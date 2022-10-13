package Catmodities;

import java.util.LinkedHashMap;

abstract class Wholesaler {
	
	protected int fishHeadsStockLevel = 100;
	protected int fishyTreatsStockLevel = 100;
	protected int codStockLevel = 80;
	protected int salmonStockLevel = 60;
	protected int rainbowStockLevel = 50;
	
	protected int ashyTreatsStockLevel= 100;
	protected int yarnBallStockLevel = 100;
	protected int toyMouseStockLevel = 50;
	protected int scratchingPostStockLevel = 30;
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
