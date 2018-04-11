package com.pxy.tutor.main.mine.service;


import com.pxy.tutor.main.mine.adapter.protocol.getstudent.GetStudentResponse;
import com.pxy.tutor.main.mine.adapter.protocol.getstudents.GetStudentsResponse;
import com.pxy.tutor.main.mine.adapter.protocol.gettutor.GetTutorResponse;
import com.pxy.tutor.main.mine.adapter.protocol.gettutors.GetTutorsResponse;
import com.pxy.tutor.main.mine.adapter.protocol.studentlogin.StudentLoginResponse;
import com.pxy.tutor.main.mine.adapter.protocol.studentregister.StudentRegisterResponse;
import com.pxy.tutor.main.mine.adapter.protocol.tutorlogin.TutorRegisterResponse;
import com.pxy.tutor.main.mine.adapter.protocol.tutorregister.TutorLoginResponse;

/**
 * Created by Administrator on 2018/3/15.
 */

public interface IAppService {

    GetTutorsResponse getTutors(String city, int page);

    GetStudentsResponse getStudents(String city, int page);

    StudentRegisterResponse studentRegister(String no, String pwd, String name, String area);

    StudentLoginResponse studentLogin(String no, String pwd);

    TutorLoginResponse tutorLogin(String no, String pwd);

    TutorRegisterResponse tutorRegister(String no, String pwd, String name, String area);
    GetStudentResponse getStudent(String no);

    GetTutorResponse getTutor(String no);
}
