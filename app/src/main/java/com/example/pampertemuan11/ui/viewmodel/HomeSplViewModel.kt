package com.example.pampertemuan11.ui.viewmodel

import androidx.core.app.NotificationCompat.MessagingStyle.Message
import com.example.pampertemuan11.data.entity.Supplier

data class HomeSplUiState(
    val listSpl: List<Supplier> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)