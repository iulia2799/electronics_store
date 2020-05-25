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
        int rebuildQuantity=0;
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
        Iterator<JSONObject> iterator = arrayToParse.iterator();
        while(iterator.hasNext())
        {
            JSONObject obj = iterator.next();
            if(obj.get("nameOfProduct").equals(nameOfProduct))
            {
                String quantity2 = obj.get("quantity").toString();
                int quant = Integer.parseInt(quantity2);
                rebuildQuantity+=quant;
                arrayToParse.remove(obj);
                break;
            }
        }
        System.out.println("Cantitatea citita este : "+rebuildQuantity);
        int finalquant;
        if(rebuildQuantity!=0)
        {
            finalquant=rebuildQuantity+quantity;
        }
        else {
            finalquant=quantity;
        }
        System.out.println("Cantitatea finala: "+finalquant);
        users.put("nameOfProduct",nameOfProduct);
        users.put("quantity", finalquant);
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
