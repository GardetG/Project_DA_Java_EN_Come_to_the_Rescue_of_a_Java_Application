package com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

class SymptomCounterTest {

	@Test
	void Given_UnsortedSymptomList_When_CountingSymptoms_Then_ReturnListSortAlphabetically() {
		// Arrange
		SymptomCounter counterToTest = new SymptomCounter();
		List<String> listToSort = Arrays.asList("c", "a", "b");
		List<String> expectedList = Arrays.asList("a: 1", "b: 1", "c: 1");

		// Act
		List<String> sortedList = counterToTest.AnalyzeSymptoms(listToSort);

		// Assert
		assertEquals(sortedList, expectedList);
	}

	@Test
	void Given_RawList_When_CountingSymptoms_Then_ReturnCorrectlyCountedList() {
		// Arrange
		SymptomCounter counterToTest = new SymptomCounter();
		List<String> listToSort = Arrays.asList("a", "a", "b", "a", "c");
		List<String> expectedList = Arrays.asList("a: 3", "b: 1", "c: 1");

		// Act
		List<String> sortedList = counterToTest.AnalyzeSymptoms(listToSort);

		// Assert
		assertEquals(sortedList, expectedList);
	}

	@Test
	void Given_RawListWithMajusculeAndBlank_When_CountingSymptoms_Then_ReturnCorrectlyCountedList() {
		// Arrange
		SymptomCounter counterToTest = new SymptomCounter();
		List<String> listToSort = Arrays.asList("c", "a", "b", "", "A", " ", null);
		List<String> expectedList = Arrays.asList("a: 2", "b: 1", "c: 1");

		// Act
		List<String> sortedList = counterToTest.AnalyzeSymptoms(listToSort);

		// Assert
		assertEquals(sortedList, expectedList);
	}

	@Test
	void Given_UnsortedSymptomList_When_CountingSymptomsWithReverseComparator_Then_ReturnListSortReversly() {
		// Arrange
		SymptomCounter counterToTest = new SymptomCounter(Comparator.reverseOrder());
		List<String> listToSort = Arrays.asList("c", "a", "b");
		List<String> expectedList = Arrays.asList("c: 1", "b: 1", "a: 1");

		// Act
		List<String> sortedList = counterToTest.AnalyzeSymptoms(listToSort);

		// Assert
		assertEquals(sortedList, expectedList);
	}
}
