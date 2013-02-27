package ControlPacket;

public class QuitCommand extends Command{

	public QuitCommand(){}
	
	@Override
	public void ActCommand() {
		System.exit(-1);
	}
}
