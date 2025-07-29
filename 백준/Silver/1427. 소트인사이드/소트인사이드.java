import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String number = br.readLine();
        Character[] digits = new Character[number.length()];

        for (int i = 0; i < number.length(); i++) {
            digits[i] = number.charAt(i);
        }

        Arrays.sort(digits, Collections.reverseOrder()); 

        StringBuilder sb = new StringBuilder();
        for (char c : digits) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
