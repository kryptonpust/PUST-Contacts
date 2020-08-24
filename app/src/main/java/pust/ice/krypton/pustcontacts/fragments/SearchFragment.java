package pust.ice.krypton.pustcontacts.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnCloseListener;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import pust.ice.krypton.pustcontacts.MainViewModel;
import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.adapters.UserListAdapter;
import pust.ice.krypton.pustcontacts.pojo.OfficerPojo;

public class SearchFragment extends Fragment {

    private UserListAdapter adapter;
    private NavController navController;
    private String querytext = "";
    private ShimmerRecyclerView recyclerView;
    private String STATE_KEY = "private_state_key";
    private MainViewModel mViewModel;
    private int lastFirstVisiblePosition;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.navController = Navigation.findNavController(viewGroup);
        View inflate = layoutInflater.inflate(R.layout.details_fragment, viewGroup, false);
        this.adapter = new UserListAdapter(getContext());
        this.recyclerView = inflate.findViewById(R.id.detail_recycler);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.showShimmerAdapter();
        this.adapter.registerAdapterDataObserver(new AdapterDataObserver() {
            public void onChanged() {
                super.onChanged();
                hideshimmerlayout();
            }
        });
        return inflate;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        this.mViewModel.getsearchresult().observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
            public void onChanged(List<OfficerPojo> list) {
                SearchFragment.this.adapter.enablePos(true);
                SearchFragment.this.adapter.setsearchresult(list);
                hideshimmerlayout();
                if (!SearchFragment.this.querytext.equals("")) {
                    SearchFragment.this.adapter.filter(SearchFragment.this.querytext);
                }
            }
        });
    }



    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
        menuInflater.inflate(R.menu.fragment_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setQueryHint("Name");
        searchView.setQuery(querytext, false);
        searchView.setIconified(false);
        searchView.setOnCloseListener(new OnCloseListener() {
            public boolean onClose() {
                SearchFragment.this.navController.popBackStack();
                return true;
            }
        });
        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                SearchFragment.this.querytext = str;
                SearchFragment.this.recyclerView.showShimmerAdapter();
                SearchFragment.this.adapter.filter(str);
                return true;
            }
        });
    }

    private void hideshimmerlayout() {
        recyclerView.hideShimmerAdapter();
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(lastFirstVisiblePosition, 0);
    }


    @Override
    public void onPause() {
        super.onPause();
        lastFirstVisiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    }
}
