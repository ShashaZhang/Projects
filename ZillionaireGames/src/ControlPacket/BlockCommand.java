package ControlPacket;

import PlayerPacket.Player;
import PropPacket.Prop;

public class BlockCommand extends Command {

	private int Step;
	private Prop RoadBlock;
	private Player player;
	
	public BlockCommand(int Step,Player player){
		this.Step = Step;
		this.RoadBlock = new Prop(1);
		this.player = player;
		this.RoadBlock.SetSetupBy(player.GetID());
		player.UseProp(RoadBlock);
		//block position = player.GetPosition() + Step; 替换地图上69个点中的一个
	}//使用Block
	
	//block生效 对其他玩家
	@Override
	public void ActCommand() {
		if(player.GetID() != this.RoadBlock.getSetupBy()){
			player.SetStopTimes(1);
			this.RoadBlock.SetSetupBy(-1);
			//还需要恢复地图上那个原来存放block的点
		}
	}

}
