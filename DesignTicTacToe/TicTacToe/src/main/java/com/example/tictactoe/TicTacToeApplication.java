package com.example.tictactoe;

import com.example.tictactoe.Controllers.GameController;
import com.example.tictactoe.Model.*;
import com.example.tictactoe.WinningStrategy.ColumnWinningStrategy;
import com.example.tictactoe.WinningStrategy.RowWinningStrategy;
import com.example.tictactoe.WinningStrategy.WinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);

        int dimension = 3;
        Player p1 = new HumanPlayer(new Symbol('X'));
        Player p2 = new BotPlayer(new Symbol('O'), BotPlayingDifficulty.EASY);
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        WinningStrategy row = new RowWinningStrategy();
        WinningStrategy col = new ColumnWinningStrategy();


        GameController gameController = new GameController();

        Game game = gameController.createGame(dimension, players, List.of(row,col));





        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("Please Make the Next Move. This is current Status");
            gameController.showBoard(game);
            gameController.makeMove(game);
        }

        if (gameController.getGameStatus(game).equals(GameStatus.WIN)) {
            System.out.println("WINNER WINNER CHICKEN DINNER");
            gameController.getWinner(game);
        }

        if (gameController.getGameStatus(game).equals(GameStatus.DRAW)) {
            System.out.println("UH OH. Try AGain. No one won");
            gameController.getWinner(game);
        }
    }

}
