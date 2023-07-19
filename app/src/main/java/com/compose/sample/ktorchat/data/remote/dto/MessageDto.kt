package com.compose.sample.ktorchat.data.remote.dto

import com.compose.sample.ktorchat.domain.model.Message
import kotlinx.serialization.Serializable
import java.text.DateFormat
import java.util.Date

@Serializable
data class MessageDto(
    val id: String,
    val username: String,
    val text: String,
    val timestamp: Long
) {

    fun toMessage(): Message {
        val date = Date(timestamp)
        val formattedDate = DateFormat
            .getDateInstance(DateFormat.DEFAULT)
            .format(date)

        return Message(
            username = username,
            text = text,
            formattedTime = formattedDate
        )
    }
}
