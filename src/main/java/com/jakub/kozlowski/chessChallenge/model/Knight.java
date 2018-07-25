package com.jakub.kozlowski.chessChallenge.model;

import com.jakub.kozlowski.chessChallenge.shared.FieldType;

public class Knight implements Piece {

    private Integer lengthPosition;
    private Integer widthPosition;

    public Knight() {
        this.lengthPosition = 0;
        this.widthPosition = 0;
    }

    @Override
    public FieldType getType() {
        return FieldType.KNIGHT;
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
        return Math.abs(lengthPosition - this.lengthPosition) == 1 && Math.abs(widthPosition - this.widthPosition) == 2
                || (Math.abs(lengthPosition - this.lengthPosition) == 2 && Math.abs(widthPosition - this.widthPosition) == 1);
    }
}
