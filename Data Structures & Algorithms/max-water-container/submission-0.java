class Solution {
    public int maxArea(int[] heights) {


        //  optimal solution

        int l = 0,res = 0;
        int r = heights.length - 1;

        while(l < r){
            int minHeight = Math.min(heights[l], heights[r]);
            int length = r - l;

            int area = minHeight * length;
            res = Math.max(area, res);

            if(heights[l] < heights[r]) l++;
            else if(heights[l] > heights[r]) r--;
            else l++;
        }

        return res;





        // Brute Force

        // int res = 0;
        // for(int i = 0; i < heights.length; i++){

        //     for (int j = 0; j < heights.length; j++){

        //         int minHeight = Math.min(heights[i], heights[j]);
        //         int length = j - i;
        //         int area = minHeight * length;

        //         res = Math.max(area, res); 
        //     }
        // }

        // return res;
    }
}
