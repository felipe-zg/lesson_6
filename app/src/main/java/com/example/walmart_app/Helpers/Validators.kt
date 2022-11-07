package com.example.walmart_app.Helpers

import android.text.TextUtils
import android.util.Patterns

class Validators {
    companion object {
        fun isValidEmail(target: CharSequence?): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}