package motion.diaryapps.dao

import java.io.Serializable
import java.util.Date

import motion.diaryapps.utils.Tools

class DiaryDao : Serializable {
    var id: String? = null
    var title: String? = null
    var description: String? = null
    var url_cover: String? = null
    var date: String? = null

    val titleDate: String
        get() = Tools.getTitleDate(date!!)

    val normalDate: String
        get() = Tools.getNormalDate(date!!)

    val valueDate: Date?
        get() = Tools.getDateFromTimestamp(date!!)

    constructor(id: String, title: String, description: String, url_cover: String, date: String) {
        this.id = id
        this.title = title
        this.description = description
        this.url_cover = url_cover
        this.date = date
    }

    fun setDate(date: Date) {
        this.date = Tools.setTimestampFromDate(date)
    }

    fun setDate() {
        this.date = Tools.currentDateISO8601
    }
}
