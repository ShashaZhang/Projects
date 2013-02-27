package ControlPacket;

import PlayerPacket.Player;

public interface CommandFactory {
	public Command MakeCommand(String CommandStr,int parameter,Player player);
}
