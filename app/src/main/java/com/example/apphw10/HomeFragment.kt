package com.example.apphw10

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        setImage("https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(5)_9nbj.jpeg", binding.imageView1)
        setImage("https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_yo6w.jpeg", binding.imageView2)
        setImage("https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(4)_gh4s.jpeg", binding.imageView3)
        setImage("https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(2)_72gx.jpeg", binding.imageView4)
        setImage("https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(3)_xgzd.jpeg", binding.imageView5)
        setImage("https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(1)_9hng.jpeg", binding.imageView6)
    }

    private fun setImage(photoUrl: String, imageView: ImageView){
        Glide.with(this)
            .load(photoUrl)
            .circleCrop()
            .into(imageView)
    }

    private fun setImageListener(){

    }
}