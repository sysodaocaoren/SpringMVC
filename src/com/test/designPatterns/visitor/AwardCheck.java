package com.test.designPatterns.visitor;

/**
 * ��ѡ�����ýӿ���
 * @author zhuyumeng
 *
 */
public interface AwardCheck {
	public void check(TeacherCheck tk);
	public void check(StudentCheck tk);
}
