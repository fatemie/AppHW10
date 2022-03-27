package com.example.apphw10

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
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
        initVews()
        setBackGround()
    }

    private fun initVews(){
        var itemViewList = arrayListOf<ImageView>()
        itemViewList.add(binding.imageView1)
        itemViewList.add(binding.imageView2)
        itemViewList.add(binding.imageView3)
        itemViewList.add(binding.imageView4)
        itemViewList.add(binding.imageView5)
        itemViewList.add(binding.imageView6)

        for( i in 0..5){
            if(i == getNumberOfItem()){
                break
            }
            setImage(Data.itemList[i].url, itemViewList[i])
            setItemListener(itemViewList[i], Data.itemList[i].id)
        }

        var num = (0..3).random()
        binding.textView.text = Data.PointList[num]
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

    private fun getNumberOfItem() : Int{
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE
        )
        var numberOfItem = prefs.getInt(NUMBEROFITEM,6)
        return numberOfItem
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