package ir.shabrangkala.simplelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ir.shabrangkala.simplelibrary.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //loading most viewed book's pictures
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/99791_82810_normal.jpg?width=200" , binding.imageView1)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/99791_82810_normal.jpg?width=200" , binding.imageView2)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/99791_82810_normal.jpg?width=200" , binding.imageView3)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/99791_82810_normal.jpg?width=200" , binding.imageView4)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/99791_82810_normal.jpg?width=200" , binding.imageView5)




    }

    fun loadImageWithGlide(view : View, url: String, imageView: ImageView){
        Glide.with(view)
            .load(url)
            .override(120, 180)
            .into(imageView)
    }
}