package stackqueuealgos;

import java.util.*;

/*
Algorithm:
1) Declare a character stack S.
2) Now traverse the expression string exp.
    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack
       and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3) After complete traversal, if there is some starting bracket left in stack then “not balanced”
*/
public class ParenthesesMatching {
    public static void main(String[] args) {
        String str = "({}){}";
        System.out.println(isBalanced(str));
    }
    
    static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if(ch == '}' || ch == ')' || ch == ']') {
                if(stack.isEmpty()) {
                    return false;
                } else if(isMatchingPair(stack.peek(), ch)) {
                    count++;
                    stack.pop();
                }
            }
        }
        System.out.println(count);
        return stack.isEmpty();
    }
    
    static boolean isMatchingPair(char ch1, char ch2) {
        if(ch1 == '(' && ch2 == ')')
            return true;
        else if(ch1 == '{' && ch2 == '}')
            return true;
        else if(ch1 == '[' && ch2 == ']')
            return true;
        else
            return false;
    }
}
