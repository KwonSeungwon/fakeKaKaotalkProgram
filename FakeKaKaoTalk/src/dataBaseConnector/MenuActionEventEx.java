package dataBaseConnector;
OracleConnect.java
[code]
import java.sql.*;

public class oracleconnect {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("����̹� �ε� ����...");
        String url="jdbc:oracle:thin:@����Ŭ�����ּ�:��Ʈ��ȣ:���̵�";
          
        String user="db����id";
        String pwd="db����pw";
          
        Connection con=DriverManager.getConnection(url,user,pwd);
        System.out.println("DB ���� ����!");
          
        Statement st=con.createStatement();
        String sql="select * from users";
        ResultSet rs=st.executeQuery(sql);
          
        while(rs.next()){
            String id=rs.getString(1);
            String passwd=rs.getString(2);
            String dept=rs.getString(3);
            System.out.println(id+"\t"+passwd+"\t"+dept);
        }//while---------
          
        rs.close();
        st.close();
        con.close();
    }
}