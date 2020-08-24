package pust.ice.krypton.pustcontacts.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.adapters.Constants.ORIGIN;
import pust.ice.krypton.pustcontacts.database.tables.Departments;
import pust.ice.krypton.pustcontacts.database.tables.Faculties;
import pust.ice.krypton.pustcontacts.database.tables.Menus;
import pust.ice.krypton.pustcontacts.database.tables.Offices;

public class MainAdapter extends Adapter<MainAdapter.ViewHolder> {
    private Context context;
    private List<?> data = new ArrayList();
    private ORIGIN origin;

    public MainAdapter(ORIGIN origin2, Context context2) {
        this.context = context2;
        this.origin = origin2;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == 0) {
            view = LayoutInflater.from(this.context).inflate(R.layout.recyclerview_empty, viewGroup, false);
        } else {
            view = LayoutInflater.from(this.context).inflate(R.layout.recyclerview_item, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (getItemViewType(i) != 0) {
            switch (this.origin) {
                case NULL:
                    final Menus menus = (Menus) this.data.get(i);
                    viewHolder.cardview.setTag(Integer.valueOf(menus.getMenu_id()));
                    viewHolder.textView.setText(menus.getMenu_title());
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (menus.getMenu_title().toLowerCase().contains("administration")) {
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.ADMINISTRATION.name());
                                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_mainFragment, bundle);
                            } else if (menus.getMenu_title().toLowerCase().contains("academic")) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.ORIGIN_KEY, ORIGIN.ACADEMIC.name());
                                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_mainFragment, bundle2);

                            } else if (menus.getMenu_title().toLowerCase().contains("governance")) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.ORIGIN_KEY, ORIGIN.GOVERNANCE.name());
                                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_mainFragment, bundle2);
                            } else if(menus.getMenu_title().toLowerCase().contains("notices"))
                            {
                                Bundle bundle =new Bundle();
                                bundle.putString(Constants.ORIGIN_KEY,ORIGIN.NOTICES.name());
                                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_mainFragment,bundle);
                            }
                            else {
                                Bundle bundle3 = new Bundle();
                                bundle3.putString(Constants.ORIGIN_KEY, ORIGIN.FACALITIES.name());
                                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_mainFragment, bundle3);
                            }
                        }
                    });
                    return;
                case GOVERNANCE:
                    final String governance = (String) this.data.get(i);
                    viewHolder.textView.setText(governance);
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (governance.equals(Constants.GOVERNANCE_LIST[0])) {
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.G_ACADEMIC_COUNCIL.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle);
                            } else if (governance.equals(Constants.GOVERNANCE_LIST[1])) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.ORIGIN_KEY, ORIGIN.G_FINACE_COMMITTEE.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle2);
                            } else if (governance.equals(Constants.GOVERNANCE_LIST[2])) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.ORIGIN_KEY, ORIGIN.G_REGENT_BOARD.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle2);
                            }
                        }
                    });
                    break;
                case ADMINISTRATION:
                    final Offices offices = (Offices) this.data.get(i);
                    viewHolder.textView.setText(offices.getOffice_name());
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putString(Constants.DEPT_CODE, offices.getDept_code());
                            bundle.putString(Constants.ORIGIN_KEY, ORIGIN.OFFICES.name());
                            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle);
                        }
                    });
                    return;
                case ACADEMIC:
                    final String str = (String) this.data.get(i);
                    viewHolder.textView.setText(str);
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (str.equals(Constants.ACADEMIC_LIST[0])) {
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.AC_FACULTIES.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_self, bundle);
                            } else if (str.equals(Constants.ACADEMIC_LIST[1])) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.ORIGIN_KEY, ORIGIN.AC_DEPARTMENTS.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_self, bundle2);
                            } else if (str.equals(Constants.ACADEMIC_LIST[2])) {
                                Bundle bundle3 = new Bundle();
                                bundle3.putString(Constants.ORIGIN_KEY, ORIGIN.ALL_DEAN.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle3);
                            } else if (str.equals(Constants.ACADEMIC_LIST[3])) {
                                Bundle bundle4 = new Bundle();
                                bundle4.putString(Constants.ORIGIN_KEY, ORIGIN.ALL_CHAIRMAN.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle4);
                            }
                        }
                    });
                    return;
                case AC_DEPARTMENTS:
                    final Faculties faculties = (Faculties) this.data.get(i);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Faculty of ");
                    sb.append(faculties.getFaculty_name());
                    viewHolder.textView.setText(sb.toString());
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putInt(Constants.FACULTY_id, faculties.getFaculty_id());
                            bundle.putString(Constants.ORIGIN_KEY, ORIGIN.AC_DEPARTMENT.name());
                            Navigation.findNavController(view).navigate(R.id.action_mainFragment_self, bundle);
                        }
                    });
                    return;
                case AC_DEPARTMENT:
                    final Departments departments = (Departments) this.data.get(i);
                    viewHolder.textView.setText(departments.getDept_fname());
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putString(Constants.DEPT_CODE, departments.getDept_code());
                            bundle.putString(Constants.ORIGIN_KEY, ORIGIN.AC_DEPARTMENT.name());
                            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle);
                        }
                    });
                    return;
                case AC_FACULTIES:
                    final Faculties faculties2 = (Faculties) this.data.get(i);
                    viewHolder.textView.setText(faculties2.getFaculty_name());
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putString(Constants.DEPT_CODE, faculties2.getDept_code());
                            bundle.putString(Constants.ORIGIN_KEY, ORIGIN.AC_FACULTY.name());
                            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle);
                        }
                    });
                    return;
                case FACALITIES:
                    final String str2 = (String) this.data.get(i);
                    viewHolder.textView.setText(str2);
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (str2.equals(Constants.FACILITIES_LIST[0])) {
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.DEPT_CODE, "O07");
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.FACALITIES.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle);
                            } else if (str2.equals(Constants.FACILITIES_LIST[1])) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.DEPT_CODE, "O18");
                                bundle2.putString(Constants.ORIGIN_KEY, ORIGIN.FACALITIES.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle2);
                            } else if (str2.equals(Constants.FACILITIES_LIST[2])) {
                                Bundle bundle3 = new Bundle();
                                bundle3.putString(Constants.ORIGIN_KEY, ORIGIN.FC_RESIDENCE.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_self, bundle3);
                            } else if (str2.equals(Constants.FACILITIES_LIST[3])) {
                                Bundle bundle4 = new Bundle();
                                bundle4.putString(Constants.DEPT_CODE, "O13");
                                bundle4.putString(Constants.ORIGIN_KEY, ORIGIN.FACALITIES.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle4);
                            } else if (str2.equals(Constants.FACILITIES_LIST[4])) {
                                Bundle bundle5 = new Bundle();
                                bundle5.putString(Constants.DEPT_CODE, "random");
                                bundle5.putString(Constants.ORIGIN_KEY, ORIGIN.FC_BTCL.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle5);
                            }
                        }
                    });
                    return;
                case FC_RESIDENCE:
                    final String str3 = (String) this.data.get(i);
                    viewHolder.textView.setText(str3);
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (str3.equals(Constants.RESIDENCE_LIST[0])) {
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.DEPT_CODE, "O19");
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.FC_HALL.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle);
                            } else if (str3.equals(Constants.RESIDENCE_LIST[1])) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.DEPT_CODE, "O20");
                                bundle2.putString(Constants.ORIGIN_KEY, ORIGIN.FC_HALL.name());
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_officersFragment, bundle2);
                            }
                        }
                    });
                    return;
                case NOTICES:
                    final String notice= (String) this.data.get(i);
                    viewHolder.textView.setText(notice);
                    viewHolder.cardview.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle=new Bundle();
                            if(notice.equals(Constants.NOTICE_LIST[0]))
                            {
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.NOTICES.name());
                            }else if(notice.equals(Constants.NOTICE_LIST[1]))
                            {
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.JOB.name());
                            }else if(notice.equals(Constants.NOTICE_LIST[2]))
                            {
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.PRESS.name());
                            }else if(notice.equals(Constants.NOTICE_LIST[3]))
                            {
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.NOC.name());
                            }else if(notice.equals(Constants.NOTICE_LIST[4]))
                            {
                                bundle.putString(Constants.ORIGIN_KEY, ORIGIN.RESULT.name());
                            }
                            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_noticesFragment, bundle);
                        }
                    });
                    return;
                default:
            }
        }
    }

    public int getItemCount() {
        if (this.data.size() == 0) {
            return 1;
        }
        return this.data.size();
    }

    public int getItemViewType(int i) {
        return this.data.size() == 0 ? 0 : 1;
    }

    public void setdata(List<?> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private CardView cardview;
        private TextView textView;

        private ViewHolder(@NonNull View view) {
            super(view);
            this.textView = view.findViewById(R.id.recycler_textview);
            this.cardview = view.findViewById(R.id.clickroot);
        }
    }
}
