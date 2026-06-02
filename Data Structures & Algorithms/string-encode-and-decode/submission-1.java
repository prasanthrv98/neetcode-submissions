class Solution {

    public String encode(List<String> strs) {

        StringBuilder res = new StringBuilder();

        for(String s: strs){
            res.append(s.length()).append("#").append(s);
        }

        return res.toString();

    }

//     
// 3#run4#moon3#sun
//            i
//            j
    public List<String> decode(String str) {

     int i = 0;
     List<String> res = new ArrayList<>();

     while (i < str.length()){
        int j = i;

        while(str.charAt(j) != '#'){
            j++;
        }

        int length = Integer.parseInt(str.substring(i, j));

        i = j + 1;
        j = i + length;
        String word = str.substring(i, j);
        res.add(word);
        // j = i + length;
        i = j;



     }

     return res;
    }
}
