package com.example.tictactoe.WinningStrategy;

import com.example.tictactoe.Module.Board;
import com.example.tictactoe.Module.Move;
import com.example.tictactoe.Module.Player;

public interface WinningStrategy {
    boolean checkIfWon(Player player, Board board, Move move);
}
