package Parser;

import java.util.Stack;

public class SimpleParser {
	
	public static void main(String[] args) {
		String expr = "( 5 + 6 * ( 6 / 5 ) )";
		String expr2 = "(5+6)*(5+6)";
		
		//float f = new SimpleParser().calculate(expr);
		
		String str = new SimpleParser().parse2(expr2);
		System.out.println(">>"+str);
	}

	public SimpleParser() {
		// TODO Auto-generated constructor stub
	}
	
	
	private float calculate2(float one, float two, String op) {
		switch(op) {
		case "+": return one+two;
		case "-": return one-two;
		case "*": return one*two;
		case "/": return two/one;
		default: return 0;
		}
			
	}
	
	private String parse2(String expr) {
		Stack<String> numberStack = new Stack<>();
		Stack<String> symbolStack = new Stack<>();
		String token="";
		for(char c : expr.toCharArray()) {
			System.out.println(c);
			//System.out.println(numberStack);
			//System.out.println(symbolStack);
			switch(c) {
				case '(':{
					if(token.length()>0)
					numberStack.push(token);
					System.out.println(numberStack);
					token="";
					numberStack.push("(");
					continue;
				}
				case ('+'): {
					if(token.length()>0)
					numberStack.push(token);
					System.out.println(numberStack);
					token="";
					symbolStack.add("+");
					continue;
				}
				case ('-'): {
					if(token.length()>0)
					numberStack.push(token);
					System.out.println(numberStack);
					token="";
					symbolStack.add("-");
					continue;
				}
				case ('*'): {
					if(token.length()>0)
					numberStack.push(token);
					System.out.println(numberStack);
					token="";
					symbolStack.add("*");
					continue;
				}
				case ('/'): {
					if(token.length()>0)
					numberStack.push(token);
					System.out.println(numberStack);
					token="";
					symbolStack.add("/");
					continue;
				}
				case (' '): {
					if(token.length()>0)
					numberStack.push(token);
					System.out.println(numberStack);
					token="";
					continue;
				}
				case (')'): {
					if(token.length()>0)
					numberStack.push(token);
					System.out.println(numberStack);
					while(true) {
						//get two nums form numstack
						String strnum1 = numberStack.pop();
						float num1 = Float.parseFloat(strnum1);

						String strnum2 = numberStack.pop();
						if(strnum2.equals("(") || strnum2==null) {
							numberStack.push(strnum1);
							System.out.println(numberStack);
							break;
						}
						float num2 = Float.parseFloat(strnum2);
						
						String symbol = symbolStack.pop();
						
						String result = calculate2(num1, num2, symbol)+"";
						
						System.out.println("oo"+result);
						
						numberStack.push(result);
						System.out.println(numberStack);
					}
					continue;
				}
				default: {
					token += c;
					continue;
				}
			}
			
		}
		
		//iteration finished now evaluate the stacks
		evaluatestack(numberStack, symbolStack);
		return numberStack.pop();
	}
	
	
	private void evaluatestack(Stack<String> numberStack, Stack<String> symbolStack) {
			System.out.println(numberStack);
			System.out.println(symbolStack);
		while(true) {
			//get two nums form numstack
			String strnum1 = numberStack.pop();
			float num1 = Float.parseFloat(strnum1);

			if(numberStack.isEmpty()) {
				numberStack.push(strnum1);
				break;
			}
			String strnum2 = numberStack.pop();
			if(strnum2.equals("(")) {
				numberStack.push(strnum1);
				continue;
			} else {
 				float num2 = Float.parseFloat(strnum2);
				
 				
				String symbol = symbolStack.pop();
				
				String result = calculate2(num1, num2, symbol)+"";
				
				System.out.println(result);
				
				numberStack.push(result);
				
			}
		}
		
		
	}

}
