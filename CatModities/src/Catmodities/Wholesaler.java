package Catmodities;

import java.util.LinkedHashMap;

abstract class Wholesaler {
	
	protected int fishHeadsStockLevel = 500;
	protected int fishyTreatsStockLevel = 500;
	protected int codStockLevel = 500;
	protected int salmonStockLevel = 500;
	protected int rainbowStockLevel = 500;
	
	protected int ashyTreatsStockLevel= 500;
	protected int yarnBallStockLevel = 500;
	protected int toyMouseStockLevel = 500;
	protected int scratchingPostStockLevel = 500;
	protected int fortressStockLevel = 500;
	
	protected int dreamsiesStockLevel = 500;
	protected int catNipStockLevel = 500;
	protected int megaMunchiesStockLevel = 500;
	
	abstract void setPrices();
	abstract LinkedHashMap<String, Integer> getPrices();
	abstract void localCrash(boolean crash, double crashAmount);
	abstract void localPriceRise(boolean rise, double riseAmount);
}
