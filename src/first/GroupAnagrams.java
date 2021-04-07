package first;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            byte[] bytes = new byte[26];
            for (int i = 0; i < str.length(); i++) {
                bytes[(int) str.charAt(i) - 97] ++;
            }

            String key = new String(bytes);
            List<String> tempList = map.computeIfAbsent(key, k -> new ArrayList<>());
            tempList.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List<List<String>> list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        list.forEach(System.out::println);
    }

}
