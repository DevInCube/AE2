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

public final class E_MainCanvas extends Canvas implements Runnable,
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
	private static Display display;
	private boolean isRunning = false;
	private boolean isLoading = true;
	public A_MenuBase currentMenuMb;
	public static int canvasWidth;
	public static int canvasHeight;
	public int var_13ec = 0;
	public int var_13f4;
	public int var_13fc = 0;
	public long var_1404;
	public static F_Sprite[] charsSprites = new F_Sprite[2];
	public static Random var_1414 = new Random();
	public static boolean[] settings = { true, true, true, true };
	public static String[] settingsNames;
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
	public static byte[][] resourcesData;
	public static String[] resourcesNames;

	public E_MainCanvas(MIDlet paramMIDlet) {
		try {
			setFullScreenMode(true);
			A_MenuBase.mainCanvas = this;
			A_MenuBase.loadLangStrings("/lang.dat", false);
			canvasWidth = getWidth();
			canvasHeight = getHeight();
			display = Display.getDisplay(paramMIDlet);
			display.setCurrent(this);
			new Thread(this).start();
			return;
		} catch (Exception ex) {
			showFatalError(ex.toString());
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

	public static final byte[] getRecordStoreData(String paramString, int paramInt)
			throws Exception {
		RecordStore store = RecordStore.openRecordStore(
				paramString, false);
		byte[] arrayOfByte = store.getRecord(paramInt + 1);
		store.closeRecordStore();
		return arrayOfByte;
	}

	public static final void saveRecordStoreData(String recordName, int paramInt,
			byte[] paramArrayOfByte) throws Exception {
		RecordStore localRecordStore = RecordStore.openRecordStore(recordName,
				true);
		int i = localRecordStore.getNumRecords();
		if (i <= paramInt) {
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

	public static final int getRecordStoreAvailableSize(String paramString) {
		int size = 0;
		try {
			RecordStore localRecordStore = RecordStore.openRecordStore(paramString,
					true);
			size = localRecordStore.getSizeAvailable();
			localRecordStore.closeRecordStore();
		} catch (Exception ex) {
			//
		}
		return size;
	}

	public static final int sub_1761(byte paramByte, String paramString) {
		return charsSprites[paramByte].var_7f4 * paramString.length();
	}

	public static final int sub_1789(byte paramByte) {
		return charsSprites[paramByte].var_7fc;
	}

	public static final void sub_17ac(Graphics paramGraphics, int paramInt) {
		paramGraphics.setColor(paramInt);
	}

	public final void showNotify() {
		this.var_142c = false;
		var_1444 = false;
		sub_1f57();
		if (this.currentMenuMb != null) {
			this.currentMenuMb.sub_84a();
		}
	}

	public final void hideNotify() {
		sub_1f57();
		if (this.currentMenuMb != null) {
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
					charsSprites[paramInt3].sub_108a(j);
					charsSprites[paramInt3].sub_12d2(paramGraphics, paramInt1,
							paramInt2);
					paramInt1 += charsSprites[paramInt3].var_7f4;
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

	public final void showMenu(A_MenuBase menu) {
		sub_1f57();
		menu.sub_84a();
		this.currentMenuMb = menu;
	}

	public final void repaintAll() {
		repaint();
		serviceRepaints();
	}

	public final void paint(Graphics paramGraphics) {
		if (this.isLoading) {
			paramGraphics.setColor(16777215); //#FFFFFF
			paramGraphics.fillRect(0, 0, canvasWidth, canvasHeight);
			paramGraphics.setFont(var_137c);
			paramGraphics.setColor(0);
			//LOADING...
			paramGraphics.drawString(A_MenuBase.getLangString(58), canvasWidth / 2,
					canvasHeight / 2 - 1, 33);
			return;
		}
		this.currentMenuMb.sub_8a5(paramGraphics);
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
		if (this.currentMenuMb != null) {
			this.currentMenuMb.sub_865(paramInt, i);
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

	public final void showFatalError(String errorMsg) {
		this.isRunning = false;
		Form errForm = new Form("Fatal error!");
		errForm.append(errorMsg);
		Command localCommand = new Command("Exit", 7, 1);
		errForm.addCommand(localCommand);
		errForm.setCommandListener(this);
		display.setCurrent(errForm);
	}

	public final void stopGame() {
		this.isRunning = false;
	}

	public static final void sub_2168() throws Exception {
		charsSprites[0] = new F_Sprite("chars");
		charsSprites[1] = new F_Sprite("lchars");
	}

	public final void run() {
		try {
			repaintAll();
			settingsNames = new String[] { A_MenuBase.getLangString(26),
					A_MenuBase.getLangString(28), A_MenuBase.getLangString(25),
					A_MenuBase.getLangString(24) };
			I_Game localClass_i_168 = new I_Game();
			repaintAll();
			this.currentMenuMb = localClass_i_168;
			this.isLoading = false;
			this.isRunning = true;
			localClass_i_168.sub_3fd8();
			while (this.isRunning) {
				long time = System.currentTimeMillis();
				if ((isShown()) && (!var_1444)) {
					if (var_1434 >= 0) {
						sub_24ab(var_1434, var_143c);
						if ((var_1464 != null) && (var_1464.getState() == 400)) {
							var_1434 = -1;
						}
					}
					this.currentMenuMb.sub_880();
					repaintAll();
				}
				int timeElapsed = (int) (System.currentTimeMillis() - time);
				int delay = 65 - timeElapsed;
				if (delay < 10) {
					delay = 10;
				}
				if (delay > 0) {
					try {
						Thread.sleep(delay);
					} catch (Exception ex1) {
						//
					}
				}
			}
			if (B_MainMIDlet.midlet != null) {
				B_MainMIDlet.midlet.notifyDestroyed();
				B_MainMIDlet.midlet.destroyApp(true);
			}
			return;
		} catch (Exception ex2) {
			ex2.printStackTrace();
			showFatalError(ex2.toString());
		}
	}

	public static final void sub_233e(int paramInt) {
		try {
			if (settings[1] != false) {
				display.vibrate(paramInt * 4);
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
			InputStream localInputStream = getResourceStream(musicNames[paramInt]
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
		} catch (Exception ex) {
			//
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
			if ((var_1454[paramInt1] == 1) && (settings[0] != false)) {
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
		} catch (Exception ex) {
			//
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

	public static final void loadResourcesPak(String pakFileName) throws Exception {
		if (resourcesNames == null) {
			resourcesNames = null;
			int[] arrayOfInt1 = null;
			int[] arrayOfInt2 = null;
			InputStream stream = B_MainMIDlet.midlet.getClass()
					.getResourceAsStream("/1.pak");
			DataInputStream resStream = new DataInputStream(
					stream);
			int i = resStream.readShort();
			int resLength = resStream.readShort();
			resourcesNames = new String[resLength];
			arrayOfInt1 = new int[resLength];
			arrayOfInt2 = new int[resLength];
			for (int k = 0; k < resLength; k++) {
				resourcesNames[k] = resStream.readUTF();
				arrayOfInt1[k] = (resStream.readInt() + i);
				arrayOfInt2[k] = resStream.readShort();
			}
			resourcesData = new byte[resourcesNames.length][];
			for (int m = 0; m < resourcesNames.length; m++) {
				resourcesData[m] = new byte[arrayOfInt2[m]];
				resStream.readFully(resourcesData[m]);
			}
			resStream.close();
		}
	}

	public static final byte[] getResourceData(String resName) {
		for (int i = 0; i < resourcesNames.length; i++) {
			if (resName.equals(resourcesNames[i])) {
				return resourcesData[i];
			}
		}
		return null;
	}

	public static final InputStream getResourceStream(String resName)
			throws Exception {
		return new ByteArrayInputStream(getResourceData(resName));
	}

	public final void commandAction(Command paramCommand,
			Displayable paramDisplayable) {
		B_MainMIDlet.midlet.notifyDestroyed();
	}

}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_e_034
 * 
 * JD-Core Version: 0.7.0.1
 */