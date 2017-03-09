package jrJava.tetris;

import resources.DrawingBoard;

public class Graveyard {
	private static TombStack[] tombstacks;
	
	static{
		
		 tombstacks = new TombStack[(Wall.RIGHT-Wall.LEFT)/Block.SIZE];
		 for(int i=0;i<tombstacks.length;i++){
			 tombstacks[i] = new TombStack();
		 }
	}
	

	public static boolean isInside(Block block){
		 for(int i=0;i<tombstacks.length;i++){
			 if(tombstacks[i].isInside(block)){
				 return true;
			 }
		 }
		 return false;
	}
	
	public static void putToGrave(Block block){
		int target = (block.getX()-100)/Block.SIZE;
		tombstacks[target].add(block);
	}
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<tombstacks.length; i++){
			tombstacks[i].draw(board);
		}
	}
	

}
