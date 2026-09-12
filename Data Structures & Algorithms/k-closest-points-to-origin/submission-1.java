class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> 
                        (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point: points){
          
          maxheap.add(point);

          if(maxheap.size() > k) maxheap.poll();

        }

        int[][] res = new int[k][2];
        int index = 0;
        while(!maxheap.isEmpty()){
            int[] curPoint = maxheap.poll();
            // res[index][0] = curPoint[0];
            // res[index][1] = curPoint[1];
            res[index] = new int[]{curPoint[0], curPoint[1]};

            index++;
        }

        return res;

    }

    
}
