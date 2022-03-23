package com.example.apphw10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.apphw10.databinding.FragmentItemDescriptionBinding
import kotlin.properties.Delegates


class itemDescriptionFragment : Fragment() {
    var itemId = 0
    lateinit var binding : FragmentItemDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemId = it.getInt("itemId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage(Data.itemList[itemId].url,binding.image)
        setNameAndDescription()
    }

    private fun setImage(photoUrl: String, imageView: ImageView){
        Glide.with(this)
            .load(photoUrl)
            .circleCrop()
            .into(imageView)
    }
    private fun setNameAndDescription(){
        binding.name.text = Data.itemList[itemId].name
        binding.description.text = Data.itemList[itemId].detail
    }

}