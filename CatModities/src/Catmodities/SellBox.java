package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class SellBox {
    
    int entered;
    int stockResult;
    int balanceResult;

    int wholesalerStockHolding;
    int warehouseStockHolding;

    int[] stockBalance = new int[4];

    public static int[] sell(int price, int wholesalerStock, int warehouseStock, int balance){
        SellBox sellBox = new SellBox();
        Stage window = new Stage();

        sellBox.wholesalerStockHolding = wholesalerStock;
        sellBox.warehouseStockHolding = warehouseStock;

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Buying");
        window.setMinWidth(250);

        Label label = new Label("How much?");

        TextField amount = new TextField();
        Button confirm = new Button("Confirm");

        confirm.setOnAction(e -> {

        try {
            sellBox.entered += Integer.parseInt(amount.getText());
        
            sellBox.stockResult = warehouseStock - sellBox.entered;
            sellBox.balanceResult = sellBox.entered * price;

            if (sellBox.stockResult < 0){
                label.setText("No stock");
                amount.setText("Over by " + (sellBox.stockResult));
                sellBox.stockResult = 0;
                sellBox.balanceResult = 0;  
                sellBox.entered = 0;
                e.consume();
            } else {
                // Wholesaler/Warehouse/Bank Balance/confirmation
                sellBox.stockBalance[0] = sellBox.wholesalerStockHolding += sellBox.entered;
                sellBox.stockBalance[1] = sellBox.warehouseStockHolding -= sellBox.entered;
                sellBox.stockBalance[2] = balance + sellBox.balanceResult;
                sellBox.stockBalance[3] = 1;
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

        return sellBox.stockBalance;
    }
}
