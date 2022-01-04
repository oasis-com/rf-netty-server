package com.oasis

object App {

    @JvmStatic
    fun main(args: Array<String>) {
        RFServer().bind(10086)
    }
}