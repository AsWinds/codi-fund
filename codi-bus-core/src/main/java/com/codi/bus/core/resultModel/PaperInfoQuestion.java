package com.codi.bus.core.resultModel;

import com.codi.base.domain.BaseDomain;
import lombok.ToString;

import java.util.List;

public class PaperInfoQuestion extends BaseDomain {

	private String question_no;
	private String question_content;
	private String answer_object;
	private String order_no;
	private List<QuestionSection> sections;


    public String getQuestion_no() {
        return question_no;
    }


	public void setQuestion_no(String question_no) {
		this.question_no = question_no;
	}


	public String getQuestion_content() {
		return question_content;
	}


	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}


	public String getAnswer_object() {
		return answer_object;
	}


	public void setAnswer_object(String answer_object) {
		this.answer_object = answer_object;
	}


	public String getOrder_no() {
		return order_no;
	}


	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}


	public List<QuestionSection> getSections() {
		return sections;
	}


	public void setSections(List<QuestionSection> sections) {
		this.sections = sections;
	}


    @ToString
    public class QuestionSection {

        private String option_content;
        private String option_no;
        private String option_score;
        private String order_no;

        public String getOption_content() {
            return option_content;
        }

        public void setOption_content(String option_content) {
            this.option_content = option_content;
        }

        public String getOption_no() {
            return option_no;
        }

        public void setOption_no(String option_no) {
            this.option_no = option_no;
        }

        public String getOption_score() {
            return option_score;
        }

        public void setOption_score(String option_score) {
            this.option_score = option_score;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }
    }

}
