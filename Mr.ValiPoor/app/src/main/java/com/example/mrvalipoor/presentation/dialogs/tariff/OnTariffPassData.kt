package com.example.mrvalipoor.presentation.dialogs.tariff

interface OnTariffPassData {

    fun passNormalCallPrice(data : String)
    fun passSabetCallPrice(data : String)
    fun updateLogoInFreeCall(data : String)
    fun defineLogoInNormalCall(data : String)
    fun defineLogoInBrands(data : String)
    fun defineLogoInRec(data : String)

}