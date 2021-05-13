public class MatrixFun implements Matrix {
    private int[][] newMatrix;
    private int rowvalue = 0;
    private int columnvalue = 0;

    //Single parameter constructor
    public MatrixFun(int[][] matrix) {
        if (matrix.length == 0) {
            rowvalue = 0;
            columnvalue = 0;
        } else {
            rowvalue = matrix.length;
            columnvalue = matrix[0].length;
        }
        newMatrix = new int[rowvalue][columnvalue];
        for (int i = 0; i < rowvalue; i++) {
            for (int j = 0; j < columnvalue; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
    }

    //dpuble parameter constructor
    public MatrixFun(int x, int y) {
        rowvalue = x;
        columnvalue = y;
        newMatrix = new int[x][y];
    }

    public int[][] getMatrix() {
        return newMatrix;
    }

    public int getElement(int y, int x) {
        return newMatrix[y][x];
    }

    @Override
    public int getRows() {
        // TODO Auto-generated method stub
        return rowvalue;
    }

    @Override
    public int getColumns() {
        // TODO Auto-generated method stub
        return columnvalue;
    }

    @Override
    public Matrix scale(int scalar) {
        // TODO Auto-generated method stub
        int newval = 0;
        int i, j;

        int scaleMatrix[][] = new int[getRows()][getColumns()];
        for (i = 0; i < rowvalue; i++) {
            for (j = 0; j < columnvalue; j++) {
                newval = (getElement(i, j) * scalar);
                scaleMatrix[i][j] = newval;
            }
        }
        MatrixFun mat1 =
                new MatrixFun(scaleMatrix);
        return mat1;
    }

    @Override
    public Matrix plus(Matrix other) {
        // TODO Auto-generated method stub
        int sum = 0;
        int i, j;
        if ((getRows() == other.getRows()) && (getColumns() == other.getColumns())) {
            int summationMatrix[][] = new int[getRows()][getColumns()];
            for (i = 0; i < other.getRows(); i++) {
                for (j = 0; j < other.getColumns(); j++) {
                    sum = (getElement(i, j) + other.getElement(i, j));
                    summationMatrix[i][j] = sum;
                }
            }

            MatrixFun mat2 =
                    new MatrixFun(summationMatrix);

            return mat2;
        } else
            return new MatrixFun(0, 0);
    }

    // Implement the method multiply
    public Matrix multiply(Matrix other) {
        // TODO Auto-generated method stub
        int product = 0;
        // Declare local variables
        int i, j;
        // Use if condition to check whether rows of
        // first matrix and columns of the second matrix
        if ((getRows() == other.getColumns())) {
            // Create matrix
            int productMatrix[][] = new int[getRows()][getColumns()];
            // use for-loop to iterate and mutiply each value
            for (i = 0; i < getRows(); i++) {
                for (j = 0; j < other.getColumns(); j++) {
                    product = 0;
                    for (int k = 0; k < getColumns(); k++) {
                        product += (getElement(i, k) * other.getElement(k, j));
                    }
                    productMatrix[i][j] = product;
                }
            }
            MatrixFun mat2 =
                    new MatrixFun(productMatrix);
            return mat2;
        } else
            return new MatrixFun(0, 0);
    }


    // Implement the method minus
    @Override
    public Matrix minus(Matrix other) {
        // TODO Auto-generated method stub
        int diff = 0;
        int i, j;
        // Compare the sizes of the matrices
        if ((getRows() == other.getRows())
                && (getColumns() == other.getColumns())) {
            int minusMatrix[][] = new int[getRows()][getColumns()];

            for (i = 0; i < other.getRows(); i++) {
                for (j = 0; j < other.getColumns(); j++) {
                    diff = (getElement(i, j) - other.getElement(i, j));
                    minusMatrix[i][j] = diff;
                }
            }
            MatrixFun mat3 =
                    new MatrixFun(minusMatrix);
            return mat3;
        } else
            return new MatrixFun(0, 0);
    }

    // Implement the method equals method
    public boolean equals(Matrix other) {
        // check whether objects are null or not
        // and string is null or not
        if (other == null || this == null || other.toString().equals("[]")) {
            // return false
            return false;
        }
        // Otherwise
        // use two for-loops to check whether the
        // matrices are equal or not
        else {
            for (int i = 0; i < other.getRows(); i++) {
                for (int j = 0; j < other.getColumns(); j++) {
                    // if the elements are not equal
                    // return false
                    if (this.getElement(i, j) != other.getElement(i, j)) {
                        return false;
                    }
                }
            }
            // Otherwise return if all the elements are equal
            return true;
        }
    }

    // Implement the method toString()
    public String toString() {
        String result = "\n";
        for (int i = 0; i < rowvalue; i++) {
            for (int j = 0; j < columnvalue; j++) {
                if (j == 0)
                    result += String.format("%5d", newMatrix[i][j]);
                else
                    result += String.format("%5d", newMatrix[i][j]);
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        MatrixFun m1 = new MatrixFun(data1);
        MatrixFun m2 = new MatrixFun(data2);
        MatrixFun m3 = new MatrixFun(data3);
        MatrixFun m4 = new MatrixFun(data4);
        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: "
                + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: "
                + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: "
                + m3.getColumns());
        // check for reference issues
        System.out.println("m2 --> " + m2);
        data2[1][1] = 101;
        System.out.println("m2 --> " + m2);
        // test equals
        System.out.println("m2==null: " + m2.equals(null)); // false
        System.out.println("m3==MATRIX: " + m2.equals("MATRIX")); // false
        System.out.println("m2==m1: " + m2.equals(m1)); // false
        System.out.println("m2==m2: " + m2.equals(m2)); // true
        System.out.println("m2==m3: " + m2.equals(m3)); // false
        System.out.println("m3==m4: " + m3.equals(m4)); // true;
        // test operations (valid)
        System.out.println("2 * m2: " + m2.scale(2));
        System.out.println("m2 + m3: " + m2.plus(m3));
        System.out.println("m2 - m3: " + m2.minus(m3));
        // not tested... multiply(). you know what to do.
        System.out.println("m2 * m3: " + m2.multiply(m3));
        // test operations (invalid)
        System.out.println("m1 + m2" + m1.plus(m2));
        System.out.println("m1 - m2" + m1.minus(m2));
    }
}

