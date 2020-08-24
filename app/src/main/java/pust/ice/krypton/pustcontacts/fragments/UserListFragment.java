package pust.ice.krypton.pustcontacts.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import pust.ice.krypton.pustcontacts.MainViewModel;
import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.adapters.Constants;
import pust.ice.krypton.pustcontacts.adapters.Constants.ORIGIN;
import pust.ice.krypton.pustcontacts.adapters.UserListAdapter;
import pust.ice.krypton.pustcontacts.pojo.OfficerPojo;


public class UserListFragment extends Fragment {

    private UserListAdapter adapter;
    private MainViewModel mainViewModel;
    private ShimmerRecyclerView mainrecyclerview;
    private ORIGIN origin;
    private int lastFirstVisiblePosition;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.origin = ORIGIN.valueOf(getArguments().getString(Constants.ORIGIN_KEY));
        this.mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        View inflate = layoutInflater.inflate(R.layout.details_fragment, viewGroup, false);
        this.adapter = new UserListAdapter(getContext());
        this.mainrecyclerview = inflate.findViewById(R.id.detail_recycler);
        this.mainrecyclerview.setAdapter(this.adapter);
        this.mainrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mainrecyclerview.showShimmerAdapter();
        switch (this.origin) {
            case OFFICES:
                String string = getArguments().getString(Constants.DEPT_CODE);
                this.mainViewModel.getOfficeTeachers(string).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        UserListFragment.this.adapter.setteachers(list);
                        UserListFragment.this.hideshimmerlayout();
                    }
                });
                this.mainViewModel.getResidenceTeacher(string).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        UserListFragment.this.adapter.setresidence(list);
                        UserListFragment.this.hideshimmerlayout();
                    }
                });
                this.mainViewModel.getOfficeOfficers(string).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        UserListFragment.this.adapter.setofficer(list);
                        UserListFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case AC_DEPARTMENT:
                String string2 = getArguments().getString(Constants.DEPT_CODE);
                this.mainViewModel.getDepartmentTeachers(string2).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        UserListFragment.this.adapter.setteachers(list);
                        UserListFragment.this.hideshimmerlayout();
                    }
                });
                this.mainViewModel.getDeptOfficers(string2).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        UserListFragment.this.adapter.setofficer(list);
                        UserListFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case AC_FACULTY:
                this.mainViewModel.getFacultyByCode(getArguments().getString(Constants.DEPT_CODE)).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        UserListFragment.this.adapter.setteachers(list);
                        UserListFragment.this.hideshimmerlayout();
                    }
                });
                break;
            case ALL_DEAN:
                this.mainViewModel.getAllDean().observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        adapter.enablePos(true);
                        adapter.setteachers(list);
                        hideshimmerlayout();

                    }
                });
                break;
            case ALL_CHAIRMAN:
                this.mainViewModel.getAllChairman().observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        adapter.enablePos(true);
                        adapter.setteachers(list);
                        hideshimmerlayout();
                    }
                });
                break;
            case FACALITIES:
                this.mainViewModel.getOfficeOfficers(getArguments().getString(Constants.DEPT_CODE)).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        adapter.setofficer(list);
                        hideshimmerlayout();
                    }
                });
                break;
            case FC_HALL:
                this.mainViewModel.getResidenceTeacher(getArguments().getString(Constants.DEPT_CODE)).observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    public void onChanged(List<OfficerPojo> list) {
                        adapter.setresidence(list);
                        hideshimmerlayout();
                    }
                });
                break;
            case FC_BTCL:
                hideshimmerlayout();
                break;
            case G_ACADEMIC_COUNCIL:
                mainViewModel.getAcMembers().observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    @Override
                    public void onChanged(List<OfficerPojo> officerPojos) {
                        adapter.setteachers(officerPojos);
                        hideshimmerlayout();
                    }
                });
                break;
            case G_FINACE_COMMITTEE:
                mainViewModel.getFcMembers().observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    @Override
                    public void onChanged(List<OfficerPojo> officerPojos) {
                        adapter.setteachers(officerPojos);
                        hideshimmerlayout();
                    }
                });
                break;
            case G_REGENT_BOARD:
                mainViewModel.getRbMembers().observe(getViewLifecycleOwner(), new Observer<List<OfficerPojo>>() {
                    @Override
                    public void onChanged(List<OfficerPojo> officerPojos) {
                        adapter.setteachers(officerPojos);
                        hideshimmerlayout();
                    }
                });
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
