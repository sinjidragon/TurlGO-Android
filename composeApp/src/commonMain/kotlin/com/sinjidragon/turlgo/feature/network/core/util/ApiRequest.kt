package com.sinjidragon.turlgo.feature.network.core.util


import com.sinjidragon.turlgo.feature.network.core.model.DefaultResponse
import com.sinjidragon.turlgo.feature.network.core.model.Response
import com.sinjidragon.turlgo.feature.network.exception.BadRequestException
import com.sinjidragon.turlgo.feature.network.exception.ConflictException
import com.sinjidragon.turlgo.feature.network.exception.DataNotFoundException
import com.sinjidragon.turlgo.feature.network.exception.ForbiddenException
import com.sinjidragon.turlgo.feature.network.exception.LockedException
import com.sinjidragon.turlgo.feature.network.exception.NotFoundException
import com.sinjidragon.turlgo.feature.network.exception.TooManyRequestsException
import com.sinjidragon.turlgo.feature.network.exception.UnauthorizedException
import com.sinjidragon.turlgo.feature.network.exception.InternalServerException

suspend inline fun <T> safeRequest(crossinline request: suspend () -> Response<T>): T {
    val response = request()
    return when (response.status) {
        200, 201, 204 -> response.data ?: throw DataNotFoundException(response.message)
        400 -> throw BadRequestException(response.message)
        401 -> throw UnauthorizedException(response.message)
        403 -> throw ForbiddenException(response.message)
        404 -> throw NotFoundException(response.message)
        409 -> throw ConflictException(response.message)
        423 -> throw LockedException(response.message)
        429 -> throw TooManyRequestsException(response.message)
        500 -> throw InternalServerException(response.message, response.status)
        else -> throw Exception(response.message)
    }
}

suspend inline fun defaultSafeRequest(crossinline request: suspend () -> DefaultResponse) {
    val response = request()
    return when (response.status) {
        200, 201, 204 -> Unit
        400 -> throw BadRequestException(response.message)
        401 -> throw UnauthorizedException(response.message)
        403 -> throw ForbiddenException(response.message)
        404 -> throw NotFoundException(response.message)
        409 -> throw ConflictException(response.message)
        423 -> throw LockedException(response.message)
        429 -> throw TooManyRequestsException(response.message)
        500 -> throw InternalServerException(response.message, response.status)
        else -> throw Exception(response.message)
    }
}
