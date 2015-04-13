package org.satishg.camel.example.routes;

import org.apache.camel.builder.RouteBuilder;
import org.satishg.camel.example.processor.SampleMessageProcessor;
import org.springframework.stereotype.Component;

@Component
public class SampleMessageRouter extends RouteBuilder {
 
  @Override
  public void configure() throws Exception {
    from("jms://invoices").transform().simple("Transforming ${in.body} ....").process(new SampleMessageProcessor()).log("jms:invoice is logged");
  }
 
}