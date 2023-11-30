package com.example.shoppinglist;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingItemAdapter extends RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder> {
    Context context;
    private final List<ShoppingItem> shoppingItemList;

    public ShoppingItemAdapter(Context context, List<ShoppingItem> shoppingItemList) {
        this.shoppingItemList = shoppingItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShoppingItem shoppingItem = shoppingItemList.get(position);
        holder.nameView.setText(shoppingItem.name);
        holder.itemView.findViewById(R.id.delete_button).setOnClickListener(view -> {
            int actualPosition = holder.getAdapterPosition();
            MainActivity.items.remove(actualPosition);
            notifyItemRemoved(actualPosition);
        });
        holder.itemView.findViewById(R.id.edit_button).setOnClickListener(view -> {
            int actualPosition = holder.getAdapterPosition();
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.edit_item_dialog);
            EditText editText = dialog.findViewById(R.id.edit_item_widget);
            editText.setText(MainActivity.items.get(actualPosition).name ,TextView.BufferType.EDITABLE);
            dialog.findViewById(R.id.save_changes_button).setOnClickListener(view1 -> {
                MainActivity.items.get(actualPosition).name = editText.getText().toString();
                notifyItemChanged(actualPosition);
                dialog.dismiss();
            });
            dialog.show();

        });
    }

    @Override
    public int getItemCount() {
        return shoppingItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.item_name);
        }
    }
}
