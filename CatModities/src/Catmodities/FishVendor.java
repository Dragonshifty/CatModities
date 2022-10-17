package Catmodities;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

class FishVendor extends Wholesaler {
	private int fishHeads;
	private int fishyTreats;
	private int cod;
	private int salmonMousse;
	private int rainbowTrout;
		
	private int headsMin = 1;
	private int headsMax = 5;
	
	private int treatsMin = 5;
	private int treatsMax = 15;
	
	private int codMin = 40;
	private int codMax = 55;
	
	private int salmonMin = 75;
	private int salmonMax = 90;
	
	private int rainbowMin = 180;
	private int rainbowMax = 220;

	private boolean localCrashBool;
	private boolean localPriceRiseBool;
	
	private double localCrash = 0.2;
	private double localPriceRise = 0.2;
	
	private int[] fishArray = new int[5];
	
	private LinkedHashMap<String, Integer> fishPrices = new LinkedHashMap<String, Integer>();
	
	// Constructor
	FishVendor(){
		if (fishPrices.isEmpty()) {
		fishPrices.put("FishHeads", fishHeads);
		fishPrices.put("Fishy Treats", fishyTreats);
		fishPrices.put("Cod", cod);
		fishPrices.put("Salmon Mousse", salmonMousse);
		fishPrices.put("Rainbow Trout", rainbowTrout);	
		}
	}
	
	@Override
	protected void setPrices() {		
		// Apply random within range prices
		fishHeads = ThreadLocalRandom.current().nextInt(headsMin, headsMax + 1);
		fishyTreats = ThreadLocalRandom.current().nextInt(treatsMin, treatsMax + 1);
		cod = ThreadLocalRandom.current().nextInt(codMin, codMax + 1);
		salmonMousse = ThreadLocalRandom.current().nextInt(salmonMin, salmonMax + 1);
		rainbowTrout = ThreadLocalRandom.current().nextInt(rainbowMin, rainbowMax + 1);
		
		// Set to array
		fishArray[0] = fishHeads;
		fishArray[1] = fishyTreats;
		fishArray[2] = cod;
		fishArray[3] = salmonMousse;
		fishArray[4] = rainbowTrout;
		
		// Check for local price crashes/rises and apply to array elements
		if (localCrashBool) {
			for (int i = 0; i < fishArray.length; i++) {
				fishArray[i] -= fishArray[i] * localCrash;
				fishArray[i] = (fishArray[0] < 1) ? 1 : fishArray[i];
			}					
		} else if (localPriceRiseBool) {
			for (int i = 0; i < fishArray.length; i++) {
				fishArray[i] += fishArray[i] * localPriceRise;
			}
		}
		
		// Assign array to HashMap key/value pairs
		int local = 0;
		for (Entry<String, Integer> set : fishPrices.entrySet()) {
			set.setValue(fishArray[local++]);
		}		
	}
	
	@Override
	protected LinkedHashMap<String, Integer> getPrices() {
		return fishPrices;
	}
	
	@Override
	protected void localCrash(boolean fishCrash, double crashAmount) {
		this.localCrashBool = fishCrash;
		this.localCrash = crashAmount;
		setPrices();		
	}
	
	@Override
	protected void localPriceRise(boolean fishRise, double riseAmount) {
		this.localPriceRiseBool = fishRise;
		this.localPriceRise = riseAmount;
		setPrices();
	}

	@Override
	protected void restock(){
		fishHeadsStockLevel = 50;
		fishyTreatsStockLevel = 30;
		codStockLevel = 25;
		salmonStockLevel = 25;
		rainbowStockLevel = 10;
	}

	@Override int[] getArray(){
		return fishArray;
	}

}

