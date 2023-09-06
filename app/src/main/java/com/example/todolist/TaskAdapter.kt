package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val tasks: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        val taskTitleTextView = holder.itemView.findViewById<TextView>(R.id.textViewTaskTitle)
        val taskCheckBox = holder.itemView.findViewById<CheckBox>(R.id.checkBoxTask)
        val taskDescriptionTextView = holder.itemView.findViewById<TextView>(R.id.textViewTaskDescription)
        val deleteButton = holder.itemView.findViewById<ImageButton>(R.id.buttonDeleteTask)


        taskTitleTextView.text = task.title
        taskDescriptionTextView.text = task.description
        taskCheckBox.isChecked = task.isCompleted
        taskCheckBox.setOnCheckedChangeListener { _ , isChecked -> task.isCompleted = isChecked }





        deleteButton.setOnClickListener {
            tasks.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, tasks.size)
        }

    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}