
public class A_Unit {
	
	private byte uType;
	private byte uTeam;
	private int uPosX;
	private int uPosY;

	public A_Unit(byte uType, byte uTeam, int uPosX, int uPosY){
		this.uType = uType;
		this.uTeam = uTeam;
		this.uPosX = uPosX;
		this.uPosY = uPosY;
	}

	public static A_Unit createUnit(byte uType, byte uTeam, int uPosX, int uPosY) {
		// TODO Auto-generated method stub
		return new A_Unit(uType, uTeam,  uPosX,  uPosY);
	}

}
