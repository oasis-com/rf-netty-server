package com.oasis

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel


class ServerChannelHandler : ChannelInitializer<SocketChannel>() {

    override fun initChannel(ch: SocketChannel) {
        ch.pipeline().addLast(RFServerHandler())
    }
}