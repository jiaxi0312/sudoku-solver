/**
 * The Grid class is created to stimulate the sodoku grid
 * and keep track the overall situation of this grid
 */

import java.util.*;

public class Grid {
    /**
     * reads the given file
     */
    private Scanner input;

    /**
     * stores the specific numbers by cols
     */
    private int[][] cols;


    /**
     * initialize this class by reading the input file
     * create the cols
     * @param input used to read a file
     */
    public Grid(Scanner input) {

        this.input = input;
        this.createCols();
    }

    /**
     * creates the grid containing some specific numbers
     * iterates all the elements in the scanner and then
     * stores the given numbers in the grid
     */
    public void createCols() {
        this.cols = new int[9][9];
        int index = 0;
        while (input.hasNextLine()) {
            String s = input.nextLine();
            createCols(s, index);
            index++;
        }
    }

    /**
     * helper method for createCols
     * stores the given number from the scanner into the grid
     * if there is no given number stores 0
     * @param index keeps track of the row of the cols
     * @param s     a line to be precessed
     */
    private void createCols(String s, int index) {

        Scanner console = new Scanner(s);
        int j = 0;
        while (console.hasNext()) {
            if (console.hasNextInt()) {
                int next = console.nextInt();
                this.cols[index][j] = next;
            } else {
                console.next();
            }
            j++;
        }
    }

    /**
     * gets a void place for placing a new number
     * @return an array contains the location
     * the first element of the array is row position, second is the col position
     * if all locations have been assigned return -1 in both places
     */
    public int[] getUnassignedLocation() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int next = this.cols[i][j];
                if (next == 0) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        int[] result = {-1, -1};
        return result;
    }

    /**
     * checks weather this number is safe to place in this location
     *
     * @param coordinate the void place which can be used to put the number
     * @param number     the given number to be put into the grid
     */
    public boolean isSafe(int[] coordinate, int number) {

        int row = coordinate[0];
        int col = coordinate[1];
        return checkRows(row, number) && checkCols(col, number)
                && checkSquares(row / 3 * 3, col / 3 * 3, number);
    }

    /**
     * check this particular row is safe to place this number
     *
     * @param number the number to be put
     * @param row    the row to be checked
     */
    private boolean checkRows(int row, int number) {

        int[] check = this.cols[row];
        return contains(check, number);
    }

    /**
     * checks the column is safe to put the given
     *
     * @param number the number to be put
     * @param col    the col to be checked
     */
    private boolean checkCols(int col, int number) {

        int[] check = new int[9];
        for (int i = 0; i < 9; i++) {
            check[i] = this.cols[i][col];
        }
        return contains(check, number);
    }

    /**
     * Sees weather this 3*3 square contains the same number
     *
     * @param x the x coordinate of the place where the number will be assigned to
     * @param y the y coordinate
     */
    private boolean checkSquares(int x, int y, int number) {

        int[] check = new int[9];
        int index = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                check[index] = this.cols[i][j];
                index++;
            }
        }
        return contains(check, number);
    }

    /**
     * Checks if the given array contains same number
     *
     * @param check the array to be checked
     */
    private boolean contains(int[] check, int number) {

        for (int n : check) {
            if (n == number) {
                return false;
            }
        }
        return true;
    }

    /**
     * Places the number to the given place
     *
     * @param place where to put the number
     */
    public void place(int[] place, int number) {
        this.cols[place[0]][place[1]] = number;
    }

    /**
     * remove the number from the given place
     */
    public void remove(int[] place) {
        this.cols[place[0]][place[1]] = 0;
    }

    /**
     * Print the grid
     */
    public void print() {
        for (int[] a : this.cols) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returns the cols when needed
     */
    public int[][] getCols() {

        return cols;
    }
}
