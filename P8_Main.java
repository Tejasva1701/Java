public class Main {
    public static void main(String[] args) {
        String[] strings = {"100", "10.2", "5.hello", "100hello"};

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            try {
                int intValue = Integer.parseInt(str);
                System.out.println("\"" + str + "\" is a valid integer");
            } catch (NumberFormatException e1) {
                try {
                    double doubleValue = Double.parseDouble(str);
                    System.out.println("\"" + str + "\" is a valid double");
                } catch (NumberFormatException e2) {
                    System.out.println("\"" + str + "\" is not a valid integer or double");
                }
            }
        }
    }
}
