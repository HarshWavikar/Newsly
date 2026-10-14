package com.harshcode.newsly.domain.usecases

import com.harshcode.newsly.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val userManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean> {
        return userManager.readAppEntry()
    }
}