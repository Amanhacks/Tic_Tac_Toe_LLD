package com.example.tictactoe.WinningStrategy;

import com.example.tictactoe.Model.Board;
import com.example.tictactoe.Model.Move;
import com.example.tictactoe.Model.Player;

public interface WinningStrategy {
    boolean checkIfWon(Player player, Board board, Move move);
}
