package com.compose.sample.ktorchat.data.remote

import com.compose.sample.ktorchat.data.remote.dto.MessageDto
import com.compose.sample.ktorchat.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MessageServiceImpl(
    private val client:HttpClient
) : MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {

            client.get(MessageService.EndPoints.GetAllMessages.url).body<List<MessageDto>>()
                .map { it.toMessage() }

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}