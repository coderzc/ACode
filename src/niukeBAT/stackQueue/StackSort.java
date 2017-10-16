package niukeBAT.stackQueue;

import java.util.Stack;

/**
 * 栈排序
 */
public class StackSort {
    public static void main(String[] args) {
        int[] array={3,2,3,2,4,5,6,7,1};
        Stack<Integer> stack=new Stack<>();
        for (int i : array) {
            stack.push(i);
        }

        sortStack(stack);
        System.out.println(stack);

    }

    private static void sortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            while (!help.isEmpty() && help.peek() > pop) {
                stack.push(help.pop());
            }
            help.push(pop);
        }
        while (!help.isEmpty()){
            Integer pop = help.pop();
            stack.push(pop);
        }
    }

}
