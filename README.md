# sudoku-solver

This program is designed to solve sudoku puzzles.

However, in order to successfully execute this program
severl things needed to be done before running this program.

First, in the Grid class I try to simulate a grid.
Thus, the file you put into this pogram should have some
specifc format. The format of the file should be 9 * 9.

Example: test.txt

0 0 5 3 0 0 0 0 0
8 0 0 0 0 0 0 2 0
0 7 0 0 1 0 5 0 0
4 0 0 0 0 5 3 0 0
0 1 0 0 7 0 0 0 6
0 0 3 2 0 0 0 8 0
0 6 0 5 0 0 0 0 9
0 0 4 0 0 0 0 3 0
0 0 0 0 0 9 7 0 0

The position where the number is unknown should be 0 or 
any characteristics other than number between 1-9
Also it should be nine columns and nine rows
And when inputting the file name, the name should be complete
with the file name and the postfix such as .txt, .doc
The .txt format is highly recommanded.

Second, the text file should be put under the same folder as the java code, which is Grid.java and SudokuSolver.java

You can find the codes and file example in sudok folder.

