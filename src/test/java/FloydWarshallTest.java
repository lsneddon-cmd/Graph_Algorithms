import org.junit.Assert;
import org.junit.Test;

public class FloydWarshallTest {
    @Test
    public void Test1() {
        final int I = 9999;
        int[][] adjacency = new int[][] {
                {0,I,2,I,I,8,4},
                {2,0,I,1,I,I,I},
                {I,I,0,I,I,5,I},
                {I,I,I,0,I,I,I},
                {I,I,I,I,0,I,I},
                {I,I,I,I,0,I,5},
                {I,3,I,1,3,I,I}
        };
        int[][] cost = new int[][] {
                {0, 7, 2, 5, 7, 7, 4},
                {2, 0, 4, 1, 9, 9, 6},
                {15, 13, 0, 11, 5, 5, 10},
                {I, I, I, 0, I, I, I},
                {I, I, I, I, 0, I, I},
                {10, 8, 12, 6, 0, 17, 5},
                {5, 3, 7, 1, 3, 12, 9}
        };
        FloydWarshall floydWarshall = new FloydWarshall(adjacency);
        int[][] testOutput = floydWarshall.getCostMatrix();

        Assert.assertArrayEquals(testOutput, cost);
    }

    @Test
    public void Test2() {
        int[][] adjacency = new int[][] {
                {0, 9, 2},
                {1, 0, 4},
                {2, 4, 0}
        };
        int[][] cost = new int[][] {
                {0, 6, 2},
                {1, 0, 3},
                {2, 4, 0}
        };
        FloydWarshall floydWarshall = new FloydWarshall(adjacency);
        int[][] testOutput = floydWarshall.getCostMatrix();
        Assert.assertArrayEquals(testOutput, cost);
    }
}