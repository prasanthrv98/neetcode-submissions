class MinStack {
    public Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<int[]>();
    }
    
    public void push(int val) {
        int curMin = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);

        stack.push(new int[] {val, curMin});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
