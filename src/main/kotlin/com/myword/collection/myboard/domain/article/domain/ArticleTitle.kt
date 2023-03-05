package com.myword.collection.myboard.domain.article.domain

import com.myword.collection.myboard.exception.ErrorCode
import com.myword.collection.myboard.exception.ErrorCode.*
import com.myword.collection.myboard.exception.validate
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class ArticleTitle(
    @Column(name = "title", length = MAXIMUM_LENGTH)
    val value: String
) {
    init {
        validate(this.value.isNotBlank()) { REQUIRED }
        validate(this.value.length <= MAXIMUM_LENGTH) { INVALID_ARTICLE_MINIMUM_LENGTH }
    }

    companion object {
        const val MAXIMUM_LENGTH = 300
    }
}
