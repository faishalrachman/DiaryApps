package motion.diaryapps.list_notes

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_list_notes.*
import motion.diaryapps.R
import motion.diaryapps.create_notes.CreateNotesActivity
import java.util.*

class ListNotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_notes)

        initToolbar()

        initRecycler()
        initDummy()
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
        Handler().postDelayed({
            listData.add(ListNotesModel("1", "Tes1", "https://kilo943.com/wp-content/uploads/2018/04/ded-logo.jpg", ""))
            listData.add(ListNotesModel("2", "Tes2", "https://kilo943.com/wp-content/uploads/2018/04/ded-logo.jpg", ""))
            listData.add(ListNotesModel("3", "Tes3", "https://kilo943.com/wp-content/uploads/2018/04/ded-logo.jpg", ""))
            recyclerView.adapter?.notifyDataSetChanged()
        }, 2000)

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
