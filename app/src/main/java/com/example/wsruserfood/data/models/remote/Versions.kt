package com.example.wsruserfood.data.models.remote

import com.example.wsruserfood.data.db.entity.VersionsEntity

data class Versions(
    val version: List<String>
) {
    fun toEntity() = VersionsEntity(
        version = version
    )
}
