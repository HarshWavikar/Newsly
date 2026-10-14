package com.harshcode.newsly.domain.usecases

import com.harshcode.newsly.domain.manager.LocalUserManager

class SaveAppEntry(private val userManager: LocalUserManager) {
    suspend operator fun invoke() {
        userManager.saveAppEntry()
    }
}