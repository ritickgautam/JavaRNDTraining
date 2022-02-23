<<<<<<< HEAD
package com.ems.exception;

public class ErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}



}
=======
package com.ems.exception;

public class ErrorResponse {
	private int status;
	private String message;
	private long timeStamp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}



}
>>>>>>> ca98932d9306c6218e14d6b42efd1c68119703d8
