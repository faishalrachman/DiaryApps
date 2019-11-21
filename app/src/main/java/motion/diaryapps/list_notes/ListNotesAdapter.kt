package motion.diaryapps.list_notes

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list_notes.view.*
import motion.diaryapps.R
import motion.diaryapps.detail_notes.DetailNotesActivity
import motion.diaryapps.utils.Tools

class ListNotesAdapter(private val children : List<ListNotesModel>)
    : RecyclerView.Adapter<ListNotesAdapter.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v =  LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_notes,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]

        holder.initData(child)
        holder.initListener(context,child)
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun initData(child : ListNotesModel){
            // TODO : Initiate Variable Here
            itemView.tvItemListNotesDate.text = Tools.getNormalDate(child.date)
            itemView.tvItemListNotesTitle.text = child.title
            Tools.setImage(itemView.ivItemListNotes,child.image_url)
        }

        fun initListener(context : Context, child : ListNotesModel){
            // TODO : Initiate Listener Here
            itemView.setOnClickListener{
                // TODO : Do Something after item click
                DetailNotesActivity.startActivity(context,child.id)
            }
        }
    }
}
