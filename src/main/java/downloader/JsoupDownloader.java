package downloader;

import lombok.Data;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UserAgentUtils;

import java.io.IOException;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/13.
 */
@Data
public class JsoupDownloader {

    private static Logger logger = LoggerFactory.getLogger(JsoupDownloader.class);
    private int retryTimes = 3;
    private Map<String, String> cookies;
    private int defultTimeout = 6000;


    /**
     * set the retry times for download failure
     * @param times
     */
    public void setRetryTimes(int times){
        this.retryTimes =  times;
    }

    /**
     * get the page resources with url
     * @param url
     * @return Jsoup.Document
     */
    public Document get(String url){
        return get(url, null, null);
    }

    /**
     * get the page resources with url and header
     * @param url
     * @param header
     * @return
     */
    public Document get(String url,Map<String, String> header){
        return get(url, header, null);
    }
    /**
     * get the pageResources with url,header and proxy
     * @param  url, header, proxy
     * @return
     */
    public Document get(String url, Map<String, String> header, Map<String,String> proxy) {
        Document document = new Document("");
        cookies = new HashMap<String, String>();
        int i =  0;

        Connection conn = Jsoup.connect(url);

        //添加
        if (header != null){
            for (Map.Entry<String, String> entry: header.entrySet()){
                conn.header( entry.getKey(),  entry.getValue());
//                    System.out.println("添加cookie中");
            }
        }
        if (proxy != null){
            conn.proxy(proxy.get("IP"), Integer.valueOf(proxy.get("PORT")));
        }
        while(i++ < retryTimes){
            Connection.Response res = null;
            try {
                res = conn.userAgent(UserAgentUtils.randomUserAgent())
                        .maxBodySize(0)
                        .ignoreContentType(true)
                        .timeout(defultTimeout)
                        .execute();
                document = res.parse();
                this.cookies = res.cookies();
                break;

            } catch (IOException e) {
                e.printStackTrace();
                logger.info("重试下载网页第{}次,网址为：{}",i, url);
            }catch (Exception e){
                logger.info("another exception, I will ignore");
            }
        }

        return document;
    }


    /**
     * post mehtod for downloader with url and body
     * @param url
     * @param data
     * @return
     */
    public Document post(String url, Map<String, String> data){
        return post(url, null, data);
    }

    /**
     * post mehtod for downloader with url, header and body
     * @param url
     * @param header
     * @param data
     * @return
     */
    public Document post(String url, Map<String, String> header, Map<String, String> data) {

        Connection conn = Jsoup.connect(url);

        if (header != null){
            for (Map.Entry<String, String> entry: header.entrySet()){
                conn.header( entry.getKey(),  entry.getValue());
            }
        }
        if (data != null){
            for (Map.Entry<String, String> entry: data.entrySet()){
                conn.data( entry.getKey(),  entry.getValue());
            }
        }

        Document document = new Document("");
        cookies = new HashMap<String, String>();

        int i =  0;
        while(i++ < retryTimes){

            try {

                document =   conn
                        .userAgent(UserAgentUtils.randomUserAgent())
                        .ignoreContentType(true)
                        .timeout(defultTimeout)
                        .post();

                break;

            } catch (IOException e) {
                e.printStackTrace();
                logger.info("重试下载网页第{}次,网址为：{}",i, url);
                continue;
            }
        }

        return document;

    }

}
