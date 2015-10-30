package neustadt.presidents;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PresidentPagerAdapter extends PagerAdapter {
private President[] presidents;
    public PresidentPagerAdapter(President[] presidents){
        this.presidents = presidents;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o){
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.president_pager_item, null);
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView number = (TextView)view.findViewById(R.id.number);

        President president = presidents[position];
        name.setText(president.getPresident());
        number.setText(president.getNumber());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }


}
