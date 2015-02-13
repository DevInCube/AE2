import javax.microedition.midlet.MIDlet;

public class Class_b_001 extends MIDlet {
	
	public static Class_b_001 var_101;
	public static Class_e_034 var_109;

	public final void startApp() {
		if (var_101 == null) {
			var_101 = this;
			var_109 = new Class_e_034(this);
		}
	}

	public final void destroyApp(boolean paramBoolean) {
		if (var_109 != null) {
			var_109.sub_2148();
		}
		var_109 = null;
		var_101 = null;
	}

	public final void pauseApp() {
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob2\
 * 
 * Qualified Name: Class_b_001
 * 
 * JD-Core Version: 0.7.0.1
 */