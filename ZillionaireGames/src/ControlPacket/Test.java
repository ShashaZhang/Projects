package ControlPacket;

import ControlPacket.ChangeBKColor;

public class Test{
	public static void main(String agrs[]){
			for(int i=0;i<10;i++)
				for(int j=0;j<10;j++){
						ChangeBKColor.changeColor(i,j);
						System.out.println("hello world");
					}
		}
	}