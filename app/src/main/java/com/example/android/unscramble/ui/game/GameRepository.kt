package com.example.android.unscramble.ui.game

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepository(
  context: Context,
  private val dataSource: GameDataSource = GameDataSource(context)
) {
  val highScore: Flow<Int> = dataSource.gamePreferencesFlow.map { it.highScore }

  suspend fun recordScore(score: Int) {
    dataSource.updateHighScore(score)
  }
}

