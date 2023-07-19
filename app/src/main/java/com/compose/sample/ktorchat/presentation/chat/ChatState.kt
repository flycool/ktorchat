package com.compose.sample.ktorchat.presentation.chat

import com.compose.sample.ktorchat.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
