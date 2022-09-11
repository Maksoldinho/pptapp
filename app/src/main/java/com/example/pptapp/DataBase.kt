package com.example.pptapp

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

object DataBase {

    @SuppressLint("StaticFieldLeak")
    private val db = Firebase.firestore

    fun AddToDb(user: User){
        val _user = mutableMapOf<String, String>(
            "userName" to user.userName,
            "userPassword" to user.password
        )
    db.collection("Users").add(_user).addOnSuccessListener { println("Data was added") }
    }
    fun DeleteFromDb(){

    }
   suspend fun GetFromDb(): QuerySnapshot {
    val colUsers = db.collection("Users")
       val documents =colUsers.get().await()
    println(documents)
       return documents


//        colUsers.get().addOnCompleteListener {task ->
//            if (task.isSuccessful) {
//                val listOfUsers = ArrayList<User>()
//                for (document in task.result){
//                    val name = document.data["userName"].toString()
//                    val pwd = document.data["userPassword"].toString()
//                    listOfUsers.add(User(userName = name, password = pwd))
//                }
//                myCallBack.onCallBack(listOfUsers)
//            }



//            docUsers = it.documents
//            for (document in it.documents) {
//                println(document.data)
//            }
//        }
//        println("docUsers: $docUsers")
        }
    }


