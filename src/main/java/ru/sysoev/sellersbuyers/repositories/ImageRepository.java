package ru.sysoev.sellersbuyers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sysoev.sellersbuyers.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
