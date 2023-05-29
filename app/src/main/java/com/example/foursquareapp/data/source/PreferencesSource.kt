package com.example.foursquareapp.data.source

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class PreferencesSource @Inject constructor(
    private val prefs: SharedPreferences
) {

    companion object {
        private const val EMPTY_STRING = ""
        private const val TOKEN_KEY = "TOKEN_KEY"
    }

}