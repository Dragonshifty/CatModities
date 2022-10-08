package Catmodities;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

class TreatVendor extends Wholesaler {
	private int ashyTreats;
	private int fishyTreats;
	private int dreamsies;
	private int catNip;
	private int megaMunchies;
		
	private int ashyMin = 2;
	private int ashyMax = 5;
	
	private int headsMin = 2;
	private int headsMax = 5;
	
	private int dreamMin = 5;
	private int dreamMax = 10;
	
	private int nipMin = 20;
	private int nipMax = 30;
	
	private int megaMin = 30;
	private int megaMax = 40;
	
	private boolean localCrashBool;
	private boolean localPriceRiseBool;
	
	private double localCrash = 0.2;
	private double localPriceRise = 0.2;
	
	private int[] treatArray = new int[5];
	
	private LinkedHashMap<String, Integer> treatPrices = new LinkedHashMap<String, Integer>();
	
	// Constructor
	TreatVendor(){	
		if (treatPrices.isEmpty()) {
		treatPrices.put("Ashy Treats", ashyTreats);
		treatPrices.put("Fishy Treats", fishyTreats);
		treatPrices.put("Dreamsies", dreamsies);
		treatPrices.put("Cat Nip", catNip);
		treatPrices.put("Mega Munchies", megaMunchies);		
		}
	}
	
	@Override
	protected void setPrices() {		
		// Apply random within range prices
		ashyTreats = ThreadLocalRandom.current().nextInt(ashyMin, ashyMax + 1);
		fishyTreats = ThreadLocalRandom.current().nextInt(headsMin, headsMax + 1);
		dreamsies = ThreadLocalRandom.current().nextInt(dreamMin, dreamMax + 1);
		catNip = ThreadLocalRandom.current().nextInt(nipMin, nipMax + 1);
		megaMunchies = ThreadLocalRandom.current().nextInt(megaMin, megaMax + 1);
		
		// Set to array
		treatArray[0] = ashyTreats;
		treatArray[1] = fishyTreats;
		treatArray[2] = dreamsies;
		treatArray[3] = catNip;
		treatArray[4] = megaMunchies;
		
		// Check for local price crashes/rises and apply to array elements
		if (localCrashBool) {
			for (int i = 0; i < treatArray.length; i++) {
				treatArray[i] -= treatArray[i] * localCrash;
			}					
		} else if (localPriceRiseBool) {
			for (int i = 0; i < treatArray.length; i++) {
				treatArray[i] += treatArray[i] * localPriceRise;
			}
		}
		
		// reset price/crash booleans
		localPriceRiseBool = false;
		localCrashBool = false;
		
		// Assign array to HashMap key/value pairs
		int local = 0;
		for (Entry<String, Integer> set : treatPrices.entrySet()) {
			set.setValue(treatArray[local]);
			local++;
		}		
	}
	
	@Override
	protected LinkedHashMap<String, Integer> getPrices() {
		return treatPrices;
	}
	
	@Override
	protected void localCrash(boolean treatCrash, double crashAmount) {
		this.localCrashBool = treatCrash;
		this.localCrash = crashAmount;
//		System.out.println(treatPrices);
		setPrices();		
	}
	
	@Override
	protected void localPriceRise(boolean treatRise, double riseAmount) {
		this.localPriceRiseBool = treatRise;
		this.localPriceRise = riseAmount;
//		System.out.println(treatPrices);
		setPrices();
	}
}

