import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class I_Game extends A_MenuBase implements Runnable {
	
	public String appPropVersion = "?";
	public static byte var_32c3 = 32;
	public int someGWidth;
	public int someGHeight;
	public int viewportWidth;
	public int viewportHeight;
	public int unlockedScenarioLevelsCount = 0;
	public static String[] skirmishMapsNames = new String[12];
	public static int[] var_32fb = { 4, 5, 6, 7, 8, 9, 10, 11 };
	public boolean[] var_3303;
	public static final short[] skirmishStartMoneyEnum = { 500, 1000, 2000 };
	public static final short[] skirmishStartUnitsEnum = { 10, 20, 25 };
	public int mapStartMoney;
	public int mapStartUnitCap;
	public byte mapModeCampIf0;
	public static int var_3333 = 1024;
	public static int var_333b = 2048;
	public String[] gameMenuItemsNames = { A_MenuBase.getLangString(66),
			A_MenuBase.getLangString(70), A_MenuBase.getLangString(71),
			A_MenuBase.getLangString(4), A_MenuBase.getLangString(60) };
	public String[] unitActionsNames = { A_MenuBase.getLangString(63),
			A_MenuBase.getLangString(67), A_MenuBase.getLangString(68),
			A_MenuBase.getLangString(62), A_MenuBase.getLangString(69),
			A_MenuBase.getLangString(61), A_MenuBase.getLangString(64) };
	public H_ImageExt[] actionIconsFrames;
	public String[] mainMenuItemsNames = { A_MenuBase.getLangString(1),
			A_MenuBase.getLangString(2), A_MenuBase.getLangString(5),
			A_MenuBase.getLangString(3), A_MenuBase.getLangString(6),
			A_MenuBase.getLangString(8), A_MenuBase.getLangString(7),
			A_MenuBase.getLangString(9), A_MenuBase.getLangString(10),
			A_MenuBase.getLangString(11), A_MenuBase.getLangString(4) };
	public H_ImageExt[] menuIconsFrames;
	public String[] playerSkirmishChoicesNames = { A_MenuBase.getLangString(35),
			A_MenuBase.getLangString(36), A_MenuBase.getLangString(37) };
	public String[] onOffValuesNames = { A_MenuBase.getLangString(29),
			A_MenuBase.getLangString(30) };
	public byte[] var_337b = { 0, 6, 5, 7, 8, 9 };
	public byte[] var_3383 = { 0, 6, 5, 7, 8, 9 };
	public byte[] var_338b = { 1, 2, 3, 4 };
	public static final byte[][] cursorFrameSequences = { { 0, 1 }, { 2, 3, 4 }, { 0, 1 },
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
	public static final int[] playerColors = { 10526880, 26054, 15204434, 39473,
			16754 };
	public static final int[] var_33c3 = { -1, 2, 3, 2, 3 };
	public static final int[] var_33cb = { -1, 4, 5, 4, 5 };
	public F_Sprite[][] playersUnitsSprites;
	public static final byte[] var_33db = { 1, 2 };
	public static final byte[] var_33e3 = { 0, 5, 10, 10, 15, 0, 5, 15, 15, 15 };
	public static final byte[] var_33eb = { 1, 1, 2, 2, 3, 3, 1, 1, 1, 1 };
	public int houseTileIdStartIndex;
	public H_ImageExt[] smallTilesImages;
	public byte[] tilesProps;
	public int var_340b;
	public int var_3413;
	public int var_341b;
	public int var_3423;
	public int mapWidth;
	public int mapHeight;
	private H_ImageExt tombstoneSprite;
	public H_ImageExt[] allTilesImages;
	public F_Sprite cursorSprite;
	public F_Sprite var_3453;
	public F_Sprite sideArrowSprite;
	public F_Sprite arrowSprite;
	public F_Sprite buttonsSprite;
	public F_Sprite menuSprite;
	public F_Sprite smokeSprite;
	public F_Sprite sparkSprite;
	public F_Sprite redsparkSprite;
	public F_Sprite statusSprite;
	public F_Sprite smallSparkSprite;
	public F_Sprite portraitsSprite;
	public int var_34ab;
	public int var_34b3;
	public byte[][] mapTilesIds;
	public byte activeUnitState;
	public byte var_34cb;
	public long time;
	public int scenarioMapIndex;
	public int var_34e3;
	public int var_34eb;
	public C_Unit[] var_34f3;
	public C_Unit activeUnit;
	public int var_3503;
	public int var_350b;
	public byte[][] someMapData;
	public boolean var_351b = false;
	public boolean var_3523 = false;
	public boolean isCursorVisible = true;
	public Vector mapUnitsSprites = new Vector();
	public Vector var_353b;
	public int var_3543;
	public int var_354b;
	public long someStartTime5;
	public byte mapMaxPlayersMb = 2;
	public byte[] var_3563 = new byte[5];
	public byte[] playersIndexes = new byte[4];
	public byte[] var_3573 = new byte[4];
	public byte playerId = 0;
	public short currentTurn;
	public C_Unit[] playersKings;
	public C_Unit[][] var_3593;
	public int[] var_359b;
	public int[] var_35a3 = new int[4];
	public byte[][] kingsPositions = new byte[4][2];
	public byte[] var_35b3 = new byte[4];
	public D_Menu someGameMenu;
	public Vector var_35c3 = new Vector();
	public Vector var_35cb = new Vector();
	public C_Unit dyingUnit;
	public C_Unit var_35db;
	public long var_35e3;
	public C_Unit var_35eb;
	public byte var_35f3;
	public long var_35fb;
	public int var_3603;
	public boolean canCancelMb = false;
	public boolean canApplyMb = false;
	public byte gameMode2Mb = 4;
	public H_ImageExt msLogoImage;
	public H_ImageExt splashImage;
	public H_ImageExt logoImage;
	public H_ImageExt glowImage;
	public int introMode;
	public boolean var_364b = false;
	public int waveImageAmplitude;
	public int var_365b;
	public int var_366b;
	public long var_3673;
	public C_Unit attackerUnitMb;
	public C_Unit attackedUnitMb;
	public boolean var_368b = true;
	public long var_3693;
	public boolean var_369b = false;
	public long var_36a3;
	public int var_36ab;
	public int var_36b3;
	public H_ImageExt[] var_36bb;
	public boolean isBlackLoading = false;
	public boolean showPressAnyKey;
	public static int[] var_36d3 = { 83, 83, 83, 83, 83, 83, 83, 83, 175, 84,
			84, 84, 175, 147, 159, 151, 155, 167, 171 };
	public int helpTipId = -1;
	public D_Menu instructionsMenu;
	public D_Menu instructionsItemsMenu;
	public D_Menu instructionsDescMenu;
	public D_Menu startupMessageBox;
	public int var_3703 = 8;
	public D_Menu var_370b;
	public D_Menu var_3713;
	public D_Menu selectLevelMenu;
	public boolean var_3723 = false;
	public int var_372b;
	public byte[][] housesDataArr;
	public byte[][] var_373b;
	public F_Sprite bigCircleSprite;
	public F_Sprite smallCircleSprite;
	public C_Unit var_3753;
	public F_Sprite hudIconsSprite;
	public F_Sprite hudIcons2Sprite;
	public int someMenuWidth;
	public int someMenuHeight;
	public int glowImagePosX;
	public boolean isUpdatingMb = true;
	public int var_378b;
	public boolean var_3793;
	public F_Sprite miniIconsSprite;
	public F_Sprite[] houseSmokeSprites;
	public F_Sprite bigSmokeSprite;
	public D_Menu skirmishSetupMenu;
	public D_Menu playerOptionsMenu;
	public D_Menu chooseMoneyItemsMenu;
	public D_Menu chooseUnitCapItemsMenu;
	public D_Menu[] choosePlayerMenuList;
	public D_Menu[] chooseTeamMenuList;
	public D_Menu settingsMenu;
	public D_Menu[] settingsMenuList;
	public F_Sprite alphaMapSprite;
	public int fadeInColor;
	public boolean isFadingIn;
	public boolean var_380b;
	public boolean isFading;
	public Vector gotNewLevelUnits = new Vector(2);
	public F_Sprite levelupSprite;
	public int var_382b;
	public F_Sprite[] kingHeadsSprites;
	public D_Menu castleBuyMenu;
	public D_Menu castleBuyUnitMenu;
	public D_Menu castleBuyAllUnitsMenu;
	public D_Menu castleBuyDescMenu;
	public F_Sprite arrowIconsSprite;
	public F_Sprite var_3863;
	public C_Unit var_386b;
	public int var_3873 = 0;
	public boolean var_387b = true;
	public boolean var_3883;
	public String mapName;
	public String[] slotsDescriptions;
	public byte[] slotsCurrentPlayerIds;
	public int[] slotsMapIndexes;
	public D_Menu loadSlotsMenu;
	public D_Menu saveSlotsMenu;
	public D_Menu var_38bb;
	public D_Menu var_38c3;
	public D_Menu mainMenuMb;
	public D_Menu warningEndGameMenu;
	public D_Menu warningDialog;
	public byte mapTeamsCount;
	public byte[] somePlayerIds;
	public int var_38f3;
	public String[] var_38fb;
	public int[] var_3903;
	public String[] onlineMenuItemsNames = { A_MenuBase.getLangString(46),
			A_MenuBase.getLangString(47) };
	public String[] downloadMenuItemsNames = { A_MenuBase.getLangString(48),
			A_MenuBase.getLangString(49) };
	public D_Menu someOnlineMenu;
	public D_Menu onlineMenu;
	public D_Menu newsItemsMenu;
	public D_Menu deleteMapMenu;
	public D_Menu mapDeletingMenu;
	public D_Menu var_3943;
	public D_Menu downloadItemsMenu;
	public D_Menu downloadMenu;
	public int var_395b;
	public String deletingMapName;
	public int downloadStoreAvailableSize;
	public boolean appPropHightscoreUpload = true;
	public boolean var_397b = true;
	public boolean var_3983 = true;
	public H_ImageExt gameOverImage;
	public Image[][] alphaMappedTilesImages;
	public int loadingProgress;
	public static final String[] var_39a3 = { "14281428", "18241824" };
	public StringBuffer m_strBuf = new StringBuffer();
	public C_Unit var_39b3;
	public int var_39bb = 12;
	public int var_39c3 = 1;
	public boolean var_39cb;
	public int alphaWindowWTF;
	public int var_39db;
	public int var_39e3;
	public int var_39eb;
	public int var_39f3;
	public H_ImageExt introImage;
	public String[] introText;
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
	public C_Unit var_3a83;
	public C_Unit var_3a8b;
	public C_Unit var_3a93;
	public int var_3a9b;
	public long aSomeOtherTime;
	public C_Unit[] var_3aab;
	public C_Unit[] var_3ab3;
	public byte[] var_3abb;
	public int[][] var_3ac3;
	public int[] var_3acb;
	public int var_3ad3;
	public byte[][] var_3adb;
	public int mapCastlesCount;
	public int var_3aeb;
	public int var_3af3;
	public int var_3afb;
	public int var_3b03;
	public Vector var_3b0b;
	public boolean var_3b13 = false;
	public int waitTimeValue;
	public D_Menu mapNameDialog;
	public C_Unit skeleton1Map2;
	public C_Unit crystalOfWisdom;
	public C_Unit skeleton2Map2;
	public C_Unit wisdomCrystalKeeper;
	public C_Unit var_3b4b;
	public C_Unit unitEndTurnMb;
	public int scriptStep;
	public long var_3b63;
	public int var_3b6b;
	public boolean isWaiting = false;
	public boolean var_3b7b = false;
	public int cameraX = -1;
	public int cameraY = -1;
	public int var_3b93 = 0;
	public G_FightAnimation var_3b9b;
	public G_FightAnimation var_3ba3;
	public long someStartTime2;
	public boolean var_3bb3;
	public Vector gameSprites = new Vector();
	public boolean var_3bc3 = false;
	public long someMaxTime;
	public long someStartTime;
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
	public int[] someSizesMb;
	public String appPropPortalCode = "Macrospace";
	public String appPropGameCode = "msaeii";
	public String appPropUrl = "http://msaeii.scores.macrospace.com/connectx/in";
	private ByteArrayOutputStream m_baos;
	private DataOutputStream m_dos;
	public int var_3c6b;
	public boolean var_3c73;
	public A_MenuBase var_3c7b;
	public int var_3c83;

	public I_Game() {
		this.actionIconsFrames = new H_ImageExt[this.unitActionsNames.length];
		this.menuIconsFrames = new H_ImageExt[this.mainMenuItemsNames.length];
		this.houseSmokeSprites = new F_Sprite[0];
		this.var_39b3 = null;
		this.var_3b4b = null;
		this.unitEndTurnMb = null;
	}

	public final void runLoading() throws Exception {
		setLoadingProgress(0);
		E_MainCanvas.loadResourcesPak("");
		setLoadingProgress(18);
		E_MainCanvas.initMusicVars();
		for (int i = 0; i < E_MainCanvas.musicNames.length; i++) {
			E_MainCanvas.loadMusic(i);
			setLoadingProgress(19 + i);
		}
		setLoadingProgress(28);
		D_Menu.gameVar = this;
		setLoadingProgress(29);
		A_MenuBase.initSin1024();
		setLoadingProgress(30);
		E_MainCanvas.loadCharsSprites();
		setLoadingProgress(32);
		this.actionIconsFrames = new F_Sprite("action_icons").frameImages;
		setLoadingProgress(34);
		this.menuIconsFrames = new F_Sprite("menu_icons").frameImages;
		setLoadingProgress(36);
		this.hudIconsSprite = new F_Sprite("hud_icons");
		setLoadingProgress(38);
		this.hudIcons2Sprite = new F_Sprite("hud_icons_2");
		setLoadingProgress(40);
		this.arrowSprite = new F_Sprite("arrow");
		setLoadingProgress(42);
		this.sideArrowSprite = new F_Sprite("side_arrow");
		setLoadingProgress(44);
		this.buttonsSprite = new F_Sprite("buttons");
		setLoadingProgress(46);
		this.menuSprite = new F_Sprite("menu");
		setLoadingProgress(48);
		this.bigCircleSprite = new F_Sprite("big_circle");
		setLoadingProgress(50);
		this.smallCircleSprite = new F_Sprite("small_circle");
		setLoadingProgress(52);
		this.smallSparkSprite = new F_Sprite("small_spark");
		setLoadingProgress(54);
		this.alphaMapSprite = new F_Sprite("alpha");
		setLoadingProgress(56);
		try {
			this.gameOverImage = new H_ImageExt("gameover");
		} catch (Exception ex1) {
			//
		}
		setLoadingProgress(58);
		this.msLogoImage = new H_ImageExt("ms_logo");
		setLoadingProgress(62);
		DataInputStream tilesStream = new DataInputStream(
				E_MainCanvas.getResourceStream("tiles0.prop"));
		int tilesStreamLength = tilesStream.readShort();
		tilesStream.readShort();
		this.tilesProps = new byte[tilesStreamLength];
		for (int k = 0; k < tilesStreamLength; k++) {
			this.tilesProps[k] = tilesStream.readByte();
		}
		tilesStream.close();
		setLoadingProgress(64);
		F_Sprite smallTiles0Sprite = new F_Sprite("stiles0");
		this.smallTilesImages = smallTiles0Sprite.frameImages;
		setLoadingProgress(70);
		this.miniIconsSprite = new F_Sprite("mini_icons");
		setLoadingProgress(72);
		this.houseTileIdStartIndex = 37;
		this.someGWidth = this.someCanWidth;
		this.someGHeight = this.someCanHeight;
		this.viewportWidth = (this.someGWidth >> 1);
		this.viewportHeight = (this.someGHeight >> 1);
		this.introMode = 0;
		for (int m = 0; m < 12; m++) {
			skirmishMapsNames[m] = A_MenuBase.getLangString(101 + m);
		}
		loadSettings();
		setLoadingProgress(74);
		try {
			this.unlockedScenarioLevelsCount = E_MainCanvas.getRecordStoreData("settings", 1)[0];
		} catch (Exception ex2) {
			//
		}
		setLoadingProgress(76);
		this.var_38fb = new String[0];
		this.var_3903 = new int[0];
		try {
			byte[] arrayOfByte = E_MainCanvas.getRecordStoreData("settings", 2);
			DataInputStream stream1 = new DataInputStream(
					new ByteArrayInputStream(arrayOfByte));
			this.var_38f3 = stream1.readInt();
			this.var_3903 = new int[this.var_38f3];
			this.var_38fb = new String[this.var_38f3];
			for (int i1 = 0; i1 < this.var_38f3; i1++) {
				this.var_3903[i1] = stream1.readInt();
				this.var_38fb[i1] = stream1.readUTF();
			}
			stream1.close();
		} catch (Exception ex3) {
			//
		}
		setLoadingProgress(80);
		this.downloadStoreAvailableSize = E_MainCanvas.getRecordStoreAvailableSize("download");
		setLoadingProgress(84);
		this.slotsDescriptions = new String[3];
		this.slotsCurrentPlayerIds = new byte[3];
		this.slotsMapIndexes = new int[3];
		byte[] saveData;
		for (int n = 0; n < 3; n++) {
			this.slotsCurrentPlayerIds[n] = -1;
			this.slotsMapIndexes[n] = -1;
			saveData = null;
			try {
				saveData = E_MainCanvas.getRecordStoreData("save", n);
			} catch (Exception ex4) {
				//
			}
			if ((saveData == null) || (saveData.length == 0)) {
				this.slotsDescriptions[n] = ("\n" + A_MenuBase.getLangString(79) + "\n "); //NO SAVED GAMES
			} else {
				DataInputStream slotDataStream = new DataInputStream(
						new ByteArrayInputStream((byte[]) saveData));
				int mapMode = slotDataStream.readByte();
				int mapIndex = slotDataStream.readByte();
				slotDataStream.readByte();
				slotDataStream.readByte();
				byte currentPlayerId = slotDataStream.readByte();
				int currentTurn = slotDataStream.readShort();
				slotDataStream.close();
				this.slotsCurrentPlayerIds[n] = currentPlayerId;
				this.slotsDescriptions[n] = getSlotDescription(mapMode, mapIndex, currentTurn);
				this.slotsMapIndexes[n] = mapIndex;
			}
		}
		setLoadingProgress(90);
		int msSkPos = 0;
		String appProperty;
		if ((appProperty = B_MainMIDlet.midlet
				.getAppProperty("ProvisionX-Highscore-gameCode")) != null) {
			this.appPropGameCode = ((String) appProperty).trim();
		}
		if ((appProperty = B_MainMIDlet.midlet
				.getAppProperty("ProvisionX-Highscore-portalCode")) != null) {
			this.appPropPortalCode = ((String) appProperty).trim();
		}
		if ((appProperty = B_MainMIDlet.midlet
				.getAppProperty("ProvisionX-Highscore-Url")) != null) {
			this.appPropUrl = ((String) appProperty).trim();
		}
		if ((appProperty = B_MainMIDlet.midlet
				.getAppProperty("ms-highscoreUpload")) != null) {
			this.appPropHightscoreUpload = (Integer.parseInt(((String) appProperty).trim()) == 1);
		}
		if ((appProperty = B_MainMIDlet.midlet.getAppProperty("ms-skPos")) != null) {
			msSkPos = Integer.parseInt(((String) appProperty).trim());
		}
		if ((appProperty = B_MainMIDlet.midlet
				.getAppProperty("MIDlet-Version")) != null) {
			this.appPropVersion = ((String) appProperty).trim();
		}
		setLoadingProgress(96);
		if (msSkPos == 1) {
			var_3333 = 2048;
			var_333b = 1024;
		}
		setLoadingProgress(100);
		E_MainCanvas.playMusicLooped(0, 0);
		this.gameMode2Mb = 0;
	}

	public final void setLoadingProgress(int value) {
		this.loadingProgress = value;
		A_MenuBase.mainCanvas.repaintAll();
	}

	public final String getSlotDescription(int campaignModeIf0, int mapIndex, int currentTurn) {
		String mapName;
		if (campaignModeIf0 == 0) {
			mapName = A_MenuBase.getLangString(121 + mapIndex);
		} else {
			mapName = getSkirmishMapName(mapIndex);
		}
		String mode = A_MenuBase.getLangString(32 + campaignModeIf0);
		return  mode + "\n" + mapName + "\n"
				+ "Current turn: " + (currentTurn + 1); // slot description
	}

	public final boolean sub_4789() {
		return (this.isUpdatingMb) && (A_MenuBase.mainCanvas.mainDrawElement == this);
	}

	public final void checkResources() throws Exception {
		this.msLogoImage = null;
		this.splashImage = null;
		this.logoImage = null;
		this.glowImage = null;
		System.gc();
		this.someGHeight = (this.someCanHeight - var_32c3);
		this.viewportHeight = (this.someGHeight >> 1);
		E_MainCanvas.stopMusic();
		if (this.gameMode2Mb == 1) {
			return;
		}
		this.gameMode2Mb = 1;
		C_Unit.sub_2745(this);
		E_MainCanvas.loadResourcesPak("/1.pak");
		this.playersUnitsSprites = new F_Sprite[5][12];
		F_Sprite sprite1;
		for (byte playerIndex = 0; playerIndex < 5; playerIndex = (byte) (playerIndex + 1)) {
			sprite1 = new F_Sprite("unit_icons", playerIndex);
			int j = sprite1.getFramesCount() / 12;
			for (int unitTypeId = 0; unitTypeId < 12; unitTypeId = (byte) (unitTypeId + 1)) {
				H_ImageExt[] image;
				if (playerIndex == 0) {
					image = new H_ImageExt[] { sprite1.frameImages[unitTypeId] };
					this.playersUnitsSprites[playerIndex][unitTypeId] = new F_Sprite(image);
				} else {
					image = new H_ImageExt[j];
					for (int k = 0; k < j; k++) {
						image[k] = sprite1.frameImages[(k * 12 + unitTypeId)];
					}
					this.playersUnitsSprites[playerIndex][unitTypeId] = new F_Sprite(image);
				}
			}
		}
		F_Sprite tilesSprite = new F_Sprite("tiles0");
		H_ImageExt[] tilesImages = tilesSprite.frameImages;
		this.houseTileIdStartIndex = tilesImages.length;
		H_ImageExt[] buildingsImages = new H_ImageExt[10];
		F_Sprite spr1;
		for (byte b = 0; b <= 4; b = (byte) (b + 1)) {
			spr1 = new F_Sprite("buildings", b);
			for (int i = 0; i < 2; i = (byte) (i + 1)) {
				buildingsImages[(b * 2 + i)] = spr1.frameImages[i];
			}
		}
		this.allTilesImages = new H_ImageExt[tilesImages.length
				+ buildingsImages.length];
		System.arraycopy(tilesImages, 0, this.allTilesImages, 0,
				tilesImages.length);
		System.arraycopy(buildingsImages, 0, this.allTilesImages, this.houseTileIdStartIndex,
				buildingsImages.length);
		this.alphaMappedTilesImages = new Image[2][this.allTilesImages.length];
		for (byte alphaId = 0; alphaId < 2; alphaId = (byte) (alphaId + 1)) {
			for (byte tileId = 0; tileId < this.allTilesImages.length; tileId = (byte) (tileId + 1)) {
				Image img = Image.createImage(24, 24);
				this.alphaMappedTilesImages[alphaId][tileId] = img;
				Graphics graphics = img.getGraphics();
				this.allTilesImages[tileId].drawImageExt(graphics, 0, 0);
				this.alphaMapSprite.drawFrameAt(graphics, alphaId, 0, 0, 0);
			}
		}
		this.portraitsSprite = new F_Sprite("portraits");
		this.cursorSprite = new F_Sprite("cursor");
		this.redsparkSprite = new F_Sprite("redspark");
		this.smokeSprite = new F_Sprite("smoke");
		this.sparkSprite = new F_Sprite("spark");
		this.statusSprite = new F_Sprite("status");
		this.arrowIconsSprite = new F_Sprite("arrow_icons");
		this.tombstoneSprite = new H_ImageExt("tombstone");
		this.levelupSprite = new F_Sprite("levelup");
		this.kingHeadsSprites = new F_Sprite[2];
		this.kingHeadsSprites[0] = new F_Sprite("king_head_icons");
		this.kingHeadsSprites[1] = new F_Sprite("king_head_icons", (byte) 0);
		this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
		this.var_3453 = new F_Sprite(this.cursorSprite);
		this.var_3453.setFrameSequence(cursorFrameSequences[3]);
		this.var_36bb = new H_ImageExt[2];
		this.var_36b3 = var_33db[0];
		this.var_36bb[0] = this.allTilesImages[var_33db[0]];
		this.var_36bb[1] = this.allTilesImages[var_33db[1]];
		this.bigSmokeSprite = new F_Sprite("b_smoke");
	}

	public final void sub_4bfe(int paramInt1, int paramInt2) {
		if ((this.mapModeCampIf0 == 0) && (this.gameMode2Mb == 1)
				&& (this.activeUnitState == 0)) {
			int i = 0;
			this.m_strBuf.append(paramInt2);
			String str = this.m_strBuf.toString();
			for (int j = 0; j < var_39a3.length; j++) {
				if (str.equals(var_39a3[j])) {
					if (j == 0) {
						if (this.scenarioMapIndex == 7) {
							this.var_3883 = true;
						} else {
							missionComplete();
						}
					} else if (j == 1) {
						this.var_35a3[this.playerId] += 1000;
					}
					this.var_397b = true;
				} else if (var_39a3[j].startsWith(str)) {
					i = 1;
				}
			}
			if (i == 0) {
				this.m_strBuf = new StringBuffer();
			}
		}
	}

	public final void sub_4d3f() {
		this.var_397b = true;
		this.var_3983 = true;
		this.var_3bf3 = true;
		this.var_3beb = true;
	}

	public final byte[] saveMapDataBytes() throws Exception {
		this.kingsPositions[this.playerId][0] = ((byte) this.var_34ab);
		this.kingsPositions[this.playerId][1] = ((byte) this.var_34b3);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream stream = new DataOutputStream(
				baos);
		stream.writeByte(this.mapModeCampIf0);
		stream.writeByte(this.scenarioMapIndex);
		stream.writeByte(this.mapMaxPlayersMb);
		stream.writeByte(this.playerId);
		stream.writeByte(this.playersIndexes[this.playerId]);
		stream.writeShort(this.currentTurn);
		stream.writeByte(this.var_3703);
		stream.writeByte(this.mapMaxPlayersMb);
		for (int i = 0; i < this.mapMaxPlayersMb; i++) {
			stream.writeByte(this.var_3573[i]);
			stream.writeByte(this.var_35b3[i]);
			stream.writeShort(this.var_35a3[i]);
			stream.writeByte(this.kingsPositions[i][0]);
			stream.writeByte(this.kingsPositions[i][1]);
		}
		stream.writeByte(this.mapStartUnitCap);
		for (int i = 0; i < this.housesDataArr.length; i++) {
			stream
					.writeByte(this.mapTilesIds[this.housesDataArr[i][0]][this.housesDataArr[i][1]]);
		}
		stream.writeByte(this.mapUnitsSprites.size());
		int i = 0;
		int mapSpritesLength = this.mapUnitsSprites.size();
		while (i < mapSpritesLength) {
			C_Unit unit = (C_Unit) this.mapUnitsSprites
					.elementAt(i);
			stream.writeByte(unit.unitTypeId);
			stream.writeByte(unit.playerId);
			stream.writeByte(unit.m_state);
			stream.writeByte(unit.status);
			stream.writeByte(unit.unitHealthMb);
			stream.writeByte(unit.level);
			stream.writeShort(unit.experience);
			stream.writeShort(unit.positionX);
			stream.writeShort(unit.positionY);
			stream.writeByte(unit.var_b5b);
			stream.writeByte(unit.var_b63);
			if (unit.unitTypeId == 9) {
				stream.writeByte(unit.var_b7b);
				stream.writeShort(unit.cost);
				stream
						.writeByte(this.playersKings[unit.playerId] == unit ? 1
								: 0);
			}
			i++;
		}
		stream.writeShort((short) this.scriptStep);
		stream.writeInt((short) (int) this.var_3b63);
		stream.writeInt(this.var_3b6b);
		stream.writeByte(this.isWaiting ? 0 : 1);
		byte[] arrayOfByte = baos.toByteArray();
		stream.close();
		return arrayOfByte;
	}

	public final void loadMapDataBytes(byte[] data) throws Exception {
		DataInputStream stream = new DataInputStream(
				new ByteArrayInputStream(data));
		this.mapModeCampIf0 = stream.readByte();
		this.scenarioMapIndex = stream.readByte();
		this.mapMaxPlayersMb = stream.readByte();
		loadMap(this.scenarioMapIndex);
		this.playerId = stream.readByte();
		stream.readByte();
		this.currentTurn = stream.readShort();
		this.var_3703 = stream.readByte();
		this.mapMaxPlayersMb = stream.readByte();
		for (int i = 0; i < this.mapMaxPlayersMb; i++) {
			this.var_3573[i] = stream.readByte();
			this.var_35b3[i] = stream.readByte();
			this.var_35a3[i] = stream.readShort();
			this.kingsPositions[i][0] = stream.readByte();
			this.kingsPositions[i][1] = stream.readByte();
		}
		this.mapStartUnitCap = stream.readByte();
		for (int i = 0; i < this.housesDataArr.length; i++) {
			this.mapTilesIds[this.housesDataArr[i][0]][this.housesDataArr[i][1]] = stream
					.readByte();
		}
		this.var_3593 = new C_Unit[this.mapMaxPlayersMb][4];
		this.var_359b = new int[this.mapMaxPlayersMb];
		sub_87e6();
		int j = 0;
		int length =  stream.readByte();
		while (j < length) {
			byte uType = stream.readByte();
			byte b2 = stream.readByte();
			byte b3 = stream.readByte();
			byte b4 = stream.readByte();
			int m = stream.readByte();
			byte b5 = stream.readByte();
			int n = stream.readShort();
			int i1 = stream.readShort();
			int i2 = stream.readShort();
			byte b6 = stream.readByte();
			byte b7 = stream.readByte();
			C_Unit lUnit = C_Unit.createUnitOnMap(uType, b2, i1, i2);
			lUnit.m_state = b3;
			lUnit.experience = n;
			lUnit.setUnitLevel(b5);
			lUnit.status = b4;
			lUnit.calcStatusEffect();
			lUnit.unitHealthMb = ((short) m);
			lUnit.var_b5b = b6;
			lUnit.var_b63 = b7;
			if (uType == 9) {
				byte kingNameId = stream.readByte();
				short kingCost = stream.readShort();
				lUnit.setKingName(kingNameId);
				lUnit.cost = kingCost;
				byte i5 = stream.readByte();
				if (i5 == 1) {
					this.playersKings[lUnit.playerId] = lUnit;
				}
			}
			j++;
		}
		this.scriptStep = stream.readShort();
		this.var_3b63 = stream.readInt();
		this.var_3b6b = stream.readInt();
		this.isWaiting = (stream.readByte() != 0);
		stream.close();
		if ((this.scenarioMapIndex == 6) && (this.scriptStep > 32)) {
			this.startupMessageBox = createDialog(A_MenuBase.getLangString(121 + this.scenarioMapIndex),
					A_MenuBase.getLangString(138), this.someGHeight, -1);
			this.startupMessageBox.setMenuActionEnabled((byte) 0, true);
			this.startupMessageBox.setParentMenu(null);
		}
		int cposx = this.kingsPositions[this.playerId][0];
		int cposy = this.kingsPositions[this.playerId][1];
		moveCursorToPos(cposx, cposy);
		sub_b9c5(cposx, cposy);
		E_MainCanvas.playMusicLooped2(var_33c3[this.playersIndexes[this.playerId]], 0);
	}

	public final void saveToSlotMenuShow(int paramInt, A_MenuBase parentMenu) {
		try {
			E_MainCanvas.saveRecordStoreData("save", paramInt, saveMapDataBytes());
			this.slotsDescriptions[paramInt] = getSlotDescription(this.mapModeCampIf0, this.scenarioMapIndex,
					this.currentTurn);
			this.slotsCurrentPlayerIds[paramInt] = this.playersIndexes[this.playerId];
			this.slotsMapIndexes[paramInt] = this.scenarioMapIndex;
			this.var_38c3.createDescDialogMb(null, this.slotsDescriptions[paramInt],
					this.someGWidth, -1);
			this.var_38c3.titleGradientColor = playerColors[this.slotsCurrentPlayerIds[paramInt]];
			this.var_38c3.onLoad();
			D_Menu dialog = createDialog(null, A_MenuBase.getLangString(77),
					this.someGHeight, 1000); // GAME SAVED
			dialog.parentMenu = parentMenu;
			A_MenuBase.mainCanvas.showMenu(dialog);
			return;
		} catch (Exception ex) {
			//
		}
	}

	public static final void loadSettings() {
		try {
			byte[] settingsBytes = E_MainCanvas.getRecordStoreData("settings", 0);
			for (int i = 0; i < 4; i++) {
				E_MainCanvas.settings[i] = ((settingsBytes[0] & 1 << i) != 0 ? true
						: false);
			}
			return;
		} catch (Exception ex) {
			//
		}
	}

	public final void saveSettings() {
		try {
			byte[] settinsBytes = new byte[1];
			for (int i = 0; i < 4; i++) {
				if (E_MainCanvas.settings[i] != false) {
					int tmp21_20 = 0;
					byte[] tmp21_19 = settinsBytes;
					tmp21_19[tmp21_20] = ((byte) (tmp21_19[tmp21_20] | 1 << i));
				}
			}
			E_MainCanvas.saveRecordStoreData("settings", 0, settinsBytes);
			return;
		} catch (Exception ex) {
			//
		}
	}

	public final void sub_558c(C_Unit unit) {
		this.var_3873 = 0;
		moveCursorToPos(unit.positionX, unit.positionY);
		this.var_386b = unit;
	}

	public final void sub_55bd(C_Unit unit1, C_Unit unit2) {
		if (unit2.m_state == 4) {
			this.var_35db = unit2;
			showSpriteOnMap(this.redsparkSprite, this.var_35db.posXPixel,
					this.var_35db.posYPixel, 0, 0, 1, 50);
			this.var_3603 = 6;
			this.activeUnit.endMove();
			this.activeUnitState = 0;
			clearActiveUnit();
			this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
			if (this.var_35b3[this.playerId] == 0) {
				this.aSomeOtherTime = this.time;
				this.var_3a6b = 6;
			}
		} else {
			if ((E_MainCanvas.settings[3] != false) && (unit2.charsData.length > 0)) {
				this.var_364b = true;
				this.waveImageAmplitude = 0;
				E_MainCanvas.stopMusic();
			} else {
				this.activeUnitState = 13;
				this.var_366b = 0;
				this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
			}
			this.attackerUnitMb = unit1;
			this.attackedUnitMb = unit2;
		}
	}

	public final void sub_56c3() {
		clearActiveUnit();
		if (this.attackerUnitMb.unitHealthMb <= 0) {
			this.dyingUnit = this.attackerUnitMb;
		} else if (this.attackerUnitMb.gotNewLevel()) {
			this.gotNewLevelUnits.addElement(this.attackerUnitMb);
		}
		if (this.attackedUnitMb.unitHealthMb <= 0) {
			this.dyingUnit = this.attackedUnitMb;
		} else {
			if (this.attackerUnitMb.hasProperty((short) 128)) { //poison
				showSpriteOnMap(this.sparkSprite, this.attackedUnitMb.posXPixel,
						this.attackedUnitMb.posYPixel, 0, 0, 1, 50);
				F_Sprite poisonSprite = F_Sprite.someSpriteCopy(this.statusSprite, 0, 0,
						-4, -1, 800, (byte) 5);
				poisonSprite.setSpritePosition(this.attackedUnitMb.posXPixel
						+ (this.attackedUnitMb.frameWidth - poisonSprite.frameWidth)
						/ 2, this.attackedUnitMb.posYPixel - poisonSprite.frameHeight);
				poisonSprite.setFrameSequence(var_339b);
				this.var_35c3.addElement(poisonSprite);
				this.attackedUnitMb.applyPoisonStatus((byte) 1);
			}
			if (this.attackedUnitMb.gotNewLevel()) {
				this.gotNewLevelUnits.addElement(this.attackedUnitMb);
			}
		}
		if (this.dyingUnit != null) {
			moveCursorToPos(this.dyingUnit.positionX, this.dyingUnit.positionY);
			showSpriteOnMap(this.sparkSprite, this.dyingUnit.posXPixel,
					this.dyingUnit.posYPixel, 0, 0, 1, 50);
			E_MainCanvas.playMusicLooped(12, 1);
		}
		this.var_35e3 = this.time;
		if (this.var_35b3[this.playerId] == 0) {
			this.aSomeOtherTime = this.time;
			this.var_3a6b = 6;
		}
		this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
		this.activeUnitState = 0;
		this.attackerUnitMb.endMove();
		this.attackedUnitMb = null;
		this.attackerUnitMb = null;
	}

	public final F_Sprite showSpriteOnMap(F_Sprite sprite,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			int paramInt5, int paramInt6) {
		F_Sprite aSprinte = F_Sprite.someSpriteCopy(sprite, paramInt3,
				paramInt4, 0, paramInt5, paramInt6, (byte) 0);
		aSprinte.setSpritePosition(paramInt1, paramInt2);
		this.var_35cb.addElement(aSprinte);
		return aSprinte;
	}

	public final void sub_58af(C_Unit unit) {
		this.canApplyMb = true;
		this.canCancelMb = (!this.var_3723);
		this.alphaWindowWTF = 12;
		this.activeUnitState = 1;
		this.var_369b = true;
		fillArrayWithValue(this.someMapData, 0);
		unit.fillWhereUnitCanMove(this.someMapData);
		this.var_351b = true;
		this.var_3523 = false;
		this.cursorSprite.setFrameSequence(cursorFrameSequences[2]);
	}

	public final void showPlayMenu(byte[] data, int cX, int cY, A_MenuBase menu) {
		D_Menu playWheelMenu = new D_Menu((byte) 0, 0);
		this.someMenuWidth = cX;
		this.someMenuHeight = cY;
		int length = data.length;
		Vector itemsNames = new Vector(length);
		Vector itemsImages = new Vector(length);
		for (int j = 0; j < length; j++) {
			int k = data[j];
			if ((this.appPropHightscoreUpload) || (k != 6)) {
				itemsNames.addElement(this.mainMenuItemsNames[k]);
				itemsImages.addElement(this.menuIconsFrames[k]);
			}
		}
		String[] menuItemNames = new String[itemsNames.size()];
		H_ImageExt[] menuItemImages = new H_ImageExt[itemsImages.size()];
		itemsNames.copyInto(menuItemNames);
		itemsImages.copyInto(menuItemImages);
		playWheelMenu.initWheelMenu(menuItemNames, menuItemImages,
				this.someCanWidthDiv2, this.someMenuWidth, this.someMenuHeight, 3, (byte) 1);
		playWheelMenu.setParentMenu(menu);
		A_MenuBase.mainCanvas.showMenu(playWheelMenu);
	}

	public final void sub_5a85(byte[] data, C_Unit unitUnused) {
		this.someGameMenu = new D_Menu((byte) 0, 0);
		int length = data.length;
		String[] names = new String[length];
		H_ImageExt[] images = new H_ImageExt[length];
		for (int j = 0; j < data.length; j++) {
			names[j] = this.unitActionsNames[data[j]];
			images[j] = this.actionIconsFrames[data[j]];
		}
		if (this.var_34b3 * 24 <= this.someGHeight / 2 - 24) {
			this.someGameMenu.sub_1e97(names, images, 0,
					this.someGHeight - this.buttonsSprite.frameHeight, 36);
		} else {
			this.someGameMenu.sub_1e97(names, images,
					this.someGWidth, 0, 8);
		}
		this.someGameMenu.setParentMenu(this);
		A_MenuBase.mainCanvas.showMenu(this.someGameMenu);
	}

	public final D_Menu createSlotsMenu(String desc, H_ImageExt image) {
		String[] slotNames = new String[3];
		for (int i = 0; i < 3; i++) {
			slotNames[i] = ("SLOT " + (i + 1) + "/" + 3);
		}
		this.var_38bb = new D_Menu((byte) 14, 0);
		this.var_38bb.setMenuItemsNames(slotNames, this.someGWidth, -1);
		this.var_38c3 = new D_Menu((byte) 10, 0);
		this.var_38c3.createDescDialogMb(null, this.slotsDescriptions[0], this.someGWidth, -1);
		if (this.slotsCurrentPlayerIds[0] != -1) {
			this.var_38c3.titleGradientColor = playerColors[this.slotsCurrentPlayerIds[0]];
		}
		D_Menu menu1 = new D_Menu((byte) 15, 15);
		int j = (this.someGHeight - this.var_38bb.menuHeight - this.var_38c3.menuHeight) / 2;
		D_Menu aMenu = new D_Menu((byte) 10, 0);
		aMenu.createDescDialogMb(null, desc, this.someGWidth, -1);
		aMenu.menuTitleIcon = image;
		menu1.addChildMenu(aMenu, 0, 0, 0);
		j += aMenu.menuHeight / 2;
		menu1.addChildMenu(this.var_38bb, 0, j, 0);
		j += this.var_38bb.menuHeight;
		menu1.addChildMenu(this.var_38c3, 0, j, 20);
		menu1.updateAllChildrenBoolMb = true;
		menu1.setMenuActionEnabled((byte) 0, true);
		return menu1;
	}

	public final void sub_5d1a(A_MenuBase menu) {
		int length = this.var_3c2b.length;
		String[] arrayOfString = new String[length];
		int[] arrayOfInt1 = new int[length];
		int j = 0;
		for (int k = 0; k < length; k++) {
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
		this.var_3943 = new D_Menu((byte) 15, 15);
		D_Menu menu1 = new D_Menu((byte) 10, 0);
		menu1.createDescDialogMb(null,
				A_MenuBase.getLangString(48), this.someGWidth, -1); // DOWNLOAD
		D_Menu menu2;
		if (j == 0) {
			menu2 = new D_Menu((byte) 10, 0);
			menu2.createDescDialogMb(null, A_MenuBase.getLangString(52), this.someGWidth,
					this.viewportHeight); //EMPTY
			this.var_3943.addChildMenu((D_Menu) menu2, 0,
					(this.someGHeight + menu1.menuHeight) / 2, 6);
		} else {
			String[] itemsNames = new String[j];
			int[] arrayOfInt2 = new int[j];
			System.arraycopy(arrayOfString, 0, itemsNames, 0, j);
			System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, j);
			this.downloadMenu = new D_Menu((byte) 10, 0);
			String str = getByteSizeString(this.downloadStoreAvailableSize);
			this.downloadMenu.createDescDialogMb(
					null,
					A_MenuBase.replaceStringFirst(54,
							getByteSizeString(this.someSizesMb[arrayOfInt2[0]]))
							+ "\n"
							+ A_MenuBase.replaceStringFirst(53, str), this.someGWidth, -1); // Needed: %U KBytes
			this.downloadItemsMenu = new D_Menu((byte) 11, 0);
			this.downloadItemsMenu.createMenuListItems(itemsNames, this.viewportWidth,
					this.viewportHeight, this.someGWidth, this.someGHeight
							- menu1.menuHeight
							- this.downloadMenu.menuHeight, 3, 4);
			this.downloadItemsMenu.var_1195 = arrayOfInt2;
			int i1 = (this.someGHeight - this.downloadMenu.menuHeight
					- this.downloadItemsMenu.menuHeight + menu1.menuHeight) / 2;
			this.var_3943.addChildMenu(this.downloadItemsMenu, 0, i1, 20);
			i1 += this.downloadItemsMenu.menuHeight;
			this.var_3943.addChildMenu(this.downloadMenu, 0, i1, 20);
			this.var_3943.updateAllChildrenBoolMb = true;
			this.var_3943.setMenuActionEnabled((byte) 0, true);
		}
		this.var_3943.addChildMenu(menu1, 0, 0, 20);
		this.var_3943.setParentMenu(menu);
	}

	public final D_Menu sub_5fed(A_MenuBase menu) {
		D_Menu localClass_d_0231;
		if (this.var_38fb.length == 0) {
			localClass_d_0231 = new D_Menu((byte) 10, 0);
			D_Menu delMenu = localClass_d_0231.createTitleMenu(A_MenuBase.getLangString(49));//DELETE
			delMenu.menuTitleIcon = this.menuIconsFrames[6]; 
			localClass_d_0231.createDescDialogMb(null, A_MenuBase.getLangString(52),
					this.someCanWidth, -1); //EMPTY
			localClass_d_0231.sub_193f(0,
					(this.someGHeight + delMenu.menuHeight) / 2, 6);
			localClass_d_0231.setParentMenu(menu);
			this.deleteMapMenu = null;
			return localClass_d_0231;
		}
		this.deleteMapMenu = new D_Menu((byte) 11, 0);
		localClass_d_0231 = this.deleteMapMenu.createTitleMenu(A_MenuBase.getLangString(49));//DELETE
		localClass_d_0231.menuTitleIcon = this.menuIconsFrames[6];
		this.deleteMapMenu
				.createMenuListItems(this.var_38fb, this.someCanWidth / 2,
						(this.someGHeight + localClass_d_0231.menuHeight) / 2,
						this.someGWidth, this.someGHeight
								- localClass_d_0231.menuHeight, 3, 4);
		this.deleteMapMenu.setParentMenu(menu);
		return this.deleteMapMenu;
	}

	public final int sub_60ce(int paramInt) {
		if (paramInt >= skirmishMapsNames.length) {
			return this.var_3903[(paramInt - skirmishMapsNames.length)]
					+ skirmishMapsNames.length;
		}
		return paramInt;
	}

	public final DataInputStream getSkirmishMapData(int paramInt) throws Exception {
		if (paramInt >= skirmishMapsNames.length) {
			int i = paramInt - skirmishMapsNames.length;
			return new DataInputStream(new ByteArrayInputStream(
					E_MainCanvas.getRecordStoreData("download", i)));
		}
		return new DataInputStream(E_MainCanvas.getResourceStream("s" + paramInt));
	}

	public final String getSkirmishMapName(int paramInt) {
		if (paramInt >= skirmishMapsNames.length) {
			int i = paramInt - skirmishMapsNames.length;
			for (int j = 0; j < this.var_3903.length; j++) {
				if (this.var_3903[j] == i) {
					return this.var_38fb[j];
				}
			}
			return null;
		}
		return skirmishMapsNames[paramInt];
	}

	public final String getByteSizeString(int bytes) {
		int i = bytes * 100 / 1024;
		int j = i / 100;
		int k = i % 100;
		return j + "." + k;
	}

	public final void sub_6260(D_Menu menu, int itemNumber,
			String itemName, byte paramByte) throws Exception {
		this.var_3c73 = true;
		if ((menu == this.someGameMenu) && (paramByte == 1)) {
			if (this.activeUnitState == 3) {
				this.activeUnit.setUnitPosition(this.var_3503, this.var_350b);
				this.activeUnit.fillWhereUnitCanMove(this.someMapData);
				sub_58af(this.activeUnit);
				this.var_369b = true;
			}
			return;
		}
		if (menu == this.mainMenuMb) {
			if (paramByte == 0) {
				A_MenuBase.mainCanvas.stopGame(); //exit
				return;
			}
			this.mainMenuMb = null;
			return;
		}
		if (menu == this.warningEndGameMenu) {
			if (paramByte == 0) {
				showPlayMenu(this.var_338b, this.someMenuWidth, this.someMenuHeight,
						menu.parentMenu); //move back
			}
			this.warningEndGameMenu = null;
			return;
		}
		if (menu == this.warningDialog) {
			if (paramByte == 0) {
				int pos = this.var_38bb.activeItemPositionMb;
				saveToSlotMenuShow(pos, this.saveSlotsMenu);
			}
			this.warningDialog = null;
			return;
		}
		if (menu == this.castleBuyAllUnitsMenu) {
			if ((paramByte == 2) || (paramByte == 3)) {
				String unitDesc = A_MenuBase.getLangString(184 + this.castleBuyAllUnitsMenu.buyUnits[itemNumber].unitTypeId);
				this.castleBuyDescMenu.createDescDialogMb(
								null, unitDesc, this.someGWidth, this.someGHeight
										- this.castleBuyUnitMenu.menuHeight
										- this.castleBuyAllUnitsMenu.menuHeight);
				this.castleBuyUnitMenu.menuUnit = this.castleBuyAllUnitsMenu.buyUnits[itemNumber];
				this.castleBuyDescMenu.onLoad();
				this.castleBuyUnitMenu.onLoad();
			}
			return;
		}
		Object localObject1;
		if (menu == this.castleBuyMenu) {
			if (paramByte == 0) {
				localObject1 = this.castleBuyAllUnitsMenu.buyUnits[this.castleBuyAllUnitsMenu.activeItemPositionMb];
				if (sub_e9d0((C_Unit) localObject1, this.var_34ab,
						this.var_34b3)) {
					this.activeUnit = sub_8722((C_Unit) localObject1,
							this.var_34ab, this.var_34b3);
					this.var_3723 = true;
					sub_58af(this.activeUnit);
					A_MenuBase.mainCanvas.showMenu(this);
				} else {
					return;
				}
			}
			this.castleBuyMenu = null;
			this.castleBuyAllUnitsMenu = null;
			this.castleBuyDescMenu = null;
			this.castleBuyUnitMenu = null;
			return;
		}
		if (menu == this.instructionsItemsMenu) {
			if ((paramByte == 2) || (paramByte == 3)) {
				if (itemNumber == 0) {
					localObject1 = A_MenuBase.getLangString(15);
				} else {
					localObject1 = A_MenuBase
							.getSomeHelpString(196 + itemNumber - 1, true);
				}
				this.instructionsDescMenu.createDescDialogMb(null, (String) localObject1,
						this.someGWidth, this.instructionsDescMenu.menuHeight);
				this.instructionsDescMenu.onLoad();
			}
			return;
		}
		if (menu == this.instructionsMenu) {
			this.instructionsMenu = null;
			this.instructionsItemsMenu = null;
			this.instructionsDescMenu = null;
			return;
		}
		if (menu == this.startupMessageBox) {
			if (paramByte == 0) {
				A_MenuBase.mainCanvas.showMenu(this);
			}
			return;
		}
		if (menu == this.skirmishSetupMenu) {
			if (paramByte == 0) {
				this.playerOptionsMenu = new D_Menu((byte) 15, 15);
				D_Menu titleMenu = new D_Menu((byte) 10, 0);
				titleMenu.menuTitleIcon = this.menuIconsFrames[4];
				titleMenu.createDescDialogMb(null,
						A_MenuBase.getLangString(34), this.someGWidth, -1); //SKIRMISH SETUP
				this.playerOptionsMenu.addChildMenu(titleMenu, 0, 0, 20);
				String[] teamOptionsStrings = new String[this.mapTeamsCount];
				for (int teamIndex = 0; teamIndex < this.mapTeamsCount; teamIndex++) {
					teamOptionsStrings[teamIndex] = A_MenuBase.replaceStringFirst(38, "" + (teamIndex + 1));
				}
				int titleMenuHeight = titleMenu.menuHeight;
				D_Menu[] menuList = new D_Menu[this.mapTeamsCount];
				this.choosePlayerMenuList = new D_Menu[this.mapTeamsCount];
				this.chooseTeamMenuList = new D_Menu[this.mapTeamsCount];
				for (int playerIndex = 0; playerIndex < this.mapTeamsCount; playerIndex++) {
					this.choosePlayerMenuList[playerIndex] = new D_Menu((byte) 14, 6);
					this.choosePlayerMenuList[playerIndex].setMenuItemsNames(this.playerSkirmishChoicesNames, this.someCanWidthDiv2, -1);
					this.chooseTeamMenuList[playerIndex] = new D_Menu((byte) 14, 5);
					this.chooseTeamMenuList[playerIndex]
							.setMenuItemsNames(teamOptionsStrings, this.someCanWidthDiv2, -1);
					this.chooseTeamMenuList[playerIndex].activeItemPositionMb = playerIndex;
					int someMaxWidth = Math.max(this.choosePlayerMenuList[playerIndex].menuWidth,
							this.chooseTeamMenuList[playerIndex].menuWidth);
					int someWidth = this.someCanWidth - someMaxWidth;
					this.choosePlayerMenuList[playerIndex].menuWidth = someMaxWidth;
					this.chooseTeamMenuList[playerIndex].menuWidth = someMaxWidth;
					this.playerOptionsMenu.addChildMenu(this.choosePlayerMenuList[playerIndex], someWidth, titleMenuHeight, 20);
					titleMenuHeight += this.choosePlayerMenuList[playerIndex].menuHeight;
					this.playerOptionsMenu.addChildMenu(this.chooseTeamMenuList[playerIndex], someWidth, titleMenuHeight, 20);
					titleMenuHeight += this.chooseTeamMenuList[playerIndex].menuHeight;
					menuList[playerIndex] = new D_Menu((byte) 10, 8);
					menuList[playerIndex].createDescDialogMb(null,
							A_MenuBase.getLangString(this.somePlayerIds[playerIndex] - 1 + 89),
							someWidth, this.choosePlayerMenuList[playerIndex].menuHeight
									+ this.chooseTeamMenuList[playerIndex].menuHeight); //player name color
					menuList[playerIndex].titleGradientColor = playerColors[this.somePlayerIds[playerIndex]];
					this.playerOptionsMenu.addChildMenu(menuList[playerIndex], 0, titleMenuHeight, 36);
				}
				this.playerOptionsMenu.var_111d = 1;
				D_Menu chooseMoneyMenu = new D_Menu((byte) 10, 8);
				chooseMoneyMenu.createDescDialogMb(null,
						A_MenuBase.getLangString(40), this.viewportWidth, -1);//Money
				this.playerOptionsMenu.addChildMenu(chooseMoneyMenu, 0, titleMenuHeight, 20);
				this.chooseMoneyItemsMenu = new D_Menu((byte) 14, 4);
				String[] skirmishStartMoneyValues = new String[skirmishStartMoneyEnum.length];;
				for (int moneyIndex = 0; moneyIndex < skirmishStartMoneyValues.length; moneyIndex++) {
					skirmishStartMoneyValues[moneyIndex] = ("" + skirmishStartMoneyEnum[moneyIndex]);
				}
				this.chooseMoneyItemsMenu.setMenuItemsNames(skirmishStartMoneyValues, this.viewportWidth,
						chooseMoneyMenu.menuHeight);
				this.playerOptionsMenu.addChildMenu(this.chooseMoneyItemsMenu, this.someCanWidthDiv2, titleMenuHeight, 20);
				titleMenuHeight += chooseMoneyMenu.menuHeight;
				D_Menu chooseUnitCapMenu = new D_Menu((byte) 10, 8);
				chooseUnitCapMenu.createDescDialogMb(
						null, A_MenuBase.getLangString(41), this.viewportWidth, -1);//Unit cap
				this.playerOptionsMenu.addChildMenu(chooseUnitCapMenu, 0, titleMenuHeight, 20);
				this.chooseUnitCapItemsMenu = new D_Menu((byte) 14, 4);
				String[] skirmishUnitsCapValues = new String[skirmishStartUnitsEnum.length];
				for (int capIndex = 0; capIndex < skirmishUnitsCapValues.length; capIndex++) {
					skirmishUnitsCapValues[capIndex] = ("" + skirmishStartUnitsEnum[capIndex]);
				}
				this.chooseUnitCapItemsMenu.setMenuItemsNames(skirmishUnitsCapValues, this.viewportWidth,
						chooseUnitCapMenu.menuHeight);
				this.playerOptionsMenu.addChildMenu(this.chooseUnitCapItemsMenu, this.someCanWidthDiv2, titleMenuHeight, 20);
				this.playerOptionsMenu.setParentMenu(menu);
				this.playerOptionsMenu.setMenuActionEnabled((byte) 0, true); 
				A_MenuBase.mainCanvas.showMenu(this.playerOptionsMenu);
				return;
			}
			this.skirmishSetupMenu = null;
			return;
		}
		if (menu == this.playerOptionsMenu) {
			if (paramByte == 0) {
				int j = 0;
				int n = 0;
				boolean[] arrayOfBoolean = new boolean[this.mapTeamsCount];
				for (int i6 = 0; i6 < this.mapTeamsCount; i6++) {
					if (this.choosePlayerMenuList[i6].activeItemPositionMb == 2) {
						this.var_35b3[i6] = 2;
					} else {
						j++;
						if (this.choosePlayerMenuList[i6].activeItemPositionMb == 0) {
							this.var_35b3[i6] = 1;
						} else if (this.choosePlayerMenuList[i6].activeItemPositionMb == 1) {
							this.var_35b3[i6] = 0;
						}
						this.var_3573[i6] = ((byte) this.chooseTeamMenuList[i6].activeItemPositionMb);
						if (arrayOfBoolean[this.var_3573[i6]] == false) {
							n++;
							arrayOfBoolean[this.var_3573[i6]] = true;
						}
					}
				}
				if ((j < 2) || (n < 2)) {
					//2 players and 2 teams minimum are required to start a skirmish game.
					D_Menu infoMenu = createDialog(null,
							A_MenuBase.getLangString(39), this.someGHeight, 2000); 
					infoMenu.setParentMenu(this.playerOptionsMenu);
					A_MenuBase.mainCanvas.showMenu(infoMenu);
					return;
				}
				this.playerOptionsMenu = null;
				this.skirmishSetupMenu = null;
				A_MenuBase.mainCanvas.showMenu(this);
				this.mapStartMoney = skirmishStartMoneyEnum[this.chooseMoneyItemsMenu.activeItemPositionMb];
				this.mapStartUnitCap = skirmishStartUnitsEnum[this.chooseUnitCapItemsMenu.activeItemPositionMb];
				this.choosePlayerMenuList = null;
				this.chooseMoneyItemsMenu = null;
				this.chooseUnitCapItemsMenu = null;
				this.mapModeCampIf0 = 1;
				this.var_3703 = 8;
				this.isBlackLoading = true;
				A_MenuBase.mainCanvas.repaintAll();
				checkResources();
				loadMap(this.var_34e3);
				this.scenarioMapIndex = this.var_34e3;
				this.isBlackLoading = false;
				this.activeUnitState = 0;
			}
			return;
		}
		int i4;
		int i7;
		if (menu == this.var_3713) {
			int ii;
			int j = this.var_370b.activeItemPositionMb;
			if ((paramByte == 0)
					&& ((j >= skirmishMapsNames.length) || (this.var_3303[j] == false))) {
				this.var_34e3 = sub_60ce(j);
				DataInputStream localDataInputStream;
				i4 = (localDataInputStream = getSkirmishMapData(this.var_34e3)).readInt();
				i7 = localDataInputStream.readInt();
				byte[][] localObject61 = new byte[i4][i7];
				this.somePlayerIds = new byte[4];
				byte[] localObject71 = new byte[5];
				for (int i13 = 0; i13 < 5; i13++) {
					localObject71[i13] = -1;
				}
				this.mapTeamsCount = 0;
				for (int i13 = 0; i13 < i4; i13++) {
					for (int i14 = 0; i14 < i7; i14++) {
						localObject61[i13][i14] = localDataInputStream
								.readByte();
						if ((this.tilesProps[localObject61[i13][i14]] == 9)
								&& ((ii = houseOwnerPlayerIndex(i13, i14,
										(byte[][]) localObject61)) != 0)
								&& (localObject71[ii] == -1)) {
							this.somePlayerIds[this.mapTeamsCount] = ((byte) ii);
							localObject71[ii] = this.mapTeamsCount;
							this.mapTeamsCount = ((byte) (this.mapTeamsCount + 1));
						}
					}
				}
				localDataInputStream.close();
				this.mapName = this.var_370b.menuItemsNamesMb[j];
				this.skirmishSetupMenu = new D_Menu((byte) 15, 15);
				D_Menu settingsMenuMb = new D_Menu((byte) 10, 0);
				settingsMenuMb.menuTitleIcon = this.menuIconsFrames[4]; //castle skirmish
				settingsMenuMb.createDescDialogMb(null, this.mapName, this.someGWidth,
						-1);
				D_Menu menu11 = new D_Menu((byte) 8, 0);
				menu11.initMapPreviewMenu(
						this.someCanWidth, this.someGHeight
								- settingsMenuMb.menuHeight
								- this.buttonsSprite.frameHeight,
						(byte[][]) localObject61, null);
				this.skirmishSetupMenu
						.addChildMenu(
								menu11,
								this.viewportWidth,
								this.viewportHeight
										+ (settingsMenuMb.menuHeight - this.buttonsSprite.frameHeight)
										/ 2, 3);
				this.skirmishSetupMenu.addChildMenu(settingsMenuMb, 0, 0, 0);
				this.skirmishSetupMenu.setParentMenu(menu);
				this.skirmishSetupMenu.setMenuActionEnabled((byte) 0, true);
				this.skirmishSetupMenu.updateAllChildrenBoolMb = true;
				A_MenuBase.mainCanvas.showMenu(this.skirmishSetupMenu);
			}
		} else if (menu == this.settingsMenu) {
			if (paramByte == 1) {
				boolean setting1Enabled = E_MainCanvas.settings[0];
				int countSettingsChanged = 0;
				for (int it = 0; it < 4; it++) {
					boolean settingEnabled = (this.settingsMenuList[it].activeItemPositionMb == 0) ? true
							: false;
					if ((settingEnabled) != E_MainCanvas.settings[it]) {
						E_MainCanvas.settings[it] = settingEnabled;
						countSettingsChanged = 1;
					}
				}
				if (countSettingsChanged != 0) {
					saveSettings();
					if (setting1Enabled != E_MainCanvas.settings[0]) {
						if (E_MainCanvas.settings[0] == false) {
							E_MainCanvas.stopMusic();
							return;
						}
						if (this.gameMode2Mb == 1) {
							if ((this.activeUnitState != 11) && (this.activeUnitState != 14)) {
								E_MainCanvas.playMusicLooped(
										var_33c3[this.playersIndexes[this.playerId]],
										0);
							}
						} else if (this.gameMode2Mb == 0) {
							E_MainCanvas.playMusicLooped(0, 0);
						}
					}
				} else {
					this.settingsMenu = null;
					this.settingsMenuList = null;
				}
			}
			return;
		}
		Object parMenu;
		if (menu == this.saveSlotsMenu) {
			if (paramByte == 0) {
				int slotIndex = this.var_38bb.activeItemPositionMb;
				if (this.slotsCurrentPlayerIds[slotIndex] == -1) {
					saveToSlotMenuShow(slotIndex, menu);
				} else {
					this.warningDialog = createDialog(null, A_MenuBase.getLangString(88),
							this.someGHeight, -1); //Overwriting the current saved game, are you sure?
					this.warningDialog.setMenuActionEnabled((byte) 0, true);
					this.warningDialog.setParentMenu(menu);
					A_MenuBase.mainCanvas.showMenu(this.warningDialog);
				}
			} else {
				this.saveSlotsMenu = null;
				this.var_38bb = null;
				this.var_38c3 = null;
			}
		} else if (menu == this.loadSlotsMenu) {
			if (paramByte == 0) {
				byte[] saveData = null;
				try {
					saveData = E_MainCanvas.getRecordStoreData("save",
							this.var_38bb.activeItemPositionMb);
				} catch (Exception localException) {
					//
				}
				if (saveData != null) {
					this.loadSlotsMenu = null;
					this.var_38bb = null;
					this.var_38c3 = null;
					A_MenuBase.mainCanvas.showMenu(this);
					this.isBlackLoading = true;
					A_MenuBase.mainCanvas.repaintAll();
					checkResources();
					loadMapDataBytes((byte[]) saveData);
					if (this.mapModeCampIf0 == 0) {
						this.isUpdatingMb = true;
					}
					this.isBlackLoading = false;
					this.activeUnitState = 0;
				}
			} else {
				this.loadSlotsMenu = null;
				this.var_38bb = null;
				this.var_38c3 = null;
			}
		} else if (menu == this.var_38bb) {
			if ((paramByte == 2) || (paramByte == 3)) {
				this.var_38c3.createDescDialogMb(null, this.slotsDescriptions[itemNumber],
						this.someGWidth, -1);
				if (this.slotsCurrentPlayerIds[itemNumber] == -1) {
					this.var_38c3.titleGradientColor = 2370117; //#242A45 dark blue
				} else {
					this.var_38c3.titleGradientColor = playerColors[this.slotsCurrentPlayerIds[itemNumber]];
				}
				this.var_38c3.onLoad();
			}
			return;
		}
		if (menu == this.someOnlineMenu) {
			if (paramByte == 0) {
				if (itemName.equals(this.onlineMenuItemsNames[0])) { // get news
					if (this.var_3c13 == null) {
						startRetrievingData(0, "news", A_MenuBase.getLangString(0), menu);
						return;
					}
					this.newsItemsMenu = sub_14c01(this.var_3c13, menu);
					return;
				}
				if (itemName.equals(this.onlineMenuItemsNames[1])) { //download maps
					this.onlineMenu = new D_Menu((byte) 11, 0);
					D_Menu onlineMenuTitle = this.onlineMenu.createTitleMenu(itemName);
					onlineMenuTitle.menuTitleIcon = this.menuIconsFrames[6]; //globe online
					this.onlineMenu
							.createMenuListItems(
									this.downloadMenuItemsNames,
									this.someCanWidth / 2,
									(this.someGHeight + onlineMenuTitle.menuHeight) / 2,
									this.someGWidth,
									this.someGHeight
											- onlineMenuTitle.menuHeight,
									3, 0);
					this.onlineMenu.setParentMenu(menu);
					A_MenuBase.mainCanvas.showMenu(this.onlineMenu);
				}
			} else if (paramByte == 1) {
				this.someOnlineMenu = null;
			}
		} else if (menu == this.onlineMenu) {
			if (paramByte == 0) {
				if (itemName.equals(this.downloadMenuItemsNames[0])) {
					if (this.var_3c2b == null) {
						startRetrievingData(2, "levels", A_MenuBase.getLangString(0),
								menu);
					} else {
						sub_5d1a(menu);
						A_MenuBase.mainCanvas.showMenu(this.var_3943);
					}
				} else if (itemName.equals(this.downloadMenuItemsNames[1])) {
					A_MenuBase.mainCanvas.showMenu(sub_5fed(menu));
				}
			} else if (paramByte == 1) {
				this.onlineMenu = null;
			}
		} else if (menu == this.newsItemsMenu) {
			if (paramByte == 0) {
				if (this.var_3c23[itemNumber] == null) {
					this.var_3c03 = itemNumber;
					startRetrievingData(1, this.var_3c1b[itemNumber],
							A_MenuBase.getLangString(0), menu);
				} else {
					D_Menu menu21 = createDialog(this.var_3c13[itemNumber],
							this.var_3c23[itemNumber], this.someGHeight,
							this.someGHeight / 2, -1);
					menu21.setParentMenu(menu);
					A_MenuBase.mainCanvas.showMenu((A_MenuBase) menu21);
				}
			} else if (paramByte == 1) {
				this.newsItemsMenu = null;
			}
		} else if (menu == this.var_3943) {
			if (paramByte == 0) {
				this.var_3c0b = this.downloadItemsMenu.var_1195[this.downloadItemsMenu.activeItemPositionMb];
				if (this.downloadStoreAvailableSize >= this.someSizesMb[this.var_3c0b]) {
					startRetrievingData(3, this.var_3c33[this.var_3c0b],
							A_MenuBase.getLangString(0), menu);
				} else {
					D_Menu menu31 = createDialog(null, A_MenuBase.getLangString(55),
							this.someGHeight, -1); //You do not have enough memory
					menu31.setParentMenu(menu);
					A_MenuBase.mainCanvas.showMenu((A_MenuBase) menu31);
				}
			} else if (paramByte == 1) {
				this.downloadMenu = null;
				this.downloadItemsMenu = null;
				this.var_3943 = null;
			}
		} else if (menu == this.downloadItemsMenu) {
			if ((paramByte == 2) || (paramByte == 3)) {
				parMenu = getByteSizeString(this.downloadStoreAvailableSize);
				this.downloadMenu
						.createDescDialogMb(
								null,
								A_MenuBase
										.replaceStringFirst(
												54,
												getByteSizeString(this.someSizesMb[this.downloadItemsMenu.var_1195[itemNumber]]))
										+ "\n"
										+ A_MenuBase.replaceStringFirst(53,
												(String) parMenu),
								this.someGWidth, -1);
				this.downloadMenu.onLoad();
			}
		} else if (menu == this.deleteMapMenu) {
			if (paramByte == 0) {
				if (this.var_3903[itemNumber] + skirmishMapsNames.length == this.scenarioMapIndex) {
					D_Menu menu41 = createDialog(null, A_MenuBase.getLangString(56),
							this.someGHeight, -1); //You cannot delete the level you are currently playing.
					menu41.setParentMenu(menu);
					A_MenuBase.mainCanvas.showMenu((A_MenuBase) menu41);
				} else {
					this.var_395b = itemNumber;
					this.deletingMapName = itemName;
					this.mapDeletingMenu = createDialog(null,
							A_MenuBase.replaceStringFirst(50, itemName),
							this.someGHeight, this.viewportHeight, -1); //Deleting skirmish map '%U'.
					this.mapDeletingMenu.setParentMenu(menu);
					this.mapDeletingMenu.setMenuActionEnabled((byte) 0, true);
					A_MenuBase.mainCanvas.showMenu(this.mapDeletingMenu);
				}
			} else if (paramByte == 1) {
				this.deleteMapMenu = null;
			}
		} else if (menu == this.mapDeletingMenu) {
			if (paramByte == 0) {
				sub_15429(this.var_395b);
				parMenu = sub_5fed(this.deleteMapMenu.parentMenu);
				D_Menu menuOk = createDialog(null,
						A_MenuBase.replaceStringFirst(51, this.deletingMapName), this.someGHeight,
						-1); //Map '%U' deleted.
				menuOk.setParentMenu((A_MenuBase) parMenu);
				A_MenuBase.mainCanvas.showMenu((A_MenuBase) menuOk);
			}
			this.mapDeletingMenu = null;
			this.deletingMapName = null;
		}
		if (menu.menuType == 7) {
			A_MenuBase.mainCanvas.showMenu(this);
			return;
		}
		if ((itemName == null) || (paramByte != 0)) {
			return;
		}
		if (itemName.equals(this.mainMenuItemsNames[0])) { // Play
			if ((this.gameMode2Mb == 0) || (this.activeUnitState != 0)) {
				showPlayMenu(this.var_338b, this.someMenuWidth, this.someMenuHeight,
						menu);
				return;
			}
			this.warningEndGameMenu = createDialog(null, A_MenuBase.getLangString(87),
					this.someGHeight, -1); //This will end your current game, are you sure?
			this.warningEndGameMenu.setMenuActionEnabled((byte) 0, true);
			this.warningEndGameMenu.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.warningEndGameMenu);
			return;
		}
		if ((itemName.equals(this.mainMenuItemsNames[1]))
				|| (menu == this.selectLevelMenu)) {
			A_MenuBase.mainCanvas.showMenu(this);
			if (menu == this.selectLevelMenu) {
				this.scenarioMapIndex = itemNumber;
				this.selectLevelMenu = null;
			} else {
				this.scenarioMapIndex = 0;
			}
			this.mapModeCampIf0 = 0;
			this.var_35b3[1] = 0;
			this.isBlackLoading = true;
			A_MenuBase.mainCanvas.repaintAll();
			System.gc();
			checkResources();
			loadMap(this.scenarioMapIndex);
			this.isBlackLoading = false;
			sub_10c83();
			this.activeUnitState = 0;
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(3))) { // SELECT LEVEL
			this.selectLevelMenu = new D_Menu((byte) 11, 0);
			int countScenLevels = this.unlockedScenarioLevelsCount;
			if (countScenLevels > 7) {
				countScenLevels = 7;
			}
			countScenLevels++;
			String[] scenMapNames = new String[countScenLevels];
			for (int lvlIndex = 0; lvlIndex < countScenLevels; lvlIndex++) {
				scenMapNames[lvlIndex] = (lvlIndex + 1 + ". " + A_MenuBase
						.getLangString(121 + lvlIndex)); // map name in menu
			}
			D_Menu selLevelMenuTitle = this.selectLevelMenu.createTitleMenu(itemName);
			selLevelMenuTitle.menuTitleIcon = this.menuIconsFrames[3];
			this.selectLevelMenu
					.createMenuListItems(
							scenMapNames,
							this.someCanWidth / 2,
							(this.someGHeight + selLevelMenuTitle.menuHeight) / 2,
							this.someGWidth, this.someGHeight
									- selLevelMenuTitle.menuHeight,
							3, 4);
			this.selectLevelMenu.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.selectLevelMenu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(4))) { //SAVE GAME
			this.saveSlotsMenu = createSlotsMenu(itemName, this.menuIconsFrames[10]); //save game icon
			this.saveSlotsMenu.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.saveSlotsMenu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(5))) { //LOAD GAME
			this.loadSlotsMenu = createSlotsMenu(itemName, this.menuIconsFrames[2]);
			this.loadSlotsMenu.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.loadSlotsMenu);
			return;
		}
		D_Menu titleMenu;
		if (itemName.equals(A_MenuBase.getLangString(6))) { //SKIRMISH
			this.var_3713 = new D_Menu((byte) 15, 15);
			titleMenu = new D_Menu((byte) 10, 0);
			titleMenu.createDescDialogMb(null,
					itemName, this.someGWidth, -1);
			titleMenu.menuTitleIcon = this.menuIconsFrames[4];
			this.var_3303 = new boolean[12];
			for (int i2 = this.unlockedScenarioLevelsCount; i2 <= 7; i2++) {
				this.var_3303[var_32fb[i2]] = true;
			}
			String[] localObject51 = new String[12];
			for (i7 = 0; i7 < 12; i7++) {
				if (this.var_3303[i7] != false) {
					localObject51[i7] = A_MenuBase.getLangString(42);
				} else {
					localObject51[i7] = skirmishMapsNames[i7];
				}
			}
			String[] arrayOfString2 = new String[12 + this.var_38f3];
			System.arraycopy(localObject51, 0, arrayOfString2, 0, 12);
			System.arraycopy(this.var_38fb, 0, arrayOfString2, 12,
					this.var_38f3);
			this.var_370b = new D_Menu((byte) 0, 0);
			this.var_370b.createMenuListItems(arrayOfString2, 0, 0, this.someGWidth,
					this.someGHeight - titleMenu.menuHeight
							- this.buttonsSprite.frameHeight * 2, 3, 4);
			this.var_3713.addChildMenu(this.var_370b, this.viewportWidth,
					(this.someGHeight + titleMenu.menuHeight) / 2, 3);
			this.var_3713.addChildMenu(titleMenu, 0, 0, 0);
			this.var_3713.updateAllChildrenBoolMb = true;
			this.var_3713.setMenuActionEnabled((byte) 0, true);
			this.var_3713.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.var_3713);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(7))) { //ONLINE
			this.someOnlineMenu = new D_Menu((byte) 11, 0);
			titleMenu = this.someOnlineMenu.createTitleMenu(itemName);
			titleMenu.menuTitleIcon = this.menuIconsFrames[6];
			this.someOnlineMenu.createMenuListItems(this.onlineMenuItemsNames, this.someCanWidth / 2,
					(this.someGHeight + titleMenu.menuHeight) / 2,
					this.someGWidth, this.someGHeight - titleMenu.menuHeight,
					3, 0);
			this.someOnlineMenu.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.someOnlineMenu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(8))) { //SETTINGs
			this.settingsMenu = new D_Menu((byte) 15, 15);
			titleMenu = new D_Menu((byte) 10, 0);
			titleMenu.menuTitleIcon = this.menuIconsFrames[5];
			titleMenu.createDescDialogMb(null, itemName, this.someGWidth, -1);
			this.settingsMenu.addChildMenu(titleMenu, 0, 0, 20);
			int mHeight = titleMenu.menuHeight;
			D_Menu[] settingsOptionsMenuList = new D_Menu[4];
			this.settingsMenuList = new D_Menu[4];
			for (int setIt = 0; setIt < 4; setIt++) {
				int i10 = 8;
				if (setIt != 0) {
					i10 = 9;
				}
				if (setIt != 3) {
					i10 |= 0x2;
				}
				settingsOptionsMenuList[setIt] = new D_Menu((byte) 10, i10);
				settingsOptionsMenuList[setIt].createDescDialogMb(null, E_MainCanvas.settingsNames[setIt],
						this.viewportWidth, -1);
				this.settingsMenu.addChildMenu(settingsOptionsMenuList[setIt], 0, mHeight, 20);
				i10 = 4;
				if (setIt != 0) {
					i10 = 5;
				}
				if (setIt != 3) {
					i10 |= 0x2;
				}
				this.settingsMenuList[setIt] = new D_Menu((byte) 14, i10);
				this.settingsMenuList[setIt].setMenuItemsNames(this.onOffValuesNames, this.viewportWidth,
						settingsOptionsMenuList[setIt].menuHeight);
				this.settingsMenuList[setIt].activeItemPositionMb = (E_MainCanvas.settings[setIt] != false ? 0
						: 1);
				this.settingsMenu.addChildMenu(this.settingsMenuList[setIt], this.someCanWidthDiv2, mHeight, 20);
				mHeight += settingsOptionsMenuList[setIt].menuHeight;
			}
			this.settingsMenu.var_111d = 2;
			this.settingsMenu.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.settingsMenu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(9))) { //INSTRUCTIONS
			this.instructionsMenu = new D_Menu((byte) 15, 15);
			titleMenu = new D_Menu((byte) 10, 0);
			titleMenu.createDescDialogMb(null, itemName, this.someGWidth, -1);
			titleMenu.menuTitleIcon = this.menuIconsFrames[7];
			String[] instrStrings = new String[20];
			for (int i5 = 0; i5 <= 19; i5++) {
				if (i5 > 0) {
					instrStrings[i5] = (A_MenuBase
							.getLangString(var_36d3[(i5 - 1)]) + " " + i5 + "/" + 19);
				} else {
					instrStrings[i5] = (A_MenuBase.getLangString(85) + " " + i5
							+ "/" + 19); //introduction
				}
			}
			this.instructionsItemsMenu = new D_Menu((byte) 14, 2);
			this.instructionsItemsMenu.setMenuItemsNames(instrStrings, this.someGWidth, -1);
			this.instructionsDescMenu = new D_Menu((byte) 10, 1);
			this.instructionsDescMenu.createDescDialogMb(null, A_MenuBase.getLangString(15),
					this.someGWidth, this.someGHeight - titleMenu.menuHeight
							- this.instructionsItemsMenu.menuHeight - this.buttonsSprite.frameHeight
							* 2);
			int height = titleMenu.menuHeight + this.buttonsSprite.frameHeight;
			this.instructionsMenu.addChildMenu(this.instructionsItemsMenu, this.viewportWidth, height, 17);
			height += this.instructionsItemsMenu.menuHeight;
			this.instructionsMenu.addChildMenu(this.instructionsDescMenu, this.viewportWidth, height, 17);
			this.instructionsMenu.addChildMenu(titleMenu, 0, 0, 0);
			this.instructionsMenu.setParentMenu(menu);
			this.instructionsMenu.updateAllChildrenBoolMb = true;
			A_MenuBase.mainCanvas.showMenu(this.instructionsMenu);
			return;
		}
		D_Menu aboutMenu;
		if (itemName.equals(A_MenuBase.getLangString(10))) { //ABOUT
			titleMenu = new D_Menu((byte) 15, 15);
			D_Menu titMenu = new D_Menu((byte) 10, 0);
			titMenu.createDescDialogMb(null, itemName, this.someGWidth, -1);
			titMenu.menuTitleIcon = this.menuIconsFrames[8];
			aboutMenu = new D_Menu((byte) 10, 0);
			String str = A_MenuBase.replaceStringFirst(16, this.appPropVersion);
			aboutMenu.createDescDialogMb(null, str, this.someGWidth, this.someGHeight
					- ((D_Menu) titMenu).menuHeight
					- this.buttonsSprite.frameHeight * 2);
			titleMenu
					.addChildMenu(
							aboutMenu,
							0,
							(this.someGHeight + ((D_Menu) titMenu).menuHeight) / 2,
							6);
			titleMenu.addChildMenu(titMenu, 0, 0, 0);
			titleMenu.setParentMenu(menu);
			titleMenu.updateAllChildrenBoolMb = true;
			A_MenuBase.mainCanvas.showMenu(titleMenu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(11))) { //Exit
			//Exiting game, are you sure?
			this.mainMenuMb = createDialog(null, A_MenuBase.getLangString(86),
					this.someGHeight, -1);
			this.mainMenuMb.setMenuActionEnabled((byte) 0, true);
			this.mainMenuMb.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.mainMenuMb);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(60))) { //MAIN MENU
			showPlayMenu(this.var_3383, this.viewportHeight, this.someGHeight,
					menu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(61))) { //MOVE
			this.var_3723 = false;
			sub_58af(this.activeUnit);
			A_MenuBase.mainCanvas.showMenu(this);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(62))) { //ATTACK
			fillArrayWithValue(this.someMapData, 0);
			this.var_34cb = this.activeUnitState;
			this.activeUnitState = 6;
			this.var_369b = true;
			this.var_34f3 = this.activeUnit.getActiveUnitsInAttackRange(this.activeUnit.positionX,
					this.activeUnit.positionY, (byte) 0);
			this.var_34eb = 0;
			this.var_351b = true;
			this.var_3523 = true;
			this.activeUnit.fillAttackRangeData(this.someMapData, this.activeUnit.positionX,
					this.activeUnit.positionY);
			this.cursorSprite.setFrameSequence(cursorFrameSequences[1]);
			moveCursorToPos(this.var_34f3[this.var_34eb].positionX,
					this.var_34f3[this.var_34eb].positionY);
			this.canCancelMb = true;
			this.canApplyMb = true;
			A_MenuBase.mainCanvas.showMenu(this);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(63))) { //BUY
			this.castleBuyMenu = new D_Menu((byte) 15, 15);
			this.castleBuyMenu.var_11b5 = this.someGHeight;
			this.castleBuyUnitMenu = new D_Menu((byte) 2, 2);
			this.castleBuyAllUnitsMenu = new D_Menu((byte) 3, 1);
			this.castleBuyDescMenu = new D_Menu((byte) 10, 3);
			this.castleBuyDescMenu.var_1125 = true;
			this.castleBuyUnitMenu.menuUnit = this.castleBuyAllUnitsMenu.buyUnits[0];
			this.castleBuyDescMenu.createDescDialogMb(null, A_MenuBase
					.getLangString(184 + this.castleBuyAllUnitsMenu.buyUnits[0].unitTypeId),
					this.someGWidth, this.someGHeight - this.castleBuyUnitMenu.menuHeight
							- this.castleBuyAllUnitsMenu.menuHeight);
			this.castleBuyMenu.addChildMenu(this.castleBuyUnitMenu, 0, 0, 0);
			this.castleBuyMenu.addChildMenu(this.castleBuyDescMenu, 0, this.castleBuyUnitMenu.menuHeight, 0);
			this.castleBuyMenu.addChildMenu(this.castleBuyAllUnitsMenu, 0, this.someGHeight, 32);
			this.castleBuyMenu.updateAllChildrenBoolMb = true;
			this.castleBuyMenu.setParentMenu(this);
			this.castleBuyMenu.setMenuActionEnabled((byte) 0, true);
			A_MenuBase.mainCanvas.showMenu(this.castleBuyMenu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(64))) {
			this.activeUnit.endMove();
			clearActiveUnit();
			this.var_3753 = getSomeUnit(this.var_34ab, this.var_34b3, (byte) 0);
			this.activeUnitState = 0;
			A_MenuBase.mainCanvas.showMenu(this);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(66))) { //END TURN
			sub_dd85();
			A_MenuBase.mainCanvas.showMenu(this);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(68))) { //REPAIR
			byte repairedHouseId = (byte) this.houseTileIdStartIndex;
			repairDestroyedHouse(repairedHouseId, this.activeUnit.positionX,
					this.activeUnit.positionY);
			A_MenuBase.mainCanvas.showMenu(createDialog(null,
					A_MenuBase.getLangString(74), this.someGHeight, 500)); //REPAIRED!
			E_MainCanvas.playMusicLooped(9, 1);
			this.activeUnit.endMove();
			this.activeUnitState = 0;
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(67))) { //OCCUPY
			if (sub_e0c8(this.activeUnit.positionX, this.activeUnit.positionY,
					this.activeUnit)) {
				sub_e1a9(this.activeUnit.positionX, this.activeUnit.positionY,
						this.playersIndexes[this.activeUnit.playerId]);
				A_MenuBase.mainCanvas.showMenu(createDialog(null,
						A_MenuBase.getLangString(73), this.someGHeight, 1000));
				this.activeUnitState = 9;
				E_MainCanvas.playMusicLooped(9, 1);
				this.someStartTime5 = this.time;
			}
			this.activeUnit.endMove();
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(69))) {
			this.activeUnitState = 7;
			this.var_34f3 = this.activeUnit.getActiveUnitsInAttackRange(this.activeUnit.positionX,
					this.activeUnit.positionY, (byte) 1);
			this.var_351b = true;
			this.var_3523 = true;
			this.activeUnit.fillAttackRangeData(this.someMapData, this.activeUnit.positionX,
					this.activeUnit.positionY);
			this.canCancelMb = true;
			A_MenuBase.mainCanvas.showMenu(this);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(70))) { //MAP
			D_Menu mapMenu = new D_Menu((byte) 15, 15);
			D_Menu mapTitleMenu = new D_Menu((byte) 10, 0);
			mapTitleMenu.createDescDialogMb(null, this.mapName, this.someGWidth, -1);
			D_Menu mapPreviewMenu = new D_Menu((byte) 8, 0);
			mapPreviewMenu.initMapPreviewMenu(
					this.someGWidth, this.someGHeight
							- mapTitleMenu.menuHeight
							- this.buttonsSprite.frameHeight, this.mapTilesIds,
					this.mapUnitsSprites);
			mapMenu.addChildMenu(
							mapPreviewMenu,
							this.viewportWidth,
							this.viewportHeight
									+ (mapTitleMenu.menuHeight - this.buttonsSprite.frameHeight)
									/ 2, 3);
			mapMenu.addChildMenu(mapTitleMenu, 0, 0, 0);
			mapMenu.setParentMenu(menu);
			mapMenu.updateAllChildrenBoolMb = true;
			A_MenuBase.mainCanvas.showMenu(mapMenu);
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(71))) { //OBJECTIVE
			this.startupMessageBox.setMenuActionEnabled((byte) 0, false);
			this.startupMessageBox.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.startupMessageBox);
		}
	}

	public final C_Unit sub_8722(C_Unit paramClass_c_032,
			int paramInt1, int paramInt2) {
		this.var_35a3[this.playerId] -= paramClass_c_032.cost;
		paramClass_c_032.unitHealthMb = 100;
		paramClass_c_032.setUnitPosition(paramInt1, paramInt2);
		if (!this.mapUnitsSprites.contains(paramClass_c_032)) {
			this.mapUnitsSprites.addElement(paramClass_c_032);
		}
		this.var_397b = true;
		return paramClass_c_032;
	}

	public final C_Unit sub_8788(byte paramByte, int paramInt1,
			int paramInt2) {
		this.var_35a3[this.playerId] -= C_Unit.var_bcb[paramByte];
		this.var_397b = true;
		return C_Unit.createUnitOnMap(paramByte, this.playerId, paramInt1,
				paramInt2);
	}

	public final F_Sprite sub_87c3(byte paramByte1, byte paramByte2) {
		return this.playersUnitsSprites[paramByte1][paramByte2];
	}

	public final void sub_87e6() {
		this.mapUnitsSprites = new Vector();
		this.activeUnit = null;
		this.var_34f3 = null;
		this.var_39b3 = null;
	}

	public final void loadMap(int mapId) throws Exception {
		E_MainCanvas.stopMusic();
		this.var_35c3 = new Vector();
		this.isFadingIn = false;
		this.isCursorVisible = true;
		this.var_364b = false;
		this.var_3883 = false;
		this.var_353b = null;
		this.dyingUnit = null;
		this.var_386b = null;
		this.var_35db = null;
		this.var_35eb = null;
		this.gotNewLevelUnits.removeAllElements();
		this.currentTurn = 0;
		this.playerId = 0;
		this.playerId = 0;
		this.scriptStep = 0;
		sub_87e6();
		this.playersKings = null;
		this.mapTilesIds = ((byte[][]) null);
		this.someMapData = ((byte[][]) null);
		this.mapMaxPlayersMb = 0;
		for (int i = 0; i < 5; i++) {
			this.var_3563[i] = -1;
		}
		this.var_369b = true;
		E_MainCanvas.loadResourcesPak("/1.pak");
		DataInputStream dis;
		if (this.mapModeCampIf0 == 0) {
			this.mapName = A_MenuBase.getLangString(113 + mapId);
			dis = new DataInputStream(E_MainCanvas.getResourceStream("m" + mapId));
		} else {
			this.mapName = getSkirmishMapName(mapId);
			dis = getSkirmishMapData(mapId);
		}
		this.mapWidth = dis.readInt();
		this.mapHeight = dis.readInt();
		this.mapTilesIds = new byte[this.mapWidth][this.mapHeight];
		this.someMapData = new byte[this.mapWidth][this.mapHeight];
		this.var_3adb = new byte[this.mapWidth][this.mapHeight];
		this.mapCastlesCount = 0;
		int countHouses = 0;
		byte[][] housesArr = new byte[30][3];
		byte[][] mapCastlesPositions = new byte[30][2];
		int m;
		for (short i = 0; i < this.mapWidth; i = (short) (i + 1)) {
			for (short j = 0; j < this.mapHeight; j = (short) (j + 1)) {
				this.mapTilesIds[i][j] = dis.readByte();
				this.someMapData[i][j] = 0;
				if ((this.mapTilesIds[i][j] >= this.houseTileIdStartIndex)
						|| (this.mapTilesIds[i][j] == 27)) { //is house
					m = tileOwnerPlayerIndex(i, j);
					housesArr[countHouses][0] = ((byte) i);
					housesArr[countHouses][1] = ((byte) j);
					housesArr[countHouses][2] = ((byte) m);
					countHouses++;
					if (getTileType(i, j) == 9) { //castle
						if ((this.mapModeCampIf0 == 1) && (m != 0)
								&& (this.var_3563[m] == -1)) {
							this.playersIndexes[this.mapMaxPlayersMb] = ((byte) m);
							this.var_3563[m] = this.mapMaxPlayersMb;
							this.mapMaxPlayersMb = ((byte) (this.mapMaxPlayersMb + 1));
						}
						mapCastlesPositions[this.mapCastlesCount][0] = ((byte) i);
						mapCastlesPositions[this.mapCastlesCount][1] = ((byte) j);
						this.mapCastlesCount += 1;
					}
				}
			}
		}
		this.var_3acb = new int[countHouses];
		this.housesDataArr = new byte[countHouses][];
		for (short i = 0; i < countHouses; i = (short) (i + 1)) {
			this.housesDataArr[i] = housesArr[i];
		}
		this.var_373b = new byte[this.mapCastlesCount][2];
		System.arraycopy(mapCastlesPositions, 0, this.var_373b, 0, this.mapCastlesCount);
		this.var_340b = (this.mapWidth * 24);
		this.var_3413 = (this.mapHeight * 24);
		if (this.mapModeCampIf0 == 1) {
			for (short i = 0; i < this.mapMaxPlayersMb; i = (short) (i + 1)) {
				this.var_35a3[i] = this.mapStartMoney;
			}
		}
		this.mapMaxPlayersMb = 2;
		this.var_35a3[0] = 0;
		this.var_35a3[1] = 0;
		this.var_3563[1] = 0;
		this.var_3563[2] = 1;
		this.playersIndexes[0] = 1;
		this.playersIndexes[1] = 2;
		this.var_3573[0] = 0;
		this.var_3573[1] = 1;
		this.var_35b3[0] = 1;
		this.var_35b3[1] = 0;
		this.mapStartUnitCap = 100;
		for (short i = 0; i < this.housesDataArr.length; i = (short) (i + 1)) {
			m = this.housesDataArr[i][2];
			if ((m > 0) && (this.var_35b3[sub_e276(m)] == 2)) {
				sub_e1a9(this.housesDataArr[i][0], this.housesDataArr[i][1], 0);
			}
		}
		int m1 = dis.readInt();
		dis.skip(m1 * 4);
		int n = dis.readInt();
		this.playersKings = new C_Unit[this.mapMaxPlayersMb];
		this.var_3593 = new C_Unit[this.mapMaxPlayersMb][4];
		this.var_359b = new int[this.mapMaxPlayersMb];
		for (short i = 0; i < n; i = (short) (i + 1)) {
			int i1 = dis.readByte();
			int posX = dis.readShort() / 24;
			int posY = dis.readShort() / 24;
			byte unitType = (byte) (i1 % 12);
			byte playerID = (byte) sub_e276(1 + i1 / 12);
			if (this.var_35b3[playerID] != 2) {
				C_Unit unit1 = C_Unit.createUnitOnMap(unitType, playerID, posX, posY);
				if (unitType == 9) {
					this.playersKings[playerID] = unit1;
				}
			}
		}
		dis.close();
		if (this.mapModeCampIf0 == 0) {
			this.startupMessageBox = createDialog(A_MenuBase.getLangString(121 + this.scenarioMapIndex),
					A_MenuBase.getLangString(129 + this.scenarioMapIndex), this.someGHeight, -1);
		} else {
			this.startupMessageBox = createDialog(A_MenuBase.getLangString(71), 
					A_MenuBase.getLangString(137), this.someGHeight, -1); //OBJECTIVE
		}
		this.var_3b7b = false;
		this.var_3b4b = null;
		this.skeleton1Map2 = null;
		this.crystalOfWisdom = null;
		this.skeleton2Map2 = null;
		this.wisdomCrystalKeeper = null;
		this.unitEndTurnMb = null;
		for (short i = 0; i < this.playersKings.length; i = (short) (i + 1)) {
			if (this.playersKings[i] == null) {
				this.kingsPositions[i][0] = 0;
				this.kingsPositions[i][1] = 0;
			} else {
				this.kingsPositions[i][0] = ((byte) this.playersKings[i].positionX);
				this.kingsPositions[i][1] = ((byte) this.playersKings[i].positionY);
			}
		}
		if (this.mapModeCampIf0 == 1) {
			this.scriptStep = 100;
			this.isUpdatingMb = true;
			for (short i = 0; i < this.mapMaxPlayersMb; i = (short) (i + 1)) {
				if (this.var_35b3[i] != 2) {
					this.playerId = ((byte) i);
					break;
				}
				this.currentTurn = ((short) (this.currentTurn + 1));
			}
		}
		if (this.playersKings[this.playerId] != null) {
			sub_b9c5(this.playersKings[this.playerId].positionX,
					this.playersKings[this.playerId].positionY);
			moveCursorToPos(this.playersKings[this.playerId].positionX,
					this.playersKings[this.playerId].positionY);
		}
		this.var_3ab3 = new C_Unit[this.housesDataArr.length];
		this.var_3abb = new byte[this.housesDataArr.length];
		this.houseSmokeSprites = new F_Sprite[this.housesDataArr.length];
		for (short i = 0; i < this.housesDataArr.length; i = (short) (i + 1)) {
			if (getTileType(this.housesDataArr[i][0], this.housesDataArr[i][1]) == 8) {
				this.houseSmokeSprites[i] = F_Sprite.someSpriteCopy(this.bigSmokeSprite, 0, -1,
						0, 1, 250, (byte) 0);
				this.houseSmokeSprites[i].var_84c = false;
			}
		}
		if (this.var_35b3[this.playerId] == 0) {
			sub_ea76();
		}
	}

	public final void clearActiveUnit() {
		this.var_34eb = 0;
		this.activeUnit = null;
		this.var_34f3 = new C_Unit[0];
		fillArrayWithValue(this.someMapData, 0);
		this.var_351b = false;
		this.var_3523 = false;
	}

	public final void fillArrayWithValue(byte[][] data, int type) {
		for (int i = 0; i < this.mapWidth; i++) {
			for (int j = 0; j < this.mapHeight; j++) {
				data[i][j] = ((byte) type);
			}
		}
	}

	public final void sub_91c4(C_Unit unit) {
		E_MainCanvas.stopMusicPlayer(10);
		this.var_39b3 = null;
		fillArrayWithValue(this.someMapData, 0);
		this.var_351b = false;
		if (this.var_35b3[this.playerId] == 1) {
			this.var_39c3 = 1;
			this.isCursorVisible = true;
			this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
			this.activeUnitState = 3;
			sub_5a85(sub_9267(unit, (byte) 0), unit);
			E_MainCanvas.playMusicLooped(11, 1);
			return;
		}
		if (this.var_35b3[this.playerId] == 0) {
			this.var_3a6b = 4;
			this.activeUnitState = 0;
		}
	}

	public final byte[] sub_9267(C_Unit unit, byte paramByte) {
		int i = 0;
		byte[] arrayOfByte = new byte[this.unitActionsNames.length];
		if ((paramByte == 1)
				&& (getTileType(this.activeUnit.positionX, this.activeUnit.positionY) == 9)
				&& (sub_e312(this.activeUnit.positionX, this.activeUnit.positionY,
						unit.playerId))) {
			arrayOfByte[(i++)] = 0;
		}
		arrayOfByte[(i++)] = 2;
		if (sub_e0c8(unit.positionX, unit.positionY,
				unit)) {
			arrayOfByte[(i++)] = (byte) (sub_e065(unit.positionX,
					unit.positionY, unit) ? 0 : 1);
		}
		if (((paramByte == 1) || (unit.unitTypeId != 7))
				&& (unit.charsData.length > 0)
				&& (unit.getActiveUnitsInAttackRange(unit.positionX,
						unit.positionY, (byte) 0).length > 0)) {
			arrayOfByte[(i++)] = 3;
		}
		C_Unit[] lUnit = unit.getActiveUnitsInAttackRange(
				unit.positionX, unit.positionY,
				(byte) 1);
		if ((unit.hasProperty((short) 32))
				&& (lUnit.length > 0)) {
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

	public final void updateIntro() throws Exception {
		boolean skipIntro = true;
		switch (this.introMode) {
		case 0: // mslogoStill
			long showMSLogoStillTime = 0L;
			if (this.time >= showMSLogoStillTime) {
				this.introMode = 1;
				this.waveImageAmplitude = skipIntro ? 0 : 40; //40
			}
			return;
		case 1: // mslogowave
			if (this.waveImageAmplitude <= 0) {
				this.msLogoImage = null;
				this.waveImageAmplitude = 0;
				this.introMode += 1;
				if(!skipIntro)
					loadIntro(0, 0, 3);
				return;
			}
			this.waveImageAmplitude -= 1;
			return;
		case 2:
			if(!skipIntro)
				loadIntro(1, 2, 3);
			this.logoImage = new H_ImageExt("logo");
			this.introMode += 1;
			return;
		case 3:
			int maxLogoWaveAmp = (skipIntro) ? 0 : 40;
			if (++this.waveImageAmplitude > maxLogoWaveAmp) {
				try {
					this.splashImage = new H_ImageExt("splash");
					this.glowImage = new H_ImageExt("glow");
				} catch (Exception ex) {
					//
				}
				this.waveImageAmplitude = 11;
				this.introMode += 1;
				A_MenuBase.mainCanvas.clearActions();
				return;
			}
			break;
		case 4:
			if (++this.waveImageAmplitude < 16) {
				if (this.glowImage != null) {
					this.glowImagePosX = (-this.glowImage.imageWidth);
				}
			} else {
				if (this.glowImagePosX >= this.someCanWidth * 4) {
					if (this.glowImage != null) {
						this.glowImagePosX = (-this.glowImage.imageWidth);
					}
				} else {
					this.glowImagePosX += this.logoImage.imageWidth / 6;
				}
				if (this.time % 100L == 0L) {
					this.showPressAnyKey = (!this.showPressAnyKey);
				}
				if (((this.splashImage == null) || (A_MenuBase.mainCanvas.isActionPressed()))
						&& (sub_4789())) {
					if (this.glowImage != null) { // stop glow animation
						this.glowImagePosX = (-this.glowImage.imageWidth);
					}
					this.showPressAnyKey = false;
					int logoHeight = this.logoImage.imageHeight + 1;
					showPlayMenu(this.var_337b, (this.someCanHeight + logoHeight) / 2,
							this.someCanHeight - logoHeight, this.splashImage == null ? null
									: this);
					A_MenuBase.mainCanvas.clearActions();
				}
			}
			break;
		}
	}

	//@Override
	public final void onUpdate() throws Exception {
		this.time += 50L;
		if (this.gameMode2Mb == 2) {
			updateGameSprites();
			return;
		}
		if (this.gameMode2Mb == 3) {
			sub_c1eb();
			return;
		}
		if (this.gameMode2Mb == 0) {
			updateIntro();
			return;
		}
		updateMapScript();
		if (this.helpTipId != -1) {
			if (E_MainCanvas.settings[2] != false) { // help setting
				D_Menu aHelpDialog1 = showUnitDialogMsg(
						A_MenuBase.getSomeHelpString(196 + this.helpTipId, true),
						(byte) -1, (byte) 2); //Use %KM to move the cursor...
				aHelpDialog1.var_117d = 7831691; //#77808B
				aHelpDialog1.titleGradientColor = 7831691;  //#77808B
				aHelpDialog1.m_bgColorMb = 16250855; //#F7F7E7
			}
			this.helpTipId = -1;
		}
		if (A_MenuBase.mainCanvas.mainDrawElement != this) {
			return;
		}
		if (this.activeUnitState == 0) { 
			for (int i = 0; i < this.houseSmokeSprites.length; i++) {
				int k = tileOwnerPlayerIndex(this.housesDataArr[i][0], this.housesDataArr[i][1]);
				if ((this.houseSmokeSprites[i] != null) && (k != -1) && (k != 0)
						&& (!this.houseSmokeSprites[i].var_84c)
						&& (E_MainCanvas.random.nextInt() % 8 == 0)) {
					this.houseSmokeSprites[i].var_84c = true;
					this.houseSmokeSprites[i].setCurrentFrameIndex(0);
					this.houseSmokeSprites[i].var_81c = 1;
					this.houseSmokeSprites[i].setSpritePosition((this.housesDataArr[i][0] + 1) * 24
							- this.bigSmokeSprite.frameWidth,
							this.housesDataArr[i][1] * 24 - 2);
					this.var_35cb.addElement(this.houseSmokeSprites[i]);
				}
			}
		}
		if (this.time - this.var_3693 >= 300L) {
			this.var_368b = (!this.var_368b);
			this.var_3693 = this.time;
		}
		if ((this.var_3bc3) && (this.time - this.someStartTime >= this.someMaxTime)) {
			this.var_3bc3 = false;
		}
		if (this.var_364b) {
			this.waveImageAmplitude += 1;
			if (this.waveImageAmplitude > 16) {
				if (this.activeUnitState == 10) {
					this.var_3b93 = 1;
				} else if (this.activeUnitState == 11) {
					if (this.mapModeCampIf0 == 0) {
						this.isFading = true;
						this.var_380b = true;
						this.fadeInColor = 0;
					}
					this.var_372b = 0;
					this.someStartTime5 = this.time;
				} else {
					sub_144b2(this.attackerUnitMb, this.attackedUnitMb);
					this.var_3a83 = null;
					clearActiveUnit();
				}
				this.var_364b = false;
			}
			return;
		}
		if (this.isFading) {
			if (this.isFadingIn) {
				if (this.fadeInColor < 16) {
					this.fadeInColor += 1;
				}
			} else if (this.var_380b) {
				this.fadeInColor += 1;
				if (this.fadeInColor > 16) {
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
			if (this.alphaWindowWTF > 0) {
				this.alphaWindowWTF -= 4;
				if (this.alphaWindowWTF < 0) {
					this.alphaWindowWTF = 0;
				}
			}
		}
		if ((this.isCursorVisible) && (this.time - this.var_33a3 >= 200L)) {
			this.cursorSprite.nextFrame();
			this.var_33a3 = this.time;
		}
		int k = this.var_34ab * 24;
		int m = this.var_34b3 * 24;
		int n = this.cursorSprite.posXPixel;
		int i1 = this.cursorSprite.posYPixel;
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
		this.cursorSprite.setSpritePosition(n, i1);
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
			if (this.activeUnitState == 8) {
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
						if (this.var_35b3[this.playerId] == 1) {
							localObject1 = "" + this.var_3a5b;
						} else {
							localObject1 = "?";
						}
						D_Menu localClass_d_0233 = createDialog(
								A_MenuBase.getLangString(75),
								A_MenuBase.replaceStringFirst(76, (String) localObject1),
								this.someGHeight, 1500);
						A_MenuBase.mainCanvas.showMenu(localClass_d_0233);
						localClass_d_0233.titleGradientColor = playerColors[this.playersIndexes[this.playerId]];
						E_MainCanvas.playMusicLooped2(
								var_33c3[this.playersIndexes[this.playerId]], 0);
					}
				} else {
					for (int i = this.mapUnitsSprites.size() - 1; i >= 0; i--) {
						C_Unit localObject11 = (C_Unit) this.mapUnitsSprites
								.elementAt(i);
						if ((localObject11.m_state != 3)
								&& (this.playerId == ((C_Unit) localObject11).playerId)
								&& ((getTileType(
										((C_Unit) localObject11).positionX,
										((C_Unit) localObject11).positionY) == 7) || (sub_e2b4(
										((C_Unit) localObject11).positionX,
										((C_Unit) localObject11).positionY,
										this.var_3573[localObject11.playerId])))
								&& (((C_Unit) localObject11).unitHealthMb < 100)) {
							int i5;
							if ((i5 = 100 - ((C_Unit) localObject11).unitHealthMb) > 20) {
								i5 = 20;
							}
							localObject11.unitHealthMb += i5;
							F_Sprite localObject51 = F_Sprite.sub_15c2(
									"+" + i5, 0, -4, (byte) 1);
							localObject51
									.setSpritePosition(
											((F_Sprite) localObject11).posXPixel
													+ ((F_Sprite) localObject11).frameWidth
													/ 2,
											((F_Sprite) localObject11).posYPixel
													+ ((F_Sprite) localObject11).frameHeight);
							this.var_35c3.addElement(localObject51);
						}
					}
					this.var_354b = 0;
					this.var_3793 = false;
					this.activeUnitState = 0;
				}
			} else if (this.activeUnitState == 9) {
				this.activeUnitState = 0;
			} else if (this.activeUnitState == 11) {
				if ((!this.var_364b)
						&& (this.var_372b == 0)
						&& ((this.mapModeCampIf0 == 1)
								|| (this.time - this.someStartTime5 >= 3000L) || (A_MenuBase.mainCanvas
								.isActionPressed()))) {
					this.someGHeight = this.someCanHeight;
					this.viewportHeight = this.someCanHeightDiv2;
					showPlayMenu(this.var_337b, this.someCanHeightDiv2, this.someCanHeight, null);
					this.var_372b = 1;
					this.var_380b = false;
				}
			} else {
				Object localObject3;
				if ((this.activeUnitState == 10) || (this.activeUnitState == 14)) {
					if ((this.var_3b93 == 1)
							|| ((this.activeUnitState == 14) && (this.var_3b93 != 2))) {
						this.scenarioMapIndex += 1;
						if (this.scenarioMapIndex > this.unlockedScenarioLevelsCount) {
							localObject1 = skirmishMapsNames[var_32fb[this.unlockedScenarioLevelsCount]];
							localObject3 = createDialog(null, A_MenuBase.replaceStringFirst(
									82, (String) localObject1), this.someCanHeight,
									3000);
							A_MenuBase.mainCanvas
									.showMenu((A_MenuBase) localObject3);
							this.unlockedScenarioLevelsCount = this.scenarioMapIndex;
							try {
								localObject5 = new byte[] { (byte) this.unlockedScenarioLevelsCount };
								E_MainCanvas.saveRecordStoreData("settings", 1,
										(byte[]) localObject5);
							} catch (Exception localException) {
							}
						}
						this.var_3b93 = 2;
					} else if (this.var_3b93 == 0) {
						this.var_364b = true;
						this.waveImageAmplitude = 0;
					} else if (this.var_3b93 == 2) {
						if (this.activeUnitState == 14) {
							this.someGHeight = this.someCanHeight;
							this.viewportHeight = this.someCanHeightDiv2;
							showPlayMenu(this.var_337b, this.someCanHeightDiv2, this.someCanHeight,
									null);
							return;
						}
						if (this.scenarioMapIndex <= 7) {
							loadMap(this.scenarioMapIndex);
							sub_10c83();
							this.activeUnitState = 0;
						}
					}
				} else {
					int i7;
					if (this.activeUnitState == 13) {
						int i2;
						if (this.var_366b == 0) {
							E_MainCanvas.vibrate(200);
							i2 = this.attackerUnitMb.sub_fea(this.attackedUnitMb);
							this.attackedUnitMb.shakeUnit(400);
							E_MainCanvas.playMusicLooped(14, 1);
							showSpriteOnMap(this.redsparkSprite, this.attackedUnitMb.posXPixel,
									this.attackedUnitMb.posYPixel, 0, 0, 2, 50);
							localObject3 = F_Sprite.sub_15c2("-" + i2, 0,
									-4, (byte) 1);
							if ((i7 = this.attackedUnitMb.posXPixel
									+ this.attackedUnitMb.frameWidth / 2)
									+ ((F_Sprite) localObject3).frameWidth / 2 > this.var_340b) {
								i7 = this.var_340b
										- ((F_Sprite) localObject3).frameWidth
										/ 2;
							} else if (i7
									- ((F_Sprite) localObject3).frameWidth / 2 < 0) {
								i7 = ((F_Sprite) localObject3).frameWidth / 2;
							}
							((F_Sprite) localObject3).setSpritePosition(i7,
									this.attackedUnitMb.posYPixel
											+ this.attackedUnitMb.frameHeight);
							this.var_35c3.addElement(localObject3);
							this.var_3673 = this.time;
							this.var_366b += 1;
						} else if (this.var_366b == 1) {
							if (this.time - this.var_3673 >= 800L) {
								moveCursorToPos(this.attackerUnitMb.positionX,
										this.attackerUnitMb.positionY);
								if (this.attackedUnitMb.sub_1134(this.attackerUnitMb,
										this.attackerUnitMb.positionX,
										this.attackerUnitMb.positionY)) {
									E_MainCanvas.vibrate(200);
									i2 = this.attackedUnitMb.sub_fea(this.attackerUnitMb);
									this.attackerUnitMb.shakeUnit(400);
									E_MainCanvas.playMusicLooped(14, 1);
									showSpriteOnMap(this.redsparkSprite,
											this.attackerUnitMb.posXPixel,
											this.attackerUnitMb.posYPixel, 0, 0, 2, 50);
									localObject3 = F_Sprite.sub_15c2("-"
											+ i2, 0, -4, (byte) 1);
									if ((i7 = this.attackerUnitMb.posXPixel
											+ this.attackerUnitMb.frameWidth / 2)
											+ ((F_Sprite) localObject3).frameWidth
											/ 2 > this.var_340b) {
										i7 = this.var_340b
												- ((F_Sprite) localObject3).frameWidth
												/ 2;
									} else if (i7
											- ((F_Sprite) localObject3).frameWidth
											/ 2 < 0) {
										i7 = ((F_Sprite) localObject3).frameWidth / 2;
									}
									((F_Sprite) localObject3).setSpritePosition(i7,
											this.attackerUnitMb.posYPixel
													+ this.attackerUnitMb.frameHeight);
									this.var_35c3.addElement(localObject3);
									this.var_3673 = this.time;
									this.var_366b += 1;
								} else {
									sub_56c3();
								}
							}
						} else if (this.time - this.var_3673 >= 800L) {
							sub_56c3();
						}
					} else if (this.var_386b != null) {
						if (this.var_3873 == 0) {
							if (this.var_39cb) {
								this.var_3863 = showSpriteOnMap(this.sparkSprite,
										this.var_386b.posXPixel, -this.var_3423,
										0, 12, -1, 0);
								D_Menu localClass_d_0232;
								(localClass_d_0232 = createDialog(null,
										A_MenuBase.getLangString(280),
										this.someGHeight, 2000)).sub_193f(
										this.viewportWidth, 2, 17);
								A_MenuBase.mainCanvas.showMenu(localClass_d_0232);
								this.var_3873 = 1;
							}
						} else if (this.var_3873 == 1) {
							for (int i = 0; i < 3; i++) {
								showSpriteOnMap(
										this.bigSmokeSprite,
										this.var_3863.posXPixel
												+ E_MainCanvas
														.getRandomMax(this.var_3863.frameWidth
																- this.bigSmokeSprite.frameWidth),
										this.var_3863.posYPixel, 0, E_MainCanvas
												.getRandomWithin(-3, 0), 1,
										50 * E_MainCanvas.getRandomMax(4));
							}
							if (this.var_3863.posYPixel >= this.var_386b.posYPixel) {
								this.var_3863.var_84c = false;
								E_MainCanvas.vibrate(200);
								sub_14bd3(500);
								if (this.var_387b) {
									int i3;
									if ((i3 = 25 + E_MainCanvas.getRandomMax(25)) > this.var_386b.unitHealthMb) {
										i3 = this.var_386b.unitHealthMb;
									}
									this.var_386b.unitHealthMb -= i3;
									F_Sprite localObject31 = F_Sprite
											.sub_15c2("-" + i3, 0, -4, (byte) 1);
									localObject31
											.setSpritePosition(
													this.var_386b.posXPixel
															+ this.var_386b.frameWidth
															/ 2,
													this.var_386b.posYPixel
															+ this.var_386b.frameHeight);
									this.var_35c3.addElement(localObject31);
								}
								sub_b64d(this.var_386b);
								this.var_3873 = 2;
							}
						} else if (++this.var_3873 >= 20) {
							if (this.var_386b.unitHealthMb <= 0) {
								this.dyingUnit = this.var_386b;
								showSpriteOnMap(this.sparkSprite, this.dyingUnit.posXPixel,
										this.dyingUnit.posYPixel, 0, 0, 1, 50);
								E_MainCanvas.playMusicLooped(12, 1);
								this.var_35e3 = this.time;
							}
							this.var_386b = null;
						}
					} else if (this.var_35db != null) {
						if (--this.var_3603 <= 0) {
							E_MainCanvas.vibrate(100);
							sub_b64d(this.var_35db);
							repairDestroyedHouse((byte) 27, this.var_35db.positionX,
									this.var_35db.positionY);
							this.var_35db = null;
						}
					} else if (this.dyingUnit != null) {
						if ((this.time - this.var_35e3 >= 300L)
								&& (sub_b848(this.dyingUnit.positionX,
										this.dyingUnit.positionY))) {
							if ((this.mapModeCampIf0 == 0) && (this.scenarioMapIndex == 7)
									&& (this.dyingUnit == this.playersKings[1])) {
								this.var_3883 = true;
							} else {
								showSpriteOnMap(this.smokeSprite, this.dyingUnit.posXPixel,
										this.dyingUnit.posYPixel, 0, -3, 1, 100);
								this.dyingUnit.m_state = 3;
								this.dyingUnit.var_b5b = 3;
								if ((this.dyingUnit.unitTypeId == 10)
										|| (this.dyingUnit.unitTypeId == 11)) {
									this.dyingUnit.removeFromMap();
								} else if (this.dyingUnit.unitTypeId == 9) {
									this.dyingUnit.setUnitPosition(-10, -10);
									this.dyingUnit.status = 0;
									this.dyingUnit.calcStatusEffect();
								}
								if ((this.dyingUnit.unitTypeId == 9) && (this.dyingUnit.cost < 1000)) {
									this.dyingUnit.cost += 200;
								}
							}
							this.dyingUnit = null;
						}
					} else {
						C_Unit localClass_c_032;
						if (this.gotNewLevelUnits.size() > 0) {
							localClass_c_032 = (C_Unit) this.gotNewLevelUnits
									.elementAt(0);
							if (this.var_382b == 0) {
								moveCursorToPos(localClass_c_032.positionX,
										localClass_c_032.positionY);
								this.var_382b = 1;
							} else if (sub_b848(localClass_c_032.positionX,
									localClass_c_032.positionY)) {
								showSpriteOnMap(
										this.smallSparkSprite,
										localClass_c_032.posXPixel
												+ E_MainCanvas
														.getRandomMax(localClass_c_032.frameWidth),
										localClass_c_032.posYPixel
												+ E_MainCanvas
														.getRandomMax(localClass_c_032.frameHeight),
										0, 0, 1, 50);
								if (this.var_382b == 1) {
									E_MainCanvas.playMusicLooped(13, 1);
								}
								if (this.var_382b <= 5) {
									int i6 = 200;
									if (this.var_382b == 5) {
										i6 = 1000;
									}
									i7 = localClass_c_032.posXPixel
											+ (localClass_c_032.frameWidth - this.levelupSprite.frameWidth)
											/ 2;
									int i8 = localClass_c_032.posYPixel
											- this.var_382b * 4;
									if (i7 < 0) {
										i7 = 0;
									} else if (i7 + this.levelupSprite.frameWidth > this.var_340b) {
										i7 = this.var_340b
												- this.levelupSprite.frameWidth;
									}
									if (i8 < 0) {
										i8 = 0;
									}
									showSpriteOnMap(this.levelupSprite, i7, i8, 0, 0, 1, i6);
								}
								this.var_382b += 1;
								if (this.var_382b >= 20) {
									this.gotNewLevelUnits
											.removeElement(localClass_c_032);
									this.var_382b = 0;
									if ((localClass_c_032.unitTypeId != 9)
											&& (localClass_c_032.level <= 6)
											&& (localClass_c_032.level % 2 == 0)) {
										A_MenuBase.mainCanvas
												.showMenu(createDialog(
														null,
														A_MenuBase.getLangString(80)
																+ "\n"
																+ localClass_c_032.unitName,
														this.someGWidth, 2000));
									}
								}
							}
						} else if (this.var_35eb != null) {
							if (this.time - this.var_35fb >= 400L) {
								this.var_35eb.removeFromMap();
								(localClass_c_032 = C_Unit.createUnitOnMap(
										(byte) 10, this.var_35f3,
										this.var_35eb.positionX,
										this.var_35eb.positionY)).endMove();
								this.var_35eb = null;
							}
						} else if (!this.var_3b7b) {
							if (this.activeUnitState == 2) {
								if ((this.activeUnit.m_state != 1)
										&& (this.var_39cb)) {
									sub_91c4(this.activeUnit);
								}
							} else if (this.var_35b3[this.playerId] == 0) {
								sub_ebb9();
							} else if (sub_4789()) {
								if ((this.canApplyMb)
										&& (A_MenuBase.mainCanvas
												.someActionCodeIsSet(var_3333))) {
									A_MenuBase.mainCanvas.addActionCode(16);
									A_MenuBase.mainCanvas.clearActionCode(var_3333);
								}
								if ((this.activeUnitState == 6)
										|| (this.activeUnitState == 7)) {
									if ((A_MenuBase.mainCanvas.invertActionCode(4))
											|| (A_MenuBase.mainCanvas.invertActionCode(1))) {
										this.var_34eb -= 1;
										if (this.var_34eb < 0) {
											this.var_34eb = (this.var_34f3.length - 1);
										}
										A_MenuBase.mainCanvas.clearActionCode(4);
										A_MenuBase.mainCanvas.clearActionCode(1);
										this.var_369b = true;
									} else if ((A_MenuBase.mainCanvas.invertActionCode(8))
											|| (A_MenuBase.mainCanvas.invertActionCode(2))) {
										this.var_34eb += 1;
										if (this.var_34eb >= this.var_34f3.length) {
											this.var_34eb = 0;
										}
										A_MenuBase.mainCanvas.clearActionCode(8);
										A_MenuBase.mainCanvas.clearActionCode(2);
										this.var_369b = true;
									}
									moveCursorToPos(
											this.var_34f3[this.var_34eb].positionX,
											this.var_34f3[this.var_34eb].positionY);
									if (this.var_369b) {
										this.var_3753 = getSomeUnit(this.var_34ab,
												this.var_34b3, (byte) 0);
										this.var_3983 = true;
									}
									if (A_MenuBase.mainCanvas.invertActionCode(16)) {
										if (this.activeUnitState == 6) {
											sub_55bd(
													this.activeUnit,
													this.var_34f3[this.var_34eb]);
										} else if (this.activeUnitState == 7) {
											sub_b6fe(
													this.var_34f3[this.var_34eb],
													this.playerId);
											this.activeUnit.endMove();
											this.activeUnitState = 0;
										}
										this.someGameMenu = null;
										this.var_351b = false;
										this.var_3523 = false;
										this.canCancelMb = false;
										this.canApplyMb = false;
									}
									this.var_369b = false;
								} else {
									if ((this.time - this.var_33ab >= 150L)
											&& (this.cursorSprite.posXPixel % 24 == 0)
											&& (this.cursorSprite.posYPixel % 24 == 0)) {
										if ((A_MenuBase.mainCanvas.invertActionCode(4))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(4))) {
											if (this.var_34ab > 0) {
												this.var_34ab -= 1;
											}
											this.var_369b = true;
											this.var_33ab = this.time;
										} else if ((A_MenuBase.mainCanvas
												.invertActionCode(8))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(8))) {
											if (this.var_34ab < this.mapWidth - 1) {
												this.var_34ab += 1;
											}
											this.var_369b = true;
											this.var_33ab = this.time;
										}
										if ((A_MenuBase.mainCanvas.invertActionCode(1))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(1))) {
											if (this.var_34b3 > 0) {
												this.var_34b3 -= 1;
											}
											this.var_369b = true;
											this.var_33ab = this.time;
										} else if ((A_MenuBase.mainCanvas
												.invertActionCode(2))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(2))) {
											if (this.var_34b3 < this.mapHeight - 1) {
												this.var_34b3 += 1;
											}
											this.var_369b = true;
											this.var_33ab = this.time;
										}
										if (this.var_369b) {
											if (this.activeUnitState == 1) {
												if (this.someMapData[this.var_34ab][this.var_34b3] > 0) {
													this.var_353b = this.activeUnit
															.sub_1b48(
																	this.activeUnit.positionX,
																	this.activeUnit.positionY,
																	this.var_34ab,
																	this.var_34b3);
												}
											} else {
												this.var_3753 = getSomeUnit(
														this.var_34ab,
														this.var_34b3, (byte) 0);
											}
											this.var_3983 = true;
										}
										this.var_369b = false;
									}
									if (((this.activeUnitState == 1) || (this.activeUnitState == 0))
											&& (A_MenuBase.mainCanvas
													.invertActionCode(256))) {
										if ((localClass_c_032 = getSomeUnit(
												this.var_34ab, this.var_34b3,
												(byte) 0)) != null) {
											D_Menu localObject41 = new D_Menu(
													(byte) 15, 15);
											localObject41.var_11b5 = this.someGHeight;
											i7 = 0;
											D_Menu localClass_d_0234 = new D_Menu(
													(byte) 5, 2);
											D_Menu localClass_d_0235;
											(localClass_d_0235 = new D_Menu(
													(byte) 10, 1)).var_1125 = true;
											String str = A_MenuBase
													.getLangString(184 + localClass_c_032.unitTypeId);
											if (localClass_c_032.status != 0) {
												StringBuffer localStringBuffer = new StringBuffer(
														A_MenuBase.getLangString(98));
												if ((localClass_c_032.status & 0x2) != 0) {
													localStringBuffer
															.append('\n');
													localStringBuffer
															.append(A_MenuBase
																	.getLangString(100));
												}
												if ((localClass_c_032.status & 0x1) != 0) {
													localStringBuffer
															.append('\n');
													localStringBuffer
															.append(A_MenuBase
																	.getLangString(99));
												}
												localStringBuffer
														.append("\n-----------\n");
												str = localStringBuffer
														.toString() + str;
											}
											localClass_d_0235
													.createDescDialogMb(
															null,
															str,
															this.someGWidth,
															this.someGHeight
																	- localClass_d_0234.menuHeight);
											((D_Menu) localObject41)
													.addChildMenu(
															localClass_d_0234,
															0, 0, 0);
											((D_Menu) localObject41)
													.addChildMenu(
															localClass_d_0235,
															0,
															localClass_d_0234.menuHeight,
															0);
											((D_Menu) localObject41).updateAllChildrenBoolMb = true;
											((D_Menu) localObject41)
													.setParentMenu(this);
											A_MenuBase.mainCanvas
													.showMenu((A_MenuBase) localObject41);
										}
										A_MenuBase.mainCanvas.clearActionCode(256);
									}
									if (this.activeUnitState == 1) {
										if ((A_MenuBase.mainCanvas.invertActionCode(16))
												&& (this.activeUnit != null)) {
											localClass_c_032 = getSomeUnit(
													this.var_34ab,
													this.var_34b3, (byte) 0);
											if ((this.someMapData[this.var_34ab][this.var_34b3] > 0)
													&& ((localClass_c_032 == null) || (localClass_c_032 == this.activeUnit))) {
												this.var_3503 = this.activeUnit.positionX;
												this.var_350b = this.activeUnit.positionY;
												this.activeUnit.goToPosition(
														this.var_34ab,
														this.var_34b3, true);
												this.var_39b3 = this.activeUnit;
												this.isCursorVisible = false;
												this.var_351b = false;
												this.var_353b = null;
												this.someGameMenu = null;
												this.canCancelMb = false;
												this.canApplyMb = false;
												this.activeUnitState = 2;
												E_MainCanvas.playMusicLooped(10, 1);
											}
											A_MenuBase.mainCanvas.clearActionCode(16);
										}
									} else if (this.activeUnitState == 0) {
										if (A_MenuBase.mainCanvas.invertActionCode(512)) {
											int i4 = 0;
											C_Unit localObject4 = this.playersKings[this.playerId];
											if ((this.var_3753 != null)
													&& (this.var_3753.unitTypeId == 9)) {
												//
											}
											C_Unit localObject41 = this.var_3593[this.playerId][((this.var_3753.var_b83 + 1) % this.var_359b[this.playerId])];
											for (;;) {
												i4++;
												if ((i4 >= this.var_359b[this.playerId])
														|| (((C_Unit) localObject41).m_state != 3)) {
													break;
												}
												localObject41 = this.var_3593[this.playerId][((localObject41.var_b83 + 1) % this.var_359b[this.playerId])];
											}
											if ((localObject41 != null)
													&& (((C_Unit) localObject41).m_state != 3)) {
												moveCursorToPos(
														((C_Unit) localObject41).positionX,
														((C_Unit) localObject41).positionY);
												sub_b998(
														((F_Sprite) localObject41).posXPixel + 12,
														((F_Sprite) localObject41).posYPixel + 12);
											}
										} else if (A_MenuBase.mainCanvas
												.invertActionCode(32)) {
											if (this.var_3523) {
												fillArrayWithValue(this.someMapData, 0);
												this.var_351b = false;
												this.var_3523 = false;
											} else {
												this.activeUnit = getSomeUnit(
														this.var_34ab,
														this.var_34b3, (byte) 0);
												if (this.activeUnit != null) {
													fillArrayWithValue(this.someMapData, 0);
													this.activeUnit
															.showWhereUnitCanAttack(this.someMapData);
													this.var_3523 = true;
													this.var_351b = true;
													this.alphaWindowWTF = 12;
												}
											}
											A_MenuBase.mainCanvas.clearActionCode(32);
										} else if ((A_MenuBase.mainCanvas
												.invertActionCode(16))
												|| (A_MenuBase.mainCanvas
														.invertActionCode(var_3333))) {
											this.activeUnit = getSomeUnit(
													this.var_34ab,
													this.var_34b3, (byte) 0);
											if ((this.activeUnit != null)
													&& (this.activeUnit.m_state == 0)
													&& (this.activeUnit.playerId == this.playerId)) {
												byte[] localObject21 = sub_9267(
														this.activeUnit, (byte) 1);
												if (localObject21.length > 1) {
													sub_5a85(
															(byte[]) localObject21,
															this.activeUnit);
													E_MainCanvas.playMusicLooped(11, 1);
												} else {
													this.var_3723 = false;
													sub_58af(this.activeUnit);
												}
											} else if ((getTileType(this.var_34ab,
													this.var_34b3) == 9)
													&& (sub_e312(this.var_34ab,
															this.var_34b3,
															this.playerId))) {
												localObject2 = new byte[] { 0 };
												sub_5a85((byte[]) localObject2,
														null);
												E_MainCanvas.playMusicLooped(11, 1);
											} else {
												this.activeUnit = null;
												this.someGameMenu = new D_Menu(
														(byte) 11, 0);
												this.someGameMenu.createMenuListItems(
														this.gameMenuItemsNames, 2, 2,
														-1, this.someGHeight, 20,
														0);
												this.someGameMenu.setParentMenu(this);
												A_MenuBase.mainCanvas
														.showMenu(this.someGameMenu);
												E_MainCanvas.playMusicLooped(11, 1);
											}
											A_MenuBase.mainCanvas.clearActions();
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
		int j = this.mapUnitsSprites.size();
		while (i < j) {
			((C_Unit) this.mapUnitsSprites.elementAt(i)).unitUpdate();
			i++;
		}
		if (this.time - this.var_36a3 >= 300L) {
			this.var_36ab = ((this.var_36ab + 1) % this.var_36bb.length);
			this.allTilesImages[this.var_36b3] = this.var_36bb[this.var_36ab];
			this.var_36a3 = this.time;
		}
		sub_b79b();
		if ((this.canCancelMb) && (A_MenuBase.mainCanvas.someActionCodeIsSet(var_333b))) {
			if (this.activeUnitState == 1) {
				this.activeUnitState = 0;
				fillArrayWithValue(this.someMapData, 0);
				this.var_353b = null;
				this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
				moveCursorToPos(this.activeUnit.positionX, this.activeUnit.positionY);
				this.activeUnit = null;
			} else if ((this.activeUnitState == 6) || (this.activeUnitState == 7)) {
				this.activeUnitState = this.var_34cb;
				fillArrayWithValue(this.someMapData, 0);
				this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
				moveCursorToPos(this.activeUnit.positionX, this.activeUnit.positionY);
				A_MenuBase.mainCanvas.showMenu(this.someGameMenu);
			}
			this.var_351b = false;
			this.var_3523 = false;
			A_MenuBase.mainCanvas.clearActionCode(var_333b);
			this.canCancelMb = false;
			this.canApplyMb = false;
		}
		for (i = this.var_35c3.size() - 1; i >= 0; i--) {
			F_Sprite localObject21 = (F_Sprite) this.var_35c3
					.elementAt(i);
			localObject21.spriteUpdate();
			if (!((F_Sprite) localObject21).var_84c) {
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

	public final void sub_b64d(C_Unit paramClass_c_032) {
		int i = paramClass_c_032.posYPixel + 24;
		showSpriteOnMap(this.smokeSprite, paramClass_c_032.posXPixel, i
				- this.smokeSprite.frameHeight, 0, -2, 1, 100);
		for (int j = 0; j < 5; j++) {
			showSpriteOnMap(this.bigSmokeSprite, paramClass_c_032.posXPixel, i
					- this.bigSmokeSprite.frameHeight, -2 + j,
					E_MainCanvas.getRandomWithin(-4, -1), 1,
					50 + 50 * E_MainCanvas.getRandomMax(4));
		}
		showSpriteOnMap(this.sparkSprite, paramClass_c_032.posXPixel,
				paramClass_c_032.posYPixel, 0, 0, 1, 100);
	}

	public final void sub_b6fe(C_Unit paramClass_c_032, byte paramByte) {
		this.var_35eb = paramClass_c_032;
		this.var_35f3 = paramByte;
		showSpriteOnMap(this.sparkSprite, paramClass_c_032.posXPixel - 8,
				paramClass_c_032.posYPixel - 8, 1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_c_032.posXPixel + 8,
				paramClass_c_032.posYPixel - 8, -1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_c_032.posXPixel - 8,
				paramClass_c_032.posYPixel + 8, 1, -1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_c_032.posXPixel + 8,
				paramClass_c_032.posYPixel + 8, -1, -1, 3, 50);
		this.var_35fb = this.time;
	}

	public final void sub_b79b() {
		if (this.var_39b3 == null) {
			sub_b9f2(this.cursorSprite.posXPixel + 12, this.cursorSprite.posYPixel + 12);
			return;
		}
		sub_b9f2(this.var_39b3.posXPixel + 12, this.var_39b3.posYPixel + 12);
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
		if (this.var_340b > this.someGWidth) {
			if ((i = this.viewportWidth - paramInt) > 0) {
				i = 0;
			} else if (i < this.someGWidth - this.var_340b) {
				i = this.someGWidth - this.var_340b;
			}
		} else {
			i = (this.someGWidth - this.var_340b) / 2;
		}
		return i;
	}

	public final int sub_b913(int paramInt) {
		int i;
		if (this.var_3413 > this.someGHeight) {
			if ((i = this.viewportHeight - paramInt) > 0) {
				i = 0;
			} else if (i < this.someGHeight - this.var_3413) {
				i = this.someGHeight - this.var_3413;
			}
		} else {
			i = (this.someGHeight - this.var_3413) / 2;
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

	public final void moveCursorToPos(int px, int py) {
		this.var_34ab = px;
		this.var_34b3 = py;
		this.cursorSprite.setSpritePosition(px * 24, py * 24);
		this.var_3753 = getSomeUnit(this.var_34ab, this.var_34b3, (byte) 0);
		this.var_3983 = true;
	}

	public final void sub_bbf2(Graphics paramGraphics) {
		int i = -this.var_341b / 24;
		int j;
		if ((j = -this.var_3423 / 24) < 0) {
			j = 0;
		}
		int k = (this.someGWidth - this.var_341b - 1) / 24;
		int m;
		if ((m = (this.someGHeight - this.var_3423 - 1) / 24) >= this.mapHeight) {
			m = this.mapHeight - 1;
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
				int i7 = this.mapTilesIds[i5][i4];
				if ((!this.var_351b) || (this.someMapData[i5][i4] == 0)
						|| (this.alphaWindowWTF > 0)) {
					this.allTilesImages[i7].drawImageExt(paramGraphics, i1, i2);
				}
				if ((this.var_351b) && (this.someMapData[i5][i4] > 0)) {
					if (this.alphaWindowWTF != 0) {
						paramGraphics.clipRect(i1 + this.alphaWindowWTF, i2
								+ this.alphaWindowWTF, 24 - this.alphaWindowWTF * 2,
								24 - this.alphaWindowWTF * 2);
					}
					paramGraphics.drawImage(this.alphaMappedTilesImages[i3][i7], i1, i2, 0);
					if (this.alphaWindowWTF != 0) {
						paramGraphics.setClip(0, 0, this.someGWidth,
								this.someGHeight);
					}
				}
				int i6;
				if (((i6 = i4 + 1) < this.mapHeight)
						&& (this.tilesProps[this.mapTilesIds[i5][i6]] == 9)) {
					this.allTilesImages[28].drawImageExt(paramGraphics, i1, i2);
				}
				i1 += 24;
			}
			i2 += 24;
		}
	}

	public final void paintBlackScreenLoading(Graphics gr) {
		gr.setFont(E_MainCanvas.font8);
		gr.setColor(0);
		gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
		gr.setColor(16777215);
		E_MainCanvas.drawString(gr, A_MenuBase.getLangString(58),
				this.someCanWidth / 2,
				(this.someCanHeight - E_MainCanvas.font8.getHeight()) / 2, 17);
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

	public final void loadIntro(int introId, int paramInt2, int paramInt3)
			throws Exception {
		this.var_3a1b = paramInt2;
		this.var_3a23 = paramInt3;
		if (this.var_3a1b == 3) {
			this.var_3a1b = 1;
		}
		if (this.var_3a23 == 3) {
			this.var_3a23 = 1;
		}
		this.var_3a13 = this.gameMode2Mb;
		try {
			this.introImage = new H_ImageExt("intro" + introId);
		} catch (Exception ex) {
			//
		}
		this.var_39db = E_MainCanvas.var_139c;
		if (this.introImage != null) {
			this.var_3a2b = this.introImage.imageHeight;
			this.waveImageAmplitude = 0;
			this.var_39eb = ((this.someCanHeight - this.introImage.imageHeight) / this.var_39db);
		} else {
			this.var_3a2b = 0;
			this.waveImageAmplitude = 16;
			this.var_39eb = (this.someCanHeight / this.var_39db);
		}
		this.introText = A_MenuBase.wrapText(
				A_MenuBase.getLangString(215 + introId), this.someCanWidth,
				E_MainCanvas.font0);
		this.var_39e3 = (this.someCanHeight - this.var_39db);
		this.var_39f3 = 0;
		this.var_3a0b = false;
		A_MenuBase.mainCanvas.clearActions();
		this.gameMode2Mb = 3;
	}

	public final void sub_c16e(String text) {
		this.var_3a13 = this.gameMode2Mb;
		this.introText = A_MenuBase.wrapText(text, this.someCanWidth, E_MainCanvas.font0);
		this.waveImageAmplitude = 16;
		this.var_3a0b = false;
		this.var_3a1b = 3;
		this.var_3a23 = 3;
		this.var_3a2b = 0;
		this.var_39db = E_MainCanvas.var_139c;
		this.var_39eb = (this.someCanHeight / this.var_39db);
		this.var_39e3 = (this.someCanHeight - this.var_39db);
		this.var_39f3 = 0;
		A_MenuBase.mainCanvas.clearActions();
		this.gameMode2Mb = 3;
	}

	public final void sub_c1eb() {
		if (this.var_3a0b) {
			this.waveImageAmplitude -= 1;
			if (this.waveImageAmplitude < 0) {
				this.waveImageAmplitude = 0;
				this.gameMode2Mb = this.var_3a13;
				this.introImage = null;
				this.introText = null;
			}
		} else {
			if (((this.var_3a1b == 2) && (this.waveImageAmplitude < 40))
					|| ((this.var_3a1b != 2) && (this.waveImageAmplitude < 16))) {
				this.waveImageAmplitude += 1;
			} else {
				this.var_39e3 -= 1;
				if (this.var_39e3 < this.var_3a2b) {
					this.var_39e3 = (this.var_3a2b + this.var_39db - (this.var_3a2b - this.var_39e3));
					this.var_39f3 += 1;
				}
			}
			if ((this.var_39f3 >= this.introText.length)
					|| (A_MenuBase.mainCanvas.someActionCodeIsSet(var_3333))) {
				this.var_3a0b = true;
				if ((this.introImage != null)
						|| (this.var_39f3 < this.introText.length)) {
					if (this.var_3a23 == 2) {
						this.waveImageAmplitude = 40;
						return;
					}
					this.waveImageAmplitude = 16;
					return;
				}
				this.waveImageAmplitude = 0;
			}
		}
	}

	public final void playIntro(Graphics gr) {
		gr.setFont(E_MainCanvas.font0);
		gr.setColor(0); //black
		gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
		if (this.introImage != null) {
			if ((!this.var_3a0b)
					&& (((this.var_3a1b == 2) && (this.waveImageAmplitude >= 40)) || ((this.var_3a1b != 2) && (this.waveImageAmplitude >= 16)))) {
				this.introImage.drawImageExt(gr, 0, 0);
			} else if (((this.var_3a23 == 2) && (this.var_3a0b))
					|| ((this.var_3a1b == 2) && (!this.var_3a0b))) {
				waveImage(gr, this.waveImageAmplitude, 40, 0, this.introImage, 0,
						0, 2);
			} else if (((this.var_3a23 == 3) && (this.var_3a0b))
					|| ((this.var_3a1b == 3) && (!this.var_3a0b))) {
				this.introImage.drawImageExt(gr, 0, 0);
			} else {
				this.introImage.drawImageExt(gr, 0, 0);
				if (this.var_3a0b) {
					if ((this.var_3a23 == 1) && (this.waveImageAmplitude <= 16)) {
						sub_e77a(gr, 0, 16 - this.waveImageAmplitude, 16, 0,
								this.introImage, 0, 0, this.someCanWidth, this.someCanHeight);
					}
				} else if (this.var_3a1b == 0) {
					if (this.waveImageAmplitude <= 16) {
						sub_e77a(gr, 16777215, this.waveImageAmplitude, 16, 1,
								null, 0, 0, this.someCanWidth, this.someCanHeight);
					}
				} else if ((this.var_3a1b == 1) && (this.waveImageAmplitude <= 16)) {
					sub_e77a(gr, 0, this.waveImageAmplitude, 16, 1, null, 0,
							0, this.someCanWidth, this.introImage.imageHeight);
				}
			}
		}
		gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
		int waveAmp = this.waveImageAmplitude;
		if ((this.var_3a0b) && (this.var_3a23 == 2)) {
			waveAmp -= 24;
			if (waveAmp < 0) {
				waveAmp = 0;
			}
		}
		int j = this.var_39e3;
		for (int k = this.var_39f3; (k < this.var_39f3 + this.var_39eb)
				&& (k < this.introText.length)
				&& (j < this.someCanHeight - this.var_39db); k++) {
			int m = this.var_39db;
			if (j < this.var_3a2b + this.var_39db) {
				m = j - this.var_3a2b;
			} else if (j + this.var_39db > this.someCanHeight - this.var_39db) {
				m = this.someCanHeight - this.var_39db - j;
			}
			int n;
			if (m < this.var_39db) {
				n = sub_bfcf(14672074, m, this.var_39db);
			} else {
				n = 14672074;
			}
			if (this.var_3a0b) {
				n = sub_bf33(0, n, waveAmp, 16);
			}
			gr.setColor(n);
			E_MainCanvas.drawString(gr, this.introText[k], this.someCanWidthDiv2,
					j + 3, 17);
			j += this.var_39db;
		}
		if (!this.var_3a0b) {
			drawActionButton(gr, var_3333, 2, this.someCanHeight);
		}
	}

	public final void paintStartLogos(Graphics gr) {
		if (this.introMode == 0) { // ms logo still image
			gr.setColor(16777215); //white
			gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
			waveImage(gr, this.waveImageAmplitude, 40, 0, this.msLogoImage,
					(this.someCanWidth - this.msLogoImage.imageWidth) / 2,
					(this.someCanHeight - this.msLogoImage.imageHeight) / 2, 4);
			return;
		}
		if (this.introMode == 1) { // ms logo waving image
			gr.setColor(16777215); //white
			gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
			waveImage(gr, this.waveImageAmplitude, 40, 0, this.msLogoImage,
					(this.someCanWidth - this.msLogoImage.imageWidth) / 2,
					(this.someCanHeight - this.msLogoImage.imageHeight) / 2, 4);
			return;
		}
		if (this.introMode == 3) { // ae logo
			gr.setColor(0); // black
			gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
			waveImage(gr, this.waveImageAmplitude, 40, 0, this.logoImage, 0, 0,
					1);
			gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			return;
		}
		if (this.introMode == 4) {
			if (this.waveImageAmplitude >= 16) {
				if (this.splashImage != null) {
					this.logoImage.drawImageExt(gr, 0, 0);
					if (this.glowImagePosX != -1) {
						this.glowImage.drawImageExt(gr, 4 + this.glowImagePosX,
								6);
					}
					this.splashImage.drawImageExt(gr, 0, 0);
				} else {
					gr.setColor(0);
					gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
					this.logoImage.drawImageExt(gr, 0, 0);
				}
				if ((this.showPressAnyKey) && (this.splashImage != null)) {
					gr.setColor(16777215); // white
					gr.setFont(E_MainCanvas.font8);
					drawHighlightedString(gr, A_MenuBase.getLangString(59),
							this.someCanWidthDiv2, this.someCanHeight - this.buttonsSprite.frameHeight
									- 1, 33, 16777215, 0); //PRESS ANY KEY
				}
			} else {
				if (this.splashImage != null) {
					this.splashImage.drawImageExt(gr, 0, 0);
				} else {
					gr.setColor(0);
					gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
				}
				gr.setColor(0);
				gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
				this.logoImage.drawImageExt(gr, 0, 0);
			}
		}
	}

	public static final void drawHighlightedString(Graphics gr,
			String string, int inX, int inY, int paramInt3,
			int stringColor, int highlightColor) {
		gr.setColor(highlightColor);
		gr.drawString(string, inX - 1, inY - 1,
				paramInt3);
		gr.drawString(string, inX - 1, inY + 1,
				paramInt3);
		gr.drawString(string, inX + 1, inY + 1,
				paramInt3);
		gr.drawString(string, inX + 1, inY - 1,
				paramInt3);
		gr.setColor(stringColor);
		gr.drawString(string, inX, inY, paramInt3);
	}

	public final void onPaint(Graphics gr) {
		int m;
		if (this.gameMode2Mb == 4) { // loading progress
			gr.setColor(16777215);
			gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
			gr.setFont(E_MainCanvas.font8);
			gr.setColor(0);
			gr.drawString(A_MenuBase.getLangString(58), this.someCanWidth / 2,
					this.someCanHeight / 2 - 1, 33); //LOADING
			int i;
			if ((i = this.someCanHeight / 18) < 12) {
				i = 12;
			}
			m = this.someCanHeight / 2 + 1;
			gr.setColor(13553358); // #CECECE light gray
			D_Menu.sub_35f8(gr, 1, m, this.someCanWidth - 2, i);
			gr.setColor(2370117); // dark blue
			D_Menu.sub_35f8(gr, 2, m + 2, this.loadingProgress
					* (this.someCanWidth - 6) / 100, i - 4);
			return;
		}
		if (this.gameMode2Mb == 2) {
			sub_1480f(gr);
			return;
		}
		if (this.gameMode2Mb == 3) { // intro play
			playIntro(gr);
			return;
		}
		if (this.isBlackLoading) {
			paintBlackScreenLoading(gr);
			return;
		}
		if (this.var_364b) {
			if (this.waveImageAmplitude >= 16) {
				if ((this.activeUnitState != 11) && (this.activeUnitState != 10)) {
					paintBlackScreenLoading(gr);
					return;
				}
				gr.setColor(0);
				gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
				return;
			}
			sub_e77a(gr, 0, this.waveImageAmplitude, 16, this.var_365b, null,
					0, 0, this.someCanWidth, this.someCanHeight);
			return;
		}
		if (this.gameMode2Mb == 0) {
			paintStartLogos(gr);
		} else if (this.activeUnitState == 14) {
			gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			gr.setColor(0);
			gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
		} else if ((this.activeUnitState == 10) && (this.var_3b93 >= 1)) {
			paintBlackScreenLoading(gr);
		} else if ((this.activeUnitState == 11) && (!this.var_364b)) {
			String str1 = A_MenuBase.getLangString(57);
			gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			gr.setFont(E_MainCanvas.font8);
			gr.setColor(0);
			gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
			if (this.mapModeCampIf0 == 0) {
				gr.setColor(16777215);
				if (this.gameOverImage != null) {
					this.gameOverImage.drawImageExt(gr, this.someCanWidthDiv2,
							this.someCanHeightDiv2, 3);
					E_MainCanvas.drawString(gr, str1, this.someCanWidthDiv2,
							this.someCanHeight - 2, 33);
				} else {
					m = this.someCanHeightDiv2 - E_MainCanvas.font8.getHeight() / 2;
					E_MainCanvas.drawString(gr, str1, this.someCanWidthDiv2, m,
							17);
				}
			}
		} else {
			gr.setClip(0, 0, this.someGWidth, this.someGHeight);
			if ((this.var_340b < this.someGWidth)
					|| (this.var_3413 < this.someGHeight)) {
				gr.setColor(0);
				gr.fillRect(0, 0, this.someGWidth, this.someGHeight);
			}
			if (this.var_3bc3) {
				int j = E_MainCanvas.getRandom() % 10;
				m = E_MainCanvas.getRandom() % 4;
				gr.translate(j, m);
				sub_bbf2(gr);
				gr.translate(-j, -m);
			} else {
				sub_bbf2(gr);
			}
			int j = 0;
			m = this.mapUnitsSprites.size();
			while (j < m) {
				C_Unit unit3 = (C_Unit) this.mapUnitsSprites.elementAt(j);
				if (unit3.m_state == 3) {
					this.tombstoneSprite.drawImageExt(gr, this.var_341b
							+ unit3.posXPixel, this.var_3423
							+ unit3.posYPixel);
				} else if (unit3 != this.activeUnit) {
					unit3.sub_252e(gr, this.var_341b,
							this.var_3423);
				}
				j++;
			}
			j = 0;
			m = this.mapUnitsSprites.size();
			while (j < m) {
				((C_Unit) this.mapUnitsSprites.elementAt(j)).sub_26ca(
						gr, this.var_341b, this.var_3423);
				j++;
			}
			int i3;
			int i4;
			if (this.var_353b != null) {
				gr.setColor(14745682);
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
							gr.fillRect(i4 + n, i7 - this.var_3a53,
									m, this.var_3a4b);
						} else if (arrayOfShort2[0] == arrayOfShort1[0] - 1) {
							gr.fillRect(i4, i7 - this.var_3a53, m,
									this.var_3a4b);
						} else if (arrayOfShort2[1] == arrayOfShort1[1] + 1) {
							gr.fillRect(i6 - this.var_3a53, i5 + n,
									this.var_3a4b, m);
						} else if (arrayOfShort2[1] == arrayOfShort1[1] - 1) {
							gr.fillRect(i6 - this.var_3a53, i5,
									this.var_3a4b, m);
						}
					}
					if (i2 == i3 - 1) {
						gr.setClip(0, 0, this.someGWidth,
								this.someGHeight);
						this.var_3453.drawCurrentFrame(gr, i6, i7, 3);
					} else if ((arrayOfShort2 = (short[]) this.var_353b
							.elementAt(i2 + 1))[0] == arrayOfShort1[0] + 1) {
						gr.fillRect(i4 + n, i7 - this.var_3a53, m,
								this.var_3a4b);
					} else if (arrayOfShort2[0] == arrayOfShort1[0] - 1) {
						gr.fillRect(i4, i7 - this.var_3a53, m,
								this.var_3a4b);
					} else if (arrayOfShort2[1] == arrayOfShort1[1] + 1) {
						gr.fillRect(i6 - this.var_3a53, i5 + n,
								this.var_3a4b, m);
					} else if (arrayOfShort2[1] == arrayOfShort1[1] - 1) {
						gr.fillRect(i6 - this.var_3a53, i5,
								this.var_3a4b, m);
					}
					i2++;
				}
			}
			if (this.activeUnit != null) {
				this.activeUnit.sub_252e(gr, this.var_341b,
						this.var_3423);
				this.activeUnit.sub_26ca(gr, this.var_341b,
						this.var_3423);
			}
			if (this.isCursorVisible) {
				this.cursorSprite.drawCurrentFrame(gr, this.var_341b + 12,
						this.var_3423 + 12, 3);
			}
			int k = 0;
			m = this.var_35c3.size();
			while (k < m) {
				F_Sprite localClass_f_045;
				(localClass_f_045 = (F_Sprite) this.var_35c3.elementAt(k))
						.draw(gr, this.var_341b, this.var_3423
								+ localClass_f_045.var_80c);
				k++;
			}
			gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			k = this.someCanHeight - var_32c3;
			if (this.var_378b > 0) {
				D_Menu.sub_5602(gr, 0, k, this.someGWidth,
						var_32c3, 14);
				gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			}
			m = var_32c3 - 24 >> 1;
			int i1 = 24 + m * 2;
			int i2 = this.someCanWidth - i1;
			k += this.var_378b;
			if (this.var_397b) {
				this.var_397b = false;
				D_Menu.sub_562e(gr, 0, k, i2 + 1, var_32c3, 0,
						2370117, playerColors[this.playersIndexes[this.playerId]],
						this.var_378b, var_32c3);
				i3 = this.someCanHeight - var_32c3 / 2 + this.var_378b;
				if (this.mapModeCampIf0 == 1) {
					i4 = i2 / 2;
					this.hudIcons2Sprite.drawFrameAt(gr, 0, i4, i3, 6);
					E_MainCanvas.drawCharedString(
							gr,
							countSomeUnits(-1, -1, this.playerId)
									- countSomeUnits(10, -1, this.playerId) + "/"
									+ this.mapStartUnitCap, i4 + this.hudIcons2Sprite.frameWidth
									+ 1, i3, 1, 6);
				}
				i4 = 10;
				if (this.someGWidth <= 120) {
					i4 = 4;
				}
				this.hudIcons2Sprite.drawFrameAt(gr, 1, i4, i3, 6);
				i4 += this.hudIcons2Sprite.frameWidth + 1;
				if (this.var_35b3[this.playerId] == 1) {
					E_MainCanvas.drawCharedString(gr, ""
							+ this.var_35a3[this.playerId], i4, i3, 1, 6);
				} else {
					E_MainCanvas.drawCharedString(gr, "- - -", i4, i3, 1, 6);
				}
				gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			}
			if (this.var_3983) {
				this.var_3983 = false;
				if (m > 0) {
					drawMenuBorderRect(gr, i2, k, i1, var_32c3);
				}
				i3 = i2 + m;
				i4 = k + m;
				this.allTilesImages[this.mapTilesIds[this.var_34ab][this.var_34b3]]
						.drawImageExt(gr, i3, i4);
				String str2 = "."
						+ var_33e3[getTileType(this.var_34ab, this.var_34b3)];
				E_MainCanvas.drawCharedString(gr, str2, i3 + 24, i4 + 24, 0,
						40);
				if (m == 0) {
					gr.setColor(0);
					gr.drawRect(i3, i4, 24, 24);
				}
			}
			if ((this.activeUnitState == 6)
					&& (this.var_34f3[this.var_34eb].m_state != 4)) {
				i3 = 0;
				if (this.var_34b3 * 24 <= this.someGHeight / 2 - 24) {
					i3 = this.someGHeight - this.buttonsSprite.frameHeight - this.var_3a43
							+ 2;
				}
				drawAttackStatMenu(gr, this.activeUnit,
						this.var_34f3[this.var_34eb], i3);
			}
		}
		if (sub_4789()) {
			if (this.canCancelMb) {
				drawActionButton(gr, var_333b, 1, this.someGHeight);
			}
			if (this.canApplyMb) {
				drawActionButton(gr, var_3333, 0, this.someGHeight);
			}
			if ((this.gameMode2Mb == 1)
					&& ((this.var_35b3[this.playerId] == 0) || (this.activeUnitState == 0))
					&& (this.activeUnitState != 11)) {
				drawActionButton(gr, var_3333, 3, this.someGHeight);
			}
		}
		if ((this.isFadingIn) || (this.var_380b)) {
			sub_e77a(gr, 0, this.fadeInColor, 16,
					this.isFadingIn ? 0 : 1, null, 0, 0, this.someCanWidth,
					this.someCanHeight);
		}
	}

	public final void drawMenuBorderRect(Graphics gr, int inX, int inY, int inW, int inH) {
		gr.setColor(4344163); //#424963 dark gray blue
		gr.fillRect(inX, inY, inW, inH);
		gr.setColor(11384493); //#ADB6AD light green blue
		gr.fillRect(inX + 1, inY + 1, inW - 2, inH - 2);
		gr.setColor(4344163); //#424963 dark gray blue
		gr.fillRect(inX + 3, inY + 3, inW - 6, inH - 6);
	}

	public final void drawAttackStatMenu(Graphics gr, C_Unit unit1, C_Unit unit2, int paramInt) {
		int i = this.var_3a43 - 2;
		gr.setColor(11384493); //#ADB6AD light green blue
		gr.fillRect(0, paramInt, this.someGWidth, i);
		gr.setColor(0); //black
		gr.fillRect(0, i + paramInt, this.someGWidth, 2);
		int k = 0;
		int n = i / 2;
		int i1 = n + paramInt;
		// draw hud icons
		for (int it = 0; it < 3; it++) {
			this.hudIconsSprite.drawFrameAt(gr, it, k + 1, i1, 6);
			k += this.hudIconsSprite.frameWidth + 2;
			int m = paramInt + 1;
			int i2;
			if (it == 0) {
				if (this.someCanWidth <= 132) {
					i2 = 56;
				} else {
					i2 = 61 * this.someGWidth / 176;
				}
			} else if (it == 1) {
				if (this.someCanWidth <= 132) {
					i2 = 28;
				} else {
					i2 = 47 * this.someGWidth / 176;
				}
			} else {
				i2 = this.someGWidth - k;
			}
			for (int it2 = 0; it2 < 2; it2++) {
				C_Unit u1;
				C_Unit u2;
				if (it2 == 0) {
					u1 = unit1;
					u2 = unit2;
				} else {
					u1 = unit2;
					u2 = unit1;
				}
				int i3 = i / 2 - 2;
				gr.setColor(2172994); //#212842 dark blue
				gr.fillRect(k, m, i2, i3); // value line rect
				int i6 = k + 1;
				if ((it == 0) || (this.someCanWidth > 132)) {
					gr
							.setColor(playerColors[this.playersIndexes[u1.playerId]]);
					gr.fillRect(i6, m + 1, 3, i3 - 2);
					i6 += 4;
				}
				int i7 = 0;
				String str = null;
				if (it == 0) {
					if ((it2 == 0)
							|| (unit2.sub_1134(unit1,
									unit1.positionX,
									unit1.positionY))) {
						i7 = u1.sub_e5f(u2);
						str = u1.unitAttackMin + i7 + "-"
								+ (u1.unitAttackMax + i7);
					} else {
						str = "0-0";
					}
				} else if (it == 1) {
					i7 = u1.sub_f43(u2);
					str = "" + (u1.unitDefence + i7);
				} else {
					str = "" + u1.level;
				}
				E_MainCanvas.drawCharedString(gr, str, i6, m + 1, 0);
				if (i7 > 0) {
					this.arrowIconsSprite.drawFrameAt(gr, 1, i6 + 1
							+ E_MainCanvas.getCharedStringWidth((byte) 0, str), m + i3 / 2,
							6);
				} else if (i7 < 0) {
					this.arrowIconsSprite.drawFrameAt(gr, 2, i6 + 1
							+ E_MainCanvas.getCharedStringWidth((byte) 0, str), m + i3 / 2,
							6);
				}
				int i8 = k + i2 - 2;
				if ((it == 0) && ((u1.status & 0x2) != 0)) {
					this.statusSprite
							.drawFrameAt(gr, 1, i8, m + i3 / 2, 10);
					i8 -= this.statusSprite.frameWidth;
				}
				if (((it == 0) || (it == 1))
						&& ((u1.status & 0x1) != 0)) {
					this.statusSprite
							.drawFrameAt(gr, 0, i8, m + i3 / 2, 10);
				}
				m += n;
			}
			k += i2;
		}
	}

	public final void drawActionButton(Graphics gr, int btn1024or2048, int frameInd, int inY) {
		int pX = 0;
		int j = 0;
		if (btn1024or2048 == 1024) {
			j = 36;
		} else if (btn1024or2048 == 2048) {
			pX = this.someCanWidth;
			j = 40;
		}
		this.buttonsSprite.drawFrameAt(gr, frameInd, pX, inY, j);
	}

	public final C_Unit getSomeUnit(int inX, int inY, byte paramByte) {
		int it = 0;
		int count = this.mapUnitsSprites.size();
		while (it < count) {
			C_Unit unit = (C_Unit) this.mapUnitsSprites.elementAt(it);;
			int i;
			int j;
			if (unit.m_state == 1) {
				i = unit.var_ae3;
				j = unit.var_aeb;
			} else {
				i = unit.positionX;
				j = unit.positionY;
			}
			if ((inX == i) && (inY == j)) {
				if ((paramByte == 0) && (unit.m_state != 3)) {
					return unit;
				} else if ((paramByte == 1) && (unit.m_state == 3)) {
					return unit;
				}
			}
			it++;
		}
		return null;
	}

	public final byte getTileType(int paramInt1, int paramInt2) {
		return this.tilesProps[this.mapTilesIds[paramInt1][paramInt2]];
	}

	public final void sub_dd85() {
		E_MainCanvas.stopMusic();
		this.var_354b = 0;
		this.var_378b = 0;
		this.activeUnitState = 8;
		this.someStartTime5 = this.time;
	}

	public final void sub_ddbb() {
		this.kingsPositions[this.playerId][0] = ((byte) this.var_34ab);
		this.kingsPositions[this.playerId][1] = ((byte) this.var_34b3);
		this.currentTurn = ((short) (this.currentTurn + 1));
		this.playerId = ((byte) ((this.playerId + 1) % this.mapMaxPlayersMb));
		if (this.var_35b3[this.playerId] == 2) {
			sub_ddbb();
			return;
		}
		for (int i = this.mapUnitsSprites.size() - 1; i >= 0; i--) {
			C_Unit aunit = (C_Unit) this.mapUnitsSprites.elementAt(i);
			if (aunit.m_state == 3) {
				if (aunit.unitTypeId != 9) {
					C_Unit tempUnit = aunit;
					tempUnit.var_b5b = (byte) (tempUnit.var_b5b - 1);
					if (tempUnit.var_b5b <= 0) {
						aunit.removeFromMap();
					}
				}
			} else {
				aunit.m_state = 0;
				if (((aunit.status & 0x1) != 0) && (aunit.var_b63 == this.playerId)) {
					aunit.applyWispStatusMb((byte) 1);
				}
				if (aunit.playerId == this.playerId) {
					aunit.applyWispStatusMb((byte) 2);
				}
				aunit.var_b93 = 0;
			}
		}
		this.var_3a5b = 0;
		for (int i = 0; i < this.mapTilesIds.length; i++) {
			for (int j = 0; j < this.mapTilesIds[i].length; j++) {
				if (sub_e312(i, j, this.playerId)) {
					if (getTileType(i, j) == 8) {
						this.var_3a5b += 30;
					} else if (getTileType(i, j) == 9) {
						this.var_3a5b += 50;
					}
				}
			}
		}
		this.var_35a3[this.playerId] += this.var_3a5b;
		for (int i = 0; i < this.housesDataArr.length; i++) {
			this.var_3acb[i] = 0;
		}
		if (this.var_35b3[this.playerId] == 1) {
			moveCursorToPos(this.kingsPositions[this.playerId][0],
					this.kingsPositions[this.playerId][1]);
		}
		this.var_369b = true;
		this.var_397b = true;
		if (this.var_35b3[this.playerId] == 0) {
			sub_ea76();
		} else {
			C_Unit.var_a7b = C_Unit.var_a73;
		}
		if ((countSomeUnits(-1, 0, this.playerId) <= 0)
				&& (countPlayerOwnerCastles(this.playerId) == 0)) {
			sub_ddbb();
		}
	}

	public final boolean sub_e065(int paramInt1, int paramInt2,
			C_Unit paramClass_c_032) {
		return (paramClass_c_032.hasProperty((short) 8))
				&& (getTileType(paramClass_c_032.positionX, paramClass_c_032.positionY) == 8)
				&& (this.mapTilesIds[paramClass_c_032.positionX][paramClass_c_032.positionY] < this.houseTileIdStartIndex);
	}

	public final boolean sub_e0c8(int paramInt1, int paramInt2,
			C_Unit unit) {
		if ((unit.hasProperty((short) 8)) //can occupy villages
				&& (getTileType(unit.positionX, unit.positionY) == 8)
				&& (this.mapTilesIds[unit.positionX][unit.positionY] >= this.houseTileIdStartIndex)
				&& (!sub_e2b4(unit.positionX,
						unit.positionY,
						this.var_3573[unit.playerId]))) {
			return true;
		}
		// 16 - occupy town
		return (unit.hasProperty((short) 16)) 
				&& (getTileType(unit.positionX, unit.positionY) == 9)
				&& (!sub_e2b4(unit.positionX,
						unit.positionY,
						this.var_3573[unit.playerId]));
	}

	public final void repairDestroyedHouse(byte paramByte, int inX, int inY) {
		this.mapTilesIds[inX][inY] = paramByte;
	}

	public final void sub_e1a9(int inX, int inY, int paramInt3) {
		if (this.mapTilesIds[inX][inY] >= this.houseTileIdStartIndex) {
			byte var = (byte) (this.houseTileIdStartIndex + paramInt3 * 2 + (this.mapTilesIds[inX][inY] - this.houseTileIdStartIndex) % 2);
			repairDestroyedHouse(var, inX, inY);
		}
	}

	public final int tileOwnerPlayerIndex(int inX, int inY) {
		return houseOwnerPlayerIndex(inX, inY, this.mapTilesIds);
	}

	public final int houseOwnerPlayerIndex(int inX, int inY, byte[][] mapData) {
		if (mapData[inX][inY] >= this.houseTileIdStartIndex) {
			return (mapData[inX][inY] - this.houseTileIdStartIndex) / 2;
		}
		return -1;
	}

	public final int sub_e276(int paramInt) {
		if ((paramInt != -1) && (paramInt != 0)) {
			return this.var_3563[paramInt];
		}
		return -1;
	}

	public final boolean sub_e2b4(int inX, int inY, int paramInt3) {
		int i = sub_e276(tileOwnerPlayerIndex(inX, inY));
		if (i > -1) {
			return paramInt3 == this.var_3573[i];
		}
		return false;
	}

	public final boolean sub_e312(int paramInt1, int paramInt2, int playerId) {
		return tileOwnerPlayerIndex(paramInt1, paramInt2) == this.playersIndexes[playerId];
	}

	public final int countPlayerOwnerCastles(int playerId) {
		int i = 0;
		for (int j = 0; j < this.mapCastlesCount; j++) {
			if (sub_e312(this.var_373b[j][0], this.var_373b[j][1], playerId)) {
				i++;
			}
		}
		return i;
	}

	public final int countSomeUnits(int unitType, int unitState, byte inPlayer) {
		int i = 0;
		int it = 0;
		int length = this.mapUnitsSprites.size();
		while (it < length) {
			C_Unit unit = (C_Unit) this.mapUnitsSprites.elementAt(it);
			if (((unitType == -1) || (unit.unitTypeId == unitType))
					&& (((unitState == -1) && (unit.m_state != 3)) || ((unitState == unit.m_state) && ((inPlayer == -1) || (unit.playerId == inPlayer))))) {
				i++;
			}
			it++;
		}
		return i;
	}

	public final C_Unit[] getUnitsOfTypeStatePlayer(int uType, int unitState, byte uPlayer) {
		Vector localVector = new Vector();
		int i = 0;
		int count = this.mapUnitsSprites.size();
		while (i < count) {
			C_Unit unit = (C_Unit) this.mapUnitsSprites.elementAt(i);
			if (((uType == -1) || (unit.unitTypeId == uType))
					&& (((unitState == -1) && (unit.m_state != 3)) || ((unitState == unit.m_state) && ((uPlayer == -1) || (unit.playerId == uPlayer))))) {
				localVector.addElement(unit);
			}
			i++;
		}
		C_Unit[] units = new C_Unit[localVector.size()];
		localVector.copyInto(units);
		return units;
	}

	public static final void waveImage(Graphics gr, int amplitude,
			int paramInt2, int paramInt3, H_ImageExt image,
			int paramInt4, int paramInt5, int paramInt6) {
		int i;
		int j;
		if (paramInt3 == 0) {
			i = image.imageWidth;
			j = image.imageHeight;
		} else {
			i = image.imageHeight;
			j = image.imageWidth;
		}
		int k = i / 2;
		int m = j / 1;
		int n = i * amplitude / paramInt2;
		int i1 = i * (paramInt2 - amplitude) / (paramInt2 * 4);
		int i3 = 360 * amplitude / paramInt2;
		int i4 = 360 * paramInt6 / m;
		for (int i5 = 0; i5 < m; i5++) {
			int i2 = i1 * A_MenuBase.getSin1024(i3) >> 10;
			if (paramInt3 == 0) {
				gr.setClip(paramInt4 + k - n / 2 + i2, paramInt5
						+ i5 * 1, n, 1);
				image.drawImageExt(gr, paramInt4 + i2,
						paramInt5);
			} else {
				gr.setClip(paramInt4 + i5 * 1, paramInt5 + k - n / 2
						+ i2, 1, n);
				image.drawImageExt(gr, paramInt4, paramInt5
						+ i2);
			}
			i3 += i4;
		}
	}

	public static final void sub_e77a(Graphics gr, int paramInt1,
			int fadeColor, int paramInt3, int paramInt4,
			H_ImageExt image, int paramInt5, int paramInt6,
			int paramInt7, int paramInt8) {
		int i = paramInt7 / 8 + 1;
		int j = paramInt8 / 1;
		int k = paramInt3 - 7;
		for (int m = 0; m < 8; m++) {
			int i2 = fadeColor - m * 1;
			if (i2 < 0) {
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
			E_MainCanvas.setColor(gr, i4 << 24 | paramInt1);
			for (int i5 = 0; i5 < 1; i5++) {
				gr.fillRect(paramInt5 + i3, paramInt6, i1, j);
			}
		}
	}

	public final boolean sub_e943(byte paramByte, int paramInt1, int paramInt2) {
		if ((this.mapStartUnitCap > countSomeUnits(-1, -1, this.playerId)
				- countSomeUnits(10, -1, this.playerId))
				&& (paramByte <= this.var_3703)
				&& (C_Unit.var_bcb[paramByte] <= this.var_35a3[this.playerId])
				&& (C_Unit.var_bcb[paramByte] > 0)) {
			fillArrayWithValue(this.someMapData, 0);
			return C_Unit.sub_1d7b(this.someMapData, paramInt1, paramInt2,
					C_Unit.var_b9b[paramByte], -1, paramByte,
					this.playerId, true);
		}
		return false;
	}

	public final boolean sub_e9d0(C_Unit unit, int paramInt1,
			int paramInt2) {
		if ((this.mapStartUnitCap > countSomeUnits(-1, -1, this.playerId)
				- countSomeUnits(10, -1, this.playerId))
				&& ((unit.unitTypeId <= this.var_3703) || (unit.unitTypeId == 9))
				&& (unit.cost <= this.var_35a3[this.playerId])) {
			fillArrayWithValue(this.someMapData, 0);
			return C_Unit.sub_1d7b(this.someMapData, paramInt1, paramInt2,
					C_Unit.var_b9b[unit.unitTypeId], -1,
					unit.unitTypeId, this.playerId, true);
		}
		return false;
	}

	public final void sub_ea76() {
		C_Unit[] units = getUnitsOfTypeStatePlayer(-1, 0, this.playerId);
		this.var_3b0b = new Vector(units.length);
		for (int i = 0; i < units.length; i++) {
			int j;
			for (j = 0; j < i; j++) {
				C_Unit unit = (C_Unit) this.var_3b0b
						.elementAt(j);
				int k = var_3a63[unit.unitTypeId];
				int m;
				if (((m = var_3a63[units[i].unitTypeId]) < k)
						|| ((m == k) && (units[i].unitHealthMb < unit.unitHealthMb))) {
					this.var_3b0b.insertElementAt(units[i], j);
					break;
				}
			}
			if (j == i) {
				this.var_3b0b.addElement(units[i]);
			}
		}
		this.var_3ab3 = new C_Unit[this.housesDataArr.length];
		this.var_3abb = new byte[this.housesDataArr.length];
		C_Unit.var_a7b = C_Unit.unitTypesCountMb;
		this.var_3a9b = 0;
		this.var_3a6b = 0;
	}

	public final void sub_ebb9() throws Exception {
		if (A_MenuBase.mainCanvas.invertActionCode(var_3333)) {
			showPlayMenu(this.var_3383, this.viewportHeight, this.someGHeight, this);
			A_MenuBase.mainCanvas.clearActions();
			return;
		}
		if (this.var_3b13) {
			return;
		}
		if (this.var_3a6b == 4) {
			if ((this.var_3a83 != null) || (this.var_3a8b != null)) {
				this.var_3a6b = 5;
				this.activeUnit.fillAttackRangeData(this.someMapData, this.activeUnit.positionX,
						this.activeUnit.positionY);
				this.var_3523 = true;
				this.var_351b = true;
				this.aSomeOtherTime = this.time;
				if (this.var_3a83 != null) {
					this.cursorSprite.setFrameSequence(cursorFrameSequences[1]);
					moveCursorToPos(this.var_3a83.positionX, this.var_3a83.positionY);
				} else if (this.var_3a8b != null) {
					moveCursorToPos(this.var_3a8b.positionX, this.var_3a8b.positionY);
				}
			} else {
				int i;
				if (sub_e0c8(this.activeUnit.positionX, this.activeUnit.positionY,
						this.activeUnit)) {
					i = sub_10b21(this.activeUnit.positionX, this.activeUnit.positionY);
					if ((this.var_3b03 != -1) && (this.var_3b03 != i)) {
						this.var_3ab3[this.var_3b03] = this.var_3ab3[i];
						this.var_3ab3[i] = this.activeUnit;
					}
					sub_e1a9(this.activeUnit.positionX, this.activeUnit.positionY,
							this.playersIndexes[this.activeUnit.playerId]);
					A_MenuBase.mainCanvas.showMenu(createDialog(null,
							A_MenuBase.getLangString(73), this.someGHeight, 1000));
					E_MainCanvas.playMusicLooped(9, 1);
					this.activeUnitState = 9;
					this.someStartTime5 = this.time;
				} else if (sub_e065(this.activeUnit.positionX,
						this.activeUnit.positionY, this.activeUnit)) {
					i = sub_10b21(this.activeUnit.positionX, this.activeUnit.positionY);
					if ((this.var_3b03 != -1) && (this.var_3b03 != i)) {
						this.var_3ab3[this.var_3b03] = this.var_3ab3[i];
						this.var_3ab3[i] = this.activeUnit;
					}
					repairDestroyedHouse((byte) this.houseTileIdStartIndex, this.activeUnit.positionX,
							this.activeUnit.positionY);
					A_MenuBase.mainCanvas.showMenu(createDialog(null,
							A_MenuBase.getLangString(74), this.someGHeight, 1000));
					E_MainCanvas.playMusicLooped(9, 1);
					this.activeUnitState = 0;
					this.someStartTime5 = this.time;
				} else {
					this.activeUnitState = 0;
				}
				this.activeUnit.endMove();
				this.activeUnit = null;
				this.var_3a6b = 0;
			}
			this.isCursorVisible = true;
			return;
		}
		if (this.var_3a6b == 5) {
			if (this.time - this.aSomeOtherTime >= 500L) {
				if (this.var_3a83 != null) {
					sub_55bd(this.activeUnit, this.var_3a83);
				} else if (this.var_3a8b != null) {
					sub_b6fe(this.var_3a8b, this.playerId);
					this.var_3a8b = null;
					this.var_3a6b = 7;
					this.activeUnit.endMove();
				}
				this.var_351b = false;
				this.var_3523 = false;
			}
		} else if (this.var_3a6b == 7) {
			if (this.var_35eb == null) {
				this.var_3a6b = 0;
				this.activeUnitState = 0;
			}
		} else if (this.var_3a6b == 6) {
			if (this.time - this.aSomeOtherTime >= 1000L) {
				this.var_3a83 = null;
				this.var_3a6b = 0;
				this.activeUnitState = 0;
			}
		} else {
			if (this.var_3a6b == 2) {
				return;
			}
			Object localObject;
			if (this.var_3a6b == 3) {
				if (this.var_3a9b == 0) {
					if (sub_b7ff(this.activeUnit.posXPixel + 12,
							this.activeUnit.posYPixel + 12)) {
						if ((this.mapModeCampIf0 == 0) && (this.scenarioMapIndex == 7)
								&& (this.activeUnit == this.playersKings[1])) {
							this.var_39b3 = null;
							C_Unit[] localObject1 = getUnitsOfTypeStatePlayer(-1, -1,
									(byte) 0);
							if (localObject1.length > 0) {
								sub_558c(localObject1[E_MainCanvas
										.getRandomMax(localObject1.length)]);
							}
							this.var_3a6b = 4;
							return;
						}
						this.var_3a9b = 1;
						this.aSomeOtherTime = this.time;
					}
				} else if (this.var_3a9b == 1) {
					if (this.time - this.aSomeOtherTime >= 100L) {
						this.var_351b = true;
						this.var_3523 = false;
						this.var_3a9b = 2;
						this.activeUnitState = 1;
						this.aSomeOtherTime = this.time;
					}
				} else if (this.var_3a9b == 2) {
					if (this.time - this.aSomeOtherTime >= 200L) {
						this.var_34ab = this.var_3a73;
						this.var_34b3 = this.var_3a7b;
						this.cursorSprite.setSpritePosition(this.var_3a73 * 24,
								this.var_3a7b * 24);
						this.var_353b = this.activeUnit.sub_1b48(
								this.activeUnit.positionX, this.activeUnit.positionY,
								this.var_34ab, this.var_34b3);
						this.var_3a9b = 3;
						this.aSomeOtherTime = this.time;
					}
				} else if ((this.var_3a9b == 3)
						&& (this.time - this.aSomeOtherTime >= 200L)) {
					this.var_353b = null;
					this.activeUnit.goToPosition(this.var_3a73, this.var_3a7b, true);
					this.var_3a6b = 2;
					this.var_3a9b = 0;
					this.activeUnitState = 2;
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
				for (int i1 = 0; i1 < this.housesDataArr.length; i1++) {
					i2 = this.housesDataArr[i1][0];
					i3 = this.housesDataArr[i1][1];
					if ((getTileType(i2, i3) == 9)
							&& (sub_e312(i2, i3, this.playerId))) {
						if (j == 0) {
							m = i2;
							n = i3;
						}
						j++;
						int i5 = 0;
						int i9;
						for (int i61 = this.mapUnitsSprites.size() - 1; i61 >= 0; i61--) {
							C_Unit localClass_c_032 = (C_Unit) this.mapUnitsSprites
									.elementAt(i61);
							if ((this.var_3573[localClass_c_032.playerId] != this.var_3573[this.playerId])
									&& (localClass_c_032.hasProperty((short) 16))) {
								if ((i9 = Math.abs(localClass_c_032.positionX
										- i2)
										+ Math.abs(localClass_c_032.positionY
												- i3)) < k) {
									k = i9;
									m = i2;
									n = i3;
								}
								i5++;
							}
						}
						if (i5 == 0) {
							for (i6 = 0; i6 < this.housesDataArr.length; i6++) {
								int i8 = this.housesDataArr[i6][0];
								i9 = this.housesDataArr[i6][1];
								int i10;
								if ((getTileType(i8, i9) == 9)
										&& (!sub_e312(i8, i9, this.playerId))
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

					for (int i1 = 0; i1 < this.var_359b[this.playerId]; i1++) {
						if ((this.var_3593[this.playerId][i1] != null)
								&& (this.var_3593[this.playerId][i1].m_state == 3)
								&& (sub_e9d0(this.var_3593[this.playerId][i1],
										m, n))) {
							localObject = sub_8722(
									this.var_3593[this.playerId][i1], m, n);
						}
					}
					if (localObject == null) {
						if ((countSomeUnits(0, -1, this.playerId) < 2)
								&& (sub_e943((byte) 0, m, n))) {
							localObject = sub_8788((byte) 0, m, n);
						} else if ((countSomeUnits(1, -1, this.playerId) < 2)
								&& (sub_e943((byte) 1, m, n))) {
							localObject = sub_8788((byte) 1, m, n);
						} else {
							int i1 = 0;
							i2 = 0;
							int i4;
							for (int pIt = 0; pIt < this.mapMaxPlayersMb; i4 = (byte) (pIt + 1)) {
								if (this.var_3573[pIt] == this.var_3573[this.playerId]) {
									i1 += countSomeUnits(-1, -1, (byte) pIt);
								} else {
									i2 += countSomeUnits(-1, -1, (byte) pIt);
								}
							}
							if ((this.var_35a3[this.playerId] >= 1000)
									|| (countSomeUnits(-1, -1, this.playerId) < 8)
									|| (i1 < i2)) {
								i4 = 0;
								byte[] arrayOfByte = new byte[12];
								int i7;
								for (i6 = 1; i6 < 12; i7 = (byte) (i6 + 1)) {
									if (((countSomeUnits(i6, -1, this.playerId) < 1) || (C_Unit.var_bcb[i6] >= 600))
											&& (sub_e943(i6, m, n))) {
										arrayOfByte[i4] = i6;
										i4++;
									}
								}
								if (i4 > 0) {
									i7 = arrayOfByte[(Math.abs(E_MainCanvas
											.getRandom()) % i4)];
									localObject = sub_8788((byte) i7, m, n);
								}
							}
						}
					}
				}
				if (localObject != null) {
					sub_f66c((C_Unit) localObject);
					return;
				}
				this.var_3aab = null;
				this.var_3b0b = null;
				sub_dd85();
				return;
			}
			if ((this.mapModeCampIf0 == 0) && (this.scenarioMapIndex == 7)
					&& (this.playersKings[1].m_state != 2)) {
				this.activeUnit = this.playersKings[1];
				moveCursorToPos(this.activeUnit.positionX, this.activeUnit.positionY);
				this.var_39b3 = this.activeUnit;
				this.var_3a6b = 3;
				this.var_3b0b.removeElement(this.activeUnit);
				return;
			}
			if ((localObject = this.var_3a93) == null) {
				localObject = (C_Unit) this.var_3b0b.elementAt(0);
			}
			sub_f66c((C_Unit) localObject);
			if (this.var_3a93 == null) {
				this.var_3b0b.removeElement(localObject);
			}
		}
	}

	public final void sub_f66c(C_Unit paramClass_c_032) {
		this.activeUnit = paramClass_c_032;
		this.isCursorVisible = true;
		fillArrayWithValue(this.someMapData, 0);
		this.activeUnit.fillWhereUnitCanMove(this.someMapData);
		this.var_351b = false;
		this.var_3aab = getUnitsOfTypeStatePlayer(0, -1, this.playerId);
		int i = 0;
		int j = this.playersKings.length + this.var_3aab.length
				+ this.housesDataArr.length;
		this.var_3ac3 = new int[j][5];
		this.var_3ad3 = 0;
		int m = 10000;
		this.var_3aeb = -1;
		this.var_3af3 = -1;
		this.var_3afb = -1;
		this.var_3b03 = -1;
		for (int n = 0; n < this.var_3aab.length + this.playersKings.length; n++) {
			C_Unit someKingUnit = null;
			if (n >= this.var_3aab.length) {
				someKingUnit = this.playersKings[(n - this.var_3aab.length)];
				if (someKingUnit != null) {
					if (someKingUnit.m_state == 3) {
						someKingUnit = null;
					} else if ((this.var_3573[someKingUnit.playerId] != this.var_3573[this.playerId])
							&& (this.playersKings[this.playerId] == null)) {
						this.var_3ac3[i][2] += someKingUnit.sub_1318(
								someKingUnit.positionX,
								someKingUnit.positionY, null) * 2;
					} else if ((this.currentTurn >= 15)
							&& (this.var_3573[someKingUnit.playerId] != this.var_3573[this.playerId])
							&& (countSomeUnits(-1, -1, someKingUnit.playerId) < 4)
							&& (countSomeUnits(-1, -1, this.playerId) >= 8)) {
						this.var_3ac3[i][2] += someKingUnit.sub_1318(
								someKingUnit.positionX,
								someKingUnit.positionY, null) * 2;
					} else if (someKingUnit.playerId != this.playerId) {
						someKingUnit = null;
					}
				}
			} else if (this.playersKings[this.playerId] != null) {
				someKingUnit = this.var_3aab[n];
			}
			if (someKingUnit != null) {
				this.var_3ac3[i][0] = someKingUnit.positionX;
				this.var_3ac3[i][1] = someKingUnit.positionY;
				if (someKingUnit.playerId == this.playerId) {
					C_Unit[] sUnit = someKingUnit
							.getPositionUnitsInAttackRange(someKingUnit.positionX,
									someKingUnit.positionY, 1, 5, (byte) 0);
					for (int i3 = 0; i3 < sUnit.length; i3++) {
						if (sUnit[i3].m_state != 4) {
							this.var_3ac3[i][2] += sUnit[i3]
									.sub_1318(sUnit[i3].positionX,
											sUnit[i3].positionY,
											someKingUnit);
						}
					}
				}
				if (this.var_3ac3[i][2] > 0) {
					this.var_3ac3[i][4] += someKingUnit.sub_1318(
							someKingUnit.positionX,
							someKingUnit.positionY, null);
					this.var_3ac3[i][4] += someKingUnit.var_b93;
					if (this.var_3ac3[i][2] > this.var_3ad3) {
						this.var_3ad3 = this.var_3ac3[i][2];
					}
					this.var_3ac3[i][3] = (Math.abs(someKingUnit.positionX
							- paramClass_c_032.positionX) + Math
							.abs(someKingUnit.positionY
									- paramClass_c_032.positionY));
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
		for (int i4 = 0; i4 < this.housesDataArr.length; i4++) {
			i5 = this.housesDataArr[i4][0];
			i6 = this.housesDataArr[i4][1];
			i7 = getTileType(i5, i6);
			boolean bool = sub_e312(i5, i6, paramClass_c_032.playerId);
			this.var_3ac3[i][2] = -6666;
			C_Unit[] localObject;
			int i10;
			if ((bool) || (this.var_3ab3[i4] != null)) {
				localObject = paramClass_c_032.getPositionUnitsInAttackRange(i5, i6, 1, 5, (byte) 0);
				this.var_3ac3[i][0] = i5;
				this.var_3ac3[i][1] = i6;
				this.var_3ac3[i][2] = 0;
				for (i10 = 0; i10 < localObject.length; i10++) {
					if (localObject[i10].m_state != 4) {
						if ((this.var_3ab3[i4] != null) && (!bool)) {
							this.var_3ac3[i][2] += localObject[i10].sub_1318(
									localObject[i10].positionX,
									localObject[i10].positionY, null);
						} else if (((i7 == 8) && (localObject[i10]
								.hasProperty((short) 8)))
								|| ((i7 == 9) && (localObject[i10]
										.hasProperty((short) 16)))) {
							this.var_3ac3[i][2] += localObject[i10].sub_1318(
									localObject[i10].positionX,
									localObject[i10].positionY, null);
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
							- paramClass_c_032.positionX) + Math.abs(i6
							- paramClass_c_032.positionY));
					if (this.var_3ac3[i][3] < 1) {
						this.var_3ac3[i][3] = 1;
					}
					if (this.var_3ac3[i][3] < m) {
						m = this.var_3ac3[i][3];
					}
				}
			}
			if (sub_e2b4(i5, i6, this.var_3573[paramClass_c_032.playerId])) {
				C_Unit localObject1 = getSomeUnit(i5, i6, (byte) 0);
				if ((((localObject1) == null) || (((C_Unit) localObject1).playerId == paramClass_c_032.playerId))
						&& ((i10 = Math.abs(i5 - paramClass_c_032.positionX)
								+ Math.abs(i6 - paramClass_c_032.positionY)) < i1)) {
					i3 = i4;
					i1 = i10;
				}
			} else if (((this.var_3ab3[i4] == null) || (this.var_3ab3[i4] == paramClass_c_032))
					&& (((i7 == 8) && (paramClass_c_032.hasProperty((short) 8))) || ((i7 == 9) && (paramClass_c_032
							.hasProperty((short) 16))))) {
				int i9;
				if ((i9 = Math.abs(i5 - paramClass_c_032.positionX)
						+ Math.abs(i6 - paramClass_c_032.positionY)) < n) {
					i2 = i4;
					n = i9;
				}
				C_Unit localClass_c_0324 = getSomeUnit(i5, i6, (byte) 0);
				if ((i9 < i1)
						&& (this.someMapData[i5][i6] > 0)
						&& ((localClass_c_0324 == null) || (localClass_c_0324.playerId == paramClass_c_032.playerId))) {
					i3 = i4;
					i1 = i9;
				}
			}
			i++;
		}
		int i4;
		if ((paramClass_c_032.unitHealthMb < 50) && (i3 != -1)) {
			if (i3 == i2) {
				this.var_3b03 = i2;
			}
			this.var_3ab3[i3] = paramClass_c_032;
			this.var_3aeb = this.housesDataArr[i3][0];
			this.var_3af3 = this.housesDataArr[i3][1];
			fillArrayWithValue(this.var_3adb, 0);
			C_Unit.sub_1d7b(this.var_3adb, this.var_3aeb, this.var_3af3,
					10, -1, paramClass_c_032.unitTypeId, this.playerId, false);
		} else if ((this.playersKings[this.playerId] != null)
				&& (i2 != -1)
				&& ((paramClass_c_032.hasProperty((short) 8)) || (paramClass_c_032
						.hasProperty((short) 16)))) {
			this.var_3b03 = i2;
			this.var_3ab3[i2] = paramClass_c_032;
			this.var_3aeb = this.housesDataArr[i2][0];
			this.var_3af3 = this.housesDataArr[i2][1];
			fillArrayWithValue(this.var_3adb, 0);
			C_Unit.sub_1d7b(this.var_3adb, this.var_3aeb, this.var_3af3,
					10, -1, paramClass_c_032.unitTypeId, this.playerId, false);
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
				int i61 = paramClass_c_032.sub_1318(paramClass_c_032.positionX,
						paramClass_c_032.positionY, null);
				if (i4 < this.var_3aab.length) {
					this.var_3aab[i4].var_b93 += i61;
				} else if (i4 < this.playersKings.length + this.var_3aab.length) {
					this.playersKings[(i4 - this.var_3aab.length)].var_b93 += i61;
				} else {
					this.var_3afb = (i4 - this.playersKings.length - this.var_3aab.length);
					this.var_3acb[this.var_3afb] += i61;
				}
				this.var_3aeb = this.var_3ac3[i4][0];
				this.var_3af3 = this.var_3ac3[i4][1];
				fillArrayWithValue(this.var_3adb, 0);
				C_Unit.sub_1d7b(this.var_3adb, this.var_3aeb,
						this.var_3af3, 10, -1, paramClass_c_032.unitTypeId,
						this.playerId, false);
			}
		}
		i4 = -10000;
		int i51 = 0;
		int i61 = this.someMapData.length;
		while (i51 < i61) {
			i7 = 0;
			int i8 = this.someMapData[i51].length;
			while (i7 < i8) {
				C_Unit lcUnit;
				if ((this.someMapData[i51][i7] > 0)
						&& (((lcUnit = getSomeUnit(i51, i7, (byte) 0)) == null)
								|| (lcUnit == paramClass_c_032) || ((this.var_3a93 == null)
								&& (lcUnit.playerId == paramClass_c_032.playerId) && (lcUnit.m_state == 0)))) {
					int i11;
					if ((!paramClass_c_032.hasProperty((short) 512))
							|| (lcUnit == paramClass_c_032)) {
						C_Unit[] arrayOfClass_c_0322 = paramClass_c_032
								.getActiveUnitsInAttackRange(i51, i7, (byte) 0);
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
					if (paramClass_c_032.hasProperty((short) 32)) {
						this.var_34f3 = paramClass_c_032.getActiveUnitsInAttackRange(i51, i7,
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
		C_Unit localClass_c_0322;
		if (((localClass_c_0322 = getSomeUnit(this.var_3a73, this.var_3a7b,
				(byte) 0)) != null) && (localClass_c_0322 != paramClass_c_032)) {
			this.var_3a93 = localClass_c_0322;
			this.var_3a6b = 0;
			return;
		}
		moveCursorToPos(paramClass_c_032.positionX, paramClass_c_032.positionY);
		this.var_39b3 = paramClass_c_032;
		this.var_3a6b = 3;
	}

	public final int sub_1062b(C_Unit cUnit21, int paramInt1,
			int paramInt2, C_Unit cUnit1,
			C_Unit paramClass_c_0323) {
		int i = 0;
		int m;
		if ((this.var_3b03 != -1)
				&& (this.playersKings[cUnit21.playerId] != null)) {
			if (this.var_3aeb != -1) {
				if (this.var_3adb[paramInt1][paramInt2] > 0) {
					i = 0 + (100 + 100 * this.var_3adb[paramInt1][paramInt2] / 10);
				} else {
					int j = Math.abs(this.var_3aeb - cUnit21.positionX)
							+ Math.abs(this.var_3af3
									- cUnit21.positionY);
					m = Math.abs(this.var_3aeb - paramInt1)
							+ Math.abs(this.var_3af3 - paramInt2);
					i = 0
							+ 100
							* (j - m)
							/ (C_Unit.var_b9b[cUnit21.unitTypeId] - 1);
					if (var_33eb[getTileType(paramInt1, paramInt2)] <= 1) {
						i += 20;
					}
				}
			}
			if ((cUnit1 == null)
					&& (!sub_e2b4(paramInt1, paramInt2,
							this.var_3573[cUnit21.playerId]))) {
				if ((cUnit21.hasProperty((short) 16))
						&& (getTileType(paramInt1, paramInt2) == 9)) {
					i += 300;
				} else if ((cUnit21.hasProperty((short) 8))
						&& ((getTileType(paramInt1, paramInt2) == 8) || (this.mapTilesIds[paramInt1][paramInt2] == 27))) {
					i += 200;
				}
			}
		}
		switch (cUnit21.unitTypeId) {
		case 3:
			if (paramClass_c_0323 != null) {
				i += 100;
			}
			break;
		case 4:
			C_Unit[] arrayOfClass_c_032 = cUnit21.getPositionUnitsInAttackRange(
					paramInt1, paramInt2, 1, 2, (byte) 2);
			if (paramClass_c_0323 != null) {
				i += 25 * arrayOfClass_c_032.length;
			}
			break;
		case 2:
			if (getTileType(paramInt1, paramInt2) == 5) {
				i += 25;
			}
			break;
		}
		if (cUnit1 != null) {
			if (cUnit1.m_state == 4) {
				int k = tileOwnerPlayerIndex(cUnit1.positionX, cUnit1.positionY);
				m = sub_10b21(cUnit1.positionX, cUnit1.positionY);
				if ((k != 0) && (m != -1) && (this.var_3ab3[m] == null)) {
					i += cUnit21.sub_1318(paramInt1, paramInt2, cUnit1) / 2;
				}
			} else {
				if (!cUnit1.sub_1134(cUnit21, paramInt1,
						paramInt2)) {
					i += cUnit21.sub_1318(paramInt1, paramInt2,
							cUnit1) * 2;
				} else {
					i += cUnit21.sub_1318(paramInt1, paramInt2,
							cUnit1)
							* 3
							/ 2
							- cUnit1.sub_1318(paramInt1, paramInt2,
									cUnit21);
				}
				if (cUnit1.unitTypeId == 9) {
					i += 25;
				} else if (cUnit1.unitTypeId == 11) {
					i += 100;
				}
			}
		}
		i += var_33e3[getTileType(paramInt1, paramInt2)];
		if ((cUnit21.unitHealthMb < 100)
				&& (sub_e2b4(paramInt1, paramInt2,
						this.var_3573[cUnit21.playerId]))) {
			i += 100 - cUnit21.unitHealthMb;
		}
		int k = sub_10b21(paramInt1, paramInt2);
		int n;
		if (this.var_3adb[paramInt1][paramInt2] > 0) {
			m = this.var_3adb[paramInt1][paramInt2];
			n = 10 - C_Unit.var_b9b[cUnit21.unitTypeId] / 2;
			if (m > n) {
				m = n;
			}
			i += 50 + 100 * m / n;
		} else if (this.var_3aeb != -1) {
			m = Math.abs(this.var_3aeb - cUnit21.positionX)
					+ Math.abs(this.var_3af3 - cUnit21.positionY);
			n = Math.abs(this.var_3aeb - paramInt1)
					+ Math.abs(this.var_3af3 - paramInt2);
			i += 50 * (m - n)
					/ (C_Unit.var_b9b[cUnit21.unitTypeId] - 1);
		}
		C_Unit localClass_c_032;
		if ((k != -1)
				&& ((localClass_c_032 = this.var_3ab3[k]) != null)
				&& (localClass_c_032 != cUnit21)
				&& (localClass_c_032.m_state == 0)
				&& (this.var_3abb[k] < C_Unit.var_b9b[localClass_c_032.unitTypeId])) {
			i -= 200;
		}
		return i += 20
				* (Math.abs(paramInt1 - cUnit21.positionX) + Math
						.abs(paramInt2 - cUnit21.positionY))
				/ (C_Unit.var_b9b[cUnit21.unitTypeId] - 1);
	}

	public final int sub_10b21(int paramInt1, int paramInt2) {
		for (int i = 0; i < this.housesDataArr.length; i++) {
			if ((this.housesDataArr[i][0] == paramInt1)
					&& (this.housesDataArr[i][1] == paramInt2)) {
				return i;
			}
		}
		return -1;
	}

	public final void waitScript(int val) {
		this.waitTimeValue = val;
		this.isWaiting = true;
	}

	public final D_Menu showUnitDialogMsg(String msg, byte paramByte1, byte paramByte2) {
		D_Menu dialog = new D_Menu((byte) 7, 12);
		int i = E_MainCanvas.someMenuShiftHeight * 3;
		dialog.sub_1a04(msg, this.someCanWidth, i, paramByte1, paramByte2);
		dialog.sub_193f(0, this.someCanHeight - i, 0);
		A_MenuBase.mainCanvas.showMenu(dialog);
		return dialog;
	}

	public final D_Menu createDialog(String header,
			String msg, int paramInt1, int showTime) {
		return createDialog(header, msg, paramInt1, -1, showTime);
	}

	public final D_Menu createDialog(String header,
			String msg, int paramInt1, int paramInt2, int showTime) {
		D_Menu localClass_d_023;
		(localClass_d_023 = new D_Menu((byte) 10, 12)).createDescDialogMb(
				header, msg, this.someCanWidth, paramInt2);
		localClass_d_023.sub_193f(this.someCanWidthDiv2, paramInt1 / 2, 3);
		localClass_d_023.parentMenu = this;
		localClass_d_023.var_10c5 = showTime;
		return localClass_d_023;
	}

	public final void sub_10c83() throws Exception {
		this.var_3b4b = null;
		if (this.mapModeCampIf0 == 0) {
			this.var_378b = var_32c3;
			this.var_3793 = true;
			this.isUpdatingMb = false;
			this.mapNameDialog = createDialog(null, this.mapName, this.someCanHeight, 2000);
			this.mapNameDialog.sub_193f(this.someCanWidthDiv2, this.someCanHeightDiv2, 3);
			this.isFading = true;
			this.var_380b = true;
			this.fadeInColor = 0;
		}
		if (this.scenarioMapIndex == 0) {
			this.var_3703 = 0;
			this.var_35a3[0] = 0;
			this.var_35a3[1] = 0;
			C_Unit.var_a7b = 4;
			this.var_39bb = 2;
			sub_b9c5(this.playersKings[0].positionX, this.playersKings[0].positionY);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			loadIntro(2, 3, 3);
			E_MainCanvas.playMusicLooped2(1, 1);
			this.isFading = false;
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		if (this.scenarioMapIndex == 1) {
			this.var_3703 = 1;
			this.var_35a3[0] = 300;
			this.var_35a3[1] = 50;
			C_Unit.var_a7b = 4;
			this.var_39bb = 2;
			this.playersKings[0].setKingName(2);
			sub_b9c5(this.playersKings[0].positionX, this.playersKings[0].positionY);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			getSomeUnit(7, 12, (byte) 0).goToPosition(7, 10, false);
			getSomeUnit(8, 11, (byte) 0).goToPosition(8, 9, false);
			getSomeUnit(9, 12, (byte) 0).goToPosition(9, 10, false);
			moveCameraTo(7, 3);
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			return;
		}
		if (this.scenarioMapIndex == 2) {
			this.var_3703 = 0;
			this.var_35a3[0] = 0;
			this.var_35a3[1] = 0;
			C_Unit.var_a7b = 4;
			this.var_35a3[0] = 0;
			sub_b9c5(this.playersKings[0].positionX, this.playersKings[0].positionY);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			this.skeleton1Map2 = getSomeUnit(8, 17, (byte) 0);
			this.crystalOfWisdom = getSomeUnit(8, 18, (byte) 0);
			this.skeleton2Map2 = getSomeUnit(8, 19, (byte) 0);
			this.skeleton1Map2.goToPosition(8, 15, false);
			this.crystalOfWisdom.goToPosition(8, 15, false);
			this.skeleton2Map2.goToPosition(8, 15, false);
			this.playersKings[0].goToPosition(8, 14, false);
			this.isCursorVisible = false;
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.scriptStep = 0;
			return;
		}
		if (this.scenarioMapIndex == 3) {
			this.var_3703 = 7;
			C_Unit.var_a7b = 4;
			this.var_35a3[0] = 400;
			this.var_35a3[1] = 400;
			this.skeleton1Map2 = C_Unit.createUnitOnMap((byte) 0, (byte) 0, -1, 5);
			this.crystalOfWisdom = C_Unit.createUnitOnMap((byte) 2, (byte) 0, -2, 5);
			this.skeleton2Map2 = C_Unit.createUnitOnMap((byte) 3, (byte) 0, -3, 5);
			this.skeleton1Map2.goToPosition(3, 4, false);
			this.crystalOfWisdom.goToPosition(4, 4, false);
			this.skeleton2Map2.goToPosition(2, 4, false);
			this.playersKings[0].goToPosition(3, 3, false);
			sub_b9c5(this.playersKings[0].positionX, this.playersKings[0].positionY);
			moveCursorToPos(3, 3);
			this.var_39b3 = this.playersKings[0];
			loadIntro(3, 3, 3);
			E_MainCanvas.playMusicLooped2(1, 1);
			this.isFading = false;
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		C_Unit localClass_c_0321;
		if (this.scenarioMapIndex == 4) {
			this.var_3703 = 0;
			this.var_35a3[0] = 0;
			this.var_35a3[1] = 0;
			sub_b998(this.playersKings[0].posXPixel + 12,
					this.playersKings[0].posYPixel + 12);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			C_Unit.var_a7b = 4;
			(localClass_c_0321 = getSomeUnit(11, 2, (byte) 0)).setUnitPosition(11, -3);
			localClass_c_0321.goToPosition(11, 2, false);
			(localClass_c_0321 = getSomeUnit(10, 1, (byte) 0)).setUnitPosition(10, -5);
			localClass_c_0321.goToPosition(10, 1, false);
			(localClass_c_0321 = getSomeUnit(11, 1, (byte) 0)).setUnitPosition(11, -5);
			localClass_c_0321.goToPosition(11, 1, false);
			(localClass_c_0321 = getSomeUnit(12, 1, (byte) 0)).setUnitPosition(12, -5);
			localClass_c_0321.goToPosition(12, 1, false);
			(localClass_c_0321 = getSomeUnit(11, 0, (byte) 0)).setUnitPosition(11, -7);
			localClass_c_0321.goToPosition(11, 0, false);
			(localClass_c_0321 = getSomeUnit(12, 0, (byte) 0)).setUnitPosition(12, -7);
			localClass_c_0321.goToPosition(12, 0, false);
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		if (this.scenarioMapIndex == 5) {
			this.var_3703 = 7;
			this.var_35a3[0] = 600;
			this.var_35a3[1] = 600;
			this.playersKings[0].setKingName(2);
			sub_b9c5(5, 0);
			moveCursorToPos(5, 0);
			this.var_39bb = 4;
			moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		C_Unit localClass_c_0322;
		C_Unit localClass_c_0323;
		if (this.scenarioMapIndex == 6) {
			this.var_3703 = 8;
			C_Unit.var_a7b = 4;
			this.var_35a3[0] = 400;
			this.var_35a3[1] = 600;
			localClass_c_0321 = C_Unit.createUnitOnMap((byte) 0, (byte) 0, 13, -1);
			localClass_c_0322 = C_Unit.createUnitOnMap((byte) 1, (byte) 0, 13, -1);
			localClass_c_0323 = C_Unit.createUnitOnMap((byte) 3, (byte) 0, 13, -1);
			C_Unit localClass_c_0324 = C_Unit.createUnitOnMap((byte) 11,
					(byte) 0, 13, -1);
			this.playersKings[0].followerUnitMb = localClass_c_0321;
			localClass_c_0321.followerUnitMb = localClass_c_0322;
			localClass_c_0322.followerUnitMb = localClass_c_0323;
			localClass_c_0323.followerUnitMb = localClass_c_0324;
			this.playersKings[0].fillWhereUnitCanMove(this.someMapData);
			this.playersKings[0].goToPosition(14, 3, true);
			sub_b9c5(this.playersKings[0].positionX, this.playersKings[0].positionY);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			this.var_39b3 = this.playersKings[0];
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		if (this.scenarioMapIndex == 7) {
			this.var_3703 = 8;
			C_Unit.var_a7b = 4;
			this.var_35a3[0] = 800;
			this.var_35a3[1] = 200;
			(localClass_c_0321 = getSomeUnit(7, 4, (byte) 0)).setKingName(3);
			this.playersKings[1] = localClass_c_0321;
			localClass_c_0322 = getSomeUnit(8, 15, (byte) 0);
			this.playersKings[0] = localClass_c_0322;
			localClass_c_0322.setKingName(0);
			(localClass_c_0323 = getSomeUnit(6, 15, (byte) 0)).setKingName(2);
			sub_b998(this.playersKings[0].posXPixel + 12,
					this.playersKings[0].posYPixel + 12);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			loadIntro(4, 3, 3);
			E_MainCanvas.playMusicLooped2(1, 1);
			this.isFading = false;
			this.isCursorVisible = false;
			this.scriptStep = 0;
		}
	}

	public final void updateMapScript() throws Exception {
		if ((this.waitTimeValue > 0) && (--this.waitTimeValue > 0)) {
			return;
		}
		if (this.var_3b7b) {
			if (this.scriptStep == 0) {
				this.var_364b = true;
				this.waveImageAmplitude = 0;
				this.activeUnitState = 11;
				this.scriptStep = 1;
			}
			return;
		}
		int i;
		int j;
		String str2;
		String str3;
		if (this.mapModeCampIf0 == 1) {//skirmish
			if (this.scriptStep == 100) {
				E_MainCanvas.playMusicLooped2(var_33c3[this.playersIndexes[this.playerId]], 0);
				this.startupMessageBox.setMenuActionEnabled((byte) 0, true);
				this.startupMessageBox.setParentMenu(null);
				A_MenuBase.mainCanvas.showMenu(this.startupMessageBox);
				this.scriptStep += 1;
				return;
			}
			if (this.scriptStep == 101) {
				i = -1;
				j = -1;
				int n = 1;
				for (int i1 = 0; i1 < this.mapMaxPlayersMb; i1++) {
					if ((this.var_35b3[i1] != 2)
							&& (((this.playersKings[i1] != null) && (this.playersKings[i1].m_state != 3)) || (countPlayerOwnerCastles(i1) != 0))) {
						j = i1;
						if ((i != -1) && (i != this.var_3573[i1])) {
							n = 0;
							break;
						}
						i = this.var_3573[i1];
					}
				}
				if (n != 0) {
					this.isUpdatingMb = false;
					this.isCursorVisible = false;
					str2 = A_MenuBase.replaceStringFirst(38, "" + (this.var_3573[j] + 1)); //Team %U
					str3 = A_MenuBase.replaceStringFirst(81, str2) + "\n("; //%U WINS!
					for (int pIndex = 0; pIndex < this.mapMaxPlayersMb; pIndex++) {
						if ((this.var_35b3[pIndex] != 2) && (this.var_3573[pIndex] == this.var_3573[j])) {
							str3 = str3 + " " + A_MenuBase.getLangString(88 + this.playersIndexes[pIndex]) + " "; // player color
						}
					}
					str3 = str3 + ")";
					D_Menu teamWinsDialog = createDialog(null, str3, this.someGHeight, this.viewportHeight, -1);
					teamWinsDialog.setParentMenu(this);
					A_MenuBase.mainCanvas.showMenu(teamWinsDialog);
					if (this.var_35b3[j] == 1) {
						E_MainCanvas.playMusicLooped2(6, 1);
					} else {
						E_MainCanvas.playMusicLooped2(7, 1);
					}
					waitScript(15);
					this.scriptStep += 1;
				}
			} else if (this.scriptStep == 102) {
				this.var_364b = true;
				this.waveImageAmplitude = 0;
				this.activeUnitState = 11;
				this.scriptStep += 1;
			}
			return;
		}
		if ((this.gameMode2Mb != 1) || (this.mapModeCampIf0 != 0) || (this.scriptStep == -1)) {
			return;
		}
		if (this.cameraX != -1) {
			if (sub_b848(this.cameraX, this.cameraY)) {
				this.cameraX = -1;
				this.cameraY = -1;
			} else {
				return;
			}
		}
		if (this.activeUnitState != 11) {
			i = 1;
			for (j = 0; j < this.var_359b[0]; j++) {
				if (this.var_3593[0][j].m_state != 3) {
					i = 0;
					break;
				}
			}
			if ((i != 0) && (countPlayerOwnerCastles(0) == 0)) {
				sub_1447e();
				return;
			}
		}
		
		//@todo scripting is here
		if (this.scenarioMapIndex == 0) {
			updateScenarioScript1();
		} else if (this.scenarioMapIndex == 1) {
			updateScenarioScript2();
		} else if (this.scenarioMapIndex == 2) {
			updateScenarioScript3();
		} else if (this.scenarioMapIndex == 3) {
			updateScenarioScript4();
		} else {
			int m = 0;
			C_Unit[] localObject1 = null;
			if (this.scenarioMapIndex == 4) {
				if (this.var_3b4b == null) {
					this.var_3b4b = getUnitsOfTypeStatePlayer(11, -1, (byte) 0)[0];
				}
				if ((this.scriptStep == 25) && (this.var_3b4b.positionX >= 15)
						&& (this.var_3b4b.positionY >= 11)
						&& (this.var_3b4b.m_state == 2)) {
					waitScript(10);
					this.isUpdatingMb = false;
					this.isCursorVisible = false;
					this.scriptStep = 26;
					return;
				}
				if (this.var_3b4b.m_state == 3) {
					this.var_3b4b = null;
					sub_1447e();
					return;
				}
				switch (this.scriptStep) {
					case 0:
						waitScript(50);
						this.scriptStep += 1;
						break;
					case 1:
						showUnitDialogMsg(A_MenuBase.getLangString(256), (byte) 5, (byte) 4);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 2:
						showUnitDialogMsg(A_MenuBase.getLangString(257), (byte) 0, (byte) 4);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 3:
						showObjective();
						this.scriptStep += 1;
						break;
					case 4:
						localObject1 = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
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
							if ((localObject1[m].m_state == 2)
									&& (localObject1[m].positionX <= 8)) {
								this.isUpdatingMb = false;
								waitScript(5);
								this.scriptStep += 1;
							} else {
								m++;
								// continue;//@todo
								this.isCursorVisible = false;
								moveCameraTo(4, 4);
								// break;//@todo
								C_Unit.createUnitOnMap((byte) 10, (byte) 1, 4, 4)
										.goToPosition(4, 1, false, true);
								waitScript(10);
								this.scriptStep += 1;
								// break;//@todo
								C_Unit.createUnitOnMap((byte) 1, (byte) 1, 4, 4)
										.goToPosition(5, 2, false, true);
								waitScript(10);
								this.scriptStep += 1;
								// break;//@todo
								C_Unit.createUnitOnMap((byte) 10, (byte) 1, 4, 4)
										.goToPosition(4, 3, false, true);
								waitScript(10);
								this.scriptStep += 1;
								// break;//@todo
								showUnitDialogMsg(A_MenuBase.getLangString(258), (byte) 5,
										(byte) 4);
								moveCameraTo(this.playersKings[0].positionX,
										this.playersKings[0].positionY);
								// break;//@todo
								this.isUpdatingMb = true;
								this.isCursorVisible = true;
								this.scriptStep += 1;
								// break;//@todo
								localObject1 = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
								m = 0;
								while (m < localObject1.length) {
									if ((localObject1[m].m_state == 2)
											&& (localObject1[m].positionY >= 7)) {
										this.isUpdatingMb = false;
										this.isCursorVisible = false;
										moveCameraTo(6, 10);
									} else {
										m++;
										// continue;//@todo
										C_Unit.createUnitOnMap((byte) 1, (byte) 1, 6,
												10).goToPosition(5, 10, false, true);
										waitScript(10);
										this.scriptStep += 1;
										// break;//@todo
										C_Unit.createUnitOnMap((byte) 5, (byte) 1, 6,
												10).goToPosition(7, 8, false, true);
										waitScript(15);
										this.scriptStep += 1;
										// break;//@todo
										C_Unit.createUnitOnMap((byte) 5, (byte) 1, 6,
												10).goToPosition(7, 9, false, true);
										this.isUpdatingMb = true;
										this.isCursorVisible = true;
										this.scriptStep += 1;
										// break;//@todo
										localObject1 = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
										m = 0;
										while (m < localObject1.length) {
											if ((localObject1[m].m_state == 2)
													&& (localObject1[m].positionX >= 8)
													&& (localObject1[m].positionY >= 6)) {
												this.isUpdatingMb = false;
												this.isCursorVisible = false;
												moveCameraTo(12, 5);
											} else {
												m++;
												// continue;@todo
												C_Unit.createUnitOnMap((byte) 5,
														(byte) 1, 12, 5).goToPosition(
														12, 7, false, true);
												waitScript(15);
												this.scriptStep += 1;
												// break;//@todo
												C_Unit.createUnitOnMap((byte) 6,
														(byte) 1, 12, 5).goToPosition(
														12, 6, false, true);
												waitScript(10);
												this.scriptStep += 1;
												// break;//@todo
												C_Unit.createUnitOnMap((byte) 5,
														(byte) 1, 12, 5).goToPosition(
														12, 5, false, true);
												this.isUpdatingMb = true;
												this.isCursorVisible = true;
												this.scriptStep += 1;
												// break;//@todo
												localObject1 = getUnitsOfTypeStatePlayer(-1, -1,
														(byte) 0);
												m = 0;
												while (m < localObject1.length) {
													if ((localObject1[m].m_state == 2)
															&& (localObject1[m].positionX >= 15)
															&& (localObject1[m].positionY >= 8)) {
														this.isUpdatingMb = false;
														this.isCursorVisible = false;
														moveCameraTo(18, 8);
													} else {
														m++;
														// continue;@todo
														C_Unit.createUnitOnMap(
																(byte) 5, (byte) 1,
																18, 8).goToPosition(16,
																10, false, true);
														waitScript(10);
														this.scriptStep += 1;
														// break;//@todo
														C_Unit.createUnitOnMap(
																(byte) 6, (byte) 1,
																18, 8).goToPosition(17,
																10, false, true);
														waitScript(10);
														this.scriptStep += 1;
														// break;//@todo
														C_Unit.createUnitOnMap(
																(byte) 5, (byte) 1,
																18, 8).goToPosition(18,
																10, false, true);
														waitScript(10);
														this.scriptStep += 1;
														// break;//@todo
														C_Unit.createUnitOnMap(
																(byte) 1, (byte) 1,
																18, 8).goToPosition(18,
																9, false, true);
														waitScript(10);
														this.scriptStep += 1;
														// break;//@todo
														showUnitDialogMsg(
																A_MenuBase
																		.getLangString(259),
																(byte) 0, (byte) 4);
														this.isUpdatingMb = true;
														this.isCursorVisible = true;
														this.scriptStep += 1;
														// break;//@todo
														if (countSomeUnits(-1, -1,
																(byte) 1) == 0) {
															this.isUpdatingMb = false;
															this.isCursorVisible = false;
															waitScript(10);
															this.scriptStep += 1;
															// break;//@todo
															missionComplete();
															this.scriptStep += 1;
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
			} else if (this.scenarioMapIndex == 5) {
				switch (this.scriptStep) {
				case 0:
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 1:
					showUnitDialogMsg(A_MenuBase.getLangString(260), (byte) 1, (byte) 4);
					this.scriptStep += 1;
					break;
				case 2:
					showObjective();
					this.scriptStep += 1;
					break;
				case 3:
					if ((countSomeUnits(-1, -1, (byte) 1) == 0) && (countPlayerOwnerCastles(1) == 0)) {
						this.isUpdatingMb = false;
						this.isCursorVisible = false;
						waitScript(15);
						this.scriptStep += 1;
					}
					break;
				case 4:
					moveCameraTo(this.playersKings[0].positionX,
							this.playersKings[0].positionY);
					break;
				case 5:
					showUnitDialogMsg(A_MenuBase.getLangString(261), (byte) 0, (byte) 4);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 6:
					missionComplete();
				}
			} else {
				C_Unit localClass_c_0323;
				if (this.scenarioMapIndex == 6) {
					if (this.scriptStep <= 10) {
						if (this.var_3b4b == null) {
							this.var_3b4b = getUnitsOfTypeStatePlayer(11, -1, (byte) 0)[0];
						}
						if (this.var_3b4b.m_state == 3) {
							this.var_3b4b = null;
							sub_1447e();
							return;
						}
					}
					switch (this.scriptStep) {
					case 0:
						if (this.playersKings[0].m_state != 1) {
							this.var_39b3 = null;
							waitScript(10);
							this.scriptStep += 1;
						}
						break;
					case 1:
						showUnitDialogMsg(A_MenuBase.getLangString(262), (byte) 5, (byte) 4);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 2:
						showUnitDialogMsg(A_MenuBase.getLangString(263), (byte) 0, (byte) 4);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 3:
						localObject1 = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
						for (m = 0; m < localObject1.length; m++) {
							localObject1[m].followerUnitMb = null;
						}
						showObjective();
						this.scriptStep += 1;
						break;
					case 4:
						if (this.currentTurn >= 2) {
							waitScript(15);
							this.isUpdatingMb = false;
							this.isCursorVisible = false;
							moveCameraTo(11, 7);
						}
						break;
					case 5:
						(localClass_c_0323 = C_Unit.createUnitOnMap((byte) 5,
								(byte) 1, 11, 8)).fillWhereUnitCanMove(this.someMapData);
						localClass_c_0323.goToPosition(14, 7, true);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 6:
						C_Unit luuUnit = C_Unit.createUnitOnMap((byte) 0,
								(byte) 1, 11, 8);
						luuUnit.fillWhereUnitCanMove(this.someMapData);
						luuUnit.goToPosition(13, 7, true);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 7:
						C_Unit localObject21 = C_Unit.createUnitOnMap(
								(byte) 3, (byte) 1, 11, 8);
						localObject21.fillWhereUnitCanMove(this.someMapData);
						((C_Unit) localObject21).goToPosition(12, 7, true);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 8:
						C_Unit localObject31 = C_Unit.createUnitOnMap(
								(byte) 1, (byte) 1, 11, 8);
						localObject31.goToPosition(13, 8, false);
						waitScript(20);
						this.scriptStep += 1;
						break;
					case 9:
						showUnitDialogMsg(A_MenuBase.getLangString(264), (byte) 5, (byte) 4);
						this.isUpdatingMb = true;
						this.isCursorVisible = true;
						moveCameraTo(this.playersKings[0].positionX,
								this.playersKings[0].positionY);
						break;
					case 10:
						int i3 = 0;
						C_Unit[] arrayOfClass_c_032 = getUnitsOfTypeStatePlayer(-1, 2,
								(byte) 0);
						for (int i4 = 0; i4 < arrayOfClass_c_032.length; i4++) {
							if ((arrayOfClass_c_032[i4].positionX <= 9)
									|| (arrayOfClass_c_032[i4].positionY >= 10)) {
								i3 = 1;
								break;
							}
						}
						if ((i3 != 0) || (countSomeUnits(-1, -1, (byte) 1) == 0)) {
							this.isCursorVisible = false;
							this.isUpdatingMb = false;
							waitScript(10);
							this.scriptStep += 1;
						}
						break;
					case 11:
						this.skeleton1Map2 = getUnitsOfTypeStatePlayer(11, -1, (byte) 0)[0];
						this.crystalOfWisdom = C_Unit.createUnitOnMap((byte) 8, (byte) 1,
								this.mapWidth, this.skeleton1Map2.positionY);
						moveCameraTo(this.mapWidth - 1, this.skeleton1Map2.positionY);
						this.isCursorVisible = false;
						break;
					case 12:
						this.crystalOfWisdom.goToPosition(this.skeleton1Map2.positionX,
								this.skeleton1Map2.positionY, false);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 13:
						showUnitDialogMsg(A_MenuBase.getLangString(265), (byte) 5, (byte) 4);
						this.var_39b3 = this.crystalOfWisdom;
						this.scriptStep += 1;
						break;
					case 14:
						if (this.crystalOfWisdom.m_state != 1) {
							showUnitDialogMsg(A_MenuBase.getLangString(266), (byte) 0,
									(byte) 4);
							this.crystalOfWisdom.goToPosition(-1, this.crystalOfWisdom.positionY,
									false);
							waitScript(3);
							this.scriptStep += 1;
						}
						break;
					case 15:
						this.skeleton1Map2
								.goToPosition(-1, this.crystalOfWisdom.positionY, false);
						this.scriptStep += 1;
						break;
					case 16:
						if (this.crystalOfWisdom.m_state != 1) {
							waitScript(10);
							this.skeleton1Map2.removeFromMap();
							this.crystalOfWisdom.removeFromMap();
							moveCursorToPos(0, this.crystalOfWisdom.positionY);
							this.skeleton1Map2 = null;
							this.crystalOfWisdom = null;
							this.var_39b3 = null;
							this.scriptStep += 1;
						}
						break;
					case 17:
						moveCameraTo(1, 9);
						break;
					case 18:
						this.playersKings[1] = C_Unit.createUnitOnMap((byte) 9,
								(byte) 1, -2, 8);
						this.playersKings[1].goToPosition(0, 8, false);
						C_Unit.createUnitOnMap((byte) 0, (byte) 1, -1, 8)
								.goToPosition(3, 8, false);
						C_Unit.createUnitOnMap((byte) 0, (byte) 1, -1, 10)
								.goToPosition(1, 10, false);
						C_Unit.createUnitOnMap((byte) 8, (byte) 1, -3, 7)
								.goToPosition(4, 8, false);
						C_Unit.createUnitOnMap((byte) 8, (byte) 1, -3, 11)
								.goToPosition(2, 10, false);
						C_Unit.createUnitOnMap((byte) 4, (byte) 1, -2, 9)
								.goToPosition(2, 9, false);
						C_Unit.createUnitOnMap((byte) 6, (byte) 1, -4, 9)
								.goToPosition(4, 9, false);
						C_Unit.createUnitOnMap((byte) 6, (byte) 1, -6, 9)
								.goToPosition(5, 10, false);
						waitScript(50);
						this.scriptStep += 1;
						break;
					case 19:
						showUnitDialogMsg(A_MenuBase.getLangString(267), (byte) 3, (byte) 4);
						this.scriptStep += 1;
						break;
					case 20:
						moveCameraTo(13, 14);
						break;
					case 21:
						C_Unit.createUnitOnMap((byte) 0, (byte) 1, 13, 14)
								.goToPosition(12, 14, false);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 22:
						C_Unit.createUnitOnMap((byte) 6, (byte) 1, 13, 14)
								.goToPosition(14, 14, false);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 23:
						C_Unit.createUnitOnMap((byte) 2, (byte) 1, 13, 14)
								.goToPosition(13, 12, false);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 24:
						C_Unit.createUnitOnMap((byte) 3, (byte) 1, 13, 14)
								.goToPosition(13, 15, false);
						waitScript(15);
						this.scriptStep += 1;
						break;
					case 25:
						showUnitDialogMsg(A_MenuBase.getLangString(268), (byte) 5, (byte) 4);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 26:
						showUnitDialogMsg(A_MenuBase.getLangString(269), (byte) 0, (byte) 4);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 27:
						moveCameraTo(13, 17);
						break;
					case 28:
						C_Unit localClass_c_0325;
						(localClass_c_0325 = C_Unit.createUnitOnMap((byte) 9,
								(byte) 0, 13, 18)).setKingName(2);
						localClass_c_0325.goToPosition(13, 16, false);
						C_Unit.createUnitOnMap((byte) 6, (byte) 0, 12, 18)
								.goToPosition(12, 16, false);
						C_Unit.createUnitOnMap((byte) 8, (byte) 0, 14, 19)
								.goToPosition(14, 16, false);
						C_Unit.createUnitOnMap((byte) 4, (byte) 0, 13, 19)
								.goToPosition(13, 17, false);
						C_Unit.createUnitOnMap((byte) 1, (byte) 0, 12, 19)
								.goToPosition(12, 17, false);
						waitScript(20);
						this.scriptStep += 1;
						break;
					case 29:
						showUnitDialogMsg(A_MenuBase.getLangString(270), (byte) 1, (byte) 4);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 30:
						moveCameraTo(this.playersKings[0].positionX,
								this.playersKings[0].positionY);
						break;
					case 31:
						this.helpTipId = 18;
						this.scriptStep += 1;
						break;
					case 32:
						this.isUpdatingMb = true;
						this.isCursorVisible = true;
						this.startupMessageBox = createDialog(
								A_MenuBase.getLangString(121 + this.scenarioMapIndex),
								A_MenuBase.getLangString(138), this.someGHeight, -1);
						this.startupMessageBox.setMenuActionEnabled((byte) 0, true);
						this.startupMessageBox.setParentMenu(null);
						A_MenuBase.mainCanvas.showMenu(this.startupMessageBox);
						this.scriptStep += 1;
						break;
					case 33:
						if ((countSomeUnits(-1, -1, (byte) 1) == 0)
								&& (countPlayerOwnerCastles(1) == 0)) {
							this.isUpdatingMb = false;
							this.isCursorVisible = false;
							waitScript(10);
							this.scriptStep += 1;
						}
						break;
					case 34:
						missionComplete();
					}
				} else if (this.scenarioMapIndex == 7) {
					switch (this.scriptStep) {
					case 0:
						A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
						this.isFading = true;
						this.scriptStep += 1;
						break;
					case 1:
						if (!this.var_380b) {
							showUnitDialogMsg(A_MenuBase.getLangString(271), (byte) 0,
									(byte) 4);
							this.scriptStep += 1;
						}
						break;
					case 2:
						moveCameraTo(this.playersKings[1].positionX,
								this.playersKings[1].positionY);
						break;
					case 3:
						showUnitDialogMsg(A_MenuBase.getLangString(272), (byte) 4, (byte) 4);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 4:
						showUnitDialogMsg(A_MenuBase.getLangString(273), (byte) 1, (byte) 4);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 5:
						showUnitDialogMsg(A_MenuBase.getLangString(274), (byte) 4, (byte) 4);
						this.scriptStep += 1;
						break;
					case 6:
						this.skeleton1Map2 = getSomeUnit(5, 2, (byte) 0);
						this.skeleton1Map2.goToPosition(7, 2, false);
						this.scriptStep += 1;
						break;
					case 7:
						if (this.skeleton1Map2.m_state != 1) {
							this.skeleton1Map2.removeFromMap();
							this.skeleton1Map2 = null;
							this.crystalOfWisdom = getSomeUnit(7, 3, (byte) 0);
							this.crystalOfWisdom.goToPosition(7, 2, false);
							this.scriptStep += 1;
						}
						break;
					case 8:
						if (this.crystalOfWisdom.m_state != 1) {
							this.crystalOfWisdom.removeFromMap();
							this.crystalOfWisdom = null;
							this.skeleton2Map2 = getSomeUnit(9, 2, (byte) 0);
							this.skeleton2Map2.goToPosition(7, 2, false);
							this.scriptStep += 1;
						}
						break;
					case 9:
						if (this.skeleton2Map2.m_state != 1) {
							this.skeleton2Map2.removeFromMap();
							this.skeleton2Map2 = null;
							this.playersKings[1].goToPosition(7, 2, false);
							waitScript(20);
							this.scriptStep += 1;
						}
						break;
					case 10:
						moveCameraTo(9, 15);
						this.isCursorVisible = true;
						break;
					case 11:
						D_Menu localObject11 = createDialog(null,
								A_MenuBase.getLangString(279), this.someGHeight, 2000);
						localObject11.sub_193f(this.viewportWidth, 2, 17);
						A_MenuBase.mainCanvas
								.showMenu((A_MenuBase) localObject11);
						this.scriptStep += 1;
						break;
					case 12:
						this.var_387b = false;
						sub_558c(getSomeUnit(9, 15, (byte) 0));
						this.scriptStep += 1;
						break;
					case 13:
						if (this.var_3873 >= 2) {
							showUnitDialogMsg(A_MenuBase.getLangString(275), (byte) 0,
									(byte) 4);
							(localClass_c_0323 = getSomeUnit(9, 15, (byte) 0))
									.removeFromMap();
							this.var_387b = true;
							waitScript(20);
							this.scriptStep += 1;
						}
						break;
					case 14:
						this.isCursorVisible = false;
						showUnitDialogMsg(A_MenuBase.getLangString(276), (byte) 4, (byte) 4);
						this.scriptStep += 1;
						break;
					case 15:
						showUnitDialogMsg(A_MenuBase.getLangString(277), (byte) 1, (byte) 4);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 16:
						this.isCursorVisible = true;
						this.var_39bb = 4;
						moveCameraTo(3, 9);
						break;
					case 17:
						moveCameraTo(13, 4);
						break;
					case 18:
						this.var_39bb = 12;
						showUnitDialogMsg(A_MenuBase.getLangString(278), (byte) 5, (byte) 4);
						moveCameraTo(this.playersKings[0].positionX,
								this.playersKings[0].positionY);
						break;
					case 19:
						showObjective();
						this.scriptStep += 1;
						break;
					case 20:
						if (this.var_3883) {
							this.isCursorVisible = false;
							this.isUpdatingMb = false;
							waitScript(20);
							this.scriptStep += 1;
						}
						break;
					case 21:
						this.isFadingIn = true;
						this.fadeInColor = 0;
						this.isFading = true;
						this.scriptStep += 1;
						break;
					case 22:
						if (this.fadeInColor >= 16) {
							sub_b9c5(7, 2);
							moveCursorToPos(7, 2);
							sub_87e6();
							this.playersKings[1] = C_Unit.createUnitOnMap((byte) 9,
									(byte) 1, 7, 2);
							this.playersKings[1].setKingName(3);
							C_Unit.createUnitOnMap((byte) 9, (byte) 0, 6, 3);
							C_Unit luuUnit = C_Unit.createUnitOnMap((byte) 9,
									(byte) 0, 8, 3);
							luuUnit.setKingName(2);
							C_Unit.createUnitOnMap((byte) 0, (byte) 0, 6, 1);
							C_Unit.createUnitOnMap((byte) 0, (byte) 0, 8, 1);
							waitScript(10);
							this.scriptStep += 1;
							E_MainCanvas.playMusicLooped2(8, 0);
						}
						break;
					case 23:
						this.isFadingIn = false;
						this.var_380b = true;
						this.fadeInColor = 0;
						this.scriptStep += 1;
						break;
					case 24:
						if (this.fadeInColor >= 16) {
							showUnitDialogMsg(A_MenuBase.getLangString(281), (byte) 4,
									(byte) 4);
							waitScript(15);
							this.scriptStep += 1;
						}
						break;
					case 25:
						showUnitDialogMsg(A_MenuBase.getLangString(282), (byte) 0, (byte) 4);
						waitScript(8);
						this.scriptStep += 1;
						break;
					case 26:
						showUnitDialogMsg(A_MenuBase.getLangString(283), (byte) 4, (byte) 4);
						waitScript(15);
						this.scriptStep += 1;
						break;
					case 27:
						showSpriteOnMap(this.sparkSprite, 168, 48, 0, 0, 1, 50);
						this.mapUnitsSprites.removeElement(this.playersKings[1]);
						waitScript(15);
						this.scriptStep += 1;
						break;
					case 28:
						E_MainCanvas.vibrate(400);
						sub_14bd3(5000);
						waitScript(10);
						this.scriptStep += 1;
						break;
					case 29:
						showUnitDialogMsg(A_MenuBase.getLangString(284), (byte) 5, (byte) 4);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 30:
						showUnitDialogMsg(A_MenuBase.getLangString(285), (byte) 2, (byte) 4);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 31:
						showUnitDialogMsg(A_MenuBase.getLangString(286), (byte) 1, (byte) 4);
						waitScript(5);
						this.scriptStep += 1;
						break;
					case 32:
						showUnitDialogMsg(A_MenuBase.getLangString(287), (byte) 0, (byte) 4);
						this.isFadingIn = true;
						this.fadeInColor = 0;
						this.scriptStep += 1;
						break;
					case 33:
						if (this.fadeInColor >= 16) {
							waitScript(10);
							this.var_3bc3 = false;
							this.scriptStep += 1;
						}
						break;
					case 34:
						loadIntro(5, 2, 2);
						this.scriptStep += 1;
						break;
					case 35:
						E_MainCanvas.playMusicLooped2(0, 0);
						sub_c16e(A_MenuBase.getLangString(288));
						this.scriptStep += 1;
						break;
					case 36:
						this.var_3b93 = 0;
						this.activeUnitState = 14;
						this.scriptStep += 1;
					}
				}
			}
		}
		this.unitEndTurnMb = null;
	}

	

	private void updateScenarioScript1() {
		switch (this.scriptStep) {
			case 0:
				this.scriptStep += 1;
				break;
			case 1:
				A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 2:
				this.isFading = true;
				getSomeUnit(0, 8, (byte) 0).goToPosition(3, 8, false);
				getSomeUnit(1, 9, (byte) 0).goToPosition(4, 9, false);
				getSomeUnit(0, 10, (byte) 0).goToPosition(3, 10, false);
				moveCameraTo(5, 9);
				break;
			case 3:
				moveCameraTo(9, 3);
				this.isCursorVisible = true;
				break;
			case 4:
				waitScript(10);
				this.var_39bb = 12;
				C_Unit.var_a7b = C_Unit.var_a73;
				this.scriptStep += 1;
				break;
			case 5:
				//Help us! We are under attack!...
				showUnitDialogMsg(A_MenuBase.getLangString(221), (byte) 2, (byte) 4);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 6:
				C_Unit vilTroop = getSomeUnit(9, 3, (byte) 0);
				E_MainCanvas.vibrate(100);
				vilTroop.shakeUnit(400);
				showSpriteOnMap(this.redsparkSprite, ((F_Sprite) vilTroop).posXPixel,
						((F_Sprite) vilTroop).posYPixel, 0, 0, 2, 50);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 7:
				//Aargh... we've failed!
				showUnitDialogMsg(A_MenuBase.getLangString(222), (byte) 2, (byte) 4);
				this.scriptStep += 1;
				break;
			case 8:
				C_Unit llUnit = getSomeUnit(9, 3, (byte) 0);
				showSpriteOnMap(this.sparkSprite, llUnit.posXPixel, llUnit.posYPixel, 0, 0, 1, 50);
				showSpriteOnMap(this.smokeSprite, llUnit.posXPixel, llUnit.posYPixel, 0, -3, 1, 100);
				llUnit.removeFromMap();
				waitScript(20);
				this.scriptStep += 1;
				break;
			case 9:
				this.isCursorVisible = false;
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 10:
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 11:
				showUnitDialogMsg(A_MenuBase.getLangString(223), (byte) 0, (byte) 4);
				waitScript(5);
				this.scriptStep += 1;
				break;
			case 12:
				//Forward troops! Make these raiders pay!
				showUnitDialogMsg(A_MenuBase.getLangString(224), (byte) 5, (byte) 4);
				this.scriptStep += 1;
				break;
			case 13:
				showObjective();
				this.scriptStep += 1;
				break;
			case 14:
				if (this.var_378b == 0) {
					this.helpTipId = 0;
					this.scriptStep += 1;
				}
				break;
			case 15:
				if ((this.playerId == 0) && (this.activeUnitState == 1)
						&& (this.alphaWindowWTF == 0)) { //activeUnitState == 1 chosen
					this.helpTipId = 1;
					this.scriptStep += 1;
				}
				break;
			case 16:
				if ((this.playerId == 0) && (this.unitEndTurnMb != null)) {
					this.helpTipId = 2;
					this.scriptStep += 1;
				}
				break;
			case 17:
				if ((this.playerId == 0) && (this.unitEndTurnMb != null)) {
					this.helpTipId = 3;
					this.scriptStep += 1;
				}
				break;
			case 18:
				if (countSomeUnits(-1, 2, (byte) 0) >= 3) { // 2 - has no turn, noboby has turn
					this.helpTipId = 4;
					this.scriptStep += 1;
				} else if (this.currentTurn >= 1) {
					this.scriptStep += 1;
				}
				break;
			case 19:
				if (this.currentTurn >= 2) {
					this.helpTipId = 5;
					this.scriptStep += 1;
				}
				break;
			case 20:
				this.helpTipId = 6;
				this.scriptStep += 1;
				break;
			case 21:
				if ((this.activeUnitState == 1) && (this.playerId == 0)) {
					this.helpTipId = 7;
					this.scriptStep += 1;
				}
				break;
			case 22:
				if (countSomeUnits(-1, -1, (byte) 1) == 0) { // no enemy troops
					this.isUpdatingMb = false;
					waitScript(20);
					this.scriptStep += 1;
				}
				break;
			case 23:
				moveCameraTo(1, 1);
				break;
			case 24:
				C_Unit newArcher = C_Unit.createUnitOnMap((byte) 1, (byte) 1, 1, 1); //archer
				newArcher.goToPosition(1, 2, false, true);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 25:
				moveCameraTo(10, 10);
				break;
			case 26:
				C_Unit newSoldier = C_Unit.createUnitOnMap((byte) 0, (byte) 1, 10, 10);
				newSoldier.goToPosition(10, 9, false, true);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 27:
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 28:
				showUnitDialogMsg(A_MenuBase.getLangString(225), (byte) 5, (byte) 4);
				waitScript(5);
				this.scriptStep += 1;
				break;
			case 29:
				showUnitDialogMsg(A_MenuBase.getLangString(226), (byte) 0, (byte) 4);
				this.isUpdatingMb = true;
				this.scriptStep += 1;
				break;
			case 30:
				if ((countSomeUnits(-1, -1, (byte) 1) == 0) && (this.activeUnitState == 0)) {
					this.isUpdatingMb = false;
					this.isCursorVisible = false;
					waitScript(30);
					this.scriptStep += 1;
				}
				break;
			case 31:
				this.isFadingIn = true;
				this.fadeInColor = 0;
				waitScript(20);
				this.scriptStep += 1;
				break;
			case 32:
				//Thank you, your Majesty, you must help ...
				showUnitDialogMsg(A_MenuBase.getLangString(227), (byte) 2, (byte) 4);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 33:
				showUnitDialogMsg(A_MenuBase.getLangString(228), (byte) 0, (byte) 4);
				waitScript(5);
				this.scriptStep += 1;
				break;
			case 34:
				showUnitDialogMsg(A_MenuBase.getLangString(229), (byte) 2, (byte) 4);
				waitScript(5);
				this.scriptStep += 1;
				break;
			case 35:
				showUnitDialogMsg(A_MenuBase.getLangString(230), (byte) 0, (byte) 4);
				waitScript(15);
				this.scriptStep += 1;
				break;
			case 36:
				missionComplete();
				break;
			}
	}

	private void updateScenarioScript2() {
		switch (this.scriptStep) {
			case 1:
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 2:
				this.var_39bb = 4; //??
				moveCameraTo(12, 3);
				break;
			case 3:
				showUnitDialogMsg(A_MenuBase.getLangString(231), (byte) 1, (byte) 4);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 4:
				showUnitDialogMsg(A_MenuBase.getLangString(232), (byte) 3, (byte) 4);
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 5:
				showUnitDialogMsg(A_MenuBase.getLangString(233), (byte) 5, (byte) 4);
				moveCameraTo(7, 3);
				break;
			case 6:
				C_Unit.var_a7b = 2;
				this.skeleton1Map2 = C_Unit.createUnitOnMap((byte) 0, (byte) 1, 7, 3);
				this.crystalOfWisdom = C_Unit.createUnitOnMap((byte) 11, (byte) 1, 7, 3);
				this.skeleton2Map2 = C_Unit.createUnitOnMap((byte) 0, (byte) 1, 7, 3);
				this.skeleton1Map2.followerUnitMb = this.crystalOfWisdom;
				this.crystalOfWisdom.followerUnitMb = this.skeleton2Map2;
				this.skeleton1Map2.goToPosition(6, -2, false);
				waitScript(30);
				this.scriptStep += 1;
				break;
			case 7:
				if ((this.skeleton2Map2.positionX == 6) && (this.skeleton2Map2.positionY == 1)) {
					C_Unit.var_a7b = 4;
					this.wisdomCrystalKeeper = C_Unit.createUnitOnMap((byte) 0, (byte) 0, 7, 3);
					this.wisdomCrystalKeeper.goToPosition(6, 2, false);
					this.crystalOfWisdom.followerUnitMb = null;
					//The Crystal of Wisdom! Do not let them escape!
					showUnitDialogMsg(A_MenuBase.getLangString(234), (byte) 2, (byte) 4);
					this.scriptStep += 1;
				}
				break;
			case 8:
				if (this.wisdomCrystalKeeper.m_state != 1) {
					E_MainCanvas.vibrate(100);
					this.wisdomCrystalKeeper.shakeUnit(400);
					showSpriteOnMap(this.redsparkSprite, this.wisdomCrystalKeeper.posXPixel,
							this.wisdomCrystalKeeper.posYPixel, 0, 0, 2, 50);
					waitScript(10);
					this.scriptStep += 1;
				}
				break;
			case 9:
				//Aarrghh!
				showUnitDialogMsg(A_MenuBase.getLangString(235), (byte) 2, (byte) 4);
				waitScript(5);
				this.scriptStep += 1;
				break;
			case 10:
				showSpriteOnMap(this.smokeSprite, this.wisdomCrystalKeeper.posXPixel,
						this.wisdomCrystalKeeper.posYPixel, 0, -3, 1, 100);
				showSpriteOnMap(this.sparkSprite, this.wisdomCrystalKeeper.posXPixel,
						this.wisdomCrystalKeeper.posYPixel, 0, 0, 1, 50);
				this.wisdomCrystalKeeper.removeFromMap();
				this.wisdomCrystalKeeper = null;
				waitScript(15);
				this.scriptStep += 1;
				break;
			case 11:
				C_Unit.var_a7b = C_Unit.var_a73;
				this.skeleton1Map2.removeFromMap();
				this.crystalOfWisdom.removeFromMap();
				this.skeleton1Map2 = null;
				this.crystalOfWisdom = null;
				this.skeleton2Map2 = null;
				this.var_39bb = 12;
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 12:
				showUnitDialogMsg(A_MenuBase.getLangString(236), (byte) 5, (byte) 4);
				this.scriptStep += 1;
				break;
			case 13:
				showUnitDialogMsg(A_MenuBase.getLangString(237), (byte) 1, (byte) 4);
				this.scriptStep += 1;
				break;
			case 14:
				moveCameraTo(3, 5);
				break;
			case 15:
				showUnitDialogMsg(A_MenuBase.getLangString(238), (byte) 5, (byte) 4);
				this.scriptStep += 1;
				break;
			case 16:
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 17:
				this.helpTipId = 8;
				this.scriptStep += 1;
				break;
			case 18:
				this.helpTipId = 9;
				this.scriptStep += 1;
				break;
			case 19:
				showObjective();
				this.scriptStep += 1;
				break;
			case 20:
				if ((this.activeUnitState == 9) && (this.playerId == 0)) {
					this.helpTipId = 10;
					this.scriptStep += 1;
				}
				break;
			case 21:
				this.helpTipId = 11;
				this.scriptStep += 1;
				break;
			case 22:
				if ((this.playersKings[0].m_state == 3) || (this.playersKings[1].m_state == 3)) { // maybe dead @todo
					this.helpTipId = 12;
					this.scriptStep += 1;
				}
				break;
			case 23:
				// no enemies and no enemy castle
				if ((countSomeUnits(-1, -1, (byte) 1) == 0) && (countPlayerOwnerCastles(1) == 0)) { 
					this.isUpdatingMb = false;
					waitScript(20);
					this.scriptStep += 1;
				}
				break;
			case 24:
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 25:
				showUnitDialogMsg(A_MenuBase.getLangString(239), (byte) 1, (byte) 4);
				this.scriptStep += 1;
				break;
			case 26:
				showUnitDialogMsg(A_MenuBase.getLangString(240), (byte) 5, (byte) 4);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 27:
				missionComplete();
				break;
		}
	}
	
	private void updateScenarioScript3() {
		//case 0 &1 @todo wtf? 
		switch (this.scriptStep) {
		case 0:
			if (this.skeleton1Map2.m_state != 1) {
				this.skeleton1Map2.goToPosition(7, 14, false);
				this.scriptStep += 1;
			}
			break;
		case 1:
			if (this.crystalOfWisdom.m_state != 1) {
				this.crystalOfWisdom.goToPosition(7, 15, false);
				waitScript(20);
				this.scriptStep += 1;
			}
			break;
		case 2:
			C_Unit.var_a7b = C_Unit.var_a73;
			this.skeleton1Map2 = null;
			this.crystalOfWisdom = null;
			this.skeleton2Map2 = null;
			//Your Majesty, this forest is known to be...
			showUnitDialogMsg(A_MenuBase.getLangString(241), (byte) 5, (byte) 4);
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 3:
			showUnitDialogMsg(A_MenuBase.getLangString(242), (byte) 0, (byte) 4);
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 4:
			showUnitDialogMsg(A_MenuBase.getLangString(243), (byte) 5, (byte) 4);
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 5:
			this.helpTipId = 14;
			this.scriptStep += 1;
			break;
		case 6:
			showObjective(); //Path of shadows
			this.scriptStep += 1;
			break;
		case 7:
			if ((this.playerId == 0)
					&& (this.var_378b == 0)
					&& (countSomeUnits(-1, 3, (byte) -1) >= 1)) { //there are dead units
				this.helpTipId = 15;
				this.scriptStep += 1;
			}
			break;
		case 8:
			int k = 0;
			C_Unit[] unitsEndTurn = getUnitsOfTypeStatePlayer(-1, 2, (byte) 0); //2 - End turn
			while (k < unitsEndTurn.length) {
				if ((unitsEndTurn[k].positionX <= 4) || (unitsEndTurn[k].positionY <= 10)) {
					waitScript(10);
					this.isUpdatingMb = false;
					this.isCursorVisible = false;
					this.scriptStep = 9;
				} else {
					k++;
				}
			}
			break;
		case 9:
			moveCameraTo(0, 8);
			C_Unit.createUnitOnMap((byte) 5, (byte) 1, -1, 8)
					.goToPosition(0, 8, false); //wolf
			C_Unit.createUnitOnMap((byte) 5, (byte) 1, -2, 7)
					.goToPosition(1, 7, false); //wolf
			waitScript(20);
			this.scriptStep += 1;
			break;
		case 10:
			moveCameraTo(8, 6);
			C_Unit.createUnitOnMap((byte) 5, (byte) 1, 12, 6)
					.goToPosition(8, 6, false); //wolf
			waitScript(20);
			this.scriptStep += 1;
			break;
		case 11:
			moveCameraTo(2, 1);
			C_Unit.createUnitOnMap((byte) 5, (byte) 1, 1, -2)
					.goToPosition(1, 2, false); //wolf
			C_Unit.createUnitOnMap((byte) 5, (byte) 1, 3, -2)
					.goToPosition(3, 2, false); //wolf
			C_Unit.createUnitOnMap((byte) 4, (byte) 1, 2, -1)
					.goToPosition(2, 1, false); //wisp
			waitScript(20);
			this.scriptStep += 1;
			break;
		case 12:
			showUnitDialogMsg(A_MenuBase.getLangString(244), (byte) 5, (byte) 4);
			waitScript(10);
			this.scriptStep += 1;
			break;
		case 13:
			moveCameraTo(4, 8);
			waitScript(15);
			this.scriptStep += 1;
			break;
		case 14:
			C_Unit lcaUnit = C_Unit.createUnitOnMap(
					(byte) 2, (byte) 1, 3, 8); // elemental
			C_Unit luuUnit = C_Unit.createUnitOnMap((byte) 2,
					(byte) 1, 4, 7); // elemental
			C_Unit someUnitx = C_Unit.createUnitOnMap((byte) 2, (byte) 1, 5, 8); // elemental
			showSpriteOnMap(this.sparkSprite, lcaUnit.posXPixel,
					lcaUnit.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite, luuUnit.posXPixel,
					luuUnit.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite,
					((F_Sprite) someUnitx).posXPixel,
					((F_Sprite) someUnitx).posYPixel, 0, 0, 1,
					50);
			waitScript(10);
			this.scriptStep += 1;
			break;
		case 15:
			showUnitDialogMsg(A_MenuBase.getLangString(245), (byte) 5, (byte) 4);
			waitScript(10);
			this.scriptStep += 1;
		    break;
		case 16:
			showUnitDialogMsg(A_MenuBase.getLangString(246), (byte) -1, (byte) 4);
			waitScript(5);
			this.scriptStep += 1;
			 break;
		case 17:
			showUnitDialogMsg(A_MenuBase.getLangString(247), (byte) 0, (byte) 4);
			waitScript(10);
			this.scriptStep += 1;
			break;
		case 18:
			A_MenuBase.mainCanvas.showMenu(createDialog(null,
					A_MenuBase.getLangString(248), this.someGHeight, 1500));
			this.scriptStep += 1;
			break;
		case 19:
			getSomeUnit(3, 8, (byte) 0).removeFromMap();
			getSomeUnit(4, 7, (byte) 0).removeFromMap();
			getSomeUnit(5, 8, (byte) 0).removeFromMap();
			C_Unit lcaUnit1 = C_Unit.createUnitOnMap((byte) 2, (byte) 0, 3, 8);
			C_Unit luuUnit1 = C_Unit.createUnitOnMap((byte) 2, (byte) 0, 4, 7);
			C_Unit someUnitx1 = C_Unit.createUnitOnMap((byte) 2, (byte) 0, 5, 8);
			showSpriteOnMap(this.sparkSprite, lcaUnit1.posXPixel, lcaUnit1.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite, luuUnit1.posXPixel, luuUnit1.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite,
					((F_Sprite) someUnitx1).posXPixel,
					((F_Sprite) someUnitx1).posYPixel, 0, 0, 1,
					50);
			waitScript(10);
			this.scriptStep += 1;
			break;
		case 20:
			this.isUpdatingMb = true;
			this.isCursorVisible = true;
			this.helpTipId = 13;
			this.scriptStep += 1;
		   break;
		case 21:
			if (countSomeUnits(-1, -1, (byte) 1) == 0) { // no enemies
				this.isUpdatingMb = false;
				waitScript(10);
				this.scriptStep += 1;
			}
			break;
		case 22:
			missionComplete();
			break;
		}
	}
	
	public final void updateScenarioScript4(){
		switch (this.scriptStep) {
		case 0:
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.isFading = true;
			this.scriptStep += 1;
			break;
		case 1:
			if (this.playersKings[0].m_state != 1) {
				this.var_39b3 = null;
				waitScript(20);
				this.scriptStep += 1;
			}
			break;
		case 2:
			this.isFadingIn = true;
			this.isFading = true;
			this.fadeInColor = 0;
			waitScript(20);
			this.scriptStep += 1;
			break;
		case 3:
			//Your Majesty, thank the Creator you are here! 
			showUnitDialogMsg(A_MenuBase.getLangString(249), (byte) 2, (byte) 4);
			waitScript(10);
			this.scriptStep += 1;
			break;
		case 4:
			showUnitDialogMsg(A_MenuBase.getLangString(250), (byte) 0, (byte) 4);
			waitScript(10);
			this.scriptStep += 1;
			break;
		case 5:
			showUnitDialogMsg(A_MenuBase.getLangString(251), (byte) 5, (byte) 4);
			moveCursorToPos(13, 3);
			sub_b998(312, 72);
			this.playersKings[0].setUnitPosition(7, 1);
			this.skeleton1Map2.setUnitPosition(5, 4);
			this.crystalOfWisdom.setUnitPosition(7, 5);
			this.skeleton2Map2.setUnitPosition(3, 3);
			this.skeleton1Map2 = null;
			this.crystalOfWisdom = null;
			this.skeleton2Map2 = null;
			this.var_39bb = 2;
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 6:
			this.isFadingIn = false;
			this.var_380b = true;
			this.fadeInColor = 0;
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 7:
			moveCameraTo(13, 10);
			break;
		case 8:
			C_Unit.var_a7b = 2;
			this.var_39bb = 4;
			this.skeleton1Map2 = getSomeUnit(10, 10, (byte) 0);
			this.skeleton1Map2.goToPosition(6, 10, false);
			moveCursorToPos(6, 10);
			moveCameraTo(6, 10);
			break;
		case 9:
			if (this.skeleton1Map2.m_state != 1) {
				this.skeleton1Map2 = null;
				this.isCursorVisible = true;
				waitScript(10);
				this.scriptStep += 1;
			}
			break;
		case 10:
			moveCursorToPos(4, 9);
			moveCameraTo(4, 9);
			showSpriteOnMap(this.redsparkSprite, 96, 216, 0, 0, 1, 50);
			waitScript(15);
			break;
		case 11:
			this.var_35db = C_Unit.sub_d60((byte) 0, (byte) 0, 4, 9,
					false);
			this.var_35db.unitTypeId = -1;
			this.var_35db.m_state = 4;
			this.var_3603 = 6;
			waitScript(20);
			this.scriptStep += 1;
			break;
		case 12:
			showUnitDialogMsg(A_MenuBase.getLangString(252), (byte) 5, (byte) 4);
			moveCameraTo(7, 1);
			break;
		case 13:
			showUnitDialogMsg(A_MenuBase.getLangString(253), (byte) 0, (byte) 4);
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 14:
			this.helpTipId = 17;
			this.scriptStep += 1;
			break;
		case 15:
			showObjective();
			this.scriptStep += 1;
			break;
		case 16:
			if ((countSomeUnits(-1, -1, (byte) 1) == 0) && (countPlayerOwnerCastles(1) == 0)) {
				waitScript(15);
				this.isUpdatingMb = false;
				this.scriptStep += 1;
			}
			break;
		case 17:
			//Your Majesty, We have stopped the attack.
			showUnitDialogMsg(A_MenuBase.getLangString(254), (byte) 5, (byte) 4); 
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 18:
			//Well done, Captain! Prepare the troops to march to Thorin!
			showUnitDialogMsg(A_MenuBase.getLangString(255), (byte) 0, (byte) 4);
			waitScript(10);
			this.scriptStep += 1;
			break;
		case 19:
			missionComplete();
			break;
		}
	}
	
	public final void showObjective() {
		this.mapNameDialog = null;
		this.var_39bb = 12;
		C_Unit.var_a7b = C_Unit.var_a73;
		this.startupMessageBox.setMenuActionEnabled((byte) 0, true);
		this.startupMessageBox.setMenuActionEnabled((byte) 1, false);
		A_MenuBase.mainCanvas.showMenu(this.startupMessageBox);
		this.isCursorVisible = true;
		this.isUpdatingMb = true;
		this.var_3793 = false;
		E_MainCanvas.playMusicLooped2(2, 0);
	}

	public final void moveCameraTo(int inX, int inY) {
		this.cameraX = inX;
		this.cameraY = inY;
		moveCursorToPos(inX, inY);
		this.scriptStep += 1;
	}

	public final void missionComplete() {
		E_MainCanvas.stopMusic();
		E_MainCanvas.playMusicLooped(6, 1);
		D_Menu dialog = createDialog(null, A_MenuBase.getLangString(72),
				this.someGHeight, 3000); //MISSION COMPLETE
		A_MenuBase.mainCanvas.showMenu(dialog);
		this.someStartTime5 = this.time;
		this.scriptStep = -1;
		this.var_3b93 = 0;
		this.activeUnitState = 10;
	}

	public final void sub_1447e() {
		this.var_3b7b = true;
		this.scriptStep = 0;
		waitScript(20);
		E_MainCanvas.stopMusic();
		E_MainCanvas.playMusicLooped(7, 1);
	}

	public final void sub_144b2(C_Unit paramClass_c_0321,
			C_Unit paramClass_c_0322) throws Exception {
		System.gc();
		this.var_3bfb = (this.someGHeight - this.var_3a43);
		this.var_3be3 = true;
		this.waveImageAmplitude = 0;
		this.var_3bb3 = false;
		this.attackerUnitMb = paramClass_c_0321;
		this.attackedUnitMb = paramClass_c_0322;
		E_MainCanvas.loadResourcesPak("/2.pak");
		this.var_3b9b = new G_FightAnimation(this, paramClass_c_0321, null);
		this.var_3ba3 = new G_FightAnimation(this, paramClass_c_0322, this.var_3b9b);
		this.var_3b9b.otherFightAnim = this.var_3ba3;
		paramClass_c_0321.sub_fea(paramClass_c_0322);
		if (paramClass_c_0322.sub_1134(paramClass_c_0321,
				paramClass_c_0321.positionX, paramClass_c_0321.positionY)) {
			paramClass_c_0322.sub_fea(paramClass_c_0321);
			this.var_3bdb = true;
		} else {
			this.var_3bdb = false;
		}
		this.var_3b9b.var_b4d = ((byte) paramClass_c_0321.unitHealthMb);
		this.var_3b9b.var_b5d = ((byte) paramClass_c_0321.getAliveCharactersCount());
		this.var_3ba3.var_b4d = ((byte) paramClass_c_0322.unitHealthMb);
		this.var_3ba3.var_b5d = ((byte) paramClass_c_0322.getAliveCharactersCount());
		E_MainCanvas.playMusicLooped(var_33cb[this.playersIndexes[this.playerId]], 0);
		this.gameMode2Mb = 2;
	}

	public final void addSpriteTo(F_Sprite sprite) {
		this.gameSprites.addElement(sprite);
	}

	public final void removeSpriteFrom(F_Sprite sprite) {
		this.gameSprites.removeElement(sprite);
	}

	//
	public final void updateGameSprites() throws Exception {
		if ((this.var_3bc3) && (this.time - this.someStartTime >= this.someMaxTime)) {
			this.var_3bc3 = false;
		}
		F_Sprite sprite;
		for (int i = 0; i < this.gameSprites.size(); i++) {
			sprite = (F_Sprite) this.gameSprites.elementAt(i);
			sprite.spriteUpdate();
		}
		for (int i = 0; i < this.gameSprites.size(); i++) {
			sprite = (F_Sprite) this.gameSprites.elementAt(i);
			if (!sprite.var_84c) {
				removeSpriteFrom(sprite);
			}
		}
		this.var_3b9b.sub_2ae8();
		this.var_3ba3.sub_2ae8();
		if (this.var_3be3) {
			this.waveImageAmplitude += 1;
			if (this.waveImageAmplitude >= 16) {
				this.var_3be3 = false;
				this.var_3b9b.sub_16bb();
			}
			this.var_3beb = true;
			this.var_3bf3 = true;
			return;
		}
		if (this.var_3bb3) {
			if (this.time - this.someStartTime2 >= 300L) {
				this.gameSprites.removeAllElements();
				this.var_3ba3 = null;
				this.var_3b9b = null;
				this.var_35c3 = new Vector();
				sub_56c3();
				this.gameMode2Mb = 1;
				E_MainCanvas.stopMusic();
				E_MainCanvas.playMusicLooped(var_33c3[this.playersIndexes[this.playerId]], 0);
				A_MenuBase.mainCanvas.clearActions();
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
					this.someStartTime2 = this.time;
				}
			} else {
				this.var_3bb3 = true;
				this.someStartTime2 = this.time;
			}
		}
	}

	public final void sub_1480f(Graphics paramGraphics) {
		int i = 0;
		int j = 0;
		if (this.var_3bc3) {
			i = E_MainCanvas.getRandom() % 10;
			j = E_MainCanvas.getRandom() % 3;
		}
		paramGraphics.translate(0, this.var_3a43);
		paramGraphics.setClip(0, 0, this.someGWidth, this.var_3bfb);
		this.var_3b9b.sub_35fd(paramGraphics, i, j);
		this.var_3ba3.sub_35fd(paramGraphics, i + this.viewportWidth, j);
		paramGraphics.setColor(0);
		paramGraphics.fillRect(this.viewportWidth - 1 + i, 0, 2, this.var_3bfb);
		this.var_3b9b.sub_3788(paramGraphics);
		this.var_3ba3.sub_3788(paramGraphics);
		Vector localVector = new Vector(this.gameSprites.size());
		F_Sprite localClass_f_0451;
		for (int k = 0; k < this.gameSprites.size(); k++) {
			localClass_f_0451 = (F_Sprite) this.gameSprites.elementAt(k);
			int m = 0;
			if (localClass_f_0451.var_85c) {
				localVector.addElement(localClass_f_0451);
			} else {
				for (m = 0; m < localVector.size(); m++) {
					F_Sprite localClass_f_0452;
					if (((localClass_f_0452 = (F_Sprite) localVector
							.elementAt(m)).var_85c)
							|| (localClass_f_0451.posYPixel
									+ localClass_f_0451.frameHeight < localClass_f_0452.posYPixel
									+ localClass_f_0452.frameHeight)) {
						localVector.insertElementAt(localClass_f_0451, m);
						break;
					}
				}
			}
			if (m == localVector.size()) {
				localVector.addElement(localClass_f_0451);
			}
		}
		this.gameSprites = localVector;
		for (int k = 0; k < this.gameSprites.size(); k++) {
			if ((localClass_f_0451 = (F_Sprite) this.gameSprites.elementAt(k)).var_86c == 0) {
				paramGraphics.setClip(0, 0, this.viewportWidth, this.var_3bfb);
			} else if (localClass_f_0451.var_86c == 1) {
				paramGraphics.setClip(this.viewportWidth, 0, this.viewportWidth,
						this.var_3bfb);
			} else {
				paramGraphics.setClip(0, 0, this.someGWidth, this.var_3bfb);
			}
			localClass_f_0451.draw(paramGraphics, 0,
					localClass_f_0451.var_80c);
		}
		paramGraphics.translate(0, -this.var_3a43);
		paramGraphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
		if (this.var_3bf3) {
			this.var_3bf3 = false;
			int k = this.someCanHeight - var_32c3;
			paramGraphics.setColor(14672074);
			paramGraphics.fillRect(0, k, this.someCanWidth, var_32c3);
			D_Menu
					.sub_5602(paramGraphics, 0, k, this.someCanWidth, var_32c3, 0);
			paramGraphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			this.var_3b9b.drawUnitHealth(paramGraphics);
			paramGraphics.translate(this.viewportWidth, 0);
			this.var_3ba3.drawUnitHealth(paramGraphics);
			paramGraphics.translate(-this.viewportWidth, 0);
		}
		if (this.var_3beb) {
			this.var_3beb = false;
			drawAttackStatMenu(paramGraphics, this.var_3b9b.m_unit,
					this.var_3ba3.m_unit, 0);
		}
		if (this.var_3be3) {
			sub_e77a(paramGraphics, 0, this.waveImageAmplitude, 16, 1, null, 0, 0,
					this.someCanWidth, this.someCanHeight);
		}
	}

	public final void sub_14bd3(int paramInt) {
		this.var_3bc3 = true;
		this.someMaxTime = paramInt;
		this.someStartTime = this.time;
	}

	public final D_Menu sub_14c01(String[] paramArrayOfString,
			A_MenuBase paramClass_a_000) {
		D_Menu localClass_d_0231;
		D_Menu localClass_d_0232;
		if (this.var_3c13.length > 0) {
			(localClass_d_0232 = (localClass_d_0231 = new D_Menu(
					(byte) 11, 0)).createTitleMenu(A_MenuBase.getLangString(46))).menuTitleIcon = this.menuIconsFrames[6];
			localClass_d_0231.createMenuListItems(this.var_3c13, this.someGWidth / 2,
					(this.someGHeight + localClass_d_0232.menuHeight) / 2,
					this.someGWidth, this.someGHeight - localClass_d_0232.menuHeight,
					3, 4);
		} else {
			(localClass_d_0232 = (localClass_d_0231 = new D_Menu(
					(byte) 10, 0)).createTitleMenu(A_MenuBase.getLangString(46))).menuTitleIcon = this.menuIconsFrames[6];
			localClass_d_0231.createDescDialogMb(null, A_MenuBase.getLangString(52),
					this.someGWidth, -1);
		}
		localClass_d_0231.setParentMenu(paramClass_a_000);
		A_MenuBase.mainCanvas.showMenu(localClass_d_0231);
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
					this.newsItemsMenu = sub_14c01(this.var_3c13, this.var_3c7b);
				} else if (this.var_3c83 == 1) {
					((DataInputStream) localObject1).readInt();
					this.var_3c23[this.var_3c03] = ((DataInputStream) localObject1)
							.readUTF();
					D_Menu localClass_d_0231;
					(localClass_d_0231 = createDialog(
							this.var_3c13[this.var_3c03],
							this.var_3c23[this.var_3c03], this.someGHeight,
							this.someGHeight / 2, -1)).setParentMenu(this.var_3c7b);
					A_MenuBase.mainCanvas.showMenu(localClass_d_0231);
				} else if (this.var_3c83 == 2) {
					int m = ((DataInputStream) localObject1).readInt() / 3;
					this.var_3c2b = new String[m];
					this.var_3c33 = new String[m];
					this.someSizesMb = new int[m];
					for (n = 0; n < m; n++) {
						this.var_3c2b[n] = ((DataInputStream) localObject1)
								.readUTF();
						this.var_3c33[n] = ((DataInputStream) localObject1)
								.readUTF();
						this.someSizesMb[n] = Integer
								.parseInt(((DataInputStream) localObject1)
										.readUTF());
					}
					sub_5d1a(this.var_3c7b);
					A_MenuBase.mainCanvas.showMenu(this.var_3943);
				} else if (this.var_3c83 == 3) {
					String str = this.var_3c2b[this.var_3c0b];
					byte[] arrayOfByte = new byte[j];
					((DataInputStream) localObject1).readFully(arrayOfByte);
					sub_15568(str, arrayOfByte);
					sub_5d1a(this.var_3943.parentMenu);
					D_Menu localClass_d_0232;
					(localClass_d_0232 = createDialog(null,
							A_MenuBase.replaceStringFirst(45, str), this.someGHeight, 2000))
							.setParentMenu(this.var_3943);
					A_MenuBase.mainCanvas.showMenu(localClass_d_0232);
				}
				this.var_3c7b = null;
				return;
			}
			((DataInputStream) localObject1).close();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		D_Menu localObject = createDialog(null, A_MenuBase.getLangString(44),
				this.someGHeight, -1);
		localObject.setParentMenu(this.var_3c7b);
		this.var_3c7b = null;
		A_MenuBase.mainCanvas.showMenu((A_MenuBase) localObject);
	}

	public final void startRetrievingData(int paramInt, String resName,
			String langCode, A_MenuBase inMenu) throws Exception {
		this.var_3c83 = paramInt;
		this.var_3c7b = inMenu;
		this.var_3c73 = false;
		this.m_baos = new ByteArrayOutputStream();
		this.m_dos = new DataOutputStream(this.m_baos);
		this.m_dos.writeInt(10001);
		this.m_dos.writeUTF(this.appPropPortalCode);
		this.m_dos.writeUTF(this.appPropGameCode);
		this.var_3c6b = this.m_baos.size();
		this.m_dos.writeUTF("resourceName");
		this.m_dos.writeUTF(resName);
		this.m_dos.writeUTF("languageCode");
		this.m_dos.writeUTF(langCode);
		this.m_dos.writeUTF("maxChunkSize");
		this.m_dos.writeUTF("1024");
		this.m_dos.writeUTF("chunk");
		this.m_dos.writeUTF("0");
		this.m_dos.writeUTF("requestId");
		this.m_dos.writeUTF("0");
		D_Menu retrievingMenu = createDialog(null, A_MenuBase.getLangString(43),
				this.someGHeight, -1);
		retrievingMenu.setParentMenu(inMenu); //Retrieving data...
		A_MenuBase.mainCanvas.showMenu(retrievingMenu);
		new Thread(this).start();
	}

	/* Error */
	public final void run() {
		//@todo
	}

	public final void sub_15429(int index) throws Exception {
		int i = this.var_3903[index];
		this.var_38f3 -= 1;
		String[] arrayOfString = new String[this.var_38f3];
		int[] arrayOfInt = new int[this.var_38f3];
		System.arraycopy(this.var_38fb, 0, arrayOfString, 0, index);
		System.arraycopy(this.var_38fb, index + 1, arrayOfString, index,
				this.var_38f3 - index);
		System.arraycopy(this.var_3903, 0, arrayOfInt, 0, index);
		System.arraycopy(this.var_3903, index + 1, arrayOfInt, index,
				this.var_38f3 - index);
		this.var_38fb = arrayOfString;
		this.var_3903 = arrayOfInt;
		E_MainCanvas.sub_16d3("download", i);
		this.downloadStoreAvailableSize = E_MainCanvas.getRecordStoreAvailableSize("download");
		saveSettingsMb();
		for (int j = 0; j < 3; j++) {
			if (this.slotsMapIndexes[j] == i + skirmishMapsNames.length) {
				this.slotsCurrentPlayerIds[j] = -1;
				this.slotsMapIndexes[j] = -1;
				this.slotsDescriptions[j] = ("\n" + A_MenuBase.getLangString(79) + "\n ");
				E_MainCanvas.saveRecordStoreData("save", j, new byte[0]);
			}
		}
	}

	public final void sub_15568(String paramString, byte[] someData)
			throws Exception {
		String[] arrayOfString = new String[this.var_38f3 + 1];
		int[] arrayOfInt = new int[this.var_38f3 + 1];
		System.arraycopy(this.var_38fb, 0, arrayOfString, 0, this.var_38f3);
		System.arraycopy(this.var_3903, 0, arrayOfInt, 0, this.var_38f3);
		this.var_38fb = arrayOfString;
		this.var_3903 = arrayOfInt;
		this.var_3903[this.var_38f3] = E_MainCanvas.saveDataToStore("download", someData);
		this.var_38fb[this.var_38f3] = paramString;
		this.var_38f3 += 1;
		this.downloadStoreAvailableSize = E_MainCanvas.getRecordStoreAvailableSize("download");
		saveSettingsMb();
	}

	public final void saveSettingsMb() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(this.var_38f3);
		for (int i = 0; i < this.var_38f3; i++) {
			dos.writeInt(this.var_3903[i]);
			dos.writeUTF(this.var_38fb[i]);
		}
		E_MainCanvas.saveRecordStoreData("settings", 2, baos.toByteArray());
		dos.close();
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_i_168
 * 
 * JD-Core Version: 0.7.0.1
 */