package neustadt.presidents;


import java.util.List;

public interface OnPresidentSelectedListener {
    void onSelect(President[] presidents, int position, int[] pictures);
}
