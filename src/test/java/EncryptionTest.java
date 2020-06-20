import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class EncryptionTest {

    @Before
    public void setUp() throws Exception {
        FileSystemServices.getPathToFile("users.json");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encodePassword() {
        Encryption encryption = new Encryption();
        String pass = "pacala89";
        try {
            assertEquals("corect",encryption.encodePassword(pass),encryption.encodePassword(pass));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}