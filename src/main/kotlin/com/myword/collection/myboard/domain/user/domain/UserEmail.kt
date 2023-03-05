package com.myword.collection.myboard.domain.user.domain

import com.myword.collection.myboard.exception.ErrorCode
import com.myword.collection.myboard.exception.validate
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class UserEmail(
    @Column(length = MAXIMUM_LENGTH, unique = true)
    val email: String
) {
    init {
        validate(email.isNotBlank()) { ErrorCode.REQUIRED }
        //validate(email.matches(Regex(EMAIL_REGEX))) { ErrorCode.INVALID_EMAIL }
        //validate(email.length <= MAXIMUM_LENGTH) { ErrorCode.INVALID_EMAIL_MAXIMUM_LENGTH }
    }

    override fun toString(): String {
        return email
    }

    companion object {
        const val MAXIMUM_LENGTH = 100
        const val EMAIL_REGEX = "^([\\w_.\\-+])+@([\\w\\-]+\\.)+([\\w]{2,10})+\$"
    }
}
