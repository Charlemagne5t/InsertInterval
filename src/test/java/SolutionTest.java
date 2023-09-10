import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void insertTest1() {
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        int[] newInterval = {2, 5};
        int[][] expected = {
                {1, 5},
                {6, 9}
        };

        int[][] actual = new Solution().insert(intervals, newInterval);
        boolean answer = Arrays.deepEquals(expected, actual);

        Assert.assertTrue(answer);
    }

    @Test
    public void insertTest2() {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newInterval = {4, 8};
        int[][] expected = {
                {1, 2},
                {3, 10},
                {12, 16}
        };

        int[][] actual = new Solution().insert(intervals, newInterval);
        boolean answer = Arrays.deepEquals(expected, actual);

        Assert.assertTrue(answer);
    }

    @Test
    public void insertTest3() {
        int[][] intervals = {
                {1, 5}
        };
        int[] newInterval = {6, 8};
        int[][] expected = {
                {1,5},
                {6,8}
        };

        int[][] actual = new Solution().insert(intervals, newInterval);
        boolean answer = Arrays.deepEquals(expected, actual);

        Assert.assertTrue(answer);
    }
    @Test
    public void insertTest4() {
        int[][] intervals = {
                {1, 5}
        };
        int[] newInterval = {0, 3};
        int[][] expected = {
                {0,5}
        };

        int[][] actual = new Solution().insert(intervals, newInterval);
        boolean answer = Arrays.deepEquals(expected, actual);

        Assert.assertTrue(answer);
    }
    @Test
    public void insertTest5() {
        int[][] intervals = {
                {1, 5}
        };
        int[] newInterval = {0, 0};
        int[][] expected = {
                {0,0},
                {1,5}
        };

        int[][] actual = new Solution().insert(intervals, newInterval);
        boolean answer = Arrays.deepEquals(expected, actual);

        Assert.assertTrue(answer);
    }

    @Test
    public void insertTest6() {
        int[][] intervals = {
                {0, 5},
                {9,12}
        };
        int[] newInterval = {7, 16};
        int[][] expected = {
                {0,5},
                {7,16}
        };

        int[][] actual = new Solution().insert(intervals, newInterval);
        boolean answer = Arrays.deepEquals(expected, actual);

        Assert.assertTrue(answer);
    }
    @Test
    public void insertTest7() {
        int[][] intervals = {
                {3, 5},
                {12,15}
        };
        int[] newInterval = {6, 6};
        int[][] expected = {
                {3,5},
                {6,6},
                {12, 15}
        };

        int[][] actual = new Solution().insert(intervals, newInterval);
        boolean answer = Arrays.deepEquals(expected, actual);

        Assert.assertTrue(answer);
    }
}
