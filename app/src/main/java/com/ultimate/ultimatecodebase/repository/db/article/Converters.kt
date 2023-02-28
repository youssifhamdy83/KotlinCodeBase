package com.ultimate.ultimatecodebase.repository.db.article

import androidx.room.TypeConverter
import com.ultimate.ultimatecodebase.models.Source


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