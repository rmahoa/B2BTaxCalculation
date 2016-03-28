package hml.com;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {
		"loginId",
		"password",
			
})

public class LoginType {
	
	
	protected String loginId;
	 
    protected String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
