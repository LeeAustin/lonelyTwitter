package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by amlee1 on 1/17/17.
 */

public abstract class Tweet  implements Tweetable{
    private Date date;
    private String message;
    private ChipperMood chipper;
    private DownMood down;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();
    private Mood mood;

    // private String hiddenString;

    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
        moodList.add(chipper);
        moodList.add(down);
    }

    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date();
        moodList.add(chipper);
        moodList.add(down);
    }

    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mood setMood(Mood mood) {
        this.mood = mood;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 144) {
            //todo throw error here
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
        if (this.mood == chipper) {
            this.message = message + chipper.DisplayMood();
        }
        if(this.mood == down) {
            this.message = message + down.DisplayMood();
        }
        this.message = message;
    }

    public void setDown(DownMood down) {
        this.down = down;
    }

    public void setChipper(ChipperMood chipper) {
        this.chipper = chipper;
    }
}
