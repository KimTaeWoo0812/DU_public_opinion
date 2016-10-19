package Server_main;

import java.sql.Date;
import java.text.SimpleDateFormat;

import Process.a1_ProcessClass;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@Sharable
public class a3_Server_Handler extends SimpleChannelInboundHandler<String> {

	a1_ProcessClass process = new a1_ProcessClass();
	
//	public a3_Server_Handler(){
//	System.out.println("\t\tget Msg:  "+getDate());
//	}
	
	//DB Db;
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, String request)
			throws Exception {
		System.out.println("\t\tget Msg: " + request+" "+getDate());
		
		ChannelFuture future = process.DoProcess(ctx, request);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		
	}
	static String getDate() {
		long time = System.currentTimeMillis(); 
        SimpleDateFormat f = new SimpleDateFormat("yyyy:MM:dd//hh:mm:ss");
        return f.format(new Date(time));
	}
}
