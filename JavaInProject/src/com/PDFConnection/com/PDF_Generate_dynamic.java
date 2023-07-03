/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PDFConnection.com;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class PDF_Generate_dynamic {

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String file_name="E:\\PDF_Generater\\Resume7.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();
			
			DBConnection obconnection = new DBConnection();
			Connection connection = obconnection.getConnection();	
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			String query="SELECT * FROM resume";
			ps=connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			
                        
                        while(rs.next()) {
				Paragraph para = new Paragraph("************************RESUME BUILDING APPLICATION************************\n\n-------------------Personal Information-------------------\nFull Name: "+rs.getString("first")+"  "+rs.getString("middle")+"  "
                                        +rs.getString("last")+" \nDOB: "+rs.getString("date")+"   Email_ID: "+rs.getString("email")+"\nGender: "+rs.getString("male")
                                        +rs.getString("female")+"  Phone_NO: "+rs.getString("phone")+"\nCity: "+rs.getString("city")+"   Address: "+rs.getString("address")
                                        +"\n\n-------------------Education Information--------------------\nCollege Name: "+rs.getString("college")+"\n Branch: "+rs.getString("branch")+"   Education: "+rs.getString("education")+"\nCGPA/%: "+rs.getString("cgpa")
                                        +"   Start Date: "+rs.getString("edustart")+"   End Date: "+rs.getString("eduend")+"\nProject Name: "+rs.getString("project")
                                        +"\nStart Date:"+rs.getString("prostart")+"   End Date: "+rs.getString("proend")+"\nProject Information: "+rs.getString("proinfo")
                                        +"\n\n----------------Technical Skills & Accomplishment----------------\nTechnical Skills: "+rs.getString("techskill")+"   Accomplishment: "+rs.getString("acco"));
                                
				document.add(para);
				document.add(new Paragraph("    "));
			}
			document.close();
			System.out.println("finish");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
