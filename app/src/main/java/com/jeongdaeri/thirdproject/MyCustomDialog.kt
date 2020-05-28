package com.jeongdaeri.thirdproject

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.custom_dialog.*

class MyCustomDialog(context: Context) : Dialog(context), View.OnClickListener {


    val TAG: String = "로그"

    var myInterface: MyInterface? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.custom_dialog)

        notify_button.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        when(view) {
            notify_button -> {
                Log.d(TAG, "MyCustomDialog - 알린다 버튼 클릭!")
                myInterface?.onDialogButtonClicked(dialog_input.text.toString())
            }
        }
    }


}
