package com.jinkyu.tv

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform