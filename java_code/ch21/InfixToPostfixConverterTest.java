package java_code.ch21;

public class InfixToPostfixConverterTest {

    public static void main(String[] args) {

        InfixToPostFixConverter test = new InfixToPostFixConverter();
        PostfixEvaluator expression; // holds our postfix expression
        test.expression();
        System.out.print("Postfix expression: " + test.getPostfix());
        System.out.println();

        // evaluating the expression
        expression = new PostfixEvaluator(test.getPostfix());
        expression.evaluateExpression();
        System.out.print("Answer: " + expression.getAnswer());
        System.out.println();

    }
}
