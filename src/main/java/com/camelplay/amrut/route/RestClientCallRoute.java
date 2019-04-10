package com.camelplay.amrut.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestClientCallRoute extends SpringRouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:testRest")
		.streamCaching()
		.to("log:Response Payload?showAll=true")
		.to("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
		.convertBodyTo(String.class)
		.to("log:Response Payload?showAll=true");
	}

}
