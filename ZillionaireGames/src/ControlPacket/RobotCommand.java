package ControlPacket;

import PlayerPacket.Player;
import PropPacket.Prop;

public class RobotCommand extends Command {

	private Prop RoboticDoll;
	private Player player;
	
	public RobotCommand(Player player){
		this.RoboticDoll = new Prop(2);
		this.player = player;
		this.RoboticDoll.SetSetupBy(player.GetID());
		player.UseProp(RoboticDoll);
		this.ActCommand();
	}
	
	@Override
	public void ActCommand() {
		for(int i = 0; i <= 10; i++ ){
			int position = player.GetPosition() + i;
			//清除地图上10步内的路障、炸弹
		}
	}

}
