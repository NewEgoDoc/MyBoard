package com.myword.collection.myboard.domain.tag.service

import com.myword.collection.myboard.domain.tag.domain.Tag
import com.myword.collection.myboard.domain.tag.domain.TagRepository
import com.myword.collection.myboard.support.BaseServiceTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class TagRevisionCommandTest @Autowired constructor(
    private val tagRevisionUseCase: TagRevisionUseCase,
    private val tagRepository: TagRepository
) : BaseServiceTest() {

    @Test
    fun `태그 개정 - 첫번째 태그`() {
        val tag = Tag("tag")

        val amendedTag = tagRevisionUseCase.amend(tag)

        assertThat(amendedTag.name).isEqualTo(tag.name)
    }

    @Test
    fun `태그 개정 - 두번째 태그`() {
        val tag1 = Tag("tag")
        val tag2 = Tag("tag")

        val amendedTag1 = tagRevisionUseCase.amend(tag1)
        val amendedTag2 = tagRevisionUseCase.amend(tag2)

        assertThat(amendedTag2).isEqualTo(amendedTag1)
        assertDoesNotThrow { tagRepository.findByName("tag")!! }
    }
}