import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;

public final class Class_e_034 extends Canvas implements Runnable,
		CommandListener {
	
	public static final Font var_1374 = Font.getFont(0, 1, 0);
	public static final Font var_137c = Font.getFont(0, 1, 8);
	public static final int var_1384 = var_137c.getBaselinePosition();
	public static final int var_138c = var_1384 + 6;
	public static final int var_1394 = var_1374.getBaselinePosition();
	public static final int var_139c = var_1394 + 8;
	public static final short[] var_13a4 = { 45, 43 };
	public static final short[] var_13ac = { 57, 57 };
	public static final byte[][] var_13b4 = {
			{ 10, 11, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
			{ 12, -1, 11, -1, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
	private static Display var_13bc;
	private boolean var_13c4 = false;
	private boolean var_13cc = true;
	public Class_a_000 var_13d4;
	public static int var_13dc;
	public static int var_13e4;
	public int var_13ec = 0;
	public int var_13f4;
	public int var_13fc = 0;
	public long var_1404;
	public static Class_f_045[] var_140c;
	public static Random var_1414 = new Random();
	public static boolean[] var_141c = { true, true, true, true };
	public static String[] var_1424;
	public boolean var_142c = false;
	public static int var_1434 = -1;
	public static int var_143c;
	public static boolean var_1444 = false;
	public static final String[] musicNames = { "main_theme", "bg_story",
			"bg_good", "bg_bad", "battle_good", "battle_bad", "victory",
			"gameover", "game_complete" };
	public static final byte[] var_1454 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	public static Player[] var_145c;
	public static Player var_1464;
	public static boolean[] var_146c;
	public static int var_1474;
	public static int var_147c;
	public static byte[][] var_1484;
	public static String[] var_148c;

	public Class_e_034(MIDlet paramMIDlet) {
		try {
			setFullScreenMode(true);
			Class_a_000.var_79b = this;
			Class_a_000.sub_bfe("/lang.dat", false);
			var_13dc = getWidth();
			var_13e4 = getHeight();
			var_13bc = Display.getDisplay(paramMIDlet);
			var_13bc.setCurrent(this);
			new Thread(this).start();
			return;
		} catch (Exception localException) {
			sub_20fa(localException.toString());
		}
	}

	public static final int sub_1544(int paramInt) {
		return sub_1564(0, paramInt);
	}

	public static final int sub_1564(int paramInt1, int paramInt2) {
		return paramInt1 + Math.abs(var_1414.nextInt())
				% (paramInt2 - paramInt1);
	}

	public static final int sub_158e() {
		return var_1414.nextInt();
	}

	public static final byte[] sub_15af(String paramString, int paramInt)
			throws Exception {
		RecordStore localRecordStore;
		byte[] arrayOfByte = (localRecordStore = RecordStore.openRecordStore(
				paramString, false)).getRecord(paramInt + 1);
		localRecordStore.closeRecordStore();
		return arrayOfByte;
	}

	public static final void sub_15e7(String paramString, int paramInt,
			byte[] paramArrayOfByte) throws Exception {
		RecordStore localRecordStore;
		int i;
		if ((i = (localRecordStore = RecordStore.openRecordStore(paramString,
				true)).getNumRecords()) <= paramInt) {
			while (i < paramInt) {
				localRecordStore.addRecord(null, 0, 0);
				i++;
			}
			localRecordStore.addRecord(paramArrayOfByte, 0,
					paramArrayOfByte.length);
		} else {
			localRecordStore.setRecord(paramInt + 1, paramArrayOfByte, 0,
					paramArrayOfByte.length);
		}
		localRecordStore.closeRecordStore();
	}

	public static final int sub_1698(String paramString, byte[] paramArrayOfByte)
			throws Exception {
		RecordStore localRecordStore;
		int i = (localRecordStore = RecordStore.openRecordStore(paramString,
				true)).addRecord(paramArrayOfByte, 0, paramArrayOfByte.length);
		localRecordStore.closeRecordStore();
		return i - 1;
	}

	public static final void sub_16d3(String paramString, int paramInt)
			throws Exception {
		RecordStore localRecordStore;
		(localRecordStore = RecordStore.openRecordStore(paramString, true))
				.deleteRecord(paramInt + 1);
		localRecordStore.closeRecordStore();
	}

	public static final int sub_1709(String paramString) {
		int i = 0;
		try {
			RecordStore localRecordStore;
			i = (localRecordStore = RecordStore.openRecordStore(paramString,
					true)).getSizeAvailable();
			localRecordStore.closeRecordStore();
		} catch (Exception localException) {
		}
		return i;
	}

	public static final int sub_1761(byte paramByte, String paramString) {
		return var_140c[paramByte].var_7f4 * paramString.length();
	}

	public static final int sub_1789(byte paramByte) {
		return var_140c[paramByte].var_7fc;
	}

	public static final void sub_17ac(Graphics paramGraphics, int paramInt) {
		paramGraphics.setColor(paramInt);
	}

	public final void showNotify() {
		this.var_142c = false;
		var_1444 = false;
		sub_1f57();
		if (this.var_13d4 != null) {
			this.var_13d4.sub_84a();
		}
	}

	public final void hideNotify() {
		sub_1f57();
		if (this.var_13d4 != null) {
			if (!this.var_142c) {
				var_1444 = true;
				if ((var_1464 != null) && (var_1464.getState() == 400)
						&& (var_1454[var_1474] == 1)) {
					var_1434 = var_1474;
					var_143c = var_147c;
				}
				sub_2459();
			}
			this.var_142c = false;
		}
	}

	public static final void sub_189a(Graphics paramGraphics,
			String paramString, int paramInt1, int paramInt2, int paramInt3,
			int paramInt4) {
		if ((paramInt4 & 0x8) != 0) {
			paramInt1 -= sub_1761((byte) paramInt3, paramString);
		} else if ((paramInt4 & 0x1) != 0) {
			paramInt1 -= sub_1761((byte) paramInt3, paramString) / 2;
		}
		if ((paramInt4 & 0x20) != 0) {
			paramInt2 -= sub_1789((byte) paramInt3);
		} else if ((paramInt4 & 0x2) != 0) {
			paramInt2 -= sub_1789((byte) paramInt3) / 2;
		}
		sub_1954(paramGraphics, paramString, paramInt1, paramInt2, paramInt3);
	}

	public static final void sub_1954(Graphics paramGraphics,
			String paramString, int paramInt1, int paramInt2, int paramInt3) {
		int m = 0;
		int n = paramString.length();
		while (m < n) {
			int k;
			if (((k = paramString.charAt(m)) >= var_13a4[paramInt3])
					&& (k <= var_13ac[paramInt3])) {
				int j;
				if ((j = var_13b4[paramInt3][(k - var_13a4[paramInt3])]) != -1) {
					var_140c[paramInt3].sub_108a(j);
					var_140c[paramInt3].sub_12d2(paramGraphics, paramInt1,
							paramInt2);
					paramInt1 += var_140c[paramInt3].var_7f4;
				} else {
					byte[] arrayOfByte = { (byte) k };
					String str = new String(arrayOfByte);
					paramGraphics.drawString(str, paramInt1, paramInt2, 20);
					paramInt1 += paramGraphics.getFont().stringWidth(str);
				}
			}
			m++;
		}
	}

	public static final void sub_1a66(Graphics paramGraphics,
			String paramString, int paramInt1, int paramInt2, int paramInt3) {
		paramGraphics.drawString(paramString, paramInt1, paramInt2 - 2,
				paramInt3);
	}

	public final void sub_1a8c(Class_a_000 paramClass_a_000) {
		sub_1f57();
		paramClass_a_000.sub_84a();
		this.var_13d4 = paramClass_a_000;
	}

	public final void sub_1ab4() {
		repaint();
		serviceRepaints();
	}

	public final void paint(Graphics paramGraphics) {
		if (this.var_13cc) {
			paramGraphics.setColor(16777215);
			paramGraphics.fillRect(0, 0, var_13dc, var_13e4);
			paramGraphics.setFont(var_137c);
			paramGraphics.setColor(0);
			paramGraphics.drawString(Class_a_000.sub_c99(58), var_13dc / 2,
					var_13e4 / 2 - 1, 33);
			return;
		}
		this.var_13d4.sub_8a5(paramGraphics);
	}

	public final int getGameAction(int paramInt) {
		try {
			switch (paramInt) {
			case -6:
				return 1024;
			case -7:
				return 2048;
			case 48:
				return 32;
			case 53:
				return 16;
			case 49:
				return 64;
			case 51:
				return 128;
			case 55:
				return 256;
			case 57:
				return 512;
			case 50:
				return 1;
			case 56:
				return 2;
			case 52:
				return 4;
			case 54:
				return 8;
			}
			switch (super.getGameAction(paramInt)) {
			case 1:
				return 1;
			case 6:
				return 2;
			case 2:
				return 4;
			case 5:
				return 8;
			case 8:
				return 16;
			}
		} catch (Exception localException) {
		}
		return 4096;
	}

	public final String sub_1da2(int paramInt) {
		int i = 0;
		switch (paramInt) {
		case 32:
			i = 48;
			break;
		case 16:
			i = 53;
			break;
		case 64:
			i = 49;
			break;
		case 128:
			i = 51;
			break;
		case 256:
			i = 55;
			break;
		case 512:
			i = 57;
			break;
		case 1:
			i = 50;
			break;
		case 2:
			i = 56;
			break;
		case 4:
			i = 52;
			break;
		case 8:
			i = 54;
		}
		return super.getKeyName(i);
	}

	public final void keyPressed(int paramInt) {
		int i = getGameAction(paramInt);
		sub_2079(i);
		if (this.var_13d4 != null) {
			this.var_13d4.sub_865(paramInt, i);
		}
	}

	public final boolean sub_1f21() {
		return this.var_13ec != 0;
	}

	public final void sub_1f57() {
		this.var_13fc = 0;
		this.var_13ec = 0;
		this.var_13f4 = 0;
	}

	public final boolean sub_1f81(int paramInt) {
		boolean bool = (this.var_13f4 & paramInt) != 0;
		this.var_13f4 &= (paramInt ^ 0xFFFFFFFF);
		return bool;
	}

	public final boolean sub_1fd5(int paramInt) {
		return (this.var_13ec & paramInt) != 0;
	}

	public final void keyReleased(int paramInt) {
		sub_20b4(getGameAction(paramInt));
	}

	public final boolean sub_2032(int paramInt) {
		return (this.var_13fc == paramInt)
				&& (System.currentTimeMillis() - this.var_1404 >= 400L);
	}

	public final void sub_2079(int paramInt) {
		this.var_13fc = paramInt;
		this.var_1404 = System.currentTimeMillis();
		this.var_13ec |= paramInt;
		this.var_13f4 |= paramInt;
	}

	public final void sub_20b4(int paramInt) {
		if (paramInt == this.var_13fc) {
			this.var_13fc = 0;
		}
		this.var_13ec &= (paramInt ^ 0xFFFFFFFF);
	}

	public final void sub_20fa(String paramString) {
		this.var_13c4 = false;
		Form localForm;
		(localForm = new Form("Fatal error!")).append(paramString);
		Command localCommand = new Command("Exit", 7, 1);
		localForm.addCommand(localCommand);
		localForm.setCommandListener(this);
		var_13bc.setCurrent(localForm);
	}

	public final void sub_2148() {
		this.var_13c4 = false;
	}

	public static final void sub_2168() throws Exception {
		var_140c[0] = new Class_f_045("chars");
		var_140c[1] = new Class_f_045("lchars");
	}

	public final void run() {
		try {
			sub_1ab4();
			var_1424 = new String[] { Class_a_000.sub_c99(26),
					Class_a_000.sub_c99(28), Class_a_000.sub_c99(25),
					Class_a_000.sub_c99(24) };
			Class_i_168 localClass_i_168 = new Class_i_168();
			sub_1ab4();
			this.var_13d4 = localClass_i_168;
			this.var_13cc = false;
			this.var_13c4 = true;
			localClass_i_168.sub_3fd8();
			while (this.var_13c4) {
				long l = System.currentTimeMillis();
				if ((isShown()) && (!var_1444)) {
					if (var_1434 >= 0) {
						sub_24ab(var_1434, var_143c);
						if ((var_1464 != null) && (var_1464.getState() == 400)) {
							var_1434 = -1;
						}
					}
					this.var_13d4.sub_880();
					sub_1ab4();
				}
				int i = (int) (System.currentTimeMillis() - l);
				int j;
				if ((j = 65 - i) < 10) {
					j = 10;
				}
				if (j > 0) {
					try {
						Thread.sleep(j);
					} catch (Exception localException1) {
					}
				}
			}
			if (Class_b_001.var_101 != null) {
				Class_b_001.var_101.notifyDestroyed();
				Class_b_001.var_101.destroyApp(true);
			}
			return;
		} catch (Exception localException2) {
			localException2.printStackTrace();
			sub_20fa(localException2.toString());
		}
	}

	public static final void sub_233e(int paramInt) {
		try {
			if (var_141c[1] != false) {
				var_13bc.vibrate(paramInt * 4);
			}
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_238e() {
		var_145c = new Player[musicNames.length];
		var_146c = new boolean[musicNames.length];
	}

	public static final void sub_23bc(int paramInt) {
		try {
			var_146c[paramInt] = false;
			InputStream localInputStream = sub_278a(musicNames[paramInt]
					+ ".mid");
			var_145c[paramInt] = Manager.createPlayer(localInputStream,
					"audio/midi");
			var_145c[paramInt].realize();
			var_145c[paramInt].prefetch();
			var_146c[paramInt] = true;
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_2439(int paramInt1, int paramInt2) {
		sub_24ab(paramInt1, paramInt2);
	}

	public static final void sub_2459() {
		try {
			if (var_1464 != null) {
				var_1464.stop();
				var_1464 = null;
				var_1474 = -1;
			}
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_24ab(int paramInt1, int paramInt2) {
		try {
			if (var_146c[paramInt1] == false) {
				return;
			}
			if (var_1464 != null) {
				var_1464.stop();
			}
			if ((var_1454[paramInt1] == 1) && (var_141c[0] != false)) {
				if (paramInt2 == 0) {
					paramInt2 = -1;
				}
				if (var_1444) {
					var_1434 = paramInt1;
					var_143c = paramInt2;
				} else {
					var_1464 = var_145c[paramInt1];
					var_1464.setLoopCount(paramInt2);
					var_1464.start();
					var_1474 = paramInt1;
					var_147c = paramInt2;
				}
			}
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_2573(int paramInt) {
		try {
			if (var_146c[paramInt] == false) {
				return;
			}
			if (var_1464 == var_145c[paramInt]) {
				var_1464.stop();
				var_1464 = null;
				var_1474 = -1;
			}
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_25e4(String paramString) throws Exception {
		if (var_148c == null) {
			var_148c = null;
			int[] arrayOfInt1 = null;
			int[] arrayOfInt2 = null;
			InputStream localInputStream = Class_b_001.var_101.getClass()
					.getResourceAsStream("/1.pak");
			DataInputStream localDataInputStream;
			int i = (localDataInputStream = new DataInputStream(
					localInputStream)).readShort();
			int j;
			var_148c = new String[j = localDataInputStream.readShort()];
			arrayOfInt1 = new int[j];
			arrayOfInt2 = new int[j];
			for (int k = 0; k < j; k++) {
				var_148c[k] = localDataInputStream.readUTF();
				arrayOfInt1[k] = (localDataInputStream.readInt() + i);
				arrayOfInt2[k] = localDataInputStream.readShort();
			}
			var_1484 = new byte[var_148c.length][];
			for (int m = 0; m < var_148c.length; m++) {
				var_1484[m] = new byte[arrayOfInt2[m]];
				localDataInputStream.readFully(var_1484[m]);
			}
			localDataInputStream.close();
		}
	}

	public static final byte[] sub_2726(String paramString) {
		for (int i = 0; i < var_148c.length; i++) {
			if (paramString.equals(var_148c[i])) {
				return var_1484[i];
			}
		}
		return null;
	}

	public static final InputStream sub_278a(String paramString)
			throws Exception {
		return new ByteArrayInputStream(sub_2726(paramString));
	}

	public final void commandAction(Command paramCommand,
			Displayable paramDisplayable) {
		Class_b_001.var_101.notifyDestroyed();
	}

	static {
		var_140c = new Class_f_045[2];
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_e_034
 * 
 * JD-Core Version: 0.7.0.1
 */