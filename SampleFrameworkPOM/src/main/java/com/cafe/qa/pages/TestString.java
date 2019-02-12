package com.cafe.qa.pages;

public class TestString {

	

	public static void main(String[] args) {
		char[] helloArray = {'h','e','l','l','o','a','r','r','a','y','.'};
		String helloString = new String(helloArray);
		System.out.println(helloString);
		System.out.println("String length = "+helloString.length());
		String newString = helloString.concat("Added");
		System.out.println("String concatenation = "+newString);
		
		int a = 10; 
		float b = 20;
		String s = "Shruthi";
		
		System.out.printf("The interger value of a is %d, float value is %f and string value is %s",a,b,s);
		System.out.println();
		String fs = null; 
		fs = String.format("The interger value of a is %d, float value is %f and string value is %s",a,b,s);
		System.out.println(fs);
		
		String charAtTest = "FindTheIndex";
		String temp = "";
		for(int i=0; i<charAtTest.length();i++)
		{
			temp = temp+"\n"+charAtTest.charAt(i);
		}
		System.out.println(temp);
		
		//String compare To
		String str1 =new String( "Shruthi");
		String str2 = new String("Harsha");
		String str3 = new String("Shruthi");
		System.out.println(str1.compareTo(str2));
		System.out.println(str2.compareTo(str1));
		System.out.println(str1.compareTo(str3));
		
		//String contentEquals
		System.out.println(str1.contentEquals(str3));
		System.out.println(str1.contentEquals(str2));
		
		//CopyValueOf
		String str="";
		str=str.copyValueOf(helloArray);
		System.out.println(str);
		str = str.copyValueOf(helloArray,2, 5);
		System.out.println(str);
		
		
		//Ends With
		System.out.println(str3.endsWith("thi"));
		System.out.println(str3.endsWith("as"));
		
		//Equals 
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		
		//getChars
		String src = "Welcome to strings in Java";
		char ch[] = new char[7];
		src.getChars(2, 9, ch, 0);
		System.out.println(ch);
		
		//matches
		System.out.println(src.matches("(.*)strings(.*)"));
		
		
		
	}

}
