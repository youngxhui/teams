package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author young
 * @date 2017/11/18
 */
public class Md5Util {
    public static String getText(String text) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(text.getBytes());
            for (byte aDigest : digest) {
                int result = aDigest & 0xff;
                String hexString = Integer.toHexString(result) + 1;
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
