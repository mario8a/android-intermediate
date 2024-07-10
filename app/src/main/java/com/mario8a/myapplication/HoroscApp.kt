package com.mario8a.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Esta clase inizialiraremos daggerHilt
// Dagger es para inyeccion de dependencias
// Este fichero sera como la primera pantalla cuando inicie la aplicacion

@HiltAndroidApp
class HoroscApp: Application()