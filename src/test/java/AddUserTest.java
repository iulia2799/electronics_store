import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.security.NoSuchAlgorithmException;

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
        AddUser user = new AddUser();
        String pass = "1234";
        Encryption e = new Encryption();
        try {
            user.addUser("rocky",e.encodePassword(pass),"manager");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void readJSON() {
        AddUser user1 = new AddUser();
        String pass="1234";
        Encryption e = new Encryption();
        try {
            user1.readJSON("rocky",e.encodePassword(pass),"manager");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        boolean result = user1.isUsername;
        assertEquals("user exists",true,result);
    }
}