package lib2_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class search  {
	private String search_name;
    private Connection conn=null;    
    private final String url="jdbc:mysql://localhost:3306/bookdb";  
    private final String username="root";  
    private final String password="1234";  
    private ResultSet resultSet=null;  
    private PreparedStatement pstmt=null; 
    private  String[] book_name =new String[500];
    private  String[] author_name =new String[500];
    private  int[] book_authorid =new int[500];
    private  int[] author_authorid =new int[500];
    private  List <String> list=new ArrayList<String>();
    
    public void setList(){
    	this.list=list;
    }
    
    public List getList(){
    	return list;
    }
	public String getSearch_name(){
		return search_name;
	}
	
	public void setSearch_name(String search_name){
		this.search_name=search_name;
	}
	public String execute() throws Exception{
		int i=0,j=0,z;
        Class.forName("com.mysql.jdbc.Driver");  
        conn=DriverManager.getConnection(url,username,password);
        pstmt = conn.prepareStatement("select * from book");  
        resultSet = pstmt.executeQuery(); 
        
        while(resultSet.next()){  
            book_name[i]=resultSet.getString("title");
            book_authorid[i]=resultSet.getInt("authorid");  
            i++;
        } 
        pstmt = conn.prepareStatement("select * from author"); 
        resultSet = pstmt.executeQuery(); 
        while(resultSet.next()){  
            author_name[j]=resultSet.getString("name");
            author_authorid[j]=resultSet.getInt("authorid");  
            j++;
        }
        
        for(z=0;z<=j;z++){
        	if(search_name.equals(author_name[z]))
        		break;
        }
        for(j=0;j<=i;j++){
        	if(author_authorid[z]==book_authorid[j])
        		{list.add(book_name[j]); 
        		System.out.println(book_name[j]);}
        }
        
      
		for(i=0;i<3;i++)
        System.out.println(book_name[i]);
		System.out.println(author_name[z]);
        pstmt.close(); 
        conn.close();
		resultSet.close();
		return "success";
	}
	
}
