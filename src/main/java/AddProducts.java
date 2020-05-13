import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;

public class AddProducts {
    public String readProducts()
    {
            String inventory="";
            JSONParser parser = new JSONParser();
            JSONObject compare = new JSONObject();
            Object p;
            JSONArray array = new JSONArray();
            try
            {
                FileReader readFile= new FileReader("inventory.json");
                BufferedReader read = new BufferedReader(readFile);
                p=parser.parse(read);
                if(p instanceof JSONArray) {
                    array = (JSONArray) p;
                }
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            } catch (IOException ioException){
                ioException.printStackTrace();
            }
            Iterator<JSONObject> iterator = array.iterator();
            while(iterator.hasNext()) {
                JSONObject obj = iterator.next();
                inventory+="Numele produslui: "+obj.get("nameOfProduct")+"\n";
                inventory+="Pretul produsului: "+obj.get("price")+"\n";
                inventory+="Cantitatea de produse:"+obj.get("quantity")+"\n";
                inventory+="\n";
            }
            return inventory;
    }
    public void  addProduct(String nameOfProduct, int quantity, double price){
        JSONObject users = new JSONObject();
        JSONParser parser = new JSONParser();
        Object p;
        JSONArray arrayToParse = new JSONArray();
        try {
            FileReader readFile= new FileReader("inventory.json");
            BufferedReader read = new BufferedReader(readFile);
            p = parser.parse(read);
            if(p instanceof  JSONArray)
            {
                arrayToParse =(JSONArray)p;
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        users.put("nameOfProduct",nameOfProduct);
        users.put("quantity",quantity);
        users.put("price",price);
        arrayToParse.add(users);
        try
        {
            File file  = new File("inventory.json");
            FileWriter fisier = new FileWriter(file.getAbsoluteFile());
            fisier.write(arrayToParse.toJSONString());
            fisier.flush();
            fisier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
