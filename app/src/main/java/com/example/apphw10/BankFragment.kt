package com.example.apphw10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.apphw10.databinding.FragmentBankBinding

class BankFragment : Fragment() {
    lateinit var binding : FragmentBankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentBankBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun getHesab() : String{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var hesab = prefs.getString(HESAB , "")
        return hesab.toString()
    }

    private fun getKart() : String{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var kart = prefs.getString(KART , "")
        return kart.toString()
    }

    private fun getSHaba() : String{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var shaba = prefs.getString(SHABA , "")
        return shaba.toString()
    }

    private fun setInformation(){
        binding.hesab.text = getHesab()
        binding.kart.text = getKart()
        binding.shaba.text = getSHaba()
    }

}