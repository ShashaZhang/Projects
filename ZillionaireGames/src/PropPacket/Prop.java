package PropPacket;

import java.util.List;

import TerritoryPacket.Land;

public class Prop {
	private static int ID;
	private static String Name;
	private int Point;
	private String Display;
	private int SetupBy = -1;
	
	private final static int ROADBLOCK = 1;
	private final static int ROBOTICDOLL = 2;
	private final static int BOMB = 3;
	
	public Prop(int ID){
		this.ID = ID;
		SetName();
		SetPoint();
		SetDisplay();
	}

	public int GetPoint() {
		return Point;
	}

	public int getID() {
		return ID;
	}

	public int getSetupBy() {
		return SetupBy;
	}

	public void SetSetupBy(int setupBy) {
		SetupBy = setupBy;
	}

	public String GetName() {
		return Name;
	}

	public static void SetName() {
		switch(ID){
		case ROADBLOCK:
			Name = "路障";
			break;
		case ROBOTICDOLL:
			Name = "机器娃娃";
			break;
		case BOMB:
			Name = "炸弹";
			break;
		}
	}

	public String GetDisplay() {
		return Display;
	}

	public void SetDisplay() {
		switch(ID){
		case ROADBLOCK:
			this.Name = "#";
			break;
		case ROBOTICDOLL:
			this.Name = "";
			break;
		case BOMB:
			this.Name = "@";
			break;
		}
	}
	
	public void SetPoint(){
		switch(ID){
		case ROADBLOCK:
			this.Point = 50;
			break;
		case ROBOTICDOLL:
			this.Point = 30;
			break;
		case BOMB:
			this.Point = 50;
			break;
		}
	}
	
	public static String CalculateProps(List<Prop> PropList){
		int RoadBlockCount = 0;
		int BombCount = 0;
		int RoboticDollCount = 0;
		
		for(int i = 0; i < PropList.size(); i++){
			Prop prop = PropList.get(i);
			switch(prop.ID){
			case ROADBLOCK:
				RoadBlockCount++;
				break;
			case ROBOTICDOLL:
				RoboticDollCount++;
				break;
			case BOMB:
				BombCount++;
				break;
			}
		}
		
		return "道具：路障"+RoadBlockCount+"个；"+
        "炸弹"+BombCount+"个；"+
        "机器娃娃"+RoboticDollCount+"个。";
	}

}
