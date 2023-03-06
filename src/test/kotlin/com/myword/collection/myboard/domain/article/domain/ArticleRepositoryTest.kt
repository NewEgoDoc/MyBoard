package com.myword.collection.myboard.domain.article.domain

import com.myword.collection.myboard.fixture.createArticle
import com.myword.collection.myboard.support.BaseRepositoryTest
import com.myword.collection.myboard.support.findByIdOrThrow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class ArticleRepositoryTest @Autowired constructor(
    private val articleRepository: ArticleRepository
) : BaseRepositoryTest() {

    @Test
    fun `Article 생성 성공`() {
        val article = articleRepository.save(createArticle())

        assertThat(article.id).isNotNull

        val foundArticle = articleRepository.findByIdOrThrow(article.id)

        assertThat(foundArticle).isEqualTo(article)
    }
}