import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class Class_h_017 {
	
	public Image var_4bb;
	private boolean var_4c3 = false;
	private int var_4cb;
	private int var_4d3;
	public int var_4db;
	public int var_4e3;
	private int var_4eb;
	private int var_4f3;
	public int var_4fb = 0;

	public Class_h_017(Class_h_017 paramClass_h_017, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		this.var_4bb = paramClass_h_017.var_4bb;
		this.var_4db = paramInt3;
		this.var_4e3 = paramInt4;
		this.var_4cb = (paramInt1 * paramInt3 + paramClass_h_017.var_4cb);
		this.var_4d3 = (paramInt2 * paramInt4 + paramClass_h_017.var_4d3);
		this.var_4c3 = true;
	}

	public Class_h_017(Class_h_017 paramClass_h_017, int paramInt) {
		this.var_4bb = paramClass_h_017.var_4bb;
		this.var_4db = paramClass_h_017.var_4db;
		this.var_4e3 = paramClass_h_017.var_4e3;
		this.var_4cb = paramClass_h_017.var_4cb;
		this.var_4d3 = paramClass_h_017.var_4d3;
		this.var_4eb = paramClass_h_017.var_4eb;
		this.var_4f3 = paramClass_h_017.var_4f3;
		this.var_4c3 = paramClass_h_017.var_4c3;
		if ((paramInt & 0x1) != 0) {
			this.var_4fb = 2;
			return;
		}
		if ((paramInt & 0x2) != 0) {
			this.var_4fb = 1;
			return;
		}
		if ((paramInt & 0x4) != 0) {
			this.var_4fb = 6;
			return;
		}
		if ((paramInt & 0x8) != 0) {
			this.var_4fb = 3;
			return;
		}
		if ((paramInt & 0x10) != 0) {
			this.var_4fb = 5;
		}
	}

	public Class_h_017(String paramString) throws Exception {
		byte[] arrayOfByte = Class_e_034.sub_2726(paramString + ".png");
		this.var_4bb = Image.createImage(arrayOfByte, 0, arrayOfByte.length);
		this.var_4db = ((short) this.var_4bb.getWidth());
		this.var_4e3 = ((short) this.var_4bb.getHeight());
		this.var_4c3 = false;
	}

	public final void sub_6d9(int paramInt1, int paramInt2, int paramInt3) {
		if (this.var_4c3) {
			return;
		}
		int i = paramInt1 & 0xD;
		int j = paramInt1 & 0x32;
		if (this.var_4fb == 2) {
			if ((i & 0x4) != 0) {
				i = 8;
			} else if ((i & 0x8) != 0) {
				i = 4;
			}
		} else if (this.var_4fb == 1) {
			if ((j & 0x10) != 0) {
				i = 32;
			} else if ((i & 0x20) != 0) {
				i = 16;
			}
		}
		if (((paramInt1 = i | j) & 0x8) != 0) {
			this.var_4eb = (paramInt2 - this.var_4db);
		} else if ((paramInt1 & 0x1) != 0) {
			this.var_4eb = (paramInt2 - this.var_4db >> 1);
		}
		if ((paramInt1 & 0x20) != 0) {
			this.var_4f3 = (paramInt3 - this.var_4e3);
			return;
		}
		if ((paramInt1 & 0x2) != 0) {
			this.var_4f3 = (paramInt3 - this.var_4e3 >> 1);
		}
	}

	public final void sub_823(int paramInt1, int paramInt2) {
		this.var_4eb += paramInt1;
		this.var_4f3 += paramInt2;
	}

	public final void sub_852(Graphics paramGraphics, int paramInt1,
			int paramInt2) {
		sub_876(paramGraphics, paramInt1, paramInt2, 20);
	}

	public final void sub_876(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3) {
		if ((this.var_4c3) || (this.var_4fb != 0)) {
			paramGraphics
					.drawRegion(this.var_4bb, this.var_4cb, this.var_4d3,
							this.var_4db, this.var_4e3, this.var_4fb, paramInt1
									+ this.var_4eb, paramInt2 + this.var_4f3,
							paramInt3);
			return;
		}
		paramGraphics.drawImage(this.var_4bb, paramInt1 + this.var_4eb,
				paramInt2 + this.var_4f3, paramInt3);
	}

	public Class_h_017(String paramString, int paramInt) {
		byte[] localObject = Class_e_034.sub_2726(paramString + ".png");
		if (paramInt != 1) {
			byte[] arrayOfByte = new byte[localObject.length];
			System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
			sub_99f(arrayOfByte, paramInt);
			localObject = arrayOfByte;
		}
		this.var_4bb = Image.createImage((byte[]) localObject, 0,
				localObject.length);
		this.var_4db = ((short) this.var_4bb.getWidth());
		this.var_4e3 = ((short) this.var_4bb.getHeight());
	}

	public static final void sub_99f(byte[] paramArrayOfByte, int paramInt) {
		try {
			int i = 33;
			int j = 0;
			int k = paramArrayOfByte.length - 3;
			while (j < k) {
				if ((paramArrayOfByte[j] == 80)
						&& (paramArrayOfByte[(j + 1)] == 76)
						&& (paramArrayOfByte[(j + 2)] == 84)) {
					i = j - 4;
					break;
				}
				j++;
			}
			j = i;
			k = ((paramArrayOfByte[j] & 0xFF) << 24
					| (paramArrayOfByte[(j + 1)] & 0xFF) << 16
					| (paramArrayOfByte[(j + 2)] & 0xFF) << 8 | paramArrayOfByte[(j + 3)] & 0xFF) & 0xFFFFFFFF;
			j += 4;
			int m = -1;
			for (int n = 0; n < 4; n++) {
				m = sub_cab(paramArrayOfByte[(j + n)], m);
			}
			j += 4;
			for (int i3 = j; i3 < j + k; i3 += 3) {
				int i4 = paramArrayOfByte[i3] & 0xFF;
				int i5 = paramArrayOfByte[(i3 + 1)] & 0xFF;
				int i6 = paramArrayOfByte[(i3 + 2)] & 0xFF;
				if (paramInt == 0) {
					if ((i4 != 244) || (i5 != 244) || (i6 != 230)) {
						int i7;
						i4 = i7 = (i4 + i5 + i6) / 3;
						i5 = i7;
						i6 = i7;
						paramArrayOfByte[i3] = ((byte) i4);
						paramArrayOfByte[(i3 + 1)] = ((byte) i5);
						paramArrayOfByte[(i3 + 2)] = ((byte) i6);
					}
				} else if (paramInt != 1) {
					int[][] arrayOfInt1 = Class_i_168.var_33b3[1];
					int[][] arrayOfInt2 = Class_i_168.var_33b3[paramInt];
					for (int i8 = 0; i8 < arrayOfInt1.length; i8++) {
						if ((arrayOfInt1[i8][0] == i4)
								&& (arrayOfInt1[i8][1] == i5)
								&& (arrayOfInt1[i8][2] == i6)) {
							paramArrayOfByte[i3] = ((byte) arrayOfInt2[i8][0]);
							paramArrayOfByte[(i3 + 1)] = ((byte) arrayOfInt2[i8][1]);
							paramArrayOfByte[(i3 + 2)] = ((byte) arrayOfInt2[i8][2]);
							break;
						}
					}
				}
				m = sub_cab(paramArrayOfByte[i3], m);
				m = sub_cab(paramArrayOfByte[(i3 + 1)], m);
				m = sub_cab(paramArrayOfByte[(i3 + 2)], m);
			}
			m ^= 0xFFFFFFFF;
			int i3 = i + 8 + k;
			paramArrayOfByte[i3] = ((byte) (m >> 24));
			paramArrayOfByte[(i3 + 1)] = ((byte) (m >> 16));
			paramArrayOfByte[(i3 + 2)] = ((byte) (m >> 8));
			paramArrayOfByte[(i3 + 3)] = ((byte) m);
			return;
		} catch (Exception localException2) {
			localException2.printStackTrace();
		}
	}

	public static final int sub_cab(byte paramByte, int paramInt) {
		int i = paramByte & 0xFF;
		paramInt ^= i;
		for (int j = 0; j < 8; j++) {
			if ((paramInt & 0x1) != 0) {
				paramInt = paramInt >>> 1 ^ 0xEDB88320;
			} else {
				paramInt >>>= 1;
			}
		}
		return paramInt;
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_h_017
 * 
 * JD-Core Version: 0.7.0.1
 */