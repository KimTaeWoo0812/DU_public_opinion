package Process;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DB {
	static Connection con = null;
	static Statement stmt;
	
	static ServerManage Manage;
	
	public static String _del="";//�뜲�씠�꽣 援щ텇�옄
	public static String _endDel="";//�뼱�젅�씠由ъ뒪�듃 醫낅즺 援щ텇�옄
	public static String _endSendDel="";//�뜲�씠�꽣 �걹 援щ텇�옄
	
	public DB() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Manage = new ServerManage(this);//愿�由ъ옄 �뒪�젅�뱶 �떆�옉
		Thread t = new Thread(Manage);
		t.start();
		
		_del+=(char)200;
		_endDel+=(char)201;
		_endSendDel+=(char)202;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("org.gjt.mm.mysql.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/DaeguUClass", "root", "dgssm");
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test","uroot","p");

			stmt = con.createStatement();
			// 占쏙옙占쏙옙
			
			
			/*
			//占쏙옙占쏙옙
			stmt.executeUpdate("CREATE TABLE user2 ("
					+ "num int NOT NULL auto_increment, "
					+ "id varchar(20) NOT NULL, " 
					+ "pw varchar(20) NOT NULL, "
					+ "name varchar(20) NOT NULL, "
					+ "isLogin int NOT NULL, " 
					+ "makeCommentNum varchar(20) NOT NULL, "
					+ "temp varchar(20) NOT NULL, "
					+ "PRIMARY KEY(num) " 
					+");");

			
			//占쏙옙占쏙옙
			stmt.executeUpdate("CREATE TABLE class3 ("
					+ "num int NOT NULL auto_increment, "
					+ "major varchar(40) NOT NULL, " //�븰怨�
					+ "title varchar(40) NOT NULL, " //怨쇰ぉ紐�
					+ "professor varchar(20) NOT NULL, " //援먯닔紐�
					+ "gradesAvr varchar(20) NOT NULL, " //�룊�젏
					+ "joinPeople varchar(20) NOT NULL, " //李몄뿬�씤�썝�닔
					+ "PRIMARY KEY(num) "+ ");");
			
		
			//占쏙옙占�
			stmt.executeUpdate("CREATE TABLE comment4 ("
					+ "userId varchar(40) NOT NULL, "
					+ "classNum int NOT NULL, "
					+ "num int NOT NULL auto_increment, "
					+ "content varchar(202) NOT NULL, " //�궡�슜
					+ "name varchar(40) NOT NULL, " //蹂꾨챸
					+ "score varchar(20) NOT NULL, " //�룊�젏
					+ "good varchar(20) NOT NULL, " //醫뗭븘�슂
					+ "bad varchar(20) NOT NULL, " //�떕�뼱�슂
					+ "date varchar(40), " //�떕�뼱�슂
					+ "PRIMARY KEY(num) "
					+ ");");
			
			//占쏙옙占� 占쌩븝옙체크
			stmt.executeUpdate("CREATE TABLE commentCheck2 ("
					+ "userId varchar(40) NOT NULL, "
					+ "commentNum int NOT NULL, "
					+ "type int NOT NULL "
					+ ");");
			 
			stmt.executeUpdate("CREATE TABLE notice ("
					+ "notice varchar(200) "
					+ ");");
					
					*/
					
					//CREATE TABLE opinion (id varchar(40), name varchar(40), com varchar(201));
					
//			stmt.executeUpdate("CREATE TABLE restaurant ("
//					+ "num int NOT NULL auto_increment, "
//					+ "name varchar(20) NOT NULL, " 
//					+ "grade varchar(20) NOT NULL, "
//					+ "joinPeople int NOT NULL, "
//					+ "PRIMARY KEY(num) " 
//					+");");
//			
//			stmt.executeUpdate("CREATE TABLE menu ("
//					+ "restaurantNum int, "
//					+ "num int NOT NULL auto_increment, "
//					+ "name varchar(20) NOT NULL, " 
//					+ "grade varchar(20) NOT NULL, "
//					+ "joinPeople int NOT NULL, "
//					+ "PRIMARY KEY(num) " 
//					+");");
			
			
//			stmt.executeUpdate("CREATE TABLE review ("
//					+ "restaurantNum int, "
//					+ "num int NOT NULL auto_increment, "
//					+ "id varchar(40) NOT NULL, " 
//					+ "name varchar(40) NOT NULL, " 
//					+ "comment varchar(511) NOT NULL, " 
//					+ "grade varchar(20) NOT NULL, "
//					+ "date varchar(40), "
//					+ "PRIMARY KEY(num) " 
//					+");");
//			stmt.executeUpdate("CREATE TABLE chatting ("
//					+ "id varchar(40) NOT NULL, "
//					+ "name varchar(40) NOT NULL, "
//					+ "comment varchar(512) NOT NULL, "
//					+ "date varchar(40) NOT NULL "
//					+ ");");
			
//			stmt.executeUpdate("CREATE TABLE user ("
//					+ "num int NOT NULL auto_increment, "
//					+ "id varchar(20) NOT NULL, " 
//					+ "name varchar(20) NOT NULL, "
//					+ "makeCommentNum varchar(20) NOT NULL, "
//					+ "temp varchar(20) NOT NULL, "
//					+ "PRIMARY KEY(num) " 
//					+");");
			
			
			
			
			stmt.executeUpdate("set global wait_timeout = 259200;"); //3일
			stmt.executeUpdate("set global interactive_timeout = 86400;");
			
			ResultSet result = stmt.executeQuery("show variables like 'wait_timeout';");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.println(result.getString(2));
				
			}
			result = stmt.executeQuery("select * from user;");
			System.out.println("user:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\t");
				System.out.print(result.getString(4) + "\t");
				System.out.print(result.getString(5) + "\n");
			}
			
			result = stmt.executeQuery("select * from user2;");
			System.out.println("user2:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\t");
				System.out.print(result.getString(4) + "\t");
				System.out.print(result.getString(5) + "\t");
				System.out.print(result.getString(6) + "\t");
				System.out.print(result.getString(7) + "\n");
			}
			result = stmt.executeQuery("select * from class3;");
			System.out.println("怨쇰ぉ:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\t");
				System.out.print(result.getString(4) + "\t");
				System.out.print(result.getString(5) + "\t");
				System.out.print(result.getString(6) + "\n");
			}

			
			result = stmt.executeQuery("select * from comment4;");
			System.out.println("�뙎湲�:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\t");
				System.out.print(result.getString(4) + "\t");
				System.out.print(result.getString(5) + "\t");
				System.out.print(result.getString(6) + "\t");
				System.out.print(result.getString(7) + "\t");
				System.out.print(result.getString(8) + "\t");
				System.out.print(result.getString(9) + "\n");
			}
			result = stmt.executeQuery("select * from commentCheck2;");
			System.out.println("醫뗭븘�슂 / �떕�뼱�슂:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\n");
			}
			result = stmt.executeQuery("select * from opinion;");
			System.out.println("사용자 의견:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\n");
			}

			result = stmt.executeQuery("select * from restaurant;");
			System.out.println("restaurant:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\t");
				System.out.print(result.getString(4) + "\n");
			}
			
			
			
			result = stmt.executeQuery("select * from review;");
			System.out.println("review:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\t");
				System.out.print(result.getString(4) + "\t");
				System.out.print(result.getString(5) + "\t");
				System.out.print(result.getString(6) + "\n");
			}
			result = stmt.executeQuery("select * from chatting;");
			System.out.println("chatting:");
			while (result.next()) {
				System.out.print(result.getString(1) + "\t");
				System.out.print(result.getString(2) + "\t");
				System.out.print(result.getString(3) + "\t");
				System.out.print(result.getString(4) + "\n");
			}
			// con.close();//DB 占쏙옙占쏙옙
		} catch (SQLException e) {
			System.out.println("SQL err:" + e.toString());

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	
	
	public synchronized String NEW_ID_CHECK(String ponNum, String id, String pw) {
		ResultSet result;
		boolean check = false;
		String name = "";
		String makeCommentNum = "";
		try {
			result = stmt
					.executeQuery("select makeCommentNum,name from user where id = '"+ ponNum + "';");
			
			while (result.next()){
				makeCommentNum = result.getString(1);
				name = result.getString(2);
				check = true;
			}
			if(check){
				//벌써 가입했네.
				return "NEW_ID_CHECK"+_del+makeCommentNum+_del+name+_del;
			}
			check = false;
			
			result = stmt
					.executeQuery("select makeCommentNum,name from user2 where id = '"+ id + "' AND pw = '"+pw+"' ;");
			
			while (result.next()){
				makeCommentNum = result.getString(1);
				name = result.getString(2);
				check = true;
			}
			if(check){
				//있다. 그러니깐 user에 가입 시키고 strTemp 보내면 댐
				String message="insert into user(`num`, `id`, `name`, `makeCommentNum`, `temp`) "
						+ "values(NULL,'"+ponNum+"','"+name+"', '"+makeCommentNum+"', '"+0+"');";

				stmt.executeUpdate(message);
				
				
				return "NEW_ID_CHECK"+_del+makeCommentNum+_del+name+_del;
			}
			
			else{
				//없다.
				
				return "NEW_ID_CHECK"+_del+"9999999"+_del;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "NEW_ID_CHECK"+_del+"9999999"+_del;
		}
	}
	
	public synchronized String NEW_JOIN_US(String id, String name) {
		ResultSet result;
		try {
			boolean check = false;
			String makeCommentNum = "";
			
			result = stmt
					.executeQuery("select makeCommentNum,name from user where id = '"+ id + "';");
			
			while (result.next()){
				makeCommentNum = result.getString(1);
				name = result.getString(2);
				check = true;
			}
			if(check){
				//벌써 가입했네.
				return "2"+_del+makeCommentNum+_del+name;
			}

			
			
			
			String message="insert into user(`num`, `id`, `name`, `makeCommentNum`, `temp`) "
					+ "values(NULL,'"+id+"','"+name+"', '"+0+"', '"+0+"');";

			stmt.executeUpdate(message);
			result = stmt.executeQuery("select Count(id) from user where id like '"
							+ id + "' ;");
			String strTemp = "";
			int temp=0;
			while (result.next())
				temp = result.getInt(1);

			if (temp == 1)
				return "1";
			else
				return "0";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}
	
	public synchronized String NEW_LOGIN(String id) {
		ResultSet result;
		boolean check = false;
		try {
			result = stmt
					.executeQuery("select makeCommentNum from user where id = '"+ id + "' ;");
			String strTemp = "";
			while (result.next()){
				strTemp = result.getString(1);
				check = true;
			}
			if(check){
				return strTemp;
			}
			
			else{
				return "9999999";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "9999999";
		}
	}
	
	
	

	public synchronized void CHANGE_NAME(String id, String name) {
		try {
			
			String msg = "update user set name='"+name+"' where id = '"+id+"';";
				
				stmt.executeUpdate(msg);
				//System.out.println(major+"   "+title+"   "+professor);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized String SET_RESTAURANT() {
		ResultSet result;
		String strTemp="";
		try {
			
			result = stmt.executeQuery("SELECT num,name,grade from restaurant ORDER BY grade desc;");
			
			while (result.next()){
				strTemp += result.getString(1)+_del;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_endDel;
			}
			strTemp += "0"+_del+_endDel;
			return strTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strTemp;
	}
	
	public synchronized String SET_MENU(String restaurantNum) {
		ResultSet result;
		String strTemp="";
		try {
			
			result = stmt.executeQuery("SELECT num,name,grade from menu "
					+ "where restaurantNum='"+restaurantNum+"' ORDER BY grade desc;");
			
			while (result.next()){
				strTemp += result.getString(1)+_del;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_endDel;
			}
			strTemp += "0"+_del+_endDel;
			return strTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strTemp;
	}
	
	//메뉴 평점 저장
	public synchronized void SAVE_GRADE(String restaurantNum, String menuNum, String grade) {
		try {
			stmt.executeUpdate("update restaurant "
					+ "set grade = ("+grade+"+grade*joinPeople) / (joinPeople+1),joinPeople=joinPeople+1 "
					+ "where num = '" + restaurantNum + "';");
			
			stmt.executeUpdate("update menu "
					+ "set grade = ("+grade+"+grade*joinPeople) / (joinPeople+1),joinPeople=joinPeople+1 "
					+ "where num = '" + menuNum + "';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static String getDate() {
		long time = System.currentTimeMillis(); 
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        return f.format(new Date(time));
	}
	
	public synchronized void opinion(String id,String name, String com) {
		try {
			stmt.executeUpdate("insert into opinion values('"+id+"', '"+name+"', '" + com + "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String Manage_execute(String msg,String i){
		String strTemp = "";
		ResultSet result;
		try {
			result = stmt.executeQuery(msg);
			while (result.next()) {
				for(int j=1;j< Integer.valueOf(i);j++){
					strTemp += result.getString(j) + _del;
				}
				strTemp += _endDel;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strTemp;
		
	}
	

	public void Manage_Update(String msg){
		try {
//			boolean check = true;
			
			stmt.executeUpdate(msg);
			System.out.println(msg);
			
			
			//System.out.println(major+"   "+title+"   "+professor);
//			ResultSet result;
//			result = stmt.executeQuery("select * from class3 where major='"+major+"' AND title='"+title+"' AND professor='"+professor+"';");
//			while (result.next()) {
//				check = false;
//				System.out.println("중복!");
//				return ;
//			}
//
//			//System.out.println(major+" 22222  "+title+"   "+professor);
//			if(check){
//				String msg = "insert into class3(`num`, `major`, `title`, `professor`, `gradesAvr`, `joinPeople`) "
//						+ "values(NULL,'"+major+"','"+title+"', '"+professor+"', '0', '0');";
//				
//				stmt.executeUpdate(msg);
//				System.out.println(major+"   "+title+"   "+professor);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public synchronized String SHOW_OPINOION() {
		String strTemp = "";
		ResultSet result;
		try {
			result = stmt.executeQuery("select * from opinion;");
			while (result.next()) {
				strTemp = result.getString(1) + _del;
				strTemp += result.getString(2) + _del;
				strTemp += result.getString(3) + _endDel;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strTemp;
	}
	
	public synchronized int IdCheck(String id) {
		ResultSet result;
		try {
			result = stmt
					.executeQuery("select Count(id) from user2 where id like '"
							+ id + "' ;");
			String strTemp = "";
			while (result.next())
				strTemp = result.getString(1);

			char cTemp = strTemp.charAt(0);
			
			if (cTemp == '0')
				return 1;
			else
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public synchronized int JoinUs(String id, String pw,String name,String major) {
		ResultSet result;
		try {
			
			
			String message="insert into user2(`num`, `id`, `pw`, `name`, `isLogin`, `makeCommentNum`, `temp`,`date`) "
					+ "values(NULL,'"+id+"','"+pw+"', '"+name+"', '"+0+"', '"+0+"', '"+major+"','"+getDate()+"');";
			//String message = "insert into USER values('" + temp + "','" + id
			//		+ "','" + pw + "','0');";
			stmt.executeUpdate(message);
			result = stmt.executeQuery("select Count(id) from user2 where id like '"
							+ id + "' ;");
			String strTemp = "";
			int temp=0;
			while (result.next())
				temp = result.getInt(1);

		
			if (temp == 1)
				return 1;
			else
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public synchronized String getNotice(){
		ResultSet result;
		String strTemp="";
		
		try {
			result = stmt.executeQuery("select notice from notice;");
			
			while (result.next())
				strTemp = result.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strTemp;
	}


	public synchronized void LoginOut(String id) {
		try {
			stmt.executeUpdate("update user2 set islogin='0' where id like '"
					+ id + "';");// 占쏙옙占쏙옙
			if(ProcessThread.isPrint)
				System.out.println(id + "占쏙옙 占싸그아울옙 占싹울옙占쏙옙占싹댐옙.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void ChangeLogin(String id) {
		String m = "update user2 set islogin='1' where id like '" + id + "';";
		try {
			stmt.executeUpdate(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 諛섑솚 1: �꽦怨�
	 * 2: �뾾�뒗 id
	 * 3: ��由� pw
	 * 4: �씠誘� �젒�냽 以�
	 * @param id
	 * @param pw
	 * @return
	 */
	public synchronized int Login(String id, String pw) {
		ResultSet result;
		try {
			result = stmt
					.executeQuery("select Count(id) from user2 where id = '"
							+ id + "' ;");
			String strTemp = "";
			while (result.next())
				strTemp = result.getString(1);

			char cTemp = strTemp.charAt(0);
			if (cTemp == '0')// �뾾�뒗 id
				return 2;

//			int nTemp = 0;
//			result = stmt
//					.executeQuery("select isLogin from user2 where id like '"
//							+ id + "' ;");// �젒�냽 �뿬遺� �솗�씤
//			while (result.next())
//				nTemp = result.getInt(1);
//			if (nTemp == 1)
//				return 4;

			result = stmt.executeQuery("select pw from user2 where id = '"
					+ id + "' ;");
			while (result.next())
				strTemp = result.getString(1);

			if (pw.equals("1"))//자동로그인
			{
				String m = "update user2 set date=SYSDATE() where id='"+id+"';";
//				String m = "update user2 set islogin='1' where id like '" + id
//						+ "';";
				stmt.executeUpdate(m);
				return 1;
			}

			if (pw.equals(strTemp))// 濡쒓렇�씤 �꽦怨�
			{
				String m = "update user2 set date=SYSDATE() where id='"+id+"';";
//				String m = "update user2 set islogin='1' where id like '" + id
//						+ "';";
				stmt.executeUpdate(m);
				return 1;
			} else
				return 3;// ��由� 鍮꾨�踰덊샇

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
	public synchronized String GetCommentNum(String id) {
		ResultSet result;
		String strTemp = "0";
		try {
			result = stmt
					.executeQuery("select makeCommentNum from user where id = '"
							+ id + "' ;");
			while (result.next())
				strTemp = result.getString(1);


			return strTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strTemp;
		
	}
	public synchronized String GetName(String id){
		ResultSet result;
		String strTemp="";
		
		try {
			result = stmt.executeQuery("select name from user2 where id like '"+ id + "' ;");
			
			while (result.next())
				strTemp = result.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strTemp;
	}
	
	
	public synchronized String rankingForAll() {
		ResultSet result;
		String strTemp="";
		int i=0;
		try {
			
			result = stmt.executeQuery("SELECT num,major,title,professor,gradesAvr,joinPeople from class3 where joinPeople > 1 ORDER BY gradesAvr desc;");
			
			while (result.next()){
				strTemp += result.getString(1)+_del;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_del;
				strTemp += result.getString(4)+_del;
				strTemp += result.getString(5)+_del;
				strTemp += result.getString(6)+_endDel;
				
				
				i++;
				if(i>30)
					break;
				
			}
			strTemp += "0"+_del+_endDel;
			return strTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strTemp;
	}
	public synchronized String RANKINGFORART() {
		ResultSet result;
		String strTemp="";
		int i=0;
		try {
			
			result = stmt.executeQuery("SELECT num,major,title,professor,gradesAvr,joinPeople from class3 where major like '기타 교양%' AND joinPeople > 1 ORDER BY gradesAvr desc;");
			
			while (result.next()){
				strTemp += result.getString(1)+_del;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_del;
				strTemp += result.getString(4)+_del;
				strTemp += result.getString(5)+_del;
				strTemp += result.getString(6)+_endDel;
				
				
				i++;
				if(i>30)
					break;
				
			}
			strTemp += "0"+_del+_endDel;
			return strTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strTemp;
	}
	
	public synchronized String Set_Class(String didSearch) {
		ResultSet result;
		String strTemp="";
		int i=0;
		try {
			result = stmt.executeQuery("select num,major,title,professor,gradesAvr,joinPeople from class3 where title like '%"
							+ didSearch + "%' ;");

			while (result.next()){
				strTemp += result.getString(1)+_del;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_del;
				strTemp += result.getString(4)+_del;
				strTemp += result.getString(5)+_del;
				strTemp += result.getString(6)+_endDel;
				

				i++;
				if(i>20){
					strTemp += "0"+ _del+_endDel;
					return strTemp;
				}
			}
			
			i=0;
			result = stmt.executeQuery("select num,major,title,professor,gradesAvr,joinPeople from class3 where professor like '%"
							+ didSearch + "%' ;");

			while (result.next()) {
				strTemp += result.getString(1) + _del;
				strTemp += result.getString(2) + _del;
				strTemp += result.getString(3) + _del;
				strTemp += result.getString(4) + _del;
				strTemp += result.getString(5) + _del;
				strTemp += result.getString(6) + _endDel;


				i++;
				if(i>20){
					strTemp += "0"+ _del+_endDel;
					return strTemp;
				}
			}
			

			strTemp += "0"+ _del+_endDel;
			return strTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strTemp;
	}
	
	
	/**
	 * 由ы꽩 1: �꽦怨�
	 * 由ы꽩 2: �씠誘� �엳�뒗 媛뺤쥖
	 * 由ы꽩 0: �떎�뙣
	 * @param major
	 * @param title
	 * @param professor
	 * @return
	 */
	public synchronized char Make_Class(String major, String title, String professor) {
		String strTemp = "";
		int nTemp = 0;
		int brforNum = 0;
		ResultSet result;
		try {
			result = stmt
					.executeQuery("select Count(major) from class3 where major like '"
							+ major + "' AND title like '"
							+ title + "' AND professor='"
							+ professor + "' ;");

			while (result.next())
				brforNum = result.getInt(1);
			
			if (brforNum != 0)// �씠誘� �엳�뒗 媛뺤쥖
				return '2';


			stmt.executeUpdate("insert into class3 values(NULL,'" + major + "','"
					+ title + "', '"+professor+"','0','0');");
			
			
			result = stmt
					.executeQuery("select Count(major) from class3 where major like '"
							+ major + "' AND title like '"
							+ title + "' ;");//�궫�씤 �셿猷� �솗�씤 議고쉶
			// 占쏙옙회
			while (result.next())
				nTemp = result.getInt(1);
			if (nTemp != brforNum)// �꽦怨�
				return '1';
			else
				return '0';// �떎�뙣
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//

		return '0';
	}
	
	public synchronized String Save_Comment(String userId, String classNum, String content, String name, String score) {
		ResultSet result;
		try {
			stmt.executeUpdate("insert into comment4 values('"+userId+"', '"+classNum+"', NULL, '" + content + "','"
					+ name + "','"+score+"','0','0','"+getDate()+"');");
			
			//�쑀�� �뙎湲� �옉�꽦 �닔 �뾽�뜲�씠�듃
			stmt.executeUpdate("update user set makeCommentNum=makeCommentNum+1 where id = '" + userId + "';");
			
			result = stmt.executeQuery("select AVG(score), Count(score) from comment4 where classNum = '"+classNum+"';");//占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 num 占쏙옙회
			String avg="";
			String count="";
			// 占쏙옙회
			while (result.next()){
				avg = result.getString(1);
				count = result.getString(2);
			}
				
				stmt.executeUpdate("update class3 set gradesAvr='"+avg+"',joinPeople='"+count+"' "
						+ " where num like '"+classNum+"';");
				//update user set islogin='0' where id like '12345';
				
				
			
			return "1";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//

		return "0";
	}
	
	public synchronized String COMMENT_GOOD(String id, String num, String g_b_num) {
		int nTemp = 0;
		int check = 0;
		String strTemp = "";
		ResultSet result;
		try {
			
			result = stmt
					.executeQuery("select Count(commentNum) from commentCheck2 "
							+ "where userId like '"+ id + "' AND commentNum like '"+num+"';");
			
			while (result.next()){
				check =  result.getInt(1);
			}
			
			if(check != 0)
				return "0";
			
			
			stmt.executeUpdate("insert into commentCheck2 values('"+id+"', '"+num+"', '"+1+"');");


			stmt.executeUpdate("update comment4 set good='"+g_b_num+"' where num like '"
					+ num + "';");// �닔�젙
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return "1";

	}
	
	public synchronized String COMMENT_BAD(String id, String num, String g_b_num) {
		int nTemp = 0;
		String strTemp = "";
		int check = 0;
		ResultSet result;
		try {
			result = stmt
					.executeQuery("select Count(commentNum) from commentCheck2 "
							+ "where userId like '"+ id + "' AND commentNum like '"+num+"';");
			
			while (result.next())
				check =  result.getInt(1);
			
			//System.out.println(check);
			
			if(check != 0)
				return "0";
			
			
			stmt.executeUpdate("insert into commentCheck2 values('"+id+"', '"+num+"', '"+2+"');");
			
			
			stmt.executeUpdate("update comment4 set bad='"+g_b_num+"' where num like '"
					+ num + "';");// �닔�젙
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return "1";
	}
	
	public synchronized String DELETE_G_B(String id, String num) {
		int nTemp = 0;
		String strTemp = "";
		int check = 0;
		ResultSet result;
		try {
			
			result = stmt
					.executeQuery("select type from commentCheck2 "
							+ "where userId like '"+ id + "' AND commentNum like '"+num+"';");
			
			while (result.next())
				check =  result.getInt(1);
			
			stmt.executeUpdate("delete from commentCheck2 where userId like '"+id+"' and commentNum like '"+num+"' ;");//占쏙옙占쏙옙
			
			
			if(check == 1){
				result = stmt
						.executeQuery("select good from comment4 where num like '"
								+ num + "' ;");
			} if(check == 2){
				result = stmt
						.executeQuery("select bad from comment4 where num like '"
								+ num + "' ;");
			}
			// 議고쉶
			while (result.next())
				nTemp = result.getInt(1);
			
			nTemp--;
			
			if(check == 1){
				stmt.executeUpdate("update comment4 set good='"+nTemp+"' where num like '"
						+ num + "';");// �닔�젙
			} if(check == 2){
				stmt.executeUpdate("update comment4 set bad='"+nTemp+"' where num like '"
						+ num + "';");// �닔�젙
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return "1";
	}
	
	
	public synchronized void REVISE_MY_COMMENT(String id, String classNum, String content, String score) {
		try {
			stmt.executeUpdate("update comment4 set content='"+content+"', score='"+score+"' "
					+ "where userId like '"+ id + "' AND classNum like '"+classNum+"';");// 占쏙옙占쏙옙
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized ArrayList<String> SET_COMMENT(String classNum) {
		ResultSet result;
		ArrayList<String> query = new ArrayList<String>();
		String strTemp="";
		String temp="";
		query.clear();
		int i=0;
		try {
			result = stmt.executeQuery("select num,content,userId,name,score,good,bad,date from comment4 where classNum like '"
							+ classNum + "' ORDER BY date desc;");
			while (result.next()){
				temp = result.getString(1)+_del;;
				strTemp += temp;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_del;
				strTemp += result.getString(4)+_del;
				strTemp += result.getString(5)+_del;
				strTemp += result.getString(6)+_del;
				strTemp += result.getString(7)+_del;
				strTemp += result.getString(8)+_endDel;
				
				if(i%20==0 && i!=0){
					query.add(strTemp);
					strTemp = "";
					
				}
				
				//System.out.println("send comment data: " + strTemp);
				i++;
			}
			strTemp += "0"+_del+_endDel;
			query.add(strTemp);
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}
	
	public synchronized String SET_MY_COMMENT(String classNum, String userId) {
		ResultSet result;
		ArrayList<String> query = new ArrayList<String>();
		String strTemp="";
		query.clear();
		int i=0;
		try {
			result = stmt.executeQuery("select num,content,name,score,good,bad,date from comment4 where classNum like '"
					+ classNum + "' AND userId like '"+userId+"';");
			
			while (result.next()){
				strTemp += result.getString(1)+_del;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_del;
				strTemp += result.getString(4)+_del;
				strTemp += result.getString(5)+_del;
				strTemp += result.getString(6)+_del;
				strTemp += result.getString(7)+_del;
			
			
				
				i++;
			}
			if(i==0)
				return _endDel+_del;
		
			return strTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strTemp;
	}
	
	
	public synchronized void SAVE_REVIEW(String restaurantNum, String id,String name, String content, String grade) {
		try {
			stmt.executeUpdate("insert into review values('"+restaurantNum+"', NULL, '" + id + "','"
					+ name + "','"+content+"','"+grade+"','"+getDate()+"');");

			stmt.executeUpdate("update restaurant "
					+ "set grade = (("+grade+"*5)+grade*joinPeople) / (joinPeople+5),joinPeople=joinPeople+10 "
					+ "where num = '" + restaurantNum + "';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
	}
	public synchronized ArrayList<String> SET_REVIEW(String restaurantNum) {
		ResultSet result;
		ArrayList<String> query = new ArrayList<String>();
		String strTemp="";
		query.clear();
		int i=0;
		try {
//			System.out.println("test1: "+restaurantNum);
			result = stmt.executeQuery("select num,id,name,comment,grade,date from review where restaurantNum = '"
							+ restaurantNum + "' ;");
			while (result.next()){
				strTemp += result.getString(1)+_del;;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_del;
				strTemp += result.getString(4)+_del;
				strTemp += result.getString(5)+_del;
				strTemp += result.getString(6)+_endDel;
				
//				System.out.println("test: "+strTemp);
				if(i%20==0 && i!=0){
					query.add(strTemp);
					strTemp = "";
					
				}
				
				//System.out.println("send comment data: " + strTemp);
				i++;
			}
			strTemp += "0"+_del+_endDel;
			query.add(strTemp);
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}
	
	
	public synchronized void DELETE_REVIEW(String num) {
		try {

			stmt.executeUpdate("delete from review where num='"+num+"';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public synchronized void SAVE_CHAT(String id, String name, String comment, String date) {
		try {

			stmt.executeUpdate("insert into chatting values('"+id+"', '"+name+"','" + comment + "','"+date+"');");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized ArrayList<String> SET_CHAT(String start, String end) {
		ResultSet result;
		ArrayList<String> query = new ArrayList<String>();
		String strTemp="";
		query.clear();
		int i=0;
		try {
			int size = 0;
			result = stmt.executeQuery("select Count(id) from chatting;");
			while (result.next()){
				size = result.getInt(1);
				
			}
			if((size - Integer.parseInt(start) - Integer.parseInt(end)) < 0){ //더없어
				if(Integer.parseInt(start) == 0){ //근데 첨이야.. 그니깐 대화내용이 별로없는 초기에만 필요한거
					result = stmt.executeQuery("select * from chatting;");
					while (result.next()){
						strTemp += result.getString(1)+_del;;
						strTemp += result.getString(2)+_del;
						strTemp += result.getString(3)+_del;
						strTemp += result.getString(4)+_endDel;
						
						if(i%50==0 && i!=0){
							query.add(strTemp);
							strTemp = "";
							
						}
						if(i>100)
							break;
						
						//System.out.println("send comment data: " + strTemp);
						i++;
					}
					strTemp += "0"+_del+_endDel;
					query.add(strTemp);
					return query;
				}
				
				strTemp += "0"+_del+_endDel;
				query.add(strTemp);
				return query;
			}
			
			
			result = stmt.executeQuery("select * from chatting limit "+(size - Integer.parseInt(start) - Integer.parseInt(end))+","+end+";");
			while (result.next()){
				strTemp += result.getString(1)+_del;;
				strTemp += result.getString(2)+_del;
				strTemp += result.getString(3)+_del;
				strTemp += result.getString(4)+_endDel;
				
				if(i%50==0 && i!=0){
					query.add(strTemp);
					strTemp = "";
					
				}
				if(i>100)
					break;
				
				//System.out.println("send comment data: " + strTemp);
				i++;
			}
			strTemp += "0"+_del+_endDel;
			query.add(strTemp);
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}

}