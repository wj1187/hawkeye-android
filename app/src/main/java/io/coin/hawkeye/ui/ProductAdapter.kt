package io.coin.hawkeye.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.coin.hawkeye.R
import io.coin.hawkeye.model.Product
import io.coin.hawkeye.model.Review
import kotlin.math.round

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-26
 */

class ProductAdapter(private val context: Context, private val product: Product) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE_INFO -> InfoHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_info, parent, false))
            else -> ReviewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_review, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position==0)
            VIEW_TYPE_INFO
        else
            VIEW_TYPE_REVIEW

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_INFO -> (holder as InfoHolder).bind(context, product, position)
            VIEW_TYPE_REVIEW -> {
                val review = getItemData(position - 1)
                (holder as ReviewHolder).bind(context, review, position)
            }
            else -> {
            }
        }
    }

    override fun getItemCount(): Int = product.review.size + 1

    private fun getItemData(position: Int): Review = product.review[position]

    inner class ReviewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        private val view: View = mView
        private val user: TextView = mView.findViewById(R.id.txt_user)
        private val timestamp: TextView = mView.findViewById(R.id.txt_timestamp)
        private val title: TextView = mView.findViewById(R.id.txt_title)
        private val body: TextView = mView.findViewById(R.id.txt_body)
        private val mall: ImageView = mView.findViewById(R.id.img_mall)
        private val stars: List<ImageView> = listOf(
                mView.findViewById(R.id.star1),
                mView.findViewById(R.id.star2),
                mView.findViewById(R.id.star3),
                mView.findViewById(R.id.star4),
                mView.findViewById(R.id.star5)
        )

        fun bind(context: Context, review: Review, position: Int) {
            user.text = review.nickname
            timestamp.text = review.date.substring(0, 10)
            title.text = review.review
            body.text = review.review
//            Glide.with(context).load(review.mall).into(mall)
            for(rate in 1..review.star) {
                stars[rate-1].visibility = View.VISIBLE
            }
        }
    }

    inner class InfoHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        private val view: View = mView
        private val img: ImageView = mView.findViewById(R.id.img_product)
        private val name: TextView = mView.findViewById(R.id.txt_product)
        private val price: TextView = mView.findViewById(R.id.txt_price)
        private val mall: TextView = mView.findViewById(R.id.txt_mall)
        private val rater: TextView = mView.findViewById(R.id.txt_rater)
        private val stars: List<ImageView> = listOf(
                mView.findViewById(R.id.star1),
                mView.findViewById(R.id.star2),
                mView.findViewById(R.id.star3),
                mView.findViewById(R.id.star4),
                mView.findViewById(R.id.star5)
        )

        fun bind(context: Context, product: Product, position: Int) {
            Glide.with(context).load(product.imageUrl).into(img)
            name.text = product.name
            price.text =  "${product.price.min}원"
            mall.text = "(${product.mallsCount}몰)"
            rater.text = "(${product.reviewersCount}명)"
            for(rate in 1..round(product.rate).toInt()) {
                stars[rate-1].visibility = View.VISIBLE
            }
        }
    }

    companion object {
        private const val VIEW_TYPE_INFO = 10
        private const val VIEW_TYPE_REVIEW = 20
    }

}