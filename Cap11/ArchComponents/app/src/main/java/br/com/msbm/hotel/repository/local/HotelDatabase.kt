package br.com.msbm.hotel.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.msbm.hotel.model.Hotel
import br.com.msbm.hotel.repository.local.constants.DATABASE_NAME
import br.com.msbm.hotel.repository.local.constants.DATABASE_VERSION
import br.com.msbm.hotel.repository.local.dao.HotelDao

@Database(entities = [Hotel::class], version = DATABASE_VERSION)
abstract class HotelDatabase : RoomDatabase() {
    abstract fun hotelDao(): HotelDao

    companion object {
        private var instance: HotelDatabase? = null

        fun getDatabase(context: Context): HotelDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    HotelDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return instance as HotelDatabase
        }

        fun destroyInstance() {
            instance = null
        }
    }
}
