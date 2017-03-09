package jrJava.tetris;

import java.util.ArrayList;

import resources.DrawingBoard;

public class TombStack {
	private ArrayList<Block> deadBlocks;
	
	public TombStack(){
		deadBlocks = new ArrayList<Block>();
	}
	
	/*public boolean isInside(Block b){
			for(int i=0;i<blocks.size();i++){
				
				if(b.getY() == blocks.get(i).getY()+b.SIZE && b.getX() ==blocks.get(i).getX()+b.SIZE)
					return true;
				else ;
			}
			return false;
	}*/
	public boolean isInside(Block block){
		int x = block.getX();
		int y = block.getY();
		for(int i=0; i<deadBlocks.size(); i++){
			if((deadBlocks.get(i).getX() + Block.SIZE==x /*|| deadBlocks.get(i).getX() - Block.SIZE==x*/) || 
					deadBlocks.get(i).getY()+Block.SIZE==y){
			}
			if( deadBlocks.get(i).getY()+Block.SIZE==y) return true;
		}
		return false;
		
	}
	
	public void add(Block block){
		deadBlocks.add(block);
	}

	public void draw(DrawingBoard board){
		for(int i=0; i<deadBlocks.size(); i++){
			deadBlocks.get(i).draw(board);
		}
	}
	
	
	

}
