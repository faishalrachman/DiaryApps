package motion.diaryapps.list_notes

import org.json.JSONObject
import java.io.Serializable

data class ListNotesModel(
        var id: String,
        var title: String,
        var image_url: String,
        var date: String
){
    fun asJSON() = JSONObject().also{obj->
            obj.putOpt("id",id)
            obj.putOpt("title",title)
            obj.putOpt("image_url",image_url)
        }.toString()
    companion object {
        fun fromJSON(json : String) : ListNotesModel{
            val json = JSONObject(json)
            val id = json.optString("id","")
            val title = json.optString("title","")
            val image_url = json.optString("image_url","")
            return ListNotesModel(id,title,image_url,"")
        }
    }
}