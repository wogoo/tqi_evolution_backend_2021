package com.wogoo.tqbank.tqbank.exception

class AuthenticationException(override val message: String, val errorCode: String): Exception() {
}