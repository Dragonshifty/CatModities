package Catmodities;

import java.util.LinkedHashMap;

abstract class Wholesaler {
	
	protected int fishHeadsStockLevel = 50;
	protected int fishyTreatsStockLevel = 30;
	protected int codStockLevel = 25;
	protected int salmonStockLevel = 25;
	protected int rainbowStockLevel = 10;
	
	protected int ashyTreatsStockLevel= 50;
	protected int yarnBallStockLevel = 40;
	protected int toyMouseStockLevel = 30;
	protected int scratchingPostStockLevel = 20;
	protected int fortressStockLevel = 10;
	
	protected int ashyTreatsTooStockLevel = 80;
	protected int randomMothStockLevel = 60;
	protected int dreamsiesStockLevel = 50;
	protected int catNipStockLevel = 50;
	protected int megaMunchiesStockLevel = 30;
	
	abstract void setPrices();
	abstract LinkedHashMap<String, Integer> getPrices();
	abstract void localCrash(boolean crash, double crashAmount);
	abstract void localPriceRise(boolean rise, double riseAmount);
	abstract int[] getArray();
	abstract void restock();
}
