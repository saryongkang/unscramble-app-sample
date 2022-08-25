package com.example.android.unscramble.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.example.android.unscramble.GameApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {
  @Provides
  fun providesContext(): Context = application

  @Provides
  fun providesApplication(): Application = application

  // TODO 임시 구현. Assisted Inject 로 대체후 삭제할 것
  @Provides
  fun providesSavedStateHandle(): SavedStateHandle = SavedStateHandle()
}