package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val tasks = mutableListOf<Task>()
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var buttonAdd: Button
    private lateinit var editTextTask: EditText
    private lateinit var editTextDesc : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)
        buttonAdd = findViewById(R.id.buttonAdd)
        editTextTask = findViewById(R.id.editTextTask)
        editTextDesc = findViewById(R.id.editTextTaskDescription)

        // Set a LinearLayoutManager
        val layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.layoutManager = layoutManager

        taskAdapter = TaskAdapter(tasks)
        recyclerViewTasks.adapter = taskAdapter

        buttonAdd.setOnClickListener {
            val taskTitle = editTextTask.text.toString()
            val taskDescription = editTextDesc.text.toString() // Add logic to get the description from user input
            if (taskTitle.isNotEmpty()) {
                val newTask = Task(taskTitle, taskDescription)
                tasks.add(newTask)
                taskAdapter.notifyItemInserted(tasks.size - 1)
                editTextTask.text.clear()
                editTextDesc.text.clear()
            }
        }
    }
}