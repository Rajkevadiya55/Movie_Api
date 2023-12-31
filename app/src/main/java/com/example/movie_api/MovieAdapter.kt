package com.example.movie_api

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog

class MovieAdapter(results: List<ResultsItem?>?):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    var results = results

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var img= itemView.findViewById<ImageView>(R.id.movie_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.movies_item,parent,false))
    }

    override fun getItemCount(): Int {
        return results?.size!!
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        var str = "https://image.tmdb.org/t/p/w500"
        Glide.with(holder.itemView.context).load(str+results?.get(position)?.posterPath).into(holder.img)

        holder.itemView.setOnClickListener {

            var dialog = BottomSheetDialog(holder.itemView.context, com.google.android.material.R.style.Base_Theme_Material3_Light_BottomSheetDialog)
            dialog.setContentView(R.layout.movie_dailog)
            var movieName = dialog.findViewById<TextView>(R.id.moviename)
            var language = dialog.findViewById<TextView>(R.id.language)
            var realeseDate = dialog.findViewById<TextView>(R.id.relasedate)
            var desc = dialog.findViewById<TextView>(R.id.description)

            movieName?.text = results?.get(position)?.originalTitle
            language?.text = results?.get(position)?.originalLanguage
            realeseDate?.text = results?.get(position)?.releaseDate
            desc?.text = results?.get(position)?.overview

            dialog.show()
        }
    }
}