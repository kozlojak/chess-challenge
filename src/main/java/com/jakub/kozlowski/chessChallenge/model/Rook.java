package com.jakub.kozlowski.chessChallenge.model;

import com.jakub.kozlowski.chessChallenge.shared.FieldType;

public class Rook implements Piece {

    private Integer lengthPosition;
    private Integer widthPosition;

    public Rook() {
        this.lengthPosition = 0;
        this.widthPosition = 0;
    }

    @Override
    public FieldType getType() {
        return FieldType.ROOK;
    }

    @Override
    public Integer getLength() {
        return lengthPosition;
    }

    @Override
    public Integer getWidth(){
        return widthPosition;
    }

    @Override
    public void setLength(Integer length) {
        this.lengthPosition=length;
    }

    @Override
    public void setWidth(Integer width) {
        this.widthPosition=width;
    }

    @Override
    public boolean pieceEquation(Integer lengthPosition, Integer widthPosition) {
        return lengthPosition.equals(this.lengthPosition) || widthPosition.equals(this.widthPosition);
    }
}
