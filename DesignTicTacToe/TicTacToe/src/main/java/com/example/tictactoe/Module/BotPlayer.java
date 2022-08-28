package com.example.tictactoe.Module;

import com.example.tictactoe.BotPlayingStrategy.BotPlayingFactory;
import com.example.tictactoe.BotPlayingStrategy.BotPlayingStrategy;

public class BotPlayer extends Player{
    private Symbol symbol;

    private BotPlayingDifficulty botPlayingDifficulty;
    private BotPlayingStrategy botPlayingStrategy;



    BotPlayer(Symbol symbol) {
        super(PlayerType.BOT,symbol);
        this.symbol = symbol;
        botPlayingStrategy = new BotPlayingFactory().getBotPlayingStrategy(botPlayingDifficulty);
    }


    @Override
    public Move makeMove(Board board) {
        return this.botPlayingStrategy.makeMove(board,this);
    }
}
