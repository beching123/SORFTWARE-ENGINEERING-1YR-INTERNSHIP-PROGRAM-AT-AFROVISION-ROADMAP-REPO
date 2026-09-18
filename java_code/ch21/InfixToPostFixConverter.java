// exercise 21.12 InfixToPostFixConverter.java
// convert ordinary infix arithmetic expression with single digits to 
// postfix expression. 
package java_code.ch21;

import java.util.Scanner;

public class InfixToPostFixConverter {

    // instance variables that will hold our expressions
    private StringBuffer infix = new StringBuffer();
    private StringBuffer postfix = new StringBuffer();
    private Scanner input = new Scanner(System.in);
    private String expression;

    // instace variable stack
    private StackInheritance<Character> stack = new StackInheritance<>();

    public void expression() {

        // prompting the user to enter their expression
        System.out.print("Enter an expression: ");
        expression = input.nextLine();

        // putting it into our string builder
        infix.append(expression); // parse the expression to our string builder

        // parsing our infinix expression to be converted to postfix
        createToPostfixExpression();
        System.out.println();
        System.out.println();

        input.close();

    }

    // method used to convert our expression from postfix to infix.
    public void createToPostfixExpression() {

        stack.push('('); // pushing a left parenthesis to our stack
        infix.append(')'); // appending a right parenthesis to the end of the infix notation

        // temporal character that will hold each
        // character from the infix buffer
        Character ch = '0';
        // Character stackCharacter; // characters the we pop from the stack
        int i = 0; // iterator character used to read infix chars

        // traversing our stack
        while (!stack.isEmpty()) {

            // reading the infix from left to right
            // for (int i = 0; i < infix.length(); i ++) {

            if (i == infix.length())
                break;

            if (i < infix.length())
                ch = infix.charAt(i);

            // append the digits to the postfix
            if (Character.isDigit(ch)) {

                // for interger values greater than 9
                while (Character.isDigit(ch)) {

                    postfix.append(ch);

                    if (i < infix.length()) // secure check
                        ch = infix.charAt(++i);
                }
                postfix.append(' '); // using space to make it bueatiful
                ch = infix.charAt(i);

            }

            // pushing parenthesis onto the stack.
            if (ch.equals('('))
                stack.push(ch);

            // handleling operators in our expression
            else if (isAnOperator(ch)) {

                // poping operators at the top of the stack if any
                // and also if they have higher precedence than the current one
                while (isAnOperator(stack.peakAtTop())
                        && (hasValidPrecedence(stack.peakAtTop())) >= hasValidPrecedence(ch)) {

                    // appending a valid poped operator to the postfix
                    postfix.append(stack.pop());
                    postfix.append(' '); // using space to make it bueatiful
                }

                // pushing the current character of the infix to the stack
                stack.push(ch);
            }

            // handling right parenthesis
            else if (ch.equals(')')) {

                // poping operators from the top of the stack untill a left parenthesis is met,
                // and appending to postfix
                while (isAnOperator(stack.peakAtTop()) && !(stack.peakAtTop()).equals('(')) {

                    postfix.append(stack.pop()); // appending operators to postfix
                    postfix.append(' '); // using space to make it bueatiful
                }

                // at this point the element at the top of the stack if the left parenthesis
                stack.pop();
            }

            else {
                Character temp = postfix.charAt(postfix.length() - 1);
                if (!temp.equals(' '))
                    postfix.append(ch);
            }

            i++;

        }
    }

    // helper class used to check if a character in a operator
    protected boolean isAnOperator(Character ch) {

        // checks the characters and return true if its an operator
        if (ch.equals('*') || ch.equals('+') || ch.equals('-') || ch.equals('/') || ch.equals('^') || ch.equals('%'))
            return true;

        return false; // the character is not an operator
    }

    // checking the precedence of operator
    private int hasValidPrecedence(Character ch) {

        int precedence = 0; // precedence initial

        // checking the precedence of our operator
        // operators with similar precedence are grouped together
        switch (ch) {

        case '*':
        case '/':
        case '%':
            precedence = 10;
            break;

        case '+':
        case '-':
            precedence = 8;
            break;

        case '^':
            precedence = 4;
            break;

        }

        return precedence;
    }

    // get method to get the postfix expression
    public StringBuffer getPostfix() {
        return postfix;
    }

}
