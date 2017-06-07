package com.test.designPatterns.observer;

public interface Observer {
	public String getName();
	public void setName(String name);
	public void notices();
	public void shareChange(ShareControllerCenter sc);
}
