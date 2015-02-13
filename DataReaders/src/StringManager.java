

public class StringManager {
	
	public class MainCanvas{
		public final String getCodeKeyName(int paramInt) {
			int keyCode = 0;
			switch (paramInt) {
			case 1:
				keyCode = 50;
				break;
			case 2:
				keyCode = 56;
				break;
			case 4:
				keyCode = 52;
				break;
			case 8:
				keyCode = 54;
				break;
			case 16:
				keyCode = 53;
				break;
			case 32:
				keyCode = 48;
				break;
			case 64:
				keyCode = 49;
				break;
			case 128:
				keyCode = 51;
				break;
			case 256:
				keyCode = 55;
				break;
			case 512:
				keyCode = 57;
			}
			return "/"+keyCode + "/";//super.getKeyName(keyCode);
		}
	}
	
	private static String[] langStrings;
	private static MainCanvas mainCanvas;
	
	public static final int loadLangDataFromFile(String langFileName) {
		DataInputStream dis;
		try {
			dis = new DataInputStream(Main.getResourceAsStream(langFileName));
			langStrings = new String[dis.readInt()];

			int i = 0;
			int j = langStrings.length;
			while (i < j) {
				langStrings[i] = dis.readUTF();
				i++;
			}
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return langStrings.length;
	}
	
	public static final String getStrByIdAndReplaceUWith(int strIndex, String inStr) {
		String langStr = getLangString(strIndex, false);
		return replaceStringInString(langStr, "%U", inStr, false);
	}
	
	public static final String getLangString(int index) {
		return getLangString(index, false);
	}
	
	public static final String getLangString(int index, boolean paramBoolean) {
		if (index < langStrings.length) {
			String langString = langStrings[index];
			if ((paramBoolean)
					&& ((langString = replaceStringInString(
							replaceStringInString(replaceStringInString(
									replaceStringInString(langString, "%K5",
											getStrByIdAndReplaceUWith(20, mainCanvas.getCodeKeyName(16)),
											true), "%K0", mainCanvas.getCodeKeyName(32),
									true), "%K7", mainCanvas.getCodeKeyName(256), true),
							"%K9", mainCanvas.getCodeKeyName(512), true)).indexOf("%KM") != -1)) {
				StringBuffer buf = new StringBuffer();
				String[] arrayOfString = { mainCanvas.getCodeKeyName(1),
						mainCanvas.getCodeKeyName(2), mainCanvas.getCodeKeyName(4),
						mainCanvas.getCodeKeyName(8) };
				buf.append(sub_d68(17, arrayOfString));
				if (buf.length() > 0) {
					buf.append('/');
				}
				buf.append(getLangString(18));
				if (buf.length() > 0) {
					buf.append('/');
				}
				buf.append(getLangString(19));
				langString = replaceStringInString(langString, "%KM", buf.toString(), true);
			}
			return langString;
		}
		return "?: " + index;
	}
	
	private static String sub_d68(int unUsedInt, String[] inArr) {
		String str = new String(getLangString(17)); // maybehere unUsedInt
		for (int i = 0; i < inArr.length; i++) {
			str = replaceStringInString(str, "%U", inArr[i], false);
		}
		return str;
	}
	
	private static String replaceStringInString(String originalStr, String toReplace,
		String replacement, boolean manyTimes) {
	do {
		int startIndex = originalStr.indexOf(toReplace);
		if (startIndex == -1) {
			break;
		}
		originalStr = originalStr.substring(0, startIndex) + replacement
				+ originalStr.substring(startIndex + toReplace.length());
	} while (manyTimes);
	return originalStr;
}
}
