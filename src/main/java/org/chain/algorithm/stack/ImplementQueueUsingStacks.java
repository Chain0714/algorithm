package org.chain.algorithm.stack;
import java.util.ArrayDeque;
import	java.util.Queue;

import java.util.Queue;
import java.util.Stack;

/**
 * description:  ImplementQueueUsingStacks
 *  使用栈实现队列的下列操作
 * @author Chain
 * @version 1.0
 * @since 2019/12/9 16:18
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public ImplementQueueUsingStacks() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Queue queue = new ArrayDeque();
        this.input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        checkMoveAll();
        return this.output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        checkMoveAll();
        return this.output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        checkMoveAll();
        return output.isEmpty();
    }

    private void checkMoveAll() {
        if (this.output.isEmpty()) {
            while (!this.input.isEmpty()) {
                this.output.push(this.input.pop());
            }
        }
    }
}
