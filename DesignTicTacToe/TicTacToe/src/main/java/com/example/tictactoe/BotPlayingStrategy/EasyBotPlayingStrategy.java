package com.example.tictactoe.BotPlayingStrategy;

import com.example.tictactoe.Module.Board;
import com.example.tictactoe.Module.Cell;
import com.example.tictactoe.Module.Move;
import com.example.tictactoe.Module.Player;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> cells = board.getCells();

        for(int i=0;i<board.getDimension();i++) {
            for(int j=0;j<board.getDimension();j++) {
                if(cells.get(i).get(j).getSymbol() == null) {
                    return new Move(player,new Cell(i,j,player.getSymbol()));
                }
            }
        }
        return null;
    }
}

