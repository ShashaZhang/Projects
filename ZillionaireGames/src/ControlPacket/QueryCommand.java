package ControlPacket;

import PlayerPacket.Player;

public class QueryCommand extends Command {

	private Player player;
	
	public QueryCommand(Player player){
		this.player = player;
	}
	
	@Override
	public void ActCommand() {
		System.out.println("显示自家资产信息：");
		System.out.println("资 金："+this.player.GetMoney()+"元 ");
		System.out.println("点 数："+this.player.GetPoint()+"点");
		System.out.println(this.player.GetFixedAssets());
		System.out.println(this.player.GetProp());
	}

}
