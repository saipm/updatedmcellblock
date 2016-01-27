    package ngdemo.web.rest;  
      
    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.PreparedStatement;  
    import java.sql.ResultSet;  
    import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ngdemo.domain.App;
import ngdemo.domain.Device;
import ngdemo.domain.Status;
import ngdemo.domain.Testcase;  
      
    public class TestcaseDao { 
    	
    	 public static List<Testcase> getTestcases() {          
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             ResultSet rs = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblocks";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement("select name from testcase_details");  
       
                 rs = pst.executeQuery();  
                 while(rs.next()){
                	 Testcase t = new Testcase();
                	 t.setTestcase(rs.getString("name"));
                	 tc.add(t);
                 }
       
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return tc;  
         } 
    	 

    	 public static List<Testcase> getallTestcases() {          
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             ResultSet rs = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblocks";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement("select * from testcase_details");  
       
                 rs = pst.executeQuery();  
                 while(rs.next()){
                	 Testcase t = new Testcase();
                	 t.setTestcase(rs.getString("name"));
                	 t.setId(rs.getString("id"));
                	 tc.add(t);
                 }
       
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return tc;  
         } 
    	 
    	 
    	 public static int getDevicesCount() {   
    		 int count=0;
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             ResultSet rs = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblocks";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement("SELECT COUNT(DISTINCT deviceid) FROM testcases");  
       
                 rs = pst.executeQuery();  
                 if (rs.next()) {
                     count= rs.getInt(1);
                     System.out.println("Count= " + count);
                   } 
       
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return count;  
         }  
    	 
    	 public static List<Integer> getTypeTestcasesCount() {   
    		 int count=0;
    		 int count1=0;
    		 int count2=0;
    		 int count3=0;
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             PreparedStatement pst1 = null;
             PreparedStatement pst2 = null; 
             PreparedStatement pst3 = null; 
             ResultSet rs = null;  
             ResultSet rs1 = null;  
             ResultSet rs2 = null;  
             ResultSet rs3 = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
             List<Integer> counts = new ArrayList<Integer>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblocks";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement("SELECT COUNT(*) FROM testcases where  testcaseid='Text Messaging';");  
                 
       
                 rs = pst.executeQuery();  
                 if (rs.next()) {
                     count= rs.getInt(1);
                     System.out.println("Count= " + count);
                   } 
                 pst1 = conn  
                         .prepareStatement("SELECT COUNT(*) FROM testcases where  testcaseid='Trillian Instant Messaging';");  
                 
       
                 rs1 = pst1.executeQuery();  
                 if (rs1.next()) {
                     count1= rs1.getInt(1);
                     System.out.println("Count= " + count1);
                   } 
                 pst2 = conn  
                         .prepareStatement("SELECT COUNT(*) FROM testcases where  error!='  ' and testcaseid='Text Messaging';");  
                 
       
                 rs2 = pst2.executeQuery();  
                 if (rs2.next()) {
                     count2= rs2.getInt(1);
                     System.out.println("Count= " + count2);
                   } 
       
                 pst3 = conn  
                         .prepareStatement("SELECT COUNT(*) FROM testcases where  error!='  ' and testcaseid='Trillian Instant Messaging';");

                 
       
                 rs3 = pst3.executeQuery();  
                 if (rs3.next()) {
                     count3= rs3.getInt(1);
                     System.out.println("Count= " + count3);
                   } 
               counts.add(count);
               counts.add(count1);
               counts.add(count2);
               counts.add(count3);
               
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return counts;  
         } 
    	 
    	 public static List<Integer> getnewTypeTestcasesCount(String testcase) {   
    		 int count=0;
    		 int count1=0;
    		 int count2=0;
    		 int count3=0;
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             PreparedStatement pst1 = null;
             PreparedStatement pst2 = null; 
             PreparedStatement pst3 = null; 
             ResultSet rs = null;  
             ResultSet rs1 = null;  
             ResultSet rs2 = null;  
             ResultSet rs3 = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
             List<Integer> counts = new ArrayList<Integer>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblock";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement("SELECT COUNT(*) FROM MastTestcaseLogs where status='Pass' and testcaseid= ? ;");  
                 
                 pst.setString(1, testcase);
                 rs = pst.executeQuery();  
                 if (rs.next()) {
                     count= rs.getInt(1);
                     System.out.println("Count= " + count);
                   } 
       
                 pst3 = conn  
                         .prepareStatement("SELECT COUNT(*) FROM MastTestcaseLogs where status='Fail' and testcaseid= ? ;");

                 pst3.setString(1, testcase);
       
                 rs3 = pst3.executeQuery();  
                 if (rs3.next()) {
                     count3= rs3.getInt(1);
                     System.out.println("Count= " + count3);
                   } 
               counts.add(count);
               counts.add(count3);
               
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return counts;  
         } 
    	 
    	 
    	 public static List<App> getDateResults(String testcase, String statustest) {   
    		 int count=0;
    		 int count1=0;
    		 int count2=0;
    		 int count3=0;
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             PreparedStatement pst1 = null;
             PreparedStatement pst2 = null; 
             PreparedStatement pst3 = null; 
             ResultSet rs = null;  
             ResultSet rs1 = null;  
             ResultSet rs2 = null;  
             ResultSet rs3 = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
             List<App> counts = new ArrayList<App>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblock";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement("SELECT left(date,10),count(*)  FROM  MastTestcaseLogs where left(date,10) between '2016/01/01' and '2016/01/30' and testcaseid= ? and status= ? group by left(date,10)");  
                 
                 pst.setString(1, testcase);
                 pst.setString(2, statustest);
                 rs = pst.executeQuery();  
                 while (rs.next()) {
                	 App app = new App();
                	 app.setApp(rs.getString(1));
                	 app.setDevice(rs.getString(2));
                     counts.add(app);
                   } 
       
                
               
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return counts;  
         } 
    	 public static int getTestcasesCount() {   
    		 int count=0;
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             ResultSet rs = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblocks";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement("SELECT COUNT(*) FROM testcases");  
       
                 rs = pst.executeQuery();  
                 if (rs.next()) {
                     count= rs.getInt(1);
                     System.out.println("Count= " + count);
                   } 
       
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return count;  
         }  
    	 public static List<Status> getSelectQueryData(String query) {   
    		 int count=0;
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             List<Status> slist = new ArrayList<Status>();
             ResultSet rs = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblocks";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 /*pst = conn  
                         .prepareStatement(" SELECT * FROM testcases where error!='  ' and testcaseid='Trillian Instant Messaging'; ");  
       */
                 pst=conn.prepareStatement(query);
                 rs = pst.executeQuery();  
                 while(rs.next()){
                	 Status s = new Status();
                	 s.setUserid(rs.getString("userid"));
                	 s.setDevice(rs.getString("deviceid"));
                	 s.setTestcase(rs.getString("testcaseid"));
                	 s.setStatus(rs.getString("status"));
                	 s.setErrormsg(rs.getString("error"));
                	 s.setDate(rs.getString("date"));
                	 s.setTime(rs.getString("time"));
                	 slist.add(s);
                 }
                /* if (rs.next()) {
                     count= rs.getInt(1);
                     System.out.println("Count= " + count);
                   } */
       
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return slist;  
         } 
    	 public static int getErrorsCount() {   
    		 int count=0;
             boolean status = false;  
             Connection conn = null;  
             PreparedStatement pst = null;  
             ResultSet rs = null;  
             List<Testcase> tc = new ArrayList<Testcase>();
       
             String url = "jdbc:mysql://localhost:3306/";  
             String dbName = "mcellblocks";  
             String driver = "com.mysql.jdbc.Driver";  
             String userName = "root";  
             String password = "password";  
             try {  
                 Class.forName(driver).newInstance();  
                 conn = DriverManager  
                         .getConnection(url + dbName, userName, password);  
       
                 pst = conn  
                         .prepareStatement(" SELECT COUNT(*) FROM testcases where error!='  '");  
       
                 rs = pst.executeQuery();  
                 if (rs.next()) {
                     count= rs.getInt(1);
                     System.out.println("Count= " + count);
                   } 
       
             } catch (Exception e) {  
                 System.out.println(e);  
             } finally {  
                 if (conn != null) {  
                     try {  
                         conn.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (pst != null) {  
                     try {  
                         pst.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
                 if (rs != null) {  
                     try {  
                         rs.close();  
                     } catch (SQLException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
             return count;  
         }  
        public static boolean validate(String name, String pass) {          
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs = null;  
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "form";  
            String driver = "com.mysql.jdbc.Driver";  
            String userName = "root";  
            String password = "password";  
            try {  
                Class.forName(driver).newInstance();  
                conn = DriverManager  
                        .getConnection(url + dbName, userName, password);  
      
                pst = conn  
                        .prepareStatement("select * from login where user=? and password=?");  
                pst.setString(1, name);  
                pst.setString(2, pass);  
      
                rs = pst.executeQuery();  
                status = rs.next();  
      
            } catch (Exception e) {  
                System.out.println(e);  
            } finally {  
                if (conn != null) {  
                    try {  
                        conn.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (pst != null) {  
                    try {  
                        pst.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (rs != null) {  
                    try {  
                        rs.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
            return status;  
        }  
        
        public static Device getDeviceDetails(String deviceId) {          
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs = null;  
            Device d = new Device();
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
            String driver = "com.mysql.jdbc.Driver";  
            String userName = "root";  
            String password = "password";  
            try {  
                Class.forName(driver).newInstance();  
                conn = DriverManager  
                        .getConnection(url + dbName, userName, password);  
      
                pst = conn  
                        .prepareStatement("select * from MastDeviceData where DeviceId = ? ");  
                pst.setString(1, deviceId);  
      
                rs = pst.executeQuery();  
                
                while(rs.next()){
                	d.setDevice(rs.getString("DeviceId"));
                	d.setModel(rs.getString("Model"));
                	d.setBrand(rs.getString("Brand"));
                	d.setVersion(rs.getString("Version"));
                	d.setStatus(rs.getString("Status"));
                }
      
            } catch (Exception e) {  
                System.out.println(e);  
            } finally {  
                if (conn != null) {  
                    try {  
                        conn.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (pst != null) {  
                    try {  
                        pst.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (rs != null) {  
                    try {  
                        rs.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
            return d;  
        }  
        
        
        
        
        
        public static int insertTestcase(String username, String deviceId, String testcase, String status, String errormsg, String date, String time, String path) {          
            //status = "";  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs = null;  
            int i=0;
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
            String driver = "com.mysql.jdbc.Driver";  
            String userName = "root";  
            String password = "password";  
            try {  
                Class.forName(driver).newInstance();  
                conn = DriverManager  
                        .getConnection(url + dbName, userName, password);  

        		String insertTableSQL = "INSERT INTO MastTestcaseLogs"
        				+ "(userid, deviceid, testcaseid, status, error,date,time,logpath) VALUES"
        				+ "(?,?,?,?,?,?,?,?)";
                pst = conn  
                        .prepareStatement(insertTableSQL);  
                pst.setString(1, username);  
                pst.setString(2, deviceId);  
                pst.setString(3, testcase);  
                pst.setString(4, status);  
                pst.setString(5, errormsg);  
                pst.setString(6, date);
                pst.setString(7, time);
                pst.setString(8, path);
                i = pst.executeUpdate(); 
                //System.out.println("i::::::"+i);
                return i; 
      
            } catch (Exception e) {  
                System.out.println(e);  
            } finally {  
                if (conn != null) {  
                    try {  
                        conn.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (pst != null) {  
                    try {  
                        pst.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (rs != null) {  
                    try {  
                        rs.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
            return i;  
        }  
        
        public static int insert(String name, String pass, String email) {          
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs = null;  
            int i=0;
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblocks";  
            String driver = "com.mysql.jdbc.Driver";  
            String userName = "root";  
            String password = "password";  
            try {  
                Class.forName(driver).newInstance();  
                conn = DriverManager  
                        .getConnection(url + dbName, userName, password);  

        		String insertTableSQL = "INSERT INTO login"
        				+ "(userid, username, password, emailaddr) VALUES"
        				+ "(?,?,?,?)";
                pst = conn  
                        .prepareStatement(insertTableSQL);  
                pst.setString(1, name);  
                pst.setString(2, name);  
                pst.setString(3, pass);  
                pst.setString(4, email);  
                i = pst.executeUpdate(); 
                System.out.println("i::::::"+i);
                return i; 
      
            } catch (Exception e) {  
                System.out.println(e);  
            } finally {  
                if (conn != null) {  
                    try {  
                        conn.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (pst != null) {  
                    try {  
                        pst.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (rs != null) {  
                    try {  
                        rs.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
            return i;  
        }  
        public static String checkuser(String name) {          
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs = null;  
            int i=0;
            String UserType="";
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
            String driver = "com.mysql.jdbc.Driver";  
            String userName = "root";  
            String password = "password";  
            try {  
                Class.forName(driver).newInstance();  
                conn = DriverManager  
                        .getConnection(url + dbName, userName, password);  

        		String insertTableSQL = "select LEFT(MstUID,2) from MastUserProfile where MstLoginId= ? ";
        				
                pst = conn  
                        .prepareStatement(insertTableSQL);  
                pst.setString(1, name);  
                
                ResultSet rs1 = pst.executeQuery(); 
                //System.out.println("i::::::"+i);
                while(rs1.next()){
                	System.out.println(rs1.getString(1));
                	UserType=rs1.getString(1);
                }
                return UserType; 
      
            } catch (Exception e) {  
                System.out.println(e);  
            } finally {  
                if (conn != null) {  
                    try {  
                        conn.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (pst != null) {  
                    try {  
                        pst.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
                if (rs != null) {  
                    try {  
                        rs.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
            return UserType;  
        }  
        
    }  