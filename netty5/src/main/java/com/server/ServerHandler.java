package com.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void messageReceived(ChannelHandlerContext context, String msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(msg);
		
		//��Ӧ�ͻ���
		context.channel().writeAndFlush("hi");
		context.writeAndFlush("haha");
		
	}


}
