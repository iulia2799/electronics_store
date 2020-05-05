import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        MainMenu m = new MainMenu();
        m.performMain();
        AddUser add =null;
        try {
            add =new AddUser();
        }catch (IOException e)
        {
            e.printStackTrace();
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
        add.addUser("user","user","manager");
    }
}
