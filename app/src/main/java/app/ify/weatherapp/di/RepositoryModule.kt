package app.ify.weatherapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// Hilt Module: Used to tell Hilt how to provide
// dependencies that it can't figure out on its own
// Helps Hilt know how to bind interfaces to their
// implementations

 @Module
 @InstallIn(SingletonComponent::class)
 abstract class RepositoryModule {
}