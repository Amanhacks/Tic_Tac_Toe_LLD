package com.example.tictactoe.BotPlayingStrategy;

import com.example.tictactoe.Module.Board;
import com.example.tictactoe.Module.Move;
import com.example.tictactoe.Module.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
