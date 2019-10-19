package dataBaseConnector;

import java.sql.*;


class hellojava{

	public static void main(String[] args) {

		System.out.println("DB 연결시작!");

		

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

			// JDBC 드라이버 로드

	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        System.out.println("드라이버 로딩성공!");

	

			url = "jdbc:oracle:thin:@192.168.0.2:포트번호:1521";

		    id = "Hr";

		    pwd = "Oracle";

/*


jdbc:oracle:thin은 사용하는 JDBC드라이버가 thin 타입을 의미입니다.

1521 은 오라클 리슨너(listener)의 포트번호이다.

(listener 는 오라클에서 오라클과 외부 애플리케이션과의 통신 역활을 한다.)

127.0.0.1 은 데이터베이스가 설치되어 있는 서버의 IP 이다.

orcl 은 SID 로, 오라클 설치시 전역 데이터베이스 이름으로 설정한 값이다.

(전역 데이터베이스 이름이 SID가 아니다. 오라클 설치시에 전역 데이터베이스 이름으로 orcl 이라고 입력했다면, 

전역 데이터베이스 이름이 orcl 로 되는 것은 물론 SID 가 orcl 인 데이터베이스가 디폴트로 생성된다.)

*/

	        

		    // 데이터베이스와 연결

		    conn1 = DriverManager.getConnection(url, id, pwd);

	        System.out.println("DB 연결성공!");




	        // SQL문 실행(PreparedStatement클래스 사용)

	        // INSERT, UPDATE 사용시 필드 갯수가 많으면 SQL 에러가 발생할수 있는 이를 보완해준다. 

	        sql = " INSERT INTO TEST (A,B) VALUES (?,?) ";

	        // prepareStatement 메소드를 이용해 미리 컴파일 시킨다.

	        pstat1 = conn1.prepareStatement(sql);

	        // 문자열 데이터 대입

	        pstat1.setString(1, "HelloJava2");

	        pstat1.setInt(2,  1980);

	        // executeUpdate 메소드를 이용해 데이터베이스를 갱신하다.

	        pstat1.executeUpdate();

	        

	        // SQL문 실행(Statement클래스 사용)

	        sql = " SELECT * FROM TEST ";

	        stat1 = conn1.createStatement();

	        rs1 = stat1.executeQuery(sql);





/*

executeUpdate() 메소드 : 데이터베이스 파일의 내용을 변경하는 SQL문을 실행합니다.

변경된 레코드의 수가 Integer(정수) 형식으로 반환됩니다.

executeQuery() 메소드 : 데이터베이스 검색 전용 메소드로 select 질의를 사용할때

사용합니다. ResultSet 형식의 반환값을 갖습니다.




ResultSet 클래스는 Statement 클래스의 객체를 매개변수로 사용하는 executeQuery() 메소드의 반환 값을

레코드를 쉽게 처리할수 있는 클래스이다.

*/

      	     

      	    // 결과 처리

	        while(rs1.next()) { 

	        	System.out.println(rs1.getString("A") + " " + rs1.getInt("B")); 

	        	// 출력결과의 첫번째 필드와 두번째 필드를 출력

	        	System.out.println(rs1.getString(1) + " " + rs1.getInt(2)); 

	        }

	        System.out.println("변경된 갯수 : " + Cnt1);	        




	        // 데이터베이스와 연결해제

	        rs1.close();

	        pstat1.close();

	        stat1.close();

	        conn1.close();

	        System.out.println("DB 해제성공!");

	        

	    } catch (ClassNotFoundException e) {

	        // 드라이버 로드 에러발생시 실행됨 

	    	e.printStackTrace();

	    } catch (SQLException e) {

	    	// 데이터베이스 연동 에러발생시 샐행됨

	        e.printStackTrace();

	    } finally {

	    	System.out.println("정상종료, 비정상종료 모두실행");

	    }

        

             

	}
}


	