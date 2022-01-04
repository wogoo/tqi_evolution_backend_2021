package com.wogoo.tqbank.tqbank.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}