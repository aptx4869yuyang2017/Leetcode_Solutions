// 贪心算法


import java.util.Arrays;
import java.util.Comparator;

class Solution2 {
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
                if (o1.end != o2.end)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        Interval preInterval = intervals[0];
        int n = 1; //记录构成最多的区间数量



        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i].start >= preInterval.end){
                n++;
                preInterval = intervals[i];
            }


        }

        return intervals.length - n;
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(1, 3)};
        System.out.println((new Solution2()).eraseOverlapIntervals(interval1));

        Interval[] interval2 = {new Interval(1, 2),
                new Interval(1, 2),
                new Interval(1, 2)};
        System.out.println((new Solution2()).eraseOverlapIntervals(interval2));

        Interval[] interval3 = {new Interval(1, 2),
                new Interval(2, 3)};
        System.out.println((new Solution2()).eraseOverlapIntervals(interval3));

    }
}

