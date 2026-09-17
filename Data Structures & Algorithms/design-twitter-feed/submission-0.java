class Twitter {

    private int timestamp;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> following;

    public Twitter() {
        this.timestamp = 0;
        this.tweets = new HashMap<>();
        this.following = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
       
        tweets.computeIfAbsent(userId, k-> new ArrayList<>()).add(new int[]{tweetId, this.timestamp++ });

    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> latestTweets = new ArrayList<>();

        Set<Integer> followersList = following.get(userId);
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> (b[1] - a[1] ));
        
        if(followersList != null){
          for(Integer follower: followersList){
            List<int[]> list = tweets.get(follower);

                for(int i = list.size() - 1; i >= Math.max(0, list.size() - 10) ; i--){
                        maxheap.offer(list.get(i));
                }
            }   
        }

      
        List<int[]> ownTweets = tweets.get(userId);

        if(ownTweets != null){
            for(int i = ownTweets.size() - 1; i >= Math.max(0, ownTweets.size() - 10) ; i--){
                    maxheap.offer(ownTweets.get(i));
            }
        }

            int count = 1;

        while(!maxheap.isEmpty() && count <= 10){
            int tweet = maxheap.poll()[0];
            latestTweets.add(tweet);
            count++;
        }

        return latestTweets;

    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.get(followerId) == null) return;

        following.get(followerId).remove(followeeId);
    }
}
