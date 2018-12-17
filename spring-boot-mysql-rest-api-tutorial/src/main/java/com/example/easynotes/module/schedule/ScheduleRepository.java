package com.example.easynotes.module.schedule;

import com.example.easynotes.module.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
//@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080","file://*"})
@CrossOrigin
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
