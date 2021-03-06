package neustadt.presidents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {
    private President[] presidents;
    private int[] pictures;
    private OnPresidentSelectedListener onPresidentListener;

    public PresidentAdapter(President[] presidents, int[] pictures, OnPresidentSelectedListener onPresidentListener) {
        this.presidents = presidents;
        this.pictures = pictures;
        this.onPresidentListener = onPresidentListener;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.president_list_item, parent, false);
        return new PresidentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PresidentViewHolder holder, final int position) {
        holder.bind(presidents[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPresidentListener.onSelect(presidents, position, pictures);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presidents.length;
    }
}
