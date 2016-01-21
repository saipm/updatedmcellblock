    package ngdemo.web.rest;  
      
    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.PreparedStatement;  
    import java.sql.ResultSet;  
    import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ngdemo.domain.Category;
import ngdemo.domain.Dept;
import ngdemo.domain.Designation;
import ngdemo.domain.Group;
import ngdemo.domain.Status;
import ngdemo.domain.Testcase;
import ngdemo.domain.User;  
      
    public class CreateDao {  
        public static boolean validate(String name, String pass) {          
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs = null;  
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
            String driver = "com.mysql.jdbc.Driver";  
            String userName = "root";  
            String password = "password";  
            try {  
            	System.out.println("connected");
                Class.forName(driver).newInstance();  
                conn = DriverManager  
                        .getConnection(url + dbName, userName, password);  
      
                pst = conn  
                        .prepareStatement("select * from login where userid=? and password=?");  
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
        
        
         
        public static List<Dept> getDepartmentData() {   
   		 int count=0;
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs=null;
            List<Dept> depts= new ArrayList<Dept>();
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
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
                
                pst=conn.prepareStatement("Select * from ParamDept");
                rs = pst.executeQuery();  
                while(rs.next()){
               	 Dept d = new Dept();
               	 d.setDeptId(rs.getString("ParDeptPre"));
               	 d.setDeptName(rs.getString("ParDeptName"));
               	 depts.add(d);
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
            return depts;  
        } 
        
        
        
        public static List<Designation> getDesigData() {   
   		 int count=0;
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs=null;
            List<Designation> depts= new ArrayList<Designation>();
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
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
                
                pst=conn.prepareStatement("Select * from ParamDesignation");
                rs = pst.executeQuery();  
                while(rs.next()){
               	 Designation d = new Designation();
               	 d.setId(rs.getString("ParDesigPre"));
               	 d.setName(rs.getString("ParDesigName"));
               	 depts.add(d);
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
            return depts;  
        } 
    
        public static List<Category> getCategoryData() {   
   		 int count=0;
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs=null;
            List<Category> depts= new ArrayList<Category>();
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
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
                
                pst=conn.prepareStatement("Select * from ParamUserCat");
                rs = pst.executeQuery();  
                while(rs.next()){
               	 Category d = new Category();
               	 d.setId(rs.getString("ParCatPre"));
               	 d.setName(rs.getString("ParCatName"));
               	 depts.add(d);
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
            return depts;  
        } 
    

        public static List<Group> getGroupData() {   
   		 int count=0;
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs=null;
            List<Group> depts= new ArrayList<Group>();
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
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
                
                pst=conn.prepareStatement("Select * from ParamUserGrp");
                rs = pst.executeQuery();  
                while(rs.next()){
               	 Group d = new Group();
               	 d.setId(rs.getString("ParUsrGrpId"));
               	 d.setName(rs.getString("ParUsrGrpName"));
               	 depts.add(d);
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
            return depts;  
        } 
        

        public static List<Testcase> getTestData() {   
   		 int count=0;
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs=null;
            List<Testcase> depts= new ArrayList<Testcase>();
      
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
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
                
                pst=conn.prepareStatement("Select * from ParamTest");
                rs = pst.executeQuery();  
                while(rs.next()){
               	 Testcase d = new Testcase();
               	 d.setId(rs.getString("ParTestId"));
               	 d.setTestcase(rs.getString("ParTestName"));
               	 d.setPath(rs.getString("ParTstExePath"));
               	 depts.add(d);
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
            return depts;  
        } 
        
        
        public static List<User> getUserData() {   
      		 int count=0;
               boolean status = false;  
               Connection conn = null;  
               PreparedStatement pst = null;  
               ResultSet rs=null;
               List<User> depts= new ArrayList<User>();
         
               String url = "jdbc:mysql://localhost:3306/";  
               String dbName = "mcellblock";  
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
                   
                   pst=conn.prepareStatement("Select * from MastUserProfile");
                   rs = pst.executeQuery();  
                   while(rs.next()){
                  	 User d = new User();
                  	 d.setId(rs.getString("MstUID"));
                  	 d.setName(rs.getString("MstName"));
                  	 d.setDesigid(rs.getString("MstDesigPre"));
                  	 d.setDeptId(rs.getString("MstDeptPre"));
                  	 d.setGroup(rs.getString("MastUsrGrpId"));
                  	 d.setLoginid(rs.getString("MstLoginId"));
                  	 d.setPassword(rs.getString("MstPassword"));
                  	 depts.add(d);
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
               return depts;  
           } 
           
        
        public static User geteditParsedData(String uid) {   
     		 int count=0;
              boolean status = false;  
              Connection conn = null;  
              PreparedStatement pst = null;  
              ResultSet rs=null;
              List<User> depts= new ArrayList<User>();
        
              String url = "jdbc:mysql://localhost:3306/";  
              String dbName = "mcellblock";  
              String driver = "com.mysql.jdbc.Driver";  
              String userName = "root";  
              String password = "password";  
              User d = new User();
              try {  
                  Class.forName(driver).newInstance();  
                  conn = DriverManager  
                          .getConnection(url + dbName, userName, password);  
        
            
                  
                  pst=conn.prepareStatement(""
                  		+ "select ParamDesignation.ParDesigName,ParamDept.ParDeptName,ParamUserGrp.ParUsrGrpName,ParamUserCat.ParCatName from "+
"MastUserProfile Inner Join ParamDesignation on MastUserProfile.MstDesigPre=ParamDesignation.ParDesigPre "+
"Inner Join ParamDept on MastUserProfile.MstDeptPre=ParamDept.ParDeptPre "+
"Inner Join ParamUserGrp on MastUserProfile.MastUsrGrpID=ParamUserGrp.ParUsrGrpId "+
"Inner Join ParamUserCat on left(MastUserProfile.MstUID,2)=ParamUserCat.ParCatPre where MastUserProfile.MstUID= ?");
                  pst.setString(1, uid);
                  rs = pst.executeQuery(); 
                 
                  while(rs.next()){
                 	
                 	 d.setDesigid(rs.getString(1));
                 	 d.setDeptId(rs.getString(2));
                 	 d.setGroup(rs.getString(3));
                 	 d.setRole(rs.getString(4));
                 	// depts.add(d);
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
        
        public static int getlastnum(String category) {   
      		 int count=0;
               boolean status = false;  
               Connection conn = null;  
               PreparedStatement pst = null;  
               ResultSet rs=null;
               List<Category> depts= new ArrayList<Category>();
               Category d = new Category();
         
               String url = "jdbc:mysql://localhost:3306/";  
               String dbName = "mcellblock";  
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
                   
                   pst=conn.prepareStatement("Select ParLastNum from ParamUserCat where ParCatPre=?");
                   pst.setString(1, category);
                   rs = pst.executeQuery();  
                   if(rs.next()){
                  	 d.setLastnum((rs.getInt(1)));
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
               return d.getLastnum();  
           } 
        
        public static int updatelastnum(String Category) {   
     		 int count=0;
              boolean status = false;  
              Connection conn = null;  
              PreparedStatement pst = null;  
              ResultSet rs=null;
              List<Category> depts= new ArrayList<Category>();
              Category d = new Category();
        
              String url = "jdbc:mysql://localhost:3306/";  
              String dbName = "mcellblock";  
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
                  
                  pst=conn.prepareStatement("UPDATE ParamUserCat SET ParLastNum = ParLastNum + 1 WHERE ParCatPre = ?;");
                  pst.setString(1, Category);
                  count = pst.executeUpdate();  
                  /*if(rs.next()){
                 	 d.setLastnum((rs.getInt(1)));
                  }*/
        
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
        
        public static int insert(String name, String role, String desig, String dept, String testcases) {          
            boolean status = false;  
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

        		String insertTableSQL = "INSERT INTO MastUserProfile"
        				+ "(MstUID, MstName, MstDesigPre, MstDeptPre, MstTestStatus) VALUES"
        				+ "(?,?,?,?,?)";
                pst = conn  
                        .prepareStatement(insertTableSQL);  
                pst.setString(1, role);  
                pst.setString(2, name);  
                pst.setString(3, desig);  
                pst.setString(4, dept); 
                pst.setString(5, testcases);
                System.out.println("hereeeeeeeeeeeeeeeeeeeeeeee");
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
        
        
        public static int insertData(String Uid,String name, String id, String passwordnew, String desig, String dept,String group) {          
            boolean status = false;  
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

        		String insertTableSQL = "INSERT INTO MastUserProfile"
        				+ "(MstUID, MstName, MstDesigPre, MstDeptPre, MastUsrGrpID,MstPassword,MstLoginId) VALUES"
        				+ "(?,?,?,?,?,?,?)";
                pst = conn  
                        .prepareStatement(insertTableSQL);  
                pst.setString(1, Uid);  
                pst.setString(2, name);  
                pst.setString(3, desig);  
                pst.setString(4, dept); 
                pst.setString(5, group);
                pst.setString(6, passwordnew);
                pst.setString(7, id);
                System.out.println("hereeeeeeeeeeeeeeeeeeeeeeee");
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
        
        public static int updateData(String Uid,String name, String id, String passwordnew, String desig, String dept,String group) {          
            boolean status = false;  
            Connection conn = null;  
            PreparedStatement pst = null;  
            ResultSet rs = null;  
            int i=0;
           System.out.println(Uid);
           System.out.println(name);
           System.out.println(id);
           System.out.println(passwordnew);
           System.out.println(desig);
           System.out.println(dept);
           System.out.println(group);
           
            String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "mcellblock";  
            String driver = "com.mysql.jdbc.Driver";  
            String userName = "root";  
            String password = "password";  
            try {  
                Class.forName(driver).newInstance();  
                conn = DriverManager  
                        .getConnection(url + dbName, userName, password);  

        		String insertTableSQL = "UPDATE MastUserProfile"
        				+ " SET MstName = ?, MstDesigPre = ?, MstDeptPre = ?, MastUsrGrpID = ?,MstPassword = ?,MstLoginId = ? "
        				+ "where MstUID = ?";
                pst = conn  
                        .prepareStatement(insertTableSQL);  
                pst.setString(7, Uid);  
                pst.setString(1, name);  
                pst.setString(2, desig);  
                pst.setString(3, dept); 
                pst.setString(4, group);
                pst.setString(5, passwordnew);
                pst.setString(6, id);
                System.out.println("Updating MasterUserProfile............................");
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
        public static int insertFunctions(String UID, String testcases, String dashboard) {          
            boolean status = false;  
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

        		String insertTableSQL = "INSERT INTO MastUserTrans"
        				+ "(MstUID, MstTestID, MstDashID) VALUES"
        				+ "(?,?,?)";
                pst = conn  
                        .prepareStatement(insertTableSQL);  
                pst.setString(1, UID);  
                pst.setString(2, testcases);  
                pst.setString(3, dashboard);  
             //   pst.setString(4, dept);  
                System.out.println("hereeeeeeeeeeeeeeeeeeeeeeee");
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
        
        
        
    }  
        
      