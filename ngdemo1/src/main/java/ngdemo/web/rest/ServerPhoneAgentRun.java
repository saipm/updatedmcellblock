package ngdemo.web.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerPhoneAgentRun {
	
	


    public void runPhoneAgent() throws InterruptedException {

        //adb shell am start -n com.example.setarehn.phage/.MainActivity
// adb install name.apk
//adb shell am force-stop com.example.setarehn.phage

        // run phone agent

    /*    SampleJavaTest.javaShellScript("adb install app-debug.apk");


        Thread.sleep(5000);


        SampleJavaTest.javaShellScript("adb shell am start -n com.example.setarehn.phage/.MainActivity");*/

    }



    public void stopPhoneAgent() throws IOException, InterruptedException
    {
       
       SampleJavaTest.javaShellScript("adb shell am force-stop com.example.setarehn.phage");
       
       System.out.println("phone agent is stopped !");
    }
    

    public String runTestCase(String testcase , String device) throws IOException, InterruptedException

    {
    	
    	 String nameOfTestCase =""; 
         if(testcase.equals("Direct Tv"))
         {
             
             return this.getApplicationUID("com.directv.dvrscheduler",device);
         }
         else if(testcase.equals("Trillian Instant Messaging"))
         {
             return  this.getApplicationUID("com.ceruleanstudios.trillian.android",device);
         }
         else if (testcase.equals("Yahoo IM"))
         {
             return this.getApplicationUID("com.yahoo.mobile.client.android.im", device);
         }
         else if(testcase.equals("Youtube without Signin"))
         {
             return this.getApplicationUID("com.google.android.youtube", device);
         }
         else if(testcase.equals("Youtube with Signin"))
         {
             return this.getApplicationUID("com.google.android.youtube", device);
         }
         else if(testcase.equals("Text Messaging"))
         {
             return "xxxxxx";
         }
         else if(testcase.equals("MMS"))
         {
             return "xxxxxx";
         }
         else if(testcase.equals("Yahoo Mail"))
         {
             return "xxxxxx";
         }
         
         
          return "";
    	 
    	 
    }
    
    
    public String getApplicationUID(String packageName, String device) throws IOException, InterruptedException
    {
         String s;
         
          s =  SampleJavaTest.javaShellScript("adb -s "+device+" shell dumpsys package "+packageName+" | grep userId=");
          
          char[] a = s.toCharArray();
          String ss = "";
          
          
          for(int i=0 ; i<s.length() ; i++)
          {
              
              if(a[i] == '=')
              {
                 for(int j=i ; a[j+1]!=' ' ; j++)
                 {
                     ss = ss + String.valueOf(a[j+1]) ;
                 }
                  break;
              }
              
          }
          
            System.out.println(ss);
            return ss;
    }
    
    
    
    
    public String trillianApplicationUID() throws IOException, InterruptedException
    {
    	 String s;
 		
	      s =  SampleJavaTest.javaShellScript("adb shell dumpsys package com.ceruleanstudios.trillian.android | grep userId=");
	      
	      char[] a = s.toCharArray();
	      String ss = "";
	      
	      
	      for(int i=0 ; i<s.length() ; i++)
	      {
	    	  
	    	  if(a[i] == '=')
	    	  {
	    		 for(int j=i ; a[j+1]!=' ' ; j++)
	    		 {
	    			 ss = ss + String.valueOf(a[j+1]) ;
	    		 }
	    		  break;
	    	  }
	    	  
	      }
	      
	        System.out.println(ss);
	        return ss;
    }


    public void setResultInDataBase(String numberOfRXPkts , String numberOfTXPkts , String bytesOfRXPkts , String bytesOfTXPkts , String latency)

    {


         System.out.println("Result .....Set");


    }























}

	
	

