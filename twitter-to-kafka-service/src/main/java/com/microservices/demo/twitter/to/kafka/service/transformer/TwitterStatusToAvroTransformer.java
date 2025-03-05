package com.microservices.demo.twitter.to.kafka.service.transformer;

import com.microservices.demo.kafka.avro.model.TwitterAvroModel;
import com.twitter.clientlib.model.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TwitterStatusToAvroTransformer {

    public TwitterAvroModel getTwitterAvroModelFromTweet(Tweet tweet) {
        return TwitterAvroModel.newBuilder()
                .setUserId(tweet.getAuthorId() != null ? Long.parseLong(tweet.getAuthorId()) : 0)
                .setId(Long.parseLong(tweet.getId()))
                .setText(tweet.getText())
                .setCreatedAt(tweet.getCreatedAt() != null ? tweet.getCreatedAt().toEpochSecond() : 0)
                .build();
    }
}
