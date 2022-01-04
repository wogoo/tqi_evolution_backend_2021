package com.wogoo.tqbank.tqbank.exception

class BadRequestException( override val message: String, val errorCode: String): Exception() {

}