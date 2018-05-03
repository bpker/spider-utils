package downloader;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lixuezhao on 2018/4/27.
 */
public class JsoupDownloaderTest {


    @Test
    public void get() throws Exception {
        JsoupDownloader downloader = new JsoupDownloader();
        downloader.get("http://stockpage.10jqka.com.cn/HK0268/quote/quotation/");
        Map<String, String> cookie = downloader.getCookies();

        System.out.println(cookie);
    }

}