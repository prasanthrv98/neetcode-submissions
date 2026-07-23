class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
     


        for(String str: tokens){
            if(str.equals("+")){
                int num2 = stack.pop();
                int num1 = stack.pop();

                stack.push(num2 + num1);
            }
            else if(str.equals("-")){
                int num2 = stack.pop();
                int num1 = stack.pop();

                stack.push(num1 - num2);
            }  
            else if(str.equals("*")){
                int num2 = stack.pop();
                int num1 = stack.pop();

                stack.push(num2 * num1);
            }  
            else if(str.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();

                stack.push(num1 / num2);
            }
       
            else{
                stack.push(Integer.parseInt(str));
            }
        } 

        return stack.pop();
    }
}
