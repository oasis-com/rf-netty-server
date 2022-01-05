package com.oasis

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

class MsgServerHandler : ChannelInboundHandlerAdapter() {

    override fun channelActive(ctx: ChannelHandlerContext) {
        println("Channel Active ${ctx.channel().remoteAddress()}")
    }

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        println("接收到客户端消息：msg: $msg")

        ctx.writeAndFlush(msg)
    }

    override fun channelInactive(ctx: ChannelHandlerContext) {
        println("客户端断开链接" + ctx.channel().localAddress().toString())
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        cause?.printStackTrace()
        ctx?.close()
    }
}