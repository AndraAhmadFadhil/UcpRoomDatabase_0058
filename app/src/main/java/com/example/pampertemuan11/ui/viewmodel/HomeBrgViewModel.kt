package com.example.pampertemuan11.ui.viewmodel

import com.example.pampertemuan11.data.entity.Barang

data class HomeBrgUiState(
    val listBrg: List<Barang> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)