package com.javaHE.function;

public class Bean {

	
//Field
	
int classId;
String className;
String classLocation;
String classDate;  //? Date??
String classTime;  //!?
String classPrice;
String classContents;
String teacherName;
	
//?!혹시
String ComboxColumn;

//Constuctor

//기본 생성자 만들기
public Bean() {
	// TODO Auto-generated constructor stub
}


//강의명 , 강사, 장소 , 날짜 (테이블 열 이름)
public Bean(String className, String teacherName, String classDate, String classLocation) {
	super();
	this.className = className;
	this.teacherName = teacherName;
	this.classDate = classDate;
	this.classLocation = classLocation;
}

//전체??
public Bean(int classId, String className, String classDate, String classLocation, String classTime, String classPrice,
		String classContents, String teacherName) {
	super();
	this.classId = classId;
	this.className = className;
	this.classDate = classDate;
	this.classLocation = classLocation;
	this.classTime = classTime;
	this.classPrice = classPrice;
	this.classContents = classContents;
	this.teacherName = teacherName;
}

//


public Bean(String comboxColumn) {
	super();
	ComboxColumn = comboxColumn;
}


//Getter & Setter
public int getClassId() {
	return classId;
}


public void setClassId(int classId) {
	this.classId = classId;
}


public String getClassName() {
	return className;
}


public void setClassName(String className) {
	this.className = className;
}


public String getClassLocation() {
	return classLocation;
}


public void setClassLocation(String classLocation) {
	this.classLocation = classLocation;
}


public String getClassDate() {
	return classDate;
}


public void setClassDate(String classDate) {
	this.classDate = classDate;
}


public String getClassTime() {
	return classTime;
}


public void setClassTime(String classTime) {
	this.classTime = classTime;
}


public String getClassPrice() {
	return classPrice;
}


public void setClassPrice(String classPrice) {
	this.classPrice = classPrice;
}


public String getClassContents() {
	return classContents;
}


public void setClassContents(String classContents) {
	this.classContents = classContents;
}


public String getTeacherName() {
	return teacherName;
}


public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}








	
	
	
	
}
