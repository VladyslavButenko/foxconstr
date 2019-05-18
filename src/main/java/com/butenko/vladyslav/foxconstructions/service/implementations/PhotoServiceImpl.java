package com.butenko.vladyslav.foxconstructions.service.implementations;

import com.butenko.vladyslav.foxconstructions.model.photo.Photo;
import com.butenko.vladyslav.foxconstructions.repository.PhotoRepository;
import com.butenko.vladyslav.foxconstructions.service.interfaces.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static com.butenko.vladyslav.foxconstructions.util.validator.Validator.*;

@Service
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.repository")
public class PhotoServiceImpl extends MainServiceImpl<Photo> implements PhotoService {

    private final PhotoRepository repository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional
    public Photo get(String title) throws IllegalArgumentException,
            NullPointerException {

        if (isEmpty(title)) {
            throw new IllegalArgumentException("Wrong URL");
        }
        Photo photo = this.repository.findByTitle(title);
        if (isNull(photo)) {
            throw new NullPointerException("No photo by this title " + title + "!");
        }
        return photo;
    }

    @Override
    @Transactional
    public void remove(String title) {
        if (isNotEmpty(title)) {
            this.repository.deleteByTitle(title);
        }
    }

    @Override
    @Transactional
    public void saveFile(MultipartFile photo) {
        if (isNotEmpty(photo)) {
            String path = Photo.PATH + photo.getOriginalFilename();
            try (OutputStream stream = new FileOutputStream(path)) {
                stream.write(photo.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteFile(String url) {
        if (isNotEmpty(url)) {
            File file = new File(Photo.PATH + url);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
