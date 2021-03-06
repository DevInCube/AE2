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
	
	public static final Font font0 = Font.getFont(0, 1, 0);
	public static final Font font8 = Font.getFont(0, 1, 8);
	public static final int font8BaselinePos = font8.getBaselinePosition();
	public static final int someMenuShiftHeight = font8BaselinePos + 6;
	public static final int font0BaselinePos = font0.getBaselinePosition();
	public static final int var_139c = font0BaselinePos + 8;
	public static final short[] numericAndDelStartingChars = { 45, 43 }; //char 45='/' 43= '-' 44='.' 46='0' 57='9'
	public static final short[] numericEndChars = { 57, 57 };
	public static final byte[][] charFontsCharIndexes = {
			{ 10, 11, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
			{ 12, -1, 11, -1, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
	private static Display display;
	private boolean isRunning = false;
	private boolean isLoading = true;
	public A_MenuBase mainDrawElement;
	public static int canvasWidth;
	public static int canvasHeight;
	public int someActionsSum = 0;
	public int someActionSum2;
	public int someActionCode = 0;
	public long someActionStartTime;
	public static F_Sprite[] charsSprites = new F_Sprite[2];
	public static Random random = new Random();
	public static boolean[] settings = { true, true, true, true };
	public static String[] settingsNames;
	public boolean m_notifyUnkFlag = false;
	public static int musicPlayerId = -1;
	public static int musicLoopCount;
	public static boolean m_notifyShownMb = false;
	public static final String[] musicNames = { "main_theme", "bg_story",
			"bg_good", "bg_bad", "battle_good", "battle_bad", "victory",
			"gameover", "game_complete" };
	public static final byte[] someMusicByteArr = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	public static Player[] musicPlayers;
	public static Player currentMusicPlayer;
	public static boolean[] musicPlayersLoaded;
	public static int currentMusicId;
	public static int currentMusicLoopCount;
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

	public static final int getRandomMax(int max) {
		return getRandomWithin(0, max);
	}

	public static final int getRandomWithin(int min, int max) {
		return min + Math.abs(random.nextInt()) % (max - min);
	}

	public static final int getRandomInt() {
		return random.nextInt();
	}

	public static final byte[] getRecordStoreData(String recName, int recIndex)
			throws Exception {
		RecordStore store = RecordStore.openRecordStore(recName, false);
		byte[] recData = store.getRecord(recIndex + 1);
		store.closeRecordStore();
		return recData;
	}

	public static final void saveRecordStoreData(String recordName, int recIndex,
			byte[] data) throws Exception {
		RecordStore recStore = RecordStore.openRecordStore(recordName, true);
		int numRecs = recStore.getNumRecords();
		if (numRecs <= recIndex) {
			while (numRecs < recIndex) {
				recStore.addRecord(null, 0, 0);
				numRecs++;
			}
			recStore.addRecord(data, 0, data.length);
		} else {
			recStore.setRecord(recIndex + 1, data, 0, data.length);
		}
		recStore.closeRecordStore();
	}

	public static final int saveDataToStore(String storeName, byte[] data)
			throws Exception {
		RecordStore record = RecordStore.openRecordStore(storeName, true);
		int recordSize = record.addRecord(data, 0, data.length);
		record.closeRecordStore();
		return recordSize - 1;
	}

	public static final void deleteStoreRecordByIndex(String recName, int recIndex)
			throws Exception {
		RecordStore store = RecordStore.openRecordStore(recName, true);
		store.deleteRecord(recIndex + 1);
		store.closeRecordStore();
	}

	public static final int getRecordStoreAvailableSize(String recordName) {
		int size = 0;
		try {
			RecordStore locRecord = RecordStore.openRecordStore(recordName, true);
			size = locRecord.getSizeAvailable();
			locRecord.closeRecordStore();
		} catch (Exception ex) {
			//
		}
		return size;
	}

	public static final int getCharedStringWidth(byte charId, String str) {
		return charsSprites[charId].frameWidth * str.length();
	}

	public static final int getCharedStringHeight(byte charId) {
		return charsSprites[charId].frameHeight;
	}

	public static final void setColor(Graphics gr, int color) {
		gr.setColor(color);
	}

	public final void showNotify() {
		this.m_notifyUnkFlag = false;
		m_notifyShownMb = false;
		clearActions();
		if (this.mainDrawElement != null) {
			this.mainDrawElement.onLoad();
		}
	}

	public final void hideNotify() {
		clearActions();
		if (this.mainDrawElement != null) {
			if (!this.m_notifyUnkFlag) {
				m_notifyShownMb = true;
				if ((currentMusicPlayer != null) && (currentMusicPlayer.getState() == 400)
						&& (someMusicByteArr[currentMusicId] == 1)) {
					musicPlayerId = currentMusicId;
					musicLoopCount = currentMusicLoopCount;
				}
				stopMusic();
			}
			this.m_notifyUnkFlag = false;
		}
	}

	public static final void drawCharedString(Graphics gr,
			String inStr, int inX, int inY, int charInd, int paramInt4) {
		if ((paramInt4 & 0x8) != 0) {
			inX -= getCharedStringWidth((byte) charInd, inStr);
		} else if ((paramInt4 & 0x1) != 0) {
			inX -= getCharedStringWidth((byte) charInd, inStr) / 2;
		}
		if ((paramInt4 & 0x20) != 0) {
			inY -= getCharedStringHeight((byte) charInd);
		} else if ((paramInt4 & 0x2) != 0) {
			inY -= getCharedStringHeight((byte) charInd) / 2;
		}
		drawCharedString(gr, inStr, inX, inY, charInd);
	}

	public static final void drawCharedString(Graphics gr, String inStr, int inX, int inY, int charInt) {
		int mIt = 0;
		int nLength = inStr.length();
		while (mIt < nLength) {
			int ch = inStr.charAt(mIt);
			if (( ch >= numericAndDelStartingChars[charInt] ) && (ch <= numericEndChars[charInt])) {
				int frameIndex = charFontsCharIndexes[charInt][(ch - numericAndDelStartingChars[charInt])];
				if ( frameIndex != -1) {
					charsSprites[charInt].setCurrentFrameIndex(frameIndex);
					charsSprites[charInt].onSpritePaint(gr, inX, inY);
					inX += charsSprites[charInt].frameWidth;
				} else {
					byte[] charBytes = { (byte) ch };
					String str = new String(charBytes);
					gr.drawString(str, inX, inY, 20);
					inX += gr.getFont().stringWidth(str);
				}
			}
			mIt++;
		}
	}

	public static final void drawString(Graphics gr, String string, int centerX, int centerY, int anchor) {
		gr.drawString(string, centerX, centerY - 2, anchor);
	}

	public final void showMenu(A_MenuBase menu) {
		clearActions();
		menu.onLoad();
		this.mainDrawElement = menu;
	}

	public final void repaintAll() {
		repaint();
		serviceRepaints();
	}

	public final void paint(Graphics graphics) {
		if (this.isLoading) {
			graphics.setColor(16777215); //#FFFFFF
			graphics.fillRect(0, 0, canvasWidth, canvasHeight);
			graphics.setFont(font8);
			graphics.setColor(0);
			//LOADING...
			graphics.drawString(A_MenuBase.getLangString(58), canvasWidth / 2,
					canvasHeight / 2 - 1, 33);
			return;
		}
		this.mainDrawElement.onPaint(graphics);
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
		} catch (Exception ex) {
			//
		}
		return 4096;
	}

	public final String getKeyName2(int paramInt) {
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
		int actionCode = getGameAction(paramInt);
		addActionCode(actionCode);
		if (this.mainDrawElement != null) {
			this.mainDrawElement.sub_865(paramInt, actionCode);
		}
	}

	public final boolean isAnyActionPressed() {
		return this.someActionsSum != 0;
	}

	public final void clearActions() {
		this.someActionCode = 0;
		this.someActionsSum = 0;
		this.someActionSum2 = 0;
	}

	public final boolean invertActionCode(int code) {
		boolean isCodeInSum = (this.someActionSum2 & code) != 0;
		this.someActionSum2 &= (code ^ 0xFFFFFFFF);
		return isCodeInSum;
	}

	public final boolean someActionCodeIsSet(int actCode) {
		return (this.someActionsSum & actCode) != 0;
	}

	public final void keyReleased(int keyCode) {
		int actionCode = getGameAction(keyCode);
		clearActionCode(actionCode);
	}

	public final boolean isActionLongPressed(int actCode) {
		long timeElapsed = System.currentTimeMillis() - this.someActionStartTime;
		return (this.someActionCode == actCode) && (timeElapsed >= 400L);
	}

	public final void addActionCode(int code) {
		this.someActionCode = code;
		this.someActionStartTime = System.currentTimeMillis();
		this.someActionsSum |= code;
		this.someActionSum2 |= code;
	}

	public final void clearActionCode(int paramInt) {
		if (paramInt == this.someActionCode) {
			this.someActionCode = 0;
		}
		this.someActionsSum &= (paramInt ^ 0xFFFFFFFF);
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

	public static final void loadCharsSprites() throws Exception {
		charsSprites[0] = new F_Sprite("chars");
		charsSprites[1] = new F_Sprite("lchars");
	}

	public final void run() {
		try {
			repaintAll();
			settingsNames = new String[] { A_MenuBase.getLangString(26),
					A_MenuBase.getLangString(28), A_MenuBase.getLangString(25),
					A_MenuBase.getLangString(24) };
			
			I_Game aGame = new I_Game();
			repaintAll();
			this.mainDrawElement = aGame;
			this.isLoading = false;
			this.isRunning = true;
			aGame.runLoading();
			while (this.isRunning) {
				long time = System.currentTimeMillis();
				if ((isShown()) && (!m_notifyShownMb)) {
					if (musicPlayerId >= 0) {
						playMusicLooped(musicPlayerId, musicLoopCount);
						if ((currentMusicPlayer != null) && (currentMusicPlayer.getState() == 400)) {
							musicPlayerId = -1;
						}
					}
					this.mainDrawElement.onUpdate();
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

	public static final void vibrate(int val) {
		try {
			if (settings[1] != false) {
				display.vibrate(val * 4);
			}
			return;
		} catch (Exception ex) {
			//
		}
	}

	public static final void initMusicVars() {
		musicPlayers = new Player[musicNames.length];
		musicPlayersLoaded = new boolean[musicNames.length];
	}

	public static final void loadMusic(int musicId) {
		try {
			musicPlayersLoaded[musicId] = false;
			InputStream stream = getResourceStream(musicNames[musicId]
					+ ".mid");
			musicPlayers[musicId] = Manager.createPlayer(stream,
					"audio/midi");
			musicPlayers[musicId].realize();
			musicPlayers[musicId].prefetch();
			musicPlayersLoaded[musicId] = true;
			return;
		} catch (Exception ex) {
			//
		}
	}

	public static final void playMusicLooped2(int paramInt1, int paramInt2) {
		playMusicLooped(paramInt1, paramInt2);
	}

	public static final void stopMusic() {
		try {
			if (currentMusicPlayer != null) {
				currentMusicPlayer.stop();
				currentMusicPlayer = null;
				currentMusicId = -1;
			}
			return;
		} catch (Exception ex) {
			//
		}
	}

	public static final void playMusicLooped(int musicId, int loopCount) {
		try {
			if (musicPlayersLoaded[musicId] == false) {
				return;
			}
			if (currentMusicPlayer != null) {
				currentMusicPlayer.stop();
			}
			if ((someMusicByteArr[musicId] == 1) && (settings[0] != false)) {
				if (loopCount == 0) {
					loopCount = -1;
				}
				if (m_notifyShownMb) {
					musicPlayerId = musicId;
					musicLoopCount = loopCount;
				} else {
					currentMusicPlayer = musicPlayers[musicId];
					currentMusicPlayer.setLoopCount(loopCount);
					currentMusicPlayer.start();
					currentMusicId = musicId;
					currentMusicLoopCount = loopCount;
				}
			}
			return;
		} catch (Exception ex) {
			//
		}
	}

	public static final void stopMusicPlayer(int index) {
		try {
			if (musicPlayersLoaded[index] == false) {
				return;
			}
			if (currentMusicPlayer == musicPlayers[index]) {
				currentMusicPlayer.stop();
				currentMusicPlayer = null;
				currentMusicId = -1;
			}
			return;
		} catch (Exception ex) {
			//
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
	
	public final void showMsg(String msg, I_Game game){
		D_Menu dialog = new D_Menu((byte) 10, 12);
		dialog.createDescDialogMb(null, msg, this.canvasWidth, -1);
		dialog.parentMenu = game;
		dialog.var_10c5 = 500;
		dialog.setMenuLoc(this.canvasWidth >> 1, this.canvasHeight >> 1, 3);
		this.showMenu(dialog);
	}

}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_e_034
 * 
 * JD-Core Version: 0.7.0.1
 */