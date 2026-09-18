// exercise 21.13 PostfixEvaluator.java
// this class evaluates postfix expression to 
// check if they are correct or not 
package java_code.ch21;

public class PostfixEvaluator extends InfixToPostFixConverter {

    // instance variables that holds the supposed postfix expression
    private StringBuffer expression = new StringBuffer();
    private StackInheritance<Integer> stack = new StackInheritance<>(); // stack used to hold our expression
    private Integer answer; // used to hold the result of y operator x;

    // constructor
    public PostfixEvaluator(StringBuffer exp) {

        expression = exp; // initializing the instance variable
    }

    // method evaluator that evaluates the expression
    public void evaluateExpression() {

        // appending a right parenthesis to the end of our expression
        expression.append(')');

        // iterator variable used to traverse the postfix expression
        int i = 0;
        Character ch = expression.charAt(i); // this variable holds each char of the expresion in object form

        // while loop used to traverse the postfix expression with the
        // help of the variable i, till the right parenthesis is encountered
        while (!ch.equals(')')) {

            if (Character.isDigit(ch)) {

                String number = ""; // holds the final number

                // handling integers greater than 9
                while (Character.isDigit(ch)) {

                    Integer value = ch - '0';
                    number += value;

                    // getting the next character
                    ch = expression.charAt(++i);
                }

                stack.push(Integer.parseInt(number)); // pushing our final value

            }

            if (isAnOperator(ch)) {

                // variables that holds the integer /
                // values popped from the stack /
                int x;
                int y;

                x = stack.pop();
                y = stack.pop();

                calculate(y, x, ch);

            }

            i++; // incrementing the iterator
            ch = expression.charAt(i); // this variable holds
        }

        answer = stack.pop(); // for the final answer expression
    }

    // this method does the calculations between values
    public void calculate(int y, int x, Character operator) {

        switch (operator) {

        case '+':
            answer = y + x;
            break;
        case '-':
            answer = y - x;
            break;
        case '*':
            answer = y * x;
            break;
        case '/':
            answer = y / x;
            break;
        case '%':
            answer = y % x;
            break;
        case '^':
            if (x == 0)
                answer = 1;
            else {
                
                int temp = 1;
                while (x != 0) {
                    temp *= y;
                    x--;
                }
                answer = temp;
            }
            break;
        }

        stack.push(answer); // pushing our answer to the stack
    }

    // get method for answer
    public Integer getAnswer() {
        return answer;
    }
}
