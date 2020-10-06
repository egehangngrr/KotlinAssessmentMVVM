package com.egehangungor.usergenerator.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.egehangungor.usergenerator.R
import com.egehangungor.usergenerator.adapter.UserAdapter
import com.egehangungor.usergenerator.model.Json4Kotlin_Base
import com.egehangungor.usergenerator.service.Service
import com.egehangungor.usergenerator.service.UserAPI
import com.egehangungor.usergenerator.viewmodel.FeedViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_feed.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val userAdapter = UserAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    lateinit var postService: UserAPI
    lateinit var postList: MutableList<Any>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        postService = Service.getClient().create(UserAPI::class.java)
        var post = postService.getUsers()
        post.clone().enqueue(MyCallback(userAdapter))


        userList.layoutManager = LinearLayoutManager(context)
        userList.adapter = userAdapter


        super.onViewCreated(view, savedInstanceState)
    }

    class MyCallback(private val userAdapter: UserAdapter): Callback<Json4Kotlin_Base> {
        override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
            Log.d("","")
        }

        override fun onResponse(
            call: Call<Json4Kotlin_Base>,
            response: Response<Json4Kotlin_Base>
        ) {
            response.body()?.let {
                it.results?.let {
                    userAdapter.updateUserList(it)
                }
            }
        }
    }

}
