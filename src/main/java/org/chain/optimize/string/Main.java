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
//        String s1 = new String("1") + new String("1");
//        s1.intern();
//        System.out.println("11" == s1);

//        String s1 = new String("11");
//        s1.intern();
//        System.out.println("11" == s1);

        long a = 127L;
        long b= 127L;
        System.out.println(a==b);
        Long c = 127L;
        Long d= 127L;
        System.out.println(c==d);

    }
}
