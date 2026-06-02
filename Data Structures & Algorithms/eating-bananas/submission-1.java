class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxVal = 0;
        for(int pile: piles){
            maxVal = Math.max(pile, maxVal);
        }

        int l = 1, r = maxVal, res = maxVal;


        // for(int i = 1; i <= maxVal; i++){
        //     if(getTotalHours(i, piles) <= h) {
        //         res = i;
        //         break;
        //     }
        // }

        // 1 2 3 4 5 6 7 8
        // int res = 0;
        while(l < r){
            int m = l + (r - l) / 2;
            int totalHours = getTotalHours(m, piles);

            if(totalHours > h) l = m + 1;
            else  {
                r = m;
                res = Math.min(res, m);
            }
        }
        
        return res;
        
    }

    public int getTotalHours(int i, int[] piles){
        int totalHours = 0;
        for(int pile: piles){
            totalHours += Math.ceil((double) pile / i);
            
        }

        return totalHours;
    }
}
