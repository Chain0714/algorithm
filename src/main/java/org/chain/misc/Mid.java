package org.chain.misc;

/**
 * 如果改成如下，mid实现getVal，直接替换.class文件，就会导致栈溢出
 * public class Mid extends Father<String> {
 *     @Override
 *     public String getVal(String str) {
 *         return super.getVal(str);
 *     }
 * }
 *
 * javap -c Mid.class
 * Compiled from "Mid.java"
 * public class org.chain.misc.Mid extends org.chain.misc.Father<java.lang.String> {
 *   public org.chain.misc.Mid();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method org/chain/misc/Father."<init>":()V
 *        4: return
 *
 *   public java.lang.String getVal(java.lang.String);
 *     Code:
 *        0: aload_0
 *        1: aload_1
 *        2: invokespecial #2                  // Method org/chain/misc/Father.getVal:(Ljava/lang/Object;)Ljava/lang/String;
 *        5: areturn
 *
 *   public java.lang.String getVal(java.lang.Object);
 *     Code:
 *        0: aload_0
 *        1: aload_1
 *        2: checkcast     #3                  // class java/lang/String
 *        5: invokevirtual #4                  // Method getVal:(Ljava/lang/String;)Ljava/lang/String;
 *        8: areturn
 * }
 */
public class Mid<T> extends Father<T> {
}
