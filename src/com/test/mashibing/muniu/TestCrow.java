package com.test.mashibing.muniu;

import java.util.ArrayList;
import java.util.List;
/**
 * ũ����ͷСĸţ��ÿ����ͷСĸţ��ĸţ������ĸţ����ʮ������ţ?
 * @author zhuyumeng
 *
 */
public class TestCrow {

	public static void main(String[] args) {
		Crow crow=new Crow(5,5);
		List<Crow> crows=new ArrayList<Crow>();
		crows.add(crow);
		Pasture pasture=new Pasture(crows);
		pasture.developYear(20);
	}

}
