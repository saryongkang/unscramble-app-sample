package com.example.android.unscramble.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepository @Inject constructor(
  private val dataSource: GameDataSource
) {
  val highScore: Flow<Int> = dataSource.gamePreferencesFlow.map { preferences -> preferences.highScore }

  suspend fun updateScore(score: Int) {
    dataSource.updateHighScore(score)
  }
}
