package com.test.blockTree;

import java.util.ArrayList;
import java.util.List;

public class CBlock {
	private int id;//����id
	private String name;//��������
	private double[] position;//����λ��
	private double[] size;//���Ĵ�С
	
	private CBlock parent;//���ĸ�id
	private List<CBlock> child =new ArrayList<CBlock>();//��������
	public int getId() {
		return id;
	}
	public List<CBlock> getChild() {
		return child;
	}
	public void setChild(List<CBlock> child) {
		this.child = child;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[] getPosition() {
		return position;
	}
	public void setPosition(double[] position) {
		this.position = position;
	}
	public double[] getSize() {
		return size;
	}
	public void setSize(double[] size) {
		this.size = size;
	}
	public CBlock getParent() {
		return parent;
	}
	public void setParent(CBlock parent) {
		this.parent = parent;
	}
	//�����ӽڵ�
	public void add(CBlock block){
		child.add(block);
	}
	//ɾ���ӽڵ�
	public void remove(CBlock block){
		child.remove(block);
	}
	//��ȡ���еĸ��ڵ�
	public List<CBlock> getElds(){
		List<CBlock> eldsBlocks=new ArrayList<CBlock>();
		CBlock parentBlock=this.getParent();
		if(parentBlock==null){
			return eldsBlocks;
		}else{
			eldsBlocks.add(parentBlock);
			eldsBlocks.addAll(parentBlock.getElds());
			return eldsBlocks;
		}
	}
	//��ȡ���е��ӽڵ�
	public List<CBlock> getJuniros(){
		List<CBlock> junirodBlocks=new ArrayList<CBlock>();
		List<CBlock> junirodBlock=new ArrayList<CBlock>();
		if(junirodBlock.size()==0){
			return junirodBlocks;
		}else{
			for(CBlock ck:junirodBlock){
				junirodBlocks.add(ck);
				junirodBlocks.addAll(ck.getJuniros());
			}
			return junirodBlocks;
		}
	}
}
