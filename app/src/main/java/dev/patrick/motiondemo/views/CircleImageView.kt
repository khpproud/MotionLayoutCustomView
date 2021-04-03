package dev.patrick.motiondemo.views

import android.content.Context
import android.util.AttributeSet
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView
import dev.patrick.motiondemo.R

class CircleImageView (context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {

    init {
        // the outline (view edges) of the view should be derived from the background
        outlineProvider = ViewOutlineProvider.BACKGROUND
        // cut the view to match the view to the outline of the background
        clipToOutline = true
        // Use the following background to calculate the outline
        setBackgroundResource(R.drawable.bg_circle)
        // Fill in the whole image view, crop of needed while keeping the center
        scaleType = ScaleType.CENTER_CROP
    }
}