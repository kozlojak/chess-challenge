package com.jakub.kozlowski.chessChallenge.domain;

import com.jakub.kozlowski.chessChallenge.model.Piece;
import com.jakub.kozlowski.chessChallenge.shared.FieldType;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.jakub.kozlowski.chessChallenge.shared.FieldType.FREE;

public class ChessSolver {
    List<Piece> pieces;
    Integer totalLength;
    Integer totalWidth;
    Integer totalFieldNumber;
    Integer result=0;
    Integer pieceNumber=0;
    Integer numberOfQueens;
    Integer numberOfRooks;
    Integer numberOfBishops;
    Integer numberOfKings;
    Integer numberOfKnights;
    List<Integer> piecesBorder;
    FieldType[] board;
    List<FieldType[]>configurations;

    public ChessSolver(List<Piece> pieces, Integer length, Integer width, Integer numberOfQueens, Integer numberOfRooks,
                       Integer numberOfBishops,Integer numberOfKings, Integer numberOfKnights) {
        this.pieces = pieces;
        this.totalLength = length;
        this.totalWidth = width;
        this.totalFieldNumber=length*width;
        this.numberOfQueens=numberOfQueens;
        this.numberOfRooks=numberOfRooks;
        this.numberOfBishops=numberOfBishops;
        this.numberOfKings=numberOfKings;
        this.numberOfKnights=numberOfKnights;
        this.piecesBorder=new ArrayList<>();
        this.piecesBorder.add(numberOfQueens+numberOfRooks);
        this.piecesBorder.add(piecesBorder.get(0)+numberOfBishops);
        this.piecesBorder.add(piecesBorder.get(1)+numberOfKings);
        board= Collections.nCopies(totalFieldNumber, FREE).toArray(new FieldType[totalFieldNumber]);
        configurations=new LinkedList<>();
    }

    public void solve(){
            for (int length = 0; length < totalWidth; length++) {
                for (int width = 0; width< totalLength; width++) {

                    pieces.get(pieceNumber).setLength(length);
                    pieces.get(pieceNumber).setWidth(width);

                    if(!findCollision(length, width, pieceNumber)){
                        pieces.get(pieceNumber).setLength(length);
                        pieces.get(pieceNumber).setWidth(width);
                        pieceNumber++;
                        if(pieceNumber<pieces.size()&&pieces.get(pieceNumber).getType()!=pieces.get(pieceNumber-1).getType()){
                            length=0;
                            width=-1;
                        }
                    }

                    if(pieceNumber==pieces.size()){
                        result++;
                        FieldType[] newBoard = board.clone();
                        for(int i=0; i<pieces.size();i++){
                            newBoard[pieces.get(i).getWidth()*totalLength+pieces.get(i).getLength()]=pieces.get(i).getType();
                        }
                        configurations.add(newBoard);
                        pieceNumber--;
                    }

                    if(length==totalLength-1 && width==totalWidth-1){
                            if(pieceNumber>0&&length==pieces.get(pieceNumber-1).getLength() && width==pieces.get(pieceNumber-1).getWidth()){
                            pieceNumber--;
                            }
                        if(pieceNumber>0) {
                            length = pieces.get(pieceNumber - 1).getLength();
                            width = pieces.get(pieceNumber - 1).getWidth();

                            pieceNumber--;
                        }
                    }

                }
            }
    }
    public void showResults(){
        ResultSaver.printResults(configurations, totalLength);
    }

    public void showResultNumber(){
        System.out.println(result);
        result=0;
    }

    boolean findCollision(int length, int width, int pieceNumber){

        for(int j=0; j<pieceNumber; j++){
            if(pieces.get(j).pieceEquation(length, width)){
                return true;
            }
        }

        switch (pieces.get(pieceNumber).getType()){
            case KNIGHT:
                for(int j=0; j<(piecesBorder.get(2)); j++){
                    if(pieces.get(pieceNumber).pieceEquation(pieces.get(j).getLength(), pieces.get(j).getWidth())){
                        return true;
                    }
                }
                break;
            case KING:
                for(int j=numberOfQueens; j<(piecesBorder.get(1)); j++){
                    if(pieces.get(pieceNumber).pieceEquation(pieces.get(j).getLength(), pieces.get(j).getWidth())){
                        return true;
                    }
                }
                break;
            case BISHOP:
                for(int j=numberOfQueens; j<(piecesBorder.get(0)); j++){
                    if(pieces.get(pieceNumber).pieceEquation(pieces.get(j).getLength(), pieces.get(j).getWidth())){
                        return true;
                    }
                }
                break;
        }
        return false;
    }



}

