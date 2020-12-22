package rr.kotlin.restful.api.controller

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import rr.kotlin.restful.api.error.NotFoundException
import rr.kotlin.restful.api.error.UnauthorizedException
import rr.kotlin.restful.api.model.WebRespone
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebRespone<String> {
        return WebRespone(
            code = 400,
            status = "Bad Request Bro",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundException(notFoundException: NotFoundException): WebRespone<String> {
        return WebRespone(
            code = 404,
            status = "Not Found Bro",
            data = "Not Found Bro"
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): WebRespone<String> {
        return WebRespone(
            code = 401,
            status = "UNAUTHORIZED",
            data = "Please put your API-KEY"
        )
    }

}