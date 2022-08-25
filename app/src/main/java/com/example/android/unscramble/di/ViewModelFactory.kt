package com.example.android.unscramble.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelBuilder {
  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

class ViewModelFactory @Inject constructor(
  private val providerMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    var provider: Provider<out ViewModel>? = providerMap[modelClass]
    if (provider == null) {
      for ((key, value) in providerMap) {
        if (modelClass.isAssignableFrom(key)) {
          provider = value
          break
        }
      }
    }
    requireNotNull(provider) { "Unknown ViewModel class: $modelClass" }
    @Suppress("UNCHECKED_CAST")
    return provider.get() as T
  }
}