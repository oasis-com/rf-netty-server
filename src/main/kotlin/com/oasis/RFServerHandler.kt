package com.oasis

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter


class RFServerHandler : ChannelInboundHandlerAdapter() {

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        val buf = msg as ByteBuf
        // 获取缓冲区可读字节数，根据可读字节数创建byte数组
        val req = ByteArray(buf.readableBytes())
        // 将缓冲区的字节数组复制到新建的req数组中
        buf.readBytes(req)

        val body = String(req, Charsets.UTF_8)
        println("server 端接受：$body")

        // 异步发送应答消息给客户端
        ctx.write(Unpooled.copiedBuffer("server $body", Charsets.UTF_8))
    }

    override fun channelReadComplete(ctx: ChannelHandlerContext?) {
        //  将消息队列中的消息写入到SocketChannel中发送给对方
        ctx?.flush()
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        cause?.printStackTrace()
        ctx?.close()
    }

}