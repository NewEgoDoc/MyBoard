package com.myword.collection.myboard.domain.article.domain

import com.myword.collection.myboard.domain.tag.domain.Tag
import com.myword.collection.myboard.fixture.createArticleBody
import com.myword.collection.myboard.fixture.createArticleTitle
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ArticleTest {
    @Test
    fun `Article 생성 성공`() {
        //when
        val article = Article(
            createArticleTitle(), createArticleBody(),
            mutableListOf(Tag("tag1"), Tag("tag2"))
        )

        //then
        assertThat(article.title).isEqualTo(createArticleTitle())
        assertThat(article.body).isEqualTo(createArticleBody())
        assertThat(article.tags).containsExactly(Tag("tag1"), Tag("tag2"))
    }
}