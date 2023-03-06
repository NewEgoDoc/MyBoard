package com.myword.collection.myboard.domain.article.service

import com.myword.collection.myboard.domain.article.domain.ArticleRepository
import com.myword.collection.myboard.domain.tag.domain.Tag
import com.myword.collection.myboard.fixture.createArticleBody
import com.myword.collection.myboard.fixture.createArticleTitle
import com.myword.collection.myboard.support.BaseServiceTest
import com.myword.collection.myboard.support.findByIdOrThrow
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.tuple
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class ArticleRegistrationCommandTest @Autowired constructor(
    private val articleRegistrationUseCase: ArticleRegistrationUseCase,
//    private val userRegistrationUseCase: UserRegistrationUseCase,
    private val articleRepository: ArticleRepository,
    private val entityManager: EntityManager
) : BaseServiceTest() {

    //private lateinit var user: User

    @BeforeEach
    fun setUp() {
        //user = userRegistrationUseCase.register(createUser())
    }

    @Test
    fun `아티클 등록`() {
        val article = articleRegistrationUseCase.register(
            createArticleTitle(), createArticleBody(),
            listOf(Tag("tag1"), Tag("tag2"))
        )

        entityManager.flush()
        entityManager.clear()

        val foundArticle = articleRepository.findByIdOrThrow(article.id)


        assertThat(foundArticle.tags)
            .extracting(Tag::name)
            .containsExactly(tuple("tag1"), tuple("tag2"))
    }
}