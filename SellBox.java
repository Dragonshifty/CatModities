import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class SellBox {

    int result;
    int entered;
    int stockLevelTemp;

    public static void sell(int stockPrice, Label stockItem, String itemReference){
        SellBox sellBox = new SellBox();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        // window.setTitle(title);
        window.setMinWidth(250);
        window.setTitle("Selling");

        Label label = new Label();
        label.setText("How Much");

        TextField amount = new TextField();

        Button confirm = new Button("Confirm");

        sellBox.stockLevelTemp = Integer.parseInt(stockItem.getText());

        confirm.setOnAction(e  -> {
            sellBox.entered += Integer.parseInt(amount.getText());
            sellBox.result = sellBox.entered * stockPrice;

            if (sellBox.entered > sellBox.stockLevelTemp){
                label.setText("Error");
                amount.setText("Over by " + (sellBox.stockLevelTemp - sellBox.entered));
                // e.consume();
            }   else {
                Bank.calculateSell(sellBox.entered, stockPrice, stockItem, itemReference);
                window.close();
            }

            // Bank.bankAccount += SellBox.result;

        });


        HBox layout = new HBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, amount, confirm);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        // return result;
    }
}

