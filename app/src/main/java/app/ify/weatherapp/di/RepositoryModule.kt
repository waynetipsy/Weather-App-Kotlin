package app.ify.weatherapp.di

import app.ify.weatherapp.repo.WeatherRepository
import app.ify.weatherapp.repo.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// Hilt Module: Used to tell Hilt how to provide
// dependencies that it can't figure out on its own
// Helps Hilt know how to bind interfaces to their
// implementations

 @Module  // a provider of dependencies
 @InstallIn(SingletonComponent::class) // Lives for whole app
 abstract class RepositoryModule {

  // @Binds: tells Hilt which implementation to use for an interface
  // @Singleton: Makes sure there's only one instance throughout the app
  @Binds
  @Singleton
  abstract fun bindWeatherRepository(
   weatherRepositoryImpl: WeatherRepositoryImpl
  ): WeatherRepository
}