package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This is a MD5 generator
 * usage:
 * MD5Util.md5(stringToBeMd5);
 */
public class MD5Util {
    /**
     * md5
     * @param str
     * @return
     */
    public static String md5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
