import java.io.InputStream;

import javax.microedition.lcdui.Graphics;

public class F_Sprite {
	
	public H_ImageExt[] frameImages;
	private byte[] var_7cc;
	public int var_7d4 = 0;
	public int var_7dc = 0;
	public int var_7e4 = 0;
	public boolean var_7ec = true;
	public int var_7f4;
	public int var_7fc;
	public byte[][] var_804;
	public int var_80c;
	public byte var_814 = 0;
	public int var_81c = -1;
	public int var_824;
	public int var_82c;
	public int var_834;
	public int var_83c;
	public int var_844;
	public boolean var_84c = true;
	public boolean var_854;
	public boolean var_85c;
	public int var_864 = -1;
	public byte var_86c = -1;
	public boolean var_874;
	public int var_87c;
	public String var_884;
	public int var_88c;
	public F_Sprite var_894;
	public F_Sprite var_89c;
	public int[][] var_8a4;
	public short[][] var_8ac;
	public int var_8b4 = 16769024;
	public byte[] var_8bc;
	public boolean[] var_8c4;

	public F_Sprite(String paramString) throws Exception {
		sub_a60(paramString, 1);
	}

	public F_Sprite(H_ImageExt[] paramArrayOfClass_h_017) {
		this.frameImages = paramArrayOfClass_h_017;
		this.var_7cc = new byte[this.frameImages.length];
		for (byte i = 0; i < this.frameImages.length; i = (byte) (i + 1)) {
			this.var_7cc[i] = i;
		}
		this.var_7f4 = this.frameImages[0].var_4db;
		this.var_7fc = this.frameImages[0].var_4e3;
	}

	public F_Sprite(String paramString, byte paramByte) throws Exception {
		sub_a60(paramString, paramByte);
	}

	private final void sub_a60(String paramString, int paramInt)
			throws Exception {
		InputStream localInputStream;
		int i = (byte) (localInputStream = E_MainCanvas.getResourceStream(paramString
				+ ".sprite")).read();
		this.var_7f4 = ((byte) localInputStream.read());
		this.var_7fc = ((byte) localInputStream.read());
		this.frameImages = new H_ImageExt[i];
		H_ImageExt[] arrayOfClass_h_017 = new H_ImageExt[i];
		int k;
		int i1;
		int i2;
		try {
			H_ImageExt localClass_h_017;
			k = (localClass_h_017 = new H_ImageExt(paramString, paramInt)).var_4db
					/ this.var_7f4;
			int m = localClass_h_017.var_4e3 / this.var_7fc;
			i1 = 0;
			for (i2 = 0; i2 < m; i2++) {
				for (int i3 = 0; i3 < k; i3++) {
					arrayOfClass_h_017[i1] = new H_ImageExt(localClass_h_017,
							i3, i2, this.var_7f4, this.var_7fc);
					i1++;
				}
			}
		} catch (Exception localException1) {
			try {
				for (k = 0; k < i; k++) {
					StringBuffer localStringBuffer;
					(localStringBuffer = new StringBuffer(paramString))
							.append('_');
					if (k < 10) {
						localStringBuffer.append('0');
					}
					localStringBuffer.append(k);
					if (paramInt == 1) {
						arrayOfClass_h_017[k] = new H_ImageExt(
								localStringBuffer.toString());
					} else {
						arrayOfClass_h_017[k] = new H_ImageExt(
								localStringBuffer.toString(), paramInt);
					}
				}
			} catch (Exception localException2) {
			}
		}
		int n;
		for (int j = 0; j < i; j++) {
			k = localInputStream.read();
			n = localInputStream.read();
			this.frameImages[j] = new H_ImageExt(arrayOfClass_h_017[k], n);
		}
		int j;
		if ((j = localInputStream.read()) > 0) {
			for (k = 0; k < i; k++) {
				this.frameImages[k].sub_6d9(j, this.var_7f4, this.var_7fc);
			}
		}
		if ((k = localInputStream.read()) > 0) {
			this.var_804 = new byte[k][];
			this.var_82c = (localInputStream.read() * 50);
			for (n = 0; n < k; n++) {
				i1 = localInputStream.read();
				this.var_804[n] = new byte[i1];
				for (i2 = 0; i2 < i1; i2++) {
					this.var_804[n][i2] = ((byte) localInputStream.read());
				}
			}
		}
		for (int n1 = 0; n1 < i; n1++) {
			i1 = (byte) localInputStream.read();
			i2 = (byte) localInputStream.read();
			if ((i1 == -1) || (i2 == -1)) {
				break;
			}
			this.frameImages[n1].sub_823(i1, i2);
		}
		localInputStream.close();
		if (this.var_804 != null) {
			this.var_7cc = this.var_804[0];
			return;
		}
		this.var_7cc = new byte[i];
		for (byte n1 = 0; n1 < i; n1 = (byte) (n1 + 1)) {
			this.var_7cc[n1] = n1;
		}
	}

	public F_Sprite(F_Sprite paramClass_f_045) {
		this.frameImages = paramClass_f_045.frameImages;
		this.var_7cc = paramClass_f_045.var_7cc;
		this.var_7d4 = paramClass_f_045.var_7d4;
		this.var_7dc = paramClass_f_045.var_7dc;
		this.var_7e4 = paramClass_f_045.var_7e4;
		this.var_80c = paramClass_f_045.var_80c;
		this.var_7ec = paramClass_f_045.var_7ec;
		this.var_7f4 = paramClass_f_045.var_7f4;
		this.var_7fc = paramClass_f_045.var_7fc;
		this.var_82c = paramClass_f_045.var_82c;
		this.var_804 = paramClass_f_045.var_804;
	}

	public F_Sprite(int paramInt1, int paramInt2) {
		this.var_7f4 = paramInt1;
		this.var_7fc = paramInt2;
	}

	public final int sub_104a() {
		return this.var_7cc.length;
	}

	public final int sub_106a() {
		return this.frameImages.length;
	}

	public final void sub_108a(int paramInt) {
		if (paramInt < this.var_7cc.length) {
			this.var_7d4 = ((byte) paramInt);
		}
	}

	public final void sub_10c6(int paramInt1, int paramInt2) {
		this.var_7dc = ((short) paramInt1);
		this.var_7e4 = ((short) paramInt2);
	}

	public final void sub_10ed() {
		this.var_7d4 += 1;
		if (this.var_7d4 >= this.var_7cc.length) {
			this.var_7d4 = 0;
		}
	}

	public final void sub_1134(byte[] paramArrayOfByte) {
		this.var_7cc = paramArrayOfByte;
		this.var_7d4 = 0;
		this.var_824 = 0;
	}

	public final void sub_115e(int paramInt, boolean paramBoolean) {
		if ((this.var_804 != null) && (paramInt <= this.var_804.length)) {
			byte[] localObject = this.var_804[paramInt];
			if (paramBoolean) {
				byte[] arrayOfByte = new byte[localObject.length];
				for (int i = 0; i < arrayOfByte.length; i++) {
					arrayOfByte[i] = ((byte) (localObject[i] + sub_106a() / 2));
				}
				localObject = arrayOfByte;
			}
			sub_1134((byte[]) localObject);
		}
	}

	public final void sub_1209(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		if ((this.var_814 == 2) || (this.var_814 == 4) || (this.var_814 == 3)) {
			sub_12d2(paramGraphics, paramInt2, paramInt3);
			return;
		}
		if (this.var_7ec) {
			int i = this.var_7dc + paramInt2;
			int j = this.var_7e4 + paramInt3;
			this.frameImages[paramInt1].sub_876(paramGraphics, i, j, paramInt4);
		}
	}

	public final void sub_12a5(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3) {
		sub_1209(paramGraphics, this.var_7cc[this.var_7d4], paramInt1,
				paramInt2, paramInt3);
	}

	public void sub_12d2(Graphics paramGraphics, int paramInt1, int paramInt2) {
		int k = 0;
		if ((this.var_814 == 2) || (this.var_814 == 4)) {
			paramGraphics.setColor(this.var_8b4);
			k = 0;
		}
		while (k < 5) {
			int i;
			int j;
			if (this.var_8c4[k] != false) {
				i = (this.var_8a4[k][0] >> 10) + paramInt1 + this.var_7dc;
				j = (this.var_8a4[k][1] >> 10) + paramInt2 + this.var_7e4;
				paramGraphics.fillRect(i, j, this.var_8bc[k], this.var_8bc[k]);
			}
			k++;
			// continue; @todo
			if (this.var_814 == 6) {
				i = 0;
				if (this.var_7d4 == 0) {
					paramGraphics.setColor(15718144);
				} else {
					paramGraphics.setColor(16777215);
				}
				if (this.var_834 > 0) {
					j = this.var_7dc + 15;
					paramGraphics.fillArc(this.var_7dc, this.var_7e4 - 15, 30,
							30, 0, 360);
					paramGraphics.fillRect(j, this.var_7e4 - 15,
							E_MainCanvas.canvasWidth - j, 30);
					return;
				}
				paramGraphics.fillArc(this.var_7dc - 30, this.var_7e4 - 15, 30,
						30, 0, 360);
				paramGraphics.fillRect(0, this.var_7e4 - 15, this.var_7dc - 15,
						30);
				return;
			}
			if (this.var_814 == 3) {
				paramGraphics.setColor(0);
				if (this.var_834 > 0) {
					paramGraphics.drawLine(this.var_7dc, this.var_7e4,
							this.var_7dc + 4, this.var_7e4 - 2);
					return;
				}
				paramGraphics.drawLine(this.var_7dc - 4, this.var_7e4 - 2,
						this.var_7dc, this.var_7e4);
				return;
			}
			if (this.var_7ec) {
				i = this.var_7dc + paramInt1;
				j = this.var_7e4 + paramInt2;
				if (this.var_884 != null) {
					E_MainCanvas.sub_189a(paramGraphics, this.var_884, i, j,
							this.var_88c, 33);
					return;
				}
				if (this.var_864 > 0) {
					i += E_MainCanvas.sub_1564(-4, 5);
					j += E_MainCanvas.sub_1564(-1, 2);
				}
				k = this.var_7cc[this.var_7d4];
				this.frameImages[k].sub_852(paramGraphics, i, j);
				if (this.var_894 != null) {
					int m;
					F_Sprite localClass_f_045;
					if ((m = k % (sub_106a() / 2)) == 2) {
						localClass_f_045 = this.var_89c;
					} else {
						(localClass_f_045 = this.var_894).sub_108a(m);
					}
					localClass_f_045.sub_12d2(paramGraphics, i, j);
				}
			}
		}
	}

	public static final F_Sprite sub_15c2(String paramString, int paramInt1,
			int paramInt2, byte paramByte) {
		int i = E_MainCanvas.sub_1761(paramByte, paramString);
		int j = E_MainCanvas.sub_1789(paramByte);
		F_Sprite localClass_f_045;
		(localClass_f_045 = new F_Sprite(i, j)).var_88c = paramByte;
		localClass_f_045.var_884 = paramString;
		localClass_f_045.var_834 = paramInt1;
		localClass_f_045.var_844 = paramInt2;
		localClass_f_045.var_814 = 5;
		return localClass_f_045;
	}

	public static final F_Sprite sub_1616(F_Sprite paramClass_f_045,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			int paramInt5, byte paramByte) {
		F_Sprite localClass_f_045 = null;
		if (paramClass_f_045 != null) {
			localClass_f_045 = new F_Sprite(paramClass_f_045);
		} else {
			localClass_f_045 = new F_Sprite(0, 0);
			if ((paramByte == 2) || (paramByte == 4)) {
				if (paramByte == 4) {
					localClass_f_045.var_8b4 = 15658751;
				}
				localClass_f_045.var_8a4 = new int[5][2];
				localClass_f_045.var_8ac = new short[5][2];
				localClass_f_045.var_8bc = new byte[5];
				localClass_f_045.var_8c4 = new boolean[5];
				for (int k = 0; k < 5; k++) {
					localClass_f_045.var_8c4[k] = true;
					if (paramByte == 4) {
						localClass_f_045.var_8ac[k][0] = ((short) (E_MainCanvas.var_1414
								.nextInt() % 4 << 10));
						localClass_f_045.var_8ac[k][1] = ((short) (E_MainCanvas.var_1414
								.nextInt() % 4 << 10));
					} else {
						localClass_f_045.var_8ac[k][0] = ((short) (Math
								.abs(E_MainCanvas.var_1414.nextInt()) % 8192 + -4096));
						localClass_f_045.var_8ac[k][1] = ((short) (Math
								.abs(E_MainCanvas.var_1414.nextInt()) % 4096 + -2048));
					}
					localClass_f_045.var_8bc[k] = ((byte) (Math
							.abs(E_MainCanvas.var_1414.nextInt()) % 2 + 1));
				}
			}
		}
		localClass_f_045.var_814 = paramByte;
		localClass_f_045.var_81c = paramInt4;
		localClass_f_045.var_82c = paramInt5;
		localClass_f_045.var_834 = paramInt1;
		localClass_f_045.var_83c = paramInt2;
		localClass_f_045.var_844 = paramInt3;
		localClass_f_045.var_854 = true;
		return localClass_f_045;
	}

	public void sub_17ec() {
		if (this.var_84c) {
			this.var_824 += 50;
			if (this.var_864 >= 0) {
				this.var_864 -= 1;
			}
			switch (this.var_814) {
			case 2:
			case 4:
				sub_19ce();
				return;
			case 3:
				sub_10c6(this.var_7dc + this.var_834, this.var_7e4
						+ this.var_83c);
				return;
			case 6:
				this.var_7d4 = ((this.var_7d4 + 1) % 2);
				if (this.var_824 >= this.var_82c) {
					this.var_84c = false;
					return;
				}
				break;
			case 5:
				if (this.var_81c == -1) {
					sub_10c6(this.var_7dc + this.var_834, this.var_7e4);
					this.var_80c += this.var_844;
					if (this.var_80c >= 0) {
						this.var_80c = 0;
						this.var_844 = (-this.var_844 / 2);
						if (this.var_844 == 0) {
							this.var_81c = 1;
							this.var_824 = 0;
						}
					} else {
						this.var_844 += 1;
					}
				} else if (this.var_824 >= 400) {
					this.var_84c = false;
					return;
				}
				break;
			default:
				sub_10c6(this.var_7dc + this.var_834, this.var_7e4
						+ this.var_83c);
				this.var_80c += this.var_844;
				if ((this.var_81c != 0) && (this.var_824 >= this.var_82c)) {
					sub_10ed();
					if ((this.var_814 == 0) && (this.var_7d4 == 0)
							&& (this.var_81c > 0)) {
						this.var_81c -= 1;
						if (this.var_81c <= 0) {
							sub_108a(sub_104a() - 1);
							if (this.var_854) {
								this.var_84c = false;
							}
						}
					}
					this.var_824 = 0;
				}
				break;
			}
		}
	}

	public final void sub_19ce() {
		if (this.var_814 != 4) {
			this.var_8b4 += -263168;
		}
		for (int i = 0; i < 5; i++) {
			if (this.var_8c4[i] != false) {
				if (this.var_814 == 4) {
					this.var_8a4[i][0] += this.var_8ac[i][0];
					this.var_8a4[i][1] += this.var_8ac[i][1];
					if (this.var_8ac[i][0] < 0) {
						int tmp102_101 = 0;
						short[] tmp102_100 = this.var_8ac[i];
						tmp102_100[tmp102_101] = ((short) (tmp102_100[tmp102_101] + 256));
					} else if (this.var_8ac[i][0] > 0) {
						int tmp131_130 = 0;
						short[] tmp131_129 = this.var_8ac[i];
						tmp131_129[tmp131_130] = ((short) (tmp131_129[tmp131_130] - 256));
					}
					if (this.var_8ac[i][1] < 0) {
						int tmp157_156 = 1;
						short[] tmp157_155 = this.var_8ac[i];
						tmp157_155[tmp157_156] = ((short) (tmp157_155[tmp157_156] + 256));
					} else if (this.var_8ac[i][1] > 0) {
						int tmp186_185 = 1;
						short[] tmp186_184 = this.var_8ac[i];
						tmp186_184[tmp186_185] = ((short) (tmp186_184[tmp186_185] - 256));
					}
				} else {
					this.var_8a4[i][0] += this.var_8ac[i][0];
					this.var_8a4[i][1] += this.var_8ac[i][1];
					int tmp242_241 = 1;
					short[] tmp242_240 = this.var_8ac[i];
					tmp242_240[tmp242_241] = ((short) (tmp242_240[tmp242_241] + 256));
				}
			}
		}
		if (this.var_824 >= this.var_82c) {
			this.var_84c = false;
		}
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_f_045
 * 
 * JD-Core Version: 0.7.0.1
 */