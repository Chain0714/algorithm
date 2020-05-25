package org.chain.algorithm.bit;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * @author renchen
 * @date 2020-03-10 23:02
 **/
public class Sort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] src = new int[10];
        for (int i = 0; i < 10; i++) {
            src[i] = random.nextInt(1000);
        }
        System.out.println(src);
        System.out.println(sort(src));

    }

    public static List<Integer> sort(int[] src) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < src.length; i++) {
            bitSet.set(src[i]);
        }
        int size = bitSet.size();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bitSet.get(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
