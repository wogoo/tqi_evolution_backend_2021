package com.wogoo.tqbank.tqbank.controller.response

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrroResponse>?
)
