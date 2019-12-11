package org.chain.optimize.serializable;

import java.io.IOException;
import java.io.Serializable;

/**
 * description:  User
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/9 20:25
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void readObject(java.io.ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        Runtime.getRuntime().exec("calc.exe");
    }
}
