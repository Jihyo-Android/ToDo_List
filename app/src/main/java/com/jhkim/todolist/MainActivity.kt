package com.jhkim.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jhkim.todolist.databinding.ActivityMainBinding
import com.jhkim.todolist.databinding.ItemTodoBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Temporary Data for making adapter
    private val data = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        data.add(Todo("숙제", false))
        data.add(Todo("청소", false))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = TodoAdapter(data)
    }
}

data class Todo(val text: String, var isDone: Boolean)


class TodoAdapter(private val dataSet: List<Todo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_todo, viewGroup, false)

        return TodoViewHolder(ItemTodoBinding.bind(view))
    }

    override fun onBindViewHolder(viewHolder: TodoViewHolder, position: Int) {
        viewHolder.binding.todoText.text = dataSet[position].text
    }

    override fun getItemCount() = dataSet.size

}
