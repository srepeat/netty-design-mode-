package com.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * �ͻ���
 * @author ����
 *
 */

public class Client {

	public static void main(String[] args) {
		//��������
		Bootstrap bootstrap = new Bootstrap();
		
		//���ô���boos�����˿�
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try {
			bootstrap.group(worker);
			
			//��������
			bootstrap.channel(NioSocketChannel.class);
			
			//��������
			bootstrap.handler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel ch) throws Exception {
						ch.pipeline().addLast(new StringEncoder());
						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new ClineHandler());
				}
			});
			
			//��IP�Ͷ˿�
			ChannelFuture connect = bootstrap.connect("127.0.0.1", 10101);
			//IO��ȡ��д��
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			//ѭ����ȡ
			while(true) {
				System.err.println("������:");
				String readLine = bufferedReader.readLine();
				//д���ȡ��һ��
				connect.channel().writeAndFlush(readLine);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			worker.shutdownGracefully();
		}
		
		
	}
}