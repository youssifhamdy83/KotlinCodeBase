package com.ultimate.ultimatecodebase.repository.db

import android.content.Context
import androidx.room.*
import com.ultimate.ultimatecodebase.repository.db.article.Article
import com.ultimate.ultimatecodebase.repository.db.article.ArticleDao
import com.ultimate.ultimatecodebase.repository.db.article.Converters


/**
 * Created by Youssif Hamdy on 11/2/2022.
 */
@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        // Volatile means that other threads can immediately see when a thread changes this instance
        @Volatile
        private var instance: ArticleDatabase? = null

        // we will use that to synchronize setting that instance
        // that will really make sure that there is only a single instance of our database at once
        private val LOCK = Any()


        // called whenever we create an instance of our database
        // if case that the instance is null we want to start a synchronized block with our lock object
        // so that means that everything that happens inside of this block of code can't be accessed by other threads at the same time
        // so we really make sure that there is no another thread that sets this instance to something while we already setting it
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // also sets our current instance
            instance ?: getDBInstance(context).also { instance = it }
        }


        private fun getDBInstance(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()


    }

}