import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public class A_MenuBase {
	
	public static E_MainCanvas mainCanvas;
	public int someCanWidth = mainCanvas.getWidth();
	public int someCanHeight = mainCanvas.getHeight();
	public int var_7b3 = this.someCanWidth >> 1;
	public int var_7bb = this.someCanHeight >> 1;
	public static String[] langStrings;
	public static short[] var_7cb = null;
	public static int var_7d3 = 360;
	public static int var_7db = 0;
	public static int var_7e3 = 0;

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

	public static final String[] sub_8c0(String paramString, int paramInt,
			Font paramFont) {
		Vector localVector = new Vector();
		int i = 0;
		int k = paramString.length();
		Object localObject1 = null;
		int m;
		do {
			m = i;
			int n = paramString.indexOf('\n', m);
			do {
				int i1 = m;
				Object localObject2 = localObject1;
				m = sub_ab5(paramString, m);
				if ((n > -1) && (n < m)) {
					m = n;
				}
				localObject1 = paramString.substring(i, m).trim();
				if (paramFont.stringWidth((String) localObject1) > paramInt) {
					if (i1 == i) {
						for (int i2 = ((String) localObject1).length() - 1; i2 > 0; i2--) {
							String str = ((String) localObject1).substring(0,
									i2);
							if (paramFont.stringWidth(str) <= paramInt) {
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

	private static final int sub_ab5(String paramString, int paramInt) {
		int i = paramString.charAt(paramInt);
		if (sub_b97(i)) {
			return paramInt + 1;
		}
		int j = 0;
		int k = 0;
		while ((k = paramString.indexOf(' ', paramInt)) == 0) {
			paramInt++;
		}
		if ((j = k) == -1) {
			j = paramString.length();
		} else {
			j++;
		}
		for (int it = paramInt + 1; it < j; it++) {
			if (sub_b97(paramString.charAt(it))) {
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

	public static final String getLangString(int paramInt) {
		return sub_cb9(paramInt, false);
	}

	public static final String sub_cb9(int paramInt, boolean paramBoolean) {
		if (paramInt < langStrings.length) {
			String str = langStrings[paramInt];
			if ((paramBoolean)
					&& ((str = sub_e6a(
							str = sub_e6a(
									str = sub_e6a(
											str = sub_e6a(
													str,
													"%K5",
													sub_e44(20, mainCanvas
															.getKeyName2(16)),
													true), "%K0",
											mainCanvas.getKeyName2(32), true), "%K7",
									mainCanvas.getKeyName2(256), true), "%K9",
							mainCanvas.getKeyName2(512), true)).indexOf("%KM") != -1)) {
				StringBuffer localStringBuffer = new StringBuffer();
				String[] arrayOfString = { mainCanvas.getKeyName2(1),
						mainCanvas.getKeyName2(2), mainCanvas.getKeyName2(4),
						mainCanvas.getKeyName2(8) };
				localStringBuffer.append(sub_ddf(17, arrayOfString));
				if (localStringBuffer.length() > 0) {
					localStringBuffer.append('/');
				}
				localStringBuffer.append(getLangString(18));
				str = sub_e6a(str, "%KM", localStringBuffer.toString(), true);
			}
			return str;
		}
		return "?: " + paramInt;
	}

	public static final String sub_ddf(int paramInt, String[] paramArrayOfString) {
		String str = new String(getLangString(paramInt));
		for (int i = 0; i < paramArrayOfString.length; i++) {
			str = sub_e6a(str, "%U", paramArrayOfString[i], false);
		}
		return str;
	}

	public static final String sub_e44(int paramInt, String paramString) {
		return sub_e6a(getLangString(paramInt), "%U", paramString, false);
	}

	public static final String sub_e6a(String paramString1,
			String paramString2, String paramString3, boolean paramBoolean) {
		String str = paramString1;
		do {
			int i;
			if ((i = str.indexOf(paramString2)) == -1) {
				break;
			}
			str = str.substring(0, i) + paramString3
					+ str.substring(i + paramString2.length());
		} while (paramBoolean);
		return str;
	}

	public static final void sub_ef4() {
		var_7db = var_7d3 >> 1;
		var_7e3 = var_7db >> 1;
		var_7cb = new short[var_7d3];
		int j = var_7d3 * 10000 / 2 / 31415;
		int k = 1024 * j;
		int m = 0;
		for (int i1 = 0; i1 < var_7d3; i1++) {
			int n = m / j;
			var_7cb[i1] = ((short) n);
			k -= n;
			m += k / j;
		}
		var_7cb[(int) 'Â'] = 0; // 'Â´'
		var_7cb[270] = -1024;
	}

	public static final short sub_f9b(int paramInt) {
		paramInt %= 360;
		return var_7cb[paramInt];
	}

	public static final short sub_fc1(int paramInt) {
		paramInt = (paramInt + var_7e3) % 360;
		return var_7cb[paramInt];
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_a_000
 * 
 * JD-Core Version: 0.7.0.1
 */