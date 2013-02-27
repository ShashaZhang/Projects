package ControlPacket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import PlayerPacket.Player;
import TerritoryPacket.Land;

public class Controller implements Runnable {

	private static int RollPoint;
	private List<Player> PlayerList;
	
	public void SetupGame(int moneyOriginal){
		if(moneyOriginal >= 1000 && moneyOriginal <= 50000)
			Player.setMoneyOriginal(moneyOriginal);
	}
	public void WhetherEndGame(){
		if(PlayerList.size() == 1){
			System.out.println(PlayerList.get(0).GetName()+"获胜");
			System.exit(-1);
		}else{
			for(int i = 0; i < PlayerList.size(); i++){
				Player temp = PlayerList.get(i);
				if(temp.GetMoney() < 0){
					Land.ReturnFixedAssets(temp.GetLandList());
				}
			}
		}
	}
	
	@Override
	public void run() {
		System.out.println("设置玩家初始资金，范围1000~50000");
		
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader bufin = new BufferedReader(stdin);
	}

	public static int getRollPoint() {
		return RollPoint;
	}

	public static void setRollPoint(int rollPoint) {
		RollPoint = rollPoint;
	}

}
