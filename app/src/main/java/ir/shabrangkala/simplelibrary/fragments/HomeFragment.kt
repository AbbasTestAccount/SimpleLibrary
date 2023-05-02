package ir.shabrangkala.simplelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ir.shabrangkala.simplelibrary.R
import ir.shabrangkala.simplelibrary.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //loading most viewed books pictures
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/99791_82810_normal.jpg?width=200" , binding.imageView1)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/86186_36247_normal.jpg?width=200" , binding.imageView2)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/136671_72256_normal.jpg?width=200" , binding.imageView3)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/68120_12778_normal.jpg?width=200" , binding.imageView4)
        loadImageWithGlide(view,"https://newcdn.fidibo.com/images/books/69249_94233_normal.jpg?width=200" , binding.imageView5)

        //loading famous authors pics
        loadImageWithGlide(view,"https://www.ketabrah.ir/img/authors/a-1355.jpg" , binding.imageView6)
        loadImageWithGlide(view,"https://www.ketabrah.ir/img/authors/a-1312.jpg" , binding.imageView7)
        loadImageWithGlide(view,"https://www.ketabrah.ir/img/authors/a-6744.jpg" , binding.imageView8)

        binding.moreOfMostViewed.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.main_frame_for_fragments, MostViewedFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

    fun loadImageWithGlide(view : View, url: String, imageView: ImageView){
        Glide.with(view)
            .load(url)
            .override(120, 180)
            .into(imageView)
    }
}