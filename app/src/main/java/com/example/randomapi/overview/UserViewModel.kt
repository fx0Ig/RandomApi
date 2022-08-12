package com.example.randomapi.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomapi.AppComponent
import com.example.randomapi.domain.User

class UserViewModel : ViewModel() {

    private var _selectedUser: MutableLiveData<User> = MutableLiveData()
    val selectedUser: LiveData<User> = _selectedUser

    var users: LiveData<List<User>> = MutableLiveData()
    private val dao = AppComponent.userDatabase.userDao()

    init {
        users = dao.getUsers()
    }

    fun setSelectedUser(userId: Int) {
        _selectedUser.value = users.value?.first { it.id == userId }
    }

}