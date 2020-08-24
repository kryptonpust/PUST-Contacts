package pust.ice.krypton.pustcontacts.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

//import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import pust.ice.krypton.pustcontacts.BuildConfig;
import pust.ice.krypton.pustcontacts.MainViewModel;
import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.adapters.Constants;
import pust.ice.krypton.pustcontacts.api.Api;
import pust.ice.krypton.pustcontacts.database.tables.Publications;
import pust.ice.krypton.pustcontacts.database.tables.Teachers;
import pust.ice.krypton.pustcontacts.pojo.OfficerPojo;

public class ProfileFragment extends Fragment {
    private CardView email;
    private TextView email_txt;
    private TextView email_txt2;
    private CardView ip_phone;
    private ImageButton msg1;
    private ImageButton msg2;

    private OfficerPojo o;
    private ImageButton office_msg;
    private CardView office_phone;
    private CardView pabx;
    private CardView phone1;
    private CardView phone2, qualificationcard, researchcard;
    private TextView phone_num1;
    private TextView phone_num2;
    private TextView phone_num3;
    private TextView phone_num4;
    private TextView phone_num5;
    private TextView qualification_txt;
    private TextView research_txt, faculty_txt, university_txt;
    private Picasso picasso;
    private CircleImageView pro_ava;
    private ImageView pro_back;
    private TextView pro_des;
    private TextView pro_name;
    private CardView work_email;
    private FlexboxLayout social_root;
    private TextView book_count, journal_count, conf_count, total_count;
    private CardView book_published_root, journal_root, conf_root, total_root;

    private MainViewModel mainViewModel;

    private FloatingActionButton floatingActionButton;

    private enum LINKS {
        FACEBOOK,
        TWITTER,
        SKYPE,
        LINKDIN,
        RESEARCH_GATE,
        SCHOLAR,
        ORCID,
        WEBSITE


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public View onCreateView(final LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.picasso = Picasso.get();
        if (BuildConfig.DEBUG) {
            picasso.setIndicatorsEnabled(true);
        }
        if (getArguments() != null) {
            o = (OfficerPojo) getArguments().getSerializable(Constants.DATA_KEY);
        }
        this.mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        this.pro_ava = inflate.findViewById(R.id.profile_pic);
        this.pro_back = inflate.findViewById(R.id.profile_background);
        this.pro_name = inflate.findViewById(R.id.profile_name);
        this.pro_des = inflate.findViewById(R.id.profile_des);
        qualification_txt = inflate.findViewById(R.id.qualification_txt);
        research_txt = inflate.findViewById(R.id.research_txt);
        if (this.o.getImages() != null) {
            this.picasso.load(Constants.geturl(this.o.getImages(), o.getDir())).placeholder(R.drawable.user).into(this.pro_ava);
//            this.picasso.load("asd").placeholder(R.drawable.header_back).into(this.pro_back);
        } else {
            this.picasso.load(Constants.geturl("", -1000)).placeholder(R.drawable.user).into(this.pro_ava);
//            this.picasso.load("asd").placeholder(R.drawable.header_back).into(this.pro_back);
        }
        faculty_txt = inflate.findViewById(R.id.faculty);
        university_txt = inflate.findViewById(R.id.university);
        floatingActionButton = inflate.findViewById(R.id.floatingActionButton);
        this.pro_name.setText(this.o.getName());
        this.pro_des.setText(this.o.getDesignation());
        this.phone1 = inflate.findViewById(R.id.phone1);
        this.phone2 = inflate.findViewById(R.id.phone2);
        this.office_phone = inflate.findViewById(R.id.offfice_phone);
        this.pabx = inflate.findViewById(R.id.PABX);
        this.ip_phone = inflate.findViewById(R.id.IP_phone);
        this.work_email = inflate.findViewById(R.id.work_email);
        this.email = inflate.findViewById(R.id.email);
        qualificationcard = inflate.findViewById(R.id.qualificationcard);
        researchcard = inflate.findViewById(R.id.research);
        this.phone_num1 = inflate.findViewById(R.id.phone_num1);
        this.phone_num2 = inflate.findViewById(R.id.phone_num2);
        this.phone_num3 = inflate.findViewById(R.id.phone_num3);
        this.phone_num4 = inflate.findViewById(R.id.phone_num4);
        this.phone_num5 = inflate.findViewById(R.id.phone_num5);
        this.email_txt = inflate.findViewById(R.id.email_txt);
        this.email_txt2 = inflate.findViewById(R.id.email_txt2);
        this.msg1 = inflate.findViewById(R.id.msg_1);
        this.msg2 = inflate.findViewById(R.id.msg_2);
        this.office_msg = inflate.findViewById(R.id.msg_3);
        this.social_root = inflate.findViewById(R.id.social_root);
        this.book_count = inflate.findViewById(R.id.book_published);
        this.journal_count = inflate.findViewById(R.id.publications);
        this.book_published_root = inflate.findViewById(R.id.book_pub_root);
        this.journal_root = inflate.findViewById(R.id.journal_root);
        this.conf_root = inflate.findViewById(R.id.conf_root);
        this.total_root = inflate.findViewById(R.id.total_root);
        this.conf_count = inflate.findViewById(R.id.conf_count);
        this.total_count = inflate.findViewById(R.id.total_count);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (!(getActivity() == null || getActivity().getCurrentFocus() == null)) {
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        String str = " (Personal)";
        if (this.o.getMobile_1() != null) {
            this.phone1.setVisibility(View.VISIBLE);
            StringBuilder sb = new StringBuilder();
            sb.append(this.o.getMobile_1());
            sb.append(str);
            this.phone_num1.setText(sb.toString());
            registercontextmenu(this.phone1, this.o.getMobile_1());
            this.phone1.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makecall(profileFragment.o.getMobile_1());
                }
            });
            this.msg1.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makesms(profileFragment.o.getMobile_1());
                }
            });
        }
        if (this.o.getMobile_2() != null) {
            this.phone2.setVisibility(View.VISIBLE);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.o.getMobile_2());
            sb2.append(str);
            this.phone_num2.setText(sb2.toString());
            registercontextmenu(this.phone2, this.o.getMobile_2());
            this.phone2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makecall(profileFragment.o.getMobile_2());
                }
            });
            this.msg2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makesms(profileFragment.o.getMobile_2());
                }
            });
        }
        if (this.o.getOffice_phone() != null) {
            this.office_phone.setVisibility(View.VISIBLE);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.o.getOffice_phone());
            sb3.append(" (Office)");
            this.phone_num3.setText(sb3.toString());
            registercontextmenu(this.office_phone, this.o.getOffice_phone());
            this.office_phone.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makecall(profileFragment.o.getOffice_phone());
                }
            });
            this.office_msg.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makesms(profileFragment.o.getOffice_phone());
                }
            });
        }
        if (this.o.getPABX_no() != null) {
            this.pabx.setVisibility(View.VISIBLE);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.o.getPABX_no());
            sb4.append(" (PABX)");
            this.phone_num4.setText(sb4.toString());
            registercontextmenu(this.pabx, this.o.getPABX_no());
            this.pabx.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makecall(profileFragment.o.getPABX_no());
                }
            });
        }
        if (this.o.getIP_phone() != null) {
            this.ip_phone.setVisibility(View.VISIBLE);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.o.getIP_phone());
            sb5.append(" (IP Phone)");
            this.phone_num5.setText(sb5.toString());
            registercontextmenu(this.ip_phone, this.o.getIP_phone());
            this.ip_phone.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makecall(profileFragment.o.getIP_phone());
                }
            });
        }
        if (this.o.getEmail() != null) {
            this.email.setVisibility(View.VISIBLE);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.o.getEmail());
            sb6.append(str);
            this.email_txt2.setText(sb6.toString());
            registercontextmenu(this.email, this.o.getEmail());
            this.email.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makeemail(profileFragment.o.getEmail());
                }
            });
        }
        if (this.o.getWork_email() != null) {
            this.work_email.setVisibility(View.VISIBLE);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.o.getWork_email());
            sb7.append(" (Work)");
            this.email_txt.setText(sb7.toString());
            registercontextmenu(this.work_email, this.o.getWork_email());
            this.work_email.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.makeemail(profileFragment.o.getWork_email());
                }
            });
        }
        if (o.getQualification() != null) {
            qualificationcard.setVisibility(View.VISIBLE);
            qualification_txt.setText(o.getQualification());
        }
        if (o.getResearch_Area() != null) {
            researchcard.setVisibility(View.VISIBLE);
            research_txt.setText(o.getResearch_Area());
        }
        if (o.getFaculty() != null) {
            faculty_txt.setVisibility(View.VISIBLE);
            faculty_txt.setText(o.getFaculty());
        }
        if (o.getUniversity() != null && !o.getUniversity().equals("pust")) {
            university_txt.setVisibility(View.VISIBLE);
            university_txt.setText(o.getUniversity());
        }
        if (o.getDir() == 1 && o.getUser_id().startsWith("PUST_")) {
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.URL + "academic/departments/dept_teachers/dept_teachers_profile/" + o.getUser_id().substring(5)));
                    startActivity(intent);
                }
            });

            this.mainViewModel.getdetails(o.getUser_id()).observe(this, new Observer<Teachers>() {
                @Override
                public void onChanged(Teachers teachers) {
                    if (social_root.getVisibility() != View.VISIBLE) {
                        if (teachers.getWebsite() != null && !teachers.getWebsite().equals("")) {
                            activate(R.drawable.website, R.color.white, teachers.getWebsite(), LINKS.WEBSITE);
                        }
                        if (teachers.getFacebook() != null && !teachers.getFacebook().equals("")) {
                            activate(R.drawable.facebook, R.color.white, teachers.getFacebook(), LINKS.FACEBOOK);
                        }
                        if (teachers.getTwitter() != null && !teachers.getTwitter().equals("")) {
                            activate(R.drawable.twitter, R.color.white, teachers.getTwitter(), LINKS.TWITTER);
                        }
                        if (teachers.getLinkedin() != null && !teachers.getLinkedin().equals("")) {
                            activate(R.drawable.linkedin, R.color.white, teachers.getLinkedin(), LINKS.LINKDIN);
                        }
                        if (teachers.getSkype() != null && !teachers.getSkype().equals("")) {
                            activate(R.drawable.skype, R.color.white, teachers.getSkype(), LINKS.SKYPE);
                        }
                        if (teachers.getResearchgate() != null && !teachers.getResearchgate().equals("")) {
                            activate(R.drawable.research_gate, R.color.white, teachers.getResearchgate(), LINKS.RESEARCH_GATE);
                        }
                        if (teachers.getGscholar() != null && !teachers.getGscholar().equals("")) {
                            activate(R.drawable.google_scholar, R.color.white, teachers.getGscholar(), LINKS.SCHOLAR);
                        }
                        if (teachers.getOrcid() != null && !teachers.getOrcid().equals("")) {
                            activate(R.drawable.orcid, R.color.white, teachers.getOrcid(), LINKS.ORCID);
                        }
                    }

                }

                private void activate(int icon, int color, final String value, final LINKS links) {
                    if (social_root.getVisibility() != View.VISIBLE) {
                        social_root.setVisibility(View.VISIBLE);
                    }


                    FloatingActionButton imageButton = new FloatingActionButton(getContext());
//                    imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageButton.setUseCompatPadding(true);
                    imageButton.setImageResource(icon);
                    imageButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color)));
                    imageButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            switch (links) {
                                case FACEBOOK:
                                case TWITTER:
                                case WEBSITE:
                                case SCHOLAR:
                                case RESEARCH_GATE:
                                case ORCID:
                                    fallbackmakeintent(value);
                                    break;
                                case SKYPE:
                                    try {
                                        getContext().getPackageManager().getPackageInfo("com.skype.raider", 0);
                                        makeintent("skype://" + value.substring(value.lastIndexOf('/') + 1));
                                    } catch (Exception e) {
                                        makeToast("Skype is not installed");
                                        fallbackmakeintent(value);
                                    }
                                    break;
                                case LINKDIN:
                                    try {
                                        getContext().getPackageManager().getPackageInfo("com.linkedin.android", 0);
                                        makeintent(value);
                                    } catch (Exception e) {
                                        makeToast("linkedin is not installed");
                                        fallbackmakeintent(value);
                                    }
                                    break;
                            }

                        }

                        private void fallbackmakeintent(String value) {
                            if(!value.startsWith("http"))
                            {
                                value="http://"+value;
                            }
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(value));
                            startActivity(intent);
                        }

                        private void makeintent(String substring) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(substring));
                            startActivity(intent);
                        }

                        private void makeToast(String val) {

                            Toast.makeText(getContext(), val, Toast.LENGTH_SHORT).show();
                        }
                    });
                    social_root.addView(imageButton);

                }
            });
        }


        this.mainViewModel.getbookpublications(o.getUser_id()).observe(this, new Observer<List<Publications>>() {
            @Override
            public void onChanged(List<Publications> publications) {
                int book = 0, journal = 0, conf = 0;
                for (Publications p : publications) {
                    if (p.getField().equals("Published_Book")) {
                        if (book_published_root.getVisibility() != View.VISIBLE) {
                            book_published_root.setVisibility(View.VISIBLE);
                        }
                        book = p.getTotal();
                    } else if (p.getField().equals("Journal_Publications")) {
                        if (journal_root.getVisibility() != View.VISIBLE) {
                            journal_root.setVisibility(View.VISIBLE);
                        }
                        journal = p.getTotal();
                    } else if (p.getField().equals("Conference_Proceedings")) {
                        if (conf_root.getVisibility() != View.VISIBLE) {
                            conf_root.setVisibility(View.VISIBLE);
                        }
                        conf = p.getTotal();
                    }
                }
                if (book != 0) {
                    book_count.setText(String.valueOf(book));
                    book_published_root.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gotoProfile();
                        }
                    });
                }
                if (journal != 0) {
                    journal_count.setText(String.valueOf(journal));
                    journal_root.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gotoProfile();
                        }
                    });
                }
                if (conf != 0) {
                    conf_count.setText(String.valueOf(conf));
                    conf_root.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gotoProfile();
                        }
                    });
                }
                if (book != 0 || journal != 0 || conf != 0) {
                    if (total_root.getVisibility() != View.VISIBLE) {
                        total_root.setVisibility(View.VISIBLE);
                    }
                    total_count.setText(String.valueOf(book + journal + conf));
                    total_root.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gotoProfile();
                        }
                    });
                }
            }
        });
    }

    private void gotoProfile() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.URL + "academic/departments/dept_teachers/dept_teachers_profile/" + o.getUser_id().substring(5)));
        startActivity(intent);
    }

    private void makesms(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        StringBuilder sb = new StringBuilder();
        sb.append("smsto:");
        sb.append(str);
        intent.setData(Uri.parse(sb.toString()));
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private void makeemail(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        StringBuilder sb = new StringBuilder();
        sb.append("mailto:");
        sb.append(str);
        intent.setData(Uri.parse(sb.toString()));
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void makecall(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        StringBuilder sb = new StringBuilder();
        sb.append("tel:");
        sb.append(str);
        intent.setData(Uri.parse(sb.toString()));
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void registercontextmenu(CardView cardView, String str) {
        cardView.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add("Share").setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.TEXT", ProfileFragment.this.o.getMobile_1());
                        intent.setType("text/plain");
                        ProfileFragment.this.startActivity(intent);
                        return true;
                    }
                });
            }
        });
    }
}
