package com.test.designPatterns.memento;


/**
 * 利用备忘录模式来模拟下棋 悔棋
 * @author zhuyumeng
 *
 */
public class TestMemento {
	private static int i=0;
	public static void main(String[] args){
		MementoCreater mc=new MementoCreater();
		ChessMan chess=new ChessMan("车",0,0);
		
		chess.setX(3);
		play(chess,mc);
		display(chess);
		chess.setY(3);
		play(chess,mc);
		display(chess);
		
		chess.setY(6);
		play(chess,mc);
		display(chess);
		
		chess.setX(7);
		play(chess,mc);
		display(chess);
		
		undo(chess,mc);
		display(chess);
		undo(chess,mc);
		display(chess);
		
		redo(chess,mc);
		display(chess);
		

	}
	//走棋
	public static void play(ChessMan ches,MementoCreater mc){
		MementoChess chese=ches.saveStore();
		mc.setMementoChess(chese);
		i++;
	}
	//悔棋
	public static void undo(ChessMan ches,MementoCreater mc){
		MementoChess chese=mc.getMementoChess(i-2);
		ches.resStore(chese);
		i--;
	}
	//撤销悔棋
	public static void redo(ChessMan ches,MementoCreater mc){
		MementoChess chese=mc.getMementoChess(i);
		ches.resStore(chese);
		i++;
	}
	
	public static void display(ChessMan ches){
		System.out.println(ches.getLabel()+"  X:"+ches.getX()+",Y: "+ches.getY());
	}
}
