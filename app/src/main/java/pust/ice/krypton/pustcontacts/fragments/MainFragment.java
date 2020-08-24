package pust.ice.krypton.pustcontacts.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.Arrays;
import java.util.List;

import pust.ice.krypton.pustcontacts.MainViewModel;
import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.adapters.Constants;
import pust.ice.krypton.pustcontacts.adapters.Constants.ORIGIN;
import pust.ice.krypton.pustcontacts.adapters.MainAdapter;
import pust.ice.krypton.pustcontacts.database.tables.Departments;
import pust.ice.krypton.pustcontacts.database.tables.Faculties;
import pust.ice.krypton.pustcontacts.database.tables.Menus;
import pust.ice.krypton.pustcontacts.database.tables.Offices;

public class MainFragment extends Fragment {
    public MainAdapter adapter;
    private MainViewModel mainViewModel;
    private ShimmerRecyclerView mainrecyclerview;
    private ORIGIN origin;
    private int lastFirstVisiblePosition;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getArguments() == null) {
            this.origin = ORIGIN.NULL;
        } else {
            this.origin = ORIGIN.valueOf(getArguments().getString(Constants.ORIGIN_KEY, "NULL"));
        }
        this.mainViewModel =new ViewModelProvider(this).get(MainViewModel.class);

        View inflate = layoutInflater.inflate(R.layout.main_fragment, viewGroup, false);
        this.mainrecyclerview = inflate.findViewById(R.id.recyclerview);
        this.mainrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        this.adapter = new MainAdapter(this.origin, getContext());
        this.mainrecyclerview.setAdapter(this.adapter);
        this.mainrecyclerview.showShimmerAdapter();
        switch (this.origin) {
            case NULL:
                this.mainViewModel.getmenus().observe(getViewLifecycleOwner(), new Observer<List<Menus>>() {
                    public void onChanged(List<Menus> list) {
                        MainFragment.this.adapter.setdata(list);
                        MainFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case ADMINISTRATION:
                this.mainViewModel.getOffices().observe(getViewLifecycleOwner(), new Observer<List<Offices>>() {
                    public void onChanged(List<Offices> list) {
                        MainFragment.this.adapter.setdata(list);
                        MainFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case GOVERNANCE:
                this.adapter.setdata(Arrays.asList(Constants.GOVERNANCE_LIST));
                hideshimmerlayout();
                break;
            case ACADEMIC:
                this.adapter.setdata(Arrays.asList(Constants.ACADEMIC_LIST));
                hideshimmerlayout();
                break;
            case AC_DEPARTMENTS:
                this.mainViewModel.getFaculties().observe(getViewLifecycleOwner(), new Observer<List<Faculties>>() {
                    public void onChanged(List<Faculties> list) {
                        MainFragment.this.adapter.setdata(list);
                        MainFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case AC_DEPARTMENT:
                this.mainViewModel.getDepartment(getArguments().getInt(Constants.FACULTY_id)).observe(getViewLifecycleOwner(), new Observer<List<Departments>>() {
                    public void onChanged(List<Departments> list) {
                        MainFragment.this.adapter.setdata(list);
                        MainFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case AC_FACULTIES:
                this.mainViewModel.getFaculties().observe(getViewLifecycleOwner(), new Observer<List<Faculties>>() {
                    public void onChanged(List<Faculties> list) {
                        MainFragment.this.adapter.setdata(list);
                        MainFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case FACALITIES:
                this.adapter.setdata(Arrays.asList(Constants.FACILITIES_LIST));
                hideshimmerlayout();
                break;
            case FC_RESIDENCE:
                this.adapter.setdata(Arrays.asList(Constants.RESIDENCE_LIST));
                hideshimmerlayout();
                break;
            case NOTICES:
                this.adapter.setdata(Arrays.asList(Constants.NOTICE_LIST));
                hideshimmerlayout();
                break;
        }
        return inflate;
    }

    private void hideshimmerlayout() {
        this.mainrecyclerview.hideShimmerAdapter();
        ((LinearLayoutManager) mainrecyclerview.getLayoutManager()).scrollToPositionWithOffset(lastFirstVisiblePosition, 0);
    }


    @Override
    public void onPause() {
        super.onPause();
        lastFirstVisiblePosition = ((LinearLayoutManager) mainrecyclerview.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    }
}
