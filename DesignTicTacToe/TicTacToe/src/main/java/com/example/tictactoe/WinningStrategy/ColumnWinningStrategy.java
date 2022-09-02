package com.example.tictactoe.WinningStrategy;

import com.example.tictactoe.Model.Board;
import com.example.tictactoe.Model.Move;
import com.example.tictactoe.Model.Player;
import com.example.tictactoe.Model.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy {

    List<HashMap<Symbol,Integer>> symbolVsCountPerCol;

    @Override
    public boolean checkIfWon(Player player, Board board, Move move) {
        if(symbolVsCountPerCol == null) {
            initializer(board);
        }
        if(symbolVsCountPerCol.get(move.getCell().getCol()).get(player.getSymbol())  == null) {
            symbolVsCountPerCol.get(move.getCell().getCol()).put(player.getSymbol(), 0);
        }
        int freq = symbolVsCountPerCol.get(move.getCell().getCol()).get(player.getSymbol());
        symbolVsCountPerCol.get(move.getCell().getCol()).put(player.getSymbol(), freq + 1);

        if(symbolVsCountPerCol.get(move.getCell().getCol()).get(player.getSymbol())  == board.getDimension()) {
            return true;
        }

        return false;
    }

    public void initializer(Board board) {
        symbolVsCountPerCol = new ArrayList<>();
        for(int i=0;i<board.getDimension();i++) {
            symbolVsCountPerCol.add(new HashMap<>());
        }
    }
}
