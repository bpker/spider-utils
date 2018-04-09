package selector;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/20.
 */
public class RegexSelectorTest {


    @Test
    public void testRegex(){
        String s = "<tr height=40>" +
                "<td width=\"132\" class=\"tr-title\">统一信用代码：</td>" +
                "<td width=\"200\">914403000877533701</td>\n" +
                "<td width=\"132\" class=\"tr-title\">经营状态：</td>" +
                "<td width=\"200\">存续</td>" +
                "</tr>" +
                "<tr height=40>\n" +
                "<td width=\"132\" class=\"tr-title\">行业：</td>" +
                "<td width=\"200\">其他金融业</td>" +
                "<td width=\"132\" class=\"tr-title\">企业类型：</td>" +
                "<td width=\"200\">有限责任公司</td>";
        RegexSelector selector = new RegexSelector(s);
//        System.out.println(selector.select("经营状态：.*>(.*)</td>", 0));
//        System.out.println(selector.select("统一信用代码：.*>(.*)</td>", 1));
//        System.out.println(selector.select("class=(.*)", 1));
    }


}