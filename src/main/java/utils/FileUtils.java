package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by lixuezhao on 2018/1/8.
 */
public class FileUtils {

    /**
     * get the file content in the classpath
     * @param filePath
     * @return
     */
    public static String getFileContent(String filePath){
        //获取文本
        InputStream in = FileUtils.class.getResourceAsStream(filePath);
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        String content = "";
        String line = null;
        try {
            line = bf.readLine();
            while(line != null){
                content += line;
                line = bf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bf != null){
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

        return content;

    }

    public static void main(String[] args) {
        String content = FileUtils.getFileContent("/newsAlgo/html.txt");
        System.out.println(content);
    }
}
