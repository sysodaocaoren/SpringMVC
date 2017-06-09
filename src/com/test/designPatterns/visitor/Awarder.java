package com.test.designPatterns.visitor;

/**
 * 获奖评定人的接口类，都可以接受评选
 * @author zhuyumeng
 *
 */
public interface Awarder {
	public void accpetCheck(AwardCheck ack);
}
