package com.others.client;

public class CacheConfig {

	private CacheConfig() {

	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Builder() {

		}
		public CacheConfig build() {
			return new CacheConfig();
		}
	}
}
