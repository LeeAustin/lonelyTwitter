package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by amlee1 on 2/14/17.
 */

public class TweetList{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public boolean hasTweet(Tweet tweet){
        //return tweets.contains(tweet);
        for (int i = 0; i < tweets.size(); i++) {
            if (tweet.equals(tweets.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    //Sorting a list by date as per the suggestion here: http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
    public List<Tweet> getTweets(){
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2){
                return t1.getDate().compareTo(t2.getDate());
            }
        });
        return tweets;
    }

    //Counting the elements of an ArrayList as per http://stackoverflow.com/questions/3704194/count-the-number-of-items-in-my-array-list
    public int getCount() {
        return tweets.size();
    }

}
