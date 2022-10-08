package Catmodities;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.geometry.*;

import org.json.simple.JSONObject;
import java.util.LinkedHashMap;
// import java.io.FileWriter;
// import java.io.IOException;

public class App extends Application {

   Stage window;

   

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
      LinkedHashMap <String, Integer> fishPrices = fish.getPrices();
      LinkedHashMap <String, Integer> toyPrices = toy.getPrices();
      LinkedHashMap <String, Integer> treatPrices = treat.getPrices();

      // Instantiate bank and personal warehouse stock
      Bank bank = new Bank();
      Warehouse warehouse = new Warehouse();
      
      // Set window
      window = primaryStage;
      window.setTitle("CatModities");

      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(8);
      grid.setHgap(10);


      Label title = new Label("CatModities");
      GridPane.setConstraints(title, 0, 0);

      Label day = new Label("Day");
      GridPane.setConstraints(day, 0, 1);

      Label message = new Label("Message Board");
      GridPane.setConstraints(message, 0, 2);

      Label marketStatus = new Label("Normal/Crash/Rise");
      GridPane.setConstraints(marketStatus, 3, 2);

      grid.getChildren().addAll(title, day, message, marketStatus);


      Label fishHeadsLabel = new Label("Fishheads");
      GridPane.setConstraints(fishHeadsLabel, 0, 3);
      Label fishHeadsPriceLabel = new Label(""+ fishPrices.get("FishHeads"));
      GridPane.setConstraints(fishHeadsPriceLabel, 1, 3);
      Button headsBuyButton = new Button("Buy");
      GridPane.setConstraints(headsBuyButton, 0, 4);
      Button headsSellButton = new Button("Sell");
      GridPane.setConstraints(headsSellButton, 1, 4);
      Label wholesalerFishHeads = new Label("" + fish.fishHeadsStockLevel);
      GridPane.setConstraints(wholesalerFishHeads, 0, 5);
      Label warehouseFishHeads = new Label("" + warehouse.getFishHeadsStock());
      GridPane.setConstraints(warehouseFishHeads, 1, 5);

      grid.getChildren().addAll(fishHeadsLabel, fishHeadsPriceLabel, 
      headsBuyButton, headsSellButton, wholesalerFishHeads, warehouseFishHeads);






      Scene scene = new Scene(grid, 1100, 650);
      scene.getStylesheets().add("/Catmodities/style.css");
      window.setScene(scene); 
      
      window.show();

      
      

   }


}
