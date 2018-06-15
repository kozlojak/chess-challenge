package com.jakub.kozlowski.chessChallenge.shared;


public enum FieldType {
    QUEEN(0),
    ROOK(1),
    BISHOP(2),
    KING(3),
    KNIGHT(4),
    FREE(5);

    FieldType(int value){
        this.value=value;
    }

    public final int value;
}

