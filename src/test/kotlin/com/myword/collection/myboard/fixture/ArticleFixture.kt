package com.myword.collection.myboard.fixture

import com.myword.collection.myboard.domain.article.domain.Article
import com.myword.collection.myboard.domain.article.domain.ArticleBody
import com.myword.collection.myboard.domain.article.domain.ArticleTitle

fun createArticle(
    //author: User = createUser(),
    title: ArticleTitle = createArticleTitle(),
    body: ArticleBody = createArticleBody()
): Article {
    return Article(title, body)
}

fun createArticleTitle(title: String = "title"): ArticleTitle {
    return ArticleTitle(title)
}

fun createArticleBody(body: String = "body"): ArticleBody {
    return ArticleBody(body)
}