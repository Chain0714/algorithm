package org.chain.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * description:  ImplementStackUsingQueues
 *
 * @author Chain
 * @version 1.0
 * @since 2019/12/9 17:34
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }

    private Queue<Integer> queue;

    public ImplementStackUsingQueues() {
        this.queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Queue<Integer> temp = new ArrayDeque<>();
        Integer poll = tempQueue(temp);
        this.queue = temp;
        return poll;
    }

    /**
     * Get the top element.
     */
    public int top() {
        Queue<Integer> temp = new ArrayDeque<>();
        Integer poll = tempQueue(temp);
        temp.add(poll);
        this.queue = temp;
        return poll;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.queue.isEmpty();
    }

    private Integer tempQueue(Queue<Integer> temp) {
        int size = this.queue.size();
        for (int i = 0; i < size - 1; i++) {
            temp.add(this.queue.poll());
        }
        return this.queue.poll();
    }

}
