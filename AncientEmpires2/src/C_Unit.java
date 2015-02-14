import java.io.DataInputStream;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;

public final class C_Unit extends F_Sprite {
	
	public static byte unitTypesCountMb = 12;
	public static byte var_a73 = 6;
	public static byte var_a7b = var_a73;
	public static I_Game sGame;
	public String var_a8b;
	public short level;
	public int experience;
	public byte[][] var_aa3;
	public Vector var_aab;
	public short var_ab3;
	public long var_abb;
	public byte unitTypeId;
	public byte var_acb;
	public short positionX;
	public short positionY;
	public int var_ae3;
	public int var_aeb;
	public int var_af3;
	public int var_afb;
	public int var_b03;
	public int var_b0b;
	public byte var_b13;
	public byte var_b1b;
	public short var_b23;
	public short var_b2b;
	public short var_b33;
	public boolean var_b3b;
	public boolean var_b43 = true;
	public int var_b4b;
	public long someUnitTime;
	public byte var_b5b;
	public byte var_b63;
	public int var_b6b;
	public C_Unit var_b73;
	public byte var_b7b = 0;
	public int var_b83;
	public int var_b8b;
	public int var_b93;
	public static byte[] var_b9b = new byte[12];
	public static byte[][] var_ba3 = new byte[12][2];
	public static byte[] var_bab = new byte[12];
	public static byte[] var_bb3 = new byte[12];
	public static byte[] var_bbb = new byte[12];
	public static byte[][][] var_bc3 = new byte[12][][];
	public static short[] var_bcb = new short[12];
	public static final short[] var_bd3 = new short[12];

	private C_Unit(byte typeId, byte playerId, int posX,
			int posY, boolean showUnit) {
		super(sGame.sub_87c3(playerId, typeId));
		this.unitTypeId = typeId;
		this.var_b13 = 0;
		this.positionX = ((short) posX);
		this.positionY = ((short) posY);
		setSpritePosition(posX * 24, posY * 24);
		sub_c72((byte) 0);
		if (showUnit) {
			sGame.mapSprites.addElement(this);
		}
	}

	public final void sub_c72(byte paramByte) {
		this.level = ((short) paramByte);
		int i = paramByte * 2;
		this.var_af3 = (var_ba3[this.unitTypeId][0] + i);
		this.var_afb = (var_ba3[this.unitTypeId][1] + i);
		this.var_b03 = (var_bab[this.unitTypeId] + i);
		if (this.unitTypeId != 9) {
			int j;
			if ((j = this.level / 2) > 3) {
				j = 3;
			}
			this.var_a8b = A_MenuBase.getLangString(139 + this.unitTypeId * 4 + j);
		}
	}

	public final void sub_d0e(int paramInt) {
		this.var_b3b = true;
		this.someUnitTime = sGame.time;
		this.var_b4b = paramInt;
	}

	public static final C_Unit sub_d3d(byte paramByte1, byte paramByte2,
			int paramInt1, int paramInt2) {
		return sub_d60(paramByte1, paramByte2, paramInt1, paramInt2, true);
	}

	public static final C_Unit sub_d60(byte paramByte1, byte paramByte2,
			int paramInt1, int paramInt2, boolean paramBoolean) {
		C_Unit unit = new C_Unit(paramByte1,
				sGame.var_356b[paramByte2], paramInt1, paramInt2,
				paramBoolean);
		unit.unitTypeId = paramByte1;
		unit.var_acb = paramByte2;
		unit.var_b0b = 100;
		unit.var_aa3 = var_bc3[paramByte1];
		unit.var_b8b = var_bcb[paramByte1];
		if (paramByte1 == 9) {
			unit.sub_e33(sGame.var_356b[paramByte2] - 1);
			unit.var_b83 = sGame.var_359b[paramByte2];
			sGame.var_3593[paramByte2][unit.var_b83] = unit;
			sGame.var_359b[paramByte2] += 1;
		}
		return unit;
	}

	public final void removeFromMap() {
		sGame.mapSprites.removeElement(this);
	}

	public final void sub_e33(int paramInt) {
		this.var_b7b = ((byte) paramInt);
		this.var_a8b = A_MenuBase.getLangString(paramInt + 93);
	}

	public final int sub_e5f(C_Unit unit) {
		return sub_e87(unit, this.positionX, this.positionY);
	}

	public final int sub_e87(C_Unit unit, int paramInt1,
			int paramInt2) {
		int i = this.var_b2b;
		if (unit != null) {
			if ((sub_232f((short) 64))
					&& (unit.sub_232f((short) 1))) {
				i += 15;
			}
			if ((this.unitTypeId == 4) && (unit.unitTypeId == 10)) {
				i += 15;
			}
		}
		if ((sub_232f((short) 2))
				&& (sGame.sub_dd5d(paramInt1, paramInt2) == 5)) {
			i += 10;
		}
		if (sGame.var_34bb[paramInt1][paramInt2] == 34) {
			i += 25;
		}
		return i;
	}

	public final int sub_f43(C_Unit unit) {
		return sub_f6b(unit, this.positionX, this.positionY);
	}

	public final int sub_f6b(C_Unit unit, int paramInt1,
			int paramInt2) {
		int i = sGame.sub_dd5d(paramInt1, paramInt2);
		int j = this.var_b33 + I_Game.var_33e3[i];
		if ((sub_232f((short) 2)) && (i == 5)) {
			j += 15;
		}
		if (sGame.var_34bb[paramInt1][paramInt2] == 34) {
			j += 15;
		}
		return j;
	}

	public final int sub_fea(C_Unit paramClass_c_032) {
		int i = E_MainCanvas.sub_1564(this.var_af3, this.var_afb)
				+ sub_e5f(paramClass_c_032);
		int j = paramClass_c_032.var_b03 + paramClass_c_032.sub_f43(this);
		int k;
		if ((k = (i - j) * this.var_b0b / 100) < 0) {
			k = 0;
		} else if (k > paramClass_c_032.var_b0b) {
			k = paramClass_c_032.var_b0b;
		}
		paramClass_c_032.var_b0b -= k;
		this.experience += paramClass_c_032.sub_108b() * k;
		return k;
	}

	public final int sub_108b() {
		return this.var_af3 + this.var_afb + this.var_b03;
	}

	public final int getLevelExpMax() {
		return sub_108b() * 100 * 2 / 3;
	}

	public final boolean gotNewLevel() {
		if (this.level < 9) {
			int exp = getLevelExpMax();
			if (this.experience >= exp) {
				this.experience -= exp;
				sub_c72((byte) (this.level + 1));
				return true;
			}
		}
		return false;
	}

	public final boolean sub_1134(C_Unit unit, int paramInt1,
			int paramInt2) {
		return (this.var_b13 != 4)
				&& (this.var_b0b > 0)
				&& (Math.abs(this.positionX - paramInt1)
						+ Math.abs(this.positionY - paramInt2) == 1)
				&& (var_bbb[this.unitTypeId] == 1);
	}

	public final void sub_119a(byte paramByte) {
		this.var_b1b = ((byte) (this.var_b1b | paramByte));
		sub_1211();
		if (paramByte == 1) {
			this.var_b63 = sGame.var_357b;
		}
	}

	public final void sub_11e5(byte paramByte) {
		this.var_b1b = ((byte) (this.var_b1b & (paramByte ^ 0xFFFFFFFF)));
		sub_1211();
	}

	public final void sub_1211() {
		this.var_b23 = 0;
		this.var_b2b = 0;
		this.var_b33 = 0;
		if ((this.var_b1b & 0x1) != 0) {
			this.var_b2b = ((short) (this.var_b2b - 10));
			this.var_b33 = ((short) (this.var_b33 - 10));
		}
		if ((this.var_b1b & 0x2) != 0) {
			this.var_b2b = ((short) (this.var_b2b + 10));
		}
	}

	public final void sub_128b(int paramInt1, int paramInt2) {
		this.positionX = ((short) paramInt1);
		this.positionY = ((short) paramInt2);
		this.posX = ((short) (paramInt1 * 24));
		this.posY = ((short) (paramInt2 * 24));
	}

	public final int sub_12c4() {
		int i = 100 / this.var_aa3.length;
		int j = this.var_b0b / i;
		if ((this.var_b0b != 100) && (this.var_b0b % i > 0)) {
			j++;
		}
		return j;
	}

	public final int sub_1318(int paramInt1, int paramInt2,
			C_Unit paramClass_c_032) {
		return (this.var_af3 + this.var_afb + this.var_b03
				+ sub_e87(paramClass_c_032, paramInt1, paramInt2) + sub_f6b(
				paramClass_c_032, paramInt1, paramInt2)) * this.var_b0b / 100;
	}

	public final void sub_1359(byte[][] paramArrayOfByte, int paramInt1,
			int paramInt2) {
		int i = var_bbb[this.unitTypeId];
		int j = var_bb3[this.unitTypeId];
		int k;
		if ((k = paramInt1 - j) < 0) {
			k = 0;
		}
		int m;
		if ((m = paramInt2 - j) < 0) {
			m = 0;
		}
		int n;
		if ((n = paramInt1 + j) >= sGame.var_342b) {
			n = sGame.var_342b - 1;
		}
		int i1;
		if ((i1 = paramInt2 + j) >= sGame.var_3433) {
			i1 = sGame.var_3433 - 1;
		}
		for (int i2 = k; i2 <= n; i2++) {
			for (int i3 = m; i3 <= i1; i3++) {
				int i4;
				if (((i4 = Math.abs(i2 - paramInt1) + Math.abs(i3 - paramInt2)) >= i)
						&& (i4 <= j) && (paramArrayOfByte[i2][i3] <= 0)) {
					paramArrayOfByte[i2][i3] = 127;
				}
			}
		}
	}

	public final void sub_14e8(byte[][] paramArrayOfByte) {
		if (sub_232f((short) 512)) {
			sub_1359(paramArrayOfByte, this.positionX, this.positionY);
			return;
		}
		sub_1d3c(paramArrayOfByte);
		for (int i = 0; i < sGame.var_342b; i++) {
			for (int j = 0; j < sGame.var_3433; j++) {
				if ((paramArrayOfByte[i][j] > 0)
						&& (paramArrayOfByte[i][j] != 127)) {
					sub_1359(paramArrayOfByte, i, j);
				}
			}
		}
	}

	public final C_Unit[] sub_15b5(int paramInt1, int paramInt2,
			byte paramByte) {
		return sub_15e7(paramInt1, paramInt2, var_bbb[this.unitTypeId],
				var_bb3[this.unitTypeId], paramByte);
	}

	public final C_Unit[] sub_15e7(int paramInt1, int paramInt2,
			int paramInt3, int paramInt4, byte paramByte) {
		Vector localVector = new Vector();
		int i;
		if ((i = paramInt1 - paramInt4) < 0) {
			i = 0;
		}
		int j;
		if ((j = paramInt2 - paramInt4) < 0) {
			j = 0;
		}
		int k;
		if ((k = paramInt1 + paramInt4) >= sGame.var_342b) {
			k = sGame.var_342b - 1;
		}
		int m;
		if ((m = paramInt2 + paramInt4) >= sGame.var_3433) {
			m = sGame.var_3433 - 1;
		}
		for (int n = i; n <= k; n++) {
			for (int i1 = j; i1 <= m; i1++) {
				int i2 = Math.abs(n - paramInt1) + Math.abs(i1 - paramInt2);
				if ((i2 >= paramInt3)
						&& (i2 <= paramInt4)) {
					C_Unit aUnit;
					if (paramByte == 0) {
						if ((aUnit = sGame.sub_dc52(n, i1,
								(byte) 0)) != null) {
							if (sGame.var_3573[aUnit.var_acb] != sGame.var_3573[this.var_acb]) {
								localVector.addElement(aUnit);
							}
						} else if ((this.unitTypeId == 7)
								&& (sGame.sub_dd5d(n, i1) == 8)
								&& (sGame.var_34bb[n][i1] >= sGame.tilesCount)
								&& (!sGame.sub_e2b4(n, i1,
										sGame.var_3573[this.var_acb]))) {
							C_Unit localClass_c_0322;
							(localClass_c_0322 = sub_d60((byte) 0, (byte) 0, n,
									i1, false)).unitTypeId = -1;
							localClass_c_0322.var_b13 = 4;
							localVector.addElement(localClass_c_0322);
						}
					} else if (paramByte == 1) {
						if ((aUnit = sGame.sub_dc52(n, i1,
								(byte) 1)) != null) {
							localVector.addElement(aUnit);
						}
					} else if ((paramByte == 2)
							&& ((aUnit = sGame.sub_dc52(n, i1,
									(byte) 0)) != null)
							&& (sGame.var_3573[aUnit.var_acb] == sGame.var_3573[this.var_acb])) {
						localVector.addElement(aUnit);
					}
				}
			}
		}
		C_Unit[] arrayOfClass_c_032 = new C_Unit[localVector.size()];
		localVector.copyInto(arrayOfClass_c_032);
		return arrayOfClass_c_032;
	}

	public final void sub_18b7(int paramInt1, int paramInt2,
			boolean paramBoolean) {
		sub_18da(paramInt1, paramInt2, paramBoolean, false);
	}

	public final void sub_18da(int paramInt1, int paramInt2,
			boolean paramBoolean1, boolean paramBoolean2) {
		if (paramBoolean1) {
			this.var_aab = sub_1b48(this.positionX, this.positionY, paramInt1,
					paramInt2);
		} else {
			int k;
			if ((paramBoolean2)
					&& (sGame.sub_dc52(paramInt1, paramInt2, (byte) 0) != null)) {
				int i = 0;
				for (int j = paramInt1 - 1; j <= paramInt1 + 1; j++) {
					for (k = paramInt2 - 1; k <= paramInt2 + 1; k++) {
						if (((j == paramInt1) && (k == paramInt2))
								|| (((j == paramInt1) || (k == paramInt2)) && (sGame
										.sub_dc52(j, k, (byte) 0) == null))) {
							paramInt1 = j;
							paramInt2 = k;
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
			if ((k = Math.abs(paramInt1 - this.positionX)) > 0) {
				int m = (paramInt1 - this.positionX) / k;
				for (n = 0; n < k; n++) {
					j = (short) (j + m);
					short[] arrayOfShort2 = { j, this.positionY };
					this.var_aab.addElement(arrayOfShort2);
				}
			}
			short m = this.positionY;
			if ((k = Math.abs(paramInt2 - this.positionY)) > 0) {
				n = (paramInt2 - this.positionY) / k;
				for (int i1 = 0; i1 < k; i1++) {
					m = (short) (m + n);
					short[] arrayOfShort3 = { j, m };
					this.var_aab.addElement(arrayOfShort3);
				}
			}
		}
		this.var_ae3 = paramInt1;
		this.var_aeb = paramInt2;
		this.var_ab3 = 1;
		this.var_b13 = 1;
	}

	public final Vector sub_1b48(int paramInt1, int paramInt2, int paramInt3,
			int paramInt4) {
		Vector localVector = null;
		short[] arrayOfShort = { (short) paramInt3, (short) paramInt4 };
		if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
			(localVector = new Vector()).addElement(arrayOfShort);
			return localVector;
		}
		int j = 0;
		int k = 0;
		int m = 0;
		int n = 0;
		if (paramInt4 > 0) {
			j = sGame.var_3513[paramInt3][(paramInt4 - 1)];
		}
		if (paramInt4 < sGame.var_3433 - 1) {
			k = sGame.var_3513[paramInt3][(paramInt4 + 1)];
		}
		if (paramInt3 > 0) {
			m = sGame.var_3513[(paramInt3 - 1)][paramInt4];
		}
		if (paramInt3 < sGame.var_342b - 1) {
			n = sGame.var_3513[(paramInt3 + 1)][paramInt4];
		}
		int i;
		if ((i = Math.max(Math.max(j, k), Math.max(m, n))) == j) {
			localVector = sub_1b48(paramInt1, paramInt2, paramInt3,
					paramInt4 - 1);
		} else if (i == k) {
			localVector = sub_1b48(paramInt1, paramInt2, paramInt3,
					paramInt4 + 1);
		} else if (i == m) {
			localVector = sub_1b48(paramInt1, paramInt2, paramInt3 - 1,
					paramInt4);
		} else if (i == n) {
			localVector = sub_1b48(paramInt1, paramInt2, paramInt3 + 1,
					paramInt4);
		}
		localVector.addElement(arrayOfShort);
		return localVector;
	}

	public final void sub_1d3c(byte[][] paramArrayOfByte) {
		sub_1d7b(paramArrayOfByte, this.positionX, this.positionY,
				var_b9b[this.unitTypeId] + this.var_b23, -1, this.unitTypeId,
				this.var_acb, false);
	}

	public static final boolean sub_1d7b(byte[][] paramArrayOfByte,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			byte paramByte1, byte paramByte2, boolean paramBoolean) {
		if (paramInt3 > paramArrayOfByte[paramInt1][paramInt2]) {
			paramArrayOfByte[paramInt1][paramInt2] = ((byte) paramInt3);
			if ((paramBoolean)
					&& (sGame.sub_dc52(paramInt1, paramInt2, (byte) 0) == null)) {
				return true;
			}
		} else {
			return false;
		}
		int i;
		if ((paramInt4 != 1)
				&& ((i = paramInt3
						- sub_1ef6(paramInt1, paramInt2 - 1, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(paramArrayOfByte, paramInt1, paramInt2 - 1, i, 2,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean)) {
			return true;
		}
		if ((paramInt4 != 2)
				&& ((i = paramInt3
						- sub_1ef6(paramInt1, paramInt2 + 1, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(paramArrayOfByte, paramInt1, paramInt2 + 1, i, 1,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean)) {
			return true;
		}
		if ((paramInt4 != 4)
				&& ((i = paramInt3
						- sub_1ef6(paramInt1 - 1, paramInt2, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(paramArrayOfByte, paramInt1 - 1, paramInt2, i, 8,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean)) {
			return true;
		}
		return (paramInt4 != 8)
				&& ((i = paramInt3
						- sub_1ef6(paramInt1 + 1, paramInt2, paramByte1,
								paramByte2)) >= 0)
				&& (sub_1d7b(paramArrayOfByte, paramInt1 + 1, paramInt2, i, 4,
						paramByte1, paramByte2, paramBoolean))
				&& (paramBoolean);
	}

	public static final int sub_1ef6(int paramInt1, int paramInt2,
			byte paramByte1, byte paramByte2) {
		if ((paramInt1 >= 0) && (paramInt2 >= 0)
				&& (paramInt1 < sGame.var_342b)
				&& (paramInt2 < sGame.var_3433)) {
			C_Unit localClass_c_032;
			if (((localClass_c_032 = sGame.sub_dc52(paramInt1, paramInt2,
					(byte) 0)) != null)
					&& (sGame.var_3573[localClass_c_032.var_acb] != sGame.var_3573[paramByte2])) {
				return 1000;
			}
			int i = sGame.sub_dd5d(paramInt1, paramInt2);
			if (paramByte1 == 11) {
				if (i == 4) {
					return 1000;
				}
			} else {
				if (sub_22f7(paramByte1, (short) 1)) {
					return 1;
				}
				if ((sub_22f7(paramByte1, (short) 2)) && (i == 5)) {
					return 1;
				}
			}
			return I_Game.var_33eb[i];
		}
		return 10000;
	}

	//@todo mb override
	public final void unitUpdate() {
		if (this.var_b3b) {
			if (sGame.time - this.someUnitTime >= this.var_b4b) {
				this.var_b3b = false;
			} else {
				this.var_b43 = (!this.var_b43);
			}
		}
		if (this.var_b13 == 1) {
			if (this.var_ab3 >= this.var_aab.size()) {
				this.var_b13 = 0;
				this.positionX = ((short) (this.posX / 24));
				this.positionY = ((short) (this.posY / 24));
				this.var_aab = null;
				this.var_ab3 = 0;
			} else {
				if ((this.var_b73 != null) && (this.posX % 24 == 0)
						&& (this.posY % 24 == 0)) {
					this.var_b73.sub_18b7(this.positionX, this.positionY, false);
				}
				short[] arrayOfShort;
				int i = (arrayOfShort = (short[]) this.var_aab
						.elementAt(this.var_ab3))[0] * 24;
				int j = arrayOfShort[1] * 24;
				F_Sprite localClass_f_045 = null;
				if ((this.var_b73 == null)
						&& (++this.var_b6b >= 24 / var_a7b / 2)) {
					localClass_f_045 = sGame.sub_5873(sGame.bigSmokeSprite,
							this.posX, this.posY, 0, 0, 1,
							E_MainCanvas.sub_1564(1, 4) * 50);
					this.var_b6b = 0;
				}
				if (i < this.posX) {
					this.posX -= var_a7b;
					if (localClass_f_045 != null) {
						localClass_f_045.setSpritePosition(this.posX + this.frameWidth,
								this.posY + this.frameHeight
										- localClass_f_045.frameHeight);
					}
				} else if (i > this.posX) {
					this.posX += var_a7b;
					if (localClass_f_045 != null) {
						localClass_f_045.setSpritePosition(this.posX
								- localClass_f_045.frameWidth, this.posY
								+ this.frameHeight - localClass_f_045.frameHeight);
					}
				} else if (j < this.posY) {
					this.posY -= var_a7b;
					if (localClass_f_045 != null) {
						localClass_f_045
								.setSpritePosition(
										this.posX
												+ (this.frameWidth - localClass_f_045.frameWidth)
												/ 2, this.posY
												+ this.frameHeight);
					}
				} else if (j > this.posY) {
					this.posY += var_a7b;
					if (localClass_f_045 != null) {
						localClass_f_045
								.setSpritePosition(
										this.posX
												+ (this.frameWidth - localClass_f_045.frameWidth)
												/ 2, this.posY
												- localClass_f_045.frameHeight);
					}
				}
				if ((this.posX == i) && (this.posY == j)) {
					this.positionX = arrayOfShort[0];
					this.positionY = arrayOfShort[1];
					this.var_ab3 = ((short) (this.var_ab3 + 1));
				}
			}
			super.setSpritePosition(this.posX, this.posY);
			nextFrame();
			return;
		}
		if ((this.var_b13 == 0) && (sGame.time - this.var_abb >= 200L)) {
			nextFrame();
			this.var_abb = sGame.time;
		}
	}

	public static final boolean sub_22f7(byte paramByte, short paramShort) {
		return (var_bd3[paramByte] & paramShort) != 0;
	}

	public final boolean sub_232f(short paramShort) {
		return sub_22f7(this.unitTypeId, paramShort);
	}

	public final void sub_2352() {
		this.var_b13 = 2;
		C_Unit unit1;
		if ((unit1 = sGame.sub_dc52(this.positionX, this.positionY,
				(byte) 1)) != null) {
			unit1.removeFromMap();
		}
		if (sub_232f((short) 256)) {
			C_Unit[] unit2 = sub_15e7(this.positionX,
					this.positionY, 1, 2, (byte) 2);
			for (int i = 0; i < unit2.length; i++) {
				unit2[i].sub_119a((byte) 2);
				sGame.sub_5873(sGame.sparkSprite,
						unit2[i].posX,
						unit2[i].posY, 0, 0, 1, 50);
			}
		}
		sGame.var_3b53 = this;
	}

	public static final C_Unit[] sub_240e(byte paramByte) {
		C_Unit[] units = new C_Unit[sGame.var_359b[paramByte]];
		int i = 0;
		for (int j = 0; j < units.length; j++) {
			if ((sGame.var_3593[sGame.var_357b][j] != null)
					&& (sGame.var_3593[sGame.var_357b][j].var_b13 == 3)) {
				units[(i++)] = sGame.var_3593[sGame.var_357b][j];
			}
		}
		C_Unit[] units2 = new C_Unit[sGame.var_3703
				+ 1 + i];
		for (int k = 0; k < units2.length; k = (byte) (k + 1)) {
			if (k < i) {
				units2[k] = units[k];
			} else {
				units2[k] = sub_d60((byte) (k - i), paramByte, 0,
						0, false);
			}
		}
		return units2;
	}

	public final void sub_252e(Graphics gr, int paramInt1,
			int paramInt2) {
		sub_2551(gr, paramInt1, paramInt2, false);
	}

	public final void sub_2551(Graphics gr, int paramInt1,
			int paramInt2, boolean paramBoolean) {
		if (this.var_b13 != 4) {
			int i;
			int j;
			if (this.var_b3b) {
				if (this.var_b43) {
					i = -2;
				} else {
					i = 2;
				}
				j = E_MainCanvas.sub_158e() % 1;
				super.draw(gr, paramInt1 + i, paramInt2 + j);
			} else if ((paramBoolean) || (this.var_b13 == 2)) {
				sGame.playersUnitsSprites[0][this.unitTypeId].draw(gr,
						this.posX + paramInt1, this.posY + paramInt2);
			} else {
				super.draw(gr, paramInt1, paramInt2);
			}
			if (this.unitTypeId == 9) {
				i = this.posX + paramInt1;
				j = this.posY + paramInt2;
				if ((paramBoolean) || (this.var_b13 == 2)) {
					sGame.kingHeadsSprites[1].drawFrameAt(gr, this.var_b7b
							* 2 + this.currentFrameIndex, i, j, 0);
					return;
				}
				sGame.kingHeadsSprites[0].drawFrameAt(gr, this.var_b7b * 2
						+ this.currentFrameIndex, i, j, 0);
			}
		}
	}

	public final void sub_26ca(Graphics paramGraphics, int paramInt1,
			int paramInt2) {
		int i = this.posX + paramInt1;
		int j = this.posY + paramInt2;
		if ((this.var_b13 != 3) && (this.var_b0b < 100)) {
			E_MainCanvas.drawCharedString(paramGraphics, "" + this.var_b0b, i, j
					+ this.frameHeight - 7, 0);
		}
	}

	public static final void sub_2745(I_Game paramClass_i_168)
			throws Exception {
		sGame = paramClass_i_168;
		DataInputStream localDataInputStream = new DataInputStream(
				E_MainCanvas.getResourceStream("units.bin"));
		for (int i = 0; i < 12; i++) {
			var_b9b[i] = localDataInputStream.readByte();
			var_ba3[i][0] = localDataInputStream.readByte();
			var_ba3[i][1] = localDataInputStream.readByte();
			var_bab[i] = localDataInputStream.readByte();
			var_bb3[i] = localDataInputStream.readByte();
			var_bbb[i] = localDataInputStream.readByte();
			var_bcb[i] = localDataInputStream.readShort();
			int j = localDataInputStream.readByte();
			var_bc3[i] = new byte[j][2];
			for (int k = 0; k < j; k++) {
				var_bc3[i][k][0] = localDataInputStream.readByte();
				var_bc3[i][k][1] = localDataInputStream.readByte();
			}
			int k = localDataInputStream.readByte();
			for (int m = 0; m < k; m++) {
				int tmp171_170 = i;
				short[] tmp171_167 = var_bd3;
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