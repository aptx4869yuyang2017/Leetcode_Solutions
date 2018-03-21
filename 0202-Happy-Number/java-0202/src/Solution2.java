
//1ms 解法

class Solution2 {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int cur = n;
            n = 0;
            while (cur > 0) {
                int d = cur % 10;
                n += d*d;
                cur /= 10;
            }
        }

        return n == 1;
    }
}