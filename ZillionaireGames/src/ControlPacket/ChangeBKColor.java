package ControlPacket;


public class ChangeBKColor{
	 
public static final int FOREGROUND_BLUE=0x0001; // text color contains blue.
public static final int FOREGROUND_GREEN=0x0002; // text color contains green.
public static final int FOREGROUND_RED=0x0004; // text color contains red.
public static final int FOREGROUND_INTENSITY=0x0008; // text color is intensified.
public static final int BACKGROUND_BLUE=0x0010; // background color contains blue.
public static final int BACKGROUND_GREEN=0x0020; // background color contains green.
public static final int BACKGROUND_RED=0x0040;// background color contains red.
public static final int BACKGROUND_INTENSITY=0x0080; 
	public native void changeBKColor(int fColor,int bColor);
	private ChangeBKColor(){}
	private static ChangeBKColor instance;
	static{
		System.loadLibrary("ChangeBKColor");
		instance=new ChangeBKColor();
	}
	
	public static void changeColor(int fColor,int bColor){
			if(instance!=null){
					instance.changeBKColor(fColor,bColor);
				}
		}
	
}