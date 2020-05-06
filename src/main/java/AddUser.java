import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Iterator;

public class AddUser {
    protected boolean isPassword=false;
    protected boolean isUsername=false;
    public void  addUser(String username, String password, String typeOfAccount){
        JSONObject users = new JSONObject();
        JSONParser parser = new JSONParser();
        Object p;
        JSONArray arrayToParse = new JSONArray();
        try {
            FileReader readFile= new FileReader("users.json");
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
        users.put("username:", username);
        users.put("password:", password);
        users.put("typeOfAccount:", typeOfAccount);
        arrayToParse.add(users);
        try
        {
            File file  = new File("users.json");
            FileWriter fisier = new FileWriter(file.getAbsoluteFile());
            fisier.write(arrayToParse.toJSONString());
            fisier.flush();
            fisier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readJSON(String user, String pass,String type)
    {
        JSONParser parser = new JSONParser();
        JSONObject compare = new JSONObject();
        Object p;
        JSONArray array = new JSONArray();
        try
        {
            FileReader readFile= new FileReader("users.json");
            BufferedReader read = new BufferedReader(readFile);
            p=parser.parse(read);
            if(p instanceof JSONArray) {
                array = (JSONArray) p;
            }
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        compare.put("username:",user);
        compare.put("password:",pass);
        compare.put("typeOfAccount:",type);
        Iterator<JSONObject> iterator = array.iterator();
        while(iterator.hasNext()) {
            JSONObject obj = iterator.next();
            if (obj.equals(compare)) {
                isPassword = true;
                isUsername = true;
            }
        }

    }
}