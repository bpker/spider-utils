package strporcess;

/**
 * Created by lixuezhao on 2018/1/23.
 * 最小编辑距离算法，分析字符串相似度
 * 算法代码来自：https://segmentfault.com/a/1190000003741294
 */
public class MinimumEditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化空字符串的情况
        for(int i = 1; i <= m; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // 增加操作：str1a变成str2后再加上b，得到str2b
                int insertion = dp[i][j-1] + 1;
                // 删除操作：str1a删除a后，再由str1变为str2b
                int deletion = dp[i-1][j] + 1;
                // 替换操作：先由str1变为str2，然后str1a的a替换为b，得到str2b
                int replace = dp[i-1][j-1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                // 三者取最小
                dp[i][j] = Math.min(replace, Math.min(insertion, deletion));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        String s1 = "深圳市test软件技术有限公司";
        String s2 = "泸州test软件科技有限公司";
        String s3 = "test软件有限公司北京分公司";
        String s = "深圳test软件";

        MinimumEditDistance minimumEditDistance = new MinimumEditDistance();
        System.out.println(minimumEditDistance.minDistance(s, s1));
        System.out.println(minimumEditDistance.minDistance(s, s2));
        System.out.println(minimumEditDistance.minDistance(s, s3));

    }
}
