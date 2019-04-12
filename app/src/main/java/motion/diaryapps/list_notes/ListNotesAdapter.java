package motion.diaryapps.list_notes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import motion.diaryapps.R;
import motion.diaryapps.detail_notes.DetailNotesActivity;
import motion.diaryapps.utils.Tools;

public class ListNotesAdapter extends RecyclerView.Adapter<ListNotesAdapter.ViewHolder> {

    private List<ListNotesModel> mLists = new ArrayList<>();
    private Context mContext;
    // TODO: 4/12/19 -> Tambahkan Constructor disini
    // hint: gunakan alt+insert

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();

        // TODO: 4/12/19 -> ganti null dengan LayoutInflater.from(...).inflate(...)
        View view = null;

        // TODO: 4/12/19 -> ganti null dengan Inisialisasi objek ViewHolder disini dengan memasukkan view yang telah dibuat
        ViewHolder viewHolder = null;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final int position = i;

        // TODO: 4/12/19 -> set setiap component yang akan tampil sesuai dengan data pada mList
        // hint: untuk date gunakan Tools.getNormalDate(....)

        viewHolder.cvItemListNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: 4/12/19 -> ganti null dengan objek Intent baru ke DetailNotesActivity disini
                // hint: gunakan mContext untuk mengisi parameter context
                Intent intent = null;

                mContext.startActivity(intent);
            }
        });

        Tools.setImage(viewHolder.ivItemListNotes,mLists.get(position).getImage_url());
    }

    @Override
    public int getItemCount() {
        // TODO: 4/12/19 -> ganti 0 pada return menjadi panjang list
        // hint : gunakan method xxxx.size()
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cvItemListNotes;
        ImageView ivItemListNotes;

        // TODO: 4/12/19  -> buat attribute setiap component disini
        // hint: ikuti contoh diatas

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItemListNotes = itemView.findViewById(R.id.cvItemListNotes);
            ivItemListNotes = itemView.findViewById(R.id.ivItemListNotes);

            // TODO: 4/12/19 -> inisialisasi setiap attribute dengan idnya disini
            // hint: gunakan itemView.findViewById(R.id.xxxxx) seperti contoh diatas

        }
    }
}
