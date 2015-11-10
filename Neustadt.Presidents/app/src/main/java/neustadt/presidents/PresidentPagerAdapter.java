package neustadt.presidents;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PresidentPagerAdapter extends PagerAdapter {
private President[] presidents;
    private int[] pictures;
    public PresidentPagerAdapter(President[] presidents, int[] pictures){
        this.presidents = presidents;
        this.pictures = pictures;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        President president = presidents[position];
        View view = inflater.inflate(R.layout.president_pager_item, null);

        ImageView image = (ImageView)view.findViewById(R.id.image);
        image.setImageResource(pictures[position]);
        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText(president.getPresident());
        TextView number = (TextView)view.findViewById(R.id.number);
        number.setText(String.valueOf(president.getNumber()));
        TextView years = (TextView)view.findViewById(R.id.years);
        years.setText(president.getBirthYear() + "-" + president.getDeathYear());
        TextView officeYears = (TextView)view.findViewById(R.id.officeYears);
        officeYears.setText(president.getTookOffice() + "-" + president.getLeftOffice());
        TextView party = (TextView)view.findViewById(R.id.party);
        party.setText(president.getParty());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }


}
