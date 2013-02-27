package ControlPacket;

import PlayerPacket.Player;

public class CommandFactoryImpl implements CommandFactory {

	private final static String ROLL = "ROLL";
	private final static String BLOCK = "BLOCK";
	private final static String BOMB = "BOMB";
	private final static String ROBOT = "ROBOT";
	private final static String SELL = "SELL";
	private final static String SELLTOOL = "SELLTOOL";
	private final static String QUERY = "QUERY";
	private final static String HELP = "HELP";
	private final static String QUIT = "QUIT";
	
	@Override
	public Command MakeCommand(String CommandStr,int parameter,Player player) {
		String command = CommandStr.toUpperCase();
		if(command.equals(ROLL))
			return new RollCommand(player);
		else if(command.equals(BLOCK))
			return new BlockCommand(parameter,player);
		else if(command.equals(BOMB))
			return new BombCommand(parameter,player);
		else if(command.equals(ROBOT))
			return new RobotCommand(player);
		else if(command.equals(SELL))
			return new SellCommand(parameter,player);
		else if(command.equals(SELLTOOL))
			return new SellToolCommand(parameter,player);
		else if(command.equals(QUERY))
			return new QueryCommand(player);
		else if(command.equals(HELP))
			return new HelpCommand();
		else if(command.endsWith(QUIT))
			return new QuitCommand();
		else
			return null;
	}

}
