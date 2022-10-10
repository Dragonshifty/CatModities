package Catmodities;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import org.json.simple.JSONObject;

import java.sql.DriverManager;
import java.util.LinkedHashMap;
// import java.io.FileWriter;
// import java.io.IOException;

public class App extends Application {

   Stage window;

   LinkedHashMap <String, Integer> fishPrices = new LinkedHashMap<>();
   LinkedHashMap <String, Integer> toyPrices = new LinkedHashMap<>();
   LinkedHashMap <String, Integer> treatPrices = new LinkedHashMap<>();

    public static void main(String[] args) {
      
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
      
      // Instantiate Vendors
      Wholesaler fish = new FishVendor();
      Wholesaler toy = new ToyVendor();
      Wholesaler treat = new TreatVendor();

      // Set vendor prices
      fish.setPrices();
      toy.setPrices();
      treat.setPrices();

      // Get vendor prices and assign to LinkedHashMap
      fishPrices = fish.getPrices();
      toyPrices = toy.getPrices();
      treatPrices = treat.getPrices();

      // Instantiate bank and personal warehouse stock
      Bank bank = new Bank();
      Warehouse warehouse = new Warehouse();
      
      // Set window
      window = primaryStage;
      window.setTitle("CatModities");

      GridPane grid = new GridPane();
      GridPane gridTop = new GridPane();

      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(8);
      grid.setHgap(10);
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(40));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(40));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(40));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(40));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(40));
      // grid.setGridLinesVisible(true);


      Text text = new Text("CatModities");
      Font font = Font.loadFont("file:/3Dumb.ttf", 45);
      text.setFont(font);
      GridPane.setConstraints(text, 0, 0);


      // Label title = new Label("CatModities");
      // GridPane.setConstraints(title, 0, 0);

      Label day = new Label("Monday");
      GridPane.setConstraints(day, 0, 1);

      Label message = new Label("Message Board");
      GridPane.setConstraints(message, 1, 1);

      Label marketStatus = new Label("Normal/Crash/Rise");
      GridPane.setConstraints(marketStatus, 3, 1);

      gridTop.getChildren().addAll(text, day, message, marketStatus);

      // Fish Vendor Labels and Buttons
      Label fishVendorTitle = new Label("Vish Vendor");
      GridPane.setConstraints(fishVendorTitle, 0, 2);
      fishVendorTitle.setId("vendortitle");

      Label fishHeadsLabel = new Label("Fish Heads");
      GridPane.setConstraints(fishHeadsLabel, 0, 3);
      Label fishHeadsPrice = new Label(""+ fishPrices.get("FishHeads"));
      GridPane.setConstraints(fishHeadsPrice, 1, 3);
      Button headsBuyButton = new Button("Buy");
      GridPane.setConstraints(headsBuyButton, 0, 4);
      Button headsSellButton = new Button("Sell");
      GridPane.setConstraints(headsSellButton, 1, 4);
      Label wholesalerFishHeads = new Label("" + fish.fishHeadsStockLevel);
      GridPane.setConstraints(wholesalerFishHeads, 0, 5);
      Label warehouseFishHeads = new Label("" + warehouse.getFishHeadsStock());
      GridPane.setConstraints(warehouseFishHeads, 1, 5);

      grid.getChildren().addAll(fishVendorTitle, fishHeadsLabel, fishHeadsPrice, 
      headsBuyButton, headsSellButton, wholesalerFishHeads, warehouseFishHeads);

      Label fishyTreats = new Label("Fishy Treats");
      GridPane.setConstraints(fishyTreats, 2, 3);
      Label fishyTreatsPrice = new Label("" + fishPrices.get("Fishy Treats"));
      GridPane.setConstraints(fishyTreatsPrice, 3, 3);
      Button fishyTreatsBuy = new Button("Buy");
      GridPane.setConstraints(fishyTreatsBuy, 2, 4);
      Button fishyTreatsSell = new Button("Sell");
      GridPane.setConstraints(fishyTreatsSell, 3, 4);
      Label wholesalerFishyTreats = new Label("" + fish.fishyTreatsStockLevel);
      GridPane.setConstraints(wholesalerFishyTreats, 2, 5);
      Label warehouseFishyTreats = new Label("" + warehouse.getFishyTreatsStock());
      GridPane.setConstraints(warehouseFishyTreats, 3, 5);

      grid.getChildren().addAll(fishyTreats, fishyTreatsPrice, fishyTreatsBuy, fishyTreatsSell,
      wholesalerFishyTreats, warehouseFishyTreats);

      Label cod = new Label("Cod");
      GridPane.setConstraints(cod, 4, 3);
      Label codPrice = new Label("" + fishPrices.get("Cod"));
      GridPane.setConstraints(codPrice, 5, 3);
      Button codBuy = new Button("Buy");
      GridPane.setConstraints(codBuy, 4, 4);
      Button codSell = new Button("Sell");
      GridPane.setConstraints(codSell, 5, 4);
      Label wholesalerCod = new Label("" + fish.codStockLevel);
      GridPane.setConstraints(wholesalerCod, 4, 5);
      Label warehouseCod = new Label("" + warehouse.getWareHouseCodStock());
      GridPane.setConstraints(warehouseCod, 5, 5);

      grid.getChildren().addAll(cod, codPrice, codBuy, codSell, wholesalerCod, warehouseCod);

      Label salmon = new Label("Salmon Mousse");
      GridPane.setConstraints(salmon, 6, 3);
      Label salmonPrice = new Label("" + fishPrices.get("Salmon Mousse"));
      GridPane.setConstraints(salmonPrice, 7, 3);
      Button salmonBuy = new Button("Buy");
      GridPane.setConstraints(salmonBuy, 6, 4);
      Button salmonSell = new Button("Sell");
      GridPane.setConstraints(salmonSell, 7, 4);
      Label wholesalerSalmon = new Label("" + fish.salmonStockLevel);
      GridPane.setConstraints(wholesalerSalmon, 6, 5);
      Label warehouseSalmon = new Label("" + warehouse.getSalmonStock());
      GridPane.setConstraints(warehouseSalmon, 7, 5);

      grid.getChildren().addAll(salmon, salmonPrice, salmonBuy, salmonSell, 
      wholesalerSalmon, warehouseSalmon);

      Label rainbow = new Label("Rainbow Trout");
      GridPane.setConstraints(rainbow, 8, 3);
      Label rainbowPrice = new Label("" + fishPrices.get("Rainbow Trout"));
      GridPane.setConstraints(rainbowPrice, 9, 3);
      Button rainbowBuy = new Button("Buy");
      GridPane.setConstraints(rainbowBuy, 8, 4);
      Button rainbowSell = new Button("Sell");
      GridPane.setConstraints(rainbowSell, 9, 4);
      Label wholesalerRainbow = new Label("" + fish.rainbowStockLevel);
      grid.setConstraints(wholesalerRainbow, 8, 5);
      Label warehouseRainbow = new Label("" + warehouse.getRainbowStock());
      grid.setConstraints(warehouseRainbow, 9,5);

      grid.getChildren().addAll(rainbow, rainbowPrice, rainbowBuy, rainbowSell,
      wholesalerRainbow, warehouseRainbow);

      Label toyVendorTitle = new Label("Toy Vendor");
      toyVendorTitle.setId("vendortitle");
      GridPane.setConstraints(toyVendorTitle, 0, 7);

      Label ashyTreats = new Label("Ashy Treats");
      GridPane.setConstraints(ashyTreats, 0, 8);
      Label ashyTreatsPrice = new Label("" + toyPrices.get("Ashy Treats"));
      GridPane.setConstraints(ashyTreatsPrice, 1, 8);
      Button ashyBuy = new Button("Buy");
      GridPane.setConstraints(ashyBuy, 0, 9);
      Button ashySell = new Button("Sell");
      GridPane.setConstraints(ashySell, 1, 9);
      Label wholesalerAshyTreats = new Label("" + toy.ashyTreatsStockLevel);
      GridPane.setConstraints(wholesalerAshyTreats, 0, 10);
      Label warehouseAshyTreats = new Label("" + warehouse.getAshTreatsStock());
      GridPane.setConstraints(warehouseAshyTreats, 1, 10);

      grid.getChildren().addAll(toyVendorTitle, ashyTreats, ashyBuy, ashySell,
      wholesalerAshyTreats, warehouseAshyTreats);

      Label yarnBall = new Label("Yarn Ball");
      GridPane.setConstraints(yarnBall, 2, 8);
      Label yarnBallPrice = new Label("" + toyPrices.get("Yarn Ball"));
      GridPane.setConstraints(yarnBallPrice, 3, 8);
      Button yarnBuy = new Button("Buy");
      GridPane.setConstraints(yarnBuy, 2, 9);
      Button yarnSell = new Button("Sell");
      GridPane.setConstraints(yarnSell, 3, 9);
      Label wholesalerYarnBall = new Label("" + toy.yarnBallStockLevel);
      GridPane.setConstraints(wholesalerYarnBall, 2, 10);
      Label warehouseYarnBall = new Label("" + warehouse.getYarnBallStock());
      GridPane.setConstraints(warehouseYarnBall, 3, 10);

      grid.getChildren().addAll(yarnBall, yarnBallPrice, yarnBuy, yarnSell,
      wholesalerYarnBall, warehouseYarnBall);

      Label toyMouse = new Label("Toy Mouse");
      GridPane.setConstraints(toyMouse, 4, 8);
      Label toyMousePrice = new Label("" + toyPrices.get("Toy Mouse"));
      GridPane.setConstraints(toyMousePrice, 5, 8);
      Button toyMouseBuy = new Button("Buy");
      GridPane.setConstraints(toyMouseBuy, 4, 9);
      Button toyMouseSell = new Button("Sell");
      GridPane.setConstraints(toyMouseSell, 5, 9);
      Label wholesalerToyMouse = new Label("" + toy.toyMouseStockLevel);
      GridPane.setConstraints(wholesalerToyMouse, 4, 10);
      Label warehouseToyMouse = new Label("" + warehouse.getToyMouseStock());
      GridPane.setConstraints(warehouseToyMouse, 5, 10);

      grid.getChildren().addAll(toyMouse, toyMousePrice, toyMouseBuy, toyMouseSell,
      wholesalerToyMouse, warehouseToyMouse);

      Label scratchingPost = new Label("Scratching Post");
      GridPane.setConstraints(scratchingPost, 6, 8);
      Label scratchingPostPrice = new Label("" + toyPrices.get("Scratching Post"));
      GridPane.setConstraints(scratchingPostPrice, 7, 8);
      Button scratchingPostBuy = new Button("Buy");
      GridPane.setConstraints(scratchingPostBuy, 6, 9);
      Button scratchingPostSell = new Button("Sell");
      GridPane.setConstraints(scratchingPostSell, 7, 9);
      Label wholesalerScratchingPost = new Label("" + toy.scratchingPostStockLevel);
      GridPane.setConstraints(wholesalerScratchingPost, 6, 10);
      Label warehouseScratchingPost = new Label("" + warehouse.getScratchingPostStock());
      GridPane.setConstraints(warehouseScratchingPost, 7, 10);
      
      grid.getChildren().addAll(scratchingPost, scratchingPostPrice, scratchingPostBuy,
      scratchingPostSell, wholesalerScratchingPost,warehouseScratchingPost);

      Label fortress = new Label("Fortress");
      GridPane.setConstraints(fortress, 8, 8);
      Label fortressPrice = new Label("" + toyPrices.get("Fortress"));
      GridPane.setConstraints(fortressPrice, 9, 8);
      Button fortressBuy = new Button("Buy");
      GridPane.setConstraints(fortressBuy, 8, 9);
      Button fortressSell = new Button("Sell");
      GridPane.setConstraints(fortressSell, 9, 9);
      Label wholesalerFortress = new Label("" + toy.fortressStockLevel);
      GridPane.setConstraints(wholesalerFortress, 8, 10);
      Label warehouseFortress = new Label("" + warehouse.getFortressStock());

      grid.getChildren().addAll(fortress, fortressPrice, fortressBuy, fortressSell,
      wholesalerFortress, warehouseFortress);

      Label treatVendorTitle = new Label("Treat Vendor");
      treatVendorTitle.setId("vendortitle");
      GridPane.setConstraints(treatVendorTitle, 0, 12);

      Label ashyTreatsToo = new Label("Ashey Treats Too");
      GridPane.setConstraints(ashyTreatsToo, 0, 13);
      Label ashyTreatsTooPrice = new Label("" + treatPrices.get("Ashy Treats Too"));
      GridPane.setConstraints(ashyTreatsTooPrice, 1, 13);
      Button ashyTreatsTooBuy = new Button("Buy");
      GridPane.setConstraints(ashyTreatsTooBuy, 0, 14);
      Button ashyTreatsTooSell = new Button("Sell");
      GridPane.setConstraints(ashyTreatsTooSell, 1, 14);
      Label wholesalerAshyTreatsToo = new Label("" + treat.ashyTreatsTooStockLevel);
      GridPane.setConstraints(wholesalerAshyTreatsToo, 0, 15);
      Label warehouseAshyTreatsToo = new Label("" + warehouse.getAshyTreatsTooStock());
      GridPane.setConstraints(warehouseAshyTreatsToo, 1, 15);

      grid.getChildren().addAll(treatVendorTitle, ashyTreatsToo, ashyTreatsTooPrice, ashyTreatsTooBuy,
      ashyTreatsTooSell, wholesalerAshyTreatsToo, warehouseAshyTreatsToo);

      Label randomMoth = new Label("Random Moth");
      GridPane.setConstraints(randomMoth, 2, 13);
      Label randomMothPrice = new Label("" + treatPrices.get("Random Moth"));
      GridPane.setConstraints(randomMothPrice, 3, 13);
      Button randomMothBuy = new Button("Buy");
      GridPane.setConstraints(randomMothBuy, 2, 14);
      Button randomMothSell = new Button("Sell");
      GridPane.setConstraints(randomMothSell, 3, 14);
      Label wholesalerRandomMoth = new Label("" + treat.randomMothStockLevel);
      GridPane.setConstraints(wholesalerRandomMoth, 2, 15);
      Label warehouseRandomMoth = new Label("" + warehouse.getRandomMothStock());
      GridPane.setConstraints(warehouseRandomMoth, 3, 15);

      grid.getChildren().addAll(randomMoth, randomMothPrice, randomMothBuy,
      randomMothSell, wholesalerRandomMoth, warehouseRandomMoth);

      Label dreamsies = new Label("Dreamsies");
      GridPane.setConstraints(dreamsies, 4, 13);
      Label dreamsiesPrice = new Label("" + treatPrices.get("Dreamsies"));
      GridPane.setConstraints(dreamsiesPrice, 5, 13);
      Button dreamsiesBuy = new Button("Buy");
      GridPane.setConstraints(dreamsiesBuy, 4, 14);
      Button dreamsiesSell = new Button("Sell");
      GridPane.setConstraints(dreamsiesSell, 5, 14);
      Label wholesalerDreamsies = new Label("" + treat.dreamsiesStockLevel);
      GridPane.setConstraints(wholesalerDreamsies, 4, 15);
      Label warehouseDreamsies = new Label("" + warehouse.getDreamsiesStock());
      GridPane.setConstraints(warehouseDreamsies, 5, 15);

      grid.getChildren().addAll(dreamsies, dreamsiesPrice, dreamsiesBuy,
      dreamsiesSell, wholesalerDreamsies, warehouseDreamsies);

      Label catNip = new Label("CatNip");
      GridPane.setConstraints(catNip, 6, 13);
      Label catNipPrice = new Label("" + treatPrices.get("CatNip"));
      GridPane.setConstraints(catNipPrice, 7, 13);
      Button catNipBuy = new Button("Buy");
      GridPane.setConstraints(catNipBuy, 6, 14);
      Button catNipSell = new Button("Sell");
      GridPane.setConstraints(catNipSell, 7, 14);
      Label wholesalerCatNip = new Label("" + treat.catNipStockLevel);
      GridPane.setConstraints(wholesalerCatNip, 6, 15);
      Label warehouseCatNip = new Label("" + warehouse.getCatNipStock());
      GridPane.setConstraints(warehouseCatNip, 7, 15);

      grid.getChildren().addAll(catNip, catNipPrice, catNipBuy, catNipSell,
      wholesalerCatNip, warehouseCatNip);

      Label megaMunchies = new Label("Mega Munchies");
      GridPane.setConstraints(megaMunchies, 8, 13);
      Label megaMunchiesPrice = new Label("" + treatPrices.get("Mega Munchies"));
      GridPane.setConstraints(megaMunchiesPrice, 9, 13);
      Button megaMunchiesBuy = new Button("Buy");
      GridPane.setConstraints(megaMunchiesBuy, 8, 14);
      Button megaMunchiesSell = new Button("Sell");
      GridPane.setConstraints(megaMunchiesSell, 9, 14);
      Label wholesalerMegaMunchies = new Label("" + treat.megaMunchiesStockLevel);
      GridPane.setConstraints(wholesalerMegaMunchies, 8, 15);
      Label warehouseMegaMunchies = new Label("" + warehouse.getMegaMunchiesStock());
      GridPane.setConstraints(warehouseMegaMunchies, 9, 15);

      grid.getChildren().addAll(megaMunchies, megaMunchiesPrice, megaMunchiesBuy,
      megaMunchiesSell, wholesalerMegaMunchies, warehouseMegaMunchies);



      Label bankBalanceLabel = new Label("Bank Balance");
      bankBalanceLabel.setId("bankbalance");
      GridPane.setConstraints(bankBalanceLabel, 0, 17);
      Label showBalance = new Label();
      showBalance.setText("" + bank.getBalance());
      showBalance.setId("showbalance");
      GridPane.setConstraints(showBalance, 0, 18);

      Button endDay = new Button("End Day");
      GridPane.setConstraints(endDay, 2, 17);

      grid.getChildren().addAll(bankBalanceLabel, showBalance, endDay);


      BorderPane pane = new BorderPane();
      pane.setTop(gridTop);
      pane.setCenter(grid);
      Scene scene = new Scene(pane, 1100, 650);
      scene.getStylesheets().add("/Catmodities/style.css");
      window.setScene(scene); 
      
      window.show();



      headsBuyButton.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("FishHeads"), fish.fishHeadsStockLevel, warehouse.getFishHeadsStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.fishHeadsStockLevel = holding[0];
            wholesalerFishHeads.setText("" + holding[0]);
            warehouse.setWareHouseFishHeads(holding[1]);
            warehouseFishHeads.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      headsSellButton.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("FishHeads"), fish.fishHeadsStockLevel, warehouse.getFishHeadsStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.fishHeadsStockLevel = holding[0];
            wholesalerFishHeads.setText("" + holding[0]);
            warehouse.setWareHouseFishHeads(holding[1]);
            warehouseFishHeads.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });
   








      endDay.setOnAction(e -> {
         // Set vendor prices
         fish.setPrices();
         toy.setPrices();
         treat.setPrices();

         // Get vendor prices and assign to LinkedHashMap
         fishPrices = fish.getPrices();
         toyPrices = toy.getPrices();
         treatPrices = treat.getPrices();

         switch(day.getText()){
            case "Monday":
               day.setText("Tuesday");
               break;
            case "Tuesday":
               day.setText("Wednesday");
               break;
            case "Wednesday":
               day.setText("Thursday");
               break;
            case "Thursday":
               day.setText("Friday");
               break;
            case "Friday":
               day.setText("Monday");
               break;
            default:
               day.setText("Monday");
         }

         fishHeadsPrice.setText("" + fishPrices.get("FishHeads"));

      });
   
   
   
   
   }


}
