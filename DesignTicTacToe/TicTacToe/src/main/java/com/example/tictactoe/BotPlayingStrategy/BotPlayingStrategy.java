package com.example.tictactoe.BotPlayingStrategy;

import com.example.tictactoe.Model.Board;
import com.example.tictactoe.Model.Move;
import com.example.tictactoe.Model.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
