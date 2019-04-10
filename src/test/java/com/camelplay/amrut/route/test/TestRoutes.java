package com.camelplay.amrut.route.test;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.DisableJmx;
import org.apache.camel.test.spring.UseAdviceWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.camelplay.amrut.route.RestClientCallRoute;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/camel-play-context.xml" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisableJmx
@UseAdviceWith(true)
public class TestRoutes extends CamelTestSupport {

	 @Override
	    protected RoutesBuilder createRouteBuilder() throws Exception {
	        return new RestClientCallRoute();
	    }

	 @Test
	 public void checkRestCall() throws InterruptedException {
		 	String body= (String) template.requestBody("direct:testRest","Hello");
		 	Thread.sleep(5000);
	        
	 }
}
