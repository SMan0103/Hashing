import java.math.BigInteger;
import java.security.MessageDigest;

public class TPHashing {

    public static String MD5Hash(String s) {
        String result = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            result = new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
     * public String SHA512(String s) {
     * String result = "";
     * 
     * try {
     * MessageDigest md = MessageDigest.getInstance("SHA-512");
     * md.update(s.getBytes());
     * result = new BigInteger(1, md.digest()).toString(16);
     * 
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * return result;
     * }
     */
}
