package com.example.pampertemuan11

import android.app.Application
import com.example.pampertemuan11.dependenciedinjection.ContainerApp

class MarketApp : Application() {
    lateinit var ContainerApp: ContainerApp

    override fun onCreate(){
        super.onCreate()

        ContainerApp = ContainerApp(this)
    }
}