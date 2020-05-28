package com.jeongdaeri.thirdproject

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_recycler_item.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val TAG: String = "로그"

    // 뷰를 가져온다.
    private val friendImage = itemView.image_view
    private val friendName = itemView.name_text
    private val friendAge = itemView.age_text

    // 뷰와 데이터를 연결
    fun bindView(myFriend: MyFriend){
        Log.d(TAG, "MyViewHolder - bindView() called" +
            "myFriend.name : ${myFriend.name}")
        friendName.text = myFriend.name
        friendAge.text = myFriend.age.toString()
    }

}
