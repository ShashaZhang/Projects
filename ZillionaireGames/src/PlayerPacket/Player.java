package PlayerPacket;

import java.util.List;

import PropPacket.Prop;
import TerritoryPacket.Land;

public class Player {

	private static final int MAXAMOUNTBEFOREBUYPROP = 9;
	private static int MoneyOriginal = 10000;
	private int ID;
	private String Name;
	private int Money;
	private int Point;
	private boolean Billiken;
	private int BillikenUseTime;
	private int StopTimes;
	private int Position;
	
	private List<Land> LandList;
	private List<Prop> PropList;

	
	public Player(int id, String name) {
		this.ID = id;
		this.Name = name;
		this.Money = MoneyOriginal;
		this.Point = 0;
		this.SetStopTimes(0);
	}
	
	public List<Land> GetLandList(){
		return this.LandList;
	}

	public int GetID(){
		return this.ID;
	}
	
	public String GetName() {
		return this.Name;
	}

	public void SetName(String name) {
		this.Name = name;
	}
	
	public void SetMoney(int Money){
		this.Money = Money;
	}

	public int GetMoney() {
		return Money;
	}

	public int GetPoint() {
		return this.Point;
	}
	
    public String GetFixedAssets() {
        return Land.CalculateFixedAssets(this.LandList);
    }

    public String GetProp() {
        return Prop.CalculateProps(PropList);
    }



    public void AddPoint(int point) {
		this.Point += point;
	}

	public void BuyArea(Land land) {
		if(this.Money >= land.GetBasePrice()){
			this.Money -= land.GetBasePrice();
			land.setOwnBy(this.ID);
			LandList.add(land);
		}
	}

	public void UpdateArea(Land land) {
		if(this.Money >= land.GetBasePrice() ){
			this.Money -= land.GetBasePrice();
			land.UpgradeType();
		}
	}

	private boolean CanSell(int count){
		if(count >= 1 )
			return true;
		else
			return false;
	}
	
	public void SellArea(Land land) {
		try{
			this.LandList.remove(land);
			
		}
		catch(Exception e){
			System.out.println("不能卖该房产");
			return;
		}
		this.Money += land.GetSellPrice();
		land.setOwnBy(-1);
		land.SetType(0);
	}

	public void SellProp(Prop prop){
		if(CheckPropCanBuy()){
			try{
				PropList.remove(prop);
			}
			catch(Exception e){
				System.out.println("不能卖该道具");
				return;
			}
			this.Point = prop.GetPoint();
		}
	}

	private boolean CheckPropCanBuy() {
		return this.PropList.size() <= MAXAMOUNTBEFOREBUYPROP;
	}
	
	public void BuyProp(Prop prop) {
		if(CheckPropCanBuy() && this.Point >= prop.GetPoint()){
			this.Point -= prop.GetPoint();
			this.PropList.add(prop);
		}
	}
	
	public void UseProp(Prop p){
		try{
			this.PropList.remove(p);
		}catch(Exception e){
			System.out.println("没有该道具，无法使用");
			return;
		}
	}
	
	public static void setMoneyOriginal(int moneyOriginal) {
		MoneyOriginal = moneyOriginal;
	}

	public int GetStopTimes() {
		return StopTimes;
	}

	public void SetStopTimes(int stopTimes) {
		StopTimes = stopTimes;
	}

	public int GetPosition() {
		return Position;
	}

	public void SetPosition(int position) {
		Position = position;
	}

	public boolean GetBilliken() {
		return Billiken;
	}

	public void SetBilliken(boolean billiken) {
		Billiken = billiken;
	}

	public int GetBillikenUseTime() {
		return BillikenUseTime;
	}

	public void SetBillikenUseTime(int billikenUseTime) {
		BillikenUseTime = billikenUseTime;
	}

}
