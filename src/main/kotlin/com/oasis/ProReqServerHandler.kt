package com.oasis

import com.oasis.protobuf.ProductReqOuterClass
import com.oasis.protobuf.ProductRespOuterClass
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

class ProReqServerHandler : ChannelInboundHandlerAdapter() {

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        val req = msg as ProductReqOuterClass.ProductReq

        if (req.reqId == 1) {
            println("接收到客服端请求（ProductReq）：\n， $req")

            ctx.writeAndFlush(proResp(req.reqId))
        }
    }

    private fun proResp(reqId: Int): ProductRespOuterClass.ProductResp? {
        return ProductRespOuterClass.ProductResp.newBuilder()
            .setReqId(reqId)
            .setRespCode(0)
            .setDesc("Product order succeed")
            .build()
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        cause?.printStackTrace()
        ctx?.close()
    }
}