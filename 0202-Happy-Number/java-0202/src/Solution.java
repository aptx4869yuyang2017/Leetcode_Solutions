import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        if (n == 1)
            return true;

        HashSet<Integer> record = new HashSet<Integer>();

        while (!record.contains(n) && n != 1){

            record.add(n);
            int temp = 0;

            while (n != 0){
                int num = n%10;
                temp += num * num;
                n = n/10;
            }

            if (temp == 1)
                return true;

            n = temp;

        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isHappy(19));
    }
}
