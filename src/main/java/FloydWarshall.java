public class FloydWarshall {
    private int[][] initialAdjacencyMatrix;
    private int[][] costMatrix;

    public FloydWarshall(int[][] adjacencyMatrix) {
        this.initialAdjacencyMatrix = adjacencyMatrix;
        this.costMatrix = performFloydWarshallAlgorithm(adjacencyMatrix);
    }

    private static int[][] performFloydWarshallAlgorithm(int[][] adjacencyMatrix) {
        for (int k = 0; k < adjacencyMatrix.length; k++) {
            adjacencyMatrix = updateIfNodeShortens(adjacencyMatrix, k);
        }
        return adjacencyMatrix;
    }

    private static int[][] updateIfNodeShortens(int[][] matrix, int node) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][node] + matrix[node][j] < matrix[i][j]) {
                    res[i][j] = matrix[i][node] + matrix[node][j];
                } else {
                    res[i][j] = matrix[i][j];
                }
            }
        }
        return res;
    }

    public int[][] getCostMatrix() {
        return costMatrix;
    }

    public void printCostMatrix() {
        for(int[] row : this.costMatrix) {
            for (int element : row) {
                System.out.printf("%4d\t", element);
            }
            System.out.println();
        }
    }
}
