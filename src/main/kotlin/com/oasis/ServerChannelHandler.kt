package com.oasis

import com.oasis.protocol.ProtobufDecoder
import com.oasis.protocol.ProtobufEncoder
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel


class ServerChannelHandler : ChannelInitializer<SocketChannel>() {

    override fun initChannel(ch: SocketChannel) {
        // 用于半包处理
        // ch.pipeline().addLast(ProtobufVarint32FrameDecoder())
        // ProtobufDecoder 解码器
        // ch.pipeline().addLast(ProtobufDecoder(ProductReqProto.ProductReq.getDefaultInstance()))
        // ch.pipeline().addLast(ProtobufVarint32LengthFieldPrepender())
        // ch.pipeline().addLast(ProtobufEncoder())

        ch.pipeline().addLast(ProtobufEncoder())
        ch.pipeline().addLast(ProtobufDecoder())

        // ch.pipeline().addLast(RFServerHandler())
        // ch.pipeline().addLast(ProReqServerHandler())

        ch.pipeline().addLast(MsgServerHandler())
    }
}