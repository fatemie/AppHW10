package com.example.apphw10

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.apphw10.databinding.FragmentSettingBinding
const val NAME = "NAME"
const val NATIONALCODE = "NATIONALCODE"
const val PHONENUMBER = "PHONENUMBER"
const val NUMBEROFITEM = "NUMBEROFITEM"
const val THEME = "THEME"
const val HESAB = "HESAB"
const val KART = "KART"
const val SHABA = "SHABA"

class SettingFragment : Fragment() {
    lateinit var binding : FragmentSettingBinding
    lateinit var prefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        setBackGround()
    }

    private fun setListener(){
        binding.editInfoButton.setOnClickListener {
            showEditTexts()
        }
        binding.saveButton.setOnClickListener {
            saveInfo()
        }
    }

    private fun showEditTexts(){
        prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        val name = prefs.getString(NAME,"")
        val code = prefs.getString(NATIONALCODE,"")
        val phone =  prefs.getString(PHONENUMBER, "")
        val hesab =  prefs.getString(HESAB, "")
        val kart =  prefs.getString(KART, "")
        val shaba =  prefs.getString(SHABA, "")
        if(!name.isNullOrEmpty()){
            binding.name.setText(name)
            binding.phoneNumber.setText(phone)
            binding.code.setText(code)
            binding.hesab.setText(hesab)
            binding.kart.setText(kart)
            binding.shaba.setText(shaba)
        }
        binding.name.isVisible = true
        binding.code.isVisible = true
        binding.phoneNumber.isVisible = true
        binding.hesab.isVisible = true
        binding.kart.isVisible = true
        binding.shaba.isVisible = true
        binding.saveButton.isVisible = true

    }
    private fun saveInfo() {
        prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        val editor =  prefs.edit()
        editor.putString(NAME, binding.name.text.toString())
        editor.putString(NATIONALCODE, binding.code.text.toString())
        editor.putString(PHONENUMBER, binding.phoneNumber.text.toString())
        editor.putString(HESAB, binding.hesab.text.toString())
        editor.putString(KART, binding.kart.text.toString())
        editor.putString(SHABA, binding.shaba.text.toString())
        val numberOfItem = when(binding.numberOfItem.checkedRadioButtonId){
            binding.one.id -> 1
            binding.two.id -> 2
            binding.three.id -> 3
            binding.four.id -> 4
            binding.five.id -> 5
            binding.six.id -> 6
            else -> 0
        }
        editor.putInt(NUMBEROFITEM, numberOfItem)
        val theme = when(binding.theme.checkedRadioButtonId){
            binding.dark.id -> "dark"
            binding.light.id -> "light"
            else -> "light"
        }
        editor.putString(THEME, theme)
        editor.apply()
        Toast.makeText(activity, "information saved!" ,Toast.LENGTH_SHORT ).show()
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
}