package com.myword.collection.myboard.domain.tag.domain

import com.myword.collection.myboard.domain.article.domain.ArticleTitle
import com.myword.collection.myboard.exception.ErrorCode
import com.myword.collection.myboard.exception.MyBoardException
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TagTest {

    @Test
    fun `Tag 생성 성공`() {
        val tag = Tag("tag")

        assertThat(tag.name).isEqualTo("tag")
    }

    @Test
    fun `공백이 있으면 생성 실패`() {
        assertThatExceptionOfType(MyBoardException::class.java)
            .isThrownBy { Tag(" ") }
            .withMessage(ErrorCode.REQUIRED.message)
    }

    @Test
    fun `최대길이 보다 크면 생성 실패`() {
        val tag = (0 until Tag.MAXIMUM_LENGTH + 1).joinToString("")

        assertThatExceptionOfType(MyBoardException::class.java)
            .isThrownBy { Tag(tag) }
            .withMessage(ErrorCode.INVALID_TAG_MAXIMUM_LENGTH.message)

    }
}
