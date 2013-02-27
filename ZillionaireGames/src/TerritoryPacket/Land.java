package TerritoryPacket;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
public class Land extends TerritoryBsc{

    private int id;
    private int basePrice;//base Price
    private int ownBy;
    private int type;
    
    private final static int AREA = 0;
    private final static int COTTAGE = 1;
    private final static int HOUSE = 2;
    private final static int SKYSCRAPER = 3;

    public Land(int id, int basePrice, int type) {
        this.id = id;
        this.basePrice = basePrice;
        this.type = type;
    }

    public int GetBasePrice() {
        return basePrice;
    }
    public int GetType(){
        return type;
    }
    
    public void UpgradeType(){
    	this.type++;
    }
    public void SetType(int type){
    	this.type = type;
    }

    public int GetSellPrice(){
        return basePrice * (type + 1) * 2;
    }

    /*public void SetBasePrice(){
    	if(this.id >= 1 && this.id <= 13)
    		this.basePrice = 200;
    }*/
    
    public void setOwnBy(int ownBy) {
        this.ownBy = ownBy;
    }
    
    public static String CalculateFixedAssets(List<Land> LandList){
    	int AreaCount = 0;
    	int CottageCount = 0;
    	int HouseCount = 0;
    	int SkyscraperCount = 0;
    	for(int i = 0; i < LandList.size(); i++){
    		Land land = LandList.get(i);
    		switch(land.GetType()){
    		case AREA:
    			AreaCount++;
    			break;
    		case COTTAGE:
    			CottageCount++;
    			break;
    		case HOUSE:
    			HouseCount++;
    			break;
    		case SKYSCRAPER:
    			SkyscraperCount++;
    			break;
    		}
    	}
		return "地产：空地"+AreaCount+"处；"
                +"茅屋"+CottageCount+"处；"
                +"洋房"+HouseCount+"处；"
                +"摩天楼"+SkyscraperCount+"处。";
    }
    
    public static void ReturnFixedAssets(List<Land> LandList){
    	for(int i = 0; i < LandList.size(); i++){
    		Land land = LandList.get(i);
    		land.setOwnBy(-1);
    		land.SetType(AREA);
    	}
    }

}
