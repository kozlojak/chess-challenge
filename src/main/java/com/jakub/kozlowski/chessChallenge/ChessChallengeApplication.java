package com.jakub.kozlowski.chessChallenge;


import com.jakub.kozlowski.chessChallenge.domain.ChessSolver;
import com.jakub.kozlowski.chessChallenge.model.*;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class ChessChallengeApplication {

	private static final String MS = "ms";
	private static final Scanner scanner = new Scanner(System.in);


	public static void main(String[] args){


		Instant start, stop;

		println("Set the input parameters:");

		int length = readParameter("Length");
		int width = readParameter("Width");
		int numberOfKings = readParameter("Number of kings");
		int numberOfQueens = readParameter("Number of queens");
		int numberOfRooks = readParameter("Number of rooks");
		int numberOfBishops = readParameter("Number of bishops");
		int numberOfKnights = readParameter("Number of knights");

		List<Piece>pieces= Stream.of(
				IntStream.range(0,numberOfQueens).mapToObj(i->new Queen()).collect(toCollection(ArrayList::new)),
				IntStream.range(0,numberOfRooks).mapToObj(i->new Rook()).collect(toCollection(ArrayList::new)),
				IntStream.range(0,numberOfBishops).mapToObj(i->new Bishop()).collect(toCollection(ArrayList::new)),
				IntStream.range(0,numberOfKings).mapToObj(i->new King()).collect(toCollection(ArrayList::new)),
				IntStream.range(0,numberOfKnights).mapToObj(i->new Knight()).collect(toCollection(ArrayList::new))
		).flatMap(Collection::stream).collect(toCollection(ArrayList::new));

		warmup();
		for(int i=0; i<5; i++) {
			ChessSolver chessSolver = new ChessSolver(pieces, length, width, numberOfQueens,
					numberOfRooks, numberOfBishops, numberOfKings, numberOfKnights);
			println("===================START==========================");

			start=Instant.now();
			chessSolver.solve();
			stop=Instant.now();

			chessSolver.showResultNumber();
			System.out.println(Duration.between(start,stop).toMillis()+MS);

			if(i==4){
				int resultDisplay = readParameter("Do you want to display reults? (if yes- click 1)");
				if(resultDisplay==1) chessSolver.showResults();
			}
		}
	}

	private static int readParameter(String parameterName) {
		System.out.print(parameterName + ": ");
		return scanner.nextInt();
	}

	private static void println(Object object) {
		System.out.println(object);
	}

	private static void warmup(){
		println("================WARMUP START=======================");
		for (int i = 0; i < 20; i++) {
			List<Piece> pieces = Arrays.asList(new Rook(), new King(), new Queen(), new Bishop(), new Knight());
			ChessSolver chessSolver = new ChessSolver(pieces, 5, 5, 1, 1, 1, 1, 1);
			chessSolver.solve();
		}
		println("================WARMUP STOP========================");
	}
}
