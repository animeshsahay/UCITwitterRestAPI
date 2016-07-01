import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * Created by animesh on 7/1/16.
 */
public class Chennaifloods {
    public static void main(String args[]) throws TwitterException {
        ConfigurationBuilder cf = new ConfigurationBuilder();

        cf.setDebugEnabled(true);
        cf.setOAuthConsumerKey("SQzo1gMENQslwAJyEeszWCJJY");
        cf.setOAuthConsumerSecret("2KGMg5OKki3YFDtlEn4C6Lpbe8CvXG0xoCkzSVnAf2Twnj3Wtv");
        cf.setOAuthAccessToken("149596430-r5qAiFQMNXJ9mpFB9aNvOaB2RYxE3uronLZ1VbzG");
        cf.setOAuthAccessTokenSecret("W0HliVCmfzoErfxwssRabQ7xAly4rgY5htnm4fVPOWnx1");

        TwitterFactory tf = new TwitterFactory(cf.build());
        twitter4j.Twitter twitter = tf.getInstance();

        List<Status> status = twitter.getHomeTimeline();
        for(Status st : status)
        {
            System.out.println(st.getUser().getName()+"----------------"+st.getText());
        }
    }
}
