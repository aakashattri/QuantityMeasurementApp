package com.apps;

import org.junit.jupiter.api.*;

import com.apps.QuantityMeasurmentApp.Feet;

public class QuantityMeasurmentAppTest {
	@Test
	public void testEquality_SameValue() {
		Feet f1=new Feet(2.5);
		Feet f2=new Feet(2.5);
		if(f1.equals(f2)) {
			System.out.println("testEquality_SameValue: Pass");
		}else {
			System.out.println("testEquality_SameValue: FAIL");
		}
	}
	
	@Test
	public void TestEquality_DifferentValue() {
		Feet f1=new Feet(5.0);
		Feet f2=new Feet(7.0);
		if(!f1.equals(f2)) {
			System.out.println("TestEquality_DifferentValue : Pass");
		}else {
			System.out.println("TestEquality_DifferentValue: fail");
		}
	}
	@Test
	public void testEquality_NullComparison() {
		Feet f1=new Feet(5.2);
		String f2=null;
		if(!f1.equals(f2)){
			System.out.println("testEquality_NullComparison: Pasas");
			
		}else {
			System.out.println("testEquality_NullComparison : Fail");
		}
	}
	@Test
	public void testEquality_NonNumericInput() {
		Feet f1=new Feet(4.1);
		String other="Other String";
		
		if(!f1.equals(other)) {
			System.out.println("testEquality_NonNumericInput: Pass");
		}else {
			System.out.println("testEquality_NonNumericInput: Fail");
		}
	}
	@Test
	public void testEquality_SameReference() {
		Feet f1=new Feet(8.3);
		if(f1.equals(f1)) {
			System.out.println("testEquality_SameReference:Pass");
		}else {
			System.out.println("testEquality_SameReference: Fail");
		}
	}
	public static void main(String[] args) {
		QuantityMeasurmentAppTest test=new QuantityMeasurmentAppTest();
		test.testEquality_SameValue();
		test.TestEquality_DifferentValue();
		test.testEquality_NonNumericInput();
		test.testEquality_NullComparison();
		test.testEquality_SameReference();
	}
}
