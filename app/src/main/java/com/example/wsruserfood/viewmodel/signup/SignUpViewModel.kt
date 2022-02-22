package com.example.wsruserfood.viewmodel.signup

import androidx.lifecycle.viewModelScope
import com.example.wsruserfood.data.models.remote.RegisterRequest
import com.example.wsruserfood.data.models.remote.TokenResponse
import com.example.wsruserfood.viewmodel.core.BaseViewModel
import com.example.wsruserfood.viewmodel.core.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : BaseViewModel() {

    var isValid: Boolean = true

    private val _authRequest = MutableStateFlow<Event<TokenResponse>>(Event.idle())
    val authRequest: StateFlow<Event<TokenResponse>> = _authRequest

    fun postRegister(email: String, password: String, login: String) {
        viewModelScope.launch {

            _authRequest.value = Event.loading()

            postRequestWithMutableFlow(_authRequest) {
                api.postRegister(RegisterRequest(email, password, login))
            }
        }
    }
}