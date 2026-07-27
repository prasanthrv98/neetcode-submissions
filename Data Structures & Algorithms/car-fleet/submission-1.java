class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int [][] cars = new int[n][2];
        Deque<Double> stack = new ArrayDeque<>();

        for(int i = 0 ; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        double initTime = (double)(target - cars[0][0]) / cars[0][1];
        stack.push(initTime);

        for(int i = 1; i < n; i++){
            int curCarSpeed = cars[i][1];
            Double curTime = (double)(target - cars[i][0]) / cars[i][1];

            if(curTime > stack.peek()){
                stack.push(curTime);
            } 
        }

        return stack.size();
    }
}
