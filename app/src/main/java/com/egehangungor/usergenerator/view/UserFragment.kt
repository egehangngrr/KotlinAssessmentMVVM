package com.egehangungor.usergenerator.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.egehangungor.usergenerator.R
import com.egehangungor.usergenerator.model.Results
import com.egehangungor.usergenerator.viewmodel.UserViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user.*
import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class UserFragment : Fragment() {
    private lateinit var viewModel : UserViewModel

    private var user : Results? = null

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
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    fun makeCall(number: String) : Boolean{
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intent)
            return true
        } catch (ignored: Exception){
            return false
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.getDataFromRoom()
        arguments?.let {

            user = UserFragmentArgs.fromBundle(
                it
            ).user

            Picasso.get().load(user?.picture?.large).into(userImage)
            userName.text = user?.name?.first
            userPhone.text =user?.phone
            if (user?.gender.equals("female")){
                userGenderImage.setImageResource(R.drawable.female)
            } else {
                userGenderImage.setImageResource(R.drawable.male)
            }

            userMail.text = user?.email

            callButton.setOnClickListener { user?.cell?.let { it1 -> makeCall(it1) } }

//            Dob(date=1947-08-22T02:22:29.181Z, age=73)
            val originalFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

            val targetFormat: DateFormat = SimpleDateFormat("dd MMM yyyy")
            val date: Date = originalFormat.parse(user?.dob?.date)
            val formattedDate: String = targetFormat.format(date)
            userDate.text = formattedDate


        }


        observeLiveData()
    }

   private fun observeLiveData(){

       viewModel.userLiveData.observe(viewLifecycleOwner, Observer {  user ->
           user?.let {



           }
       })
   }
}

