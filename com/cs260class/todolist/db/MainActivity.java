
package com.todoapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        ListView listView = findViewById(R.id.task_list);
        listView.setAdapter(adapter);

        EditText inputTask = findViewById(R.id.input_task);
        FloatingActionButton addTaskButton = findViewById(R.id.add_task_button);

        addTaskButton.setOnClickListener(v -> {
            String task = inputTask.getText().toString().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                adapter.notifyDataSetChanged();
                inputTask.setText("");
            }
        });
    }
}
