package com.others.client;


public class Consul {
	private final KVClient kvClient;

	private Consul(KVClient kvClient) {
		this.kvClient = kvClient;
	}

	public KVClient KVClient() {
		return kvClient;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		Builder() {
		}

		public Consul build() {
			ClientConfig config =  new ClientConfig();
			KVClient keyValueClient = new KVClient( config);
			return new Consul(keyValueClient);
		}
	}
}
