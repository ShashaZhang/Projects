package ControlPacket;

import PlayerPacket.Player;
import TerritoryPacket.Land;

public class SellCommand extends Command{

	private Land land;
	private Player player;
	
	public SellCommand(int houseID, Player player){
		this.player = player;
		//this.land = 通过地图类找到这块地
	}
	
	@Override
	public void ActCommand() {
		this.player.SellArea(land);
	}

}
