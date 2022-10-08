package Catmodities;
import org.json.simple.JSONObject;
import java.util.LinkedHashMap;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
      //Creating a JSONObject object
      // JSONObject jsonObject = new JSONObject();
      //Inserting key-value pairs into the json object
      
      Wholesaler fish = new FishVendor();
      Wholesaler toy = new ToyVendor();
      Wholesaler treat = new TreatVendor();

      LinkedHashMap <String, Integer> fishPrices = fish.getPrices();
      LinkedHashMap <String, Integer> toyPrices = toy.getPrices();
      LinkedHashMap <String, Integer> treatPrices = treat.getPrices();

      fish.setPrices();
      toy.setPrices();
      treat.setPrices();

      JSONObject fishJson = new JSONObject(fishPrices);
      System.out.println(fishJson);




   //    try {
   //       FileWriter file = new FileWriter("C:/output.json");
   //       file.write(jsonObject.toJSONString());
   //       file.close();
   //    } catch (IOException e) {
   //       // TODO Auto-generated catch block
   //       e.printStackTrace();
   //    }
   //    System.out.println("JSON file created: "+jsonObject);
   // }
   }
}
