import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public final class D_Menu extends A_MenuBase {
	
	public boolean[] var_fb5 = { false, false };
	public int var_fbd = 13553358; //#CECECE light gray
	public static final int var_fc5 = E_MainCanvas.canvasHeight <= 143 ? 1 : 2;
	public static final int var_fcd = var_fc5 * 2 + 1;
	public byte var_fd5 = 2;
	public short var_fdd = 3;
	public static I_Game gameVar;
	public String[] var_fed;
	public H_ImageExt[] var_ff5;
	public int var_ffd;
	public int var_1005;
	public int var_100d;
	public int var_1015;
	public int var_101d;
	public Font var_1025 = E_MainCanvas.font8;
	public int var_102d;
	public int var_1035;
	public int var_103d;
	public int var_1045;
	public int var_104d;
	public int var_1055;
	public byte var_105d;
	public int var_1065;
	public boolean var_106d = false;
	public boolean var_1075 = false;
	public C_Unit[] var_107d;
	public int var_1085;
	public int var_108d;
	public byte var_1095 = -1;
	public int var_109d;
	public int var_10a5;
	public int var_10ad;
	public int var_10b5;
	public String[] var_10bd;
	public int var_10c5 = -1;
	public boolean var_10cd = true;
	public int var_10d5;
	public C_Unit var_10dd;
	public boolean var_10e5 = true;
	public A_MenuBase parentMenu;
	public int var_10f5;
	public F_Sprite[] var_10fd;
	public int var_1105;
	public boolean var_110d = false;
	public Vector var_1115;
	public int var_111d = -1;
	public boolean var_1125;
	public boolean var_112d;
	public int var_1135;
	public int var_113d;
	public int var_1145;
	public int var_114d;
	public byte[][] var_1155;
	public Vector var_115d;
	public int var_1165;
	public int var_116d;
	public int var_1175 = 2370117;
	public int var_117d = 2370117;
	public H_ImageExt var_1185;
	public D_Menu var_118d;
	public int[] var_1195;
	public int var_119d;
	public int var_11a5;
	public int[] var_11ad;
	public int var_11b5;
	public int var_11bd = -1;
	public short[] var_11c5;
	public int var_11cd;
	public int var_11d5;
	public int var_11dd;
	public int var_11e5;
	public int var_11ed;
	public int var_11f5;
	public int var_11fd;
	public int var_1205;
	public int var_120d;
	public int var_1215;
	public byte var_121d;
	public F_Sprite var_1225;

	public final void sub_1245() {
		this.var_1205 = 0;
		if (this.var_10fd != null) {
			sub_1e13();
		}
		this.var_1105 = 4;
		this.var_106d = true;
		this.var_1075 = true;
		if (gameVar != null) {
			gameVar.sub_4d3f();
		}
		if (this.var_118d != null) {
			this.var_118d.var_106d = true;
		}
		if (this.var_105d == 15) {
			for (int i = 0; i < this.var_1115.size(); i++) {
				D_Menu localClass_d_023;
				(localClass_d_023 = (D_Menu) this.var_1115.elementAt(i))
						.sub_1245();
				localClass_d_023.var_1075 = false;
			}
		}
	}

	public final void sub_1301(byte paramByte, boolean paramBoolean) {
		this.var_fb5[paramByte] = paramBoolean;
	}

	public final void sub_1323(A_MenuBase paramClass_a_000) {
		this.parentMenu = paramClass_a_000;
		this.var_fb5[1] = (paramClass_a_000 != null ? true : false);
	}

	public D_Menu(byte paramByte, int paramInt) {
		this.var_105d = paramByte;
		this.var_1065 = paramInt;
		if (paramByte == 15) {
			this.var_11b5 = (gameVar.var_32d3 - gameVar.buttonsSprite.frameHeight);
			this.var_10cd = true;
		} else if ((paramByte == 0) || (paramByte == 11)) {
			this.var_fb5[0] = true;
			this.var_fb5[1] = true;
		} else if (paramByte == 3) {
			this.var_1225 = gameVar.bigCircleSprite;
			sub_1dac();
			this.var_10cd = false;
			this.var_1125 = true;
			this.var_1085 = (E_MainCanvas.var_138c - E_MainCanvas.font8BaselinePos);
			this.var_100d = gameVar.var_32cb;
			this.var_1015 = (gameVar.bigCircleSprite.frameHeight + var_fcd);
			if ((paramInt & 0x2) == 0) {
				this.var_1015 += 5;
			}
			this.var_107d = C_Unit.sub_240e(gameVar.var_357b);
			this.var_1035 = this.var_107d.length;
			int j = this.var_100d - gameVar.sideArrowSprite.frameWidth * 2;
			if ((paramInt & 0x4) == 0) {
				j -= 8;
			}
			if ((paramInt & 0x8) == 0) {
				j -= 8;
			}
			this.var_10a5 = (j / (gameVar.bigCircleSprite.frameWidth + 3));
			if (this.var_10a5 > this.var_1035) {
				this.var_10a5 = this.var_1035;
			}
			this.var_101d = (j / this.var_10a5);
			this.var_10f5 = ((j - this.var_101d * this.var_10a5) / 2);
			this.var_fd5 = 2;
		} else if ((paramByte == 2) || (paramByte == 5)) {
			this.var_10cd = false;
			this.var_1015 = (5 + var_fc5 + 24 + var_fcd
					+ gameVar.smallCircleSprite.frameHeight * 2 + var_fc5 + var_fc5 + 1);
			if (paramByte == 5) {
				this.var_1015 += var_fcd + E_MainCanvas.font8BaselinePos;
				this.var_10dd = gameVar.sub_dc52(gameVar.var_34ab,
						gameVar.var_34b3, (byte) 0);
				this.var_102d = this.var_10dd.unitTypeId;
				this.var_100d = gameVar.var_32cb;
			} else {
				this.var_100d = gameVar.var_32cb;
			}
		} else if ((paramByte != 7) && (paramByte == 8)) {
			this.var_fdd = 8;
			this.var_fb5[0] = true;
		}
		this.var_106d = true;
	}

	public final D_Menu sub_165e(String paramString) {
		this.var_118d = new D_Menu((byte) 10, 0);
		this.var_118d.sub_1ceb(null, paramString, gameVar.var_32cb, -1);
		return this.var_118d;
	}

	public final void sub_169b(D_Menu paramClass_d_023, int paramInt1,
			int paramInt2, int paramInt3) {
		if (this.var_1115 == null) {
			this.var_1115 = new Vector();
		}
		if (this.var_11ad == null) {
			this.var_11ad = new int[5];
			for (int i = 0; i < 5; i++) {
				this.var_11ad[i] = this.var_11b5;
				if (i > 0) {
					this.var_11ad[i] -= gameVar.buttonsSprite.frameHeight;
				}
			}
		}
		paramClass_d_023.sub_193f(paramInt1, paramInt2, paramInt3);
		int i = paramClass_d_023.var_1005;
		for (int j = 0; j < 5; j++) {
			if (i < this.var_11ad[j]) {
				if (i + paramClass_d_023.var_1015 <= this.var_11ad[j]) {
					break;
				}
				this.var_11ad[j] = i;
				if (j + 1 <= this.var_11a5) {
					break;
				}
				this.var_11a5 = (j + 1);
				break;
			}
			i -= this.var_11ad[j];
		}
		paramClass_d_023.sub_1301((byte) 0, false);
		paramClass_d_023.sub_1301((byte) 1, false);
		this.var_1115.addElement(paramClass_d_023);
	}

	public final void sub_17fa(int paramInt1, int paramInt2,
			byte[][] paramArrayOfByte, Vector paramVector) {
		this.var_1065 = 15;
		this.var_1155 = paramArrayOfByte;
		this.var_115d = paramVector;
		this.var_fdd = 8;
		this.var_fb5[0] = true;
		this.var_10cd = true;
		this.var_1165 = paramArrayOfByte.length;
		this.var_116d = paramArrayOfByte[0].length;
		this.var_100d = (this.var_1165 * gameVar.smallTilesImages[0].imageWidth + 8);
		this.var_1015 = (this.var_116d * gameVar.smallTilesImages[0].imageHeight + 8);
		int j;
		if (this.var_100d > paramInt1) {
			j = gameVar.smallTilesImages[0].imageWidth;
			this.var_1145 = ((paramInt1 - 8) / j);
			this.var_100d = (j * this.var_1145 + 8);
		} else {
			this.var_1145 = this.var_1165;
		}
		if (this.var_1015 > paramInt2) {
			j = gameVar.smallTilesImages[0].imageHeight;
			this.var_114d = ((paramInt2 - 8) / j);
			this.var_1015 = (j * this.var_114d + 8);
		} else {
			this.var_114d = this.var_116d;
		}
		this.var_105d = 8;
	}

	public final void sub_193f(int paramInt1, int paramInt2, int paramInt3) {
		this.var_ffd = paramInt1;
		this.var_1005 = paramInt2;
		if ((paramInt3 & 0x1) != 0) {
			this.var_ffd -= (this.var_100d >> 1);
		} else if ((paramInt3 & 0x8) != 0) {
			this.var_ffd -= this.var_100d;
		}
		if ((paramInt3 & 0x2) != 0) {
			this.var_1005 -= (this.var_1015 >> 1);
		} else if ((paramInt3 & 0x20) != 0) {
			this.var_1005 -= this.var_1015;
		}
		this.var_104d = this.var_ffd;
		this.var_1055 = this.var_1005;
	}

	public final void sub_1a04(String paramString, int paramInt1,
			int paramInt2, byte paramByte1, byte paramByte2) {
		this.var_1095 = paramByte1;
		if (paramByte1 == -1) {
			this.var_1065 = 14;
		} else {
			this.var_10ad = (gameVar.portraitsSprite.frameWidth - 8);
		}
		int i = paramInt1 - this.var_10ad - 16;
		this.var_fed = A_MenuBase
				.sub_8c0(paramString, i, E_MainCanvas.font8);
		sub_1a9a(null, this.var_fed, paramInt1, paramInt2);
		this.var_110d = false;
		this.var_105d = 7;
	}

	public final void sub_1a9a(String paramString, String[] paramArrayOfString,
			int paramInt1, int paramInt2) {
		this.var_10cd = false;
		this.var_100d = paramInt1;
		this.var_1015 = paramInt2;
		this.var_1035 = paramArrayOfString.length;
		this.var_102d = 0;
		this.var_109d = 0;
		this.var_10b5 = 0;
		this.var_110d = false;
		int i = paramInt1 - this.var_10ad - 16;
		if (paramString != null) {
			this.var_10bd = A_MenuBase.sub_8c0(paramString, i,
					E_MainCanvas.font8);
		}
		this.var_fed = paramArrayOfString;
		this.var_101d = E_MainCanvas.var_138c;
		this.var_1085 = (E_MainCanvas.var_138c - E_MainCanvas.font8BaselinePos);
		this.var_108d = (this.var_1085 / 2);
		int j;
		if (paramInt2 <= 0) {
			j = this.someCanHeight;
		} else {
			j = paramInt2;
		}
		if ((this.var_1065 & 0x1) == 0) {
			j -= 5;
		}
		if ((this.var_1065 & 0x2) == 0) {
			j -= 5;
		}
		if (paramString != null) {
			j -= this.var_10bd.length * this.var_101d;
		}
		this.var_10a5 = ((j - 2) / this.var_101d);
		if (this.var_10a5 > this.var_fed.length) {
			this.var_10a5 = this.var_fed.length;
		} else if (this.var_10a5 < this.var_fed.length) {
			this.var_110d = true;
		}
		if (paramInt2 < 0) {
			if (this.var_10bd != null) {
				this.var_1015 = (this.var_10bd.length * this.var_101d);
			}
			this.var_1015 += this.var_10a5 * this.var_101d;
			if ((this.var_1065 & 0x1) == 0) {
				this.var_1015 += 5;
			}
			if ((this.var_1065 & 0x2) == 0) {
				this.var_1015 += 5;
			}
		} else {
			this.var_10f5 = ((j - this.var_10a5 * this.var_101d) / 2);
		}
		this.var_105d = 10;
		this.var_fd5 = 2;
	}

	public final void sub_1ceb(String paramString1, String paramString2,
			int paramInt1, int paramInt2) {
		int i = paramInt1 - this.var_10ad;
		if ((this.var_1065 & 0x4) == 0) {
			i -= 8;
		}
		if ((this.var_1065 & 0x8) == 0) {
			i -= 8;
		}
		this.var_fed = A_MenuBase.sub_8c0(paramString2, i,
				E_MainCanvas.font8);
		sub_1a9a(paramString1, this.var_fed, paramInt1, paramInt2);
		if (this.var_110d) {
			i -= gameVar.arrowSprite.frameWidth;
			this.var_fed = A_MenuBase.sub_8c0(paramString2, i,
					E_MainCanvas.font8);
			sub_1a9a(paramString1, this.var_fed, paramInt1, paramInt2);
		}
	}

	private final void sub_1dac() {
		this.var_10fd = new F_Sprite[3];
		for (int i = 0; i < this.var_10fd.length; i++) {
			this.var_10fd[i] = new F_Sprite(gameVar.smallSparkSprite);
		}
		sub_1e13();
	}

	public final void sub_1e13() {
		for (int i = 0; i < this.var_10fd.length; i++) {
			this.var_10fd[i].var_7ec = true;
			this.var_10fd[i].setSpritePosition(
					E_MainCanvas.sub_1544(this.var_1225.frameWidth),
					E_MainCanvas.sub_1544(this.var_1225.frameHeight));
			this.var_10fd[i].setCurrentFrameIndex(E_MainCanvas.sub_1544(this.var_10fd[i]
					.getFramesCount()));
		}
	}

	public final void sub_1e97(String[] paramArrayOfString,
			H_ImageExt[] paramArrayOfClass_h_017, int paramInt1,
			int paramInt2, int paramInt3) {
		this.var_1065 = 15;
		this.var_fed = paramArrayOfString;
		this.var_ff5 = paramArrayOfClass_h_017;
		this.var_1035 = this.var_fed.length;
		this.var_100d = 0;
		for (int i = 0; i < this.var_1035; i++) {
			int j;
			if ((j = E_MainCanvas.font8.stringWidth(this.var_fed[i])) > this.var_100d) {
				this.var_100d = j;
			}
		}
		this.var_1085 = (E_MainCanvas.var_138c - E_MainCanvas.font8BaselinePos);
		this.var_108d = (this.var_1085 / 2);
		this.var_120d = gameVar.smallCircleSprite.frameWidth;
		this.var_101d = (this.var_120d + this.var_1085);
		this.var_100d += this.var_1035 * this.var_101d;
		this.var_100d += 32;
		if (this.var_100d > this.someCanWidth) {
			this.var_100d = this.someCanWidth;
		}
		this.var_1015 = this.var_120d;
		sub_193f(paramInt1, paramInt2, paramInt3);
		this.var_105d = 13;
		this.var_fd5 = 2;
	}

	public final void sub_1fcf(String[] paramArrayOfString, int paramInt1,
			int paramInt2) {
		this.var_fed = paramArrayOfString;
		this.var_1035 = this.var_fed.length;
		this.var_1125 = true;
		this.var_10cd = false;
		this.var_1015 = paramInt2;
		int i = 0;
		for (int j = 0; j < this.var_fed.length; j++) {
			int k;
			if ((k = E_MainCanvas.font8.stringWidth(this.var_fed[j])) > i) {
				i = k;
			}
		}
		this.var_100d = (i + 16 + gameVar.sideArrowSprite.frameWidth * 2);
		if (this.var_100d < paramInt1) {
			this.var_100d = paramInt1;
		}
		if (this.var_1015 < 0) {
			this.var_1015 = E_MainCanvas.var_138c;
			if (gameVar.sideArrowSprite.frameHeight > this.var_1015) {
				this.var_1015 = gameVar.sideArrowSprite.frameHeight;
			}
			if ((this.var_1065 & 0x1) == 0) {
				this.var_1015 += 5;
			}
			if ((this.var_1065 & 0x2) == 0) {
				this.var_1015 += 5;
			}
		}
		this.var_105d = 14;
		this.var_fd5 = 2;
	}

	public final void sub_212d(String[] paramArrayOfString, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5,
			int paramInt6) {
		this.var_fed = paramArrayOfString;
		this.var_1035 = this.var_fed.length;
		this.var_1085 = (E_MainCanvas.var_138c - E_MainCanvas.font8BaselinePos);
		this.var_101d = E_MainCanvas.var_138c;
		int i = 0;
		for (int j = 0; j < this.var_fed.length; j++) {
			int k;
			if ((k = E_MainCanvas.font8.stringWidth(this.var_fed[j])) > i) {
				i = k;
			}
		}
		this.var_100d = (i + 4 + 16);
		if (this.var_100d > this.someCanWidth) {
			this.var_100d = this.someCanWidth;
		} else if (this.var_100d < paramInt3) {
			if (paramInt6 == 4) {
				this.var_11bd = ((paramInt3 - this.var_100d) / 2);
			}
			this.var_100d = paramInt3;
		}
		this.var_1015 = (this.var_101d * this.var_fed.length + this.var_1085 + 16);
		if (this.var_1015 > paramInt4) {
			this.var_1015 = paramInt4;
		}
		sub_1a9a(null, this.var_fed, this.var_100d, this.var_1015);
		if ((this.var_100d < this.someCanWidth) && (this.var_110d)) {
			this.var_100d += gameVar.arrowSprite.frameWidth;
		}
		this.var_105d = 11;
		sub_193f(paramInt1, paramInt2, paramInt5);
	}

	public final void sub_22eb(String[] paramArrayOfString,
			H_ImageExt[] paramArrayOfClass_h_017, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
		this.var_121d = paramByte;
		this.var_fed = paramArrayOfString;
		this.var_ff5 = paramArrayOfClass_h_017;
		this.var_1035 = this.var_fed.length;
		if (paramByte == 1) {
			this.var_1225 = gameVar.bigCircleSprite;
		} else if (paramByte == 2) {
			this.var_1225 = gameVar.smallCircleSprite;
			if (this.var_1035 < 4) {
				String[] arrayOfString = new String[4];
				System.arraycopy(this.var_fed, 0, arrayOfString, 0,
						this.var_1035);
				this.var_fed = arrayOfString;
				this.var_1035 = 4;
			}
		}
		this.var_1085 = (E_MainCanvas.var_138c - E_MainCanvas.font8BaselinePos);
		this.var_1065 = 15;
		this.var_120d = this.var_1225.frameWidth;
		this.var_1215 = (this.var_120d >> 1);
		sub_1dac();
		this.var_11c5 = new short[this.var_1035];
		this.var_11f5 = (360 / this.var_1035);
		this.var_11ed = (this.var_11f5 / 2);
		this.var_11e5 = this.var_11ed;
		for (int i = 0; i < this.var_1035; i++) {
			this.var_11c5[i] = ((short) (this.var_11f5 * i));
		}
		if (this.var_1035 == 1) {
			this.var_11d5 = 0;
		} else if (paramInt3 <= 0) {
			this.var_11d5 = ((this.var_1225.frameWidth << 10) / (2 * A_MenuBase
					.sub_f9b(45)));
			this.var_11dd = (this.var_11d5 + this.var_1225.frameWidth / 2);
			paramInt3 = this.var_11dd * 2 + E_MainCanvas.var_138c + 2;
		} else {
			int i = (this.var_1225.frameWidth << 10)
					/ A_MenuBase.sub_f9b(this.var_11f5 / 2)
					+ this.var_1225.frameHeight / 2;
			this.var_11dd = ((paramInt3 - E_MainCanvas.var_138c) / 2 - 2);
			if (this.var_11dd > i) {
				this.var_11dd = i;
			}
			this.var_11d5 = (this.var_11dd - this.var_1225.frameHeight / 2);
		}
		this.var_11cd = 0;
		this.var_100d = (this.var_11dd * 2);
		this.var_1015 = paramInt3;
		this.var_fd5 = 0;
		sub_193f(paramInt1, paramInt2, paramInt4);
	}

	public final int sub_254b(int paramInt) {
		int i;
		int j = i = this.var_111d;
		int k = this.var_1115.size();
		do {
			if ((i += paramInt) < 0) {
				i = k - 1;
			} else if (i >= this.var_1115.size()) {
				if (j < 0) {
					return -1;
				}
				i = 0;
			}
		} while (!((D_Menu) this.var_1115.elementAt(i)).var_1125);
		return i;
	}

	//@Override
	public final void onUpdate() throws Exception {
		sub_2611(true);
	}

	public final void sub_2611(boolean paramBoolean) throws Exception {
		if (this.var_fd5 == 3) {
			return;
		}
		if ((this.var_105d == 10) && (this.var_10c5 > 0)
				&& (this.var_10c5 <= 250)) {
			this.var_1105 += 1;
			this.var_106d = true;
		} else if (this.var_1105 > 0) {
			this.var_1105 -= 1;
			this.var_106d = true;
		}
		int i;
		if ((paramBoolean) && (this.var_fd5 == 2)) {
			i = 0;
			if ((this.var_fb5[0] != false)
					&& ((A_MenuBase.mainCanvas.sub_1f81(I_Game.var_3333)) || (A_MenuBase.mainCanvas
							.sub_1f81(16)))) {
				i = 1;
				A_MenuBase.mainCanvas.sub_20b4(I_Game.var_3333);
				A_MenuBase.mainCanvas.sub_20b4(16);
			}
			if ((this.var_105d == 0) || (this.var_105d == 3)) {
				for (int j = 0; j < this.var_10fd.length; j++) {
					if (this.var_10fd[j].currentFrameIndex == this.var_10fd[j].getFramesCount() - 1) {
						if (this.var_1205 == 0) {
							this.var_10fd[j].setSpritePosition(
									E_MainCanvas.sub_1544(this.var_1225.frameWidth
											- this.var_10fd[j].frameWidth),
									E_MainCanvas.sub_1544(this.var_1225.frameHeight
											- this.var_10fd[j].frameHeight));
						} else {
							this.var_10fd[j].var_7ec = false;
						}
					}
					this.var_10fd[j].nextFrame();
				}
				this.var_106d = true;
			}
			int k;
			if (this.var_105d == 15) {
				if ((!this.var_112d) && (this.var_111d >= 0)) {
					D_Menu localClass_d_0231;
					int m;
					int n;
					if (A_MenuBase.mainCanvas.sub_1f81(1)) {
						((D_Menu) this.var_1115.elementAt(this.var_111d)).var_106d = true;
						this.var_111d = sub_254b(-1);
						(localClass_d_0231 = (D_Menu) this.var_1115
								.elementAt(this.var_111d)).var_106d = true;
						m = localClass_d_0231.var_1005;
						for (n = 0; n < 5; n++) {
							if (m < this.var_11ad[n]) {
								if (this.var_119d == n) {
									break;
								}
								sub_1245();
								this.var_119d = n;
								break;
							}
							m -= this.var_11ad[n];
						}
					}
					if (A_MenuBase.mainCanvas.sub_1f81(2)) {
						((D_Menu) this.var_1115.elementAt(this.var_111d)).var_106d = true;
						this.var_111d = sub_254b(1);
						(localClass_d_0231 = (D_Menu) this.var_1115
								.elementAt(this.var_111d)).var_106d = true;
						m = localClass_d_0231.var_1005;
						for (n = 0; n < 5; n++) {
							if (m < this.var_11ad[n]) {
								if (this.var_119d == n) {
									break;
								}
								sub_1245();
								this.var_119d = n;
								break;
							}
							m -= this.var_11ad[n];
						}
					}
				}
				if (i != 0) {
					gameVar.sub_6260(this, this.var_111d, "", (byte) 0);
					return;
				}
				for (k = 0; k < this.var_1115.size(); k++) {
					D_Menu localClass_d_0232 = (D_Menu) this.var_1115
							.elementAt(k);
					if (this.var_112d) {
						localClass_d_0232.sub_2611(true);
					} else {
						localClass_d_0232.sub_2611(k == this.var_111d);
					}
				}
				this.var_106d = true;
			} else if (this.var_105d == 0) {
				if (this.var_fd5 == 2) {
					this.var_106d = true;
					if (A_MenuBase.mainCanvas.sub_1f81(4)) {
						this.var_1205 -= this.var_11f5;
						this.var_11fd += this.var_11f5;
						this.var_102d -= 1;
						if (this.var_102d < 0) {
							this.var_102d = (this.var_1035 - 1);
						}
					} else if (A_MenuBase.mainCanvas.sub_1f81(8)) {
						this.var_1205 += this.var_11f5;
						this.var_11fd -= this.var_11f5;
						if (this.var_11fd < 0) {
							this.var_11fd += 360;
						}
						this.var_102d += 1;
						if (this.var_102d >= this.var_1035) {
							this.var_102d = 0;
						}
					}
					if (this.var_1205 != 0) {
						if ((k = -this.var_1205 / 2) == 0) {
							this.var_1205 = 0;
						} else {
							this.var_1205 += k;
						}
						if (this.var_1205 == 0) {
							sub_1e13();
						}
					} else if (A_MenuBase.mainCanvas.sub_2032(4)) {
						this.var_1205 -= this.var_11f5;
						this.var_11fd += this.var_11f5;
						this.var_102d -= 1;
						if (this.var_102d < 0) {
							this.var_102d = (this.var_1035 - 1);
						}
					} else if (A_MenuBase.mainCanvas.sub_2032(8)) {
						this.var_1205 += this.var_11f5;
						this.var_11fd -= this.var_11f5;
						if (this.var_11fd < 0) {
							this.var_11fd += 360;
						}
						this.var_102d += 1;
						if (this.var_102d >= this.var_1035) {
							this.var_102d = 0;
						}
					}
					if (i != 0) {
						gameVar.sub_6260(this, this.var_102d,
								this.var_fed[this.var_102d], (byte) 0);
					}
				}
			} else if ((this.var_105d == 13) || (this.var_105d == 14)) {
				if (A_MenuBase.mainCanvas.sub_1f81(4)) {
					this.var_102d -= 1;
					if (this.var_102d < 0) {
						this.var_102d = (this.var_1035 - 1);
					}
					if (this.var_105d == 14) {
						gameVar.sub_6260(this, this.var_102d, null, (byte) 2);
					}
					this.var_106d = true;
				} else if (A_MenuBase.mainCanvas.sub_1f81(8)) {
					this.var_102d += 1;
					if (this.var_102d >= this.var_1035) {
						this.var_102d = 0;
					}
					if (this.var_105d == 14) {
						gameVar.sub_6260(this, this.var_102d, null, (byte) 2);
					}
					this.var_106d = true;
				} else if (i != 0) {
					gameVar.sub_6260(this, this.var_102d,
							this.var_fed[this.var_102d], (byte) 0);
				}
			} else if (this.var_105d == 3) {
				if (this.var_10b5 != 0) {
					if (Math.abs(this.var_10b5) < 2) {
						this.var_10b5 = 0;
					} else {
						this.var_10b5 -= this.var_10b5 / 2;
					}
					this.var_106d = true;
				}
				if (i != 0) {
					gameVar.sub_6260(this, this.var_102d,
							this.var_fed[this.var_102d], (byte) 0);
					return;
				}
				if (A_MenuBase.mainCanvas.sub_1f81(4)) {
					if (this.var_102d < this.var_109d) {
						this.var_102d += this.var_1035;
					}
					this.var_102d -= 1;
					if (this.var_102d < this.var_109d) {
						if (this.var_102d < 0) {
							this.var_102d += this.var_1035;
						}
						this.var_109d = this.var_102d;
						this.var_10b5 = (-this.var_101d);
					}
					this.var_102d %= this.var_1035;
					gameVar.sub_6260(this, this.var_102d, null, (byte) 2);
					sub_1e13();
					this.var_106d = true;
				} else if (A_MenuBase.mainCanvas.sub_1f81(8)) {
					if (this.var_102d < this.var_109d) {
						this.var_102d += this.var_1035;
					}
					this.var_102d += 1;
					if (this.var_102d >= this.var_109d + this.var_10a5) {
						this.var_10b5 = this.var_101d;
						this.var_109d = ((this.var_109d + 1) % this.var_1035);
					}
					this.var_102d %= this.var_1035;
					gameVar.sub_6260(this, this.var_102d, null, (byte) 3);
					sub_1e13();
					this.var_106d = true;
				}
			} else if ((this.var_105d == 10) || (this.var_105d == 7)
					|| (this.var_105d == 11)) {
				if (this.var_10c5 != -1) {
					if (this.var_10c5 > 0) {
						this.var_10c5 -= 50;
					} else {
						A_MenuBase.mainCanvas.showMenu(this.parentMenu);
					}
				}
				if (this.var_10b5 > 0) {
					this.var_10b5 -= this.var_101d / 3 + 1;
					if (this.var_10b5 < 0) {
						this.var_10b5 = 0;
					}
					this.var_106d = true;
				} else if (this.var_10b5 < 0) {
					this.var_10b5 += this.var_101d / 3 + 1;
					if (this.var_10b5 > 0) {
						this.var_10b5 = 0;
					}
					this.var_106d = true;
				}
				if (this.var_10b5 == 0) {
					if (((this.var_105d == 11) || (this.var_105d == 10))
							&& (i != 0)) {
						gameVar.sub_6260(this, this.var_102d,
								this.var_fed[this.var_102d], (byte) 0);
						return;
					}
					if ((this.var_105d != 7)
							&& (A_MenuBase.mainCanvas.sub_1f81(1))) {
						if (this.var_105d == 11) {
							this.var_102d -= 1;
							if (this.var_102d < 0) {
								this.var_102d = (this.var_1035 - 1);
								this.var_109d = (this.var_1035 - this.var_10a5);
								if (this.var_105d == 3) {
									this.var_109d = this.var_102d;
								}
							} else if (this.var_102d < this.var_109d) {
								this.var_10b5 = (-this.var_101d);
								this.var_109d -= 1;
							}
							gameVar.sub_6260(this, this.var_102d, null,
									(byte) 2);
							this.var_106d = true;
						} else if (this.var_109d > 0) {
							this.var_10b5 = (-this.var_101d);
							this.var_109d -= 1;
							this.var_106d = true;
						}
						A_MenuBase.mainCanvas.sub_1f57();
					}
					if ((A_MenuBase.mainCanvas.sub_1f81(2))
							|| ((this.var_105d == 7) && (A_MenuBase.mainCanvas
									.sub_1f81(2048)))) {
						if (this.var_105d == 11) {
							this.var_102d += 1;
							if (this.var_102d >= this.var_1035) {
								this.var_102d = 0;
								this.var_109d = 0;
							} else if (this.var_102d >= this.var_109d
									+ this.var_10a5) {
								this.var_10b5 = this.var_101d;
								this.var_109d += 1;
							}
							gameVar.sub_6260(this, this.var_102d, null,
									(byte) 3);
							this.var_106d = true;
						} else if (this.var_109d + this.var_10a5 < this.var_fed.length) {
							this.var_10b5 = this.var_101d;
							this.var_109d += 1;
							this.var_106d = true;
						} else if (this.var_105d == 7) {
							gameVar.sub_6260(this, 0, null, (byte) 0);
							return;
						}
						A_MenuBase.mainCanvas.sub_1f57();
					}
				}
			} else if (this.var_105d == 8) {
				if (A_MenuBase.mainCanvas.sub_1f81(1)) {
					if (this.var_113d > 0) {
						this.var_113d -= 1;
						this.var_106d = true;
					}
				} else if ((A_MenuBase.mainCanvas.sub_1f81(2))
						&& (this.var_113d + this.var_114d < this.var_116d)) {
					this.var_113d += 1;
					this.var_106d = true;
				}
				if (A_MenuBase.mainCanvas.sub_1f81(4)) {
					if (this.var_1135 > 0) {
						this.var_1135 -= 1;
						this.var_106d = true;
					}
				} else if ((A_MenuBase.mainCanvas.sub_1f81(8))
						&& (this.var_1135 + this.var_1145 < this.var_1165)) {
					this.var_1135 += 1;
					this.var_106d = true;
				}
			}
			if ((this.var_fd5 == 2) && (this.var_fb5[1] != false)
					&& (A_MenuBase.mainCanvas.sub_1f81(I_Game.var_333b))) {
				A_MenuBase.mainCanvas.sub_20b4(I_Game.var_333b);
				A_MenuBase.mainCanvas.sub_1f57();
				if (this.parentMenu != null) {
					A_MenuBase.mainCanvas.showMenu(this.parentMenu);
				}
				if (this.var_fed != null) {
					gameVar.sub_6260(this, this.var_102d,
							this.var_fed[this.var_102d], (byte) 1);
					return;
				}
				gameVar.sub_6260(this, -1, null, (byte) 1);
				return;
			}
		}
		if ((this.var_10cd) && (++this.var_1045 >= this.var_fdd)) {
			if (this.var_103d == 0) {
				this.var_103d = 2;
			} else {
				this.var_103d = 0;
			}
			this.var_1045 = 0;
			this.var_106d = true;
		}
		switch (this.var_fd5) {
		case 0:
			if (this.var_105d == 0) {
				if (this.var_11cd < this.var_11d5) {
					if (this.var_121d == 2) {
						i = this.var_11d5 / 2;
					} else {
						i = this.var_11d5 / 5;
					}
					if (i < 1) {
						i = 1;
					}
					this.var_11cd += i;
					if (this.var_11cd > this.var_11d5) {
						this.var_11cd = this.var_11d5;
					}
				} else {
					this.var_11e5 = (Math.abs(360 - this.var_11c5[0]) / 2);
					if (this.var_11e5 < 1) {
						this.var_11e5 = 1;
					} else if (this.var_11e5 > this.var_11ed) {
						this.var_11e5 = this.var_11ed;
					}
				}
				if (this.var_121d == 1) {
					for (i = 0; i < this.var_11c5.length; i++) {
						this.var_11c5[i] = ((short) ((this.var_11c5[i] + this.var_11e5) % 360));
					}
				}
				if ((A_MenuBase.mainCanvas.sub_1f21())
						|| ((this.var_11cd >= this.var_11d5) && (this.var_11c5[0] == 0))) {
					this.var_11cd = this.var_11d5;
					for (i = 0; i < this.var_11c5.length; i++) {
						this.var_11c5[i] = ((short) (this.var_11f5 * i));
					}
					this.var_fd5 = 2;
					if (this.var_10e5) {
						A_MenuBase.mainCanvas.sub_1f57();
					}
				}
			} else if (this.var_105d == 13) {
				this.var_104d += (this.var_ffd - this.var_104d) / 2;
				this.var_10d5 += 1;
				if (this.var_10d5 == 2) {
					this.var_fd5 = 2;
					this.var_104d = this.var_ffd;
				}
			} else {
				if ((i = (this.var_ffd - this.var_104d) / 4) <= 0) {
					i = 1;
				}
				this.var_104d += i;
				if (this.var_104d == this.var_ffd) {
					this.var_fd5 = 2;
				}
			}
			this.var_106d = true;
			return;
		case 1:
			this.var_fd5 = 3;
		}
	}

	public static final void sub_35f8(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		if (paramInt4 <= 2) {
			paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
			return;
		}
		paramGraphics.fillRect(paramInt1, paramInt2 + 1, paramInt3,
				paramInt4 - 2);
		paramGraphics.fillRect(paramInt1 + 1, paramInt2, paramInt3 - 2,
				paramInt4);
	}

	//@Override
	public final void onPaint(Graphics paramGraphics) {
		sub_3675(paramGraphics, 0, 0, false);
	}

	public final void sub_3675(Graphics paramGraphics, int paramInt1,
			int paramInt2, boolean paramBoolean) {
		if (this.var_fd5 == 3) {
			return;
		}
		if (!this.var_106d) {
			return;
		}
		this.var_106d = false;
		if (((A_MenuBase.mainCanvas.mainDrawElement == this) && (this.var_1075))
				|| (this.var_105d == 0)) {
			gameVar.onPaint(paramGraphics);
		}
		this.var_1075 = false;
		paramGraphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
		if (this.var_118d != null) {
			this.var_118d.onPaint(paramGraphics);
		}
		int i = this.var_104d + paramInt1;
		int j = this.var_1055 + paramInt2;
		int k = 0;
		int m = 0;
		if ((this.var_105d != 0) && (this.var_105d != 13)) {
			sub_562e(paramGraphics, i, j, this.var_100d, this.var_1015,
					this.var_1065, this.var_117d, this.var_1175, this.var_1105,
					5);
			paramGraphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
		}
		k = this.var_100d;
		m = this.var_1015;
		if ((this.var_1065 & 0x1) == 0) {
			m -= 5;
			j += 5;
		}
		if ((this.var_1065 & 0x2) == 0) {
			m -= 5;
		}
		if ((this.var_1065 & 0x4) == 0) {
			i += 8;
			k -= 8;
		}
		if ((this.var_1065 & 0x8) == 0) {
			k -= 8;
		}
		paramGraphics.translate(i, j);
		paramGraphics.setFont(this.var_1025);
		if ((this.var_1185 != null)
				&& ((this.var_fed == null) || (this.var_1025
						.stringWidth(this.var_fed[0]) < k
						- this.var_1185.imageWidth * 2))) {
			this.var_1185.drawImageExt(paramGraphics, 0, m / 2, 6);
		}
		if (paramBoolean) {
			paramGraphics.setColor(5594742);
			sub_35f8(paramGraphics, 0, 0, k, m);
		}
		int i2;
		int i3;
		int i4;
		int n;
		int i1;
		int i5 = 0;
		if (this.var_105d == 0) {
			paramGraphics.setColor(16777215);
			i2 = this.var_11fd + this.var_1205;
			for (i3 = this.var_11c5.length - 1; i3 >= 0; i3--) {
				if ((i4 = (this.var_11c5[i3] + i2) % 360) < 0) {
					i4 += 360;
				}
				n = this.var_11dd
						+ (A_MenuBase.sub_f9b(i4) * this.var_11cd >> 10);
				i1 = E_MainCanvas.var_138c + this.var_11dd + 2
						- (A_MenuBase.sub_fc1(i4) * this.var_11cd >> 10);
				if ((this.var_fd5 == 2) && (i3 == this.var_102d)) {
					this.var_1225.drawFrameAt(paramGraphics, 1, n, i1, 3);
					if (this.var_1205 == 0) {
						i5 = 0;
					}
				} else {
					while (i5 < this.var_10fd.length) {
						this.var_10fd[i5].drawCurrentFrame(paramGraphics, n
								- this.var_1215, i1 - this.var_1215, 20);
						i5++;
						// continue; @todo

						this.var_1225.drawFrameAt(paramGraphics, 0, n, i1, 3);
					}
				}
				if ((this.var_fed[i3] != null) && (this.var_ff5 != null)
						&& (this.var_ff5[i3] != null)) {
					this.var_ff5[i3].drawImageExt(paramGraphics, n, i1, 3);
				}
			}
			if (this.var_fd5 == 2) {
				for (i3 = 0; i3 < this.var_10fd.length; i3++) {
					this.var_10fd[i3].drawCurrentFrame(paramGraphics,
							(this.var_100d - this.var_120d) / 2,
							E_MainCanvas.var_138c, 3);
				}
			}
		}
		int i6;
		int i7;
		int i9;
		int i10;
		int i12;
		int i13;
		int i14;
		int i15;
		int i16;
		int i17;
		int i18;
		int i19;
		int i20;
		int i21 = 0;
		int i22 = 0;
		switch (this.var_105d) {
		case 15:
			i3 = 0;
			i4 = 0;
			i5 = this.var_11ad[0];
			for (i6 = 1; i6 <= this.var_119d; i6++) {
				i3 = i5;
				i5 += this.var_11ad[i6];
			}
			if (this.var_119d > 0) {
				i4 = -i3 + gameVar.buttonsSprite.frameHeight;
			}
			for (i6 = 0; i6 < this.var_1115.size(); i6++) {
				D_Menu localClass_d_023;
				if (((localClass_d_023 = (D_Menu) this.var_1115
						.elementAt(i6)).var_1005 >= i3)
						&& (localClass_d_023.var_1005 < i5)) {
					localClass_d_023.sub_3675(paramGraphics, 0, i4,
							i6 == this.var_111d);
				}
			}
			paramGraphics.setClip(0, 0, gameVar.var_32cb, gameVar.var_32d3);
			if (this.var_119d > 0) {
				paramGraphics.setColor(2370117);
				paramGraphics.fillRect(0, 0, this.someCanWidth,
						gameVar.buttonsSprite.frameHeight);
				gameVar.arrowSprite.drawFrameAt(paramGraphics, 0,
						gameVar.var_32cb / 2, -this.var_103d, 17);
			}
			if (this.var_119d < this.var_11a5) {
				paramGraphics.setColor(2370117);
				i6 = this.var_11ad[this.var_119d];
				if (this.var_119d > 0) {
					i6 += gameVar.buttonsSprite.frameHeight;
				}
				paramGraphics.fillRect(0, i6, this.someCanWidth, gameVar.var_32d3
						- i6);
				gameVar.arrowSprite.drawFrameAt(paramGraphics, 1,
						gameVar.var_32cb / 2, gameVar.var_32d3 + this.var_103d,
						33);
			}
			break;
		case 0:
			if (this.var_fd5 == 2) {
				paramGraphics.setColor(1645370);
				if (this.var_121d == 2) {
					i6 = this.var_100d;
					if (this.var_fed[this.var_102d] != null) {
						i7 = E_MainCanvas.font8
								.stringWidth(this.var_fed[this.var_102d]) + 2;
						if (i6 < i7) {
							i6 = i7;
						}
					}
					sub_35f8(paramGraphics, (this.var_100d - i6) / 2, 1, i6,
							E_MainCanvas.var_138c);
				} else {
					sub_35f8(paramGraphics, 2 - this.var_ffd, 1,
							this.someCanWidth - 4, E_MainCanvas.var_138c);
				}
				if (this.var_fed[this.var_102d] != null) {
					paramGraphics.setColor(16777215);
					E_MainCanvas.drawString(paramGraphics,
							this.var_fed[this.var_102d], this.var_11dd,
							(this.var_1085 >> 1) + 1, 17);
				}
			}
			break;
		case 3:
			paramGraphics.setClip(0, 0, k, m);
			i1 = var_fc5;
			paramGraphics.setColor(11515819);
			paramGraphics.drawLine(var_fc5, i1, k - var_fc5 * 2, i1);
			i1 = i1 += 1 + var_fc5 + gameVar.bigCircleSprite.frameHeight / 2;
			n = gameVar.sideArrowSprite.frameWidth + this.var_10b5 + this.var_10f5;
			i6 = this.var_109d;
			i7 = this.var_109d + this.var_10a5;
			if (this.var_10b5 > 0) {
				i6--;
				n -= this.var_101d;
			} else if (this.var_10b5 < 0) {
				i7++;
			}
			for (int i8 = i6; i8 < i7; i8++) {
				if ((i9 = i8 % this.var_1035) < 0) {
					i9 += this.var_1035;
				}
				i10 = n + this.var_101d / 2;
				if (i9 == this.var_102d) {
					gameVar.bigCircleSprite.drawFrameAt(paramGraphics, 1, i10, i1, 3);
				} else {
					gameVar.bigCircleSprite.drawFrameAt(paramGraphics, 0, i10, i1, 3);
				}
				C_Unit localClass_c_0321 = this.var_107d[i9];
				i12 = i10 - localClass_c_0321.posX
						- localClass_c_0321.frameWidth / 2;
				i13 = i1 - localClass_c_0321.posY
						- localClass_c_0321.frameHeight / 2;
				localClass_c_0321
						.sub_2551(
								paramGraphics,
								i12,
								i13,
								localClass_c_0321.var_b8b > gameVar.var_35a3[gameVar.var_357b]);
				if (i9 == this.var_102d) {
					i14 = i10 - this.var_1225.frameWidth / 2;
					i15 = i1 - this.var_1225.frameWidth / 2;
					for (i16 = 0; i16 < this.var_10fd.length; i16++) {
						this.var_10fd[i16]
								.drawCurrentFrame(paramGraphics, i14, i15, 20);
					}
				}
				n += this.var_101d;
			}
			gameVar.sideArrowSprite.drawFrameAt(paramGraphics, 0, 0, i1, 6);
			gameVar.sideArrowSprite.drawFrameAt(paramGraphics, 1, k, i1, 10);
			break;
		case 2:
		case 5:
			paramGraphics.setClip(0, 0, k, m);
			i6 = var_fc5;
			i7 = E_MainCanvas.charsSprites[0].frameWidth;
			i1 = i6;
			this.var_10dd.sub_252e(paramGraphics, -this.var_10dd.posX + i6,
					-this.var_10dd.posY + i1);
			i2 = i1 + this.var_10dd.frameHeight / 2;
			String str = null;
			paramGraphics.setFont(E_MainCanvas.font8);
			paramGraphics.setColor(this.var_fbd);
			E_MainCanvas.drawString(paramGraphics, this.var_10dd.var_a8b, i6
					+ this.var_10dd.frameWidth + i6,
					i2 - E_MainCanvas.font8BaselinePos / 2, 20);
			if (this.var_105d == 2) {
				str = "" + this.var_10dd.var_b8b;
				gameVar.hudIcons2Sprite.drawFrameAt(paramGraphics, 1, k - i6
						- E_MainCanvas.getCharedStringWidth((byte) 1, str), i2, 10);
			} else {
				str = "" + this.var_10dd.var_b0b;
			}
			E_MainCanvas.drawCharedString(paramGraphics, str, k - i6, i2, 1, 10);
			this.var_1085 = (E_MainCanvas.var_138c - E_MainCanvas.font8BaselinePos);
			i1 += this.var_10dd.frameHeight + var_fc5;
			paramGraphics.setColor(this.var_fbd);
			paramGraphics.drawLine(i6, i1, k - i6 - i6, i1);
			i1 += 1 + var_fc5;
			int i11;
			if (this.var_105d == 5) {
				i9 = E_MainCanvas.font8BaselinePos;
				i2 = i1 + i9 / 2;
				n = i6;
				E_MainCanvas.drawString(paramGraphics, A_MenuBase.getLangString(97), n,
						i1, 20);
				i10 = E_MainCanvas.font8.stringWidth(A_MenuBase.getLangString(97));
				n += i10 + i6;
				i11 = k - n - i6 - gameVar.hudIconsSprite.frameWidth - i7 - i6;
				paramGraphics.setColor(this.var_fbd);
				sub_35f8(paramGraphics, n, i1, i11, i9);
				paramGraphics.setColor(2370117);
				if ((i12 = i11 * this.var_10dd.experience
						/ this.var_10dd.getLevelExpMax()) <= 0) {
					i12 = 1;
				}
				paramGraphics.fillRect(n + 1, i1 + 1, i12, i9 - 2);
				n = k - i6 - i7;
				gameVar.hudIconsSprite.drawFrameAt(paramGraphics, 2, n, i2, 10);
				E_MainCanvas.drawCharedString(paramGraphics, "" + this.var_10dd.level,
						n, i2, 0, 6);
				i1 += i9 + var_fc5;
				paramGraphics.setColor(this.var_fbd);
				paramGraphics.drawLine(i6, i1, k - i6 - i6, i1);
				i1 += 1 + var_fc5;
			}
			i9 = (k - i6 * 3) / 2;
			i10 = gameVar.hudIconsSprite.frameHeight;
			i12 = (i11 = gameVar.smallCircleSprite.frameHeight) / 2;
			for (i14 = 0; i14 < 2; i14++) {
				i13 = i1 + i12 - i10 / 2;
				n = i6;
				for (i15 = 0; i15 < 2; i15++) {
					if ((i14 == 0) || (i15 == 0)) {
						i16 = n + i12;
						sub_35f8(paramGraphics, i16, i13, i9 - i12, i10);
						gameVar.smallCircleSprite.draw(paramGraphics, n, i1);
						if (((i17 = i14 * 2 + i15) == 0) || (i17 == 1)) {
							gameVar.hudIconsSprite.drawFrameAt(paramGraphics, i17, i16,
									i1 + i12, 3);
						}
						i18 = 0;
						if (i17 == 0) {
							if (this.var_105d == 5) {
								i18 = this.var_10dd.sub_e5f(null);
							}
							str = this.var_10dd.var_af3 + i18 + "-"
									+ (this.var_10dd.var_afb + i18);
						} else if (i17 == 1) {
							if (this.var_105d == 5) {
								i18 = this.var_10dd.sub_f43(null);
							}
							str = "" + (this.var_10dd.var_b03 + i18);
						} else if (i17 == 2) {
							gameVar.actionIconsFrames[5].drawImageExt(paramGraphics, i16, i1
									+ i12, 3);
							str = ""
									+ C_Unit.var_b9b[this.var_10dd.unitTypeId];
						}
						E_MainCanvas.drawCharedString(paramGraphics, str, n + i11 + 1,
								i1 + i12, 0, 6);
						if (i18 > 0) {
							gameVar.arrowIconsSprite.drawFrameAt(paramGraphics, 1, i16
									+ i9 - i12 - 1, i1 + i12, 10);
						} else if (i18 < 0) {
							gameVar.arrowIconsSprite.drawFrameAt(paramGraphics, 2, i16
									+ i9 - i12 - 1, i1 + i12, 10);
						}
						n += i9 + var_fc5;
					}
				}
				i1 += i11;
			}
			i1 += var_fc5;
			paramGraphics.setColor(this.var_fbd);
			paramGraphics.drawLine(i6, i1, k - i6 - i6, i1);
			break;
		case 8:
			gameVar.sub_d599(paramGraphics, 0, 0, this.var_100d, this.var_1015);
			i15 = gameVar.smallTilesImages[0].imageWidth;
			i16 = gameVar.smallTilesImages[0].imageHeight;
			i17 = this.var_114d + this.var_113d;
			i18 = this.var_1145 + this.var_1135;
			i1 = 4;
			for (i19 = this.var_113d; i19 < i17; i19++) {
				n = 4;
				for (i20 = this.var_1135; i20 < i18; i20++) {
					i21 = gameVar.tilesProps[this.var_1155[i20][i19]];
					if (this.var_1155[i20][i19] >= gameVar.tilesCount) {
						i22 = (this.var_1155[i20][i19] - gameVar.tilesCount) / 2;
						i21 = 2 * i22 + 8 + i21 - 8;
					}
					gameVar.smallTilesImages[i21].drawImageExt(paramGraphics, n, i1);
					n += i15;
				}
				i1 += i16;
			}
			if ((this.var_115d != null) && (this.var_103d == 0)) {
				i19 = -this.var_1135 * i15 + 4;
				i20 = -this.var_113d * i16 + 4;
				i21 = 0;
				i22 = gameVar.mapSprites.size();
				while (i21 < i22) {
					C_Unit localClass_c_0322;
					if (((localClass_c_0322 = (C_Unit) gameVar.mapSprites
							.elementAt(i21)).positionX >= this.var_1135)
							&& (localClass_c_0322.positionX < i18)
							&& (localClass_c_0322.positionY >= this.var_113d)
							&& (localClass_c_0322.positionY < i17)) {
						gameVar.miniIconsSprite
								.drawFrameAt(
										paramGraphics,
										gameVar.var_356b[localClass_c_0322.var_acb] - 1,
										localClass_c_0322.positionX * i15 + i19,
										localClass_c_0322.positionY * i16 + i20,
										0);
					}
					i21++;
				}
			}
			if (this.var_103d == 0) {
				if (this.var_113d > 0) {
					gameVar.arrowSprite.drawFrameAt(paramGraphics, 0, k / 2, 0, 17);
				}
				if (this.var_113d + this.var_114d < this.var_116d) {
					gameVar.arrowSprite.drawFrameAt(paramGraphics, 1, k / 2, m, 33);
				}
				if (this.var_1135 > 0) {
					gameVar.sideArrowSprite.drawFrameAt(paramGraphics, 0, 0, m / 2, 6);
				}
				if (this.var_1135 + this.var_1145 < this.var_1165) {
					gameVar.sideArrowSprite.drawFrameAt(paramGraphics, 1, k, m / 2, 10);
				}
			}
			break;
		case 14:
			paramGraphics.setFont(E_MainCanvas.font8);
			paramGraphics.setColor(I_Game.sub_bf33(16777215, 1645370,
					this.var_1105, 5));
			i2 = m / 2;
			E_MainCanvas.drawString(paramGraphics, this.var_fed[this.var_102d],
					k / 2, (m - E_MainCanvas.font8BaselinePos) / 2, 17);
			gameVar.sideArrowSprite.drawFrameAt(paramGraphics, 0, 0, i2, 6);
			gameVar.sideArrowSprite.drawFrameAt(paramGraphics, 1, k, i2, 10);
			break;
		case 13:
			i19 = E_MainCanvas.var_138c;
			i20 = (this.var_1015 - i19) / 2;
			paramGraphics.setColor(I_Game.sub_bf33(1645370, 16777215,
					this.var_1105, 5));
			sub_35f8(paramGraphics, 0, i20, this.var_100d, i19);
			paramGraphics.setFont(E_MainCanvas.font8);
			paramGraphics.setColor(16777215);
			E_MainCanvas.drawString(paramGraphics, this.var_fed[this.var_102d],
					16, i20 + this.var_108d, 20);
			i21 = this.var_100d - this.var_101d;
			i22 = this.var_1035 - 1;
		case 7:
		case 10:
		case 11:
			while (i22 >= 0) {
				if (i22 == this.var_102d) {
					gameVar.smallCircleSprite.drawFrameAt(paramGraphics, 1, i21, 0, 20);
				} else {
					gameVar.smallCircleSprite.drawFrameAt(paramGraphics, 0, i21, 0, 20);
				}
				this.var_ff5[i22].drawImageExt(paramGraphics, i21
						+ gameVar.smallCircleSprite.frameWidth / 2, this.var_1015 / 2, 3);
				i21 -= this.var_101d;
				i22--;
				// continue; //@todo

				paramGraphics.setFont(E_MainCanvas.font8);
				if (this.var_1095 != -1) {
					gameVar.portraitsSprite.drawFrameAt(paramGraphics, this.var_1095, -8,
							m, 36);
				}
				k -= this.var_10ad;
				paramGraphics.setClip(0, 0, k, this.var_1015 - 10);
				i22 = 0;
				i1 = 0;
				if (this.var_10bd != null) {
					paramGraphics.setColor(I_Game.sub_bf33(16777215,
							this.var_117d, this.var_1105, 5));
					for (int i23 = 0; i23 < this.var_10bd.length; i23++) {
						E_MainCanvas.drawString(paramGraphics, this.var_10bd[i23],
								this.var_10ad + k / 2, i1 + this.var_108d, 17);
						i1 += this.var_101d;
					}
					paramGraphics.setColor(10463131);
					paramGraphics.drawLine(0, i1, k - 1, i1);
					i22 = i1;
				}
				int i23 = i1 + this.var_10f5;
				paramGraphics.setColor(this.var_fbd);
				int i24 = this.var_109d;
				int i25 = this.var_109d + this.var_10a5;
				if (this.var_10b5 > 0) {
					i24--;
					i1 -= this.var_101d;
				} else if (this.var_10b5 < 0) {
					i25++;
				}
				i1 += this.var_10b5 + this.var_10f5;
				paramGraphics.setClip(this.var_10ad, i22, k, m - i22);
				int i26 = k;
				if (this.var_110d) {
					i26 -= gameVar.arrowSprite.frameWidth;
				}
				int i27 = this.var_10ad + i26 / 2;
				int i29;
				int i30;
				for (int i28 = i24; i28 < i25; i28++) {
					i29 = 0;
					if (i1 < i23) {
						i29 = i23 - i1;
					} else if (i1 + this.var_101d > m - this.var_10f5) {
						i29 = i1 + this.var_101d - m + this.var_10f5;
					}
					if ((this.var_105d == 11) && (i28 == this.var_102d)) {
						paramGraphics.setColor(5594742);
						sub_35f8(paramGraphics, 0, i1, i26, this.var_101d);
						i30 = I_Game.sub_bf33(this.var_117d, 16777215,
								this.var_101d - i29, this.var_101d);
					} else {
						i30 = I_Game.sub_bf33(this.var_117d, this.var_fbd,
								this.var_101d - i29, this.var_101d);
					}
					i30 = I_Game.sub_bf33(i30, this.var_117d,
							this.var_1105, 5);
					paramGraphics.setColor(i30);
					if (this.var_11bd >= 0) {
						E_MainCanvas.drawString(paramGraphics, this.var_fed[i28],
								this.var_11bd, i1 + this.var_108d, 20);
					} else {
						E_MainCanvas.drawString(paramGraphics, this.var_fed[i28],
								i27, i1 + this.var_108d, 17);
					}
					i1 += this.var_101d;
				}
				int i28;
				if (this.var_110d) {
					i28 = gameVar.arrowSprite.frameHeight;
					i29 = gameVar.arrowSprite.frameWidth;
					i30 = gameVar.arrowSprite.frameWidth / 2;
					int i31 = m - i28 * 2 - 2;
					int i32 = k - (i29 + i30) / 2;
					if (i31 > 2) {
						paramGraphics.setColor(this.var_fbd);
						sub_35f8(paramGraphics, i32, i28 + 1, i30, i31);
						int i33;
						if ((i33 = (i31 - 2) * this.var_10a5 / this.var_1035) < 1) {
							i33 = 1;
						}
						paramGraphics.setColor(2370117);
						sub_35f8(paramGraphics, i32 + 1, i28 + (i31 - 2)
								* this.var_109d / this.var_1035 + 2, i30 - 2,
								i33);
						gameVar.arrowSprite.drawFrameAt(paramGraphics, 0, k - i29, 0,
								20);
						gameVar.arrowSprite.drawFrameAt(paramGraphics, 1, k - i29, m,
								36);
					} else {
						if (this.var_109d > 0) {
							gameVar.arrowSprite.drawFrameAt(paramGraphics, 0,
									k - i29, 0, 20);
						}
						if (this.var_109d + this.var_10a5 < this.var_1035) {
							gameVar.arrowSprite.drawFrameAt(paramGraphics, 1,
									k - i29, m, 36);
						}
					}
				}
				if (this.var_105d == 7) {
					paramGraphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
					i28 = m;
					if ((this.var_1065 & 0x2) == 0) {
						i28 += 5;
					}
					gameVar.arrowSprite.drawFrameAt(paramGraphics, 1, k
							+ this.var_10ad, i28, 40);
				}
			}
		}
		paramGraphics.translate(-i, -j);
		paramGraphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
		if ((A_MenuBase.mainCanvas.mainDrawElement == this) && (this.var_fd5 == 2)) {
			if (this.var_fb5[0] != false) {
				gameVar.sub_dbd9(paramGraphics, I_Game.var_3333, 0,
						gameVar.var_32d3);
			}
			if (this.var_fb5[1] != false) {
				gameVar.sub_dbd9(paramGraphics, I_Game.var_333b, 1,
						gameVar.var_32d3);
			}
		}
	}

	public static final void sub_5602(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
		sub_562e(paramGraphics, paramInt1, paramInt2, paramInt3, paramInt4,
				paramInt5, 2370117, 2370117, 0, 0);
	}

	public static final void sub_562e(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5,
			int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
		F_Sprite localClass_f_045 = gameVar.menuSprite;
		paramGraphics.setClip(paramInt1, paramInt2, paramInt3, paramInt4);
		paramGraphics.setColor(paramInt6);
		paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
		int i;
		int j;
		int m;
		int k;
		if (paramInt7 != paramInt6) {
			i = paramInt4 / 4;
			j = paramInt2 + 5;
			for (m = 0; m < i; m++) {
				k = I_Game.sub_bf33(paramInt7, paramInt6, m, i);
				paramGraphics.setColor(I_Game.sub_bf33(k, paramInt6,
						paramInt8, paramInt9));
				paramGraphics.fillRect(paramInt1, j, paramInt3, 1);
				j++;
			}
		}
		if (paramInt5 != 15) {
			i = (paramInt5 & 0x4) == 0 ? 1 : 0;
			j = (paramInt5 & 0x8) == 0 ? 1 : 0;
			k = (paramInt5 & 0x1) == 0 ? 1 : 0;
			m = (paramInt5 & 0x2) == 0 ? 1 : 0;
			int n = paramInt3 / localClass_f_045.frameWidth - 2;
			if (paramInt3 % localClass_f_045.frameWidth != 0) {
				n++;
			}
			if (i == 0) {
				n++;
			}
			if (j == 0) {
				n++;
			}
			int i1 = paramInt4 / localClass_f_045.frameHeight - 2;
			if (paramInt4 % localClass_f_045.frameHeight != 0) {
				i1++;
			}
			if (k == 0) {
				i1++;
			}
			if (m == 0) {
				i1++;
			}
			int i2 = paramInt1;
			if (i != 0) {
				i2 += localClass_f_045.frameWidth;
			}
			int i3 = paramInt2 + paramInt4 - localClass_f_045.frameHeight;
			for (int i4 = 0; i4 < n; i4++) {
				if (k != 0) {
					localClass_f_045.drawFrameAt(paramGraphics, 1, i2, paramInt2,
							0);
				}
				if (m != 0) {
					localClass_f_045.drawFrameAt(paramGraphics, 6, i2, i3, 0);
				}
				i2 += localClass_f_045.frameWidth;
			}
			int i4 = paramInt2;
			if (k != 0) {
				i4 += localClass_f_045.frameHeight;
			}
			int i5 = paramInt1 + paramInt3 - localClass_f_045.frameWidth;
			for (int i6 = 0; i6 < i1; i6++) {
				if (i != 0) {
					localClass_f_045.drawFrameAt(paramGraphics, 3, paramInt1, i4,
							0);
				}
				if (j != 0) {
					localClass_f_045.drawFrameAt(paramGraphics, 4, i5, i4, 0);
				}
				i4 += localClass_f_045.frameHeight;
			}
			if ((i != 0) && (k != 0)) {
				localClass_f_045.drawFrameAt(paramGraphics, 0, paramInt1,
						paramInt2, 0);
			}
			if ((j != 0) && (k != 0)) {
				localClass_f_045.drawFrameAt(paramGraphics, 2, i5, paramInt2, 0);
			}
			if ((i != 0) && (m != 0)) {
				localClass_f_045.drawFrameAt(paramGraphics, 5, paramInt1, i3, 0);
			}
			if ((j != 0) && (m != 0)) {
				localClass_f_045.drawFrameAt(paramGraphics, 7, i5, i3, 0);
			}
		}
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_d_023
 * 
 * JD-Core Version: 0.7.0.1
 */