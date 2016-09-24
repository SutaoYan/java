package com.sutao.forunittesting;

import com.others.client.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(KVCache.class)
public class TwitterClientTest {

	@Mock
	ITweet iTweet;

	@Mock
	Consul consul;

	@Mock
	ClientConfig clientConfig;

	@Mock
	CacheConfig cacheConfig;

	@Mock
	KVClient kvClient;


	@Mock
	KVCache kvCache;

	@InjectMocks
	TwitterClient twitterClient;

	@Before
	public void setUp() throws Exception {
//		twitterClient = new TwitterClient();
//		twitterClient.setConsul(consul);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sendTweet() {
		PowerMockito.when(iTweet.getMessage()).thenReturn("hello mockito");
		assertEquals(	twitterClient.sendTweet(iTweet), "hello mockito");
	}

	@Test
	public void getKey() {
		PowerMockito.when(consul.KVClient()).thenReturn(kvClient);

//		doReturn(clientConfig).when(kvClient).getConfig();
		PowerMockito.when(kvClient.getConfig()).thenReturn(clientConfig);
		PowerMockito.when(clientConfig.getCacheConfig()).thenReturn(cacheConfig);
//when(KVCache.newCache(kvClient)).thenReturn(kvCache);
//		doAnswer(invocation->{}).when()
//		KVCache cache = KVCache.newCache(kvClient);
		KVCache spy = PowerMockito.mock(KVCache.class);

		PowerMockito.mockStatic(KVCache.class);
		PowerMockito.when(KVCache.newCache(kvClient)).thenAnswer(invocationOnMock -> {
//			return spy;
			return spy;
		});
		PowerMockito.doNothing().when(spy).start();
//		PowerMockito.doNothing().when(KVCache);

//		PowerMockito.mockStatic(KVCache.class);
//		PowerMockito.doReturn(cache).when(KVCache.newCache(kvClient));

//		PowerMockito.doNothing().when(KVCache.newCache(kvClient));
//		PowerMockito.when(KVCache.newCache(kvClient).start()).thenReturn();

		PowerMockito.when(kvClient.toString()).thenReturn("key");
		assertEquals(twitterClient.getKey(), "key");
	}
}