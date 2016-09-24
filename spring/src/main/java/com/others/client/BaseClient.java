package com.others.client;

abstract class BaseClient {

	private final ClientConfig config;

	protected BaseClient(ClientConfig config) {
		this.config = config;
	}

	public ClientConfig getConfig() {
		return config;
	}
}