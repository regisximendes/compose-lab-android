package com.example.composelab.feed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelab.feed.domain.FeedPost
import com.example.composelab.feed.domain.FeedPostFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class State {
    LOADING,
    SUCCESS
}

@HiltViewModel
class FeedViewModel @Inject constructor(): ViewModel() {

    val feedList = MutableLiveData<List<FeedPost>>()
    val state = MutableLiveData<State>()

    fun init () {
        state.postValue(State.LOADING)
        viewModelScope.launch {
            delay(timeMillis = 1000)

            feedList.postValue(FeedPostFactory.makeFeedPostList())

            state.postValue(State.SUCCESS)
        }
    }
}