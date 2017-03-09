package jrJava.tetris;

import java.awt.Color;

import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DrawingBoard board = new DrawingBoard(600, 800);
		Timer timer = new Timer();

		while (true) {
			TetrisObject t = tetrisObject();
			board.getJFrame().addKeyListener(t);
			int count = 0;
			
			while (true) {
				count++;
				
				if(count==14){
					t.moveDown();
					count = 0;
				}
				
				board.clear();
				Wall.draw(board);
				t.draw(board);
				Graveyard.draw(board);
				board.repaint();
				
				if(t.isBuried()) break;

				timer.pause(30);
			}
		}

	}

	public static TetrisObject tetrisObject() {
		int random5 = (int) (Math.random() * 3);
		if (random5 == 1) {
			TetrisObject t = new TetrisObject1();
			return t;
		} else if (random5 == 2) {
			TetrisObject t = new TetrisObject2();
			return t;
		} else {
			TetrisObject t = new TetrisObject3();
			return t;
		}
	}
}
