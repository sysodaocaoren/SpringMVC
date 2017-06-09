package com.test.designPatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class MementoCreater {
	public List<MementoChess> mementoChesss=new ArrayList<MementoChess> ();
	
	public MementoChess getMementoChess(int i){
		return this.mementoChesss.get(i);
	}
	
	public void setMementoChess(MementoChess mes){
		this.mementoChesss.add(mes);
	}
}
