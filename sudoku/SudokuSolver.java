/**
 * This program is designed to use recursion to solve the sudoku questions
 * Before running this program, user is highly recommended to format their input file
 * so that the program can be successfully executed.
 * The detailed instruction is contained in the Readme file.
 */

import java.util.*;
import java.io.*;

public class SudokuSolver {
    public static void main(String[] args) throws FileNotFoundException {
        getInfor();
        Scanner console = new Scanner(System.in);
        Scanner input = checkFile(console);

        //creates the grid
        Grid g = new Grid(input);
        System.out.println();

        //finds the answer
        getAnswer(g);
    }

    //gives the introduction
    public static void getInfor() {
        System.out.println("This program is designed to solve the sudoku problems");
        System.out.println("Before enter your file name, ensure you have followed");
        System.out.println("the Readme file to format your problem file.");
        System.out.println();

    }

    //checks weather the file exists
    public static Scanner checkFile(Scanner console) throws FileNotFoundException{
        System.out.print("Your file name? ");
        String name = console.next();
        File f = new File(name);
        while (!f.exists()) {
            System.out.println("\nNo such file found, try again.");
            System.out.print("Your file name? ");
            name = console.next();
            f = new File(name);
        }
        return new Scanner(f);
    }

    //gets the answer
    public static void getAnswer(Grid g) {
        if (explore(g)) {
            //gets the right answer
            g.print();
        } else {
            //no answer found
            System.out.println("No solution found.");
        }
    }

    private static boolean explore(Grid g) {
        int[] cellNumber = g.getUnassignedLocation();
        if (cellNumber[0] == -1) {
            //every position has been placed the right number
            return true;
        } else {
            //still some position need to be filled
            for (int n = 1; n <= 9; n++) {
                //try all of the possible numbers
                if (g.isSafe(cellNumber, n)) {
                    g.place(cellNumber, n);
                    if (explore(g)) {
                        return true;
                    }
                    g.remove(cellNumber);
                }
            }
            return false;
        }
    }
}
