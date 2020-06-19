import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AddUserTest {

    @Before
    public void setUp() throws Exception {
        FileSystemServices.getPathToFile("users.json");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void readJSON() {
    }
}