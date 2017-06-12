package com.test.designPatterns.briage;

public abstract class DataSource {
	
	protected Patten pattem;

	public Patten getPattem() {
		return pattem;
	}

	public void setPattem(Patten pattem) {
		this.pattem = pattem;
	}
	
	public abstract void changeData(String name);
	
}
