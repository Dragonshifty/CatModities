package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class BuyBox {

    int entered;
    int stockResult;
    int balanceResult;

    int wholesalerStockHolding;
    int warehouseStockHolding;

    int[] stockBalance = new int[4];
    
    public static int[] buy(int price, int wholesalerStock, int warehouseStock, int balance){
        BuyBox buyBox = new BuyBox();
        Stage window = new Stage();

        buyBox.wholesalerStockHolding = wholesalerStock;
        buyBox.warehouseStockHolding = warehouseStock;

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Buying");
        window.setMinWidth(250);

        Label label = new Label("How much?");

        TextField amount = new TextField();
        Button confirm = new Button("Confirm");

        confirm.setOnAction(e -> {

            try {
            buyBox.entered += Integer.parseInt(amount.getText());
            
            buyBox.stockResult = buyBox.entered - wholesalerStock;
            buyBox.balanceResult = buyBox.entered * price;

            if (balance - buyBox.balanceResult < 0){
                label.setText("No Funds");
                amount.setText("Over by " + (balance - buyBox.balanceResult));
                buyBox.stockResult = 0;
                buyBox.balanceResult = 0;
                buyBox.entered = 0;
                e.consume();
            } else if (wholesalerStock - buyBox.stockResult < 0){
                label.setText("No stock");
                amount.setText("Over by " + (wholesalerStock - buyBox.stockResult));
                buyBox.stockResult = 0;
                buyBox.balanceResult = 0;
                buyBox.entered = 0;
                e.consume();
            } else {
                buyBox.stockBalance[0] = buyBox.wholesalerStockHolding -= buyBox.entered;
                buyBox.stockBalance[1] = buyBox.warehouseStockHolding += buyBox.entered;
                buyBox.stockBalance[2] = balance - buyBox.balanceResult;
                buyBox.stockBalance[3] = 1;
                window.close();
            }
        } catch (NumberFormatException ex){
            e.consume();
        }
        });

        HBox layout = new HBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, amount, confirm);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return buyBox.stockBalance;
    }
}
