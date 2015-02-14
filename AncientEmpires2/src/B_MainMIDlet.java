import javax.microedition.midlet.MIDlet;

public class B_MainMIDlet extends MIDlet {
	
	public static B_MainMIDlet midlet;
	public static E_MainCanvas canvas;

	public final void startApp() {
		if (midlet == null) {
			midlet = this;
			canvas = new E_MainCanvas(this);
		}
	}

	public final void destroyApp(boolean inBool) {
		if (canvas != null) {
			canvas.stopGame();
		}
		canvas = null;
		midlet = null;
	}

	public final void pauseApp() {
		//
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_b_001
 * 
 * JD-Core Version: 0.7.0.1
 */