import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public class A_MenuBase {
	
	public static E_MainCanvas mainCanvas;
	public int someCanWidth = mainCanvas.getWidth();
	public int someCanHeight = mainCanvas.getHeight();
	public int someCanWidthDiv2 = this.someCanWidth >> 1;
	public int someCanHeightDiv2 = this.someCanHeight >> 1;
	public static String[] langStrings;
	public static short[] sin1024Table = null;
	public static int maxDegrees = 360;
	public static int maxDegreesDiv2 = 0;
	public static int maxDegreesDiv4 = 0;

	public void onLoad() {
		//@todo override
	}

	public void sub_865(int paramInt1, int paramInt2) {
		//@todo override or not?
	}

	public void onUpdate() throws Exception {
		//@todo override
	}

	public void onPaint(Graphics paramGraphics) {
		//@todo override
	}

	public static final String[] wrapText(String string, int maxWidth, Font aFont) {
		Vector localVector = new Vector();
		int i = 0;
		int k = string.length();
		Object localObject1 = null;
		int m;
		do {
			m = i;
			int n = string.indexOf('\n', m);
			do {
				int i1 = m;
				Object localObject2 = localObject1;
				m = sub_ab5(string, m);
				if ((n > -1) && (n < m)) {
					m = n;
				}
				localObject1 = string.substring(i, m).trim();
				if (aFont.stringWidth((String) localObject1) > maxWidth) {
					if (i1 == i) {
						for (int i2 = ((String) localObject1).length() - 1; i2 > 0; i2--) {
							String str = ((String) localObject1).substring(0,
									i2);
							if (aFont.stringWidth(str) <= maxWidth) {
								m = i1 + i2;
								localObject1 = str;
								break;
							}
						}
					}
					m = i1;
					localObject1 = localObject2;
					break;
				}
				if (m == n) {
					m++;
					break;
				}
			} while (m < k);
			localVector.addElement(localObject1);
		} while ((i = m) < k);
		String[] arrayOfString = new String[localVector.size()];
		localVector.copyInto(arrayOfString);
		return arrayOfString;
	}

	private static final int sub_ab5(String string, int charPos) {
		int i = string.charAt(charPos);
		if (sub_b97(i)) {
			return charPos + 1;
		}
		int j = 0;
		int k = 0;
		while ((k = string.indexOf(' ', charPos)) == 0) {
			charPos++;
		}
		if ((j = k) == -1) {
			j = string.length();
		} else {
			j++;
		}
		for (int it = charPos + 1; it < j; it++) {
			if (sub_b97(string.charAt(it))) {
				return it;
			}
		}
		return j;
	}

	private static final boolean sub_b97(int paramInt) {
		return ((paramInt >= 11904) && (paramInt < 44032))
				|| ((paramInt >= 63744) && (paramInt < 64256))
				|| ((paramInt >= 65280) && (paramInt < 65504));
	}

	public static final int loadLangStrings(String langFile, boolean unusedBool)
			throws Exception {
		InputStream stream = B_MainMIDlet.midlet.getClass()
				.getResourceAsStream(langFile);
		DataInputStream dis = new DataInputStream(stream);
		langStrings = new String[dis.readInt()];
		int i = 0;
		int length = langStrings.length;
		while (i < length) {
			langStrings[i] = dis.readUTF();
			i++;
		}
		dis.close();
		return langStrings.length;
	}

	public static final String getLangString(int stringId) {
		return getSomeHelpString(stringId, false);
	}

	public static final String getSomeHelpString(int strId, boolean paramBoolean) {
		if (strId < langStrings.length) {
			String str = langStrings[strId];
			if(paramBoolean) {
				String someStr = replaceStringFirst(20, mainCanvas.getKeyName2(16)); //'%U'/select
				str = replaceString(str, "%K5", someStr, true);
				str = replaceString(str, "%K0", mainCanvas.getKeyName2(32), true);
				str = replaceString(str, "%K7", mainCanvas.getKeyName2(256), true);
				str = replaceString(str, "%K9", mainCanvas.getKeyName2(512), true);
				if ((str.indexOf("%KM") != -1)) {
					StringBuffer buf = new StringBuffer();
					String[] keyNames = { mainCanvas.getKeyName2(1),
							mainCanvas.getKeyName2(2), mainCanvas.getKeyName2(4),
							mainCanvas.getKeyName2(8) };
					buf.append(stringFormat(17, keyNames)); //'%U', '%U', '%U', '%U'
					if (buf.length() > 0) {
						buf.append('/');
					}
					buf.append(getLangString(18)); //direction pad
					str = replaceString(str, "%KM", buf.toString(), true);
				}
			}
			return str;
		}
		return "?: " + strId;
	}

	public static final String stringFormat(int paramInt, String[] paramArrayOfString) {
		String str = new String(getLangString(paramInt));
		for (int i = 0; i < paramArrayOfString.length; i++) {
			str = replaceString(str, "%U", paramArrayOfString[i], false);
		}
		return str;
	}

	public static final String replaceStringFirst(int strID, String replacement) {
		return replaceString(getLangString(strID), "%U", replacement, false);
	}

	public static final String replaceString(String string,
			String toReplace, String replacement, boolean menuTimes) {
		String str = string;
		do {
			int index = str.indexOf(toReplace);
			if (index == -1) {
				break;
			}
			str = str.substring(0, index) + replacement
					+ str.substring(index + toReplace.length());
		} while (menuTimes);
		return str;
	}

	public static final void initSin1024() {
		//
		maxDegreesDiv2 = maxDegrees >> 1;
		maxDegreesDiv4 = maxDegreesDiv2 >> 1;
		sin1024Table = new short[maxDegrees];
		int j = maxDegrees * 10000 / 2 / 31415;
		int k = 1024 * j;
		int m = 0;
		for (int degree = 0; degree < maxDegrees; degree++) {
			int n = m / j;
			sin1024Table[degree] = ((short) n);
			k -= n;
			m += k / j;
		}
		//sin1024Table[(int) 'Â'] = 0; // 'Â´'
		//sin1024Table[270] = -1024;
	}

	public static final short getSin1024(int degree) {
		degree %= 360;
		return sin1024Table[degree];
	}

	public static final short getCos2014(int angle) {
		angle = (angle + maxDegreesDiv4) % 360;
		return sin1024Table[angle];
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_a_000
 * 
 * JD-Core Version: 0.7.0.1
 */