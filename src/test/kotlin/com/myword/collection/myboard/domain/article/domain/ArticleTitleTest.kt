package com.myword.collection.myboard.domain.article.domain

import com.myword.collection.myboard.exception.ErrorCode
import com.myword.collection.myboard.exception.MyBoardException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ArticleTitleTest {
    @Test
    fun `ArticleTitle 생성 성공`() {
        //when
        val title = ArticleTitle("title")

        //then
        Assertions.assertThat(title).isEqualTo(ArticleTitle("title"))
    }

    @Test
    fun `ArticleTitle 생성 실패 - 공백`() {
        //when //then
        Assertions.assertThatExceptionOfType(MyBoardException::class.java)
            .isThrownBy { ArticleTitle(" ") }
            .withMessage(ErrorCode.REQUIRED.message)
    }

    @Test
    fun `ArticleTitle 생성 실패 - 최대 길이 초과`() {
        //when
        val title = (0 until ArticleTitle.MAXIMUM_LENGTH + 1).joinToString("")

        //then
        Assertions.assertThatExceptionOfType(MyBoardException::class.java)
            .isThrownBy { ArticleTitle(title) }
            .withMessage(ErrorCode.INVALID_ARTICLE_MINIMUM_LENGTH.message)
    }
}