package lectures;
import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        boolean flag;
        Scanner sc = new Scanner(System.in);
        do {
            String usernamePattern = "\"[^a-zA-Z0-9\\-\\\\/(),_\\s]+\"";
            String usernamePattern1 = "_";
            System.out.print("Input user name: ");
            String input = sc.next();
            flag = input.matches(usernamePattern);
            if (!flag) System.out.println("Invalid data!");
        } while (!flag);
        System.out.println("Valid data");
    }
}