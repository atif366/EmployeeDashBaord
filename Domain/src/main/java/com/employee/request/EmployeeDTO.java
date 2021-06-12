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
@ApiModel(description = "Class representing a the Employee Details")
public class EmployeeDTO {

    @ApiModelProperty(notes = "Unique identifier of the Employee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;

    @NotNull(message="Employee Name Can't be Empty.")
    @Size(min=5, max = 50)
    @ApiModelProperty(notes = "Employee Name Required To Keep For Department", required = true)
    private String employeeName;

    @NotNull(message="Department Id Shouldn't be empty")
    @ApiModelProperty(notes = "Department Id To Make Relationship WIth Employee", required = true)
    private Long departmentId;
}
