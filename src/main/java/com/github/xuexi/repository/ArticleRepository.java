package com.github.xuexi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.xuexi.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String>{

}
