package com.example.todoapp.di

import android.app.Application
import androidx.room.Room
import com.example.todoapp.data.ToDoDatabase
import com.example.todoapp.data.ToDoRepository
import com.example.todoapp.data.ToDoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideToDoDatabase(app: Application): ToDoDatabase {
        return Room.databaseBuilder(
            app,
            ToDoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideToDoRepository(db: ToDoDatabase): ToDoRepository {
        return ToDoRepositoryImpl(db.dao)
    }
}