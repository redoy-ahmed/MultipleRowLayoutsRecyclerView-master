package com.alexzh.tutorial.multiplerowlayoutsrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent;

import java.util.List;

import static com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent.CITY_TYPE;
import static com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent.EVENT_TYPE;

public class DifferentRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CityEvent> mList;

    DifferentRowAdapter(List<CityEvent> list) {
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case CITY_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_question, parent, false);
                return new CommentViewHolder(view);
            case EVENT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_question_reply, parent, false);
                return new CommentReplyViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CityEvent object = mList.get(position);
        if (object != null) {
            switch (object.getType()) {
                case CITY_TYPE:
                    ((CommentViewHolder) holder).mTitle.setText(object.getName());
                    break;
                case EVENT_TYPE:
                    ((CommentReplyViewHolder) holder).mTitle.setText(object.getName());
                    ((CommentReplyViewHolder) holder).mDescription.setText(object.getDescription());
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            CityEvent object = mList.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        CommentViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.list_item_comment_text_view_poster_title);
        }
    }

    public static class CommentReplyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;

        CommentReplyViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.list_item_comment_text_view_poster_title);
            mDescription = (TextView) itemView.findViewById(R.id.list_item_comment_expandable_text_view_comment);
        }
    }
}