package br.com.msbm.hotel.ui.hotel.form

import br.com.msbm.hotel.model.Hotel

class HotelValidator {
    fun validate(hotel: Hotel) = with(hotel) {
        checkAddress(address) && checkName(name)
    }

    private fun checkAddress(address: String) = address.length in 4..80

    private fun checkName(name: String) = name.length in 2..20
}