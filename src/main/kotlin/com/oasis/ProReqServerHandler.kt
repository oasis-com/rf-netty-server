package com.oasis

import com.oasis.protobuf.ProductReqProto
import com.oasis.protobuf.ProductRespProto
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.util.internal.logging.Log4J2LoggerFactory
import io.netty.util.internal.logging.Slf4JLoggerFactory
import org.slf4j.LoggerFactory
import java.util.logging.Logger

class ProReqServerHandler : ChannelInboundHandlerAdapter() {
//    private val logger = LoggerFactory.getLogger(ProductReqProto::class.java.simpleName)

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        val req = msg as ProductReqProto.ProductReq

        if (req.reqId == 1) {
            println("接收到客服端请求（ProductReq）：\n， $req")

            ctx.writeAndFlush(proResp(req.reqId))
        }
    }

    private fun proResp(reqId: Int): ProductRespProto.ProductResp? {
        return ProductRespProto.ProductResp.newBuilder()
            .setReqId(reqId)
            .setRespCode(0)
            .setDesc("Product order succeed")
            .build()
    }

    override fun channelInactive(ctx: ChannelHandlerContext) {
        println("客户端断开链接" + ctx.channel().localAddress().toString())
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
//        logger.info("exception caught")
        cause?.printStackTrace()
        ctx?.close()
    }
}