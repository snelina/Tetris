package jrJava.tetris;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import resources.DrawingBoard;

public abstract class TetrisObject implements KeyListener{

	static final int maxBlocksPerObj = 5;
	
	protected boolean isBuried;
	protected boolean isOutsideB;


	protected Wall wall = new Wall();
	protected Block[] blocks;
	protected Color color;

	protected int xCenter, yCenter;

	public TetrisObject(){
		/*double q = Math.random();
		int w = (int) ( ((Wall.RIGHT-Wall.LEFT)/Block.SIZE)*q );
		xCenter =  Wall.LEFT + w*Block.SIZE;//(Wall.LEFT + Wall.RIGHT)/2;
		yCenter = Wall.TOP;//+3*Block.SIZE;
		*/
		/*
		int maximum = (Wall.RIGHT-Wall.LEFT) / Block.SIZE; 
		int e = (int)(Math.random() * maximum); 
		xCenter = Wall.LEFT + e*Block.SIZE;
		yCenter = Wall.TOP;
		
		*/
//		color = _color;
		start();
		create();
		/*xCenter = (Wall.LEFT + Wall.RIGHT)/2;
		yCenter = Wall.TOP+3*Block.SIZE;
		color = Color.red;
		
		blocks = new Block[4];

		blocks[0] = new Block(-1,0,color);
		blocks[1]= new Block(0,0,color);
		blocks[2] = new Block(1,0,color);
		blocks[3] = new Block(0,1,color);
		
		updateBlocks();*/
	}
	
	public boolean isBuried(){return isBuried;}
	
	protected boolean notInside(){
		for(int i=0; i<blocks.length; i++){
			if(Graveyard.isInside(blocks[i])||Wall.isOutside(blocks[i])){ 
				return false;
			}
		}
		return true;
	}

	
	public void start(){
		
		int maximum = (Wall.RIGHT-Wall.LEFT) / Block.SIZE; 
		int e = 5;//(int)(Math.random() * maximum); 
		xCenter = Wall.LEFT + e*Block.SIZE;
		yCenter = Wall.TOP;
			
		create();
	}
	

	
	
	protected void buryToGraveyard(){
		for(int i = blocks.length-1; i>=0;i--){
			blocks[i].markAsBuried();
			Graveyard.putToGrave(blocks[i]);
		}
		isBuried = true;
	}
		
	public void moveDown(){
		if(notInside()){
			/*for(int i=0; i>blocks.length; i++){
				if(wall.isOutside(blocks[i])){
					isOutsideB= true;
					break;
				}
			}

			if(!isOutsideB){*/
				yCenter += Block.SIZE;
				updateBlocks();
			/*} else{
				buryToGraveyard();
			}*/
		}
		else{
			buryToGraveyard();
		}
	}
	
	public void updateBlocks(){
		
		for(int i = 0; i<blocks.length; i++){
			blocks[i].findAbsoluteXY(xCenter, yCenter);
		}
	}
	
	public void draw(DrawingBoard board){
		for(int i = 0; i<blocks.length; i++){
			blocks[i].draw(board);
		}
	}
	
/*	public void bury(){
		for(int i = blocks.length-1; i>=0;i--){
		Graveyard.putToGrave(blocks[i]);
		}
	}   */
	
	public void keyReleased(KeyEvent e){
		if(isBuried){
			return;
		}
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_LEFT){
		    xCenter -= Block.SIZE;
		}if(keyCode == KeyEvent.VK_RIGHT){
			xCenter += Block.SIZE;
		}	
		if(keyCode==KeyEvent.VK_SPACE){
			mirror();
		}if(keyCode == KeyEvent.VK_SHIFT){
//			System.out.println("hi, this is shift");
			rotate();
		}

		if(!notInside()){ 
			buryToGraveyard();
//			isBuried=true;
		}
		wallAvoid();
		updateBlocks();
	}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){}

	
	public abstract void create();
	
	public abstract void wallAvoid();
	
	public void mirror(){
		for(int i = 0; i<blocks.length; i++){
//			blocks[i].relX = -blocks[i].relX;
			blocks[i].mirror();
		}
	}
	
	public abstract void rotate();
	
}
