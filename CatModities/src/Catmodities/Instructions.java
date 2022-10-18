package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.FilterInputStream;

import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.scene.paint.*;

public class Instructions {

    String blurbA = "Here's how it works, my friend:\n- Buy and sell all you want each day and click 'End Day' when you're finished.\n- If you're savvy you can sell more back to a trader during the week than they had, but over the weekend their stocks will be restored to their normal levels (you keep your stocks, of course).\n- You may encounter chracters over the weekend that that will help or hinder your journey.\n- Rent is due on a Friday every four weeks (you'll get reminders, though). If you don't have enough for rent you may have to downgrade your house (just don't tell the vendors)!\n\n";

    String blurbB = "If you see my wonderfully-drawn diagram below:\n- The upper right figure shows the stock price, the lower right shows how much of that stock you have in our warehouse, and the lower left shows how much stock the vendor has.\n- The colour of the price will change according to what the price was the day before. If it's green the price is cheaper, if it's white it's the same price, or if it's red it's higher than the day before.";
    
    void showInstructions(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Instructions");
        window.setMinWidth(250);

        BorderPane pane = new BorderPane();
        
        TextFlow page = new TextFlow();
        page.setPadding(new Insets(16,20,15, 20));
        page.setTextAlignment(TextAlignment.JUSTIFY);
        page.setMaxWidth(850);
        

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(5, 10, 10, 10));
        layout.setAlignment(Pos.TOP_CENTER);

        HBox buttons = new HBox(20);
        buttons.setPadding(new Insets(10, 10, 20, 10));
        buttons.setAlignment(Pos.CENTER);

        pane.setTop(page);
        pane.setCenter(layout);
        pane.setBottom(buttons);

        Text contents = new Text();
        contents.setFill(Color.WHITE);
        contents.setText(blurbA);
        Text contents2 = new Text();
        contents2.setFill(Color.WHITE);
        contents2.setText(blurbB);
        page.getChildren().addAll(contents, contents2);

        Button ok = new Button("OK");
        buttons.getChildren().addAll(ok);
        
        ImageView img1 = new ImageView(new Image(getClass().getResource("/Catmodities/Resources/Images/stock.jpg").toExternalForm()));
        img1.setId("image");

        GridPane.setConstraints(img1, 0, 0);
        layout.getChildren().addAll(img1);

        Scene scene = new Scene(pane, 850, 620);
        scene.getStylesheets().add("/Catmodities/Resources/Style/Instructions.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
