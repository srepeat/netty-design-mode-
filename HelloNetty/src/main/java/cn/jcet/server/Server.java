package cn.jcet.server;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * �����
 * @author ����
 */
public class Server {
	public static void main(String[] args) {
		//��������
		ServerBootstrap bootstrap = new ServerBootstrap();
		//�����̳߳�
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		//����NioSocket����
		bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
		
		//���ùܵ�����
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				ChannelPipeline channels = Channels.pipeline();
				//����
				channels.addLast("decoder", new StringDecoder());
				channels.addLast("encoder", new StringEncoder());
				channels.addLast("helloHandler", new HelloHandler());
				return channels;
			}
		});
		
		//���ö˿�
		bootstrap.bind(new InetSocketAddress(10101));
		System.out.println("start");
	}

}