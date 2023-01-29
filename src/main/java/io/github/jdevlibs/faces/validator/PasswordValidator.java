/*  ---------------------------------------------------------------------------
 *  * Copyright 2023 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  ---------------------------------------------------------------------------
 */

package io.github.jdevlibs.faces.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.jdevlibs.faces.JSFValidators;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

/**
* @author supot.jdev
* @version 1.0
*/

@FacesValidator("jsf.custom.passwordValidator")
public class PasswordValidator implements Validator<String> {
	/**
	 * Password must contain at least one digit [0-9].
	 * Password must contain at least one lowercase Latin character [a-z].
	 * Password must contain at least one uppercase Latin character [A-Z].
	 * Password must contain a length of at least 8 characters and a maximum of 50 characters.
	 */
	private static final String ERR_MSG = "Password must contain at least one[[0-9] and [a-z] and [A-Z]  length of at least 8 characters and a maximum of 50 characters";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,50}$";
    private static final Pattern PATTERN = Pattern.compile(PASSWORD_PATTERN);
    
	@Override
	public void validate(FacesContext context, UIComponent comp, String value) throws ValidatorException {
		if (JSFValidators.isEmpty(value)) {
			return;
		}

		UIInput input = (UIInput) comp;
		String validateMsg = input.getValidatorMessage();
		
		boolean error = value.length() < 8;
		if (!error) {
			Matcher matcher = PATTERN.matcher(value);
			if (!matcher.matches()) {
				error = true;
			}
		}
		
		if (error) {
			input.setValid(false);
			FacesMessage message = new FacesMessage(JSFValidators.isNotEmpty(validateMsg) ?  validateMsg : ERR_MSG);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

}