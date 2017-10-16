package niukeBAT.stackQueue;
/**
 * 一个可以查询最小值的栈
 */

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public int push(int item) {
        if(stackMin.empty()){
            stackMin.push(item);
        }else {
            Integer peek = stackMin.peek();
            if (item < peek) {
                stackMin.push(item);
            } else {
                stackMin.push(peek);
            }
        }


        return stackData.push(item);
    }

    public int pop() {
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin(){
        return stackMin.peek();
    }


    public static void main(String[] args) {
        int[] array={3,2,3,2,4,5,6,7,1};
        MinStack minStack=new MinStack();
        for (int i : array) {
            minStack.push(i);
        }

        System.out.println(minStack.getMin());
    }

}
