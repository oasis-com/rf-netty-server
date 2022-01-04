package com.oasis

import com.oasis.protobuf.ProductReqOuterClass
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.protobuf.ProtobufDecoder
import io.netty.handler.codec.protobuf.ProtobufEncoder
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender

class ServerChannelHandler : ChannelInitializer<SocketChannel>() {

    override fun initChannel(ch: SocketChannel) {
        // 用于半包处理
        ch.pipeline().addLast(ProtobufVarint32FrameDecoder())
        // ProtobufDecoder 解码器
        ch.pipeline().addLast(ProtobufDecoder(ProductReqOuterClass.ProductReq.getDefaultInstance()))
        ch.pipeline().addLast(ProtobufVarint32LengthFieldPrepender())
        ch.pipeline().addLast(ProtobufEncoder())
//        ch.pipeline().addLast(RFServerHandler())
        ch.pipeline().addLast(ProReqServerHandler())
    }
}