package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Quit {

    static boolean confirm = false;
    
    public static boolean quit(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Quit");
        window.setMinWidth(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20, 20));
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

        Label messageLabel = new Label(("Exit CatModities?"));
        GridPane.setConstraints(messageLabel, 0, 0);
        GridPane.setHalignment(messageLabel, HPos.CENTER);
        GridPane.setColumnSpan(messageLabel, 2);

        grid.getChildren().add(messageLabel);
        buttons.getChildren().addAll(ok, cancel);

        ok.setOnAction(e ->{
            confirm = true;
            window.close();  
        });

        cancel.setOnAction(e -> window.close());

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("/Catmodities/Resources/Style/Sell.css");
        window.setScene(scene);
        window.showAndWait();
        return confirm;
    }
}
