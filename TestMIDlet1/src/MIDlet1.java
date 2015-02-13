import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class MIDlet1 extends MIDlet {

	private C_MainCanvas canv = new C_MainCanvas();
	
	public MIDlet1() {
		// TODO Auto-generated constructor stub
		//System.out.println("My First MIDlet");
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub
		
	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		Display display = Display.getDisplay(this);
		display.setCurrent(canv);
	}

}

final class C_MainCanvas extends Canvas{

	protected void paint(Graphics arg0) {
		arg0.setColor(15991568);
		arg0.fillRect(0, 0, 100, 100);
		arg0.setColor(15256568);
		arg0.fillRect(100, 0, 100, 300);
	}
	
}
