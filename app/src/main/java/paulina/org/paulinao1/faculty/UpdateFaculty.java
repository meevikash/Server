package paulina.org.paulinao1.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import paulina.org.paulinao1.R;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDepartment,ceDepartment,meDepartment,chmDepartment,mteDepartment,phyDepartment,ephyDepartment,bseDepartment,eeDepartment,aeDepartment,aneDepartment,ecoDepartment,ppDepartment,mseDepartment,mineDepartment,cermDepartment,ttDepartment,pieDepartment,oebDepartment,cheDepartment;
    private LinearLayout chmNoData,csNoData,bseNoData,meNoData,phyNoData,mteNoData,ephyNoData,ceNoData,eeNoData,aeNoData,aneNoData,ecoNoData,ppNoData,mseNoData,mineNoData,cermNoData,ttNoData,pieNoData,oebNoData,cheNoData;
    private List<TeacherData> list1,list2,list3,list20,list4,list5,list6,list7,list8,list9,list10,list11,list12,list13,list14,list15,list16,list17,list18,list19;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        chmDepartment = findViewById(R.id.chmDepartment);
        mteDepartment = findViewById(R.id.mteDepartment);
        csDepartment = findViewById(R.id.csDepartment);
        meDepartment = findViewById(R.id.meDepartment);
        phyDepartment = findViewById(R.id.phyDepartment);
        ephyDepartment = findViewById(R.id.ephyDepartment);
        bseDepartment = findViewById(R.id.bseDepartment);
        eeDepartment = findViewById(R.id.eeDepartment);
        ceDepartment = findViewById(R.id.ceDepartment);
        mineDepartment = findViewById(R.id.mineDepartment);
        ppDepartment = findViewById(R.id.ppDepartment);
        ttDepartment = findViewById(R.id.ttDepartment);
        mseDepartment = findViewById(R.id.mseDepartment);
        aeDepartment = findViewById(R.id.aeDepartment);
        aneDepartment = findViewById(R.id.aneDepartment);
        ecoDepartment = findViewById(R.id.ecoDepartment);
        cermDepartment = findViewById(R.id.cermDepartment);
        pieDepartment = findViewById(R.id.pieDepartment);
        oebDepartment = findViewById(R.id.oebDepartment);
        cheDepartment = findViewById(R.id.cheDepartment);

        chmNoData = findViewById(R.id.chmNoData);
        csNoData = findViewById(R.id.csNoData);
        meNoData = findViewById(R.id.meNoData);
        phyNoData = findViewById(R.id.phyNoData);
        ephyNoData = findViewById(R.id.ephyNoData);
        bseNoData = findViewById(R.id.bseNoData);
        eeNoData = findViewById(R.id.eeNoData);
        ceNoData = findViewById(R.id.ceNoData);
        mineNoData = findViewById(R.id.mineNoData);
        ppNoData = findViewById(R.id.ppNoData);
        ttNoData = findViewById(R.id.ttNoData);
        mseNoData = findViewById(R.id.mseNoData);
        aeNoData = findViewById(R.id.aeNoData);
        aneNoData = findViewById(R.id.aneNoData);
        ecoNoData = findViewById(R.id.ecoNoData);
        cermNoData = findViewById(R.id.cermNoData);
        pieNoData = findViewById(R.id.pieNoData);
        oebNoData = findViewById(R.id.oebNoData);
        cheNoData = findViewById(R.id.cheNoData);
        mteNoData = findViewById(R.id.mteNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        chmDepartment();
        csDepartment();
        meDepartment();
        phyDepartment();
        ephyDepartment();
        bseDepartment();
        eeDepartment();
        ceDepartment();
        mineDepartment();
        ppDepartment();
        ttDepartment();
        mseDepartment();
        aeDepartment();
        aneDepartment();
        ecoDepartment();
        cermDepartment();
        pieDepartment();
        oebDepartment();
        cheDepartment();
        mteDepartment();



        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this, AddTeachers.class));

            }
        });
    }

    private void csDepartment(){
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 =new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this,"Computer Science");
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void chmDepartment(){
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 =new ArrayList<>();
                if(!dataSnapshot.exists()){
                    chmNoData.setVisibility(View.VISIBLE);
                    chmDepartment.setVisibility(View.GONE);
                }else{
                    chmNoData.setVisibility(View.GONE);
                    chmDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    chmDepartment.setHasFixedSize(true);
                    chmDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this,"Chemistry");
                    chmDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void meDepartment() {
        dbRef = reference.child("Mechanical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list3= new ArrayList<>();
                if(!datasnapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }else {

                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3,UpdateFaculty.this,"Mechanical Engineering");
                    meDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void phyDepartment() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list4= new ArrayList<>();
                if(!datasnapshot.exists()){
                    phyNoData.setVisibility(View.VISIBLE);
                    phyDepartment.setVisibility(View.GONE);
                }else {

                    phyNoData.setVisibility(View.GONE);
                    phyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    phyDepartment.setHasFixedSize(true);
                    phyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4,UpdateFaculty.this,"Physics");
                    phyDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void ephyDepartment() {
        dbRef = reference.child("Engineering Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list5= new ArrayList<>();
                if(!datasnapshot.exists()){
                    ephyNoData.setVisibility(View.VISIBLE);
                    ephyDepartment.setVisibility(View.GONE);
                }else {

                    ephyNoData.setVisibility(View.GONE);
                    ephyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    ephyDepartment.setHasFixedSize(true);
                    ephyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5,UpdateFaculty.this,"Engineering Physics");
                    ephyDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void bseDepartment() {
        dbRef = reference.child("BioTechnology Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list6= new ArrayList<>();
                if(!datasnapshot.exists()){
                    bseNoData.setVisibility(View.VISIBLE);
                    bseDepartment.setVisibility(View.GONE);
                }else {

                    bseNoData.setVisibility(View.GONE);
                    bseDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    bseDepartment.setHasFixedSize(true);
                    bseDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list6,UpdateFaculty.this,"BioTechnology Engineering");
                    bseDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void eeDepartment() {
        dbRef = reference.child("Electrical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list7= new ArrayList<>();
                if(!datasnapshot.exists()){
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                }else {

                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    eeDepartment.setHasFixedSize(true);
                    eeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list7,UpdateFaculty.this,"Electrical Engineering");
                    eeDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void ceDepartment() {
        dbRef = reference.child("Civil Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list8= new ArrayList<>();
                if(!datasnapshot.exists()){
                    ceNoData.setVisibility(View.VISIBLE);
                    ceDepartment.setVisibility(View.GONE);
                }else {

                    ceNoData.setVisibility(View.GONE);
                    ceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    ceDepartment.setHasFixedSize(true);
                    ceDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list8,UpdateFaculty.this,"Civil Engineering");
                    ceDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void mineDepartment() {
        dbRef = reference.child("Mining Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list9= new ArrayList<>();
                if(!datasnapshot.exists()){
                    mineNoData.setVisibility(View.VISIBLE);
                    mineDepartment.setVisibility(View.GONE);
                }else {

                    mineNoData.setVisibility(View.GONE);
                    mineDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    mineDepartment.setHasFixedSize(true);
                    mineDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list9,UpdateFaculty.this,"Mining Engineering");
                    mineDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void ppDepartment() {
        dbRef = reference.child("Printing and Packaging");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list10= new ArrayList<>();
                if(!datasnapshot.exists()){
                    ppNoData.setVisibility(View.VISIBLE);
                    ppDepartment.setVisibility(View.GONE);
                }else {

                    ppNoData.setVisibility(View.GONE);
                    ppDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list10.add(data);
                    }
                    ppDepartment.setHasFixedSize(true);
                    ppDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list10,UpdateFaculty.this, "Printing and Packaging");
                    ppDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ttDepartment() {
        dbRef = reference.child("Textile Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list11= new ArrayList<>();
                if(!datasnapshot.exists()){
                    ttNoData.setVisibility(View.VISIBLE);
                    ttDepartment.setVisibility(View.GONE);
                }else {

                    ttNoData.setVisibility(View.GONE);
                    ttDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list11.add(data);
                    }
                    ttDepartment.setHasFixedSize(true);
                    ttDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list11,UpdateFaculty.this,"Textile Technology");
                    ttDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void mseDepartment() {
        dbRef = reference.child("Mathametics and Scientific Computing");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list12= new ArrayList<>();
                if(!datasnapshot.exists()){
                    mseNoData.setVisibility(View.VISIBLE);
                    mseDepartment.setVisibility(View.GONE);
                }else {

                    mseNoData.setVisibility(View.GONE);
                    mseDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list12.add(data);
                    }
                    mseDepartment.setHasFixedSize(true);
                    mseDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list12,UpdateFaculty.this,"Mathametics and Scientific Computing");
                    mseDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void aeDepartment() {
        dbRef = reference.child("Aerospace Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list13= new ArrayList<>();
                if(!datasnapshot.exists()){
                    aeNoData.setVisibility(View.VISIBLE);
                    aeDepartment.setVisibility(View.GONE);
                }else {

                    aeNoData.setVisibility(View.GONE);
                    aeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list13.add(data);
                    }
                    aeDepartment.setHasFixedSize(true);
                    aeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list13,UpdateFaculty.this,"Aerospace Engineering");
                    aeDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void aneDepartment() {
        dbRef = reference.child("Aeronautical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list14= new ArrayList<>();
                if(!datasnapshot.exists()){
                    aneNoData.setVisibility(View.VISIBLE);
                    aneDepartment.setVisibility(View.GONE);
                }else {

                    aneNoData.setVisibility(View.GONE);
                    aneDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list14.add(data);
                    }
                    aneDepartment.setHasFixedSize(true);
                    aneDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list14,UpdateFaculty.this,"Aeronautical Engineering");
                    aneDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void ecoDepartment() {
        dbRef = reference.child("Economics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list15= new ArrayList<>();
                if(!datasnapshot.exists()){
                    ecoNoData.setVisibility(View.VISIBLE);
                    ecoDepartment.setVisibility(View.GONE);
                }else {

                    ecoNoData.setVisibility(View.GONE);
                    ecoDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list15.add(data);
                    }
                    ecoDepartment.setHasFixedSize(true);
                    ecoDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list15,UpdateFaculty.this,"Economics");
                    ecoDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void cermDepartment() {
        dbRef = reference.child("Ceramic Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list16= new ArrayList<>();
                if(!datasnapshot.exists()){
                    cermNoData.setVisibility(View.VISIBLE);
                    cermDepartment.setVisibility(View.GONE);
                }else {

                    cermNoData.setVisibility(View.GONE);
                    cermDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list16.add(data);
                    }
                    cermDepartment.setHasFixedSize(true);
                    cermDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list16,UpdateFaculty.this,"Ceramic Engineering");
                    cermDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void pieDepartment() {
        dbRef = reference.child("Production and Industrial Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list17= new ArrayList<>();
                if(!datasnapshot.exists()){
                    pieNoData.setVisibility(View.VISIBLE);
                    pieDepartment.setVisibility(View.GONE);
                }else {

                    pieNoData.setVisibility(View.GONE);
                    pieDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list17.add(data);
                    }
                    pieDepartment.setHasFixedSize(true);
                    pieDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list17,UpdateFaculty.this,"Production and Industrial Engineering");
                    pieDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void oebDepartment() {
        dbRef = reference.child("Others Engineering Branches");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list18= new ArrayList<>();
                if(!datasnapshot.exists()){
                    oebNoData.setVisibility(View.VISIBLE);
                    oebDepartment.setVisibility(View.GONE);
                }else {

                    oebNoData.setVisibility(View.GONE);
                    oebDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list18.add(data);
                    }
                    oebDepartment.setHasFixedSize(true);
                    oebDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list18,UpdateFaculty.this,"Others Engineering Branches");
                    oebDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void cheDepartment() {
        dbRef = reference.child("Chemical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list19= new ArrayList<>();
                if(!datasnapshot.exists()){
                    cheNoData.setVisibility(View.VISIBLE);
                    cheDepartment.setVisibility(View.GONE);
                }else {

                    cheNoData.setVisibility(View.GONE);
                    cheDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list19.add(data);
                    }
                    cheDepartment.setHasFixedSize(true);
                    cheDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list19,UpdateFaculty.this,"Chemical Engineering");
                    cheDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void mteDepartment() {
        dbRef = reference.child("Metallurgical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list20= new ArrayList<>();
                if(!datasnapshot.exists()){
                    mteNoData.setVisibility(View.VISIBLE);
                    mteDepartment.setVisibility(View.GONE);
                }else {

                    mteNoData.setVisibility(View.GONE);
                    mteDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list20.add(data);
                    }
                    mteDepartment.setHasFixedSize(true);
                    mteDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list20,UpdateFaculty.this,"Metallurgical Engineering");
                    mteDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}