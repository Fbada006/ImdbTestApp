package com.example.tmdbtestapp.utils

object JsonHelper {

    val moshi by lazy {
        MoshiBuilder.create()
    }

    fun toJson(any: Any): String {
        val jsonAdapter = moshi.adapter(Any::class.java)
        return jsonAdapter.toJson(any)
    }

    inline fun <reified T> fromJson(json: String): T {
        val jsonAdapter = moshi.adapter(T::class.java)

        return jsonAdapter.fromJson(json) as T
    }
}