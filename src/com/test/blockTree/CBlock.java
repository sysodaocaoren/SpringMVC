package com.test.blockTree;

import java.util.ArrayList;
import java.util.List;

public class CBlock {
	private int id;//树的id
	private String name;//树的名字
	private double[] position;//树的位置
	private double[] size;//树的大小
	
	private CBlock parent;//树的父id
	private List<CBlock> child =new ArrayList<CBlock>();//树的子类
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
	//增加子节点
	public void add(CBlock block){
		child.add(block);
	}
	//删除子节点
	public void remove(CBlock block){
		child.remove(block);
	}
	//获取所有的父节点
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
	//获取所有的子节点
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
