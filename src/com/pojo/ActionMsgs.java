package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class ActionMsgs {
List<ActionMsg> errors = new ArrayList<ActionMsg>();

public List<ActionMsg> getErrors() {
	return errors;
}

public void setErrors(ActionMsg error) {
	errors.add(error);
}
}
