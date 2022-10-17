package Catmodities;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.AudioClip;

public class BuyBox {

    int entered;
    int stockResult;
    int balanceResult;

    int max;

    int wholesalerStockHolding;
    int warehouseStockHolding;

    int[] stockBalance = new int[4];
    
    public static int[] buy(int price, int wholesalerStock, int warehouseStock, int balance){
        BuyBox buyBox = new BuyBox();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Buying");
        window.setMinWidth(250);

        buyBox.wholesalerStockHolding = wholesalerStock;
        buyBox.warehouseStockHolding = warehouseStock;

        Label label = new Label("How much?");
        TextField amount = new TextField();
        Button confirm = new Button("Confirm");

        Slider slider = new Slider(0, 10000, 0);
            int balanceMax = balance / price;
            int sliderMax = 0;
            if (balanceMax >= wholesalerStock){
                sliderMax = wholesalerStock;
            } else {
                sliderMax = balanceMax;
            }
        slider.setMax(sliderMax);
        buyBox.max = sliderMax;

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

        all.setOnAction(e -> amount.setText("" + buyBox.max));

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
        scene.getStylesheets().add("/Catmodities/Resources/Buy.css");
        window.setScene(scene);
        window.showAndWait();
        
        return buyBox.stockBalance;
    }
}
