package com.ywq;
/*
 * 门面模式，将操作数据库的类与其它客户端分开，不直接发生关系。
 */
public class Facade {
	
	String pwd=null;
	
	private GetSQL Sql=new GetSQL();
	
	public void  facade_connect(){
		
		Sql.ConnectSQL();
	}
	
	public String facade_querytea(String s,String name){
		
		pwd=Sql.querytea(s, name);
		
		return pwd;
		

	}
	
	public String facade_querystu(String s,String username){
		
		pwd=Sql.querystu(s, username);
		
		return pwd;
		
	
	}

	

}
