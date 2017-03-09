package jrJava.tetris;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Block {
	public static final int SIZE = 20;

	private int x, y;
	protected int relX, relY;
	private Color color;
	private boolean isBuried;
	private boolean markedAsFullRowBlock;
	
	
	public Block(int _relX, int _relY, Color _color){
		relX = _relX;
		relY = _relY;
		color = _color;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	
	
	public void markAsFullRowBlock(){
		markedAsFullRowBlock = true;
	}
	
	
	public void markAsBuried(){
		isBuried = true;
	}
	
	
	public void findAbsoluteXY(int xCenter, int yCenter){
		x = xCenter + relX*SIZE;
		y = yCenter + relY*SIZE;
	}
	
	
	public void mirror(){
		relX = -relX;
	}
	
	
	public void rotateClockwise(){
		int temp = relY;
		relY = relX;
		relX = -temp;
	}
	
	
	public void rotateCounterClockwise(){
		int temp = relY;
		relY = -relX;
		relX = temp;
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, SIZE, SIZE);
		canvas.setColor(Color.black);
		canvas.drawRect(x, y, SIZE, SIZE);
		
//		canvas.setColor(Color.RED);
//		canvas.drawRect(x,y,1,1);
		
		if(markedAsFullRowBlock){
			canvas.drawLine(x, y, x+SIZE, y+SIZE); 
		}
		else if(!isBuried && relX==0 && relY==0){
			canvas.drawOval(x+SIZE/4, y+SIZE/4, SIZE/2, SIZE/2);
		}
	}
	
}