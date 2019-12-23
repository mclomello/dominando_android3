package br.com.msbm.hotel.repository.local

import androidx.lifecycle.LiveData
import br.com.msbm.hotel.model.Hotel
import br.com.msbm.hotel.repository.HotelRepository

class HotelRoomRepository(database: HotelDatabase) : HotelRepository {
    private val hotelDao = database.hotelDao()

    override fun save(hotel: Hotel) {
        if (hotel.id == 0L) {
            val id = hotelDao.insert(hotel)
            hotel.id = id
        } else {
            hotelDao.update(hotel)
        }
    }
    override fun remove(vararg hotels: Hotel) {
        hotelDao.delete(*hotels)
    }
    override fun hotelById(id: Long): LiveData<Hotel> {
        return hotelDao.hotelById(id)
    }
    override fun search(term: String): LiveData<List<Hotel>> {
        return hotelDao.search(term)
    }
}