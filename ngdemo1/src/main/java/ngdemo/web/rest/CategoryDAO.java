package ngdemo.web.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ngdemo.domain.Testcase;

public class CategoryDAO {

	  
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

    		String insertTableSQL = "INSERT INTO ParamUserCat"
    				+ "(ParCatPre, ParCatName) VALUES"
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
    
    
    public static int insertgrouptests(String groupid, int testid) {          
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

    		String insertTableSQL = "INSERT INTO MastTstGrp"
    				+ "(MastUsrGrpID, MastTestID) VALUES"
    				+ "(?,?)";
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, groupid);  
            pst.setInt(2, testid);    
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
    
    
    public static int deletegrouptests(String groupid, int testid) {          
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

    		String insertTableSQL = "DELETE FROM MastTstGrp"
    				+ " where MastUsrGrpID = ? and MastTestID = ?";
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, groupid);  
            pst.setInt(2, testid);    
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

    		String insertTableSQL = "UPDATE ParamUserCat SET ParCatPre=?, ParCatName=?"
    				+ " where (ParCatPre = ?)";
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

    		String insertTableSQL = "DELETE FROM ParamUserCat where ParCatPre = ?";
    			
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, deptid);  
               
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
    
    public static int deleteUserProfile(String deptid) {          
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

    		String insertTableSQL = "DELETE FROM MastUserProfile where MstUID = ?";
    			
            pst = conn  
                    .prepareStatement(insertTableSQL);  
            pst.setString(1, deptid);  
               
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
    
    public static int validateCategoryName(String id) {   
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
                    .prepareStatement("SELECT COUNT(*) FROM ParamUserCat where ParCatPre = ? ;");  
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
