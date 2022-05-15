



import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserFastJson implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private boolean sex;

    public UserFastJson(String lebron, String s) {
        this.name = lebron;
        this.password = s;
        System.out.println("UserFastJson construct include para");
    }

    public UserFastJson() {


        System.out.println("UserFastJson construct");
    }

    public String getName() {
        System.out.println("in getName");
        return name;
    }

    public void setName(String userName) {
        System.out.println("in setName:" + userName);
        this.name = userName;
    }

    public String getPassword() {
        System.out.println("in getPassword");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("in setPassword:" + password);
        this.password = password;
    }

    public void setSex(boolean sex) {
        System.out.println("in setSex:" + sex);
        this.sex = sex;
    }

    public boolean getSex() {
        System.err.println("Pwned");
        try {
            String[] cmd = {"calc"};
            java.lang.Runtime.getRuntime().exec(cmd).waitFor();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        System.out.println("in getSex:");
       return sex;
    }

}
