package com.mapr.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.google.common.io.Resources;

/**
 * This producer will send a bunch of messages to the topic specified.
 */
public class Producer {
	public static void main(String[] args) throws IOException {

		final String TOPIC = "/mapr/BI.devcluster.com/cbs/smscstreams/smscstreams:bademba";

		// set up the producer
		KafkaProducer<String, String> producer;
		try (InputStream props = Resources.getResource("producer.properties").openStream()) {
			Properties properties = new Properties();
			properties.load(props);
			producer = new KafkaProducer<>(properties);
		}

		try {
			for (int i = 0; i < 1000000; i++) {
				// send lots of messages
				producer.send(new ProducerRecord<String, String>(TOPIC,
						String.format("{\"name\":\"user1\", \"message\":\"kafka user1 test\"}", i)));
				System.out.println("Sent msg number " + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}

	}
}
