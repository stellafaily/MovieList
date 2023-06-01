package com.example.movielist;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localTitles;
    private int[] localImages;

    public interface OnItemclickListner {
        void onItemClickListner(View v, int pos);
    }

    private OnItemclickListner itemclickListner;
    public void setOnItemClickListner(OnItemclickListner lis) {
        itemclickListner = lis;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        //private final TextView textView;
        private final ImageView imageView;
        private final TextView tvTitle;
        private final TextView tvRating;
        private final TextView tvGenre;
        private final TextView tvYear;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            //textView = (TextView) view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvGenre = view.findViewById(R.id.tvGenre);
            tvRating = view.findViewById(R.id.tvRating);
            tvYear = view.findViewById(R.id.tvYear);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION)
                        itemclickListner.onItemClickListner(view, pos);
                }
            });
        }


        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvRating() {
            return tvRating;
        }

        public TextView getTvGenre() {
            return tvGenre;
        }

        public TextView getTvYear() {
            return tvYear;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param titles String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(String[] titles, int[] images) {
        //localDataSet = dataSet;
        localTitles = titles;
        localImages = images;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movieitem, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.getTextView().setText(localDataSet[position]);
        viewHolder.getImageView().setImageResource(localImages[position]);
        viewHolder.getTvTitle().setText(localTitles[position]);
        viewHolder.getTvRating().setText("9.0" + position);
        viewHolder.getTvGenre().setText("판타지");
        viewHolder.getTvYear().setText("2020" + position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localTitles.length;
    }
}
