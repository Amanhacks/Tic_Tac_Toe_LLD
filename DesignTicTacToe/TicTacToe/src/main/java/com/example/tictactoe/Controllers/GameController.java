package com.example.tictactoe.Controllers;


import com.example.tictactoe.Model.*;
import com.example.tictactoe.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimensionOfBoard, List<Player> players, List<WinningStrategy> strategies) {


          Game game = Game.create()
                    .setDimension(dimensionOfBoard)
                    .setPlayers(players)
                    .setWinningStrategy(strategies)
                    .Built();

        return game;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void showBoard(Game game) {
        game.showBoard();
    }


}
