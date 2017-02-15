package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by amlee1 on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

        try {
            tweets.add(tweet);
        } catch (IllegalArgumentException e) {

        }
        assertEquals(tweets.getCount(), 1);
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));

    }

    public void testStrings(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start with 't'", "test".startsWith("t")); //please dont hardcode the test

    }

    public void testTweetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("First Tweet");
        Tweet tweetTwo = new NormalTweet("Second Tweet");

        tweets.add(tweet);
        assertEquals(tweets.getCount(), 1);

        tweets.add(tweetTwo);
        assertEquals(tweets.getCount(), 2);
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("I'm here");

        tweets.add(tweet);
        assertEquals(tweets.hasTweet(tweet), true);
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("First Tweet");
        Tweet tweetTwo = new NormalTweet("Second Tweet");
        Tweet tweetThree = new NormalTweet("Final Tweet");

        tweets.add(tweet);
        tweets.add(tweetTwo);
        tweets.add(tweetThree);

        //List copy method taken from here:
        // http://stackoverflow.com/questions/14319732/how-to-copy-a-java-util-list-into-another-java-util-list
        List<Tweet> copy = new ArrayList<Tweet>(tweets.getTweets());
        Collections.sort(copy, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        });

        for (int i = 0; i < tweets.getCount(); i++) {
            assertEquals(tweets.getTweet(i), copy.get(i));
        }
    }
}
