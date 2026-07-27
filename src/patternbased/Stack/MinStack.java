package patternbased.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    public MinStack() {
    }

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    //void push(int value) pushes the element value onto the stack.
    //void pop() removes the element on the top of the stack.
    //int top() gets the top element of the stack.
    //int getMin() retrieves the minimum element in the stack.

    public void push(int val){
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    public void pop(){
        if(stack.pop().equals(minStack.peek())){
            stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
