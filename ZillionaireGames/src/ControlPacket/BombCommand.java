package ControlPacket;

import PlayerPacket.Player;
import PropPacket.Prop;

public class BombCommand extends Command {

	private int Step;
	private Prop Bomb;
	private Player player;
	
	public BombCommand(int Step, Player player){
		this.Step = Step;
		this.Bomb = new Prop(3);
		this.Bomb.SetSetupBy(player.GetID());
		player.UseProp(Bomb);
		this.player = player;
		//设置地图上的点显示bomb
	}
	
	@Override
	public void ActCommand() {
		if(player.GetID() != this.Bomb.getSetupBy()){
			player.SetStopTimes(3);//设置用户停留次数  可以在用户送去医院后设置
			//player.SetPosition();用户被放到医院这个点上
			this.Bomb.SetSetupBy(-1);
			//还需要恢复地图上那个原来存放block的点
		}
	}

}
