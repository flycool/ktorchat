package com.compose.sample.ktorchat.data.remote

import com.compose.sample.ktorchat.domain.model.Message
import com.compose.sample.ktorchat.util.Resource
import kotlinx.coroutines.flow.Flow


interface ChatSocketService {

    suspend fun initSession(username: String): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessage(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://192.168.0.105:8080"
    }

    sealed class EndPoints(val url: String) {
        object ChatSocket : EndPoints("$BASE_URL/chat-socket")
    }
}