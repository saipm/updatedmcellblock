package com.test1;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import ngdemo.web.rest.SampleJavaTest;

public class RunPhoneAgent {
	
	
	@Test
	 public void test() throws InterruptedException, IOException {
	         SampleJavaTest.javaShellScript("adb install /home/miwcb/junitdir/junittest/phoneagent.apk");
	        Thread.sleep(2000);
	        SampleJavaTest.javaShellScript("adb shell am start -n com.example.setarehn.phage/.MainActivity");		
		
	}

}
