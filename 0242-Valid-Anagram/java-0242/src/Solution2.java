import java.util.HashMap;

class Solution2 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> record = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (record.containsKey(ch))
                record.put(ch, record.get(ch) + 1);
            else
                record.put(ch, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (record.containsKey(ch))
                record.put(ch, record.get(ch) - 1);
        }

        // printMap(record);

        for (Character ch : record.keySet()) {
            if (record.get(ch) > 0)
                return false;
        }

        return true;


    }

    // public void printMap(HashMap<Character, Integer> map){
    //     for (Character ch : map.keySet()){
    //         System.out.print(ch + " " + map.get(ch));
    //     }
    //     System.out.println();
    // }

    // public static void main(String[] args) {
    //     String s = "mmmmkkkkffff";
    //     String t = "ffffkkkkmmmm";
    //     System.out.println((new Solution()).isAnagram(s, t));
    // }
}
