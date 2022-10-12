package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.util.*;
import java.util.Random;

class StoryEvent {

private final String begin = "Welcome, my feline friend! You arrive in Felixton Town, fesh and ready to face the world, but with only 10 DollarBucks to your name. Can you find fame and fortune by trading your way to success. Beware, many pitfalls stand in your way. Plus there's always rent to worry about. Good luck!";
    
private final String pirates = "A ship full of cat pirates has recently docked, sharing tales of wild adventure on the high seas. They also bring crates stacked full of fish. Now would be an excellent time to buy some cheap stock.";

private final String rats = "Rats have recently infested one of your warehouses and have decimated yourstock! You lose 10% of your stocks.";

private final String boots = "You meet a mysterious cat adorned in fancy boots in a local tavern who gives you some wonderful investment advice, a great evening out, and a sore head in the morning.";

private final String fluff = "Reports are in that a random piece of fluff floated in from the window of the main Toy Mouse manufacturing plant, causing absolute chaos as workers abandon their tools to catch and play with it. Suspicion is cast upon rival manufacturers. Toy prices surge.";

private final String darkAlley = "Against your better judgement you meet with a shady-looking cat in a dark alley who offers you some cheap Scratching Posts.";

private final String junkYard = "One evening you stray into an open junk yard where you spot an elderly cat in the midst of song, reminiscing on her memories. Whilst the song is beautiful you get the distinct impression that dancing will soon be involved so decide to hightail it out of there quickly.";

private final String theft = "You wake up to reports that one of your warehouses has been broken-in to and stock is missing. Police have a suspect, but he insists that he was never there, so the matter is dropped. You lose 15% of your hard-earned cash.";

private final String smiling = "You decide to go for a stroll in the woods and happen upon an intruiging but somewhat annoying cat with a very broad grin on his face. You move along quickly. Treat prices are up.";

private final String owl = "Whilst venturing abroad you happen upon an exceptionally happy kitty with an equally joyous owl. In their jubilations they hand you some, albeit very sticky, money for you to do with what you will. Out of the corner of your eye you think you spot some airbourne livetock, but dismiss it as a trick of the light.";

private final String mittens = "You are confronted in the street by three young cats who proclaim they have lost their mittens. You convince them that cats actually have no need for gloves anyway and sell them some Dreamsies instead.";

List <String> eventList = new ArrayList<>();



public void runPage(boolean start, Bank bank, Wholesaler fish, Wholesaler toy, Wholesaler treat, Warehouse warehouse){
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Story");
    window.setMinWidth(250);
    
    BorderPane pane = new BorderPane();
    GridPane grid = new GridPane();
    TextFlow page = new TextFlow();

    page.setPadding(new Insets(10,10,10, 10));
    page.setTextAlignment(TextAlignment.CENTER);
    page.setMaxWidth(400);

    pane.setCenter(page);
    pane.setBottom(grid);

    // Add events to list
    eventList.add(pirates);
    eventList.add(rats);
    eventList.add(boots);
    eventList.add(fluff);
    eventList.add(darkAlley);
    eventList.add(junkYard);
    eventList.add(theft);
    eventList.add(smiling);
    eventList.add(owl);
    eventList.add(mittens);

    // Get warehouse items into local variables
    int fishHeads = warehouse.getFishHeadsStock();
    int fishyTreats = warehouse.getFishyTreatsStock();
    int cod = warehouse.getWareHouseCodStock();
    int salmon = warehouse.getSalmonStock();
    int rainbow = warehouse.getRainbowStock();
    int ashyTreats = warehouse.getAshyTreatsStock();
    int yarnBall = warehouse.getYarnBallStock();
    int toyMouse = warehouse.getToyMouseStock();
    int scratchingPost = warehouse.getScratchingPostStock();
    int fortress = warehouse.getFortressStock();
    int ashyTreatsToo = warehouse.getAshyTreatsTooStock();
    int randomMoth = warehouse.getRandomMothStock();
    int dreamsies = warehouse.getDreamsiesStock();
    int catNip = warehouse.getCatNipStock();
    int megaMunchies = warehouse.getMegaMunchiesStock();

    // Set text
    Text contents = new Text();
    contents.setFill(Color.WHITE);
    contents.setId("contents");
    

    if (start){
        contents.setText(begin);
    } else {
        // Pick event at random from event list
        Random random = new Random();
        int randomEvent = random.nextInt(eventList.size());
        String event = eventList.get(randomEvent);
        contents.setText(event);

        switch(event){
            case pirates:
                fish.localCrash(true, 0.5);
                break;
            case rats:
                warehouse.setWareHouseFishHeads(fishHeads -= fishHeads * 0.1);
                warehouse.setWarehouseFishyTreats(fishyTreats -= fishyTreats * 0.1);
                warehouse.setWarehouseCod(cod -= cod * 0.1);
                warehouse.setWarehouseSalmon(salmon -= salmon * 0.1);
                warehouse.setWareHouseFishHeads(rainbow -= rainbow * 0.1);
        }

    }

  
    






    

    

    page.getChildren().add(contents);

    Button ok = new Button("OK");
    GridPane.setConstraints(ok, 0, 0);
    grid.setPadding(new Insets(10, 10, 12, 10));
    grid.setAlignment(Pos.CENTER);
    grid.getChildren().add(ok);

    ok.setOnAction(e -> window.close());

    Scene scene = new Scene(pane);
    scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Barriecito&family=Mansalva");
    scene.getStylesheets().add("/Catmodities/Resources/StoryStyle.css");
    window.setScene(scene);
    window.showAndWait();
}

}
