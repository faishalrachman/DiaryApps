package motion.diaryapps.utils

import android.annotation.SuppressLint
import android.text.TextUtils
import android.util.Log
import android.widget.ImageView

import com.squareup.picasso.Picasso

import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

import motion.diaryapps.R

object Tools {
    private val TIMESTAMP_PATTERN1 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private val TIMESTAMP_PATTERN2 = "MMMM dd, yyyy"
    private val TIMESTAMP_PATTERN3 = "dd MMMM yyyy"

    val currentDateISO8601: String
        @SuppressLint("SimpleDateFormat")
        get() {
            val timezone = TimeZone.getTimeZone("UTC")
            val dateFormat = SimpleDateFormat(TIMESTAMP_PATTERN1)
            dateFormat.timeZone = timezone
            return dateFormat.format(Date())
        }

    @SuppressLint("SimpleDateFormat")
    fun getTitleDate(timestamp: String): String {
        try {
            val dateFormat = SimpleDateFormat(TIMESTAMP_PATTERN1)
            val date = dateFormat.parse(timestamp)
            val formatter = SimpleDateFormat(TIMESTAMP_PATTERN2)
            return formatter.format(date)
        } catch (e: Exception) {
            Log.e("Tools", "getTitleDate: caused by $e")
        }

        return timestamp
    }

    @SuppressLint("SimpleDateFormat")
    fun getNormalDate(timestamp: String): String {
        try {
            val dateFormat = SimpleDateFormat(TIMESTAMP_PATTERN1)
            val date = dateFormat.parse(timestamp)
            val formatter = SimpleDateFormat(TIMESTAMP_PATTERN3)
            return formatter.format(date)
        } catch (e: Exception) {
            Log.e("Tools", "getNormalDate: caused by $e")
        }

        return timestamp
    }

    @SuppressLint("SimpleDateFormat")
    fun getDateFromTimestamp(timestamp: String): Date? {
        try {
            val dateFormat = SimpleDateFormat(TIMESTAMP_PATTERN1)
            return dateFormat.parse(timestamp)
        } catch (e: Exception) {
            Log.e("Tools", "getNormalDate: caused by $e")
        }

        return null
    }

    @SuppressLint("SimpleDateFormat")
    fun setTimestampFromDate(date: Date): String? {
        try {
            val formatter = SimpleDateFormat(TIMESTAMP_PATTERN1)
            return formatter.format(date)
        } catch (e: Exception) {
            Log.e("Tools", "getNormalDate: caused by $e")
        }

        return null
    }

    fun setImage(view: ImageView?, url: String) {
        if (view != null) {
            if (!TextUtils.isEmpty(url) && url.contains("https:")) {
                Picasso.get()
                        .load(url)
                        .placeholder(R.color.colorGray)
                        .error(R.color.colorGray)
                        .fit()
                        .into(view)
            } else {
                view.setImageResource(R.color.colorGray)
            }
        }
    }
}
