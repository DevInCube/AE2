
public class PakReader {

	private String[] resourceNames;
	private byte[][] resourceData;

	public void read(InputStream localInputStream) throws IOException {
		int[] arrayOfInt1 = null;
		int[] resourceLength = null;
		DataInputStream localDataInputStream = new DataInputStream(localInputStream);
		short i = localDataInputStream.readShort();
		int resCount = localDataInputStream.readShort();
		resourceNames = new String[resCount];
		arrayOfInt1 = new int[resCount];
		resourceLength = new int[resCount];
		for (int k = 0; k < resCount; k++) {
			resourceNames[k] = localDataInputStream.readUTF();
			arrayOfInt1[k] = (localDataInputStream.readInt() + i);
			resourceLength[k] = localDataInputStream.readShort();
		}
		resourceData = new byte[resourceNames.length][];
		for (int m = 0; m < resourceNames.length; m++) {
			resourceData[m] = new byte[resourceLength[m]];
			localDataInputStream.readFully(resourceData[m]);
		}
		localDataInputStream.close();
	}

	public void write(String dir) throws IOException {
		for (int i = 0; i < resourceNames.length; i++) {
			FileOutputStream fos = new FileOutputStream(dir + resourceNames[i]);
			fos.write(resourceData[i]);
			fos.close();
		}
	}

}
