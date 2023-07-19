package com.compose.sample.ktorchat.data.remote

import com.compose.sample.ktorchat.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://192.168.0.105:8080"
    }

    sealed class EndPoints(val url: String) {
        object GetAllMessages : EndPoints("$BASE_URL/messages")
    }

}