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

import java.util.ArrayList;
import java.util.List;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.model.Referee;

public class RefereeAdapter extends ArrayAdapter<Referee> {

    private final Context context;
    private List<Referee> refList;
    private final List<Referee> allDataList;
    private RefereeAdapter.RefereeFilter filter;

    /**
     * Constructor for SpielortAdapter, that creates an instance of this class while giving a
     * context and an ArrayList<Spielort>, that is used to initalize two beforehandly declared
     * Lists.
     */
    public RefereeAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes List<Referee> refList) {
        super(context, 0, refList);
        this.context = context;
        this.refList = refList;
        this.allDataList = refList;
    }

    /**
     * Returns the size of the spielortList used at the moment.
     *
     * @return int
     */
    @Override
    public int getCount() {
        return refList.size();
    }

    /**
     * Returns an View-element which is used in the ListView. This element contains a Spielort.
     *
     * @return View
     */
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_view_item_referee, parent, false);
        }
        Referee ref = refList.get(position);

        TextView name = listItem.findViewById(R.id.textView_name);
        name.setText(ref.getName());

        TextView anschrift = listItem.findViewById(R.id.textView_anschrift);
        anschrift.setText(ref.toStringArray()[1]);

        TextView strasse = listItem.findViewById(R.id.textView_strasse);
        strasse.setText(ref.toStringArray()[2]);


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
            filter = new RefereeAdapter.RefereeFilter();
        }
        return filter;
    }

    /**
     * Returns the item of the current position in the list.
     * The list used is not the complete list of all items, it is the list where possible searches
     * are already executed.
     *
     * @return Spielort at given position
     */
    @Override
    public Referee getItem(int position) {
        return refList.get(position);
    }

    private class RefereeFilter extends Filter {

        /**
         * Filters the Spielorts in the spielortList. Every Spielort, which name contains the
         * constraint, is returned.
         *
         * @return FilterResults
         */
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Referee> filteredList = new ArrayList<>();
            for (Referee ref : allDataList) {
                boolean condition1 = ref.getName().toLowerCase().contains(constraint.toString().toLowerCase());
                boolean condition2 = ref.getAdresse().toLowerCase().contains(constraint.toString().toLowerCase());
                if (condition1 || condition2) {
                    filteredList.add(ref);
                }
            }
            results.count = filteredList.size();
            results.values = filteredList;
            return results;
        }

        /**
         * Publishes the results of the filtering to the listView.
         */
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, @NotNull FilterResults results) {
            refList = (ArrayList<Referee>) results.values;
            notifyDataSetChanged();
        }
    }
}
