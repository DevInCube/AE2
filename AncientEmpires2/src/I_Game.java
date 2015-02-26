import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class I_Game extends A_MenuBase implements Runnable {
	
	public String appPropVersion = "?";
	public static byte someUnkHeight1 = 32;
	public int someGWidth;
	public int someGHeight;
	public int viewportWidth;
	public int viewportHeight;
	public int unlockedScenarioLevelsCount = 0;
	public static String[] skirmishMapsNames = new String[12];
	public static int[] skMapsUnlockWhenCampLvlFin = { 4, 5, 6, 7, 8, 9, 10, 11 };
	public boolean[] skMapUnlockedArr;
	public static final short[] skirmishStartMoneyEnum = { 500, 1000, 2000 };
	public static final short[] skirmishStartUnitsEnum = { 10, 20, 25 };
	public int mapStartMoney;
	public int mapStartUnitCap;
	public byte mapModeCampIf0;
	public static int m_actionApply = 1024;
	public static int m_actionCancel = 2048;
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
	public byte[] inGameMenuItems = { 0, 6, 5, 7, 8, 9 };
	public byte[] startMenuItems = { 0, 6, 5, 7, 8, 9 };
	public byte[] playMenuItems = { 1, 2, 3, 4 };
	public static final byte[][] cursorFrameSequences = { { 0, 1 }, { 2, 3, 4 }, { 0, 1 },
			{ 5 } }; // move cursor, attack cursor, move cursor, move unit
	public static final byte[] poisonFrameSeq = { 0 };
	public long cursorFrameStartTime = 0L;
	public long cursorMovingStartTimeMb;
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
	public static final int[] playersMusicIdsMb = { -1, 2, 3, 2, 3 };
	public static final int[] playersFAMusicIds = { -1, 4, 5, 4, 5 };
	public F_Sprite[][] playersUnitsSprites;
	public static final byte[] waterBlinkAnimTilesIndexes = { 1, 2 };
	public static final byte[] tilesDefences = { 0, 5, 10, 10, 15, 0, 5, 15, 15, 15 };
	public static final byte[] tilesMovements = { 1, 1, 2, 2, 3, 3, 1, 1, 1, 1 };
	public int houseTileIdStartIndex;
	public H_ImageExt[] smallTilesImages;
	public byte[] tilesProps;
	public int mapWidthPixel;
	public int mapHeightPixel;
	public int var_341b;
	public int var_3423;
	public int mapWidth;
	public int mapHeight;
	private H_ImageExt tombstoneSprite;
	public H_ImageExt[] allTilesImages;
	public F_Sprite cursorSprite;
	public F_Sprite moveUnitCursorSprite;
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
	public int someCursorXPos;
	public int someCursorYPos;
	public byte[][] mapTilesIds;
	public byte unkState;
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
	public byte[] somePlayersData = new byte[5];
	public byte[] playersIndexes = new byte[4];
	public byte[] playersTeams = new byte[4];
	public byte playerId = 0;
	public short currentTurn;
	public C_Unit[] playersKings;
	public C_Unit[][] playerKingsMb;
	public int[] playerUnitsCount;
	public int[] playersMoney = new int[4];
	public byte[][] kingsPositions = new byte[4][2];
	public byte[] mapPlayersTypes = new byte[4];
	public D_Menu unitActionsMenu;
	public Vector mapEffectsSpritesList = new Vector();
	public Vector someSpritesVector1 = new Vector();
	public C_Unit dyingUnit;
	public C_Unit var_35db;
	public long someStartTime6;
	public C_Unit someSparkingUnit;
	public byte someSprkingUnitPlayerId;
	public long someSparksStartTime13;
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
	public long someStartTime1;
	public boolean cursorIsMovingMb = false;
	public long waterBlinkAnimStartTime;
	public int waterBlinkCurFrameInd;
	public int someWaterBlinkFrameIndex;
	public H_ImageExt[] waterBlinkAnimFrames;
	public boolean isBlackLoading = false;
	public boolean showPressAnyKey;
	public static int[] instrTitlesStringsIds = { 83, 83, 83, 83, 83, 83, 83, 83, 175, 84,
			84, 84, 175, 147, 159, 151, 155, 167, 171 }; // 83 - GENERAL,...
	public int helpTipId = -1;
	public D_Menu instructionsMenu;
	public D_Menu instructionsItemsMenu;
	public D_Menu instructionsDescMenu;
	public D_Menu startupMessageBox;
	public int var_3703 = 8;
	public D_Menu skirmishMapsItemsMenu;
	public D_Menu skirmishMapsMenu;
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
	public F_Sprite heavensFuryMissle;
	public C_Unit furyTargetUnit;
	public int var_3873 = 0;
	public boolean showFuryAfterEffect = true;
	public boolean isSaethDead;
	public String mapName;
	public String[] slotsDescriptions;
	public byte[] slotsCurrentPlayerIds;
	public int[] slotsMapIndexes;
	public D_Menu loadSlotsMenu;
	public D_Menu saveSlotsMenu;
	public D_Menu var_38bb;
	public D_Menu slotDescMenu;
	public D_Menu mainMenuMb;
	public D_Menu warningEndGameMenu;
	public D_Menu warningDialog;
	public byte mapTeamsCount;
	public byte[] somePlayerIds;
	public int countExtraMapsMb;
	public String[] extraSkirmishMapNamesMb;
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
	public C_Unit m_tempUnit;
	public int someCameraVelocityMb = 12;
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
	public int playerIncomeMb;
	public static final byte[] someUnitsValuesForAImb = { 0, 2, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3 };
	public byte var_3a6b = 0;
	public int var_3a73;
	public int someTileType;
	public C_Unit var_3a83;
	public C_Unit var_3a8b;
	public C_Unit var_3a93;
	public int var_3a9b;
	public long aSomeOtherStartTime;
	public C_Unit[] someUnits5;
	public C_Unit[] someHouseUnits;
	public byte[] var_3abb;
	public int[][] someAIPosAValArr;
	public int[] var_3acb;
	public int var_3ad3;
	public byte[][] someMData;
	public int mapCastlesCount;
	public int someXPos;
	public int someYPos;
	public int var_3afb;
	public int var_3b03;
	public Vector someUnitsVector34;
	public boolean var_3b13 = false;
	public int waitTimeValue;
	public D_Menu mapNameDialog;
	public C_Unit skeleton1Map2;
	public C_Unit crystalOfWisdom;
	public C_Unit skeleton2Map2;
	public C_Unit wisdomCrystalKeeper;
	public C_Unit crystal3Unit;
	public C_Unit unitEndTurnMb;
	public int scriptStep;
	public long var_3b63;
	public int var_3b6b;
	public boolean isWaiting = false;
	public boolean var_3b7b = false;
	public int cameraX = -1;
	public int cameraY = -1;
	public int var_3b93 = 0;
	public G_FightAnimation faUnit1;
	public G_FightAnimation faUnit2;
	public long someStartTime2;
	public boolean var_3bb3;
	public Vector gameSprites = new Vector();
	public boolean isShakingScreen = false;
	public long shakeScreenMaxTime;
	public long shakeScreenStartTime;
	public boolean unitStrikesBackFAMb;
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
	public int m_baosSize;
	public boolean var_3c73;
	public A_MenuBase someOnlineParentMenu;
	public int var_3c83;
	
	private boolean skipIntro = true;

	public I_Game() {
		this.actionIconsFrames = new H_ImageExt[this.unitActionsNames.length];
		this.menuIconsFrames = new H_ImageExt[this.mainMenuItemsNames.length];
		this.houseSmokeSprites = new F_Sprite[0];
		this.m_tempUnit = null;
		this.crystal3Unit = null;
		this.unitEndTurnMb = null;
	}
	
	//@Override
	public final void onLoad() {
		//sub_4d3f();
		//sub_87e6();
		//clearActiveUnit();
		//sub_c1eb();
		//sub_dd85();
		//sub_ddbb();
		//sub_1447e();
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
		this.extraSkirmishMapNamesMb = new String[0];
		this.var_3903 = new int[0];
		try {
			byte[] arrayOfByte = E_MainCanvas.getRecordStoreData("settings", 2);
			DataInputStream stream1 = new DataInputStream(
					new ByteArrayInputStream(arrayOfByte));
			this.countExtraMapsMb = stream1.readInt();
			this.var_3903 = new int[this.countExtraMapsMb];
			this.extraSkirmishMapNamesMb = new String[this.countExtraMapsMb];
			for (int i1 = 0; i1 < this.countExtraMapsMb; i1++) {
				this.var_3903[i1] = stream1.readInt();
				this.extraSkirmishMapNamesMb[i1] = stream1.readUTF();
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
			m_actionApply = 2048;
			m_actionCancel = 1024;
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
		this.someGHeight = (this.someCanHeight - someUnkHeight1);
		this.viewportHeight = (this.someGHeight >> 1);
		E_MainCanvas.stopMusic();
		if (this.gameMode2Mb == 1) {
			return;
		}
		this.gameMode2Mb = 1;
		C_Unit.loadUnitsProps(this);
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
		this.moveUnitCursorSprite = new F_Sprite(this.cursorSprite);
		this.moveUnitCursorSprite.setFrameSequence(cursorFrameSequences[3]);
		this.waterBlinkAnimFrames = new H_ImageExt[2];
		this.someWaterBlinkFrameIndex = waterBlinkAnimTilesIndexes[0];
		this.waterBlinkAnimFrames[0] = this.allTilesImages[waterBlinkAnimTilesIndexes[0]];
		this.waterBlinkAnimFrames[1] = this.allTilesImages[waterBlinkAnimTilesIndexes[1]];
		this.bigSmokeSprite = new F_Sprite("b_smoke");
	}

	public final void sub_4bfe(int paramInt1, int paramInt2) {
		if ((this.mapModeCampIf0 == 0) && (this.gameMode2Mb == 1)
				&& (this.unkState == 0)) {
			int i = 0;
			this.m_strBuf.append(paramInt2);
			String str = this.m_strBuf.toString();
			for (int j = 0; j < var_39a3.length; j++) {
				if (str.equals(var_39a3[j])) {
					if (j == 0) {
						if (this.scenarioMapIndex == 7) {
							this.isSaethDead = true;
						} else {
							missionComplete();
						}
					} else if (j == 1) {
						this.playersMoney[this.playerId] += 1000;
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
		this.kingsPositions[this.playerId][0] = ((byte) this.someCursorXPos);
		this.kingsPositions[this.playerId][1] = ((byte) this.someCursorYPos);
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
			stream.writeByte(this.playersTeams[i]);
			stream.writeByte(this.mapPlayersTypes[i]);
			stream.writeShort(this.playersMoney[i]);
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
			stream.writeByte(unit.m_tombMaxTurns);
			stream.writeByte(unit.someStatusPlayerId);
			if (unit.unitTypeId == 9) {
				stream.writeByte(unit.kingIndex);
				stream.writeShort(unit.cost);
				stream
						.writeByte(this.playersKings[unit.playerId] == unit ? 1
								: 0);
			}
			i++;
		}
		stream.writeShort((short) this.scriptStep);
		stream.writeInt((int) this.var_3b63);
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
			this.playersTeams[i] = stream.readByte();
			this.mapPlayersTypes[i] = stream.readByte();
			this.playersMoney[i] = stream.readShort();
			this.kingsPositions[i][0] = stream.readByte();
			this.kingsPositions[i][1] = stream.readByte();
		}
		this.mapStartUnitCap = stream.readByte();
		for (int i = 0; i < this.housesDataArr.length; i++) {
			this.mapTilesIds[this.housesDataArr[i][0]][this.housesDataArr[i][1]] = stream
					.readByte();
		}
		this.playerKingsMb = new C_Unit[this.mapMaxPlayersMb][4];
		this.playerUnitsCount = new int[this.mapMaxPlayersMb];
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
			lUnit.m_tombMaxTurns = b6;
			lUnit.someStatusPlayerId = b7;
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
		E_MainCanvas.playMusicLooped2(playersMusicIdsMb[this.playersIndexes[this.playerId]], 0);
	}

	public final void saveToSlotMenuShow(int paramInt, A_MenuBase parentMenu) {
		try {
			E_MainCanvas.saveRecordStoreData("save", paramInt, saveMapDataBytes());
			this.slotsDescriptions[paramInt] = getSlotDescription(this.mapModeCampIf0, this.scenarioMapIndex,
					this.currentTurn);
			this.slotsCurrentPlayerIds[paramInt] = this.playersIndexes[this.playerId];
			this.slotsMapIndexes[paramInt] = this.scenarioMapIndex;
			this.slotDescMenu.createDescDialogMb(null, this.slotsDescriptions[paramInt], this.someGWidth, -1);
			this.slotDescMenu.titleGradientColor = playerColors[this.slotsCurrentPlayerIds[paramInt]];
			this.slotDescMenu.onLoad();
			D_Menu slotSavedDialog = createDialog(null, A_MenuBase.getLangString(77), this.someGHeight, 1000); // GAME SAVED
			slotSavedDialog.parentMenu = parentMenu;
			A_MenuBase.mainCanvas.showMenu(slotSavedDialog);
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

	public final void targetUnit(C_Unit unit) {
		this.var_3873 = 0;
		moveCursorToPos(unit.positionX, unit.positionY);
		this.furyTargetUnit = unit;
	}

	public final void sub_55bd(C_Unit unit1, C_Unit unit2) {
		if (unit2.m_state == 4) {
			this.var_35db = unit2;
			showSpriteOnMap(this.redsparkSprite, this.var_35db.posXPixel,
					this.var_35db.posYPixel, 0, 0, 1, 50);
			this.var_3603 = 6;
			this.activeUnit.endMove();
			this.unkState = 0;
			clearActiveUnit();
			this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
			if (this.mapPlayersTypes[this.playerId] == 0) {
				this.aSomeOtherStartTime = this.time;
				this.var_3a6b = 6;
			}
		} else {
			if ((E_MainCanvas.settings[3] != false) && (unit2.charsData.length > 0)) {
				this.var_364b = true;
				this.waveImageAmplitude = 0;
				E_MainCanvas.stopMusic();
			} else {
				this.unkState = 13;
				this.var_366b = 0;
				this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
			}
			this.attackerUnitMb = unit1;
			this.attackedUnitMb = unit2;
		}
	}

	public final void afterUnitsAttacked() {
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
				poisonSprite.setFrameSequence(poisonFrameSeq);
				this.mapEffectsSpritesList.addElement(poisonSprite);
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
		this.someStartTime6 = this.time;
		if (this.mapPlayersTypes[this.playerId] == 0) {
			this.aSomeOtherStartTime = this.time;
			this.var_3a6b = 6;
		}
		this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
		this.unkState = 0;
		this.attackerUnitMb.endMove();
		this.attackedUnitMb = null;
		this.attackerUnitMb = null;
	}

	public final F_Sprite showSpriteOnMap(F_Sprite sprite, int inX, int inY, 
			int paramInt3, int paramInt4,
			int paramInt5, int inTime) {
		F_Sprite aSprinte = F_Sprite.someSpriteCopy(sprite, paramInt3,
				paramInt4, 0, paramInt5, inTime, (byte) 0);
		aSprinte.setSpritePosition(inX, inY);
		this.someSpritesVector1.addElement(aSprinte);
		return aSprinte;
	}

	public final void sub_58af(C_Unit unit) {
		this.canApplyMb = true;
		this.canCancelMb = (!this.var_3723);
		this.alphaWindowWTF = 12;
		this.unkState = 1;
		this.cursorIsMovingMb = true;
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

	public final void initUnitActionsMenu(byte[] data, C_Unit unitUnused) {
		this.unitActionsMenu = new D_Menu((byte) 0, 0);
		int length = data.length;
		String[] names = new String[length];
		H_ImageExt[] images = new H_ImageExt[length];
		for (int j = 0; j < data.length; j++) {
			names[j] = this.unitActionsNames[data[j]];
			images[j] = this.actionIconsFrames[data[j]];
		}
		if (this.someCursorYPos * 24 <= this.someGHeight / 2 - 24) {
			this.unitActionsMenu.sub_1e97(names, images, 0,
					this.someGHeight - this.buttonsSprite.frameHeight, 36);
		} else {
			this.unitActionsMenu.sub_1e97(names, images, this.someGWidth, 0, 8);
		}
		this.unitActionsMenu.setParentMenu(this);
		A_MenuBase.mainCanvas.showMenu(this.unitActionsMenu);
	}

	public final D_Menu createSlotsMenu(String desc, H_ImageExt image) {
		String[] slotNames = new String[3];
		for (int i = 0; i < 3; i++) {
			slotNames[i] = ("SLOT " + (i + 1) + "/" + 3);
		}
		this.var_38bb = new D_Menu((byte) 14, 0);
		this.var_38bb.setMenuItemsNames(slotNames, this.someGWidth, -1);
		this.slotDescMenu = new D_Menu((byte) 10, 0);
		this.slotDescMenu.createDescDialogMb(null, this.slotsDescriptions[0], this.someGWidth, -1);
		if (this.slotsCurrentPlayerIds[0] != -1) {
			this.slotDescMenu.titleGradientColor = playerColors[this.slotsCurrentPlayerIds[0]];
		}
		D_Menu menu1 = new D_Menu((byte) 15, 15);
		int j = (this.someGHeight - this.var_38bb.menuHeight - this.slotDescMenu.menuHeight) / 2;
		D_Menu aMenu = new D_Menu((byte) 10, 0);
		aMenu.createDescDialogMb(null, desc, this.someGWidth, -1);
		aMenu.menuTitleIcon = image;
		menu1.addChildMenu(aMenu, 0, 0, 0);
		j += aMenu.menuHeight / 2;
		menu1.addChildMenu(this.var_38bb, 0, j, 0);
		j += this.var_38bb.menuHeight;
		menu1.addChildMenu(this.slotDescMenu, 0, j, 20);
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
			for (int n = 0; n < this.countExtraMapsMb; n++) {
				if (this.var_3c2b[k].equals(this.extraSkirmishMapNamesMb[n])) {
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
		if (this.extraSkirmishMapNamesMb.length == 0) {
			localClass_d_0231 = new D_Menu((byte) 10, 0);
			D_Menu delMenu = localClass_d_0231.createTitleMenu(A_MenuBase.getLangString(49));//DELETE
			delMenu.menuTitleIcon = this.menuIconsFrames[6]; 
			localClass_d_0231.createDescDialogMb(null, A_MenuBase.getLangString(52),
					this.someCanWidth, -1); //EMPTY
			localClass_d_0231.setMenuLoc(0,
					(this.someGHeight + delMenu.menuHeight) / 2, 6);
			localClass_d_0231.setParentMenu(menu);
			this.deleteMapMenu = null;
			return localClass_d_0231;
		}
		this.deleteMapMenu = new D_Menu((byte) 11, 0);
		localClass_d_0231 = this.deleteMapMenu.createTitleMenu(A_MenuBase.getLangString(49));//DELETE
		localClass_d_0231.menuTitleIcon = this.menuIconsFrames[6];
		this.deleteMapMenu
				.createMenuListItems(this.extraSkirmishMapNamesMb, this.someCanWidth / 2,
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
					return this.extraSkirmishMapNamesMb[j];
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
		if ((menu == this.unitActionsMenu) && (paramByte == 1)) {
			if (this.unkState == 3) {
				this.activeUnit.setUnitPosition(this.var_3503, this.var_350b);
				this.activeUnit.fillWhereUnitCanMove(this.someMapData);
				sub_58af(this.activeUnit);
				this.cursorIsMovingMb = true;
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
				showPlayMenu(this.playMenuItems, this.someMenuWidth, this.someMenuHeight,
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
				//this.castleBuyUnitMenu.onLoad();
			}
			return;
		}
		Object localObject1;
		if (menu == this.castleBuyMenu) {
			if (paramByte == 0) {
				localObject1 = this.castleBuyAllUnitsMenu.buyUnits[this.castleBuyAllUnitsMenu.activeItemPositionMb];
				if (sub_e9d0((C_Unit) localObject1, this.someCursorXPos,
						this.someCursorYPos)) {
					this.activeUnit = buyUnit((C_Unit) localObject1,
							this.someCursorXPos, this.someCursorYPos);
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
				int numPlayers = 0;
				int numTeams = 0;
				boolean[] playersFlags = new boolean[this.mapTeamsCount];
				for (int plIndex = 0; plIndex < this.mapTeamsCount; plIndex++) {
					if (this.choosePlayerMenuList[plIndex].activeItemPositionMb == 2) { //NONE
						this.mapPlayersTypes[plIndex] = 2;
					} else {
						numPlayers++;
						if (this.choosePlayerMenuList[plIndex].activeItemPositionMb == 0) { //PLAYER
							this.mapPlayersTypes[plIndex] = 1;
						} else if (this.choosePlayerMenuList[plIndex].activeItemPositionMb == 1) { //CPU
							this.mapPlayersTypes[plIndex] = 0;
						}
						this.playersTeams[plIndex] = ((byte) this.chooseTeamMenuList[plIndex].activeItemPositionMb);
						if (playersFlags[this.playersTeams[plIndex]] == false) {
							numTeams++;
							playersFlags[this.playersTeams[plIndex]] = true;
						}
					}
				}
				if ((numPlayers < 2) || (numTeams < 2)) {
					//2 players and 2 teams minimum are required to start a skirmish game.
					D_Menu infoMenu = createDialog(null, A_MenuBase.getLangString(39), this.someGHeight, 2000); 
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
				this.unkState = 0;
			}
			return;
		}
		int i4;
		int i7;
		if (menu == this.skirmishMapsMenu) {
			int ii;
			int j = this.skirmishMapsItemsMenu.activeItemPositionMb;
			if ((paramByte == 0) && ((j >= skirmishMapsNames.length) || (this.skMapUnlockedArr[j] == false))) {
				this.var_34e3 = sub_60ce(j);
				DataInputStream dis1 = getSkirmishMapData(this.var_34e3);
				i4 = dis1.readInt();
				i7 = dis1.readInt();
				byte[][] lo61 = new byte[i4][i7];
				this.somePlayerIds = new byte[4];
				byte[] lo71 = new byte[5];
				for (int i13 = 0; i13 < 5; i13++) {
					lo71[i13] = -1;
				}
				this.mapTeamsCount = 0;
				for (int i13 = 0; i13 < i4; i13++) {
					for (int i14 = 0; i14 < i7; i14++) {
						lo61[i13][i14] = dis1
								.readByte();
						if ((this.tilesProps[lo61[i13][i14]] == 9)
								&& ((ii = houseOwnerPlayerIndex(i13, i14,
										(byte[][]) lo61)) != 0)
								&& (lo71[ii] == -1)) {
							this.somePlayerIds[this.mapTeamsCount] = ((byte) ii);
							lo71[ii] = this.mapTeamsCount;
							this.mapTeamsCount = ((byte) (this.mapTeamsCount + 1));
						}
					}
				}
				dis1.close();
				this.mapName = this.skirmishMapsItemsMenu.menuItemsNamesMb[j];
				this.skirmishSetupMenu = new D_Menu((byte) 15, 15);
				D_Menu settingsMenuMb = new D_Menu((byte) 10, 0);
				settingsMenuMb.menuTitleIcon = this.menuIconsFrames[4]; //castle skirmish
				settingsMenuMb.createDescDialogMb(null, this.mapName, this.someGWidth, -1);
				D_Menu menu11 = new D_Menu((byte) 8, 0);
				menu11.initMapPreviewMenu(
						this.someCanWidth, this.someGHeight
								- settingsMenuMb.menuHeight
								- this.buttonsSprite.frameHeight,
						(byte[][]) lo61, null);
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
							if ((this.unkState != 11) && (this.unkState != 14)) {
								E_MainCanvas.playMusicLooped(
										playersMusicIdsMb[this.playersIndexes[this.playerId]],
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
				this.slotDescMenu = null;
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
					this.slotDescMenu = null;
					A_MenuBase.mainCanvas.showMenu(this);
					this.isBlackLoading = true;
					A_MenuBase.mainCanvas.repaintAll();
					checkResources();
					loadMapDataBytes((byte[]) saveData);
					if (this.mapModeCampIf0 == 0) {
						this.isUpdatingMb = true;
					}
					this.isBlackLoading = false;
					this.unkState = 0;
				}
			} else {
				this.loadSlotsMenu = null;
				this.var_38bb = null;
				this.slotDescMenu = null;
			}
		} else if (menu == this.var_38bb) {
			if ((paramByte == 2) || (paramByte == 3)) {
				this.slotDescMenu.createDescDialogMb(null, this.slotsDescriptions[itemNumber],
						this.someGWidth, -1);
				if (this.slotsCurrentPlayerIds[itemNumber] == -1) {
					this.slotDescMenu.titleGradientColor = 2370117; //#242A45 dark blue
				} else {
					this.slotDescMenu.titleGradientColor = playerColors[this.slotsCurrentPlayerIds[itemNumber]];
				}
				this.slotDescMenu.onLoad();
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
					this.newsItemsMenu = createOnlineNewsMenu(this.var_3c13, menu);
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
				saveSlots(this.var_395b);
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
			if ((this.gameMode2Mb == 0) || (this.unkState != 0)) {
				showPlayMenu(this.playMenuItems, this.someMenuWidth, this.someMenuHeight,
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
			this.mapPlayersTypes[1] = 0;
			this.isBlackLoading = true;
			A_MenuBase.mainCanvas.repaintAll();
			System.gc();
			checkResources();
			loadMap(this.scenarioMapIndex);
			this.isBlackLoading = false;
			initScenarioMap();
			this.unkState = 0;
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
			this.skirmishMapsMenu = new D_Menu((byte) 15, 15);
			titleMenu = new D_Menu((byte) 10, 0);
			titleMenu.createDescDialogMb(null,
					itemName, this.someGWidth, -1);
			titleMenu.menuTitleIcon = this.menuIconsFrames[4];
			this.skMapUnlockedArr = new boolean[12];
			for (int lvlInd = this.unlockedScenarioLevelsCount; lvlInd <= 7; lvlInd++) {
				this.skMapUnlockedArr[skMapsUnlockWhenCampLvlFin[lvlInd]] = true;
			}
			String[] skMapsNamesCaptions = new String[12];
			for (int it7 = 0; it7 < 12; it7++) {
				if (this.skMapUnlockedArr[it7] != false) {
					skMapsNamesCaptions[it7] = A_MenuBase.getLangString(42); //LOCKED
				} else {
					skMapsNamesCaptions[it7] = skirmishMapsNames[it7];
				}
			}
			String[] allSkMapsCaptions = new String[12 + this.countExtraMapsMb];
			System.arraycopy(skMapsNamesCaptions, 0, allSkMapsCaptions, 0, 12);
			System.arraycopy(this.extraSkirmishMapNamesMb, 0, allSkMapsCaptions, 12,
					this.countExtraMapsMb);
			this.skirmishMapsItemsMenu = new D_Menu((byte) 0, 0);
			this.skirmishMapsItemsMenu.createMenuListItems(allSkMapsCaptions, 0, 0, this.someGWidth,
					this.someGHeight - titleMenu.menuHeight
							- this.buttonsSprite.frameHeight * 2, 3, 4);
			this.skirmishMapsMenu.addChildMenu(this.skirmishMapsItemsMenu, this.viewportWidth,
					(this.someGHeight + titleMenu.menuHeight) / 2, 3);
			this.skirmishMapsMenu.addChildMenu(titleMenu, 0, 0, 0);
			this.skirmishMapsMenu.updateAllChildrenBoolMb = true;
			this.skirmishMapsMenu.setMenuActionEnabled((byte) 0, true);
			this.skirmishMapsMenu.setParentMenu(menu);
			A_MenuBase.mainCanvas.showMenu(this.skirmishMapsMenu);
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
							.getLangString(instrTitlesStringsIds[(i5 - 1)]) + " " + i5 + "/" + 19);
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
			showPlayMenu(this.startMenuItems, this.viewportHeight, this.someGHeight,
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
			this.var_34cb = this.unkState;
			this.unkState = 6;
			this.cursorIsMovingMb = true;
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
			this.var_3753 = getSomeUnit(this.someCursorXPos, this.someCursorYPos, (byte) 0);
			this.unkState = 0;
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
			this.unkState = 0;
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(67))) { //OCCUPY
			if (canOccupyVillageOrTown(this.activeUnit.positionX, this.activeUnit.positionY,
					this.activeUnit)) {
				occupyHouse(this.activeUnit.positionX, this.activeUnit.positionY,
						this.playersIndexes[this.activeUnit.playerId]);
				A_MenuBase.mainCanvas.showMenu(createDialog(null,
						A_MenuBase.getLangString(73), this.someGHeight, 1000)); //OCCUPIED!
				this.unkState = 9;
				E_MainCanvas.playMusicLooped(9, 1);
				this.someStartTime5 = this.time;
			}
			this.activeUnit.endMove();
			return;
		}
		if (itemName.equals(A_MenuBase.getLangString(69))) {
			this.unkState = 7;
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

	public final C_Unit buyUnit(C_Unit unit, int inX, int inY) {
		this.playersMoney[this.playerId] -= unit.cost;
		unit.unitHealthMb = 100;
		unit.setUnitPosition(inX, inY);
		if (!this.mapUnitsSprites.contains(unit)) {
			this.mapUnitsSprites.addElement(unit);
		}
		this.var_397b = true;
		return unit;
	}

	public final C_Unit aiBuyUnit(byte uType, int inX, int inY) {
		this.playersMoney[this.playerId] -= C_Unit.unitsCosts[uType];
		this.var_397b = true;
		return C_Unit.createUnitOnMap(uType, this.playerId, inX, inY);
	}

	public final F_Sprite sub_87c3(byte paramByte1, byte paramByte2) {
		return this.playersUnitsSprites[paramByte1][paramByte2];
	}

	public final void sub_87e6() {
		this.mapUnitsSprites = new Vector();
		this.activeUnit = null;
		this.var_34f3 = null;
		this.m_tempUnit = null;
	}

	public final void loadMap(int mapId) throws Exception {
		E_MainCanvas.stopMusic();
		this.mapEffectsSpritesList = new Vector();
		this.isFadingIn = false;
		this.isCursorVisible = true;
		this.var_364b = false;
		this.isSaethDead = false;
		this.var_353b = null;
		this.dyingUnit = null;
		this.furyTargetUnit = null;
		this.var_35db = null;
		this.someSparkingUnit = null;
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
			this.somePlayersData[i] = -1;
		}
		this.cursorIsMovingMb = true;
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
		this.someMData = new byte[this.mapWidth][this.mapHeight];
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
								&& (this.somePlayersData[m] == -1)) {
							this.playersIndexes[this.mapMaxPlayersMb] = ((byte) m);
							this.somePlayersData[m] = this.mapMaxPlayersMb;
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
		this.mapWidthPixel = (this.mapWidth * 24);
		this.mapHeightPixel = (this.mapHeight * 24);
		
		
		if (this.mapModeCampIf0 == 1) {
			for (short i = 0; i < this.mapMaxPlayersMb; i = (short) (i + 1)) {
				this.playersMoney[i] = this.mapStartMoney;
			}
		}
		else {
			this.mapMaxPlayersMb = 2;
			this.playersMoney[0] = 0;
			this.playersMoney[1] = 0;
			this.somePlayersData[1] = 0;
			this.somePlayersData[2] = 1;
			this.playersIndexes[0] = 1;
			this.playersIndexes[1] = 2;
			this.playersTeams[0] = 0;
			this.playersTeams[1] = 1;
			this.mapStartUnitCap = 100;
		}

		for (short i = 0; i < this.housesDataArr.length; i = (short) (i + 1)) {
			m = this.housesDataArr[i][2];
			if ((m > 0) && (this.mapPlayersTypes[sub_e276(m)] == 2)) { //NONE
				occupyHouse(this.housesDataArr[i][0], this.housesDataArr[i][1], 0);
			}
		}
		int m1 = dis.readInt();
		dis.skip(m1 * 4);
		int sLength = dis.readInt();
		this.playersKings = new C_Unit[this.mapMaxPlayersMb];
		this.playerKingsMb = new C_Unit[this.mapMaxPlayersMb][4];
		this.playerUnitsCount = new int[this.mapMaxPlayersMb];
		for (short i = 0; i < sLength; i = (short) (i + 1)) {
			int uType = dis.readByte();
			int posX = dis.readShort() / 24;
			int posY = dis.readShort() / 24;
			byte unitType = (byte) (uType % 12);
			byte playerID = (byte) sub_e276(1 + uType / 12);
			if (this.mapPlayersTypes[playerID] != 2) { //not NONE
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
		this.crystal3Unit = null;
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
				if (this.mapPlayersTypes[i] != 2) { // not NONE
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
		this.someHouseUnits = new C_Unit[this.housesDataArr.length];
		this.var_3abb = new byte[this.housesDataArr.length];
		this.houseSmokeSprites = new F_Sprite[this.housesDataArr.length];
		for (short i = 0; i < this.housesDataArr.length; i = (short) (i + 1)) {
			if (getTileType(this.housesDataArr[i][0], this.housesDataArr[i][1]) == 8) {
				this.houseSmokeSprites[i] = F_Sprite.someSpriteCopy(this.bigSmokeSprite, 0, -1,
						0, 1, 250, (byte) 0);
				this.houseSmokeSprites[i].isUpdatingMb = false;
			}
		}
		// this caused save\load units hight speed issue
		/*if (this.mapPlayersTypes[this.playerId] == 0) { //CPU
			initCPUPlayerMb();
		}*/
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

	public final void initSomeUnitData(C_Unit unit) {
		E_MainCanvas.stopMusicPlayer(10);
		this.m_tempUnit = null;
		fillArrayWithValue(this.someMapData, 0);
		this.var_351b = false;
		if (this.mapPlayersTypes[this.playerId] == 1) { //PLAYER
			this.var_39c3 = 1;
			this.isCursorVisible = true;
			this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
			this.unkState = 3;
			initUnitActionsMenu(getUnitActionsData(unit, (byte) 0), unit);
			E_MainCanvas.playMusicLooped(11, 1);
			return;
		}
		if (this.mapPlayersTypes[this.playerId] == 0) { //CPU
			this.var_3a6b = 4;
			this.unkState = 0;
		}
	}

	public final byte[] getUnitActionsData(C_Unit unit, byte moveIf1) {
		int actionsCount = 0;
		byte[] data = new byte[this.unitActionsNames.length];
		//castle and is owner		
		if ((moveIf1 == 1)
				&& (getTileType(this.activeUnit.positionX, this.activeUnit.positionY) == 9) 
				&& (playerIsOwnerOfTile(this.activeUnit.positionX, this.activeUnit.positionY, unit.playerId))) {
			data[(actionsCount++)] = 0; // BUY
		}
		if (canOccupyVillageOrTown(unit.positionX, unit.positionY, unit) 
				|| canRepairVillages(unit.positionX, unit.positionY, unit)) {
			data[(actionsCount++)] = (byte) (canRepairVillages(unit.positionX, unit.positionY, unit) ? 2 : 1);
		}
		// not catapult
		if (((moveIf1 == 1) || (unit.unitTypeId != 7))
				&& (unit.charsData.length > 0)
				&& (unit.getActiveUnitsInAttackRange(unit.positionX,
						unit.positionY, (byte) 0).length > 0)) {
			data[(actionsCount++)] = 3; // attack
		}
		C_Unit[] tombs = unit.getActiveUnitsInAttackRange(unit.positionX, unit.positionY, (byte) 1);
		if ((unit.hasProperty((short) 32)) && (tombs.length > 0)) { // magi 
			data[(actionsCount++)] = 4; //raise
		}
		if (moveIf1 == 1) {
			data[(actionsCount++)] = 5;
		} else {
			data[(actionsCount++)] = 6;
		}
		byte[] actionsData = new byte[actionsCount];
		System.arraycopy(data, 0, actionsData, 0, actionsCount);
		return actionsData;
	}

	public final void updateIntro() throws Exception {
		switch (this.introMode) {
		case 0: // mslogoStill
			long showMSLogoStillTime = 0L;
			if (this.time >= showMSLogoStillTime) {
				this.introMode = 1;
				this.waveImageAmplitude = this.skipIntro ? 0 : 40; //40
			}
			return;
		case 1: // mslogowave
			if (this.waveImageAmplitude <= 0) {
				this.msLogoImage = null;
				this.waveImageAmplitude = 0;
				this.introMode += 1;
				if(!this.skipIntro)
					loadIntro(0, 0, 3);
				return;
			}
			this.waveImageAmplitude -= 1;
			return;
		case 2:
			if(!this.skipIntro)
				loadIntro(1, 2, 3);
			this.logoImage = new H_ImageExt("logo");
			this.introMode += 1;
			return;
		case 3:
			int maxLogoWaveAmp = (this.skipIntro) ? 0 : 40;
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
				if (((this.splashImage == null) || (A_MenuBase.mainCanvas.isAnyActionPressed()))
						&& (sub_4789())) {
					if (this.glowImage != null) { // stop glow animation
						this.glowImagePosX = (-this.glowImage.imageWidth);
					}
					this.showPressAnyKey = false;
					int logoHeight = this.logoImage.imageHeight + 1;
					showPlayMenu(this.inGameMenuItems, (this.someCanHeight + logoHeight) / 2,
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
		if (this.gameMode2Mb == 2) { //game mode
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
		if (this.unkState == 0) { 
			for (int i = 0; i < this.houseSmokeSprites.length; i++) {
				int k = tileOwnerPlayerIndex(this.housesDataArr[i][0], this.housesDataArr[i][1]);
				if ((this.houseSmokeSprites[i] != null) && (k != -1) && (k != 0)
						&& (!this.houseSmokeSprites[i].isUpdatingMb)
						&& (E_MainCanvas.random.nextInt() % 8 == 0)) {
					this.houseSmokeSprites[i].isUpdatingMb = true;
					this.houseSmokeSprites[i].setCurrentFrameIndex(0);
					this.houseSmokeSprites[i].var_81c = 1;
					this.houseSmokeSprites[i].setSpritePosition((this.housesDataArr[i][0] + 1) * 24
							- this.bigSmokeSprite.frameWidth,
							this.housesDataArr[i][1] * 24 - 2);
					this.someSpritesVector1.addElement(this.houseSmokeSprites[i]);
				}
			}
		}
		/*if (this.time - this.someStartTime1 >= 300L) {
			this.var_368b = (!this.var_368b);
			this.someStartTime1 = this.time;
		}*/
		if ((this.isShakingScreen) && (this.time - this.shakeScreenStartTime >= this.shakeScreenMaxTime)) {
			this.isShakingScreen = false;
		}
		if (this.var_364b) {
			this.waveImageAmplitude += 1;
			if (this.waveImageAmplitude > 16) {
				if (this.unkState == 10) {
					this.var_3b93 = 1;
				} else if (this.unkState == 11) {
					if (this.mapModeCampIf0 == 0) {
						this.isFading = true;
						this.var_380b = true;
						this.fadeInColor = 0;
					}
					this.var_372b = 0;
					this.someStartTime5 = this.time;
				} else {
					setupUnitsFAmb(this.attackerUnitMb, this.attackedUnitMb);
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
		if ((this.isCursorVisible) && (this.time - this.cursorFrameStartTime >= 200L)) {
			this.cursorSprite.nextFrame();
			this.cursorFrameStartTime = this.time;
		}
		int k = this.someCursorXPos * 24;
		int m = this.someCursorYPos * 24;
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
			String incomeStr;
			Object localObject5;
			if (this.unkState == 8) {
				if (this.var_354b == 0) {
					if (this.var_378b < someUnkHeight1) {
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
						if (this.mapPlayersTypes[this.playerId] == 1) { // PLAYER
							incomeStr = "" + this.playerIncomeMb;
						} else { //CPU
							incomeStr = "?";
						}
						//NEW TURN!  INCOME: %U
						D_Menu newTurnMenu = createDialog(
								A_MenuBase.getLangString(75),
								A_MenuBase.replaceStringFirst(76, (String) incomeStr),
								this.someGHeight, 750);
						A_MenuBase.mainCanvas.showMenu(newTurnMenu);
						newTurnMenu.titleGradientColor = playerColors[this.playersIndexes[this.playerId]];
						E_MainCanvas.playMusicLooped2(
								playersMusicIdsMb[this.playersIndexes[this.playerId]], 0);
					}
				} else {
					for (int i = this.mapUnitsSprites.size() - 1; i >= 0; i--) {
						C_Unit mUnit = (C_Unit) this.mapUnitsSprites.elementAt(i);
						//unit not dead stay on his house
						if ((mUnit.m_state != 3)
								&& (this.playerId == mUnit.playerId)
								&& ((getTileType(
										mUnit.positionX,
										mUnit.positionY) == 7) || (isInSameTeam(
												mUnit.positionX,
												mUnit.positionY,
										this.playersTeams[mUnit.playerId])))
								&& (mUnit.unitHealthMb < 100)) {
							int uHealth = 100 - mUnit.unitHealthMb;
							if (uHealth > 20) {
								uHealth = 20;
							}
							mUnit.unitHealthMb += uHealth; // house revive units
							F_Sprite healSprite = F_Sprite.sub_15c2("+" + uHealth, 0, -4, (byte) 1);
							healSprite.setSpritePosition(
											((F_Sprite) mUnit).posXPixel
													+ ((F_Sprite) mUnit).frameWidth
													/ 2,
											((F_Sprite) mUnit).posYPixel
													+ ((F_Sprite) mUnit).frameHeight);
							this.mapEffectsSpritesList.addElement(healSprite);
						}
					}
					this.var_354b = 0;
					this.var_3793 = false;
					this.unkState = 0;
				}
			} else if (this.unkState == 9) {
				this.unkState = 0;
			} else if (this.unkState == 11) {
				if ((!this.var_364b)
						&& (this.var_372b == 0)
						&& ((this.mapModeCampIf0 == 1)
								|| (this.time - this.someStartTime5 >= 3000L) || (A_MenuBase.mainCanvas
								.isAnyActionPressed()))) {
					this.someGHeight = this.someCanHeight;
					this.viewportHeight = this.someCanHeightDiv2;
					showPlayMenu(this.inGameMenuItems, this.someCanHeightDiv2, this.someCanHeight, null);
					this.var_372b = 1;
					this.var_380b = false;
				}
			} else {
				Object localObject3;
				if ((this.unkState == 10) || (this.unkState == 14)) {
					if ((this.var_3b93 == 1)
							|| ((this.unkState == 14) && (this.var_3b93 != 2))) {
						this.scenarioMapIndex += 1;
						if (this.scenarioMapIndex > this.unlockedScenarioLevelsCount) {
							incomeStr = skirmishMapsNames[skMapsUnlockWhenCampLvlFin[this.unlockedScenarioLevelsCount]];
							localObject3 = createDialog(null, A_MenuBase.replaceStringFirst(
									82, (String) incomeStr), this.someCanHeight,
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
						if (this.unkState == 14) {
							this.someGHeight = this.someCanHeight;
							this.viewportHeight = this.someCanHeightDiv2;
							showPlayMenu(this.inGameMenuItems, this.someCanHeightDiv2, this.someCanHeight,
									null);
							return;
						}
						if (this.scenarioMapIndex <= 7) {
							loadMap(this.scenarioMapIndex);
							initScenarioMap();
							this.unkState = 0;
						}
					}
				} else {
					int iX;
					if (this.unkState == 13) {
						int i2;
						if (this.var_366b == 0) {
							E_MainCanvas.vibrate(200);
							i2 = this.attackerUnitMb.getUnitAttackDamage(this.attackedUnitMb);
							this.attackedUnitMb.shakeUnit(400);
							E_MainCanvas.playMusicLooped(14, 1);
							showSpriteOnMap(this.redsparkSprite, this.attackedUnitMb.posXPixel,
									this.attackedUnitMb.posYPixel, 0, 0, 2, 50);
							localObject3 = F_Sprite.sub_15c2("-" + i2, 0,
									-4, (byte) 1);
							if ((iX = this.attackedUnitMb.posXPixel
									+ this.attackedUnitMb.frameWidth / 2)
									+ ((F_Sprite) localObject3).frameWidth / 2 > this.mapWidthPixel) {
								iX = this.mapWidthPixel
										- ((F_Sprite) localObject3).frameWidth
										/ 2;
							} else if (iX
									- ((F_Sprite) localObject3).frameWidth / 2 < 0) {
								iX = ((F_Sprite) localObject3).frameWidth / 2;
							}
							((F_Sprite) localObject3).setSpritePosition(iX,
									this.attackedUnitMb.posYPixel
											+ this.attackedUnitMb.frameHeight);
							this.mapEffectsSpritesList.addElement(localObject3);
							this.var_3673 = this.time;
							this.var_366b += 1;
						} else if (this.var_366b == 1) {
							if (this.time - this.var_3673 >= 800L) {
								moveCursorToPos(this.attackerUnitMb.positionX,
										this.attackerUnitMb.positionY);
								if (this.attackedUnitMb.isNearOtherUnit(this.attackerUnitMb,
										this.attackerUnitMb.positionX,
										this.attackerUnitMb.positionY)) {
									E_MainCanvas.vibrate(200);
									i2 = this.attackedUnitMb.getUnitAttackDamage(this.attackerUnitMb);
									this.attackerUnitMb.shakeUnit(400);
									E_MainCanvas.playMusicLooped(14, 1);
									showSpriteOnMap(this.redsparkSprite,
											this.attackerUnitMb.posXPixel,
											this.attackerUnitMb.posYPixel, 0, 0, 2, 50);
									localObject3 = F_Sprite.sub_15c2("-"
											+ i2, 0, -4, (byte) 1);
									if ((iX = this.attackerUnitMb.posXPixel
											+ this.attackerUnitMb.frameWidth / 2)
											+ ((F_Sprite) localObject3).frameWidth
											/ 2 > this.mapWidthPixel) {
										iX = this.mapWidthPixel
												- ((F_Sprite) localObject3).frameWidth
												/ 2;
									} else if (iX
											- ((F_Sprite) localObject3).frameWidth
											/ 2 < 0) {
										iX = ((F_Sprite) localObject3).frameWidth / 2;
									}
									((F_Sprite) localObject3).setSpritePosition(iX,
											this.attackerUnitMb.posYPixel
													+ this.attackerUnitMb.frameHeight);
									this.mapEffectsSpritesList.addElement(localObject3);
									this.var_3673 = this.time;
									this.var_366b += 1;
								} else {
									afterUnitsAttacked();
								}
							}
						} else if (this.time - this.var_3673 >= 800L) {
							afterUnitsAttacked();
						}
					} else if (this.furyTargetUnit != null) {
						if (this.var_3873 == 0) {
							if (this.var_39cb) {
								this.heavensFuryMissle = showSpriteOnMap(this.sparkSprite,
										this.furyTargetUnit.posXPixel, -this.var_3423,
										0, 12, -1, 0);
								D_Menu localClass_d_0232;
								(localClass_d_0232 = createDialog(null,
										A_MenuBase.getLangString(280),
										this.someGHeight, 2000)).setMenuLoc(
										this.viewportWidth, 2, 17);
								A_MenuBase.mainCanvas.showMenu(localClass_d_0232);
								this.var_3873 = 1;
							}
						} else if (this.var_3873 == 1) {
							for (int i = 0; i < 3; i++) {
								showSpriteOnMap(
										this.bigSmokeSprite,
										this.heavensFuryMissle.posXPixel
												+ E_MainCanvas
														.getRandomMax(this.heavensFuryMissle.frameWidth
																- this.bigSmokeSprite.frameWidth),
										this.heavensFuryMissle.posYPixel, 0, E_MainCanvas
												.getRandomWithin(-3, 0), 1,
										50 * E_MainCanvas.getRandomMax(4));
							}
							if (this.heavensFuryMissle.posYPixel >= this.furyTargetUnit.posYPixel) {
								this.heavensFuryMissle.isUpdatingMb = false;
								E_MainCanvas.vibrate(200);
								startShakingScreen(500);
								if (this.showFuryAfterEffect) {
									int furyDmg = 25 + E_MainCanvas.getRandomMax(25);
									if (furyDmg > this.furyTargetUnit.unitHealthMb) {
										furyDmg = this.furyTargetUnit.unitHealthMb;
									}
									this.furyTargetUnit.unitHealthMb -= furyDmg;
									F_Sprite furyDmgSprite = F_Sprite.sub_15c2("-" + furyDmg, 0, -4, (byte) 1);
									furyDmgSprite.setSpritePosition(
													this.furyTargetUnit.posXPixel
															+ this.furyTargetUnit.frameWidth
															/ 2,
													this.furyTargetUnit.posYPixel
															+ this.furyTargetUnit.frameHeight);
									this.mapEffectsSpritesList.addElement(furyDmgSprite);
								}
								showHeavensFuryAfterEffect(this.furyTargetUnit);
								this.var_3873 = 2;
							}
						} else if (++this.var_3873 >= 20) {
							if (this.furyTargetUnit.unitHealthMb <= 0) {
								this.dyingUnit = this.furyTargetUnit;
								showSpriteOnMap(this.sparkSprite, this.dyingUnit.posXPixel,
										this.dyingUnit.posYPixel, 0, 0, 1, 50);
								E_MainCanvas.playMusicLooped(12, 1);
								this.someStartTime6 = this.time;
							}
							this.furyTargetUnit = null;
						}
					} else if (this.var_35db != null) {
						if (--this.var_3603 <= 0) {
							E_MainCanvas.vibrate(100);
							showHeavensFuryAfterEffect(this.var_35db);
							repairDestroyedHouse((byte) 27, this.var_35db.positionX,
									this.var_35db.positionY);
							this.var_35db = null;
						}
					} else if (this.dyingUnit != null) {
						if ((this.time - this.someStartTime6 >= 300L)
								&& (sub_b848(this.dyingUnit.positionX,
										this.dyingUnit.positionY))) {
							if ((this.mapModeCampIf0 == 0) && (this.scenarioMapIndex == 7)
									&& (this.dyingUnit == this.playersKings[1])) {
								this.isSaethDead = true;
							} else {
								showSpriteOnMap(this.smokeSprite, this.dyingUnit.posXPixel,
										this.dyingUnit.posYPixel, 0, -3, 1, 100);
								this.dyingUnit.m_state = 3;
								this.dyingUnit.m_tombMaxTurns = 3;
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
						C_Unit descUnit;
						if (this.gotNewLevelUnits.size() > 0) {
							descUnit = (C_Unit) this.gotNewLevelUnits
									.elementAt(0);
							if (this.var_382b == 0) {
								moveCursorToPos(descUnit.positionX,
										descUnit.positionY);
								this.var_382b = 1;
							} else if (sub_b848(descUnit.positionX,
									descUnit.positionY)) {
								showSpriteOnMap(
										this.smallSparkSprite,
										descUnit.posXPixel
												+ E_MainCanvas
														.getRandomMax(descUnit.frameWidth),
										descUnit.posYPixel
												+ E_MainCanvas
														.getRandomMax(descUnit.frameHeight),
										0, 0, 1, 50);
								if (this.var_382b == 1) {
									E_MainCanvas.playMusicLooped(13, 1);
								}
								if (this.var_382b <= 5) {
									int lvlUpTime = 120;
									if (this.var_382b == 5) {
										lvlUpTime = 600;
									}
									iX = descUnit.posXPixel
											+ (descUnit.frameWidth - this.levelupSprite.frameWidth)
											/ 2;
									int iY = descUnit.posYPixel - this.var_382b * 4;
									if (iX < 0) {
										iX = 0;
									} else if (iX + this.levelupSprite.frameWidth > this.mapWidthPixel) {
										iX = this.mapWidthPixel - this.levelupSprite.frameWidth;
									}
									if (iY < 0) {
										iY = 0;
									}
									showSpriteOnMap(this.levelupSprite, iX, iY, 0, 0, 1, lvlUpTime);
								}
								this.var_382b += 1;
								if (this.var_382b >= 20) {
									this.gotNewLevelUnits
											.removeElement(descUnit);
									this.var_382b = 0;
									if ((descUnit.unitTypeId != 9)
											&& (descUnit.level <= 6)
											&& (descUnit.level % 2 == 0)) {
										A_MenuBase.mainCanvas
												.showMenu(createDialog(
														null,
														A_MenuBase.getLangString(80)
																+ "\n"
																+ descUnit.unitName,
														this.someGWidth, 750));
									}
								}
							}
						} else if (this.someSparkingUnit != null) {
							if (this.time - this.someSparksStartTime13 >= 400L) {
								this.someSparkingUnit.removeFromMap();
								(descUnit = C_Unit.createUnitOnMap(
										(byte) 10, this.someSprkingUnitPlayerId,
										this.someSparkingUnit.positionX,
										this.someSparkingUnit.positionY)).endMove();
								this.someSparkingUnit = null;
							}
						} else if (!this.var_3b7b) {
							if (this.unkState == 2) {
								if ((this.activeUnit.m_state != 1)
										&& (this.var_39cb)) {
									initSomeUnitData(this.activeUnit);
								}
							} else if (this.mapPlayersTypes[this.playerId] == 0) {
								sub_ebb9();
							} else if (sub_4789()) {
								if ((this.canApplyMb)
										&& (A_MenuBase.mainCanvas
												.someActionCodeIsSet(m_actionApply))) {
									A_MenuBase.mainCanvas.addActionCode(16);
									A_MenuBase.mainCanvas.clearActionCode(m_actionApply);
								}
								if ((this.unkState == 6)
										|| (this.unkState == 7)) {
									if ((A_MenuBase.mainCanvas.invertActionCode(4))
											|| (A_MenuBase.mainCanvas.invertActionCode(1))) {
										this.var_34eb -= 1;
										if (this.var_34eb < 0) {
											this.var_34eb = (this.var_34f3.length - 1);
										}
										A_MenuBase.mainCanvas.clearActionCode(4);
										A_MenuBase.mainCanvas.clearActionCode(1);
										this.cursorIsMovingMb = true;
									} else if ((A_MenuBase.mainCanvas.invertActionCode(8))
											|| (A_MenuBase.mainCanvas.invertActionCode(2))) {
										this.var_34eb += 1;
										if (this.var_34eb >= this.var_34f3.length) {
											this.var_34eb = 0;
										}
										A_MenuBase.mainCanvas.clearActionCode(8);
										A_MenuBase.mainCanvas.clearActionCode(2);
										this.cursorIsMovingMb = true;
									}
									moveCursorToPos(
											this.var_34f3[this.var_34eb].positionX,
											this.var_34f3[this.var_34eb].positionY);
									if (this.cursorIsMovingMb) {
										this.var_3753 = getSomeUnit(this.someCursorXPos,
												this.someCursorYPos, (byte) 0);
										this.var_3983 = true;
									}
									if (A_MenuBase.mainCanvas.invertActionCode(16)) {
										if (this.unkState == 6) {
											sub_55bd(
													this.activeUnit,
													this.var_34f3[this.var_34eb]);
										} else if (this.unkState == 7) {
											setSomeSparkingUnitMb(
													this.var_34f3[this.var_34eb],
													this.playerId);
											this.activeUnit.endMove();
											this.unkState = 0;
										}
										this.unitActionsMenu = null;
										this.var_351b = false;
										this.var_3523 = false;
										this.canCancelMb = false;
										this.canApplyMb = false;
									}
									this.cursorIsMovingMb = false;
								} else {
									if ((this.time - this.cursorMovingStartTimeMb >= 50L)
											&& (this.cursorSprite.posXPixel % 24 == 0)
											&& (this.cursorSprite.posYPixel % 24 == 0)) {
										if ((A_MenuBase.mainCanvas.invertActionCode(4))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(4))) {
											if (this.someCursorXPos > 0) {
												this.someCursorXPos -= 1;
											}
											this.cursorIsMovingMb = true;
											this.cursorMovingStartTimeMb = this.time;
										} else if ((A_MenuBase.mainCanvas
												.invertActionCode(8))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(8))) {
											if (this.someCursorXPos < this.mapWidth - 1) {
												this.someCursorXPos += 1;
											}
											this.cursorIsMovingMb = true;
											this.cursorMovingStartTimeMb = this.time;
										}
										if ((A_MenuBase.mainCanvas.invertActionCode(1))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(1))) {
											if (this.someCursorYPos > 0) {
												this.someCursorYPos -= 1;
											}
											this.cursorIsMovingMb = true;
											this.cursorMovingStartTimeMb = this.time;
										} else if ((A_MenuBase.mainCanvas
												.invertActionCode(2))
												|| (A_MenuBase.mainCanvas
														.isActionLongPressed(2))) {
											if (this.someCursorYPos < this.mapHeight - 1) {
												this.someCursorYPos += 1;
											}
											this.cursorIsMovingMb = true;
											this.cursorMovingStartTimeMb = this.time;
										}
										if (this.cursorIsMovingMb) {
											if (this.unkState == 1) {
												if (this.someMapData[this.someCursorXPos][this.someCursorYPos] > 0) {
													this.var_353b = this.activeUnit
															.sub_1b48(
																	this.activeUnit.positionX,
																	this.activeUnit.positionY,
																	this.someCursorXPos,
																	this.someCursorYPos);
												}
											} else {
												this.var_3753 = getSomeUnit(
														this.someCursorXPos,
														this.someCursorYPos, (byte) 0);
											}
											this.var_3983 = true;
										}
										this.cursorIsMovingMb = false;
									}
									if (((this.unkState == 1) || (this.unkState == 0))
											&& (A_MenuBase.mainCanvas.invertActionCode(256))) { // key 7 - unit desc
										descUnit = getSomeUnit( this.someCursorXPos, this.someCursorYPos, (byte) 0);
										if (descUnit != null) {
											D_Menu menuI41 = new D_Menu((byte) 15, 15);
											menuI41.var_11b5 = this.someGHeight;
											iX = 0;
											D_Menu menu234 = new D_Menu((byte) 5, 2);
											D_Menu descUnitMenu = new D_Menu((byte) 10, 1);
											descUnitMenu.var_1125 = true;
											String str = A_MenuBase.getLangString(184 + descUnit.unitTypeId); //unit desc
											if (descUnit.status != 0) {
												//STATUS
												StringBuffer strBuf1 = new StringBuffer(A_MenuBase.getLangString(98));
												if ((descUnit.status & 0x2) != 0) {
													strBuf1.append('\n');
													strBuf1.append(A_MenuBase.getLangString(100)); //AURA
												}
												if ((descUnit.status & 0x1) != 0) {
													strBuf1.append('\n');
													strBuf1.append(A_MenuBase.getLangString(99)); //POISON
												}
												strBuf1.append("\n-----------\n");
												str = strBuf1.toString() + str;
											}
											descUnitMenu.createDescDialogMb(
															null,
															str,
															this.someGWidth,
															this.someGHeight
																	- menu234.menuHeight);
											((D_Menu) menuI41).addChildMenu(menu234,0, 0, 0);
											((D_Menu) menuI41).addChildMenu(descUnitMenu, 0, menu234.menuHeight, 0);
											((D_Menu) menuI41).updateAllChildrenBoolMb = true;
											((D_Menu) menuI41).setParentMenu(this);
											A_MenuBase.mainCanvas.showMenu((A_MenuBase) menuI41);
										}
										A_MenuBase.mainCanvas.clearActionCode(256);
									}
									if (this.unkState == 1) {
										if ((A_MenuBase.mainCanvas.invertActionCode(16))
												&& (this.activeUnit != null)) {
											descUnit = getSomeUnit(
													this.someCursorXPos,
													this.someCursorYPos, (byte) 0);
											if ((this.someMapData[this.someCursorXPos][this.someCursorYPos] > 0)
													&& ((descUnit == null) || (descUnit == this.activeUnit))) {
												this.var_3503 = this.activeUnit.positionX;
												this.var_350b = this.activeUnit.positionY;
												this.activeUnit.goToPosition(
														this.someCursorXPos,
														this.someCursorYPos, true);
												this.m_tempUnit = this.activeUnit;
												this.isCursorVisible = false;
												this.var_351b = false;
												this.var_353b = null;
												this.unitActionsMenu = null;
												this.canCancelMb = false;
												this.canApplyMb = false;
												this.unkState = 2;
												E_MainCanvas.playMusicLooped(10, 1);
											}
											A_MenuBase.mainCanvas.clearActionCode(16);
										}
									} else if (this.unkState == 0) {
										if (A_MenuBase.mainCanvas.invertActionCode(512)) {
											int i4 = 0;
											C_Unit localObject4 = this.playersKings[this.playerId];
											if ((this.var_3753 != null)
													&& (this.var_3753.unitTypeId == 9)) {
												//@todo
											}
											C_Unit unit41 = this.playerKingsMb[this.playerId][((this.var_3753.unitId + 1) % this.playerUnitsCount[this.playerId])];
											for (;;) {
												i4++;
												if ((i4 >= this.playerUnitsCount[this.playerId])
														|| (unit41.m_state != 3)) {
													break;
												}
												unit41 = this.playerKingsMb[this.playerId][((unit41.unitId + 1) % this.playerUnitsCount[this.playerId])];
											}
											if ((unit41 != null)
													&& (unit41.m_state != 3)) {
												moveCursorToPos(
														unit41.positionX,
														unit41.positionY);
												sub_b998( unit41.posXPixel + 12, unit41.posYPixel + 12);
											}
										} else if (A_MenuBase.mainCanvas.invertActionCode(32)) {
											if (this.var_3523) {
												fillArrayWithValue(this.someMapData, 0);
												this.var_351b = false;
												this.var_3523 = false;
											} else {
												this.activeUnit = getSomeUnit(
														this.someCursorXPos,
														this.someCursorYPos, (byte) 0);
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
										} else if ((A_MenuBase.mainCanvas.invertActionCode(16)) // key - 5?
												|| (A_MenuBase.mainCanvas.invertActionCode(m_actionApply))) {
											this.activeUnit = getSomeUnit(
													this.someCursorXPos,
													this.someCursorYPos, (byte) 0);
											if ((this.activeUnit != null)
													&& (this.activeUnit.m_state == 0)
													&& (this.activeUnit.playerId == this.playerId)) {
												byte[] unitActionsData = getUnitActionsData(
														this.activeUnit, (byte) 1);
												if (unitActionsData.length > 1) {
													initUnitActionsMenu(
															unitActionsData,
															this.activeUnit);
													E_MainCanvas.playMusicLooped(11, 1);
												} else {
													this.var_3723 = false;
													sub_58af(this.activeUnit);
												}
											} else if ((getTileType(this.someCursorXPos,
													this.someCursorYPos) == 9)
													&& (playerIsOwnerOfTile(this.someCursorXPos,
															this.someCursorYPos,
															this.playerId))) {
												byte[] someBytes2 = new byte[] { 0 };
												initUnitActionsMenu(someBytes2, null);
												E_MainCanvas.playMusicLooped(11, 1);
											} else {
												this.activeUnit = null;
												this.unitActionsMenu = new D_Menu((byte) 11, 0);
												this.unitActionsMenu.createMenuListItems(
														this.gameMenuItemsNames, 2, 2,
														-1, this.someGHeight, 20,
														0);
												this.unitActionsMenu.setParentMenu(this);
												A_MenuBase.mainCanvas.showMenu(this.unitActionsMenu);
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
		int uIt = 0;
		int jCount = this.mapUnitsSprites.size();
		while (uIt < jCount) {
			((C_Unit) this.mapUnitsSprites.elementAt(uIt)).unitUpdate();
			uIt++;
		}
		//water blink animation upate
		if (this.time - this.waterBlinkAnimStartTime >= 300L) {
			this.waterBlinkCurFrameInd = ((this.waterBlinkCurFrameInd + 1) % this.waterBlinkAnimFrames.length);
			this.allTilesImages[this.someWaterBlinkFrameIndex] = this.waterBlinkAnimFrames[this.waterBlinkCurFrameInd];
			this.waterBlinkAnimStartTime = this.time;
		}
		sub_b79b();
		if ((this.canCancelMb) && (A_MenuBase.mainCanvas.someActionCodeIsSet(m_actionCancel))) {
			if (this.unkState == 1) {
				this.unkState = 0;
				fillArrayWithValue(this.someMapData, 0);
				this.var_353b = null;
				this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
				moveCursorToPos(this.activeUnit.positionX, this.activeUnit.positionY);
				this.activeUnit = null;
			} else if ((this.unkState == 6) || (this.unkState == 7)) {
				this.unkState = this.var_34cb;
				fillArrayWithValue(this.someMapData, 0);
				this.cursorSprite.setFrameSequence(cursorFrameSequences[0]);
				moveCursorToPos(this.activeUnit.positionX, this.activeUnit.positionY);
				A_MenuBase.mainCanvas.showMenu(this.unitActionsMenu);
			}
			this.var_351b = false;
			this.var_3523 = false;
			A_MenuBase.mainCanvas.clearActionCode(m_actionCancel);
			this.canCancelMb = false;
			this.canApplyMb = false;
		}
		for (int it = this.mapEffectsSpritesList.size() - 1; it >= 0; it--) {
			F_Sprite sSprite = (F_Sprite) this.mapEffectsSpritesList.elementAt(it);
			sSprite.spriteUpdate();
			if (!sSprite.isUpdatingMb) {
				this.mapEffectsSpritesList.removeElement(sSprite);
			}
		}
		int jIt = 0;
		int jlength = this.someSpritesVector1.size();
		while (jIt < jlength) {
			this.mapEffectsSpritesList.addElement(this.someSpritesVector1.elementAt(jIt));
			jIt++;
		}
		this.someSpritesVector1.removeAllElements();
	}

	public final void showHeavensFuryAfterEffect(C_Unit unit) {
		int i = unit.posYPixel + 24;
		showSpriteOnMap(this.smokeSprite, unit.posXPixel, i
				- this.smokeSprite.frameHeight, 0, -2, 1, 100);
		for (int j = 0; j < 5; j++) {
			showSpriteOnMap(this.bigSmokeSprite, unit.posXPixel, i
					- this.bigSmokeSprite.frameHeight, -2 + j,
					E_MainCanvas.getRandomWithin(-4, -1), 1,
					50 + 50 * E_MainCanvas.getRandomMax(4));
		}
		showSpriteOnMap(this.sparkSprite, unit.posXPixel, unit.posYPixel, 0, 0, 1, 100);
	}

	public final void setSomeSparkingUnitMb(C_Unit unit1, byte inPlayerId) {
		this.someSparkingUnit = unit1;
		this.someSprkingUnitPlayerId = inPlayerId;
		showSpriteOnMap(this.sparkSprite, unit1.posXPixel - 8,
				unit1.posYPixel - 8, 1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, unit1.posXPixel + 8,
				unit1.posYPixel - 8, -1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, unit1.posXPixel - 8,
				unit1.posYPixel + 8, 1, -1, 3, 50);
		showSpriteOnMap(this.sparkSprite, unit1.posXPixel + 8,
				unit1.posYPixel + 8, -1, -1, 3, 50);
		this.someSparksStartTime13 = this.time;
	}

	public final void sub_b79b() {
		if (this.m_tempUnit == null) {
			sub_b9f2(this.cursorSprite.posXPixel + 12, this.cursorSprite.posYPixel + 12);
			return;
		}
		sub_b9f2(this.m_tempUnit.posXPixel + 12, this.m_tempUnit.posYPixel + 12);
	}

	public final boolean sub_b7ff(int inX, int inY) {
		return (this.var_341b == someXWithin(inX))
				&& (this.var_3423 == someYWithin(inY));
	}

	public final boolean sub_b848(int inX, int inY) {
		return sub_b7ff(inX * 24 + 12, inY * 24 + 12);
	}

	public final int someXWithin(int paramInt) {
		int px;
		if (this.mapWidthPixel > this.someGWidth) {
			px = this.viewportWidth - paramInt;
			if (px > 0) {
				px = 0;
			} else if (px < this.someGWidth - this.mapWidthPixel) {
				px = this.someGWidth - this.mapWidthPixel;
			}
		} else {
			px = (this.someGWidth - this.mapWidthPixel) / 2;
		}
		return px;
	}

	public final int someYWithin(int inY) {
		int py;
		if (this.mapHeightPixel > this.someGHeight) {
			py = this.viewportHeight - inY;
			if (py > 0) {
				py = 0;
			} else if (py < this.someGHeight - this.mapHeightPixel) {
				py = this.someGHeight - this.mapHeightPixel;
			}
		} else {
			py = (this.someGHeight - this.mapHeightPixel) / 2;
		}
		return py;
	}

	public final void sub_b998(int pX, int pY) {
		this.var_341b = someXWithin(pX);
		this.var_3423 = someYWithin(pY);
	}

	public final void sub_b9c5(int paramInt1, int paramInt2) {
		sub_b998(paramInt1 * 24 + 12, paramInt2 * 24 + 12);
	}

	public final void sub_b9f2(int paramInt1, int paramInt2) {
		this.var_39cb = true;
		int i = someXWithin(paramInt1);
		int j = someYWithin(paramInt2);
		int k = i - this.var_341b;
		int m = j - this.var_3423;
		int n;
		if (k != 0) {
			n = k / 2;
			if (k < 0) {
				if (n > -this.var_39c3) {
					n = -this.var_39c3;
				} else if (n < -this.someCameraVelocityMb) {
					n = -this.someCameraVelocityMb;
				}
			} else if (n < this.var_39c3) {
				n = this.var_39c3;
			} else if (n > this.someCameraVelocityMb) {
				n = this.someCameraVelocityMb;
			}
			this.var_341b += n;
			this.var_39cb = false;
		}
		if (m != 0) {
			n = m / 2;
			if (m < 0) {
				if (n > -this.var_39c3) {
					n = -this.var_39c3;
				} else if (n < -this.someCameraVelocityMb) {
					n = -this.someCameraVelocityMb;
				}
			} else if (n < this.var_39c3) {
				n = this.var_39c3;
			} else if (n > this.someCameraVelocityMb) {
				n = this.someCameraVelocityMb;
			}
			this.var_3423 += n;
			this.var_39cb = false;
		}
	}

	public final void moveCursorToPos(int px, int py) {
		this.someCursorXPos = px;
		this.someCursorYPos = py;
		this.cursorSprite.setSpritePosition(px * 24, py * 24);
		this.var_3753 = getSomeUnit(this.someCursorXPos, this.someCursorYPos, (byte) 0);
		this.var_3983 = true;
	}

	public final void sub_bbf2(Graphics gr) {
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
					this.allTilesImages[i7].drawImageExt(gr, i1, i2);
				}
				if ((this.var_351b) && (this.someMapData[i5][i4] > 0)) {
					if (this.alphaWindowWTF != 0) {
						gr.clipRect(i1 + this.alphaWindowWTF, i2
								+ this.alphaWindowWTF, 24 - this.alphaWindowWTF * 2,
								24 - this.alphaWindowWTF * 2);
					}
					gr.drawImage(this.alphaMappedTilesImages[i3][i7], i1, i2, 0);
					if (this.alphaWindowWTF != 0) {
						gr.setClip(0, 0, this.someGWidth,
								this.someGHeight);
					}
				}
				int i6;
				if (((i6 = i4 + 1) < this.mapHeight)
						&& (this.tilesProps[this.mapTilesIds[i5][i6]] == 9)) {
					this.allTilesImages[28].drawImageExt(gr, i1, i2);
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

	public final void gameOverVictory(String text) {
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
					|| (A_MenuBase.mainCanvas.someActionCodeIsSet(m_actionApply))) {
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
			drawActionButton(gr, m_actionApply, 2, this.someCanHeight);
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
		int sprLength;
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
			sprLength = this.someCanHeight / 2 + 1;
			gr.setColor(13553358); // #CECECE light gray
			D_Menu.drawRoundedRect(gr, 1, sprLength, this.someCanWidth - 2, i);
			gr.setColor(2370117); // dark blue
			D_Menu.drawRoundedRect(gr, 2, sprLength + 2, this.loadingProgress
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
				if ((this.unkState != 11) && (this.unkState != 10)) {
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
		} else if (this.unkState == 14) {
			gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			gr.setColor(0);
			gr.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
		} else if ((this.unkState == 10) && (this.var_3b93 >= 1)) {
			paintBlackScreenLoading(gr);
		} else if ((this.unkState == 11) && (!this.var_364b)) {
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
					sprLength = this.someCanHeightDiv2 - E_MainCanvas.font8.getHeight() / 2;
					E_MainCanvas.drawString(gr, str1, this.someCanWidthDiv2, sprLength,
							17);
				}
			}
		} else {
			gr.setClip(0, 0, this.someGWidth, this.someGHeight);
			if ((this.mapWidthPixel < this.someGWidth)
					|| (this.mapHeightPixel < this.someGHeight)) {
				gr.setColor(0);
				gr.fillRect(0, 0, this.someGWidth, this.someGHeight);
			}
			if (this.isShakingScreen) {
				int j = E_MainCanvas.getRandom() % 10;
				sprLength = E_MainCanvas.getRandom() % 4;
				gr.translate(j, sprLength);
				sub_bbf2(gr);
				gr.translate(-j, -sprLength);
			} else {
				sub_bbf2(gr);
			}
			int j = 0;
			sprLength = this.mapUnitsSprites.size();
			while (j < sprLength) {
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
			sprLength = this.mapUnitsSprites.size();
			while (j < sprLength) {
				((C_Unit) this.mapUnitsSprites.elementAt(j)).drawUnitHealth(
						gr, this.var_341b, this.var_3423);
				j++;
			}
			int i3;
			int i4;
			if (this.var_353b != null) {
				gr.setColor(14745682);
				sprLength = 12 + this.var_3a4b / 4;
				int n = 24 - sprLength;
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
									sprLength, this.var_3a4b);
						} else if (arrayOfShort2[0] == arrayOfShort1[0] - 1) {
							gr.fillRect(i4, i7 - this.var_3a53, sprLength,
									this.var_3a4b);
						} else if (arrayOfShort2[1] == arrayOfShort1[1] + 1) {
							gr.fillRect(i6 - this.var_3a53, i5 + n,
									this.var_3a4b, sprLength);
						} else if (arrayOfShort2[1] == arrayOfShort1[1] - 1) {
							gr.fillRect(i6 - this.var_3a53, i5,
									this.var_3a4b, sprLength);
						}
					}
					if (i2 == i3 - 1) {
						gr.setClip(0, 0, this.someGWidth,
								this.someGHeight);
						this.moveUnitCursorSprite.drawCurrentFrame(gr, i6, i7, 3);
					} else if ((arrayOfShort2 = (short[]) this.var_353b
							.elementAt(i2 + 1))[0] == arrayOfShort1[0] + 1) {
						gr.fillRect(i4 + n, i7 - this.var_3a53, sprLength,
								this.var_3a4b);
					} else if (arrayOfShort2[0] == arrayOfShort1[0] - 1) {
						gr.fillRect(i4, i7 - this.var_3a53, sprLength,
								this.var_3a4b);
					} else if (arrayOfShort2[1] == arrayOfShort1[1] + 1) {
						gr.fillRect(i6 - this.var_3a53, i5 + n,
								this.var_3a4b, sprLength);
					} else if (arrayOfShort2[1] == arrayOfShort1[1] - 1) {
						gr.fillRect(i6 - this.var_3a53, i5,
								this.var_3a4b, sprLength);
					}
					i2++;
				}
			}
			if (this.activeUnit != null) {
				this.activeUnit.sub_252e(gr, this.var_341b,
						this.var_3423);
				this.activeUnit.drawUnitHealth(gr, this.var_341b,
						this.var_3423);
			}
			if (this.isCursorVisible) {
				this.cursorSprite.drawCurrentFrame(gr, this.var_341b + 12,
						this.var_3423 + 12, 3);
			}
			int k = 0;
			sprLength = this.mapEffectsSpritesList.size();
			while (k < sprLength) {
				F_Sprite fSprite = (F_Sprite) this.mapEffectsSpritesList.elementAt(k);
				fSprite.onSpritePaint(gr, this.var_341b, this.var_3423 + fSprite.var_80c);
				k++;
			}
			gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			k = this.someCanHeight - someUnkHeight1;
			if (this.var_378b > 0) {
				D_Menu.sub_5602(gr, 0, k, this.someGWidth,
						someUnkHeight1, 14);
				gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			}
			sprLength = someUnkHeight1 - 24 >> 1;
			int i1 = 24 + sprLength * 2;
			int i2 = this.someCanWidth - i1;
			k += this.var_378b;
			if (this.var_397b) {
				this.var_397b = false;
				D_Menu.sub_562e(gr, 0, k, i2 + 1, someUnkHeight1, 0,
						2370117, playerColors[this.playersIndexes[this.playerId]],
						this.var_378b, someUnkHeight1);
				i3 = this.someCanHeight - someUnkHeight1 / 2 + this.var_378b;
				if (this.mapModeCampIf0 == 1) {
					i4 = i2 / 2;
					this.hudIcons2Sprite.drawFrameAt(gr, 0, i4, i3, 6);
					int playerUnits = countUnits(-1, -1, this.playerId) - countUnits(10, -1, this.playerId);
					E_MainCanvas.drawCharedString( gr,
							playerUnits + "/" + this.mapStartUnitCap, 
							i4 + this.hudIcons2Sprite.frameWidth + 1, i3, 1, 6);
				}
				i4 = 10;
				if (this.someGWidth <= 120) {
					i4 = 4;
				}
				this.hudIcons2Sprite.drawFrameAt(gr, 1, i4, i3, 6);
				i4 += this.hudIcons2Sprite.frameWidth + 1;
				if (this.mapPlayersTypes[this.playerId] == 1) { //PLAYER
					E_MainCanvas.drawCharedString(gr, ""
							+ this.playersMoney[this.playerId], i4, i3, 1, 6);
				} else {
					E_MainCanvas.drawCharedString(gr, "- - -", i4, i3, 1, 6);
				}
				gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			}
			if (this.var_3983) {
				this.var_3983 = false;
				if (sprLength > 0) {
					drawMenuBorderRect(gr, i2, k, i1, someUnkHeight1);
				}
				i3 = i2 + sprLength;
				i4 = k + sprLength;
				this.allTilesImages[this.mapTilesIds[this.someCursorXPos][this.someCursorYPos]]
						.drawImageExt(gr, i3, i4);
				String str2 = "."
						+ tilesDefences[getTileType(this.someCursorXPos, this.someCursorYPos)];
				E_MainCanvas.drawCharedString(gr, str2, i3 + 24, i4 + 24, 0,
						40);
				if (sprLength == 0) {
					gr.setColor(0);
					gr.drawRect(i3, i4, 24, 24);
				}
			}
			if ((this.unkState == 6)
					&& (this.var_34f3[this.var_34eb].m_state != 4)) {
				i3 = 0;
				if (this.someCursorYPos * 24 <= this.someGHeight / 2 - 24) {
					i3 = this.someGHeight - this.buttonsSprite.frameHeight - this.var_3a43
							+ 2;
				}
				drawAttackStatMenu(gr, this.activeUnit,
						this.var_34f3[this.var_34eb], i3);
			}
		}
		if (sub_4789()) {
			if (this.canCancelMb) {
				drawActionButton(gr, m_actionCancel, 1, this.someGHeight);
			}
			if (this.canApplyMb) {
				drawActionButton(gr, m_actionApply, 0, this.someGHeight);
			}
			if ((this.gameMode2Mb == 1)
					&& ((this.mapPlayersTypes[this.playerId] == 0) || (this.unkState == 0))
					&& (this.unkState != 11)) {
				drawActionButton(gr, m_actionApply, 3, this.someGHeight);
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
							|| (unit2.isNearOtherUnit(unit1,
									unit1.positionX,
									unit1.positionY))) {
						i7 = u1.getUnitExtraAttack(u2);
						str = u1.unitAttackMin + i7 + "-"
								+ (u1.unitAttackMax + i7);
					} else {
						str = "0-0";
					}
				} else if (it == 1) {
					i7 = u1.getUnitResistance(u2);
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
				i = unit.m_startPosX;
				j = unit.m_startPosY;
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
		this.unkState = 8;
		this.someStartTime5 = this.time;
	}

	public final void sub_ddbb() {
		this.kingsPositions[this.playerId][0] = ((byte) this.someCursorXPos);
		this.kingsPositions[this.playerId][1] = ((byte) this.someCursorYPos);
		this.currentTurn = ((short) (this.currentTurn + 1));
		this.playerId = ((byte) ((this.playerId + 1) % this.mapMaxPlayersMb));
		if (this.mapPlayersTypes[this.playerId] == 2) { // NONE?
			sub_ddbb();
			return;
		}
		for (int i = this.mapUnitsSprites.size() - 1; i >= 0; i--) {
			C_Unit aunit = (C_Unit) this.mapUnitsSprites.elementAt(i);
			if (aunit.m_state == 3) {
				if (aunit.unitTypeId != 9) {
					C_Unit tempUnit = aunit;
					tempUnit.m_tombMaxTurns = (byte) (tempUnit.m_tombMaxTurns - 1);
					if (tempUnit.m_tombMaxTurns <= 0) {
						aunit.removeFromMap();
					}
				}
			} else {
				aunit.m_state = 0;
				if (((aunit.status & 0x1) != 0) && (aunit.someStatusPlayerId == this.playerId)) {
					aunit.applyWispStatusMb((byte) 1);
				}
				if (aunit.playerId == this.playerId) {
					aunit.applyWispStatusMb((byte) 2);
				}
				aunit.m_aiPriority = 0;
			}
		}
		this.playerIncomeMb = 0;
		for (int i = 0; i < this.mapTilesIds.length; i++) {
			for (int j = 0; j < this.mapTilesIds[i].length; j++) {
				if (playerIsOwnerOfTile(i, j, this.playerId)) {
					if (getTileType(i, j) == 8) {
						this.playerIncomeMb += 30;
					} else if (getTileType(i, j) == 9) {
						this.playerIncomeMb += 50;
					}
				}
			}
		}
		this.playersMoney[this.playerId] += this.playerIncomeMb;
		for (int i = 0; i < this.housesDataArr.length; i++) {
			this.var_3acb[i] = 0;
		}
		if (this.mapPlayersTypes[this.playerId] == 1) { // PLAYER?
			moveCursorToPos(this.kingsPositions[this.playerId][0],
					this.kingsPositions[this.playerId][1]);
		}
		this.cursorIsMovingMb = true;
		this.var_397b = true;
		if (this.mapPlayersTypes[this.playerId] == 0) { // CPU
			initCPUPlayerMb();
		} else {
			C_Unit.m_speed = C_Unit.m_defaultSpeed;
		}
		if ((countUnits(-1, 0, this.playerId) <= 0)
				&& (countPlayerOwnerCastles(this.playerId) == 0)) {
			sub_ddbb();
		}
	}

	public final boolean canRepairVillages(int paramInt1, int paramInt2,
			C_Unit unit) {
		return (unit.hasProperty((short) 8))
				&& (getTileType(unit.positionX, unit.positionY) == 8)
				&& (this.mapTilesIds[unit.positionX][unit.positionY] < this.houseTileIdStartIndex);
	}

	public final boolean canOccupyVillageOrTown(int paramInt1, int paramInt2, C_Unit unit) {
		if ((unit.hasProperty((short) 8)) //can occupy villages
				&& (getTileType(unit.positionX, unit.positionY) == 8)
				&& (this.mapTilesIds[unit.positionX][unit.positionY] >= this.houseTileIdStartIndex)
				&& (!isInSameTeam(unit.positionX, unit.positionY, this.playersTeams[unit.playerId]))) {
			return true;
		}
		// 16 - occupy town
		return (unit.hasProperty((short) 16)) 
				&& (getTileType(unit.positionX, unit.positionY) == 9)
				&& (!isInSameTeam(unit.positionX,
						unit.positionY,
						this.playersTeams[unit.playerId]));
	}

	public final void repairDestroyedHouse(byte paramByte, int inX, int inY) {
		this.mapTilesIds[inX][inY] = paramByte;
	}

	public final void occupyHouse(int inX, int inY, int playerId) {
		if (this.mapTilesIds[inX][inY] >= this.houseTileIdStartIndex) {
			byte var = (byte) (this.houseTileIdStartIndex + playerId * 2 + (this.mapTilesIds[inX][inY] - this.houseTileIdStartIndex) % 2);
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

	public final int sub_e276(int playerId) {
		if ((playerId != -1) && (playerId != 0)) {
			return this.somePlayersData[playerId];
		}
		return -1;
	}

	public final boolean isInSameTeam(int inX, int inY, int playerTeamId) {
		int playerId = sub_e276(tileOwnerPlayerIndex(inX, inY));
		if (playerId > -1) {
			return playerTeamId == this.playersTeams[playerId];
		}
		return false;
	}

	public final boolean playerIsOwnerOfTile(int inX, int inY, int playerId) {
		return tileOwnerPlayerIndex(inX, inY) == this.playersIndexes[playerId];
	}

	public final int countPlayerOwnerCastles(int playerId) {
		int i = 0;
		for (int j = 0; j < this.mapCastlesCount; j++) {
			if (playerIsOwnerOfTile(this.var_373b[j][0], this.var_373b[j][1], playerId)) {
				i++;
			}
		}
		return i;
	}

	public final int countUnits(int unitType, int unitState, byte inPlayer) {
		int i = 0;
		int it = 0;
		int length = this.mapUnitsSprites.size();
		while (it < length) {
			C_Unit unit = (C_Unit) this.mapUnitsSprites.elementAt(it);
			if (((unitType == -1) || (unit.unitTypeId == unitType))
					&& (((unitState == -1) && (unit.m_state != 3)) || (unitState == unit.m_state)) && ((inPlayer == -1) || (unit.playerId == inPlayer))) {
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

	public final boolean sub_e943(byte inByte, int inX, int inY) {
		int plUnitsCount = countUnits(-1, -1, this.playerId) - countUnits(10, -1, this.playerId);
		if ((this.mapStartUnitCap > plUnitsCount)
				&& (inByte <= this.var_3703)
				&& (C_Unit.unitsCosts[inByte] <= this.playersMoney[this.playerId])
				&& (C_Unit.unitsCosts[inByte] > 0)) {
			fillArrayWithValue(this.someMapData, 0);
			return C_Unit.sub_1d7b(this.someMapData, inX, inY,
					C_Unit.unitsMoveRanges[inByte], -1, inByte,
					this.playerId, true);
		}
		return false;
	}

	public final boolean sub_e9d0(C_Unit unit, int inX, int inY) {
		int plUnitsCount = countUnits(-1, -1, this.playerId) - countUnits(10, -1, this.playerId);
		if ((this.mapStartUnitCap > plUnitsCount)
				&& ((unit.unitTypeId <= this.var_3703) || (unit.unitTypeId == 9))
				&& (unit.cost <= this.playersMoney[this.playerId])) {
			fillArrayWithValue(this.someMapData, 0);
			return C_Unit.sub_1d7b(this.someMapData, inX, inY,
					C_Unit.unitsMoveRanges[unit.unitTypeId], -1,
					unit.unitTypeId, this.playerId, true);
		}
		return false;
	}

	public final void initCPUPlayerMb() {
		C_Unit[] units = getUnitsOfTypeStatePlayer(-1, 0, this.playerId);
		this.someUnitsVector34 = new Vector(units.length);
		for (int i = 0; i < units.length; i++) {
			int count;
			for (count = 0; count < i; count++) {
				C_Unit unit = (C_Unit) this.someUnitsVector34.elementAt(count);
				int k = someUnitsValuesForAImb[unit.unitTypeId];
				int m = someUnitsValuesForAImb[units[i].unitTypeId];
				if ((m < k) || ((m == k) && (units[i].unitHealthMb < unit.unitHealthMb))) {
					this.someUnitsVector34.insertElementAt(units[i], count);
					break;
				}
			}
			if (count == i) {
				this.someUnitsVector34.addElement(units[i]);
			}
		}
		this.someHouseUnits = new C_Unit[this.housesDataArr.length];
		this.var_3abb = new byte[this.housesDataArr.length];
		C_Unit.m_speed = C_Unit.m_cpuUnitSpeed;
		this.var_3a9b = 0;
		this.var_3a6b = 0;
	}

	public final void sub_ebb9() throws Exception {
		if (A_MenuBase.mainCanvas.invertActionCode(m_actionApply)) {
			showPlayMenu(this.startMenuItems, this.viewportHeight, this.someGHeight, this);
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
				this.aSomeOtherStartTime = this.time;
				if (this.var_3a83 != null) {
					this.cursorSprite.setFrameSequence(cursorFrameSequences[1]);
					moveCursorToPos(this.var_3a83.positionX, this.var_3a83.positionY);
				} else if (this.var_3a8b != null) {
					moveCursorToPos(this.var_3a8b.positionX, this.var_3a8b.positionY);
				}
			} else {
				int houseId;
				if (canOccupyVillageOrTown(this.activeUnit.positionX, this.activeUnit.positionY,
						this.activeUnit)) {
					houseId = getMapHouseId(this.activeUnit.positionX, this.activeUnit.positionY);
					if ((this.var_3b03 != -1) && (this.var_3b03 != houseId)) {
						this.someHouseUnits[this.var_3b03] = this.someHouseUnits[houseId];
						this.someHouseUnits[houseId] = this.activeUnit;
					}
					occupyHouse(this.activeUnit.positionX, this.activeUnit.positionY,
							this.playersIndexes[this.activeUnit.playerId]);
					A_MenuBase.mainCanvas.showMenu(createDialog(null,
							A_MenuBase.getLangString(73), this.someGHeight, 700));//OCCUPIED!
					E_MainCanvas.playMusicLooped(9, 1);
					this.unkState = 9;
					this.someStartTime5 = this.time;
				} else if (canRepairVillages(this.activeUnit.positionX,
						this.activeUnit.positionY, this.activeUnit)) {
					houseId = getMapHouseId(this.activeUnit.positionX, this.activeUnit.positionY);
					if ((this.var_3b03 != -1) && (this.var_3b03 != houseId)) {
						this.someHouseUnits[this.var_3b03] = this.someHouseUnits[houseId];
						this.someHouseUnits[houseId] = this.activeUnit;
					}
					repairDestroyedHouse((byte) this.houseTileIdStartIndex, this.activeUnit.positionX,
							this.activeUnit.positionY);
					A_MenuBase.mainCanvas.showMenu(createDialog(null,
							A_MenuBase.getLangString(74), this.someGHeight, 700)); //REPAIRED!
					E_MainCanvas.playMusicLooped(9, 1);
					this.unkState = 0;
					this.someStartTime5 = this.time;
				} else {
					this.unkState = 0;
				}
				this.activeUnit.endMove();
				this.activeUnit = null;
				this.var_3a6b = 0;
			}
			this.isCursorVisible = true;
			return;
		}
		if (this.var_3a6b == 5) {
			if (this.time - this.aSomeOtherStartTime >= 500L) {
				if (this.var_3a83 != null) {
					sub_55bd(this.activeUnit, this.var_3a83);
				} else if (this.var_3a8b != null) {
					setSomeSparkingUnitMb(this.var_3a8b, this.playerId);
					this.var_3a8b = null;
					this.var_3a6b = 7;
					this.activeUnit.endMove();
				}
				this.var_351b = false;
				this.var_3523 = false;
			}
		} else if (this.var_3a6b == 7) {
			if (this.someSparkingUnit == null) {
				this.var_3a6b = 0;
				this.unkState = 0;
			}
		} else if (this.var_3a6b == 6) {
			if (this.time - this.aSomeOtherStartTime >= 1000L) {
				this.var_3a83 = null;
				this.var_3a6b = 0;
				this.unkState = 0;
			}
		} else {
			if (this.var_3a6b == 2) {
				return;
			}
			C_Unit aiUnit;
			if (this.var_3a6b == 3) {
				if (this.var_3a9b == 0) {
					if (sub_b7ff(this.activeUnit.posXPixel + 12,
							this.activeUnit.posYPixel + 12)) {
						if ((this.mapModeCampIf0 == 0) && (this.scenarioMapIndex == 7)
								&& (this.activeUnit == this.playersKings[1])) {
							this.m_tempUnit = null;
							C_Unit[] localObject1 = getUnitsOfTypeStatePlayer(-1, -1,
									(byte) 0);
							if (localObject1.length > 0) {
								targetUnit(localObject1[E_MainCanvas
										.getRandomMax(localObject1.length)]);
							}
							this.var_3a6b = 4;
							return;
						}
						this.var_3a9b = 1;
						this.aSomeOtherStartTime = this.time;
					}
				} else if (this.var_3a9b == 1) {
					if (this.time - this.aSomeOtherStartTime >= 100L) {
						this.var_351b = true;
						this.var_3523 = false;
						this.var_3a9b = 2;
						this.unkState = 1;
						this.aSomeOtherStartTime = this.time;
					}
				} else if (this.var_3a9b == 2) {
					if (this.time - this.aSomeOtherStartTime >= 200L) {
						this.someCursorXPos = this.var_3a73;
						this.someCursorYPos = this.someTileType;
						this.cursorSprite.setSpritePosition(this.var_3a73 * 24,
								this.someTileType * 24);
						this.var_353b = this.activeUnit.sub_1b48(
								this.activeUnit.positionX, this.activeUnit.positionY,
								this.someCursorXPos, this.someCursorYPos);
						this.var_3a9b = 3;
						this.aSomeOtherStartTime = this.time;
					}
				} else if ((this.var_3a9b == 3)
						&& (this.time - this.aSomeOtherStartTime >= 200L)) {
					this.var_353b = null;
					this.activeUnit.goToPosition(this.var_3a73, this.someTileType, true);
					this.var_3a6b = 2;
					this.var_3a9b = 0;
					this.unkState = 2;
				}
				return;
			}
			if (this.someUnitsVector34.size() == 0) {
				aiUnit = null;
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
							&& (playerIsOwnerOfTile(i2, i3, this.playerId))) {
						if (j == 0) {
							m = i2;
							n = i3;
						}
						j++;
						int i5 = 0;
						int dist1;
						for (int i61 = this.mapUnitsSprites.size() - 1; i61 >= 0; i61--) {
							C_Unit unit32 = (C_Unit) this.mapUnitsSprites
									.elementAt(i61);
							if ((this.playersTeams[unit32.playerId] != this.playersTeams[this.playerId])
									&& (unit32.hasProperty((short) 16))) {
								dist1 = Math.abs(unit32.positionX
										- i2)
										+ Math.abs(unit32.positionY
												- i3);
								if (dist1 < k) {
									k = dist1;
									m = i2;
									n = i3;
								}
								i5++;
							}
						}
						if (i5 == 0) {
							for (i6 = 0; i6 < this.housesDataArr.length; i6++) {
								int i8 = this.housesDataArr[i6][0];
								dist1 = this.housesDataArr[i6][1];
								int dist2;
								if ((getTileType(i8, dist1) == 9)
										&& (!playerIsOwnerOfTile(i8, dist1, this.playerId))
										&& ((dist2 = Math.abs(i8 - i2)
												+ Math.abs(dist1 - i3)) < k)) {
									k = dist2;
									m = i2;
									n = i3;
								}
							}
						}
					}
				}
				if (j > 0) {

					for (int i1 = 0; i1 < this.playerUnitsCount[this.playerId]; i1++) {
						if ((this.playerKingsMb[this.playerId][i1] != null)
								&& (this.playerKingsMb[this.playerId][i1].m_state == 3)
								&& (sub_e9d0(this.playerKingsMb[this.playerId][i1], m, n))) {
							aiUnit = buyUnit(this.playerKingsMb[this.playerId][i1], m, n);
						}
					}
					if (aiUnit == null) {
						if ((countUnits(0, -1, this.playerId) < 2) && (sub_e943((byte) 0, m, n))) {
							//buy soldiers
							aiUnit = aiBuyUnit((byte) 0, m, n);
						} else if ((countUnits(1, -1, this.playerId) < 2) && (sub_e943((byte) 1, m, n))) {
							//buy archers
							aiUnit = aiBuyUnit((byte) 1, m, n);
						} else {
							int i1 = 0;
							i2 = 0;
							for (int pIt = 0; pIt < this.mapMaxPlayersMb; pIt = (byte) (pIt + 1)) {
								if (this.playersTeams[pIt] == this.playersTeams[this.playerId]) {
									i1 += countUnits(-1, -1, (byte) pIt);
								} else {
									i2 += countUnits(-1, -1, (byte) pIt);
								}
							}
							if ((this.playersMoney[this.playerId] >= 1000)
									|| (countUnits(-1, -1, this.playerId) < 8)
									|| (i1 < i2)) {
								int buyUnitsCount = 0;
								byte[] unitsToBuy = new byte[12];			
								//@todo why 1?
								for (byte u1 = 1; u1 < 12; u1 = (byte) (u1 + 1)) {
									if (((countUnits(u1, -1, this.playerId) < 1) || (C_Unit.unitsCosts[u1] >= 600))
											&& (sub_e943(u1, m, n))) {
										unitsToBuy[buyUnitsCount] = u1;
										buyUnitsCount++;
									}
								}
								if (buyUnitsCount > 0) {
									int uBuyType = unitsToBuy[(Math.abs(E_MainCanvas.getRandom()) % buyUnitsCount)];
									aiUnit = aiBuyUnit((byte) uBuyType, m, n);
								}
							}
						}
					}
				}
				if (aiUnit != null) {
					someAIPriorityCals((C_Unit) aiUnit);
					return;
				}
				this.someUnits5 = null;
				this.someUnitsVector34 = null;
				sub_dd85();
				return;
			}
			if ((this.mapModeCampIf0 == 0) && (this.scenarioMapIndex == 7)
					&& (this.playersKings[1].m_state != 2)) {
				this.activeUnit = this.playersKings[1];
				moveCursorToPos(this.activeUnit.positionX, this.activeUnit.positionY);
				this.m_tempUnit = this.activeUnit;
				this.var_3a6b = 3;
				this.someUnitsVector34.removeElement(this.activeUnit);
				return;
			}
			aiUnit = this.var_3a93;
			if (aiUnit == null) {
				aiUnit = (C_Unit) this.someUnitsVector34.elementAt(0);
			}
			someAIPriorityCals(aiUnit);
			if (this.var_3a93 == null) {
				this.someUnitsVector34.removeElement(aiUnit);
			}
		}
	}

	public final void someAIPriorityCals(C_Unit pxUnit) {
		this.activeUnit = pxUnit;
		this.isCursorVisible = true;
		fillArrayWithValue(this.someMapData, 0);
		this.activeUnit.fillWhereUnitCanMove(this.someMapData);
		this.var_351b = false;
		this.someUnits5 = getUnitsOfTypeStatePlayer(0, -1, this.playerId);
		int i = 0;
		int j = this.playersKings.length + this.someUnits5.length
				+ this.housesDataArr.length;
		this.someAIPosAValArr = new int[j][5];
		this.var_3ad3 = 0;
		int m = 10000;
		this.someXPos = -1;
		this.someYPos = -1;
		this.var_3afb = -1;
		this.var_3b03 = -1;
		for (int n = 0; n < this.someUnits5.length + this.playersKings.length; n++) {
			C_Unit someKingUnit = null;
			if (n >= this.someUnits5.length) {
				someKingUnit = this.playersKings[(n - this.someUnits5.length)];
				if (someKingUnit != null) {
					if (someKingUnit.m_state == 3) {
						someKingUnit = null;
					} else if ((this.playersTeams[someKingUnit.playerId] != this.playersTeams[this.playerId])
							&& (this.playersKings[this.playerId] == null)) {
						this.someAIPosAValArr[i][2] += someKingUnit.getSomePropSum(
								someKingUnit.positionX,
								someKingUnit.positionY, null) * 2;
					} else if ((this.currentTurn >= 15)
							&& (this.playersTeams[someKingUnit.playerId] != this.playersTeams[this.playerId])
							&& (countUnits(-1, -1, someKingUnit.playerId) < 4)
							&& (countUnits(-1, -1, this.playerId) >= 8)) {
						this.someAIPosAValArr[i][2] += someKingUnit.getSomePropSum(
								someKingUnit.positionX,
								someKingUnit.positionY, null) * 2;
					} else if (someKingUnit.playerId != this.playerId) {
						someKingUnit = null;
					}
				}
			} else if (this.playersKings[this.playerId] != null) {
				someKingUnit = this.someUnits5[n];
			}
			if (someKingUnit != null) {
				this.someAIPosAValArr[i][0] = someKingUnit.positionX;
				this.someAIPosAValArr[i][1] = someKingUnit.positionY;
				if (someKingUnit.playerId == this.playerId) {
					C_Unit[] sUnit = someKingUnit
							.getPositionUnitsInAttackRange(someKingUnit.positionX,
									someKingUnit.positionY, 1, 5, (byte) 0);
					for (int i3 = 0; i3 < sUnit.length; i3++) {
						if (sUnit[i3].m_state != 4) {
							this.someAIPosAValArr[i][2] += sUnit[i3]
									.getSomePropSum(sUnit[i3].positionX,
											sUnit[i3].positionY,
											someKingUnit);
						}
					}
				}
				if (this.someAIPosAValArr[i][2] > 0) {
					this.someAIPosAValArr[i][4] += someKingUnit.getSomePropSum(
							someKingUnit.positionX,
							someKingUnit.positionY, null);
					this.someAIPosAValArr[i][4] += someKingUnit.m_aiPriority;
					if (this.someAIPosAValArr[i][2] > this.var_3ad3) {
						this.var_3ad3 = this.someAIPosAValArr[i][2];
					}
					this.someAIPosAValArr[i][3] = (Math.abs(someKingUnit.positionX
							- pxUnit.positionX) + Math
							.abs(someKingUnit.positionY
									- pxUnit.positionY));
					if (this.someAIPosAValArr[i][3] < 1) {
						this.someAIPosAValArr[i][3] = 1;
					}
					if (this.someAIPosAValArr[i][3] < m) {
						m = this.someAIPosAValArr[i][3];
					}
				} else {
					this.someAIPosAValArr[i][2] = -6666;
				}
			} else {
				this.someAIPosAValArr[i][2] = -6666;
			}
			i++;
		}
		int n = 666;
		int i1 = 666;
		int i2 = -1;
		int i3 = -1;
		int tileType;
		int pX;
		byte pY;
		for (int i4 = 0; i4 < this.housesDataArr.length; i4++) {
			pX = this.housesDataArr[i4][0];
			pY = this.housesDataArr[i4][1];
			tileType = getTileType(pX, pY);
			boolean isOwner = playerIsOwnerOfTile(pX, pY, pxUnit.playerId);
			this.someAIPosAValArr[i][2] = -6666;
			C_Unit[] someUnitsInRange;
			int i10;
			if ((isOwner) || (this.someHouseUnits[i4] != null)) {
				someUnitsInRange = pxUnit.getPositionUnitsInAttackRange(pX, pY, 1, 5, (byte) 0);
				this.someAIPosAValArr[i][0] = pX;
				this.someAIPosAValArr[i][1] = pY;
				this.someAIPosAValArr[i][2] = 0;
				for (int itx = 0; itx < someUnitsInRange.length; itx++) {
					if (someUnitsInRange[itx].m_state != 4) {
						if ((this.someHouseUnits[i4] != null) && (!isOwner)) {
							this.someAIPosAValArr[i][2] += someUnitsInRange[itx].getSomePropSum(
									someUnitsInRange[itx].positionX,
									someUnitsInRange[itx].positionY, null);
						} else if (((tileType == 8) && (someUnitsInRange[itx].hasProperty((short) 8)))
								|| ((tileType == 9) && (someUnitsInRange[itx].hasProperty((short) 16)))) {
							 //vilage or castles
							this.someAIPosAValArr[i][2] += someUnitsInRange[itx].getSomePropSum(
									someUnitsInRange[itx].positionX,
									someUnitsInRange[itx].positionY, null);
						}
					}
				}
				if (this.someAIPosAValArr[i][2] == 0) {
					if ((this.someHouseUnits[i4] != null) && (!isOwner)) {
						this.someAIPosAValArr[i][2] = 100;
						this.someAIPosAValArr[i][4] += 2000;
					} else {
						this.someAIPosAValArr[i][2] = -6666;
					}
				}
				if (this.someAIPosAValArr[i][2] != -6666) {
					this.someAIPosAValArr[i][4] += this.var_3acb[i4];
					if (this.someAIPosAValArr[i][2] > this.var_3ad3) {
						this.var_3ad3 = this.someAIPosAValArr[i][2];
					}
					this.someAIPosAValArr[i][3] = (Math.abs(pX
							- pxUnit.positionX) + Math.abs(pY
							- pxUnit.positionY));
					if (this.someAIPosAValArr[i][3] < 1) {
						this.someAIPosAValArr[i][3] = 1;
					}
					if (this.someAIPosAValArr[i][3] < m) {
						m = this.someAIPosAValArr[i][3];
					}
				}
			}
			if (isInSameTeam(pX, pY, this.playersTeams[pxUnit.playerId])) {
				C_Unit unit11 = getSomeUnit(pX, pY, (byte) 0);
				if (((unit11 == null) || (unit11.playerId == pxUnit.playerId))
						&& ((i10 = Math.abs(pX - pxUnit.positionX)
								+ Math.abs(pY - pxUnit.positionY)) < i1)) {
					i3 = i4;
					i1 = i10;
				}
			} else if (((this.someHouseUnits[i4] == null) || (this.someHouseUnits[i4] == pxUnit))
					&& (((tileType == 8) && (pxUnit.hasProperty((short) 8))) || 
						((tileType == 9) && (pxUnit.hasProperty((short) 16))))) {
				//village or castle
				int distance1 = Math.abs(pX - pxUnit.positionX) + Math.abs(pY - pxUnit.positionY);
				if (distance1 < n) {
					i2 = i4;
					n = distance1;
				}
				C_Unit unit24 = getSomeUnit(pX, pY, (byte) 0);
				if ((distance1 < i1)
						&& (this.someMapData[pX][pY] > 0)
						&& ((unit24 == null) || (unit24.playerId == pxUnit.playerId))) {
					i3 = i4;
					i1 = distance1;
				}
			}
			i++;
		}
		int i4;
		if ((pxUnit.unitHealthMb < 50) && (i3 != -1)) {
			if (i3 == i2) {
				this.var_3b03 = i2;
			}
			this.someHouseUnits[i3] = pxUnit;
			this.someXPos = this.housesDataArr[i3][0];
			this.someYPos = this.housesDataArr[i3][1];
			fillArrayWithValue(this.someMData, 0);
			C_Unit.sub_1d7b(this.someMData, this.someXPos, this.someYPos,
					10, -1, pxUnit.unitTypeId, this.playerId, false);
		} else if ((this.playersKings[this.playerId] != null)
				&& (i2 != -1)
				&& ((pxUnit.hasProperty((short) 8)) || (pxUnit.hasProperty((short) 16)))) { //occupy
			this.var_3b03 = i2;
			this.someHouseUnits[i2] = pxUnit;
			this.someXPos = this.housesDataArr[i2][0];
			this.someYPos = this.housesDataArr[i2][1];
			fillArrayWithValue(this.someMData, 0);
			C_Unit.sub_1d7b(this.someMData, this.someXPos, this.someYPos,
					10, -1, pxUnit.unitTypeId, this.playerId, false);
		} else {
			i4 = -1;
			pX = -6666;
			for (pY = 0; pY < i; pY++) {
				if (this.someAIPosAValArr[pY][2] > -6666) {
					if (this.someAIPosAValArr[pY][2] > 0) {
						this.someAIPosAValArr[pY][2] = (this.someAIPosAValArr[pY][2] * m / this.someAIPosAValArr[pY][3]);
					}
					this.someAIPosAValArr[pY][2] -= this.someAIPosAValArr[pY][4];
					if (this.someAIPosAValArr[pY][2] > pX) {
						pX = this.someAIPosAValArr[pY][2];
						i4 = pY;
					}
				}
			}
			if (i4 != -1) {
				int someSumVal = pxUnit.getSomePropSum(pxUnit.positionX, pxUnit.positionY, null);
				if (i4 < this.someUnits5.length) {
					this.someUnits5[i4].m_aiPriority += someSumVal;
				} else if (i4 < this.playersKings.length + this.someUnits5.length) {
					this.playersKings[(i4 - this.someUnits5.length)].m_aiPriority += someSumVal;
				} else {
					this.var_3afb = (i4 - this.playersKings.length - this.someUnits5.length);
					this.var_3acb[this.var_3afb] += someSumVal;
				}
				this.someXPos = this.someAIPosAValArr[i4][0];
				this.someYPos = this.someAIPosAValArr[i4][1];
				fillArrayWithValue(this.someMData, 0);
				C_Unit.sub_1d7b(this.someMData, this.someXPos,
						this.someYPos, 10, -1, pxUnit.unitTypeId,
						this.playerId, false);
			}
		}
		i4 = -10000;
		int it2 = 0;
		int length2 = this.someMapData.length;
		while (it2 < length2) {
			tileType = 0;
			int length3 = this.someMapData[it2].length;
			while (tileType < length3) {
				C_Unit lcUnit;
				if ((this.someMapData[it2][tileType] > 0)
						&& (((lcUnit = getSomeUnit(it2, tileType, (byte) 0)) == null)
								|| (lcUnit == pxUnit) || ((this.var_3a93 == null)
								&& (lcUnit.playerId == pxUnit.playerId) && (lcUnit.m_state == 0)))) {
					int cellPrior;
					if ((!pxUnit.hasProperty((short) 512))
							|| (lcUnit == pxUnit)) { //not catapult
						C_Unit[] arUnit = pxUnit
								.getActiveUnitsInAttackRange(it2, tileType, (byte) 0);
						for (int it13 = 0; it13 < arUnit.length; it13++) {
							cellPrior = getUnitCellPriority(pxUnit, it2, tileType, arUnit[it13], null);
							if (cellPrior > i4) {
								this.var_3a8b = null;
								this.var_3a83 = arUnit[it13];
								i4 = cellPrior;
								this.var_3a73 = it2;
								this.someTileType = tileType;
							}
						}
					}
					if (pxUnit.hasProperty((short) 32)) { //raise
						this.var_34f3 = pxUnit.getActiveUnitsInAttackRange(it2, tileType, (byte) 1);
						for (int i12 = 0; i12 < this.var_34f3.length; i12++) {
							cellPrior = getUnitCellPriority(pxUnit, it2, tileType,
									null, this.var_34f3[i12]);
							if (cellPrior > i4) {
								this.var_3a83 = null;
								this.var_3a8b = this.var_34f3[i12];
								i4 = cellPrior;
								this.var_3a73 = it2;
								this.someTileType = tileType;
							}
						}
					}
					cellPrior = getUnitCellPriority(pxUnit, it2, tileType, null, null);
					if (cellPrior > i4) {
						this.var_3a83 = null;
						this.var_3a8b = null;
						i4 = cellPrior;
						this.var_3a73 = it2;
						this.someTileType = tileType;
					}
				}
				tileType++;
			}
			it2++;
		}
		if (this.var_3b03 != -1) {
			this.var_3abb[this.var_3b03] = ((byte) (10 - this.someMData[this.var_3a73][this.someTileType]));
		}
		this.var_3a93 = null;
		C_Unit unit22 = getSomeUnit(this.var_3a73, this.someTileType, (byte) 0);
		if ((unit22 != null) && (unit22 != pxUnit)) {
			this.var_3a93 = unit22;
			this.var_3a6b = 0;
			return;
		}
		moveCursorToPos(pxUnit.positionX, pxUnit.positionY);
		this.m_tempUnit = pxUnit;
		this.var_3a6b = 3;
	}

	public final int getUnitCellPriority(C_Unit cUnit21, int inX, int inY, C_Unit cUnit1, C_Unit inUnit) {
		int priority = 0;
		if ((this.var_3b03 != -1) && (this.playersKings[cUnit21.playerId] != null)) {
			if (this.someXPos != -1) {
				if (this.someMData[inX][inY] > 0) {
					priority = 0 + (100 + 100 * this.someMData[inX][inY] / 10);
				} else {
					int j = Math.abs(this.someXPos - cUnit21.positionX)
							+ Math.abs(this.someYPos
									- cUnit21.positionY);
					int m = Math.abs(this.someXPos - inX)
							+ Math.abs(this.someYPos - inY);
					priority = 0
							+ 100
							* (j - m)
							/ (C_Unit.unitsMoveRanges[cUnit21.unitTypeId] - 1);
					if (tilesMovements[getTileType(inX, inY)] <= 1) {
						priority += 20;
					}
				}
			}
			if ((cUnit1 == null)
					&& (!isInSameTeam(inX, inY,
							this.playersTeams[cUnit21.playerId]))) {
				if ((cUnit21.hasProperty((short) 16))
						&& (getTileType(inX, inY) == 9)) {
					priority += 300;
				} else if ((cUnit21.hasProperty((short) 8))
						&& ((getTileType(inX, inY) == 8) || (this.mapTilesIds[inX][inY] == 27))) {
					priority += 200;
				}
			}
		}
		switch (cUnit21.unitTypeId) {
			case 3: //magi
				if (inUnit != null) {
					priority += 100;
				}
				break;
			case 4: //wisp
				C_Unit[] someUnits2 = cUnit21.getPositionUnitsInAttackRange(inX, inY, 1, 2, (byte) 2);
				if (inUnit != null) {
					priority += 25 * someUnits2.length;
				}
				break;
			case 2: //elemental
				if (getTileType(inX, inY) == 5) { //water
					priority += 25;
				}
				break;
		}
		if (cUnit1 != null) {
			if (cUnit1.m_state == 4) {
				int oPlayerId = tileOwnerPlayerIndex(cUnit1.positionX, cUnit1.positionY);
				int house1Id = getMapHouseId(cUnit1.positionX, cUnit1.positionY);
				if ((oPlayerId != 0) && (house1Id != -1) && (this.someHouseUnits[house1Id] == null)) {
					priority += cUnit21.getSomePropSum(inX, inY, cUnit1) / 2;
				}
			} else {
				if (!cUnit1.isNearOtherUnit(cUnit21, inX, inY)) {
					priority += cUnit21.getSomePropSum(inX, inY, cUnit1) * 2;
				} else {
					priority += cUnit21.getSomePropSum(inX, inY, cUnit1)
							* 3 / 2
							- cUnit1.getSomePropSum(inX, inY, cUnit21);
				}
				if (cUnit1.unitTypeId == 9) { //king
					priority += 25;
				} else if (cUnit1.unitTypeId == 11) { // crystal
					priority += 100;
				}
			}
		}
		priority += tilesDefences[getTileType(inX, inY)];
		if ((cUnit21.unitHealthMb < 100)
				&& (isInSameTeam(inX, inY, this.playersTeams[cUnit21.playerId]))) {
			priority += 100 - cUnit21.unitHealthMb;
		}
		int house2Id = getMapHouseId(inX, inY);
		if (this.someMData[inX][inY] > 0) {
			int m = this.someMData[inX][inY];
			int n = 10 - C_Unit.unitsMoveRanges[cUnit21.unitTypeId] / 2;
			if (m > n) {
				m = n;
			}
			priority += 50 + 100 * m / n;
		} else if (this.someXPos != -1) {
			int m = Math.abs(this.someXPos - cUnit21.positionX)
					+ Math.abs(this.someYPos - cUnit21.positionY);
			int n = Math.abs(this.someXPos - inX)
					+ Math.abs(this.someYPos - inY);
			priority += 50 * (m - n)
					/ (C_Unit.unitsMoveRanges[cUnit21.unitTypeId] - 1);
		}
		C_Unit ssUnit8;
		if ((house2Id != -1)
				&& ((ssUnit8 = this.someHouseUnits[house2Id]) != null)
				&& (ssUnit8 != cUnit21)
				&& (ssUnit8.m_state == 0)
				&& (this.var_3abb[house2Id] < C_Unit.unitsMoveRanges[ssUnit8.unitTypeId])) {
			priority -= 200;
		}
		return priority += 20
				* (Math.abs(inX - cUnit21.positionX) + Math
						.abs(inY - cUnit21.positionY))
				/ (C_Unit.unitsMoveRanges[cUnit21.unitTypeId] - 1);
	}

	public final int getMapHouseId(int inX, int inY) {
		for (int i = 0; i < this.housesDataArr.length; i++) {
			if ((this.housesDataArr[i][0] == inX)
					&& (this.housesDataArr[i][1] == inY)) {
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
		dialog.initPortraitDialog(msg, this.someCanWidth, i, paramByte1, paramByte2);
		dialog.setMenuLoc(0, this.someCanHeight - i, 0);
		A_MenuBase.mainCanvas.showMenu(dialog);
		return dialog;
	}

	public final D_Menu createDialog(String header,
			String msg, int paramInt1, int showTime) {
		return createDialog(header, msg, paramInt1, -1, showTime);
	}

	public final D_Menu createDialog(String header,
			String msg, int paramInt1, int paramInt2, int showTime) {
		D_Menu dialog = new D_Menu((byte) 10, 12);
		dialog.createDescDialogMb(header, msg, this.someCanWidth, paramInt2);
		dialog.setMenuLoc(this.someCanWidthDiv2, paramInt1 / 2, 3);
		dialog.parentMenu = this;
		dialog.var_10c5 = showTime;
		return dialog;
	}

	public final void initScenarioMap() throws Exception {
		this.crystal3Unit = null;
		if (this.mapModeCampIf0 == 0) {
			this.var_378b = someUnkHeight1;
			this.var_3793 = true;
			this.isUpdatingMb = false;
			this.mapNameDialog = createDialog(null, this.mapName, this.someCanHeight, 2000);
			this.mapNameDialog.setMenuLoc(this.someCanWidthDiv2, this.someCanHeightDiv2, 3);
			this.isFading = true;
			this.var_380b = true;
			this.fadeInColor = 0;
		}
		if (this.scenarioMapIndex == 0) {
			this.var_3703 = 0;
			this.playersMoney[0] = 0;
			this.playersMoney[1] = 0;
			C_Unit.m_speed = 4;
			this.someCameraVelocityMb = 2;
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
			this.playersMoney[0] = 300;
			this.playersMoney[1] = 50;
			C_Unit.m_speed = 4;
			this.someCameraVelocityMb = 2;
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
			this.playersMoney[0] = 0;
			this.playersMoney[1] = 0;
			C_Unit.m_speed = 4;
			this.playersMoney[0] = 0;
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
			C_Unit.m_speed = 4;
			this.playersMoney[0] = 400;
			this.playersMoney[1] = 400;
			this.skeleton1Map2 = C_Unit.createUnitOnMap((byte) 0, (byte) 0, -1, 5);
			this.crystalOfWisdom = C_Unit.createUnitOnMap((byte) 2, (byte) 0, -2, 5);
			this.skeleton2Map2 = C_Unit.createUnitOnMap((byte) 3, (byte) 0, -3, 5);
			this.skeleton1Map2.goToPosition(3, 4, false);
			this.crystalOfWisdom.goToPosition(4, 4, false);
			this.skeleton2Map2.goToPosition(2, 4, false);
			this.playersKings[0].goToPosition(3, 3, false);
			sub_b9c5(this.playersKings[0].positionX, this.playersKings[0].positionY);
			moveCursorToPos(3, 3);
			this.m_tempUnit = this.playersKings[0];
			loadIntro(3, 3, 3);
			E_MainCanvas.playMusicLooped2(1, 1);
			this.isFading = false;
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		C_Unit cUnit;
		if (this.scenarioMapIndex == 4) {
			this.var_3703 = 0;
			this.playersMoney[0] = 0;
			this.playersMoney[1] = 0;
			sub_b998(this.playersKings[0].posXPixel + 12,
					this.playersKings[0].posYPixel + 12);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			C_Unit.m_speed = 4;
			(cUnit = getSomeUnit(11, 2, (byte) 0)).setUnitPosition(11, -3);
			cUnit.goToPosition(11, 2, false);
			(cUnit = getSomeUnit(10, 1, (byte) 0)).setUnitPosition(10, -5);
			cUnit.goToPosition(10, 1, false);
			(cUnit = getSomeUnit(11, 1, (byte) 0)).setUnitPosition(11, -5);
			cUnit.goToPosition(11, 1, false);
			(cUnit = getSomeUnit(12, 1, (byte) 0)).setUnitPosition(12, -5);
			cUnit.goToPosition(12, 1, false);
			(cUnit = getSomeUnit(11, 0, (byte) 0)).setUnitPosition(11, -7);
			cUnit.goToPosition(11, 0, false);
			(cUnit = getSomeUnit(12, 0, (byte) 0)).setUnitPosition(12, -7);
			cUnit.goToPosition(12, 0, false);
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		if (this.scenarioMapIndex == 5) {
			this.var_3703 = 7;
			this.playersMoney[0] = 600;
			this.playersMoney[1] = 600;
			this.playersKings[0].setKingName(2);
			sub_b9c5(5, 0);
			moveCursorToPos(5, 0);
			this.someCameraVelocityMb = 4;
			moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		C_Unit cUnit2;
		C_Unit cUnit3;
		if (this.scenarioMapIndex == 6) {
			this.var_3703 = 8;
			C_Unit.m_speed = 4;
			this.playersMoney[0] = 400;
			this.playersMoney[1] = 600;
			cUnit = C_Unit.createUnitOnMap((byte) 0, (byte) 0, 13, -1);
			cUnit2 = C_Unit.createUnitOnMap((byte) 1, (byte) 0, 13, -1);
			cUnit3 = C_Unit.createUnitOnMap((byte) 3, (byte) 0, 13, -1);
			C_Unit localClass_c_0324 = C_Unit.createUnitOnMap((byte) 11,
					(byte) 0, 13, -1);
			this.playersKings[0].followerUnitMb = cUnit;
			cUnit.followerUnitMb = cUnit2;
			cUnit2.followerUnitMb = cUnit3;
			cUnit3.followerUnitMb = localClass_c_0324;
			this.playersKings[0].fillWhereUnitCanMove(this.someMapData);
			this.playersKings[0].goToPosition(14, 3, true);
			sub_b9c5(this.playersKings[0].positionX, this.playersKings[0].positionY);
			moveCursorToPos(this.playersKings[0].positionX, this.playersKings[0].positionY);
			this.m_tempUnit = this.playersKings[0];
			A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
			this.isCursorVisible = false;
			this.scriptStep = 0;
			return;
		}
		if (this.scenarioMapIndex == 7) {
			this.var_3703 = 8;
			C_Unit.m_speed = 4;
			this.playersMoney[0] = 800;
			this.playersMoney[1] = 200;
			(cUnit = getSomeUnit(7, 4, (byte) 0)).setKingName(3);
			this.playersKings[1] = cUnit;
			cUnit2 = getSomeUnit(8, 15, (byte) 0);
			this.playersKings[0] = cUnit2;
			cUnit2.setKingName(0);
			(cUnit3 = getSomeUnit(6, 15, (byte) 0)).setKingName(2);
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
				this.unkState = 11;
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
				E_MainCanvas.playMusicLooped2(playersMusicIdsMb[this.playersIndexes[this.playerId]], 0);
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
					if ((this.mapPlayersTypes[i1] != 2)
							&& (((this.playersKings[i1] != null) && (this.playersKings[i1].m_state != 3)) || (countPlayerOwnerCastles(i1) != 0))) {
						j = i1;
						if ((i != -1) && (i != this.playersTeams[i1])) {
							n = 0;
							break;
						}
						i = this.playersTeams[i1];
					}
				}
				if (n != 0) {
					this.isUpdatingMb = false;
					this.isCursorVisible = false;
					str2 = A_MenuBase.replaceStringFirst(38, "" + (this.playersTeams[j] + 1)); //Team %U
					str3 = A_MenuBase.replaceStringFirst(81, str2) + "\n("; //%U WINS!
					for (int pIndex = 0; pIndex < this.mapMaxPlayersMb; pIndex++) {
						if ((this.mapPlayersTypes[pIndex] != 2) && (this.playersTeams[pIndex] == this.playersTeams[j])) {
							str3 = str3 + " " + A_MenuBase.getLangString(88 + this.playersIndexes[pIndex]) + " "; // player color
						}
					}
					str3 = str3 + ")";
					D_Menu teamWinsDialog = createDialog(null, str3, this.someGHeight, this.viewportHeight, -1);
					teamWinsDialog.setParentMenu(this);
					A_MenuBase.mainCanvas.showMenu(teamWinsDialog);
					if (this.mapPlayersTypes[j] == 1) {
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
				this.unkState = 11;
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
		if (this.unkState != 11) {
			i = 1;
			for (j = 0; j < this.playerUnitsCount[0]; j++) {
				if (this.playerKingsMb[0][j].m_state != 3) {
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
		} else if (this.scenarioMapIndex == 4){
			updateScenarioScript5();
		} else if (this.scenarioMapIndex == 5) {
			updateScenarioScript6();
		} else if(this.scenarioMapIndex == 6) {
			updateScenarioScript7();
	    } else if (this.scenarioMapIndex == 7) {
			updateScenarioScript8();	
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
				this.someCameraVelocityMb = 12;
				C_Unit.m_speed = C_Unit.m_defaultSpeed;
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
				//activeUnitState == 1 chosen
				if ((this.playerId == 0) && (this.unkState == 1) && (this.alphaWindowWTF == 0)) { 
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
				if (countUnits(-1, 2, (byte) 0) >= 3) { // 2 - has no turn, noboby has turn
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
				if ((this.unkState == 1) && (this.playerId == 0)) {
					this.helpTipId = 7;
					this.scriptStep += 1;
				}
				break;
			case 22:
				if (countUnits(-1, -1, (byte) 1) == 0) { // no enemy troops
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
				if ((countUnits(-1, -1, (byte) 1) == 0) && (this.unkState == 0)) {
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
				this.someCameraVelocityMb = 4; //??
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
				C_Unit.m_speed = 2;
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
					C_Unit.m_speed = 4;
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
				C_Unit.m_speed = C_Unit.m_defaultSpeed;
				this.skeleton1Map2.removeFromMap();
				this.crystalOfWisdom.removeFromMap();
				this.skeleton1Map2 = null;
				this.crystalOfWisdom = null;
				this.skeleton2Map2 = null;
				this.someCameraVelocityMb = 12;
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
				if ((this.unkState == 9) && (this.playerId == 0)) {
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
				if ((countUnits(-1, -1, (byte) 1) == 0) && (countPlayerOwnerCastles(1) == 0)) { 
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
			C_Unit.m_speed = C_Unit.m_defaultSpeed;
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
					&& (countUnits(-1, 3, (byte) -1) >= 1)) { //there are dead units
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
					break;
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
			C_Unit el1Unit = C_Unit.createUnitOnMap((byte) 2, (byte) 1, 3, 8); // elemental
			C_Unit el2Unit = C_Unit.createUnitOnMap((byte) 2, (byte) 1, 4, 7); // elemental
			C_Unit el3Unit = C_Unit.createUnitOnMap((byte) 2, (byte) 1, 5, 8); // elemental
			showSpriteOnMap(this.sparkSprite, el1Unit.posXPixel, el1Unit.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite, el2Unit.posXPixel, el2Unit.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite, el3Unit.posXPixel, el3Unit.posYPixel, 0, 0, 1, 50);
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
			C_Unit el1 = C_Unit.createUnitOnMap((byte) 2, (byte) 0, 3, 8); 
			C_Unit el2 = C_Unit.createUnitOnMap((byte) 2, (byte) 0, 4, 7);
			C_Unit el3 = C_Unit.createUnitOnMap((byte) 2, (byte) 0, 5, 8);
			showSpriteOnMap(this.sparkSprite, el1.posXPixel, el1.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite, el2.posXPixel, el2.posYPixel, 0, 0, 1, 50);
			showSpriteOnMap(this.sparkSprite, el3.posXPixel, el3.posYPixel, 0, 0, 1, 50);
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
			if (countUnits(-1, -1, (byte) 1) == 0) { // no enemies
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
				this.m_tempUnit = null;
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
			this.someCameraVelocityMb = 2;//??
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 6:
			this.isFadingIn = false;
			this.var_380b = true;//??
			this.fadeInColor = 0;
			waitScript(5);
			this.scriptStep += 1;
			break;
		case 7:
			moveCameraTo(13, 10);
			break;
		case 8:
			C_Unit.m_speed = 2;
			this.someCameraVelocityMb = 4;
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
			this.var_35db = C_Unit.createUnit((byte) 0, (byte) 0, 4, 9,
					false);
			this.var_35db.unitTypeId = -1;
			this.var_35db.m_state = 4;
			this.var_3603 = 6;
			waitScript(20);
			this.scriptStep += 1;
			break;
		case 12:
			//They are destroying our buildings to cripple...
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
			if ((countUnits(-1, -1, (byte) 1) == 0) && (countPlayerOwnerCastles(1) == 0)) {
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
	
	public final void updateScenarioScript5(){
		
			if (this.crystal3Unit == null) {
				this.crystal3Unit = getUnitsOfTypeStatePlayer(11, -1, (byte) 0)[0];
			}
			if (this.crystal3Unit.m_state == 3) { //dead?
				this.crystal3Unit = null;
				sub_1447e(); //mission failed?
				return;
			}
			switch (this.scriptStep) {
				case 0:
					waitScript(50);
					this.scriptStep += 1;
					break;
				case 1:
					//Your Highness, I do not like the look
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
					C_Unit[] plUnits = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
					int m = 0;
					while (m < plUnits.length) {
						if ((plUnits[m].m_state == 2) && (plUnits[m].positionX <= 8)) {
							this.isUpdatingMb = false;
							waitScript(5);
							this.scriptStep += 1;
							break;
						} else {
							m++;
						}
					}
					break;
				case 5:
					this.isCursorVisible = false;
					moveCameraTo(4, 4);
					this.scriptStep += 1;
					break;
				case 6:
					C_Unit.createUnitOnMap((byte) 10, (byte) 1, 4, 4).goToPosition(4, 1, false, true); //skeleton
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 7:
					C_Unit.createUnitOnMap((byte) 1, (byte) 1, 4, 4).goToPosition(5, 2, false, true); //archer
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 8:
					C_Unit.createUnitOnMap((byte) 10, (byte) 1, 4, 4).goToPosition(4, 3, false, true); //skeleton
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 9:
					//Ambush! Protect the Crystal at all cost!...
					showUnitDialogMsg(A_MenuBase.getLangString(258), (byte) 5, (byte) 4);
					moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
					this.scriptStep += 1;
					break;
				case 10:
					this.isUpdatingMb = true;
					this.isCursorVisible = true;
					this.scriptStep += 1;
					break;
				case 11:
					plUnits = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
					m = 0;
					while (m < plUnits.length) {
						if ((plUnits[m].m_state == 2)
								&& (plUnits[m].positionY >= 7)) {
							this.isUpdatingMb = false;
							this.isCursorVisible = false;
							moveCameraTo(6, 10);
							this.scriptStep += 1;
							break;
						} else {
							m++;
						}
					}
					break;
				case 12:
					C_Unit.createUnitOnMap((byte) 1, (byte) 1, 6, 10).goToPosition(5, 10, false, true); //archer
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 13:
					C_Unit.createUnitOnMap((byte) 5, (byte) 1, 6, 10).goToPosition(7, 8, false, true); //wolf
					waitScript(15);
					this.scriptStep += 1;
					break;
				case 14:
					C_Unit.createUnitOnMap((byte) 5, (byte) 1, 6, 10).goToPosition(7, 9, false, true); //wolf
					this.isUpdatingMb = true;
					this.isCursorVisible = true;
					this.scriptStep += 1;
					break;
				case 15:
					plUnits = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
					m = 0;
					while (m < plUnits.length) {
						if ((plUnits[m].m_state == 2)
								&& (plUnits[m].positionX >= 8)
								&& (plUnits[m].positionY >= 6)) {
							this.isUpdatingMb = false;
							this.isCursorVisible = false;
							moveCameraTo(12, 5);
							this.scriptStep += 1;
							break;
						} else {
							m++;
						}
					}
					break;
				case 16:
					C_Unit.createUnitOnMap((byte) 5, (byte) 1, 12, 5).goToPosition(	12, 7, false, true);//wolf
					waitScript(15);
					this.scriptStep += 1;
					break;
				case 17:
					C_Unit.createUnitOnMap((byte) 6, (byte) 1, 12, 5).goToPosition(	12, 6, false, true); //golem
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 18:
					C_Unit.createUnitOnMap((byte) 5, (byte) 1, 12, 5).goToPosition(	12, 5, false, true); //wolf
					this.isUpdatingMb = true;
					this.isCursorVisible = true;
					this.scriptStep += 1;
					break;
				case 19:
					plUnits = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
					m = 0;
					while (m < plUnits.length) {
						if ((plUnits[m].m_state == 2)
								&& (plUnits[m].positionX >= 15)
								&& (plUnits[m].positionY >= 8)) {
							this.isUpdatingMb = false;
							this.isCursorVisible = false;
							moveCameraTo(18, 8);
							this.scriptStep += 1;
							break;
						} else {
							m++;
						}
					}
					break;
				case 20:
					C_Unit.createUnitOnMap((byte) 5, (byte) 1, 18, 8).goToPosition(16, 10, false, true);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 21:
					C_Unit.createUnitOnMap((byte) 6, (byte) 1, 18, 8).goToPosition(17, 10, false, true);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 22:
					C_Unit.createUnitOnMap((byte) 5, (byte) 1,	18, 8).goToPosition(18,	10, false, true);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 23:
					C_Unit.createUnitOnMap((byte) 1, (byte) 1, 18, 8).goToPosition(18, 9, false, true);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 24:
					showUnitDialogMsg(A_MenuBase.getLangString(259), (byte) 0, (byte) 4);
					this.isUpdatingMb = true;
					this.isCursorVisible = true;
					this.scriptStep += 1;
					break;
				case 25:
					if( (this.crystal3Unit.positionX >= 15)
						&& (this.crystal3Unit.positionY >= 11)
						&& (this.crystal3Unit.m_state == 2)) {
						waitScript(10);
						this.isUpdatingMb = false;
						this.isCursorVisible = false;
						this.scriptStep = 26;
						return;
					}
					if (countUnits(-1, -1, (byte) 1) == 0) { // no enemies
						this.isUpdatingMb = false;
						this.isCursorVisible = false;
						waitScript(10);
						this.scriptStep += 1;
					}
					break;
				case 26:
					missionComplete();
					break;
					
			}
	}
	
	public final void updateScenarioScript6(){
		switch (this.scriptStep) {
			case 0:
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 1:
				//The enemy is planning to attack King Galamar...
				showUnitDialogMsg(A_MenuBase.getLangString(260), (byte) 1, (byte) 4);
				this.scriptStep += 1;
				break;
			case 2:
				showObjective();
				this.scriptStep += 1;
				break;
			case 3:
				if ((countUnits(-1, -1, (byte) 1) == 0) && (countPlayerOwnerCastles(1) == 0)) {
					this.isUpdatingMb = false;
					this.isCursorVisible = false;
					waitScript(15);
					this.scriptStep += 1;
				}
				break;
			case 4:
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 5:
				//Let us hurry North to meet Galamar...
				showUnitDialogMsg(A_MenuBase.getLangString(261), (byte) 0, (byte) 4);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 6:
				missionComplete();
				break;
		}
	}
	
	public final void updateScenarioScript7(){

			if (this.scriptStep <= 10) {
				if (this.crystal3Unit == null) {
					this.crystal3Unit = getUnitsOfTypeStatePlayer(11, -1, (byte) 0)[0];
				}
				if (this.crystal3Unit.m_state == 3) {
					this.crystal3Unit = null;
					sub_1447e(); //gameover
					return;
				}
			}

			switch (this.scriptStep) {
				case 0:
					if (this.playersKings[0].m_state != 1) {
						this.m_tempUnit = null;
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
					C_Unit[] plUnits = getUnitsOfTypeStatePlayer(-1, -1, (byte) 0);
					for (int m = 0; m < plUnits.length; m++) {
						plUnits[m].followerUnitMb = null;
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
					C_Unit unit2 = C_Unit.createUnitOnMap((byte) 5, (byte) 1, 11, 8); //wolf
					unit2.fillWhereUnitCanMove(this.someMapData);
					unit2.goToPosition(14, 7, true);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 6:
					C_Unit unit3 = C_Unit.createUnitOnMap((byte) 0, (byte) 1, 11, 8); //soldier
					unit3.fillWhereUnitCanMove(this.someMapData);
					unit3.goToPosition(13, 7, true);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 7:
					C_Unit unit4 = C_Unit.createUnitOnMap((byte) 3, (byte) 1, 11, 8); //magi
					unit4.fillWhereUnitCanMove(this.someMapData);
					unit4.goToPosition(12, 7, true);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 8:
					C_Unit unit5 = C_Unit.createUnitOnMap((byte) 1, (byte) 1, 11, 8); //archer
					unit5.goToPosition(13, 8, false);
					waitScript(20);
					this.scriptStep += 1;
					break;
				case 9:
					//Another ambush! Don't let the Crystal leave your sight!
					showUnitDialogMsg(A_MenuBase.getLangString(264), (byte) 5, (byte) 4);
					this.isUpdatingMb = true;
					this.isCursorVisible = true;
					moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
					break;
				case 10:
					boolean outsideTheRegion = false;
					C_Unit[] unitsEndedTurn = getUnitsOfTypeStatePlayer(-1, 2, (byte) 0);
					for (int uT = 0; uT < unitsEndedTurn.length; uT++) {
						if ((unitsEndedTurn[uT].positionX <= 9) || (unitsEndedTurn[uT].positionY >= 10)) {
							outsideTheRegion = true;
							break;
						}
					}
					if ((outsideTheRegion) || (countUnits(-1, -1, (byte) 1) == 0)) {
						this.isCursorVisible = false;
						this.isUpdatingMb = false;
						waitScript(10);
						this.scriptStep += 1;
					}
					break;
				case 11:
					this.skeleton1Map2 = getUnitsOfTypeStatePlayer(11, -1, (byte) 0)[0]; //crystal
					this.crystalOfWisdom = C_Unit.createUnitOnMap((byte) 8, (byte) 1,
							this.mapWidth, this.skeleton1Map2.positionY); // dragon
					moveCameraTo(this.mapWidth - 1, this.skeleton1Map2.positionY);
					this.isCursorVisible = false;
					break;
				case 12:
					this.crystalOfWisdom.goToPosition(this.skeleton1Map2.positionX, this.skeleton1Map2.positionY, false);
					waitScript(5);
					this.scriptStep += 1;
					break;
				case 13:
					// Troops! That dragon is heading...
					showUnitDialogMsg(A_MenuBase.getLangString(265), (byte) 5, (byte) 4);
					this.m_tempUnit = this.crystalOfWisdom;
					this.scriptStep += 1;
					break;
				case 14:
					if (this.crystalOfWisdom.m_state != 1) { //stopped running
						// It is the Crystal it is after! May the Creator protect us!...
						showUnitDialogMsg(A_MenuBase.getLangString(266), (byte) 0, (byte) 4);
						this.crystalOfWisdom.goToPosition(-1, this.crystalOfWisdom.positionY, false);
						waitScript(3);
						this.scriptStep += 1;
					}
					break;
				case 15:
					this.skeleton1Map2.goToPosition(-1, this.crystalOfWisdom.positionY, false);
					this.scriptStep += 1;
					break;
				case 16:
					if (this.crystalOfWisdom.m_state != 1) { //stopped running
						waitScript(10);
						this.skeleton1Map2.removeFromMap();
						this.crystalOfWisdom.removeFromMap();
						moveCursorToPos(0, this.crystalOfWisdom.positionY);
						this.skeleton1Map2 = null;
						this.crystalOfWisdom = null;
						this.m_tempUnit = null;
						this.scriptStep += 1;
					}
					break;
				case 17:
					moveCameraTo(1, 9);
					break;
				case 18:
					this.playersKings[1] = C_Unit.createUnitOnMap((byte) 9, (byte) 1, -2, 8);
					this.playersKings[1].goToPosition(0, 8, false);
					C_Unit.createUnitOnMap((byte) 0, (byte) 1, -1, 8).goToPosition(3, 8, false);
					C_Unit.createUnitOnMap((byte) 0, (byte) 1, -1, 10).goToPosition(1, 10, false);
					C_Unit.createUnitOnMap((byte) 8, (byte) 1, -3, 7).goToPosition(4, 8, false);
					C_Unit.createUnitOnMap((byte) 8, (byte) 1, -3, 11).goToPosition(2, 10, false);
					C_Unit.createUnitOnMap((byte) 4, (byte) 1, -2, 9).goToPosition(2, 9, false);
					C_Unit.createUnitOnMap((byte) 6, (byte) 1, -4, 9).goToPosition(4, 9, false);
					C_Unit.createUnitOnMap((byte) 6, (byte) 1, -6, 9).goToPosition(5, 10, false);
					waitScript(50);
					this.scriptStep += 1;
					break;
				case 19:
					//Run, pitiful human, before it is too late!...
					showUnitDialogMsg(A_MenuBase.getLangString(267), (byte) 3, (byte) 4);
					this.scriptStep += 1;
					break;
				case 20:
					moveCameraTo(13, 14);
					break;
				case 21:
					C_Unit.createUnitOnMap((byte) 0, (byte) 1, 13, 14).goToPosition(12, 14, false);
					waitScript(5);
					this.scriptStep += 1;
					break;
				case 22:
					C_Unit.createUnitOnMap((byte) 6, (byte) 1, 13, 14).goToPosition(14, 14, false);
					waitScript(5);
					this.scriptStep += 1;
					break;
				case 23:
					C_Unit.createUnitOnMap((byte) 2, (byte) 1, 13, 14).goToPosition(13, 12, false);
					waitScript(5);
					this.scriptStep += 1;
					break;
				case 24:
					C_Unit.createUnitOnMap((byte) 3, (byte) 1, 13, 14).goToPosition(13, 15, false);
					waitScript(15);
					this.scriptStep += 1;
					break;
				case 25:
					//The enemy force looks formidable, I recommend retreat...
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
					C_Unit valadorn  = C_Unit.createUnitOnMap((byte) 9, (byte) 0, 13, 18); // valadorn
					valadorn.setKingName(2);
					valadorn.goToPosition(13, 16, false);
					C_Unit.createUnitOnMap((byte) 6, (byte) 0, 12, 18).goToPosition(12, 16, false);
					C_Unit.createUnitOnMap((byte) 8, (byte) 0, 14, 19).goToPosition(14, 16, false);
					C_Unit.createUnitOnMap((byte) 4, (byte) 0, 13, 19).goToPosition(13, 17, false);
					C_Unit.createUnitOnMap((byte) 1, (byte) 0, 12, 19).goToPosition(12, 17, false);
					waitScript(20);
					this.scriptStep += 1;
					break;
				case 29:
					//Galamar! We came as fast as we could! Let us fight side by side!...
					showUnitDialogMsg(A_MenuBase.getLangString(270), (byte) 1, (byte) 4);
					waitScript(10);
					this.scriptStep += 1;
					break;
				case 30:
					moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
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
					if ((countUnits(-1, -1, (byte) 1) == 0) && (countPlayerOwnerCastles(1) == 0)) {
						this.isUpdatingMb = false;
						this.isCursorVisible = false;
						waitScript(10);
						this.scriptStep += 1;
					}
					break;
				case 34:
					missionComplete();
					break;
			}
	}
	
	public final void updateScenarioScript8() throws Exception{
		//intro missing @todo
		switch (this.scriptStep) {
			case 0:
				A_MenuBase.mainCanvas.showMenu(this.mapNameDialog);
				this.isFading = true;
				this.scriptStep += 1;
				break;
			case 1:
				if (!this.var_380b) {
					//The Ruins of the Ancient Citadel... and Saeth! With the Crystals!
					showUnitDialogMsg(A_MenuBase.getLangString(271), (byte) 0, (byte) 4);
					this.scriptStep += 1;
				}
				break;
			case 2:
				moveCameraTo(this.playersKings[1].positionX, this.playersKings[1].positionY);
				this.scriptStep += 1;
				break;
			case 3:
				//At last, Galamar and Valadorn!...
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
				this.skeleton1Map2 = getSomeUnit(5, 2, (byte) 0); // crystal 1
				this.skeleton1Map2.goToPosition(7, 2, false);
				this.scriptStep += 1;
				break;
			case 7:
				if (this.skeleton1Map2.m_state != 1) {
					this.skeleton1Map2.removeFromMap();
					this.skeleton1Map2 = null;
					this.crystalOfWisdom = getSomeUnit(7, 3, (byte) 0); // crystal 2
					this.crystalOfWisdom.goToPosition(7, 2, false);
					this.scriptStep += 1;
				}
				break;
			case 8:
				if (this.crystalOfWisdom.m_state != 1) { 
					this.crystalOfWisdom.removeFromMap();
					this.crystalOfWisdom = null;
					this.skeleton2Map2 = getSomeUnit(9, 2, (byte) 0); // crystal 3
					this.skeleton2Map2.goToPosition(7, 2, false);
					this.scriptStep += 1;
				}
				break;
			case 9:
				if (this.skeleton2Map2.m_state != 1) {
					this.skeleton2Map2.removeFromMap();
					this.skeleton2Map2 = null;
					this.playersKings[1].goToPosition(7, 2, false); // saeth
					waitScript(20);
					this.scriptStep += 1;
				}
				break;
			case 10:
				moveCameraTo(9, 15);
				this.isCursorVisible = true;
				break;
			case 11:
				D_Menu targetMenu = createDialog(null, A_MenuBase.getLangString(279), this.someGHeight, 1000); //TARGET AQUIRED...
				targetMenu.setMenuLoc(this.viewportWidth, 2, 17);
				A_MenuBase.mainCanvas.showMenu((A_MenuBase) targetMenu);
				this.scriptStep += 1;
				break;
			case 12:
				this.showFuryAfterEffect = false;
				targetUnit(getSomeUnit(9, 15, (byte) 0));
				this.scriptStep += 1;
				break;
			case 13:
				if (this.var_3873 >= 2) {
					//What in the name of the Creator is that!
					showUnitDialogMsg(A_MenuBase.getLangString(275), (byte) 0, (byte) 4);
					C_Unit targetedUnit = getSomeUnit(9, 15, (byte) 0);
					targetedUnit.removeFromMap();
					this.showFuryAfterEffect = true;
					waitScript(20);
					this.scriptStep += 1;
				}
				break;
			case 14:
				this.isCursorVisible = false;
				// Pathetic creatures, this is something ancient...
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
				this.someCameraVelocityMb = 4;
				moveCameraTo(3, 9);
				break;
			case 17:
				moveCameraTo(13, 4);
				break;
			case 18:
				this.someCameraVelocityMb = 12;
				showUnitDialogMsg(A_MenuBase.getLangString(278), (byte) 5, (byte) 4);
				moveCameraTo(this.playersKings[0].positionX, this.playersKings[0].positionY);
				break;
			case 19:
				showObjective();
				this.scriptStep += 1;
				break;
			case 20:
				if (this.isSaethDead) {
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
					this.playersKings[1] = C_Unit.createUnitOnMap((byte) 9, (byte) 1, 7, 2);
					this.playersKings[1].setKingName(3);
					C_Unit.createUnitOnMap((byte) 9, (byte) 0, 6, 3);
					C_Unit luuUnit = C_Unit.createUnitOnMap((byte) 9, (byte) 0, 8, 3);
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
					//Pitiful wretches. You will not live...
					showUnitDialogMsg(A_MenuBase.getLangString(281), (byte) 4, (byte) 4);
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
				startShakingScreen(5000);
				waitScript(10);
				this.scriptStep += 1;
				break;
			case 29:
				//Your Majesty, the Ruins are falling apart!...
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
					this.isShakingScreen = false;
					this.scriptStep += 1;
				}
				break;
			case 34:
				loadIntro(5, 2, 2);
				this.scriptStep += 1;
				break;
			case 35:
				E_MainCanvas.playMusicLooped2(0, 0);
				gameOverVictory(A_MenuBase.getLangString(288)); //Congratulations!
				this.scriptStep += 1;
				break;
			case 36:
				this.var_3b93 = 0;
				this.unkState = 14;
				this.scriptStep += 1;
				break;
		}
	}
	
	public final void showObjective() {
		this.mapNameDialog = null;
		this.someCameraVelocityMb = 12;
		C_Unit.m_speed = C_Unit.m_defaultSpeed;
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
		this.unkState = 10;
	}

	public final void sub_1447e() {
		this.var_3b7b = true;
		this.scriptStep = 0;
		waitScript(20);
		E_MainCanvas.stopMusic();
		E_MainCanvas.playMusicLooped(7, 1);
	}

	public final void setupUnitsFAmb(C_Unit unit1, C_Unit unit2) throws Exception {
		System.gc();
		this.var_3bfb = (this.someGHeight - this.var_3a43);
		this.var_3be3 = true;
		this.waveImageAmplitude = 0;
		this.var_3bb3 = false;
		this.attackerUnitMb = unit1;
		this.attackedUnitMb = unit2;
		E_MainCanvas.loadResourcesPak("/2.pak");
		this.faUnit1 = new G_FightAnimation(this, unit1, null);
		this.faUnit2 = new G_FightAnimation(this, unit2, this.faUnit1);
		this.faUnit1.otherFightAnim = this.faUnit2;
		unit1.getUnitAttackDamage(unit2);
		if (unit2.isNearOtherUnit(unit1,
				unit1.positionX, unit1.positionY)) {
			unit2.getUnitAttackDamage(unit1);
			this.unitStrikesBackFAMb = true;
		} else {
			this.unitStrikesBackFAMb = false;
		}
		this.faUnit1.unitHealth3 = ((byte) unit1.unitHealthMb);
		this.faUnit1.unitChars3 = ((byte) unit1.getAliveCharactersCount());
		this.faUnit2.unitHealth3 = ((byte) unit2.unitHealthMb);
		this.faUnit2.unitChars3 = ((byte) unit2.getAliveCharactersCount());
		E_MainCanvas.playMusicLooped(playersFAMusicIds[this.playersIndexes[this.playerId]], 0);
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
		if ((this.isShakingScreen) && (this.time - this.shakeScreenStartTime >= this.shakeScreenMaxTime)) {
			this.isShakingScreen = false;
		}
		F_Sprite sprite;
		for (int i = 0; i < this.gameSprites.size(); i++) {
			sprite = (F_Sprite) this.gameSprites.elementAt(i);
			sprite.spriteUpdate();
		}
		for (int i = 0; i < this.gameSprites.size(); i++) {
			sprite = (F_Sprite) this.gameSprites.elementAt(i);
			if (!sprite.isUpdatingMb) {
				removeSpriteFrom(sprite);
			}
		}
		this.faUnit1.sub_2ae8();
		this.faUnit2.sub_2ae8();
		if (this.var_3be3) {
			this.waveImageAmplitude += 1;
			if (this.waveImageAmplitude >= 16) {
				this.var_3be3 = false;
				this.faUnit1.sub_16bb();
			}
			this.var_3beb = true;
			this.var_3bf3 = true;
			return;
		}
		if (this.var_3bb3) {
			if (this.time - this.someStartTime2 >= 300L) {
				this.gameSprites.removeAllElements();
				this.faUnit2 = null;
				this.faUnit1 = null;
				this.mapEffectsSpritesList = new Vector();
				afterUnitsAttacked();
				this.gameMode2Mb = 1;
				E_MainCanvas.stopMusic();
				E_MainCanvas.playMusicLooped(playersMusicIdsMb[this.playersIndexes[this.playerId]], 0);
				A_MenuBase.mainCanvas.clearActions();
				this.var_397b = true;
				this.var_3983 = true;
			}
		} else if (this.faUnit1.var_b35) {
			if ((this.unitStrikesBackFAMb) && (this.faUnit2.unitHealth3 > 0)) {
				if (!this.faUnit2.var_b2d) {
					this.faUnit2.sub_16bb();
				}
				if (this.faUnit2.var_b35) {
					this.var_3bb3 = true;
					this.someStartTime2 = this.time;
				}
			} else {
				this.var_3bb3 = true;
				this.someStartTime2 = this.time;
			}
		}
	}

	public final void sub_1480f(Graphics gr) {
		int i = 0;
		int j = 0;
		if (this.isShakingScreen) {
			i = E_MainCanvas.getRandom() % 10;
			j = E_MainCanvas.getRandom() % 3;
		}
		gr.translate(0, this.var_3a43);
		gr.setClip(0, 0, this.someGWidth, this.var_3bfb);
		this.faUnit1.sub_35fd(gr, i, j);
		this.faUnit2.sub_35fd(gr, i + this.viewportWidth, j);
		gr.setColor(0);
		gr.fillRect(this.viewportWidth - 1 + i, 0, 2, this.var_3bfb);
		this.faUnit1.sub_3788(gr);
		this.faUnit2.sub_3788(gr);
		Vector localVector = new Vector(this.gameSprites.size());
		F_Sprite sSprite;
		for (int k = 0; k < this.gameSprites.size(); k++) {
			sSprite = (F_Sprite) this.gameSprites.elementAt(k);
			int m = 0;
			if (sSprite.var_85c) {
				localVector.addElement(sSprite);
			} else {
				for (m = 0; m < localVector.size(); m++) {
					F_Sprite sprite = (F_Sprite) localVector.elementAt(m);
					if ((sprite.var_85c)
							|| (sSprite.posYPixel
									+ sSprite.frameHeight < sprite.posYPixel
									+ sprite.frameHeight)) {
						localVector.insertElementAt(sSprite, m);
						break;
					}
				}
			}
			if (m == localVector.size()) {
				localVector.addElement(sSprite);
			}
		}
		this.gameSprites = localVector;
		for (int k = 0; k < this.gameSprites.size(); k++) {
			sSprite = (F_Sprite) this.gameSprites.elementAt(k);
			if (sSprite.var_86c == 0) {
				gr.setClip(0, 0, this.viewportWidth, this.var_3bfb);
			} else if (sSprite.var_86c == 1) {
				gr.setClip(this.viewportWidth, 0, this.viewportWidth,
						this.var_3bfb);
			} else {
				gr.setClip(0, 0, this.someGWidth, this.var_3bfb);
			}
			sSprite.onSpritePaint(gr, 0,
					sSprite.var_80c);
		}
		gr.translate(0, -this.var_3a43);
		gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
		if (this.var_3bf3) {
			this.var_3bf3 = false;
			int k = this.someCanHeight - someUnkHeight1;
			gr.setColor(14672074);
			gr.fillRect(0, k, this.someCanWidth, someUnkHeight1);
			D_Menu.sub_5602(gr, 0, k, this.someCanWidth, someUnkHeight1, 0);
			gr.setClip(0, 0, this.someCanWidth, this.someCanHeight);
			this.faUnit1.drawUnitHealth(gr);
			gr.translate(this.viewportWidth, 0);
			this.faUnit2.drawUnitHealth(gr);
			gr.translate(-this.viewportWidth, 0);
		}
		if (this.var_3beb) {
			this.var_3beb = false;
			drawAttackStatMenu(gr, this.faUnit1.m_unit,
					this.faUnit2.m_unit, 0);
		}
		if (this.var_3be3) {
			sub_e77a(gr, 0, this.waveImageAmplitude, 16, 1, null, 0, 0,
					this.someCanWidth, this.someCanHeight);
		}
	}

	public final void startShakingScreen(int val) {
		this.isShakingScreen = true;
		this.shakeScreenMaxTime = val;
		this.shakeScreenStartTime = this.time;
	}

	public final D_Menu createOnlineNewsMenu(String[] unusedArr, A_MenuBase pMenu) {
		D_Menu menu1;
		D_Menu menu2;//@unused?
		if (this.var_3c13.length > 0) {
			menu1 = new D_Menu((byte) 11, 0);
			menu2 = menu1.createTitleMenu(A_MenuBase.getLangString(46));// ONLINE NEWS
			menu2.menuTitleIcon = this.menuIconsFrames[6]; 
			menu1.createMenuListItems(this.var_3c13, this.someGWidth / 2,
					(this.someGHeight + menu2.menuHeight) / 2,
					this.someGWidth, this.someGHeight - menu2.menuHeight,
					3, 4);
		} else {
			menu1 = new D_Menu((byte) 10, 0);
			menu2 = menu1.createTitleMenu(A_MenuBase.getLangString(46));// ONLINE NEWS
			menu2.menuTitleIcon = this.menuIconsFrames[6];
			menu1.createDescDialogMb(null, A_MenuBase.getLangString(52),
					this.someGWidth, -1); //EMPTY
		}
		menu1.setParentMenu(pMenu);
		A_MenuBase.mainCanvas.showMenu(menu1);
		return menu1;
	}

	public final void retrieveOnlineNewsData(byte[] data) {
		DataInputStream dis;
		try {
			dis = new DataInputStream(new ByteArrayInputStream(data));
			dis.readLong();
			int iCase = dis.readInt();
			switch (iCase) {
			case 10001:
				dis.readUTF();
				dis.readInt();
				dis.readUTF();
				dis.readInt();
				dis.readUTF();
				dis.readInt();
				dis.readUTF();
				int j = dis.readInt();
				dis.readUTF();
				dis.readUTF();
				int n;
				if (this.var_3c83 == 0) {
					int k = dis.readInt() / 2;
					this.var_3c13 = new String[k];
					this.var_3c1b = new String[k];
					this.var_3c23 = new String[k];
					n = 0;
					for (int i1 = 0; i1 < k; i1++) {
						this.var_3c13[i1] = dis.readUTF();
						this.var_3c1b[i1] = dis.readUTF();
					}
					this.newsItemsMenu = createOnlineNewsMenu(this.var_3c13, this.someOnlineParentMenu);
				} else if (this.var_3c83 == 1) {
					dis.readInt();
					this.var_3c23[this.var_3c03] = dis.readUTF();
					D_Menu localClass_d_0231= createDialog(
							this.var_3c13[this.var_3c03],
							this.var_3c23[this.var_3c03], this.someGHeight,
							this.someGHeight / 2, -1);
					localClass_d_0231.setParentMenu(this.someOnlineParentMenu);
					A_MenuBase.mainCanvas.showMenu(localClass_d_0231);
				} else if (this.var_3c83 == 2) {
					int m = dis.readInt() / 3;
					this.var_3c2b = new String[m];
					this.var_3c33 = new String[m];
					this.someSizesMb = new int[m];
					for (n = 0; n < m; n++) {
						this.var_3c2b[n] = dis.readUTF();
						this.var_3c33[n] = dis.readUTF();
						this.someSizesMb[n] = Integer
								.parseInt(dis.readUTF());
					}
					sub_5d1a(this.someOnlineParentMenu);
					A_MenuBase.mainCanvas.showMenu(this.var_3943);
				} else if (this.var_3c83 == 3) {
					String str = this.var_3c2b[this.var_3c0b];
					byte[] arrayOfByte = new byte[j];
					dis.readFully(arrayOfByte);
					sub_15568(str, arrayOfByte);
					sub_5d1a(this.var_3943.parentMenu);
					D_Menu localClass_d_0232 = createDialog(null,
							A_MenuBase.replaceStringFirst(45, str), this.someGHeight, 2000);
					localClass_d_0232.setParentMenu(this.var_3943);
					A_MenuBase.mainCanvas.showMenu(localClass_d_0232);
				}
				this.someOnlineParentMenu = null;
				return;
			}
			dis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//Failed to retrieve data
		D_Menu localObject = createDialog(null, A_MenuBase.getLangString(44), this.someGHeight, -1);
		localObject.setParentMenu(this.someOnlineParentMenu);
		this.someOnlineParentMenu = null;
		A_MenuBase.mainCanvas.showMenu((A_MenuBase) localObject);
	}

	public final void startRetrievingData(int paramInt, String resName,
			String langCode, A_MenuBase inMenu) throws Exception {
		this.var_3c83 = paramInt;
		this.someOnlineParentMenu = inMenu;
		this.var_3c73 = false;
		this.m_baos = new ByteArrayOutputStream();
		this.m_dos = new DataOutputStream(this.m_baos);
		this.m_dos.writeInt(10001);
		this.m_dos.writeUTF(this.appPropPortalCode);
		this.m_dos.writeUTF(this.appPropGameCode);
		this.m_baosSize = this.m_baos.size();
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

	public final void saveSlots(int index) throws Exception {
		int i = this.var_3903[index];
		this.countExtraMapsMb -= 1;
		String[] arrayOfString = new String[this.countExtraMapsMb];
		int[] arrayOfInt = new int[this.countExtraMapsMb];
		System.arraycopy(this.extraSkirmishMapNamesMb, 0, arrayOfString, 0, index);
		System.arraycopy(this.extraSkirmishMapNamesMb, index + 1, arrayOfString, index,
				this.countExtraMapsMb - index);
		System.arraycopy(this.var_3903, 0, arrayOfInt, 0, index);
		System.arraycopy(this.var_3903, index + 1, arrayOfInt, index,
				this.countExtraMapsMb - index);
		this.extraSkirmishMapNamesMb = arrayOfString;
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
		String[] arrayOfString = new String[this.countExtraMapsMb + 1];
		int[] arrayOfInt = new int[this.countExtraMapsMb + 1];
		System.arraycopy(this.extraSkirmishMapNamesMb, 0, arrayOfString, 0, this.countExtraMapsMb);
		System.arraycopy(this.var_3903, 0, arrayOfInt, 0, this.countExtraMapsMb);
		this.extraSkirmishMapNamesMb = arrayOfString;
		this.var_3903 = arrayOfInt;
		this.var_3903[this.countExtraMapsMb] = E_MainCanvas.saveDataToStore("download", someData);
		this.extraSkirmishMapNamesMb[this.countExtraMapsMb] = paramString;
		this.countExtraMapsMb += 1;
		this.downloadStoreAvailableSize = E_MainCanvas.getRecordStoreAvailableSize("download");
		saveSettingsMb();
	}

	public final void saveSettingsMb() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(this.countExtraMapsMb);
		for (int i = 0; i < this.countExtraMapsMb; i++) {
			dos.writeInt(this.var_3903[i]);
			dos.writeUTF(this.extraSkirmishMapNamesMb[i]);
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