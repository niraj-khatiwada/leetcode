package DesignTwitter355;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class DesignTwitter {
    public Map<Integer, User> users;
    public int time;

    private class User {
        public int id;
        public Set<Integer> followings;
        public Set<int[]> tweets; // [time, tweetId]

        public User(int id) {
            this.id = id;
            this.followings = new HashSet<>();
            this.tweets = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        }
    }

    public DesignTwitter() {
        this.users = new HashMap<>();
    }

    // O(1)
    public void postTweet(int userId, int tweetId) {
        var user = this._createOrRetrieveUser(userId);
        user.tweets.add(new int[] { time, tweetId });
        time++;
    }

    // O(10 * log(k)) k = number of tweets of user and it's followings
    public List<Integer> getNewsFeed(int userId) {
        var user = this._createOrRetrieveUser(userId);
        var count = 0;
        var rs = new ArrayList<Integer>();
        var heap = new PriorityQueue<int[]>(Comparator.comparingInt(x -> -x[0])); // [time, tweetId]
        for (var tweet : user.tweets) {
            heap.offer(tweet);
        }
        for (var followingId : user.followings) {
            var following = this.users.get(followingId);
            for (var tweet : following.tweets) {
                heap.offer(tweet);
            }
        }
        while (!heap.isEmpty()) {
            var tweet = heap.poll();
            rs.add(tweet[1]);
            count++;
            if (count == 10) {
                break;
            }
        }
        return rs;
    }

    // O(1)
    public void follow(int followerId, int followeeId) {
        var follower = this._createOrRetrieveUser(followerId);
        var followee = this._createOrRetrieveUser(followeeId);
        follower.followings.add(followeeId);
    }

    // O(1)
    public void unfollow(int followerId, int followeeId) {
        var follower = this._createOrRetrieveUser(followerId);
        var followee = this._createOrRetrieveUser(followeeId);
        follower.followings.remove(followeeId);
    }

    // O(1)
    private User _createOrRetrieveUser(int id) {
        var user = this.users.get(id);
        if (user == null) {
            user = new User(id);
            this.users.put(id, user);
        }
        return user;
    }
}
