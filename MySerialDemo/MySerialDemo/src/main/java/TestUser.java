import java.io.*;

public class TestUser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("e:/user.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(new User("lebron", "123"));

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        User user = (User) inputStream.readObject();
        System.out.println(user.getName() +" : "+ user.getPassword());
    }


}
