package com.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
/**
 * �����
 * @author ����
 *
 */
public class Server {

	public static void main(String[] args) {
		//��������
		ServerBootstrap bootstrap = new ServerBootstrap();
		
		//�����̳߳�boos worker
		EventLoopGroup boos = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try {
			//�����̳߳�
			bootstrap.group(boos, worker);
			//��������
			bootstrap.channel(NioServerSocketChannel.class);
			
			//���ùܵ�
			bootstrap.childHandler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel channel) throws Exception {
					// TODO Auto-generated method stub
					//���ù���
					channel.pipeline().addLast(new StringEncoder());
					channel.pipeline().addLast(new StringDecoder());
					channel.pipeline().addLast(new ServerHandler());
				}
			});
			
			
			//����TCP����
			bootstrap.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannal==>���������洢���ֽڳ���
			//socketά�ֻ������Ļ�Ծ�ȣ�����б�
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
			//�ر��ӳٷ���
			bootstrap.childOption(ChannelOption.TCP_NODELAY, true);
			
			
			//�󶨶˿�
			ChannelFuture future = bootstrap.bind(10101);
			
			System.out.println("server����!");
			//�ȴ�����˹ر�
			future.channel().closeFuture().sync();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			boos.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}