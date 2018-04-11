package com.pxy.tutor.main.mine.service.imp;


import com.pxy.pangjiao.compiler.mpv.annotation.Service;
import com.pxy.tutor.main.mine.adapter.protocol.getstudent.GetStudentRequest;
import com.pxy.tutor.main.mine.adapter.protocol.getstudent.GetStudentResponse;
import com.pxy.tutor.main.mine.adapter.protocol.getstudents.GetStudentsRequest;
import com.pxy.tutor.main.mine.adapter.protocol.getstudents.GetStudentsResponse;
import com.pxy.tutor.main.mine.adapter.protocol.gettutor.GetTutorRequest;
import com.pxy.tutor.main.mine.adapter.protocol.gettutor.GetTutorResponse;
import com.pxy.tutor.main.mine.adapter.protocol.gettutors.GetTutorsRequest;
import com.pxy.tutor.main.mine.adapter.protocol.gettutors.GetTutorsResponse;
import com.pxy.tutor.main.mine.adapter.protocol.studentlogin.StudentLoginRequest;
import com.pxy.tutor.main.mine.adapter.protocol.studentlogin.StudentLoginResponse;
import com.pxy.tutor.main.mine.adapter.protocol.studentregister.StudentRegisterRequest;
import com.pxy.tutor.main.mine.adapter.protocol.studentregister.StudentRegisterResponse;
import com.pxy.tutor.main.mine.adapter.protocol.tutorlogin.TutorRegisterRequest;
import com.pxy.tutor.main.mine.adapter.protocol.tutorlogin.TutorRegisterResponse;
import com.pxy.tutor.main.mine.adapter.protocol.tutorregister.TutorLoginRequest;
import com.pxy.tutor.main.mine.adapter.protocol.tutorregister.TutorLoginResponse;
import com.pxy.tutor.main.mine.service.IAppService;


/**
 * Created by Administrator on 2018/3/15.
 */

@Service
public class AppService implements IAppService {

    @Override
    public GetTutorsResponse getTutors(String city, int page) {
        GetTutorsRequest request = new GetTutorsRequest();
        request.setCity(city);
        request.setPage(page);
        return request.execute();
    }

    @Override
    public GetStudentsResponse getStudents(String city, int page) {
        GetStudentsRequest request = new GetStudentsRequest();
        request.setCity(city);
        request.setPage(page);
        return request.execute();
    }

    @Override
    public StudentRegisterResponse studentRegister(String no, String pwd, String name, String area) {
        StudentRegisterRequest request = new StudentRegisterRequest();
        request.setStudentNO(no);
        request.setPwd(pwd);
        request.setName(name);
        request.setAreaTeach(area);
        return request.execute();
    }

    @Override
    public StudentLoginResponse studentLogin(String no, String pwd) {
        StudentLoginRequest request = new StudentLoginRequest();
        request.setNo(no);
        request.setPwd(pwd);
        return request.execute();
    }

    @Override
    public TutorLoginResponse tutorLogin(String no, String pwd) {
        TutorLoginRequest request = new TutorLoginRequest();
        request.setNo(no);
        request.setPwd(pwd);
        return request.execute();
    }

    @Override
    public TutorRegisterResponse tutorRegister(String no, String pwd, String name, String area) {
        TutorRegisterRequest request = new TutorRegisterRequest();
        request.setTutorNO(no);
        request.setPwd(pwd);
        request.setName(name);
        request.setAddress(area);
        return request.execute();
    }

    @Override
    public GetStudentResponse getStudent(String no) {
        GetStudentRequest request=new GetStudentRequest();
        request.setNo(no);
        return request.execute();
    }

    @Override
    public GetTutorResponse getTutor(String no) {
        GetTutorRequest request=new GetTutorRequest();
        request.setNo(no);
        return request.execute();
    }
}
