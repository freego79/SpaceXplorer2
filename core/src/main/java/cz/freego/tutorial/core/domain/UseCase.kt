package cz.freego.tutorial.core.domain

interface UseCase<in I, out O> {
    suspend operator fun invoke(input: I): O
}