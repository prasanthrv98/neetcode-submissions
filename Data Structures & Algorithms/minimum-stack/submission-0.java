class MinStack {

    public Deque<Integer> mainStack;
    public Deque<Integer> minStack;

    public MinStack() {
        mainStack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        
        mainStack.push(val);

        if(minStack.isEmpty()) minStack.push(val);
        else minStack.push(Math.min(val, minStack.peek()));
    }
    
    public void pop() {
         mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
