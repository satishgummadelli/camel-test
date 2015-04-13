package org.satishg.camel.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SampleMessageProcessor  implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("at the Processor ..............");
		System.out.println(exchange.getIn().getBody(String.class));
		
	}

}
