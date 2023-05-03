package ir.shabrangkala.simplelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.shabrangkala.simplelibrary.Book
import ir.shabrangkala.simplelibrary.BookAdapter
import ir.shabrangkala.simplelibrary.databinding.MostViewedFragmentBinding

class MostViewedFragment: Fragment(){
    lateinit var binding: MostViewedFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MostViewedFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val data = arrayListOf<Book>(
            Book("https://newcdn.fidibo.com/images/books/99791_82810_normal.jpg?width=200"
                ,"عادت ها اتمی", "جیمز کلیر", 20, "100 تومان", 1.5F)
            , Book("https://newcdn.fidibo.com/images/books/86186_36247_normal.jpg?width=200"
                ,"حافظه نامحدود", "کوین هرسلی", 29, "1100 تومان", 4.5F)
            , Book("https://newcdn.fidibo.com/images/books/136671_72256_normal.jpg?width=200"
                ,"محکم در آغوشم بگیر", "سو جانسن", 100, "190 تومان", 5F)
            , Book("https://newcdn.fidibo.com/images/books/68120_12778_normal.jpg?width=200"
                ,"کفش فروش پیر", "ناشناس", 10, "90 تومان", 1F)
            , Book("https://newcdn.fidibo.com/images/books/69249_94233_normal.jpg?width=200"
                ,"اثر مرکب", "دارن هاردی", 1000, "50 تومان", 3.3F)
        )
        val bookAdapter = BookAdapter(data)

        binding.recyclerView.adapter = bookAdapter

        binding.recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }
}



