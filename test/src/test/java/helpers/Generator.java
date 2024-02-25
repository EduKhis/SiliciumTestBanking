package helpers;

import lombok.Data;

@Data
public class Generator {

    static String letters = "abcdefghijklmnopqrstuvwxyz";

    public static String postCode;
    public static String firstName;

    public static void generatePostCodeAndName() {
        long t = (long) (Math.random()* 8999999999L + 1000000000);
        postCode = Long.toString(t);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            String a = postCode.substring(i, i + 2);
            i=i+1;
            int b = Integer.parseInt(a);
            int c = b/26;
            int d = b-c*26;
            builder.append(letters.charAt(d));
        }
        firstName = builder.toString();
    }
}
