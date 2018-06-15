package com.jakub.kozlowski.chessChallenge.model;

import com.jakub.kozlowski.chessChallenge.shared.FieldType;

public interface Piece {
    FieldType getType();
    Integer getLength();
    Integer getWidth();
    void setLength(Integer length);
    void setWidth(Integer width);
    boolean pieceEquation(Integer length, Integer width);
}
