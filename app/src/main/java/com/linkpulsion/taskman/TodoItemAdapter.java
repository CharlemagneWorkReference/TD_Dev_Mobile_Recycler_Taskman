package com.linkpulsion.taskman;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

class TodoItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<TodoItem> list = Collections.emptyList();
    TodoItem currentItem;
    int curPos = 0;

    TodoItemAdapter(@NonNull Context context, List<TodoItem> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.row,parent,false);
        return new TodoItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TodoItemHolder todoItemHolder = (TodoItemHolder)holder;
        currentItem = list.get(position);
        todoItemHolder.aSwitch.setChecked(currentItem.isDone());
        todoItemHolder.label.setText(currentItem.getLabel());
        if (currentItem.getCurentTag() == TodoItem.Tags.Faible){
            todoItemHolder.tagColor.setBackgroundColor(Color.GREEN);
        }
        if (currentItem.getCurentTag() == TodoItem.Tags.Normal){
            todoItemHolder.tagColor.setBackgroundColor(context.getResources().getColor(R.color.orange));
        }
        if (currentItem.getCurentTag() == TodoItem.Tags.Important){
            todoItemHolder.tagColor.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class TodoItemHolder extends RecyclerView.ViewHolder{

        ImageView tagColor;
        Switch aSwitch;
        TextView label;

        TodoItemHolder(View itemView) {
            super(itemView);
            tagColor = (ImageView)itemView.findViewById(R.id.tagColor);
            aSwitch = (Switch)itemView.findViewById(R.id.done);
            label = (TextView)itemView.findViewById(R.id.label);
        }
    }
}
