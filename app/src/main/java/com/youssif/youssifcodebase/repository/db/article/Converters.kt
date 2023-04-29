package com.youssif.youssifcodebase.repository.db.article

import androidx.room.TypeConverter
import com.youssif.youssifcodebase.models.Source


/**
 * Created by Youssif Hamdy on 11/2/2022.
 */
class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }


    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }


}