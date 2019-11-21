package motion.diaryapps.api.table

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TableDiary(
        @SerializedName("id") @Expose var id: String? = null,
        @SerializedName("title") @Expose var title: String? = null,
        @SerializedName("description") @Expose var description: String? = null,
        @SerializedName("img_url") @Expose var img_url: String? = null,
        @SerializedName("entry_date") @Expose var entry_date: String? = null
)