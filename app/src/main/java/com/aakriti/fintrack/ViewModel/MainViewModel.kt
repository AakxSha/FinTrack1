package com.aakriti.fintrack.ViewModel

import androidx.lifecycle.ViewModel
import com.aakriti.fintrack.Repository.MainRepository

class MainViewModel(val repository:MainRepository):ViewModel() {
    constructor():this(MainRepository())

    fun loadExpenseData() = repository.items
    fun loadBudgetData() = repository.budget
}