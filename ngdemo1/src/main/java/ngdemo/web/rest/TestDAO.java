package ngdemo.web.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ngdemo.domain.Testcase;

public class TestDAO {

	  
    public static int insertFunctions(String deptname, String path) {          
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

    		String insertTableSQL = "INSERT INTO ParamTest"
    				+ "(ParTestName, ParTstExePath) VALUES"
    				+ "(?,?)";
            pst = conn  
                    .prepareStatement(insertTableSQL);  
         //   pst.setInt(1, deptid);  
            pst.setString(1, deptname); 
            pst.setString(2, path);
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
    
    public static int update(int prevdeptid, int deptid, String deptname, String path) {          
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

    		String insertTableSQL = "UPDATE ParamTest SET ParTestId=?, ParTestName=?, ParTstExePath=? "
    				+ " where (ParTestId = ?)";
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setInt(1, deptid);  
            pst.setString(2, deptname);
            pst.setString(3, path);
            pst.setInt(4, prevdeptid);
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
    
    
    public static int delete(int deptid) {          
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

    		String insertTableSQL = "DELETE FROM ParamTest where ParTestId = ?";
    			
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setInt(1, deptid);  
               
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
    
    public static int validateTestName(String id) {   
		 int count=0;
       boolean status = false;  
       Connection conn = null;  
       PreparedStatement pst = null;  
       ResultSet rs = null;  
       List<Testcase> tc = new ArrayList<Testcase>();
 
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
                   .prepareStatement("SELECT COUNT(*) FROM ParamTest where ParTestName = ? ;");  
           pst.setString(1, id);
 
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
	
    public static List<Testcase> getTestData(String id) {   
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
               System.out.println("inside:::::::::::::::::::::"+id);
               
               pst=conn.prepareStatement("select test.MastTestID,par.ParTestName from MastTstGrp AS test "+
                                         "INNER JOIN ParamTest AS par ON test.MastTestID=par.ParTestID "+ 
                                         "where test.MastUsrGrpID= ? ");
               pst.setString(1, id);
               rs = pst.executeQuery();  
               while(rs.next()){
            	  
              	 Testcase d = new Testcase();
              	 d.setId(rs.getString(1));
              	 d.setTestcase(rs.getString(2));
              	// d.setPath(rs.getString("ParTstExePath"));
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
       
	
    
    public static List<Testcase> getNotTestData(String id) {   
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
              System.out.println("inside:::::::::::::::::::::"+id);
              
              pst=conn.prepareStatement("select ParamTest.ParTestID,ParamTest.ParTestName from ParamTest "+
            		 " where ParamTest.ParTestID NOT IN (select MastTstGrp.MastTestID from MastTstGrp where MastUsrGrpID= ? )");
              pst.setString(1, id);
              rs = pst.executeQuery();  
              while(rs.next()){
           	  
             	 Testcase d = new Testcase();
             	 d.setId(rs.getString(1));
             	 d.setTestcase(rs.getString(2));
             	// d.setPath(rs.getString("ParTstExePath"));
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
      
}
