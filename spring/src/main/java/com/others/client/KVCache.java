package com.others.client;

public class KVCache {

	private CacheConfig cacheConfig;
	private KVCache(CacheConfig cacheConfig) {
		this.cacheConfig = cacheConfig;
	}

	public static KVCache newCache(final KVClient kvClient) {
		return new KVCache(kvClient.getConfig().getCacheConfig());
	}

	public void start() {
		assert false;
	}
}
