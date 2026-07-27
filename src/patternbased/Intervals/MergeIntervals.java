package patternbased.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {

            int[] current = intervals[i];
//            Because after sorting, all earlier intervals have already been merged into lastMerged
//            if they overlapped. Any interval before lastMerged ends at or before lastMerged
//            and therefore cannot create a new overlap that lastMerged hasn't already captured
            int[] lastMerged = merged.get(merged.size() - 1);

            // current.start <= previous.end ?
            if (current[0] <= lastMerged[1]) {
                lastMerged[1] = Math.max(current[1], lastMerged[1]);
            } else {
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // Add the merged interval
        result.add(newInterval);

        // 3. Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }

   public int[][] mergeRevision(int[][] interval){
        Arrays.sort(interval, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();

        merged.add(interval[0]);

        for(int i = 1; i < interval.length ; i++){
            int[] current = interval[i];

            int[] lastMerged = merged.get(merged.size() -1);

            if(current[0] <= lastMerged[1]){
                lastMerged[1] = Math.max(current[1], lastMerged[1]);
            } else {
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
   }

    public int[][] insertRevision(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;
// 1. Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // 2. Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            result.add(newInterval);
        }
//3. copy remaining elements.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart < prevEnd) {
                removals++;

                prevEnd = Math.min(prevEnd, currentEnd);
            } else {
                prevEnd = currentEnd;
            }
        }
        return removals;
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }

    public int eraseOverlapIntervalsRev(int[][] intervals){
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        int removals = 0;

        int prevEnd = intervals[0][1];

        for(int i = 1 ; i < intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart < prevEnd){
                removals++;
                prevEnd = Math.min(currEnd,prevEnd);
            } else {
                prevEnd = currEnd;
            }

        }
        return removals;
    }

    public int findMinArrowShotsRev(int[][] points){
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for(int i = 1; i < points.length; i++){
            if(points[i][0] > arrowPos){
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }


    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] intervals1 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        int[][] points = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };

//        int [][] result = mergeIntervals.merge(intervals);
//
//        for(int[] interval : result){
//            System.out.println(Arrays.toString(interval));
//        }

        int result = mergeIntervals.eraseOverlapIntervals(intervals1);
        //       System.out.println(result);

        int arrows = mergeIntervals.findMinArrowShots(points);
        System.out.println(arrows);
    }
}
