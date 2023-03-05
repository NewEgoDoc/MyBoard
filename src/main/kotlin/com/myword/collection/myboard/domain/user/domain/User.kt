package com.myword.collection.myboard.domain.user.domain

import com.myword.collection.myboard.support.BaseAggregateRoot

class User (
    /** 이메일 **/
    var email: UserEmail,

): BaseAggregateRoot<User>() {

}
