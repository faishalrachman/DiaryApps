package motion.diaryapps.list_notes

import java.io.Serializable

data class ListNotesModel(
        var id: String,
        var title: String,
        var image_url: String,
        var date: String
)