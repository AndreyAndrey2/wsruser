package com.example.wsruserfood.viewmodel.signin

import androidx.lifecycle.viewModelScope
import com.example.wsruserfood.data.models.remote.TokenResponse
import com.example.wsruserfood.viewmodel.core.BaseViewModel
import com.example.wsruserfood.viewmodel.core.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel: BaseViewModel() {
    var isValid: Boolean = true

    private val _authRequest = MutableStateFlow<Event<TokenResponse>>(Event.idle())
    val authRequest: StateFlow<Event<TokenResponse>> = _authRequest

    fun postAuth(email: String, password: String) {
        viewModelScope.launch {

            _authRequest.value = Event.loading()

//            postRequestWithMutableFlow(_authRequest){
//                api.postAuth(AuthRequest(email, password))
//            }
        }
    }
}