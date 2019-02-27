import java.util.*;
class Postfix
{

   static int operatorPredance(char op)
    {
     		if(op == '+' || op == '-')
		{
			return 1;	
		}
		else if(op == '/' || op == '*')
		{
			return 2;
		}
		else if(op == '^')
		{
			return 3;
		}   
	return 0;  
    }
   static  boolean isOperator(char e)
	{
		if(e =='+' || e =='-' || e =='/' || e =='*')
		{
			
			return true;			
		}
		return false;
	}

	public static void main(String args[])
	{
		int inc = 0;
		boolean flag = true;
		Stack <Character> operator = new Stack<>();
		Stack <Double> numbers = new Stack<>();
		String exp = "22+25/0*2";
		String number[] = exp.split("[+-/*]+");
		for(String r : number)
		{
			System.out.println(r);
		} 
		for(int i = 0;i<exp.length();i++)
		{
			if(isOperator(exp.charAt(i)))
			{
				if(operator.empty())
				{
					operator.push(exp.charAt(i));	
					System.out.println(operator.peek());
					flag = true;
				}
				else
				{
					
					int incoming = operatorPredance(exp.charAt(i));
					int instack = operatorPredance(operator.peek());
					if(incoming <= instack)
					{
						double number2 = numbers.pop();
						System.out.println("number2 :"+number2);
						double number1 = numbers.pop();
						System.out.println("number1 :"+number1);
						double result = 0;
						System.out.println(operator.peek());
						if(operator.peek() == '+')
						{
						 result = number1 + number2;
						}
						else if(operator.peek() == '-')
						{
						 result = number1 - number2;
						}
						else if(operator.peek() == '*')
						{
						 result = number1 * number2;
						}
						else if(operator.peek() == '/')
						{
						 result = number1 / number2;
						}
						numbers.push(result);
						operator.pop();
						
						
					}
					operator.push(exp.charAt(i));
					
					System.out.println(operator.peek());
					flag = true;
		
				}
			}
			else
			{
				if(flag)
				{
					System.out.println(number[inc]);
					double c= Double.parseDouble(number[inc]);
					inc++;
					numbers.push(c);
					flag = false;
				}
			}
		}
		while(!operator.empty())
		{
		
			
			double number2 = numbers.pop();
			double number1 = numbers.pop();
			double result = 0;
			System.out.println("number2 :"+number2);
			System.out.println("number1 :"+number1);
			System.out.println(operator.peek());
						if(operator.peek() == '+')
						{
						 result = number1 + number2;
						}
						else if(operator.peek() == '-')
						{
						 result = number1 - number2;
						}
						else if(operator.peek() == '*')
						{
						 result = number1 * number2;
						}
						else if(operator.peek() == '/')
						{
						 result = number1 / number2;
						}
						operator.pop();
						numbers.push(result);
						

		}
		if(numbers.peek() ==Double.POSITIVE_INFINITY)
		{
			String c = String.valueOf(Character.toString('\u221E'));
			System.out.println(c);
		}
		else
		System.out.println("Answer ="+numbers.pop());
	}

}