package com.chemical_son.retrofit.dataModel

data class TopHeadlinesResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)