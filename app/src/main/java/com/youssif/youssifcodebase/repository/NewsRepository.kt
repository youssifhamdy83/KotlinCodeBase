package com.youssif.youssifcodebase.repository

import com.youssif.youssifcodebase.repository.api.AppAPIs
import com.youssif.youssifcodebase.repository.db.ArticleDatabase
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