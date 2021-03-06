package com.ejemplo.labo4

import android.support.design.internal.BottomNavigationItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cardview_movie.view.*

class movieAdapter(var movies: List<Movie>): RecyclerView.Adapter<movieAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): movieAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.cardview_movie,p0,false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: movieAdapter.ViewHolder, p1: Int):Unit = holder.bind(movies[p1])

    fun changeList(movies:List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: Movie) = with(itemView){

            Glide.with(itemView.context)
                    .load(item.Poster)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(movie_image_cv)

            movie_title_cv.text = item.Title
            movie_plot_cv.text = item.Plot
            movie_rate_cv.text = item.imdbRating
            movie_runtime_cv.text = item.Runtime

        }
    }

}