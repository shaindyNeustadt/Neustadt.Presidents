package neustadt.presidents;


public interface OnPresidentSelectedListener {
    void onSelect(President[] presidents, int position, int[] pictures);
}
