import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * Created by animesh on 7/1/16.
 */
public class TweetsSearch {
    public static void main(String[] args) {
        //Authentication
        ConfigurationBuilder cf = new ConfigurationBuilder();

        cf.setDebugEnabled(true);
        cf.setOAuthConsumerKey("SQzo1gMENQslwAJyEeszWCJJY");
        cf.setOAuthConsumerSecret("2KGMg5OKki3YFDtlEn4C6Lpbe8CvXG0xoCkzSVnAf2Twnj3Wtv");
        cf.setOAuthAccessToken("149596430-r5qAiFQMNXJ9mpFB9aNvOaB2RYxE3uronLZ1VbzG");
        cf.setOAuthAccessTokenSecret("W0HliVCmfzoErfxwssRabQ7xAly4rgY5htnm4fVPOWnx1");

        TwitterFactory tf = new TwitterFactory(cf.build());
        Twitter twitter = tf.getInstance();

        //Actual tweet scrapping
        if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        //Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query(args[0]);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }

}
