package com.jeongdaeri.thirdproject

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter: RecyclerView.Adapter<MyViewHolder>() {

    val TAG: String = "로그"

    private var myFriendsList = ArrayList<MyFriend>()


    // 뷰홀더가 생성 될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d(TAG, "MyRecyclerViewAdapter - onCreateViewHolder() called")

        // 어떤 xml아이템을 띄울꺼냐
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false))

    }

    // 보여줄 목록 갯수
    override fun getItemCount(): Int {
//        Log.d(TAG, "MyRecyclerViewAdapter - getItemCount() called")
        return myFriendsList.size
    }

    // 뷰와 묶일때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerViewAdapter - onBindViewHolder() called / " +
            "position : $position")

        // 해당 번째의 아이템을 가져온다.
        val friendItem = this.myFriendsList[position]

        // 데이터와 뷰 묶음
        holder.bindView(friendItem)
    }

    // 외부에서 데이터 넘기기
    fun submitList(myFriendsListFromMainActivity: ArrayList<MyFriend>){
        Log.d(TAG, "MyRecyclerViewAdapter - submitList() called")
        this.myFriendsList = myFriendsListFromMainActivity
    }

}










