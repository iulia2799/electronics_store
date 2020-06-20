import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public String encodePassword(String password) throws NoSuchAlgorithmException {
        String salt="jack.smith";
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] hashedPass = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return new String(hashedPass , StandardCharsets.UTF_8).replace("\"","");
    }
}
