package com.example.android.unscramble.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameDataSource @Inject constructor(
  @ApplicationContext context: Context
) {
  private val dataStore = context.gameDataStore

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