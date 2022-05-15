



import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private   String name;
    private  String password;

    public User(String lebron, String s) {
        this.name = lebron;
        this.password = s;
    }

    public User() {

    }
//    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        ois.defaultReadObject();
//        System.out.println("readObject");
//    }
//    private Object readResolve() {
//        System.out.println("readResolve");
//        return new User("name1", "passwd1");
//    }

    private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
        System.out.println("User readObject");
        s.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream s)throws java.io.IOException{
        System.out.println("User writeObject");
        s.defaultWriteObject();
    }

    private Object readResolve() {
        System.out.println("User readResolve");
        return this;
    }
}
