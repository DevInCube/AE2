import javax.microedition.lcdui.Graphics;

public final class G_FightAnimation {
	
	public static final String[] var_af5 = { "road", "grass", "woods", "hill",
			"mountain", "water", "bridge", "town" };
	public static final byte[] var_afd = { 0, 1, 1, 1, 4, 5, 6, 7, 7, 7 };
	public static final byte[] var_b05 = { 0, 1, 2, 3, 4, 5, 6, 7, 7, 7 };
	public static final String[] var_b0d = { "soldier", "archer", "lizard",
			"wizard", "wisp", "spider", "golem", "catapult", "wyvern", "king",
			"skeleton" };
	public I_Game var_b15;
	public C_Unit var_b1d;
	public byte var_b25;
	public boolean var_b2d = false;
	public boolean var_b35 = false;
	public boolean var_b3d;
	public byte var_b45;
	public byte var_b4d;
	public byte var_b55;
	public byte var_b5d;
	public byte var_b65;
	public byte var_b6d;
	public boolean var_b75;
	public int var_b7d = 0;
	public static final byte[] var_b85 = { 3, -3 };
	public F_Sprite var_b8d;
	public F_Sprite var_b95;
	public F_Sprite var_b9d;
	public F_Sprite var_ba5;
	public int var_bad;
	public int var_bb5;
	public long var_bbd;
	public long var_bc5;
	public long var_bcd;
	public F_Sprite[] var_bd5;
	public H_ImageExt[] var_bdd;
	public H_ImageExt var_be5;
	public G_FightAnimation var_bed;
	public int var_bf5;
	public int var_bfd;
	public int var_c05;
	public int var_c0d;
	public boolean var_c15 = false;
	public int var_c1d;
	public int var_c25;
	public int[][] var_c2d;
	public int[] var_c35;
	public int var_c3d;
	public int var_c45 = 20;
	public int var_c4d;
	public int var_c55;
	public byte[][] var_c5d;
	public F_Sprite var_c65;
	public F_Sprite var_c6d;
	public F_Sprite[] var_c75;
	public int var_c7d;
	public int var_c85;

	public G_FightAnimation(I_Game paramClass_i_168,
			C_Unit paramClass_c_032, G_FightAnimation paramClass_g_066)
			throws Exception {
		this.var_b15 = paramClass_i_168;
		this.var_b1d = paramClass_c_032;
		this.var_b25 = paramClass_c_032.unitTypeId;
		this.var_bed = paramClass_g_066;
		this.var_b45 = ((byte) paramClass_c_032.var_b0b);
		this.var_c1d = this.var_b45;
		this.var_b55 = ((byte) paramClass_c_032.sub_12c4());
		this.var_b65 = this.var_b55;
		int i = 0;
		if (paramClass_g_066 == null) {
			this.var_b6d = 0;
			this.var_bad = 0;
			this.var_b75 = true;
		} else {
			i = paramClass_i_168.var_32db;
			this.var_b6d = 1;
			this.var_b7d = 0;
		}
		this.var_bf5 = paramClass_i_168.sub_dd5d(paramClass_c_032.positionX,
				paramClass_c_032.positionY);
		int j = var_b05[this.var_bf5];
		int k = var_afd[this.var_bf5];
		if ((paramClass_g_066 != null)
				&& (k == var_afd[paramClass_g_066.var_bf5])) {
			this.var_bdd = new H_ImageExt[paramClass_g_066.var_bdd.length];
			System.arraycopy(paramClass_g_066.var_bdd, 0, this.var_bdd, 0,
					this.var_bdd.length);
		} else {
			this.var_bdd = new F_Sprite(var_af5[k]).frameImages;
		}
		if (this.var_b6d == 1) {
			for (int m = 0; m < this.var_bdd.length; m++) {
				this.var_bdd[m] = new H_ImageExt(this.var_bdd[m], 1);
			}
		}
		try {
			if ((paramClass_g_066 != null)
					&& (j == var_b05[paramClass_g_066.var_bf5])) {
				this.var_be5 = paramClass_g_066.var_be5;
			} else {
				this.var_be5 = new H_ImageExt(var_af5[j] + "_bg");
			}
			if (this.var_b6d == 1) {
				this.var_be5 = new H_ImageExt(this.var_be5, 1);
			}
		} catch (Exception localException) {
		}
		if (this.var_be5 != null) {
			this.var_bfd = this.var_be5.imageHeight;
		}
		this.var_c05 = (paramClass_i_168.var_32db / this.var_bdd[0].imageWidth);
		if (paramClass_i_168.var_32db % this.var_bdd[0].imageWidth != 0) {
			this.var_c05 += 1;
		}
		this.var_c0d = ((paramClass_i_168.var_3bfb - this.var_bfd) / this.var_bdd[0].imageHeight);
		if ((paramClass_i_168.var_3bfb - this.var_bfd)
				% this.var_bdd[0].imageHeight != 0) {
			this.var_c0d += 1;
		}
		this.var_c5d = new byte[this.var_c05][this.var_c0d];
		for (int m = 0; m < this.var_c05; m++) {
			for (int n = 0; n < this.var_c0d; n++) {
				this.var_c5d[m][n] = ((byte) Math.abs(E_MainCanvas.random
						.nextInt() % this.var_bdd.length));
			}
		}
		this.var_b8d = new F_Sprite(var_b0d[this.var_b25],
				paramClass_i_168.var_356b[paramClass_c_032.var_acb]);
		if ((paramClass_g_066 != null)
				&& (paramClass_g_066.var_b25 == this.var_b25)) {
			if (paramClass_g_066.var_ba5 != null) {
				this.var_ba5 = new F_Sprite(paramClass_g_066.var_ba5);
			}
			if (paramClass_g_066.var_b95 != null) {
				this.var_b95 = new F_Sprite(paramClass_g_066.var_b95);
			}
			if (paramClass_g_066.var_b9d != null) {
				this.var_b9d = new F_Sprite(paramClass_g_066.var_b9d);
			}
			if (paramClass_g_066.var_c65 != null) {
				this.var_c65 = new F_Sprite(paramClass_g_066.var_c65);
				this.var_c6d = new F_Sprite(paramClass_g_066.var_c6d);
			}
		} else if ((this.var_b25 == 0) || (this.var_b25 == 10)
				|| (this.var_b25 == 5)) {
			this.var_ba5 = new F_Sprite("slash");
		} else if (this.var_b25 == 1) {
			this.var_b9d = new F_Sprite("archer_arrow");
		} else if (this.var_b25 == 9) {
			this.var_b95 = new F_Sprite("kingwave");
			this.var_ba5 = new F_Sprite("kingslash");
			this.var_c65 = new F_Sprite("king_heads");
			this.var_c6d = new F_Sprite("king_heads_back");
		} else if (this.var_b25 == 2) {
			this.var_b95 = new F_Sprite("watermagic");
			this.var_b9d = new F_Sprite("fish");
		} else if ((this.var_b25 == 7) || (this.var_b25 == 6)) {
			this.var_b9d = new F_Sprite("crater");
		} else if (this.var_b25 == 3) {
			this.var_b95 = new F_Sprite("spell");
			this.var_b9d = this.var_b95;
		}
		if (this.var_b95 != null) {
			this.var_b95.startAnimation(0, this.var_b75);
		}
		if (this.var_b9d != null) {
			this.var_b9d.startAnimation(0, this.var_b75);
		}
		if (this.var_ba5 != null) {
			this.var_ba5.startAnimation(0, this.var_b75);
		}
		if (this.var_c65 != null) {
			this.var_c65.startAnimation(paramClass_c_032.var_b7b, this.var_b75);
			this.var_c65.setCurrentFrameIndex(paramClass_c_032.var_b7b);
			this.var_c6d.startAnimation(0, this.var_b75);
			this.var_c6d.setCurrentFrameIndex(paramClass_c_032.var_b7b);
		}
		this.var_c2d = new int[paramClass_c_032.var_aa3.length][2];
		for (int m = 0; m < this.var_c2d.length; m++) {
			this.var_c2d[m][0] = (paramClass_c_032.var_aa3[m][0]
					* paramClass_i_168.someCanWidth / 128);
			if (this.var_b6d == 1) {
				this.var_c2d[m][0] = (paramClass_i_168.var_32db
						- this.var_c2d[m][0] - this.var_b8d.frameWidth + i);
			}
			this.var_c2d[m][1] = (paramClass_c_032.var_aa3[m][1]
					* paramClass_i_168.var_3bfb / 128 - this.var_b8d.frameHeight);
		}
		this.var_bd5 = new F_Sprite[this.var_b55];
		if ((this.var_b25 == 4) || (this.var_b25 == 6)) {
			this.var_c35 = new int[this.var_b55];
		}
		for (int m = 0; m < this.var_b55; m++) {
			this.var_bd5[m] = new F_Sprite(this.var_b8d);
			paramClass_i_168.sub_145c5(this.var_bd5[m]);
			this.var_bd5[m].setSpritePosition(this.var_c2d[m][0], this.var_c2d[m][1]);
			this.var_bd5[m].startAnimation(0, this.var_b75);
			this.var_bd5[m].var_854 = false;
			this.var_bd5[m].var_83c = 0;
			if (this.var_b25 == 6) {
				this.var_bd5[m].var_874 = true;
				this.var_c35[m] = E_MainCanvas.sub_1544(360);
				this.var_bd5[m].var_80c = (-6 + 4
						* A_MenuBase.sub_f9b(this.var_c35[m]) >> 10);
			} else if (this.var_b25 == 4) {
				this.var_bd5[m].var_874 = true;
				this.var_bd5[m].var_80c = (-5 - E_MainCanvas.sub_1544(10));
				this.var_c35[m] = E_MainCanvas.sub_1544(360);
			} else if (this.var_b25 == 9) {
				this.var_bd5[m].var_894 = this.var_c65;
				this.var_bd5[m].var_89c = this.var_c6d;
			}
		}
	}

	public final int sub_1673(F_Sprite paramClass_f_045, int paramInt) {
		if (this.var_b6d == 1) {
			return this.var_b8d.frameWidth - paramInt - paramClass_f_045.frameWidth;
		}
		return paramInt;
	}

	public final void sub_16bb() {
		this.var_b2d = true;
		this.var_b7d = 1;
		this.var_bc5 = this.var_b15.time;
	}

	public final void sub_16eb() {
		int i;
		int i3;
		int m;
		F_Sprite localClass_f_0455;
		switch (this.var_b7d) {
		case 1:
			F_Sprite localClass_f_0454;
			if (this.var_b25 == 6) {
				if (this.var_c4d == 0) {
					if (this.var_b15.time - this.var_bc5 >= 200L) {
						if (this.var_c85 < this.var_b65) {
							this.var_bd5[this.var_c85].var_87c = -1;
							this.var_bd5[this.var_c85].var_874 = false;
							this.var_bd5[this.var_c85].var_844 = 0;
						}
						if (++this.var_c85 >= this.var_b65) {
							this.var_c85 = 0;
							this.var_c4d = 1;
							this.var_bc5 = this.var_b15.time;
						}
					}
				} else if (this.var_c4d == 1) {
					if (this.var_b15.time - this.var_bc5 >= 200L) {
						if (this.var_c85 < this.var_b65) {
							this.var_bd5[this.var_c85].var_844 = -1;
						}
						if (++this.var_c85 >= this.var_b65) {
							this.var_c85 = 0;
							this.var_c4d = 2;
							this.var_bc5 = this.var_b15.time;
						}
					}
				} else if (this.var_c4d == 2) {
					i = 1;
					if (this.var_b15.time - this.var_bc5 >= 200L) {
						if (this.var_c85 < this.var_b65) {
							this.var_bd5[this.var_c85].var_87c = 0;
							this.var_bd5[this.var_c85].var_844 = 0;
							this.var_bd5[this.var_c85]
									.startAnimation(2, this.var_b75);
							this.var_bd5[this.var_c85].var_81c = 1;
						}
						if (++this.var_c85 < this.var_b65) {
							i = 0;
						}
					} else {
						i = 0;
					}
					for (int j = 0; j < this.var_b65; j++) {
						if (this.var_bd5[j].var_87c == 0) {
							if (this.var_bd5[j].currentFrameIndex == 1) {
								this.var_bd5[j].var_80c = 0;
								this.var_bd5[j].var_87c = 1;
								E_MainCanvas.sub_233e(200);
								this.var_b15.sub_14bd3(1200);
								E_MainCanvas.playMusicLooped(14, 1);
								for (int n = 0; n < 2; n++) {
									F_Sprite localClass_f_0456;
									(localClass_f_0456 = F_Sprite.sub_1616(
											this.var_b15.smokeSprite, 0, 0, -1, 1,
											E_MainCanvas.sub_1544(4) * 50,
											(byte) 0))
											.setSpritePosition(
													this.var_bd5[j].posX
															+ E_MainCanvas
																	.sub_1544(this.var_b8d.frameWidth
																			- localClass_f_0456.frameWidth),
													this.var_bd5[j].posY
															+ this.var_b8d.frameHeight
															- localClass_f_0456.frameHeight
															+ 2);
									localClass_f_0456.var_85c = true;
									this.var_b15.sub_145c5(localClass_f_0456);
								}
								(localClass_f_0454 = F_Sprite.sub_1616(
										this.var_b15.smokeSprite, -1, 0, -1, 1,
										E_MainCanvas.sub_1544(4) * 50, (byte) 0))
										.setSpritePosition(
												this.var_bd5[j].posX,
												this.var_bd5[j].posY
														+ this.var_b8d.frameHeight
														- localClass_f_0454.frameHeight
														+ 2);
								localClass_f_0454.var_85c = true;
								this.var_b15.sub_145c5(localClass_f_0454);
								(localClass_f_0454 = F_Sprite.sub_1616(
										this.var_b15.smokeSprite, 1, 0, -1, 1,
										E_MainCanvas.sub_1544(4) * 50, (byte) 0))
										.setSpritePosition(
												this.var_bd5[j].posX
														+ this.var_b8d.frameWidth
														- localClass_f_0454.frameWidth,
												this.var_bd5[j].posY
														+ this.var_b8d.frameHeight
														- localClass_f_0454.frameHeight
														+ 2);
								localClass_f_0454.var_85c = true;
								this.var_b15.sub_145c5(localClass_f_0454);
							}
							i = 0;
						} else if (this.var_bd5[j].var_87c != -1) {
							if (this.var_bd5[j].var_81c > 0) {
								i = 0;
							} else if (this.var_bd5[j].var_81c != -1) {
								if (this.var_bd5[j].var_87c == 1) {
									this.var_bd5[j].startAnimation(3, this.var_b75);
									this.var_bd5[j].var_81c = 1;
									this.var_bd5[j].var_87c = 2;
									i = 0;
								} else if (this.var_bd5[j].var_87c == 2) {
									this.var_bd5[j].var_80c = -6;
									this.var_bd5[j].var_874 = true;
									this.var_bd5[j].var_844 = E_MainCanvas
											.sub_1564(-2, 3);
									this.var_bd5[j].startAnimation(0, this.var_b75);
									this.var_bd5[j].var_81c = -1;
									this.var_bd5[j].var_87c = 3;
									i = 0;
								}
							}
						}
					}
					if (i != 0) {
						this.var_c4d = 0;
						this.var_bc5 = this.var_b15.time;
						this.var_b7d = 4;
					}
				}
			} else if (this.var_c4d == 0) {
				if (this.var_b15.time - this.var_bc5 >= 200L) {
					if (this.var_b25 == 9) {
						this.var_c75 = new F_Sprite[this.var_b65 * 2];
					} else if ((this.var_b25 != 7) && (this.var_b25 != 1)) {
						this.var_c75 = new F_Sprite[this.var_b65];
					}
					this.var_c4d = 1;
					this.var_c85 = 0;
					this.var_bc5 = this.var_b15.time;
				}
			} else if (this.var_c4d == 1) {
				i = 1;
				if (this.var_c85 < this.var_b65) {
					this.var_bd5[this.var_c85].startAnimation(2, this.var_b75);
					this.var_bd5[this.var_c85].var_81c = 1;
					if ((this.var_b25 == 3) || (this.var_b25 == 2)) {
						this.var_c75[this.var_c85] = F_Sprite.sub_1616(
								this.var_b95, 0, 0, 0, 1, 50, (byte) 0);
						this.var_c75[this.var_c85]
								.setSpritePosition(
										this.var_bd5[this.var_c85].posX
												+ sub_1673(
														this.var_c75[this.var_c85],
														this.var_bd5[this.var_c85].frameWidth),
										this.var_bd5[this.var_c85].posY);
						this.var_b15.sub_145c5(this.var_c75[this.var_c85]);
					} else if (this.var_b25 == 1) {
						F_Sprite localClass_f_0451;
						(localClass_f_0451 = F_Sprite.sub_1616(this.var_b9d,
								0, 0, 0, 1, 0, (byte) 0)).startAnimation(1,
								this.var_b75);
						localClass_f_0451
								.setSpritePosition(
										this.var_bd5[this.var_c85].posX
												+ sub_1673(
														localClass_f_0451,
														this.var_bd5[this.var_c85].frameWidth),
										this.var_bd5[this.var_c85].posY);
						this.var_b15.sub_145c5(localClass_f_0451);
					} else {
						if (this.var_b25 == 7) {
							this.var_bd5[this.var_c85].var_864 = 5;
							for (int k = 0; k < 3; k++) {
								(localClass_f_0454 = F_Sprite.sub_1616(
										this.var_b15.bigSmokeSprite,
										E_MainCanvas.sub_1564(-1, 2), 0, 0, 1,
										E_MainCanvas.sub_1544(4) * 50, (byte) 0))
										.setSpritePosition(
												this.var_bd5[this.var_c85].posX
														+ this.var_b8d.frameWidth
														/ 2,
												this.var_bd5[this.var_c85].posY);
								localClass_f_0454.var_85c = true;
								this.var_b15.sub_145c5(localClass_f_0454);
							}
						}
						if (this.var_b25 == 9) {
							F_Sprite localClass_f_0452;
							(localClass_f_0452 = F_Sprite.sub_1616(
									this.var_ba5, 0, 0, 0, 1, 200, (byte) 0))
									.setSpritePosition(this.var_bd5[0].posX,
											this.var_bd5[0].posY
													+ this.var_b8d.frameHeight);
							localClass_f_0452.var_80c = (-this.var_b8d.frameHeight);
							this.var_b15.sub_145c5(localClass_f_0452);
							this.var_c75[0] = F_Sprite.sub_1616(
									this.var_b95, var_b85[this.var_b6d] * 3,
									-2, 0, -1, 100, (byte) 0);
							int i1 = this.var_bd5[this.var_c85].posX
									+ sub_1673(
											this.var_c75[this.var_c85],
											this.var_bd5[this.var_c85].frameWidth / 2);
							i3 = this.var_bd5[this.var_c85].posY
									+ this.var_b8d.frameHeight
									- this.var_c75[this.var_c85].frameHeight + 2;
							this.var_c75[0].setSpritePosition(i1, i3);
							this.var_c75[1] = F_Sprite.sub_1616(
									this.var_b95, var_b85[this.var_b6d] * 3, 1,
									0, -1, 100, (byte) 0);
							this.var_c75[1].setSpritePosition(i1, i3);
							this.var_b15.sub_145c5(this.var_c75[1]);
							this.var_c75[1].var_86c = this.var_b6d;
							this.var_b15.sub_145c5(this.var_c75[0]);
							this.var_c75[0].var_86c = this.var_b6d;
						} else if (this.var_b25 == 8) {
							this.var_c75[this.var_c85] = F_Sprite.sub_1616(
									null, var_b85[this.var_b6d], 0, 0, -1,
									2000, (byte) 6);
							this.var_c75[this.var_c85]
									.setSpritePosition(
											this.var_bd5[this.var_c85].posX
													+ sub_1673(
															this.var_c75[this.var_c85],
															this.var_bd5[this.var_c85].frameWidth + 2),
											this.var_bd5[this.var_c85].posY + 30);
							this.var_c75[this.var_c85].var_85c = true;
							E_MainCanvas.sub_233e(200);
							this.var_b15.sub_14bd3(1200);
							E_MainCanvas.playMusicLooped(14, 1);
							this.var_b15.sub_145c5(this.var_c75[this.var_c85]);
						}
					}
				}
				if (++this.var_c85 < this.var_b65) {
					i = 0;
				}
				for (m = 0; m < this.var_b65; m++) {
					if (this.var_bd5[m].var_81c > 0) {
						i = 0;
					} else if ((this.var_b25 != 7)
							&& (this.var_bd5[m].var_81c != -1)) {
						if (this.var_bd5[m].var_87c == 0) {
							this.var_bd5[m].startAnimation(3, this.var_b75);
							this.var_bd5[m].var_81c = 1;
							this.var_bd5[m].var_87c = 1;
							if (this.var_b25 == 8) {
								this.var_c75[m].var_84c = false;
							}
							i = 0;
						} else if (this.var_bd5[m].var_87c == 1) {
							this.var_bd5[m].startAnimation(0, this.var_b75);
							this.var_bd5[m].var_81c = -1;
							this.var_bd5[m].var_87c = 2;
							i = 0;
						}
					}
					if ((this.var_b25 == 8) && (this.var_c75[m] != null)
							&& (this.var_c75[m].var_84c)) {
						(localClass_f_0455 = F_Sprite.sub_1616(
								this.var_b15.bigSmokeSprite, var_b85[this.var_b6d]
										* E_MainCanvas.sub_1564(1, 4),
								E_MainCanvas.sub_1564(-2, 3), 0, 1,
								50 * E_MainCanvas.sub_1544(4), (byte) 0))
								.setSpritePosition(
										this.var_bd5[m].posX
												+ sub_1673(localClass_f_0455,
														this.var_b8d.frameWidth),
										this.var_c75[m].posY
												+ E_MainCanvas
														.sub_1544(30 - this.var_c75[m].frameHeight)
												- 15);
						localClass_f_0455.var_85c = true;
						this.var_b15.sub_145c5(localClass_f_0455);
					}
				}
				if (i != 0) {
					if (this.var_b1d.unitTypeId == 9) {
						this.var_b7d = 6;
					} else {
						this.var_b7d = 4;
					}
					this.var_c55 = 400;
					if (this.var_b1d.unitTypeId == 8) {
						this.var_c55 = 0;
					}
					this.var_bc5 = this.var_b15.time;
					this.var_c4d = 0;
					return;
				}
			}
			break;
		case 6:
			i = 1;
			for (m = 0; m < this.var_c75.length; m++) {
				if ((this.var_b25 == 9) && (E_MainCanvas.sub_1544(2) == 0)) {
					(localClass_f_0455 = F_Sprite.sub_1616(
							this.var_b15.bigSmokeSprite, E_MainCanvas.sub_1564(-2, 1),
							0, -1, 1, 100, (byte) 0)).setSpritePosition(
							this.var_c75[m].posX
									+ sub_1673(this.var_c75[m], 0),
							this.var_c75[m].posY + this.var_c75[m].frameHeight
									- localClass_f_0455.frameHeight);
					if (this.var_c75[m].var_87c == 1) {
						localClass_f_0455.var_86c = this.var_bed.var_b6d;
					} else {
						localClass_f_0455.var_86c = this.var_b6d;
					}
					this.var_b15.sub_145c5(localClass_f_0455);
				}
				if (this.var_b25 == 9) {
					if (this.var_b6d == 0) {
						if (this.var_c75[m].posX >= this.var_b15.var_32cb) {
							if (this.var_c75[m].var_87c == 0) {
								this.var_c75[m].setSpritePosition(this.var_b15.var_32db
										- this.var_c75[m].frameWidth,
										this.var_c75[m].posY);
								this.var_c75[m].var_86c = this.var_bed.var_b6d;
								this.var_c75[m].var_87c = 1;
								i = 0;
							} else if (this.var_c75[m].var_87c == 1) {
								this.var_b15.sub_145e8(this.var_c75[m]);
								this.var_c75[m].var_87c = 2;
							}
						} else {
							i = 0;
						}
					} else if (this.var_b6d == 1) {
						if (this.var_c75[m].posX + this.var_c75[m].frameWidth < 0) {
							if (this.var_c75[m].var_87c == 0) {
								this.var_c75[m].setSpritePosition(this.var_b15.var_32db,
										this.var_c75[m].posY);
								this.var_c75[m].var_86c = this.var_bed.var_b6d;
								this.var_c75[m].var_87c = 1;
								i = 0;
							} else if (this.var_c75[m].var_87c == 1) {
								this.var_b15.sub_145e8(this.var_c75[m]);
								this.var_c75[m].var_87c = 2;
							}
						} else {
							i = 0;
						}
					}
				}
			}
			if (i != 0) {
				this.var_c4d = 0;
				this.var_b7d = 4;
				this.var_bc5 = this.var_b15.time;
				return;
			}
			break;
		case 4:
			if (this.var_c4d == 0) {
				if (this.var_b15.time - this.var_bc5 >= this.var_c55) {
					this.var_bed.sub_3363();
					if (this.var_b25 != 1) {
						this.var_b15.sub_14bd3(200);
					}
					E_MainCanvas.sub_233e(200);
					E_MainCanvas.playMusicLooped(14, 1);
					if (this.var_b9d != null) {
						this.var_c7d = C_Unit.var_bc3[this.var_b25].length;
					}
					this.var_c4d = 1;
				}
			} else if (this.var_c4d == 1) {
				if (--this.var_c7d >= 0) {
					F_Sprite localClass_f_0453;
					if ((this.var_b25 == 3) || (this.var_b25 == 2)
							|| (this.var_b25 == 1)) {
						localClass_f_0453 = F_Sprite.sub_1616(this.var_b9d,
								0, 0, 0, 1, 0, (byte) 0);
					} else {
						localClass_f_0453 = F_Sprite.sub_1616(this.var_b9d,
								0, 0, 0, -1, 0, (byte) 0);
					}
					if ((this.var_b25 == 2) || (this.var_b25 == 1)) {
						localClass_f_0453.var_854 = false;
					}
					int i2 = E_MainCanvas.sub_1544(this.var_b15.var_32cb / 2
							- localClass_f_0453.frameWidth);
					i3 = 0;
					if (this.var_bed.var_be5 != null) {
						i3 = 0 + (this.var_bed.var_be5.imageHeight - localClass_f_0453.frameHeight);
					}
					int i4 = (this.var_b15.var_3bfb - i3)
							* (this.var_c7d * 2 + 1)
							/ (C_Unit.var_bc3[this.var_b25].length * 2)
							- localClass_f_0453.frameHeight / 2 + i3;
					if (this.var_b6d == 0) {
						i2 += this.var_b15.var_32db;
					}
					if ((this.var_b25 == 7) || (this.var_b25 == 6)) {
						localClass_f_0453.var_80c = i4;
						i4 = 0;
					}
					localClass_f_0453.setSpritePosition(i2, i4);
					this.var_b15.sub_145c5(localClass_f_0453);
					for (int i5 = 0; i5 < 3; i5++) {
						F_Sprite localClass_f_0457;
						if ((this.var_b25 == 7) || (this.var_b25 == 6)) {
							(localClass_f_0457 = F_Sprite.sub_1616(
									this.var_b15.smokeSprite,
									E_MainCanvas.sub_1564(-1, 2), 0,
									E_MainCanvas.sub_1564(-2, 0), 1,
									E_MainCanvas.sub_1544(4) * 50, (byte) 0))
									.setSpritePosition(
											i2
													+ E_MainCanvas
															.sub_1544(localClass_f_0453.frameWidth
																	- localClass_f_0457.frameWidth),
											localClass_f_0453.var_80c
													+ localClass_f_0453.frameHeight
													- localClass_f_0457.frameHeight
													+ 1);
							localClass_f_0457.var_80c = (-localClass_f_0453.frameHeight / 2);
						} else {
							(localClass_f_0457 = F_Sprite.sub_1616(
									this.var_b15.bigSmokeSprite,
									E_MainCanvas.sub_1564(-1, 2), 0, -1, 1, 100,
									(byte) 0))
									.setSpritePosition(
											i2
													+ E_MainCanvas
															.sub_1544(localClass_f_0453.frameWidth
																	- localClass_f_0457.frameWidth),
											i4 + localClass_f_0453.frameHeight
													- localClass_f_0457.frameHeight
													+ 1);
						}
						this.var_b15.sub_145c5(localClass_f_0457);
					}
				}
				this.var_b7d = 7;
				this.var_bc5 = this.var_b15.time;
				return;
			}
			break;
		case 7:
			if (this.var_b15.time - this.var_bc5 >= 1000L) {
				this.var_b7d = 0;
				this.var_b35 = true;
			}
			break;
		}
	}

	public final void sub_2730() {
		for (int i = 0; i < this.var_b65; i++) {
			this.var_bd5[i].var_864 = 6;
		}
	}

	public final void sub_2782() {
		switch (this.var_b7d) {
		case 1:
			if (this.var_c4d == 0) {
				if (this.var_b15.time - this.var_bc5 >= 200L) {
					this.var_c4d = 1;
					this.var_bc5 = this.var_b15.time;
				}
			} else {
				F_Sprite localClass_f_0451;
				if (this.var_c4d == 1) {
					this.var_c45 += 5;
					if (this.var_c45 >= 90) {
						this.var_c4d += 1;
						this.var_bc5 = this.var_b15.time;
					}
					if ((this.var_c45 - 20) % 15 == 0) {
						for (int i = 0; i < this.var_bd5.length; i++) {
							(localClass_f_0451 = F_Sprite.sub_1616(
									this.var_b15.bigSmokeSprite,
									E_MainCanvas.sub_1564(-1, 2), 0, 0, 1, 100,
									(byte) 0))
									.setSpritePosition(
											this.var_bd5[i].posX
													+ E_MainCanvas
															.sub_1544(this.var_b8d.frameWidth
																	- localClass_f_0451.frameWidth),
											this.var_bd5[i].posY
													+ this.var_b8d.frameHeight
													- localClass_f_0451.frameHeight
													+ 1);
							this.var_b15.sub_145c5(localClass_f_0451);
						}
					}
				} else if ((this.var_c4d == 2)
						&& (this.var_b15.time - this.var_bc5 >= 400L)) {
					this.var_c45 = 20;
					this.var_bed.sub_3363();
					this.var_b7d = 4;
					this.var_bed.var_c15 = false;
					this.var_bc5 = this.var_b15.time;
				}
				if (++this.var_c3d >= 2) {
					for (int i = 0; i < this.var_bed.var_bd5.length; i++) {
						(localClass_f_0451 = F_Sprite
								.sub_1616(this.var_b15.redsparkSprite, 0, 0, 0, 1,
										50, (byte) 0))
								.setSpritePosition(
										this.var_bed.var_bd5[i].posX
												+ E_MainCanvas
														.sub_1544(this.var_bed.var_bd5[i].frameWidth
																- localClass_f_0451.frameWidth),
										this.var_bed.var_bd5[i].posY
												+ E_MainCanvas
														.sub_1544(this.var_bed.var_bd5[i].frameHeight
																- localClass_f_0451.frameHeight));
						localClass_f_0451.var_85c = true;
						this.var_b15.sub_145c5(localClass_f_0451);
					}
					this.var_c3d = 0;
					this.var_bed.sub_2730();
				}
			}
			break;
		case 4:
			if (this.var_b15.time - this.var_bc5 >= 800L) {
				this.var_b35 = true;
				this.var_b7d = 0;
			}
			break;
		}
		int i = 0;
		if (this.var_b15.time - this.var_bbd >= 300L) {
			i = 1;
			this.var_bbd = this.var_b15.time;
		}
		for (int j = 0; j < this.var_bd5.length; j++) {
			if (i != 0) {
				F_Sprite localClass_f_0452;
				(localClass_f_0452 = F_Sprite.sub_1616(null, 0, 0, 0, 1,
						500, (byte) 4))
						.setSpritePosition(this.var_bd5[j].posX
								+ (this.var_bd5[j].frameWidth >> 1),
								this.var_bd5[j].posY
										+ (this.var_bd5[j].frameHeight >> 1)
										+ this.var_bb5);
				this.var_b15.sub_145c5(localClass_f_0452);
			}
			int k = this.var_bd5[j].frameWidth / 3;
			this.var_bd5[j]
					.setSpritePosition(
							this.var_c2d[j][0]
									+ (k * A_MenuBase.sub_fc1(this.var_c35[j]) >> 10),
							this.var_c2d[j][1]
									+ (k * A_MenuBase.sub_f9b(this.var_c35[j])
											/ 3 >> 10));
			this.var_c35[j] = ((this.var_c35[j] + this.var_c45) % 360);
		}
	}

	public final void sub_2ae8() {
		if (this.var_c15) {
			if (this.var_b15.time - this.var_bcd >= 300L) {
				this.var_c15 = false;
				this.var_bad = 0;
				this.var_bb5 = 0;
			} else {
				if (this.var_bad > 0) {
					this.var_bad = -2;
				} else {
					this.var_bad = 2;
				}
				this.var_bb5 = (E_MainCanvas.random.nextInt() % 1);
			}
		}
		if ((this.var_b3d) && (this.var_c1d > this.var_b4d)) {
			this.var_c1d -= 2;
			if (this.var_c1d < this.var_b4d) {
				this.var_c1d = this.var_b4d;
			}
			this.var_b15.var_3bf3 = true;
		}
		int i;
		if ((this.var_b25 == 8) || (this.var_b25 == 9) || (this.var_b25 == 7)
				|| (this.var_b25 == 1) || (this.var_b25 == 3)
				|| (this.var_b25 == 2) || (this.var_b25 == 6)) {
			sub_16eb();
		} else if (this.var_b25 == 4) {
			sub_2782();
		} else {
			i = 0;
			int j;
			int k;
			switch (this.var_b7d) {
			case 1:
				if (this.var_b15.time - this.var_bc5 >= 200L) {
					this.var_b7d = 3;
				}
				break;
			case 3:
				j = 1;
				F_Sprite localClass_f_045;
				if (this.var_c4d < this.var_b65) {
					if ((this.var_b25 == 0) || (this.var_b25 == 5)) {
						this.var_bd5[this.var_c4d].var_844 = -6;
					}
					if (this.var_b25 == 5) {
						this.var_bd5[this.var_c4d].var_834 = (2 * var_b85[this.var_b6d]);
						for (k = 0; k < 3; k++) {
							(localClass_f_045 = F_Sprite.sub_1616(
									this.var_b15.bigSmokeSprite,
									E_MainCanvas.sub_1564(-1, 2), 0, -1, 1, 100,
									(byte) 0))
									.setSpritePosition(
											this.var_bd5[this.var_c4d].posX
													+ E_MainCanvas
															.sub_1544(this.var_b8d.frameWidth
																	- localClass_f_045.frameWidth),
											this.var_bd5[this.var_c4d].posY
													+ this.var_b8d.frameHeight
													- localClass_f_045.frameHeight
													+ 1);
							this.var_b15.sub_145c5(localClass_f_045);
						}
					}
					this.var_bd5[this.var_c4d].var_834 = var_b85[this.var_b6d];
					this.var_bd5[this.var_c4d].startAnimation(1, this.var_b75);
					this.var_c4d += 1;
					j = 0;
				}
				for (k = 0; k < this.var_c4d; k++) {
					if (this.var_b25 == 10) {
						if (this.var_bd5[k].var_87c != -1) {
							this.var_bd5[k].var_87c += 1;
							if (this.var_bd5[k].var_87c >= 16) {
								this.var_bd5[k].startAnimation(2, this.var_b75);
								this.var_bd5[k].var_834 = 0;
								this.var_bd5[k].var_87c = -1;
								(localClass_f_045 = F_Sprite.sub_1616(null,
										0, 0, 0, 1, 800, (byte) 2)).setSpritePosition(
										this.var_bd5[k].posX
												+ sub_1673(localClass_f_045,
														this.var_b8d.frameWidth),
										this.var_bd5[k].posY
												+ this.var_b8d.frameHeight);
								this.var_b15.sub_145c5(localClass_f_045);
								(localClass_f_045 = F_Sprite
										.sub_1616(this.var_ba5, 0, 0, 0, 1,
												150, (byte) 0))
										.setSpritePosition(
												this.var_bd5[k].posX
														+ sub_1673(
																localClass_f_045,
																24),
												this.var_bd5[k].posY + 3);
								this.var_b15.sub_145c5(localClass_f_045);
							} else {
								j = 0;
							}
						}
					} else if (this.var_bd5[k].var_80c < 0) {
						this.var_bd5[k].var_844 += 1;
						j = 0;
					} else if (this.var_bd5[k].var_844 >= 6) {
						this.var_bd5[k].var_80c = 0;
						this.var_bd5[k].var_844 = 0;
						this.var_bd5[k].var_834 = 0;
						if ((this.var_b25 == 0) || (this.var_b25 == 5)) {
							this.var_bd5[k].startAnimation(2, this.var_b75);
							if (this.var_b25 == 0) {
								(localClass_f_045 = F_Sprite
										.sub_1616(this.var_ba5, 0, 0, 0, 1,
												150, (byte) 0))
										.setSpritePosition(
												this.var_bd5[k].posX
														+ sub_1673(
																localClass_f_045,
																14),
												this.var_bd5[k].posY
														+ this.var_bd5[k].frameHeight);
								localClass_f_045.var_80c = (4 - this.var_bd5[k].frameHeight);
								this.var_b15.sub_145c5(localClass_f_045);
							} else if (this.var_b25 == 5) {
								(localClass_f_045 = F_Sprite.sub_1616(
										this.var_b15.redsparkSprite, 0, 0, 0, 1, 50,
										(byte) 0))
										.setSpritePosition(
												this.var_bd5[k].posX
														+ sub_1673(
																localClass_f_045,
																this.var_b8d.frameWidth * 3 / 4),
												this.var_bd5[k].posY
														+ this.var_bd5[k].frameHeight);
								localClass_f_045.var_80c = (-localClass_f_045.frameHeight);
								this.var_b15.sub_145c5(localClass_f_045);
							}
						}
					}
				}
				if (j != 0) {
					this.var_c4d = 0;
					this.var_b7d = 6;
					this.var_bed.sub_3363();
					this.var_b15.sub_14bd3(200);
					E_MainCanvas.sub_233e(200);
					E_MainCanvas.playMusicLooped(14, 1);
					this.var_bc5 = this.var_b15.time;
				}
				break;
			case 6:
				if (((this.var_b25 == 10) && (this.var_b15.time
						- this.var_bc5 >= 400L))
						|| (((this.var_b25 == 0) || (this.var_b25 == 2) || (this.var_b25 == 5)) && (this.var_b15.time
								- this.var_bc5 >= 50L))) {
					this.var_b7d = 4;
				}
				break;
			case 4:
				j = 1;
				if (this.var_c4d < this.var_b65) {
					if ((this.var_b25 == 0) || (this.var_b25 == 2)
							|| (this.var_b25 == 5)) {
						this.var_bd5[this.var_c4d].var_844 = -6;
					} else if (this.var_b25 == 10) {
						this.var_bd5[this.var_c4d].var_87c = 0;
					}
					if (this.var_b25 == 5) {
						this.var_bd5[this.var_c4d].var_834 = (-2 * var_b85[this.var_b6d]);
					} else {
						this.var_bd5[this.var_c4d].var_834 = (-var_b85[this.var_b6d]);
					}
					this.var_bd5[this.var_c4d].startAnimation(3, this.var_b75);
					this.var_c4d += 1;
					j = 0;
				}
				for (k = 0; k < this.var_c4d; k++) {
					if (this.var_b25 == 10) {
						if (this.var_bd5[k].var_87c != -1) {
							this.var_bd5[k].var_87c += 1;
							if (this.var_bd5[k].var_87c >= 16) {
								this.var_bd5[k].startAnimation(0, this.var_b75);
								this.var_bd5[k].var_834 = 0;
								this.var_bd5[k].var_87c = -1;
							} else {
								j = 0;
							}
						}
					} else if (this.var_bd5[k].var_80c < 0) {
						this.var_bd5[k].var_844 += 1;
						j = 0;
					} else if (this.var_bd5[k].var_844 >= 6) {
						this.var_bd5[k].var_844 = 0;
						this.var_bd5[k].var_834 = 0;
						this.var_bd5[k].var_80c = 0;
						this.var_bd5[k].startAnimation(0, this.var_b75);
					}
				}
				if (j != 0) {
					this.var_b35 = true;
					this.var_b7d = 0;
					this.var_bc5 = this.var_b15.time;
				}
				break;
			}
		}
		if (this.var_b25 == 6) {
			for (i = 0; i < this.var_bd5.length; i++) {
				if (this.var_bd5[i].var_874) {
					this.var_bd5[i].var_80c = (-6 + 4
							* A_MenuBase.sub_f9b(this.var_c35[i]) >> 10);
					this.var_c35[i] = ((this.var_c35[i] + 10) % 360);
				}
			}
		}
	}

	public final void sub_3363() {
		this.var_b3d = true;
		this.var_c25 = (this.var_b55 - this.var_b5d);
		this.var_b65 = this.var_b5d;
		int k;
		for (int i = 0; i < this.var_c25; i++) {
			this.var_b15.sub_145e8(this.var_bd5[i]);
			F_Sprite localClass_f_0451;
			(localClass_f_0451 = F_Sprite.sub_1616(this.var_b15.redsparkSprite, 0,
					0, 0, 1, 0, (byte) 0))
					.setSpritePosition(
							this.var_bd5[i].posX
									+ (this.var_bd5[i].frameWidth - localClass_f_0451.frameWidth)
									/ 2, this.var_b15.someCanHeight);
			localClass_f_0451.var_80c = (this.var_bd5[i].posY
					+ (this.var_bd5[i].frameHeight - localClass_f_0451.frameHeight) / 2 - this.var_b15.someCanHeight);
			this.var_b15.sub_145c5(localClass_f_0451);
			F_Sprite localClass_f_0452;
			for (k = 0; k < 3; k++) {
				(localClass_f_0452 = F_Sprite.sub_1616(
						this.var_b15.bigSmokeSprite, -1 + k, 0,
						E_MainCanvas.sub_1564(-4, -1), 1,
						E_MainCanvas.sub_1544(4) * 50, (byte) 0))
						.setSpritePosition(
								this.var_bd5[i].posX
										+ (this.var_bd5[i].frameWidth - localClass_f_0452.frameWidth)
										/ 2, this.var_bd5[i].posY
										+ this.var_bd5[i].frameHeight
										- localClass_f_0452.frameHeight + 3);
				this.var_b15.sub_145c5(localClass_f_0452);
			}
			(localClass_f_0452 = F_Sprite.sub_1616(this.var_b15.smokeSprite, 0,
					0, -1, 1, 200, (byte) 0))
					.setSpritePosition(
							this.var_bd5[i].posX
									+ (this.var_bd5[i].frameWidth - localClass_f_0452.frameWidth)
									/ 2, this.var_bd5[i].posY
									+ this.var_bd5[i].frameHeight
									- localClass_f_0452.frameHeight + 3);
			this.var_b15.sub_145c5(localClass_f_0452);
		}
		F_Sprite[] arrayOfClass_f_045 = new F_Sprite[this.var_b65];
		System.arraycopy(this.var_bd5, this.var_c25, arrayOfClass_f_045, 0,
				this.var_b65);
		this.var_bd5 = arrayOfClass_f_045;
		F_Sprite localClass_f_0451 = F_Sprite.sub_15c2(""
				+ (this.var_b4d - this.var_b45), 0, -4, (byte) 1);
		int j;
		if (this.var_b5d == 1) {
			j = this.var_bd5[0].posX + this.var_bd5[0].frameWidth / 2;
			k = this.var_bd5[0].posY + this.var_bd5[0].frameHeight + 1;
		} else {
			j = this.var_b15.var_32db / 2;
			if (this.var_b6d == 1) {
				j += this.var_b15.var_32db;
			}
			k = (this.var_b15.var_3bfb + this.var_bfd) / 2;
		}
		localClass_f_0451.setSpritePosition(j, k);
		localClass_f_0451.var_85c = true;
		this.var_b15.sub_145c5(localClass_f_0451);
	}

	public final void sub_35fd(Graphics paramGraphics, int paramInt1,
			int paramInt2) {
		paramGraphics.translate(paramInt1, paramInt2);
		int i = 0;
		int k = 0;
		int m = this.var_c05;
		int n;
		while (k < m) {
			int j = this.var_bfd + paramInt2;
			n = 0;
			int i1 = this.var_c0d;
			while (n < i1) {
				this.var_bdd[this.var_c5d[k][n]].drawImageExt(paramGraphics, i, j);
				j += 24;
				n++;
			}
			i += 24;
			k++;
		}
		if (this.var_be5 != null) {
			k = this.var_be5.imageWidth;
			i = 0;
			m = 0;
			n = this.var_b15.var_32db / k;
			while (m < n) {
				this.var_be5.drawImageExt(paramGraphics, i, 0);
				i += k;
				m++;
			}
		}
		paramGraphics.translate(-paramInt1, -paramInt2);
	}

	public final void sub_3734(Graphics paramGraphics) {
		int i = this.var_b15.someCanHeight - I_Game.var_32c3 / 2;
		E_MainCanvas.drawCharedString(paramGraphics, this.var_c1d + "/" + 100,
				this.var_b15.var_32db / 2, i, 1, 3);
	}

	public final void sub_3788(Graphics paramGraphics) {
		paramGraphics.setColor(4210752);
		for (int i = 0; i < this.var_b65; i++) {
			F_Sprite localClass_f_045 = this.var_bd5[i];
			if ((this.var_b25 == 0) || (this.var_b25 == 4)
					|| (this.var_b25 == 5) || (this.var_b25 == 6)) {
				paramGraphics.fillArc(localClass_f_045.posX,
						localClass_f_045.posY + localClass_f_045.frameHeight * 4
								/ 5, localClass_f_045.frameWidth,
						localClass_f_045.frameHeight / 4, 0, 360);
			}
		}
	}

	static {
		new byte[] { 18 }[1] = -18;
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_g_066
 * 
 * JD-Core Version: 0.7.0.1
 */