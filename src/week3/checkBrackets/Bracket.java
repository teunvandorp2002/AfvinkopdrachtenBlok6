package week3.checkBrackets;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a thing:");
        String in = input.nextLine();
        Stack<Character> stack = new Stack<>();
        //String in = "{kk(hh[ii(])hh)kk}";
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            if (!stack.isEmpty()) {
                if (c == '}') {
                    if (stack.pop() != '{') {
                        positions.add(i);
                    }
                } else if (c == ']') {
                    if (stack.pop() != '[') {
                        positions.add(i);
                    }
                } else if (c == ')') {
                    if (stack.pop() != '(') {
                        positions.add(i);
                    }
                }
            } else {
                positions.add(i);
            }
        }
        if (!positions.isEmpty()) {

            for (Integer position : positions) {
                System.out.println("Error at position " + position + ":");
                System.out.println(in);
                for (int j = 0; j < position; j++) {
                    System.out.print(" ");

                }
                System.out.println("^");
            }
        } else {
            System.out.println("All good");
        }
    }
}
