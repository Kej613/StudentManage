//package com.example.Student.Repository;
//
//import com.example.Student.domain.Student;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class MemoryStudentRepository implements StudentRepository {
//    private static Map<Long,Student> store = new HashMap<>();
//    private static long sequence = 0L; //sequence는 0,1,2 이렇게 키값을 생성
//
//    @Override
//    public Student save(Student student) { //학생을 저장
//        student.setId(++sequence);
//        store.put(student.getId(),student);
//        return student;
//    }
//
//    @Override
//    public Optional<Student> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Student> findByName(String name) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Student> findAll() {
//        return null;
//    }
//}
