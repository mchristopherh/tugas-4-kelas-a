package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<String> idList, nameList;
    private EditText editTextId, editTextName;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        buttonAdd = findViewById(R.id.buttonAdd);

        idList = new ArrayList<>();
        nameList = new ArrayList<>();
        idList.add("225150407111041");
        nameList.add("Michael Christopher Harijanto");

        adapter = new RecyclerViewAdapter(idList, nameList);
        recyclerView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newId = editTextId.getText().toString();
                String newName = editTextName.getText().toString();
                if (!newId.isEmpty() && !newName.isEmpty()) {
                    idList.add(newId);
                    nameList.add(newName);
                    adapter.notifyItemInserted(idList.size() - 1);
                    editTextId.setText("");
                    editTextName.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Tolong masukkan ID dan Nama", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
