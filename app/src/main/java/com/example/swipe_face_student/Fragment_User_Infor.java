package com.example.swipe_face_student;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.swipe_face_student.Model.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;


public class Fragment_User_Infor extends Fragment implements FragmentBackHandler {

    private final String TAG = "Fragment_User_Infor";
    private FirebaseFirestore db;
    private TextView tvStudentName;
    private TextView tvStudent_Id;
    private TextView tvStudentDepartment;
    private TextView tvStudentEmail;
    private TextView tvStudentSchool;
    private String student_Id;
    private String studentId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__user__infor, container, false);

    }

    @Override
    public boolean onBackPressed()  {
        return BackHandlerHelper.handleBackPress(this);
    }//fragment 返回鍵

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //init db
        db = FirebaseFirestore.getInstance();

        //抓現在使用者
//        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
//        currentFirebaseUser.getEmail(); String[] currentUserIdToStringList = currentFirebaseUser.getEmail().split("@");
//        student_Id = currentUserIdToStringList[0];
        student_Id = "405401217";
        //inti xml
        tvStudent_Id = view.findViewById(R.id.tvStudent_Id);
        tvStudentDepartment = view.findViewById(R.id.tvStudentDepartment);
        tvStudentEmail = view.findViewById(R.id.tvStudentEmail);
        tvStudentSchool = view.findViewById(R.id.tvStudentSchool);
        tvStudentName = view.findViewById(R.id.tvStudentName);

        //db query
        if(student_Id!=null){
            setInfo();
        }


    }

    private void setInfo() {
        db.collection("Student").whereEqualTo("student_id", student_Id).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {

                    Log.d(TAG, "Error :" + e.getMessage());
                }

                for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {

                    if (doc.getType() == DocumentChange.Type.ADDED) {
                        studentId = doc.getDocument().getId();
                        if(studentId!=null){
                            DocumentReference docRef = db.collection("Student").document(studentId);
                            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot document = task.getResult();
                                        if (document.exists()) {
                                            Student student = document.toObject(Student.class);
                                            tvStudent_Id.setText(student.getStudent_id());
                                            tvStudentDepartment.setText(student.getStudent_department());
                                            tvStudentEmail.setText(student.getStudent_email());
                                            tvStudentName.setText(student.getStudent_name());
                                            tvStudentSchool.setText(student.getStudent_school());

                                        } else {
                                            Log.d(TAG, "No such document");
                                        }
                                    } else {
                                        Log.d(TAG, "get failed with ", task.getException());
                                    }
                                }
                            });
                        }
                    }
                }

            }
        });
    }
}
