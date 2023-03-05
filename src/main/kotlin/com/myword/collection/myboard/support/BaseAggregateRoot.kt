package com.myword.collection.myboard.support

import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class BaseAggregateRoot<A: BaseAggregateRoot<A>> : BaseAggregate() {
}