package io.coin.hawkeye.tools

import android.util.Size
import java.lang.Long.signum

import java.util.Comparator

/**
 * @author kimwoojae <jaykim@jaykim.xyz>
 * @since 2018-10-26
 */

/**
 * Compares two `Size`s based on their areas.
 */
internal class CompareSizesByArea : Comparator<Size> {

    // We cast here to ensure the multiplications won't overflow
    override fun compare(lhs: Size, rhs: Size) =
            signum(lhs.width.toLong() * lhs.height - rhs.width.toLong() * rhs.height)

}
