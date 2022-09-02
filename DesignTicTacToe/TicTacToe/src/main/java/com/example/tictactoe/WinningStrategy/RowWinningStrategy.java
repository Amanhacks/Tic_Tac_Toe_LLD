package com.example.tictactoe.WinningStrategy;

import com.example.tictactoe.Model.Board;
import com.example.tictactoe.Model.Move;
import com.example.tictactoe.Model.Player;
import com.example.tictactoe.Model.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowWinningStrategy implements WinningStrategy {

    List<HashMap<Symbol,Integer>> symbolVsCountPerRow;
    @Override
    public boolean checkIfWon(Player player, Board board, Move move) {
        if(symbolVsCountPerRow == null) {
            initializer(board);
        }
        if(symbolVsCountPerRow.get(move.getCell().getRow()).get(player.getSymbol())  == null) {
            symbolVsCountPerRow.get(move.getCell().getRow()).put(player.getSymbol(), 0);
        }
        int freq = symbolVsCountPerRow.get(move.getCell().getRow()).get(player.getSymbol());
        symbolVsCountPerRow.get( move.getCell().getRow()).put(player.getSymbol(), freq + 1);

        System.out.println("row number :" + move.getCell().getRow() + " player : " + player.getSymbol() + " freq :" +
                symbolVsCountPerRow.get(move.getCell().getRow()).get(player.getSymbol()));
        if(symbolVsCountPerRow.get(move.getCell().getRow()).get(player.getSymbol())  == board.getDimension()) {
            return true;
        }

        return false;
    }
    public void initializer(Board board) {
        symbolVsCountPerRow = new ArrayList<>();
        for(int i=0;i<board.getDimension();i++) {
            symbolVsCountPerRow.add(new HashMap<>());
        }
    }
}
