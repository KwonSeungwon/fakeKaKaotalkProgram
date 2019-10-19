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
        System.out.println("드라이버 로딩 성공...");
        String url="jdbc:oracle:thin:@오라클서버주소:포트번호:아이디";
          
        String user="db접속id";
        String pwd="db접속pw";
          
        Connection con=DriverManager.getConnection(url,user,pwd);
        System.out.println("DB 연결 성공!");
          
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