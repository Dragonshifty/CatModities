package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.media.AudioClip;

class House {
    private final String friendsSofa = "Friend's Sofa";
    private final String apartment = "Apartment";
    private final String seaviewCottage = "Seaview Terrace";
    private final String penthouseSuite = "Penthouse Suite";
    private final String mansion = "Mansion";

    int friendsSofaRent = 20;
    int apartmentRent = 350;
    int seaviewCottageRent = 900;
    int penthouseSuiteRent = 3000;
    int mansionRent = 10000;

    int apartmentCost = 1000;
    int seaviewCottageCost = 10000;
    int penthouseSuiteCost = 50000;
    int mansionCost = 100000;

    boolean apartmentOpen = false;
    boolean seaviewCottageOpen = false;
    boolean penthouseSuiteOpen = false;
    boolean mansionOpen = false;

    String houseLevel = friendsSofa;

    int tempBalance;

    public String getHouseLevel() {
        return houseLevel;
    }

    public void setCurrentHouseLevel(String houseString) {
        switch (houseString){
            case "Friend's Sofa":
                houseLevel = friendsSofa;
                break;
            case "Apartment":
                houseLevel = apartment;
                apartmentOpen = true;
                break;
            case "Seaview Terrace":
                houseLevel = seaviewCottage;
                apartmentOpen = true;
                seaviewCottageOpen = true;
                break;
            case "Penthouse Suite":
                houseLevel = penthouseSuite;
                apartmentOpen = true;
                seaviewCottageOpen = true;
                penthouseSuiteOpen = true;
                break;
            case "Mansion":
                houseLevel = mansion;
                apartmentOpen = true;
                seaviewCottageOpen = true;
                penthouseSuiteOpen = true;
                mansionOpen = true;
                break;
        }
    }

    public void payRent(Bank bank){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Rent");
        window.setMinWidth(250);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);        

        Label rentDueLabel = new Label("RENT DUE!");
        Label rentMessage = new Label();

        int tempBalance = bank.getBalance();
        switch(houseLevel){
            case friendsSofa:
                rentMessage.setText("" + houseLevel + " rent is " + friendsSofaRent);
                if ((tempBalance -= friendsSofaRent) < 1){
                    rentMessage.setText("Not enough funds - " + friendsSofaRent);
                    bank.setBalance(1);
                    playDowngradeHouse();
                } else {
                    playRent();
                    bank.setBalance(tempBalance);
                }
                break;
            case apartment:
                rentMessage.setText("" + houseLevel + " rent is " + apartmentRent);
                if ((tempBalance -= apartmentRent) < 1){
                    bank.setBalance(5);
                    rentMessage.setText("Not enough funds - " + apartmentRent + "! Back to Friend's Sofa!");
                    houseLevel = friendsSofa;
                    playDowngradeHouse();
                } else {
                    playRent();
                    bank.setBalance(tempBalance);
                }
                break;
            case seaviewCottage:
                rentMessage.setText("" + houseLevel + " rent is " + seaviewCottageRent);
                if ((tempBalance -= seaviewCottageRent) < 1){
                    bank.setBalance(50);
                    rentMessage.setText("Not enough funds - " + seaviewCottageRent + "! Back to the apartment!");
                    houseLevel = apartment;
                    playDowngradeHouse();
                } else {
                    playRent();
                    bank.setBalance(tempBalance);
                }
                break;
            case penthouseSuite:
                rentMessage.setText("" + houseLevel + " rent is " + penthouseSuiteRent);
                if ((tempBalance -= penthouseSuiteRent) < 1){
                    bank.setBalance(200);
                    rentMessage.setText("Not enough funds -" + penthouseSuiteRent + "! Back to Seaview Cottage!");
                    houseLevel = seaviewCottage;
                    playDowngradeHouse();
                } else {
                    playRent();
                    bank.setBalance(tempBalance);
                }
                break;
            case mansion:
                rentMessage.setText("" + houseLevel + " rent is " + mansionRent);
                if ((tempBalance -= mansionRent) < 1){
                    bank.setBalance(200);
                    rentMessage.setText("Not enough funds - " + mansionRent + "! Back to Penthouse Suite!");
                    houseLevel = penthouseSuite;
                    playDowngradeHouse();
                } else {
                    playRent();
                    bank.setBalance(tempBalance);
                }
                break;
        }

        Button ok = new Button("OK");
        layout.getChildren().addAll(rentDueLabel,rentMessage,ok);

        ok.setOnAction(e -> window.close());

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/Catmodities/Resources/Style/HouseStyle.css");
        window.setScene(scene);
        window.showAndWait();
    }

    public void rentReminder(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Rent due Friday");
        window.setMinWidth(250);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);

        playRentReminder();

        int rentDue = 0;

        switch (houseLevel){
            case friendsSofa:
                rentDue = friendsSofaRent;
                break;
            case apartment:
                rentDue = apartmentRent;
                break;
            case seaviewCottage:
                rentDue = seaviewCottageRent;
                break;
            case penthouseSuite:
                rentDue = penthouseSuiteRent;
                break;
            case mansion:
                rentDue = mansionRent;
                break;
        }

        Label rentDueLabel = new Label("Rent is due this Friday!");
        Label rentMessage = new Label("Make sure you have the funds:" + rentDue);

        Button ok = new Button("OK");
        layout.getChildren().addAll(rentDueLabel,rentMessage,ok);

        ok.setOnAction(e -> window.close());

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/Catmodities/Resources/Style/HouseStyle.css");
        window.setScene(scene);
        window.showAndWait();
    }

    public void upgradeHouse(Bank bank){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Upgrade House");
        window.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(8);
        layout.setAlignment(Pos.CENTER);

        HBox buttons = new HBox(20);
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setTop(layout);
        pane.setCenter(buttons);

        Label messageLabel = new Label();
        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setHalignment(messageLabel, HPos.CENTER);
        GridPane.setColumnSpan(messageLabel, 2);
        Label upgradeCostLabel = new Label();
        GridPane.setConstraints(upgradeCostLabel, 0, 1);
        GridPane.setHalignment(upgradeCostLabel, HPos.CENTER);
        GridPane.setColumnSpan(upgradeCostLabel, 2);
        Label newRentLabel = new Label();
        GridPane.setConstraints(newRentLabel, 0, 2);
        GridPane.setHalignment(newRentLabel, HPos.CENTER);
        GridPane.setColumnSpan(newRentLabel, 2);
        Label balanceLabel = new Label();
        GridPane.setConstraints(balanceLabel, 0, 3);
        GridPane.setHalignment(balanceLabel, HPos.CENTER);
        GridPane.setColumnSpan(balanceLabel, 2);
        Label tomorrow = new Label("You'll move in tomorrow.");
        GridPane.setConstraints(tomorrow, 0, 4);
        tomorrow.setStyle("-fx-font-size: 16");
        GridPane.setHalignment(tomorrow, HPos.CENTER);
        GridPane.setColumnSpan(tomorrow, 2);

        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");

        layout.getChildren().addAll(messageLabel, upgradeCostLabel, newRentLabel, balanceLabel, tomorrow);
        buttons.getChildren().addAll(ok, cancel);

        tempBalance = bank.getBalance();
       
        String upgradeTo = "";
        int upgradePrice = 0;
        int newRent = 0;

        switch(houseLevel){
            case friendsSofa:
                upgradeTo = apartment;
                upgradePrice = apartmentCost;
                newRent = apartmentRent;
                break;
            case apartment:
                upgradeTo = seaviewCottage;
                upgradePrice = seaviewCottageCost;
                newRent = seaviewCottageRent;
                break;
            case seaviewCottage:
                upgradeTo = penthouseSuite;
                upgradePrice = penthouseSuiteCost;
                newRent = penthouseSuiteRent;
                break;
            case penthouseSuite:
                upgradeTo = mansion;
                upgradePrice = mansionCost;
                newRent = mansionRent;
                break;
        }

        messageLabel.setText("Do you wish to upgrade to " + upgradeTo + "?");
        upgradeCostLabel.setText("This will cost you " + upgradePrice);
        newRentLabel.setText("Your new rent per month will be " + newRent);
        balanceLabel.setText("You currently have " + bank.getBalance());

        if ((tempBalance -= upgradePrice) < 0){
            ok.setDisable(true);
        }

        ok.setOnAction(e -> {
            bank.setBalance(tempBalance);
            switch (houseLevel){
                case friendsSofa:
                    houseLevel = apartment;
                    apartmentOpen = true;
                    break;
                case apartment:
                    houseLevel = seaviewCottage;
                    seaviewCottageOpen = true;
                    break;
                case seaviewCottage:
                    houseLevel = penthouseSuite;
                    penthouseSuiteOpen = true;
                    break;
                case penthouseSuite:
                    houseLevel = mansion;
                    mansionOpen = true;
                    break;
            }
            playUpgradeHouse();
            window.close();
        });

        cancel.setOnAction(e -> window.close());

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("/Catmodities/Resources/Style/BuyHouse.css");
        window.setScene(scene);
        window.showAndWait();
    }

    void playRentReminder(){
        try {
            AudioClip rentReminderSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/rentReminder.wav").toExternalForm());
            rentReminderSound.play();
            } catch (Exception ex){
                ex.printStackTrace();
            }
    }

    void playRent(){
        try{
            AudioClip rentSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/rent.wav").toExternalForm());
            rentSound.play();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void playUpgradeHouse(){
        try {
            AudioClip buyHouseSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/Buy_House.wav").toExternalForm());
            buyHouseSound.play();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void playDowngradeHouse(){
        try {
            AudioClip loseHouseSound = new AudioClip(getClass().getResource("/Catmodities/Resources/Sounds/Lose_House.wav").toExternalForm());
            loseHouseSound.play();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
