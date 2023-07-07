package ait.album.tests;

import ait.album.dao.Album;
import ait.album.dao.AlbumImpl;
import ait.album.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class AlbumImplTest {

    Album albums;
    LocalDateTime now = LocalDateTime.now();
    Photo[] ph = new Photo[6];

    @BeforeEach
    void setUp() {
        albums = new AlbumImpl(7);
        ph[0] = new Photo(1,1,"title1","url1",now.minusDays(7));
        ph[1] = new Photo(1,2,"title2","url2",now.minusDays(7));
        ph[2] = new Photo(1,3,"title3","url3",now.minusDays(5));
        ph[3] = new Photo(2,1,"title1","url1",now.minusDays(7)); // это фото 1 в другом альбоме
        ph[4] = new Photo(2,4,"title4","url4",now.minusDays(2));
        ph[5] = new Photo(1,4,"title4","url1",now.minusDays(2));

        // add photos to albums
        for (int i = 0; i < ph.length; i++) {
            albums.addPhoto(ph[i]);
        }
    }

    @Test
    void addPhoto() {

        // проверка на переполнение, не нулевое фото, нельзя добавить существующее
        assertFalse(albums.addPhoto(null)); // пустое фото
        assertFalse(albums.addPhoto(ph[1])); // уже имеющееся
        Photo photo = new Photo(1, 5, "title5", "url5", now.minusDays(3)); // это новое фото
        assertTrue(albums.addPhoto(photo));
        assertEquals(7, albums.size()); // ожидаем, что фото добавится
        photo = new Photo(1, 6, "title6", "url6", now.minusDays(3));
        assertFalse(albums.addPhoto(photo)); // ожидаем, что НЕ добавится, тк места уже нет

    }

    @Test
    void removePhoto() {
    }

    @Test
    void updatePhoto() {
    }

    @Test
    void getPhotoFromAlbum() {
    }

    @Test
    void getAllPhotoFromAlbum() {
    }

    @Test
    void getPhotoBetweenDate() {
    }

    @Test
    void size() {
    }
}