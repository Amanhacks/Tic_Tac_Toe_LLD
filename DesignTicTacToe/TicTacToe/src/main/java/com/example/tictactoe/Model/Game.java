package com.example.tictactoe.Model;

import com.example.tictactoe.WinningStrategy.WinningStrategy;

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
    private GameStatus gameStatus = GameStatus.NOT_STARTED;

    private Game() {
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.players = new ArrayList<>();
        this.winningStrategies = new ArrayList<>();
        this.moves = new ArrayList<>();
    }

    public static Builder create() {

        return new Builder();
    }

    public static class Builder {

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
            this.players.addAll(players);
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

        public Builder setWinningStrategy(List<WinningStrategy> winningStrategies) {
            this.winningStrategies.addAll(winningStrategies);
            return this;
        }

        public Game Built() {

            Game game = null;
            try{
                game = new Game();
                game.board = new Board(dimension);
                game.dimension = dimension;
                game.players.addAll(this.players);
                game.winningStrategies.addAll(this.winningStrategies);
            }
            catch(Exception ex) {
                System.out.println("Not able to create game in builder class");
                System.out.println(ex.getStackTrace());
            }

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


        for(WinningStrategy winningStrategy : winningStrategies ) {
            if(winningStrategy.checkIfWon(players.get(lastIndexPlayer),this.board, moves.get(moves.size()-1))) {

                this.gameStatus = GameStatus.WIN;
                this.winner = players.get(lastIndexPlayer);
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

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
}
