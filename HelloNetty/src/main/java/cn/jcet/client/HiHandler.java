package cn.jcet.client;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class HiHandler extends SimpleChannelHandler {

	/**
	 * channel关闭时候触发
	 */
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelClosed(ctx, e);
		System.out.println("channelClosed");
	}

	/**
	 * 新连接
	 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelConnected(ctx, e);
		System.out.println("channelConnected");
	}

	/**
	 * 必须是连接已经建立，关闭通道时触发
	 */
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelDisconnected(ctx, e);
		System.out.println("channelDisconnected");
	}

	/**
	 * 捕获异常执行
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, e);
		System.out.println("exceptionCaught");
	}

	/**
	 * 发送消息
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(ctx, e);
		
		String s = (String) e.getMessage();
		System.out.println(s);
		//回客户端消息
		System.out.println("messageReceived");
	}

	
	
}
