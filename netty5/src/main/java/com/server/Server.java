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
 * 服务端
 * @author 鲜磊
 *
 */
public class Server {

	public static void main(String[] args) {
		//创建服务
		ServerBootstrap bootstrap = new ServerBootstrap();
		
		//创建线程池boos worker
		EventLoopGroup boos = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try {
			//设置线程池
			bootstrap.group(boos, worker);
			//创建工厂
			bootstrap.channel(NioServerSocketChannel.class);
			
			//设置管道
			bootstrap.childHandler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel channel) throws Exception {
					// TODO Auto-generated method stub
					//设置过滤
					channel.pipeline().addLast(new StringEncoder());
					channel.pipeline().addLast(new StringDecoder());
					channel.pipeline().addLast(new ServerHandler());
				}
			});
			
			
			//设置TCP参数
			bootstrap.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannal==>缓冲区所存储的字节长度
			//socket维持缓冲区的活跃度，清楚列表
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
			//关闭延迟发送
			bootstrap.childOption(ChannelOption.TCP_NODELAY, true);
			
			
			//绑定端口
			ChannelFuture future = bootstrap.bind(10101);
			
			System.out.println("server启动!");
			//等待服务端关闭
			future.channel().closeFuture().sync();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//释放资源
			boos.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}
