package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class SellBox {
    
    int entered;
    int stockResult;
    int balanceResult;
    int max;

    int wholesalerStockHolding;
    int warehouseStockHolding;

    int[] stockBalance = new int[4];

    public static int[] sell(int price, int wholesalerStock, int warehouseStock, int balance){
        SellBox sellBox = new SellBox();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Selling");
        window.setMinWidth(250);

        sellBox.wholesalerStockHolding = wholesalerStock;
        sellBox.warehouseStockHolding = warehouseStock;

        Label label = new Label("How much?");
        TextField amount = new TextField();
        Button confirm = new Button("Confirm");
        Slider slider = new Slider(0, 10000, 0);
        slider.setMax(warehouseStock);

        amount.setText(Math.round(slider.getValue()) + "");

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
              if (newValue == null) {
                amount.setText("");
                return;
              }
              amount.setText(Math.round(newValue.intValue()) + "");
            }
          });
        
        Button all = new Button("All");
        
        all.setOnAction(e -> {
            amount.setText("" + warehouseStock);
            try {
                sellBox.entered += Integer.parseInt(amount.getText());
            
                sellBox.stockResult = warehouseStock - sellBox.entered;
                sellBox.balanceResult = sellBox.entered * price;
    
                // Wholesaler/Warehouse/Bank Balance/confirmation
                sellBox.stockBalance[0] = sellBox.wholesalerStockHolding += sellBox.entered;
                sellBox.stockBalance[1] = sellBox.warehouseStockHolding -= sellBox.entered;
                sellBox.stockBalance[2] = balance + sellBox.balanceResult;
                sellBox.stockBalance[3] = 1;
                window.close();
                
            } catch (NumberFormatException ex){
                e.consume();
            } catch (ArithmeticException ex){
                e.consume();
                window.close();
            }
        });

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
        } catch (ArithmeticException ex){
            e.consume();
            window.close();
        }
        });

        HBox layout = new HBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, amount, confirm, slider, all);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/Catmodities/Resources/Style/Sell.css");
        window.setScene(scene);
        window.showAndWait();

        return sellBox.stockBalance;
    }
}
