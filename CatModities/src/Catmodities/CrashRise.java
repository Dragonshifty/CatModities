package Catmodities;

import java.util.Random;

public class CrashRise {
    
    void resetCrashRise(Wholesaler fish, Wholesaler toy, Wholesaler treat){
        fish.localCrash(false, 0.0);
           fish.localPriceRise(false, 0.0);
           toy.localCrash(false, 0.0);
           toy.localPriceRise(false, 0.0);
           treat.localCrash(false, 0.0);
           treat.localPriceRise(false, 0.0);
     }

     String runCrashRiseChance(Wholesaler fish, Wholesaler toy, Wholesaler treat){
        Random random = new Random();
        int chance = random.nextInt(4);
        int vendor = random.nextInt(3);
        int riseFall = random.nextInt(2);
        String messageHold = "";
            if (chance == 3){
                switch (vendor){
                    case 0:
                        if (riseFall == 0){
                            fish.localCrash(true, 0.2);
                            messageHold = "Fish CRASH!";
                        } else {
                            fish.localPriceRise(true, 0.2);
                            messageHold = "Fish RISE!";
                        }
                        break;
                    case 1:
                        if (riseFall == 0){
                            toy.localCrash(true, 0.2);
                            messageHold = "Toy CRASH!";
                        } else {
                            toy.localPriceRise(true, 0.2);
                            messageHold = "Toy RISE!";
                        }
                        break;
                    case 2:
                        if (riseFall == 0){
                            treat.localCrash(true, 0.2);
                            messageHold = "Treat CRASH!";
                        } else {
                            treat.localPriceRise(true, 0.2);
                            messageHold = "Treat RISE!";
                        }
                        break;
                }
            }
            return messageHold;
     }
}
