package com.ticTocToe;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        char board[][] = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("player " + player + " Enter:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveOwn(board, player);
                if (gameOver) {
                    System.out.println("player " + player + " has own");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else
                System.out.println("Invalid move!..Try again");
        }
        printBoard(board);
    }

    public static boolean haveOwn(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if(board[row][0]==player&&board[row][1]==player&&board[row][2]==player){
                return true;
            }
        }
        for (int col = 0; col < board[0].length ; col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;

    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
