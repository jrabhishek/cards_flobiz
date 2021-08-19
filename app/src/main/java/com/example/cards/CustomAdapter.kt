package com.example.cards

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cards.Models.Item
import com.squareup.picasso.Picasso

class CustomAdapter(private val dataSet: ArrayList<Item>, private val context:Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView:ImageView
        val dateText:TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.card_text)
            imageView  = view.findViewById(R.id.card_image)
            dateText = view.findViewById(R.id.card_date)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(context)
            .inflate(R.layout.card_layout, viewGroup, false)

        return CustomAdapter.ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].text1
        viewHolder.dateText.text  = dataSet[position].text2
      Picasso.get().load(dataSet[position].image).into(viewHolder.imageView)
//        Glide.with(context).load("https://via.placeholder.com/150").centerCrop().into(viewHolder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}