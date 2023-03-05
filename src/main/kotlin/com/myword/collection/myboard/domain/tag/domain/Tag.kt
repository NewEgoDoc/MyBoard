package com.myword.collection.myboard.domain.tag.domain

import com.myword.collection.myboard.exception.ErrorCode
import com.myword.collection.myboard.exception.validate
import com.myword.collection.myboard.support.BaseAggregateRoot
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Tag(
    @Column(length = MAXIMUM_LENGTH)
    val name: String
) : BaseAggregateRoot<Tag>() {
    init {
        validate(this.name.isNotBlank()) { ErrorCode.REQUIRED }
        validate(this.name.length <= MAXIMUM_LENGTH) { ErrorCode.INVALID_TAG_MAXIMUM_LENGTH }
    }

    companion object {
        const val MAXIMUM_LENGTH = 100
    }
}
