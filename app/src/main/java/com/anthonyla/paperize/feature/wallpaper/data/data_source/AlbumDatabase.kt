package com.anthonyla.paperize.feature.wallpaper.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anthonyla.paperize.feature.wallpaper.domain.model.Album
import com.anthonyla.paperize.feature.wallpaper.domain.model.Folder
import com.anthonyla.paperize.feature.wallpaper.domain.model.Wallpaper

@Database(
    entities = [Album::class, Wallpaper::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AlbumDatabase: RoomDatabase() {
    abstract val albumDao: AlbumDao
    companion object {
        const val DATABASE_NAME = "paperize_album_db"
    }
}