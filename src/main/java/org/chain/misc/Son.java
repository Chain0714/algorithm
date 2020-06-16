package org.chain.misc;

/**
 * javap -c Son.class
 * Compiled from "Son.java"
 * public class org.chain.misc.Son extends org.chain.misc.Mid<java.lang.String> {
 *   public org.chain.misc.Son();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method org/chain/misc/Mid."<init>":()V
 *        4: return
 *
 *   public java.lang.String getVal(java.lang.String);
 *     Code:
 *        0: aload_0
 *        1: aload_1
 *        2: invokespecial #2                  // Method org/chain/misc/Mid.getVal:(Ljava/lang/Object;)Ljava/lang/String;
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
public class Son extends Mid<String> {
    @Override
    public String getVal(String s) {
        return super.getVal(s);
    }
}
