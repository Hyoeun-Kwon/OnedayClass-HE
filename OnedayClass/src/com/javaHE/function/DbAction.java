package com.javaHE.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DbAction {

	//ShareVar에 저장해둔 DataBase 환경 연결
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	//
	int classId;
	String teacherName;
	String className;
	String classLocation;
	String classDate;
	String classContents;
	
	String ComboxColumn;
	//Constructor
	public DbAction() {
		// TODO Auto-generated constructor stub
	}
	
	//OuterTable 에 나올 것만
	
	public DbAction( String className, String teacherName, String classLocation, String classDate) {
		super();
		this.className = className;
		this.teacherName = teacherName;
		this.classLocation = classLocation;
		this.classDate = classDate;
	}
	
	//콤보박스를 위해 하나만
	
	public DbAction(String comboxColumn) {
		super();
		ComboxColumn = comboxColumn;
	}
	
	

	
	
	//전체??
	
	public DbAction(int classId, String teacherName, String className, String classLocation, String classDate,
			String classContents, String comboxColumn) {
		super();
		this.classId = classId;
		this.teacherName = teacherName;
		this.className = className;
		this.classLocation = classLocation;
		this.classDate = classDate;
		this.classContents = classContents;
		ComboxColumn = comboxColumn;
	}
	

	
	
	
	
	

	//콤보상자에 있는 카테고리별 강의명, 강사, 장소, 날짜 정보를 테이블로 불러오기
	public ArrayList<Bean> selectList(){
		
		ArrayList<Bean> beanList = new ArrayList<Bean>();   		
		 String whereDefault1 = "select c.className, t.teacherName, c.classLocation, c.classDate from Class as c, Teacher as t , Register as r ";  
		 String whereDefault2 = " where c.classId = r.Class_classId and t.teacherEmail = r.Teacher_teacherEmail ";
		 String whereDefault3 = " and classCategory ='"; 
		 String whereDefault4 = " '";
		 
			 try{ 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			 Statement stmt_mysql = conn_mysql.createStatement();
				
			 ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2 + whereDefault3 + ComboxColumn + whereDefault4);  
			          
			 while(rs.next()){  // 데이터 가져오기 --DB는 한줄씩 움직이니까 //Record단위
			 String wkClassName = rs.getString(1);
			 String wkTeacherName = rs.getString(2);
			 String wkClassLocation = rs.getString(3);
			 String wkClassDate = rs.getString(4);

			Bean bean = new Bean(wkClassName, wkTeacherName, wkClassLocation, wkClassDate);
			beanList.add(bean);
			
			 }
			 conn_mysql.close();
			 }catch (Exception e){
				 e.printStackTrace();
			 }
			 return beanList;
				
	} //selectList 	End


//
	//Table Click
//	public Bean TableClick() {
//	Bean bean = null;  
//	String WhereDefault = "select dddddddd, name, telno, address, email, relation from userinfo "; 
//	String WhereDefault2 = "where com.. = " ;
//	      
//	      try{
//	          Class.forName("com.mysql.cj.jdbc.Driver");
//	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//	          Statement stmt_mysql = conn_mysql.createStatement();
//
//	          ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2 +ComboxColumn);  // 생성자에서 만들어 놓은 시퀀넘을 가져옴
//
//	          while(rs.next()){
//	          	int wkSeq =(rs.getInt(1));
//	          	String wkName =(rs.getString(2));
//	          	String wkTelno =(rs.getString(3));
//	          	String wkAddress =(rs.getString(4));
//	          	String wkEmail =(rs.getString(5));
//	          	String wkRelation =(rs.getString(6));
//	        
//	          	bean = new Bean(wkSeq, wkName, wkTelno, wkAddress, wkEmail, wkRelation);
//	          	
//	       }
//	          conn_mysql.close();
//	      }
//	      catch (Exception e){
//	          e.printStackTrace();
//	      }
//			return bean;
//	}
//	
	
	
}//end

