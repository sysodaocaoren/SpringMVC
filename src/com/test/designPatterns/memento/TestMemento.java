package com.test.designPatterns.memento;


/**
 * ���ñ���¼ģʽ��ģ������ ����
 * @author zhuyumeng
 *
 */
public class TestMemento {
	private static int i=0;
	public static void main(String[] args){
		MementoCreater mc=new MementoCreater();
		ChessMan chess=new ChessMan("��",0,0);
		
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
	//����
	public static void play(ChessMan ches,MementoCreater mc){
		MementoChess chese=ches.saveStore();
		mc.setMementoChess(chese);
		i++;
	}
	//����
	public static void undo(ChessMan ches,MementoCreater mc){
		MementoChess chese=mc.getMementoChess(i-2);
		ches.resStore(chese);
		i--;
	}
	//��������
	public static void redo(ChessMan ches,MementoCreater mc){
		MementoChess chese=mc.getMementoChess(i);
		ches.resStore(chese);
		i++;
	}
	
	public static void display(ChessMan ches){
		System.out.println(ches.getLabel()+"  X:"+ches.getX()+",Y: "+ches.getY());
	}
}
