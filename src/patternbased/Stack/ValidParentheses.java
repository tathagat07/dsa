package patternbased.Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if(c == '{'){
                stack.push('}');
            } else if(c == '['){
                stack.push(']');
            } else {
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidApproach2(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();

                if(c == ')' && top != '('){
                    return false;
                }

                if(c == '}' && top != '{'){
                    return false;
                }

                if(c == ']' && top != '['){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String input = "([])";
        Boolean isValid = validParentheses.isValidApproach2(input);
        System.out.println(isValid);
    }
}
