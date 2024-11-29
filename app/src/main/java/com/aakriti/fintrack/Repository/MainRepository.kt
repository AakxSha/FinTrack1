package com.aakriti.fintrack.Repository

import com.aakriti.fintrack.Domain.BudgetDomain
import com.aakriti.fintrack.Domain.ExpenseDomain

class MainRepository {
    val items= mutableListOf(
        ExpenseDomain(title = "Restaurant", price = 573.12, pic = "img1", time = "17 jun 2024 19:15"),
        ExpenseDomain(title = "McDonald", price = 77.82, pic = "img2", time = "16 jun 2024 13:17"),
        ExpenseDomain(title = "Cinema", price = 23.47, pic = "img3", time = "16 jun 2024 20:45"),
        ExpenseDomain(title = "Restaurant", price = 341.12, pic = "img1", time = "15 jun 2024 22:18")

    )

    val budget = mutableListOf(
        BudgetDomain(title = "Home Loan", price = 1200.0, percent = 80.8),
        BudgetDomain(title = "Subscription", price = 1200.0, percent = 10.0),
        BudgetDomain(title = "Car Loan", price = 800.0, percent = 30.0)
    )
}

