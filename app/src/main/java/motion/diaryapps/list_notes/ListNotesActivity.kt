package motion.diaryapps.list_notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_list_notes.*
import motion.diaryapps.R
import motion.diaryapps.api.ApiClient
import motion.diaryapps.api.ApiInterface
import motion.diaryapps.api.table.TableDiary
import motion.diaryapps.create_notes.CreateNotesActivity
import motion.diaryapps.utils.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ListNotesActivity : AppCompatActivity() {

    private val mLists = ArrayList<ListNotesModel>()
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_notes)

        initToolbar()

        initRecycler()
//        initDummy()
        loadData()
    }

    fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Diary Apps"
    }

    var listData: MutableList<ListNotesModel> = mutableListOf()
    lateinit var recyclerView: RecyclerView

    private fun initRecycler() {
        recyclerView = rvListNotes

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false);
            adapter = ListNotesAdapter(listData)
        }
    }

    private fun initDummy() {
        listData.add(ListNotesModel("", "", "", ""))
        listData.add(ListNotesModel("", "", "", ""))
        listData.add(ListNotesModel("", "", "", ""))
        recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun loadData(){
        val client = ApiClient().getClient(BASE_URL)
        val api = client?.create(ApiInterface::class.java)
        val call = api?.loadAll()
        call?.enqueue(object : Callback<List<TableDiary>> {

            override fun onFailure(call: Call<List<TableDiary>>, t: Throwable) {
                Log.e("Error", t.message)
            }

            override fun onResponse(call: Call<List<TableDiary>>, response: Response<List<TableDiary>>) {
                listData.clear()
                response.body()?.forEach {
                    listData.add(ListNotesModel(
                            it.id!!,
                            it.title!!,
                            it.img_url?:"",
                            it.entry_date!!
                    ))
                }
                recyclerView.adapter?.notifyDataSetChanged()
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_list_notes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.menuAdd) {
            CreateNotesActivity.startActivity(this)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
