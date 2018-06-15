package com.jakub.kozlowski.chessChallenge.model;

import com.jakub.kozlowski.chessChallenge.shared.FieldType;

public class Queen implements Piece {

    private Integer lengthPosition;
    private Integer widthPosition;

    public Queen() {
        this.lengthPosition = 0;
        this.widthPosition = 0;
    }

    @Override
    public FieldType getType() {
        return FieldType.QUEEN;
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
        return lengthPosition == this.lengthPosition || widthPosition == this.widthPosition
                || lengthPosition + widthPosition == this.lengthPosition + this.widthPosition
                || lengthPosition - widthPosition == this.lengthPosition - this.widthPosition;
    }
}
