package org.chain.optimize.stream;

import java.util.Arrays;
import java.util.List;

/**
 * description:  Main
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/2 11:10
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张三", "李四", "王老五", "李三", "刘老四", "王小二", "张四", "张五六七");
        int l = names.stream().filter(name -> name.startsWith("张")).mapToInt(String::length).max().orElse(0);
        System.out.println(l);
    }
}
