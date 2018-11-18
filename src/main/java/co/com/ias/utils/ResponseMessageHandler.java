package co.com.ias.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResponseMessageHandler {
	
	@Value("${response.create.message.success}")
	private String responseCreateSuccessMessage;
	
	@Value("${response.create.message.error}")
	private String responseCreateErrorMessage;
	
	@Value("${response.update.message.success}")
	private String responseUpdateSuccessMessage;
	
	@Value("${response.update.message.error}")
	private String responseUpdateErrorMessage;
	
	@Value("${response.delete.message.success}")
	private String responseDeleteSuccessMessage;
	
	@Value("${response.delete.message.error}")
	private String responseDeleteErrorMessage;
	
	@Value("${response.get.message.error}")
	private String responseGetErrorMessage;
	
	@Value("${response.status.success}")
	private int statusSuccess;
	
	@Value("${response.status.error}")
	private int statusError;
	
	public ResponseMessage showCreateSuccessMessage() {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(statusSuccess);
		responseMessage.setMessage(responseCreateSuccessMessage);
		responseMessage.setStatus(true);
		return responseMessage;
	}
	
	public ResponseMessage showCreateErrorMessage() {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(statusError);
		responseMessage.setMessage(responseCreateErrorMessage);
		responseMessage.setStatus(false);
		return responseMessage;
	}
	
	public ResponseMessage showUpdateSuccessMessage() {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(statusSuccess);
		responseMessage.setMessage(responseUpdateSuccessMessage);
		responseMessage.setStatus(true);
		return responseMessage;
	}
	
	public ResponseMessage showUpdateErrorMessage() {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(statusError);
		responseMessage.setMessage(responseUpdateErrorMessage);
		responseMessage.setStatus(false);
		return responseMessage;
	}
	
	public ResponseMessage showDeleteSuccessMessage() {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(statusSuccess);
		responseMessage.setMessage(responseDeleteSuccessMessage);
		responseMessage.setStatus(true);
		return responseMessage;
	}
	
	public ResponseMessage showDeleteErrorMessage() {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(statusError);
		responseMessage.setMessage(responseDeleteErrorMessage);
		responseMessage.setStatus(false);
		return responseMessage;
	}
	
	public ResponseMessage showNotFoundMessage() {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(statusError);
		responseMessage.setMessage(responseGetErrorMessage);
		responseMessage.setStatus(false);
		return responseMessage;
	}
}
