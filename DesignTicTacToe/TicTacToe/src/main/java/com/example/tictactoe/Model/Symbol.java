package com.example.tictactoe.Model;

public class Symbol {
    public char getSymbolChar() {
        return symbolChar;
    }

    public void setSymbolChar(char symbolChar) {
        this.symbolChar = symbolChar;
    }

    private char symbolChar;
    public Symbol(char symbolChar) {
        this.symbolChar = symbolChar;
    }
}
