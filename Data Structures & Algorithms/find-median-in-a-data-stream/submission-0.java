class MedianFinder {

    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;

    public MedianFinder() {
        this.maxheap = new PriorityQueue<>((a , b) -> (b - a));
        this.minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        this.maxheap.offer(num);

        int firstHalfLargeVal = maxheap.poll();

        this.minheap.offer(firstHalfLargeVal);

        if(this.minheap.size() > this.maxheap.size()) this.maxheap.offer(this.minheap.poll());
    }
    
    public double findMedian() {
        if(this.maxheap.size() > this.minheap.size()) return this.maxheap.peek();
        else {
            return (this.maxheap.peek() + this.minheap.peek()) / 2.0;
        }
    }
}
