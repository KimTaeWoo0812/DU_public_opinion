package Process;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import io.netty.channel.ChannelHandlerContext;

 

public class ProcessThread {
//	public static HashMap<String, ChannelHandlerContext> clients;

	
	static DB Db;
	public static String strMsg = "";
	public static String _del="";
	public static String _endSendDel="";
	static int n_txtName = 1;
	static boolean isPrint = true;
	static String notice = "";
	static volatile boolean hasNotice = false;
	//public static volatile SocketChannel sc[] = new SocketChannel[300];
	//public static volatile String queue[]= new String[300];
	//public static volatile int top=0;
	//public static volatile int rear=0;
	//public final static int QUEUESIZE=300;
	//public boolean stopThread = true;
	
	public ProcessThread( ){
		Db = new DB();
		_del+=(char)200;
		_endSendDel+=(char)202;
//		clients = new HashMap<String, ChannelHandlerContext>();
	}
	public void Manage_execute(String msg[],ChannelHandlerContext sc){
		SendMessage(sc, Db.Manage_execute(msg[1],msg[2])+"\n");
	}
	public void Manage_Update(String msg[],ChannelHandlerContext sc){
		Db.Manage_Update(msg[1]);
	}
//	public synchronized static void test(SocketChannel sc) throws IOException
//	{
//		FileInputStream f_in=new FileInputStream("F:/test/b.jpg"); 
//		// getChannel()�몴占� 占쎌깈�빊�뮉鍮먲옙苑� FileChannel揶쏆빘猿쒐몴占� 占쎈섯占쎈뮉占쎈뼄.
//		FileChannel in=f_in.getChannel();
//
//		//獄쏅뗄�뵠占쎈뱜 甕곌쑵�쓠 占쎄문占쎄쉐. 占쎌뵠占쎈르 甕곌쑵�쓠占쎌벥 占쎄쾿疫꿸퀡�뮉 占쎌겱占쎌삺 占쎈솁占쎌뵬占쎌벥 占쎄쾿疫꿸퀡彛뷂옙寃� 筌띾슢諭븝옙�뼄.
//		// 占쎈솁占쎌뵬占쎌벥 占쎄쾿疫꿸퀡�뮉 �뵳�뗪쉘占쎈릭占쎈뮉 size()占쎈뮉 long占쎌굨占쎌뱽 �뵳�뗪쉘占쎈릭沃섓옙嚥∽옙 int占쎌굨占쎌몵嚥∽옙 筌�癒��뮞占쎈샒占쎈립占쎈뼄.
//		ByteBuffer buf2=ByteBuffer.allocate((int)in.size());
//		//in.read(buf2);
//		System.out.println("asd");
//		sc.write(buf2);
//		
//	}
	
	
	public synchronized static void SendMessage(ChannelHandlerContext sc,String message)
	{
		System.out.println("보내는 메시지: "+message);
		sc.write(message + _del + _endSendDel);
		sc.flush();
	}
	
	
	
	public static synchronized void NEW_ID_CHECK(String Msg[], ChannelHandlerContext sc)
	{
		String msg = Db.NEW_ID_CHECK(Msg[1],Msg[2],Msg[3]);
		SendMessage(sc,msg+"\n");
	}
	public static synchronized void NEW_JOIN_US(String Msg[], ChannelHandlerContext sc)
	{
		String msg = Db.NEW_JOIN_US(Msg[1],Msg[2]);
		SendMessage(sc,"NEW_JOIN_US"+_del+msg+_del+"\n");
	}
	public static synchronized void NEW_LOGIN(String Msg[], ChannelHandlerContext sc)
	{
		ServerManage.countAccept++;
		String msg = Db.NEW_LOGIN(Msg[1]);
		SendMessage(sc,"NEW_LOGIN"+_del+msg+_del+"\n");
	}
	
	
	
	
	
	
	
	
	public synchronized static void LoginOut(ChannelHandlerContext sc)//�뜝�룞�삕�뜝�뙂�벝�삕 �뜝�룞�삕�뜝�룞�삕梨꾢뜝�룞�삕�뜝�룞�삕 id�뜝�룞�삕 李얍뜝�떍�눦�삕 DB�뜝�룞�삕 isLogin�뜝�룞�삕 0�뜝�룞�삕�뜝�룞�삕 �뜝�뙐袁쇰뙋�삕.
	{
//		Set key = clients.keySet();
//		  for (Iterator iterator2 = key.iterator(); iterator2.hasNext();)
//		  {
//			  String keyName = (String) iterator2.next();
//			  if(sc.equals(clients.get(keyName)))
//			  {
//				  String id = keyName;
//				  clients.remove(id);
//				  if(isPrint)
//					  System.out.println("Logout id: "+id);
//				  Db.LoginOut(id);
//				sc.close();
//				  
//				  
//				  return;
//			  }
//		  }
	}
	
	public static synchronized void CHANGE_IP(String Msg[], ChannelHandlerContext sc)
	{
//		clients.remove(Msg[1]);
//		clients.put(Msg[1], sc);
		
	}
	
	public static synchronized void LOGIN(String Msg[], ChannelHandlerContext sc)
	{
		String name="";
		
		int msg=Db.Login(Msg[1], Msg[2]);
		String commentNum = "0";
		
		if(msg==1||Msg[2].compareTo("1") == 0)//占쎌젔占쎈꺗.. 占쎈퉸占쎈룴筌띾벊肉� 筌�袁④섯 占쏙옙占쎌삢
		{
			System.out.println("嚥≪뮄�젃占쎌뵥 占쎄쉐�⑨옙!");
//			clients.put(Msg[1], sc);
			//Db.ChangeLogin(Msg[1]);
			
			name = Db.GetName(Msg[1]);
			
			commentNum = Db.GetCommentNum(Msg[1]);
		}
		ServerManage.countAccept++;
		strMsg="LOGIN"+_del+Integer.toString(msg)+_del + name + _del + commentNum + _del;
	
		SendMessage(sc,strMsg);
	}
	
	//占쎄텢占쎌뒠占쎌쁽 占쎌벥野껓옙 獄쏆룄由�. txt 占쎈솁占쎌뵬 占쎌뿯�빊�뮆�젾占쎌몵嚥∽옙 占쏙옙占쎌삢
	public static synchronized void OPINOION(String Msg[], ChannelHandlerContext sc)
	{
		Db.opinion(Msg[1],Msg[2],Msg[3]);
	}
	public static synchronized void SHOW_OPINOION(String Msg[], ChannelHandlerContext sc)
	{
		String msg = Db.SHOW_OPINOION();
		SendMessage(sc,msg+"\n");
	}
	
	public static synchronized void NOTICE(String Msg[], ChannelHandlerContext sc)
	{
		System.out.println(hasNotice);
		if(!hasNotice)
			strMsg="NOTICE"+_del+ "0" + _del;
		else
			strMsg="NOTICE"+_del+ "1" + _del + notice + _del;
		
		SendMessage(sc,strMsg);
	}
	
	public static synchronized void LOGOUT(String Msg[], ChannelHandlerContext sc)
	{
		LoginOut(sc);
	}
	
	public static synchronized void IDCHECK(String Msg[], ChannelHandlerContext sc)
	{
		int msg=Db.IdCheck(Msg[1]);
		
		strMsg="IDCHECK"+_del+Integer.toString(msg)+_del;
		SendMessage(sc,strMsg);
	}

	public static synchronized void JOIN_US(String Msg[], ChannelHandlerContext sc) {
	
		int msg = Db.JoinUs(Msg[1], Msg[2], Msg[3], Msg[4]);

		strMsg = "JOIN_US" + _del + Integer.toString(msg) + _del;

		SendMessage(sc, strMsg);
	}
	
	public static synchronized void rankingForAll(String Msg[], ChannelHandlerContext sc)
	{
    		String query = Db.rankingForAll();
    		
    		SendMessage(sc,query);
	}
	
	
	public static synchronized void RANKINGFORART(String Msg[], ChannelHandlerContext sc)
	{
    		String query = Db.RANKINGFORART();
    		
    		SendMessage(sc,query);
			
	}
	public static synchronized void SET_CLASS(String Msg[], ChannelHandlerContext sc)
	{
    		String query = Db.Set_Class(Msg[1]);
    		
    		SendMessage(sc,query);
			
    		
    		
	}
	public static synchronized void MAKE_CLASS(String Msg[], ChannelHandlerContext sc)
	{
    		char query = Db.Make_Class(Msg[1], Msg[2], Msg[3]);
    		
    		
    		SendMessage(sc,"MAKE_CLASS"+_del+query+_del);
			
    		//�뵳�뗪쉘 1: 占쎄쉐�⑨옙
    		//�뵳�뗪쉘 2: 占쎌뵠沃섓옙 占쎌뿳占쎈뮉 揶쏅벡伊�
    		//�뵳�뗪쉘 0: 占쎈뼄占쎈솭
	}
	public static synchronized void SAVE_COMMENT(String Msg[], ChannelHandlerContext sc)
	{
		//占쎈솊疫뀐옙, 癰귢쑬梨�, 占쎈즸占쎌젎
    		String query = Db.Save_Comment(Msg[1], Msg[2], Msg[3], Msg[4], Msg[5]);
    		
    		SendMessage(sc,"SAVE_COMMENT"+_del+query+_del);
			
    		//�뵳�뗪쉘 1=占쎄쉐�⑨옙  �뵳�뗪쉘 0=占쎈뼄占쎈솭
	}
	public static synchronized void COMMENT_GOOD(String Msg[], ChannelHandlerContext sc)
	{
		//占쎈솊疫뀐옙 甕곕뜇�깈
    		String temp = Db.COMMENT_GOOD(Msg[1], Msg[2], Msg[3]);
    		
    		SendMessage(sc,"COMMENT_GOOD"+_del+temp+_del);
	}
	public static synchronized void COMMENT_BAD(String Msg[], ChannelHandlerContext sc)
	{
    		//占쎈솊疫뀐옙 甕곕뜇�깈
    		String temp = Db.COMMENT_BAD(Msg[1],Msg[2], Msg[3]);
    		
    		SendMessage(sc,"COMMENT_BAD"+_del+temp+_del);
	}
	public static synchronized void DELETE_G_B(String Msg[], ChannelHandlerContext sc)
	{
    		
    		Db.DELETE_G_B(Msg[1],Msg[2]);
    		
	}
	public static synchronized void SET_COMMENT(String Msg[], ChannelHandlerContext sc)
	{
    		ArrayList<String> query = Db.SET_COMMENT(Msg[1]);
    		
    		for (int i = 0; i < query.size(); i++) {
    				try {
    					System.out.println("i 占쎈뮉? "+i);
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			
    			SendMessage(sc,query.get(i));
    		}
	}
	public static synchronized void REVISE_MY_COMMENT(String Msg[], ChannelHandlerContext sc)
	{
		Db.REVISE_MY_COMMENT(Msg[1], Msg[2], Msg[3], Msg[4]);
	}
	public static synchronized void CHANGE_NAME(String Msg[], ChannelHandlerContext sc)
	{
		Db.CHANGE_NAME(Msg[1], Msg[2]);
	}

	
	
	public static synchronized void SET_RESTAURANT(String Msg[], ChannelHandlerContext sc)
	{
    		String query = Db.SET_RESTAURANT();
    		
    		SendMessage(sc,query);
	}
	public static synchronized void SET_MENU(String Msg[], ChannelHandlerContext sc)
	{
    		String query = Db.SET_MENU(Msg[1]);
    		
    		SendMessage(sc,query);
	}
	public static synchronized void SAVE_GRADE(String Msg[], ChannelHandlerContext sc)
	{
    		Db.SAVE_GRADE(Msg[1], Msg[2], Msg[3]);
	}
	

	public static synchronized void SAVE_REVIEW(String Msg[], ChannelHandlerContext sc)
	{
		Db.SAVE_REVIEW(Msg[1],Msg[2],Msg[3],Msg[4],Msg[5]);
	}
	public static synchronized void SET_REVIEW(String Msg[], ChannelHandlerContext sc)
	{
		ArrayList<String> query = Db.SET_REVIEW(Msg[1]);
		
//		System.out.println("test: "+query.size());
		for (int i = 0; i < query.size(); i++) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			SendMessage(sc,query.get(i));
		}
	}
	public static synchronized void DELETE_REVIEW(String Msg[], ChannelHandlerContext sc)
	{
		Db.DELETE_REVIEW(Msg[1]);
	}
	public static synchronized void SAVE_CHAT(String Msg[], ChannelHandlerContext sc)
	{
		Db.SAVE_CHAT(Msg[1],Msg[2],Msg[3],Msg[4]);
	}
	public static synchronized void SET_CHAT(String Msg[], ChannelHandlerContext sc)
	{
		ArrayList<String> query = Db.SET_CHAT(Msg[1],Msg[2]);
		
//		System.out.println("test: "+query.size());
		for (int i = 0; i < query.size(); i++) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			SendMessage(sc,query.get(i));
		}
	}
}
