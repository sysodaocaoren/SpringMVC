package com.test.blockTree;

import java.util.ArrayList;
import java.util.List;

public class CblockTree {
	
	private CBlock root=null;
	
	public CblockTree(CBlock cblock){
		root= cblock;
	}

	public CBlock getRoot() {
		return root;
	}

	public void setRoot(CBlock root) {
		this.root = root;
	}
	
	public List<CBlock> getBlocksByName(String name){
		List<CBlock> resultBlocks=new ArrayList<CBlock>();
		CBlock block=this.getRoot();
		if(block==null){
			return resultBlocks;
		}else{
			if(name.equals(block.getName())){
				resultBlocks.add(block);
			}
			List<CBlock> allBlock=root.getJuniros();
			for(CBlock block1:allBlock){
				if(name.equals(block1.getName())){
					resultBlocks.add(block1);
				}
			}
			return resultBlocks;
		}
	}
	
	public void addBlockByParent(CBlock block,CBlock parentBlock){
		block.setParent(parentBlock);
		parentBlock.getChild().add(block);
	}
}
