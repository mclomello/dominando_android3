package br.com.msbm.hotel.ui.hotel.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.msbm.hotel.model.Hotel
import br.com.msbm.hotel.repository.HotelRepository

class HotelDetailViewModel(private val repository: HotelRepository) : ViewModel() {
    fun loadHotelDetails(id: Long): LiveData<Hotel> {
        return repository.hotelById(id)
    }
}
