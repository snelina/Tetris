package jrJava.tetris;

public class TetrisObject3 extends TetrisObject{
	public TetrisObject3(){
		color = color.cyan;
		start();
	}
	
	public void create(){
		blocks = new Block[4];
		blocks[0] = new Block(0,1,color);
		blocks[1]= new Block(0,0,color);
		blocks[2] = new Block(-1,0,color);
		blocks[3] = new Block(-2,0,color);

	}
	
	public void wallAvoid(){
		if(xCenter<wall.getLeft()+Block.SIZE){
			xCenter = wall.getLeft()+Block.SIZE;
		}
		else if(xCenter>wall.getRight()-3*Block.SIZE){
			xCenter = wall.getRight()-3*Block.SIZE;
		}
	}
	
	int[][][] turns = { 
			{/*Block 0*/ {1,0}, {0,-1}, {-1,0}, {0,1} },
			{/*Block 1*/ {0,0}, {0,0}, {0,0}, {0,0} },
			{/*Block 3*/ {0,1}, {1,0}, {0,-1}, {-1,0} },
			{/*Block 4*/ {0,2}, {2,0}, {0,-2}, {-2,0} }
	};
	
	int tn = 0;
	
	public void rotate() {
		if(tn>3){tn = 0;}
		
		for(int i = 0; i<blocks.length; i++){
			blocks[i].relX = turns[i][tn][0];
			blocks[i].relY = turns[i][tn][1];
		}
		tn++;
	}

}
