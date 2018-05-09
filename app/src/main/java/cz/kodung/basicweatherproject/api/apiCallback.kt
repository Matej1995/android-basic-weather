package cz.kodung.basicweatherproject.api

interface ApiCallback<T> {
    fun onSuccess(objects: T)
    fun onError(e: Throwable)
}