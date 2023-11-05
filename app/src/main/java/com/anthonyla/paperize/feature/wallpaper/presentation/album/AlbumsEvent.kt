package com.anthonyla.paperize.feature.wallpaper.presentation.album

import com.anthonyla.paperize.feature.wallpaper.domain.model.AlbumWithWallpaper

sealed class AlbumsEvent {
    data object RefreshAlbums: AlbumsEvent()

    data class DeleteAlbumWithWallpapers(
        val albumWithWallpaper: AlbumWithWallpaper
    ): AlbumsEvent()
}