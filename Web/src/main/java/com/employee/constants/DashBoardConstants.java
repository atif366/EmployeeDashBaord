package com.employee.constants;

public interface DashBoardConstants {
	
	String ID_NOT_EXIST="Id does not exist";
	String CONFIG_URL_SUCCSS = "Config URL Updated Successfully...";
	String CONFIG_URL_FAIL = "Config URL not Updated Successfully...";
	String NUM_VERIFY_OTP_GEN = "Mobile Number Verfied Successfully And Generated OTP";
	String NUM_OTP_VERIFY="Requestd Otp Is Invalid";
	String NUM_VERIFY_FAIL = "Mobile Number Not Registered With Us";
	String NUM_EXISTS = "Mobile Number Already Exist";
	String NUM_REGISTERED="Mobile Number Already Registered";
	String NUM_NOT_REGISTERED="This Mobile Number is not registered...";
	String DATA_NOT_FOUND="No data found in Database";
	String INVALID_CREDENTIALS="Invalid MobileNumber Or Password";
	String INVALID_MOBILE_NUM="Mobile Number Is Not Valid";
	int OTP_EXPIRATION_TIME = 120; // 120 sec/60 = 2 minute 
	String OPT_EXPIRED = "This OTP is Expired!";
	String OTP_VERIFY_SUCCESS = "OTP verified Successfully!";
	String OTP_GEN_SUCCESS="OTP Generated Successfully";
	String USER_DELETED="User is Deleted Successfully";
	String REGISTRATION_USER="Your registration has been submitted successfully.Please wait for approve by admin";
	String ACCOUNT_LOCKED="Your Account Is Locked, Please Contact Admin";
	String ACCOUNT_DEACTIVATED="Your Account Is De-Activated, Please Contact Admin";
	String SENDERID_STATUS_APPROVED="APPROVED";
	
	String USER_NOT_ACTIVATED="N";
	String USER_ACTIVATED="A";
	String REQUESTED_SUCCESSFULLY = "Requested Successfully";
	
	 String ALREADY_EXIST = "Already Exist";
	 String PENDING = "PENDING";

	 int OK = 200;
	 int BAD_REQUEST = 400;
	 int INTERNAL_SERVER_ERROR = 500;
	 int CREATED = 201;
	 int NOT_FOUND = 404;
	 int OTP_EXPIRED = 205;
	 
	 String USER_PERMISSIONS="User PermissionList is Updated Successfully.";
	
}

