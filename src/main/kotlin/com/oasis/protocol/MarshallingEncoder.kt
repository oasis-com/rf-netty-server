package com.oasis.protocol

import io.netty.buffer.ByteBuf
import io.netty.handler.codec.marshalling.MarshallingEncoder

class MarshallingEncoder {
    private val marshaller = MarshallingEncoder()
    fun encode(msg: Any, bArray: ByteBuf){

    }
}