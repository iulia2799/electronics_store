import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.ParseException;

public class AddUser {
    public void addUser(String username , String password , String typeOfAccount) throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        Reader read = new FileReader("users.json");
        try {
            JSONArray arrayToParse = (JSONArray) parser.parse(read);
        }catch(IOException e)
        {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject();
        obj.put("username:",username);
        obj.put("password:",password);
        obj.put("typeOfAccount:",typeOfAccount);
        JSONArray listOfelements = new JSONArray();
        listOfelements.add(obj);
        try
        {
            FileWriter file = new FileWriter("users.json");
            file.write(listOfelements.toJSONString());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
