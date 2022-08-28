package com.example.tictactoe.Module;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Symbol symbol;


    HumanPlayer(Symbol symbol) {
        super(PlayerType.HUMAN,symbol);
        this.symbol = symbol;
    }

    @Override
    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the row for your move  : ");
        int row = scanner.nextInt();

        System.out.println("Select the row for your move  : ");
        int col = scanner.nextInt();

        return new Move(this,new Cell(row,col,this.symbol));
    }
}
