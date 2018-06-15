package com.jakub.kozlowski.chessChallenge.domain;

import com.jakub.kozlowski.chessChallenge.shared.FieldType;

import java.util.Collection;
import java.util.stream.IntStream;

public class ResultSaver {
    public static void printResults(Collection<FieldType[]> configurations, Integer totalLength){
        configurations.forEach(configuration->printResults(configuration, totalLength));
    }

    public static void printResults(FieldType[] configuration, Integer totalLength){
        IntStream.range(0, configuration.length).forEach(i -> {
            if (i % totalLength == 0) {
                System.out.println("");
            }
            char sign = getChar(configuration[i]);
            System.out.print(sign);
        });
        System.out.println("");
        System.out.flush();
    }

    private static char getChar(FieldType fieldType) {
        switch (fieldType) {
            case FREE:
                return '\u0000';
            case KING:
                return 'K';
            case ROOK:
                return 'R';
            case QUEEN:
                return 'Q';
            case BISHOP:
                return 'B';
            case KNIGHT:
                return 'H';
            default:
                return '*';

        }
    }
}
