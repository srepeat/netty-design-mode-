package cn.jcet.client;


import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
/**
 * channelDisconnected与channelClosed的区别？
		channelDisconnected只有在连接建立后断开才会调用
		channelClosed无论连接是否成功都会调用关闭资源
 * @author 鲜磊
 * 客户端
 *
 */

public class Client {

	public static void main(String[] args) {
		//创建客户端
		ClientBootstrap bootstrap = new ClientBootstrap();
		
		//线程池
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		//clientSocket客户端socket
		bootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));
		
		//设置管道工厂
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipeline = Channels.pipeline();
				//设置过滤器
				pipeline.addLast("decoder", new StringDecoder());
				pipeline.addLast("encoder", new StringEncoder());
				pipeline.addLast("hiHandler", new HiHandler());
				
				return pipeline;
			}
		});
		
		//获取服务端的IP和端口
		ChannelFuture connect = bootstrap.connect(new InetSocketAddress("127.0.0.1", 10101));
		Channel channel = connect.getChannel();
			
		System.out.println("client start!!");
		//键盘输入
		Scanner scanner = new Scanner(System.in);
		//死循环
		while(true) {
			System.out.println("请输入。。。");
			channel.write(scanner.next());
		}
	}
}
