package com.harshcode.newsly.domain.usecases.app_entry

import com.harshcode.newsly.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val userManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean> {
        return userManager.readAppEntry()
    }
}