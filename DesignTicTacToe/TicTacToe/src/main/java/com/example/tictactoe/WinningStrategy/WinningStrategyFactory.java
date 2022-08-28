package com.example.tictactoe.WinningStrategy;

import lombok.Builder;

public class WinningStrategyFactory {

    public WinningStrategy getWinningStrategy(WinningStrategyType winningStrategyType) {
        return switch (winningStrategyType) {
            case ROW ->  new RowWinningStrategy();

            case COLUMN -> new ColumnWinningStrategy();

            case DIGONAL -> new DigonalWinningStrategy();

        };
    }
}
