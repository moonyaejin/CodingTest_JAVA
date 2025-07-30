import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        int mod = 1000000;
        int pisanoPeriod = 1500000;

        int index = (int)(n % pisanoPeriod);

        if (index == 0) {
            System.out.println(0);
            return;
        }

        long[] fb = new long[index + 1];
        fb[0] = 0;
        fb[1] = 1;

        for (int i = 2; i <= index; i++) {
            fb[i] = (fb[i - 1] + fb[i - 2]) % mod;
        }

        System.out.println(fb[index]);
    }
}
