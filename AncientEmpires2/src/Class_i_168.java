import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class Class_i_168 extends Class_a_000 implements Runnable {
	
	public String var_32bb = "?";
	public static byte var_32c3 = 32;
	public int var_32cb;
	public int var_32d3;
	public int var_32db;
	public int var_32e3;
	public int var_32eb = 0;
	public static String[] var_32f3 = new String[12];
	public static int[] var_32fb = { 4, 5, 6, 7, 8, 9, 10, 11 };
	public boolean[] var_3303;
	public static final short[] var_330b = { 500, 1000, 2000 };
	public static final short[] var_3313 = { 10, 20, 25 };
	public int var_331b;
	public int var_3323;
	public byte var_332b;
	public static int var_3333 = 1024;
	public static int var_333b = 2048;
	public String[] var_3343 = { Class_a_000.sub_c99(66),
			Class_a_000.sub_c99(70), Class_a_000.sub_c99(71),
			Class_a_000.sub_c99(4), Class_a_000.sub_c99(60) };
	public String[] var_334b = { Class_a_000.sub_c99(63),
			Class_a_000.sub_c99(67), Class_a_000.sub_c99(68),
			Class_a_000.sub_c99(62), Class_a_000.sub_c99(69),
			Class_a_000.sub_c99(61), Class_a_000.sub_c99(64) };
	public Class_h_017[] var_3353;
	public String[] var_335b = { Class_a_000.sub_c99(1),
			Class_a_000.sub_c99(2), Class_a_000.sub_c99(5),
			Class_a_000.sub_c99(3), Class_a_000.sub_c99(6),
			Class_a_000.sub_c99(8), Class_a_000.sub_c99(7),
			Class_a_000.sub_c99(9), Class_a_000.sub_c99(10),
			Class_a_000.sub_c99(11), Class_a_000.sub_c99(4) };
	public Class_h_017[] var_3363;
	public String[] var_336b = { Class_a_000.sub_c99(35),
			Class_a_000.sub_c99(36), Class_a_000.sub_c99(37) };
	public String[] var_3373 = { Class_a_000.sub_c99(29),
			Class_a_000.sub_c99(30) };
	public byte[] var_337b = { 0, 6, 5, 7, 8, 9 };
	public byte[] var_3383 = { 0, 6, 5, 7, 8, 9 };
	public byte[] var_338b = { 1, 2, 3, 4 };
	public static final byte[][] var_3393 = { { 0, 1 }, { 2, 3, 4 }, { 0, 1 },
			{ 5 } };
	public static final byte[] var_339b = { 0 };
	public long var_33a3 = 0L;
	public long var_33ab;
	public static final int[][][] var_33b3 = {
			new int[0][],
			{ { 150, 217, 244 }, { 65, 149, 233 }, { 0, 100, 198 },
					{ 12, 53, 112 } },
			{ { 244, 158, 156 }, { 219, 36, 113 }, { 161, 0, 112 },
					{ 95, 5, 120 } },
			{ { 171, 237, 90 }, { 99, 190, 37 }, { 0, 153, 55 }, { 0, 85, 82 } },
			{ { 0, 118, 150 }, { 0, 65, 114 }, { 0, 43, 75 }, { 0, 22, 48 } } };
	public static final int[] var_33bb = { 10526880, 26054, 15204434, 39473,
			16754 };
	public static final int[] var_33c3 = { -1, 2, 3, 2, 3 };
	public static final int[] var_33cb = { -1, 4, 5, 4, 5 };
	public Class_f_045[][] var_33d3;
	public static final byte[] var_33db = { 1, 2 };
	public static final byte[] var_33e3 = { 0, 5, 10, 10, 15, 0, 5, 15, 15, 15 };
	public static final byte[] var_33eb = { 1, 1, 2, 2, 3, 3, 1, 1, 1, 1 };
	public int var_33f3;
	public Class_h_017[] var_33fb;
	public byte[] var_3403;
	public int var_340b;
	public int var_3413;
	public int var_341b;
	public int var_3423;
	public int var_342b;
	public int var_3433;
	private Class_h_017 var_343b;
	public Class_h_017[] var_3443;
	public Class_f_045 var_344b;
	public Class_f_045 var_3453;
	public Class_f_045 var_345b;
	public Class_f_045 var_3463;
	public Class_f_045 var_346b;
	public Class_f_045 var_3473;
	public Class_f_045 var_347b;
	public Class_f_045 var_3483;
	public Class_f_045 var_348b;
	public Class_f_045 var_3493;
	public Class_f_045 var_349b;
	public Class_f_045 var_34a3;
	public int var_34ab;
	public int var_34b3;
	public byte[][] var_34bb;
	public byte var_34c3;
	public byte var_34cb;
	public long var_34d3;
	public int var_34db;
	public int var_34e3;
	public int var_34eb;
	public Class_c_032[] var_34f3;
	public Class_c_032 var_34fb;
	public int var_3503;
	public int var_350b;
	public byte[][] var_3513;
	public boolean var_351b = false;
	public boolean var_3523 = false;
	public boolean var_352b = true;
	public Vector var_3533 = new Vector();
	public Vector var_353b;
	public int var_3543;
	public int var_354b;
	public long var_3553;
	public byte var_355b = 2;
	public byte[] var_3563 = new byte[5];
	public byte[] var_356b = new byte[4];
	public byte[] var_3573 = new byte[4];
	public byte var_357b = 0;
	public short var_3583;
	public Class_c_032[] var_358b;
	public Class_c_032[][] var_3593;
	public int[] var_359b;
	public int[] var_35a3 = new int[4];
	public byte[][] var_35ab = new byte[4][2];
	public byte[] var_35b3 = new byte[4];
	public Class_d_023 var_35bb;
	public Vector var_35c3 = new Vector();
	public Vector var_35cb = new Vector();
	public Class_c_032 var_35d3;
	public Class_c_032 var_35db;
	public long var_35e3;
	public Class_c_032 var_35eb;
	public byte var_35f3;
	public long var_35fb;
	public int var_3603;
	public boolean var_360b = false;
	public boolean var_3613 = false;
	public byte var_361b = 4;
	public Class_h_017 var_3623;
	public Class_h_017 var_362b;
	public Class_h_017 var_3633;
	public Class_h_017 var_363b;
	public int var_3643;
	public boolean var_364b = false;
	public int var_3653;
	public int var_365b;
	public int var_3663;
	public int var_366b;
	public long var_3673;
	public Class_c_032 var_367b;
	public Class_c_032 var_3683;
	public boolean var_368b = true;
	public long var_3693;
	public boolean var_369b = false;
	public long var_36a3;
	public int var_36ab;
	public int var_36b3;
	public Class_h_017[] var_36bb;
	public boolean var_36c3 = false;
	public boolean var_36cb;
	public static int[] var_36d3 = { 83, 83, 83, 83, 83, 83, 83, 83, 175, 84,
			84, 84, 175, 147, 159, 151, 155, 167, 171 };
	public int var_36db = -1;
	public Class_d_023 var_36e3;
	public Class_d_023 var_36eb;
	public Class_d_023 var_36f3;
	public Class_d_023 var_36fb;
	public int var_3703 = 8;
	public Class_d_023 var_370b;
	public Class_d_023 var_3713;
	public Class_d_023 var_371b;
	public boolean var_3723 = false;
	public int var_372b;
	public byte[][] var_3733;
	public byte[][] var_373b;
	public Class_f_045 var_3743;
	public Class_f_045 var_374b;
	public Class_c_032 var_3753;
	public Class_f_045 var_375b;
	public Class_f_045 var_3763;
	public int var_376b;
	public int var_3773;
	public int var_377b;
	public boolean var_3783 = true;
	public int var_378b;
	public boolean var_3793;
	public Class_f_045 var_379b;
	public Class_f_045[] var_37a3;
	public Class_f_045 var_37ab;
	public Class_d_023 var_37b3;
	public Class_d_023 var_37bb;
	public Class_d_023 var_37c3;
	public Class_d_023 var_37cb;
	public Class_d_023[] var_37d3;
	public Class_d_023[] var_37db;
	public Class_d_023 var_37e3;
	public Class_d_023[] var_37eb;
	public Class_f_045 var_37f3;
	public int var_37fb;
	public boolean var_3803;
	public boolean var_380b;
	public boolean var_3813;
	public Vector var_381b = new Vector(2);
	public Class_f_045 var_3823;
	public int var_382b;
	public Class_f_045[] var_3833;
	public Class_d_023 var_383b;
	public Class_d_023 var_3843;
	public Class_d_023 var_384b;
	public Class_d_023 var_3853;
	public Class_f_045 var_385b;
	public Class_f_045 var_3863;
	public Class_c_032 var_386b;
	public int var_3873 = 0;
	public boolean var_387b = true;
	public boolean var_3883;
	public String var_388b;
	public String[] var_3893;
	public byte[] var_389b;
	public int[] var_38a3;
	public Class_d_023 var_38ab;
	public Class_d_023 var_38b3;
	public Class_d_023 var_38bb;
	public Class_d_023 var_38c3;
	public Class_d_023 var_38cb;
	public Class_d_023 var_38d3;
	public Class_d_023 var_38db;
	public byte var_38e3;
	public byte[] var_38eb;
	public int var_38f3;
	public String[] var_38fb;
	public int[] var_3903;
	public String[] var_390b = { Class_a_000.sub_c99(46),
			Class_a_000.sub_c99(47) };
	public String[] var_3913 = { Class_a_000.sub_c99(48),
			Class_a_000.sub_c99(49) };
	public Class_d_023 var_391b;
	public Class_d_023 var_3923;
	public Class_d_023 var_392b;
	public Class_d_023 var_3933;
	public Class_d_023 var_393b;
	public Class_d_023 var_3943;
	public Class_d_023 var_394b;
	public Class_d_023 var_3953;
	public int var_395b;
	public String var_3963;
	public int var_396b;
	public boolean var_3973 = true;
	public boolean var_397b = true;
	public boolean var_3983 = true;
	public Class_h_017 var_398b;
	public Image[][] var_3993;
	public int var_399b;
	public static final String[] var_39a3 = { "14281428", "18241824" };
	public StringBuffer var_39ab = new StringBuffer();
	public Class_c_032 var_39b3;
	public int var_39bb = 12;
	public int var_39c3 = 1;
	public boolean var_39cb;
	public int var_39d3;
	public int var_39db;
	public int var_39e3;
	public int var_39eb;
	public int var_39f3;
	public Class_h_017 var_39fb;
	public String[] var_3a03;
	public boolean var_3a0b;
	public byte var_3a13;
	public int var_3a1b;
	public int var_3a23;
	public int var_3a2b;
	public int var_3a33 = 0;
	public int var_3a3b;
	public int var_3a43 = 24;
	public int var_3a4b = 8;
	public int var_3a53 = this.var_3a4b >> 1;
	public int var_3a5b;
	public static final byte[] var_3a63 = { 0, 2, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3 };
	public byte var_3a6b = 0;
	public int var_3a73;
	public int var_3a7b;
	public Class_c_032 var_3a83;
	public Class_c_032 var_3a8b;
	public Class_c_032 var_3a93;
	public int var_3a9b;
	public long var_3aa3;
	public Class_c_032[] var_3aab;
	public Class_c_032[] var_3ab3;
	public byte[] var_3abb;
	public int[][] var_3ac3;
	public int[] var_3acb;
	public int var_3ad3;
	public byte[][] var_3adb;
	public int var_3ae3;
	public int var_3aeb;
	public int var_3af3;
	public int var_3afb;
	public int var_3b03;
	public Vector var_3b0b;
	public boolean var_3b13 = false;
	public int var_3b1b;
	public Class_d_023 var_3b23;
	public Class_c_032 var_3b2b;
	public Class_c_032 var_3b33;
	public Class_c_032 var_3b3b;
	public Class_c_032 var_3b43;
	public Class_c_032 var_3b4b;
	public Class_c_032 var_3b53;
	public int var_3b5b;
	public long var_3b63;
	public int var_3b6b;
	public boolean var_3b73 = false;
	public boolean var_3b7b = false;
	public int var_3b83 = -1;
	public int var_3b8b = -1;
	public int var_3b93 = 0;
	public Class_g_066 var_3b9b;
	public Class_g_066 var_3ba3;
	public long var_3bab;
	public boolean var_3bb3;
	public Vector var_3bbb = new Vector();
	public boolean var_3bc3 = false;
	public long var_3bcb;
	public long var_3bd3;
	public boolean var_3bdb;
	public boolean var_3be3;
	public boolean var_3beb;
	public boolean var_3bf3;
	public int var_3bfb;
	public int var_3c03;
	public int var_3c0b;
	public String[] var_3c13;
	public String[] var_3c1b;
	public String[] var_3c23;
	public String[] var_3c2b;
	public String[] var_3c33;
	public int[] var_3c3b;
	public String var_3c43 = "Macrospace";
	public String var_3c4b = "msaeii";
	public String var_3c53 = "http://msaeii.scores.macrospace.com/connectx/in";
	private ByteArrayOutputStream var_3c5b;
	private DataOutputStream var_3c63;
	public int var_3c6b;
	public boolean var_3c73;
	public Class_a_000 var_3c7b;
	public int var_3c83;

	public Class_i_168() {
		this.var_3353 = new Class_h_017[this.var_334b.length];
		this.var_3363 = new Class_h_017[this.var_335b.length];
		this.var_37a3 = new Class_f_045[0];
		this.var_39b3 = null;
		this.var_3b4b = null;
		this.var_3b53 = null;
	}

	public final void sub_3fd8() throws Exception {
		sub_46da(0);
		Class_e_034.sub_25e4("");
		sub_46da(18);
		Class_e_034.sub_238e();
		for (int i = 0; i < Class_e_034.musicNames.length; i++) {
			Class_e_034.sub_23bc(i);
			sub_46da(19 + i);
		}
		sub_46da(28);
		Class_d_023.var_fe5 = this;
		sub_46da(29);
		Class_a_000.sub_ef4();
		sub_46da(30);
		Class_e_034.sub_2168();
		sub_46da(32);
		this.var_3353 = new Class_f_045("action_icons").var_7c4;
		sub_46da(34);
		this.var_3363 = new Class_f_045("menu_icons").var_7c4;
		sub_46da(36);
		this.var_375b = new Class_f_045("hud_icons");
		sub_46da(38);
		this.var_3763 = new Class_f_045("hud_icons_2");
		sub_46da(40);
		this.var_3463 = new Class_f_045("arrow");
		sub_46da(42);
		this.var_345b = new Class_f_045("side_arrow");
		sub_46da(44);
		this.var_346b = new Class_f_045("buttons");
		sub_46da(46);
		this.var_3473 = new Class_f_045("menu");
		sub_46da(48);
		this.var_3743 = new Class_f_045("big_circle");
		sub_46da(50);
		this.var_374b = new Class_f_045("small_circle");
		sub_46da(52);
		this.var_349b = new Class_f_045("small_spark");
		sub_46da(54);
		this.var_37f3 = new Class_f_045("alpha");
		sub_46da(56);
		try {
			this.var_398b = new Class_h_017("gameover");
		} catch (Exception localException1) {
		}
		sub_46da(58);
		this.var_3623 = new Class_h_017("ms_logo");
		sub_46da(62);
		DataInputStream localDataInputStream;
		int j = (localDataInputStream = new DataInputStream(
				Class_e_034.sub_278a("tiles0.prop"))).readShort();
		localDataInputStream.readShort();
		this.var_3403 = new byte[j];
		for (int k = 0; k < j; k++) {
			this.var_3403[k] = localDataInputStream.readByte();
		}
		localDataInputStream.close();
		sub_46da(64);
		Class_f_045 localClass_f_045 = new Class_f_045("stiles0");
		this.var_33fb = localClass_f_045.var_7c4;
		sub_46da(70);
		this.var_379b = new Class_f_045("mini_icons");
		sub_46da(72);
		this.var_33f3 = 37;
		this.var_32cb = this.var_7a3;
		this.var_32d3 = this.var_7ab;
		this.var_32db = (this.var_32cb >> 1);
		this.var_32e3 = (this.var_32d3 >> 1);
		this.var_3643 = 0;
		for (int m = 0; m < 12; m++) {
			var_32f3[m] = Class_a_000.sub_c99(101 + m);
		}
		sub_5471();
		sub_46da(74);
		try {
			this.var_32eb = Class_e_034.sub_15af("settings", 1)[0];
		} catch (Exception localException2) {
		}
		sub_46da(76);
		this.var_38fb = new String[0];
		this.var_3903 = new int[0];
		try {
			byte[] arrayOfByte = Class_e_034.sub_15af("settings", 2);
			localDataInputStream = new DataInputStream(
					new ByteArrayInputStream(arrayOfByte));
			this.var_38f3 = localDataInputStream.readInt();
			this.var_3903 = new int[this.var_38f3];
			this.var_38fb = new String[this.var_38f3];
			for (int i1 = 0; i1 < this.var_38f3; i1++) {
				this.var_3903[i1] = localDataInputStream.readInt();
				this.var_38fb[i1] = localDataInputStream.readUTF();
			}
			localDataInputStream.close();
		} catch (Exception localException3) {
		}
		sub_46da(80);
		this.var_396b = Class_e_034.sub_1709("download");
		sub_46da(84);
		this.var_3893 = new String[3];
		this.var_389b = new byte[3];
		this.var_38a3 = new int[3];
		byte[] localObject;
		for (int n = 0; n < 3; n++) {
			this.var_389b[n] = -1;
			this.var_38a3[n] = -1;
			localObject = null;
			try {
				localObject = Class_e_034.sub_15af("save", n);
			} catch (Exception localException4) {
			}
			if ((localObject == null) || (localObject.length == 0)) {
				this.var_3893[n] = ("\n" + Class_a_000.sub_c99(79) + "\n ");
			} else {
				int i2 = (localDataInputStream = new DataInputStream(
						new ByteArrayInputStream((byte[]) localObject)))
						.readByte();
				int i3 = localDataInputStream.readByte();
				localDataInputStream.readByte();
				localDataInputStream.readByte();
				byte i4 = localDataInputStream.readByte();
				int i5 = localDataInputStream.readShort();
				localDataInputStream.close();
				this.var_389b[n] = i4;
				this.var_3893[n] = sub_4700(i2, i3, i5);
				this.var_38a3[n] = i3;
			}
		}
		sub_46da(90);
		int n = 0;
		String localObject1;
		if ((localObject1 = Class_b_001.var_101
				.getAppProperty("ProvisionX-Highscore-gameCode")) != null) {
			this.var_3c4b = ((String) localObject1).trim();
		}
		if ((localObject1 = Class_b_001.var_101
				.getAppProperty("ProvisionX-Highscore-portalCode")) != null) {
			this.var_3c43 = ((String) localObject1).trim();
		}
		if ((localObject1 = Class_b_001.var_101
				.getAppProperty("ProvisionX-Highscore-Url")) != null) {
			this.var_3c53 = ((String) localObject1).trim();
		}
		if ((localObject1 = Class_b_001.var_101
				.getAppProperty("ms-highscoreUpload")) != null) {
			this.var_3973 = (Integer.parseInt(((String) localObject1).trim()) == 1);
		}
		if ((localObject1 = Class_b_001.var_101.getAppProperty("ms-skPos")) != null) {
			n = Integer.parseInt(((String) localObject1).trim());
		}
		if ((localObject1 = Class_b_001.var_101
				.getAppProperty("MIDlet-Version")) != null) {
			this.var_32bb = ((String) localObject1).trim();
		}
		sub_46da(96);
		if (n == 1) {
			var_3333 = 2048;
			var_333b = 1024;
		}
		sub_46da(100);
		Class_e_034.sub_24ab(0, 0);
		this.var_361b = 0;
	}

	public final void sub_46da(int paramInt) {
		this.var_399b = paramInt;
		Class_a_000.var_79b.sub_1ab4();
	}

	public final String sub_4700(int paramInt1, int paramInt2, int paramInt3) {
		String str1;
		if (paramInt1 == 0) {
			str1 = Class_a_000.sub_c99(121 + paramInt2);
		} else {
			str1 = sub_618f(paramInt2);
		}
		return  Class_a_000.sub_c99(32 + paramInt1) + "\n" + str1 + "\n"
				+ "Current turn: " + (paramInt3 + 1); // slot description
	}

	public final boolean sub_4789() {
		return (this.var_3783) && (Class_a_000.var_79b.var_13d4 == this);
	}

	public final void sub_47c9() throws Exception {
		this.var_3623 = null;
		this.var_362b = null;
		this.var_3633 = null;
		this.var_363b = null;
		System.gc();
		this.var_32d3 = (this.var_7ab - var_32c3);
		this.var_32e3 = (this.var_32d3 >> 1);
		Class_e_034.sub_2459();
		if (this.var_361b == 1) {
			return;
		}
		this.var_361b = 1;
		Class_c_032.sub_2745(this);
		Class_e_034.sub_25e4("/1.pak");
		this.var_33d3 = new Class_f_045[5][12];
		Class_f_045 localClass_f_045;
		int i;
		for (byte b = 0; b < 5; b = (byte) (b + 1)) {
			int j = (localClass_f_045 = new Class_f_045("unit_icons", b))
					.sub_106a() / 12;
			for (i = 0; i < 12; i = (byte) (i + 1)) {
				Class_h_017[] arrayOfClass_h_0172;
				if (b == 0) {
					arrayOfClass_h_0172 = new Class_h_017[] { localClass_f_045.var_7c4[i] };
					this.var_33d3[b][i] = new Class_f_045(arrayOfClass_h_0172);
				} else {
					arrayOfClass_h_0172 = new Class_h_017[j];
					for (int k = 0; k < j; k++) {
						arrayOfClass_h_0172[k] = localClass_f_045.var_7c4[(k * 12 + i)];
					}
					this.var_33d3[b][i] = new Class_f_045(arrayOfClass_h_0172);
				}
			}
		}
		Class_h_017[] arrayOfClass_h_0171 = (localClass_f_045 = new Class_f_045(
				"tiles0")).var_7c4;
		this.var_33f3 = arrayOfClass_h_0171.length;
		Class_h_017[] arrayOfClass_h_0172 = new Class_h_017[10];
		Class_f_045 localObject;
		for (byte b = 0; b <= 4; b = (byte) (b + 1)) {
			localObject = new Class_f_045("buildings", b);
			for (i = 0; i < 2; i = (byte) (i + 1)) {
				arrayOfClass_h_0172[(b * 2 + i)] = localObject.var_7c4[i];
			}
		}
		this.var_3443 = new Class_h_017[arrayOfClass_h_0171.length
				+ arrayOfClass_h_0172.length];
		System.arraycopy(arrayOfClass_h_0171, 0, this.var_3443, 0,
				arrayOfClass_h_0171.length);
		System.arraycopy(arrayOfClass_h_0172, 0, this.var_3443, this.var_33f3,
				arrayOfClass_h_0172.length);
		this.var_3993 = new Image[2][this.var_3443.length];
		for (byte b = 0; b < 2; b = (byte) (b + 1)) {
			for (byte i1 = 0; i1 < this.var_3443.length; i1 = (byte) (i1 + 1)) {
				this.var_3993[b][i1] = Image.createImage(24, 24);
				Graphics localObject1 = this.var_3993[b][i1].getGraphics();
				this.var_3443[i1].sub_852((Graphics) localObject1, 0, 0);
				this.var_37f3.sub_1209((Graphics) localObject1, b, 0, 0, 0);
			}
		}
		this.var_34a3 = new Class_f_045("portraits");
		this.var_344b = new Class_f_045("cursor");
		this.var_348b = new Class_f_045("redspark");
		this.var_347b = new Class_f_045("smoke");
		this.var_3483 = new Class_f_045("spark");
		this.var_3493 = new Class_f_045("status");
		this.var_385b = new Class_f_045("arrow_icons");
		this.var_343b = new Class_h_017("tombstone");
		this.var_3823 = new Class_f_045("levelup");
		this.var_3833 = new Class_f_045[2];
		this.var_3833[0] = new Class_f_045("king_head_icons");
		this.var_3833[1] = new Class_f_045("king_head_icons", (byte) 0);
		this.var_344b.sub_1134(var_3393[0]);
		this.var_3453 = new Class_f_045(this.var_344b);
		this.var_3453.sub_1134(var_3393[3]);
		this.var_36bb = new Class_h_017[2];
		this.var_36b3 = var_33db[0];
		this.var_36bb[0] = this.var_3443[var_33db[0]];
		this.var_36bb[1] = this.var_3443[var_33db[1]];
		this.var_37ab = new Class_f_045("b_smoke");
	}

	public final void sub_4bfe(int paramInt1, int paramInt2) {
		if ((this.var_332b == 0) && (this.var_361b == 1)
				&& (this.var_34c3 == 0)) {
			int i = 0;
			this.var_39ab.append(paramInt2);
			String str = this.var_39ab.toString();
			for (int j = 0; j < var_39a3.length; j++) {
				if (str.equals(var_39a3[j])) {
					if (j == 0) {
						if (this.var_34db == 7) {
							this.var_3883 = true;
						} else {
							sub_1442b();
						}
					} else if (j == 1) {
						this.var_35a3[this.var_357b] += 1000;
					}
					this.var_397b = true;
				} else if (var_39a3[j].startsWith(str)) {
					i = 1;
				}
			}
			if (i == 0) {
				this.var_39ab = new StringBuffer();
			}
		}
	}

	public final void sub_4d3f() {
		this.var_397b = true;
		this.var_3983 = true;
		this.var_3bf3 = true;
		this.var_3beb = true;
	}

	public final byte[] sub_4d6e() throws Exception {
		this.var_35ab[this.var_357b][0] = ((byte) this.var_34ab);
		this.var_35ab[this.var_357b][1] = ((byte) this.var_34b3);
		ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream localDataOutputStream;
		(localDataOutputStream = new DataOutputStream(
				localByteArrayOutputStream)).writeByte(this.var_332b);
		localDataOutputStream.writeByte(this.var_34db);
		localDataOutputStream.writeByte(this.var_355b);
		localDataOutputStream.writeByte(this.var_357b);
		localDataOutputStream.writeByte(this.var_356b[this.var_357b]);
		localDataOutputStream.writeShort(this.var_3583);
		localDataOutputStream.writeByte(this.var_3703);
		localDataOutputStream.writeByte(this.var_355b);
		for (int i = 0; i < this.var_355b; i++) {
			localDataOutputStream.writeByte(this.var_3573[i]);
			localDataOutputStream.writeByte(this.var_35b3[i]);
			localDataOutputStream.writeShort(this.var_35a3[i]);
			localDataOutputStream.writeByte(this.var_35ab[i][0]);
			localDataOutputStream.writeByte(this.var_35ab[i][1]);
		}
		localDataOutputStream.writeByte(this.var_3323);
		for (int i = 0; i < this.var_3733.length; i++) {
			localDataOutputStream
					.writeByte(this.var_34bb[this.var_3733[i][0]][this.var_3733[i][1]]);
		}
		localDataOutputStream.writeByte(this.var_3533.size());
		int i = 0;
		int j = this.var_3533.size();
		while (i < j) {
			Class_c_032 localClass_c_032 = (Class_c_032) this.var_3533
					.elementAt(i);
			localDataOutputStream.writeByte(localClass_c_032.var_ac3);
			localDataOutputStream.writeByte(localClass_c_032.var_acb);
			localDataOutputStream.writeByte(localClass_c_032.var_b13);
			localDataOutputStream.writeByte(localClass_c_032.var_b1b);
			localDataOutputStream.writeByte(localClass_c_032.var_b0b);
			localDataOutputStream.writeByte(localClass_c_032.var_a93);
			localDataOutputStream.writeShort(localClass_c_032.var_a9b);
			localDataOutputStream.writeShort(localClass_c_032.var_ad3);
			localDataOutputStream.writeShort(localClass_c_032.var_adb);
			localDataOutputStream.writeByte(localClass_c_032.var_b5b);
			localDataOutputStream.writeByte(localClass_c_032.var_b63);
			if (localClass_c_032.var_ac3 == 9) {
				localDataOutputStream.writeByte(localClass_c_032.var_b7b);
				localDataOutputStream.writeShort(localClass_c_032.var_b8b);
				localDataOutputStream
						.writeByte(this.var_358b[localClass_c_032.var_acb] == localClass_c_032 ? 1
								: 0);
			}
			i++;
		}
		localDataOutputStream.writeShort((short) this.var_3b5b);
		localDataOutputStream.writeInt((short) (int) this.var_3b63);
		localDataOutputStream.writeInt(this.var_3b6b);
		localDataOutputStream.writeByte(this.var_3b73 ? 0 : 1);
		byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
		localDataOutputStream.close();
		return arrayOfByte;
	}

	public final void sub_5053(byte[] paramArrayOfByte) throws Exception {
		DataInputStream localDataInputStream = new DataInputStream(
				new ByteArrayInputStream(paramArrayOfByte));
		this.var_332b = localDataInputStream.readByte();
		this.var_34db = localDataInputStream.readByte();
		this.var_355b = localDataInputStream.readByte();
		sub_881b(this.var_34db);
		this.var_357b = localDataInputStream.readByte();
		localDataInputStream.readByte();
		this.var_3583 = localDataInputStream.readShort();
		this.var_3703 = localDataInputStream.readByte();
		this.var_355b = localDataInputStream.readByte();
		for (int i = 0; i < this.var_355b; i++) {
			this.var_3573[i] = localDataInputStream.readByte();
			this.var_35b3[i] = localDataInputStream.readByte();
			this.var_35a3[i] = localDataInputStream.readShort();
			this.var_35ab[i][0] = localDataInputStream.readByte();
			this.var_35ab[i][1] = localDataInputStream.readByte();
		}
		this.var_3323 = localDataInputStream.readByte();
		for (int i = 0; i < this.var_3733.length; i++) {
			this.var_34bb[this.var_3733[i][0]][this.var_3733[i][1]] = localDataInputStream
					.readByte();
		}
		this.var_3593 = new Class_c_032[this.var_355b][4];
		this.var_359b = new int[this.var_355b];
		sub_87e6();
		byte i = localDataInputStream.readByte();
		int j = 0;
		int k = i;
		while (j < k) {
			byte b1 = localDataInputStream.readByte();
			byte b2 = localDataInputStream.readByte();
			byte b3 = localDataInputStream.readByte();
			byte b4 = localDataInputStream.readByte();
			int m = localDataInputStream.readByte();
			byte b5 = localDataInputStream.readByte();
			int n = localDataInputStream.readShort();
			int i1 = localDataInputStream.readShort();
			int i2 = localDataInputStream.readShort();
			byte b6 = localDataInputStream.readByte();
			byte b7 = localDataInputStream.readByte();
			Class_c_032 localClass_c_032;
			(localClass_c_032 = Class_c_032.sub_d3d(b1, b2, i1, i2)).var_b13 = b3;
			localClass_c_032.var_a9b = n;
			localClass_c_032.sub_c72(b5);
			localClass_c_032.var_b1b = b4;
			localClass_c_032.sub_1211();
			localClass_c_032.var_b0b = ((short) m);
			localClass_c_032.var_b5b = b6;
			localClass_c_032.var_b63 = b7;
			if (b1 == 9) {
				int i3 = localDataInputStream.readByte();
				int i4 = localDataInputStream.readShort();
				localClass_c_032.sub_e33(i3);
				localClass_c_032.var_b8b = i4;
				int i5 = localDataInputStream.readByte();
				if (i5 == 1) {
					this.var_358b[localClass_c_032.var_acb] = localClass_c_032;
				}
			}
			j++;
		}
		this.var_3b5b = localDataInputStream.readShort();
		this.var_3b63 = localDataInputStream.readInt();
		this.var_3b6b = localDataInputStream.readInt();
		this.var_3b73 = (localDataInputStream.readByte() != 0);
		localDataInputStream.close();
		if ((this.var_34db == 6) && (this.var_3b5b > 32)) {
			this.var_36fb = sub_10c0e(Class_a_000.sub_c99(121 + this.var_34db),
					Class_a_000.sub_c99(138), this.var_32d3, -1);
			this.var_36fb.sub_1301((byte) 0, true);
			this.var_36fb.sub_1323(null);
		}
		sub_bba8(this.var_35ab[this.var_357b][0],
				this.var_35ab[this.var_357b][1]);
		sub_b9c5(this.var_35ab[this.var_357b][0],
				this.var_35ab[this.var_357b][1]);
		Class_e_034.sub_2439(var_33c3[this.var_356b[this.var_357b]], 0);
	}

	public final void sub_53b1(int paramInt, Class_a_000 paramClass_a_000) {
		try {
			Class_e_034.sub_15e7("save", paramInt, sub_4d6e());
			this.var_3893[paramInt] = sub_4700(this.var_332b, this.var_34db,
					this.var_3583);
			this.var_389b[paramInt] = this.var_356b[this.var_357b];
			this.var_38a3[paramInt] = this.var_34db;
			this.var_38c3.sub_1ceb(null, this.var_3893[paramInt],
					this.var_32cb, -1);
			this.var_38c3.var_1175 = var_33bb[this.var_389b[paramInt]];
			this.var_38c3.sub_1245();
			Class_d_023 localClass_d_023;
			(localClass_d_023 = sub_10c0e(null, Class_a_000.sub_c99(77),
					this.var_32d3, 1000)).var_10ed = paramClass_a_000;
			Class_a_000.var_79b.sub_1a8c(localClass_d_023);
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_5471() {
		try {
			byte[] arrayOfByte = Class_e_034.sub_15af("settings", 0);
			for (int i = 0; i < 4; i++) {
				Class_e_034.var_141c[i] = ((arrayOfByte[0] & 1 << i) != 0 ? true
						: false);
			}
			return;
		} catch (Exception localException) {
		}
	}

	public final void sub_5501() {
		try {
			byte[] arrayOfByte = new byte[1];
			for (int i = 0; i < 4; i++) {
				if (Class_e_034.var_141c[i] != false) {
					int tmp21_20 = 0;
					byte[] tmp21_19 = arrayOfByte;
					tmp21_19[tmp21_20] = ((byte) (tmp21_19[tmp21_20] | 1 << i));
				}
			}
			Class_e_034.sub_15e7("settings", 0, arrayOfByte);
			return;
		} catch (Exception localException) {
		}
	}

	public final void sub_558c(Class_c_032 paramClass_c_032) {
		this.var_3873 = 0;
		sub_bba8(paramClass_c_032.var_ad3, paramClass_c_032.var_adb);
		this.var_386b = paramClass_c_032;
	}

	public final void sub_55bd(Class_c_032 paramClass_c_0321,
			Class_c_032 paramClass_c_0322) {
		if (paramClass_c_0322.var_b13 == 4) {
			this.var_35db = paramClass_c_0322;
			sub_5873(this.var_348b, this.var_35db.var_7dc,
					this.var_35db.var_7e4, 0, 0, 1, 50);
			this.var_3603 = 6;
			this.var_34fb.sub_2352();
			this.var_34c3 = 0;
			sub_90fd();
			this.var_344b.sub_1134(var_3393[0]);
			if (this.var_35b3[this.var_357b] == 0) {
				this.var_3aa3 = this.var_34d3;
				this.var_3a6b = 6;
			}
		} else {
			if ((Class_e_034.var_141c[3] != false)
					&& (paramClass_c_0322.var_aa3.length > 0)) {
				this.var_364b = true;
				this.var_3653 = 0;
				Class_e_034.sub_2459();
			} else {
				this.var_34c3 = 13;
				this.var_366b = 0;
				this.var_344b.sub_1134(var_3393[0]);
			}
			this.var_367b = paramClass_c_0321;
			this.var_3683 = paramClass_c_0322;
		}
	}

	public final void sub_56c3() {
		sub_90fd();
		if (this.var_367b.var_b0b <= 0) {
			this.var_35d3 = this.var_367b;
		} else if (this.var_367b.sub_10da()) {
			this.var_381b.addElement(this.var_367b);
		}
		if (this.var_3683.var_b0b <= 0) {
			this.var_35d3 = this.var_3683;
		} else {
			if (this.var_367b.sub_232f((short) 128)) {
				sub_5873(this.var_3483, this.var_3683.var_7dc,
						this.var_3683.var_7e4, 0, 0, 1, 50);
				Class_f_045 localClass_f_045;
				(localClass_f_045 = Class_f_045.sub_1616(this.var_3493, 0, 0,
						-4, -1, 800, (byte) 5)).sub_10c6(this.var_3683.var_7dc
						+ (this.var_3683.var_7f4 - localClass_f_045.var_7f4)
						/ 2, this.var_3683.var_7e4 - localClass_f_045.var_7fc);
				localClass_f_045.sub_1134(var_339b);
				this.var_35c3.addElement(localClass_f_045);
				this.var_3683.sub_119a((byte) 1);
			}
			if (this.var_3683.sub_10da()) {
				this.var_381b.addElement(this.var_3683);
			}
		}
		if (this.var_35d3 != null) {
			sub_bba8(this.var_35d3.var_ad3, this.var_35d3.var_adb);
			sub_5873(this.var_3483, this.var_35d3.var_7dc,
					this.var_35d3.var_7e4, 0, 0, 1, 50);
			Class_e_034.sub_24ab(12, 1);
		}
		this.var_35e3 = this.var_34d3;
		if (this.var_35b3[this.var_357b] == 0) {
			this.var_3aa3 = this.var_34d3;
			this.var_3a6b = 6;
		}
		this.var_344b.sub_1134(var_3393[0]);
		this.var_34c3 = 0;
		this.var_367b.sub_2352();
		this.var_3683 = null;
		this.var_367b = null;
	}

	public final Class_f_045 sub_5873(Class_f_045 paramClass_f_045,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			int paramInt5, int paramInt6) {
		Class_f_045 localClass_f_045;
		(localClass_f_045 = Class_f_045.sub_1616(paramClass_f_045, paramInt3,
				paramInt4, 0, paramInt5, paramInt6, (byte) 0)).sub_10c6(
				paramInt1, paramInt2);
		this.var_35cb.addElement(localClass_f_045);
		return localClass_f_045;
	}

	public final void sub_58af(Class_c_032 paramClass_c_032) {
		this.var_3613 = true;
		this.var_360b = (!this.var_3723);
		this.var_39d3 = 12;
		this.var_34c3 = 1;
		this.var_369b = true;
		sub_913d(this.var_3513, 0);
		paramClass_c_032.sub_1d3c(this.var_3513);
		this.var_351b = true;
		this.var_3523 = false;
		this.var_344b.sub_1134(var_3393[2]);
	}

	public final void sub_593d(byte[] paramArrayOfByte, int paramInt1,
			int paramInt2, Class_a_000 paramClass_a_000) {
		Class_d_023 localClass_d_023 = new Class_d_023((byte) 0, 0);
		this.var_376b = paramInt1;
		this.var_3773 = paramInt2;
		int i = paramArrayOfByte.length;
		Vector localVector1 = new Vector(i);
		Vector localVector2 = new Vector(i);
		for (int j = 0; j < i; j++) {
			int k = paramArrayOfByte[j];
			if ((this.var_3973) || (k != 6)) {
				localVector1.addElement(this.var_335b[k]);
				localVector2.addElement(this.var_3363[k]);
			}
		}
		String[] arrayOfString = new String[localVector1.size()];
		Class_h_017[] arrayOfClass_h_017 = new Class_h_017[localVector2.size()];
		localVector1.copyInto(arrayOfString);
		localVector2.copyInto(arrayOfClass_h_017);
		localClass_d_023.sub_22eb(arrayOfString, arrayOfClass_h_017,
				this.var_7b3, this.var_376b, this.var_3773, 3, (byte) 1);
		localClass_d_023.sub_1323(paramClass_a_000);
		Class_a_000.var_79b.sub_1a8c(localClass_d_023);
	}

	public final void sub_5a85(byte[] paramArrayOfByte,
			Class_c_032 paramClass_c_032) {
		this.var_35bb = new Class_d_023((byte) 0, 0);
		int i;
		String[] arrayOfString = new String[i = paramArrayOfByte.length];
		Class_h_017[] arrayOfClass_h_017 = new Class_h_017[i];
		for (int j = 0; j < paramArrayOfByte.length; j++) {
			arrayOfString[j] = this.var_334b[paramArrayOfByte[j]];
			arrayOfClass_h_017[j] = this.var_3353[paramArrayOfByte[j]];
		}
		if (this.var_34b3 * 24 <= this.var_32d3 / 2 - 24) {
			this.var_35bb.sub_1e97(arrayOfString, arrayOfClass_h_017, 0,
					this.var_32d3 - this.var_346b.var_7fc, 36);
		} else {
			this.var_35bb.sub_1e97(arrayOfString, arrayOfClass_h_017,
					this.var_32cb, 0, 8);
		}
		this.var_35bb.sub_1323(this);
		Class_a_000.var_79b.sub_1a8c(this.var_35bb);
	}

	public final Class_d_023 sub_5ba0(String paramString,
			Class_h_017 paramClass_h_017) {
		String[] arrayOfString = new String[3];
		for (int i = 0; i < 3; i++) {
			arrayOfString[i] = ("SLOT " + (i + 1) + "/" + 3);
		}
		this.var_38bb = new Class_d_023((byte) 14, 0);
		this.var_38bb.sub_1fcf(arrayOfString, this.var_32cb, -1);
		this.var_38c3 = new Class_d_023((byte) 10, 0);
		this.var_38c3.sub_1ceb(null, this.var_3893[0], this.var_32cb, -1);
		if (this.var_389b[0] != -1) {
			this.var_38c3.var_1175 = var_33bb[this.var_389b[0]];
		}
		Class_d_023 localClass_d_0231 = new Class_d_023((byte) 15, 15);
		int j = (this.var_32d3 - this.var_38bb.var_1015 - this.var_38c3.var_1015) / 2;
		Class_d_023 localClass_d_0232;
		(localClass_d_0232 = new Class_d_023((byte) 10, 0)).sub_1ceb(null,
				paramString, this.var_32cb, -1);
		localClass_d_0232.var_1185 = paramClass_h_017;
		localClass_d_0231.sub_169b(localClass_d_0232, 0, 0, 0);
		j += localClass_d_0232.var_1015 / 2;
		localClass_d_0231.sub_169b(this.var_38bb, 0, j, 0);
		j += this.var_38bb.var_1015;
		localClass_d_0231.sub_169b(this.var_38c3, 0, j, 20);
		localClass_d_0231.var_112d = true;
		localClass_d_0231.sub_1301((byte) 0, true);
		return localClass_d_0231;
	}

	public final void sub_5d1a(Class_a_000 paramClass_a_000) {
		int i;
		String[] arrayOfString = new String[i = this.var_3c2b.length];
		int[] arrayOfInt1 = new int[i];
		int j = 0;
		for (int k = 0; k < i; k++) {
			int m = 0;
			for (int n = 0; n < this.var_38f3; n++) {
				if (this.var_3c2b[k].equals(this.var_38fb[n])) {
					m = 1;
					break;
				}
			}
			if (m == 0) {
				arrayOfString[j] = this.var_3c2b[k];
				arrayOfInt1[j] = k;
				j++;
			}
		}
		this.var_3943 = new Class_d_023((byte) 15, 15);
		Class_d_023 localClass_d_023;
		(localClass_d_023 = new Class_d_023((byte) 10, 0)).sub_1ceb(null,
				Class_a_000.sub_c99(48), this.var_32cb, -1);
		Class_d_023 localObject;
		if (j == 0) {
			localObject = new Class_d_023((byte) 10, 0);
			localObject.sub_1ceb(null, Class_a_000.sub_c99(52), this.var_32cb,
					this.var_32e3);
			this.var_3943.sub_169b((Class_d_023) localObject, 0,
					(this.var_32d3 + localClass_d_023.var_1015) / 2, 6);
		} else {
			String[] localObject1;
			localObject1 = new String[j];
			int[] arrayOfInt2 = new int[j];
			System.arraycopy(arrayOfString, 0, localObject1, 0, j);
			System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, j);
			this.var_3953 = new Class_d_023((byte) 10, 0);
			String str = sub_6218(this.var_396b);
			this.var_3953.sub_1ceb(
					null,
					Class_a_000.sub_e44(54,
							sub_6218(this.var_3c3b[arrayOfInt2[0]]))
							+ "\n"
							+ Class_a_000.sub_e44(53, str), this.var_32cb, -1);
			this.var_394b = new Class_d_023((byte) 11, 0);
			this.var_394b.sub_212d((String[]) localObject1, this.var_32db,
					this.var_32e3, this.var_32cb, this.var_32d3
							- localClass_d_023.var_1015
							- this.var_3953.var_1015, 3, 4);
			this.var_394b.var_1195 = arrayOfInt2;
			int i1 = (this.var_32d3 - this.var_3953.var_1015
					- this.var_394b.var_1015 + localClass_d_023.var_1015) / 2;
			this.var_3943.sub_169b(this.var_394b, 0, i1, 20);
			i1 += this.var_394b.var_1015;
			this.var_3943.sub_169b(this.var_3953, 0, i1, 20);
			this.var_3943.var_112d = true;
			this.var_3943.sub_1301((byte) 0, true);
		}
		this.var_3943.sub_169b(localClass_d_023, 0, 0, 20);
		this.var_3943.sub_1323(paramClass_a_000);
	}

	public final Class_d_023 sub_5fed(Class_a_000 paramClass_a_000) {
		Class_d_023 localClass_d_0231;
		if (this.var_38fb.length == 0) {
			Class_d_023 localClass_d_0232;
			(localClass_d_0232 = (localClass_d_0231 = new Class_d_023(
					(byte) 10, 0)).sub_165e(Class_a_000.sub_c99(49))).var_1185 = this.var_3363[6];
			localClass_d_0231.sub_1ceb(null, Class_a_000.sub_c99(52),
					this.var_7a3, -1);
			localClass_d_0231.sub_193f(0,
					(this.var_32d3 + localClass_d_0232.var_1015) / 2, 6);
			localClass_d_0231.sub_1323(paramClass_a_000);
			this.var_3933 = null;
			return localClass_d_0231;
		}
		this.var_3933 = new Class_d_023((byte) 11, 0);
		(localClass_d_0231 = this.var_3933.sub_165e(Class_a_000.sub_c99(49))).var_1185 = this.var_3363[6];
		this.var_3933
				.sub_212d(this.var_38fb, this.var_7a3 / 2,
						(this.var_32d3 + localClass_d_0231.var_1015) / 2,
						this.var_32cb, this.var_32d3
								- localClass_d_0231.var_1015, 3, 4);
		this.var_3933.sub_1323(paramClass_a_000);
		return this.var_3933;
	}

	public final int sub_60ce(int paramInt) {
		if (paramInt >= var_32f3.length) {
			return this.var_3903[(paramInt - var_32f3.length)]
					+ var_32f3.length;
		}
		return paramInt;
	}

	public final DataInputStream sub_6115(int paramInt) throws Exception {
		if (paramInt >= var_32f3.length) {
			int i = paramInt - var_32f3.length;
			return new DataInputStream(new ByteArrayInputStream(
					Class_e_034.sub_15af("download", i)));
		}
		return new DataInputStream(Class_e_034.sub_278a("s" + paramInt));
	}

	public final String sub_618f(int paramInt) {
		if (paramInt >= var_32f3.length) {
			int i = paramInt - var_32f3.length;
			for (int j = 0; j < this.var_3903.length; j++) {
				if (this.var_3903[j] == i) {
					return this.var_38fb[j];
				}
			}
			return null;
		}
		return var_32f3[paramInt];
	}

	public final String sub_6218(int paramInt) {
		int i;
		int j = (i = paramInt * 100 / 1024) / 100;
		int k = i % 100;
		return j + "." + k;
	}

	public final void sub_6260(Class_d_023 paramClass_d_023, int paramInt,
			String paramString, byte paramByte) throws Exception {
		this.var_3c73 = true;
		if ((paramClass_d_023 == this.var_35bb) && (paramByte == 1)) {
			if (this.var_34c3 == 3) {
				this.var_34fb.sub_128b(this.var_3503, this.var_350b);
				this.var_34fb.sub_1d3c(this.var_3513);
				sub_58af(this.var_34fb);
				this.var_369b = true;
			}
			return;
		}
		if (paramClass_d_023 == this.var_38cb) {
			if (paramByte == 0) {
				Class_a_000.var_79b.sub_2148();
				return;
			}
			this.var_38cb = null;
			return;
		}
		if (paramClass_d_023 == this.var_38d3) {
			if (paramByte == 0) {
				sub_593d(this.var_338b, this.var_376b, this.var_3773,
						paramClass_d_023.var_10ed);
			}
			this.var_38d3 = null;
			return;
		}
		if (paramClass_d_023 == this.var_38db) {
			if (paramByte == 0) {
				int i = this.var_38bb.var_102d;
				sub_53b1(i, this.var_38b3);
			}
			this.var_38db = null;
			return;
		}
		if (paramClass_d_023 == this.var_384b) {
			if ((paramByte == 2) || (paramByte == 3)) {
				this.var_3853
						.sub_1ceb(
								null,
								Class_a_000
										.sub_c99(184 + this.var_384b.var_107d[paramInt].var_ac3),
								this.var_32cb, this.var_32d3
										- this.var_3843.var_1015
										- this.var_384b.var_1015);
				this.var_3843.var_10dd = this.var_384b.var_107d[paramInt];
				this.var_3853.sub_1245();
				this.var_3843.sub_1245();
			}
			return;
		}
		Object localObject1;
		if (paramClass_d_023 == this.var_383b) {
			if (paramByte == 0) {
				localObject1 = this.var_384b.var_107d[this.var_384b.var_102d];
				if (sub_e9d0((Class_c_032) localObject1, this.var_34ab,
						this.var_34b3)) {
					this.var_34fb = sub_8722((Class_c_032) localObject1,
							this.var_34ab, this.var_34b3);
					this.var_3723 = true;
					sub_58af(this.var_34fb);
					Class_a_000.var_79b.sub_1a8c(this);
				} else {
					return;
				}
			}
			this.var_383b = null;
			this.var_384b = null;
			this.var_3853 = null;
			this.var_3843 = null;
			return;
		}
		if (paramClass_d_023 == this.var_36eb) {
			if ((paramByte == 2) || (paramByte == 3)) {
				if (paramInt == 0) {
					localObject1 = Class_a_000.sub_c99(15);
				} else {
					localObject1 = Class_a_000
							.sub_cb9(196 + paramInt - 1, true);
				}
				this.var_36f3.sub_1ceb(null, (String) localObject1,
						this.var_32cb, this.var_36f3.var_1015);
				this.var_36f3.sub_1245();
			}
			return;
		}
		if (paramClass_d_023 == this.var_36e3) {
			this.var_36e3 = null;
			this.var_36eb = null;
			this.var_36f3 = null;
			return;
		}
		if (paramClass_d_023 == this.var_36fb) {
			if (paramByte == 0) {
				Class_a_000.var_79b.sub_1a8c(this);
			}
			return;
		}
		Class_d_023 localObject6;
		String[] localObject7;
		int i15;
		if (paramClass_d_023 == this.var_37b3) {
			if (paramByte == 0) {
				this.var_37bb = new Class_d_023((byte) 15, 15);
				Class_d_023 localObject11;
				(localObject11 = new Class_d_023((byte) 10, 0)).var_1185 = this.var_3363[4];
				((Class_d_023) localObject11).sub_1ceb(null,
						Class_a_000.sub_c99(34), this.var_32cb, -1);
				this.var_37bb.sub_169b((Class_d_023) localObject11, 0, 0, 20);
				String[] arrayOfString1 = new String[this.var_38e3];
				for (int i3 = 0; i3 < this.var_38e3; i3++) {
					arrayOfString1[i3] = Class_a_000.sub_e44(38, "" + (i3 + 1));
				}
				int i3 = ((Class_d_023) localObject11).var_1015;
				Class_d_023[] arrayOfClass_d_023 = new Class_d_023[this.var_38e3];
				this.var_37d3 = new Class_d_023[this.var_38e3];
				this.var_37db = new Class_d_023[this.var_38e3];
				for (int i9 = 0; i9 < this.var_38e3; i9++) {
					this.var_37d3[i9] = new Class_d_023((byte) 14, 6);
					this.var_37d3[i9].sub_1fcf(this.var_336b, this.var_7b3, -1);
					this.var_37db[i9] = new Class_d_023((byte) 14, 5);
					this.var_37db[i9]
							.sub_1fcf(arrayOfString1, this.var_7b3, -1);
					this.var_37db[i9].var_102d = i9;
					int i11 = Math.max(this.var_37d3[i9].var_100d,
							this.var_37db[i9].var_100d);
					int i12 = this.var_7a3 - i11;
					this.var_37d3[i9].var_100d = i11;
					this.var_37db[i9].var_100d = i11;
					this.var_37bb.sub_169b(this.var_37d3[i9], i12, i3, 20);
					i3 += this.var_37d3[i9].var_1015;
					this.var_37bb.sub_169b(this.var_37db[i9], i12, i3, 20);
					i3 += this.var_37db[i9].var_1015;
					arrayOfClass_d_023[i9] = new Class_d_023((byte) 10, 8);
					arrayOfClass_d_023[i9].sub_1ceb(null,
							Class_a_000.sub_c99(this.var_38eb[i9] - 1 + 89),
							i12, this.var_37d3[i9].var_1015
									+ this.var_37db[i9].var_1015);
					arrayOfClass_d_023[i9].var_1175 = var_33bb[this.var_38eb[i9]];
					this.var_37bb.sub_169b(arrayOfClass_d_023[i9], 0, i3, 36);
				}
				this.var_37bb.var_111d = 1;
				(localObject6 = new Class_d_023((byte) 10, 8)).sub_1ceb(null,
						Class_a_000.sub_c99(40), this.var_32db, -1);
				this.var_37bb.sub_169b((Class_d_023) localObject6, 0, i3, 20);
				this.var_37c3 = new Class_d_023((byte) 14, 4);
				localObject7 = new String[var_330b.length];
				for (int i12 = 0; i12 < localObject7.length; i12++) {
					localObject7[i12] = ("" + var_330b[i12]);
				}
				this.var_37c3.sub_1fcf((String[]) localObject7, this.var_32db,
						((Class_d_023) localObject6).var_1015);
				this.var_37bb.sub_169b(this.var_37c3, this.var_7b3, i3, 20);
				i3 += ((Class_d_023) localObject6).var_1015;
				Class_d_023 localClass_d_0235;
				(localClass_d_0235 = new Class_d_023((byte) 10, 8)).sub_1ceb(
						null, Class_a_000.sub_c99(41), this.var_32db, -1);
				this.var_37bb.sub_169b(localClass_d_0235, 0, i3, 20);
				this.var_37cb = new Class_d_023((byte) 14, 4);
				String[] arrayOfString3 = new String[var_3313.length];
				for (i15 = 0; i15 < arrayOfString3.length; i15++) {
					arrayOfString3[i15] = ("" + var_3313[i15]);
				}
				this.var_37cb.sub_1fcf(arrayOfString3, this.var_32db,
						localClass_d_0235.var_1015);
				this.var_37bb.sub_169b(this.var_37cb, this.var_7b3, i3, 20);
				this.var_37bb.sub_1323(paramClass_d_023);
				this.var_37bb.sub_1301((byte) 0, true);
				Class_a_000.var_79b.sub_1a8c(this.var_37bb);
				return;
			}
			this.var_37b3 = null;
			return;
		}
		int j;
		if (paramClass_d_023 == this.var_37bb) {
			if (paramByte == 0) {
				j = 0;
				int n = 0;
				boolean[] arrayOfBoolean = new boolean[this.var_38e3];
				for (int i6 = 0; i6 < this.var_38e3; i6++) {
					if (this.var_37d3[i6].var_102d == 2) {
						this.var_35b3[i6] = 2;
					} else {
						j++;
						if (this.var_37d3[i6].var_102d == 0) {
							this.var_35b3[i6] = 1;
						} else if (this.var_37d3[i6].var_102d == 1) {
							this.var_35b3[i6] = 0;
						}
						this.var_3573[i6] = ((byte) this.var_37db[i6].var_102d);
						if (arrayOfBoolean[this.var_3573[i6]] == false) {
							n++;
							arrayOfBoolean[this.var_3573[i6]] = true;
						}
					}
				}
				if ((j < 2) || (n < 2)) {
					Class_d_023 localClass_d_0234;
					(localClass_d_0234 = sub_10c0e(null,
							Class_a_000.sub_c99(39), this.var_32d3, 2000))
							.sub_1323(this.var_37bb);
					Class_a_000.var_79b.sub_1a8c(localClass_d_0234);
					return;
				}
				this.var_37bb = null;
				this.var_37b3 = null;
				Class_a_000.var_79b.sub_1a8c(this);
				this.var_331b = var_330b[this.var_37c3.var_102d];
				this.var_3323 = var_3313[this.var_37cb.var_102d];
				this.var_37d3 = null;
				this.var_37c3 = null;
				this.var_37cb = null;
				this.var_332b = 1;
				this.var_3703 = 8;
				this.var_36c3 = true;
				Class_a_000.var_79b.sub_1ab4();
				sub_47c9();
				sub_881b(this.var_34e3);
				this.var_34db = this.var_34e3;
				this.var_36c3 = false;
				this.var_34c3 = 0;
			}
			return;
		}
		int i4;
		int i7;
		if (paramClass_d_023 == this.var_3713) {
			j = this.var_370b.var_102d;
			if ((paramByte == 0)
					&& ((j >= var_32f3.length) || (this.var_3303[j] == false))) {
				this.var_34e3 = sub_60ce(j);
				DataInputStream localDataInputStream;
				i4 = (localDataInputStream = sub_6115(this.var_34e3)).readInt();
				i7 = localDataInputStream.readInt();
				byte[][] localObject61 = new byte[i4][i7];
				this.var_38eb = new byte[4];
				byte[] localObject71 = new byte[5];
				for (int i13 = 0; i13 < 5; i13++) {
					localObject71[i13] = -1;
				}
				this.var_38e3 = 0;
				for (int i13 = 0; i13 < i4; i13++) {
					for (int i14 = 0; i14 < i7; i14++) {
						localObject61[i13][i14] = localDataInputStream
								.readByte();
						if ((this.var_3403[localObject61[i13][i14]] == 9)
								&& ((i15 = sub_e22b(i13, i14,
										(byte[][]) localObject61)) != 0)
								&& (localObject71[i15] == -1)) {
							this.var_38eb[this.var_38e3] = ((byte) i15);
							localObject71[i15] = this.var_38e3;
							this.var_38e3 = ((byte) (this.var_38e3 + 1));
						}
					}
				}
				localDataInputStream.close();
				this.var_388b = this.var_370b.var_fed[j];
				this.var_37b3 = new Class_d_023((byte) 15, 15);
				Class_d_023 localClass_d_0236;
				(localClass_d_0236 = new Class_d_023((byte) 10, 0)).var_1185 = this.var_3363[4];
				localClass_d_0236.sub_1ceb(null, this.var_388b, this.var_32cb,
						-1);
				Class_d_023 localClass_d_0237;
				(localClass_d_0237 = new Class_d_023((byte) 8, 0)).sub_17fa(
						this.var_7a3, this.var_32d3
								- localClass_d_0236.var_1015
								- this.var_346b.var_7fc,
						(byte[][]) localObject61, null);
				this.var_37b3
						.sub_169b(
								localClass_d_0237,
								this.var_32db,
								this.var_32e3
										+ (localClass_d_0236.var_1015 - this.var_346b.var_7fc)
										/ 2, 3);
				this.var_37b3.sub_169b(localClass_d_0236, 0, 0, 0);
				this.var_37b3.sub_1323(paramClass_d_023);
				this.var_37b3.sub_1301((byte) 0, true);
				this.var_37b3.var_112d = true;
				Class_a_000.var_79b.sub_1a8c(this.var_37b3);
			}
		} else if (paramClass_d_023 == this.var_37e3) {
			if (paramByte == 1) {
				boolean j1 = Class_e_034.var_141c[0];
				int i1 = 0;
				for (i4 = 0; i4 < 4; i4++) {
					boolean i71 = (this.var_37eb[i4].var_102d == 0) ? true
							: false;
					if ((i71) != Class_e_034.var_141c[i4]) {
						Class_e_034.var_141c[i4] = i71;
						i1 = 1;
					}
				}
				if (i1 != 0) {
					sub_5501();
					if (j1 != Class_e_034.var_141c[0]) {
						if (Class_e_034.var_141c[0] == false) {
							Class_e_034.sub_2459();
							return;
						}
						if (this.var_361b == 1) {
							if ((this.var_34c3 != 11) && (this.var_34c3 != 14)) {
								Class_e_034.sub_24ab(
										var_33c3[this.var_356b[this.var_357b]],
										0);
							}
						} else if (this.var_361b == 0) {
							Class_e_034.sub_24ab(0, 0);
						}
					}
				} else {
					this.var_37e3 = null;
					this.var_37eb = null;
				}
			}
			return;
		}
		Object localObject2;
		if (paramClass_d_023 == this.var_38b3) {
			if (paramByte == 0) {
				j = this.var_38bb.var_102d;
				if (this.var_389b[j] == -1) {
					sub_53b1(j, paramClass_d_023);
				} else {
					this.var_38db = sub_10c0e(null, Class_a_000.sub_c99(88),
							this.var_32d3, -1);
					this.var_38db.sub_1301((byte) 0, true);
					this.var_38db.sub_1323(paramClass_d_023);
					Class_a_000.var_79b.sub_1a8c(this.var_38db);
				}
			} else {
				this.var_38b3 = null;
				this.var_38bb = null;
				this.var_38c3 = null;
			}
		} else if (paramClass_d_023 == this.var_38ab) {
			if (paramByte == 0) {
				localObject2 = null;
				try {
					localObject2 = Class_e_034.sub_15af("save",
							this.var_38bb.var_102d);
				} catch (Exception localException) {
				}
				if (localObject2 != null) {
					this.var_38ab = null;
					this.var_38bb = null;
					this.var_38c3 = null;
					Class_a_000.var_79b.sub_1a8c(this);
					this.var_36c3 = true;
					Class_a_000.var_79b.sub_1ab4();
					sub_47c9();
					sub_5053((byte[]) localObject2);
					if (this.var_332b == 0) {
						this.var_3783 = true;
					}
					this.var_36c3 = false;
					this.var_34c3 = 0;
				}
			} else {
				this.var_38ab = null;
				this.var_38bb = null;
				this.var_38c3 = null;
			}
		} else if (paramClass_d_023 == this.var_38bb) {
			if ((paramByte == 2) || (paramByte == 3)) {
				this.var_38c3.sub_1ceb(null, this.var_3893[paramInt],
						this.var_32cb, -1);
				if (this.var_389b[paramInt] == -1) {
					this.var_38c3.var_1175 = 2370117;
				} else {
					this.var_38c3.var_1175 = var_33bb[this.var_389b[paramInt]];
				}
				this.var_38c3.sub_1245();
			}
			return;
		}
		if (paramClass_d_023 == this.var_391b) {
			if (paramByte == 0) {
				if (paramString.equals(this.var_390b[0])) {
					if (this.var_3c13 == null) {
						sub_1500b(0, "news", Class_a_000.sub_c99(0),
								paramClass_d_023);
						return;
					}
					this.var_392b = sub_14c01(this.var_3c13, paramClass_d_023);
					return;
				}
				if (paramString.equals(this.var_390b[1])) {
					this.var_3923 = new Class_d_023((byte) 11, 0);
					Class_d_023 localObject21;
					(localObject21 = this.var_3923.sub_165e(paramString)).var_1185 = this.var_3363[6];
					this.var_3923
							.sub_212d(
									this.var_3913,
									this.var_7a3 / 2,
									(this.var_32d3 + ((Class_d_023) localObject21).var_1015) / 2,
									this.var_32cb,
									this.var_32d3
											- ((Class_d_023) localObject21).var_1015,
									3, 0);
					this.var_3923.sub_1323(paramClass_d_023);
					Class_a_000.var_79b.sub_1a8c(this.var_3923);
				}
			} else if (paramByte == 1) {
				this.var_391b = null;
			}
		} else if (paramClass_d_023 == this.var_3923) {
			if (paramByte == 0) {
				if (paramString.equals(this.var_3913[0])) {
					if (this.var_3c2b == null) {
						sub_1500b(2, "levels", Class_a_000.sub_c99(0),
								paramClass_d_023);
					} else {
						sub_5d1a(paramClass_d_023);
						Class_a_000.var_79b.sub_1a8c(this.var_3943);
					}
				} else if (paramString.equals(this.var_3913[1])) {
					Class_a_000.var_79b.sub_1a8c(sub_5fed(paramClass_d_023));
				}
			} else if (paramByte == 1) {
				this.var_3923 = null;
			}
		} else if (paramClass_d_023 == this.var_392b) {
			if (paramByte == 0) {
				if (this.var_3c23[paramInt] == null) {
					this.var_3c03 = paramInt;
					sub_1500b(1, this.var_3c1b[paramInt],
							Class_a_000.sub_c99(0), paramClass_d_023);
				} else {
					Class_d_023 localObject21;
					(localObject21 = sub_10c33(this.var_3c13[paramInt],
							this.var_3c23[paramInt], this.var_32d3,
							this.var_32d3 / 2, -1)).sub_1323(paramClass_d_023);
					Class_a_000.var_79b.sub_1a8c((Class_a_000) localObject21);
				}
			} else if (paramByte == 1) {
				this.var_392b = null;
			}
		} else if (paramClass_d_023 == this.var_3943) {
			if (paramByte == 0) {
				this.var_3c0b = this.var_394b.var_1195[this.var_394b.var_102d];
				if (this.var_396b >= this.var_3c3b[this.var_3c0b]) {
					sub_1500b(3, this.var_3c33[this.var_3c0b],
							Class_a_000.sub_c99(0), paramClass_d_023);
				} else {
					Class_d_023 localObject21;
					(localObject21 = sub_10c0e(null, Class_a_000.sub_c99(55),
							this.var_32d3, -1)).sub_1323(paramClass_d_023);
					Class_a_000.var_79b.sub_1a8c((Class_a_000) localObject21);
				}
			} else if (paramByte == 1) {
				this.var_3953 = null;
				this.var_394b = null;
				this.var_3943 = null;
			}
		} else if (paramClass_d_023 == this.var_394b) {
			if ((paramByte == 2) || (paramByte == 3)) {
				localObject2 = sub_6218(this.var_396b);
				this.var_3953
						.sub_1ceb(
								null,
								Class_a_000
										.sub_e44(
												54,
												sub_6218(this.var_3c3b[this.var_394b.var_1195[paramInt]]))
										+ "\n"
										+ Class_a_000.sub_e44(53,
												(String) localObject2),
								this.var_32cb, -1);
				this.var_3953.sub_1245();
			}
		} else if (paramClass_d_023 == this.var_3933) {
			if (paramByte == 0) {
				if (this.var_3903[paramInt] + var_32f3.length == this.var_34db) {
					Class_d_023 localObject21;
					(localObject21 = sub_10c0e(null, Class_a_000.sub_c99(56),
							this.var_32d3, -1)).sub_1323(paramClass_d_023);
					Class_a_000.var_79b.sub_1a8c((Class_a_000) localObject21);
				} else {
					this.var_395b = paramInt;
					this.var_3963 = paramString;
					this.var_393b = sub_10c33(null,
							Class_a_000.sub_e44(50, paramString),
							this.var_32d3, this.var_32e3, -1);
					this.var_393b.sub_1323(paramClass_d_023);
					this.var_393b.sub_1301((byte) 0, true);
					Class_a_000.var_79b.sub_1a8c(this.var_393b);
				}
			} else if (paramByte == 1) {
				this.var_3933 = null;
			}
		} else if (paramClass_d_023 == this.var_393b) {
			if (paramByte == 0) {
				sub_15429(this.var_395b);
				localObject2 = sub_5fed(this.var_3933.var_10ed);
				Class_d_023 localObject31;
				(localObject31 = sub_10c0e(null,
						Class_a_000.sub_e44(51, this.var_3963), this.var_32d3,
						-1)).sub_1323((Class_a_000) localObject2);
				Class_a_000.var_79b.sub_1a8c((Class_a_000) localObject31);
			}
			this.var_393b = null;
			this.var_3963 = null;
		}
		if (paramClass_d_023.var_105d == 7) {
			Class_a_000.var_79b.sub_1a8c(this);
			return;
		}
		if ((paramString == null) || (paramByte != 0)) {
			return;
		}
		if (paramString.equals(this.var_335b[0])) {
			if ((this.var_361b == 0) || (this.var_34c3 != 0)) {
				sub_593d(this.var_338b, this.var_376b, this.var_3773,
						paramClass_d_023);
				return;
			}
			this.var_38d3 = sub_10c0e(null, Class_a_000.sub_c99(87),
					this.var_32d3, -1);
			this.var_38d3.sub_1301((byte) 0, true);
			this.var_38d3.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_38d3);
			return;
		}
		if ((paramString.equals(this.var_335b[1]))
				|| (paramClass_d_023 == this.var_371b)) {
			Class_a_000.var_79b.sub_1a8c(this);
			if (paramClass_d_023 == this.var_371b) {
				this.var_34db = paramInt;
				this.var_371b = null;
			} else {
				this.var_34db = 0;
			}
			this.var_332b = 0;
			this.var_35b3[1] = 0;
			this.var_36c3 = true;
			Class_a_000.var_79b.sub_1ab4();
			System.gc();
			sub_47c9();
			sub_881b(this.var_34db);
			this.var_36c3 = false;
			sub_10c83();
			this.var_34c3 = 0;
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(3))) {
			this.var_371b = new Class_d_023((byte) 11, 0);
			int k;
			if ((k = this.var_32eb) > 7) {
				k = 7;
			}
			k++;
			String[] localObject31 = new String[k];
			for (int i41 = 0; i41 < k; i41++) {
				localObject31[i41] = (i41 + 1 + ". " + Class_a_000
						.sub_c99(121 + i41)); // map name in menu
			}
			Class_d_023 localObject51;
			(localObject51 = this.var_371b.sub_165e(paramString)).var_1185 = this.var_3363[3];
			this.var_371b
					.sub_212d(
							(String[]) localObject31,
							this.var_7a3 / 2,
							(this.var_32d3 + ((Class_d_023) localObject51).var_1015) / 2,
							this.var_32cb, this.var_32d3
									- ((Class_d_023) localObject51).var_1015,
							3, 4);
			this.var_371b.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_371b);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(4))) {
			this.var_38b3 = sub_5ba0(paramString, this.var_3363[10]);
			this.var_38b3.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_38b3);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(5))) {
			this.var_38ab = sub_5ba0(paramString, this.var_3363[2]);
			this.var_38ab.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_38ab);
			return;
		}
		Class_d_023 localClass_d_0231;
		int i2;
		if (paramString.equals(Class_a_000.sub_c99(6))) {
			this.var_3713 = new Class_d_023((byte) 15, 15);
			(localClass_d_0231 = new Class_d_023((byte) 10, 0)).sub_1ceb(null,
					paramString, this.var_32cb, -1);
			localClass_d_0231.var_1185 = this.var_3363[4];
			this.var_3303 = new boolean[12];
			for (i2 = this.var_32eb; i2 <= 7; i2++) {
				this.var_3303[var_32fb[i2]] = true;
			}
			String[] localObject51 = new String[12];
			for (i7 = 0; i7 < 12; i7++) {
				if (this.var_3303[i7] != false) {
					localObject51[i7] = Class_a_000.sub_c99(42);
				} else {
					localObject51[i7] = var_32f3[i7];
				}
			}
			String[] arrayOfString2 = new String[12 + this.var_38f3];
			System.arraycopy(localObject51, 0, arrayOfString2, 0, 12);
			System.arraycopy(this.var_38fb, 0, arrayOfString2, 12,
					this.var_38f3);
			this.var_370b = new Class_d_023((byte) 0, 0);
			this.var_370b.sub_212d(arrayOfString2, 0, 0, this.var_32cb,
					this.var_32d3 - localClass_d_0231.var_1015
							- this.var_346b.var_7fc * 2, 3, 4);
			this.var_3713.sub_169b(this.var_370b, this.var_32db,
					(this.var_32d3 + localClass_d_0231.var_1015) / 2, 3);
			this.var_3713.sub_169b(localClass_d_0231, 0, 0, 0);
			this.var_3713.var_112d = true;
			this.var_3713.sub_1301((byte) 0, true);
			this.var_3713.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_3713);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(7))) {
			this.var_391b = new Class_d_023((byte) 11, 0);
			(localClass_d_0231 = this.var_391b.sub_165e(paramString)).var_1185 = this.var_3363[6];
			this.var_391b.sub_212d(this.var_390b, this.var_7a3 / 2,
					(this.var_32d3 + localClass_d_0231.var_1015) / 2,
					this.var_32cb, this.var_32d3 - localClass_d_0231.var_1015,
					3, 0);
			this.var_391b.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_391b);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(8))) {
			this.var_37e3 = new Class_d_023((byte) 15, 15);
			(localClass_d_0231 = new Class_d_023((byte) 10, 0)).var_1185 = this.var_3363[5];
			localClass_d_0231.sub_1ceb(null, paramString, this.var_32cb, -1);
			this.var_37e3.sub_169b(localClass_d_0231, 0, 0, 20);
			i2 = localClass_d_0231.var_1015;
			Class_d_023[] localObject51 = new Class_d_023[4];
			this.var_37eb = new Class_d_023[4];
			for (int i8 = 0; i8 < 4; i8++) {
				int i10 = 8;
				if (i8 != 0) {
					i10 = 9;
				}
				if (i8 != 3) {
					i10 |= 0x2;
				}
				localObject51[i8] = new Class_d_023((byte) 10, i10);
				localObject51[i8].sub_1ceb(null, Class_e_034.var_1424[i8],
						this.var_32db, -1);
				this.var_37e3.sub_169b(localObject51[i8], 0, i2, 20);
				i10 = 4;
				if (i8 != 0) {
					i10 = 5;
				}
				if (i8 != 3) {
					i10 |= 0x2;
				}
				this.var_37eb[i8] = new Class_d_023((byte) 14, i10);
				this.var_37eb[i8].sub_1fcf(this.var_3373, this.var_32db,
						localObject51[i8].var_1015);
				this.var_37eb[i8].var_102d = (Class_e_034.var_141c[i8] != false ? 0
						: 1);
				this.var_37e3.sub_169b(this.var_37eb[i8], this.var_7b3, i2, 20);
				i2 += localObject51[i8].var_1015;
			}
			this.var_37e3.var_111d = 2;
			this.var_37e3.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_37e3);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(9))) {
			this.var_36e3 = new Class_d_023((byte) 15, 15);
			(localClass_d_0231 = new Class_d_023((byte) 10, 0)).sub_1ceb(null,
					paramString, this.var_32cb, -1);
			localClass_d_0231.var_1185 = this.var_3363[7];
			String[] localObject41 = new String[20];
			for (int i5 = 0; i5 <= 19; i5++) {
				if (i5 > 0) {
					localObject41[i5] = (Class_a_000
							.sub_c99(var_36d3[(i5 - 1)]) + " " + i5 + "/" + 19);
				} else {
					localObject41[i5] = (Class_a_000.sub_c99(85) + " " + i5
							+ "/" + 19);
				}
			}
			this.var_36eb = new Class_d_023((byte) 14, 2);
			this.var_36eb.sub_1fcf(localObject41, this.var_32cb, -1);
			this.var_36f3 = new Class_d_023((byte) 10, 1);
			this.var_36f3.sub_1ceb(null, Class_a_000.sub_c99(15),
					this.var_32cb, this.var_32d3 - localClass_d_0231.var_1015
							- this.var_36eb.var_1015 - this.var_346b.var_7fc
							* 2);
			int i5 = localClass_d_0231.var_1015 + this.var_346b.var_7fc;
			this.var_36e3.sub_169b(this.var_36eb, this.var_32db, i5, 17);
			i5 += this.var_36eb.var_1015;
			this.var_36e3.sub_169b(this.var_36f3, this.var_32db, i5, 17);
			this.var_36e3.sub_169b(localClass_d_0231, 0, 0, 0);
			this.var_36e3.sub_1323(paramClass_d_023);
			this.var_36e3.var_112d = true;
			Class_a_000.var_79b.sub_1a8c(this.var_36e3);
			return;
		}
		Class_d_023 localClass_d_0233;
		if (paramString.equals(Class_a_000.sub_c99(10))) {
			localClass_d_0231 = new Class_d_023((byte) 15, 15);
			Class_d_023 localObject41;
			(localObject41 = new Class_d_023((byte) 10, 0)).sub_1ceb(null,
					paramString, this.var_32cb, -1);
			((Class_d_023) localObject41).var_1185 = this.var_3363[8];
			localClass_d_0233 = new Class_d_023((byte) 10, 0);
			String str = Class_a_000.sub_e44(16, this.var_32bb);
			localClass_d_0233.sub_1ceb(null, str, this.var_32cb, this.var_32d3
					- ((Class_d_023) localObject41).var_1015
					- this.var_346b.var_7fc * 2);
			localClass_d_0231
					.sub_169b(
							localClass_d_0233,
							0,
							(this.var_32d3 + ((Class_d_023) localObject41).var_1015) / 2,
							6);
			localClass_d_0231.sub_169b((Class_d_023) localObject41, 0, 0, 0);
			localClass_d_0231.sub_1323(paramClass_d_023);
			localClass_d_0231.var_112d = true;
			Class_a_000.var_79b.sub_1a8c(localClass_d_0231);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(11))) {
			this.var_38cb = sub_10c0e(null, Class_a_000.sub_c99(86),
					this.var_32d3, -1);
			this.var_38cb.sub_1301((byte) 0, true);
			this.var_38cb.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_38cb);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(60))) {
			sub_593d(this.var_3383, this.var_32e3, this.var_32d3,
					paramClass_d_023);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(61))) {
			this.var_3723 = false;
			sub_58af(this.var_34fb);
			Class_a_000.var_79b.sub_1a8c(this);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(62))) {
			sub_913d(this.var_3513, 0);
			this.var_34cb = this.var_34c3;
			this.var_34c3 = 6;
			this.var_369b = true;
			this.var_34f3 = this.var_34fb.sub_15b5(this.var_34fb.var_ad3,
					this.var_34fb.var_adb, (byte) 0);
			this.var_34eb = 0;
			this.var_351b = true;
			this.var_3523 = true;
			this.var_34fb.sub_1359(this.var_3513, this.var_34fb.var_ad3,
					this.var_34fb.var_adb);
			this.var_344b.sub_1134(var_3393[1]);
			sub_bba8(this.var_34f3[this.var_34eb].var_ad3,
					this.var_34f3[this.var_34eb].var_adb);
			this.var_360b = true;
			this.var_3613 = true;
			Class_a_000.var_79b.sub_1a8c(this);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(63))) {
			this.var_383b = new Class_d_023((byte) 15, 15);
			this.var_383b.var_11b5 = this.var_32d3;
			this.var_3843 = new Class_d_023((byte) 2, 2);
			this.var_384b = new Class_d_023((byte) 3, 1);
			this.var_3853 = new Class_d_023((byte) 10, 3);
			this.var_3853.var_1125 = true;
			this.var_3843.var_10dd = this.var_384b.var_107d[0];
			this.var_3853.sub_1ceb(null, Class_a_000
					.sub_c99(184 + this.var_384b.var_107d[0].var_ac3),
					this.var_32cb, this.var_32d3 - this.var_3843.var_1015
							- this.var_384b.var_1015);
			this.var_383b.sub_169b(this.var_3843, 0, 0, 0);
			this.var_383b.sub_169b(this.var_3853, 0, this.var_3843.var_1015, 0);
			this.var_383b.sub_169b(this.var_384b, 0, this.var_32d3, 32);
			this.var_383b.var_112d = true;
			this.var_383b.sub_1323(this);
			this.var_383b.sub_1301((byte) 0, true);
			Class_a_000.var_79b.sub_1a8c(this.var_383b);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(64))) {
			this.var_34fb.sub_2352();
			sub_90fd();
			this.var_3753 = sub_dc52(this.var_34ab, this.var_34b3, (byte) 0);
			this.var_34c3 = 0;
			Class_a_000.var_79b.sub_1a8c(this);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(66))) {
			sub_dd85();
			Class_a_000.var_79b.sub_1a8c(this);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(68))) {
			sub_e185((byte) this.var_33f3, this.var_34fb.var_ad3,
					this.var_34fb.var_adb);
			Class_a_000.var_79b.sub_1a8c(sub_10c0e(null,
					Class_a_000.sub_c99(74), this.var_32d3, 1000));
			Class_e_034.sub_24ab(9, 1);
			this.var_34fb.sub_2352();
			this.var_34c3 = 0;
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(67))) {
			if (sub_e0c8(this.var_34fb.var_ad3, this.var_34fb.var_adb,
					this.var_34fb)) {
				sub_e1a9(this.var_34fb.var_ad3, this.var_34fb.var_adb,
						this.var_356b[this.var_34fb.var_acb]);
				Class_a_000.var_79b.sub_1a8c(sub_10c0e(null,
						Class_a_000.sub_c99(73), this.var_32d3, 1000));
				this.var_34c3 = 9;
				Class_e_034.sub_24ab(9, 1);
				this.var_3553 = this.var_34d3;
			}
			this.var_34fb.sub_2352();
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(69))) {
			this.var_34c3 = 7;
			this.var_34f3 = this.var_34fb.sub_15b5(this.var_34fb.var_ad3,
					this.var_34fb.var_adb, (byte) 1);
			this.var_351b = true;
			this.var_3523 = true;
			this.var_34fb.sub_1359(this.var_3513, this.var_34fb.var_ad3,
					this.var_34fb.var_adb);
			this.var_360b = true;
			Class_a_000.var_79b.sub_1a8c(this);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(70))) {
			Class_d_023 localClass_d_0232 = new Class_d_023((byte) 15, 15);
			Class_d_023 localObject41;
			(localObject41 = new Class_d_023((byte) 10, 0)).sub_1ceb(null,
					this.var_388b, this.var_32cb, -1);
			(localClass_d_0233 = new Class_d_023((byte) 8, 0)).sub_17fa(
					this.var_32cb, this.var_32d3
							- ((Class_d_023) localObject41).var_1015
							- this.var_346b.var_7fc, this.var_34bb,
					this.var_3533);
			localClass_d_0232
					.sub_169b(
							localClass_d_0233,
							this.var_32db,
							this.var_32e3
									+ (((Class_d_023) localObject41).var_1015 - this.var_346b.var_7fc)
									/ 2, 3);
			localClass_d_0232.sub_169b((Class_d_023) localObject41, 0, 0, 0);
			localClass_d_0232.sub_1323(paramClass_d_023);
			localClass_d_0232.var_112d = true;
			Class_a_000.var_79b.sub_1a8c(localClass_d_0232);
			return;
		}
		if (paramString.equals(Class_a_000.sub_c99(71))) {
			this.var_36fb.sub_1301((byte) 0, false);
			this.var_36fb.sub_1323(paramClass_d_023);
			Class_a_000.var_79b.sub_1a8c(this.var_36fb);
		}
	}

	public final Class_c_032 sub_8722(Class_c_032 paramClass_c_032,
			int paramInt1, int paramInt2) {
		this.var_35a3[this.var_357b] -= paramClass_c_032.var_b8b;
		paramClass_c_032.var_b0b = 100;
		paramClass_c_032.sub_128b(paramInt1, paramInt2);
		if (!this.var_3533.contains(paramClass_c_032)) {
			this.var_3533.addElement(paramClass_c_032);
		}
		this.var_397b = true;
		return paramClass_c_032;
	}

	public final Class_c_032 sub_8788(byte paramByte, int paramInt1,
			int paramInt2) {
		this.var_35a3[this.var_357b] -= Class_c_032.var_bcb[paramByte];
		this.var_397b = true;
		return Class_c_032.sub_d3d(paramByte, this.var_357b, paramInt1,
				paramInt2);
	}

	public final Class_f_045 sub_87c3(byte paramByte1, byte paramByte2) {
		return this.var_33d3[paramByte1][paramByte2];
	}

	public final void sub_87e6() {
		this.var_3533 = new Vector();
		this.var_34fb = null;
		this.var_34f3 = null;
		this.var_39b3 = null;
	}

	public final void sub_881b(int paramInt) throws Exception {
		Class_e_034.sub_2459();
		this.var_35c3 = new Vector();
		this.var_3803 = false;
		this.var_352b = true;
		this.var_364b = false;
		this.var_3883 = false;
		this.var_353b = null;
		this.var_35d3 = null;
		this.var_386b = null;
		this.var_35db = null;
		this.var_35eb = null;
		this.var_381b.removeAllElements();
		this.var_3583 = 0;
		this.var_357b = 0;
		this.var_357b = 0;
		this.var_3b5b = 0;
		sub_87e6();
		this.var_358b = null;
		this.var_34bb = ((byte[][]) null);
		this.var_3513 = ((byte[][]) null);
		this.var_355b = 0;
		for (int i = 0; i < 5; i++) {
			this.var_3563[i] = -1;
		}
		this.var_369b = true;
		Class_e_034.sub_25e4("/1.pak");
		DataInputStream localDataInputStream;
		if (this.var_332b == 0) {
			this.var_388b = Class_a_000.sub_c99(113 + paramInt);
			localDataInputStream = new DataInputStream(Class_e_034.sub_278a("m"
					+ paramInt));
		} else {
			this.var_388b = sub_618f(paramInt);
			localDataInputStream = sub_6115(paramInt);
		}
		this.var_342b = localDataInputStream.readInt();
		this.var_3433 = localDataInputStream.readInt();
		this.var_34bb = new byte[this.var_342b][this.var_3433];
		this.var_3513 = new byte[this.var_342b][this.var_3433];
		this.var_3adb = new byte[this.var_342b][this.var_3433];
		this.var_3ae3 = 0;
		int k = 0;
		byte[][] arrayOfByte1 = new byte[30][3];
		byte[][] arrayOfByte2 = new byte[30][2];
		int m;
		for (short i = 0; i < this.var_342b; i = (short) (i + 1)) {
			for (int j = 0; j < this.var_3433; j = (short) (j + 1)) {
				this.var_34bb[i][j] = localDataInputStream.readByte();
				this.var_3513[i][j] = 0;
				if ((this.var_34bb[i][j] >= this.var_33f3)
						|| (this.var_34bb[i][j] == 27)) {
					m = sub_e206(i, j);
					arrayOfByte1[k][0] = ((byte) i);
					arrayOfByte1[k][1] = ((byte) j);
					arrayOfByte1[k][2] = ((byte) m);
					k++;
					if (sub_dd5d(i, j) == 9) {
						if ((this.var_332b == 1) && (m != 0)
								&& (this.var_3563[m] == -1)) {
							this.var_356b[this.var_355b] = ((byte) m);
							this.var_3563[m] = this.var_355b;
							this.var_355b = ((byte) (this.var_355b + 1));
						}
						arrayOfByte2[this.var_3ae3][0] = ((byte) i);
						arrayOfByte2[this.var_3ae3][1] = ((byte) j);
						this.var_3ae3 += 1;
					}
				}
			}
		}
		this.var_3acb = new int[k];
		this.var_3733 = new byte[k][];
		for (short i = 0; i < k; i = (short) (i + 1)) {
			this.var_3733[i] = arrayOfByte1[i];
		}
		this.var_373b = new byte[this.var_3ae3][2];
		System.arraycopy(arrayOfByte2, 0, this.var_373b, 0, this.var_3ae3);
		this.var_340b = (this.var_342b * 24);
		this.var_3413 = (this.var_3433 * 24);
		if (this.var_332b == 1) {
			for (short i = 0; i < this.var_355b; i = (short) (i + 1)) {
				this.var_35a3[i] = this.var_331b;
			}
		}
		this.var_355b = 2;
		this.var_35a3[0] = 0;
		this.var_35a3[1] = 0;
		this.var_3563[1] = 0;
		this.var_3563[2] = 1;
		this.var_356b[0] = 1;
		this.var_356b[1] = 2;
		this.var_3573[0] = 0;
		this.var_3573[1] = 1;
		this.var_35b3[0] = 1;
		this.var_35b3[1] = 0;
		this.var_3323 = 100;
		for (short i = 0; i < this.var_3733.length; i = (short) (i + 1)) {
			if (((m = this.var_3733[i][2]) > 0)
					&& (this.var_35b3[sub_e276(m)] == 2)) {
				sub_e1a9(this.var_3733[i][0], this.var_3733[i][1], 0);
			}
		}
		int m1 = localDataInputStream.readInt();
		localDataInputStream.skip(m1 * 4);
		int n = localDataInputStream.readInt();
		this.var_358b = new Class_c_032[this.var_355b];
		this.var_3593 = new Class_c_032[this.var_355b][4];
		this.var_359b = new int[this.var_355b];
		for (short i = 0; i < n; i = (short) (i + 1)) {
			int i1 = localDataInputStream.readByte();
			int i2 = localDataInputStream.readShort() / 24;
			int i3 = localDataInputStream.readShort() / 24;
			byte b1 = (byte) (i1 % 12);
			byte b2 = (byte) sub_e276(1 + i1 / 12);
			if (this.var_35b3[b2] != 2) {
				Class_c_032 localClass_c_032 = Class_c_032.sub_d3d(b1, b2, i2,
						i3);
				if (b1 == 9) {
					this.var_358b[b2] = localClass_c_032;
				}
			}
		}
		localDataInputStream.close();
		if (this.var_332b == 0) {
			this.var_36fb = sub_10c0e(Class_a_000.sub_c99(121 + this.var_34db),
					Class_a_000.sub_c99(129 + this.var_34db), this.var_32d3, -1);
		} else {
			this.var_36fb = sub_10c0e(Class_a_000.sub_c99(71),
					Class_a_000.sub_c99(137), this.var_32d3, -1);
		}
		this.var_3b7b = false;
		this.var_3b4b = null;
		this.var_3b2b = null;
		this.var_3b33 = null;
		this.var_3b3b = null;
		this.var_3b43 = null;
		this.var_3b53 = null;
		for (short i = 0; i < this.var_358b.length; i = (short) (i + 1)) {
			if (this.var_358b[i] == null) {
				this.var_35ab[i][0] = 0;
				this.var_35ab[i][1] = 0;
			} else {
				this.var_35ab[i][0] = ((byte) this.var_358b[i].var_ad3);
				this.var_35ab[i][1] = ((byte) this.var_358b[i].var_adb);
			}
		}
		if (this.var_332b == 1) {
			this.var_3b5b = 100;
			this.var_3783 = true;
			for (short i = 0; i < this.var_355b; i = (short) (i + 1)) {
				if (this.var_35b3[i] != 2) {
					this.var_357b = ((byte) i);
					break;
				}
				this.var_3583 = ((short) (this.var_3583 + 1));
			}
		}
		if (this.var_358b[this.var_357b] != null) {
			sub_b9c5(this.var_358b[this.var_357b].var_ad3,
					this.var_358b[this.var_357b].var_adb);
			sub_bba8(this.var_358b[this.var_357b].var_ad3,
					this.var_358b[this.var_357b].var_adb);
		}
		this.var_3ab3 = new Class_c_032[this.var_3733.length];
		this.var_3abb = new byte[this.var_3733.length];
		this.var_37a3 = new Class_f_045[this.var_3733.length];
		for (short i = 0; i < this.var_3733.length; i = (short) (i + 1)) {
			if (sub_dd5d(this.var_3733[i][0], this.var_3733[i][1]) == 8) {
				this.var_37a3[i] = Class_f_045.sub_1616(this.var_37ab, 0, -1,
						0, 1, 250, (byte) 0);
				this.var_37a3[i].var_84c = false;
			}
		}
		if (this.var_35b3[this.var_357b] == 0) {
			sub_ea76();
		}
	}

	public final void sub_90fd() {
		this.var_34eb = 0;
		this.var_34fb = null;
		this.var_34f3 = new Class_c_032[0];
		sub_913d(this.var_3513, 0);
		this.var_351b = false;
		this.var_3523 = false;
	}

	public final void sub_913d(byte[][] paramArrayOfByte, int paramInt) {
		for (int i = 0; i < this.var_342b; i++) {
			for (int j = 0; j < this.var_3433; j++) {
				paramArrayOfByte[i][j] = ((byte) paramInt);
			}
		}
	}

	public final void sub_91c4(Class_c_032 paramClass_c_032) {
		Class_e_034.sub_2573(10);
		this.var_39b3 = null;
		sub_913d(this.var_3513, 0);
		this.var_351b = false;
		if (this.var_35b3[this.var_357b] == 1) {
			this.var_39c3 = 1;
			this.var_352b = true;
			this.var_344b.sub_1134(var_3393[0]);
			this.var_34c3 = 3;
			sub_5a85(sub_9267(paramClass_c_032, (byte) 0), paramClass_c_032);
			Class_e_034.sub_24ab(11, 1);
			return;
		}
		if (this.var_35b3[this.var_357b] == 0) {
			this.var_3a6b = 4;
			this.var_34c3 = 0;
		}
	}

	public final byte[] sub_9267(Class_c_032 paramClass_c_032, byte paramByte) {
		int i = 0;
		byte[] arrayOfByte = new byte[this.var_334b.length];
		if ((paramByte == 1)
				&& (sub_dd5d(this.var_34fb.var_ad3, this.var_34fb.var_adb) == 9)
				&& (sub_e312(this.var_34fb.var_ad3, this.var_34fb.var_adb,
						paramClass_c_032.var_acb))) {
			arrayOfByte[(i++)] = 0;
		}
		arrayOfByte[(i++)] = 2;
		if (sub_e0c8(paramClass_c_032.var_ad3, paramClass_c_032.var_adb,
				paramClass_c_032)) {
			arrayOfByte[(i++)] = (byte) (sub_e065(paramClass_c_032.var_ad3,
					paramClass_c_032.var_adb, paramClass_c_032) ? 0 : 1);
		}
		if (((paramByte == 1) || (paramClass_c_032.var_ac3 != 7))
				&& (paramClass_c_032.var_aa3.length > 0)
				&& (paramClass_c_032.sub_15b5(paramClass_c_032.var_ad3,
						paramClass_c_032.var_adb, (byte) 0).length > 0)) {
			arrayOfByte[(i++)] = 3;
		}
		Class_c_032[] localObject = paramClass_c_032.sub_15b5(
				paramClass_c_032.var_ad3, paramClass_c_032.var_adb,
				(byte) 1);
		if ((paramClass_c_032.sub_232f((short) 32))
				&& (localObject.length > 0)) {
			arrayOfByte[(i++)] = 4;
		}
		if (paramByte == 1) {
			arrayOfByte[(i++)] = 5;
		} else {
			arrayOfByte[(i++)] = 6;
		}
		byte[] localObject1 = new byte[i];
		System.arraycopy(arrayOfByte, 0, localObject1, 0, i);
		return localObject1;
	}

	public final void sub_940b() throws Exception {
		switch (this.var_3643) {
		case 0:
			if (this.var_34d3 >= 1200L) {
				this.var_3643 = 1;
			}
			this.var_3653 = 40;
			return;
		case 1:
			if (this.var_3653 <= 0) {
				this.var_3623 = null;
				this.var_3653 = 0;
				this.var_3643 += 1;
				sub_c019(0, 0, 3);
				return;
			}
			this.var_3653 -= 1;
			return;
		case 2:
			sub_c019(1, 2, 3);
			this.var_3633 = new Class_h_017("logo");
			this.var_3643 += 1;
			return;
		case 3:
			if (++this.var_3653 > 40) {
				try {
					this.var_362b = new Class_h_017("splash");
					this.var_363b = new Class_h_017("glow");
				} catch (Exception localException) {
				}
				this.var_3653 = 11;
				this.var_3643 += 1;
				Class_a_000.var_79b.sub_1f57();
				return;
			}
			break;
		case 4:
			if (this.var_3653 < 16) {
				this.var_3653 += 1;
				this.var_3663 += 1;
				if (this.var_363b != null) {
					this.var_377b = (-this.var_363b.var_4db);
				}
			} else {
				if (this.var_377b >= this.var_7a3 * 4) {
					if (this.var_363b != null) {
						this.var_377b = (-this.var_363b.var_4db);
					}
				} else {
					this.var_377b += this.var_3633.var_4db / 6;
				}
				if (this.var_34d3 % 100L == 0L) {
					this.var_36cb = (!this.var_36cb);
				}
				if (((this.var_362b == null) || (Class_a_000.var_79b.sub_1f21()))
						&& (sub_4789())) {
					if (this.var_363b != null) {
						this.var_377b = (-this.var_363b.var_4db);
					}
					this.var_36cb = false;
					int i = this.var_3633.var_4e3 + 1;
					sub_593d(this.var_337b, (this.var_7ab + i) / 2,
							this.var_7ab - i, this.var_362b == null ? null
									: this);
					Class_a_000.var_79b.sub_1f57();
				}
			}
			break;
		}
	}

	public final void sub_96cc() throws Exception {
		this.var_34d3 += 50L;
		if (this.var_361b == 2) {
			sub_1460c();
			return;
		}
		if (this.var_361b == 3) {
			sub_c1eb();
			return;
		}
		if (this.var_361b == 0) {
			sub_940b();
			return;
		}
		sub_112a9();
		if (this.var_36db != -1) {
			if (Class_e_034.var_141c[2] != false) {
				Class_d_023 localClass_d_0231;
				(localClass_d_0231 = sub_10bb9(
						Class_a_000.sub_cb9(196 + this.var_36db, true),
						(byte) -1, (byte) 2)).var_117d = 7831691;
				localClass_d_0231.var_1175 = 7831691;
				localClass_d_0231.var_fbd = 16250855;
			}
			this.var_36db = -1;
		}
		if (Class_a_000.var_79b.var_13d4 != this) {
			return;
		}
		if (this.var_34c3 == 0) {
			for (int i = 0; i < this.var_37a3.length; i++) {
				int k = sub_e206(this.var_3733[i][0], this.var_3733[i][1]);
				if ((this.var_37a3[i] != null) && (k != -1) && (k != 0)
						&& (!this.var_37a3[i].var_84c)
						&& (Class_e_034.var_1414.nextInt() % 8 == 0)) {
					this.var_37a3[i].var_84c = true;
					this.var_37a3[i].sub_108a(0);
					this.var_37a3[i].var_81c = 1;
					this.var_37a3[i].sub_10c6((this.var_3733[i][0] + 1) * 24
							- this.var_37ab.var_7f4,
							this.var_3733[i][1] * 24 - 2);
					this.var_35cb.addElement(this.var_37a3[i]);
				}
			}
		}
		if (this.var_34d3 - this.var_3693 >= 300L) {
			this.var_368b = (!this.var_368b);
			this.var_3693 = this.var_34d3;
		}
		if ((this.var_3bc3) && (this.var_34d3 - this.var_3bd3 >= this.var_3bcb)) {
			this.var_3bc3 = false;
		}
		if (this.var_364b) {
			this.var_3653 += 1;
			if (this.var_3653 > 16) {
				if (this.var_34c3 == 10) {
					this.var_3b93 = 1;
				} else if (this.var_34c3 == 11) {
					if (this.var_332b == 0) {
						this.var_3813 = true;
						this.var_380b = true;
						this.var_37fb = 0;
					}
					this.var_372b = 0;
					this.var_3553 = this.var_34d3;
				} else {
					sub_144b2(this.var_367b, this.var_3683);
					this.var_3a83 = null;
					sub_90fd();
				}
				this.var_364b = false;
			}
			return;
		}
		if (this.var_3813) {
			if (this.var_3803) {
				if (this.var_37fb < 16) {
					this.var_37fb += 1;
				}
			} else if (this.var_380b) {
				this.var_37fb += 1;
				if (this.var_37fb > 16) {
					this.var_380b = false;
				}
			}
		}
		if (this.var_353b != null) {
			this.var_3543 = ((this.var_3543 + 1) % 12);
		}
		if (this.var_351b) {
			if (this.var_3a3b == 0) {
				this.var_3a33 += 1;
				if (this.var_3a33 >= 15) {
					this.var_3a3b = 1;
				}
			} else {
				this.var_3a33 -= 1;
				if (this.var_3a33 <= 0) {
					this.var_3a3b = 0;
				}
			}
			if (this.var_39d3 > 0) {
				this.var_39d3 -= 4;
				if (this.var_39d3 < 0) {
					this.var_39d3 = 0;
				}
			}
		}
		if ((this.var_352b) && (this.var_34d3 - this.var_33a3 >= 200L)) {
			this.var_344b.sub_10ed();
			this.var_33a3 = this.var_34d3;
		}
		int k = this.var_34ab * 24;
		int m = this.var_34b3 * 24;
		int n = this.var_344b.var_7dc;
		int i1 = this.var_344b.var_7e4;
		if (k > n) {
			n += 8;
		} else if (k < n) {
			n -= 8;
		}
		if (m > i1) {
			i1 += 8;
		} else if (m < i1) {
			i1 -= 8;
		}
		this.var_344b.sub_10c6(n, i1);
		Object localObject2;
		if ((!this.var_3793) && (this.var_378b > 0)) {
			if (this.var_378b < 2) {
				this.var_378b = 0;
			} else {
				this.var_378b /= 2;
			}
			this.var_397b = true;
			this.var_3983 = true;
		} else {
			Object localObject1;
			Object localObject5;
			if (this.var_34c3 == 8) {
				if (this.var_354b == 0) {
					if (this.var_378b < var_32c3) {
						if (this.var_378b == 0) {
							this.var_3793 = true;
							this.var_378b = 1;
						} else {
							this.var_378b *= 2;
						}
						this.var_397b = true;
						this.var_3983 = true;
					} else {
						this.var_354b = 1;
						sub_ddbb();
						if (this.var_35b3[this.var_357b] == 1) {
							localObject1 = "" + this.var_3a5b;
						} else {
							localObject1 = "?";
						}
						Class_d_023 localClass_d_0233 = sub_10c0e(
								Class_a_000.sub_c99(75),
								Class_a_000.sub_e44(76, (String) localObject1),
								this.var_32d3, 1500);
						Class_a_000.var_79b.sub_1a8c(localClass_d_0233);
						localClass_d_0233.var_1175 = var_33bb[this.var_356b[this.var_357b]];
						Class_e_034.sub_2439(
								var_33c3[this.var_356b[this.var_357b]], 0);
					}
				} else {
					for (int i = this.var_3533.size() - 1; i >= 0; i--) {
						Class_c_032 localObject11 = (Class_c_032) this.var_3533
								.elementAt(i);
						if ((localObject11.var_b13 != 3)
								&& (this.var_357b == ((Class_c_032) localObject11).var_acb)
								&& ((sub_dd5d(
										((Class_c_032) localObject11).var_ad3,
										((Class_c_032) localObject11).var_adb) == 7) || (sub_e2b4(
										((Class_c_032) localObject11).var_ad3,
										((Class_c_032) localObject11).var_adb,
										this.var_3573[localObject11.var_acb])))
								&& (((Class_c_032) localObject11).var_b0b < 100)) {
							int i5;
							if ((i5 = 100 - ((Class_c_032) localObject11).var_b0b) > 20) {
								i5 = 20;
							}
							localObject11.var_b0b += i5;
							Class_f_045 localObject51 = Class_f_045.sub_15c2(
									"+" + i5, 0, -4, (byte) 1);
							localObject51
									.sub_10c6(
											((Class_f_045) localObject11).var_7dc
													+ ((Class_f_045) localObject11).var_7f4
													/ 2,
											((Class_f_045) localObject11).var_7e4
													+ ((Class_f_045) localObject11).var_7fc);
							this.var_35c3.addElement(localObject51);
						}
					}
					this.var_354b = 0;
					this.var_3793 = false;
					this.var_34c3 = 0;
				}
			} else if (this.var_34c3 == 9) {
				this.var_34c3 = 0;
			} else if (this.var_34c3 == 11) {
				if ((!this.var_364b)
						&& (this.var_372b == 0)
						&& ((this.var_332b == 1)
								|| (this.var_34d3 - this.var_3553 >= 3000L) || (Class_a_000.var_79b
								.sub_1f21()))) {
					this.var_32d3 = this.var_7ab;
					this.var_32e3 = this.var_7bb;
					sub_593d(this.var_337b, this.var_7bb, this.var_7ab, null);
					this.var_372b = 1;
					this.var_380b = false;
				}
			} else {
				Object localObject3;
				if ((this.var_34c3 == 10) || (this.var_34c3 == 14)) {
					if ((this.var_3b93 == 1)
							|| ((this.var_34c3 == 14) && (this.var_3b93 != 2))) {
						this.var_34db += 1;
						if (this.var_34db > this.var_32eb) {
							localObject1 = var_32f3[var_32fb[this.var_32eb]];
							localObject3 = sub_10c0e(null, Class_a_000.sub_e44(
									82, (String) localObject1), this.var_7ab,
									3000);
							Class_a_000.var_79b
									.sub_1a8c((Class_a_000) localObject3);
							this.var_32eb = this.var_34db;
							try {
								localObject5 = new byte[] { (byte) this.var_32eb };
								Class_e_034.sub_15e7("settings", 1,
										(byte[]) localObject5);
							} catch (Exception localException) {
							}
						}
						this.var_3b93 = 2;
					} else if (this.var_3b93 == 0) {
						this.var_364b = true;
						this.var_3653 = 0;
					} else if (this.var_3b93 == 2) {
						if (this.var_34c3 == 14) {
							this.var_32d3 = this.var_7ab;
							this.var_32e3 = this.var_7bb;
							sub_593d(this.var_337b, this.var_7bb, this.var_7ab,
									null);
							return;
						}
						if (this.var_34db <= 7) {
							sub_881b(this.var_34db);
							sub_10c83();
							this.var_34c3 = 0;
						}
					}
				} else {
					int i7;
					if (this.var_34c3 == 13) {
						int i2;
						if (this.var_366b == 0) {
							Class_e_034.sub_233e(200);
							i2 = this.var_367b.sub_fea(this.var_3683);
							this.var_3683.sub_d0e(400);
							Class_e_034.sub_24ab(14, 1);
							sub_5873(this.var_348b, this.var_3683.var_7dc,
									this.var_3683.var_7e4, 0, 0, 2, 50);
							localObject3 = Class_f_045.sub_15c2("-" + i2, 0,
									-4, (byte) 1);
							if ((i7 = this.var_3683.var_7dc
									+ this.var_3683.var_7f4 / 2)
									+ ((Class_f_045) localObject3).var_7f4 / 2 > this.var_340b) {
								i7 = this.var_340b
										- ((Class_f_045) localObject3).var_7f4
										/ 2;
							} else if (i7
									- ((Class_f_045) localObject3).var_7f4 / 2 < 0) {
								i7 = ((Class_f_045) localObject3).var_7f4 / 2;
							}
							((Class_f_045) localObject3).sub_10c6(i7,
									this.var_3683.var_7e4
											+ this.var_3683.var_7fc);
							this.var_35c3.addElement(localObject3);
							this.var_3673 = this.var_34d3;
							this.var_366b += 1;
						} else if (this.var_366b == 1) {
							if (this.var_34d3 - this.var_3673 >= 800L) {
								sub_bba8(this.var_367b.var_ad3,
										this.var_367b.var_adb);
								if (this.var_3683.sub_1134(this.var_367b,
										this.var_367b.var_ad3,
										this.var_367b.var_adb)) {
									Class_e_034.sub_233e(200);
									i2 = this.var_3683.sub_fea(this.var_367b);
									this.var_367b.sub_d0e(400);
									Class_e_034.sub_24ab(14, 1);
									sub_5873(this.var_348b,
											this.var_367b.var_7dc,
											this.var_367b.var_7e4, 0, 0, 2, 50);
									localObject3 = Class_f_045.sub_15c2("-"
											+ i2, 0, -4, (byte) 1);
									if ((i7 = this.var_367b.var_7dc
											+ this.var_367b.var_7f4 / 2)
											+ ((Class_f_045) localObject3).var_7f4
											/ 2 > this.var_340b) {
										i7 = this.var_340b
												- ((Class_f_045) localObject3).var_7f4
												/ 2;
									} else if (i7
											- ((Class_f_045) localObject3).var_7f4
											/ 2 < 0) {
										i7 = ((Class_f_045) localObject3).var_7f4 / 2;
									}
									((Class_f_045) localObject3).sub_10c6(i7,
											this.var_367b.var_7e4
													+ this.var_367b.var_7fc);
									this.var_35c3.addElement(localObject3);
									this.var_3673 = this.var_34d3;
									this.var_366b += 1;
								} else {
									sub_56c3();
								}
							}
						} else if (this.var_34d3 - this.var_3673 >= 800L) {
							sub_56c3();
						}
					} else if (this.var_386b != null) {
						if (this.var_3873 == 0) {
							if (this.var_39cb) {
								this.var_3863 = sub_5873(this.var_3483,
										this.var_386b.var_7dc, -this.var_3423,
										0, 12, -1, 0);
								Class_d_023 localClass_d_0232;
								(localClass_d_0232 = sub_10c0e(null,
										Class_a_000.sub_c99(280),
										this.var_32d3, 2000)).sub_193f(
										this.var_32db, 2, 17);
								Class_a_000.var_79b.sub_1a8c(localClass_d_0232);
								this.var_3873 = 1;
							}
						} else if (this.var_3873 == 1) {
							for (int i = 0; i < 3; i++) {
								sub_5873(
										this.var_37ab,
										this.var_3863.var_7dc
												+ Class_e_034
														.sub_1544(this.var_3863.var_7f4
																- this.var_37ab.var_7f4),
										this.var_3863.var_7e4, 0, Class_e_034
												.sub_1564(-3, 0), 1,
										50 * Class_e_034.sub_1544(4));
							}
							if (this.var_3863.var_7e4 >= this.var_386b.var_7e4) {
								this.var_3863.var_84c = false;
								Class_e_034.sub_233e(200);
								sub_14bd3(500);
								if (this.var_387b) {
									int i3;
									if ((i3 = 25 + Class_e_034.sub_1544(25)) > this.var_386b.var_b0b) {
										i3 = this.var_386b.var_b0b;
									}
									this.var_386b.var_b0b -= i3;
									Class_f_045 localObject31 = Class_f_045
											.sub_15c2("-" + i3, 0, -4, (byte) 1);
									localObject31
											.sub_10c6(
													this.var_386b.var_7dc
															+ this.var_386b.var_7f4
															/ 2,
													this.var_386b.var_7e4
															+ this.var_386b.var_7fc);
									this.var_35c3.addElement(localObject31);
								}
								sub_b64d(this.var_386b);
								this.var_3873 = 2;
							}
						} else if (++this.var_3873 >= 20) {
							if (this.var_386b.var_b0b <= 0) {
								this.var_35d3 = this.var_386b;
								sub_5873(this.var_3483, this.var_35d3.var_7dc,
										this.var_35d3.var_7e4, 0, 0, 1, 50);
								Class_e_034.sub_24ab(12, 1);
								this.var_35e3 = this.var_34d3;
							}
							this.var_386b = null;
						}
					} else if (this.var_35db != null) {
						if (--this.var_3603 <= 0) {
							Class_e_034.sub_233e(100);
							sub_b64d(this.var_35db);
							sub_e185((byte) 27, this.var_35db.var_ad3,
									this.var_35db.var_adb);
							this.var_35db = null;
						}
					} else if (this.var_35d3 != null) {
						if ((this.var_34d3 - this.var_35e3 >= 300L)
								&& (sub_b848(this.var_35d3.var_ad3,
										this.var_35d3.var_adb))) {
							if ((this.var_332b == 0) && (this.var_34db == 7)
									&& (this.var_35d3 == this.var_358b[1])) {
								this.var_3883 = true;
							} else {
								sub_5873(this.var_347b, this.var_35d3.var_7dc,
										this.var_35d3.var_7e4, 0, -3, 1, 100);
								this.var_35d3.var_b13 = 3;
								this.var_35d3.var_b5b = 3;
								if ((this.var_35d3.var_ac3 == 10)
										|| (this.var_35d3.var_ac3 == 11)) {
									this.var_35d3.sub_e0d();
								} else if (this.var_35d3.var_ac3 == 9) {
									this.var_35d3.sub_128b(-10, -10);
									this.var_35d3.var_b1b = 0;
									this.var_35d3.sub_1211();
								}
								if ((this.var_35d3.var_ac3 == 9)
										&& (this.var_35d3.var_b8b < 1000)) {
									this.var_35d3.var_b8b += 200;
								}
							}
							this.var_35d3 = null;
						}
					} else {
						Class_c_032 localClass_c_032;
						if (this.var_381b.size() > 0) {
							localClass_c_032 = (Class_c_032) this.var_381b
									.elementAt(0);
							if (this.var_382b == 0) {
								sub_bba8(localClass_c_032.var_ad3,
										localClass_c_032.var_adb);
								this.var_382b = 1;
							} else if (sub_b848(localClass_c_032.var_ad3,
									localClass_c_032.var_adb)) {
								sub_5873(
										this.var_349b,
										localClass_c_032.var_7dc
												+ Class_e_034
														.sub_1544(localClass_c_032.var_7f4),
										localClass_c_032.var_7e4
												+ Class_e_034
														.sub_1544(localClass_c_032.var_7fc),
										0, 0, 1, 50);
								if (this.var_382b == 1) {
									Class_e_034.sub_24ab(13, 1);
								}
								if (this.var_382b <= 5) {
									int i6 = 200;
									if (this.var_382b == 5) {
										i6 = 1000;
									}
									i7 = localClass_c_032.var_7dc
											+ (localClass_c_032.var_7f4 - this.var_3823.var_7f4)
											/ 2;
									int i8 = localClass_c_032.var_7e4
											- this.var_382b * 4;
									if (i7 < 0) {
										i7 = 0;
									} else if (i7 + this.var_3823.var_7f4 > this.var_340b) {
										i7 = this.var_340b
												- this.var_3823.var_7f4;
									}
									if (i8 < 0) {
										i8 = 0;
									}
									sub_5873(this.var_3823, i7, i8, 0, 0, 1, i6);
								}
								this.var_382b += 1;
								if (this.var_382b >= 20) {
									this.var_381b
											.removeElement(localClass_c_032);
									this.var_382b = 0;
									if ((localClass_c_032.var_ac3 != 9)
											&& (localClass_c_032.var_a93 <= 6)
											&& (localClass_c_032.var_a93 % 2 == 0)) {
										Class_a_000.var_79b
												.sub_1a8c(sub_10c0e(
														null,
														Class_a_000.sub_c99(80)
																+ "\n"
																+ localClass_c_032.var_a8b,
														this.var_32cb, 2000));
									}
								}
							}
						} else if (this.var_35eb != null) {
							if (this.var_34d3 - this.var_35fb >= 400L) {
								this.var_35eb.sub_e0d();
								(localClass_c_032 = Class_c_032.sub_d3d(
										(byte) 10, this.var_35f3,
										this.var_35eb.var_ad3,
										this.var_35eb.var_adb)).sub_2352();
								this.var_35eb = null;
							}
						} else if (!this.var_3b7b) {
							if (this.var_34c3 == 2) {
								if ((this.var_34fb.var_b13 != 1)
										&& (this.var_39cb)) {
									sub_91c4(this.var_34fb);
								}
							} else if (this.var_35b3[this.var_357b] == 0) {
								sub_ebb9();
							} else if (sub_4789()) {
								if ((this.var_3613)
										&& (Class_a_000.var_79b
												.sub_1fd5(var_3333))) {
									Class_a_000.var_79b.sub_2079(16);
									Class_a_000.var_79b.sub_20b4(var_3333);
								}
								if ((this.var_34c3 == 6)
										|| (this.var_34c3 == 7)) {
									if ((Class_a_000.var_79b.sub_1f81(4))
											|| (Class_a_000.var_79b.sub_1f81(1))) {
										this.var_34eb -= 1;
										if (this.var_34eb < 0) {
											this.var_34eb = (this.var_34f3.length - 1);
										}
										Class_a_000.var_79b.sub_20b4(4);
										Class_a_000.var_79b.sub_20b4(1);
										this.var_369b = true;
									} else if ((Class_a_000.var_79b.sub_1f81(8))
											|| (Class_a_000.var_79b.sub_1f81(2))) {
										this.var_34eb += 1;
										if (this.var_34eb >= this.var_34f3.length) {
											this.var_34eb = 0;
										}
										Class_a_000.var_79b.sub_20b4(8);
										Class_a_000.var_79b.sub_20b4(2);
										this.var_369b = true;
									}
									sub_bba8(
											this.var_34f3[this.var_34eb].var_ad3,
											this.var_34f3[this.var_34eb].var_adb);
									if (this.var_369b) {
										this.var_3753 = sub_dc52(this.var_34ab,
												this.var_34b3, (byte) 0);
										this.var_3983 = true;
									}
									if (Class_a_000.var_79b.sub_1f81(16)) {
										if (this.var_34c3 == 6) {
											sub_55bd(
													this.var_34fb,
													this.var_34f3[this.var_34eb]);
										} else if (this.var_34c3 == 7) {
											sub_b6fe(
													this.var_34f3[this.var_34eb],
													this.var_357b);
											this.var_34fb.sub_2352();
											this.var_34c3 = 0;
										}
										this.var_35bb = null;
										this.var_351b = false;
										this.var_3523 = false;
										this.var_360b = false;
										this.var_3613 = false;
									}
									this.var_369b = false;
								} else {
									if ((this.var_34d3 - this.var_33ab >= 150L)
											&& (this.var_344b.var_7dc % 24 == 0)
											&& (this.var_344b.var_7e4 % 24 == 0)) {
										if ((Class_a_000.var_79b.sub_1f81(4))
												|| (Class_a_000.var_79b
														.sub_2032(4))) {
											if (this.var_34ab > 0) {
												this.var_34ab -= 1;
											}
											this.var_369b = true;
											this.var_33ab = this.var_34d3;
										} else if ((Class_a_000.var_79b
												.sub_1f81(8))
												|| (Class_a_000.var_79b
														.sub_2032(8))) {
											if (this.var_34ab < this.var_342b - 1) {
												this.var_34ab += 1;
											}
											this.var_369b = true;
											this.var_33ab = this.var_34d3;
										}
										if ((Class_a_000.var_79b.sub_1f81(1))
												|| (Class_a_000.var_79b
														.sub_2032(1))) {
											if (this.var_34b3 > 0) {
												this.var_34b3 -= 1;
											}
											this.var_369b = true;
											this.var_33ab = this.var_34d3;
										} else if ((Class_a_000.var_79b
												.sub_1f81(2))
												|| (Class_a_000.var_79b
														.sub_2032(2))) {
											if (this.var_34b3 < this.var_3433 - 1) {
												this.var_34b3 += 1;
											}
											this.var_369b = true;
											this.var_33ab = this.var_34d3;
										}
										if (this.var_369b) {
											if (this.var_34c3 == 1) {
												if (this.var_3513[this.var_34ab][this.var_34b3] > 0) {
													this.var_353b = this.var_34fb
															.sub_1b48(
																	this.var_34fb.var_ad3,
																	this.var_34fb.var_adb,
																	this.var_34ab,
																	this.var_34b3);
												}
											} else {
												this.var_3753 = sub_dc52(
														this.var_34ab,
														this.var_34b3, (byte) 0);
											}
											this.var_3983 = true;
										}
										this.var_369b = false;
									}
									if (((this.var_34c3 == 1) || (this.var_34c3 == 0))
											&& (Class_a_000.var_79b
													.sub_1f81(256))) {
										if ((localClass_c_032 = sub_dc52(
												this.var_34ab, this.var_34b3,
												(byte) 0)) != null) {
											Class_d_023 localObject41 = new Class_d_023(
													(byte) 15, 15);
											localObject41.var_11b5 = this.var_32d3;
											i7 = 0;
											Class_d_023 localClass_d_0234 = new Class_d_023(
													(byte) 5, 2);
											Class_d_023 localClass_d_0235;
											(localClass_d_0235 = new Class_d_023(
													(byte) 10, 1)).var_1125 = true;
											String str = Class_a_000
													.sub_c99(184 + localClass_c_032.var_ac3);
											if (localClass_c_032.var_b1b != 0) {
												StringBuffer localStringBuffer = new StringBuffer(
														Class_a_000.sub_c99(98));
												if ((localClass_c_032.var_b1b & 0x2) != 0) {
													localStringBuffer
															.append('\n');
													localStringBuffer
															.append(Class_a_000
																	.sub_c99(100));
												}
												if ((localClass_c_032.var_b1b & 0x1) != 0) {
													localStringBuffer
															.append('\n');
													localStringBuffer
															.append(Class_a_000
																	.sub_c99(99));
												}
												localStringBuffer
														.append("\n-----------\n");
												str = localStringBuffer
														.toString() + str;
											}
											localClass_d_0235
													.sub_1ceb(
															null,
															str,
															this.var_32cb,
															this.var_32d3
																	- localClass_d_0234.var_1015);
											((Class_d_023) localObject41)
													.sub_169b(
															localClass_d_0234,
															0, 0, 0);
											((Class_d_023) localObject41)
													.sub_169b(
															localClass_d_0235,
															0,
															localClass_d_0234.var_1015,
															0);
											((Class_d_023) localObject41).var_112d = true;
											((Class_d_023) localObject41)
													.sub_1323(this);
											Class_a_000.var_79b
													.sub_1a8c((Class_a_000) localObject41);
										}
										Class_a_000.var_79b.sub_20b4(256);
									}
									if (this.var_34c3 == 1) {
										if ((Class_a_000.var_79b.sub_1f81(16))
												&& (this.var_34fb != null)) {
											localClass_c_032 = sub_dc52(
													this.var_34ab,
													this.var_34b3, (byte) 0);
											if ((this.var_3513[this.var_34ab][this.var_34b3] > 0)
													&& ((localClass_c_032 == null) || (localClass_c_032 == this.var_34fb))) {
												this.var_3503 = this.var_34fb.var_ad3;
												this.var_350b = this.var_34fb.var_adb;
												this.var_34fb.sub_18b7(
														this.var_34ab,
														this.var_34b3, true);
												this.var_39b3 = this.var_34fb;
												this.var_352b = false;
												this.var_351b = false;
												this.var_353b = null;
												this.var_35bb = null;
												this.var_360b = false;
												this.var_3613 = false;
												this.var_34c3 = 2;
												Class_e_034.sub_24ab(10, 1);
											}
											Class_a_000.var_79b.sub_20b4(16);
										}
									} else if (this.var_34c3 == 0) {
										if (Class_a_000.var_79b.sub_1f81(512)) {
											int i4 = 0;
											Class_c_032 localObject4 = this.var_358b[this.var_357b];
											if ((this.var_3753 != null)
													&& (this.var_3753.var_ac3 == 9)) {
												//
											}
											Class_c_032 localObject41 = this.var_3593[this.var_357b][((this.var_3753.var_b83 + 1) % this.var_359b[this.var_357b])];
											for (;;) {
												i4++;
												if ((i4 >= this.var_359b[this.var_357b])
														|| (((Class_c_032) localObject41).var_b13 != 3)) {
													break;
												}
												localObject41 = this.var_3593[this.var_357b][((localObject41.var_b83 + 1) % this.var_359b[this.var_357b])];
											}
											if ((localObject41 != null)
													&& (((Class_c_032) localObject41).var_b13 != 3)) {
												sub_bba8(
														((Class_c_032) localObject41).var_ad3,
														((Class_c_032) localObject41).var_adb);
												sub_b998(
														((Class_f_045) localObject41).var_7dc + 12,
														((Class_f_045) localObject41).var_7e4 + 12);
											}
										} else if (Class_a_000.var_79b
												.sub_1f81(32)) {
											if (this.var_3523) {
												sub_913d(this.var_3513, 0);
												this.var_351b = false;
												this.var_3523 = false;
											} else {
												this.var_34fb = sub_dc52(
														this.var_34ab,
														this.var_34b3, (byte) 0);
												if (this.var_34fb != null) {
													sub_913d(this.var_3513, 0);
													this.var_34fb
															.sub_14e8(this.var_3513);
													this.var_3523 = true;
													this.var_351b = true;
													this.var_39d3 = 12;
												}
											}
											Class_a_000.var_79b.sub_20b4(32);
										} else if ((Class_a_000.var_79b
												.sub_1f81(16))
												|| (Class_a_000.var_79b
														.sub_1f81(var_3333))) {
											this.var_34fb = sub_dc52(
													this.var_34ab,
													this.var_34b3, (byte) 0);
											if ((this.var_34fb != null)
													&& (this.var_34fb.var_b13 == 0)
													&& (this.var_34fb.var_acb == this.var_357b)) {
												byte[] localObject21 = sub_9267(
														this.var_34fb, (byte) 1);
												if (localObject21.length > 1) {
													sub_5a85(
															(byte[]) localObject21,
															this.var_34fb);
													Class_e_034.sub_24ab(11, 1);
												} else {
													this.var_3723 = false;
													sub_58af(this.var_34fb);
												}
											} else if ((sub_dd5d(this.var_34ab,
													this.var_34b3) == 9)
													&& (sub_e312(this.var_34ab,
															this.var_34b3,
															this.var_357b))) {
												localObject2 = new byte[] { 0 };
												sub_5a85((byte[]) localObject2,
														null);
												Class_e_034.sub_24ab(11, 1);
											} else {
												this.var_34fb = null;
												this.var_35bb = new Class_d_023(
														(byte) 11, 0);
												this.var_35bb.sub_212d(
														this.var_3343, 2, 2,
														-1, this.var_32d3, 20,
														0);
												this.var_35bb.sub_1323(this);
												Class_a_000.var_79b
														.sub_1a8c(this.var_35bb);
												Class_e_034.sub_24ab(11, 1);
											}
											Class_a_000.var_79b.sub_1f57();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		int i = 0;
		int j = this.var_3533.size();
		while (i < j) {
			((Class_c_032) this.var_3533.elementAt(i)).sub_1fde();
			i++;
		}
		if (this.var_34d3 - this.var_36a3 >= 300L) {
			this.var_36ab = ((this.var_36ab + 1) % this.var_36bb.length);
			this.var_3443[this.var_36b3] = this.var_36bb[this.var_36ab];
			this.var_36a3 = this.var_34d3;
		}
		sub_b79b();
		if ((this.var_360b) && (Class_a_000.var_79b.sub_1fd5(var_333b))) {
			if (this.var_34c3 == 1) {
				this.var_34c3 = 0;
				sub_913d(this.var_3513, 0);
				this.var_353b = null;
				this.var_344b.sub_1134(var_3393[0]);
				sub_bba8(this.var_34fb.var_ad3, this.var_34fb.var_adb);
				this.var_34fb = null;
			} else if ((this.var_34c3 == 6) || (this.var_34c3 == 7)) {
				this.var_34c3 = this.var_34cb;
				sub_913d(this.var_3513, 0);
				this.var_344b.sub_1134(var_3393[0]);
				sub_bba8(this.var_34fb.var_ad3, this.var_34fb.var_adb);
				Class_a_000.var_79b.sub_1a8c(this.var_35bb);
			}
			this.var_351b = false;
			this.var_3523 = false;
			Class_a_000.var_79b.sub_20b4(var_333b);
			this.var_360b = false;
			this.var_3613 = false;
		}
		for (i = this.var_35c3.size() - 1; i >= 0; i--) {
			Class_f_045 localObject21 = (Class_f_045) this.var_35c3
					.elementAt(i);
			localObject21.sub_17ec();
			if (!((Class_f_045) localObject21).var_84c) {
				this.var_35c3.removeElement(localObject21);
			}
		}
		i = 0;
		j = this.var_35cb.size();
		while (i < j) {
			this.var_35c3.addElement(this.var_35cb.elementAt(i));
			i++;
		}
		this.var_35cb.removeAllElements();
	}

	public final void sub_b64d(Class_c_032 paramClass_c_032) {
		int i = paramClass_c_032.var_7e4 + 24;
		sub_5873(this.var_347b, paramClass_c_032.var_7dc, i
				- this.var_347b.var_7fc, 0, -2, 1, 100);
		for (int j = 0; j < 5; j++) {
			sub_5873(this.var_37ab, paramClass_c_032.var_7dc, i
					- this.var_37ab.var_7fc, -2 + j,
					Class_e_034.sub_1564(-4, -1), 1,
					50 + 50 * Class_e_034.sub_1544(4));
		}
		sub_5873(this.var_3483, paramClass_c_032.var_7dc,
				paramClass_c_032.var_7e4, 0, 0, 1, 100);
	}

	public final void sub_b6fe(Class_c_032 paramClass_c_032, byte paramByte) {
		this.var_35eb = paramClass_c_032;
		this.var_35f3 = paramByte;
		sub_5873(this.var_3483, paramClass_c_032.var_7dc - 8,
				paramClass_c_032.var_7e4 - 8, 1, 1, 3, 50);
		sub_5873(this.var_3483, paramClass_c_032.var_7dc + 8,
				paramClass_c_032.var_7e4 - 8, -1, 1, 3, 50);
		sub_5873(this.var_3483, paramClass_c_032.var_7dc - 8,
				paramClass_c_032.var_7e4 + 8, 1, -1, 3, 50);
		sub_5873(this.var_3483, paramClass_c_032.var_7dc + 8,
				paramClass_c_032.var_7e4 + 8, -1, -1, 3, 50);
		this.var_35fb = this.var_34d3;
	}

	public final void sub_b79b() {
		if (this.var_39b3 == null) {
			sub_b9f2(this.var_344b.var_7dc + 12, this.var_344b.var_7e4 + 12);
			return;
		}
		sub_b9f2(this.var_39b3.var_7dc + 12, this.var_39b3.var_7e4 + 12);
	}

	public final boolean sub_b7ff(int paramInt1, int paramInt2) {
		return (this.var_341b == sub_b88e(paramInt1))
				&& (this.var_3423 == sub_b913(paramInt2));
	}

	public final boolean sub_b848(int paramInt1, int paramInt2) {
		return sub_b7ff(paramInt1 * 24 + 12, paramInt2 * 24 + 12);
	}

	public final int sub_b88e(int paramInt) {
		int i;
		if (this.var_340b > this.var_32cb) {
			if ((i = this.var_32db - paramInt) > 0) {
				i = 0;
			} else if (i < this.var_32cb - this.var_340b) {
				i = this.var_32cb - this.var_340b;
			}
		} else {
			i = (this.var_32cb - this.var_340b) / 2;
		}
		return i;
	}

	public final int sub_b913(int paramInt) {
		int i;
		if (this.var_3413 > this.var_32d3) {
			if ((i = this.var_32e3 - paramInt) > 0) {
				i = 0;
			} else if (i < this.var_32d3 - this.var_3413) {
				i = this.var_32d3 - this.var_3413;
			}
		} else {
			i = (this.var_32d3 - this.var_3413) / 2;
		}
		return i;
	}

	public final void sub_b998(int paramInt1, int paramInt2) {
		this.var_341b = sub_b88e(paramInt1);
		this.var_3423 = sub_b913(paramInt2);
	}

	public final void sub_b9c5(int paramInt1, int paramInt2) {
		sub_b998(paramInt1 * 24 + 12, paramInt2 * 24 + 12);
	}

	public final void sub_b9f2(int paramInt1, int paramInt2) {
		this.var_39cb = true;
		int i = sub_b88e(paramInt1);
		int j = sub_b913(paramInt2);
		int k = i - this.var_341b;
		int m = j - this.var_3423;
		int n;
		if (k != 0) {
			n = k / 2;
			if (k < 0) {
				if (n > -this.var_39c3) {
					n = -this.var_39c3;
				} else if (n < -this.var_39bb) {
					n = -this.var_39bb;
				}
			} else if (n < this.var_39c3) {
				n = this.var_39c3;
			} else if (n > this.var_39bb) {
				n = this.var_39bb;
			}
			this.var_341b += n;
			this.var_39cb = false;
		}
		if (m != 0) {
			n = m / 2;
			if (m < 0) {
				if (n > -this.var_39c3) {
					n = -this.var_39c3;
				} else if (n < -this.var_39bb) {
					n = -this.var_39bb;
				}
			} else if (n < this.var_39c3) {
				n = this.var_39c3;
			} else if (n > this.var_39bb) {
				n = this.var_39bb;
			}
			this.var_3423 += n;
			this.var_39cb = false;
		}
	}

	public final void sub_bba8(int paramInt1, int paramInt2) {
		this.var_34ab = paramInt1;
		this.var_34b3 = paramInt2;
		this.var_344b.sub_10c6(paramInt1 * 24, paramInt2 * 24);
		this.var_3753 = sub_dc52(this.var_34ab, this.var_34b3, (byte) 0);
		this.var_3983 = true;
	}

	public final void sub_bbf2(Graphics paramGraphics) {
		int i = -this.var_341b / 24;
		int j;
		if ((j = -this.var_3423 / 24) < 0) {
			j = 0;
		}
		int k = (this.var_32cb - this.var_341b - 1) / 24;
		int m;
		if ((m = (this.var_32d3 - this.var_3423 - 1) / 24) >= this.var_3433) {
			m = this.var_3433 - 1;
		}
		int n;
		if (this.var_341b < 0) {
			n = this.var_341b % 24;
		} else {
			n = this.var_341b;
		}
		int i2;
		if (this.var_3423 < 0) {
			i2 = this.var_3423 % 24;
		} else {
			i2 = this.var_3423;
		}
		int i3 = 0;
		if (this.var_3523) {
			i3 = 1;
		}
		for (int i4 = j; i4 <= m; i4++) {
			int i1 = n;
			for (int i5 = i; i5 <= k; i5++) {
				int i7 = this.var_34bb[i5][i4];
				if ((!this.var_351b) || (this.var_3513[i5][i4] == 0)
						|| (this.var_39d3 > 0)) {
					this.var_3443[i7].sub_852(paramGraphics, i1, i2);
				}
				if ((this.var_351b) && (this.var_3513[i5][i4] > 0)) {
					if (this.var_39d3 != 0) {
						paramGraphics.clipRect(i1 + this.var_39d3, i2
								+ this.var_39d3, 24 - this.var_39d3 * 2,
								24 - this.var_39d3 * 2);
					}
					paramGraphics.drawImage(this.var_3993[i3][i7], i1, i2, 0);
					if (this.var_39d3 != 0) {
						paramGraphics.setClip(0, 0, this.var_32cb,
								this.var_32d3);
					}
				}
				int i6;
				if (((i6 = i4 + 1) < this.var_3433)
						&& (this.var_3403[this.var_34bb[i5][i6]] == 9)) {
					this.var_3443[28].sub_852(paramGraphics, i1, i2);
				}
				i1 += 24;
			}
			i2 += 24;
		}
	}

	public final void sub_bed9(Graphics paramGraphics) {
		paramGraphics.setFont(Class_e_034.var_137c);
		paramGraphics.setColor(0);
		paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
		paramGraphics.setColor(16777215);
		Class_e_034.sub_1a66(paramGraphics, Class_a_000.sub_c99(58),
				this.var_7a3 / 2,
				(this.var_7ab - Class_e_034.var_137c.getHeight()) / 2, 17);
	}

	public static final int sub_bf33(int paramInt1, int paramInt2,
			int paramInt3, int paramInt4) {
		if (paramInt3 == 0) {
			return paramInt1;
		}
		if (paramInt3 == paramInt4) {
			return paramInt2;
		}
		int i = paramInt1 & 0xFF0000;
		int j = paramInt1 & 0xFF00;
		int k = paramInt1 & 0xFF;
		int m = (((paramInt2 & 0xFF0000) - i) * paramInt3 / paramInt4 & 0xFF0000)
				+ i;
		int n = (((paramInt2 & 0xFF00) - j) * paramInt3 / paramInt4 & 0xFF00)
				+ j;
		int i1 = ((paramInt2 & 0xFF) - k) * paramInt3 / paramInt4 + k;
		return m | n | i1;
	}

	public static final int sub_bfcf(int paramInt1, int paramInt2, int paramInt3) {
		int i = (paramInt1 & 0xFF0000) * paramInt2 / paramInt3 & 0xFF0000;
		int j = (paramInt1 & 0xFF00) * paramInt2 / paramInt3 & 0xFF00;
		int k = (paramInt1 & 0xFF) * paramInt2 / paramInt3;
		return i | j | k;
	}

	public final void sub_c019(int paramInt1, int paramInt2, int paramInt3)
			throws Exception {
		this.var_3a1b = paramInt2;
		this.var_3a23 = paramInt3;
		if (this.var_3a1b == 3) {
			this.var_3a1b = 1;
		}
		if (this.var_3a23 == 3) {
			this.var_3a23 = 1;
		}
		this.var_3a13 = this.var_361b;
		try {
			this.var_39fb = new Class_h_017("intro" + paramInt1);
		} catch (Exception localException) {
		}
		this.var_39db = Class_e_034.var_139c;
		if (this.var_39fb != null) {
			this.var_3a2b = this.var_39fb.var_4e3;
			this.var_3653 = 0;
			this.var_39eb = ((this.var_7ab - this.var_39fb.var_4e3) / this.var_39db);
		} else {
			this.var_3a2b = 0;
			this.var_3653 = 16;
			this.var_39eb = (this.var_7ab / this.var_39db);
		}
		this.var_3a03 = Class_a_000.sub_8c0(
				Class_a_000.sub_c99(215 + paramInt1), this.var_7a3,
				Class_e_034.var_1374);
		this.var_39e3 = (this.var_7ab - this.var_39db);
		this.var_39f3 = 0;
		this.var_3a0b = false;
		Class_a_000.var_79b.sub_1f57();
		this.var_361b = 3;
	}

	public final void sub_c16e(String paramString) {
		this.var_3a13 = this.var_361b;
		this.var_3a03 = Class_a_000.sub_8c0(paramString, this.var_7a3,
				Class_e_034.var_1374);
		this.var_3653 = 16;
		this.var_3a0b = false;
		this.var_3a1b = 3;
		this.var_3a23 = 3;
		this.var_3a2b = 0;
		this.var_39db = Class_e_034.var_139c;
		this.var_39eb = (this.var_7ab / this.var_39db);
		this.var_39e3 = (this.var_7ab - this.var_39db);
		this.var_39f3 = 0;
		Class_a_000.var_79b.sub_1f57();
		this.var_361b = 3;
	}

	public final void sub_c1eb() {
		if (this.var_3a0b) {
			this.var_3653 -= 1;
			if (this.var_3653 < 0) {
				this.var_3653 = 0;
				this.var_361b = this.var_3a13;
				this.var_39fb = null;
				this.var_3a03 = null;
			}
		} else {
			if (((this.var_3a1b == 2) && (this.var_3653 < 40))
					|| ((this.var_3a1b != 2) && (this.var_3653 < 16))) {
				this.var_3653 += 1;
			} else {
				this.var_39e3 -= 1;
				if (this.var_39e3 < this.var_3a2b) {
					this.var_39e3 = (this.var_3a2b + this.var_39db - (this.var_3a2b - this.var_39e3));
					this.var_39f3 += 1;
				}
			}
			if ((this.var_39f3 >= this.var_3a03.length)
					|| (Class_a_000.var_79b.sub_1fd5(var_3333))) {
				this.var_3a0b = true;
				if ((this.var_39fb != null)
						|| (this.var_39f3 < this.var_3a03.length)) {
					if (this.var_3a23 == 2) {
						this.var_3653 = 40;
						return;
					}
					this.var_3653 = 16;
					return;
				}
				this.var_3653 = 0;
			}
		}
	}

	public final void sub_c348(Graphics paramGraphics) {
		paramGraphics.setFont(Class_e_034.var_1374);
		paramGraphics.setColor(0);
		paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
		if (this.var_39fb != null) {
			if ((!this.var_3a0b)
					&& (((this.var_3a1b == 2) && (this.var_3653 >= 40)) || ((this.var_3a1b != 2) && (this.var_3653 >= 16)))) {
				this.var_39fb.sub_852(paramGraphics, 0, 0);
			} else if (((this.var_3a23 == 2) && (this.var_3a0b))
					|| ((this.var_3a1b == 2) && (!this.var_3a0b))) {
				sub_e5ef(paramGraphics, this.var_3653, 40, 0, this.var_39fb, 0,
						0, 2);
			} else if (((this.var_3a23 == 3) && (this.var_3a0b))
					|| ((this.var_3a1b == 3) && (!this.var_3a0b))) {
				this.var_39fb.sub_852(paramGraphics, 0, 0);
			} else {
				this.var_39fb.sub_852(paramGraphics, 0, 0);
				if (this.var_3a0b) {
					if ((this.var_3a23 == 1) && (this.var_3653 <= 16)) {
						sub_e77a(paramGraphics, 0, 16 - this.var_3653, 16, 0,
								this.var_39fb, 0, 0, this.var_7a3, this.var_7ab);
					}
				} else if (this.var_3a1b == 0) {
					if (this.var_3653 <= 16) {
						sub_e77a(paramGraphics, 16777215, this.var_3653, 16, 1,
								null, 0, 0, this.var_7a3, this.var_7ab);
					}
				} else if ((this.var_3a1b == 1) && (this.var_3653 <= 16)) {
					sub_e77a(paramGraphics, 0, this.var_3653, 16, 1, null, 0,
							0, this.var_7a3, this.var_39fb.var_4e3);
				}
			}
		}
		paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
		int i = this.var_3653;
		if ((this.var_3a0b) && (this.var_3a23 == 2)) {
			i -= 24;
			if (i < 0) {
				i = 0;
			}
		}
		int j = this.var_39e3;
		for (int k = this.var_39f3; (k < this.var_39f3 + this.var_39eb)
				&& (k < this.var_3a03.length)
				&& (j < this.var_7ab - this.var_39db); k++) {
			int m = this.var_39db;
			if (j < this.var_3a2b + this.var_39db) {
				m = j - this.var_3a2b;
			} else if (j + this.var_39db > this.var_7ab - this.var_39db) {
				m = this.var_7ab - this.var_39db - j;
			}
			int n;
			if (m < this.var_39db) {
				n = sub_bfcf(14672074, m, this.var_39db);
			} else {
				n = 14672074;
			}
			if (this.var_3a0b) {
				n = sub_bf33(0, n, i, 16);
			}
			paramGraphics.setColor(n);
			Class_e_034.sub_1a66(paramGraphics, this.var_3a03[k], this.var_7b3,
					j + 3, 17);
			j += this.var_39db;
		}
		if (!this.var_3a0b) {
			sub_dbd9(paramGraphics, var_3333, 2, this.var_7ab);
		}
	}

	public final void sub_c6ed(Graphics paramGraphics) {
		if (this.var_3643 == 0) {
			paramGraphics.setColor(16777215);
			paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
			sub_e5ef(paramGraphics, this.var_3653, 40, 0, this.var_3623,
					(this.var_7a3 - this.var_3623.var_4db) / 2,
					(this.var_7ab - this.var_3623.var_4e3) / 2, 4);
			return;
		}
		if (this.var_3643 == 1) {
			paramGraphics.setColor(16777215);
			paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
			sub_e5ef(paramGraphics, this.var_3653, 40, 0, this.var_3623,
					(this.var_7a3 - this.var_3623.var_4db) / 2,
					(this.var_7ab - this.var_3623.var_4e3) / 2, 4);
			return;
		}
		if (this.var_3643 == 3) {
			paramGraphics.setColor(0);
			paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
			sub_e5ef(paramGraphics, this.var_3653, 40, 0, this.var_3633, 0, 0,
					1);
			paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
			return;
		}
		if (this.var_3643 == 4) {
			if (this.var_3653 >= 16) {
				if (this.var_362b != null) {
					this.var_3633.sub_852(paramGraphics, 0, 0);
					if (this.var_377b != -1) {
						this.var_363b.sub_852(paramGraphics, 4 + this.var_377b,
								6);
					}
					this.var_362b.sub_852(paramGraphics, 0, 0);
				} else {
					paramGraphics.setColor(0);
					paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
					this.var_3633.sub_852(paramGraphics, 0, 0);
				}
				if ((this.var_36cb) && (this.var_362b != null)) {
					paramGraphics.setColor(16777215);
					paramGraphics.setFont(Class_e_034.var_137c);
					sub_c93d(paramGraphics, Class_a_000.sub_c99(59),
							this.var_7b3, this.var_7ab - this.var_346b.var_7fc
									- 1, 33, 16777215, 0);
				}
			} else {
				if (this.var_362b != null) {
					this.var_362b.sub_852(paramGraphics, 0, 0);
				} else {
					paramGraphics.setColor(0);
					paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
				}
				paramGraphics.setColor(0);
				paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
				this.var_3633.sub_852(paramGraphics, 0, 0);
			}
		}
	}

	public static final void sub_c93d(Graphics paramGraphics,
			String paramString, int paramInt1, int paramInt2, int paramInt3,
			int paramInt4, int paramInt5) {
		paramGraphics.setColor(paramInt5);
		paramGraphics.drawString(paramString, paramInt1 - 1, paramInt2 - 1,
				paramInt3);
		paramGraphics.drawString(paramString, paramInt1 - 1, paramInt2 + 1,
				paramInt3);
		paramGraphics.drawString(paramString, paramInt1 + 1, paramInt2 + 1,
				paramInt3);
		paramGraphics.drawString(paramString, paramInt1 + 1, paramInt2 - 1,
				paramInt3);
		paramGraphics.setColor(paramInt4);
		paramGraphics.drawString(paramString, paramInt1, paramInt2, paramInt3);
	}

	public final void sub_c9a1(Graphics paramGraphics) {
		int m;
		if (this.var_361b == 4) {
			paramGraphics.setColor(16777215);
			paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
			paramGraphics.setFont(Class_e_034.var_137c);
			paramGraphics.setColor(0);
			paramGraphics.drawString(Class_a_000.sub_c99(58), this.var_7a3 / 2,
					this.var_7ab / 2 - 1, 33);
			int i;
			if ((i = this.var_7ab / 18) < 12) {
				i = 12;
			}
			m = this.var_7ab / 2 + 1;
			paramGraphics.setColor(13553358);
			Class_d_023.sub_35f8(paramGraphics, 1, m, this.var_7a3 - 2, i);
			paramGraphics.setColor(2370117);
			Class_d_023.sub_35f8(paramGraphics, 2, m + 2, this.var_399b
					* (this.var_7a3 - 6) / 100, i - 4);
			return;
		}
		if (this.var_361b == 2) {
			sub_1480f(paramGraphics);
			return;
		}
		if (this.var_361b == 3) {
			sub_c348(paramGraphics);
			return;
		}
		if (this.var_36c3) {
			sub_bed9(paramGraphics);
			return;
		}
		if (this.var_364b) {
			if (this.var_3653 >= 16) {
				if ((this.var_34c3 != 11) && (this.var_34c3 != 10)) {
					sub_bed9(paramGraphics);
					return;
				}
				paramGraphics.setColor(0);
				paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
				return;
			}
			sub_e77a(paramGraphics, 0, this.var_3653, 16, this.var_365b, null,
					0, 0, this.var_7a3, this.var_7ab);
			return;
		}
		if (this.var_361b == 0) {
			sub_c6ed(paramGraphics);
		} else if (this.var_34c3 == 14) {
			paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
			paramGraphics.setColor(0);
			paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
		} else if ((this.var_34c3 == 10) && (this.var_3b93 >= 1)) {
			sub_bed9(paramGraphics);
		} else if ((this.var_34c3 == 11) && (!this.var_364b)) {
			String str1 = Class_a_000.sub_c99(57);
			paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
			paramGraphics.setFont(Class_e_034.var_137c);
			paramGraphics.setColor(0);
			paramGraphics.fillRect(0, 0, this.var_7a3, this.var_7ab);
			if (this.var_332b == 0) {
				paramGraphics.setColor(16777215);
				if (this.var_398b != null) {
					this.var_398b.sub_876(paramGraphics, this.var_7b3,
							this.var_7bb, 3);
					Class_e_034.sub_1a66(paramGraphics, str1, this.var_7b3,
							this.var_7ab - 2, 33);
				} else {
					m = this.var_7bb - Class_e_034.var_137c.getHeight() / 2;
					Class_e_034.sub_1a66(paramGraphics, str1, this.var_7b3, m,
							17);
				}
			}
		} else {
			paramGraphics.setClip(0, 0, this.var_32cb, this.var_32d3);
			if ((this.var_340b < this.var_32cb)
					|| (this.var_3413 < this.var_32d3)) {
				paramGraphics.setColor(0);
				paramGraphics.fillRect(0, 0, this.var_32cb, this.var_32d3);
			}
			if (this.var_3bc3) {
				int j = Class_e_034.sub_158e() % 10;
				m = Class_e_034.sub_158e() % 4;
				paramGraphics.translate(j, m);
				sub_bbf2(paramGraphics);
				paramGraphics.translate(-j, -m);
			} else {
				sub_bbf2(paramGraphics);
			}
			int j = 0;
			m = this.var_3533.size();
			while (j < m) {
				Class_c_032 localClass_c_032;
				if ((localClass_c_032 = (Class_c_032) this.var_3533
						.elementAt(j)).var_b13 == 3) {
					this.var_343b.sub_852(paramGraphics, this.var_341b
							+ localClass_c_032.var_7dc, this.var_3423
							+ localClass_c_032.var_7e4);
				} else if (localClass_c_032 != this.var_34fb) {
					localClass_c_032.sub_252e(paramGraphics, this.var_341b,
							this.var_3423);
				}
				j++;
			}
			j = 0;
			m = this.var_3533.size();
			while (j < m) {
				((Class_c_032) this.var_3533.elementAt(j)).sub_26ca(
						paramGraphics, this.var_341b, this.var_3423);
				j++;
			}
			int i3;
			int i4;
			if (this.var_353b != null) {
				paramGraphics.setColor(14745682);
				m = 12 + this.var_3a4b / 4;
				int n = 24 - m;
				int i2 = 0;
				i3 = this.var_353b.size();
				while (i2 < i3) {
					short[] arrayOfShort1;
					i4 = (arrayOfShort1 = (short[]) this.var_353b.elementAt(i2))[0]
							* 24 + this.var_341b;
					int i5 = arrayOfShort1[1] * 24 + this.var_3423;
					int i6 = i4 + 12;
					int i7 = i5 + 12;
					short[] arrayOfShort2;
					if (i2 != 0) {
						if ((arrayOfShort2 = (short[]) this.var_353b
								.elementAt(i2 - 1))[0] == arrayOfShort1[0] + 1) {
							paramGraphics.fillRect(i4 + n, i7 - this.var_3a53,
									m, this.var_3a4b);
						} else if (arrayOfShort2[0] == arrayOfShort1[0] - 1) {
							paramGraphics.fillRect(i4, i7 - this.var_3a53, m,
									this.var_3a4b);
						} else if (arrayOfShort2[1] == arrayOfShort1[1] + 1) {
							paramGraphics.fillRect(i6 - this.var_3a53, i5 + n,
									this.var_3a4b, m);
						} else if (arrayOfShort2[1] == arrayOfShort1[1] - 1) {
							paramGraphics.fillRect(i6 - this.var_3a53, i5,
									this.var_3a4b, m);
						}
					}
					if (i2 == i3 - 1) {
						paramGraphics.setClip(0, 0, this.var_32cb,
								this.var_32d3);
						this.var_3453.sub_12a5(paramGraphics, i6, i7, 3);
					} else if ((arrayOfShort2 = (short[]) this.var_353b
							.elementAt(i2 + 1))[0] == arrayOfShort1[0] + 1) {
						paramGraphics.fillRect(i4 + n, i7 - this.var_3a53, m,
								this.var_3a4b);
					} else if (arrayOfShort2[0] == arrayOfShort1[0] - 1) {
						paramGraphics.fillRect(i4, i7 - this.var_3a53, m,
								this.var_3a4b);
					} else if (arrayOfShort2[1] == arrayOfShort1[1] + 1) {
						paramGraphics.fillRect(i6 - this.var_3a53, i5 + n,
								this.var_3a4b, m);
					} else if (arrayOfShort2[1] == arrayOfShort1[1] - 1) {
						paramGraphics.fillRect(i6 - this.var_3a53, i5,
								this.var_3a4b, m);
					}
					i2++;
				}
			}
			if (this.var_34fb != null) {
				this.var_34fb.sub_252e(paramGraphics, this.var_341b,
						this.var_3423);
				this.var_34fb.sub_26ca(paramGraphics, this.var_341b,
						this.var_3423);
			}
			if (this.var_352b) {
				this.var_344b.sub_12a5(paramGraphics, this.var_341b + 12,
						this.var_3423 + 12, 3);
			}
			int k = 0;
			m = this.var_35c3.size();
			while (k < m) {
				Class_f_045 localClass_f_045;
				(localClass_f_045 = (Class_f_045) this.var_35c3.elementAt(k))
						.sub_12d2(paramGraphics, this.var_341b, this.var_3423
								+ localClass_f_045.var_80c);
				k++;
			}
			paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
			k = this.var_7ab - var_32c3;
			if (this.var_378b > 0) {
				Class_d_023.sub_5602(paramGraphics, 0, k, this.var_32cb,
						var_32c3, 14);
				paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
			}
			m = var_32c3 - 24 >> 1;
			int i1 = 24 + m * 2;
			int i2 = this.var_7a3 - i1;
			k += this.var_378b;
			if (this.var_397b) {
				this.var_397b = false;
				Class_d_023.sub_562e(paramGraphics, 0, k, i2 + 1, var_32c3, 0,
						2370117, var_33bb[this.var_356b[this.var_357b]],
						this.var_378b, var_32c3);
				i3 = this.var_7ab - var_32c3 / 2 + this.var_378b;
				if (this.var_332b == 1) {
					i4 = i2 / 2;
					this.var_3763.sub_1209(paramGraphics, 0, i4, i3, 6);
					Class_e_034.sub_189a(
							paramGraphics,
							sub_e3c8(-1, -1, this.var_357b)
									- sub_e3c8(10, -1, this.var_357b) + "/"
									+ this.var_3323, i4 + this.var_3763.var_7f4
									+ 1, i3, 1, 6);
				}
				i4 = 10;
				if (this.var_32cb <= 120) {
					i4 = 4;
				}
				this.var_3763.sub_1209(paramGraphics, 1, i4, i3, 6);
				i4 += this.var_3763.var_7f4 + 1;
				if (this.var_35b3[this.var_357b] == 1) {
					Class_e_034.sub_189a(paramGraphics, ""
							+ this.var_35a3[this.var_357b], i4, i3, 1, 6);
				} else {
					Class_e_034.sub_189a(paramGraphics, "- - -", i4, i3, 1, 6);
				}
				paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
			}
			if (this.var_3983) {
				this.var_3983 = false;
				if (m > 0) {
					sub_d599(paramGraphics, i2, k, i1, var_32c3);
				}
				i3 = i2 + m;
				i4 = k + m;
				this.var_3443[this.var_34bb[this.var_34ab][this.var_34b3]]
						.sub_852(paramGraphics, i3, i4);
				String str2 = "."
						+ var_33e3[sub_dd5d(this.var_34ab, this.var_34b3)];
				Class_e_034.sub_189a(paramGraphics, str2, i3 + 24, i4 + 24, 0,
						40);
				if (m == 0) {
					paramGraphics.setColor(0);
					paramGraphics.drawRect(i3, i4, 24, 24);
				}
			}
			if ((this.var_34c3 == 6)
					&& (this.var_34f3[this.var_34eb].var_b13 != 4)) {
				i3 = 0;
				if (this.var_34b3 * 24 <= this.var_32d3 / 2 - 24) {
					i3 = this.var_32d3 - this.var_346b.var_7fc - this.var_3a43
							+ 2;
				}
				sub_d5f9(paramGraphics, this.var_34fb,
						this.var_34f3[this.var_34eb], i3);
			}
		}
		if (sub_4789()) {
			if (this.var_360b) {
				sub_dbd9(paramGraphics, var_333b, 1, this.var_32d3);
			}
			if (this.var_3613) {
				sub_dbd9(paramGraphics, var_3333, 0, this.var_32d3);
			}
			if ((this.var_361b == 1)
					&& ((this.var_35b3[this.var_357b] == 0) || (this.var_34c3 == 0))
					&& (this.var_34c3 != 11)) {
				sub_dbd9(paramGraphics, var_3333, 3, this.var_32d3);
			}
		}
		if ((this.var_3803) || (this.var_380b)) {
			sub_e77a(paramGraphics, 0, this.var_37fb, 16,
					this.var_3803 ? 0 : 1, null, 0, 0, this.var_7a3,
					this.var_7ab);
		}
	}

	public final void sub_d599(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		paramGraphics.setColor(4344163);
		paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
		paramGraphics.setColor(11384493);
		paramGraphics.fillRect(paramInt1 + 1, paramInt2 + 1, paramInt3 - 2,
				paramInt4 - 2);
		paramGraphics.setColor(4344163);
		paramGraphics.fillRect(paramInt1 + 3, paramInt2 + 3, paramInt3 - 6,
				paramInt4 - 6);
	}

	public final void sub_d5f9(Graphics paramGraphics,
			Class_c_032 paramClass_c_0321, Class_c_032 paramClass_c_0322,
			int paramInt) {
		int i = this.var_3a43 - 2;
		paramGraphics.setColor(11384493);
		paramGraphics.fillRect(0, paramInt, this.var_32cb, i);
		paramGraphics.setColor(0);
		paramGraphics.fillRect(0, i + paramInt, this.var_32cb, 2);
		int k = 0;
		int n;
		int i1 = (n = i / 2) + paramInt;
		for (int i4 = 0; i4 < 3; i4++) {
			this.var_375b.sub_1209(paramGraphics, i4, k + 1, i1, 6);
			k += this.var_375b.var_7f4 + 2;
			int m = paramInt + 1;
			int i2;
			if (i4 == 0) {
				if (this.var_7a3 <= 132) {
					i2 = 56;
				} else {
					i2 = 61 * this.var_32cb / 176;
				}
			} else if (i4 == 1) {
				if (this.var_7a3 <= 132) {
					i2 = 28;
				} else {
					i2 = 47 * this.var_32cb / 176;
				}
			} else {
				i2 = this.var_32cb - k;
			}
			for (int i5 = 0; i5 < 2; i5++) {
				Class_c_032 localClass_c_0321;
				Class_c_032 localClass_c_0322;
				if (i5 == 0) {
					localClass_c_0321 = paramClass_c_0321;
					localClass_c_0322 = paramClass_c_0322;
				} else {
					localClass_c_0321 = paramClass_c_0322;
					localClass_c_0322 = paramClass_c_0321;
				}
				int i3 = i / 2 - 2;
				paramGraphics.setColor(2172994);
				paramGraphics.fillRect(k, m, i2, i3);
				int i6 = k + 1;
				if ((i4 == 0) || (this.var_7a3 > 132)) {
					paramGraphics
							.setColor(var_33bb[this.var_356b[localClass_c_0321.var_acb]]);
					paramGraphics.fillRect(i6, m + 1, 3, i3 - 2);
					i6 += 4;
				}
				int i7 = 0;
				String str = null;
				if (i4 == 0) {
					if ((i5 == 0)
							|| (paramClass_c_0322.sub_1134(paramClass_c_0321,
									paramClass_c_0321.var_ad3,
									paramClass_c_0321.var_adb))) {
						i7 = localClass_c_0321.sub_e5f(localClass_c_0322);
						str = localClass_c_0321.var_af3 + i7 + "-"
								+ (localClass_c_0321.var_afb + i7);
					} else {
						str = "0-0";
					}
				} else if (i4 == 1) {
					i7 = localClass_c_0321.sub_f43(localClass_c_0322);
					str = "" + (localClass_c_0321.var_b03 + i7);
				} else {
					str = "" + localClass_c_0321.var_a93;
				}
				Class_e_034.sub_1954(paramGraphics, str, i6, m + 1, 0);
				if (i7 > 0) {
					this.var_385b.sub_1209(paramGraphics, 1, i6 + 1
							+ Class_e_034.sub_1761((byte) 0, str), m + i3 / 2,
							6);
				} else if (i7 < 0) {
					this.var_385b.sub_1209(paramGraphics, 2, i6 + 1
							+ Class_e_034.sub_1761((byte) 0, str), m + i3 / 2,
							6);
				}
				int i8 = k + i2 - 2;
				if ((i4 == 0) && ((localClass_c_0321.var_b1b & 0x2) != 0)) {
					this.var_3493
							.sub_1209(paramGraphics, 1, i8, m + i3 / 2, 10);
					i8 -= this.var_3493.var_7f4;
				}
				if (((i4 == 0) || (i4 == 1))
						&& ((localClass_c_0321.var_b1b & 0x1) != 0)) {
					this.var_3493
							.sub_1209(paramGraphics, 0, i8, m + i3 / 2, 10);
				}
				m += n;
			}
			k += i2;
		}
	}

	public final void sub_dbd9(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3) {
		int i = 0;
		int j = 0;
		if (paramInt1 == 1024) {
			j = 36;
		} else if (paramInt1 == 2048) {
			i = this.var_7a3;
			j = 40;
		}
		this.var_346b.sub_1209(paramGraphics, paramInt2, i, paramInt3, j);
	}

	public final Class_c_032 sub_dc52(int paramInt1, int paramInt2,
			byte paramByte) {
		int k = 0;
		int m = this.var_3533.size();
		while (k < m) {
			Class_c_032 localClass_c_032;
			int i;
			int j;
			if ((localClass_c_032 = (Class_c_032) this.var_3533.elementAt(k)).var_b13 == 1) {
				i = localClass_c_032.var_ae3;
				j = localClass_c_032.var_aeb;
			} else {
				i = localClass_c_032.var_ad3;
				j = localClass_c_032.var_adb;
			}
			if ((paramInt1 == i) && (paramInt2 == j)) {
				if (paramByte == 0) {
					if (localClass_c_032.var_b13 != 3) {
						return localClass_c_032;
					}
				} else if ((paramByte == 1) && (localClass_c_032.var_b13 == 3)) {
					return localClass_c_032;
				}
			}
			k++;
		}
		return null;
	}

	public final byte sub_dd5d(int paramInt1, int paramInt2) {
		return this.var_3403[this.var_34bb[paramInt1][paramInt2]];
	}

	public final void sub_dd85() {
		Class_e_034.sub_2459();
		this.var_354b = 0;
		this.var_378b = 0;
		this.var_34c3 = 8;
		this.var_3553 = this.var_34d3;
	}

	public final void sub_ddbb() {
		this.var_35ab[this.var_357b][0] = ((byte) this.var_34ab);
		this.var_35ab[this.var_357b][1] = ((byte) this.var_34b3);
		this.var_3583 = ((short) (this.var_3583 + 1));
		this.var_357b = ((byte) ((this.var_357b + 1) % this.var_355b));
		if (this.var_35b3[this.var_357b] == 2) {
			sub_ddbb();
			return;
		}
		for (int i = this.var_3533.size() - 1; i >= 0; i--) {
			Class_c_032 localClass_c_032;
			if ((localClass_c_032 = (Class_c_032) this.var_3533.elementAt(i)).var_b13 == 3) {
				if (localClass_c_032.var_ac3 != 9) {
					Class_c_032 tmp121_120 = localClass_c_032;
					if ((tmp121_120.var_b5b = (byte) (tmp121_120.var_b5b - 1)) <= 0) {
						localClass_c_032.sub_e0d();
					}
				}
			} else {
				localClass_c_032.var_b13 = 0;
				if (((localClass_c_032.var_b1b & 0x1) != 0)
						&& (localClass_c_032.var_b63 == this.var_357b)) {
					localClass_c_032.sub_11e5((byte) 1);
				}
				if (localClass_c_032.var_acb == this.var_357b) {
					localClass_c_032.sub_11e5((byte) 2);
				}
				localClass_c_032.var_b93 = 0;
			}
		}
		this.var_3a5b = 0;
		int i;
		for (i = 0; i < this.var_34bb.length; i++) {
			for (int j = 0; j < this.var_34bb[i].length; j++) {
				if (sub_e312(i, j, this.var_357b)) {
					if (sub_dd5d(i, j) == 8) {
						this.var_3a5b += 30;
					} else if (sub_dd5d(i, j) == 9) {
						this.var_3a5b += 50;
					}
				}
			}
		}
		this.var_35a3[this.var_357b] += this.var_3a5b;
		for (i = 0; i < this.var_3733.length; i++) {
			this.var_3acb[i] = 0;
		}
		if (this.var_35b3[this.var_357b] == 1) {
			sub_bba8(this.var_35ab[this.var_357b][0],
					this.var_35ab[this.var_357b][1]);
		}
		this.var_369b = true;
		this.var_397b = true;
		if (this.var_35b3[this.var_357b] == 0) {
			sub_ea76();
		} else {
			Class_c_032.var_a7b = Class_c_032.var_a73;
		}
		if ((sub_e3c8(-1, 0, this.var_357b) <= 0)
				&& (sub_e353(this.var_357b) == 0)) {
			sub_ddbb();
		}
	}

	public final boolean sub_e065(int paramInt1, int paramInt2,
			Class_c_032 paramClass_c_032) {
		return (paramClass_c_032.sub_232f((short) 8))
				&& (sub_dd5d(paramClass_c_032.var_ad3, paramClass_c_032.var_adb) == 8)
				&& (this.var_34bb[paramClass_c_032.var_ad3][paramClass_c_032.var_adb] < this.var_33f3);
	}

	public final boolean sub_e0c8(int paramInt1, int paramInt2,
			Class_c_032 paramClass_c_032) {
		if ((paramClass_c_032.sub_232f((short) 8))
				&& (sub_dd5d(paramClass_c_032.var_ad3, paramClass_c_032.var_adb) == 8)
				&& (this.var_34bb[paramClass_c_032.var_ad3][paramClass_c_032.var_adb] >= this.var_33f3)
				&& (!sub_e2b4(paramClass_c_032.var_ad3,
						paramClass_c_032.var_adb,
						this.var_3573[paramClass_c_032.var_acb]))) {
			return true;
		}
		return (paramClass_c_032.sub_232f((short) 16))
				&& (sub_dd5d(paramClass_c_032.var_ad3, paramClass_c_032.var_adb) == 9)
				&& (!sub_e2b4(paramClass_c_032.var_ad3,
						paramClass_c_032.var_adb,
						this.var_3573[paramClass_c_032.var_acb]));
	}

	public final void sub_e185(byte paramByte, int paramInt1, int paramInt2) {
		this.var_34bb[paramInt1][paramInt2] = paramByte;
	}

	public final void sub_e1a9(int paramInt1, int paramInt2, int paramInt3) {
		if (this.var_34bb[paramInt1][paramInt2] >= this.var_33f3) {
			sub_e185(
					(byte) (this.var_33f3 + paramInt3 * 2 + (this.var_34bb[paramInt1][paramInt2] - this.var_33f3) % 2),
					paramInt1, paramInt2);
		}
	}

	public final int sub_e206(int paramInt1, int paramInt2) {
		return sub_e22b(paramInt1, paramInt2, this.var_34bb);
	}

	public final int sub_e22b(int paramInt1, int paramInt2,
			byte[][] paramArrayOfByte) {
		if (paramArrayOfByte[paramInt1][paramInt2] >= this.var_33f3) {
			return (paramArrayOfByte[paramInt1][paramInt2] - this.var_33f3) / 2;
		}
		return -1;
	}

	public final int sub_e276(int paramInt) {
		if ((paramInt != -1) && (paramInt != 0)) {
			return this.var_3563[paramInt];
		}
		return -1;
	}

	public final boolean sub_e2b4(int paramInt1, int paramInt2, int paramInt3) {
		int i;
		if ((i = sub_e276(sub_e206(paramInt1, paramInt2))) > -1) {
			return paramInt3 == this.var_3573[i];
		}
		return false;
	}

	public final boolean sub_e312(int paramInt1, int paramInt2, int paramInt3) {
		return sub_e206(paramInt1, paramInt2) == this.var_356b[paramInt3];
	}

	public final int sub_e353(int paramInt) {
		int i = 0;
		for (int j = 0; j < this.var_3ae3; j++) {
			if (sub_e312(this.var_373b[j][0], this.var_373b[j][1], paramInt)) {
				i++;
			}
		}
		return i;
	}

	public final int sub_e3c8(int paramInt1, int paramInt2, byte paramByte) {
		int i = 0;
		int j = 0;
		int k = this.var_3533.size();
		while (j < k) {
			Class_c_032 localClass_c_032 = (Class_c_032) this.var_3533
					.elementAt(j);
			if (((paramInt1 == -1) || (localClass_c_032.var_ac3 == paramInt1))
					&& (((paramInt2 == -1) && (localClass_c_032.var_b13 != 3)) || ((paramInt2 == localClass_c_032.var_b13) && ((paramByte == -1) || (localClass_c_032.var_acb == paramByte))))) {
				i++;
			}
			j++;
		}
		return i;
	}

	public final Class_c_032[] sub_e4c7(int paramInt1, int paramInt2,
			byte paramByte) {
		Vector localVector = new Vector();
		int i = 0;
		int j = this.var_3533.size();
		while (i < j) {
			Class_c_032 localClass_c_032 = (Class_c_032) this.var_3533
					.elementAt(i);
			if (((paramInt1 == -1) || (localClass_c_032.var_ac3 == paramInt1))
					&& (((paramInt2 == -1) && (localClass_c_032.var_b13 != 3)) || ((paramInt2 == localClass_c_032.var_b13) && ((paramByte == -1) || (localClass_c_032.var_acb == paramByte))))) {
				localVector.addElement(localClass_c_032);
			}
			i++;
		}
		Class_c_032[] arrayOfClass_c_032 = new Class_c_032[localVector.size()];
		localVector.copyInto(arrayOfClass_c_032);
		return arrayOfClass_c_032;
	}

	public static final void sub_e5ef(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, Class_h_017 paramClass_h_017,
			int paramInt4, int paramInt5, int paramInt6) {
		int i;
		int j;
		if (paramInt3 == 0) {
			i = paramClass_h_017.var_4db;
			j = paramClass_h_017.var_4e3;
		} else {
			i = paramClass_h_017.var_4e3;
			j = paramClass_h_017.var_4db;
		}
		int k = i / 2;
		int m = j / 1;
		int n = i * paramInt1 / paramInt2;
		int i1 = i * (paramInt2 - paramInt1) / (paramInt2 * 4);
		int i3 = 360 * paramInt1 / paramInt2;
		int i4 = 360 * paramInt6 / m;
		for (int i5 = 0; i5 < m; i5++) {
			int i2 = i1 * Class_a_000.sub_f9b(i3) >> 10;
			if (paramInt3 == 0) {
				paramGraphics.setClip(paramInt4 + k - n / 2 + i2, paramInt5
						+ i5 * 1, n, 1);
				paramClass_h_017.sub_852(paramGraphics, paramInt4 + i2,
						paramInt5);
			} else {
				paramGraphics.setClip(paramInt4 + i5 * 1, paramInt5 + k - n / 2
						+ i2, 1, n);
				paramClass_h_017.sub_852(paramGraphics, paramInt4, paramInt5
						+ i2);
			}
			i3 += i4;
		}
	}

	public static final void sub_e77a(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4,
			Class_h_017 paramClass_h_017, int paramInt5, int paramInt6,
			int paramInt7, int paramInt8) {
		int i = paramInt7 / 8 + 1;
		int j = paramInt8 / 1;
		int k = paramInt3 - 7;
		for (int m = 0; m < 8; m++) {
			int i2;
			if ((i2 = paramInt2 - m * 1) < 0) {
				i2 = 0;
			}
			int i1;
			if (i2 >= k) {
				//int n = 0;
				i1 = i;
			} else {
				i1 = i * i2 / k;
			}
			int i3;
			if (paramInt4 == 1) {
				i3 = m * i + i1;
				i1 = i - i1;
			} else {
				i3 = m * i;
			}
			int i4 = 255 * i1 / i;
			Class_e_034.sub_17ac(paramGraphics, i4 << 24 | paramInt1);
			for (int i5 = 0; i5 < 1; i5++) {
				paramGraphics.fillRect(paramInt5 + i3, paramInt6, i1, j);
			}
		}
	}

	public final boolean sub_e943(byte paramByte, int paramInt1, int paramInt2) {
		if ((this.var_3323 > sub_e3c8(-1, -1, this.var_357b)
				- sub_e3c8(10, -1, this.var_357b))
				&& (paramByte <= this.var_3703)
				&& (Class_c_032.var_bcb[paramByte] <= this.var_35a3[this.var_357b])
				&& (Class_c_032.var_bcb[paramByte] > 0)) {
			sub_913d(this.var_3513, 0);
			return Class_c_032.sub_1d7b(this.var_3513, paramInt1, paramInt2,
					Class_c_032.var_b9b[paramByte], -1, paramByte,
					this.var_357b, true);
		}
		return false;
	}

	public final boolean sub_e9d0(Class_c_032 paramClass_c_032, int paramInt1,
			int paramInt2) {
		if ((this.var_3323 > sub_e3c8(-1, -1, this.var_357b)
				- sub_e3c8(10, -1, this.var_357b))
				&& ((paramClass_c_032.var_ac3 <= this.var_3703) || (paramClass_c_032.var_ac3 == 9))
				&& (paramClass_c_032.var_b8b <= this.var_35a3[this.var_357b])) {
			sub_913d(this.var_3513, 0);
			return Class_c_032.sub_1d7b(this.var_3513, paramInt1, paramInt2,
					Class_c_032.var_b9b[paramClass_c_032.var_ac3], -1,
					paramClass_c_032.var_ac3, this.var_357b, true);
		}
		return false;
	}

	public final void sub_ea76() {
		Class_c_032[] arrayOfClass_c_032 = sub_e4c7(-1, 0, this.var_357b);
		this.var_3b0b = new Vector(arrayOfClass_c_032.length);
		for (int i = 0; i < arrayOfClass_c_032.length; i++) {
			int j;
			for (j = 0; j < i; j++) {
				Class_c_032 localClass_c_032 = (Class_c_032) this.var_3b0b
						.elementAt(j);
				int k = var_3a63[localClass_c_032.var_ac3];
				int m;
				if (((m = var_3a63[arrayOfClass_c_032[i].var_ac3]) < k)
						|| ((m == k) && (arrayOfClass_c_032[i].var_b0b < localClass_c_032.var_b0b))) {
					this.var_3b0b.insertElementAt(arrayOfClass_c_032[i], j);
					break;
				}
			}
			if (j == i) {
				this.var_3b0b.addElement(arrayOfClass_c_032[i]);
			}
		}
		this.var_3ab3 = new Class_c_032[this.var_3733.length];
		this.var_3abb = new byte[this.var_3733.length];
		Class_c_032.var_a7b = Class_c_032.var_a6b;
		this.var_3a9b = 0;
		this.var_3a6b = 0;
	}

	public final void sub_ebb9() throws Exception {
		if (Class_a_000.var_79b.sub_1f81(var_3333)) {
			sub_593d(this.var_3383, this.var_32e3, this.var_32d3, this);
			Class_a_000.var_79b.sub_1f57();
			return;
		}
		if (this.var_3b13) {
			return;
		}
		if (this.var_3a6b == 4) {
			if ((this.var_3a83 != null) || (this.var_3a8b != null)) {
				this.var_3a6b = 5;
				this.var_34fb.sub_1359(this.var_3513, this.var_34fb.var_ad3,
						this.var_34fb.var_adb);
				this.var_3523 = true;
				this.var_351b = true;
				this.var_3aa3 = this.var_34d3;
				if (this.var_3a83 != null) {
					this.var_344b.sub_1134(var_3393[1]);
					sub_bba8(this.var_3a83.var_ad3, this.var_3a83.var_adb);
				} else if (this.var_3a8b != null) {
					sub_bba8(this.var_3a8b.var_ad3, this.var_3a8b.var_adb);
				}
			} else {
				int i;
				if (sub_e0c8(this.var_34fb.var_ad3, this.var_34fb.var_adb,
						this.var_34fb)) {
					i = sub_10b21(this.var_34fb.var_ad3, this.var_34fb.var_adb);
					if ((this.var_3b03 != -1) && (this.var_3b03 != i)) {
						this.var_3ab3[this.var_3b03] = this.var_3ab3[i];
						this.var_3ab3[i] = this.var_34fb;
					}
					sub_e1a9(this.var_34fb.var_ad3, this.var_34fb.var_adb,
							this.var_356b[this.var_34fb.var_acb]);
					Class_a_000.var_79b.sub_1a8c(sub_10c0e(null,
							Class_a_000.sub_c99(73), this.var_32d3, 1000));
					Class_e_034.sub_24ab(9, 1);
					this.var_34c3 = 9;
					this.var_3553 = this.var_34d3;
				} else if (sub_e065(this.var_34fb.var_ad3,
						this.var_34fb.var_adb, this.var_34fb)) {
					i = sub_10b21(this.var_34fb.var_ad3, this.var_34fb.var_adb);
					if ((this.var_3b03 != -1) && (this.var_3b03 != i)) {
						this.var_3ab3[this.var_3b03] = this.var_3ab3[i];
						this.var_3ab3[i] = this.var_34fb;
					}
					sub_e185((byte) this.var_33f3, this.var_34fb.var_ad3,
							this.var_34fb.var_adb);
					Class_a_000.var_79b.sub_1a8c(sub_10c0e(null,
							Class_a_000.sub_c99(74), this.var_32d3, 1000));
					Class_e_034.sub_24ab(9, 1);
					this.var_34c3 = 0;
					this.var_3553 = this.var_34d3;
				} else {
					this.var_34c3 = 0;
				}
				this.var_34fb.sub_2352();
				this.var_34fb = null;
				this.var_3a6b = 0;
			}
			this.var_352b = true;
			return;
		}
		if (this.var_3a6b == 5) {
			if (this.var_34d3 - this.var_3aa3 >= 500L) {
				if (this.var_3a83 != null) {
					sub_55bd(this.var_34fb, this.var_3a83);
				} else if (this.var_3a8b != null) {
					sub_b6fe(this.var_3a8b, this.var_357b);
					this.var_3a8b = null;
					this.var_3a6b = 7;
					this.var_34fb.sub_2352();
				}
				this.var_351b = false;
				this.var_3523 = false;
			}
		} else if (this.var_3a6b == 7) {
			if (this.var_35eb == null) {
				this.var_3a6b = 0;
				this.var_34c3 = 0;
			}
		} else if (this.var_3a6b == 6) {
			if (this.var_34d3 - this.var_3aa3 >= 1000L) {
				this.var_3a83 = null;
				this.var_3a6b = 0;
				this.var_34c3 = 0;
			}
		} else {
			if (this.var_3a6b == 2) {
				return;
			}
			Object localObject;
			if (this.var_3a6b == 3) {
				if (this.var_3a9b == 0) {
					if (sub_b7ff(this.var_34fb.var_7dc + 12,
							this.var_34fb.var_7e4 + 12)) {
						if ((this.var_332b == 0) && (this.var_34db == 7)
								&& (this.var_34fb == this.var_358b[1])) {
							this.var_39b3 = null;
							Class_c_032[] localObject1 = sub_e4c7(-1, -1,
									(byte) 0);
							if (localObject1.length > 0) {
								sub_558c(localObject1[Class_e_034
										.sub_1544(localObject1.length)]);
							}
							this.var_3a6b = 4;
							return;
						}
						this.var_3a9b = 1;
						this.var_3aa3 = this.var_34d3;
					}
				} else if (this.var_3a9b == 1) {
					if (this.var_34d3 - this.var_3aa3 >= 100L) {
						this.var_351b = true;
						this.var_3523 = false;
						this.var_3a9b = 2;
						this.var_34c3 = 1;
						this.var_3aa3 = this.var_34d3;
					}
				} else if (this.var_3a9b == 2) {
					if (this.var_34d3 - this.var_3aa3 >= 200L) {
						this.var_34ab = this.var_3a73;
						this.var_34b3 = this.var_3a7b;
						this.var_344b.sub_10c6(this.var_3a73 * 24,
								this.var_3a7b * 24);
						this.var_353b = this.var_34fb.sub_1b48(
								this.var_34fb.var_ad3, this.var_34fb.var_adb,
								this.var_34ab, this.var_34b3);
						this.var_3a9b = 3;
						this.var_3aa3 = this.var_34d3;
					}
				} else if ((this.var_3a9b == 3)
						&& (this.var_34d3 - this.var_3aa3 >= 200L)) {
					this.var_353b = null;
					this.var_34fb.sub_18b7(this.var_3a73, this.var_3a7b, true);
					this.var_3a6b = 2;
					this.var_3a9b = 0;
					this.var_34c3 = 2;
				}
				return;
			}
			if (this.var_3b0b.size() == 0) {
				localObject = null;
				int j = 0;
				int k = 6666;
				int m = 0;
				int n = 0;
				int i2;
				int i3;
				byte i6;
				for (int i1 = 0; i1 < this.var_3733.length; i1++) {
					i2 = this.var_3733[i1][0];
					i3 = this.var_3733[i1][1];
					if ((sub_dd5d(i2, i3) == 9)
							&& (sub_e312(i2, i3, this.var_357b))) {
						if (j == 0) {
							m = i2;
							n = i3;
						}
						j++;
						int i5 = 0;
						int i9;
						for (int i61 = this.var_3533.size() - 1; i61 >= 0; i61--) {
							Class_c_032 localClass_c_032 = (Class_c_032) this.var_3533
									.elementAt(i61);
							if ((this.var_3573[localClass_c_032.var_acb] != this.var_3573[this.var_357b])
									&& (localClass_c_032.sub_232f((short) 16))) {
								if ((i9 = Math.abs(localClass_c_032.var_ad3
										- i2)
										+ Math.abs(localClass_c_032.var_adb
												- i3)) < k) {
									k = i9;
									m = i2;
									n = i3;
								}
								i5++;
							}
						}
						if (i5 == 0) {
							for (i6 = 0; i6 < this.var_3733.length; i6++) {
								int i8 = this.var_3733[i6][0];
								i9 = this.var_3733[i6][1];
								int i10;
								if ((sub_dd5d(i8, i9) == 9)
										&& (!sub_e312(i8, i9, this.var_357b))
										&& ((i10 = Math.abs(i8 - i2)
												+ Math.abs(i9 - i3)) < k)) {
									k = i10;
									m = i2;
									n = i3;
								}
							}
						}
					}
				}
				if (j > 0) {

					for (int i1 = 0; i1 < this.var_359b[this.var_357b]; i1++) {
						if ((this.var_3593[this.var_357b][i1] != null)
								&& (this.var_3593[this.var_357b][i1].var_b13 == 3)
								&& (sub_e9d0(this.var_3593[this.var_357b][i1],
										m, n))) {
							localObject = sub_8722(
									this.var_3593[this.var_357b][i1], m, n);
						}
					}
					if (localObject == null) {
						if ((sub_e3c8(0, -1, this.var_357b) < 2)
								&& (sub_e943((byte) 0, m, n))) {
							localObject = sub_8788((byte) 0, m, n);
						} else if ((sub_e3c8(1, -1, this.var_357b) < 2)
								&& (sub_e943((byte) 1, m, n))) {
							localObject = sub_8788((byte) 1, m, n);
						} else {
							int i1 = 0;
							i2 = 0;
							int i4;
							for (i3 = 0; i3 < this.var_355b; i4 = (byte) (i3 + 1)) {
								if (this.var_3573[i3] == this.var_3573[this.var_357b]) {
									i1 += sub_e3c8(-1, -1, (byte) i3);
								} else {
									i2 += sub_e3c8(-1, -1, (byte) i3);
								}
							}
							if ((this.var_35a3[this.var_357b] >= 1000)
									|| (sub_e3c8(-1, -1, this.var_357b) < 8)
									|| (i1 < i2)) {
								i4 = 0;
								byte[] arrayOfByte = new byte[12];
								int i7;
								for (i6 = 1; i6 < 12; i7 = (byte) (i6 + 1)) {
									if (((sub_e3c8(i6, -1, this.var_357b) < 1) || (Class_c_032.var_bcb[i6] >= 600))
											&& (sub_e943(i6, m, n))) {
										arrayOfByte[i4] = i6;
										i4++;
									}
								}
								if (i4 > 0) {
									i7 = arrayOfByte[(Math.abs(Class_e_034
											.sub_158e()) % i4)];
									localObject = sub_8788((byte) i7, m, n);
								}
							}
						}
					}
				}
				if (localObject != null) {
					sub_f66c((Class_c_032) localObject);
					return;
				}
				this.var_3aab = null;
				this.var_3b0b = null;
				sub_dd85();
				return;
			}
			if ((this.var_332b == 0) && (this.var_34db == 7)
					&& (this.var_358b[1].var_b13 != 2)) {
				this.var_34fb = this.var_358b[1];
				sub_bba8(this.var_34fb.var_ad3, this.var_34fb.var_adb);
				this.var_39b3 = this.var_34fb;
				this.var_3a6b = 3;
				this.var_3b0b.removeElement(this.var_34fb);
				return;
			}
			if ((localObject = this.var_3a93) == null) {
				localObject = (Class_c_032) this.var_3b0b.elementAt(0);
			}
			sub_f66c((Class_c_032) localObject);
			if (this.var_3a93 == null) {
				this.var_3b0b.removeElement(localObject);
			}
		}
	}

	public final void sub_f66c(Class_c_032 paramClass_c_032) {
		this.var_34fb = paramClass_c_032;
		this.var_352b = true;
		sub_913d(this.var_3513, 0);
		this.var_34fb.sub_1d3c(this.var_3513);
		this.var_351b = false;
		this.var_3aab = sub_e4c7(0, -1, this.var_357b);
		int i = 0;
		int j = this.var_358b.length + this.var_3aab.length
				+ this.var_3733.length;
		this.var_3ac3 = new int[j][5];
		this.var_3ad3 = 0;
		int m = 10000;
		this.var_3aeb = -1;
		this.var_3af3 = -1;
		this.var_3afb = -1;
		this.var_3b03 = -1;
		for (int n = 0; n < this.var_3aab.length + this.var_358b.length; n++) {
			Class_c_032 localClass_c_0321 = null;
			if (n >= this.var_3aab.length) {
				if ((localClass_c_0321 = this.var_358b[(n - this.var_3aab.length)]) != null) {
					if (localClass_c_0321.var_b13 == 3) {
						localClass_c_0321 = null;
					} else if ((this.var_3573[localClass_c_0321.var_acb] != this.var_3573[this.var_357b])
							&& (this.var_358b[this.var_357b] == null)) {
						this.var_3ac3[i][2] += localClass_c_0321.sub_1318(
								localClass_c_0321.var_ad3,
								localClass_c_0321.var_adb, null) * 2;
					} else if ((this.var_3583 >= 15)
							&& (this.var_3573[localClass_c_0321.var_acb] != this.var_3573[this.var_357b])
							&& (sub_e3c8(-1, -1, localClass_c_0321.var_acb) < 4)
							&& (sub_e3c8(-1, -1, this.var_357b) >= 8)) {
						this.var_3ac3[i][2] += localClass_c_0321.sub_1318(
								localClass_c_0321.var_ad3,
								localClass_c_0321.var_adb, null) * 2;
					} else if (localClass_c_0321.var_acb != this.var_357b) {
						localClass_c_0321 = null;
					}
				}
			} else if (this.var_358b[this.var_357b] != null) {
				localClass_c_0321 = this.var_3aab[n];
			}
			if (localClass_c_0321 != null) {
				this.var_3ac3[i][0] = localClass_c_0321.var_ad3;
				this.var_3ac3[i][1] = localClass_c_0321.var_adb;
				if (localClass_c_0321.var_acb == this.var_357b) {
					Class_c_032[] arrayOfClass_c_0321 = localClass_c_0321
							.sub_15e7(localClass_c_0321.var_ad3,
									localClass_c_0321.var_adb, 1, 5, (byte) 0);
					for (int i3 = 0; i3 < arrayOfClass_c_0321.length; i3++) {
						if (arrayOfClass_c_0321[i3].var_b13 != 4) {
							this.var_3ac3[i][2] += arrayOfClass_c_0321[i3]
									.sub_1318(arrayOfClass_c_0321[i3].var_ad3,
											arrayOfClass_c_0321[i3].var_adb,
											localClass_c_0321);
						}
					}
				}
				if (this.var_3ac3[i][2] > 0) {
					this.var_3ac3[i][4] += localClass_c_0321.sub_1318(
							localClass_c_0321.var_ad3,
							localClass_c_0321.var_adb, null);
					this.var_3ac3[i][4] += localClass_c_0321.var_b93;
					if (this.var_3ac3[i][2] > this.var_3ad3) {
						this.var_3ad3 = this.var_3ac3[i][2];
					}
					this.var_3ac3[i][3] = (Math.abs(localClass_c_0321.var_ad3
							- paramClass_c_032.var_ad3) + Math
							.abs(localClass_c_0321.var_adb
									- paramClass_c_032.var_adb));
					if (this.var_3ac3[i][3] < 1) {
						this.var_3ac3[i][3] = 1;
					}
					if (this.var_3ac3[i][3] < m) {
						m = this.var_3ac3[i][3];
					}
				} else {
					this.var_3ac3[i][2] = -6666;
				}
			} else {
				this.var_3ac3[i][2] = -6666;
			}
			i++;
		}
		int n = 666;
		int i1 = 666;
		int i2 = -1;
		int i3 = -1;
		int i7;
		int i5;
		byte i6;
		for (int i4 = 0; i4 < this.var_3733.length; i4++) {
			i5 = this.var_3733[i4][0];
			i6 = this.var_3733[i4][1];
			i7 = sub_dd5d(i5, i6);
			boolean bool = sub_e312(i5, i6, paramClass_c_032.var_acb);
			this.var_3ac3[i][2] = -6666;
			Class_c_032[] localObject;
			int i10;
			if ((bool) || (this.var_3ab3[i4] != null)) {
				localObject = paramClass_c_032.sub_15e7(i5, i6, 1, 5, (byte) 0);
				this.var_3ac3[i][0] = i5;
				this.var_3ac3[i][1] = i6;
				this.var_3ac3[i][2] = 0;
				for (i10 = 0; i10 < localObject.length; i10++) {
					if (localObject[i10].var_b13 != 4) {
						if ((this.var_3ab3[i4] != null) && (!bool)) {
							this.var_3ac3[i][2] += localObject[i10].sub_1318(
									localObject[i10].var_ad3,
									localObject[i10].var_adb, null);
						} else if (((i7 == 8) && (localObject[i10]
								.sub_232f((short) 8)))
								|| ((i7 == 9) && (localObject[i10]
										.sub_232f((short) 16)))) {
							this.var_3ac3[i][2] += localObject[i10].sub_1318(
									localObject[i10].var_ad3,
									localObject[i10].var_adb, null);
						}
					}
				}
				if (this.var_3ac3[i][2] == 0) {
					if ((this.var_3ab3[i4] != null) && (!bool)) {
						this.var_3ac3[i][2] = 100;
						this.var_3ac3[i][4] += 2000;
					} else {
						this.var_3ac3[i][2] = -6666;
					}
				}
				if (this.var_3ac3[i][2] != -6666) {
					this.var_3ac3[i][4] += this.var_3acb[i4];
					if (this.var_3ac3[i][2] > this.var_3ad3) {
						this.var_3ad3 = this.var_3ac3[i][2];
					}
					this.var_3ac3[i][3] = (Math.abs(i5
							- paramClass_c_032.var_ad3) + Math.abs(i6
							- paramClass_c_032.var_adb));
					if (this.var_3ac3[i][3] < 1) {
						this.var_3ac3[i][3] = 1;
					}
					if (this.var_3ac3[i][3] < m) {
						m = this.var_3ac3[i][3];
					}
				}
			}
			if (sub_e2b4(i5, i6, this.var_3573[paramClass_c_032.var_acb])) {
				Class_c_032 localObject1 = sub_dc52(i5, i6, (byte) 0);
				if ((((localObject1) == null) || (((Class_c_032) localObject1).var_acb == paramClass_c_032.var_acb))
						&& ((i10 = Math.abs(i5 - paramClass_c_032.var_ad3)
								+ Math.abs(i6 - paramClass_c_032.var_adb)) < i1)) {
					i3 = i4;
					i1 = i10;
				}
			} else if (((this.var_3ab3[i4] == null) || (this.var_3ab3[i4] == paramClass_c_032))
					&& (((i7 == 8) && (paramClass_c_032.sub_232f((short) 8))) || ((i7 == 9) && (paramClass_c_032
							.sub_232f((short) 16))))) {
				int i9;
				if ((i9 = Math.abs(i5 - paramClass_c_032.var_ad3)
						+ Math.abs(i6 - paramClass_c_032.var_adb)) < n) {
					i2 = i4;
					n = i9;
				}
				Class_c_032 localClass_c_0324 = sub_dc52(i5, i6, (byte) 0);
				if ((i9 < i1)
						&& (this.var_3513[i5][i6] > 0)
						&& ((localClass_c_0324 == null) || (localClass_c_0324.var_acb == paramClass_c_032.var_acb))) {
					i3 = i4;
					i1 = i9;
				}
			}
			i++;
		}
		int i4;
		if ((paramClass_c_032.var_b0b < 50) && (i3 != -1)) {
			if (i3 == i2) {
				this.var_3b03 = i2;
			}
			this.var_3ab3[i3] = paramClass_c_032;
			this.var_3aeb = this.var_3733[i3][0];
			this.var_3af3 = this.var_3733[i3][1];
			sub_913d(this.var_3adb, 0);
			Class_c_032.sub_1d7b(this.var_3adb, this.var_3aeb, this.var_3af3,
					10, -1, paramClass_c_032.var_ac3, this.var_357b, false);
		} else if ((this.var_358b[this.var_357b] != null)
				&& (i2 != -1)
				&& ((paramClass_c_032.sub_232f((short) 8)) || (paramClass_c_032
						.sub_232f((short) 16)))) {
			this.var_3b03 = i2;
			this.var_3ab3[i2] = paramClass_c_032;
			this.var_3aeb = this.var_3733[i2][0];
			this.var_3af3 = this.var_3733[i2][1];
			sub_913d(this.var_3adb, 0);
			Class_c_032.sub_1d7b(this.var_3adb, this.var_3aeb, this.var_3af3,
					10, -1, paramClass_c_032.var_ac3, this.var_357b, false);
		} else {
			i4 = -1;
			i5 = -6666;
			for (i6 = 0; i6 < i; i6++) {
				if (this.var_3ac3[i6][2] > -6666) {
					if (this.var_3ac3[i6][2] > 0) {
						this.var_3ac3[i6][2] = (this.var_3ac3[i6][2] * m / this.var_3ac3[i6][3]);
					}
					this.var_3ac3[i6][2] -= this.var_3ac3[i6][4];
					if (this.var_3ac3[i6][2] > i5) {
						i5 = this.var_3ac3[i6][2];
						i4 = i6;
					}
				}
			}
			if (i4 != -1) {
				int i61 = paramClass_c_032.sub_1318(paramClass_c_032.var_ad3,
						paramClass_c_032.var_adb, null);
				if (i4 < this.var_3aab.length) {
					this.var_3aab[i4].var_b93 += i61;
				} else if (i4 < this.var_358b.length + this.var_3aab.length) {
					this.var_358b[(i4 - this.var_3aab.length)].var_b93 += i61;
				} else {
					this.var_3afb = (i4 - this.var_358b.length - this.var_3aab.length);
					this.var_3acb[this.var_3afb] += i61;
				}
				this.var_3aeb = this.var_3ac3[i4][0];
				this.var_3af3 = this.var_3ac3[i4][1];
				sub_913d(this.var_3adb, 0);
				Class_c_032.sub_1d7b(this.var_3adb, this.var_3aeb,
						this.var_3af3, 10, -1, paramClass_c_032.var_ac3,
						this.var_357b, false);
			}
		}
		i4 = -10000;
		int i51 = 0;
		int i61 = this.var_3513.length;
		while (i51 < i61) {
			i7 = 0;
			int i8 = this.var_3513[i51].length;
			while (i7 < i8) {
				Class_c_032 localClass_c_0323;
				if ((this.var_3513[i51][i7] > 0)
						&& (((localClass_c_0323 = sub_dc52(i51, i7, (byte) 0)) == null)
								|| (localClass_c_0323 == paramClass_c_032) || ((this.var_3a93 == null)
								&& (localClass_c_0323.var_acb == paramClass_c_032.var_acb) && (localClass_c_0323.var_b13 == 0)))) {
					int i11;
					if ((!paramClass_c_032.sub_232f((short) 512))
							|| (localClass_c_0323 == paramClass_c_032)) {
						Class_c_032[] arrayOfClass_c_0322 = paramClass_c_032
								.sub_15b5(i51, i7, (byte) 0);
						for (int i13 = 0; i13 < arrayOfClass_c_0322.length; i13++) {
							if ((i11 = sub_1062b(paramClass_c_032, i51, i7,
									arrayOfClass_c_0322[i13], null)) > i4) {
								this.var_3a8b = null;
								this.var_3a83 = arrayOfClass_c_0322[i13];
								i4 = i11;
								this.var_3a73 = i51;
								this.var_3a7b = i7;
							}
						}
					}
					if (paramClass_c_032.sub_232f((short) 32)) {
						this.var_34f3 = paramClass_c_032.sub_15b5(i51, i7,
								(byte) 1);
						for (int i12 = 0; i12 < this.var_34f3.length; i12++) {
							if ((i11 = sub_1062b(paramClass_c_032, i51, i7,
									null, this.var_34f3[i12])) > i4) {
								this.var_3a83 = null;
								this.var_3a8b = this.var_34f3[i12];
								i4 = i11;
								this.var_3a73 = i51;
								this.var_3a7b = i7;
							}
						}
					}
					if ((i11 = sub_1062b(paramClass_c_032, i51, i7, null, null)) > i4) {
						this.var_3a83 = null;
						this.var_3a8b = null;
						i4 = i11;
						this.var_3a73 = i51;
						this.var_3a7b = i7;
					}
				}
				i7++;
			}
			i51++;
		}
		if (this.var_3b03 != -1) {
			this.var_3abb[this.var_3b03] = ((byte) (10 - this.var_3adb[this.var_3a73][this.var_3a7b]));
		}
		this.var_3a93 = null;
		Class_c_032 localClass_c_0322;
		if (((localClass_c_0322 = sub_dc52(this.var_3a73, this.var_3a7b,
				(byte) 0)) != null) && (localClass_c_0322 != paramClass_c_032)) {
			this.var_3a93 = localClass_c_0322;
			this.var_3a6b = 0;
			return;
		}
		sub_bba8(paramClass_c_032.var_ad3, paramClass_c_032.var_adb);
		this.var_39b3 = paramClass_c_032;
		this.var_3a6b = 3;
	}

	public final int sub_1062b(Class_c_032 paramClass_c_0321, int paramInt1,
			int paramInt2, Class_c_032 paramClass_c_0322,
			Class_c_032 paramClass_c_0323) {
		int i = 0;
		int m;
		if ((this.var_3b03 != -1)
				&& (this.var_358b[paramClass_c_0321.var_acb] != null)) {
			if (this.var_3aeb != -1) {
				if (this.var_3adb[paramInt1][paramInt2] > 0) {
					i = 0 + (100 + 100 * this.var_3adb[paramInt1][paramInt2] / 10);
				} else {
					int j = Math.abs(this.var_3aeb - paramClass_c_0321.var_ad3)
							+ Math.abs(this.var_3af3
									- paramClass_c_0321.var_adb);
					m = Math.abs(this.var_3aeb - paramInt1)
							+ Math.abs(this.var_3af3 - paramInt2);
					i = 0
							+ 100
							* (j - m)
							/ (Class_c_032.var_b9b[paramClass_c_0321.var_ac3] - 1);
					if (var_33eb[sub_dd5d(paramInt1, paramInt2)] <= 1) {
						i += 20;
					}
				}
			}
			if ((paramClass_c_0322 == null)
					&& (!sub_e2b4(paramInt1, paramInt2,
							this.var_3573[paramClass_c_0321.var_acb]))) {
				if ((paramClass_c_0321.sub_232f((short) 16))
						&& (sub_dd5d(paramInt1, paramInt2) == 9)) {
					i += 300;
				} else if ((paramClass_c_0321.sub_232f((short) 8))
						&& ((sub_dd5d(paramInt1, paramInt2) == 8) || (this.var_34bb[paramInt1][paramInt2] == 27))) {
					i += 200;
				}
			}
		}
		switch (paramClass_c_0321.var_ac3) {
		case 3:
			if (paramClass_c_0323 != null) {
				i += 100;
			}
			break;
		case 4:
			Class_c_032[] arrayOfClass_c_032 = paramClass_c_0321.sub_15e7(
					paramInt1, paramInt2, 1, 2, (byte) 2);
			if (paramClass_c_0323 != null) {
				i += 25 * arrayOfClass_c_032.length;
			}
			break;
		case 2:
			if (sub_dd5d(paramInt1, paramInt2) == 5) {
				i += 25;
			}
			break;
		}
		if (paramClass_c_0322 != null) {
			if (paramClass_c_0322.var_b13 == 4) {
				int k = sub_e206(paramClass_c_0322.var_ad3,
						paramClass_c_0322.var_adb);
				m = sub_10b21(paramClass_c_0322.var_ad3,
						paramClass_c_0322.var_adb);
				if ((k != 0) && (m != -1) && (this.var_3ab3[m] == null)) {
					i += paramClass_c_0321.sub_1318(paramInt1, paramInt2,
							paramClass_c_0322) / 2;
				}
			} else {
				if (!paramClass_c_0322.sub_1134(paramClass_c_0321, paramInt1,
						paramInt2)) {
					i += paramClass_c_0321.sub_1318(paramInt1, paramInt2,
							paramClass_c_0322) * 2;
				} else {
					i += paramClass_c_0321.sub_1318(paramInt1, paramInt2,
							paramClass_c_0322)
							* 3
							/ 2
							- paramClass_c_0322.sub_1318(paramInt1, paramInt2,
									paramClass_c_0321);
				}
				if (paramClass_c_0322.var_ac3 == 9) {
					i += 25;
				} else if (paramClass_c_0322.var_ac3 == 11) {
					i += 100;
				}
			}
		}
		i += var_33e3[sub_dd5d(paramInt1, paramInt2)];
		if ((paramClass_c_0321.var_b0b < 100)
				&& (sub_e2b4(paramInt1, paramInt2,
						this.var_3573[paramClass_c_0321.var_acb]))) {
			i += 100 - paramClass_c_0321.var_b0b;
		}
		int k = sub_10b21(paramInt1, paramInt2);
		int n;
		if (this.var_3adb[paramInt1][paramInt2] > 0) {
			m = this.var_3adb[paramInt1][paramInt2];
			n = 10 - Class_c_032.var_b9b[paramClass_c_0321.var_ac3] / 2;
			if (m > n) {
				m = n;
			}
			i += 50 + 100 * m / n;
		} else if (this.var_3aeb != -1) {
			m = Math.abs(this.var_3aeb - paramClass_c_0321.var_ad3)
					+ Math.abs(this.var_3af3 - paramClass_c_0321.var_adb);
			n = Math.abs(this.var_3aeb - paramInt1)
					+ Math.abs(this.var_3af3 - paramInt2);
			i += 50 * (m - n)
					/ (Class_c_032.var_b9b[paramClass_c_0321.var_ac3] - 1);
		}
		Class_c_032 localClass_c_032;
		if ((k != -1)
				&& ((localClass_c_032 = this.var_3ab3[k]) != null)
				&& (localClass_c_032 != paramClass_c_0321)
				&& (localClass_c_032.var_b13 == 0)
				&& (this.var_3abb[k] < Class_c_032.var_b9b[localClass_c_032.var_ac3])) {
			i -= 200;
		}
		return i += 20
				* (Math.abs(paramInt1 - paramClass_c_0321.var_ad3) + Math
						.abs(paramInt2 - paramClass_c_0321.var_adb))
				/ (Class_c_032.var_b9b[paramClass_c_0321.var_ac3] - 1);
	}

	public final int sub_10b21(int paramInt1, int paramInt2) {
		for (int i = 0; i < this.var_3733.length; i++) {
			if ((this.var_3733[i][0] == paramInt1)
					&& (this.var_3733[i][1] == paramInt2)) {
				return i;
			}
		}
		return -1;
	}

	public final void sub_10b94(int paramInt) {
		this.var_3b1b = paramInt;
		this.var_3b73 = true;
	}

	public final Class_d_023 sub_10bb9(String paramString, byte paramByte1,
			byte paramByte2) {
		Class_d_023 localClass_d_023 = new Class_d_023((byte) 7, 12);
		int i = Class_e_034.var_138c * 3;
		localClass_d_023.sub_1a04(paramString, this.var_7a3, i, paramByte1,
				paramByte2);
		localClass_d_023.sub_193f(0, this.var_7ab - i, 0);
		Class_a_000.var_79b.sub_1a8c(localClass_d_023);
		return localClass_d_023;
	}

	public final Class_d_023 sub_10c0e(String paramString1,
			String paramString2, int paramInt1, int paramInt2) {
		return sub_10c33(paramString1, paramString2, paramInt1, -1, paramInt2);
	}

	public final Class_d_023 sub_10c33(String paramString1,
			String paramString2, int paramInt1, int paramInt2, int paramInt3) {
		Class_d_023 localClass_d_023;
		(localClass_d_023 = new Class_d_023((byte) 10, 12)).sub_1ceb(
				paramString1, paramString2, this.var_7a3, paramInt2);
		localClass_d_023.sub_193f(this.var_7b3, paramInt1 / 2, 3);
		localClass_d_023.var_10ed = this;
		localClass_d_023.var_10c5 = paramInt3;
		return localClass_d_023;
	}

	public final void sub_10c83() throws Exception {
		this.var_3b4b = null;
		if (this.var_332b == 0) {
			this.var_378b = var_32c3;
			this.var_3793 = true;
			this.var_3783 = false;
			this.var_3b23 = sub_10c0e(null, this.var_388b, this.var_7ab, 2000);
			this.var_3b23.sub_193f(this.var_7b3, this.var_7bb, 3);
			this.var_3813 = true;
			this.var_380b = true;
			this.var_37fb = 0;
		}
		if (this.var_34db == 0) {
			this.var_3703 = 0;
			this.var_35a3[0] = 0;
			this.var_35a3[1] = 0;
			Class_c_032.var_a7b = 4;
			this.var_39bb = 2;
			sub_b9c5(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_bba8(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_c019(2, 3, 3);
			Class_e_034.sub_2439(1, 1);
			this.var_3813 = false;
			this.var_352b = false;
			this.var_3b5b = 0;
			return;
		}
		if (this.var_34db == 1) {
			this.var_3703 = 1;
			this.var_35a3[0] = 300;
			this.var_35a3[1] = 50;
			Class_c_032.var_a7b = 4;
			this.var_39bb = 2;
			this.var_358b[0].sub_e33(2);
			sub_b9c5(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_bba8(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_dc52(7, 12, (byte) 0).sub_18b7(7, 10, false);
			sub_dc52(8, 11, (byte) 0).sub_18b7(8, 9, false);
			sub_dc52(9, 12, (byte) 0).sub_18b7(9, 10, false);
			sub_143f6(7, 3);
			Class_a_000.var_79b.sub_1a8c(this.var_3b23);
			return;
		}
		if (this.var_34db == 2) {
			this.var_3703 = 0;
			this.var_35a3[0] = 0;
			this.var_35a3[1] = 0;
			Class_c_032.var_a7b = 4;
			this.var_35a3[0] = 0;
			sub_b9c5(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_bba8(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			this.var_3b2b = sub_dc52(8, 17, (byte) 0);
			this.var_3b33 = sub_dc52(8, 18, (byte) 0);
			this.var_3b3b = sub_dc52(8, 19, (byte) 0);
			this.var_3b2b.sub_18b7(8, 15, false);
			this.var_3b33.sub_18b7(8, 15, false);
			this.var_3b3b.sub_18b7(8, 15, false);
			this.var_358b[0].sub_18b7(8, 14, false);
			this.var_352b = false;
			Class_a_000.var_79b.sub_1a8c(this.var_3b23);
			this.var_3b5b = 0;
			return;
		}
		if (this.var_34db == 3) {
			this.var_3703 = 7;
			Class_c_032.var_a7b = 4;
			this.var_35a3[0] = 400;
			this.var_35a3[1] = 400;
			this.var_3b2b = Class_c_032.sub_d3d((byte) 0, (byte) 0, -1, 5);
			this.var_3b33 = Class_c_032.sub_d3d((byte) 2, (byte) 0, -2, 5);
			this.var_3b3b = Class_c_032.sub_d3d((byte) 3, (byte) 0, -3, 5);
			this.var_3b2b.sub_18b7(3, 4, false);
			this.var_3b33.sub_18b7(4, 4, false);
			this.var_3b3b.sub_18b7(2, 4, false);
			this.var_358b[0].sub_18b7(3, 3, false);
			sub_b9c5(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_bba8(3, 3);
			this.var_39b3 = this.var_358b[0];
			sub_c019(3, 3, 3);
			Class_e_034.sub_2439(1, 1);
			this.var_3813 = false;
			this.var_352b = false;
			this.var_3b5b = 0;
			return;
		}
		Class_c_032 localClass_c_0321;
		if (this.var_34db == 4) {
			this.var_3703 = 0;
			this.var_35a3[0] = 0;
			this.var_35a3[1] = 0;
			sub_b998(this.var_358b[0].var_7dc + 12,
					this.var_358b[0].var_7e4 + 12);
			sub_bba8(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			Class_c_032.var_a7b = 4;
			(localClass_c_0321 = sub_dc52(11, 2, (byte) 0)).sub_128b(11, -3);
			localClass_c_0321.sub_18b7(11, 2, false);
			(localClass_c_0321 = sub_dc52(10, 1, (byte) 0)).sub_128b(10, -5);
			localClass_c_0321.sub_18b7(10, 1, false);
			(localClass_c_0321 = sub_dc52(11, 1, (byte) 0)).sub_128b(11, -5);
			localClass_c_0321.sub_18b7(11, 1, false);
			(localClass_c_0321 = sub_dc52(12, 1, (byte) 0)).sub_128b(12, -5);
			localClass_c_0321.sub_18b7(12, 1, false);
			(localClass_c_0321 = sub_dc52(11, 0, (byte) 0)).sub_128b(11, -7);
			localClass_c_0321.sub_18b7(11, 0, false);
			(localClass_c_0321 = sub_dc52(12, 0, (byte) 0)).sub_128b(12, -7);
			localClass_c_0321.sub_18b7(12, 0, false);
			Class_a_000.var_79b.sub_1a8c(this.var_3b23);
			this.var_352b = false;
			this.var_3b5b = 0;
			return;
		}
		if (this.var_34db == 5) {
			this.var_3703 = 7;
			this.var_35a3[0] = 600;
			this.var_35a3[1] = 600;
			this.var_358b[0].sub_e33(2);
			sub_b9c5(5, 0);
			sub_bba8(5, 0);
			this.var_39bb = 4;
			sub_143f6(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			Class_a_000.var_79b.sub_1a8c(this.var_3b23);
			this.var_352b = false;
			this.var_3b5b = 0;
			return;
		}
		Class_c_032 localClass_c_0322;
		Class_c_032 localClass_c_0323;
		if (this.var_34db == 6) {
			this.var_3703 = 8;
			Class_c_032.var_a7b = 4;
			this.var_35a3[0] = 400;
			this.var_35a3[1] = 600;
			localClass_c_0321 = Class_c_032.sub_d3d((byte) 0, (byte) 0, 13, -1);
			localClass_c_0322 = Class_c_032.sub_d3d((byte) 1, (byte) 0, 13, -1);
			localClass_c_0323 = Class_c_032.sub_d3d((byte) 3, (byte) 0, 13, -1);
			Class_c_032 localClass_c_0324 = Class_c_032.sub_d3d((byte) 11,
					(byte) 0, 13, -1);
			this.var_358b[0].var_b73 = localClass_c_0321;
			localClass_c_0321.var_b73 = localClass_c_0322;
			localClass_c_0322.var_b73 = localClass_c_0323;
			localClass_c_0323.var_b73 = localClass_c_0324;
			this.var_358b[0].sub_1d3c(this.var_3513);
			this.var_358b[0].sub_18b7(14, 3, true);
			sub_b9c5(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_bba8(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			this.var_39b3 = this.var_358b[0];
			Class_a_000.var_79b.sub_1a8c(this.var_3b23);
			this.var_352b = false;
			this.var_3b5b = 0;
			return;
		}
		if (this.var_34db == 7) {
			this.var_3703 = 8;
			Class_c_032.var_a7b = 4;
			this.var_35a3[0] = 800;
			this.var_35a3[1] = 200;
			(localClass_c_0321 = sub_dc52(7, 4, (byte) 0)).sub_e33(3);
			this.var_358b[1] = localClass_c_0321;
			localClass_c_0322 = sub_dc52(8, 15, (byte) 0);
			this.var_358b[0] = localClass_c_0322;
			localClass_c_0322.sub_e33(0);
			(localClass_c_0323 = sub_dc52(6, 15, (byte) 0)).sub_e33(2);
			sub_b998(this.var_358b[0].var_7dc + 12,
					this.var_358b[0].var_7e4 + 12);
			sub_bba8(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
			sub_c019(4, 3, 3);
			Class_e_034.sub_2439(1, 1);
			this.var_3813 = false;
			this.var_352b = false;
			this.var_3b5b = 0;
		}
	}

	public final void sub_112a9() throws Exception {
		if ((this.var_3b1b > 0) && (--this.var_3b1b > 0)) {
			return;
		}
		if (this.var_3b7b) {
			if (this.var_3b5b == 0) {
				this.var_364b = true;
				this.var_3653 = 0;
				this.var_34c3 = 11;
				this.var_3b5b = 1;
			}
			return;
		}
		int i;
		int j;
		Object localObject2;
		Object localObject3;
		if (this.var_332b == 1) {
			if (this.var_3b5b == 100) {
				Class_e_034.sub_2439(var_33c3[this.var_356b[this.var_357b]], 0);
				this.var_36fb.sub_1301((byte) 0, true);
				this.var_36fb.sub_1323(null);
				Class_a_000.var_79b.sub_1a8c(this.var_36fb);
				this.var_3b5b += 1;
				return;
			}
			if (this.var_3b5b == 101) {
				i = -1;
				j = -1;
				int n = 1;
				for (int i1 = 0; i1 < this.var_355b; i1++) {
					if ((this.var_35b3[i1] != 2)
							&& (((this.var_358b[i1] != null) && (this.var_358b[i1].var_b13 != 3)) || (sub_e353(i1) != 0))) {
						j = i1;
						if ((i != -1) && (i != this.var_3573[i1])) {
							n = 0;
							break;
						}
						i = this.var_3573[i1];
					}
				}
				if (n != 0) {
					this.var_3783 = false;
					this.var_352b = false;
					localObject2 = Class_a_000.sub_e44(38, ""
							+ (this.var_3573[j] + 1));
					localObject3 = Class_a_000.sub_e44(81,
							(String) localObject2) + "\n(";
					for (int i2 = 0; i2 < this.var_355b; i2++) {
						if ((this.var_35b3[i2] != 2)
								&& (this.var_3573[i2] == this.var_3573[j])) {
							localObject3 = (String) localObject3
									+ " "
									+ Class_a_000
											.sub_c99(88 + this.var_356b[i2])
									+ " ";
						}
					}
					localObject3 = (String) localObject3 + ")";
					Class_d_023 localClass_d_023;
					(localClass_d_023 = sub_10c33(null, (String) localObject3,
							this.var_32d3, this.var_32e3, -1)).sub_1323(this);
					Class_a_000.var_79b.sub_1a8c(localClass_d_023);
					if (this.var_35b3[j] == 1) {
						Class_e_034.sub_2439(6, 1);
					} else {
						Class_e_034.sub_2439(7, 1);
					}
					sub_10b94(15);
					this.var_3b5b += 1;
				}
			} else if (this.var_3b5b == 102) {
				this.var_364b = true;
				this.var_3653 = 0;
				this.var_34c3 = 11;
				this.var_3b5b += 1;
			}
			return;
		}
		if ((this.var_361b != 1) || (this.var_332b != 0)
				|| (this.var_3b5b == -1)) {
			return;
		}
		if (this.var_3b83 != -1) {
			if (sub_b848(this.var_3b83, this.var_3b8b)) {
				this.var_3b83 = -1;
				this.var_3b8b = -1;
			} else {
				return;
			}
		}
		if (this.var_34c3 != 11) {
			i = 1;
			for (j = 0; j < this.var_359b[0]; j++) {
				if (this.var_3593[0][j].var_b13 != 3) {
					i = 0;
					break;
				}
			}
			if ((i != 0) && (sub_e353(0) == 0)) {
				sub_1447e();
				return;
			}
		}
		Class_c_032[] localObject1 = null;
		Class_c_032 localClass_c_0324;
		if (this.var_34db == 0) {
			switch (this.var_3b5b) {
			case 0:
				this.var_3b5b += 1;
				break;
			case 1:
				Class_a_000.var_79b.sub_1a8c(this.var_3b23);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 2:
				this.var_3813 = true;
				sub_dc52(0, 8, (byte) 0).sub_18b7(3, 8, false);
				sub_dc52(1, 9, (byte) 0).sub_18b7(4, 9, false);
				sub_dc52(0, 10, (byte) 0).sub_18b7(3, 10, false);
				sub_143f6(5, 9);
				break;
			case 3:
				sub_143f6(9, 3);
				this.var_352b = true;
				break;
			case 4:
				sub_10b94(10);
				this.var_39bb = 12;
				Class_c_032.var_a7b = Class_c_032.var_a73;
				this.var_3b5b += 1;
				break;
			case 5:
				sub_10bb9(Class_a_000.sub_c99(221), (byte) 2, (byte) 4);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 6:
				Class_c_032 localObject11 = sub_dc52(9, 3, (byte) 0);
				Class_e_034.sub_233e(100);
				((Class_c_032) localObject11).sub_d0e(400);
				sub_5873(this.var_348b, ((Class_f_045) localObject11).var_7dc,
						((Class_f_045) localObject11).var_7e4, 0, 0, 2, 50);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 7:
				sub_10bb9(Class_a_000.sub_c99(222), (byte) 2, (byte) 4);
				this.var_3b5b += 1;
				break;
			case 8:
				Class_c_032 localClass_c_0321 = sub_dc52(9, 3, (byte) 0);
				sub_5873(this.var_3483, localClass_c_0321.var_7dc,
						localClass_c_0321.var_7e4, 0, 0, 1, 50);
				sub_5873(this.var_347b, localClass_c_0321.var_7dc,
						localClass_c_0321.var_7e4, 0, -3, 1, 100);
				localClass_c_0321.sub_e0d();
				sub_10b94(20);
				this.var_3b5b += 1;
				break;
			case 9:
				this.var_352b = false;
				sub_143f6(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
				break;
			case 10:
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 11:
				sub_10bb9(Class_a_000.sub_c99(223), (byte) 0, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 12:
				sub_10bb9(Class_a_000.sub_c99(224), (byte) 5, (byte) 4);
				this.var_3b5b += 1;
				break;
			case 13:
				sub_1439a();
				this.var_3b5b += 1;
				break;
			case 14:
				if (this.var_378b == 0) {
					this.var_36db = 0;
					this.var_3b5b += 1;
				}
				break;
			case 15:
				if ((this.var_357b == 0) && (this.var_34c3 == 1)
						&& (this.var_39d3 == 0)) {
					this.var_36db = 1;
					this.var_3b5b += 1;
				}
				break;
			case 16:
				if ((this.var_357b == 0) && (this.var_3b53 != null)) {
					this.var_36db = 2;
					this.var_3b5b += 1;
				}
				break;
			case 17:
				if ((this.var_357b == 0) && (this.var_3b53 != null)) {
					this.var_36db = 3;
					this.var_3b5b += 1;
				}
				break;
			case 18:
				if (sub_e3c8(-1, 2, (byte) 0) >= 3) {
					this.var_36db = 4;
					this.var_3b5b += 1;
				} else if (this.var_3583 >= 1) {
					this.var_3b5b += 1;
				}
				break;
			case 19:
				if (this.var_3583 >= 2) {
					this.var_36db = 5;
					this.var_3b5b += 1;
				}
				break;
			case 20:
				this.var_36db = 6;
				this.var_3b5b += 1;
				break;
			case 21:
				if ((this.var_34c3 == 1) && (this.var_357b == 0)) {
					this.var_36db = 7;
					this.var_3b5b += 1;
				}
				break;
			case 22:
				if (sub_e3c8(-1, -1, (byte) 1) == 0) {
					this.var_3783 = false;
					sub_10b94(20);
					this.var_3b5b += 1;
				}
				break;
			case 23:
				sub_143f6(1, 1);
				break;
			case 24:
				(localClass_c_0324 = Class_c_032.sub_d3d((byte) 1, (byte) 1, 1,
						1)).sub_18da(1, 2, false, true);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 25:
				sub_143f6(10, 10);
				break;
			case 26:
				Class_c_032 localObject21 = Class_c_032.sub_d3d((byte) 0,
						(byte) 1, 10, 10);
				localObject21.sub_18da(10, 9, false, true);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 27:
				sub_143f6(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
				break;
			case 28:
				sub_10bb9(Class_a_000.sub_c99(225), (byte) 5, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 29:
				sub_10bb9(Class_a_000.sub_c99(226), (byte) 0, (byte) 4);
				this.var_3783 = true;
				this.var_3b5b += 1;
				break;
			case 30:
				if ((sub_e3c8(-1, -1, (byte) 1) == 0) && (this.var_34c3 == 0)) {
					this.var_3783 = false;
					this.var_352b = false;
					sub_10b94(30);
					this.var_3b5b += 1;
				}
				break;
			case 31:
				this.var_3803 = true;
				this.var_37fb = 0;
				sub_10b94(20);
				this.var_3b5b += 1;
				break;
			case 32:
				sub_10bb9(Class_a_000.sub_c99(227), (byte) 2, (byte) 4);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 33:
				sub_10bb9(Class_a_000.sub_c99(228), (byte) 0, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 34:
				sub_10bb9(Class_a_000.sub_c99(229), (byte) 2, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 35:
				sub_10bb9(Class_a_000.sub_c99(230), (byte) 0, (byte) 4);
				sub_10b94(15);
				this.var_3b5b += 1;
				break;
			case 36:
				sub_1442b();
			}
		} else if (this.var_34db == 1) {
			switch (this.var_3b5b) {
			case 1:
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 2:
				this.var_39bb = 4;
				sub_143f6(12, 3);
				break;
			case 3:
				sub_10bb9(Class_a_000.sub_c99(231), (byte) 1, (byte) 4);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 4:
				sub_10bb9(Class_a_000.sub_c99(232), (byte) 3, (byte) 4);
				sub_143f6(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
				break;
			case 5:
				sub_10bb9(Class_a_000.sub_c99(233), (byte) 5, (byte) 4);
				sub_143f6(7, 3);
				break;
			case 6:
				Class_c_032.var_a7b = 2;
				this.var_3b2b = Class_c_032.sub_d3d((byte) 0, (byte) 1, 7, 3);
				this.var_3b33 = Class_c_032.sub_d3d((byte) 11, (byte) 1, 7, 3);
				this.var_3b3b = Class_c_032.sub_d3d((byte) 0, (byte) 1, 7, 3);
				this.var_3b2b.var_b73 = this.var_3b33;
				this.var_3b33.var_b73 = this.var_3b3b;
				this.var_3b2b.sub_18b7(6, -2, false);
				sub_10b94(30);
				this.var_3b5b += 1;
				break;
			case 7:
				if ((this.var_3b3b.var_ad3 == 6)
						&& (this.var_3b3b.var_adb == 1)) {
					Class_c_032.var_a7b = 4;
					this.var_3b43 = Class_c_032.sub_d3d((byte) 0, (byte) 0, 7,
							3);
					this.var_3b43.sub_18b7(6, 2, false);
					this.var_3b33.var_b73 = null;
					sub_10bb9(Class_a_000.sub_c99(234), (byte) 2, (byte) 4);
					this.var_3b5b += 1;
				}
				break;
			case 8:
				if (this.var_3b43.var_b13 != 1) {
					Class_e_034.sub_233e(100);
					this.var_3b43.sub_d0e(400);
					sub_5873(this.var_348b, this.var_3b43.var_7dc,
							this.var_3b43.var_7e4, 0, 0, 2, 50);
					sub_10b94(10);
					this.var_3b5b += 1;
				}
				break;
			case 9:
				sub_10bb9(Class_a_000.sub_c99(235), (byte) 2, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 10:
				sub_5873(this.var_347b, this.var_3b43.var_7dc,
						this.var_3b43.var_7e4, 0, -3, 1, 100);
				sub_5873(this.var_3483, this.var_3b43.var_7dc,
						this.var_3b43.var_7e4, 0, 0, 1, 50);
				this.var_3b43.sub_e0d();
				this.var_3b43 = null;
				sub_10b94(15);
				this.var_3b5b += 1;
				break;
			case 11:
				Class_c_032.var_a7b = Class_c_032.var_a73;
				this.var_3b2b.sub_e0d();
				this.var_3b33.sub_e0d();
				this.var_3b2b = null;
				this.var_3b33 = null;
				this.var_3b3b = null;
				this.var_39bb = 12;
				sub_143f6(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
				break;
			case 12:
				sub_10bb9(Class_a_000.sub_c99(236), (byte) 5, (byte) 4);
				this.var_3b5b += 1;
				break;
			case 13:
				sub_10bb9(Class_a_000.sub_c99(237), (byte) 1, (byte) 4);
				this.var_3b5b += 1;
				break;
			case 14:
				sub_143f6(3, 5);
				break;
			case 15:
				sub_10bb9(Class_a_000.sub_c99(238), (byte) 5, (byte) 4);
				this.var_3b5b += 1;
				break;
			case 16:
				sub_143f6(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
				break;
			case 17:
				this.var_36db = 8;
				this.var_3b5b += 1;
				break;
			case 18:
				this.var_36db = 9;
				this.var_3b5b += 1;
				break;
			case 19:
				sub_1439a();
				this.var_3b5b += 1;
				break;
			case 20:
				if ((this.var_34c3 == 9) && (this.var_357b == 0)) {
					this.var_36db = 10;
					this.var_3b5b += 1;
				}
				break;
			case 21:
				this.var_36db = 11;
				this.var_3b5b += 1;
				break;
			case 22:
				if ((this.var_358b[0].var_b13 == 3)
						|| (this.var_358b[1].var_b13 == 3)) {
					this.var_36db = 12;
					this.var_3b5b += 1;
				}
				break;
			case 23:
				if ((sub_e3c8(-1, -1, (byte) 1) == 0) && (sub_e353(1) == 0)) {
					this.var_3783 = false;
					sub_10b94(20);
					this.var_3b5b += 1;
				}
				break;
			case 24:
				sub_143f6(this.var_358b[0].var_ad3, this.var_358b[0].var_adb);
				break;
			case 25:
				sub_10bb9(Class_a_000.sub_c99(239), (byte) 1, (byte) 4);
				this.var_3b5b += 1;
				break;
			case 26:
				sub_10bb9(Class_a_000.sub_c99(240), (byte) 5, (byte) 4);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 27:
				sub_1442b();
			}
		} else if (this.var_34db == 2) {
			int k = 0;
			switch (this.var_3b5b) {
			case 0:
				if (this.var_3b2b.var_b13 != 1) {
					this.var_3b2b.sub_18b7(7, 14, false);
					this.var_3b5b += 1;
				}
				break;
			case 1:
				if (this.var_3b33.var_b13 != 1) {
					this.var_3b33.sub_18b7(7, 15, false);
					sub_10b94(20);
					this.var_3b5b += 1;
				}
				break;
			case 2:
				Class_c_032.var_a7b = Class_c_032.var_a73;
				this.var_3b2b = null;
				this.var_3b33 = null;
				this.var_3b3b = null;
				sub_10bb9(Class_a_000.sub_c99(241), (byte) 5, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 3:
				sub_10bb9(Class_a_000.sub_c99(242), (byte) 0, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 4:
				sub_10bb9(Class_a_000.sub_c99(243), (byte) 5, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 5:
				this.var_36db = 14;
				this.var_3b5b += 1;
				break;
			case 6:
				sub_1439a();
				this.var_3b5b += 1;
				break;
			case 7:
			case 8:
				if ((this.var_3b5b == 7) && (this.var_357b == 0)
						&& (this.var_378b == 0)
						&& (sub_e3c8(-1, 3, (byte) -1) >= 1)) {
					this.var_36db = 15;
					this.var_3b5b += 1;
				}
				localObject1 = sub_e4c7(-1, 2, (byte) 0);
				k = 0;
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
				while (k < localObject1.length) {
					if ((localObject1[k].var_ad3 <= 4)
							|| (localObject1[k].var_adb <= 10)) {
						sub_10b94(10);
						this.var_3783 = false;
						this.var_352b = false;
						this.var_3b5b = 9;
					} else {
						k++;
						// continue; //@todo
						sub_143f6(0, 8);
						Class_c_032.sub_d3d((byte) 5, (byte) 1, -1, 8)
								.sub_18b7(0, 8, false);
						Class_c_032.sub_d3d((byte) 5, (byte) 1, -2, 7)
								.sub_18b7(1, 7, false);
						sub_10b94(20);
						// break;//@todo
						sub_143f6(8, 6);
						Class_c_032.sub_d3d((byte) 5, (byte) 1, 12, 6)
								.sub_18b7(8, 6, false);
						sub_10b94(20);
						// break;//@todo
						sub_143f6(2, 1);
						Class_c_032.sub_d3d((byte) 5, (byte) 1, 1, -2)
								.sub_18b7(1, 2, false);
						Class_c_032.sub_d3d((byte) 5, (byte) 1, 3, -2)
								.sub_18b7(3, 2, false);
						Class_c_032.sub_d3d((byte) 4, (byte) 1, 2, -1)
								.sub_18b7(2, 1, false);
						sub_10b94(20);
						// break;//@todo
						sub_10bb9(Class_a_000.sub_c99(244), (byte) 5, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						// break;//@todo
						sub_143f6(4, 8);
						sub_10b94(15);
						// break;//@todo
						Class_c_032 localClass_c_0322 = Class_c_032.sub_d3d(
								(byte) 2, (byte) 1, 3, 8);
						localClass_c_0324 = Class_c_032.sub_d3d((byte) 2,
								(byte) 1, 4, 7);
						localObject2 = Class_c_032.sub_d3d((byte) 2, (byte) 1,
								5, 8);
						sub_5873(this.var_3483, localClass_c_0322.var_7dc,
								localClass_c_0322.var_7e4, 0, 0, 1, 50);
						sub_5873(this.var_3483, localClass_c_0324.var_7dc,
								localClass_c_0324.var_7e4, 0, 0, 1, 50);
						sub_5873(this.var_3483,
								((Class_f_045) localObject2).var_7dc,
								((Class_f_045) localObject2).var_7e4, 0, 0, 1,
								50);
						sub_10b94(10);
						this.var_3b5b += 1;
						// break;//@todo
						sub_10bb9(Class_a_000.sub_c99(245), (byte) 5, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						// break;//@todo
						sub_10bb9(Class_a_000.sub_c99(246), (byte) -1, (byte) 4);
						sub_10b94(5);
						this.var_3b5b += 1;
						// break;//@todo
						sub_10bb9(Class_a_000.sub_c99(247), (byte) 0, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						// break;//@todo
						Class_a_000.var_79b.sub_1a8c(sub_10c0e(null,
								Class_a_000.sub_c99(248), this.var_32d3, 1500));
						this.var_3b5b += 1;
						// break;//@todo
						sub_dc52(3, 8, (byte) 0).sub_e0d();
						sub_dc52(4, 7, (byte) 0).sub_e0d();
						sub_dc52(5, 8, (byte) 0).sub_e0d();
						localClass_c_0322 = Class_c_032.sub_d3d((byte) 2,
								(byte) 0, 3, 8);
						localClass_c_0324 = Class_c_032.sub_d3d((byte) 2,
								(byte) 0, 4, 7);
						localObject2 = Class_c_032.sub_d3d((byte) 2, (byte) 0,
								5, 8);
						sub_5873(this.var_3483, localClass_c_0322.var_7dc,
								localClass_c_0322.var_7e4, 0, 0, 1, 50);
						sub_5873(this.var_3483, localClass_c_0324.var_7dc,
								localClass_c_0324.var_7e4, 0, 0, 1, 50);
						sub_5873(this.var_3483,
								((Class_f_045) localObject2).var_7dc,
								((Class_f_045) localObject2).var_7e4, 0, 0, 1,
								50);
						sub_10b94(10);
						this.var_3b5b += 1;
						// break;//@todo
						this.var_3783 = true;
						this.var_352b = true;
						this.var_36db = 13;
						this.var_3b5b += 1;
						// break;//@todo
						if (sub_e3c8(-1, -1, (byte) 1) == 0) {
							this.var_3783 = false;
							sub_10b94(10);
							this.var_3b5b += 1;
							// break;//@todo
							sub_1442b();
						}
					}
				}
			}
		} else if (this.var_34db == 3) {
			switch (this.var_3b5b) {
			case 0:
				Class_a_000.var_79b.sub_1a8c(this.var_3b23);
				this.var_3813 = true;
				this.var_3b5b += 1;
				break;
			case 1:
				if (this.var_358b[0].var_b13 != 1) {
					this.var_39b3 = null;
					sub_10b94(20);
					this.var_3b5b += 1;
				}
				break;
			case 2:
				this.var_3803 = true;
				this.var_3813 = true;
				this.var_37fb = 0;
				sub_10b94(20);
				this.var_3b5b += 1;
				break;
			case 3:
				sub_10bb9(Class_a_000.sub_c99(249), (byte) 2, (byte) 4);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 4:
				sub_10bb9(Class_a_000.sub_c99(250), (byte) 0, (byte) 4);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 5:
				sub_10bb9(Class_a_000.sub_c99(251), (byte) 5, (byte) 4);
				sub_bba8(13, 3);
				sub_b998(312, 72);
				this.var_358b[0].sub_128b(7, 1);
				this.var_3b2b.sub_128b(5, 4);
				this.var_3b33.sub_128b(7, 5);
				this.var_3b3b.sub_128b(3, 3);
				this.var_3b2b = null;
				this.var_3b33 = null;
				this.var_3b3b = null;
				this.var_39bb = 2;
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 6:
				this.var_3803 = false;
				this.var_380b = true;
				this.var_37fb = 0;
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 7:
				sub_143f6(13, 10);
				break;
			case 8:
				Class_c_032.var_a7b = 2;
				this.var_39bb = 4;
				this.var_3b2b = sub_dc52(10, 10, (byte) 0);
				this.var_3b2b.sub_18b7(6, 10, false);
				sub_bba8(6, 10);
				sub_143f6(6, 10);
				break;
			case 9:
				if (this.var_3b2b.var_b13 != 1) {
					this.var_3b2b = null;
					this.var_352b = true;
					sub_10b94(10);
					this.var_3b5b += 1;
				}
				break;
			case 10:
				sub_bba8(4, 9);
				sub_143f6(4, 9);
				sub_5873(this.var_348b, 96, 216, 0, 0, 1, 50);
				sub_10b94(15);
				break;
			case 11:
				this.var_35db = Class_c_032.sub_d60((byte) 0, (byte) 0, 4, 9,
						false);
				this.var_35db.var_ac3 = -1;
				this.var_35db.var_b13 = 4;
				this.var_3603 = 6;
				sub_10b94(20);
				this.var_3b5b += 1;
				break;
			case 12:
				sub_10bb9(Class_a_000.sub_c99(252), (byte) 5, (byte) 4);
				sub_143f6(7, 1);
				break;
			case 13:
				sub_10bb9(Class_a_000.sub_c99(253), (byte) 0, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 14:
				this.var_36db = 17;
				this.var_3b5b += 1;
				break;
			case 15:
				sub_1439a();
				this.var_3b5b += 1;
				break;
			case 16:
				if ((sub_e3c8(-1, -1, (byte) 1) == 0) && (sub_e353(1) == 0)) {
					sub_10b94(15);
					this.var_3783 = false;
					this.var_3b5b += 1;
				}
				break;
			case 17:
				sub_10bb9(Class_a_000.sub_c99(254), (byte) 5, (byte) 4);
				sub_10b94(5);
				this.var_3b5b += 1;
				break;
			case 18:
				sub_10bb9(Class_a_000.sub_c99(255), (byte) 0, (byte) 4);
				sub_10b94(10);
				this.var_3b5b += 1;
				break;
			case 19:
				sub_1442b();
			}
		} else {
			int m = 0;
			if (this.var_34db == 4) {
				if (this.var_3b4b == null) {
					this.var_3b4b = sub_e4c7(11, -1, (byte) 0)[0];
				}
				if ((this.var_3b5b == 25) && (this.var_3b4b.var_ad3 >= 15)
						&& (this.var_3b4b.var_adb >= 11)
						&& (this.var_3b4b.var_b13 == 2)) {
					sub_10b94(10);
					this.var_3783 = false;
					this.var_352b = false;
					this.var_3b5b = 26;
					return;
				}
				if (this.var_3b4b.var_b13 == 3) {
					this.var_3b4b = null;
					sub_1447e();
					return;
				}
				switch (this.var_3b5b) {
				case 0:
					sub_10b94(50);
					this.var_3b5b += 1;
					break;
				case 1:
					sub_10bb9(Class_a_000.sub_c99(256), (byte) 5, (byte) 4);
					sub_10b94(5);
					this.var_3b5b += 1;
					break;
				case 2:
					sub_10bb9(Class_a_000.sub_c99(257), (byte) 0, (byte) 4);
					sub_10b94(5);
					this.var_3b5b += 1;
					break;
				case 3:
					sub_1439a();
					this.var_3b5b += 1;
					break;
				case 4:
					localObject1 = sub_e4c7(-1, -1, (byte) 0);
					m = 0;
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
				case 18:
				case 19:
				case 20:
				case 21:
				case 22:
				case 23:
				case 24:
				case 25:
				case 26:
					while (m < localObject1.length) {
						if ((localObject1[m].var_b13 == 2)
								&& (localObject1[m].var_ad3 <= 8)) {
							this.var_3783 = false;
							sub_10b94(5);
							this.var_3b5b += 1;
						} else {
							m++;
							// continue;//@todo
							this.var_352b = false;
							sub_143f6(4, 4);
							// break;//@todo
							Class_c_032.sub_d3d((byte) 10, (byte) 1, 4, 4)
									.sub_18da(4, 1, false, true);
							sub_10b94(10);
							this.var_3b5b += 1;
							// break;//@todo
							Class_c_032.sub_d3d((byte) 1, (byte) 1, 4, 4)
									.sub_18da(5, 2, false, true);
							sub_10b94(10);
							this.var_3b5b += 1;
							// break;//@todo
							Class_c_032.sub_d3d((byte) 10, (byte) 1, 4, 4)
									.sub_18da(4, 3, false, true);
							sub_10b94(10);
							this.var_3b5b += 1;
							// break;//@todo
							sub_10bb9(Class_a_000.sub_c99(258), (byte) 5,
									(byte) 4);
							sub_143f6(this.var_358b[0].var_ad3,
									this.var_358b[0].var_adb);
							// break;//@todo
							this.var_3783 = true;
							this.var_352b = true;
							this.var_3b5b += 1;
							// break;//@todo
							localObject1 = sub_e4c7(-1, -1, (byte) 0);
							m = 0;
							while (m < localObject1.length) {
								if ((localObject1[m].var_b13 == 2)
										&& (localObject1[m].var_adb >= 7)) {
									this.var_3783 = false;
									this.var_352b = false;
									sub_143f6(6, 10);
								} else {
									m++;
									// continue;//@todo
									Class_c_032.sub_d3d((byte) 1, (byte) 1, 6,
											10).sub_18da(5, 10, false, true);
									sub_10b94(10);
									this.var_3b5b += 1;
									// break;//@todo
									Class_c_032.sub_d3d((byte) 5, (byte) 1, 6,
											10).sub_18da(7, 8, false, true);
									sub_10b94(15);
									this.var_3b5b += 1;
									// break;//@todo
									Class_c_032.sub_d3d((byte) 5, (byte) 1, 6,
											10).sub_18da(7, 9, false, true);
									this.var_3783 = true;
									this.var_352b = true;
									this.var_3b5b += 1;
									// break;//@todo
									localObject1 = sub_e4c7(-1, -1, (byte) 0);
									m = 0;
									while (m < localObject1.length) {
										if ((localObject1[m].var_b13 == 2)
												&& (localObject1[m].var_ad3 >= 8)
												&& (localObject1[m].var_adb >= 6)) {
											this.var_3783 = false;
											this.var_352b = false;
											sub_143f6(12, 5);
										} else {
											m++;
											// continue;@todo
											Class_c_032.sub_d3d((byte) 5,
													(byte) 1, 12, 5).sub_18da(
													12, 7, false, true);
											sub_10b94(15);
											this.var_3b5b += 1;
											// break;//@todo
											Class_c_032.sub_d3d((byte) 6,
													(byte) 1, 12, 5).sub_18da(
													12, 6, false, true);
											sub_10b94(10);
											this.var_3b5b += 1;
											// break;//@todo
											Class_c_032.sub_d3d((byte) 5,
													(byte) 1, 12, 5).sub_18da(
													12, 5, false, true);
											this.var_3783 = true;
											this.var_352b = true;
											this.var_3b5b += 1;
											// break;//@todo
											localObject1 = sub_e4c7(-1, -1,
													(byte) 0);
											m = 0;
											while (m < localObject1.length) {
												if ((localObject1[m].var_b13 == 2)
														&& (localObject1[m].var_ad3 >= 15)
														&& (localObject1[m].var_adb >= 8)) {
													this.var_3783 = false;
													this.var_352b = false;
													sub_143f6(18, 8);
												} else {
													m++;
													// continue;@todo
													Class_c_032.sub_d3d(
															(byte) 5, (byte) 1,
															18, 8).sub_18da(16,
															10, false, true);
													sub_10b94(10);
													this.var_3b5b += 1;
													// break;//@todo
													Class_c_032.sub_d3d(
															(byte) 6, (byte) 1,
															18, 8).sub_18da(17,
															10, false, true);
													sub_10b94(10);
													this.var_3b5b += 1;
													// break;//@todo
													Class_c_032.sub_d3d(
															(byte) 5, (byte) 1,
															18, 8).sub_18da(18,
															10, false, true);
													sub_10b94(10);
													this.var_3b5b += 1;
													// break;//@todo
													Class_c_032.sub_d3d(
															(byte) 1, (byte) 1,
															18, 8).sub_18da(18,
															9, false, true);
													sub_10b94(10);
													this.var_3b5b += 1;
													// break;//@todo
													sub_10bb9(
															Class_a_000
																	.sub_c99(259),
															(byte) 0, (byte) 4);
													this.var_3783 = true;
													this.var_352b = true;
													this.var_3b5b += 1;
													// break;//@todo
													if (sub_e3c8(-1, -1,
															(byte) 1) == 0) {
														this.var_3783 = false;
														this.var_352b = false;
														sub_10b94(10);
														this.var_3b5b += 1;
														// break;//@todo
														sub_1442b();
														this.var_3b5b += 1;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			} else if (this.var_34db == 5) {
				switch (this.var_3b5b) {
				case 0:
					sub_10b94(10);
					this.var_3b5b += 1;
					break;
				case 1:
					sub_10bb9(Class_a_000.sub_c99(260), (byte) 1, (byte) 4);
					this.var_3b5b += 1;
					break;
				case 2:
					sub_1439a();
					this.var_3b5b += 1;
					break;
				case 3:
					if ((sub_e3c8(-1, -1, (byte) 1) == 0) && (sub_e353(1) == 0)) {
						this.var_3783 = false;
						this.var_352b = false;
						sub_10b94(15);
						this.var_3b5b += 1;
					}
					break;
				case 4:
					sub_143f6(this.var_358b[0].var_ad3,
							this.var_358b[0].var_adb);
					break;
				case 5:
					sub_10bb9(Class_a_000.sub_c99(261), (byte) 0, (byte) 4);
					sub_10b94(10);
					this.var_3b5b += 1;
					break;
				case 6:
					sub_1442b();
				}
			} else {
				Class_c_032 localClass_c_0323;
				if (this.var_34db == 6) {
					if (this.var_3b5b <= 10) {
						if (this.var_3b4b == null) {
							this.var_3b4b = sub_e4c7(11, -1, (byte) 0)[0];
						}
						if (this.var_3b4b.var_b13 == 3) {
							this.var_3b4b = null;
							sub_1447e();
							return;
						}
					}
					switch (this.var_3b5b) {
					case 0:
						if (this.var_358b[0].var_b13 != 1) {
							this.var_39b3 = null;
							sub_10b94(10);
							this.var_3b5b += 1;
						}
						break;
					case 1:
						sub_10bb9(Class_a_000.sub_c99(262), (byte) 5, (byte) 4);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 2:
						sub_10bb9(Class_a_000.sub_c99(263), (byte) 0, (byte) 4);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 3:
						localObject1 = sub_e4c7(-1, -1, (byte) 0);
						for (m = 0; m < localObject1.length; m++) {
							localObject1[m].var_b73 = null;
						}
						sub_1439a();
						this.var_3b5b += 1;
						break;
					case 4:
						if (this.var_3583 >= 2) {
							sub_10b94(15);
							this.var_3783 = false;
							this.var_352b = false;
							sub_143f6(11, 7);
						}
						break;
					case 5:
						(localClass_c_0323 = Class_c_032.sub_d3d((byte) 5,
								(byte) 1, 11, 8)).sub_1d3c(this.var_3513);
						localClass_c_0323.sub_18b7(14, 7, true);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 6:
						(localClass_c_0324 = Class_c_032.sub_d3d((byte) 0,
								(byte) 1, 11, 8)).sub_1d3c(this.var_3513);
						localClass_c_0324.sub_18b7(13, 7, true);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 7:
						Class_c_032 localObject21 = Class_c_032.sub_d3d(
								(byte) 3, (byte) 1, 11, 8);
						localObject21.sub_1d3c(this.var_3513);
						((Class_c_032) localObject21).sub_18b7(12, 7, true);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 8:
						Class_c_032 localObject31 = Class_c_032.sub_d3d(
								(byte) 1, (byte) 1, 11, 8);
						localObject31.sub_18b7(13, 8, false);
						sub_10b94(20);
						this.var_3b5b += 1;
						break;
					case 9:
						sub_10bb9(Class_a_000.sub_c99(264), (byte) 5, (byte) 4);
						this.var_3783 = true;
						this.var_352b = true;
						sub_143f6(this.var_358b[0].var_ad3,
								this.var_358b[0].var_adb);
						break;
					case 10:
						int i3 = 0;
						Class_c_032[] arrayOfClass_c_032 = sub_e4c7(-1, 2,
								(byte) 0);
						for (int i4 = 0; i4 < arrayOfClass_c_032.length; i4++) {
							if ((arrayOfClass_c_032[i4].var_ad3 <= 9)
									|| (arrayOfClass_c_032[i4].var_adb >= 10)) {
								i3 = 1;
								break;
							}
						}
						if ((i3 != 0) || (sub_e3c8(-1, -1, (byte) 1) == 0)) {
							this.var_352b = false;
							this.var_3783 = false;
							sub_10b94(10);
							this.var_3b5b += 1;
						}
						break;
					case 11:
						this.var_3b2b = sub_e4c7(11, -1, (byte) 0)[0];
						this.var_3b33 = Class_c_032.sub_d3d((byte) 8, (byte) 1,
								this.var_342b, this.var_3b2b.var_adb);
						sub_143f6(this.var_342b - 1, this.var_3b2b.var_adb);
						this.var_352b = false;
						break;
					case 12:
						this.var_3b33.sub_18b7(this.var_3b2b.var_ad3,
								this.var_3b2b.var_adb, false);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 13:
						sub_10bb9(Class_a_000.sub_c99(265), (byte) 5, (byte) 4);
						this.var_39b3 = this.var_3b33;
						this.var_3b5b += 1;
						break;
					case 14:
						if (this.var_3b33.var_b13 != 1) {
							sub_10bb9(Class_a_000.sub_c99(266), (byte) 0,
									(byte) 4);
							this.var_3b33.sub_18b7(-1, this.var_3b33.var_adb,
									false);
							sub_10b94(3);
							this.var_3b5b += 1;
						}
						break;
					case 15:
						this.var_3b2b
								.sub_18b7(-1, this.var_3b33.var_adb, false);
						this.var_3b5b += 1;
						break;
					case 16:
						if (this.var_3b33.var_b13 != 1) {
							sub_10b94(10);
							this.var_3b2b.sub_e0d();
							this.var_3b33.sub_e0d();
							sub_bba8(0, this.var_3b33.var_adb);
							this.var_3b2b = null;
							this.var_3b33 = null;
							this.var_39b3 = null;
							this.var_3b5b += 1;
						}
						break;
					case 17:
						sub_143f6(1, 9);
						break;
					case 18:
						this.var_358b[1] = Class_c_032.sub_d3d((byte) 9,
								(byte) 1, -2, 8);
						this.var_358b[1].sub_18b7(0, 8, false);
						Class_c_032.sub_d3d((byte) 0, (byte) 1, -1, 8)
								.sub_18b7(3, 8, false);
						Class_c_032.sub_d3d((byte) 0, (byte) 1, -1, 10)
								.sub_18b7(1, 10, false);
						Class_c_032.sub_d3d((byte) 8, (byte) 1, -3, 7)
								.sub_18b7(4, 8, false);
						Class_c_032.sub_d3d((byte) 8, (byte) 1, -3, 11)
								.sub_18b7(2, 10, false);
						Class_c_032.sub_d3d((byte) 4, (byte) 1, -2, 9)
								.sub_18b7(2, 9, false);
						Class_c_032.sub_d3d((byte) 6, (byte) 1, -4, 9)
								.sub_18b7(4, 9, false);
						Class_c_032.sub_d3d((byte) 6, (byte) 1, -6, 9)
								.sub_18b7(5, 10, false);
						sub_10b94(50);
						this.var_3b5b += 1;
						break;
					case 19:
						sub_10bb9(Class_a_000.sub_c99(267), (byte) 3, (byte) 4);
						this.var_3b5b += 1;
						break;
					case 20:
						sub_143f6(13, 14);
						break;
					case 21:
						Class_c_032.sub_d3d((byte) 0, (byte) 1, 13, 14)
								.sub_18b7(12, 14, false);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 22:
						Class_c_032.sub_d3d((byte) 6, (byte) 1, 13, 14)
								.sub_18b7(14, 14, false);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 23:
						Class_c_032.sub_d3d((byte) 2, (byte) 1, 13, 14)
								.sub_18b7(13, 12, false);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 24:
						Class_c_032.sub_d3d((byte) 3, (byte) 1, 13, 14)
								.sub_18b7(13, 15, false);
						sub_10b94(15);
						this.var_3b5b += 1;
						break;
					case 25:
						sub_10bb9(Class_a_000.sub_c99(268), (byte) 5, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 26:
						sub_10bb9(Class_a_000.sub_c99(269), (byte) 0, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 27:
						sub_143f6(13, 17);
						break;
					case 28:
						Class_c_032 localClass_c_0325;
						(localClass_c_0325 = Class_c_032.sub_d3d((byte) 9,
								(byte) 0, 13, 18)).sub_e33(2);
						localClass_c_0325.sub_18b7(13, 16, false);
						Class_c_032.sub_d3d((byte) 6, (byte) 0, 12, 18)
								.sub_18b7(12, 16, false);
						Class_c_032.sub_d3d((byte) 8, (byte) 0, 14, 19)
								.sub_18b7(14, 16, false);
						Class_c_032.sub_d3d((byte) 4, (byte) 0, 13, 19)
								.sub_18b7(13, 17, false);
						Class_c_032.sub_d3d((byte) 1, (byte) 0, 12, 19)
								.sub_18b7(12, 17, false);
						sub_10b94(20);
						this.var_3b5b += 1;
						break;
					case 29:
						sub_10bb9(Class_a_000.sub_c99(270), (byte) 1, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 30:
						sub_143f6(this.var_358b[0].var_ad3,
								this.var_358b[0].var_adb);
						break;
					case 31:
						this.var_36db = 18;
						this.var_3b5b += 1;
						break;
					case 32:
						this.var_3783 = true;
						this.var_352b = true;
						this.var_36fb = sub_10c0e(
								Class_a_000.sub_c99(121 + this.var_34db),
								Class_a_000.sub_c99(138), this.var_32d3, -1);
						this.var_36fb.sub_1301((byte) 0, true);
						this.var_36fb.sub_1323(null);
						Class_a_000.var_79b.sub_1a8c(this.var_36fb);
						this.var_3b5b += 1;
						break;
					case 33:
						if ((sub_e3c8(-1, -1, (byte) 1) == 0)
								&& (sub_e353(1) == 0)) {
							this.var_3783 = false;
							this.var_352b = false;
							sub_10b94(10);
							this.var_3b5b += 1;
						}
						break;
					case 34:
						sub_1442b();
					}
				} else if (this.var_34db == 7) {
					switch (this.var_3b5b) {
					case 0:
						Class_a_000.var_79b.sub_1a8c(this.var_3b23);
						this.var_3813 = true;
						this.var_3b5b += 1;
						break;
					case 1:
						if (!this.var_380b) {
							sub_10bb9(Class_a_000.sub_c99(271), (byte) 0,
									(byte) 4);
							this.var_3b5b += 1;
						}
						break;
					case 2:
						sub_143f6(this.var_358b[1].var_ad3,
								this.var_358b[1].var_adb);
						break;
					case 3:
						sub_10bb9(Class_a_000.sub_c99(272), (byte) 4, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 4:
						sub_10bb9(Class_a_000.sub_c99(273), (byte) 1, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 5:
						sub_10bb9(Class_a_000.sub_c99(274), (byte) 4, (byte) 4);
						this.var_3b5b += 1;
						break;
					case 6:
						this.var_3b2b = sub_dc52(5, 2, (byte) 0);
						this.var_3b2b.sub_18b7(7, 2, false);
						this.var_3b5b += 1;
						break;
					case 7:
						if (this.var_3b2b.var_b13 != 1) {
							this.var_3b2b.sub_e0d();
							this.var_3b2b = null;
							this.var_3b33 = sub_dc52(7, 3, (byte) 0);
							this.var_3b33.sub_18b7(7, 2, false);
							this.var_3b5b += 1;
						}
						break;
					case 8:
						if (this.var_3b33.var_b13 != 1) {
							this.var_3b33.sub_e0d();
							this.var_3b33 = null;
							this.var_3b3b = sub_dc52(9, 2, (byte) 0);
							this.var_3b3b.sub_18b7(7, 2, false);
							this.var_3b5b += 1;
						}
						break;
					case 9:
						if (this.var_3b3b.var_b13 != 1) {
							this.var_3b3b.sub_e0d();
							this.var_3b3b = null;
							this.var_358b[1].sub_18b7(7, 2, false);
							sub_10b94(20);
							this.var_3b5b += 1;
						}
						break;
					case 10:
						sub_143f6(9, 15);
						this.var_352b = true;
						break;
					case 11:
						Class_d_023 localObject11 = sub_10c0e(null,
								Class_a_000.sub_c99(279), this.var_32d3, 2000);
						localObject11.sub_193f(this.var_32db, 2, 17);
						Class_a_000.var_79b
								.sub_1a8c((Class_a_000) localObject11);
						this.var_3b5b += 1;
						break;
					case 12:
						this.var_387b = false;
						sub_558c(sub_dc52(9, 15, (byte) 0));
						this.var_3b5b += 1;
						break;
					case 13:
						if (this.var_3873 >= 2) {
							sub_10bb9(Class_a_000.sub_c99(275), (byte) 0,
									(byte) 4);
							(localClass_c_0323 = sub_dc52(9, 15, (byte) 0))
									.sub_e0d();
							this.var_387b = true;
							sub_10b94(20);
							this.var_3b5b += 1;
						}
						break;
					case 14:
						this.var_352b = false;
						sub_10bb9(Class_a_000.sub_c99(276), (byte) 4, (byte) 4);
						this.var_3b5b += 1;
						break;
					case 15:
						sub_10bb9(Class_a_000.sub_c99(277), (byte) 1, (byte) 4);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 16:
						this.var_352b = true;
						this.var_39bb = 4;
						sub_143f6(3, 9);
						break;
					case 17:
						sub_143f6(13, 4);
						break;
					case 18:
						this.var_39bb = 12;
						sub_10bb9(Class_a_000.sub_c99(278), (byte) 5, (byte) 4);
						sub_143f6(this.var_358b[0].var_ad3,
								this.var_358b[0].var_adb);
						break;
					case 19:
						sub_1439a();
						this.var_3b5b += 1;
						break;
					case 20:
						if (this.var_3883) {
							this.var_352b = false;
							this.var_3783 = false;
							sub_10b94(20);
							this.var_3b5b += 1;
						}
						break;
					case 21:
						this.var_3803 = true;
						this.var_37fb = 0;
						this.var_3813 = true;
						this.var_3b5b += 1;
						break;
					case 22:
						if (this.var_37fb >= 16) {
							sub_b9c5(7, 2);
							sub_bba8(7, 2);
							sub_87e6();
							this.var_358b[1] = Class_c_032.sub_d3d((byte) 9,
									(byte) 1, 7, 2);
							this.var_358b[1].sub_e33(3);
							Class_c_032.sub_d3d((byte) 9, (byte) 0, 6, 3);
							(localClass_c_0324 = Class_c_032.sub_d3d((byte) 9,
									(byte) 0, 8, 3)).sub_e33(2);
							Class_c_032.sub_d3d((byte) 0, (byte) 0, 6, 1);
							Class_c_032.sub_d3d((byte) 0, (byte) 0, 8, 1);
							sub_10b94(10);
							this.var_3b5b += 1;
							Class_e_034.sub_2439(8, 0);
						}
						break;
					case 23:
						this.var_3803 = false;
						this.var_380b = true;
						this.var_37fb = 0;
						this.var_3b5b += 1;
						break;
					case 24:
						if (this.var_37fb >= 16) {
							sub_10bb9(Class_a_000.sub_c99(281), (byte) 4,
									(byte) 4);
							sub_10b94(15);
							this.var_3b5b += 1;
						}
						break;
					case 25:
						sub_10bb9(Class_a_000.sub_c99(282), (byte) 0, (byte) 4);
						sub_10b94(8);
						this.var_3b5b += 1;
						break;
					case 26:
						sub_10bb9(Class_a_000.sub_c99(283), (byte) 4, (byte) 4);
						sub_10b94(15);
						this.var_3b5b += 1;
						break;
					case 27:
						sub_5873(this.var_3483, 168, 48, 0, 0, 1, 50);
						this.var_3533.removeElement(this.var_358b[1]);
						sub_10b94(15);
						this.var_3b5b += 1;
						break;
					case 28:
						Class_e_034.sub_233e(400);
						sub_14bd3(5000);
						sub_10b94(10);
						this.var_3b5b += 1;
						break;
					case 29:
						sub_10bb9(Class_a_000.sub_c99(284), (byte) 5, (byte) 4);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 30:
						sub_10bb9(Class_a_000.sub_c99(285), (byte) 2, (byte) 4);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 31:
						sub_10bb9(Class_a_000.sub_c99(286), (byte) 1, (byte) 4);
						sub_10b94(5);
						this.var_3b5b += 1;
						break;
					case 32:
						sub_10bb9(Class_a_000.sub_c99(287), (byte) 0, (byte) 4);
						this.var_3803 = true;
						this.var_37fb = 0;
						this.var_3b5b += 1;
						break;
					case 33:
						if (this.var_37fb >= 16) {
							sub_10b94(10);
							this.var_3bc3 = false;
							this.var_3b5b += 1;
						}
						break;
					case 34:
						sub_c019(5, 2, 2);
						this.var_3b5b += 1;
						break;
					case 35:
						Class_e_034.sub_2439(0, 0);
						sub_c16e(Class_a_000.sub_c99(288));
						this.var_3b5b += 1;
						break;
					case 36:
						this.var_3b93 = 0;
						this.var_34c3 = 14;
						this.var_3b5b += 1;
					}
				}
			}
		}
		this.var_3b53 = null;
	}

	public final void sub_1439a() {
		this.var_3b23 = null;
		this.var_39bb = 12;
		Class_c_032.var_a7b = Class_c_032.var_a73;
		this.var_36fb.sub_1301((byte) 0, true);
		this.var_36fb.sub_1301((byte) 1, false);
		Class_a_000.var_79b.sub_1a8c(this.var_36fb);
		this.var_352b = true;
		this.var_3783 = true;
		this.var_3793 = false;
		Class_e_034.sub_2439(2, 0);
	}

	public final void sub_143f6(int paramInt1, int paramInt2) {
		this.var_3b83 = paramInt1;
		this.var_3b8b = paramInt2;
		sub_bba8(paramInt1, paramInt2);
		this.var_3b5b += 1;
	}

	public final void sub_1442b() {
		Class_e_034.sub_2459();
		Class_e_034.sub_24ab(6, 1);
		Class_a_000.var_79b.sub_1a8c(sub_10c0e(null, Class_a_000.sub_c99(72),
				this.var_32d3, 3000));
		this.var_3553 = this.var_34d3;
		this.var_3b5b = -1;
		this.var_3b93 = 0;
		this.var_34c3 = 10;
	}

	public final void sub_1447e() {
		this.var_3b7b = true;
		this.var_3b5b = 0;
		sub_10b94(20);
		Class_e_034.sub_2459();
		Class_e_034.sub_24ab(7, 1);
	}

	public final void sub_144b2(Class_c_032 paramClass_c_0321,
			Class_c_032 paramClass_c_0322) throws Exception {
		System.gc();
		this.var_3bfb = (this.var_32d3 - this.var_3a43);
		this.var_3be3 = true;
		this.var_3653 = 0;
		this.var_3bb3 = false;
		this.var_367b = paramClass_c_0321;
		this.var_3683 = paramClass_c_0322;
		Class_e_034.sub_25e4("/2.pak");
		this.var_3b9b = new Class_g_066(this, paramClass_c_0321, null);
		this.var_3ba3 = new Class_g_066(this, paramClass_c_0322, this.var_3b9b);
		this.var_3b9b.var_bed = this.var_3ba3;
		paramClass_c_0321.sub_fea(paramClass_c_0322);
		if (paramClass_c_0322.sub_1134(paramClass_c_0321,
				paramClass_c_0321.var_ad3, paramClass_c_0321.var_adb)) {
			paramClass_c_0322.sub_fea(paramClass_c_0321);
			this.var_3bdb = true;
		} else {
			this.var_3bdb = false;
		}
		this.var_3b9b.var_b4d = ((byte) paramClass_c_0321.var_b0b);
		this.var_3b9b.var_b5d = ((byte) paramClass_c_0321.sub_12c4());
		this.var_3ba3.var_b4d = ((byte) paramClass_c_0322.var_b0b);
		this.var_3ba3.var_b5d = ((byte) paramClass_c_0322.sub_12c4());
		Class_e_034.sub_24ab(var_33cb[this.var_356b[this.var_357b]], 0);
		this.var_361b = 2;
	}

	public final void sub_145c5(Class_f_045 paramClass_f_045) {
		this.var_3bbb.addElement(paramClass_f_045);
	}

	public final void sub_145e8(Class_f_045 paramClass_f_045) {
		this.var_3bbb.removeElement(paramClass_f_045);
	}

	public final void sub_1460c() throws Exception {
		if ((this.var_3bc3) && (this.var_34d3 - this.var_3bd3 >= this.var_3bcb)) {
			this.var_3bc3 = false;
		}
		Class_f_045 localClass_f_045;
		for (int i = 0; i < this.var_3bbb.size(); i++) {
			(localClass_f_045 = (Class_f_045) this.var_3bbb.elementAt(i))
					.sub_17ec();
		}
		for (int i = 0; i < this.var_3bbb.size(); i++) {
			if (!(localClass_f_045 = (Class_f_045) this.var_3bbb.elementAt(i)).var_84c) {
				sub_145e8(localClass_f_045);
			}
		}
		this.var_3b9b.sub_2ae8();
		this.var_3ba3.sub_2ae8();
		if (this.var_3be3) {
			this.var_3653 += 1;
			if (this.var_3653 >= 16) {
				this.var_3be3 = false;
				this.var_3b9b.sub_16bb();
			}
			this.var_3beb = true;
			this.var_3bf3 = true;
			return;
		}
		if (this.var_3bb3) {
			if (this.var_34d3 - this.var_3bab >= 300L) {
				this.var_3bbb.removeAllElements();
				this.var_3ba3 = null;
				this.var_3b9b = null;
				this.var_35c3 = new Vector();
				sub_56c3();
				this.var_361b = 1;
				Class_e_034.sub_2459();
				Class_e_034.sub_24ab(var_33c3[this.var_356b[this.var_357b]], 0);
				Class_a_000.var_79b.sub_1f57();
				this.var_397b = true;
				this.var_3983 = true;
			}
		} else if (this.var_3b9b.var_b35) {
			if ((this.var_3bdb) && (this.var_3ba3.var_b4d > 0)) {
				if (!this.var_3ba3.var_b2d) {
					this.var_3ba3.sub_16bb();
				}
				if (this.var_3ba3.var_b35) {
					this.var_3bb3 = true;
					this.var_3bab = this.var_34d3;
				}
			} else {
				this.var_3bb3 = true;
				this.var_3bab = this.var_34d3;
			}
		}
	}

	public final void sub_1480f(Graphics paramGraphics) {
		int i = 0;
		int j = 0;
		if (this.var_3bc3) {
			i = Class_e_034.sub_158e() % 10;
			j = Class_e_034.sub_158e() % 3;
		}
		paramGraphics.translate(0, this.var_3a43);
		paramGraphics.setClip(0, 0, this.var_32cb, this.var_3bfb);
		this.var_3b9b.sub_35fd(paramGraphics, i, j);
		this.var_3ba3.sub_35fd(paramGraphics, i + this.var_32db, j);
		paramGraphics.setColor(0);
		paramGraphics.fillRect(this.var_32db - 1 + i, 0, 2, this.var_3bfb);
		this.var_3b9b.sub_3788(paramGraphics);
		this.var_3ba3.sub_3788(paramGraphics);
		Vector localVector = new Vector(this.var_3bbb.size());
		Class_f_045 localClass_f_0451;
		for (int k = 0; k < this.var_3bbb.size(); k++) {
			localClass_f_0451 = (Class_f_045) this.var_3bbb.elementAt(k);
			int m = 0;
			if (localClass_f_0451.var_85c) {
				localVector.addElement(localClass_f_0451);
			} else {
				for (m = 0; m < localVector.size(); m++) {
					Class_f_045 localClass_f_0452;
					if (((localClass_f_0452 = (Class_f_045) localVector
							.elementAt(m)).var_85c)
							|| (localClass_f_0451.var_7e4
									+ localClass_f_0451.var_7fc < localClass_f_0452.var_7e4
									+ localClass_f_0452.var_7fc)) {
						localVector.insertElementAt(localClass_f_0451, m);
						break;
					}
				}
			}
			if (m == localVector.size()) {
				localVector.addElement(localClass_f_0451);
			}
		}
		this.var_3bbb = localVector;
		for (int k = 0; k < this.var_3bbb.size(); k++) {
			if ((localClass_f_0451 = (Class_f_045) this.var_3bbb.elementAt(k)).var_86c == 0) {
				paramGraphics.setClip(0, 0, this.var_32db, this.var_3bfb);
			} else if (localClass_f_0451.var_86c == 1) {
				paramGraphics.setClip(this.var_32db, 0, this.var_32db,
						this.var_3bfb);
			} else {
				paramGraphics.setClip(0, 0, this.var_32cb, this.var_3bfb);
			}
			localClass_f_0451.sub_12d2(paramGraphics, 0,
					localClass_f_0451.var_80c);
		}
		paramGraphics.translate(0, -this.var_3a43);
		paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
		if (this.var_3bf3) {
			this.var_3bf3 = false;
			int k = this.var_7ab - var_32c3;
			paramGraphics.setColor(14672074);
			paramGraphics.fillRect(0, k, this.var_7a3, var_32c3);
			Class_d_023
					.sub_5602(paramGraphics, 0, k, this.var_7a3, var_32c3, 0);
			paramGraphics.setClip(0, 0, this.var_7a3, this.var_7ab);
			this.var_3b9b.sub_3734(paramGraphics);
			paramGraphics.translate(this.var_32db, 0);
			this.var_3ba3.sub_3734(paramGraphics);
			paramGraphics.translate(-this.var_32db, 0);
		}
		if (this.var_3beb) {
			this.var_3beb = false;
			sub_d5f9(paramGraphics, this.var_3b9b.var_b1d,
					this.var_3ba3.var_b1d, 0);
		}
		if (this.var_3be3) {
			sub_e77a(paramGraphics, 0, this.var_3653, 16, 1, null, 0, 0,
					this.var_7a3, this.var_7ab);
		}
	}

	public final void sub_14bd3(int paramInt) {
		this.var_3bc3 = true;
		this.var_3bcb = paramInt;
		this.var_3bd3 = this.var_34d3;
	}

	public final Class_d_023 sub_14c01(String[] paramArrayOfString,
			Class_a_000 paramClass_a_000) {
		Class_d_023 localClass_d_0231;
		Class_d_023 localClass_d_0232;
		if (this.var_3c13.length > 0) {
			(localClass_d_0232 = (localClass_d_0231 = new Class_d_023(
					(byte) 11, 0)).sub_165e(Class_a_000.sub_c99(46))).var_1185 = this.var_3363[6];
			localClass_d_0231.sub_212d(this.var_3c13, this.var_32cb / 2,
					(this.var_32d3 + localClass_d_0232.var_1015) / 2,
					this.var_32cb, this.var_32d3 - localClass_d_0232.var_1015,
					3, 4);
		} else {
			(localClass_d_0232 = (localClass_d_0231 = new Class_d_023(
					(byte) 10, 0)).sub_165e(Class_a_000.sub_c99(46))).var_1185 = this.var_3363[6];
			localClass_d_0231.sub_1ceb(null, Class_a_000.sub_c99(52),
					this.var_32cb, -1);
		}
		localClass_d_0231.sub_1323(paramClass_a_000);
		Class_a_000.var_79b.sub_1a8c(localClass_d_0231);
		return localClass_d_0231;
	}

	public final void sub_14cdb(byte[] paramArrayOfByte) {
		DataInputStream localObject1;
		try {
			localObject1 = new DataInputStream(new ByteArrayInputStream(
					paramArrayOfByte));
			localObject1.readLong();
			int i = localObject1.readInt();
			switch (i) {
			case 10001:
				((DataInputStream) localObject1).readUTF();
				((DataInputStream) localObject1).readInt();
				((DataInputStream) localObject1).readUTF();
				((DataInputStream) localObject1).readInt();
				((DataInputStream) localObject1).readUTF();
				((DataInputStream) localObject1).readInt();
				((DataInputStream) localObject1).readUTF();
				int j = ((DataInputStream) localObject1).readInt();
				((DataInputStream) localObject1).readUTF();
				((DataInputStream) localObject1).readUTF();
				int n;
				if (this.var_3c83 == 0) {
					int k = ((DataInputStream) localObject1).readInt() / 2;
					this.var_3c13 = new String[k];
					this.var_3c1b = new String[k];
					this.var_3c23 = new String[k];
					n = 0;
					for (int i1 = 0; i1 < k; i1++) {
						this.var_3c13[i1] = ((DataInputStream) localObject1)
								.readUTF();
						this.var_3c1b[i1] = ((DataInputStream) localObject1)
								.readUTF();
					}
					this.var_392b = sub_14c01(this.var_3c13, this.var_3c7b);
				} else if (this.var_3c83 == 1) {
					((DataInputStream) localObject1).readInt();
					this.var_3c23[this.var_3c03] = ((DataInputStream) localObject1)
							.readUTF();
					Class_d_023 localClass_d_0231;
					(localClass_d_0231 = sub_10c33(
							this.var_3c13[this.var_3c03],
							this.var_3c23[this.var_3c03], this.var_32d3,
							this.var_32d3 / 2, -1)).sub_1323(this.var_3c7b);
					Class_a_000.var_79b.sub_1a8c(localClass_d_0231);
				} else if (this.var_3c83 == 2) {
					int m = ((DataInputStream) localObject1).readInt() / 3;
					this.var_3c2b = new String[m];
					this.var_3c33 = new String[m];
					this.var_3c3b = new int[m];
					for (n = 0; n < m; n++) {
						this.var_3c2b[n] = ((DataInputStream) localObject1)
								.readUTF();
						this.var_3c33[n] = ((DataInputStream) localObject1)
								.readUTF();
						this.var_3c3b[n] = Integer
								.parseInt(((DataInputStream) localObject1)
										.readUTF());
					}
					sub_5d1a(this.var_3c7b);
					Class_a_000.var_79b.sub_1a8c(this.var_3943);
				} else if (this.var_3c83 == 3) {
					String str = this.var_3c2b[this.var_3c0b];
					byte[] arrayOfByte = new byte[j];
					((DataInputStream) localObject1).readFully(arrayOfByte);
					sub_15568(str, arrayOfByte);
					sub_5d1a(this.var_3943.var_10ed);
					Class_d_023 localClass_d_0232;
					(localClass_d_0232 = sub_10c0e(null,
							Class_a_000.sub_e44(45, str), this.var_32d3, 2000))
							.sub_1323(this.var_3943);
					Class_a_000.var_79b.sub_1a8c(localClass_d_0232);
				}
				this.var_3c7b = null;
				return;
			}
			((DataInputStream) localObject1).close();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		Class_d_023 localObject = sub_10c0e(null, Class_a_000.sub_c99(44),
				this.var_32d3, -1);
		localObject.sub_1323(this.var_3c7b);
		this.var_3c7b = null;
		Class_a_000.var_79b.sub_1a8c((Class_a_000) localObject);
	}

	public final void sub_1500b(int paramInt, String paramString1,
			String paramString2, Class_a_000 paramClass_a_000) throws Exception {
		this.var_3c83 = paramInt;
		this.var_3c7b = paramClass_a_000;
		this.var_3c73 = false;
		this.var_3c5b = new ByteArrayOutputStream();
		this.var_3c63 = new DataOutputStream(this.var_3c5b);
		this.var_3c63.writeInt(10001);
		this.var_3c63.writeUTF(this.var_3c43);
		this.var_3c63.writeUTF(this.var_3c4b);
		this.var_3c6b = this.var_3c5b.size();
		this.var_3c63.writeUTF("resourceName");
		this.var_3c63.writeUTF(paramString1);
		this.var_3c63.writeUTF("languageCode");
		this.var_3c63.writeUTF(paramString2);
		this.var_3c63.writeUTF("maxChunkSize");
		this.var_3c63.writeUTF("1024");
		this.var_3c63.writeUTF("chunk");
		this.var_3c63.writeUTF("0");
		this.var_3c63.writeUTF("requestId");
		this.var_3c63.writeUTF("0");
		Class_d_023 localClass_d_023;
		(localClass_d_023 = sub_10c0e(null, Class_a_000.sub_c99(43),
				this.var_32d3, -1)).sub_1323(paramClass_a_000);
		Class_a_000.var_79b.sub_1a8c(localClass_d_023);
		new Thread(this).start();
	}

	/* Error */
	public final void run() {
		// Byte code:
		// 0: aconst_null
		// 1: astore_1
		// 2: aconst_null
		// 3: astore_2
		// 4: aload_0
		// 5: getfield 138 Class_i_168:var_3c5b Ljava/io/ByteArrayOutputStream;
		// 8: invokevirtual 704 java/io/ByteArrayOutputStream:toByteArray ()[B
		// 11: astore_3
		// 12: aload_0
		// 13: getfield 138 Class_i_168:var_3c5b Ljava/io/ByteArrayOutputStream;
		// 16: invokevirtual 625 java/io/ByteArrayOutputStream:close ()V
		// 19: aload_0
		// 20: getfield 139 Class_i_168:var_3c63 Ljava/io/DataOutputStream;
		// 23: invokevirtual 624 java/io/DataOutputStream:close ()V
		// 26: aload_0
		// 27: getfield 267 Class_i_168:var_3c53 Ljava/lang/String;
		// 30: invokestatic 679 javax/microedition/io/Connector:open
		// (Ljava/lang/String;)Ljavax/microedition/io/Connection;
		// 33: checkcast 34 javax/microedition/io/HttpConnection
		// 36: astore_2
		// 37: ldc_w 749
		// 40: invokevirtual 673 java/lang/String:length ()I
		// 43: ifle +47 -> 90
		// 46: ldc_w 749
		// 49: invokevirtual 664 java/lang/String:getBytes ()[B
		// 52: astore 4
		// 54: aload_0
		// 55: getfield 151 Class_i_168:var_3c6b I
		// 58: istore 5
		// 60: iload 5
		// 62: aload_3
		// 63: arraylength
		// 64: if_icmpge +26 -> 90
		// 67: aload_3
		// 68: iload 5
		// 70: dup2
		// 71: baload
		// 72: aload 4
		// 74: iload 5
		// 76: aload 4
		// 78: arraylength
		// 79: irem
		// 80: baload
		// 81: ixor
		// 82: i2b
		// 83: bastore
		// 84: iinc 5 1
		// 87: goto -27 -> 60
		// 90: aload_2
		// 91: ldc_w 752
		// 94: invokeinterface 723 2 0
		// 99: aload_2
		// 100: ldc_w 747
		// 103: aload_3
		// 104: arraylength
		// 105: invokestatic 706 java/lang/Integer:toString
		// (I)Ljava/lang/String;
		// 108: invokeinterface 724 3 0
		// 113: aload_2
		// 114: ldc_w 746
		// 117: ldc_w 766
		// 120: invokeinterface 724 3 0
		// 125: aload_2
		// 126: invokeinterface 722 1 0
		// 131: dup
		// 132: astore 4
		// 134: aload_3
		// 135: invokevirtual 712 java/io/OutputStream:write ([B)V
		// 138: aload 4
		// 140: invokevirtual 660 java/io/OutputStream:flush ()V
		// 143: aload 4
		// 145: invokevirtual 626 java/io/OutputStream:close ()V
		// 148: aload_2
		// 149: invokeinterface 721 1 0
		// 154: astore 5
		// 156: aload_2
		// 157: invokeinterface 720 1 0
		// 162: dup
		// 163: istore 6
		// 165: sipush 200
		// 168: if_icmpne +56 -> 224
		// 171: new 19 java/io/ByteArrayOutputStream
		// 174: dup
		// 175: invokespecial 444 java/io/ByteArrayOutputStream:<init> ()V
		// 178: astore 7
		// 180: iconst_0
		// 181: istore 8
		// 183: aload 5
		// 185: invokevirtual 685 java/io/DataInputStream:read ()I
		// 188: dup
		// 189: istore 8
		// 191: iconst_m1
		// 192: if_icmpeq +13 -> 205
		// 195: aload 7
		// 197: iload 8
		// 199: invokevirtual 713 java/io/ByteArrayOutputStream:write (I)V
		// 202: goto -19 -> 183
		// 205: aload 7
		// 207: invokevirtual 704 java/io/ByteArrayOutputStream:toByteArray ()[B
		// 210: astore_1
		// 211: aload 7
		// 213: invokevirtual 625 java/io/ByteArrayOutputStream:close ()V
		// 216: aload 5
		// 218: invokevirtual 623 java/io/DataInputStream:close ()V
		// 221: goto +32 -> 253
		// 224: new 23 java/lang/Exception
		// 227: dup
		// 228: new 28 java/lang/StringBuffer
		// 231: dup
		// 232: invokespecial 436 java/lang/StringBuffer:<init> ()V
		// 235: ldc_w 725
		// 238: invokevirtual 575 java/lang/StringBuffer:append
		// (Ljava/lang/String;)Ljava/lang/StringBuffer;
		// 241: iload 6
		// 243: invokevirtual 576 java/lang/StringBuffer:append
		// (I)Ljava/lang/StringBuffer;
		// 246: invokevirtual 705 java/lang/StringBuffer:toString
		// ()Ljava/lang/String;
		// 249: invokespecial 450 java/lang/Exception:<init>
		// (Ljava/lang/String;)V
		// 252: athrow
		// 253: aload_2
		// 254: ifnull +18 -> 272
		// 257: aload_2
		// 258: invokeinterface 719 1 0
		// 263: goto +9 -> 272
		// 266: dup
		// 267: astore 11
		// 269: invokevirtual 682 java/lang/Exception:printStackTrace ()V
		// 272: goto +54 -> 326
		// 275: dup
		// 276: astore_3
		// 277: invokevirtual 682 java/lang/Exception:printStackTrace ()V
		// 280: aload_2
		// 281: ifnull +18 -> 299
		// 284: aload_2
		// 285: invokeinterface 719 1 0
		// 290: goto +9 -> 299
		// 293: dup
		// 294: astore 11
		// 296: invokevirtual 682 java/lang/Exception:printStackTrace ()V
		// 299: goto +27 -> 326
		// 302: astore 9
		// 304: aload_2
		// 305: ifnull +18 -> 323
		// 308: aload_2
		// 309: invokeinterface 719 1 0
		// 314: goto +9 -> 323
		// 317: dup
		// 318: astore 11
		// 320: invokevirtual 682 java/lang/Exception:printStackTrace ()V
		// 323: aload 9
		// 325: athrow
		// 326: aload_0
		// 327: getfield 59 Class_i_168:var_3c73 Z
		// 330: ifne +8 -> 338
		// 333: aload_0
		// 334: aload_1
		// 335: invokevirtual 606 Class_i_168:sub_14cdb ([B)V
		// 338: return
		// Local variable table:
		// start length slot name signature
		// 0 339 0 this Class_i_168
		// 1 334 1 arrayOfByte byte[]
		// 3 306 2 localHttpConnection javax.microedition.io.HttpConnection
		// 11 266 3 localObject1 Object
		// 52 92 4 localObject2 Object
		// 58 27 5 i int
		// 154 63 5 localDataInputStream DataInputStream
		// 163 79 6 j int
		// 178 34 7 localByteArrayOutputStream ByteArrayOutputStream
		// 181 17 8 k int
		// 302 22 9 localObject3 Object
		// 267 52 11 localException1 Exception
		// 266 1 12 localException2 Exception
		// 275 1 13 localException3 Exception
		// 293 1 14 localException4 Exception
		// 317 1 15 localException5 Exception
		// Exception table:
		// from to target type
		// 257 263 266 java/lang/Exception
		// 4 253 275 java/lang/Exception
		// 284 290 293 java/lang/Exception
		// 4 253 302 finally
		// 275 280 302 finally
		// 302 304 302 finally
		// 308 314 317 java/lang/Exception
	}

	public final void sub_15429(int paramInt) throws Exception {
		int i = this.var_3903[paramInt];
		this.var_38f3 -= 1;
		String[] arrayOfString = new String[this.var_38f3];
		int[] arrayOfInt = new int[this.var_38f3];
		System.arraycopy(this.var_38fb, 0, arrayOfString, 0, paramInt);
		System.arraycopy(this.var_38fb, paramInt + 1, arrayOfString, paramInt,
				this.var_38f3 - paramInt);
		System.arraycopy(this.var_3903, 0, arrayOfInt, 0, paramInt);
		System.arraycopy(this.var_3903, paramInt + 1, arrayOfInt, paramInt,
				this.var_38f3 - paramInt);
		this.var_38fb = arrayOfString;
		this.var_3903 = arrayOfInt;
		Class_e_034.sub_16d3("download", i);
		this.var_396b = Class_e_034.sub_1709("download");
		sub_155fb();
		for (int j = 0; j < 3; j++) {
			if (this.var_38a3[j] == i + var_32f3.length) {
				this.var_389b[j] = -1;
				this.var_38a3[j] = -1;
				this.var_3893[j] = ("\n" + Class_a_000.sub_c99(79) + "\n ");
				Class_e_034.sub_15e7("save", j, new byte[0]);
			}
		}
	}

	public final void sub_15568(String paramString, byte[] paramArrayOfByte)
			throws Exception {
		String[] arrayOfString = new String[this.var_38f3 + 1];
		int[] arrayOfInt = new int[this.var_38f3 + 1];
		System.arraycopy(this.var_38fb, 0, arrayOfString, 0, this.var_38f3);
		System.arraycopy(this.var_3903, 0, arrayOfInt, 0, this.var_38f3);
		this.var_38fb = arrayOfString;
		this.var_3903 = arrayOfInt;
		this.var_3903[this.var_38f3] = Class_e_034.sub_1698("download",
				paramArrayOfByte);
		this.var_38fb[this.var_38f3] = paramString;
		this.var_38f3 += 1;
		this.var_396b = Class_e_034.sub_1709("download");
		sub_155fb();
	}

	public final void sub_155fb() throws Exception {
		ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream localDataOutputStream;
		(localDataOutputStream = new DataOutputStream(
				localByteArrayOutputStream)).writeInt(this.var_38f3);
		for (int i = 0; i < this.var_38f3; i++) {
			localDataOutputStream.writeInt(this.var_3903[i]);
			localDataOutputStream.writeUTF(this.var_38fb[i]);
		}
		Class_e_034.sub_15e7("settings", 2,
				localByteArrayOutputStream.toByteArray());
		localDataOutputStream.close();
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_i_168
 * 
 * JD-Core Version: 0.7.0.1
 */