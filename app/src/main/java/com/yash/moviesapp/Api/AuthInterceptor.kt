package com.yash.moviesapp.Api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYTgwNDcyNTQ1Y2UyNWNjMDM5MWQxZWE2MzlkODFhYiIsInN1YiI6IjY1MDg3NGJiMTA5ZGVjMDEwY2MyYmY5OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-N5BIyPFGug2LtSOr5d2Fez9mvBmLvkN1fjmeLtZuVk"
        request.header("Authorization","Bearer $token")
        return chain.proceed(request.build())
    }
}