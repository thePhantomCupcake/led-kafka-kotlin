package com.epiuse.labs.training.sekret.anonymizer

interface Anonymizer<I, O> {

    fun anonymize(input: I): O
}