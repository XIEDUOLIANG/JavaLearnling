package leetcode.高频算法.字符串;

import java.util.Objects;

/**
 * @author XieDuoLiang
 * @date 2020/10/29 上午9:31
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(Math.abs('A'-'a'));
        System.out.println((byte)' ');
        System.out.println((byte)'0');
        System.out.println((byte)'P');
        String s = "A man, a plan, a canal: Panama";
        s = ".";
        s = "0P";
        System.out.println(new IsPalindrome().isPalindrome(s));
    }

    /**
     * 验证回文字符串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     * 'a'~'z':97~122 | 'A'~'Z':65~90 | '0'~'9':48~57
     * */
    public boolean isPalindrome(String s) {
        if (Objects.isNull(s) || s.trim().equals("")) {
            return true;
        }
        int differ = Math.abs('A'-'a');
        for (int i = 0,j = s.length()-1; i <= j; i++,j--) {
            while (!((s.charAt(i)>=97 && s.charAt(i)<=122)
                    || (s.charAt(i)>=65 && s.charAt(i)<=90)
                    || (s.charAt(i)>=48 && s.charAt(i)<=57))) {
                if (i == j) break;
                i++;
            }
            while (!((s.charAt(j)>=97 && s.charAt(j)<=122)
                    || (s.charAt(j)>=65 && s.charAt(j)<=90)
                    || (s.charAt(j)>=48 && s.charAt(j)<=57))) {
                if (j == i)  break;
                j--;
            }
            //忽略大小写 字符大小写相差32
            if (!(s.charAt(i) == s.charAt(j) || Math.abs(s.charAt(i)-s.charAt(j)) == differ)) {
                return false;
            }
            //'0'和'P'相差刚好32 特殊情况
            if ((s.charAt(i) == '0' && s.charAt(j) == 'P') || (s.charAt(i) == 'P' && s.charAt(j) == '0')) {
                return false;
            }
        }
        return true;
    }
}
