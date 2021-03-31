package first;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int maxLength = 0;
        Set<Character> vals = new HashSet<>();
        int i=0;
        int j=0;
        while (i < s.length()  && j <= i) {
            if (vals.contains(s.charAt(i))) {
                j ++;
                continue;
            }
            maxLength = Math.max(maxLength, i-j);
            vals.add(s.charAt(i++));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
