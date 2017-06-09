package com.test.designPatterns.strategy;

public class AirPlane implements PlaneTypeInf{

	public void getPlanType() {
		System.out.println("LongDistanceTakeOff + SubSonicFly");
	}

}
