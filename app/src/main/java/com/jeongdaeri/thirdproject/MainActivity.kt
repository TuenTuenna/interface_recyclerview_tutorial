package com.jeongdaeri.thirdproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : BaseActivity(), MyInterface {

    private val TAG: String = "로그"

    var myFriendsList = ArrayList<MyFriend>()

    private lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("로그", "MainActivity - onCreate() called")

        var myCustomDialog = MyCustomDialog(this)

        myCustomDialog.myInterface = this

        myCustomDialog.show()

        second_activity_button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            startActivity(intent)
        }

        var myFriend_1 = MyFriend()
        var myFriend_2 = MyFriend()
        var myFriend_3 = MyFriend()
        var myFriend_4 = MyFriend()
        var myFriend_5 = MyFriend()
        var myFriend_6 = MyFriend()

//        myFriendsList.add(myFriend_1)
//        myFriendsList.add(myFriend_2)
//        myFriendsList.add(myFriend_3)
//        myFriendsList.add(myFriend_4)
//        myFriendsList.add(myFriend_5)
//        myFriendsList.add(myFriend_6)


        // 서버에서
        for (i in 1..600){

            var myFriend = MyFriend("친구 $i 번째")

            myFriendsList.add(myFriend)
        }

        Log.d(TAG, "MainActivity - myFriendsList.size : ${myFriendsList.size}")

        myFriendsList.forEach {
            Log.d(TAG, "MainActivity - 내 친구 : ${it.name}")
        }

        Log.d(TAG, "MainActivity - myFriend.name : ${myFriend_1.name}")
        Log.d(TAG, "MainActivity - myFriend.age : ${myFriend_2.age}")

        // 어답터를 준비 한다.
        myRecyclerViewAdapter = MyRecyclerViewAdapter()

        myRecyclerViewAdapter.submitList(myFriendsList)

//        my_recycler_view.apply {
//            // 방향
//            layoutManager = LinearLayoutManager(this@MainActivity,
//                                        LinearLayoutManager.VERTICAL,
//                                            false
//                                            )
//            adapter = myRecyclerViewAdapter
//        }

        my_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = myRecyclerViewAdapter
        }

    }

//    override fun onDialogButtonClicked() {
//
//    }

    override fun onDialogButtonClicked(userInput: String) {
        Log.d(TAG, "MainActivity - onDialogButtonClicked() called / userInput: $userInput")
        Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show()
    }

}
