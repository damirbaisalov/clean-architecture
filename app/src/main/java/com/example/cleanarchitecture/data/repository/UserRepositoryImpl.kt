package com.example.cleanarchitecture.data.repository

import android.content.Context
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FRIST_NAME = "firstName"
private const val KEY_LASTNAME = "lastName"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImpl(context: Context): UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveparam: SaveUserNameParam): Boolean {

        sharedPreferences.edit().putString(KEY_FRIST_NAME, saveparam.name).apply()
        return true
    }

    override fun getName(): UserName {

        val firstName = sharedPreferences.getString(KEY_FRIST_NAME,"") ?: ""
        val lastName = sharedPreferences.getString(KEY_LASTNAME, DEFAULT_NAME) ?: DEFAULT_NAME

        return UserName(firstName="Damir", lastName = "Hello from repository")
    }
}