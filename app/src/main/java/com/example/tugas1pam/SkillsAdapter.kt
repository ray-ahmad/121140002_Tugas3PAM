package com.example.tugas1pam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas1pam.databinding.RowSkillsBinding

class SkillsAdapter(private var listData: ArrayList<Skills>): RecyclerView.Adapter<SkillsAdapter.DataViewHolder>() {
    private lateinit var OnClickCallBack: onClickCallBack

    fun setOnClickCallBack(data: onClickCallBack){
        this.OnClickCallBack = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(RowSkillsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val (name,desc) = listData[position]
        holder.binding.txtName.text = name
        holder.binding.txtDesc.text = desc

        holder.itemView.setOnClickListener{
            OnClickCallBack.onItemClicked(listData[holder.absoluteAdapterPosition])
        }
    }

    fun setFilteredList(filterList: List<Skills>){
        this.listData = filterList as ArrayList<Skills>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.count()
    }

    class DataViewHolder(val binding: RowSkillsBinding) : RecyclerView.ViewHolder(binding.root)

    interface onClickCallBack{
        fun onItemClicked(data: Skills)
    }
//    class DataViewHolder(item: View) : RecyclerView.ViewHolder(item){
//        val txtName: TextView = item.findViewById(R.id.txt_name)
//        val txtDesc: TextView = item.findViewById(R.id.txt_desc)
//    }
}