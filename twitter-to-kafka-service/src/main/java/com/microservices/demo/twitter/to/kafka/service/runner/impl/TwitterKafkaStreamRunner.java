package com.microservices.demo.twitter.to.kafka.service.runner.impl;

import com.microservices.demo.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.listener.TwitterKafkaStatusListener;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import com.twitter.clientlib.ApiClient;
import com.twitter.clientlib.JSON;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.StreamingTweetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

@Component
@ConditionalOnProperty(name = "twitter-to-kafka-service.enable-mock-tweets", havingValue = "false", matchIfMissing = true)
public class TwitterKafkaStreamRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStreamRunner.class);

    private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;

    private final TwitterKafkaStatusListener twitterKafkaStatusListener;

    private TwitterApi apiInstance;

    public TwitterKafkaStreamRunner(TwitterToKafkaServiceConfigData configData,
                                    TwitterKafkaStatusListener statusListener) {
        this.twitterToKafkaServiceConfigData = configData;
        this.twitterKafkaStatusListener = statusListener;
    }

    @Override
    public void start() {
        ApiClient client = new ApiClient();
        client.setBearerToken("xxxx"); // Replace with your Bearer Token

        apiInstance = new TwitterApi(client);

        try (InputStream stream = apiInstance.tweets().searchStream()
                .tweetFields(Set.of("id", "text", "created_at"))
                .expansions(Set.of("author_id"))
                .userFields(Set.of("id", "name", "username"))
                .execute()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    StreamingTweetResponse response = JSON.deserialize(line, StreamingTweetResponse.class);
                    if (response.getData() != null) {
                        twitterKafkaStatusListener.onTweet(response.getData());
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception when calling Twitter API: ", e);
        }
    }

    @PreDestroy
    public void shutdown() {
        if (apiInstance != null) {
            LOG.info("Closing Twitter stream!");
            // Close the connection (if applicable)
        }
    }

}