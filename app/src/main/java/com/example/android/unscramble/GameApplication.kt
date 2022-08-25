package com.example.android.unscramble

import android.app.Application
import com.example.android.unscramble.di.AppComponent
import com.example.android.unscramble.di.AppModule
import com.example.android.unscramble.di.DaggerAppComponent

class GameApplication : Application() {
  val appComponent: AppComponent = DaggerAppComponent.builder()
    .appModule(AppModule(this))
    .build()
}