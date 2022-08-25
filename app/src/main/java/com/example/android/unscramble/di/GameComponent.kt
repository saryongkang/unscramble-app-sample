package com.example.android.unscramble.di

import com.example.android.unscramble.ui.game.GameFragment
import dagger.Subcomponent

@Subcomponent
interface GameComponent {
  @Subcomponent.Factory
  interface Factory {
    fun create(): GameComponent
  }

  fun inject(gameFragment: GameFragment)
}