package com.example.tictactoe.Module;

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
        Dimension = dimension;
    }

    Board(int Dimension) {
        this.Dimension = Dimension;

        for(int i=0;i<Dimension;i++) {
            cells.add(new ArrayList<>());
            for(int j=0;i<Dimension;j++) {
                cells.get(i).add(new Cell(i,j,null));
            }
        }


    }

    public void updateMove(Move move) {
        cells.get(move.getCell().getRow()).get(move.getCell().getCol()).setSymbol(move.getPlayer().getSymbol());
    }

}
