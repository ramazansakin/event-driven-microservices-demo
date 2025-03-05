package com.microservices.demo.twitter.to.kafka.service.transformer;

import com.microservices.demo.kafka.avro.model.TwitterAvroModel;
import com.twitter.clientlib.model.Tweet;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TwitterStatusToAvroTransformer {

    public TwitterAvroModel getTwitterAvroModelFromTweet(Tweet tweet) {
        return TwitterAvroModel.newBuilder()
                .setUserId(Long.parseLong(Objects.requireNonNull(tweet.getAuthorId())))
                .setId(Long.parseLong(tweet.getId()))
                .setText(tweet.getText())
                .setCreatedAt(Objects.requireNonNull(tweet.getCreatedAt()).toEpochSecond())
                .build();
    }
}
