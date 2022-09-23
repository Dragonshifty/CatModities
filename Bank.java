
import javafx.scene.control.*;


public class Bank {
    static int bankAccount = 1000;

    static void calculateBuy(int entered, int stockPrice, Label stockItem, String itemReference){
        
        int result = entered * stockPrice;
        bankAccount -= result;
 
        switch (itemReference){
            case "fh":
                Main.fishHeadsStockLevel += entered;
                Main.fishHeadsStock.setText("" + Main.fishHeadsStockLevel);
                break;
            case "ft":
                Main.fishyTreatsStockLevel += entered;
                Main.fishyTreatsStock.setText("" + Main.fishHeadsStockLevel);
                break;
            case "cd":
                Main.codStockLevel += entered;
                Main.codStock.setText("" + Main.codStockLevel);
                break;
            case "sm":
                Main.salmonStockLevel += entered;
                Main.salmonStock.setText("" + Main.salmonStockLevel);
                break;
            case "rt":
                Main.rainbowStockLevel += entered;
                Main.rainbowStock.setText("" + Main.rainbowStockLevel);
        }
    }

    static void calculateSell(int entered, int stockPrice, Label stockItem, String itemReference){

        bankAccount += entered * stockPrice;

        switch (itemReference){
            case "fh":
                Main.fishHeadsStockLevel -= entered;
                Main.fishHeadsStock.setText("" + Main.fishHeadsStockLevel);
                break;
            case "ft":
                Main.fishyTreatsStockLevel -= entered;
                Main.fishyTreatsStock.setText("" + Main.fishHeadsStockLevel);
                break;
            case "cd":
                Main.codStockLevel -= entered;
                Main.codStock.setText("" + Main.codStockLevel);
                break;
            case "sm":
                Main.salmonStockLevel -= entered;
                Main.salmonStock.setText("" + Main.salmonStockLevel);
                break;
            case "rt":
                Main.rainbowStockLevel -= entered;
                Main.rainbowStock.setText("" + Main.rainbowStockLevel);
        }
    }
}
