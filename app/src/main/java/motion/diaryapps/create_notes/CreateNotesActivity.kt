package motion.diaryapps.create_notes

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

import motion.diaryapps.R
import motion.diaryapps.dao.DiaryDao
import motion.diaryapps.list_notes.ListNotesModel
import motion.diaryapps.utils.Tools

class CreateNotesActivity : AppCompatActivity() {

    //  layout component
    private var mTvToolbarTitle: TextView? = null
    private var mEtCreateNotesTitle: EditText? = null
    private var mEtCreateNotesDescription: EditText? = null
    private var mLlCreateNotesCover: LinearLayout? = null
    private var mRlCreateNotesCover: RelativeLayout? = null
    private var mIvCreateNotesEdit: ImageView? = null
    private var mBtnCreateNotes: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_notes)

        val type = intent.getIntExtra(KEY_TYPE, 0)

        initToolbar()
        initComponent()
        initListener(type)
        changeState(type)
    }

    fun initComponent() {
        mTvToolbarTitle = findViewById(R.id.tvCreateNotesCover)
        mEtCreateNotesTitle = findViewById(R.id.etCreateNotesTitle)
        mEtCreateNotesDescription = findViewById(R.id.etCreateNotesDescription)
        mLlCreateNotesCover = findViewById(R.id.llCreateNotesCover)
        mRlCreateNotesCover = findViewById(R.id.rlCreateNotesCover)
        mIvCreateNotesEdit = findViewById(R.id.ivCreateNotesEdit)
        mBtnCreateNotes = findViewById(R.id.btnCreateNotes)
    }

    fun changeState(type: Int) {
        when (type) {
            TYPE_EDIT -> {
                mTvToolbarTitle!!.text = "Edit Diary"
                initData(intent.getSerializableExtra(KEY_DATA) as DiaryDao)
                mLlCreateNotesCover!!.visibility = View.GONE
                mRlCreateNotesCover!!.visibility = View.VISIBLE
            }
            else -> {
                mTvToolbarTitle!!.text = "Create Diary"
                mLlCreateNotesCover!!.visibility = View.VISIBLE
                mRlCreateNotesCover!!.visibility = View.GONE
            }
        }
    }

    fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }

    }

    fun initData(data: DiaryDao) {
        mEtCreateNotesTitle!!.setText(data.title)
        mEtCreateNotesDescription!!.setText(data.description)
        Tools.setImage(mIvCreateNotesEdit, data.url_cover!!)
    }

    fun initListener(type: Int) {
        mBtnCreateNotes!!.setOnClickListener {
            if (type == TYPE_EDIT)
                Toast.makeText(this@CreateNotesActivity, "button update clicked", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this@CreateNotesActivity, "button create clicked ", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    companion object {

        //  static Variable
        val TYPE_ADD = 0
        val TYPE_EDIT = 1
        val KEY_TYPE = "type"
        val KEY_DATA = "data"

        fun startActivity(context: Context) {
            val intent = Intent(context, CreateNotesActivity::class.java)
            intent.putExtra(KEY_TYPE, TYPE_ADD)
            context.startActivity(intent)
        }

        fun startActivity(context: Context, data: DiaryDao) {
            val intent = Intent(context, CreateNotesActivity::class.java)
            intent.putExtra(KEY_TYPE, TYPE_EDIT)
            intent.putExtra(KEY_DATA, data)
            context.startActivity(intent)
        }
    }
}
