package com.retro.ondc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.retro.py.ExposeUseModule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ExposeUseModule.initializePython(this)
        displayPythonResult()
    }

    private fun initializePython() {
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
    }

    private fun displayPythonResult() {
        val helloMessage = ExposeUseModule.callPythonFunction()
        Toast.makeText(this, helloMessage, Toast.LENGTH_LONG).show()
    }

    private fun callPythonFunction(): String {
        val python = Python.getInstance()
        val pythonModule = python.getModule("user")
        return pythonModule.callAttr("get_hello_message").toString()
    }
}