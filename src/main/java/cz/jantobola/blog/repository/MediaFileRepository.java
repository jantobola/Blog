package cz.jantobola.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.jantobola.blog.domain.MediaFile;

@Repository
public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {

}