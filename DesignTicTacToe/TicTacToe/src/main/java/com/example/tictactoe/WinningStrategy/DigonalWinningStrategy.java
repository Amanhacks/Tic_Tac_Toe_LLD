package com.example.tictactoe.WinningStrategy;

import com.example.tictactoe.Model.Board;
import com.example.tictactoe.Model.Move;
import com.example.tictactoe.Model.Player;

public class DigonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkIfWon(Player player, Board board, Move move) {
        return false;
    }
}
