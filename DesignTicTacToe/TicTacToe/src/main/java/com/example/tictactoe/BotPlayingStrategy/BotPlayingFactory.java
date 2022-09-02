package com.example.tictactoe.BotPlayingStrategy;

import com.example.tictactoe.Model.BotPlayingDifficulty;

public class BotPlayingFactory {
    public BotPlayingStrategy getBotPlayingStrategy(BotPlayingDifficulty botPlayingDifficulty) {
        return switch (botPlayingDifficulty) {
            case EASY -> new EasyBotPlayingStrategy();

            case MEDIUM -> new MediumBotPlayingStrategy();
        };
    }
}
