class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> (b - a));

        int[] count = new int[26];

        Queue<int[]> queue = new ArrayDeque<>();

        int time = 0;

//  count the freq of the chars
        for(int i = 0; i < tasks.length; i++){
            int charIndex = tasks[i] - 'A';
            count[charIndex]++;
        }

        for(int i = 0; i < count.length; i++){
            if(count[i] > 0) maxheap.offer(count[i]);
        }

        while(!maxheap.isEmpty() || !queue.isEmpty()){
            time++;

            if(!maxheap.isEmpty()){
                int curCount = maxheap.poll() - 1;
                if(curCount > 0) queue.offer(new int[]{curCount, time + n + 1});
            }

            if(!queue.isEmpty() && queue.peek()[1] == time + 1){
                maxheap.offer(queue.poll()[0]);
            }
        }

        return time;
        
    }
}
