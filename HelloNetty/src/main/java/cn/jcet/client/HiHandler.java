package cn.jcet.client;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class HiHandler extends SimpleChannelHandler {

	/**
	 * channel�ر�ʱ�򴥷�
	 */
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelClosed(ctx, e);
		System.out.println("channelClosed");
	}

	/**
	 * ������
	 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelConnected(ctx, e);
		System.out.println("channelConnected");
	}

	/**
	 * �����������Ѿ��������ر�ͨ��ʱ����
	 */
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelDisconnected(ctx, e);
		System.out.println("channelDisconnected");
	}

	/**
	 * �����쳣ִ��
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, e);
		System.out.println("exceptionCaught");
	}

	/**
	 * ������Ϣ
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(ctx, e);
		
		String s = (String) e.getMessage();
		System.out.println(s);
		//�ؿͻ�����Ϣ
		System.out.println("messageReceived");
	}

	
	
}