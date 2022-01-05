package com.oasis.protocol

data class NettyMessage(val header: Header, val body: Any)

data class Header(
    val crcCode: Long = 0xabef0101,
    val length: Int, // 消息长度
    val sessionID: Long, // 会话ID
    val byte: Byte, // 消息类型
    val priority: Byte, // 消息优先级
    val attachment: HashMap<String, Any>
)