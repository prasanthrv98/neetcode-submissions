class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

// populate the maxheap with values
        for(int stone: stones){
            maxHeap.add(stone);
        }

// loop until one val remains after the simulation
        while(maxHeap.size() > 1){
            int firstHeavyStone = maxHeap.poll();
            int secondHeavyStone = maxHeap.poll();
            int res = 0;

            if(firstHeavyStone < secondHeavyStone){
                res = secondHeavyStone - firstHeavyStone;
            } else if(firstHeavyStone > secondHeavyStone){
                res = firstHeavyStone - secondHeavyStone;
            }

            if(res > 0) maxHeap.add(res);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
