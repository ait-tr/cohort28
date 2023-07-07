package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;

public class AlbumImpl implements Album{
    Photo[] photos;
    int size; // quantity of photos

    public AlbumImpl(int capacity){ // создаем массив фотографий размером capacity
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        // проверка на переполнение, не нулевое фото, нельзя добавить существующее
        return false;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        return new Photo[0];
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return new Photo[0];
    }

    @Override
    public int size() {
        return size;
    }
}
