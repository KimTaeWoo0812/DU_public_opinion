package Process;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;

public class a1_ProcessClass {
	ProcessThread process = null;
	
	public a1_ProcessClass(){
		process = new ProcessThread();
		
	}
	
	public synchronized ChannelFuture DoProcess(ChannelHandlerContext sc, String strMsg){
		String Msg[] = strMsg.split(ProcessThread._del);
//		System.out.println("\t\tget2: "+Msg[0]);

		switch (Msg[0]) {
		case "ROADING":
				System.out.println("ROADING"+ProcessThread._del);
				sc.write("ROADING"+ProcessThread._del+ProcessThread._endSendDel);
				sc.flush();
	    	   break;
	    	   
	       case "NEW_ID_CHECK":
	    	   process.NEW_ID_CHECK(Msg, sc);
	    	   break;
	       case "NEW_JOIN_US":
	    	   process.NEW_JOIN_US(Msg, sc);
	    	   break;
	       case "NEW_LOGIn":
	    	   process.NEW_LOGIN(Msg, sc);
	    	   break;
	    	   
	       case "LOGIN":
	    	   System.out.println("예전 로그인: "+Msg);
	    	   process.LOGIN(Msg, sc);
	    	   break;
	       case "LOGOUT":
	    	   process.LOGOUT(Msg, sc);
	    	   break;
	       case "IDCHECK":
	    	   process.IDCHECK(Msg, sc);
	    	   break;
	       case "JOIN_US":
	    	   process.JOIN_US(Msg, sc);
	    	   break;
	       case "SET_CLASS":
	    	   process.SET_CLASS(Msg, sc);
	    	   break;
	       case "MAKE_CLASS":
	    	   process.MAKE_CLASS(Msg, sc);
	    	   break;
	       case "SAVE_COMMENT":
	    	   process.SAVE_COMMENT(Msg, sc);
	    	   break;
	       case "COMMENT_GOOD":
	    	   process.COMMENT_GOOD(Msg, sc);
	    	   break;
	       case "COMMENT_BAD":
	    	   process.COMMENT_BAD(Msg, sc);
	    	   break;
	       case "REVISE_MY_COMMENT":
	    	   process.REVISE_MY_COMMENT(Msg, sc);
	    	   break;
	       case "SET_COMMENT":
	    	   process.SET_COMMENT(Msg, sc);
	    	   break;
	       case "NOTICE":
	    	   process.NOTICE(Msg, sc);
	    	   break;
	       case "OPINOION":
	    	   process.OPINOION(Msg, sc);
	    	   break;
	       case "DELETE_G_B":
	    	   process.DELETE_G_B(Msg, sc);
	    	   break;
	       case "CHANGE_IP":
	    	   process.CHANGE_IP(Msg, sc);
	    	   break;
	       case "RANKINGFORALL":
	    	   process.rankingForAll(Msg, sc);
	    	   break;
	       case "RANKINGFORART":
	    	   process.RANKINGFORART(Msg, sc);
	    	   break;
	       case "SHOW_OPINOION":
	    	   process.SHOW_OPINOION(Msg, sc);
	    	   break;
	    	   
	       case "SET_RESTAURANT":
	    	   process.SET_RESTAURANT(Msg, sc);
	    	   break;
	       case "SET_MENU":
	    	   process.SET_MENU(Msg, sc);
	    	   break;
	       case "SAVE_GRADE":
	    	   process.SAVE_GRADE(Msg, sc);
	    	   break;
	       case "CHANGE_NAME":
	    	   process.CHANGE_NAME(Msg, sc);
	    	   break;

	       case "SAVE_REVIEW":
	    	   process.SAVE_REVIEW(Msg, sc);
	    	   break;
	       case "SET_REVIEW":
	    	   process.SET_REVIEW(Msg, sc);
	    	   break;
	       case "DELETE_REVIEW":
	    	   process.DELETE_REVIEW(Msg, sc);
	    	   break;
	    	   
	       case "SAVE_CHAT":
	    	   process.SAVE_CHAT(Msg, sc);
	    	   break;
	       case "SET_CHAT":
	    	   process.SET_CHAT(Msg, sc);
	    	   break;
	    	   
	    	   
	    	   //관리
	       case "Manage_execute":
	    	   process.Manage_execute(Msg, sc);
	    	   break;
	       case "Manage_Update":
	    	   process.Manage_Update(Msg, sc);
	    	   break;
		default:
			break;
		}
		return null;
		
		
		
	}
}
