class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirst = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                isFirst = true;
            } else {
                if (isFirst) {
                    if (Character.isLetter(c)) {
                        answer.append(Character.toUpperCase(c));
                    } else {
                        answer.append(c);
                    }
                    isFirst = false;
                } else {
                    answer.append(Character.toLowerCase(c));
                }
            }
        }
        return answer.toString();
    }
}