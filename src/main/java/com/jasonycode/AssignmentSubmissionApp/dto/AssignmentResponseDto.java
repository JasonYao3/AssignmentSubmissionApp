package com.jasonycode.AssignmentSubmissionApp.dto;

import com.jasonycode.AssignmentSubmissionApp.entity.Assignment;
import com.jasonycode.AssignmentSubmissionApp.enums.AssignmentEnum;

public class AssignmentResponseDto {

    private Assignment assignment;
    private AssignmentEnum[] assignmentEnums = AssignmentEnum.values();

    public AssignmentResponseDto(Assignment assignment) {
        super();
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public AssignmentEnum[] getAssignmentEnums() {
        return assignmentEnums;
    }

}
