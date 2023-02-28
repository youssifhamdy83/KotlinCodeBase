package com.ultimate.ultimatecodebase.repository

import com.ultimate.ultimatecodebase.repository.api.AppAPIs
import com.ultimate.ultimatecodebase.repository.db.ArticleDatabase
import javax.inject.Inject


/**
 * Created by Youssif Hamdy on 1/11/2023.
 */
class NewsRepository @Inject constructor(
    val mDb: ArticleDatabase,
    val appAPIs: AppAPIs
) {


    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) = appAPIs.getBreakingNews(countryCode,pageNumber)



}