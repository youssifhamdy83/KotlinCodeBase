package com.youssif.youssifcodebase.repository.db.article

import androidx.lifecycle.LiveData
import androidx.room.*


/**
 * Created by Youssif Hamdy on 11/2/2022.
 */
@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long // long returned is the id that generated

    // it will be a normal fun because it will return a live data object and that doesn't work with suspend functions
    @Query("SELECT * FROM Article")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)


}