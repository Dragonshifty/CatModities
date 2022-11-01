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
import javafx.scene.media.AudioClip;

class StoryEvent {

private final String begin = "'Here, catch! That twenty I owe you!' Your old friend greets you off the the boat after a long voyage to start a new life in Felixton. 'You can stay on my sofa whilst you get on your feet. In this town we trade our way to success, but it's not gonna be easy. Not all the traders will deal with you until you get better digs; kinda stuck up if you ask me, but that's Felixton for you.' He slaps you on the back. 'Still, you can use my warehouse, and you're sure gonna meet some characters along the way!' As you make your way along the dock you can't help but wonder what you've got yourself into...";
    
private final String pirates = "A ship full of cat pirates has recently docked, sharing tales of wild adventure on the high seas. They also bring crates stacked full of fish. Now would be an excellent time to buy some cheap stock.";

private final String rats = "Rats have recently infested one of your warehouses and have decimated yourstock! You lose 10% of your fish stocks.";

private final String boots = "You meet a mysterious cat adorned in fancy boots in a local tavern who gives you some wonderful investment advice, a great evening out, and a sore head in the morning.";

private final String fluff = "Reports are in that a random piece of fluff floated in from the window of the main Toy Mouse manufacturing plant, causing absolute chaos as workers abandon their tools to catch and play with it. Suspicion is cast upon rival manufacturers. Toy prices surge.";

private final String darkAlley = "Against your better judgement you meet with a shady-looking cat in a dark alley who offers you some cheap Scratching Posts.";

private final String junkYard = "One evening you stray into an open junk yard where you spot an elderly cat in the midst of song, reminiscing on her memories. Whilst the song is beautiful you get the distinct impression that dancing will soon be involved so decide to hightail it out of there quickly.";

private final String theft = "You wake up to reports that one of your warehouses has been broken-in to and stock is missing. Police have a suspect, but he insists that he was never there, so the matter is dropped. You lose 15% of your hard-earned cash.";

private final String smiling = "You decide to go for a stroll in the woods and happen upon an intruiging but somewhat annoying cat with a very broad grin on his face. You move along quickly. Treat prices are up.";

private final String owl = "Whilst venturing abroad you happen upon an exceptionally happy kitty with an equally joyous owl. In their jubilations they hand you some, albeit very sticky, money for you to do with what you will. Out of the corner of your eye you think you spot some airbourne livetock, but dismiss it as a trick of the light.";

private final String mittens = "You are confronted in the street by three young cats who proclaim they have lost their mittens. You convince them that cats actually have no need for gloves anyway and sell them some Dreamsies instead.";

private final String tigger = "Over the weekend you decide to go for a walk in a local wood to get away from the stresses of trading. Whilst there you meet a delightfully happy character bouncing along on his tail and singing 'happy and glee and copyright free!' As he leaves, Tigger slips you some cash from his recent book deal.";

private final String hello = "On a weekend trip to Japan you have a frustrating conversation with a curious white cat who keeps on saying hello and addressing you as Kitty each time you ask her her name. Still, the trip was great and you had a woderful time (although the airfare wasn't cheap).";

private final String lasagne = "On a lazy afternoon a lazy-looking cat lackadaisically leans into the lower floors, licks his lips and asks for some lasagne.";

private final String top = "As you're passing an alley you hear a 'pssst, is Dibble about?' You've no idea what he's on about but, after chatting a while, his street-smarts and savvy fincancial advise help you net some great deals. Your stocks have gone up.";

private final String pink = "Over the weekend a smart, rose-coloured panther enters your office to invest in your business. He says I might want to be on the lookout for a particular inspector but he doesn't have a Clue-so you shouldn't really worry about it.";

private final String hat = "Against your better judgement you arrange a deal for a curious cat in a curious hat. Upon delivery he claims that the delivery wasn't what he asks for. Despite explaining you never mentioned ham, and eggs really shouldn't be that colour anyway, he refuses to pay and the stock goes bad.";

private final String king = "Whilst on a hiking holiday you spot a baboon holding a young lion cub over a cliff, with all sorts of animals looking on. It really is a moving sight, despite the obvious disregard for any kind of health and safety.";

private final String tom = "You decide to go for a stroll in the park one afternoon and witness what looks to be a shocking assault when a small brown mouse hits a cat with a baseball bat. It turns out they're actually good friends and do this sort of thing all the time. You guess the cat is just very resilient to kinetic energy or something? Who knows; people are weird sometimes.";

private final String path = "You step outside the warehouse and a black cat crosses in front of you. Just after this you spot something shiny on the ground and find some money. You thank your geographically-based luck; if you hadn't have been in the UK it might have been bad luck!";

private final String shop = "After a pleasant morning spent window shopping in town you come across an odd scene where lots of mice are singing and crafting things around a pink and white stripy cat. At least you thought that's what you saw. When you glance back in the shop window everyone is completely still. You put it down to a bad batch of Ashy Treats.";

private final String wardrobe = "For reasons known only to yourself you decide to check whether your wardrobe would be a good hiding place (you never know when someone will drop round for a quick game of hide and seek, I guess?). You're somewhat alarmed to find a lot more coats are there than you previously thought and it actually backs out onto a snowy landscape you didn't think was physically possible, given the confines of this kind of furniture. You're greeted by a huge friendly lion who suggests investing in toys (useful information, if a bit odd). You return home with a greater respect for lions (and carpentry, come to think of it).";

private final String siam = "You happen upon a couple of Siamese cats. You can tell they're Siamese as they look just like Siamese cats, and they do indeed confirm this by singing a song about them being Siamese cats. They don't seem to mind whether you're pleased or not about this information, apparently.";

private final String puddy = "One Sunday afternoon a small yellow bird flies in and proclaims 'I tawt I saw a puddy tat'. Hardly surprising information given you're in a town full of cats, but hey, I guess it was just making conversation";

private final String face = "You come face to face with and strange floating cat with a gigantic head and tiny body. He says he's after a load of Ashy Treats but says he can only pay in Random Moths. You're slightly taken aback by his use of 'only' as you can't think of a universe where Random Moths wouldn't be accepted as local currency.";

private final String grumpy = "You enter the warehouse one morning and notice an unhappy-looking cat walk out. You ask him what the matter is and he immediately berates you for assuming he was sad just because he looks a bit grumpy. You apologise and he goes on his way. A little later you notice some money has gone missing, so apparently he's not making enough ad revenue money on YouTube and has resorted to petty theft. Which IS sad.";

private final String jungle = "On a recent visit abroad you decide to go on a jungle cruise. Against the advice from the tour rep you go off for an explore by yourself. In a terrifying encounter with an incredibly smooth-talking tiger you narrowly avoid by eaten. However, the tiger manages to steal your wallet as you make your escape, so just cash and a little bit of your dignity lost there.";

private final String tony = "You receive an interesting phone call one day from a tiger called Tony. He's in the cereals business but wants to branch out into other areas; he has some Ashy Treats and Salmon Mousse he wants us to sample. He keeps saying they're 'greeeeeaaaaaaaat', which just comes across as a bit pushy, really. Still, you're not one to turn down free stuff.";


List <String> eventList = new ArrayList<>();

public String runPage(boolean start, Bank bank, Wholesaler fish, Wholesaler toy, Wholesaler treat, Warehouse warehouse, House house){
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Story");
    window.setMinWidth(250);
    
    BorderPane pane = new BorderPane();
    GridPane grid = new GridPane();
    TextFlow page = new TextFlow();

    page.setPadding(new Insets(12,12,12, 12));
    page.setTextAlignment(TextAlignment.JUSTIFY);
    page.setMaxWidth(500);

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
    eventList.add(tigger);
    eventList.add(hello);
    eventList.add(lasagne);
    eventList.add(top);
    eventList.add(pink);
    eventList.add(hat);
    eventList.add(king);
    eventList.add(tom);
    eventList.add(path);
    eventList.add(shop);
    eventList.add(wardrobe);
    eventList.add(siam);
    eventList.add(puddy);
    eventList.add(face);
    eventList.add(grumpy);
    eventList.add(jungle);
    eventList.add(tony);

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
    page.getChildren().add(contents);

    String messageHold = "";
    
    if (start){
        contents.setText(begin);
    } else {
        // Pick event at random from event list
        Random random = new Random();
        int randomEvent = random.nextInt(eventList.size());
        String event = eventList.get(randomEvent);
        int tempBalance = bank.getBalance();
        contents.setText(event);
        switch(event){
            case pirates:
                fish.localCrash(true, 0.5);
                messageHold = "Fish CRASH!";
                playSoundCrashRise();
                break;
            case rats:          
                warehouse.setWareHouseFishHeads(fishHeads -= fishHeads * 0.1);
                warehouse.setWarehouseFishyTreats(fishyTreats -= fishyTreats * 0.1);
                warehouse.setWarehouseCod(cod -= cod * 0.1);
                warehouse.setWarehouseSalmon(salmon -= salmon * 0.1);
                messageHold = "Stock loss!";
                playSoundLoseMoney();
                break;
            case boots:
                bank.setBalance(tempBalance += tempBalance * 0.2);
                messageHold = "Cash GAIN!";
                playSoundGainMoney();
                break;
            case fluff:
                toy.localPriceRise(true, 0.5);
                messageHold = "Toy RISE!";
                playSoundCrashRise();
                break;
            case darkAlley:
                warehouse.setWarehouseScracthingPost(scratchingPost += 20);
                messageHold = "Stock GAIN!";
                playSoundGainMoney();
                break;
            case junkYard:
                treat.localCrash(true, 0.5);
                messageHold = "Treat CRASH!";
                playSoundCrashRise();
                break;
            case theft:
                tempBalance -= tempBalance * 0.1;
                tempBalance = (tempBalance < 1) ? 1 : tempBalance;
                bank.setBalance(tempBalance);
                messageHold = "Cash LOSS!";
                playSoundLoseMoney();
                break;
            case smiling:
                treat.localPriceRise(true, 0.5);
                messageHold = "Treat RISE!";
                playSoundCrashRise();
                break;
            case owl:
                switch (house.getHouseLevel()){
                    case "Friend's Sofa":
                        bank.setBalance(tempBalance += 200);
                        break;
                    case "Apartment":
                        bank.setBalance(tempBalance += 500);
                        break;
                    case "Seaview Terrace":
                        bank.setBalance(tempBalance += 1000);
                        break;
                    case "Penthouse Suite":
                        bank.setBalance(tempBalance += 2000);
                        break;
                    case "Mansion":
                        bank.setBalance(tempBalance += 10000);
                        break;
                }
                messageHold = "Cash GAIN!";
                playSoundGainMoney();
                break;
            case mittens:
            switch (house.getHouseLevel()){
                case "Friend's Sofa":
                    bank.setBalance(tempBalance += 50);
                    break;
                case "Apartment":
                    bank.setBalance(tempBalance += 200);
                    break;
                case "Seaview Terrace":
                    bank.setBalance(tempBalance += 500);
                    break;
                case "Penthouse Suite":
                    bank.setBalance(tempBalance += 800);
                    break;
                case "Mansion":
                    bank.setBalance(tempBalance += 1200);
                    break;
                }
                messageHold = "Cash GAIN!";
                playSoundGainMoney();
                break;
            case tigger:
            switch (house.getHouseLevel()){
                case "Friend's Sofa":
                    bank.setBalance(tempBalance += 100);
                    break;
                case "Apartment":
                    bank.setBalance(tempBalance += 300);
                    break;
                case "Seaview Terrace":
                    bank.setBalance(tempBalance += 750);
                    break;
                case "Penthouse Suite":
                    bank.setBalance(tempBalance += 1000);
                    break;
                case "Mansion":
                    bank.setBalance(tempBalance += 8000);
                    break;
                }
                messageHold = "Cash GAIN!";
                playSoundGainMoney();
                break;
            case hello:
                tempBalance -= 100;
                tempBalance = (tempBalance < 1) ? 1 : tempBalance;
                bank.setBalance(tempBalance);
                messageHold = "Cash LOSS!";
                playSoundLoseMoney();
                break;
            case lasagne:
                fish.localPriceRise(true, 0.5);
                messageHold = "Fish RISE!";
                playSoundCrashRise();
                break;
            case top:
                warehouse.setWarehouseYarnBall(yarnBall += 15);
                warehouse.setWarehouseDreamsies(dreamsies += 5);
                messageHold = "Stock GAIN!";
                playSoundGainMoney();
                break;
            case pink:
                bank.setBalance(tempBalance += 500);
                messageHold = "Cash GAIN!";
                playSoundGainMoney();
                break;
            case hat:
                tempBalance -= tempBalance * 0.3;
                tempBalance = (tempBalance < 1) ? 1 : tempBalance;
                bank.setBalance(tempBalance);
                messageHold = "Cash LOSS!";
                playSoundLoseMoney();
                break;
            case king:
                treat.localPriceRise(true, 0.5);
                messageHold = "Treat RISE!";
                playSoundCrashRise();
                break;
            case tom:
                warehouse.setWarehouseToyMouse(toyMouse += 30);
                messageHold = "Stock GAIN!";
                playSoundGainMoney();
                break;
            case path:
            switch (house.getHouseLevel()){
                case "Friend's Sofa":
                    bank.setBalance(tempBalance += 75);
                    break;
                case "Apartment":
                    bank.setBalance(tempBalance += 250);
                    break;
                case "Seaview Terrace":
                    bank.setBalance(tempBalance += 700);
                    break;
                case "Penthouse Suite":
                    bank.setBalance(tempBalance += 1000);
                    break;
                case "Mansion":
                    bank.setBalance(tempBalance += 2000);
                    break;
                }
                messageHold = "Cash GAIN!";
                playSoundGainMoney();
                break;
            case shop:
                if (warehouse.getAshyTreatsStock() > 0) warehouse.setWarehouseAshTreats(0);
                if (warehouse.getAshyTreatsTooStock() > 0) warehouse.setWarehouseAshyTreatsToo(0);
                playSoundLoseMoney();
                messageHold = "Stock LOSS!";
                break;
            case wardrobe:
                toy.localCrash(true, 0.7);
                messageHold = "Toy CRASH!";
                playSoundCrashRise();
                break;
            case siam:
                fish.localPriceRise(true, 0.7);
                messageHold = "Fish RISE!";
                playSoundCrashRise();
                break;
            case puddy:
                treat.localPriceRise(true, 0.5);
                messageHold = "Treat RISE!";
                playSoundCrashRise();
                break;
            case face:
                warehouse.setWarehouseRandomMoth(randomMoth += 200);
                messageHold = "Stock GAIN!";
                playSoundGainMoney();
                break;
            case grumpy:
                tempBalance -= tempBalance * 0.2;
                tempBalance = (tempBalance < 1) ? 1 : tempBalance;
                bank.setBalance(tempBalance);
                messageHold = "Cash LOSS!";
                playSoundLoseMoney();
                break;
            case jungle:
                tempBalance -= tempBalance * 0.15;
                tempBalance = (tempBalance < 1) ? 1 : tempBalance;
                bank.setBalance(tempBalance);
                messageHold = "Cash LOSS!";
                playSoundLoseMoney();
                break;
            case tony:
                warehouse.setWarehouseAshyTreatsToo(ashyTreatsToo += 100);
                warehouse.setWarehouseSalmon(salmon += 50);
                messageHold = "Stock GAIN!";
                playSoundGainMoney();
                break;
        }
    }
  

    Button ok = new Button("OK");
    GridPane.setConstraints(ok, 0, 0);
    grid.setPadding(new Insets(10, 10, 12, 10));
    grid.setAlignment(Pos.CENTER);
    grid.getChildren().add(ok);

    ok.setOnAction(e -> window.close());

    Scene scene = new Scene(pane);
    scene.getStylesheets().add("/Catmodities/Resources/Style/StoryStyle.css");
    window.setScene(scene);
    window.showAndWait();

    return messageHold;
}

    void playSoundCrashRise(){
        try {
            AudioClip crashRise = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/crashRise.wav").toExternalForm());
            crashRise.play();
            } catch (Exception ex){
                ex.printStackTrace();
            }
    }

    void playSoundLoseMoney(){
        try {
            AudioClip loseMoney = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/loseMoney.wav").toExternalForm());
            loseMoney.play();
            } catch (Exception ex){
                ex.printStackTrace();
            }
    }

    void playSoundGainMoney(){
        try {
            AudioClip gainMoney = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/gainMoney.wav").toExternalForm());
            gainMoney.play();
            } catch (Exception ex){
                ex.printStackTrace();
            }
    }

}
