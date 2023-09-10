public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int index = binarySearch(intervals, newInterval[0]);

        if (index == 0 && newInterval[0] < intervals[0][0] && newInterval[1] >= intervals[0][0]) {
            intervals[0][0] = newInterval[0];
        }

        if (index == 0 && newInterval[0] < intervals[0][0]) {
            int[][] newIntervals = new int[intervals.length + 1][2];
            newIntervals[0] = newInterval;
            for (int i = 1; i < newIntervals.length; i++) {
                newIntervals[i] = intervals[i - 1];
            }
            return newIntervals;
        }

        if (intervals[index][1] < newInterval[0] && (index == intervals.length - 1 || newInterval[1] < intervals[index + 1][0])) {
            int[][] newIntervals = new int[intervals.length + 1][2];
            for (int i = 0, j = 0; i < intervals.length; i++) {
                newIntervals[j] = intervals[i];
                j++;
                if (i == index) {
                    newIntervals[j] = newInterval;
                    j++;
                }
            }
            return newIntervals;
        }


        if (intervals[index][0] <= newInterval[0] && intervals[index][1] >= newInterval[1]) {
            return intervals;
        }
        if ((intervals[index][0] <= newInterval[0]) && (intervals[index][1] < newInterval[1]) && (newInterval[0] <= intervals[index][1])) {

            int devoured = index;
            while (devoured < intervals.length && intervals[devoured][0] <= newInterval[1]) {
                devoured++;
            }
            devoured--;
            newInterval[0] = intervals[index][0];
            newInterval[1] = Math.max(newInterval[1], intervals[devoured][1]);
            int[][] newIntervals = new int[intervals.length - (devoured - index)][2];

            for (int i = 0, j = 0; i < intervals.length; i++) {
                if (i < index || i > devoured) {
                    newIntervals[j] = intervals[i];
                    j++;
                } else if (i == index) {
                    newIntervals[j] = newInterval;
                    j++;
                }
            }

            return newIntervals;
        }
        if (newInterval[0] > intervals[index][1] && (index == intervals.length - 1 || intervals[index + 1][0] < newInterval[1])) {
            int[][] newIntervals = new int[intervals.length + 1][2];
            if (index < intervals.length - 1 && newInterval[1] >= intervals[index + 1][0]) {
                int devoured = index + 1;
                while (devoured < intervals.length && intervals[devoured][0] <= newInterval[1]) {
                    devoured++;
                }
                devoured--;
                newInterval[1] = Math.max(newInterval[1], intervals[devoured][1]);
                int[][] newIntervalsA = new int[intervals.length - (devoured - index - 1)][2];
                for (int i = 0, j = 0; i < intervals.length; i++) {
                    if (i <= index || i > devoured) {
                        newIntervalsA[j] = intervals[i];
                        j++;
                    } else if (i == index + 1) {
                        newIntervalsA[j] = newInterval;
                        j++;
                    }
                }
                return newIntervalsA;
            }
            for (int i = 0, j = 0; i < intervals.length; i++) {
                newIntervals[j] = intervals[i];
                j++;
                if (i == index) {
                    newIntervals[index + 1] = newInterval;
                    j++;
                }
            }
            return newIntervals;
        }


        return intervals;
    }

    private int binarySearch(int[][] intervals, int start) {
        int l = 0;
        int r = intervals.length - 1;
        int mid = l + (r - l) / 2;

        int index = 0;
        while (l <= r) {

            mid = l + (r - l) / 2;
            if (intervals[mid][0] == start) {
                return mid;
            }

            if (intervals[mid][0] < start) {
                index = mid;
                l = mid + 1;
            }

            if (intervals[mid][0] > start) {
                r = mid - 1;
            }
        }
        return index;
    }
}
