package com.retro.py

import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

object ExposeUseModule {
    fun initializePython(activity: AppCompatActivity) {
        if (Python.isStarted()) {
        } else {
            Python.start(AndroidPlatform(activity))
        }
    }

    fun callPythonFunction(): String {
        val python = Python.getInstance()
        val pythonModule = python.getModule("user")
        return pythonModule.callAttr("get_hello_message").toString()
    }

}