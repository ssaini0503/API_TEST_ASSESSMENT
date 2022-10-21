package com.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "data", "message" })
public class TC1_Response_GetEMP {

	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private List<Datum> data = null;
	@JsonProperty("message")
	private String message;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("data")
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "employee_name", "employee_salary", "employee_age", "profile_image" })

class Datum {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("employee_name")
	private String employeeName;
	@JsonProperty("employee_salary")
	private Integer employeeSalary;
	@JsonProperty("employee_age")
	private Integer employeeAge;
	@JsonProperty("profile_image")
	private String profileImage;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("employee_name")
	public String getEmployeeName() {
		return employeeName;
	}

	@JsonProperty("employee_name")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@JsonProperty("employee_salary")
	public Integer getEmployeeSalary() {
		return employeeSalary;
	}

	@JsonProperty("employee_salary")
	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	@JsonProperty("employee_age")
	public Integer getEmployeeAge() {
		return employeeAge;
	}

	@JsonProperty("employee_age")
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	@JsonProperty("profile_image")
	public String getProfileImage() {
		return profileImage;
	}

	@JsonProperty("profile_image")
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
