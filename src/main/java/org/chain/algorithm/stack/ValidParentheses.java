package org.chain.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * description:  ValidParentheses
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/9 15:52
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> def = new HashMap<>(4);
        def.put(')', '(');
        def.put(']', '[');
        def.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            Character character = def.get(c);
            if (null == character) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || !character.equals(stack.pop())) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
