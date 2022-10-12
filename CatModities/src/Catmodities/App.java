package Catmodities;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.geometry.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.Random;

import javax.swing.event.SwingPropertyChangeSupport;

import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
// import java.io.FileWriter;
// import java.io.IOException;

public class App extends Application {

   Stage window;

   // Set class variables
   Label wholesalerFishHeads;
   Label wholesalerFishyTreats;
   Label wholesalerCod;
   Label wholesalerSalmon;
   Label wholesalerRainbow;
   Label wholesalerAshyTreats;
   Label wholesalerYarnBall;
   Label wholesalerToyMouse;
   Label wholesalerScratchingPost;
   Label wholesalerFortress;
   Label wholesalerAshyTreatsToo;
   Label wholesalerRandomMoth;
   Label wholesalerDreamsies;
   Label wholesalerCatNip;
   Label wholesalerMegaMunchies;

   Label warehouseFishHeads;
   Label warehouseFishyTreats;
   Label warehouseCod;
   Label warehouseSalmon;
   Label warehouseRainbow;
   Label warehouseAshyTreats;
   Label warehouseYarnBall;
   Label warehouseToyMouse;
   Label warehouseScratchingPost;
   Label warehouseFortress;
   Label warehouseAshyTreatsToo;
   Label warehouseRandomMoth;
   Label warehouseDreamsies;
   Label warehouseCatNip;
   Label warehouseMegaMunchies;

   Label fishHeadsPrice;
   Label fishyTreatsPrice;
   Label codPrice;
   Label salmonPrice;
   Label rainbowPrice;
   Label ashyTreatsPrice;
   Label yarnBallPrice;
   Label toyMousePrice;
   Label scratchingPostPrice;
   Label fortressPrice;
   Label ashyTreatsTooPrice;
   Label randomMothPrice;
   Label dreamsiesPrice;
   Label catNipPrice;
   Label megaMunchiesPrice;

   int dayCounter = 1;

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

      // Instantiate bank, personal warehouse stock, and Story Event
      Bank bank = new Bank();
      Warehouse warehouse = new Warehouse();
      StoryEvent storyEvent = new StoryEvent();
      
      // Set window
      window = primaryStage;
      window.setTitle("CatModities");

      GridPane grid = new GridPane();
      grid.setAlignment(Pos.TOP_CENTER);
      GridPane gridTop = new GridPane();
      gridTop.setAlignment(Pos.CENTER);
      GridPane gridLeft = new GridPane();
      gridLeft.setAlignment(Pos.TOP_CENTER);
      GridPane gridBottom = new GridPane();
      gridBottom.setAlignment(Pos.CENTER);

      // Main Grid padding
      grid.setPadding(new Insets(10, 10, 12, 0));
      grid.setVgap(8);
      grid.setHgap(8);
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(42));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(42));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(42));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(42));
      grid.getColumnConstraints().add(new ColumnConstraints(130));
      grid.getColumnConstraints().add(new ColumnConstraints(42));     
      gridLeft.getColumnConstraints().add(new ColumnConstraints(120));
      gridLeft.setVgap(10);
      gridLeft.setPadding(new Insets(10, 4, 10, 10));
      gridBottom.setPadding(new Insets(10,10,10, 10));

      // Title set
      Label title = new Label("CatModities");
      title.setId("title");
      GridPane.setConstraints(title, 0, 0);
      gridTop.getChildren().addAll(title);

      // Left panel
      Label day = new Label("Monday");
      day.setId("day"); 
      GridPane.setConstraints(day, 0, 0);
      GridPane.setHalignment(day, HPos.CENTER);
      
      Label dayCount = new Label("" + dayCounter);
      dayCount.setId("daycount");
      GridPane.setHalignment(dayCount, HPos.CENTER);
      GridPane.setConstraints(dayCount, 0, 3);

      Button story = new Button("Story");
      GridPane.setConstraints(story, 0, 8);
      GridPane.setHalignment(story, HPos.CENTER);

      gridLeft.getChildren().addAll(day, dayCount, story);


      // Fish Vendor Labels and Buttons
      Label fishVendorTitle = new Label("Fish Vendor");
      GridPane.setConstraints(fishVendorTitle, 0, 0);
      fishVendorTitle.setId("vendortitle");
      Label fishHeadsLabel = new Label("Fish Heads");
      GridPane.setConstraints(fishHeadsLabel, 0, 1);
      fishHeadsPrice = new Label(""+ fishPrices.get("FishHeads"));
      fishHeadsPrice.setId("pricelabel");
      GridPane.setConstraints(fishHeadsPrice, 1, 1);
      Button headsBuyButton = new Button("Buy");
      GridPane.setConstraints(headsBuyButton, 0, 2);
      Button headsSellButton = new Button("Sell");
      GridPane.setConstraints(headsSellButton, 1, 2);
      wholesalerFishHeads = new Label("" + fish.fishHeadsStockLevel);
      GridPane.setConstraints(wholesalerFishHeads, 0, 3);
      warehouseFishHeads = new Label("" + warehouse.getFishHeadsStock());
      warehouseFishHeads.setId("warehouse");
      GridPane.setConstraints(warehouseFishHeads, 1, 3);

      grid.getChildren().addAll(fishVendorTitle, fishHeadsLabel, fishHeadsPrice, 
      headsBuyButton, headsSellButton, wholesalerFishHeads, warehouseFishHeads);

      Label fishyTreats = new Label("Fishy Treats");
      GridPane.setConstraints(fishyTreats, 2, 1);
      fishyTreatsPrice = new Label("" + fishPrices.get("Fishy Treats"));
      fishyTreatsPrice.setId("pricelabel");
      GridPane.setConstraints(fishyTreatsPrice, 3, 1);
      Button fishyTreatsBuy = new Button("Buy");
      GridPane.setConstraints(fishyTreatsBuy, 2, 2);
      Button fishyTreatsSell = new Button("Sell");
      GridPane.setConstraints(fishyTreatsSell, 3, 2);
      wholesalerFishyTreats = new Label("" + fish.fishyTreatsStockLevel);
      GridPane.setConstraints(wholesalerFishyTreats, 2, 3);
      warehouseFishyTreats = new Label("" + warehouse.getFishyTreatsStock());
      warehouseFishyTreats.setId("warehouse");
      GridPane.setConstraints(warehouseFishyTreats, 3, 3);

      grid.getChildren().addAll(fishyTreats, fishyTreatsPrice, fishyTreatsBuy, fishyTreatsSell,
      wholesalerFishyTreats, warehouseFishyTreats);

      Label cod = new Label("Cod");
      GridPane.setConstraints(cod, 4, 1);
      codPrice = new Label("" + fishPrices.get("Cod"));
      codPrice.setId("pricelabel");
      GridPane.setConstraints(codPrice, 5, 1);
      Button codBuy = new Button("Buy");
      GridPane.setConstraints(codBuy, 4, 2);
      Button codSell = new Button("Sell");
      GridPane.setConstraints(codSell, 5, 2);
      wholesalerCod = new Label("" + fish.codStockLevel);
      GridPane.setConstraints(wholesalerCod, 4, 3);
      warehouseCod = new Label("" + warehouse.getWareHouseCodStock());
      warehouseCod.setId("warehouse");
      GridPane.setConstraints(warehouseCod, 5, 3);

      grid.getChildren().addAll(cod, codPrice, codBuy, codSell, wholesalerCod, warehouseCod);

      Label salmon = new Label("Salmon Mousse");
      GridPane.setConstraints(salmon, 6, 1);
      salmonPrice = new Label("" + fishPrices.get("Salmon Mousse"));
      salmonPrice.setId("pricelabel");
      GridPane.setConstraints(salmonPrice, 7, 1);
      Button salmonBuy = new Button("Buy");
      GridPane.setConstraints(salmonBuy, 6, 2);
      Button salmonSell = new Button("Sell");
      GridPane.setConstraints(salmonSell, 7, 2);
      wholesalerSalmon = new Label("" + fish.salmonStockLevel);
      GridPane.setConstraints(wholesalerSalmon, 6, 3);
      warehouseSalmon = new Label("" + warehouse.getSalmonStock());
      warehouseSalmon.setId("warehouse");
      GridPane.setConstraints(warehouseSalmon, 7, 3);

      grid.getChildren().addAll(salmon, salmonPrice, salmonBuy, salmonSell, 
      wholesalerSalmon, warehouseSalmon);

      Label rainbow = new Label("Rainbow Trout");
      GridPane.setConstraints(rainbow, 8, 1);
      rainbowPrice = new Label("" + fishPrices.get("Rainbow Trout"));
      rainbowPrice.setId("pricelabel");
      GridPane.setConstraints(rainbowPrice, 9, 1);
      Button rainbowBuy = new Button("Buy");
      GridPane.setConstraints(rainbowBuy, 8, 2);
      Button rainbowSell = new Button("Sell");
      GridPane.setConstraints(rainbowSell, 9, 2);
      wholesalerRainbow = new Label("" + fish.rainbowStockLevel);
      GridPane.setConstraints(wholesalerRainbow, 8, 3);
      warehouseRainbow = new Label("" + warehouse.getRainbowStock());
      warehouseRainbow.setId("warehouse");
      GridPane.setConstraints(warehouseRainbow, 9,3);

      grid.getChildren().addAll(rainbow, rainbowPrice, rainbowBuy, rainbowSell,
      wholesalerRainbow, warehouseRainbow);

      // Toy Vendor label and buttons
      Label toyVendorTitle = new Label("Toy Vendor");
      toyVendorTitle.setId("vendortitle");
      GridPane.setConstraints(toyVendorTitle, 0, 5);
      Label ashyTreats = new Label("Ashy Treats");
      GridPane.setConstraints(ashyTreats, 0, 6);
      ashyTreatsPrice = new Label("" + toyPrices.get("Ashy Treats"));
      ashyTreatsPrice.setId("pricelabel");
      GridPane.setConstraints(ashyTreatsPrice, 1, 6);
      Button ashyBuy = new Button("Buy");
      GridPane.setConstraints(ashyBuy, 0, 7);
      Button ashySell = new Button("Sell");
      GridPane.setConstraints(ashySell, 1, 7);
      wholesalerAshyTreats = new Label("" + toy.ashyTreatsStockLevel);
      GridPane.setConstraints(wholesalerAshyTreats, 0, 8);
      warehouseAshyTreats = new Label("" + warehouse.getAshyTreatsStock());
      warehouseAshyTreats.setId("warehouse");
      GridPane.setConstraints(warehouseAshyTreats, 1, 8);

      grid.getChildren().addAll(toyVendorTitle, ashyTreats, ashyTreatsPrice, ashyBuy, ashySell,
      wholesalerAshyTreats, warehouseAshyTreats);

      Label yarnBall = new Label("Yarn Ball");
      GridPane.setConstraints(yarnBall, 2, 6);
      yarnBallPrice = new Label("" + toyPrices.get("Yarn Ball"));
      yarnBallPrice.setId("pricelabel");
      GridPane.setConstraints(yarnBallPrice, 3, 6);
      Button yarnBuy = new Button("Buy");
      GridPane.setConstraints(yarnBuy, 2, 7);
      Button yarnSell = new Button("Sell");
      GridPane.setConstraints(yarnSell, 3, 7);
      wholesalerYarnBall = new Label("" + toy.yarnBallStockLevel);
      GridPane.setConstraints(wholesalerYarnBall, 2, 8);
      warehouseYarnBall = new Label("" + warehouse.getYarnBallStock());
      warehouseYarnBall.setId("warehouse");
      GridPane.setConstraints(warehouseYarnBall, 3, 8);

      grid.getChildren().addAll(yarnBall, yarnBallPrice, yarnBuy, yarnSell,
      wholesalerYarnBall, warehouseYarnBall);

      Label toyMouse = new Label("Toy Mouse");
      GridPane.setConstraints(toyMouse, 4, 6);
      toyMousePrice = new Label("" + toyPrices.get("Toy Mouse"));
      toyMousePrice.setId("pricelabel");
      GridPane.setConstraints(toyMousePrice, 5, 6);
      Button toyMouseBuy = new Button("Buy");
      GridPane.setConstraints(toyMouseBuy, 4, 7);
      Button toyMouseSell = new Button("Sell");
      GridPane.setConstraints(toyMouseSell, 5, 7);
      wholesalerToyMouse = new Label("" + toy.toyMouseStockLevel);
      GridPane.setConstraints(wholesalerToyMouse, 4, 8);
      warehouseToyMouse = new Label("" + warehouse.getToyMouseStock());
      warehouseToyMouse.setId("warehouse");
      GridPane.setConstraints(warehouseToyMouse, 5, 8);

      grid.getChildren().addAll(toyMouse, toyMousePrice, toyMouseBuy, toyMouseSell,
      wholesalerToyMouse, warehouseToyMouse);

      Label scratchingPost = new Label("Scratching Post");
      GridPane.setConstraints(scratchingPost, 6, 6);
      scratchingPostPrice = new Label("" + toyPrices.get("Scratching Post"));
      scratchingPostPrice.setId("pricelabel");
      GridPane.setConstraints(scratchingPostPrice, 7, 6);
      Button scratchingPostBuy = new Button("Buy");
      GridPane.setConstraints(scratchingPostBuy, 6, 7);
      Button scratchingPostSell = new Button("Sell");
      GridPane.setConstraints(scratchingPostSell, 7, 7);
      wholesalerScratchingPost = new Label("" + toy.scratchingPostStockLevel);
      GridPane.setConstraints(wholesalerScratchingPost, 6, 8);
      warehouseScratchingPost = new Label("" + warehouse.getScratchingPostStock());
      warehouseScratchingPost.setId("warehouse");
      GridPane.setConstraints(warehouseScratchingPost, 7, 8);
      
      grid.getChildren().addAll(scratchingPost, scratchingPostPrice, scratchingPostBuy,
      scratchingPostSell, wholesalerScratchingPost,warehouseScratchingPost);

      Label fortress = new Label("Fortress");
      GridPane.setConstraints(fortress, 8, 6);
      fortressPrice = new Label("" + toyPrices.get("Fortress"));
      fortressPrice.setId("pricelabel");
      GridPane.setConstraints(fortressPrice, 9, 6);
      Button fortressBuy = new Button("Buy");
      GridPane.setConstraints(fortressBuy, 8, 7);
      Button fortressSell = new Button("Sell");
      GridPane.setConstraints(fortressSell, 9, 7);
      wholesalerFortress = new Label("" + toy.fortressStockLevel);
      GridPane.setConstraints(wholesalerFortress, 8, 8);
      warehouseFortress = new Label("" + warehouse.getFortressStock());
      warehouseFortress.setId("warehouse");
      GridPane.setConstraints(warehouseFortress, 9, 8);

      grid.getChildren().addAll(fortress, fortressPrice, fortressBuy, fortressSell,
      wholesalerFortress, warehouseFortress);

      // Treat Vendor labels and buttons
      Label treatVendorTitle = new Label("Treat Vendor");
      treatVendorTitle.setId("vendortitle");
      GridPane.setConstraints(treatVendorTitle, 0, 10);
      Label ashyTreatsToo = new Label("Ashey Treats Too");
      GridPane.setConstraints(ashyTreatsToo, 0, 11);
      ashyTreatsTooPrice = new Label("" + treatPrices.get("Ashy Treats Too"));
      ashyTreatsTooPrice.setId("pricelabel");
      GridPane.setConstraints(ashyTreatsTooPrice, 1, 11);
      Button ashyTreatsTooBuy = new Button("Buy");
      GridPane.setConstraints(ashyTreatsTooBuy, 0, 12);
      Button ashyTreatsTooSell = new Button("Sell");
      GridPane.setConstraints(ashyTreatsTooSell, 1, 12);
      wholesalerAshyTreatsToo = new Label("" + treat.ashyTreatsTooStockLevel);
      GridPane.setConstraints(wholesalerAshyTreatsToo, 0, 13);
      warehouseAshyTreatsToo = new Label("" + warehouse.getAshyTreatsTooStock());
      warehouseAshyTreatsToo.setId("warehouse");
      GridPane.setConstraints(warehouseAshyTreatsToo, 1, 13);

      grid.getChildren().addAll(treatVendorTitle, ashyTreatsToo, ashyTreatsTooPrice, ashyTreatsTooBuy,
      ashyTreatsTooSell, wholesalerAshyTreatsToo, warehouseAshyTreatsToo);

      Label randomMoth = new Label("Random Moth");
      GridPane.setConstraints(randomMoth, 2, 11);
      randomMothPrice = new Label("" + treatPrices.get("Random Moth"));
      randomMothPrice.setId("pricelabel");
      GridPane.setConstraints(randomMothPrice, 3, 11);
      Button randomMothBuy = new Button("Buy");
      GridPane.setConstraints(randomMothBuy, 2, 12);
      Button randomMothSell = new Button("Sell");
      GridPane.setConstraints(randomMothSell, 3, 12);
      wholesalerRandomMoth = new Label("" + treat.randomMothStockLevel);
      GridPane.setConstraints(wholesalerRandomMoth, 2, 13);
      warehouseRandomMoth = new Label("" + warehouse.getRandomMothStock());
      warehouseRandomMoth.setId("warehouse");
      GridPane.setConstraints(warehouseRandomMoth, 3, 13);

      grid.getChildren().addAll(randomMoth, randomMothPrice, randomMothBuy,
      randomMothSell, wholesalerRandomMoth, warehouseRandomMoth);

      Label dreamsies = new Label("Dreamsies");
      GridPane.setConstraints(dreamsies, 4, 11);
      dreamsiesPrice = new Label("" + treatPrices.get("Dreamsies"));
      dreamsiesPrice.setId("pricelabel");
      GridPane.setConstraints(dreamsiesPrice, 5, 11);
      Button dreamsiesBuy = new Button("Buy");
      GridPane.setConstraints(dreamsiesBuy, 4, 12);
      Button dreamsiesSell = new Button("Sell");
      GridPane.setConstraints(dreamsiesSell, 5, 12);
      wholesalerDreamsies = new Label("" + treat.dreamsiesStockLevel);
      GridPane.setConstraints(wholesalerDreamsies, 4, 13);
      warehouseDreamsies = new Label("" + warehouse.getDreamsiesStock());
      warehouseDreamsies.setId("warehouse");
      GridPane.setConstraints(warehouseDreamsies, 5, 13);

      grid.getChildren().addAll(dreamsies, dreamsiesPrice, dreamsiesBuy,
      dreamsiesSell, wholesalerDreamsies, warehouseDreamsies);

      Label catNip = new Label("CatNip");
      GridPane.setConstraints(catNip, 6, 11);
      catNipPrice = new Label("" + treatPrices.get("CatNip"));
      catNipPrice.setId("pricelabel");
      GridPane.setConstraints(catNipPrice, 7, 11);
      Button catNipBuy = new Button("Buy");
      GridPane.setConstraints(catNipBuy, 6, 12);
      Button catNipSell = new Button("Sell");
      GridPane.setConstraints(catNipSell, 7, 12);
      wholesalerCatNip = new Label("" + treat.catNipStockLevel);
      GridPane.setConstraints(wholesalerCatNip, 6, 13);
      warehouseCatNip = new Label("" + warehouse.getCatNipStock());
      warehouseCatNip.setId("warehouse");
      GridPane.setConstraints(warehouseCatNip, 7, 13);

      grid.getChildren().addAll(catNip, catNipPrice, catNipBuy, catNipSell,
      wholesalerCatNip, warehouseCatNip);

      Label megaMunchies = new Label("Mega Munchies");
      GridPane.setConstraints(megaMunchies, 8, 11);
      megaMunchiesPrice = new Label("" + treatPrices.get("Mega Munchies"));
      megaMunchiesPrice.setId("pricelabel");
      GridPane.setConstraints(megaMunchiesPrice, 9, 11);
      Button megaMunchiesBuy = new Button("Buy");
      GridPane.setConstraints(megaMunchiesBuy, 8, 12);
      Button megaMunchiesSell = new Button("Sell");
      GridPane.setConstraints(megaMunchiesSell, 9, 12);
      wholesalerMegaMunchies = new Label("" + treat.megaMunchiesStockLevel);
      GridPane.setConstraints(wholesalerMegaMunchies, 8, 13);
      warehouseMegaMunchies = new Label("" + warehouse.getMegaMunchiesStock());
      warehouseMegaMunchies.setId("warehouse");
      GridPane.setConstraints(warehouseMegaMunchies, 9, 13);

      grid.getChildren().addAll(megaMunchies, megaMunchiesPrice, megaMunchiesBuy,
      megaMunchiesSell, wholesalerMegaMunchies, warehouseMegaMunchies);

      Button endDay = new Button("End Day");
      endDay.setId("endDay");
      GridPane.setConstraints(endDay, 0, 15);

      Label bankBalanceLabel = new Label("Bank Balance");
      bankBalanceLabel.setId("bankbalance");
      GridPane.setConstraints(bankBalanceLabel, 6, 15);
      Label showBalance = new Label();
      showBalance.setText("" + bank.getBalance());
      showBalance.setId("showbalance");
      GridPane.setConstraints(showBalance, 8, 15);

      grid.getChildren().addAll(endDay, bankBalanceLabel, showBalance);


      BorderPane pane = new BorderPane();
      pane.setTop(gridTop);
      pane.setCenter(grid);
      pane.setLeft(gridLeft);
      Scene scene = new Scene(pane, 1100, 650);

      scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Gafata");
      scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Barriecito");
      scene.getStylesheets().add("/Catmodities/Resources/style.css");
      
      window.setScene(scene); 
      
      window.show();


      // Buy and sell buttons
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
   
      fishyTreatsBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Fishy Treats"), fish.fishyTreatsStockLevel, warehouse.getFishyTreatsStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.fishyTreatsStockLevel = holding[0];
            wholesalerFishyTreats.setText("" + holding[0]);
            warehouse.setWarehouseFishyTreats(holding[1]);
            warehouseFishyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      fishyTreatsSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Fishy Treats"), fish.fishyTreatsStockLevel, warehouse.getFishyTreatsStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.fishyTreatsStockLevel = holding[0];
            wholesalerFishyTreats.setText("" + holding[0]);
            warehouse.setWarehouseFishyTreats(holding[1]);
            warehouseFishyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      codBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Cod"), fish.codStockLevel, warehouse.getWareHouseCodStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.codStockLevel = holding[0];
            wholesalerCod.setText("" + holding[0]);
            warehouse.setWarehouseCod(holding[1]);
            warehouseCod.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      codSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Cod"), fish.codStockLevel, warehouse.getWareHouseCodStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.codStockLevel = holding[0];
            wholesalerCod.setText("" + holding[0]);
            warehouse.setWarehouseCod(holding[1]);
            warehouseCod.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      salmonBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Salmon Mousse"), fish.salmonStockLevel, warehouse.getSalmonStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.salmonStockLevel = holding[0];
            wholesalerSalmon.setText("" + holding[0]);
            warehouse.setWarehouseSalmon(holding[1]);
            warehouseSalmon.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      salmonSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Salmon Mousse"), fish.salmonStockLevel, warehouse.getSalmonStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.salmonStockLevel = holding[0];
            wholesalerSalmon.setText("" + holding[0]);
            warehouse.setWarehouseSalmon(holding[1]);
            warehouseSalmon.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      rainbowBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Rainbow Trout"), fish.rainbowStockLevel, warehouse.getRainbowStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.rainbowStockLevel = holding[0];
            wholesalerRainbow.setText("" + holding[0]);
            warehouse.setWarehouseRainbow(holding[1]);
            warehouseRainbow.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      rainbowSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Rainbow Salmon"), fish.rainbowStockLevel, warehouse.getRainbowStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            fish.rainbowStockLevel = holding[0];
            wholesalerRainbow.setText("" + holding[0]);
            warehouse.setWarehouseRainbow(holding[1]);
            warehouseRainbow.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      ashyBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Ashy Treats"), toy.ashyTreatsStockLevel, warehouse.getAshyTreatsStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.ashyTreatsStockLevel = holding[0];
            wholesalerAshyTreats.setText("" + holding[0]);
            warehouse.setWarehouseAshTreats(holding[1]);
            warehouseAshyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      ashySell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Ashy Treats"), toy.ashyTreatsStockLevel, warehouse.getAshyTreatsStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.ashyTreatsStockLevel = holding[0];
            wholesalerAshyTreats.setText("" + holding[0]);
            warehouse.setWarehouseAshTreats(holding[1]);
            warehouseAshyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      yarnBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Yarn Ball"), toy.yarnBallStockLevel, warehouse.getYarnBallStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.yarnBallStockLevel = holding[0];
            wholesalerYarnBall.setText("" + holding[0]);
            warehouse.setWarehouseYarnBall(holding[1]);
            warehouseYarnBall.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      yarnSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Yarn Ball"), toy.yarnBallStockLevel, warehouse.getYarnBallStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.yarnBallStockLevel = holding[0];
            wholesalerYarnBall.setText("" + holding[0]);
            warehouse.setWarehouseYarnBall(holding[1]);
            warehouseYarnBall.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      toyMouseBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Toy Mouse"), toy.toyMouseStockLevel, warehouse.getToyMouseStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.toyMouseStockLevel = holding[0];
            wholesalerToyMouse.setText("" + holding[0]);
            warehouse.setWarehouseToyMouse(holding[1]);
            warehouseToyMouse.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      toyMouseSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Toy Mouse"), toy.toyMouseStockLevel, warehouse.getToyMouseStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.toyMouseStockLevel = holding[0];
            wholesalerToyMouse.setText("" + holding[0]);
            warehouse.setWarehouseToyMouse(holding[1]);
            warehouseToyMouse.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      scratchingPostBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Scratching Post"), toy.scratchingPostStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.scratchingPostStockLevel = holding[0];
            wholesalerScratchingPost.setText("" + holding[0]);
            warehouse.setWarehouseScracthingPost(holding[1]);
            warehouseScratchingPost.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      scratchingPostSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Scratching Post"), toy.scratchingPostStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.scratchingPostStockLevel = holding[0];
            wholesalerScratchingPost.setText("" + holding[0]);
            warehouse.setWarehouseScracthingPost(holding[1]);
            warehouseScratchingPost.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      fortressBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Fortress"), toy.fortressStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.fortressStockLevel = holding[0];
            wholesalerFortress.setText("" + holding[0]);
            warehouse.setWarehouseFortress(holding[1]);
            warehouseFortress.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      fortressSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Fortress"), toy.fortressStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            toy.fortressStockLevel = holding[0];
            wholesalerFortress.setText("" + holding[0]);
            warehouse.setWarehouseFortress(holding[1]);
            warehouseFortress.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      ashyTreatsTooBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Ashy Treats Too"), treat.ashyTreatsTooStockLevel, warehouse.getAshyTreatsTooStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.ashyTreatsTooStockLevel = holding[0];
            wholesalerAshyTreatsToo.setText("" + holding[0]);
            warehouse.setWarehouseAshyTreatsToo(holding[1]);
            warehouseAshyTreatsToo.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      ashyTreatsTooSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Ashy Treats Too"), treat.ashyTreatsTooStockLevel, warehouse.getAshyTreatsTooStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.ashyTreatsTooStockLevel = holding[0];
            wholesalerAshyTreatsToo.setText("" + holding[0]);
            warehouse.setWarehouseAshyTreatsToo(holding[1]);
            warehouseAshyTreatsToo.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      randomMothBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Random Moth"), treat.randomMothStockLevel, warehouse.getRandomMothStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.randomMothStockLevel = holding[0];
            wholesalerRandomMoth.setText("" + holding[0]);
            warehouse.setWarehouseRandomMoth(holding[1]);
            warehouseRandomMoth.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      randomMothSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Random Moth"), treat.randomMothStockLevel, warehouse.getRandomMothStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.randomMothStockLevel = holding[0];
            wholesalerRandomMoth.setText("" + holding[0]);
            warehouse.setWarehouseRandomMoth(holding[1]);
            warehouseRandomMoth.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      dreamsiesBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Dreamsies"), treat.dreamsiesStockLevel, warehouse.getDreamsiesStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.dreamsiesStockLevel = holding[0];
            wholesalerDreamsies.setText("" + holding[0]);
            warehouse.setWarehouseDreamsies(holding[1]);
            warehouseDreamsies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      dreamsiesSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Dreamsies"), treat.dreamsiesStockLevel, warehouse.getDreamsiesStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.dreamsiesStockLevel = holding[0];
            wholesalerDreamsies.setText("" + holding[0]);
            warehouse.setWarehouseDreamsies(holding[1]);
            warehouseDreamsies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      catNipBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("CatNip"), treat.catNipStockLevel, warehouse.getCatNipStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.catNipStockLevel = holding[0];
            wholesalerCatNip.setText("" + holding[0]);
            warehouse.setWarehouseCatNip(holding[1]);
            warehouseCatNip.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      catNipSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("CatNip"), treat.catNipStockLevel, warehouse.getCatNipStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.catNipStockLevel = holding[0];
            wholesalerCatNip.setText("" + holding[0]);
            warehouse.setWarehouseCatNip(holding[1]);
            warehouseCatNip.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      megaMunchiesBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Mega Munchies"), treat.megaMunchiesStockLevel, warehouse.getMegaMunchiesStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.megaMunchiesStockLevel = holding[0];
            wholesalerMegaMunchies.setText("" + holding[0]);
            warehouse.setWarehouseMegaMunchies(holding[1]);
            warehouseMegaMunchies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      megaMunchiesSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Mega Munchies"), treat.megaMunchiesStockLevel, warehouse.getMegaMunchiesStock(), bank.getBalance());

         // return wholesaler/warehouse/bank balance/confirmation
         if (holding[3] == 1){
            treat.megaMunchiesStockLevel = holding[0];
            wholesalerMegaMunchies.setText("" + holding[0]);
            warehouse.setWarehouseMegaMunchies(holding[1]);
            warehouseMegaMunchies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
         }          
      });

      story.setOnAction(e -> {
         storyEvent.runPage(false, bank, fish, toy, treat, warehouse);
      });

      // End day commands
      endDay.setOnAction(e -> {
         // Reset crash/rise and set vendor prices
         fish.localCrash(false, 0.0);
         fish.localPriceRise(false, 0.0);
         toy.localCrash(false, 0.0);
         toy.localPriceRise(false, 0.0);
         treat.localCrash(false, 0.0);
         treat.localPriceRise(false, 0.0);
         fish.setPrices();
         toy.setPrices();
         treat.setPrices();

         // Get vendor prices and assign to LinkedHashMap
         fishPrices = fish.getPrices();
         toyPrices = toy.getPrices();
         treatPrices = treat.getPrices();

         //Increment day counter
         dayCounter++;
         dayCount.setText("" + dayCounter);

         // Set day
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
               fish.restock();
               toy.restock();
               treat.restock();
               Random random = new Random();
               int randomStory = random.nextInt(2);
               System.out.println(randomStory);
               if (randomStory == 1){
                  storyEvent.runPage(false, bank, fish, toy, treat, warehouse);
               }
               break;
         }

         getWholesalerStock(fish, toy, treat);
         getWarehouseStock(warehouse);
         getPrices(fishPrices, toyPrices, treatPrices);
         showHighLow(fishPrices, toyPrices, treatPrices);

      });
   
   }

   void getWholesalerStock(Wholesaler fish, Wholesaler toy, Wholesaler treat){
      wholesalerFishHeads.setText("" + fish.fishHeadsStockLevel);
      wholesalerFishyTreats.setText("" + fish.fishyTreatsStockLevel);
      wholesalerCod.setText("" + fish.codStockLevel);
      wholesalerSalmon.setText("" + fish.salmonStockLevel);
      wholesalerRainbow.setText("" + fish.rainbowStockLevel);
      wholesalerAshyTreats.setText("" + toy.ashyTreatsStockLevel);
      wholesalerYarnBall.setText("" + toy.yarnBallStockLevel);
      wholesalerToyMouse.setText("" + toy.toyMouseStockLevel);
      wholesalerScratchingPost.setText("" + toy.scratchingPostStockLevel);
      wholesalerFortress.setText("" + toy.fortressStockLevel);
      wholesalerAshyTreatsToo.setText("" + treat.ashyTreatsTooStockLevel);
      wholesalerRandomMoth.setText("" + treat.randomMothStockLevel);
      wholesalerDreamsies.setText("" + treat.dreamsiesStockLevel);
      wholesalerCatNip.setText("" + treat.catNipStockLevel);
      wholesalerMegaMunchies.setText("" + treat.megaMunchiesStockLevel);
   }

   void getWarehouseStock(Warehouse warehouse){
      warehouseFishHeads.setText("" + warehouse.getFishHeadsStock());
      warehouseFishyTreats.setText("" + warehouse.getFishyTreatsStock());
      warehouseCod.setText("" + warehouse.getWareHouseCodStock());
      warehouseSalmon.setText("" + warehouse.getSalmonStock());
      warehouseRainbow.setText("" + warehouse.getRainbowStock());
      warehouseAshyTreats.setText("" + warehouse.getAshyTreatsStock());
      warehouseYarnBall.setText("" + warehouse.getYarnBallStock());
      warehouseToyMouse.setText("" + warehouse.getYarnBallStock());
      warehouseScratchingPost.setText("" + warehouse.getScratchingPostStock());
      warehouseFortress.setText("" + warehouse.getFortressStock());
      warehouseAshyTreatsToo.setText("" + warehouse.getAshyTreatsTooStock());
      warehouseRandomMoth.setText("" + warehouse.getRandomMothStock());
      warehouseDreamsies.setText("" + warehouse.getDreamsiesStock());
      warehouseCatNip.setText("" + warehouse.getCatNipStock());
      warehouseMegaMunchies.setText("" + warehouse.getMegaMunchiesStock()); 
   }

   void getPrices(LinkedHashMap fishPrices, LinkedHashMap toyPrices, LinkedHashMap treatPrices){
      fishHeadsPrice.setText("" + fishPrices.get("FishHeads"));
      fishyTreatsPrice.setText("" + fishPrices.get("Fishy Treats"));
      codPrice.setText("" + fishPrices.get("Cod"));
      salmonPrice.setText("" + fishPrices.get("Salmon Mousse"));
      rainbowPrice.setText("" + fishPrices.get("Rainbow Trout"));

      ashyTreatsPrice.setText("" + toyPrices.get("Ashy Treats"));
      yarnBallPrice.setText("" + toyPrices.get("Yarn Ball"));
      toyMousePrice.setText("" + toyPrices.get("Toy Mouse"));
      scratchingPostPrice.setText("" + toyPrices.get("Scratching Post"));
      fortressPrice.setText("" + toyPrices.get("Fortress"));

      ashyTreatsTooPrice.setText("" + treatPrices.get("Ashy Treats Too"));
      randomMothPrice.setText("" + treatPrices.get("Random Moth"));
      dreamsiesPrice.setText("" + treatPrices.get("Dreamsies"));
      catNipPrice.setText("" + treatPrices.get("CatNip"));
      megaMunchiesPrice.setText("" + treatPrices.get("Mega Munchies"));  
   }

   void showHighLow(LinkedHashMap fishPrices, LinkedHashMap toyPrices, LinkedHashMap treatPrices){

      if ((int)fishPrices.get("FishHeads") >= 3){
          fishHeadsPrice.setStyle("-fx-text-fill: green");
      } else if ((int)fishPrices.get("FishHeads") < 3){
         fishHeadsPrice.setStyle("-fx-text-fill: red");
      }
      

  }

}
