package ir.shabrangkala.simplelibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class BookAdapter(private val data : ArrayList<Book>):RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView : View, private val context: Context): RecyclerView.ViewHolder(itemView){
        val bookImage = itemView.findViewById<ImageView>(R.id.bookImage)
        val bookName = itemView.findViewById<TextView>(R.id.bookName)
        val authorName = itemView.findViewById<TextView>(R.id.authorName)
        val numRate = itemView.findViewById<TextView>(R.id.numRate)
        val price = itemView.findViewById<TextView>(R.id.price)
        val rateBooks = itemView.findViewById<RatingBar>(R.id.rateBooks)

        fun bindData(position: Int){
            Glide
                .with(context)
                .load(data[position].imgURL)
                .into(bookImage)

            bookName.text = data[position].bookName
            authorName.text = data[position].authorName
            numRate.text = data[position].numRate.toString()
            price.text = data[position].price
            rateBooks.rating = data[position].rateBooks


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindData(position)
    }



    override fun getItemCount(): Int {
        return data.size
    }
}