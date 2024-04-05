package com.example.educatie
import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class CardAdapter(context: Context, objects: List<CardItem>) :
    ArrayAdapter<CardItem>(context, 0, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val currentCard = getItem(position)

        val progressCircleImageView: ImageView = itemView!!.findViewById(R.id.progressCircleImageView)
        val textViewProgress: TextView = itemView.findViewById(R.id.textViewProgress)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)

        currentCard?.let {
            textViewTitle.text = it.title
            textViewDescription.text = it.description

            // Set dynamic progress circle and percentage
            setProgressCircleAndPercentage(progressCircleImageView, textViewProgress, it.progress)
        }
        itemView.setOnClickListener {
            val intent = Intent(context, LearningTopic::class.java).apply {
                putExtra("subject", currentCard?.title)
            }
            context.startActivity(intent)
        }
        return itemView
    }

    private fun setProgressCircleAndPercentage(progressCircleImageView: ImageView, textViewProgress: TextView, progress: Int) {
        // Calculate the color based on progress
        val color = getColorForProgress(progress)

        // Create a dynamic progress circle using a GradientDrawable
        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.OVAL
        gradientDrawable.setColor(color)

        // Set the progress circle as background for ImageView
        progressCircleImageView.background = gradientDrawable

        // Set the percentage text
        textViewProgress.text = "$progress%"
    }

    private fun getColorForProgress(progress: Int): Int {
        // Define your color logic based on progress
        // For example, here's a simple logic that interpolates between red and green based on progress
        val startColor = ContextCompat.getColor(context, R.color.Red)
        val endColor = ContextCompat.getColor(context, R.color.Green)
        val interpolatedColor = interpolateColor(startColor, endColor, progress / 100f)
        return interpolatedColor
    }

    private fun interpolateColor(startColor: Int, endColor: Int, fraction: Float): Int {
        val startAlpha = (startColor shr 24) and 0xff
        val startRed = (startColor shr 16) and 0xff
        val startGreen = (startColor shr 8) and 0xff
        val startBlue = startColor and 0xff
        val endAlpha = (endColor shr 24) and 0xff
        val endRed = (endColor shr 16) and 0xff
        val endGreen = (endColor shr 8) and 0xff
        val endBlue = endColor and 0xff
        return (startAlpha + (fraction * (endAlpha - startAlpha)).toInt() shl 24
                or (startRed + (fraction * (endRed - startRed)).toInt() shl 16)
                or (startGreen + (fraction * (endGreen - startGreen)).toInt() shl 8)
                or (startBlue + (fraction * (endBlue - startBlue)).toInt()))
    }
}
