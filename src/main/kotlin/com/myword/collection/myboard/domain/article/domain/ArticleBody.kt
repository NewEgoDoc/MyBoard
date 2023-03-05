package com.myword.collection.myboard.domain.article.domain

import com.myword.collection.myboard.exception.ErrorCode
import com.myword.collection.myboard.exception.ErrorCode.*
import com.myword.collection.myboard.exception.validate
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Lob

@Embeddable
class ArticleBody (
    @Lob
    @Column(name = "body")
    val value: String
){
    init {
        validate(this.value.isNotBlank()) { REQUIRED }
    }
}
