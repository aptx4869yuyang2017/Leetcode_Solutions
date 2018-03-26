
// 查找问题的核心永远是要搞清楚，具体要讲什么数据放入查找表
// O(n) 29ms 54%

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length==0) return new ArrayList<List<String>>();

        HashMap<String, List<String>> record = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {

            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!record.containsKey(keyStr))
                record.put(keyStr, new ArrayList<String>());
            record.get(keyStr).add(str);

        }

        return new ArrayList<List<String>>(record.values());

    }

    public static void main(String[] args) {

        String[] strs = new String[]{"eate", "atee", "eat", "tan", "ant"};
        System.out.println((new Solution()).groupAnagrams(strs));

    }
}
