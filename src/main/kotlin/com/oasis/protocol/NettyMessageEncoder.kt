package com.oasis.protocol

import com.google.protobuf.MessageLite
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder

class NettyMessageEncoder : MessageToMessageEncoder<NettyMessage>() {

    override fun encode(ctx: ChannelHandlerContext?, msg: NettyMessage, out: MutableList<Any>?) {

    }
}