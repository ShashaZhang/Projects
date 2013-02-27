package ControlPacket;

import PlayerPacket.Player;
import PropPacket.Prop;

public class SellToolCommand extends Command {

	private Prop prop;
	private Player player;
	
	public SellToolCommand(int ID, Player player){
		prop = new Prop(ID);
		this.player = player;
	}
	@Override
	public void ActCommand() {
		player.SellProp(prop);
	}

}
