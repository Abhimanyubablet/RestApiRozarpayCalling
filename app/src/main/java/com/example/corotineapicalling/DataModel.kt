package com.example.corotineapicalling

import com.google.gson.annotations.SerializedName

data class UserDataModel(
    val entity: String,
    val count: Long,
    val items: List<Item>,
)

data class Item(
    val id: String,
    val entity: String,
    val name: String,
    val email: String,
    val contact: String,
    val gstin: String,
    val notes: Notes,
    @SerializedName("created_at")
    val createdAt: Long,
)

data class Notes(
    @SerializedName("notes_key_1")
    val notesKey1: String,
    @SerializedName("notes_key_2")
    val notesKey2: String,
)

