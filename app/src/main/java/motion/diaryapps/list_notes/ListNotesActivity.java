package motion.diaryapps.list_notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import motion.diaryapps.R;
import motion.diaryapps.create_notes.CreateNotesActivity;
import motion.diaryapps.utils.Tools;

public class ListNotesActivity extends AppCompatActivity {

    private List<ListNotesModel> mLists = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        initToolbar();

        // TODO: 4/12/19 panggil initRecyclerView() disini

        // TODO: 4/12/19 panggil initDummy() disini
    }

    public void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Diary Apps");
    }

    public void initRecyclerView(){
        // TODO: 4/12/19 -> ganti null dengan component RecyclerView pada activity_list_notes
        // hint: gunakan findViewById(R.id.xxxxx);
        mRecyclerView = null;

        // TODO: 4/12/19 -> ganti null dengan objek ListNotesAdapter
        mAdapter = null;

        // TODO: 4/12/19 -> ganti null dengan objek LinearLayoutManager
        mLayoutManager = null;


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void initDummy(){
        // TODO: 4/12/19 -> lengkapi parameter untuk ListNotesModel disini
        // hint: lakukan setelah menambahkan constructor pada ListNotesModel
        // untuk date gunakan Tools.getCurrentDateISO8601()

        mLists.add(new ListNotesModel());

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_notes,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menuAdd){
            CreateNotesActivity.startActivity(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
