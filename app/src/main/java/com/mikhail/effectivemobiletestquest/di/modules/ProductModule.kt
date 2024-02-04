package com.mikhail.effectivemobiletestquest.di.modules

import androidx.lifecycle.SavedStateHandle
import com.mikhail.effectivemobiletestquest.di.annotations.ProductId
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ProductModule {
    @Provides
    @ProductId
    @ViewModelScoped
    fun provideProductId(
        savedStateHandle: SavedStateHandle
    ): String =
        savedStateHandle.get<String>("productId")
            ?: throw IllegalArgumentException("You have to provide randomNumber as parameter with type Int when navigating to details")
}