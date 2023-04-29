package com.youssif.youssifcodebase.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youssif.youssifcodebase.models.NewsResponse
import com.youssif.youssifcodebase.repository.NewsRepository
import com.youssif.youssifcodebase.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Youssif Hamdy on 1/11/2023.
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    val newsRepository: NewsRepository
) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {

        breakingNews.postValue(Resource.Loading())
        // TODO look for a better way to handle the exception
        try {
            val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
            breakingNews.postValue(handleBreakingNewsResponse(response))
        } catch (e:Exception){
            breakingNews.postValue(e.localizedMessage?.let { Resource.Error(it) })
        }


    }


    private fun handleBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {

        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())

    }

}