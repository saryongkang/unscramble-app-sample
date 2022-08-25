package com.example.android.unscramble.di

import com.example.android.unscramble.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, GameModule::class, ViewModelBuilder::class])
interface AppComponent {
  fun inject(activity: MainActivity)

  fun gameComponent(): GameComponent.Factory
}