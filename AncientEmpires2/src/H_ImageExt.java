import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class H_ImageExt {
	
	public Image image;
	private boolean var_4c3 = false;
	private int var_4cb;
	private int var_4d3;
	public int imageWidth;
	public int imageHeight;
	private int locationX;
	private int locationY;
	public int var_4fb = 0;

	public H_ImageExt(H_ImageExt image, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		this.image = image.image;
		this.imageWidth = paramInt3;
		this.imageHeight = paramInt4;
		this.var_4cb = (paramInt1 * paramInt3 + image.var_4cb);
		this.var_4d3 = (paramInt2 * paramInt4 + image.var_4d3);
		this.var_4c3 = true;
	}

	public H_ImageExt(H_ImageExt image, int paramInt) {
		this.image = image.image;
		this.imageWidth = image.imageWidth;
		this.imageHeight = image.imageHeight;
		this.var_4cb = image.var_4cb;
		this.var_4d3 = image.var_4d3;
		this.locationX = image.locationX;
		this.locationY = image.locationY;
		this.var_4c3 = image.var_4c3;
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

	public H_ImageExt(String paramString) throws Exception {
		byte[] imgData = E_MainCanvas.getResourceData(paramString + ".png");
		this.image = Image.createImage(imgData, 0, imgData.length);
		this.imageWidth = ((short) this.image.getWidth());
		this.imageHeight = ((short) this.image.getHeight());
		this.var_4c3 = false;
	}
	
	public H_ImageExt(String paramString, int paramInt) {
		byte[] imgData = E_MainCanvas.getResourceData(paramString + ".png");
		if (paramInt != 1) {
			byte[] data = new byte[imgData.length];
			System.arraycopy(imgData, 0, data, 0, imgData.length);
			sub_99f(data, paramInt);
			imgData = data;
		}
		this.image = Image.createImage((byte[]) imgData, 0,
				imgData.length);
		this.imageWidth = ((short) this.image.getWidth());
		this.imageHeight = ((short) this.image.getHeight());
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
			this.locationX = (paramInt2 - this.imageWidth);
		} else if ((paramInt1 & 0x1) != 0) {
			this.locationX = (paramInt2 - this.imageWidth >> 1);
		}
		if ((paramInt1 & 0x20) != 0) {
			this.locationY = (paramInt3 - this.imageHeight);
			return;
		}
		if ((paramInt1 & 0x2) != 0) {
			this.locationY = (paramInt3 - this.imageHeight >> 1);
		}
	}

	public final void translateImage(int inX, int inY) {
		this.locationX += inX;
		this.locationY += inY;
	}

	public final void drawImageExt(Graphics gr, int inX,
			int inY) {
		drawImageExt(gr, inX, inY, 20);
	}

	public final void drawImageExt(Graphics gr, int inX,
			int inY, int paramInt3) {
		if ((this.var_4c3) || (this.var_4fb != 0)) {
			gr
					.drawRegion(this.image, this.var_4cb, this.var_4d3,
							this.imageWidth, this.imageHeight, this.var_4fb, inX
									+ this.locationX, inY + this.locationY,
							paramInt3);
			return;
		}
		gr.drawImage(this.image, inX + this.locationX,
				inY + this.locationY, paramInt3);
	}
	
	public static final void sub_99f(byte[] data, int paramInt) {
		try {
			int i = 33;
			int it = 0;
			int length3 = data.length - 3;
			while (it < length3) {
				if ((data[it] == 80)
						&& (data[(it + 1)] == 76)
						&& (data[(it + 2)] == 84)) {
					i = it - 4;
					break;
				}
				it++;
			}
			it = i;
			length3 = ((data[it] & 0xFF) << 24
					| (data[(it + 1)] & 0xFF) << 16
					| (data[(it + 2)] & 0xFF) << 8 | data[(it + 3)] & 0xFF) & 0xFFFFFFFF;
			it += 4;
			int m = -1;
			for (int n = 0; n < 4; n++) {
				m = sub_cab(data[(it + n)], m);
			}
			it += 4;
			for (int i3 = it; i3 < it + length3; i3 += 3) {
				int i4 = data[i3] & 0xFF;
				int i5 = data[(i3 + 1)] & 0xFF;
				int i6 = data[(i3 + 2)] & 0xFF;
				if (paramInt == 0) {
					if ((i4 != 244) || (i5 != 244) || (i6 != 230)) {
						int i7;
						i4 = i7 = (i4 + i5 + i6) / 3;
						i5 = i7;
						i6 = i7;
						data[i3] = ((byte) i4);
						data[(i3 + 1)] = ((byte) i5);
						data[(i3 + 2)] = ((byte) i6);
					}
				} else if (paramInt != 1) {
					int[][] arrayOfInt1 = I_Game.var_33b3[1];
					int[][] arrayOfInt2 = I_Game.var_33b3[paramInt];
					for (int i8 = 0; i8 < arrayOfInt1.length; i8++) {
						if ((arrayOfInt1[i8][0] == i4)
								&& (arrayOfInt1[i8][1] == i5)
								&& (arrayOfInt1[i8][2] == i6)) {
							data[i3] = ((byte) arrayOfInt2[i8][0]);
							data[(i3 + 1)] = ((byte) arrayOfInt2[i8][1]);
							data[(i3 + 2)] = ((byte) arrayOfInt2[i8][2]);
							break;
						}
					}
				}
				m = sub_cab(data[i3], m);
				m = sub_cab(data[(i3 + 1)], m);
				m = sub_cab(data[(i3 + 2)], m);
			}
			m ^= 0xFFFFFFFF;
			int i3 = i + 8 + length3;
			data[i3] = ((byte) (m >> 24));
			data[(i3 + 1)] = ((byte) (m >> 16));
			data[(i3 + 2)] = ((byte) (m >> 8));
			data[(i3 + 3)] = ((byte) m);
			return;
		} catch (Exception ex2) {
			ex2.printStackTrace();
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