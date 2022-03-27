package com.example.apphw10

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.apphw10.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding : FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage("https://s6.uupload.ir/files/img_20201127_140915_421_t5b9.jpg", binding.image)
        setInformation()
        setBackGround()
        binding.BankButton.setOnClickListener {
            goToBankFragment()
        }
    }

    private fun getName() : String{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var name = prefs.getString(NAME , "")
        return name.toString()
    }
    private fun getNationalCode() : String{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var code = prefs.getString(NATIONALCODE , "")
        return code.toString()
    }
    private fun getPhoneNumber() : String{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var phone = prefs.getString(PHONENUMBER , "")
        return phone.toString()
    }

    private fun setInformation(){
        binding.name.text = getName()
        binding.nationalCode.text = getNationalCode()
        binding.phoneNumber.text = getPhoneNumber()
    }

    private fun setImage(photoUrl: String, imageView: ImageView){
        Glide.with(this)
            .load(photoUrl)
            .circleCrop()
            .into(imageView)
    }

    @SuppressLint("ResourceAsColor")
    private fun setBackGround(){
        if(getTheme() == "dark"){
            binding.root.setBackgroundColor(R.color.purple_200)
        }
    }

    private fun getTheme() : String{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var theme = prefs.getString(THEME,"light")
        return theme.toString()
    }

    private fun goToBankFragment(){
        val action = ProfileFragmentDirections.actionProfileFragmentToBankFragment()
        findNavController().navigate(action)
    }
}