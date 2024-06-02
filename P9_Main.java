import java.util.Scanner;

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

public class Main {
    static void validateAge(int age) throws MyException {
        if (age < 18) {
            throw new MyException("Age must be 18 years or older.");
        } else {
            System.out.println("Age is valid.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            validateAge(age);
        } catch (MyException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
