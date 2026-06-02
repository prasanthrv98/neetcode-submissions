class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      
    // 1.create list of list int of nums elements

    List<Integer>[] freq = new List[nums.length + 1];
    Map<Integer, Integer> count = new HashMap<>();

    for (int i = 0; i < freq.length; i++){
        freq[i] = new ArrayList<>();
    }

    // 2.loop through the nums and get the count and put in freq map

    for(int n: nums){
        count.put(n, count.getOrDefault(n,0) + 1);
    }

    // 3.loop through the freq map entries and put them in value (count)
    //  in the list index and add the key to the list in that index

   for(Map.Entry<Integer, Integer> entry: count.entrySet()){
        int number = entry.getKey();
        int countValue = entry.getValue();

        freq[countValue].add(number);
    }

    // 4. loop the list of list nums in reverse order and the list inside it and take top k elements to the res list

    int[] res = new int[k];

    int index = 0;

    for(int i = freq.length - 1; i > 0 && index < k; i--){
        
        for(int n: freq[i]){
            res[index] = n;
            if(index == k) return res;

            index++;
        }
    }

    return res;
    }
}
