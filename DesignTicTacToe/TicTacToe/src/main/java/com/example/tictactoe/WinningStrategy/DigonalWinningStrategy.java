package com.example.tictactoe.WinningStrategy;

import com.example.tictactoe.Module.Board;
import com.example.tictactoe.Module.Move;
import com.example.tictactoe.Module.Player;

public class DigonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkIfWon(Player player, Board board, Move move) {
        return false;
    }
}
