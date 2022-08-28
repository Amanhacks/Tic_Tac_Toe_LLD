package com.example.tictactoe.Module;

import com.example.tictactoe.WinningStrategy.WinningStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private int lastIndexPlayer=0;
    private Player winner;
    private int dimension;
    private GameStatus gameStatus;

    private Game(GameStatus gameStatus) {
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.players = new ArrayList<>();
        this.winningStrategies = new ArrayList<>();
        this.moves = new ArrayList<>();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    static class Builder {

        private List<Player> players;
        private int lastIndexPlayer=0;
        private int dimension;

        private List<WinningStrategy> winningStrategies;

        Builder() {
            players = new ArrayList<>();
            winningStrategies = new ArrayList<>();
        }

        public List<Player> getPlayers() {
            return players;

        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public int getLastIndexPlayer() {
            return lastIndexPlayer;
        }

        public Builder setLastIndexPlayer(int lastIndexPlayer) {
            this.lastIndexPlayer = lastIndexPlayer;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            winningStrategies.add(winningStrategy);
            return this;
        }

        public Game Built() {
            Game game = new Game(GameStatus.NOT_STARTED);
            game.lastIndexPlayer = this.lastIndexPlayer;
            game.board = new Board(this.dimension);
            game.dimension = dimension;
            game.players = this.players;
            game.winningStrategies = this.winningStrategies;
            return game;
        }

    }

    public void makeMove() {
        Move move = players.get(lastIndexPlayer).makeMove(board);
        if(move != null) {
            moves.add(move);
            this.board.updateMove(move);

            if (!checkIfWon()) {
                lastIndexPlayer = (lastIndexPlayer + 1) % players.size();
            }
        }
    }

    public Player getWinner() {
        return this.winner;
    }

    public boolean checkIfWon() {
        boolean inWon = false;
        for(WinningStrategy winningStrategy : winningStrategies ) {
            if(winningStrategy.checkIfWon(players.get(lastIndexPlayer),this.board, moves.get(moves.size()-1))) {
                System.out.println("Player : "+players.get(lastIndexPlayer).getName() + " won the game!!" );
                gameStatus = GameStatus.WIN;
                winner = players.get(lastIndexPlayer);
                return true;
            }
        }
        if (moves.size() == this.board.getDimension() * this.board.getDimension()) {
            gameStatus = GameStatus.DRAW;
        }
        return false;

    }

    public void showBoard() {
        for(int i=0;i<dimension;i++) {
            for(int j=0;j<dimension;j++) {
                if(board.getCells().get(i).get(j).getSymbol() != null) {
                    System.out.print("| "+board.getCells().get(i).get(j).getSymbol().getSymbolChar() + " |");

                }
                else {
                    System.out.print("|   |");
                }
            }
            System.out.println();
        }
    }
}
