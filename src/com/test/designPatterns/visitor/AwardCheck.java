package com.test.designPatterns.visitor;

/**
 * 评选方法得接口类
 * @author zhuyumeng
 *
 */
public interface AwardCheck {
	public void check(TeacherCheck tk);
	public void check(StudentCheck tk);
}
