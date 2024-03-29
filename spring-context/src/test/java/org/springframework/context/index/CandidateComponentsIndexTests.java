/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.index;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Tests for {@link CandidateComponentsIndex}.
 *
 * @author Stephane Nicoll
 */
public class CandidateComponentsIndexTests {

	@Test
	public void getCandidateTypes() {
		CandidateComponentsIndex index = new CandidateComponentsIndex(
				Collections.singletonList(createSampleProperties()));
		Set<String> actual = index.getCandidateTypes("com.example.com.zkq.service", "service");
		assertThat(actual, containsInAnyOrder("com.example.com.zkq.service.One",
				"com.example.com.zkq.service.sub.Two", "com.example.com.zkq.service.Three"));
	}

	@Test
	public void getCandidateTypesSubPackage() {
		CandidateComponentsIndex index = new CandidateComponentsIndex(
				Collections.singletonList(createSampleProperties()));
		Set<String> actual = index.getCandidateTypes("com.example.com.zkq.service.sub", "service");
		assertThat(actual, containsInAnyOrder("com.example.com.zkq.service.sub.Two"));
	}

	@Test
	public void getCandidateTypesSubPackageNoMatch() {
		CandidateComponentsIndex index = new CandidateComponentsIndex(
				Collections.singletonList(createSampleProperties()));
		Set<String> actual = index.getCandidateTypes("com.example.com.zkq.service.none", "service");
		assertThat(actual, hasSize(0));
	}

	@Test
	public void getCandidateTypesNoMatch() {
		CandidateComponentsIndex index = new CandidateComponentsIndex(
				Collections.singletonList(createSampleProperties()));
		Set<String> actual = index.getCandidateTypes("com.example.com.zkq.service", "entity");
		assertThat(actual, hasSize(0));
	}

	@Test
	public void mergeCandidateStereotypes() {
		CandidateComponentsIndex index = new CandidateComponentsIndex(Arrays.asList(
				createProperties("com.example.Foo", "service"),
				createProperties("com.example.Foo", "entity")));
		assertThat(index.getCandidateTypes("com.example", "service"),
				contains("com.example.Foo"));
		assertThat(index.getCandidateTypes("com.example", "entity"),
				contains("com.example.Foo"));
	}

	private static Properties createProperties(String key, String stereotypes) {
		Properties properties = new Properties();
		properties.put(key, String.join(",", stereotypes));
		return properties;
	}

	private static Properties createSampleProperties() {
		Properties properties = new Properties();
		properties.put("com.example.com.zkq.service.One", "service");
		properties.put("com.example.com.zkq.service.sub.Two", "service");
		properties.put("com.example.com.zkq.service.Three", "service");
		properties.put("com.example.domain.Four", "entity");
		return properties;
	}

}
