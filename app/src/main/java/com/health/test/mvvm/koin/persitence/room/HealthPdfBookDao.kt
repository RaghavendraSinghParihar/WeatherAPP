package com.health.test.mvvm.koin.persitence.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Room Magic is in this file, where you map a method call to an SQL query.
 *
 * When you are using complex data types, such as Date, you have to also supply type converters.
 * To keep this example basic, no types that require type converters are used.
 * See the documentation at
 * https://developer.android.com/topic/libraries/architecture/room.html#type-converters
 */

@Dao
interface HealthPdfBookDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM health_pdf_table ORDER BY eBookName ASC")
    fun getAlphabetizedWords(): List<HealthPdfBookEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: HealthPdfBookEntity)

    @Query("DELETE FROM health_pdf_table")
    suspend fun deleteAll()
}
