package rpncalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author Nicklas Molving
 */
public class RPNCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack();
        System.out.println("Hello human, you have started a Reverse Polish Notation calculator");
        String rpn = in.readLine();
        while (true) {
            if (rpn.equals("")) {
                printStack(stack); //printStack if the string is empty ie. when return/enter is pushed on the keyboard.
            } else if (rpn.equalsIgnoreCase("stop")) {
                System.out.println("command 'stop' acknowledged, printing stack...");
                printStack(stack);
                System.out.println("bye bye human....");
                break;
            } else if (rpn.matches("([^\\d\\+\\-\\*\\/\\s])+")) {//regex pattern ([^\d\+\-\*\/\s])+ checks for anything that is not a number, or a supported operator.
                System.out.println("err! please refrain from anything but digits and + - * /");
            } else {
                String[] input = rpn.split(" ");
                for (String s : input) {
                    try {
                        int num = Integer.parseInt(s);
                        stack.push(num);
                    } catch (NumberFormatException e) {
                        //if exception the value is an operator!
                        //calculate and push to stack!

                        //calculate the expresion and push to stack
                        if (stack.size() <= 1) {
                            System.out.println("Sorry there's not enough information in the stack to perform this operation.");
                            System.out.println("Please add more numbers to the stack before using another operator");
                        } else {
                            int sum = calculate(stack.pop(), stack.pop(), s);
                            stack.push(sum);
                        }
                    }
                }
                printStack(stack);
            }
            rpn = in.readLine();
        }
    }

//end of main!
    public static int calculate(int firstNum, int secondNum, String operator) {
        int sum;
        switch (operator) {
            case "+":
                sum = firstNum + secondNum;
                break;
            case "-":
                sum = secondNum - firstNum;
                break;
            case "*":
                sum = firstNum * secondNum;
                break;
            case "/":
                sum = secondNum / firstNum;
                break;
            default:
                sum = 0;
        }
        return sum;
    }

    public static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("The stack does not contain any elements");
        } else {
            stack.stream().forEach((element) -> {
                System.out.println(">" + element);
            });
        }
    }

}
