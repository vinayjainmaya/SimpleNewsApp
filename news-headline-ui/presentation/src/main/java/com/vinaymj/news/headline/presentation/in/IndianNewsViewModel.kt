package com.vinaymj.news.headline.presentation.`in`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinaymj.news.headline.domain.model.News
import com.vinaymj.news.headline.domain.usecase.GetIndiaNewsUseCase
import com.vinaymj.news.core.api.Response
import com.vinaymj.news.core.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IndianNewsViewModel @Inject constructor(
    private val getIndiaNewsUseCase: GetIndiaNewsUseCase
) : ViewModel() {

    private val _news = MutableLiveData<Event<Response<News>>>()
    internal val news: LiveData<Event<Response<News>>>
        get() = _news

    fun getTopHeadlines(countryCode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _news.postValue(Event(Response.Loading()))
            try {
                val response = getIndiaNewsUseCase.execute(countryCode)

                _news.postValue(Event(
                    if (response is Response.Success)
                        Response.Success(response.data)
                    else Response.Error(response.errorMessage.toString())
                ))
            } catch (e: Exception) {
                _news.postValue(Event(Response.Error(e.message.toString())))
            }
        }
    }
}