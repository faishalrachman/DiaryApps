package motion.diaryapps.api

import motion.diaryapps.api.table.TableDiary
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("LoadAll.php")
    fun loadAll() : Call<List<TableDiary>>
}