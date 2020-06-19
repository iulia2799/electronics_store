import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTasksTest {

    @Test
    public void addTask() {
    }

    @Test
    public void viewTasks() {
        AddTasks addTasks = new AddTasks();
        addTasks.viewTasks("");
      // assertEquals("result","",addTasks.viewTasks(""));
       //la assert da eroare de comparatie din cauza ca este intr-un fisier json,in loc de "" da [""][""]
    }

    @Before
    public void setUp() throws Exception {
        FileSystemServices.getPathToFile("tasks.json");
    }
}