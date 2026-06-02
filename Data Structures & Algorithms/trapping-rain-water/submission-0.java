class Solution {
    public int trap(int[] height) {

        int l = 0 , res = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        

        while(l < r){
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL, height[l]);
                res += maxL - height[l];
            }
            else{
                r--;
                maxR = Math.max(maxR, height[r]);
                res += maxR - height[r];
            }
        }

        return res;

        
    }
}
