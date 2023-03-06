package com.myword.collection.myboard.domain.article.service

import com.myword.collection.myboard.domain.article.domain.Article
import com.myword.collection.myboard.domain.article.domain.ArticleBody
import com.myword.collection.myboard.domain.article.domain.ArticleRepository
import com.myword.collection.myboard.domain.article.domain.ArticleTitle
import com.myword.collection.myboard.domain.tag.domain.Tag
import com.myword.collection.myboard.domain.tag.service.TagRevisionUseCase
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

interface ArticleRegistrationUseCase {
    /**
     * 아티클 등록
     */
    fun register(title: ArticleTitle, body: ArticleBody,
                 tags: List<Tag>?
    ): Article
}

@Service
@Transactional
class ArticleRegistrationCommand(
    private val articleRepository: ArticleRepository,
    private val tagRevisionUseCase: TagRevisionUseCase
) : ArticleRegistrationUseCase {
    override fun register(
        title: ArticleTitle, body: ArticleBody, tags: List<Tag>?
    ): Article {

        val article = Article(title, body)

        tags?.forEach { tag ->
            val amendedTag = tagRevisionUseCase.amend(tag)

            article.withTag(amendedTag)
        }

        return articleRepository.save(article)
    }
}