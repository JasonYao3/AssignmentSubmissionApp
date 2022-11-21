package com.jasonycode.AssignmentSubmissionApp.repositiory;

import com.jasonycode.AssignmentSubmissionApp.entity.Assignment;
import com.jasonycode.AssignmentSubmissionApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AssignmentRepository  extends JpaRepository<Assignment, Long> {

    Set<Assignment> findByUser(User user);
}
