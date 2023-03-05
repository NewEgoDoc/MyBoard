package com.myword.collection.myboard.exception

import com.myword.collection.myboard.domain.article.domain.ArticleTitle
import com.myword.collection.myboard.domain.tag.domain.Tag
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class MyBoardException(errorCode: ErrorCode) : RuntimeException(errorCode.message)

enum class ErrorCode(
    val message: String
) {
    REQUIRED("필수값입니다."),

    /** 아티클 제목 */
    INVALID_ARTICLE_MINIMUM_LENGTH("아티클 제목 최대 길이 ${ArticleTitle.MAXIMUM_LENGTH} 보다 큽니다."),

    /** 태그 */
    INVALID_TAG_MAXIMUM_LENGTH("태그 이름 최대 길이 ${Tag.MAXIMUM_LENGTH} 보다 큽니다."),
}
/**
 * throws an [MyBoardException] with the result of calling [ErrorCode.message] if the [value] is false.
 */
@OptIn(ExperimentalContracts::class)
fun validate(value: Boolean, lazyErrorCode: () -> ErrorCode){
    contract {
        returns() implies value
    }
    if(!value) {
        val errorCode = lazyErrorCode()
        throw MyBoardException(errorCode)
    }
}