package com.jasonycode.AssignmentSubmissionApp.service;

import com.jasonycode.AssignmentSubmissionApp.dto.CommentDto;
import com.jasonycode.AssignmentSubmissionApp.entity.Assignment;
import com.jasonycode.AssignmentSubmissionApp.entity.Comment;
import com.jasonycode.AssignmentSubmissionApp.entity.User;
import com.jasonycode.AssignmentSubmissionApp.repositiory.AssignmentRepository;
import com.jasonycode.AssignmentSubmissionApp.repositiory.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private AssignmentRepository assignmentRepo;

    public Comment save(CommentDto commentDto, User user) {
        Comment comment = new Comment();
        Assignment assignment = assignmentRepo.getReferenceById(commentDto.getAssignmentId());

        comment.setId(commentDto.getId());
        comment.setAssignment(assignment);
        comment.setText(commentDto.getText());
        comment.setCreatedBy(user);
        if (comment.getId() == null) {
            comment.setCreatedDate(LocalDateTime.now());
        }
        return commentRepo.save(comment);
    }

    public Set<Comment> getCommentsByAssignmentId(Long assignmentId) {
        Set<Comment> comments = commentRepo.findByAssignmentId(assignmentId);

        return comments;
    }
}
