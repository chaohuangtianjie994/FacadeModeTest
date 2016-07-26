/*
 * ���ܣ����������ݿ�SQLserver�������ӣ��Լ���Ӧ�Ĳ�ѯ������
 */
package com.ywq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//дһ���࣬���������ݿ⽨�����ӣ����Ҳ�ѯ����
public class GetSQL {
	// �趨�û���������
	String userword;
	String pwd;

	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// �����������ݿ�ķ���������������ļ̳�
	public void ConnectSQL() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct = DriverManager.getConnection("jdbc:odbc:ywq");
			System.out.println("The SQL is connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ���������ݿ���в�ѯ�ķ���
	public String querystu(String s,String username) {
		// ���������
		try {
			ps = ct.prepareStatement("select * from info where Ȩ��=? and �û���=? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			ps.setString(2, username);
			// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			// ѭ��ȡ��
			if (rs.next()) {
				// ����ʦ���û���������ȡ��
				userword = rs.getString(2);
				pwd = rs.getString(3);
				System.out.println("�ɹ���ȡ��������û���from���ݿ�");
				System.out.println(userword + "\t" + pwd + "\t");
				
				//���õ�¼����
			
			}else
			{
				JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			    
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pwd;
	}
	//�ڽ�ʦ���н��в�ѯ
	public String querytea(String s,String name ) {
		// ���������
		try {
			ps = ct.prepareStatement("select * from info_tea where Ȩ��=? and �û���=? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			ps.setString(2, name);
			// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			// ѭ��ȡ��
			if (rs.next()) {
				// ����ʦ���û���������ȡ��
				userword = rs.getString(2);
				pwd = rs.getString(3);
				System.out.println("�ɹ���ȡ��������û���from���ݿ�");
				System.out.println(userword + "\t" + pwd + "\t");
			}else
			{
				JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pwd;
	}
}