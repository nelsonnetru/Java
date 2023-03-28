// 4*. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

import java.util.ArrayList;

public class Class_04 {
    private static int[][] chessBoard = new int[8][8];
    private static int counter = 0;

    public static void main(String[] args) {
        findPosition(0); // стартуем с нижней строки
    }

    private static void setQueen (int i, int j) {
        for (int x = 0; x < 8; x++) {
            chessBoard[x][j] += 1;
            chessBoard[i][x] += 1;
            if (0 <= i + j - x && i + j - x < 8)
                chessBoard[i + j - x][x] += 1;
            if (0 <= i - j + x && i - j + x < 8)
                chessBoard[i - j + x][x] += 1;
        }
        chessBoard[i][j] = -1;
    }

    private static void removeQueen (int i, int j) {
        for (int x = 0; x < 8; x++) {
            chessBoard[x][j] -= 1;
            chessBoard[i][x] -= 1;
            if (0 <= i + j - x && i + j - x < 8)
                chessBoard[i + j - x][x] -= 1;
            if (0 <= i - j + x && i - j + x < 8)
                chessBoard[i - j + x][x] -= 1;
        }
        chessBoard[i][j] = 0;
    }

    private static void printPos () {
        String letters = "abcdefgh";
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] == -1)
                    answer.add(letters.charAt(j)+ "" + (i+1));
            }
        }
         counter += 1;
         System.out.println("Позиция " + counter + ": " + answer);
    }

    private static void findPosition (int i) {
        for (int j = 0; j < 8; j++) {
            if (chessBoard[i][j] == 0)
            {
                setQueen(i, j);
                if (i == 7) // если верхняя строка
                    printPos();
                else
                    findPosition(i + 1);
                removeQueen(i, j);
            }
        }
    }
}
