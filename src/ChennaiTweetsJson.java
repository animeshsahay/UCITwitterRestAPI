import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

/**
 * Created by animesh on 7/1/16.
 */
public class ChennaiTweetsJson {
    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cf = new ConfigurationBuilder();

        cf.setDebugEnabled(true);
        cf.setOAuthConsumerKey("SQzo1gMENQslwAJyEeszWCJJY");
        cf.setOAuthConsumerSecret("2KGMg5OKki3YFDtlEn4C6Lpbe8CvXG0xoCkzSVnAf2Twnj3Wtv");
        cf.setOAuthAccessToken("149596430-r5qAiFQMNXJ9mpFB9aNvOaB2RYxE3uronLZ1VbzG");
        cf.setOAuthAccessTokenSecret("W0HliVCmfzoErfxwssRabQ7xAly4rgY5htnm4fVPOWnx1");
        cf.setJSONStoreEnabled(true);

        Twitter twitter = new TwitterFactory(cf.build()).getInstance();
        Query query = new Query("#chennaifloods");
        QueryResult result = twitter.search(query);
        for (Status tweet : result.getTweets()) {
            System.out.println(tweet.getUser().getScreenName() + ":" + tweet.getText());
            String json = DataObjectFactory.getRawJSON(tweet);
            System.out.println(json);
        }
    }
}
