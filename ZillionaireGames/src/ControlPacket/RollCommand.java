package ControlPacket;

import PlayerPacket.Player;

public class RollCommand extends Command {

	private Player player;
	
	public RollCommand(Player player){
		this.player = player;
	}
	
	@Override
	public void ActCommand() {
		if(player.GetStopTimes() == 0){
			int RollPoint = (int)(Math.random()*6 + 1);
			Controller.setRollPoint(RollPoint);
		}else{
			int StopTime = player.GetStopTimes();
			player.SetStopTimes(StopTime - 1);
		}
	}

}
