import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] sudoku = new int[9][9];
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] cols = new boolean[9][10];
    static boolean[][] boxes = new boolean[9][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                sudoku[i][j] = Integer.parseInt(input[j]);
                if(sudoku[i][j] != 0){
                    int num = sudoku[i][j];
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[getBoxIndex(i, j)][num] = true;
                }
            }
        }
        solve(0, 0);

        //출력
        printSdoku();

    }

    public static boolean solve(int row, int col){
        if(row == 9){
            return true;
        }

        if(col == 9) {
            return solve(row + 1, 0);
        }

        if(sudoku[row][col] != 0){
            return solve(row, col + 1);
        }

        for(int num = 1; num <= 9; num++){
            if(isValid(row, col, num)){
                sudoku[row][col] = num;
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[getBoxIndex(row, col)][num] = true;

                if(solve(row, col + 1)){
                    return true;
                }

                sudoku[row][col] = 0;
                rows[row][num] = false;
                cols[col][num] = false;
                boxes[getBoxIndex(row, col)][num] = false;
            }
        }
        return false;
    }

    public static boolean isValid(int row, int col, int num){
        return !rows[row][num] && !cols[col][num] && !boxes[getBoxIndex(row, col)][num];
    }

    public static int getBoxIndex(int row, int col){
        return (row / 3) * 3 + (col / 3);
    }

    public static void printSdoku(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }



}
