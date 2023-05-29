package ru.sysoev.sellersbuyers.util;

import lombok.Builder;
import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;
import ru.sysoev.sellersbuyers.models.Image;

import java.io.IOException;

@UtilityClass
public class GenerateImage {
    @Builder
    public Image getImageEntity(MultipartFile file) throws IOException {
        return Image.builder()
                .name(file.getName())
                .originalFileName(file.getOriginalFilename())
                .contentType(file.getContentType())
                .size(file.getSize())
                .data(file.getBytes())
                .build();
    }
}
