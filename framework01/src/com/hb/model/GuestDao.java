package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.model.entity.GuestDto;

public class GuestDao {
	
	// �޼ҵ� ���ȭ. �����丵 �ϴ¹�~~(�ҽ��ڵ� ���뼺 ����...��Ȱ���� �� �ְ�)
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@203.236.209.198:1521:xe";
	String id="scott";
	String pw="tiger";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
public GuestDao() {
	try {
		
		Class.forName(driver);
		conn=DriverManager.getConnection(url, id, pw);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	

	
	
	public List<GuestDto> selectAll(){	
		
		String sql = "select * from guest01";
		List<GuestDto> list = executeQuery(sql, new Object[]{});
		return list;
		
//		
//		List<GuestDto> list = new ArrayList<GuestDto>();
//		try {
//
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()){
//				GuestDto bean = new GuestDto();	
//				bean.setSabun(rs.getInt("sabun"));
//				bean.setName(rs.getString("name"));
//				bean.setNalzza(rs.getDate("nalzza"));
//				bean.setPay(rs.getInt("pay"));
//				list.add(bean);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			allClose();
//		}
//		
//		return list;
	}
	
	
	public GuestDto selectOne(int sabun) {
		String sql ="Select * from guest01 where sabun="+sabun;
		List<GuestDto> list = executeQuery(sql, new Object[]{sabun});
		return list.get(0);
//		List<GuestDto> list = new ArrayList<GuestDto>();
//		
//		try{
//		
//		pstmt = conn.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()){
//			GuestDto bean = new GuestDto();
//			bean.setSabun(rs.getInt("sabun"));
//			bean.setName(rs.getString("name"));
//			bean.setNalzza(rs.getDate("nalzza"));
//			bean.setPay(rs.getInt("pay"));
//			list.add(bean);
//		}
//		
//		}catch(Exception e){
//			
//		}finally{
//			allClose();
//		}
//		
//		return list.get(0);
//		
	}

	
	public List executeQuery(String sql, Object[] objs){
		
		List<GuestDto> list = new ArrayList<GuestDto>();
		
		try{
			pstmt = conn.prepareStatement(sql);
		
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			GuestDto bean = new GuestDto();
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalzza(rs.getDate("nalzza"));
			bean.setPay(rs.getInt("pay"));
			list.add(bean);
		}
		
		}catch(Exception e){
			
		}finally{
			allClose();
		}
		return list;
		
	}
	
	
	public void deleteOne(int sabun){
		String sql = "delete from guest01 where sabun=?";
		executeUpdate(sql, new Object[]{sabun});
		
	}
	
	
	
	private void executeUpdate(String sql, Object objs[]){
		//���� ������Ʈ �Ϸ��� Ŀ�ؼ� ��ü�� ���⼭ �����ϸ� ��..������ ������ �ȿ��� �����ϴϱ�..���� �̰� �����ؾ��� �ʿ䰡 ������ �𸦱� �̷��� �� �ʿ�� ����
		//�ƴϸ� �� �޼��带 ȣ���ϴ��ʿ��� dao�� ���� �����ϰų�
		//���߿� ���� ������ �߰��ؼ� �ٿ��� ������ �����ϴ� ���� ���� ��
		try {
			pstmt = conn.prepareStatement(sql);
		
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			allClose();
		}
	}
	
	

	public void insertOne(int sabun, String name, String nalzza, int pay) {

		String sql = "insert into Guest01(sabun, name, nalzza, pay) values(?,?,to_date(?,'yyyy-mm-dd'),?)";
		
		Object[] objs = {sabun, name, nalzza, pay};
		executeUpdate(sql, objs);
		
//		try{
//		}catch(Exception e ){
//			e.printStackTrace();
//		}
//		
		
	}


	public void updateOne(int sabun, String name, int pay) {
		
		String sql ="update guest01 set name=?, pay=? where sabun=?";
		
		executeUpdate(sql, new Object[]{name, pay, sabun});
		
//		try{

//			pstmt = conn.prepareStatement(sql);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setInt(2, pay);
//			pstmt.setInt(3, sabun);
//			pstmt.executeUpdate();	
//		}catch(Exception e){
//			
//		}finally{
//			allClose();
//		}
//		
		
	} 
	
	
	
	public void allClose(){
		
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
