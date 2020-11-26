package leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LongestPalindromeSolution {

    public static void main(String[] args) {
        String s = "cvfghaahgfvccaccvfg";
        System.out.println(longestPalindromeByCenterExtent(s));
        //小写字符边界 97 - 122
        System.out.println(new SimpleDateFormat("mm:ss:SSS").format(new Date()));
        String s_random = "";
        for (int i = 0; i <1000000 ; i++) {
            s_random += (char)(97 + (int) (Math.random() * 26));
        }
        //s_random = RandomStringUtils.randomAlphanumeric(10);
        System.out.println(new SimpleDateFormat("mm:ss:SSS").format(new Date()));
        System.out.println(longestPalindromeByCenterExtent(s_random));
        System.out.println(new SimpleDateFormat("mm:ss:SSS").format(new Date()));
    }

    /*5. 最长回文子串*/
    /*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：

    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：

    输入: "cbbd"
    输出: "bb"*/


    /**
     * 中心扩散算法
     * 时间复杂度O(n2)
     * */
    public static String longestPalindromeByCenterExtent(String s) {
        if("".equals(s)){
            return "";
        }
        //有奇数和偶数长度，所以中心数量有n+n-1个
        int maxLength = 0;
        int first = 0;
        int last = 0;
        //偶数中心 n-1个
        for (int i = 0; i+1 < s.length() ; i++) {

            for (int j = i,j_mirror = i+1;  ; j--,j_mirror++) {

                if(j<0 || j_mirror > s.length()-1 || s.charAt(j) != s.charAt(j_mirror)){
                    if((j_mirror-1)-(j+1)+1 > maxLength){
                        first = j+1;
                        last = j_mirror-1;
                        maxLength = last - first + 1;
                    }
                    break;
                }
            }

        }
        //奇数中心 n个
        for (int i = 0; i <s.length() ; i++) {

            for (int j = i+1;  ; j++) {

                int j_mirror = i-(j-i);

                if(j_mirror<0 || j>s.length()-1 || s.charAt(j_mirror) != s.charAt(j)){

                    if((j-1) - (j_mirror+1) + 1 > maxLength){
                        first = j_mirror + 1;
                        last = j - 1;
                        maxLength = last - first + 1;
                    }
                    break;
                }
            }

        }
        return s.substring(first,last+1);
    }

    /**
     * 马拉车算法  todo
     * 时间复杂度O(n)
     * */
    public static String longestPalindromeByManacher(String s){

        return null;
    }
}
