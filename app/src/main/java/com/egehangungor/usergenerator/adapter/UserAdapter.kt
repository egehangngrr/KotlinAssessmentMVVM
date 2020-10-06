package com.egehangungor.usergenerator.adapter


import android.content.Context
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.egehangungor.usergenerator.R
import com.egehangungor.usergenerator.model.Results
import com.egehangungor.usergenerator.view.FeedFragmentDirections
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class UserAdapter(val userList: ArrayList<Results>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    lateinit var context: Context


    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val itemImageView =  holder.view.findViewById<CircularImageView>(R.id.imageView)
        holder.view.name.text = userList[position].name.first + " " + userList[position].name.last
        Picasso.get().load(userList[position].picture?.large).into(itemImageView)





        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToUserFragment(userList[position])
            Navigation.findNavController(it).navigate(action)
        }

    }

    fun updateUserList(newUserList : List<Results>){
        userList.clear()
        userList.addAll(newUserList)
        notifyDataSetChanged()
    }

    fun addUser(newUser : Results){
        userList.add(newUser)
        notifyDataSetChanged()
    }
}