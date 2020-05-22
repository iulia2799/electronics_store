import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
public class AddTasks {
    public void  addTask(String nameOfEmployee, String task){
        boolean conditieIesire=false;
        JSONObject users = new JSONObject();
        JSONParser parser = new JSONParser();
        Object p;
        JSONArray arrayToParse = new JSONArray();
        try {
            FileReader readFile= new FileReader("tasks.json");
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
        if(arrayToParse.isEmpty()) {
            JSONArray taskslist = new JSONArray();
            taskslist.add(task);

            users.put("nameOfEmployee", nameOfEmployee);
            users.put("tasksList:", taskslist);
            arrayToParse.add(users);
        }
        else {
            Iterator<JSONObject> jObject = arrayToParse.iterator();
            while (jObject.hasNext()) {
                JSONObject obj = jObject.next();
                if (nameOfEmployee.equals(obj.get("nameOfEmployee"))) {
                    JSONArray arrayToPut = new JSONArray();
                    arrayToPut.add(task);
                    arrayToPut.add(obj.get("tasksList:"));
                    users.put("nameOfEmployee", nameOfEmployee);
                    users.put("tasksList:", arrayToPut);
                    arrayToParse.remove(obj);
                    arrayToParse.add(users);
                    break;
                }
                else
                {
                    JSONArray taskslist = new JSONArray();
                    taskslist.add(task);

                    users.put("nameOfEmployee", nameOfEmployee);
                    users.put("tasksList:", taskslist);
                    arrayToParse.add(users);
                    break;
                }
            }
        }
        try
        {
            File file  = new File("tasks.json");
            FileWriter fisier = new FileWriter(file.getAbsoluteFile());
                fisier.write(arrayToParse.toJSONString());
                fisier.flush();
                fisier.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String viewTasks(String nameOfEmployee)
    {
        String tasks ="";

        JSONParser parser = new JSONParser();
        JSONObject compare = new JSONObject();
        Object p;
        JSONArray array = new JSONArray();
        try
        {
            FileReader readFile= new FileReader("tasks.json");
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
            if(obj.get("nameOfEmployee").equals(nameOfEmployee))
            {

                tasks+=obj.get("tasksList:");
            }


        }

        return tasks;
    }

}
