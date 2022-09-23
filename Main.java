import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.geometry.*;
// import javafx.beans.value.ChangeListener;
// import javafx.beans.value.ObservableValue;

import java.util.LinkedHashMap;

public class Main extends Application {

    Stage window;
    static LinkedHashMap <String, Integer> fishPrices =  new LinkedHashMap<>();
    public static GridPane grid;
    static Label showBalance;
    static Label fishHeadsStock;
    static Label fishyTreatsStock;
    static Label codStock;
    static Label salmonStock;
    static Label rainbowStock;
    
    static int fishHeadsStockLevel;
    static int fishyTreatsStockLevel;
    static int codStockLevel;
    static int salmonStockLevel;
    static int rainbowStockLevel;

    String refFishHeads = "fh";
    String refFishyTreats = "ft";
    String refCod = "cd";
    String refSalmon = "sm";
    String refRainbow = "rt";


    public void reset(FishVendor fish, Label fishyTreatsPrice, Label fhp, Label cp, Label sp, Label rp){
        fish.setPrices();
        fishPrices = fish.getPrices();
        fhp.setText(""+ fishPrices.get("FishHeads"));
        fishyTreatsPrice.setText("" + fishPrices.get("Fishy Treats"));
        cp.setText("" + fishPrices.get("Cod"));
        sp.setText("" + fishPrices.get("Salmon Mousse"));
        rp.setText("" + fishPrices.get("Rainbow Trout"));
    }

    public static void main (String[] args){
        launch(args);
    }

    @Override 
    public void start(Stage primaryStage) throws Exception{
        FishVendor fish = new FishVendor();
        fish.setPrices();
        Main mn = new Main();
        fishPrices = fish.getPrices();

        window = primaryStage;
        window.setTitle("CatModities");

        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label fishHeads = new Label("Fishheads");
        GridPane.setConstraints(fishHeads, 0, 0);
        Label fishHeadsPrice = new Label(""+ fishPrices.get("FishHeads"));
        GridPane.setConstraints(fishHeadsPrice, 1, 0);
        Button headsBuy = new Button("Buy");
        GridPane.setConstraints(headsBuy, 0, 1);
        Button headsSell = new Button("Sell");
        GridPane.setConstraints(headsSell, 1, 1);

        
        fishHeadsStock = new Label("" + fishHeadsStockLevel);
        GridPane.setConstraints(fishHeadsStock,  1, 2);

        Label fishyTreats = new Label("Fishy Treats");
        GridPane.setConstraints(fishyTreats, 2, 0);
        Label fishyTreatsPrice = new Label("" + fishPrices.get("Fishy Treats"));
        GridPane.setConstraints(fishyTreatsPrice, 3, 0);
        Button fTreatsBuy = new Button("Buy");
        GridPane.setConstraints(fTreatsBuy, 2, 1);
        Button fTreatsSell = new Button("Sell");
        GridPane.setConstraints(fTreatsSell, 3, 1);

        fishyTreatsStock = new Label("" + fishyTreatsStockLevel);
        GridPane.setConstraints(fishyTreatsStock,  3, 2);

        Label cod = new Label("Cod");
        GridPane.setConstraints(cod, 4, 0);
        Label codPrice = new Label("" + fishPrices.get("Cod"));
        GridPane.setConstraints(codPrice, 5, 0);
        Button codBuy = new Button("Buy");
        GridPane.setConstraints(codBuy, 4, 1);
        Button codSell = new Button("Sell");
        GridPane.setConstraints(codSell, 5, 1);

        codStock = new Label("" + codStockLevel);
        GridPane.setConstraints(codStock,  5, 2);

        Label salmon = new Label("Salmon Mousse");
        GridPane.setConstraints(salmon, 6, 0);
        Label salmonPrice = new Label("" + fishPrices.get("Salmon Mousse"));
        GridPane.setConstraints(salmonPrice, 7, 0);
        Button salmonBuy = new Button("Buy");
        GridPane.setConstraints(salmonBuy, 6, 1);
        Button salmonSell = new Button("Sell");
        GridPane.setConstraints(salmonSell, 7, 1);

        salmonStock = new Label("" + salmonStockLevel);
        GridPane.setConstraints(salmonStock,  7, 2);

        Label rainbow = new Label("Rainbow Trout");
        GridPane.setConstraints(rainbow, 8, 0);
        Label rainbowPrice = new Label("" + fishPrices.get("Rainbow Trout"));
        GridPane.setConstraints(rainbowPrice, 9, 0);
        Button rainbowBuy = new Button("Buy");
        GridPane.setConstraints(rainbowBuy, 8, 1);
        Button rainbowSell = new Button("Sell");
        GridPane.setConstraints(rainbowSell, 9, 1);

        rainbowStock = new Label("" + rainbowStockLevel);
        GridPane.setConstraints(rainbowStock,  9, 2);

        Button resetPrices = new Button("Reset Prices");
        GridPane.setConstraints(resetPrices, 8, 5);

        Label bankBalance = new Label("Bank Balance");
        bankBalance.setId("bankbalance");
        GridPane.setConstraints(bankBalance, 0, 5);
        showBalance = new Label("1000");
        showBalance.setId("showbalance");
        GridPane.setConstraints(showBalance, 1, 5);

        for (int i = 0, j = 0; i < 5; i++,  j+=2) {
            Label label = new Label("Stock");
            GridPane.setConstraints(label, j, 2);
            label.setId("stocklabel");
            grid.getChildren().add(label);
        }

        Button priceCrashLabel = new Button("Crash");
        GridPane.setConstraints(priceCrashLabel, 3, 5);

        Button priceRiseLabel = new Button("Price Rise");
        GridPane.setConstraints(priceRiseLabel, 5, 5);

        grid.getChildren().addAll(fishHeads, fishHeadsPrice, headsBuy, headsSell, fishyTreats, fishyTreatsPrice, fTreatsBuy, fTreatsSell, cod, codPrice, codBuy, codSell, salmon, salmonPrice, salmonBuy, salmonSell, rainbow, rainbowPrice, rainbowBuy, rainbowSell, resetPrices, bankBalance, showBalance, fishHeadsStock, fishyTreatsStock, codStock, salmonStock, rainbowStock, priceCrashLabel, priceRiseLabel);
       
        Scene scene1 = new Scene(grid, 1100, 650);
        scene1.getStylesheets().add("style.css");
        window.setScene(scene1);

        window.show();
        
        headsBuy.setOnAction(e -> {
            BuyBox.buy(fishPrices.get("FishHeads"), fishHeadsStock, refFishHeads);
            showBalance.setText("" + Bank.bankAccount);
        });

        headsSell.setOnAction(e -> {
            SellBox.sell(fishPrices.get("FishHeads"), fishHeadsStock, refFishHeads);
            showBalance.setText("" + Bank.bankAccount);
        });

        fTreatsBuy.setOnAction(e -> {
            BuyBox.buy(fishPrices.get("Fishy Treats"), fishyTreatsStock, refFishyTreats);
            showBalance.setText("" + Bank.bankAccount);
        });

        fTreatsSell.setOnAction(e -> {
            SellBox.sell(fishPrices.get("Fishy Treats"), fishyTreatsStock, refFishyTreats);
            showBalance.setText("" + Bank.bankAccount);
        });

        codBuy.setOnAction(e -> {
            BuyBox.buy(fishPrices.get("Cod"), codStock, refCod);
            showBalance.setText("" + Bank.bankAccount);
        });

        codSell.setOnAction(e -> {
            SellBox.sell(fishPrices.get("Cod"), codStock, refCod);
            showBalance.setText("" + Bank.bankAccount);
        });

        salmonBuy.setOnAction(e -> {
            BuyBox.buy(fishPrices.get("Salmon Mousse"), salmonStock, refSalmon);
            showBalance.setText("" + Bank.bankAccount);
        });

        salmonSell.setOnAction(e -> {
            SellBox.sell(fishPrices.get("Salmon Mousse"), salmonStock, refSalmon);
            showBalance.setText("" + Bank.bankAccount);
        });

        rainbowBuy.setOnAction(e -> {
            BuyBox.buy(fishPrices.get("Rainbow Trout"), rainbowStock, refRainbow);
            showBalance.setText("" + Bank.bankAccount);
        });

        rainbowSell.setOnAction(e -> {
            SellBox.sell(fishPrices.get("Rainbow Trout"), rainbowStock, refRainbow);
            showBalance.setText("" + Bank.bankAccount);
        });

        priceCrashLabel.setOnAction(e -> {
            fish.localCrash(true, 0.2);
            // fishPrices = fish.getPrices();
            mn.reset(fish, fishyTreatsPrice, fishHeadsPrice, codPrice, salmonPrice, rainbowPrice);
        });

        priceRiseLabel.setOnAction(e -> {
            fish.localPriceRise(true, 0.2);
            // fishPrices = fish.getPrices();
            mn.reset(fish, fishyTreatsPrice, fishHeadsPrice, codPrice, salmonPrice, rainbowPrice);
        });

        resetPrices.setOnAction(e -> {
            mn.reset(fish, fishyTreatsPrice, fishHeadsPrice, codPrice, salmonPrice, rainbowPrice);
        });

    }

}