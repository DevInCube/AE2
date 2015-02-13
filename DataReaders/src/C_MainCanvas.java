

public class C_MainCanvas {

	public static String streamToString(InputStream paramInputStream) {
		StringBuffer localStringBuffer = new StringBuffer();
		for (;;) {
			char c;
			try {
				c = (char) paramInputStream.read();
				if (c == 65535) {
					if (localStringBuffer.length() > 0) {
						String result = localStringBuffer.toString();
						return result;
					}
					return null;
				}
				if (c == '\n') {
					localStringBuffer.append(';');
				}
				if (c != '\r') {
					localStringBuffer.append(c);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static String[] splitStringByChar(String tilesPropString, char c) {
		String[] strs = tilesPropString.split(new String(new char[]{c}));
		return strs;
	}

}
