package neustadt.presidents;

import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PresidentDetailViewHolder {
    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.number)
    TextView number;

    public PresidentDetailViewHolder(View itemView, President president) {
        ButterKnife.bind(this, itemView);
        name.setText(president.getPresident());
        number.setText(String.valueOf(president.getNumber()));
    }
}


