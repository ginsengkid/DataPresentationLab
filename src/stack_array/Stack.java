package stack_array;

public class Stack {
    private int[] s;
    private int up;

    public Stack(int size) {
        s = new int[size];
        up = -1;
    }

    public void push (int v) {
        s[++up] = v;
    }

    public int pop() {
        return s[up--];
    }

    public int top() {
        return s[up];
    }

    public boolean full() {
        return up == s.length - 1;
    }

    public boolean empty() {
        return up == -1;
    }

}
