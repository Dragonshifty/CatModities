package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class SaveLoad{

    String messageHold = "";
    int[] counters = new int[3];

    public String getMessageHold(){
        return messageHold;
    }
    
    public void save(Bank bank, House house, Warehouse warehouse, int dayCounter, int weekCounter){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Story");
        window.setMinWidth(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(12,12,12, 12));
        grid.setAlignment(Pos.CENTER);
        grid.setMaxWidth(300);

        HBox buttons = new HBox(20);
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setTop(grid);
        pane.setCenter(buttons);

        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");

        Label messageLabel = new Label(("Save Game?"));
        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setHalignment(messageLabel, HPos.CENTER);
        GridPane.setColumnSpan(messageLabel, 2);

        grid.getChildren().add(messageLabel);
        buttons.getChildren().addAll(ok, cancel);
        
        ok.setOnAction(e ->{
        JSONObject store = new JSONObject();

        store.put("balance", bank.getBalance());
        store.put("house", house.getHouseLevel());
        store.put("day", dayCounter);
        store.put("week", weekCounter);
        store.put("FishHeads", warehouse.getFishHeadsStock());
        store.put("Fishy Treats", warehouse.getFishyTreatsStock());
        store.put("Cod", warehouse.getWareHouseCodStock());
        store.put("Salmon Mousse", warehouse.getSalmonStock());
        store.put("Rainbow Trout", warehouse.getRainbowStock());
        store.put("Ashy Treats", warehouse.getAshyTreatsStock());
        store.put("Yarn Ball", warehouse.getYarnBallStock());
        store.put("Toy Mouse", warehouse.getToyMouseStock());
        store.put("Scratching Post", warehouse.getScratchingPostStock());
        store.put("Fortress", warehouse.getFortressStock());
        store.put("Ashy Treats Too", warehouse.getAshyTreatsTooStock());
        store.put("Random Moth", warehouse.getRandomMothStock());
        store.put("Dreamsies", warehouse.getDreamsiesStock());
        store.put("CatNip", warehouse.getCatNipStock());
        store.put("Mega Munchies", warehouse.getMegaMunchiesStock());

        try (FileWriter file = new FileWriter("save1.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(store.toJSONString()); 
            file.flush();
            messageHold = "Saved";
            window.close();
 
        } catch (IOException ex) {
            messageLabel.setText("Error writing file");
            e.consume();
        }
        });

        cancel.setOnAction(e -> window.close());

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Barriecito&family=Mansalva&family=Delius");
        scene.getStylesheets().add("/Catmodities/Resources/Buy.css");
        window.setScene(scene);
        window.showAndWait();
    }

    public int[] load (Bank bank, House house, Warehouse warehouse){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Story");
        window.setMinWidth(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(12,12,12, 12));
        grid.setAlignment(Pos.CENTER);
        grid.setMaxWidth(300);

        HBox buttons = new HBox(20);
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setTop(grid);
        pane.setCenter(buttons);

        Label messageLabel = new Label(("Load Game?"));
        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setHalignment(messageLabel, HPos.CENTER);
        GridPane.setColumnSpan(messageLabel, 2);
        grid.setVgap(8);
        grid.setHgap(8);

        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");

        grid.getChildren().add(messageLabel);
        buttons.getChildren().addAll(ok, cancel);

        ok.setOnAction(e -> {
            JSONParser parser = new JSONParser();

            try (Reader reader = new FileReader("save1.json")){
                JSONObject loadedFile = (JSONObject) parser.parse(reader);

                // Convert from JSON Long/String
                int balance = (int) (long) loadedFile.get("balance");
                String houseLevel = (String) loadedFile.get("house");
                int day = (int) (long) loadedFile.get("day");
                int week = (int) (long) loadedFile.get("week");
                int fishHeads = (int) (long) loadedFile.get("FishHeads");
                int fishyTreats = (int) (long) loadedFile.get("Fishy Treats");
                int cod = (int) (long) loadedFile.get("Cod");
                int salmon = (int) (long) loadedFile.get("Salmon Mousse");
                int rainbow = (int) (long) loadedFile.get("Rainbow Trout");
                int ashyTreats = (int) (long) loadedFile.get("Ashy Treats");
                int yarnBall = (int) (long) loadedFile.get("Yarn Ball");
                int toyMouse = (int) (long) loadedFile.get("Toy Mouse");
                int scratchingPost = (int) (long) loadedFile.get("Scratching Post");
                int fortress = (int) (long) loadedFile.get("Fortress");
                int ashyTreatsToo = (int) (long) loadedFile.get("Ashy Treats Too");
                int randomMoth = (int) (long) loadedFile.get("Random Moth");
                int dreamsies = (int) (long) loadedFile.get("CatNip");
                int catNip = (int) (long) loadedFile.get("FishHeads");
                int megaMunchies = (int) (long) loadedFile.get("Mega Munchies");

                bank.setBalance(balance);
                house.setCurrentHouseLevel(houseLevel);
                warehouse.setWareHouseFishHeads(fishHeads);
                warehouse.setWarehouseFishyTreats(fishyTreats);
                warehouse.setWarehouseCod(cod);
                warehouse.setWarehouseSalmon(salmon);
                warehouse.setWarehouseRainbow(rainbow);
                warehouse.setWarehouseFishyTreats(ashyTreats);
                warehouse.setWarehouseYarnBall(yarnBall);
                warehouse.setWarehouseToyMouse(toyMouse);
                warehouse.setWarehouseScracthingPost(scratchingPost);
                warehouse.setWarehouseFortress(fortress);
                warehouse.setWarehouseAshyTreatsToo(ashyTreatsToo);
                warehouse.setWarehouseRandomMoth(randomMoth);
                warehouse.setWarehouseDreamsies(dreamsies);
                warehouse.setWarehouseCatNip(catNip);
                warehouse.setWarehouseMegaMunchies(megaMunchies);

                // Return array - day/week/success = 1
                counters[0] = day;
                counters[1] = week;
                counters[2] = 1;

                messageHold = "Loaded";
                
                window.close();

            } catch(FileNotFoundException ex){
                messageLabel.setText("File Not Found");
                messageHold = "Error";
                counters[2] = 0;
                e.consume();
            } catch (IOException ex){
                messageLabel.setText("Error");
                messageHold = "Error";
                counters[2] = 0;
                ex.printStackTrace();
            } catch (ParseException ex){
                messageLabel.setText("Error");
                messageHold = "Error";
                counters[2] = 0;
                ex.printStackTrace();
            } catch (Exception ex){
                messageLabel.setText("Error");
                messageHold = "Error";
                counters[2] = 0;
                ex.printStackTrace();
            }
        });
        

        cancel.setOnAction(e -> window.close());

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Barriecito&family=Mansalva&family=Delius");
        scene.getStylesheets().add("/Catmodities/Resources/Sell.css");
        window.setScene(scene);
        window.showAndWait();

        return counters;
    }
}
