package org.chain.algorithm.fibonacci;

/**
 * description:  Main
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/4 19:57
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(m1(3));
        System.out.println(m2(3));
    }

    /**
     * O(n^2)
     *
     * @param n
     * @return
     */
    private static int m1(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return m1(n - 1) + m1(n - 2);
        }
    }

    /**
     * O(n)
     *
     * @param n
     * @return
     */
    private static int m2(int n) {
        if (n <= 2) {
            return 1;
        }
        int prePre = 1;
        int pre = 1;
        int result = 2;
        for (int i = 3; i <= n; i++) {
            result = prePre + pre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
