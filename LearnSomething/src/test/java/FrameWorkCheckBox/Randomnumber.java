package FrameWorkCheckBox;

import java.util.Random;

import org.testng.annotations.Test;

import ObjectRepository.JavaUtility;

public class Randomnumber {
@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Random r=new Random();
//		for(; ;) {
//			System.out.println(r.nextInt(1000));
//			
//		}
		JavaUtility j =new  JavaUtility() ;
		System.out.println(j.generateRandomNumber(200));
	
}
}
