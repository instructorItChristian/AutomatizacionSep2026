package com.automatizacion;
//conectarse a una base de datos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ejer13 {


      @Test
	public void testBaseDeDatos() throws ClassNotFoundException, SQLException {
		
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://192.168.56.101:3306/digitalers2023";					

		//Database Username		
		String username = "root2";	
            
		//Database Password		
		String password = "@DjvjhWfTYRl(NIE";				

		//Query to Execute		
		String query = "select count(1) from categorias;";
		//query = "select count(1) from clientes where DNI = " + dniUtilizado;
            
     	//Load mysql jdbc driver		
       //	Class.forName("com.mysql.jdbc.Driver");		
    	Class.forName("com.mysql.cj.jdbc.Driver");	
       	
       
       
       	//Create Connection to DB		
        Connection con = DriverManager.getConnection(dbUrl,username,password);
      
      	//Create Statement Object		
    	Statement stmt = con.createStatement();					
   
   		// Execute the SQL Query. Store results in ResultSet		
     	ResultSet rs= stmt.executeQuery(query);							
     
     	int count = 0;
     		
     	// While Loop to iterate through all data and print results		
		while (rs.next()){
			count = rs.getInt(1);
			
			// select nombre, edad, fechaNacimiento from clientes;
			//nombre = rs.getString(1);
			//edad = rs.getInt(2);
			//fechaNacimiento = rs.getDate(3);
        }		
	
			
		System.out.println("Número de registros en Base de Datos: " + count);
		Assert.assertTrue(count > 0);
			
  		// closing DB Connection		
  		con.close();			

}
 	}





