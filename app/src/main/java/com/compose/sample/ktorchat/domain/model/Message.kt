package com.compose.sample.ktorchat.domain.model

data class Message(
    val username: String,
    val text: String,
    val formattedTime: String,
)
