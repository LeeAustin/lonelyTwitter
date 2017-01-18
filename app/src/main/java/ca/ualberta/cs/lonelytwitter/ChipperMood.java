package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by amlee1 on 1/17/17.
 */

public class ChipperMood extends Mood {
    public ChipperMood(){
        super();
    }

    public ChipperMood(Date date){
        super(date);
    }

    public String DisplayMood(){
        return "Feeling chipper";
    }
}
