package com.jinkyu.tv.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinkyu.tv.presentation.MainViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class AndroidMainViewModel : ViewModel(), KoinComponent {

    val mainViewModel: MainViewModel by inject { parametersOf(viewModelScope) }

}