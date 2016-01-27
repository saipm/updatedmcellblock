package ngdemo.web.rest;

import com.google.inject.Inject;

import ngdemo.domain.App;
import ngdemo.domain.Data;
import ngdemo.domain.Device;
import ngdemo.domain.Status;
import ngdemo.domain.Testcase;
import ngdemo.service.contract.TestcaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.PhantomReference;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/testcases")
public class TestcaseRestService {

   private final TestcaseService testcaseService;
   //private static String APPIUMSERVERSTART="/home/saisreem/.npm-packages/lib/node_modules/appium/bin/./appium.js";
   // private static String APPIUMSERVERSTART="/home/miwcb/./appiumstart.sh appium";
   // private static String APPIUMSERVERSTARTUID="/home/saisreem/.npm-packages/lib/node_modules/appium/bin/./appium.js -U ";
  private static String APPIUMSERVERSTARTUID="appium -U ";
   
    private static String LOGS="/home/miwcb/junitdir/logs/";
    private static String ADBDEVICES="adb devices";
   // private static String JAVASCRIPT="/home/saisreem/.npm-packages/lib/node_modules/appium/bin/./javatest.sh";
   // private static String MainSCRIPT="/home/saisreem/.npm-packages/lib/node_modules/appium/bin/./mainjava.sh";
     private static String MainSCRIPT="/home/miwcb/junitdir/scripts/./mainjava.sh";
   // private static String JAVAMSCRIPT="/home/saisreem/.npm-packages/lib/node_modules/appium/bin/./javaMtest.sh";
  // private static String LOGS="/home/saisreem/logs/";
     

    @Inject
    public TestcaseRestService(TestcaseService testcaseService) {
        this.testcaseService = testcaseService;
    }
    @GET
    @Path("/runalldevices")
    @Produces(MediaType.APPLICATION_JSON)
    public String runalldevices() throws IOException, InterruptedException{
    	String[] args1 = {};
    	 StringBuffer buffer = new StringBuffer("output:");
    	 String line1=" ";
    	 BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    	SampleJavaTest.main(args1);
    	while ((line1 = rd.readLine()) != null) {
    		System.out.println(line1);
    		buffer.append(line1 + "\n");
    		}
    	return buffer.toString();
   }  
    @GET
    @Path("/runatestcase/{device}")
    @Produces(MediaType.APPLICATION_JSON)
    public String runatestcase(@PathParam("device") String device) throws IOException, InterruptedException{
    	long startTime = System.currentTimeMillis();
    	SampleJavaTest.startAppiumServer(APPIUMSERVERSTARTUID+device);
    	StringBuffer buffer = new StringBuffer("");
    	String test="";
    	String status="";
    	String errormsg=" ";
        Thread.sleep(2000);
    	System.out.println("Device Id: "+device);
    	System.out.println("Device Model: "+SampleJavaTest.getDeviceParameters(device));
    	TestcaseDao td = new TestcaseDao();
    	if(device.equals("TA93304LE5")){
    	//test=SampleJavaTest.javaShellScript(JAVAMSCRIPT);
    	}
    	else{
       // test=SampleJavaTest.javaShellScript(JAVASCRIPT);
    	}
    	SampleJavaTest.stopAppiumServer();
    	long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    String time= String.valueOf(elapsedTime);
    	String buffstring = buffer.toString();
    	buffer.append("device:"+device+"\n");
    	buffer.append("device model:"+SampleJavaTest.getDeviceParameters(device)+"\n");
    			buffer.append(test+"\n");
    		if(buffer.indexOf("PASS")>0){
    			status="Pass";
    		}if(buffer.indexOf("FAIL")>0){
    			status="Fail";
    			errormsg="t"+(buffer.toString().substring(buffer.toString().lastIndexOf("test(")+1));	
        		System.out.println("error message:"+errormsg);
    		}
    		
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		Date date = new Date();
    		System.out.println(dateFormat.format(date));
    	//td.insertTestcase("saipm", device, "Trillian Instant Messaging", status, errormsg,dateFormat.format(date),time);
    	return buffer.toString();
   } 
    
    
    @GET
    @Path("/getalltexttestcases")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Status> getalltexttestcases() throws IOException, InterruptedException{
    	String textPath="/home/miwcb/junitdir/scripts/./textMessages.sh ";
    	//String textPath="/home/saisreem/.npm-packages/lib/node_modules/appium/bin/./textMessages.sh ";
    	Process textProcess;
    	String message = "text messsaging";
    	String input="4259519067";
    	String command="adb devices";
    	String status="";
    	String errormsg="";
    	List<String> deviceList = new ArrayList<String>();
    	List<Status> statuslist = new ArrayList<Status>();
    	Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			String line="";
            BufferedReader input1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input1.readLine()) != null) {
			    if (line.endsWith("device")) {
			        deviceList.add(line.split("\\t")[0]);
			    } if (line.endsWith("unauthorized")) {
			        deviceList.add(line.split("\\t")[0]);
			    }
			}
			
			
			for(String s:deviceList){
				long startTime = System.currentTimeMillis();
	    		textProcess = Runtime.getRuntime().exec(textPath+s+" "+input+" "+message);
	    		textProcess.waitFor();
	    		BufferedReader br = new BufferedReader(new InputStreamReader(textProcess.getInputStream()));
	            String line1;
                StringBuffer buffstring=new StringBuffer("");
	            while ((line1 = br.readLine()) != null) {
	                System.out.println(line1);
	                buffstring=buffstring.append(line1);
	                }
	            if(buffstring.toString().contains("Starting: Intent")){
	            	status="Pass";
	            }else{status="Fail";
	            errormsg=buffstring.toString();
	            	}
	            
	            long stopTime = System.currentTimeMillis();
	    	    long elapsedTime = stopTime - startTime;
	    	    String time= String.valueOf(elapsedTime);
	            TestcaseDao td = new TestcaseDao();
					
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		Date date = new Date();
	    		System.out.println(dateFormat.format(date));
	    	//	td.insertTestcase("saipm", s, "Text Messaging", status, errormsg,dateFormat.format(date),time);
	    		Status t = new Status();
	    		if(errormsg.length()>200)
	    		t.setErrormsg(errormsg.substring(0, 200));
	    		else
	    			t.setErrormsg(errormsg);
				
				t.setUserid("saipm");
				t.setDevice(s);
				t.setErrormsg(errormsg);
				t.setStatus(status);
				t.setDate(dateFormat.format(date));
				t.setTime(time);
				statuslist.add(t);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statuslist;
    }
    
    @GET
    @Path("/getalltestcases/{testcase}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Status> getalltestcases(@PathParam("testcase") String testcase) throws IOException, InterruptedException{
    	System.out.println("inside:::::::::::");
    	String command="adb devices";
    	List<String> deviceList = new ArrayList<String>();
    	List<Status> statuslist = new ArrayList<Status>();
    	Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			String line="";
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
			    if (line.endsWith("device")) {
			        deviceList.add(line.split("\\t")[0]);
			    } if (line.endsWith("unauthorized")) {
			        deviceList.add(line.split("\\t")[0]);
			    }
			}
			
		for(String device: deviceList){
			// SampleJavaTest.javaShellScript("adb -s "+device+" install /home/miwcb/junitdir/junittest/phoneagent.apk");
		    // Thread.sleep(2000);
		    // SampleJavaTest.javaShellScript("adb -s "+device+" shell am start -n com.example.setarehn.phage/.MainActivity");
			Status t = new Status();
			t=getatestcase(device,testcase);
		//	Store store = new Store();
    	//	ServerPhoneAgentRun st = new ServerPhoneAgentRun();
    		//store.uid = st.runTestCase(testcase,device);
    	//    SampleJavaTest.javaShellScript("adb -s "+ device+" shell am force-stop com.example.setarehn.phage");
			statuslist.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statuslist;
    }
    
   
    @GET
    @Path("/getpartialtestcases/{testcase}/{device}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Status> getpartialtestcases(@PathParam("testcase") String testcase,@PathParam("device") String deviceList) throws IOException, InterruptedException{
    	System.out.println("inside:::::::::::");
    	
    	List<Status> statuslist = new ArrayList<Status>();
			
    	System.out.println("device::::::::::::::::::::"+deviceList);
    	
    	String[] items = deviceList.split(",");
        List<String> itemList = Arrays.asList(items);
        System.out.println(itemList);
    	
		for(String device: itemList){
			System.out.println("device:::::::::"+device);
			Status t = new Status();
			t=getatestcase(device,testcase);
        	statuslist.add(t);
		}
		
		return statuslist;
    }
    
    
    
    @GET
    @Path("/getatestcase/{device}/{testcase}")
    @Produces(MediaType.APPLICATION_JSON)
    public Status getatestcase(@PathParam("device") String device, @PathParam("testcase") String testcase) throws IOException, InterruptedException{
    	  
    	long startTime = System.currentTimeMillis();
    	Date date1 = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
    	String formattedDate = sdf.format(date1);
    	System.out.println(formattedDate);
    	
    	String firstWord="";
    	if(testcase.contains(" ")){
    		   firstWord= testcase.substring(0, testcase.indexOf(" ")); 
    		}
    	String path = LOGS+firstWord+formattedDate+".txt";
    	if(testcase.equals("Text Messaging")){
    		
    	}
    	else{
    	SampleJavaTest.startAppiumServer(APPIUMSERVERSTARTUID+device+"  --log "+path);
    	}
    	StringBuffer buffer = new StringBuffer("");
    	String test="";
    	String status="";
    	String errormsg=" ";
        Thread.sleep(2000);
    	System.out.println("Device Id: "+device);
    	System.out.println("Device Model: "+SampleJavaTest.getDeviceParameters(device));
    	TestcaseDao td = new TestcaseDao();
    	if(testcase.equals("Trillian Instant Messaging")){
    		if(SampleJavaTest.getDeviceBrand(device).equals("motorola")){
    		test=SampleJavaTest.javaShellScript(MainSCRIPT+" SendingMotogMessages.java"+" com.test.SendingMotogMessages");
    		}else{
    			test=SampleJavaTest.javaShellScript(MainSCRIPT+" SendingMessages.java"+" com.test.SendingMessages");
    		}    		
    	}
        if(testcase.equals("Text Messaging")){
        	System.out.println("sdkjdssdkkjds"+path);
        	test=SampleJavaTest.javaShellScript("/home/miwcb/junitdir/scripts/./textmessages.sh "+device+" > "+path);
        //	test=SampleJavaTest.javaShellScript("/home/saisreem/.npm-packages/lib/node_modules/appium/bin/./textmessages.sh "+device+" > "+path);
    		//test= "/home/miwcb/junitdir/scripts/./textMessages.sh ";
        	//test= "/home/miwcb/junitdir/scripts/./textMessages.sh ";
        	//getalltexttestcases();
    	}
        if(testcase.equals("MMS")){
        	if(SampleJavaTest.getDeviceBrand(device).equals("motorola")){
        		test=SampleJavaTest.javaShellScript(MainSCRIPT+" mmstest_motog.java"+" com.test.mmstest_motog");
        		//*************
        		
        	}else{
        	test=SampleJavaTest.javaShellScript(MainSCRIPT+" mmstest_samsungs4.java"+" com.test.mmstest_samsungs4");
        	}}
        if(testcase.equals("Visual voice mail")){
        	test=SampleJavaTest.javaShellScript(MainSCRIPT+" visualvoicemail_samsungs4.java"+" com.test.visualvoicemail_samsungs4");	
    	}
        if(testcase.equals("Youtube with Signin")){
        	test=SampleJavaTest.javaShellScript(MainSCRIPT+" YoutubeNewVersion.java"+" com.test.YoutubeNewVersion");
        }
        if(testcase.equals("Youtube without Signin")){
        	if(SampleJavaTest.getDeviceBrand(device).equals("motorola")){
        		test=SampleJavaTest.javaShellScript(MainSCRIPT+" youtube_motog.java"+" com.test.youtube_motog");
        	}else{
        		test=SampleJavaTest.javaShellScript(MainSCRIPT+" youtube_samsungs4.java"+" com.test.youtube_samsungs4");	
        	}
        }
        if(testcase.equals("Direct TV")){
        	System.out.println("inside direct tv");
        	test=SampleJavaTest.javaShellScript(MainSCRIPT+" Directtv.java"+" com.test.Directtv");
        System.out.println("end directtv");
        }
        if(testcase.equals("Yahoo Mail")){
        	test=SampleJavaTest.javaShellScript(MainSCRIPT+" Yahoomailsend_Samsungs4.java"+" com.test.Yahoomailsend_Samsungs4");
        }
        if(testcase.equals("Yahoo IM")){
        	test=SampleJavaTest.javaShellScript(MainSCRIPT+" YahooIM.java"+" com.test.YahooIM");
        }
       
    	/*if(device.equals("TA93304LE5")){
    	test=SampleJavaTest.javaShellScript(JAVAMSCRIPT);
    	}
    	else{
    		System.out.println("inside::::::::::::::::::::");
        test=SampleJavaTest.javaShellScript(JAVASCRIPT);
    	}*/
        if(testcase.equals("Text Messaging")){
        	
        }else{
    	SampleJavaTest.stopAppiumServer();
        }
    	long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    String time= String.valueOf(elapsedTime);
    	String buffstring = buffer.toString();
    	buffer.append("device:"+device+"\n");
    	buffer.append("device model:"+SampleJavaTest.getDeviceParameters(device)+"\n");
    			buffer.append(test+"\n");
    			if(testcase.equals("Text Messaging")){
    				if(buffer.toString().contains("Starting: Intent")){
    	    			status="Pass";
    	    		}if(buffer.toString().contains("Error")){
    	    			System.out.println("fail:::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    	    			status="Fail";
    	    			errormsg=(buffer.toString());	
    	        		//System.out.println("error message:"+errormsg);
    	    		}
    			
    			}else{
    		if(buffer.indexOf("PASS")>0){
    			status="Pass";
    		}if(buffer.indexOf("FAIL")>0){
    			System.out.println("fail:::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    			status="Fail";
    			errormsg="t"+(buffer.toString().substring(buffer.toString().lastIndexOf("test(")+1));	
        		//System.out.println("error message:"+errormsg);
    		}
    			}
    		Status st = new Status();
    		st.setDevice(device);
    		st.setStatus(status);
    		if(status.equals("Pass")){
    			
    		}else{
    			status="Fail";
    		}
    		st.setUserid("saipm");
    		st.setTestcase(testcase);
    		st.setLogpath(path);
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		Date date = new Date();
    		System.out.println(dateFormat.format(date));
    		st.setDate(dateFormat.format(date));
    		st.setTime(time);
    		if(errormsg.length()>200)
    		st.setErrormsg(errormsg.substring(0, 200));
    		else
    			st.setErrormsg(errormsg);
    		 
    	td.insertTestcase("saipm", device,testcase, status, errormsg,dateFormat.format(date),time,path);
    	//return buffer.toString();
    		return st;
   } 
    @GET
    @Path("/upload/{device}/{file}")
    @Produces(MediaType.APPLICATION_JSON)
    public String uploadFile(@PathParam("device") String device, @PathParam("file") String file){
    	
    	file = file.replaceAll("aaa","/");
    	System.out.println("sddsd"+device);
    	System.out.println("jdshdhffd"+file);
    	 StringBuffer buffer = new StringBuffer("output:");
	String command = "adb -s "+device+" push "+file+"  /sdcard/Download/";
	System.out.println("install::::"+command);
	String line1 = "";
	List<Device> dlist = new ArrayList<Device>();
	Process p;
	try {
		p = Runtime.getRuntime().exec(command);
		p.waitFor();
		String line="";
		List<String> deviceList = new ArrayList<String>();
		BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
    	while ((line1 = rd.readLine()) != null) {
		System.out.println(line1);
		buffer.append(line1 + "\n");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return buffer.toString();
   }  

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Testcase> getAlltestsInJSON() throws SQLException {
    	
    	System.out.println("Test cases");
    	String command = "adb devices";
		List<Testcase> dlist = new ArrayList<Testcase>();
		org.codehaus.jettison.json.JSONObject finalObject = new org.codehaus.jettison.json.JSONObject();
		dlist=TestcaseDao.getTestcases();
    	return dlist;
    }
    
    @GET
    @Path("/getdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Testcase> getTestcases() throws SQLException {
    	
    	System.out.println("Test cases");
    	//String command = "adb devices";
		List<Testcase> dlist = new ArrayList<Testcase>();
		//org.codehaus.jettison.json.JSONObject finalObject = new org.codehaus.jettison.json.JSONObject();
		dlist=TestcaseDao.getallTestcases();
    	return dlist;
    }
    
    @GET
    @Path("/getusertype/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserType(@PathParam("name") String name) throws SQLException {
    	
    	System.out.println("Test cases");
    	//String command = "adb devices";
         String dlist = TestcaseDao.checkuser(name);
		//org.codehaus.jettison.json.JSONObject finalObject = new org.codehaus.jettison.json.JSONObject();
		//dlist=TestcaseDao.getallTestcases();
    	return dlist;
    }
    
    @GET
    @Path("/apps/{device}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<App> getAllAppsInJSON(@PathParam("device") String device) {
    	
    	System.out.println("adb -s TA93304LE5 shell pm list packages -3");
    	String command = "adb -s "+device+" shell pm list packages -3";
		List<App> dlist = new ArrayList<App>();
		org.codehaus.jettison.json.JSONObject finalObject = new org.codehaus.jettison.json.JSONObject();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			String line="";
			List<String> deviceList = new ArrayList<String>();
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				 deviceList.add(line.split(":")[1]);
				}
			for(String app: deviceList)
			{
				App ap = new App();
				ap.setApp(app);
				ap.setDevice(device);
			    dlist.add(ap);
			}
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return dlist;
    }
    
    @GET
    @Path("/command/{cName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Data> runCommand(@PathParam("cName") String deviceId) {	
    	String command="adb -s "+deviceId+ " shell getprop";
    	System.out.println("command:::"+command);
    	List<Data> data = new ArrayList<Data>();
		List<String> deviceList = new ArrayList<String>();
		Data d = new Data();
	   Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			String line1="";
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	while ((line1 = rd.readLine()) != null) {
	    		deviceList.add(line1);
			}
	    	for (String device : deviceList) {
				System.out.println(device);
				if(device.contains("model")||device.contains("version.sdk")||device.contains("manufacturer")
						||device.contains("hardware")||device.contains("platform")
						||device.contains("revision")||device.contains("product.name")
						||device.contains("brand")){
					device = device.replace("[", "").replace("]", "").replace("ro.", "");
				Data d1 = new Data();
				d1.setData(device);
			    data.add(d1);
			}
	    	}
	    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return data;
    }
    
    @GET
    @Path("/memory/{cName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<App> Memory(@PathParam("cName") String deviceId) {	
    	String command="adb -s "+deviceId+ " shell cat /proc/meminfo";
    	System.out.println("command:::"+command);
    	List<App> data = new ArrayList<App>();
		List<String> deviceList = new ArrayList<String>();
		App d = new App();
	   Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			String line="",line1="",line2="";
			String[] temp;
			String delimiter="\\s+";
			int i=0;
			BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	while ((line = rd.readLine()) != null) {
	    		if(i<4){
	    		line = line.replace(":", " ");
	    		temp=line.split(delimiter);
	    		line1 = temp[0];
	    		line2= temp[1];
				App a = new App();
				a.setDevice(line1);
				a.setApp(line2);
			    data.add(a);
	    		}else
	    			break;
	    		i++;
			}
	    	for(App a1: data){
	    		System.out.println(a1.getDevice()+"   "+a1.getApp());
	    	}
	    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return data;
    }
    
    @GET
    @Path("/memoryperapp/{cName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<App> MemoryPerApp(@PathParam("cName") String deviceId) {
    	//List<App> app = 
    	String command="adb -s "+deviceId+ " shell dumpsys meminfo| grep com.";
    	System.out.println("command:::"+command);
    	List<App> data = new ArrayList<App>();
		List<String> deviceList = new ArrayList<String>();
		App d = new App();
	   Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			String line="",line1="",line2="";
			String[] temp;
			String delimiter="kB:";
			Set<String> hs = new HashSet<>();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	while ((line = rd.readLine()) != null) {
	    		line=line.trim();
	    		deviceList.add(line);	
			}
	    	hs.addAll(deviceList);
	    	deviceList.clear();
	    	deviceList.addAll(hs);
	    	for(String dnew : deviceList){
	    	//	line = line.replace(":", " ");
	    		temp=dnew.split(delimiter);
	    	/*	System.out.println("temp[0]::::"+temp[0]);
	    		System.out.println("temp[1]::::"+temp[1]);*/
	    		line1 = temp[0].trim();
	    		line2= temp[1];
				App a = new App();a.setDevice(line1);a.setApp(line2);
			    data.add(a);
	    	}
	    	
	    	/*for(App a1: data){
	    		System.out.println(a1.getDevice()+"   "+a1.getApp());
	    	}*/
	    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return data;
    }
    
    
    
/*    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<App> getAppsInJSON(@PathParam("device") String device)) {
    	
    	System.out.println("adb -s TA93304LE5 shell pm list packages -3");
    	//String command = "adb -s "+device+" shell pm list packages -3";
		List<App> dlist = new ArrayList<App>();
		List<App> dlist1 = new ArrayList<App>();
		List<Device> devices = new ArrayList<Device>();
		DeviceRestService ds = new DeviceRestService((DeviceService) deviceService);
		devices = ds.getAllUsersInJSON();
		
		
		for(int i=0; i<devices.size();i++){
			System.out.println("i:::"+i);
			System.out.println("size:::"+devices.size());
			Device d=devices.get(i);
			String dname=d.getDevice();
			dlist= ds.getAllAppsInJSON(dname);
			dlist1.addAll(dlist);
		}	
    	return dlist1;
    }
    */
    
   
    
    @GET
    @Path("/battery/{device}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getbatteryinfo(@PathParam("device") String device) {
    	
    	System.out.println("adb -s TA93304LE5 shell dumpsys battery");
    	String command = "adb -s "+device+" shell dumpsys battery";
		List<App> dlist = new ArrayList<App>();String line1="";
		org.codehaus.jettison.json.JSONObject finalObject = new org.codehaus.jettison.json.JSONObject();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			
			List<String> deviceList = new ArrayList<String>();
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line1 = input.readLine()) != null) {
				 System.out.println(line1+":::::line1");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return line1;
    }

    @GET
    @Path("/run/{device}/{file}")
   // @Produces(MediaType.APPLICATION_JSON)
    public String RunApp(@PathParam("device") String device, @PathParam("file") String file){
    	//adb -s TA93304LE5 shell monkey -p com.whatsapp -c android.intent.category.LAUNCHER 1
	String command = "adb -s "+device+" shell monkey -p "+file+" -c android.intent.category.LAUNCHER 1";
	System.out.println("install::::"+command);
	String line1 = "";
	List<Device> dlist = new ArrayList<Device>();
	Process p;
	StringBuffer buffer = new StringBuffer("output:");
	try {
		p = Runtime.getRuntime().exec(command);
		p.waitFor();
		String line=""; 
		List<String> deviceList = new ArrayList<String>();
		BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
    	while ((line1 = rd.readLine()) != null) {
		//System.out.println("dfjjfjfjgjj"+line1);
		buffer.append(line1 + "\n");
		
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return buffer.toString();
   }  
    
    
    @GET
    @Path("/uninstall/{device}/{file}")
    //@Produces(MediaType.APPLICATION_JSON)
    public String UnInstallApp(@PathParam("device") String device, @PathParam("file") String file){
    	//adb -s TA93304LE5 shell monkey -p com.whatsapp -c android.intent.category.LAUNCHER 1
	//String command = "adb -s "+device+" shell am start -a android.intent.action.DELETE -d "+ file;
    	String command= "adb -s "+device+" shell pm uninstall "+file;
	System.out.println("install::::"+command);
	String line1 = "";
	List<Device> dlist = new ArrayList<Device>();
	Process p;
	StringBuffer buffer = new StringBuffer("output:");
	try {
		p = Runtime.getRuntime().exec(command);
		p.waitFor();
		String line=""; 
		List<String> deviceList = new ArrayList<String>();
		BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
    	while ((line1 = rd.readLine()) != null) {
		//System.out.println("dfjjfjfjgjj"+line1);
		buffer.append(line1 + "\n");
		
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return buffer.toString();
   }  
    
    

  /*  @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device getDeviceById(@PathParam("id") int id) {
        return deviceService.getById(id);
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Testcase create(Testcase testcase) {
        return testcaseService.createNewTestcase(testcase);
    }

  /*  @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Device update(Device device) {
        return deviceService.update(device);
    }*/
    
    @PUT
    @Path("{id}")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Device update(Device device) {
    	System.out.println("update::::::::");
    	System.out.println("device::::"+device.getDevice());
    	return device;
        //return deviceService.update(device);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") String id) {
        testcaseService.remove(id);
    }
}
