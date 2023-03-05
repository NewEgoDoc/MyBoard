package com.myword.collection.myboard.support

import org.springframework.data.repository.CrudRepository

fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T = findById(id).get()