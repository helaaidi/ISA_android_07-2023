package com.example.loginregister;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyTaskAdapter extends ArrayAdapter<MyTask> {
    Context context;
    public static List<MyTask> arrayListMyData;
    public static final String TAG = "MyTaskAdapter";

    LayoutInflater inflater;
    public MyTaskAdapter(@NonNull Context context, List<MyTask> arrayListMyData) {
        super(context, R.layout.task_list_item, arrayListMyData);
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.arrayListMyData = arrayListMyData;
    }

    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item, null, true);

        TextView codeText = view.findViewById(R.id.NumTask);
        CheckBox taskState = view.findViewById(R.id.taskState);
        MyTask task=arrayListMyData.get(position);
        taskState.setChecked(task.isChecked());
        taskState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                task.setChecked(isChecked);
            }
        });

        codeText.setText(arrayListMyData.get(position).getTxtCode());
        return view;
    }

    public List<MyTask> getCheckedItems() {
        List<MyTask> checkedItems = new ArrayList<>();
        for (MyTask item : arrayListMyData) {
            if (item.isChecked()) {
                checkedItems.add(item);
            }
        }
        return checkedItems;
    }

}