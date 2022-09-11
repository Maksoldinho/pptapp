package com.example.pptapp

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object Registration {

    var logInDataIsCorrect = false
    fun TryToRegister (password: String, username: String) {
        DataBase.AddToDb(User(userName = username, password = password))
    }
     fun TryToLogin(username: String, password: String) = runBlocking {
         val user_ = User(userName = username, password = password)
         val mapOfUser = mutableMapOf<String, String>(
             "userName" to user_.userName,
             "userPassword" to user_.password
         )
         logInDataIsCorrect = false
         launch {
             val Users = DataBase.GetFromDb()
             for(user in Users){
                 println("user.data: ${user.data}")
                 println("mapOfUser: $mapOfUser")
                 if(user.data == mapOfUser )
                     logInDataIsCorrect = true
             }
         }
     }


//         var logInfoIsCorrect = false
//         DataBase.GetFromDb(object: MyCallBack{
//             override fun onCallBack(value: List<User>){
//                 println("value: $value")
//
//                 for (user in value){
//                     logInfoIsCorrect = user.userName == username && user.password == password
//                 }
//             }
//         })

//        for (user in users){
//            if(username == user.userName && password == user.password)
//                logInfoIsCorrect = true
//
//            println("logInfoIsCorrect in for loop: $logInfoIsCorrect")
//        }

}