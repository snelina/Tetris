package jrJava.tetris;

import java.awt.Color;
import java.awt.event.KeyEvent;

import resources.DrawingBoard;

public class TetrisObject1 extends TetrisObject{

	public TetrisObject1(){
		color = Color.red;
		start();
	}
	
	public void create(){
		
		blocks = new Block[4];

		blocks[0] = new Block(-1,0,color);
		blocks[1]= new Block(0,0,color);
		blocks[2] = new Block(1,0,color);
		blocks[3] = new Block(0,1,color);
		
		updateBlocks();
	}
		
	public void wallAvoid(){
		if(xCenter<wall.getLeft()+Block.SIZE){
			xCenter = wall.getLeft()+Block.SIZE;
		}
		else if(xCenter>wall.getRight()-2*Block.SIZE){
			xCenter = wall.getRight()-2*Block.SIZE;
		}
	}
	
/*	protected int[][][] turns = { 
//			{/*Block 0*/ //{0,-1},{1,0}, {0,1},{-1,0} },
//			{/*Block 1*/ {0,0}, {0,0}, {0,0}, {0,0} },
//			{/*Block 2*/ {0,1}, {-1,0}, {0,-1}, {1,0} },
//			{/*Block 3*/ {-1,0}, {0,-1}, {1,0}, {0,1} }
//	};
	
	private int tn = 0;
	
//	int rotateNumber = 0;
	
	public void rotate(){
		/*if (rotateNumber == 0){
			for(int i = 0; i<blocks.length; i++){
				blocks[i].relX = 
				blocks[i].relY = 
			}
		}
		*/
		for(int i=0; i<blocks.length; i++){
				blocks[i].rotateClockwise();
			}
			updateBlocks();
		/*if(tn>3){tn = 0;}
		
		for(int i = 0; i<blocks.length; i++){
			blocks[i].relX = turns[i][tn][0];
			blocks[i].relY = turns[i][tn][1];
		}
		tn++;
		*/
	}
	
}

