package br.com.msbm.hotel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.msbm.hotel.repository.local.constants.COLUMN_ID
import br.com.msbm.hotel.repository.local.constants.TABLE_HOTEL

@Entity(tableName = TABLE_HOTEL)
data class Hotel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var rating: Float = 0.0F
)
