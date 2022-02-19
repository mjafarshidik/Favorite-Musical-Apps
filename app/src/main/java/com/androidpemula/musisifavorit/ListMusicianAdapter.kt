package com.androidpemula.musisifavorit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMusicianAdapter (private val listMusician: ArrayList<Musician>) : RecyclerView.Adapter<ListMusicianAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Musician)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_musician, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val musician = listMusician[position]

        Glide.with(holder.itemView.context)
            .load(musician.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = musician.name
        holder.tvDetail.text = musician.detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMusician[holder.adapterPosition]) }
        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailMusician::class.java)
            moveDetail.putExtra(DetailMusician.EXTRA_NAME, musician.name)
            moveDetail.putExtra(DetailMusician.EXTRA_ORIGIN, musician.origin)
            moveDetail.putExtra(DetailMusician.EXTRA_GENRE, musician.genre)
            moveDetail.putExtra(DetailMusician.EXTRA_ACTIVE, musician.activeYear)
            moveDetail.putExtra(DetailMusician.EXTRA_MEMBER, musician.member)
            moveDetail.putExtra(DetailMusician.EXTRA_ALBUM, musician.album)
            moveDetail.putExtra(DetailMusician.EXTRA_DETAIL, musician.detail)
            moveDetail.putExtra(DetailMusician.EXTRA_PHOTO, musician.photo)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listMusician.size
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById<TextView>(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}