package com.epiuse.labs.training.sekret.anonymizer

class AnonymizerPipeline<T> {

    private var steps: MutableList<(T) -> T> = mutableListOf()

    fun addSteps(vararg stps: (T) -> T): AnonymizerPipeline<T> {
        steps.addAll(stps)
        return this
    }

    fun addStep(step: (T) -> T):AnonymizerPipeline<T> {
        steps.add(step)
        return this
    }

    fun execute(input: T): T {
        return steps.fold(input) { value, f -> f(value)}
    }
}