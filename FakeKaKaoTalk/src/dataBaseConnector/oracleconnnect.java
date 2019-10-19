package dataBaseConnector;

import java.sql.*;


class hellojava{

	public static void main(String[] args) {

		System.out.println("DB �������!");

		

		Connection conn1 = null;

		Statement stat1 = null;

		PreparedStatement pstat1 = null;

		ResultSet rs1 = null;




		String url = null;

		String id = null;

		String pwd = null; 

		String sql = null;

		

		int Cnt1 = 0;

		

		try {

			// JDBC ����̹� �ε�

	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        System.out.println("����̹� �ε�����!");

	

			url = "jdbc:oracle:thin:@192.168.0.2:��Ʈ��ȣ:1521";

		    id = "Hr";

		    pwd = "Oracle";

/*


jdbc:oracle:thin�� ����ϴ� JDBC����̹��� thin Ÿ���� �ǹ��Դϴ�.

1521 �� ����Ŭ ������(listener)�� ��Ʈ��ȣ�̴�.

(listener �� ����Ŭ���� ����Ŭ�� �ܺ� ���ø����̼ǰ��� ��� ��Ȱ�� �Ѵ�.)

127.0.0.1 �� �����ͺ��̽��� ��ġ�Ǿ� �ִ� ������ IP �̴�.

orcl �� SID ��, ����Ŭ ��ġ�� ���� �����ͺ��̽� �̸����� ������ ���̴�.

(���� �����ͺ��̽� �̸��� SID�� �ƴϴ�. ����Ŭ ��ġ�ÿ� ���� �����ͺ��̽� �̸����� orcl �̶�� �Է��ߴٸ�, 

���� �����ͺ��̽� �̸��� orcl �� �Ǵ� ���� ���� SID �� orcl �� �����ͺ��̽��� ����Ʈ�� �����ȴ�.)

*/

	        

		    // �����ͺ��̽��� ����

		    conn1 = DriverManager.getConnection(url, id, pwd);

	        System.out.println("DB ���Ἲ��!");




	        // SQL�� ����(PreparedStatementŬ���� ���)

	        // INSERT, UPDATE ���� �ʵ� ������ ������ SQL ������ �߻��Ҽ� �ִ� �̸� �������ش�. 

	        sql = " INSERT INTO TEST (A,B) VALUES (?,?) ";

	        // prepareStatement �޼ҵ带 �̿��� �̸� ������ ��Ų��.

	        pstat1 = conn1.prepareStatement(sql);

	        // ���ڿ� ������ ����

	        pstat1.setString(1, "HelloJava2");

	        pstat1.setInt(2,  1980);

	        // executeUpdate �޼ҵ带 �̿��� �����ͺ��̽��� �����ϴ�.

	        pstat1.executeUpdate();

	        

	        // SQL�� ����(StatementŬ���� ���)

	        sql = " SELECT * FROM TEST ";

	        stat1 = conn1.createStatement();

	        rs1 = stat1.executeQuery(sql);





/*

executeUpdate() �޼ҵ� : �����ͺ��̽� ������ ������ �����ϴ� SQL���� �����մϴ�.

����� ���ڵ��� ���� Integer(����) �������� ��ȯ�˴ϴ�.

executeQuery() �޼ҵ� : �����ͺ��̽� �˻� ���� �޼ҵ�� select ���Ǹ� ����Ҷ�

����մϴ�. ResultSet ������ ��ȯ���� �����ϴ�.




ResultSet Ŭ������ Statement Ŭ������ ��ü�� �Ű������� ����ϴ� executeQuery() �޼ҵ��� ��ȯ ����

���ڵ带 ���� ó���Ҽ� �ִ� Ŭ�����̴�.

*/

      	     

      	    // ��� ó��

	        while(rs1.next()) { 

	        	System.out.println(rs1.getString("A") + " " + rs1.getInt("B")); 

	        	// ��°���� ù��° �ʵ�� �ι�° �ʵ带 ���

	        	System.out.println(rs1.getString(1) + " " + rs1.getInt(2)); 

	        }

	        System.out.println("����� ���� : " + Cnt1);	        




	        // �����ͺ��̽��� ��������

	        rs1.close();

	        pstat1.close();

	        stat1.close();

	        conn1.close();

	        System.out.println("DB ��������!");

	        

	    } catch (ClassNotFoundException e) {

	        // ����̹� �ε� �����߻��� ����� 

	    	e.printStackTrace();

	    } catch (SQLException e) {

	    	// �����ͺ��̽� ���� �����߻��� �����

	        e.printStackTrace();

	    } finally {

	    	System.out.println("��������, ���������� ��ν���");

	    }

        

             

	}
}


	