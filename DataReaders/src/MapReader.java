
public class MapReader {

	private int mapWidth;
	private int mapHeight;
	private byte[][] var_47da;
	private byte[][] var_4d92;
	private int mapCastlesCount;
	private int scenarioModeIf0;
	private int teamsCountMaybe;
	private int[] var_482a;
	private byte[] var_4832;
	private int[] var_4d82;
	private byte[][] buildingsData;
	private byte[][] mapCastlesPositions;
	private int mapWidthPixel;
	private int mapHeightPixel;
	private int[] var_486a;
	private int[] var_483a;
	private int[] someTeamValuesArr;
	private int var_45f2;
	private int var_45ea;
	private A_Unit[] playersKings;
	private A_Unit[][] teamsUnits;
	private int[] teamsUnitsCount;
	private byte[][] mapTilesIds;
	//
	private byte[] tilesDefs;
	private byte[] tilesTypes;
	private byte[] tilesExtraDefence;
	
	public MapReader(){
		//* INIT *//
		this.var_486a = new int[2];
		this.var_482a = new int[5];
		this.var_4832 = new byte[2];
		this.var_483a = new int[2];
		this.someTeamValuesArr = new int[2];
		//* INIT end *//
	}

	private static boolean isVillageOrTownEvenDestroyed(byte paramByte) {
		return ((paramByte >= 37) && (paramByte < 47)) || (paramByte == 27);
	}

	private int sub_11bae(int paramInt1, int paramInt2) {
		return sub_11bd2(paramInt1, paramInt2, this.mapTilesIds);
	}

	private static int sub_11bd2(int inX, int inY, byte[][] paramArrayOfByte) {
		int val = paramArrayOfByte[inX][inY] - 37 >> 1;
		if ((val >= 0) && (val <= 4)) {
			return val;
		}
		return -1;
	}

	public final byte getMapTileType(int paramInt1, int paramInt2) {
		return this.tilesDefs[this.mapTilesIds[paramInt1][paramInt2]];
	}

	private int sub_11c17(int paramInt) {
		if ((paramInt != -1) && (paramInt != 0)) {
			return this.var_482a[paramInt];
		}
		return -1;
	}

	private void setMapTileId(byte id, int inX, int inY) {
		this.mapTilesIds[inX][inY] = id;
	}

	private void changeTileToOccupiedByTeam(int inX, int inY, int teamIndex) {
		byte tileId = this.mapTilesIds[inX][inY];
		if (tileCanBeOccupied(tileId)) {
			setMapTileId((byte) (37 + (teamIndex << 1) + (tileId - 37) % 2), inX, inY);
		}
	}

	public static boolean tileCanBeOccupied(byte inByte) {
		return (inByte >= 37) && (inByte < 47);
	}

	public void read(InputStream stream) throws IOException {
		DataInputStream mapDis = new DataInputStream(stream);
		
		this.mapWidth = mapDis.readInt();
		this.mapHeight = mapDis.readInt();
		this.mapTilesIds = new byte[this.mapWidth][this.mapHeight];
		this.var_47da = new byte[this.mapWidth][this.mapHeight];
		this.var_4d92 = new byte[this.mapWidth][this.mapHeight];
		this.mapCastlesCount = 0;
		int countOccupiable = 0;
		Vector localVector1 = new Vector();
		Vector localVector2 = new Vector();
		for (int n = 0; n < this.mapWidth; n = (short) (n + 1)) {
			for (int i1 = 0; i1 < this.mapHeight; i1 = (short) (i1 + 1)) {
				this.mapTilesIds[n][i1] = mapDis.readByte();
				this.var_47da[n][i1] = 0;
				if (isVillageOrTownEvenDestroyed(this.mapTilesIds[n][i1])) {
					int k = sub_11bae(n, i1);
					byte[] arrayOfByte2;
					(arrayOfByte2 = new byte[3])[0] = ((byte) n);
					arrayOfByte2[1] = ((byte) i1);
					arrayOfByte2[2] = ((byte) k);
					localVector1.addElement(arrayOfByte2);
					countOccupiable++;
					if (getMapTileType(n, i1) == 9) {
						if ((this.scenarioModeIf0 == 1) && (k != 0) && (this.var_482a[k] == -1)) {
							this.var_4832[this.teamsCountMaybe] = ((byte) k);
							this.var_482a[k] = (this.teamsCountMaybe++);
						}
						byte[] arrayOfByte1;
						(arrayOfByte1 = new byte[2])[0] = ((byte) n);
						arrayOfByte1[1] = ((byte) i1);
						localVector2.addElement(arrayOfByte1);
						this.mapCastlesCount += 1;
					}
				}
			}
		}
		this.var_4d82 = new int[countOccupiable];
		this.buildingsData = new byte[countOccupiable][];
		localVector1.copyInto(this.buildingsData);
		this.mapCastlesPositions = new byte[this.mapCastlesCount][];
		localVector2.copyInto(this.mapCastlesPositions);
		this.mapWidthPixel = (this.mapWidth * 24);
		this.mapHeightPixel = (this.mapHeight * 24);
		if (this.scenarioModeIf0 == 1) { // skirmish
			for (int n = 0; n < this.teamsCountMaybe; n = (short) (n + 1)) {
				this.var_486a[n] = this.var_45ea;
			}
		}
		this.teamsCountMaybe = 2;

	
		
		this.var_486a[0] = 0;
		this.var_486a[1] = 0;
		this.var_482a[1] = 0;
		this.var_482a[2] = 1;
		this.var_4832[0] = 1;
		this.var_4832[1] = 2;
		this.var_483a[0] = 0;
		this.var_483a[1] = 1;
		this.someTeamValuesArr[0] = 1;
		this.someTeamValuesArr[1] = 0;
		this.var_45f2 = 100;
		int i2;
		for (int n = 0; n < this.buildingsData.length; n = (short) (n + 1)) {
			byte i1 = this.buildingsData[n][2];
			i2 = sub_11c17(i1);
			if ((i1 > 0) && ((i2 < 0) || (this.someTeamValuesArr[i2] == 2))) {
				int pX = this.buildingsData[n][0];
				int pY = this.buildingsData[n][1];
				changeTileToOccupiedByTeam(pX, pY, 0);
			}
		}
		int m = mapDis.readInt();
		mapDis.skip(m << 2);
		int unitsCount = ((DataInputStream) mapDis).readInt();
		this.playersKings = new A_Unit[this.teamsCountMaybe];
		this.teamsUnits = new A_Unit[this.teamsCountMaybe][4];
		this.teamsUnitsCount = new int[this.teamsCountMaybe];
		for (int n = 0; n < unitsCount; n = (short) (n + 1)) {
			int someVal1 = mapDis.readByte();
			int uPosX = mapDis.readShort() / 24;
			int uPosY = mapDis.readShort() / 24;
			byte uType = (byte) (someVal1 % 12);
			byte uTeam = (byte) sub_11c17(1 + someVal1 / 12);
			if (this.someTeamValuesArr[uTeam] != 2) {
				A_Unit unit1 = A_Unit.createUnit(uType, uTeam, uPosX, uPosY);
				if (uType == 9) {
					this.playersKings[uTeam] = unit1;
				}
			}
		}
		mapDis.close();
	}

	public void readTilesData(InputStream tilesStream) {
		String tilesPropString = C_MainCanvas
				.streamToString((InputStream) tilesStream);
		String[] lines = tilesPropString.split(";"); 
		try {
			String propLine = null;
			int i = 0;
			while(i<lines.length) {
				propLine = lines[i++].trim();;
				if (propLine.length() != 0) {
					String[] lineStrs = C_MainCanvas
							.splitStringByChar(propLine, ' ');
					if (lineStrs[0].equalsIgnoreCase("TypeCount")) {
						int typesCount = Integer.parseInt(lineStrs[1]);
						tilesTypes = new byte[typesCount];
						tilesExtraDefence = new byte[typesCount];
					} else if (lineStrs[0].equalsIgnoreCase("TypeDef")) {
						int val = Integer.parseInt(lineStrs[1]);
						tilesTypes[val] = ((byte) Integer.parseInt(lineStrs[2]));
						tilesExtraDefence[val] = ((byte) Integer
								.parseInt(lineStrs[3]));
					} else if (lineStrs[0].equalsIgnoreCase("TileCount")) {
						int tilesCount = Integer.parseInt(lineStrs[1]);
						this.tilesDefs = new byte[tilesCount];
					} else if (lineStrs[0].equalsIgnoreCase("TileDef")) {
						this.tilesDefs[Integer.parseInt(lineStrs[1])] = ((byte) Integer
								.parseInt(lineStrs[2]));
					}
				}
			} 

			tilesStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
