

public class Main {
	
	
	static void readLang() {
		StringManager.loadLangDataFromFile("lang.dat");
		for(int i = 0; i < 1000; i++){
			String str = StringManager.getLangString(i);
			if(str.startsWith("?: "))
				break;
			System.out.println(i+" > "+str);
		}
	}

	public static void main(String[] args) {
		InputStream tilesStream = getResourceAsStream("res/1.pak");
		PakReader pak = new PakReader();
		try {
			pak.read(tilesStream);
			pak.write("res/resources/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		InputStream tilesStream = getResourceAsStream("tiles0.prop");
		InputStream stream = getResourceAsStream("s3.aem");
		MapReader reader = new MapReader();
		reader.readTilesData(tilesStream);
		try {
			reader.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return;
				/*
		try {
			Path path = Paths.get("save_1.rms");
			byte[] data = Files.readAllBytes(path);

			DataInputStream dis = new DataInputStream(
					new ByteArrayInputStream(data));
			
			System.out.println(">"+dis.readByte());
			System.out.println(">"+dis.readByte());
			byte teamsCount = dis.readByte();
			System.out.println("teamsCount > "+teamsCount);
			System.out.println("? > "+dis.readByte());
			System.out.println("//"+dis.readByte());
			System.out.println("? > "+dis.readShort());
			System.out.println("? > "+dis.readByte());
			System.out.println("? > "+dis.readByte());
			System.out.println("for::");
			for (int i = 0; i < teamsCount; i++) {
				System.out.println(i+"::");
				System.out.println("? > "+dis.readByte());
				System.out.println("? > "+dis.readByte());
				System.out.println("? > "+dis.readInt());
				System.out.println("? > "+dis.readByte());
				System.out.println("? > "+dis.readByte());
			}
			System.out.println("end::");
			System.out.println("? > "+dis.readShort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		
		this.teamsCountMaybe = dis.readByte();
		for (int i = 0; i < this.teamsCountMaybe; i++) {
			this.var_483a[i] = dis.readByte();
			this.var_487a[i] = dis.readByte();
			this.var_486a[i] = dis.readInt();
			this.var_4872[i][0] = dis.readByte();
			this.var_4872[i][1] = dis.readByte();
		}
		this.var_45f2 = dis.readShort();
		for (int i = 0; i < this.var_49fa.length; i++) {
			this.var_4782[this.var_49fa[i][0]][this.var_49fa[i][1]] = dis
					.readByte();
		}
		this.teamsUnits = new Class_a_Unit[this.teamsCountMaybe][4];
		this.teamsUnitsCount = new int[this.teamsCountMaybe];
		sub_ac6f();
		byte dataLength = dis.readByte();
		int j = 0;
		while (j < dataLength) {
			byte unitType = dis.readByte();
			byte teamId = dis.readByte();
			byte k = dis.readByte();
			byte b3 = dis.readByte();
			byte unitHealth = dis.readByte();
			byte unitLvl = dis.readByte();
			short unitExp = dis.readShort();
			short posX = dis.readShort();
			short posY = dis.readShort();
			byte b5 = dis.readByte();
			byte b6 = dis.readByte();
			Class_a_Unit unit = Class_a_Unit.createUnit(unitType, teamId, posX, posY);
			unit.var_e83 = k;
			unit.maybeExperience = unitExp;
			unit.setUnitLevel(unitLvl);
			unit.var_e8b = b3;
			unit.sub_160c();
			unit.health = unitHealth;
			unit.var_ecb = b5;
			unit.var_ed3 = b6;
			if (unitType == 9) {
				byte kingNameId = dis.readByte();
				short kingCost = dis.readShort();
				unit.setKingName(kingNameId);
				unit.cost = kingCost;
				if (dis.readByte() == 1) {// isALive?
					this.maybeTeamKings[unit.teamId] = unit;
				}
			}
			j++;
		}
		this.var_4e12 = dis.readShort();
		this.var_4e22 = dis.readInt();
		this.var_4e2a = dis.readInt();
		this.var_4e32 = (dis.readByte() != 0);
		dis.close();
		if ((this.var_47a2 == 6) && (this.var_4e12 > 32)) {
			this.var_49c2 = sub_14359(
					Class_f_StringManager.getLangString(121 + this.var_47a2),
					Class_f_StringManager.getLangString(138), this.someCanHeight, -1);
			this.var_49c2.sub_132e((byte) 0, true);
			this.var_49c2.sub_1350(null);
		}
		sub_f182(this.var_4872[this.var_4842][0],
				this.var_4872[this.var_4842][1]);
		sub_efe5(this.var_4872[this.var_4842][0],
				this.var_4872[this.var_4842][1]);
		Class_c_MainCanvas.sub_2bf1(var_4692[this.var_4832[this.var_4842]], 0);
		*/
	}

	public static InputStream getResourceAsStream(String langFileName) {
		Path path = Paths.get(langFileName);
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	new ByteArrayInputStream(data);
	}
	

}
