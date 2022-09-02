package com.example.tictactoe.Model;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Symbol symbol;


    public HumanPlayer(Symbol symbol) {
        super(PlayerType.HUMAN,symbol);
        this.symbol = symbol;
    }

    @Override
    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the row for your move  : ");
        int row = scanner.nextInt();

        System.out.println("Select the column for your move  : ");
        int col = scanner.nextInt();
        Cell cell = new Cell();
        cell.setRow(row);
        cell.setCol(col);
        cell.setSymbol(this.symbol);
        return new Move(this,cell);
    }
}
