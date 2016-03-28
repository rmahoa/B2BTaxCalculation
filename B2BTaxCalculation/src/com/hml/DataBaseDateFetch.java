package com.hml;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
 
public class DataBaseDateFetch {
	
	 public static String getHmUserName() {
		return hmUserName;
	}


	public static void setHmUserName(String hmUserName) {
		DataBaseDateFetch.hmUserName = hmUserName;
	}


	public static String getHmPassword() {
		return hmPassword;
	}


	public static void setHmPassword(String hmPassword) {
		DataBaseDateFetch.hmPassword = hmPassword;
	}


	static Logger log = Logger.getLogger(DataBaseDateFetch.class.getName());
	 
	 static  String taxAreaLookUpUrl;
	  static String  calculateTaxUrl;
	  static String  hmUserName;
	  static String hmPassword;
	
	
	  public static String[] fetchDate() {  Connection con = null;
	    Statement stmt = null;
	    ResultSet rs1= null;
	   
	    String MethodName="fetchDate()";
	    long startTime=System.currentTimeMillis();
		log.info(MethodName+"   : Begin");
		  String[] valueArray = new String[4];
	    
	   
	    try {
	    	
	    	ClassLoader classLoader = DataBaseDateFetch.class.getClassLoader();
	    	
	    	String connector="";
	    	Properties prop = new Properties();
	    	try {
				prop.load(classLoader.getResourceAsStream("Database.properties"));
				connector=prop.getProperty("connector", "");
				log.info("DB Connection String ====>"+connector);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Error while loading Properties File");
			}
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection(connector);
	        stmt = con.createStatement();
	        
	      
	       
	        
	      
	        rs1 = stmt.executeQuery("select * from APP_VERTEXB2B.x_vertex_name_value where name in( 'password','userName','wsdlTaxCalculationLocation','wsdlTaxAReaLocation','hmUserName','hmPassword') order by ROWNO");
	        int i=0;
	        while(rs1.next()) {
	          
	         //  System.out.println("##############################"+rs1.getString(2));
	           if(i==0){
	        	   taxAreaLookUpUrl=rs1.getString(2);  
	        	   log.info("taxAreaLookUpUrl ====>"+taxAreaLookUpUrl);
	           }
	           if(i==1){
	           valueArray[1]=rs1.getString(2);
	               }
	           if(i==2){
		       valueArray[0]=rs1.getString(2);
		           }
	           if(i==3){
	         	calculateTaxUrl=rs1.getString(2);
	         	log.info("calculateTaxUrl ====>"+calculateTaxUrl);
		           }
	           if(i==4){
	        	   hmPassword=rs1.getString(2);
		           }
	           if(i==5){
	        	   hmUserName=rs1.getString(2);
		           }
	           i++;
	        }
	    
	        
	       
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            rs1.close();
	            stmt.close();
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    long endTime=System.currentTimeMillis();
	    	  
	    log.info(MethodName+"   : End in time   :"+(endTime-startTime));
	    return valueArray;
	    
	  }


	public static String getTaxAreaLookUpUrl() {
		return taxAreaLookUpUrl;
	}


	public static void setTaxAreaLookUpUrl(String taxAreaLookUpUrl) {
		DataBaseDateFetch.taxAreaLookUpUrl = taxAreaLookUpUrl;
	}


	public static String getCalculateTaxUrl() {
		return calculateTaxUrl;
	}


	public static void setCalculateTaxUrl(String calculateTaxUrl) {
		DataBaseDateFetch.calculateTaxUrl = calculateTaxUrl;
	}
	  
	
	 
   
}
