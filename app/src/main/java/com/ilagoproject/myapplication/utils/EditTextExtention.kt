package com.ilagoproject.myapplication.utils

import android.content.res.ColorStateList
import android.graphics.Color
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.markAsRequired(){
    setHintTextColor(ColorStateList.valueOf(Color.RED))
}