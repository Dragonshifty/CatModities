package Catmodities;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import java.util.Random;
import javafx.scene.media.AudioClip;
import java.util.LinkedHashMap;

public class App extends Application {

   Stage window;

   // Set instance variables
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
   Label message;

   Button rainbowBuy;
   Button rainbowSell;
   Button ashyBuy;
   Button ashySell;
   Button yarnBuy;
   Button yarnSell;
   Button toyMouseBuy;
   Button toyMouseSell;
   Button scratchingPostBuy;
   Button scratchingPostSell;
   Button fortressBuy;
   Button fortressSell;
   Button ashyTreatsTooBuy;
   Button ashyTreatsTooSell;
   Button randomMothBuy;
   Button randomMothSell;
   Button dreamsiesBuy;
   Button dreamsiesSell;
   Button catNipBuy;
   Button catNipSell;
   Button megaMunchiesBuy;
   Button megaMunchiesSell;
   Button buyHouse;

   boolean apartmentChecked = false;
   boolean seaviewCottageChecked = false;
   boolean penthouseSuiteChecked = false;
   boolean mansionChecked = false; 

   AudioClip intermission;
   AudioClip endDaySound;
   AudioClip crashRiseSound;
   AudioClip buySound;
   AudioClip sellSound;

   int dayCounter = 1;
   int weekCounter = 1;

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
      House house = new House();

      //Load Fonts 
      try{
         Font.loadFont(getClass().getResource("/Catmodities/Resources/Fonts/Barriecito-Regular.ttf").toExternalForm(),10);
         Font.loadFont(getClass().getResource("/Catmodities/Resources/Fonts/Delius-Regular.ttf").toExternalForm(),10);
      } catch (Exception ex){
         ex.printStackTrace();
      }

      //Load frequented sounds
      try{
         endDaySound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/End_Day.wav").toExternalForm());
         crashRiseSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/crashRise.wav").toExternalForm());
         buySound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/buy.wav").toExternalForm());
         sellSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/sell.wav").toExternalForm());
         } catch (Exception ex){
            ex.printStackTrace();
         }

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
      
      buyHouse = new Button("Buy House");
      buyHouse.setMinWidth(90);
      GridPane.setConstraints(buyHouse, 0, 8);
      GridPane.setHalignment(buyHouse, HPos.CENTER);

      Label message = new Label("");
      message.setId("message");
      GridPane.setConstraints(message, 0, 12);
      GridPane.setHalignment(message, HPos.CENTER);

      Button instructions = new Button("Instructions");
      instructions.setId("panel");
      instructions.setMinWidth(90);
      GridPane.setConstraints(instructions, 0, 17);
      GridPane.setHalignment(instructions, HPos.CENTER);

      Button save = new Button("Save");
      save.setId("panel");
      save.setMinWidth(90);
      GridPane.setConstraints(save, 0, 19);
      GridPane.setHalignment(save, HPos.CENTER);
     
      Button load = new Button("Load");
      load.setId("panel");
      load.setMinWidth(90);
      GridPane.setConstraints(load, 0, 21);
      GridPane.setHalignment(load, HPos.CENTER);

      Button quit = new Button("Quit");
      quit.setId("panel");
      quit.setMinWidth(90);
      GridPane.setConstraints(quit, 0, 23);
      GridPane.setHalignment(quit, HPos.CENTER);

      gridLeft.getChildren().addAll(day, dayCount, buyHouse, message, load, save, instructions, quit);

      BorderPane pane = new BorderPane();
      pane.setTop(gridTop);
      pane.setCenter(grid);
      pane.setLeft(gridLeft);

      // SPLASH scene
      GridPane gridSplash = new GridPane();
      gridSplash.setAlignment(Pos.CENTER);
      gridSplash.setVgap(10);
      gridSplash.setPadding(new Insets(10, 10, 10, 10));
      
      Label titleSplash = new Label("CatModities");
      titleSplash.setId("titlesplash");
      GridPane.setConstraints(title, 0, 0);
      
      Button switchIt = new Button("Enter");
      GridPane.setConstraints(switchIt, 0,6);
      GridPane.setHalignment(switchIt, HPos.CENTER);
      gridSplash.getChildren().addAll(titleSplash, switchIt);

      VBox splashText = new VBox(10);
      Text copyright = new Text("Dragonshifty Studios 2022 © - Music by James Fitt ©");
      copyright.setFill(Color.WHITE);
      splashText.setPadding(new Insets(10, 0, 20, 0));
      splashText.setAlignment(Pos.CENTER);
      splashText.getChildren().add(copyright);

      BorderPane paneSplash = new BorderPane();
      paneSplash.setCenter(gridSplash);
      paneSplash.setBottom(splashText);

      Scene sceneSplash = new Scene(paneSplash, 1100, 650);
      sceneSplash.getStylesheets().add("/Catmodities/Resources/Style/Splash.css");

      // Play splash screen music
      introMusicPlay();

      // Main Window
      Scene scene = new Scene(pane, 1100, 650);
      scene.getStylesheets().add("/Catmodities/Resources/Style/style.css");     
      window.setScene(sceneSplash); 
      window.show();

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
      rainbowBuy = new Button("Buy");
      GridPane.setConstraints(rainbowBuy, 8, 2);
      rainbowBuy.setDisable(true);
      rainbowSell = new Button("Sell");
      GridPane.setConstraints(rainbowSell, 9, 2);
      rainbowSell.setDisable(true);
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
      ashyBuy = new Button("Buy");
      GridPane.setConstraints(ashyBuy, 0, 7);
      ashyBuy.setDisable(true);
      ashySell = new Button("Sell");
      GridPane.setConstraints(ashySell, 1, 7);
      ashySell.setDisable(true);
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
      yarnBallPrice.setId("pricelabel2");
      GridPane.setConstraints(yarnBallPrice, 3, 6);
      yarnBuy = new Button("Buy");
      GridPane.setConstraints(yarnBuy, 2, 7);
      yarnBuy.setDisable(true);
      yarnSell = new Button("Sell");
      GridPane.setConstraints(yarnSell, 3, 7);
      yarnSell.setDisable(true);
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
      toyMousePrice.setId("pricelabel2");
      GridPane.setConstraints(toyMousePrice, 5, 6);
      toyMouseBuy = new Button("Buy");
      GridPane.setConstraints(toyMouseBuy, 4, 7);
      toyMouseBuy.setDisable(true);
      toyMouseSell = new Button("Sell");
      GridPane.setConstraints(toyMouseSell, 5, 7);
      toyMouseSell.setDisable(true);
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
      scratchingPostBuy = new Button("Buy");
      GridPane.setConstraints(scratchingPostBuy, 6, 7);
      scratchingPostBuy.setDisable(true);
      scratchingPostSell = new Button("Sell");
      GridPane.setConstraints(scratchingPostSell, 7, 7);
      scratchingPostSell.setDisable(true);
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
      fortressBuy = new Button("Buy");
      GridPane.setConstraints(fortressBuy, 8, 7);
      fortressBuy.setDisable(true);
      fortressSell = new Button("Sell");
      GridPane.setConstraints(fortressSell, 9, 7);
      fortressSell.setDisable(true);
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
      ashyTreatsTooBuy = new Button("Buy");
      GridPane.setConstraints(ashyTreatsTooBuy, 0, 12);
      ashyTreatsTooBuy.setDisable(true);
      ashyTreatsTooSell = new Button("Sell");
      GridPane.setConstraints(ashyTreatsTooSell, 1, 12);
      ashyTreatsTooSell.setDisable(true);
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
      randomMothBuy = new Button("Buy");
      GridPane.setConstraints(randomMothBuy, 2, 12);
      randomMothBuy.setDisable(true);
      randomMothSell = new Button("Sell");
      GridPane.setConstraints(randomMothSell, 3, 12);
      randomMothSell.setDisable(true);
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
      dreamsiesBuy = new Button("Buy");
      GridPane.setConstraints(dreamsiesBuy, 4, 12);
      dreamsiesBuy.setDisable(true);
      dreamsiesSell = new Button("Sell");
      GridPane.setConstraints(dreamsiesSell, 5, 12);
      dreamsiesSell.setDisable(true);
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
      catNipBuy = new Button("Buy");
      GridPane.setConstraints(catNipBuy, 6, 12);
      catNipBuy.setDisable(true);
      catNipSell = new Button("Sell");
      GridPane.setConstraints(catNipSell, 7, 12);
      catNipSell.setDisable(true);
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
      megaMunchiesBuy = new Button("Buy");
      GridPane.setConstraints(megaMunchiesBuy, 8, 12);
      megaMunchiesBuy.setDisable(true);
      megaMunchiesSell = new Button("Sell");
      GridPane.setConstraints(megaMunchiesSell, 9, 12);
      megaMunchiesSell.setDisable(true);
      wholesalerMegaMunchies = new Label("" + treat.megaMunchiesStockLevel);
      GridPane.setConstraints(wholesalerMegaMunchies, 8, 13);
      warehouseMegaMunchies = new Label("" + warehouse.getMegaMunchiesStock());
      warehouseMegaMunchies.setId("warehouse");
      GridPane.setConstraints(warehouseMegaMunchies, 9, 13);

      grid.getChildren().addAll(megaMunchies, megaMunchiesPrice, megaMunchiesBuy,
      megaMunchiesSell, wholesalerMegaMunchies, warehouseMegaMunchies);

      // End Day Button
      Button endDay = new Button("End Day");
      endDay.setId("endDay");
      GridPane.setConstraints(endDay, 0, 15);

      // House Labels
      Label houseLabel = new Label("House Level:");
      GridPane.setConstraints(houseLabel, 2, 15);
      GridPane.setHalignment(houseLabel, HPos.RIGHT);

      Label houseLevel = new Label("" + house.getHouseLevel());
      houseLevel.setId("showbalance");
      GridPane.setConstraints(houseLevel, 3, 15);
      GridPane.setColumnSpan(houseLevel, 2);

      // Bank balance and labels
      Label bankBalanceLabel = new Label("Bank Balance");
      bankBalanceLabel.setId("bankbalance");
      GridPane.setConstraints(bankBalanceLabel, 6, 15);
      GridPane.setHalignment(bankBalanceLabel, HPos.RIGHT);
      GridPane.setColumnSpan(bankBalanceLabel, 2);
      Label showBalance = new Label();
      showBalance.setText("" + bank.getBalance());
      showBalance.setId("showbalance");
      GridPane.setConstraints(showBalance, 8, 15);

      grid.getChildren().addAll(endDay, houseLabel, houseLevel, bankBalanceLabel, showBalance);

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
            playBuy();
         }          
      });

      headsSellButton.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("FishHeads"), fish.fishHeadsStockLevel, warehouse.getFishHeadsStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.fishHeadsStockLevel = holding[0];
            wholesalerFishHeads.setText("" + holding[0]);
            warehouse.setWareHouseFishHeads(holding[1]);
            warehouseFishHeads.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });
   
      fishyTreatsBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Fishy Treats"), fish.fishyTreatsStockLevel, warehouse.getFishyTreatsStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.fishyTreatsStockLevel = holding[0];
            wholesalerFishyTreats.setText("" + holding[0]);
            warehouse.setWarehouseFishyTreats(holding[1]);
            warehouseFishyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      fishyTreatsSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Fishy Treats"), fish.fishyTreatsStockLevel, warehouse.getFishyTreatsStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.fishyTreatsStockLevel = holding[0];
            wholesalerFishyTreats.setText("" + holding[0]);
            warehouse.setWarehouseFishyTreats(holding[1]);
            warehouseFishyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      codBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Cod"), fish.codStockLevel, warehouse.getWareHouseCodStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.codStockLevel = holding[0];
            wholesalerCod.setText("" + holding[0]);
            warehouse.setWarehouseCod(holding[1]);
            warehouseCod.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      codSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Cod"), fish.codStockLevel, warehouse.getWareHouseCodStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.codStockLevel = holding[0];
            wholesalerCod.setText("" + holding[0]);
            warehouse.setWarehouseCod(holding[1]);
            warehouseCod.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      salmonBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Salmon Mousse"), fish.salmonStockLevel, warehouse.getSalmonStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.salmonStockLevel = holding[0];
            wholesalerSalmon.setText("" + holding[0]);
            warehouse.setWarehouseSalmon(holding[1]);
            warehouseSalmon.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      salmonSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Salmon Mousse"), fish.salmonStockLevel, warehouse.getSalmonStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.salmonStockLevel = holding[0];
            wholesalerSalmon.setText("" + holding[0]);
            warehouse.setWarehouseSalmon(holding[1]);
            warehouseSalmon.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      rainbowBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(fishPrices.get("Rainbow Trout"), fish.rainbowStockLevel, warehouse.getRainbowStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.rainbowStockLevel = holding[0];
            wholesalerRainbow.setText("" + holding[0]);
            warehouse.setWarehouseRainbow(holding[1]);
            warehouseRainbow.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      rainbowSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(fishPrices.get("Rainbow Trout"), fish.rainbowStockLevel, warehouse.getRainbowStock(), bank.getBalance());
         if (holding[3] == 1){
            fish.rainbowStockLevel = holding[0];
            wholesalerRainbow.setText("" + holding[0]);
            warehouse.setWarehouseRainbow(holding[1]);
            warehouseRainbow.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      ashyBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Ashy Treats"), toy.ashyTreatsStockLevel, warehouse.getAshyTreatsStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.ashyTreatsStockLevel = holding[0];
            wholesalerAshyTreats.setText("" + holding[0]);
            warehouse.setWarehouseAshTreats(holding[1]);
            warehouseAshyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      ashySell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Ashy Treats"), toy.ashyTreatsStockLevel, warehouse.getAshyTreatsStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.ashyTreatsStockLevel = holding[0];
            wholesalerAshyTreats.setText("" + holding[0]);
            warehouse.setWarehouseAshTreats(holding[1]);
            warehouseAshyTreats.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      yarnBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Yarn Ball"), toy.yarnBallStockLevel, warehouse.getYarnBallStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.yarnBallStockLevel = holding[0];
            wholesalerYarnBall.setText("" + holding[0]);
            warehouse.setWarehouseYarnBall(holding[1]);
            warehouseYarnBall.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      yarnSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Yarn Ball"), toy.yarnBallStockLevel, warehouse.getYarnBallStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.yarnBallStockLevel = holding[0];
            wholesalerYarnBall.setText("" + holding[0]);
            warehouse.setWarehouseYarnBall(holding[1]);
            warehouseYarnBall.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      toyMouseBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Toy Mouse"), toy.toyMouseStockLevel, warehouse.getToyMouseStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.toyMouseStockLevel = holding[0];
            wholesalerToyMouse.setText("" + holding[0]);
            warehouse.setWarehouseToyMouse(holding[1]);
            warehouseToyMouse.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      toyMouseSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Toy Mouse"), toy.toyMouseStockLevel, warehouse.getToyMouseStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.toyMouseStockLevel = holding[0];
            wholesalerToyMouse.setText("" + holding[0]);
            warehouse.setWarehouseToyMouse(holding[1]);
            warehouseToyMouse.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      scratchingPostBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Scratching Post"), toy.scratchingPostStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.scratchingPostStockLevel = holding[0];
            wholesalerScratchingPost.setText("" + holding[0]);
            warehouse.setWarehouseScracthingPost(holding[1]);
            warehouseScratchingPost.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      scratchingPostSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Scratching Post"), toy.scratchingPostStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.scratchingPostStockLevel = holding[0];
            wholesalerScratchingPost.setText("" + holding[0]);
            warehouse.setWarehouseScracthingPost(holding[1]);
            warehouseScratchingPost.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      fortressBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(toyPrices.get("Fortress"), toy.fortressStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.fortressStockLevel = holding[0];
            wholesalerFortress.setText("" + holding[0]);
            warehouse.setWarehouseFortress(holding[1]);
            warehouseFortress.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      fortressSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(toyPrices.get("Fortress"), toy.fortressStockLevel, warehouse.getScratchingPostStock(), bank.getBalance());
         if (holding[3] == 1){
            toy.fortressStockLevel = holding[0];
            wholesalerFortress.setText("" + holding[0]);
            warehouse.setWarehouseFortress(holding[1]);
            warehouseFortress.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      ashyTreatsTooBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Ashy Treats Too"), treat.ashyTreatsTooStockLevel, warehouse.getAshyTreatsTooStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.ashyTreatsTooStockLevel = holding[0];
            wholesalerAshyTreatsToo.setText("" + holding[0]);
            warehouse.setWarehouseAshyTreatsToo(holding[1]);
            warehouseAshyTreatsToo.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      ashyTreatsTooSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Ashy Treats Too"), treat.ashyTreatsTooStockLevel, warehouse.getAshyTreatsTooStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.ashyTreatsTooStockLevel = holding[0];
            wholesalerAshyTreatsToo.setText("" + holding[0]);
            warehouse.setWarehouseAshyTreatsToo(holding[1]);
            warehouseAshyTreatsToo.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      randomMothBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Random Moth"), treat.randomMothStockLevel, warehouse.getRandomMothStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.randomMothStockLevel = holding[0];
            wholesalerRandomMoth.setText("" + holding[0]);
            warehouse.setWarehouseRandomMoth(holding[1]);
            warehouseRandomMoth.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      randomMothSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Random Moth"), treat.randomMothStockLevel, warehouse.getRandomMothStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.randomMothStockLevel = holding[0];
            wholesalerRandomMoth.setText("" + holding[0]);
            warehouse.setWarehouseRandomMoth(holding[1]);
            warehouseRandomMoth.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      dreamsiesBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Dreamsies"), treat.dreamsiesStockLevel, warehouse.getDreamsiesStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.dreamsiesStockLevel = holding[0];
            wholesalerDreamsies.setText("" + holding[0]);
            warehouse.setWarehouseDreamsies(holding[1]);
            warehouseDreamsies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      dreamsiesSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Dreamsies"), treat.dreamsiesStockLevel, warehouse.getDreamsiesStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.dreamsiesStockLevel = holding[0];
            wholesalerDreamsies.setText("" + holding[0]);
            warehouse.setWarehouseDreamsies(holding[1]);
            warehouseDreamsies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      catNipBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("CatNip"), treat.catNipStockLevel, warehouse.getCatNipStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.catNipStockLevel = holding[0];
            wholesalerCatNip.setText("" + holding[0]);
            warehouse.setWarehouseCatNip(holding[1]);
            warehouseCatNip.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      catNipSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("CatNip"), treat.catNipStockLevel, warehouse.getCatNipStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.catNipStockLevel = holding[0];
            wholesalerCatNip.setText("" + holding[0]);
            warehouse.setWarehouseCatNip(holding[1]);
            warehouseCatNip.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      megaMunchiesBuy.setOnAction(e -> {
         int[] holding = new int[3];
         holding = BuyBox.buy(treatPrices.get("Mega Munchies"), treat.megaMunchiesStockLevel, warehouse.getMegaMunchiesStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.megaMunchiesStockLevel = holding[0];
            wholesalerMegaMunchies.setText("" + holding[0]);
            warehouse.setWarehouseMegaMunchies(holding[1]);
            warehouseMegaMunchies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playBuy();
         }          
      });

      megaMunchiesSell.setOnAction(e -> {
         int[] holding = new int[3];
         holding = SellBox.sell(treatPrices.get("Mega Munchies"), treat.megaMunchiesStockLevel, warehouse.getMegaMunchiesStock(), bank.getBalance());
         if (holding[3] == 1){
            treat.megaMunchiesStockLevel = holding[0];
            wholesalerMegaMunchies.setText("" + holding[0]);
            warehouse.setWarehouseMegaMunchies(holding[1]);
            warehouseMegaMunchies.setText("" + holding[1]);
            bank.setBalance(holding[2]);
            showBalance.setText("" + holding[2]);
            playSell();
         }          
      });

      // Switch from splash screen to main window
      switchIt.setOnAction(e -> {
         try {
            intermission.stop();
         } catch (Exception ex){
            ex.printStackTrace();
         }
         window.setScene(scene);
         playBegin();
         storyEvent.runPage(true, bank, fish, toy, treat, warehouse, house);
      });

      // Left panel buttons
      buyHouse.setOnAction(e -> {
         house.upgradeHouse(bank);
         showBalance.setText("" + bank.getBalance());
         houseLevel.setText("" + house.getHouseLevel());
      });

      save.setOnAction(e ->{
         SaveLoad saveGame = new SaveLoad();
         saveGame.save(bank, house, warehouse, dayCounter, weekCounter, day.getText());
         message.setText(saveGame.getMessageHold());
         if (saveGame.getMessageHold() == "Saved") playSuccess();
      });

      load.setOnAction(e -> {
         SaveLoad loadGame = new SaveLoad();
         int[] counters = loadGame.load(bank, house, warehouse);
         houseLevel.setText("" + house.getHouseLevel());
         getWarehouseStock(warehouse);
         checkHouseLevel(house);
         if (counters[3] == 1){
            dayCounter = counters[0];
            weekCounter = counters[1];
            dayCount.setText("" + dayCounter);
            switch(counters[2]){
               case 1:
                  day.setText("Monday");
                  break;
               case 2:
                  day.setText("Tuesday");
                  break;
               case 3:
                  day.setText("Wednesday");
                  break;
               case 4:
                  day.setText("Thursday");
                  break;
               case 5:
                  day.setText("Friday");
                  break;
            }
            playSuccess();
         }
         message.setText(loadGame.getMessageHold());
      });

      instructions.setOnAction(e ->{
         Instructions instruct = new Instructions();
         instruct.showInstructions();
      });

      quit.setOnAction(e ->{
         boolean confirm = Quit.quit();
         if (confirm) window.close();
      });

      // End day commands
      endDay.setOnAction(e -> {
         playEndDay();
         // Send today's prices for comparison
         HighLow highLow = new HighLow();
         highLow.recordOld(fish.getArray(), toy.getArray(), treat.getArray());    

         // Reset crash/rise and set vendor prices
         CrashRise crashRise = new CrashRise();
         crashRise.resetCrashRise(fish, toy, treat);
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

         // Set day, check for crash/rise, check rent due (with reminder), possible story
         String messageHold = "";
         switch(day.getText()){
            case "Monday":
               day.setText("Tuesday");
               messageHold = crashRise.runCrashRiseChance(fish, toy, treat);
               if (weekCounter % 4 == 0){
                  house.rentReminder();
               }
               break;
            case "Tuesday":
               day.setText("Wednesday");
               messageHold = crashRise.runCrashRiseChance(fish, toy, treat);
               break;
            case "Wednesday":
               day.setText("Thursday");
               messageHold = crashRise.runCrashRiseChance(fish, toy, treat);
               break;
            case "Thursday":
               day.setText("Friday");
               weekCounter++;
               messageHold = crashRise.runCrashRiseChance(fish, toy, treat);
               if (dayCounter % 20 == 0){
                  house.payRent(bank);
               }
               break;
            case "Friday":
               day.setText("Monday");
               fish.restock();
               toy.restock();
               treat.restock();
               Random random = new Random();
               int randomStory = random.nextInt(2);
               if (randomStory == 1){
                  messageHold = storyEvent.runPage(false, bank, fish, toy, treat, warehouse, house);
               }
               break;
         }

         // Reset GUI methods
         getWholesalerStock(fish, toy, treat);
         getWarehouseStock(warehouse);
         getPrices(fishPrices, toyPrices, treatPrices);
         checkHouseLevel(house);
         houseLevel.setText("" + house.getHouseLevel());
         showBalance.setText("" + bank.getBalance());
         message.setText(messageHold);
         
         // Get comparitive figures for yesterday and today
         int[] compareDays = highLow.getHighLow(fish.getArray(), toy.getArray(), treat.getArray());
         showHighLow(compareDays, fish, toy, treat, warehouse);
         
      });
   }

   void getWholesalerStock(Wholesaler fish, Wholesaler toy, Wholesaler treat){
      // Reset wholesaler GUI
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
      // Reset own stock GUI
      warehouseFishHeads.setText("" + warehouse.getFishHeadsStock());
      warehouseFishyTreats.setText("" + warehouse.getFishyTreatsStock());
      warehouseCod.setText("" + warehouse.getWareHouseCodStock());
      warehouseSalmon.setText("" + warehouse.getSalmonStock());
      warehouseRainbow.setText("" + warehouse.getRainbowStock());
      warehouseAshyTreats.setText("" + warehouse.getAshyTreatsStock());
      warehouseYarnBall.setText("" + warehouse.getYarnBallStock());
      warehouseToyMouse.setText("" + warehouse.getToyMouseStock());
      warehouseScratchingPost.setText("" + warehouse.getScratchingPostStock());
      warehouseFortress.setText("" + warehouse.getFortressStock());
      warehouseAshyTreatsToo.setText("" + warehouse.getAshyTreatsTooStock());
      warehouseRandomMoth.setText("" + warehouse.getRandomMothStock());
      warehouseDreamsies.setText("" + warehouse.getDreamsiesStock());
      warehouseCatNip.setText("" + warehouse.getCatNipStock());
      warehouseMegaMunchies.setText("" + warehouse.getMegaMunchiesStock()); 
   }

   void getPrices(LinkedHashMap fishPrices, LinkedHashMap toyPrices, LinkedHashMap treatPrices){
      // Reset prices GUI
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

   // Set price label, red for higher than yeterday/white for same/green for lower
   void showHighLow(int [] compareDays, Wholesaler fish, Wholesaler toy, Wholesaler treat, Warehouse warehouse){
      if (compareDays[0] == 0){
         fishHeadsPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[0] == 1){
         fishHeadsPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[0] == 2) {
         fishHeadsPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[1] == 0){
         fishyTreatsPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[1] == 1){
         fishyTreatsPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[1] == 2) {
         fishyTreatsPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[2] == 0){
         codPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[2] == 1){
         codPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[2] == 2) {
         codPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[3] == 0){
         salmonPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[3] == 1){
         salmonPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[3] == 2) {
         salmonPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[4] == 0){
         rainbowPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[4] == 1){
         rainbowPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[4] == 2) {
         rainbowPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[5] == 0){
         ashyTreatsPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[5] == 1){
         ashyTreatsPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[5] == 2) {
         ashyTreatsPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[6] == 0){
         yarnBallPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[6] == 1){
         yarnBallPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[6] == 2) {
         yarnBallPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[7] == 0){
         toyMousePrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[7] == 1){
         toyMousePrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[7] == 2) {
         toyMousePrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[8] == 0){
         scratchingPostPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[8] == 1){
         scratchingPostPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[8] == 2) {
         scratchingPostPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[9] == 0){
         fortressPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[9] == 1){
         fortressPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[9] == 2) {
         fortressPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[10] == 0){
         ashyTreatsTooPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[10] == 1){
         ashyTreatsTooPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[10] == 2) {
         ashyTreatsTooPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[11] == 0){
         randomMothPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[11] == 1){
         randomMothPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[11] == 2) {
         randomMothPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[12] == 0){
         dreamsiesPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[12] == 1){
         dreamsiesPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[12] == 2) {
         dreamsiesPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[13] == 0){
         catNipPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[13] == 1){
         catNipPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[13] == 2) {
         catNipPrice.setStyle("-fx-text-fill: green");
      }
      if (compareDays[14] == 0){
         megaMunchiesPrice.setStyle("-fx-text-fill: red");
      } else if (compareDays[14] == 1){
         megaMunchiesPrice.setStyle("-fx-text-fill: white");
      } else if (compareDays[14] == 2) {
         megaMunchiesPrice.setStyle("-fx-text-fill: green");
      }

      // Set stock indicators - black for no stock, white for stock
      if (warehouse.getFishHeadsStock() > 0){
         warehouseFishHeads.setStyle("-fx-text-fill: white");
      } else if (warehouse.getFishHeadsStock() == 0){
         warehouseFishHeads.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getFishyTreatsStock() > 0){
         warehouseFishyTreats.setStyle("-fx-text-fill: white");
      } else if (warehouse.getFishyTreatsStock() == 0){
         warehouseFishyTreats.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getWareHouseCodStock() > 0){
         warehouseCod.setStyle("-fx-text-fill: white");
      } else if (warehouse.getWareHouseCodStock() == 0){
         warehouseCod.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getSalmonStock() > 0){
         warehouseSalmon.setStyle("-fx-text-fill: white");
      } else if (warehouse.getSalmonStock() == 0){
         warehouseSalmon.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getRainbowStock() > 0){
         warehouseRainbow.setStyle("-fx-text-fill: white");
      } else if (warehouse.getRainbowStock() == 0){
         warehouseRainbow.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getAshyTreatsStock() > 0){
         warehouseAshyTreats.setStyle("-fx-text-fill: white");
      } else if (warehouse.getAshyTreatsStock() == 0){
         warehouseAshyTreats.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getYarnBallStock() > 0){
         warehouseYarnBall.setStyle("-fx-text-fill: white");
      } else if (warehouse.getYarnBallStock() == 0){
         warehouseYarnBall.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getToyMouseStock() > 0){
         warehouseToyMouse.setStyle("-fx-text-fill: white");
      } else if (warehouse.getToyMouseStock() == 0){
         warehouseToyMouse.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getScratchingPostStock() > 0){
         warehouseScratchingPost.setStyle("-fx-text-fill: white");
      } else if (warehouse.getScratchingPostStock() == 0){
         warehouseScratchingPost.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getFortressStock() > 0){
         warehouseFortress.setStyle("-fx-text-fill: white");
      } else if (warehouse.getFortressStock() == 0){
         warehouseFortress.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getAshyTreatsTooStock() > 0){
         warehouseAshyTreatsToo.setStyle("-fx-text-fill: white");
      } else if (warehouse.getAshyTreatsTooStock() == 0){
         warehouseAshyTreatsToo.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getRandomMothStock() > 0){
         warehouseRandomMoth.setStyle("-fx-text-fill: white");
      } else if (warehouse.getRandomMothStock() == 0){
         warehouseRandomMoth.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getDreamsiesStock() > 0){
         warehouseDreamsies.setStyle("-fx-text-fill: white");
      } else if (warehouse.getDreamsiesStock() == 0){
         warehouseDreamsies.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getCatNipStock() > 0){
         warehouseCatNip.setStyle("-fx-text-fill: white");
      } else if (warehouse.getCatNipStock() == 0){
         warehouseCatNip.setStyle("-fx-text-fill: grey");
      }
      if (warehouse.getMegaMunchiesStock() > 0){
         warehouseMegaMunchies.setStyle("-fx-text-fill: white");
      } else if (warehouse.getMegaMunchiesStock() == 0){
         warehouseMegaMunchies.setStyle("-fx-text-fill: grey");
      }
   }
     
   void checkHouseLevel(House house){
      // Check to see if house level open and only change buttons if true
      if (!apartmentChecked){
         if (house.apartmentOpen){
            ashyBuy.setDisable(false);
            ashySell.setDisable(false);
            yarnBuy.setDisable(false);
            yarnSell.setDisable(false);
            toyMouseBuy.setDisable(false);
            toyMouseSell.setDisable(false);
            scratchingPostBuy.setDisable(false);
            scratchingPostSell.setDisable(false);
            apartmentChecked = true;
         }
      }
      if (!seaviewCottageChecked){
         if (house.seaviewCottageOpen){
            ashyTreatsTooBuy.setDisable(false);
            ashyTreatsTooSell.setDisable(false);
            randomMothBuy.setDisable(false);
            randomMothSell.setDisable(false);
            dreamsiesBuy.setDisable(false);
            dreamsiesSell.setDisable(false);
            catNipBuy.setDisable(false);
            catNipSell.setDisable(false);
            seaviewCottageChecked = true;
         }
      }
      if (!penthouseSuiteChecked){
         if (house.penthouseSuiteOpen){
            rainbowBuy.setDisable(false);
            rainbowSell.setDisable(false);
            fortressBuy.setDisable(false);
            fortressSell.setDisable(false);
            megaMunchiesBuy.setDisable(false);
            megaMunchiesSell.setDisable(false);
            penthouseSuiteChecked = true;
         }
      }
      if (!mansionChecked){
         if (house.mansionOpen){
            buyHouse.setDisable(true);
         }
      }
   }

   // Sound methods
   void playEndDay(){
      try{
         endDaySound.play();    
         } catch (Exception ex){
            ex.printStackTrace();
         }
   }

   void playSoundCrashRise(){
      try {
          crashRiseSound.play();
          } catch (Exception ex){
              ex.printStackTrace();
          }
   }

   void playBuy(){
      try {
         buySound.play();
         } catch (Exception ex){
             ex.printStackTrace();
         }
   }

   void playSell(){
      try {
         sellSound.play();
         } catch (Exception ex){
             ex.printStackTrace();
         }
   }

   void playSuccess(){
      try {
         AudioClip successSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/success.wav").toExternalForm());
         successSound.play();
         } catch (Exception ex){
             ex.printStackTrace();
         }
   }

   void playBegin(){
      try {
         AudioClip beginSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/begin.wav").toExternalForm());
         beginSound.play();
         } catch (Exception ex){
             ex.printStackTrace();
         }
   }

   void introMusicPlay(){
      try {
         intermission = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/Intermission.mp3").toExternalForm());
         intermission.play();
         } catch (Exception ex){
             ex.printStackTrace();
         }
   }
}
