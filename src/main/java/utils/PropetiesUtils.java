package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lixuezhao on 2018/5/3.
 */
public class PropetiesUtils {

    /**
     * 获取properties对象，注意不需要后缀
     * @param path
     * @return
     */
    public static Properties loadProperties(String path){
        Properties prop = new Properties();
        InputStream in = null;
        try {

             in = PropetiesUtils.class.getClassLoader().getResourceAsStream(path + ".properties");
             prop.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    public static void main(String[] args) {
        Properties p = PropetiesUtils.loadProperties("rabbitmq");
        System.out.println(p.get("host"));
        System.out.println(p.get("userName"));
        System.out.println(p.get("password"));

    }
}
