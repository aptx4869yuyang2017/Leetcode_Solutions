import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {

        if (intervals.length == 0)
            return 0;


        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);

        // 第一层循环，遍历所有intervals[i] interval
        // 第二层循环，寻找这个 interval 之前的 intervals[j], 判断是否能接到这个interval[j] 上形成更多的 interval 数量

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j].end <= intervals[i].start)
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }

        int maxNum = 0;
        for (int i = 0; i < intervals.length; i++) {
            maxNum = Math.max(maxNum, memo[i]);
        }

        return intervals.length - maxNum;
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(1, 3)};
        System.out.println((new Solution()).eraseOverlapIntervals(interval1));

        Interval[] interval2 = {new Interval(1, 2),
                new Interval(1, 2),
                new Interval(1, 2)};
        System.out.println((new Solution()).eraseOverlapIntervals(interval2));

        Interval[] interval3 = {new Interval(1, 2),
                new Interval(2, 3)};
        System.out.println((new Solution()).eraseOverlapIntervals(interval3));

    }
}
