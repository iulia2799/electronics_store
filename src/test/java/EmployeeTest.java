import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Before
    public void setUp() throws Exception {
        FileSystemServices.getPathToFile("tasks.json");
        FileSystemServices.getPathToFile("inventory.json");
    }

    @Test
    public void deleteTasks() {
        Employee employee = new Employee("rocky");
        employee.deleteTasks("rocky");
        assertNotNull(employee);
    }
}