package com.example.youtube

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(
    private val context: Context,
    private val videosList: List<YTVideo>
) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    // Provide a reference to the type of views that you are using
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnailImg: ImageView = view.findViewById(R.id.thumbnail_img)
        val titleTxt: TextView = view.findViewById(R.id.title_txt)
        val channelTxt: TextView = view.findViewById(R.id.channel_txt)
        val viewsCountTxt: TextView = view.findViewById(R.id.views_count_txt)
        val dateTxt: TextView = view.findViewById(R.id.date_txt)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_video, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position
        val ytVideo = videosList[position]

        // Replace the contents of the view with that element
        viewHolder.apply {
            thumbnailImg.setImageDrawable(ContextCompat.getDrawable(context, ytVideo.thumbnailId))
            titleTxt.text = ytVideo.title
            channelTxt.text = ytVideo.channel
            viewsCountTxt.text = "${ytVideo.viewsCount / 1000}K Views"
            dateTxt.text = ytVideo.date
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = videosList.size

}