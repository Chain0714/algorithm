package org.chain.optimize.serializable;

import java.io.*;

/**
 * description:  Test
 *  通过反序列化打开
 * @author Chain
 * @version 1.0
 * @since 2019/12/9 20:27
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        write();
        read();
    }

    private static void write() throws IOException {
        FileOutputStream fos = new FileOutputStream("./test.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        User user = new User();
        user.setName("test");
        oos.writeObject(user);
    }

    private static void read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./test.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ois.readObject();
    }
}
