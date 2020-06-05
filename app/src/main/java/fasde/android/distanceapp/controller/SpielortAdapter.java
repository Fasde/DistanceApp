package fasde.android.distanceapp.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;
import java.util.List;

import fasde.android.distanceapp.model.Spielort;
import fasde.android.distanceapp.R;

/**
 * Custom Adapter for a ListView of Spielorts.
 */
public class SpielortAdapter extends ArrayAdapter<Spielort> {

    private Context context;
    private List<Spielort> spielortList;
    private List<Spielort> allDataList;
    private SpielortFilter filter;

    /**
     * Constructor for SpielortAdapter, that creates an instance of this class while giving a
     * context and an ArrayList<Spielort>, that is used to initalize two beforehandly declared
     * Lists.
     *
     * @param context
     * @param spielortList
     */
    public SpielortAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<Spielort> spielortList) {
        super(context, 0, spielortList);
        this.context = context;
        this.spielortList = spielortList;
        this.allDataList = spielortList;
    }

    /**
     * Returns the size of the spielortList used at the moment.
     *
     * @return int
     */
    @Override
    public int getCount() {
        return spielortList.size();
    }

    /**
     * Method just for testing purposes.
     * Returns the spielOrtList to check if the constructor is working properly.
     *
     * @return the spielortList
     */
    @TestOnly
    public List<Spielort> getSpielortList(){
        return this.spielortList;
    }

    /**
     * Returns an View-element which is used in the ListView. This element contains a Spielort.
     *
     * @param position
     * @param convertView
     * @param parent
     * @return View
     */
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        Spielort ort = spielortList.get(position);

        TextView spielort = listItem.findViewById(R.id.textView_ort);
        spielort.setText("\t" + ort.getOrtsName());

        TextView anschrift = listItem.findViewById(R.id.textView_anschrift);
        anschrift.setText(ort.toStringArray()[4]);

        TextView strasse = listItem.findViewById(R.id.textView_strasse);
        strasse.setText(ort.toStringArray()[5]);

        TextView kreis = listItem.findViewById(R.id.textView_kreis);
        kreis.setText(ort.getKreis().getName());

        return listItem;
    }

    /**
     * Returns the current Filter. If it is null, a new one is initialized.
     *
     * @return Filter
     */
    @NotNull
    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new SpielortFilter();
        }
        return filter;
    }

    /**
     * Returns the item of the current position in the list.
     * The list used is not the complete list of all items, it is the list where possible searches
     * are already executed.
     *
     * @param position
     * @return Spielort at given position
     */
    @Override
    public Spielort getItem(int position){
        return spielortList.get(position);
    }

    private class SpielortFilter extends Filter {

        /**
         * Filters the Spielorts in the spielortList. Every Spielort, which name contains the
         * constraint, is returned.
         *
         * @param constraint
         * @return FilterResults
         */
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Spielort> filteredList = new ArrayList<>();
            for (Spielort ort : allDataList) {
                if (ort.getOrtsName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                    filteredList.add(ort);
                }
            }
            results.count = filteredList.size();
            results.values = filteredList;
            return results;
        }

        /**
         * Publishes the results of the filtering to the listView.
         *
         * @param constraint
         * @param results
         */
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, @NotNull FilterResults results) {
            spielortList = (ArrayList<Spielort>) results.values;
            notifyDataSetChanged();
        }
    }


}
