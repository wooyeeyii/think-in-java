package com.chang.strategy;

public class AdvancedMemberStrategy implements MemberStrategy {

	@Override
	public double calPrice(double price) {
		return price*0.8;
	}

}
