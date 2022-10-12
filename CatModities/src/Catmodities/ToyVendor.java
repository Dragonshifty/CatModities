package Catmodities;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

class ToyVendor extends Wholesaler {
	private int ashyTreats;
	private int yarnBall;
	private int toyMouse;
	private int scratchingPost;
	private int fortress;
		
	private int ashyMin = 2;
	private int ashyMax = 5;
	
	private int yarnMin = 2;
	private int yarnMax = 5;
	
	private int mouseMin = 5;
	private int mouseMax = 10;
	
	private int scratchMin = 20;
	private int scratchMax = 30;
	
	private int fortressMin = 30;
	private int fortressMax = 40;
	
	private boolean localCrashBool;
	private boolean localPriceRiseBool;
	
	private double localCrash = 0.2;
	private double localPriceRise = 0.2;
	
	private int[] toyArray = new int[5];
	
	private LinkedHashMap<String, Integer> toyPrices = new LinkedHashMap<String, Integer>();
	
	// Constructor
	ToyVendor(){	
		if (toyPrices.isEmpty()) {
		toyPrices.put("Ashy Treats", ashyTreats);
		toyPrices.put("Yarn Ball", yarnBall);
		toyPrices.put("Toy Mouse", toyMouse);
		toyPrices.put("Scratching Post", scratchingPost);
		toyPrices.put("Fortress", fortress);	
		}
	}
	
	@Override
	protected void setPrices() {		
		// Apply random within range prices
		ashyTreats = ThreadLocalRandom.current().nextInt(ashyMin, ashyMax + 1);
		yarnBall = ThreadLocalRandom.current().nextInt(yarnMin, yarnMax + 1);
		toyMouse = ThreadLocalRandom.current().nextInt(mouseMin, mouseMax + 1);
		scratchingPost = ThreadLocalRandom.current().nextInt(scratchMin, scratchMax + 1);
		fortress = ThreadLocalRandom.current().nextInt(fortressMin, fortressMax + 1);
		
		// Set to array
		toyArray[0] = ashyTreats;
		toyArray[1] = yarnBall;
		toyArray[2] = toyMouse;
		toyArray[3] = scratchingPost;
		toyArray[4] = fortress;
		
		// Check for local price crashes/rises and apply to array elements
		if (localCrashBool) {
			for (int i = 0; i < toyArray.length; i++) {
				toyArray[i] -= toyArray[i] * localCrash;
			}					
		} else if (localPriceRiseBool) {
			for (int i = 0; i < toyArray.length; i++) {
				toyArray[i] += toyArray[i] * localPriceRise;
			}
		}
		
		// reset price/crash booleans
		localPriceRiseBool = false;
		localCrashBool = false;
		
		// Assign array to HashMap key/value pairs
		int local = 0;
		for (Entry<String, Integer> set : toyPrices.entrySet()) {
			set.setValue(toyArray[local]);
			local++;
		}		
	}
	
	@Override
	protected LinkedHashMap<String, Integer> getPrices() {
		return toyPrices;
	}
	
	@Override
	protected void localCrash(boolean toyCrash, double crashAmount) {
		this.localCrashBool = toyCrash;
		this.localCrash = crashAmount;
		setPrices();		
	}
	
	@Override
	protected void localPriceRise(boolean toyRise, double riseAmount) {
		this.localPriceRiseBool = toyRise;
		this.localPriceRise = riseAmount;
		setPrices();
	}

	@Override
	protected void restock(){
		ashyTreatsStockLevel= 100;
		yarnBallStockLevel = 100;
		toyMouseStockLevel = 50;
		scratchingPostStockLevel = 30;
		fortressStockLevel = 10;
	}
}

