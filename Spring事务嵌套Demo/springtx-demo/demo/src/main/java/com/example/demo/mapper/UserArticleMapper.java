package com.example.demo.mapper;

import com.example.demo.model.UserArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserArticleMapper {

    @Insert(" insert into user_article(articleId, userId, title, context) " +
            "values (#{articleId}, #{userId}, #{title}, #{context})")
    void insert(UserArticle userArticle);


}
