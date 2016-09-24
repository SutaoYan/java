package com.sutao.forunittesting;

import com.others.client.Consul;
import com.others.client.KVCache;
import com.others.client.KVClient;
import lombok.Setter;

public class TwitterClient {

	@Setter
	private Consul consul;

	public String sendTweet(ITweet tweet) {
		return tweet.getMessage();
		// send the message to Twitter
	}

	public String getKey() {
		KVClient kvClient = consul.KVClient();
		KVCache kvCache = KVCache.newCache(kvClient);
		kvCache.start();
		return kvClient.toString();
	}
}
