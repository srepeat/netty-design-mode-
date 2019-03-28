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
 * ������
 * @author ����
 *
 */
public class MultClient {

	//����
	private Bootstrap bootstrap = new Bootstrap();
	
	//�߳�����
	private List<Channel> channels = new ArrayList<>();
	
	//���������
	private final AtomicInteger index = new AtomicInteger();
	
	//��ʼ������
	public void init(int count) {
		
		//�����̳߳�
		EventLoopGroup worker = new NioEventLoopGroup();
		
		//�����߳�
		bootstrap.group(worker);
		
		//��������
		bootstrap.channel(NioSocketChannel.class);
		
		//����
		bootstrap.handler(new ChannelInitializer<Channel>() {

			@Override
			protected void initChannel(Channel ch) throws Exception {
				// TODO Auto-generated method stub
				ch.pipeline().addLast(new StringEncoder());
				ch.pipeline().addLast(new StringDecoder());
				ch.pipeline().addLast(new ClineHandler());
			}
		});
		 
		//ѭ������
		for (int i = 1; i < count; i++) {
			//��ÿһ����ַ���ӵ��̳߳���
			ChannelFuture future = bootstrap.connect("127.0.0.1", 10101);
			channels.add(future.channel());
		}
	}
	
	//��ȡ�Ự
	public Channel nextChannel() {
		//��ʼֵΪ0
		return getFirstActiveChannel(0);
	}
	
	private Channel getFirstActiveChannel(int count) {
		//ʹ�ü������������̵߳ķ���
		Channel channel = channels.get(Math.abs(index.getAndIncrement()% channels.size()) );
		if(!channel.isActive()) {
			//����
			reconnect(channel);
			//��������жϾ��ֶ��׳�ִ��ʱ�쳣
			if(count <= channels.size()) {
				throw new RuntimeException("no can user channel");
			}
			return getFirstActiveChannel(count+1);
		}
		return channel;
	}
	
	//����
	private void reconnect(Channel channel) {
		//�߳�ͬ��������Ҳ��������������
		synchronized (channel) {
			//�����ǰ��һ������-1��ֱ�ӷ���
			if (channels.indexOf(channel) == -1) {
				return;
			}
			//�ڴγ�����������
			Channel newChannel = bootstrap.connect("127.0.0.1", 10101).channel();
			channels.set(channels.indexOf(channel), newChannel);
		}
	}
	
	
	
}
