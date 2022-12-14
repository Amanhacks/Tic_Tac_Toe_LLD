package com.example.tictactoe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int Dimension;
    private List<List<Cell>> cells;

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public int getDimension() {
        return Dimension;
    }

    public void setDimension(int dimension) {
        this.Dimension = dimension;
    }

    public Board(int Dimension) {
        this.Dimension = Dimension;
        this.cells = new ArrayList<>();
        for(int i=0;i<Dimension;i++) {
            cells.add(new ArrayList<Cell>());
        }
        for(int i=0;i<Dimension;i++) {
            for(int j=0;j<Dimension;j++) {
                cells.get(i).add(new Cell());
            }
        }


    }

    public void updateMove(Move move) {
        cells.get(move.getCell().getRow()).get(move.getCell().getCol()).setSymbol(move.getPlayer().getSymbol());
    }

}
