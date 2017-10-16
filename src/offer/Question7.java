package offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 用俩个栈实现队列
 */
public class Question7<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();
    private int size = 0;

    public int size(){
        return size;
    }

    public void offerQueue(T t) {
        stack1.push(t);
        size++;
    }

    public T pollQueue(){
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                T pop = stack1.pop();
                stack2.push(pop);
            }
        }

        if (!stack2.isEmpty()) {
            size--;
            return stack2.pop();
        } else {
            return null;
        }

    }


    public static void main(String[] args) {
        Question7<Integer> question7 = new Question7<>();
        for (int i = 0; i < 10; i++) {
            question7.offerQueue(i);
        }
        while (question7.size()!=0){
            Integer integer = question7.pollQueue();
            System.out.println(integer);
        }
    }


}
