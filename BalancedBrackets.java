package com.greatlearning.brackets;

import java.util.Stack;
import java.util.Scanner;

public class BalancedBrackets {
	
	public static boolean balancedBrackets(String s)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			
			if(c == '[' || c == '(' || c == '{')
			{
				stack.push(c);
			}else if(c == ']') {
				if(stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			}else if(c == ')') {
				if(stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}else if(c == '}') {
				if(stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
		
		//Driver Code
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("please enter the expression:");
			
			String s = sc.nextLine();
			
			boolean bracket  = balancedBrackets(s);
			if(bracket)
				System.out.println("Balanced Expression");
				else
					System.out.println("Not a Balanced Expression");
			
			sc.close();
		}
	}