package com.example.part5bitfit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WaterEntryDao {
    @Query("SELECT * FROM water_entries ORDER BY id DESC")
    fun getAll(): LiveData<List<WaterEntry>>

    @Insert
    fun insert(entry: WaterEntry)
}