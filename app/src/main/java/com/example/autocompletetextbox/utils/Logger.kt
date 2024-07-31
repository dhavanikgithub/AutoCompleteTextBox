package com.example.autocompletetextbox.utils

import android.util.Log

class Logger {

    companion object {
        fun d(tag: String?, message: String?) {
            try {
                Log.d(tag, message!!)
            } catch (e: Exception) {
                //e.printStackTrace();
            }
        }

        fun w(tag: String?, message: String?) {
            try {
                Log.w(tag, message!!)
            } catch (e: Exception) {
                //e.printStackTrace();
            }
        }

        fun i(tag: String?, message: String?) {
            try {
                Log.i(tag, message!!)
            } catch (e: Exception) {
                //e.printStackTrace();
            }
        }


        fun e(tag: String?, message: String?) {
            try {
                Log.e(tag, message!!)
            } catch (e: Exception) {
                //e.printStackTrace();
            }
        }

        fun log(message: String?) {
            e("log:", message)
        }

    }
}