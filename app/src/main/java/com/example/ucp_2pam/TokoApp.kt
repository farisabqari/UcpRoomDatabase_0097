package com.example.ucp_2pam

import android.app.Application
import com.example.ucp_2pam.Data.dependenciesinjection.ContainerApp

class TokoApp: Application() {
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}