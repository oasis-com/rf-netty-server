package com.oasis

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.logging.LogLevel
import io.netty.handler.logging.LoggingHandler

class RFServer {

    fun bind(port: Int) {
        // 配置服务端的NIO线程组
        val bossGroup = NioEventLoopGroup()
        val workGroup = NioEventLoopGroup()

        try {
            val b = ServerBootstrap()
            b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel::class.java)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .handler(LoggingHandler(LogLevel.INFO))
                .childHandler(ServerChannelHandler())

            // 绑定端口，同步等待成功
            val f = b.bind(port).sync()

            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync()
        } finally {

            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully()
            workGroup.shutdownGracefully()
        }
    }
}