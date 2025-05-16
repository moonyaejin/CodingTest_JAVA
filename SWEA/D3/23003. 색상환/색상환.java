import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] color = {"red", "orange", "yellow", "green", "blue", "purple"};
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < color.length; i++) {
            indexMap.put(color[i], i);
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            String s1 = input[0];
            String s2 = input[1];

            if (s1.equals(s2)) {
                System.out.println("E");
                continue;
            }

            int i1 = indexMap.get(s1);
            int i2 = indexMap.get(s2);
            int diff = Math.abs(i1 - i2);

            if (diff == 1 || diff == 5) {
                System.out.println("A");
            } else if (diff == 3) {
                System.out.println("C");
            } else {
                System.out.println("X");
            }
        }
    }
}
