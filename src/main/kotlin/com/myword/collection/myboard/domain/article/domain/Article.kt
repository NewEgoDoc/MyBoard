package com.myword.collection.myboard.domain.article.domain

import com.myword.collection.myboard.domain.tag.domain.Tag
import com.myword.collection.myboard.domain.user.domain.User
import com.myword.collection.myboard.support.BaseAggregate
import com.myword.collection.myboard.support.BaseAggregateRoot
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne

@Entity
class Article(

//    TODO: 작성자
//    /** 작성자 **/
//    @ManyToOne(fetch = FetchType.LAZY)
//    val author: User,

    /** 제목 **/
    var title: ArticleTitle,

    /** 내용 **/
    var body: ArticleBody,

    /** 태그 **/
    @ManyToMany
    var tags: MutableList<Tag> = mutableListOf()
) : BaseAggregateRoot<Article>() {
    fun withTag(tag: Tag) {
        this.tags.add(tag)
    }

    companion object {
        fun create(title: ArticleTitle, body: ArticleBody): Article {
            return Article(title, body)
        }
    }
}