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
 * 服务端
 * @author 鲜磊
 */
public class Server {
	public static void main(String[] args) {
		//创建服务
		ServerBootstrap bootstrap = new ServerBootstrap();
		//创建线程池
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		//创建NioSocket工厂
		bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
		
		//设置管道工厂
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				ChannelPipeline channels = Channels.pipeline();
				//过滤
				channels.addLast("decoder", new StringDecoder());
				channels.addLast("encoder", new StringEncoder());
				channels.addLast("helloHandler", new HelloHandler());
				return channels;
			}
		});
		
		//设置端口
		bootstrap.bind(new InetSocketAddress(10101));
		System.out.println("start");
	}

}
