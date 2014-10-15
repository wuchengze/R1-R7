package lib2_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import org.apache.struts2.*;
import com.opensymphony.xwork2.ActionContext;

public class search_1 {
	private String search_name;
    private Connection conn=null;    
    private final String url="jdbc:mysql://localhost:3306/bookdb";  
    private final String username="root";  
    private final String password="1234";  
    private ResultSet resultSet=null;  
    private PreparedStatement pstmt=null; 
    
    private  String book_ISBN ;
    private  String book_authorid ;
    private  String book_title ;
    private  String book_publisher ;
    private  String book_publishdata ;
    private  String book_price;
    private  String author_name ;
    private  String author_authorid ;
    private  String author_age;
    private  String author_country;
    
    private  List <String> list1=new ArrayList<String>();
    private  String name ;
    
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
    public void setList1(){
    	this.list1=list1;
    }
    
    public List getList1(){
    	return list1;
    }
	public String execute() throws Exception{
		System.out.println(name);
        Class.forName("com.mysql.jdbc.Driver");  
        conn=DriverManager.getConnection(url,username,password);
        pstmt = conn.prepareStatement("select * from book");  
        resultSet = pstmt.executeQuery(); 
	
        while(resultSet.next()){  
        	book_title=resultSet.getString("title");
        	if(book_title.equals(name)){
            book_ISBN=Integer.toString(resultSet.getInt("ISBN"));
            book_authorid=Integer.toString(resultSet.getInt("authorid"));  
            book_publishdata=Integer.toString(resultSet.getInt("publishdata")); 
            book_price=Float.toString(resultSet.getInt("price")); 
            book_publisher=resultSet.getString("publisher");
        
        	}
            
        } 
        pstmt = conn.prepareStatement("select * from author"); 
        resultSet = pstmt.executeQuery(); 
        while(resultSet.next()){  

            author_authorid=Integer.toString(resultSet.getInt("authorid"));  
            if(author_authorid.equals(book_authorid)){
            author_name=resultSet.getString("name");
            author_country=resultSet.getString("country");
            author_age=Integer.toString(resultSet.getInt("age")); 
            }
        }
        
        
        list1.add(book_title);
        list1.add(book_ISBN);
        list1.add(book_authorid);
        list1.add(book_publishdata);
        list1.add(book_price);
        list1.add(book_publisher);
        
        list1.add(author_name);
        list1.add(author_authorid);
        list1.add(author_country);
        list1.add(author_age);
        pstmt.close(); 
        conn.close();
		resultSet.close();
        
        return "success";
	}

}
