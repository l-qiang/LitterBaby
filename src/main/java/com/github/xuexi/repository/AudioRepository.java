package com.github.xuexi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.xuexi.entity.Audio;

@Repository
public interface AudioRepository extends JpaRepository<Audio, String>{

}
