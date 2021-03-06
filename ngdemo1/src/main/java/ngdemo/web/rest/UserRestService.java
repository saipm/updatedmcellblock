package ngdemo.web.rest;

import com.google.inject.Inject;
import ngdemo.domain.User;
import ngdemo.domain.Category;
import ngdemo.domain.Dept;
import ngdemo.domain.Designation;
import ngdemo.domain.Group;
import ngdemo.domain.Testcase;
import ngdemo.service.contract.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/users")
public class UserRestService {

    private final UserService userService;

    @Inject
    public UserRestService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("numberOfUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNumberOfUsers() {
        return userService.getNumberOfUsers();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        users=CreateDao.getUserData();
        return users;
    }

   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") String id) {
        return userService.getById(id);
    }
    
    /*  Rest api for User Profiles
     * -----------------------------------------------------------------------------------------------*/
    
    @GET
    @Path("/edit/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserEditdata(@PathParam("id") String id) {
    	User user = new User();
    	System.out.println("id::::::::"+id);
    	user= CreateDao.geteditParsedData(id);
    	return user;
        //return userService.getById(id);
    }
    
    @GET
    @Path("/create/{name}/{role}/{desig}/{dept}/{testcases}/{dashboard}/{mytestcases}")
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(@PathParam("name") String id1, @PathParam("role") String id2, @PathParam("desig") String id3,
    		@PathParam("dept") String id4, @PathParam("testcases") String testcases, @PathParam("dashboard") String dashboard,
    		@PathParam("mytestcases") List<String> mytestcases) {
       CreateDao cd = new CreateDao();
       for(String test:mytestcases){
    	   System.out.println("inside testcases:::"+test);
    	   
    	   //System.out.println(test.split(":")[0]);
       }
       int lastNum = CreateDao.getlastnum(id2)+1;
       int length = String.valueOf(lastNum).length();
       int lengthdiff= 6-length;
       String UserId=null;
       String appendZero="";
       if(lengthdiff==0){
    	   UserId=id2+lastNum;
       }
       else{
    	   for(;(lengthdiff>0);lengthdiff--){
    		   appendZero+="0";
    	   }
       UserId=id2+appendZero+lastNum;
       
       }
       int i=CreateDao.insert(id1, UserId, id3, id4,testcases);   
     if(i==1){
    	 CreateDao.updatelastnum(id2);
    	 CreateDao.insertFunctions(UserId, testcases, dashboard);
    	 System.out.println("user created Succesfully");
    	 return "User created succesfully  "+UserId;
     }
     return "User creation failed";
    }
    
  
    @GET
    @Path("/createuser/{name}/{id}/{password}/{type}/{desig}/{dept}/{group}")
    @Produces(MediaType.APPLICATION_JSON)
    public String createUserProfile(@PathParam("name") String name, @PathParam("id") String id, @PathParam("password") String password,
    		@PathParam("type") String type, @PathParam("desig") String desig, @PathParam("dept") String dept,
    		@PathParam("group") String group) {
       CreateDao cd = new CreateDao();
       
       int lastNum = CreateDao.getlastnum(type)+1;
       int length = String.valueOf(lastNum).length();
       int lengthdiff= 6-length;
       String UserId=null;
       String appendZero="";
       System.out.println("test"+type);
       if(lengthdiff==0){
    	   UserId=type+lastNum;
       }
       else{
    	   for(;(lengthdiff>0);lengthdiff--){
    		   appendZero+="0";
    	   }
       UserId=type+appendZero+lastNum;
       
       }
       int i=CreateDao.insertData(UserId, name, id, password, desig, dept, group);   
     if(i==1){
    	 CreateDao.updatelastnum(type);
    	 //CreateDao.insertFunctions(UserId, testcases, dashboard);
    	 System.out.println("user created Succesfully");
    	 return null;
     }
     return null;
    }
    
    @GET
    @Path("/edituser/{uid}/{name}/{id}/{password}/{type}/{desig}/{dept}/{group}")
    @Produces(MediaType.APPLICATION_JSON)
    public String createUserProfile(@PathParam("uid") String uid,@PathParam("name") String name, @PathParam("id") String id, @PathParam("password") String password,
    		@PathParam("type") String type, @PathParam("desig") String desig, @PathParam("dept") String dept,
    		@PathParam("group") String group) {
       CreateDao cd = new CreateDao();
       System.out.println("popoooiooooooooooooooooooooooooooooooooooooooooooo");
       int i=CreateDao.updateData(uid, name, id, password, desig, dept, group);   
     if(i==1){
    	// CreateDao.updatelastnum(type);
    	 System.out.println("user created Succesfully");
    	 return uid+ "User updated successfully";
     }
     return "Error in updating user "+uid;
    }
   
    /*  User Profiles end
     * -----------------------------------------------------------------------------------------------*/
    
    @GET
    @Path("/edittest/{id}")
   // @Produces(MediaType.APPLICATION_JSON)
    public String getgrouptests(@PathParam("id") String id) {
    	List<Testcase> tc= new ArrayList<Testcase>();
    	String jsonstr="";
    	tc=GroupDAO.getGrouptests(id);
    	for(Testcase t:tc){
    		//System.out.println(t.getId());
    		//System.out.println(t.getTestcase());
    		jsonstr=jsonstr+"\""+t.getId()+"\""+":"+"\""+t.getTestcase()+"\""+",";
    	}
    	if(jsonstr.length()>1)
    	jsonstr=jsonstr.substring(0,jsonstr.length()-1);
    	System.out.println(jsonstr);
    	return jsonstr;
    }
    
    @GET
    @Path("/addtestcase/{id}/{list}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addtestcase(@PathParam("id") String id,@PathParam("list") List<String> list) {
    	String slist="";
    	for(String s:list){
    		slist=s;
    		}
    	List<Integer> numberList = new ArrayList<Integer>();
    	
    	List<String> elephantList = Arrays.asList(slist.split(","));
    	for(String number : elephantList) {
    		   numberList.add(Integer.parseInt(number)); 
    		}
     for(int i : numberList){
    	int x= CategoryDAO.insertgrouptests(id, i);
     }
    		return null;
    }
    
    @GET
    @Path("/deletetestcase/{id}/{list}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletetestcase(@PathParam("id") String id,@PathParam("list") List<String> list) {
    	String slist="";
    	for(String s:list){
    		slist=s;
    		}
    	List<Integer> numberList = new ArrayList<Integer>();
    	
    	List<String> elephantList = Arrays.asList(slist.split(","));
    	for(String number : elephantList) {
    		   numberList.add(Integer.parseInt(number)); 
    		}
     for(int i : numberList){
    	int x= CategoryDAO.deletegrouptests(id, i);
     }
    		return null;
    }
    
    
    @GET
    @Path("/testspresent/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Testcase> getpresenttests(@PathParam("id") String id) {
    	TestDAO cd = new TestDAO();
    	//System.out.println("dfjjdfjdfjfjkfdjdfjfdjkkdfkjfdjkfdkjdfkjfdkj");
    	List<Testcase> d = new ArrayList<Testcase>();
    	d=TestDAO.getTestData(id);
    	return d;
    }
    
    @GET
    @Path("/testsnotpresent/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Testcase> getnotpresenttests(@PathParam("id") String id) {
    	TestDAO cd = new TestDAO();
    	//System.out.println("dfjjdfjdfjfjkfdjdfjfdjkkdfkjfdjkfdkjdfkjfdkj");
    	List<Testcase> d = new ArrayList<Testcase>();
    	d=TestDAO.getNotTestData(id);
    	return d;
    }
    
    /*  Rest api for Departments
     * -----------------------------------------------------------------------------------------------*/
    
    
    @GET
    @Path("/depts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dept> getDepts() {
    	CreateDao cd = new CreateDao();
    	List<Dept> d = new ArrayList<Dept>();
    	d=CreateDao.getDepartmentData();
    	return d;
    }
    
    @GET
    @Path("/depts/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertDepts(@PathParam("id") String id,@PathParam("name") String name) {
    	int i=DepartmentDAO.insertFunctions(id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    
    @GET
    @Path("/depts/{id}/{name}/{previd}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateDepts(@PathParam("id") String id,@PathParam("name") String name,@PathParam("previd") String previd) {
    	int i=DepartmentDAO.update(previd,id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/depts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteDepts(@PathParam("id") String id) {
    	int i=DepartmentDAO.delete(id);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    
    @GET
    @Path("/depts/checkid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int ValidatedeptId(@PathParam("id") String id) {
    	int i=DepartmentDAO.validateDeptName(id);
    	System.out.println("i::::::::::::::"+i);
    	return i;
    }
    
    /*  Departments end
     * -----------------------------------------------------------------------------------------------*/
    
    @GET
    @Path("/profiles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteUsers(@PathParam("id") String id) {
    	int i=CategoryDAO.deleteUserProfile(id);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    
    /*  Rest api for Designations 
     * -----------------------------------------------------------------------------------------------*/
    
    @GET
    @Path("/designations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Designation> getDesignations() {
    	CreateDao cd = new CreateDao();
    	List<Designation> d = new ArrayList<Designation>();
    	d=CreateDao.getDesigData();
    	return d;
    }

    
    @GET
    @Path("/designations/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertDesigs(@PathParam("id") String id,@PathParam("name") String name) {
    	int i=DesignationDAO.insertFunctions(id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/designations/{id}/{name}/{previd}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateDesigs(@PathParam("id") String id,@PathParam("name") String name,@PathParam("previd") String previd) {
    	int i=DesignationDAO.update(previd,id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/designations/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteDesigs(@PathParam("id") String id) {
    	int i=DesignationDAO.delete(id);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    
    @GET
    @Path("/designations/checkid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int ValidateDesignationId(@PathParam("id") String id) {
    	int i=DesignationDAO.validateDesignationName(id);
    	System.out.println("i::::::::::::::"+i);
    	return i;
    }
    
    /*  Designations End 
     * ---------------------------------------------------------------------------------------------*/
  
    /*  Rest api for User Categories/Roles 
     * -----------------------------------------------------------------------------------------------*/
    
    @GET
    @Path("/roles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getRoles() {
    	CreateDao cd = new CreateDao();
    	List<Category> d = new ArrayList<Category>();
    	d=CreateDao.getCategoryData();
    	return d;
    }


    @GET
    @Path("/roles/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertroles(@PathParam("id") String id,@PathParam("name") String name) {
    	int i=CategoryDAO.insertFunctions(id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/roles/{id}/{name}/{previd}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateroles(@PathParam("id") String id,@PathParam("name") String name,@PathParam("previd") String previd) {
    	int i=CategoryDAO.update(previd,id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String Deleteroles(@PathParam("id") String id) {
    	int i=CategoryDAO.delete(id);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    
    @GET
    @Path("/roles/checkid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int ValidateId(@PathParam("id") String id) {
    	int i=CategoryDAO.validateCategoryName(id);
    	System.out.println("i::::::::::::::"+i);
    	return i;
    }
    
    /*  Roles/Categories End 
     * ---------------------------------------------------------------------------------------------*/
    
    /*  Rest api for Testcases
     * -----------------------------------------------------------------------------------------------*/
    
    @GET
    @Path("/testcases")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Testcase> getTestcases() {
    	CreateDao cd = new CreateDao();
    	List<Testcase> d = new ArrayList<Testcase>();
    	d=CreateDao.getTestData();
    	return d;
    }


    @GET
    @Path("/testcases/insert/{name}/{path}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserttestcases(@PathParam("name") String name,@PathParam("path") String path) {
    	int i=TestDAO.insertFunctions(name,path);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/testcases/{id}/{name}/{path}/{previd}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updatetestcases(@PathParam("id") int id,@PathParam("name") String name,@PathParam("path") String path,@PathParam("previd") int previd) {
    	int i=TestDAO.update(previd,id, name,path);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/testcases/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String Deletetestcases(@PathParam("id") int id) {
    	int i=TestDAO.delete(id);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    
    @GET
    @Path("/testcases/checkid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int ValidatetestId(@PathParam("id") String id) {
    	int i=TestDAO.validateTestName(id);
    	System.out.println("i::::::::::::::"+i);
    	return i;
    }
    
    
    /*  Testcases End 
     * ---------------------------------------------------------------------------------------------*/
    
    /*  Rest api for User Groups
     * -----------------------------------------------------------------------------------------------*/
    
    @GET
    @Path("/groups")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getGroups() {
    	CreateDao cd = new CreateDao();
    	List<Group> d = new ArrayList<Group>();
    	d=CreateDao.getGroupData();
    	return d;
    }


    @GET
    @Path("/groups/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertgroups(@PathParam("id") String id,@PathParam("name") String name) {
    	int i=GroupDAO.insertFunctions(id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/groups/{id}/{name}/{previd}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updategroups(@PathParam("id") String id,@PathParam("name") String name,@PathParam("previd") String previd) {
    	int i=GroupDAO.update(previd,id, name);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/groups/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String Deletegroups(@PathParam("id") String id) {
    	int i=GroupDAO.delete(id);
    	System.out.println("i::::::::::::::"+i);
    	if(i==1)
    	return null;
    	else
    		return null;
    }
    @GET
    @Path("/groups/checkid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int ValidategroupId(@PathParam("id") String id) {
    	int i=GroupDAO.validateGroupName(id);
    	System.out.println("i::::::::::::::"+i);
    	return i;
    }
    
    /*  User Groups End 
     * ---------------------------------------------------------------------------------------------*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return userService.createNewUser(user);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user) {
        return userService.update(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") String id) {
        userService.remove(id);
    }
}
