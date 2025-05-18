package edu.luqsiyana.forumfgdapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Participant(
    val nama: String,
    val telefon: String,
    val email: String,
    val gender: String,
    val skillset: List<String>,
    val category: String
) : Parcelable
