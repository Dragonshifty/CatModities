import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class BuyBox {

    static boolean answer;
    int result;
    int tempBankAccount = Bank.bankAccount;


    int entered;
    public static void buy(int stockPrice, Label stockItem, String itemReference){
        BuyBox buyBox= new BuyBox();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        // window.setTitle(title);
        window.setMinWidth(250);
        window.setTitle("Buying");

        Label label = new Label();
        label.setText("How Much");

        TextField amount = new TextField();

        Button confirm = new Button("Confirm");

        
        confirm.setOnAction(e  -> {
            buyBox.entered += Integer.parseInt(amount.getText());
            buyBox.result = buyBox.entered * stockPrice;
            

            if (buyBox.tempBankAccount - buyBox.result < 0){
                label.setText("Error");
                amount.setText("Over by " + (buyBox.tempBankAccount = buyBox.result));
                e.consume();
            }  else {
                Bank.calculateBuy(buyBox.entered, stockPrice, stockItem, itemReference);
                buyBox.result = buyBox.entered * stockPrice;
                window.close();

            }
            // main.bankAccount -= buyBox.result;
            
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

