package yougo.entity;

import java.io.Serializable;

public class BaseResult<T> implements Serializable{
	
	private String code;
	
	private Object model;
	
	public BaseResult(){
	}
	
	public BaseResult(String code){
		this.code = code;
	}
	
	public BaseResult(String code, T model){
		this.code = code;
		this.model = model;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}
	
}
