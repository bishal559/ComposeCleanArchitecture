package com.bishal.data.model
/**
 *
 * Created by bishal adhikari on 07/10/2024
 * */
enum class ServerErrorCode(val description: String) {

    DEFAULT("Unknown Error");

    companion object {
        fun parse(errorCode: String) =
            values().find { it.name == errorCode.trim().uppercase() } ?: DEFAULT
    }
}