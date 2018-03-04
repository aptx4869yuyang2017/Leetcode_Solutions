import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        //System.out.println(height);

        int[] miniPath = new int[height+1]; //  当只有一个数据时候最底层的循环代码min计算，还是有两个数据的加和
        for (int i = 0; i < miniPath.length; i++) {
            System.out.println(miniPath[i]);
        }

        // 从上到下遍历，需要分析特殊处理两侧的情况
        // 从下到上遍历，则可以省掉了特殊情况的处理
        // 注意考虑开始和结束的情况

        for (int i = height-1; i >= 0; i--) {

            List<Integer> tmp = triangle.get(i);

            for (int j = 0; j < tmp.size() ; j++) {
                miniPath[j] = Math.min(miniPath[j], miniPath[j+1]) + tmp.get(j);
            }


        }
        return miniPath[0];
    }

}
