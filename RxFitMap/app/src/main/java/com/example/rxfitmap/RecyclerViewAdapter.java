apackage com.example.rxfitmap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxfitmap.Post;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Post> list = new ArrayList<>();
    RecyclerViewModel viewModel;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_layout , parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.bind(list.get(position));
    }

    public void setPost(List<Post> post) {

        this.list = post;
    }

    public List<Post> getPosts(){

        return list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updatePost(Post post){
        list.set(list.indexOf(post), post);
        notifyItemChanged(list.indexOf(post));
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ProgressBar progressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView =  itemView.findViewById(R.id.txtv);
            progressBar =  itemView.findViewById(R.id.progressBar);
        }

        public  void bind(Post post){

            textView.setText(post.getBody());
            check();
        }

        private void check() {

            if(textView.getText() == null){

                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }

        }
    }
}
