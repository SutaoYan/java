package com.sutao.producer;

import java.util.concurrent.ExecutionException;

import com.sutao.IKafkaConstants;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerApp {
	public static void main(String[] args) {
		runProducer();
	}

	static void runProducer() {
		Producer<Integer, String> producer = ProducerCreator.createProducer();
		for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
			ProducerRecord<Integer, String> record = new ProducerRecord<Integer, String>(IKafkaConstants.TOPIC_NAME, index,
				"This is record " + index);
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
					+ " with offset " + metadata.offset());
				Thread.sleep(2000l);
			} catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}
}
