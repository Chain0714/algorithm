package org.chain.optimize.string;

/**
 * description:  Main
 *
 * @author Chain
 * @version 1.0
 * @since 2019/11/27 17:02
 */
public class Main {
    public static void main(String[] args) {
        String s1 = new String("1") + new String("2");
        s1.intern();
        String s2 = "12";
        System.out.println(s1 == s2);
    }
}
