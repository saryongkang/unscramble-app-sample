package com.example.android.unscramble.data

import android.app.Application
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameDataSource @Inject constructor(
  application: Application
) {
  private val dataStore = application.gameDataStore

  val gamePreferencesFlow: Flow<GamePreferences> = dataStore.data.map { preferences ->
    val highScore = preferences[PreferenceKeys.HIGH_SCORE] ?: 0
    GamePreferences(highScore = highScore)
  }

  suspend fun updateHighScore(score: Int) {
    dataStore.edit { preferences ->
      val currentHighScore = preferences[PreferenceKeys.HIGH_SCORE] ?: 0
      if (currentHighScore < score) {
        preferences[PreferenceKeys.HIGH_SCORE] = score
      }
    }
  }
}