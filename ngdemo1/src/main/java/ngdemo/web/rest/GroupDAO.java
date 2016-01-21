package ngdemo.web.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ngdemo.domain.Testcase;

public class GroupDAO {

	  
    public static int insertFunctions(String deptid, String deptname) {          
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

    		String insertTableSQL = "INSERT INTO ParamUserGrp"
    				+ "(ParUsrGrpId, ParUsrGrpName) VALUES"
    				+ "(?,?)";
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, deptid);  
            pst.setString(2, deptname);    
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
    
    public static int update(String prevdeptid, String deptid, String deptname) {          
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

    		String insertTableSQL = "UPDATE ParamUserGrp SET ParUsrGrpId=?, ParUsrGrpName=?"
    				+ " where (ParUsrGrpId = ?)";
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, deptid);  
            pst.setString(2, deptname); 
            pst.setString(3, prevdeptid);
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
    
    
    public static int delete(String deptid) {          
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

    		String insertTableSQL = "DELETE FROM ParamUserGrp where ParUsrGrpId = ?";
    			
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, deptid);  
               
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
    
    
    
    public static List<Testcase> getGrouptests(String groupid) {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        int i=0;
        List<Testcase>  ts = new ArrayList<Testcase>();
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "mcellblock";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "password";  
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  

    		String insertTableSQL = "SELECT MastTstGrp.MastTestID, ParamTest.ParTestName FROM MastTstGrp INNER JOIN ParamTest on "
    				+ "MastTstGrp.MastTestID = ParamTest.ParTestID where MastTstGrp.MastUsrGrpId=?";
    			
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, groupid);  
               
         //   pst.setString(4, dept);  
            System.out.println("hereeeeeeeeeeeeeeeeeeeeeeee");
            rs = pst.executeQuery(); 
            while(rs.next())
            {
            	Testcase t = new Testcase();
            	t.setId(rs.getString(1));
            	t.setTestcase(rs.getString(2));
            	ts.add(t);
            }
            System.out.println("i::::::"+i);
            return ts; 
  
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
        return ts;  
    }  
    
    public static int validateGroupName(String id) {   
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
                   .prepareStatement("SELECT COUNT(*) FROM ParamUserGrp where ParUsrGrpId = ? ;");  
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
	
    
	
}
