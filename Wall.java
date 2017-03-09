package jrJava.tetris;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Wall {

	public static final int LEFT = 100;
	public static final int RIGHT = 500;
	public static final int TOP = 40;
	public static final int BOTTOM = 200;

	private static Color gridColor = Color.gray;
	private static Color wallColor = Color.black;

	public static void draw(DrawingBoard board) {

		Graphics2D canvas = board.getCanvas();

		canvas.setColor(gridColor);

		for (int x = LEFT; x <= RIGHT; x += Block.SIZE) {
			canvas.drawLine(x, TOP, x, BOTTOM);
		}

		for (int y = TOP; y <= BOTTOM; y += Block.SIZE) {
			canvas.drawLine(LEFT, y, RIGHT, y);
		}
		canvas.setColor(wallColor);
		canvas.drawRect(LEFT, TOP, RIGHT - LEFT, BOTTOM - TOP);

	}

	public static boolean isOutside(Block block) {

		if (block.getY() +block.SIZE>= BOTTOM) {
			return true;
		}
		else return false;
	}

	public int getLeft() {
		return LEFT;
	}

	public int getRight() {
		return RIGHT;
	}

	public int getTop() {
		return TOP;
	}

	public int getBotton() {
		return BOTTOM;
	}

}
