package com.epiuse.labs.training.sekret.model

data class User(
        val id: Long,
        var firstName: String,
        var lastName: String,
        var emailAddress: String
)