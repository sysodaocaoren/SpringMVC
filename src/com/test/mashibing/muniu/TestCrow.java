package com.test.mashibing.muniu;

import java.util.ArrayList;
import java.util.List;
/**
 * 农场有头小母牛，每年生头小母牛。母牛五岁生母牛，二十年后多少牛?
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
