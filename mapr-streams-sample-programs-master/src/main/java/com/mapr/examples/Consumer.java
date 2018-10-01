package com.mapr.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.google.common.io.Resources;

public class Consumer {
	public static void main(String[] args) throws IOException {

		// the consumer
		KafkaConsumer<String, String> consumer;
		try (InputStream props = Resources.getResource("consumer.properties").openStream()) {
			Properties properties = new Properties();
			properties.load(props);
			consumer = new KafkaConsumer<>(properties);
                       // consumer.subscribe("");
			consumer.subscribe(Arrays.asList(properties.getProperty("stream")));
		}
		int timeouts = 0;
		// InfiniteLoopStatement
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(1000);
			if (records.count() == 0) {
				timeouts++;
			} else {
				System.out.printf("Got %d records after %d timeouts\n", records.count(), timeouts);
				timeouts = 0;
			}
			System.out.println("Number of records received=" + records.count());
			for (ConsumerRecord<String, String> record : records) {
				System.out.println("topic=" + record.topic() + " |partition=" + record.partition() + "|offset"
						+ record.offset() + "|value=" + record.value());
			}
		}
	}
}
