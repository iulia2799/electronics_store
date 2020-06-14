import javafx.scene.shape.Path;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static void copyFile(File src , File dest)
    {
        try {
            FileUtils.copyFileToDirectory(src, dest);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) throws IOException, ParseException {
            File from_inventory = new File("\\electronics_storeFinalAproximate\\inventory.json").getAbsoluteFile();
            File from_task = new File("\\electronics_storeFinalAproximate\\tasks.json").getAbsoluteFile();
            File from_users = new File("\\electronics_storeFinalAproximate\\users.json").getAbsoluteFile();
            File dest = new File("\\electronics_storeFinalAproximate\\target");

            copyFile(from_inventory,dest);
            copyFile(from_task,dest);
            copyFile(from_users,dest);

            MainMenu m = new MainMenu();
            m.performMain();

    }
}
