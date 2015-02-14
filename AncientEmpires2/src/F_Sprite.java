import java.io.InputStream;

import javax.microedition.lcdui.Graphics;

public class F_Sprite {
	
	public H_ImageExt[] frameImages;
	private byte[] frameSequence;
	public int currentFrameIndex = 0;
	public int posX = 0;
	public int posY = 0;
	public boolean var_7ec = true;
	public int frameWidth;
	public int frameHeight;
	public byte[][] frameAnimationsSequences;
	public int var_80c;
	public byte var_814 = 0;
	public int var_81c = -1;
	public int frameTime;
	public int mapFrameTime;
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
	public int yellowColor = 16769024; //#FFE000 yellow
	public byte[] var_8bc;
	public boolean[] var_8c4;

	public F_Sprite(String spriteId) throws Exception {
		loadSprite(spriteId, 1);
	}

	public F_Sprite(H_ImageExt[] images) {
		this.frameImages = images;
		this.frameSequence = new byte[this.frameImages.length];
		for (byte index = 0; index < this.frameImages.length; index = (byte) (index + 1)) {
			this.frameSequence[index] = index;
		}
		this.frameWidth = this.frameImages[0].imageWidth;
		this.frameHeight = this.frameImages[0].imageHeight;
	}

	public F_Sprite(String spriteId, byte paramByte) throws Exception {
		loadSprite(spriteId, paramByte);
	}

	private final void loadSprite(String spriteId, int paramInt)
			throws Exception {
		InputStream stream = E_MainCanvas.getResourceStream(spriteId
				+ ".sprite");
		int length = (byte) (stream ).read();
		this.frameWidth = ((byte) stream.read());
		this.frameHeight = ((byte) stream.read());
		this.frameImages = new H_ImageExt[length];
		H_ImageExt[] images = new H_ImageExt[length];
		try {
			H_ImageExt localClass_h_017 = new H_ImageExt(spriteId, paramInt);
			int numberOfFramesX = localClass_h_017.imageWidth
					/ this.frameWidth;
			int numberOfFramesY = localClass_h_017.imageHeight / this.frameHeight;
			int i1 = 0;
			for (int i2 = 0; i2 < numberOfFramesY; i2++) {
				for (int i3 = 0; i3 < numberOfFramesX; i3++) {
					images[i1] = new H_ImageExt(localClass_h_017,
							i3, i2, this.frameWidth, this.frameHeight);
					i1++;
				}
			}
		} catch (Exception localException1) {
			try {
				for (int it = 0; it < length; it++) {
					StringBuffer localStringBuffer;
					(localStringBuffer = new StringBuffer(spriteId))
							.append('_');
					if (it < 10) {
						localStringBuffer.append('0');
					}
					localStringBuffer.append(it);
					if (paramInt == 1) {
						images[it] = new H_ImageExt(
								localStringBuffer.toString());
					} else {
						images[it] = new H_ImageExt(
								localStringBuffer.toString(), paramInt);
					}
				}
			} catch (Exception localException2) {
			}
		}
		for (int j = 0; j < length; j++) {
			int n1 = stream.read();
			int n = stream.read();
			this.frameImages[j] = new H_ImageExt(images[n1], n);
		}
		int j = stream.read();
		if (j > 0) {
			for (int it = 0; it < length; it++) {
				this.frameImages[it].sub_6d9(j, this.frameWidth, this.frameHeight);
			}
		}
		int nn = stream.read();
		if (nn > 0) {
			this.frameAnimationsSequences = new byte[nn][];
			this.mapFrameTime = (stream.read() * 50);
			for (int n1 = 0; n1 < nn; n1++) {
				int i1 = stream.read();
				this.frameAnimationsSequences[n1] = new byte[i1];
				for (int i2 = 0; i2 < i1; i2++) {
					this.frameAnimationsSequences[n1][i2] = ((byte) stream.read());
				}
			}
		}
		for (int n1 = 0; n1 < length; n1++) {
			byte i1 = (byte) stream.read();
			byte i2 = (byte) stream.read();
			if ((i1 == -1) || (i2 == -1)) {
				break;
			}
			this.frameImages[n1].translateImage(i1, i2);
		}
		stream.close();
		if (this.frameAnimationsSequences != null) {
			this.frameSequence = this.frameAnimationsSequences[0];
			return;
		}
		this.frameSequence = new byte[length];
		for (byte n1 = 0; n1 < length; n1 = (byte) (n1 + 1)) {
			this.frameSequence[n1] = n1;
		}
	}

	public F_Sprite(F_Sprite sprite) {
		this.frameImages = sprite.frameImages;
		this.frameSequence = sprite.frameSequence;
		this.currentFrameIndex = sprite.currentFrameIndex;
		this.posX = sprite.posX;
		this.posY = sprite.posY;
		this.var_80c = sprite.var_80c;
		this.var_7ec = sprite.var_7ec;
		this.frameWidth = sprite.frameWidth;
		this.frameHeight = sprite.frameHeight;
		this.mapFrameTime = sprite.mapFrameTime;
		this.frameAnimationsSequences = sprite.frameAnimationsSequences;
	}

	public F_Sprite(int width, int height) {
		this.frameWidth = width;
		this.frameHeight = height;
	}

	public final int getFrameSequenceLength() {
		return this.frameSequence.length;
	}

	public final int getFramesCount() {
		return this.frameImages.length;
	}

	public final void setCurrentFrameIndex(int val) {
		if (val < this.frameSequence.length) {
			this.currentFrameIndex = ((byte) val);
		}
	}

	public final void setSpritePosition(int pX, int pY) {
		this.posX = ((short) pX);
		this.posY = ((short) pY);
	}

	public final void nextFrame() {
		this.currentFrameIndex += 1;
		if (this.currentFrameIndex >= this.frameSequence.length) {
			this.currentFrameIndex = 0;
		}
	}

	public final void setFrameSequence(byte[] data) {
		this.frameSequence = data;
		this.currentFrameIndex = 0;
		this.frameTime = 0;
	}

	public final void startAnimation(int animationIndex, boolean inBool) {
		if ((this.frameAnimationsSequences != null) && (animationIndex <= this.frameAnimationsSequences.length)) {
			byte[] frameSeq = this.frameAnimationsSequences[animationIndex];
			if (inBool) {
				byte[] arrayOfByte = new byte[frameSeq.length];
				for (int i = 0; i < arrayOfByte.length; i++) {
					arrayOfByte[i] = ((byte) (frameSeq[i] + getFramesCount() / 2));
				}
				frameSeq = arrayOfByte;
			}
			setFrameSequence((byte[]) frameSeq);
		}
	}

	public final void sub_1209(Graphics gr, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		if ((this.var_814 == 2) || (this.var_814 == 4) || (this.var_814 == 3)) {
			draw(gr, paramInt2, paramInt3);
			return;
		}
		if (this.var_7ec) {
			int i = this.posX + paramInt2;
			int j = this.posY + paramInt3;
			this.frameImages[paramInt1].drawImageExt(gr, i, j, paramInt4);
		}
	}

	public final void sub_12a5(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3) {
		sub_1209(paramGraphics, this.frameSequence[this.currentFrameIndex], paramInt1,
				paramInt2, paramInt3);
	}

	//this is not virtual
	public void draw(Graphics gr, int inX, int inY) {
		int k = 0;
		if ((this.var_814 == 2) || (this.var_814 == 4)) {
			gr.setColor(this.yellowColor);
			k = 0;
		}
		while (k < 5) {
			int i;
			int j;
			if (this.var_8c4[k] != false) {
				i = (this.var_8a4[k][0] >> 10) + inX + this.posX;
				j = (this.var_8a4[k][1] >> 10) + inY + this.posY;
				gr.fillRect(i, j, this.var_8bc[k], this.var_8bc[k]);
			}
			k++;
			// continue; @todo
			if (this.var_814 == 6) {
				i = 0;
				if (this.currentFrameIndex == 0) {
					gr.setColor(15718144); // #EFD700 sand yellow
				} else {
					gr.setColor(16777215); // white
				}
				if (this.var_834 > 0) {
					j = this.posX + 15;
					gr.fillArc(this.posX, this.posY - 15, 30,
							30, 0, 360);
					gr.fillRect(j, this.posY - 15,
							E_MainCanvas.canvasWidth - j, 30);
					return;
				}
				gr.fillArc(this.posX - 30, this.posY - 15, 30,
						30, 0, 360);
				gr.fillRect(0, this.posY - 15, this.posX - 15,
						30);
				return;
			}
			if (this.var_814 == 3) {
				gr.setColor(0);
				if (this.var_834 > 0) {
					gr.drawLine(this.posX, this.posY,
							this.posX + 4, this.posY - 2);
					return;
				}
				gr.drawLine(this.posX - 4, this.posY - 2,
						this.posX, this.posY);
				return;
			}
			if (this.var_7ec) {
				i = this.posX + inX;
				j = this.posY + inY;
				if (this.var_884 != null) {
					E_MainCanvas.sub_189a(gr, this.var_884, i, j,
							this.var_88c, 33);
					return;
				}
				if (this.var_864 > 0) {
					i += E_MainCanvas.sub_1564(-4, 5);
					j += E_MainCanvas.sub_1564(-1, 2);
				}
				k = this.frameSequence[this.currentFrameIndex];
				this.frameImages[k].drawImageExt(gr, i, j);
				if (this.var_894 != null) {
					int m = k % (getFramesCount() / 2);
					F_Sprite sprite;
					if (m == 2) {
						sprite = this.var_89c;
					} else {
						sprite = this.var_894;
						sprite.setCurrentFrameIndex(m);
					}
					sprite.draw(gr, i, j);
				}
			}
		}
	}

	public static final F_Sprite sub_15c2(String str, int paramInt1,
			int paramInt2, byte paramByte) {
		int i = E_MainCanvas.sub_1761(paramByte, str);
		int j = E_MainCanvas.sub_1789(paramByte);
		F_Sprite sprite = new F_Sprite(i, j);
		sprite.var_88c = paramByte;
		sprite.var_884 = str;
		sprite.var_834 = paramInt1;
		sprite.var_844 = paramInt2;
		sprite.var_814 = 5;
		return sprite;
	}

	public static final F_Sprite sub_1616(F_Sprite sprite,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			int paramInt5, byte paramByte) {
		F_Sprite lspr = null;
		if (sprite != null) {
			lspr = new F_Sprite(sprite);
		} else {
			lspr = new F_Sprite(0, 0);
			if ((paramByte == 2) || (paramByte == 4)) {
				if (paramByte == 4) {
					lspr.yellowColor = 15658751;
				}
				lspr.var_8a4 = new int[5][2];
				lspr.var_8ac = new short[5][2];
				lspr.var_8bc = new byte[5];
				lspr.var_8c4 = new boolean[5];
				for (int k = 0; k < 5; k++) {
					lspr.var_8c4[k] = true;
					if (paramByte == 4) {
						lspr.var_8ac[k][0] = ((short) (E_MainCanvas.random
								.nextInt() % 4 << 10));
						lspr.var_8ac[k][1] = ((short) (E_MainCanvas.random
								.nextInt() % 4 << 10));
					} else {
						lspr.var_8ac[k][0] = ((short) (Math
								.abs(E_MainCanvas.random.nextInt()) % 8192 + -4096));
						lspr.var_8ac[k][1] = ((short) (Math
								.abs(E_MainCanvas.random.nextInt()) % 4096 + -2048));
					}
					lspr.var_8bc[k] = ((byte) (Math
							.abs(E_MainCanvas.random.nextInt()) % 2 + 1));
				}
			}
		}
		lspr.var_814 = paramByte;
		lspr.var_81c = paramInt4;
		lspr.mapFrameTime = paramInt5;
		lspr.var_834 = paramInt1;
		lspr.var_83c = paramInt2;
		lspr.var_844 = paramInt3;
		lspr.var_854 = true;
		return lspr;
	}

	//@todo override? what is this code about
	public void spriteUpdate() {
		if (this.var_84c) {
			this.frameTime += 50;
			if (this.var_864 >= 0) {
				this.var_864 -= 1;
			}
			switch (this.var_814) {
			case 2:
			case 4:
				sub_19ce();
				return;
			case 3:
				setSpritePosition(this.posX + this.var_834, this.posY
						+ this.var_83c);
				return;
			case 6:
				this.currentFrameIndex = ((this.currentFrameIndex + 1) % 2);
				if (this.frameTime >= this.mapFrameTime) {
					this.var_84c = false;
					return;
				}
				break;
			case 5:
				if (this.var_81c == -1) {
					setSpritePosition(this.posX + this.var_834, this.posY);
					this.var_80c += this.var_844;
					if (this.var_80c >= 0) {
						this.var_80c = 0;
						this.var_844 = (-this.var_844 / 2);
						if (this.var_844 == 0) {
							this.var_81c = 1;
							this.frameTime = 0;
						}
					} else {
						this.var_844 += 1;
					}
				} else if (this.frameTime >= 400) {
					this.var_84c = false;
					return;
				}
				break;
			default:
				setSpritePosition(this.posX + this.var_834, this.posY
						+ this.var_83c);
				this.var_80c += this.var_844;
				if ((this.var_81c != 0) && (this.frameTime >= this.mapFrameTime)) {
					nextFrame();
					if ((this.var_814 == 0) && (this.currentFrameIndex == 0)
							&& (this.var_81c > 0)) {
						this.var_81c -= 1;
						if (this.var_81c <= 0) {
							setCurrentFrameIndex(getFrameSequenceLength() - 1);
							if (this.var_854) {
								this.var_84c = false;
							}
						}
					}
					this.frameTime = 0;
				}
				break;
			}
		}
	}

	public final void sub_19ce() {
		if (this.var_814 != 4) {
			this.yellowColor += -263168;
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
		if (this.frameTime >= this.mapFrameTime) {
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