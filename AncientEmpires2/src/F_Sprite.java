import java.io.InputStream;

import javax.microedition.lcdui.Graphics;

public class F_Sprite {
	
	public H_ImageExt[] frameImages;
	private byte[] frameSequence;
	public int currentFrameIndex = 0;
	public int posXPixel = 0;
	public int posYPixel = 0;
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
	public boolean isUpdatingMb = true;
	public boolean var_854;
	public boolean var_85c;
	public int var_864 = -1;
	public byte var_86c = -1;
	public boolean var_874;
	public int var_87c;
	public String spriteString;
	public int charFontId;
	public F_Sprite kingHeadSprite;
	public F_Sprite kingBackSprite;
	public int[][] var_8a4;
	public short[][] var_8ac;
	public int someColor = 16769024; //#FFE000 yellow
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
		int length = (byte)stream.read();
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
		} catch (Exception ex) {
			try {
				for (int it = 0; it < length; it++) {
					StringBuffer tileName = new StringBuffer(spriteId);
					tileName.append('_');
					if (it < 10) {
						tileName.append('0');
					}
					tileName.append(it);
					if (paramInt == 1) {
						images[it] = new H_ImageExt(
								tileName.toString());
					} else {
						images[it] = new H_ImageExt(
								tileName.toString(), paramInt);
					}
				}
			} catch (Exception ex2) {
				//
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
		int animationsCount = stream.read();
		if (animationsCount > 0) {
			this.frameAnimationsSequences = new byte[animationsCount][];
			this.mapFrameTime = (stream.read() * 50);
			for (int animId = 0; animId < animationsCount; animId++) {
				int animLength = stream.read();
				this.frameAnimationsSequences[animId] = new byte[animLength];
				for (int it = 0; it < animLength; it++) {
					this.frameAnimationsSequences[animId][it] = ((byte) stream.read());
				}
			}
		}
		for (int n1 = 0; n1 < length; n1++) {
			byte iX = (byte) stream.read();
			byte iY = (byte) stream.read();
			if ((iX == -1) || (iY == -1)) {
				break;
			}
			this.frameImages[n1].translateImage(iX, iY);
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
		this.posXPixel = sprite.posXPixel;
		this.posYPixel = sprite.posYPixel;
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
		this.posXPixel = ((short) pX);
		this.posYPixel = ((short) pY);
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

	public final void drawFrameAt(Graphics gr, int frameIndex,
			int inX, int inY, int paramInt4) {
		if ((this.var_814 == 2) || (this.var_814 == 4) || (this.var_814 == 3)) {
			onSpritePaint(gr, inX, inY);
			return;
		}
		if (this.var_7ec) {
			int x = this.posXPixel + inX;
			int y = this.posYPixel + inY;
			this.frameImages[frameIndex].drawImageExt(gr, x, y, paramInt4);
		}
	}

	public final void drawCurrentFrame(Graphics gr, int inX,
			int inY, int paramInt3) {
		drawFrameAt(gr, this.frameSequence[this.currentFrameIndex], inX,
				inY, paramInt3);
	}

	

	public static final F_Sprite sub_15c2(String str, int paramInt1,
			int paramInt2, byte charId) {
		int strWidth = E_MainCanvas.getCharedStringWidth(charId, str);
		int strHeight = E_MainCanvas.getCharedStringHeight(charId);
		F_Sprite sprite = new F_Sprite(strWidth, strHeight);
		sprite.charFontId = charId;
		sprite.spriteString = str;
		sprite.var_834 = paramInt1;
		sprite.var_844 = paramInt2;
		sprite.var_814 = 5;
		return sprite;
	}

	public static final F_Sprite someSpriteCopy(F_Sprite sprite,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			int frameTime, byte paramByte) {
		F_Sprite lspr = null;
		if (sprite != null) {
			lspr = new F_Sprite(sprite);
		} else {
			lspr = new F_Sprite(0, 0);
			if ((paramByte == 2) || (paramByte == 4)) {
				if (paramByte == 4) {
					lspr.someColor = 15658751;
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
		lspr.mapFrameTime = frameTime;
		lspr.var_834 = paramInt1;
		lspr.var_83c = paramInt2;
		lspr.var_844 = paramInt3;
		lspr.var_854 = true;
		return lspr;
	}

	public final void sub_19ce() {
		if (this.var_814 != 4) {
			this.someColor += -263168;
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
			this.isUpdatingMb = false;
		}
	}
	
	//@Virtual
	public void spriteUpdate() {
		if (this.isUpdatingMb) {
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
				setSpritePosition(this.posXPixel + this.var_834, this.posYPixel
						+ this.var_83c);
				return;
			case 6:
				this.currentFrameIndex = ((this.currentFrameIndex + 1) % 2);
				if (this.frameTime >= this.mapFrameTime) {
					this.isUpdatingMb = false;
					return;
				}
				break;
			case 5:
				if (this.var_81c == -1) {
					setSpritePosition(this.posXPixel + this.var_834, this.posYPixel);
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
					this.isUpdatingMb = false;
					return;
				}
				break;
			default:
				setSpritePosition(this.posXPixel + this.var_834, this.posYPixel
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
								this.isUpdatingMb = false;
							}
						}
					}
					this.frameTime = 0;
				}
				break;
			}
		}
	}

	//@Virtual
	public void onSpritePaint(Graphics gr, int inX, int inY) {
		int k = 0;
		if ((this.var_814 == 2) || (this.var_814 == 4)) {
			gr.setColor(this.someColor);
			k = 0;
		}
		
		//@todo !!! this was fatal for all units!
		/*
		while (k < 5) {
			int x;
			int y;
			if (this.var_8c4[k] != false) {
				x = (this.var_8a4[k][0] >> 10) + inX + this.posXPixel;
				y = (this.var_8a4[k][1] >> 10) + inY + this.posYPixel;
				gr.fillRect(x, y, this.var_8bc[k], this.var_8bc[k]);
			}
			k++;
		}*/
		
		if (this.var_814 == 6) {
			int x = 0;
			if (this.currentFrameIndex == 0) {
				gr.setColor(15718144); // #EFD700 sand yellow
			} else {
				gr.setColor(16777215); // white
			}
			if (this.var_834 > 0) {
				int y = this.posXPixel + 15;
				gr.fillArc(this.posXPixel, this.posYPixel - 15, 30,
						30, 0, 360);
				gr.fillRect(y, this.posYPixel - 15,
						E_MainCanvas.canvasWidth - y, 30);
				return;
			}
			gr.fillArc(this.posXPixel - 30, this.posYPixel - 15, 30,
					30, 0, 360);
			gr.fillRect(0, this.posYPixel - 15, this.posXPixel - 15,
					30);
			return;
		}
		if (this.var_814 == 3) {
			gr.setColor(0); //black
			if (this.var_834 > 0) {
				gr.drawLine(this.posXPixel, this.posYPixel,
						this.posXPixel + 4, this.posYPixel - 2);
				return;
			}
			gr.drawLine(this.posXPixel - 4, this.posYPixel - 2,
					this.posXPixel, this.posYPixel);
			return;
		}
		if (this.var_7ec) {
			int x = this.posXPixel + inX;
			int y = this.posYPixel + inY;
			if (this.spriteString != null) {
				E_MainCanvas.drawCharedString(gr, this.spriteString, x, y,
						this.charFontId, 33);
				return;
			}
			if (this.var_864 > 0) {
				x += E_MainCanvas.getRandomWithin(-4, 5);
				y += E_MainCanvas.getRandomWithin(-1, 2);
			}
			k = this.frameSequence[this.currentFrameIndex];
			this.frameImages[k].drawImageExt(gr, x, y);
			if (this.kingHeadSprite != null) {
				int m = k % (getFramesCount() / 2);
				F_Sprite sprite;
				if (m == 2) {
					sprite = this.kingBackSprite;
				} else {
					sprite = this.kingHeadSprite;
					sprite.setCurrentFrameIndex(m);
				}
				sprite.onSpritePaint(gr, x, y);
			}
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