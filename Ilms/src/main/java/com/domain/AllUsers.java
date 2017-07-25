package com.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllUsers {
	
private ClientBean clientbean[];
@JsonProperty("ClientBean")
public ClientBean[] getClientbean() {
	return clientbean;
}

public void setClientbean(ClientBean[] clientbean) {
	this.clientbean = clientbean;
}

}
