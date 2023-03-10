package com.myword.collection.myboard.domain.article.domain

import com.myword.collection.myboard.exception.ErrorCode
import com.myword.collection.myboard.exception.MyBoardException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class ArticleBodyTest {

    @Test
    fun `ArticleBody 생성 성공`() {
        //when
        val body = ArticleBody("body")

        //then
        assertThat(body).isEqualTo(ArticleBody("body"))
    }

    @Test
    fun `Article 생성 실패 - 공백 입력시`() {
        //when //then
        assertThatExceptionOfType(MyBoardException::class.java)
            .isThrownBy { ArticleBody(" ") }
            .withMessage(ErrorCode.REQUIRED.message)
    }
}