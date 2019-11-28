package motion.diaryapps.detail_notes

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import motion.diaryapps.R
import motion.diaryapps.create_notes.CreateNotesActivity
import motion.diaryapps.dao.DiaryDao
import motion.diaryapps.list_notes.ListNotesModel
import motion.diaryapps.utils.Tools

class DetailNotesActivity : AppCompatActivity() {

    //    layout component
    private var mIvDetailNotes: ImageView? = null
    private var mTvDetailNotesTitle: TextView? = null
    private var mTvDetailNotesDescription: TextView? = null

    //    attribute
    private var mData: DiaryDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_notes)
        val extras = intent.extras!!

        val detail = ListNotesModel.fromJSON(extras.getString(KEY_DATA)!!)

        initToolbar()
        initComponent()
        setData(DiaryDao(detail.id,detail.title,"",detail.image_url,""))
    }

    fun setData(mData: DiaryDao?) {
        mTvDetailNotesTitle!!.text = mData!!.title
        mTvDetailNotesDescription!!.text = mData.description
        supportActionBar!!.title = Tools.getTitleDate(mData.date!!)
        Tools.setImage(mIvDetailNotes, mData.url_cover!!)
    }

    fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    fun initComponent() {
        mIvDetailNotes = findViewById(R.id.ivDetailNotes)
        mTvDetailNotesTitle = findViewById(R.id.tvDetailNotesTitle)
        mTvDetailNotesDescription = findViewById(R.id.tvDetailNotesDescription)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail_notes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.menuDelete -> {
                showDialog()
                return true
            }
            R.id.menuEdit -> {
                CreateNotesActivity.startActivity(this, mData!!)
                return true
            }
            R.id.menuShare -> {
                Toast.makeText(this, "menu share di klik", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure want delete this diary?")
        builder.setTitle("Delete Diary")
        builder.setCancelable(false)
        builder.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(this@DetailNotesActivity, "delete diary di click", Toast.LENGTH_SHORT).show()
            finish()
        }
        builder.setNegativeButton("No") { dialog, which -> dialog.cancel() }
        val alertDialog = builder.create()

        alertDialog.show()
    }

    companion object {
        //    constant value
        private val KEY_DATA = "data"

        fun startActivity(context: Context, detail : String){
            var intent = Intent(context,DetailNotesActivity::class.java)
            intent.putExtra(KEY_DATA,detail)
            context.startActivity(intent)
        }
    }

}
