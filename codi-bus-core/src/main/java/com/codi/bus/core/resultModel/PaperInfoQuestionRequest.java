package com.codi.bus.core.resultModel;

public class PaperInfoQuestionRequest {
	private String sort_direction;
	private String answer_object;
	private String paper_client_type;
	
	public PaperInfoQuestionRequest(String sort_direction, String answer_object, String paper_client_type) {
		this.sort_direction = sort_direction;
		this.answer_object = answer_object;
		this.paper_client_type = paper_client_type;
	}
	
	public PaperInfoQuestionRequest() {
		
	}
	
	public String getSort_direction() {
		return sort_direction;
	}
	public void setSort_direction(String sort_direction) {
		this.sort_direction = sort_direction;
	}
	public String getAnswer_object() {
		return answer_object;
	}
	public void setAnswer_object(String answer_object) {
		this.answer_object = answer_object;
	}
	public String getPaper_client_type() {
		return paper_client_type;
	}
	public void setPaper_client_type(String paper_client_type) {
		this.paper_client_type = paper_client_type;
	}
}
