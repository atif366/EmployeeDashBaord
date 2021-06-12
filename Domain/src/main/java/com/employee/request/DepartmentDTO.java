package com.employee.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Class representing a the Department and Their Courses Details")
public class DepartmentDTO {

    @ApiModelProperty(notes = "Unique identifier of the Department")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;

    @NotNull(message="Department Name Can't be Empty.")
    @Size(min=5, max = 50)
    @ApiModelProperty(notes = "Department Name Required To Keep For List Of Courses", required = true)
    private String departmentName;

    @ApiModelProperty(notes = "List Of Course assigned to department")
    @Valid
    @NotNull(groups = { CourseDTO.class })
    private List<CourseDTO> course;
}
