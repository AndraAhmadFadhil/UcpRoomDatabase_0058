package com.example.pampertemuan11.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pampertemuan11.MarketApp

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeBrgViewModel(
                MarketApp().ContainerApp.repositoryBrg
            )
        }
        initializer {
            InsertBrgViewModel(
                MarketApp().ContainerApp.repositoryBrg
            )
        }
        initializer {
            DetailBrgViewModel(
                createSavedStateHandle(),
                MarketApp().ContainerApp.repositoryBrg
            )
        }
        initializer {
            UpdateBrgViewModel(
                createSavedStateHandle(),
                MarketApp().ContainerApp.repositoryBrg
            )
        }
        initializer {
            HomeSplViewModel(
                MarketApp().ContainerApp.repositorySpl
            )
        }
        initializer {
            InsertSplViewModel(
                MarketApp().ContainerApp.repositorySpl
            )
        }
    }
}

fun CreationExtras.MarketApp(): MarketApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MarketApp)