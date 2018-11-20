package br.com.rrlabs.apps.survi.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.graphics.drawable.Drawable
import br.com.rrlabs.apps.survi.R


class ViewUtils {

    fun changeIconDrawableToGray(context: Context, drawable: Drawable?) {
        if (drawable != null) {
            drawable.mutate()
            drawable.setColorFilter(ContextCompat.getColor(context, R.color.background_material_dark), PorterDuff.Mode.SRC_ATOP)
        }
    }

    fun dpToPx(dp: Float): Int {
        val density = Resources.getSystem().displayMetrics.density
        return Math.round(dp * density)
    }

    fun pxToDp(px: Float): Float {
        val densityDpi = Resources.getSystem().displayMetrics.densityDpi
        return px / (densityDpi / 160f)
    }
}