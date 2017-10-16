package niukeBAT.stackQueue;

import java.util.Stack;

/**
 * 逆序栈
 */
public class ReversedStack {

    public static void main(String[] args) {
        int[] array={3,2,3,2,4,5,6,7,1};
        Stack<Integer> stack=new Stack<>();
        for (int i : array) {
            stack.push(i);
        }

        reverse(stack);
        System.out.println(stack);
    }

    //获得并且移除栈底
    private static int getBottom(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getBottom(stack);
            stack.push(result);
            return last;
        }
    }

    private static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int bottom=getBottom(stack);
        reverse(stack);
        stack.push(bottom);
    }

}
