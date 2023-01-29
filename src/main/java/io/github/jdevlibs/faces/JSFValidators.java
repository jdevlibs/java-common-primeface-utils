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

package io.github.jdevlibs.faces;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
* @author supot.jdev
* @version 1.0
*/
public final class JSFValidators {

	private static final String EMAIL_NORMAL 	= "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
	private static final String EMAIL_RFC5322 	= "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	private static final String EMAIL_UNICODE 	= "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
	private static final Pattern PATTERN_NORMAL;
	private static final Pattern PATTERN_RFC5322;
	private static final Pattern PATTERN_UNICODE;

	static {
		PATTERN_NORMAL = Pattern.compile(EMAIL_NORMAL);
		PATTERN_RFC5322 = Pattern.compile(EMAIL_RFC5322);
		PATTERN_UNICODE = Pattern.compile(EMAIL_UNICODE);
	}

	private JSFValidators() {

	}

	public static boolean isNull(Object value) {
		return (null == value);
	}

	public static boolean isNotNull(Object value) {
		return !isNull(value);
	}

	public static boolean isEmpty(Object value) {
		if (isNull(value)) {
			return true;
		}

		if (value instanceof String) {
			return ((String) value).trim().isEmpty();
		} else if (value instanceof Optional<?>) {
			Optional<?> op = (Optional<?>) value;
			return !op.isPresent();
		} else if (value instanceof Collection<?>) {
			return ((Collection<?>) value).isEmpty();
		} else if (value instanceof Iterator<?>) {
			return !((Iterator<?>) value).hasNext();
		} else if (value instanceof Map<?, ?>) {
			return ((Map<?, ?>) value).isEmpty();
		} else if (value.getClass().isArray()) {
			return Array.getLength(value) == 0;
		}
		return value.toString().isEmpty();
	}

	public static boolean isNotEmpty(Object value) {
		return !isEmpty(value);
	}

	/**
	 * Validate input value is email format pattern
	 * @see JSFValidators#EMAIL_NORMAL
	 * @param email The input value
	 * @return true when email is valid format
	 */
	public static boolean isEmail(final String email) {
		if (isEmpty(email)) {
			return false;
		}

		return PATTERN_NORMAL.matcher(email).matches();
	}

	/**
	 * Validate input value is not email format pattern
	 * @see JSFValidators#EMAIL_NORMAL
	 * @param email The input value
	 * @return true when email is invalid format
	 */
	public static boolean isNotEmail(final String email) {
		return !isEmail(email);
	}

	/**
	 * Validate input value is email format pattern
	 * @see <a href="https://www.rfc-editor.org/info/rfc5322">RFC 5322 standards</a>
	 * @see JSFValidators#EMAIL_RFC5322
	 * @param email The input value
	 * @return true when email is valid format
	 */
	public static boolean isEmailRfc523(final String email) {
		if (isEmpty(email)) {
			return false;
		}

		return PATTERN_RFC5322.matcher(email).matches();
	}

	/**
	 * Validate input value is not email format pattern
	 * @see <a href="https://www.rfc-editor.org/info/rfc5322">RFC 5322 standards</a>
	 * @see JSFValidators#EMAIL_RFC5322
	 * @param email The input value
	 * @return true when email is invalid format
	 */
	public static boolean isNotEmailRfc523(final String email) {
		return !isEmailRfc523(email);
	}

	/**
	 * Validate input value is email format pattern
	 * @see JSFValidators#EMAIL_UNICODE
	 * @param email The input value
	 * @return true when email is valid format
	 */
	public static boolean isEmailUnicode(final String email) {
		if (isEmpty(email)) {
			return false;
		}

		return PATTERN_UNICODE.matcher(email).matches();
	}

	/**
	 * Validate input value is not email format pattern
	 * @see JSFValidators#EMAIL_UNICODE
	 * @param email The input value
	 * @return true when email is invalid format
	 */
	public static boolean isNotEmailUnicode(final String email) {
		return !isEmailUnicode(email);
	}

	/**
	 * Validate that some objects are null.
	 * @param values The multiple values to validate
	 * @return true when Validate one of the values was null
	 */
	public static boolean isNullOne(Object... values) {
		if (isEmpty(values)) {
			return true;
		}

		for (Object obj : values) {
			if (isNull(obj)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Validate that all the objects are null.
	 * @param values The multiple values to validate
	 * @return true when Validate all value was null
	 */
	public static boolean isNullAll(Object... values) {
		if (isEmpty(values)) {
			return true;
		}

		for (Object obj : values) {
			if (isNotNull(obj)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Validate that all the objects are not null.
	 * @param values The multiple values to validate
	 * @return true when Validate all value was not null
	 */
	public static boolean isNotNullAll(Object... values) {
		return !isNullOne(values);
	}

	/**
	 * Validate that some objects are empty [null also count to empty].
	 * @param values The multiple values to validate
	 * @return true when Validate one of the values was empty
	 */
	public static boolean isEmptyOne(Object... values) {
		if (isEmpty(values)) {
			return true;
		}

		for (Object obj : values) {
			if (isEmpty(obj)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Validate that all the objects are empty [null also count to empty].
	 * @param values The multiple values to validate
	 * @return true when Validate all value was empty
	 */
	public static boolean isEmptyAll(Object... values) {
		if (isEmpty(values)) {
			return true;
		}

		for (Object obj : values) {
			if (isNotEmpty(obj)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Validate that all the objects are not empty [null also count to empty].
	 * @param values The multiple values to validate
	 * @return true when Validate all value was not empty
	 */
	public static boolean isNotEmptyAll(Object... values) {
		return !isEmptyOne(values);
	}
}
