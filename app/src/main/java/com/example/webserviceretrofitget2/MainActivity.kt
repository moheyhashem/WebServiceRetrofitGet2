package com.example.webserviceretrofitget2

import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    internal var contentTV: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //api.github.com/users/devdloperhendy/repos
    interface GithhubService {

        @get:GET("users/develpoerhendy/repos")
        val developerHendyRepos: Call<Void>

    }

    fun LoadData(view: View) {

        val Link = "https://jsonplaceholder.typicode.com/posts"
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/").build()
        val githhubService = retrofit.create(GithhubService::class.java)

        githhubService.developerHendyRepos.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                contentTV!!.text = response.body()!!.toString()


            }

            override fun onFailure(call: Call<Void>, t: Throwable) {

            }
        })
    }
}
