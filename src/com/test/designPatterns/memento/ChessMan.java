package com.test.designPatterns.memento;

public class ChessMan {
	private String label;
	private int x;
	private int y;
	
	public ChessMan(String label,int x,int y){
		this.label=label;
		this.x=x;
		this.y=y;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//±£´æ²½Öè
	public MementoChess saveStore(){
		return new MementoChess(this.label,this.x,this.y);
	}
	
	//»Ø¹ö
	public void resStore(MementoChess mss){
		this.label=mss.getLabel();
		this.x=mss.getX();
		this.y=mss.getY();
	}
	
}
