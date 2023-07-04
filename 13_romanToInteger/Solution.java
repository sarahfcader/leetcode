class Solution {
    public int romanToInt(String s) {

        char[] chars = s.toCharArray();

        int answer = 0;
        int num = 0;
        // Counting backwards, since roman numerals are ordered descending left to right.
        for (int i = chars.length - 1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (num * 4 < answer) { 
                // Can have up to III -- 3 numerals in a row. The fourth will have to be smaller. So num*4 is guarenteed to 
                // be larger than answer unless it is a "subtraction exception case."
                answer -= num;
            } else {
                answer += num;
            }
        }

        return answer;
        
    }
}