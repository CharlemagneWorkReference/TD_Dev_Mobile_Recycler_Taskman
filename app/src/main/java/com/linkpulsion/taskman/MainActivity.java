package com.linkpulsion.taskman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;

    private List<TodoItem> list = Collections.emptyList();
    private TodoItemAdapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView)findViewById(R.id.recycler);
        manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        list = getItems();
        adapter = new TodoItemAdapter(this,list);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

    private ArrayList<TodoItem> getItems() {
        ArrayList<TodoItem> items = new ArrayList<TodoItem>();
        items.add(new TodoItem(TodoItem.Tags.Important, "Réviser ses cours"));
        items.add(new TodoItem(TodoItem.Tags.Normal, "Acheter du pain"));
        items.add(new TodoItem(TodoItem.Tags.Normal, "Marcher 30 mn par jour"));
        items.add(new TodoItem(TodoItem.Tags.Faible, "Manger 5 fruits et légumes"));
        items.add(new TodoItem(TodoItem.Tags.Normal, "Prendre des nouvelles des parents"));
        items.add(new TodoItem(TodoItem.Tags.Faible, "Préparer la prochaine soirée poker"));
        items.add(new TodoItem(TodoItem.Tags.Normal, "Révoir les premières saisons de Game of thrones"));
        items.add(new TodoItem(TodoItem.Tags.Faible, "Finir la vaisselle"));
        items.add(new TodoItem(TodoItem.Tags.Important, "Acheter un nouveau disque dur"));
        items.add(new TodoItem(TodoItem.Tags.Important, "Revoir les raccourcis clavier"));
        items.add(new TodoItem(TodoItem.Tags.Normal, "Tester une nouvelle techno"));
        items.add(new TodoItem(TodoItem.Tags.Faible, "Tester l'application en cours"));

        return items;
    }
}
