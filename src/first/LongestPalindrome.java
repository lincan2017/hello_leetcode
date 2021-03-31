package first;

public class LongestPalindrome {

    public static String longestPalindrome1(String s) {

        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("c"));
    }
}
