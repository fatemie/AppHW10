package com.example.apphw10

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.apphw10.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage(Data.itemList[0].url, binding.imageView1)
        setImage(Data.itemList[1].url, binding.imageView2)
        setImage(Data.itemList[2].url, binding.imageView3)
        setImage(Data.itemList[3].url, binding.imageView4)
        setImage(Data.itemList[4].url, binding.imageView5)
        setImage(Data.itemList[5].url, binding.imageView6)

        setItemListener(binding.imageView1, Data.itemList[0].id)
        setItemListener(binding.imageView2, Data.itemList[1].id)
        setItemListener(binding.imageView3, Data.itemList[2].id)
        setItemListener(binding.imageView4, Data.itemList[3].id)
        setItemListener(binding.imageView5, Data.itemList[4].id)
        setItemListener(binding.imageView6, Data.itemList[5].id)
    }

    private fun setImage(photoUrl: String, imageView: ImageView){
        Glide.with(this)
            .load(photoUrl)
            .circleCrop()
            .into(imageView)
    }

    private fun setItemListener(item : ImageView, id : Int){
        item.setOnClickListener {
            goToItemDetail(id)
        }
    }

    private fun goToItemDetail(id : Int){
        val action = HomeFragmentDirections.actionHomeFragmentToItemDescriptionFragment(id)
        findNavController().navigate(action)
    }
}