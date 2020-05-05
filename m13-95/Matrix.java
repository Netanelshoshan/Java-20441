
/**
 * This class represents 2D-array Matrix of black-white RGB's.
 * While 0 represent the white and 255 represent black, the values between represents the gray.
 * <p>
 * More information on how to use it can be found in the API documentation.
 *
 * @author Netanel Shoshan.
 * @version 28/12/2019
 */

public class Matrix {
    // Instance variables:
    private int[][] _matArr;

    /**
     * Constructs a Matrix from two dimensional array, the dimensions as well as
     * the values of this Matrix will be the same as the dimensions and values
     * of the two-dimensional array.
     */
    public Matrix(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        _matArr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                _matArr[i][j] += array[i][j];
                // Im not sure I did it the right way or this is still aliasing.
            }
        }
    }

    /**
     * Constructs a size1 by size2 Matrix of zeros.
     *
     * @param size1 represents the lines.
     * @param size2 represents the columns.
     */
    public Matrix(int size1, int size2) {
        _matArr = new int[size1][size2];

        // Start iterating through the array and assigning the zero value for each element.
        for (int row = 0; row < _matArr.length; row++) {
            for (int col = 0; col < _matArr[row].length; col++)
                _matArr[row][col] = 0;
            // Im not sure I did it the right way or this is still aliasing.
        }

    }

    /**
     * This method will return the negative value of the pic.
     * Each point in the array that had black value will have white value vise versa.
     * (will return new array).
     *
     * @return for each element in the array, his (abs) negative value.
     */
    public Matrix makeNegative() {

        // Negative value for the
        int NEG_RGB = 255;

        // Copy matrix for the negative values.
        int rowsOfNegative = _matArr.length;
        int colOfNegative = _matArr[0].length;
        int[][] negativeMatrix = new int[rowsOfNegative][colOfNegative];

        // Start iterating through the original matrix and copy the values.
        for (int i = 0; i < rowsOfNegative; i++)
            for (int j = 0; j < colOfNegative; j++) {
                negativeMatrix[i][j] += _matArr[i][j];
            }

        // Subtracting from each element in the matrix the negative value.
        for (int row = 0; row < negativeMatrix.length; row++) {
            for (int col = 0; col < negativeMatrix[row].length; col++) {
                negativeMatrix[row][col] -= Math.abs(NEG_RGB);
            }
        }

        /* After subtracting from each element his negative value,
            we get matrix with negative values, so I wrote another loop in order
            to get the absolute value of each element and return new positive matrix.*/
        // Changing from negative values to positive values.
        for (int row = 0; row < _matArr.length; row++) {
            for (int col = 0; col < _matArr[row].length; col++)
                negativeMatrix[row][col] = Math.abs(negativeMatrix[row][col]);
        }

        return new Matrix(negativeMatrix);
    }// End of makeNegative method.

    /**
     * This method will return the matrix 90 degrees clockwise.
     */
    public Matrix rotateClockwise() {
        // Named them in reverse, so it would be easy to know the diff.
        int rowsOfRotated = _matArr[0].length; // Total COLUMNS of the original matrix.
        int colOfRotated = _matArr.length; //     Total ROWS of the original matrix.
        int[][] rotatedMatrix = new int[rowsOfRotated][colOfRotated]; // Creating new rotated matrix.

        /* Start iterating throw the array and assign the values from the elements in original
        array to the rotatedMatrix.
         */
        for (int row = 0; row < _matArr.length; row++) {
            for (int col = 0; col < _matArr[0].length; col++) {
                rotatedMatrix[col][(colOfRotated - 1) - row] = _matArr[row][col];
            }
        }
        return new Matrix(rotatedMatrix);
    }// End of rotateClockwise method.

    /**
     * This method will return the array 90 degrees <against the clock.>
     */
    public Matrix rotateCounterClockwise() {
        // Named them in reverse, so it would be easy to know the diff.
        int rowsOfRotated = _matArr[0].length; // Total COLUMNS of the original matrix.
        int colOfRotated = _matArr.length; //     Total ROWS of the original matrix.
        int[][] rotatedMatrix = new int[rowsOfRotated][colOfRotated]; // Creating new rotated matrix.

        /* Start iterating throw the array and assign the values from the elements in original
        array to the rotatedMatrix.
         */
        for (int row = 0; row < _matArr.length; row++) {
            for (int col = 0; col < _matArr[0].length; col++) {
                rotatedMatrix[(rowsOfRotated - 1) - col][row] = _matArr[row][col];
            }
        }
        return new Matrix(rotatedMatrix);// Assigning the matrix to the rotated one.
    }// End of rotateCounterClockwise method.

    /**
     * This method averages the neighbors of each cell in the 2D array.
     * <p>
     * In order to do so, I had to create another two methods:
     * countNeighbor - to count the number of neighbors around each element.
     * sumNeighbor - to sum the values of neighbors.
     * After that , will davide the sumOfNeighbors with the noOfNeighbors.
     *
     * @return new array and replace each element with the average of his neighbors.
     */
    public Matrix imageFilterAverage() {
        //Initialize new array with only with the row length of the original matrix.
        int[][] filteredImage = new int[_matArr.length][];

        //Initializing local vars to so we could assign the data we'll get from the other two methods later on..
        int noOfNeighbors = 0;
        int sumOfNeighbors = 0;

        /*
        Self-Explanation:
        Start iterating throw the matrix.
        For each element in the matrix,
        1. Send him for evaluation (countNeighbor and sumNeighbor).
        2. Calculate the sum & assign the new data to the same location in the new array. and so on..

        I'll demonstrate is for better understanding:
        1   2   3
        4   5   6
        The countNeighbor will start iterating through the array and in when counting how many neighbors num 1 has,
        ->> will return 4 (including 1 himself).
        After that, will assign the num of neighbors that we found to local integer called noOfNeighbors.
        Will pass the if statement because we have 4 neighbors.
        The sumNeighbor does the same calculation as countNeighbor with a little diff.
        The only difference is that instead of a counter she sums the number of neighbors.
        In our case, the sum of the first run (12) (1+2+4+5) to sumOfNeighbors. cool.
        After we've got this two parameters, we can assign them to the new array
        ->> at the same point we did the calculation.
         */
        for (int row = 0; row < _matArr.length; row++) {
            filteredImage[row] = new int[_matArr[row].length];
            for (int col = 0; col < _matArr[0].length; col++) {
                noOfNeighbors = countNeighbor(_matArr, row, col); //Getting the neighbors using the countNeighbor method
                if (noOfNeighbors != 0) {
                    /*Will get the sum of the neighbors around, which leaves us just to davide the rows
                     and columns and return new Matrix with the filtered values*/
                    sumOfNeighbors = sumNeighbor(_matArr, row, col);
                    filteredImage[row][col] = sumOfNeighbors / noOfNeighbors;
                }
            }
        }
        return new Matrix(filteredImage);
    }// End of imageFilterAverage

    /**
     * This method calculate how many neighbors are around the element.
     *
     * @param countNei the array to preform the check on.
     * @param row      the number of rows.
     * @param col      the number of columns.
     * @return the number of neighbors around.
     */
    private int countNeighbor(int[][] countNei, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                /* If i is inside the array and i is not exceeding the number of rows,
                and j is inside the array and j is not exceeding the number of columns,
                increment the counter by 1.
                 */
                if (i >= 0 && i <= countNei.length - 1 && j >= 0 && j <= countNei[0].length - 1) {
                    count++;
                }
            }
        }
        return count;
    }// End of countNeighbor method.

    /**
     * This method calculates the sum of elements.
     *
     * @param sumNei the array to preform the check on.
     * @param row    the number of rows.
     * @param col    the number of columns.
     * @return the sum of the neighbors around.
     */
    private int sumNeighbor(int[][] sumNei, int row, int col) {
        int sum = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                /* If i is inside the array and i is not exceeding the number of rows,
                and j is inside the array and j is not exceeding the number of columns,
                increment sum by the rows and columns.
                 */
                if (i >= 0 && i <= sumNei.length - 1 && j >= 0 && j <= sumNei[0].length - 1) {
                    sum += sumNei[i][j];
                }
            }
        }
        return sum;
    }// End of sumNeighbor.

    /**
     * Will print the matrix.
     *
     * @return the matrix.
     */

    public String toString() {
        String str = "";
        for (int row = 0; row < _matArr.length; row++) {
            for (int col = 0; col < _matArr[row].length; col++)
                str += _matArr[row][col] + "\t";
            str += "\n";

        }
        return str;
    } // End of toString method.
} //End of Matrix class.

