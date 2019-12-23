package br.com.msbm.hotel.di

import br.com.msbm.hotel.ui.hotel.detail.HotelDetailViewModel
import br.com.msbm.hotel.ui.hotel.form.HotelFormViewModel
import br.com.msbm.hotel.ui.hotel.HotelListViewModel
import br.com.msbm.hotel.repository.HotelRepository
import br.com.msbm.hotel.repository.local.HotelDatabase
import br.com.msbm.hotel.repository.local.HotelRoomRepository
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val androidModule = module {
    single { this }

    single {
        HotelRoomRepository(
            HotelDatabase.getDatabase(context = get())
        ) as HotelRepository
    }

    viewModel {
        HotelListViewModel(hotelRepository = get())
    }

    viewModel {
        HotelDetailViewModel(repository = get())
    }

    viewModel {
        HotelFormViewModel(repository = get())
    }
}

