import java.io.DataInputStream;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;

public final class C_Unit extends F_Sprite {
	
	public static byte unitTypesCountMb = 12;
	public static byte var_a73 = 6;
	public static byte var_a7b = var_a73;
	public static I_Game sGame;
	public String unitName;
	public short level;
	public int experience;
	public byte[][] charsData;
	public Vector var_aab;
	public short var_ab3;
	public long unitFrameStartTime;
	public byte unitTypeId;
	public byte playerId;
	public short positionX;
	public short positionY;
	public int var_ae3;
	public int var_aeb;
	public int unitAttackMin;
	public int unitAttackMax;
	public int unitDefence;
	public int unitHealthMb;
	public byte m_state;
	public byte status;
	public short movementStatusBonus;
	public short defenceStatusBonus;
	public short attackStatusBonus;
	public boolean isUnitSchaking;
	public boolean var_b43 = true;
	public int shakingMaxTime;
	public long shakingStartTime;
	public byte var_b5b;
	public byte var_b63;
	public int var_b6b;
	public C_Unit followerUnitMb;
	public byte kingIndex = 0;
	public int unitId;
	public int cost;
	public int var_b93;
	public static byte[] var_b9b = new byte[12];
	public static byte[][] var_ba3 = new byte[12][2];
	public static byte[] var_bab = new byte[12];
	public static byte[] maxUnitRanges = new byte[12];
	public static byte[] minUnitRanges = new byte[12];
	public static byte[][][] unitsChars = new byte[12][][];
	public static short[] unitsCosts = new short[12];
	public static final short[] unitsProperties = new short[12];

	private C_Unit(byte typeId, byte playerId, int posX,
			int posY, boolean showUnit) {
		super(sGame.sub_87c3(playerId, typeId));
		this.unitTypeId = typeId;
		this.m_state = 0;
		this.positionX = ((short) posX);
		this.positionY = ((short) posY);
		setSpritePosition(posX * 24, posY * 24);
		setUnitLevel((byte) 0);
		if (showUnit) {
			sGame.mapUnitsSprites.addElement(this);
		}
	}

	public final void setUnitLevel(byte lvl) {
		this.level = ((short) lvl);
		int lvlBonus = lvl * 2;
		this.unitAttackMin = (var_ba3[this.unitTypeId][0] + lvlBonus);
		this.unitAttackMax = (var_ba3[this.unitTypeId][1] + lvlBonus);
		this.unitDefence = (var_bab[this.unitTypeId] + lvlBonus);
		if (this.unitTypeId != 9) {
			int j = this.level / 2;
			if (j > 3) {
				j = 3;
			}
			this.unitName = A_MenuBase.getLangString(139 + this.unitTypeId * 4 + j);
		}
	}

	public final void shakeUnit(int val) {
		this.isUnitSchaking = true;
		this.shakingStartTime = sGame.time;
		this.shakingMaxTime = val;
	}

	public static final C_Unit createUnitOnMap(byte type, byte playerId, int pX, int pY) {
		return createUnit(type, playerId, pX, pY, true);
	}

	public static final C_Unit createUnit(byte type, byte playerId,
			int pX, int pY, boolean showUnit) {
		C_Unit unit = new C_Unit(type,
				sGame.playersIndexes[playerId], pX, pY,
				showUnit);
		unit.unitTypeId = type;
		unit.playerId = playerId;
		unit.unitHealthMb = 100;
		unit.charsData = unitsChars[type];
		unit.cost = unitsCosts[type];
		if (type == 9) {
			unit.setKingName(sGame.playersIndexes[playerId] - 1);
			unit.unitId = sGame.playerUnitsCount[playerId];
			sGame.playerKingsMb[playerId][unit.unitId] = unit;
			sGame.playerUnitsCount[playerId] += 1;
		}
		return unit;
	}

	public final void removeFromMap() {
		sGame.mapUnitsSprites.removeElement(this);
	}

	public final void setKingName(int index) {
		this.kingIndex = ((byte) index);
		this.unitName = A_MenuBase.getLangString(index + 93);
	}

	public final int getUnitExtraAttack(C_Unit unit) {
		return getUnitExtraAttack(unit, this.positionX, this.positionY);
	}

	public final int getUnitExtraAttack(C_Unit unit, int inX, int inY) {
		int extraAtt = this.defenceStatusBonus;
		if (unit != null) {
			if ((hasProperty((short) 64))
					&& (unit.hasProperty((short) 1))) { //archer & dragon
				extraAtt += 15;
			}
			if ((this.unitTypeId == 4) && (unit.unitTypeId == 10)) { //wisp & skeleton
				extraAtt += 15;
			}
		}
		if ((hasProperty((short) 2)) && (sGame.getTileType(inX, inY) == 5)) { //water
			extraAtt += 10;
		}
		if (sGame.mapTilesIds[inX][inY] == 34) { //saeth
			extraAtt += 25;
		}
		return extraAtt;
	}

	public final int getUnitResistance(C_Unit unit) {
		return getUnitResistance(unit, this.positionX, this.positionY);
	}

	public final int getUnitResistance(C_Unit unit, int inX, int inY) {
		int tType = sGame.getTileType(inX, inY);
		int resist = this.attackStatusBonus + I_Game.tilesDefences[tType];
		if ((hasProperty((short) 2)) && (tType == 5)) { //water
			resist += 15;
		}
		if (sGame.mapTilesIds[inX][inY] == 34) { //saeth citadel
			resist += 15;
		}
		return resist;
	}

	public final int getUnitAttackDamage(C_Unit oUnit) {
		int uDamage = E_MainCanvas.getRandomWithin(this.unitAttackMin, this.unitAttackMax)
				+ getUnitExtraAttack(oUnit);
		int uDefence = oUnit.unitDefence + oUnit.getUnitResistance(this);
		int damage = (uDamage - uDefence) * this.unitHealthMb / 100;
		if (damage < 0) {
			damage = 0;
		} else if (damage > oUnit.unitHealthMb) {
			damage = oUnit.unitHealthMb;
		}
		oUnit.unitHealthMb -= damage;
		this.experience += oUnit.getExpKoef() * damage;
		return damage;
	}

	public final int getExpKoef() {
		return this.unitAttackMin + this.unitAttackMax + this.unitDefence;
	}

	public final int getLevelExpMax() {
		return getExpKoef() * 100 * 2 / 3;
	}

	public final boolean gotNewLevel() {
		if (this.level < 9) {
			int exp = getLevelExpMax();
			if (this.experience >= exp) {
				this.experience -= exp;
				setUnitLevel((byte) (this.level + 1));
				return true;
			}
		}
		return false;
	}

	public final boolean isNearOtherUnit(C_Unit unit, int inX, int inY) {
		return (this.m_state != 4)
				&& (this.unitHealthMb > 0)
				&& (Math.abs(this.positionX - inX)
						+ Math.abs(this.positionY - inY) == 1)
				&& (minUnitRanges[this.unitTypeId] == 1);
	}

	public final void applyPoisonStatus(byte paramByte) {
		this.status = ((byte) (this.status | paramByte));
		calcStatusEffect();
		if (paramByte == 1) {
			this.var_b63 = sGame.playerId;
		}
	}

	public final void applyWispStatusMb(byte paramByte) {
		this.status = ((byte) (this.status & (paramByte ^ 0xFFFFFFFF)));
		calcStatusEffect();
	}

	public final void calcStatusEffect() {
		this.movementStatusBonus = 0;
		this.defenceStatusBonus = 0;
		this.attackStatusBonus = 0;
		if ((this.status & 0x1) != 0) { // poison
			this.defenceStatusBonus = ((short) (this.defenceStatusBonus - 10));
			this.attackStatusBonus = ((short) (this.attackStatusBonus - 10));
		}
		if ((this.status & 0x2) != 0) { // wisp
			this.defenceStatusBonus = ((short) (this.defenceStatusBonus + 10));
		}
	}

	public final void setUnitPosition(int pX, int pY) {
		this.positionX = ((short) pX);
		this.positionY = ((short) pY);
		this.posXPixel = ((short) (pX * 24));
		this.posYPixel = ((short) (pY * 24));
	}

	public final int getAliveCharactersCount() {
		int i = 100 / this.charsData.length;
		int j = this.unitHealthMb / i;
		if ((this.unitHealthMb != 100) && (this.unitHealthMb % i > 0)) {
			j++;
		}
		return j;
	}

	public final int getSomePropSum(int inX, int inY, C_Unit unit) {
		return (this.unitAttackMin + this.unitAttackMax + this.unitDefence
				+ getUnitExtraAttack(unit, inX, inY) + getUnitResistance(
				unit, inX, inY)) * this.unitHealthMb / 100;
	}

	public final void fillAttackRangeData(byte[][] mapdata, int inX,
			int inY) {
		int minRange = minUnitRanges[this.unitTypeId];
		int maxRange = maxUnitRanges[this.unitTypeId];
		int minX = inX - maxRange;
		if (minX < 0) {
			minX = 0;
		}
		int minY = inY - maxRange;
		if (minY < 0) {
			minY = 0;
		}
		int maxX = inX + maxRange;
		if (maxX >= sGame.mapWidth) {
			maxX = sGame.mapWidth - 1;
		}
		int maxY = inY + maxRange;
		if (maxY >= sGame.mapHeight) {
			maxY = sGame.mapHeight - 1;
		}
		for (int xx = minX; xx <= maxX; xx++) {
			for (int yy = minY; yy <= maxY; yy++) {
				int dist = Math.abs(xx - inX) + Math.abs(yy - inY);
				if ((dist >= minRange) && (dist <= maxRange) && (mapdata[xx][yy] <= 0)) {
					mapdata[xx][yy] = 127;
				}
			}
		}
	}

	public final void showWhereUnitCanAttack(byte[][] mapRangeData) {
		if (hasProperty((short) 512)) { //catapult
			fillAttackRangeData(mapRangeData, this.positionX, this.positionY);
			return;
		}
		fillWhereUnitCanMove(mapRangeData);
		for (int i = 0; i < sGame.mapWidth; i++) {
			for (int j = 0; j < sGame.mapHeight; j++) {
				if ((mapRangeData[i][j] > 0) && (mapRangeData[i][j] != 127)) {
					fillAttackRangeData(mapRangeData, i, j);
				}
			}
		}
	}

	public final C_Unit[] getActiveUnitsInAttackRange(int paramInt1, int paramInt2,
			byte paramByte) {
		return getPositionUnitsInAttackRange(paramInt1, paramInt2, minUnitRanges[this.unitTypeId],
				maxUnitRanges[this.unitTypeId], paramByte);
	}

	public final C_Unit[] getPositionUnitsInAttackRange(int inX, int inY,
			int minRange, int maxRange, byte paramByte) {
		Vector localVector = new Vector();
		int minX = inX - maxRange;
		if (minX < 0) {
			minX = 0;
		}
		int minY = inY - maxRange;
		if (minY < 0) {
			minY = 0;
		}
		int maxX  = inX + maxRange;
		if (maxX >= sGame.mapWidth) {
			maxX = sGame.mapWidth - 1;
		}
		int maxY = inY + maxRange;
		if (maxY >= sGame.mapHeight) {
			maxY = sGame.mapHeight - 1;
		}
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				int dist = Math.abs(x - inX) + Math.abs(y - inY);
				if ((dist >= minRange) && (dist <= maxRange)) {
					C_Unit aUnit;
					if (paramByte == 0) {
						if ((aUnit = sGame.getSomeUnit(x, y,
								(byte) 0)) != null) {
							if (sGame.playersTeams[aUnit.playerId] != sGame.playersTeams[this.playerId]) {
								localVector.addElement(aUnit);
							}
						} else if ((this.unitTypeId == 7)
								&& (sGame.getTileType(x, y) == 8)
								&& (sGame.mapTilesIds[x][y] >= sGame.houseTileIdStartIndex)
								&& (!sGame.isInSameTeam(x, y,
										sGame.playersTeams[this.playerId]))) {
							C_Unit unit2 = createUnit((byte) 0, (byte) 0, x,
									y, false);
							unit2.unitTypeId = -1;
							unit2.m_state = 4;
							localVector.addElement(unit2);
						}
					} else if (paramByte == 1) {
						if ((aUnit = sGame.getSomeUnit(x, y,
								(byte) 1)) != null) {
							localVector.addElement(aUnit);
						}
					} else if ((paramByte == 2)
							&& ((aUnit = sGame.getSomeUnit(x, y,
									(byte) 0)) != null)
							&& (sGame.playersTeams[aUnit.playerId] == sGame.playersTeams[this.playerId])) {
						localVector.addElement(aUnit);
					}
				}
			}
		}
		C_Unit[] units = new C_Unit[localVector.size()];
		localVector.copyInto(units);
		return units;
	}

	public final void goToPosition(int inX, int inY,
			boolean paramBoolean) {
		goToPosition(inX, inY, paramBoolean, false);
	}

	public final void goToPosition(int inX, int inY,
			boolean paramBoolean1, boolean paramBoolean2) {
		if (paramBoolean1) {
			this.var_aab = sub_1b48(this.positionX, this.positionY, inX,
					inY);
		} else {
			int k;
			if ((paramBoolean2)
					&& (sGame.getSomeUnit(inX, inY, (byte) 0) != null)) {
				int i = 0;
				for (int j = inX - 1; j <= inX + 1; j++) {
					for (k = inY - 1; k <= inY + 1; k++) {
						if (((j == inX) && (k == inY))
								|| (((j == inX) || (k == inY)) && (sGame
										.getSomeUnit(j, k, (byte) 0) == null))) {
							inX = j;
							inY = k;
							i = 1;
							break;
						}
					}
					if (i != 0) {
						break;
					}
				}
			}
			this.var_aab = new Vector();
			short[] arrayOfShort1 = { this.positionX, this.positionY };
			this.var_aab.addElement(arrayOfShort1);
			short j = this.positionX;
			int n;
			if ((k = Math.abs(inX - this.positionX)) > 0) {
				int m = (inX - this.positionX) / k;
				for (n = 0; n < k; n++) {
					j = (short) (j + m);
					short[] arrayOfShort2 = { j, this.positionY };
					this.var_aab.addElement(arrayOfShort2);
				}
			}
			short m = this.positionY;
			if ((k = Math.abs(inY - this.positionY)) > 0) {
				n = (inY - this.positionY) / k;
				for (int i1 = 0; i1 < k; i1++) {
					m = (short) (m + n);
					short[] arrayOfShort3 = { j, m };
					this.var_aab.addElement(arrayOfShort3);
				}
			}
		}
		this.var_ae3 = inX;
		this.var_aeb = inY;
		this.var_ab3 = 1;
		this.m_state = 1; // running mb
	}

	public final Vector sub_1b48(int paramInt1, int paramInt2, int inX,
			int inY) {
		Vector localVector = null;
		short[] somePos = { (short) inX, (short) inY };
		if ((paramInt1 == inX) && (paramInt2 == inY)) {
			(localVector = new Vector()).addElement(somePos);
			return localVector;
		}
		int j = 0;
		int k = 0;
		int m = 0;
		int n = 0;
		if (inY > 0) {
			j = sGame.someMapData[inX][(inY - 1)];
		}
		if (inY < sGame.mapHeight - 1) {
			k = sGame.someMapData[inX][(inY + 1)];
		}
		if (inX > 0) {
			m = sGame.someMapData[(inX - 1)][inY];
		}
		if (inX < sGame.mapWidth - 1) {
			n = sGame.someMapData[(inX + 1)][inY];
		}
		int i;
		if ((i = Math.max(Math.max(j, k), Math.max(m, n))) == j) {
			localVector = sub_1b48(paramInt1, paramInt2, inX,
					inY - 1);
		} else if (i == k) {
			localVector = sub_1b48(paramInt1, paramInt2, inX,
					inY + 1);
		} else if (i == m) {
			localVector = sub_1b48(paramInt1, paramInt2, inX - 1,
					inY);
		} else if (i == n) {
			localVector = sub_1b48(paramInt1, paramInt2, inX + 1,
					inY);
		}
		localVector.addElement(somePos);
		return localVector;
	}

	public final void fillWhereUnitCanMove(byte[][] paramArrayOfByte) {
		sub_1d7b(paramArrayOfByte, this.positionX, this.positionY,
				var_b9b[this.unitTypeId] + this.movementStatusBonus, -1, this.unitTypeId,
				this.playerId, false);
	}

	public static final boolean sub_1d7b(byte[][] mdata,
			int inX, int inY, int sTileType, int paramInt4,
			byte paramByte1, byte paramByte2, boolean paramBoolean) {
		if (sTileType > mdata[inX][inY]) {
			mdata[inX][inY] = ((byte) sTileType);
			if ((paramBoolean)
					&& (sGame.getSomeUnit(inX, inY, (byte) 0) == null)) {
				return true;
			}
		} else {
			return false;
		}
		int i;
		if ((paramInt4 != 1)
				&& ((i = sTileType
						- getCellMoveValue(inX, inY - 1, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(mdata, inX, inY - 1, i, 2,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean)) {
			return true;
		}
		if ((paramInt4 != 2)
				&& ((i = sTileType
						- getCellMoveValue(inX, inY + 1, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(mdata, inX, inY + 1, i, 1,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean)) {
			return true;
		}
		if ((paramInt4 != 4)
				&& ((i = sTileType
						- getCellMoveValue(inX - 1, inY, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(mdata, inX - 1, inY, i, 8,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean)) {
			return true;
		}
		return (paramInt4 != 8)
				&& ((i = sTileType
						- getCellMoveValue(inX + 1, inY, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(mdata, inX + 1, inY, i, 4,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean);
	}

	public static final int getCellMoveValue(int inX, int inY, byte inUnitType, byte inUnitTeam) {
		if ((inX >= 0) && (inY >= 0) && (inX < sGame.mapWidth) && (inY < sGame.mapHeight)) {
			C_Unit unitOnPos = sGame.getSomeUnit(inX, inY, (byte) 0);
			if ((unitOnPos != null)
					&& (sGame.playersTeams[unitOnPos.playerId] != sGame.playersTeams[inUnitTeam])) {
				return 1000;
			}
			int tyleType = sGame.getTileType(inX, inY);
			if (inUnitType == 11) { //crystal
				if (tyleType == 4) { //mountain
					return 1000;
				}
			} else {
				if (hasUnitProperty(inUnitType, (short) 1)) { //fly
					return 1;
				}
				if ((hasUnitProperty(inUnitType, (short) 2)) && (tyleType == 5)) { //water
					return 1;
				}
			}
			return I_Game.tilesMovements[tyleType];
		}
		return 10000;
	}
	
	public final void spriteUpdate(){
		super.spriteUpdate();
		//@todo
	}

	//@todo mb override
	public final void unitUpdate() {
		if (this.isUnitSchaking) {
			if (sGame.time - this.shakingStartTime >= this.shakingMaxTime) {
				this.isUnitSchaking = false;
			} else {
				this.var_b43 = (!this.var_b43);
			}
		}
		if (this.m_state == 1) {
			if (this.var_ab3 >= this.var_aab.size()) {
				this.m_state = 0;
				this.positionX = ((short) (this.posXPixel / 24));
				this.positionY = ((short) (this.posYPixel / 24));
				this.var_aab = null;
				this.var_ab3 = 0;
			} else {
				if ((this.followerUnitMb != null) && (this.posXPixel % 24 == 0)
						&& (this.posYPixel % 24 == 0)) {
					this.followerUnitMb.goToPosition(this.positionX, this.positionY, false);
				}
				short[] arrayOfShort;
				int i = (arrayOfShort = (short[]) this.var_aab
						.elementAt(this.var_ab3))[0] * 24;
				int j = arrayOfShort[1] * 24;
				F_Sprite somSprite = null;
				if ((this.followerUnitMb == null)
						&& (++this.var_b6b >= 24 / var_a7b / 2)) {
					somSprite = sGame.showSpriteOnMap(sGame.bigSmokeSprite,
							this.posXPixel, this.posYPixel, 0, 0, 1,
							E_MainCanvas.getRandomWithin(1, 4) * 50);
					this.var_b6b = 0;
				}
				if (i < this.posXPixel) {
					this.posXPixel -= var_a7b;
					if (somSprite != null) {
						somSprite.setSpritePosition(this.posXPixel + this.frameWidth,
								this.posYPixel + this.frameHeight
										- somSprite.frameHeight);
					}
				} else if (i > this.posXPixel) {
					this.posXPixel += var_a7b;
					if (somSprite != null) {
						somSprite.setSpritePosition(this.posXPixel
								- somSprite.frameWidth, this.posYPixel
								+ this.frameHeight - somSprite.frameHeight);
					}
				} else if (j < this.posYPixel) {
					this.posYPixel -= var_a7b;
					if (somSprite != null) {
						somSprite
								.setSpritePosition(
										this.posXPixel
												+ (this.frameWidth - somSprite.frameWidth)
												/ 2, this.posYPixel
												+ this.frameHeight);
					}
				} else if (j > this.posYPixel) {
					this.posYPixel += var_a7b;
					if (somSprite != null) {
						somSprite
								.setSpritePosition(
										this.posXPixel
												+ (this.frameWidth - somSprite.frameWidth)
												/ 2, this.posYPixel
												- somSprite.frameHeight);
					}
				}
				if ((this.posXPixel == i) && (this.posYPixel == j)) {
					this.positionX = arrayOfShort[0];
					this.positionY = arrayOfShort[1];
					this.var_ab3 = ((short) (this.var_ab3 + 1));
				}
			}
			super.setSpritePosition(this.posXPixel, this.posYPixel);
			nextFrame();
			return;
		}
		if ((this.m_state == 0) && (sGame.time - this.unitFrameStartTime >= 200L)) {
			nextFrame();
			this.unitFrameStartTime = sGame.time;
		}
	}

	public static final boolean hasUnitProperty(byte uType, short prop) {
		return (unitsProperties[uType] & prop) != 0;
	}

	public final boolean hasProperty(short prop) {
		return hasUnitProperty(this.unitTypeId, prop);
	}

	public final void endMove() {
		this.m_state = 2;
		C_Unit unit1 = sGame.getSomeUnit(this.positionX, this.positionY, (byte) 1);
		if (unit1 != null) {
			unit1.removeFromMap();
		}
		if (hasProperty((short) 256)) { //wisp aura
			C_Unit[] unitsInRange = getPositionUnitsInAttackRange(this.positionX, this.positionY, 1, 2, (byte) 2);
			for (int i = 0; i < unitsInRange.length; i++) {
				unitsInRange[i].applyPoisonStatus((byte) 2);
				sGame.showSpriteOnMap(sGame.sparkSprite,
						unitsInRange[i].posXPixel,
						unitsInRange[i].posYPixel, 0, 0, 1, 50);
			}
		}
		sGame.unitEndTurnMb = this;
	}

	public static final C_Unit[] getSomUnitsList(byte paramByte) {
		C_Unit[] units = new C_Unit[sGame.playerUnitsCount[paramByte]];
		int i = 0;
		for (int j = 0; j < units.length; j++) {
			if ((sGame.playerKingsMb[sGame.playerId][j] != null)
					&& (sGame.playerKingsMb[sGame.playerId][j].m_state == 3)) {
				units[(i++)] = sGame.playerKingsMb[sGame.playerId][j];
			}
		}
		C_Unit[] units2 = new C_Unit[sGame.var_3703 + 1 + i];
		for (int k = 0; k < units2.length; k = (byte) (k + 1)) {
			if (k < i) {
				units2[k] = units[k];
			} else {
				units2[k] = createUnit((byte) (k - i), paramByte, 0, 0, false);
			}
		}
		return units2;
	}

	//@todo candidate
	public final void sub_252e(Graphics gr, int paramInt1, int paramInt2) {
		sub_2551(gr, paramInt1, paramInt2, false);
	}

	public final void sub_2551(Graphics gr, int paramInt1,
			int paramInt2, boolean paramBoolean) {
		if (this.m_state != 4) {
			int i;
			int j;
			if (this.isUnitSchaking) {
				if (this.var_b43) {
					i = -2;
				} else {
					i = 2;
				}
				j = E_MainCanvas.getRandom() % 1;
				super.onSpritePaint(gr, paramInt1 + i, paramInt2 + j);
			} else if ((paramBoolean) || (this.m_state == 2)) {
				sGame.playersUnitsSprites[0][this.unitTypeId].onSpritePaint(gr,
						this.posXPixel + paramInt1, this.posYPixel + paramInt2);
			} else {
				super.onSpritePaint(gr, paramInt1, paramInt2);
			}
			if (this.unitTypeId == 9) {
				i = this.posXPixel + paramInt1;
				j = this.posYPixel + paramInt2;
				if ((paramBoolean) || (this.m_state == 2)) {
					sGame.kingHeadsSprites[1].drawFrameAt(gr, this.kingIndex
							* 2 + this.currentFrameIndex, i, j, 0);
					return;
				}
				sGame.kingHeadsSprites[0].drawFrameAt(gr, this.kingIndex * 2
						+ this.currentFrameIndex, i, j, 0);
			}
		}
	}

	public final void drawUnitHealth(Graphics paramGraphics, int shiftX, int shiftY) {
		int hX = this.posXPixel + shiftX;
		int hY = this.posYPixel + shiftY;
		if ((this.m_state != 3) && (this.unitHealthMb < 100)) {
			E_MainCanvas.drawCharedString(paramGraphics, "" + this.unitHealthMb, hX, hY
					+ this.frameHeight - 7, 0);
		}
	}

	public static final void loadUnitsProps(I_Game aGame) throws Exception {
		sGame = aGame;
		DataInputStream localDataInputStream = new DataInputStream(
				E_MainCanvas.getResourceStream("units.bin"));
		for (int i = 0; i < 12; i++) {
			var_b9b[i] = localDataInputStream.readByte();
			var_ba3[i][0] = localDataInputStream.readByte();
			var_ba3[i][1] = localDataInputStream.readByte();
			var_bab[i] = localDataInputStream.readByte();
			maxUnitRanges[i] = localDataInputStream.readByte();
			minUnitRanges[i] = localDataInputStream.readByte();
			unitsCosts[i] = localDataInputStream.readShort();
			int j = localDataInputStream.readByte();
			unitsChars[i] = new byte[j][2];
			for (int k = 0; k < j; k++) {
				unitsChars[i][k][0] = localDataInputStream.readByte();
				unitsChars[i][k][1] = localDataInputStream.readByte();
			}
			int k = localDataInputStream.readByte();
			for (int m = 0; m < k; m++) {
				int tmp171_170 = i;
				short[] tmp171_167 = unitsProperties;
				tmp171_167[tmp171_170] = ((short) (tmp171_167[tmp171_170] | 1 << localDataInputStream
						.readByte()));
			}
		}
		localDataInputStream.close();
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_c_032
 * 
 * JD-Core Version: 0.7.0.1
 */