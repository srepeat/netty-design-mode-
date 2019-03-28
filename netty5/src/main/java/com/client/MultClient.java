package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
 * 对象组
 * @author 鲜磊
 *
 */
public class MultClient {

	//服务
	private Bootstrap bootstrap = new Bootstrap();
	
	//线程容器
	private List<Channel> channels = new ArrayList<>();
	
	//引入计数器
	private final AtomicInteger index = new AtomicInteger();
	
	//初始化方法
	public void init(int count) {
		
		//创建线程池
		EventLoopGroup worker = new NioEventLoopGroup();
		
		//管理线程
		bootstrap.group(worker);
		
		//创建工厂
		bootstrap.channel(NioSocketChannel.class);
		
		//过滤
		bootstrap.handler(new ChannelInitializer<Channel>() {

			@Override
			protected void initChannel(Channel ch) throws Exception {
				// TODO Auto-generated method stub
				ch.pipeline().addLast(new StringEncoder());
				ch.pipeline().addLast(new StringDecoder());
				ch.pipeline().addLast(new ClineHandler());
			}
		});
		 
		//循环遍历
		for (int i = 1; i < count; i++) {
			//将每一个地址添加到线程池中
			ChannelFuture future = bootstrap.connect("127.0.0.1", 10101);
			channels.add(future.channel());
		}
	}
	
	//获取会话
	public Channel nextChannel() {
		//初始值为0
		return getFirstActiveChannel(0);
	}
	
	private Channel getFirstActiveChannel(int count) {
		//使用计算类来计算线程的分配
		Channel channel = channels.get(Math.abs(index.getAndIncrement()% channels.size()) );
		if(!channel.isActive()) {
			//重连
			reconnect(channel);
			//如果连接中断就手动抛出执行时异常
			if(count <= channels.size()) {
				throw new RuntimeException("no can user channel");
			}
			return getFirstActiveChannel(count+1);
		}
		return channel;
	}
	
	//重连
	private void reconnect(Channel channel) {
		//线程同步，但是也会容易引起阻塞
		synchronized (channel) {
			//如果当前第一个等于-1就直接返回
			if (channels.indexOf(channel) == -1) {
				return;
			}
			//在次尝试重新连接
			Channel newChannel = bootstrap.connect("127.0.0.1", 10101).channel();
			channels.set(channels.indexOf(channel), newChannel);
		}
	}
	
	
	
}

