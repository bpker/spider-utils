package selector;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lixuezhao on 2017/9/20.
 * RegexSelector
 * usage：
 * new RegexSelector(source).select(regexStr);
 */

public class RegexSelector {


    private int defultGroup = 0;

    private String source;

    public RegexSelector(String source) {
        this.source = source;
    }

    /**
     * 设置默认分组
     * @param defultGroup
     */
    public void setDefultGroup(int defultGroup) {
        this.defultGroup = defultGroup;
    }

    /**
     * select one str
     * @param regexStr
     * @return
     */
    public String selectOne(String regexStr){
        return selectGroup(regexStr, defultGroup);
    }
    public String selectOne(String regexStr, int group){
        return selectGroup(regexStr, group);
    }
    private String selectGroup(String regexStr, int group) {
        String result = "";
        Pattern regex = Pattern.compile(regexStr);
        Matcher matcher = regex.matcher(source);
        if (matcher.find()) {
            try {
                result = matcher.group(group);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;

    }

    /**
     * select str list
     * @param regexStr
     * @return
     */
    public List<String> selectList(String regexStr) {
        return selectListGroup(regexStr, defultGroup);
    }
    public List<String> selectList(String regexStr, int group) {
        return selectListGroup(regexStr, group);
    }
    private List<String> selectListGroup(String regexStr, int group) {
        List<String> result = new ArrayList<String>();
        Pattern regex = Pattern.compile(regexStr);
        Matcher matcher = regex.matcher(source);
        while(matcher.find()) {
            try {
                String e = matcher.group(group);
                if (!result.contains(e)){
                    result.add(e);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;

    }
}