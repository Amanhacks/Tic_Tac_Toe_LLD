package com.example.tictactoe.BotPlayingStrategy;

import com.example.tictactoe.Model.Board;
import com.example.tictactoe.Model.Cell;
import com.example.tictactoe.Model.Move;
import com.example.tictactoe.Model.Player;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> cells = board.getCells();

        for(int i=0;i<board.getDimension();i++) {
            for(int j=0;j<board.getDimension();j++) {
                if(cells.get(i).get(j).getSymbol() == null) {
                    Cell cell = new Cell();
                    cell.setRow(i);
                    cell.setCol(j);
                    cell.setSymbol(player.getSymbol());
                    return new Move(player,cell);
                }
            }
        }
        return null;
    }
}

