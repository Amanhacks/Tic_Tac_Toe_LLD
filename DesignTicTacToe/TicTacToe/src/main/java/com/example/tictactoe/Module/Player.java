package com.example.tictactoe.Module;

public abstract class Player {
    private String Name;
    private Symbol symbol;
    private PlayerType playerType;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    Player(PlayerType playerType, Symbol symbol) {
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board);


}
