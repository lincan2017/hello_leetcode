package first;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BracketIsValid {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        // 存放各种括号
        Map<Character, Character> bracketMapping = new HashMap<>();
        bracketMapping.put('[', ']');
        bracketMapping.put('(', ')');
        bracketMapping.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            Character character = bracketMapping.get(s.charAt(i));
            if (character != null) {
                stack.push(character);
            } else {
                if (stack.isEmpty() || !Objects.equals(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();


    }
}
