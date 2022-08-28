package com.example.tictactoe.Module;

public class Symbol {
    public char getSymbolChar() {
        return symbolChar;
    }

    public void setSymbolChar(char symbolChar) {
        this.symbolChar = symbolChar;
    }

    private char symbolChar;
    Symbol(char symbolChar) {
        this.symbolChar = symbolChar;
    }
}
