package com.employee.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Class representing a the Course Details For Every Department")
public class CourseDTO {

    @ApiModelProperty(notes = "Unique identifier of the Course")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;

    @NotNull(message="Course Name Can't be Empty.")
    @Size(min=5, max = 100)
    @ApiModelProperty(notes = "Course Name Required", required = true)
    private String courseName;


}
