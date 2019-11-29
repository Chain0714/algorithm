package org.chain.optimize.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:  Main
 *
 * @author Chain
 * @version 1.0
 * @since 2019/11/27 19:37
 */
public class Main {
    public static void main(String[] args) {
        String str = "abbbc";
//        String reg = "ab{1,3}c";//贪婪 未回溯
//        String reg = "ab{1,3}bc";//贪婪 回溯
//        String reg = "ab{1,3}?c";//懒惰 回溯
        String reg = "ab{1,3}+c";//独占 未回溯
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
