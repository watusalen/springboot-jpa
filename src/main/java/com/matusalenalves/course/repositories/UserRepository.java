package com.matusalenalves.course.repositories;

import com.matusalenalves.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}