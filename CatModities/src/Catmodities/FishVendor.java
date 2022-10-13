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
		
	private int headsMin = 2;
	private int headsMax = 5;
	
	private int treatsMin = 3;
	private int treatsMax = 7;
	
	private int codMin = 5;
	private int codMax = 10;
	
	private int salmonMin = 20;
	private int salmonMax = 30;
	
	private int rainbowMin = 30;
	private int rainbowMax = 40;

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
//		System.out.println(fishPrices);
		setPrices();		
	}
	
	@Override
	protected void localPriceRise(boolean fishRise, double riseAmount) {
		this.localPriceRiseBool = fishRise;
		this.localPriceRise = riseAmount;
//		System.out.println(fishPrices);
		setPrices();
	}

	@Override
	protected void restock(){
		fishHeadsStockLevel = 100;
		fishyTreatsStockLevel = 100;
		codStockLevel = 80;
		salmonStockLevel = 60;
		rainbowStockLevel = 50;
	}

	@Override int[] getArray(){
		return fishArray;
	}

}

