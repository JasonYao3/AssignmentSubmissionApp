package com.jasonycode.AssignmentSubmissionApp.web;

import com.jasonycode.AssignmentSubmissionApp.dto.CommentDto;
import com.jasonycode.AssignmentSubmissionApp.entity.Comment;
import com.jasonycode.AssignmentSubmissionApp.entity.User;
import com.jasonycode.AssignmentSubmissionApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal User user) {
        Comment comment = commentService.save(commentDto, user);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("{commentId}")
    public ResponseEntity<Comment> updateComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal User user) {
        Comment comment = commentService.save(commentDto, user);
        return ResponseEntity.ok(comment);
    }
    @GetMapping("")
    public ResponseEntity<Set<Comment>> getCommentsByAssignment(@RequestParam Long assignmentId) {
        Set<Comment> comments = commentService.getCommentsByAssignmentId(assignmentId);
        return ResponseEntity.ok(comments);
    }
}
