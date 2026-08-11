class Solution {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();  // stores indices
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int poppedIndex = stack.pop();
                int poppedHeight = heights[poppedIndex];

                int rightBoundary = i;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                int width = rightBoundary - leftBoundary - 1;
                int area = poppedHeight * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}    
    